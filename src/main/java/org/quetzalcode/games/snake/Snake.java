package org.quetzalcode.games.snake;

import java.util.ArrayList;
import java.util.List;

import org.quetzalcode.games.snake.constants.SnakeDirections;
import org.quetzalcode.games.snake.exception.GameOverException;
import org.quetzalcode.games.snake.shackle.Shackle;

public class Snake {
	private List<Shackle> shackles;

	private SnakeDirections direction;

	public Snake(int initialX,int initialY,SnakeDirections initialDirection) {
		shackles = new ArrayList<Shackle>();
		Shackle shackle = new Shackle(initialX, initialY);
		shackles.add(shackle);
		this.direction = initialDirection;
	}

	public void move() {
		synchronized (this) {
			Shackle firstShacke = shackles.get(0);
			int currentX = (int) firstShacke.getX();
			int currentY = (int) firstShacke.getY();

			switch (direction) {
			case RIGHT:
				currentX += 1;
				break;
			case LEFT:
				currentX -= 1;
				break;
			case UP:
				currentY -= 1;
				break;
			case DOWN:
				currentY += 1;
				break;
			}
			Shackle newShackle = new Shackle(currentX, currentY);
			if (shackles.contains(newShackle)) {
				throw new GameOverException();
			}
			shackles.add(0, newShackle);
			shackles.remove(shackles.size() - 1);
		}
	}

	public boolean changeDirection(SnakeDirections direction) {
		synchronized (this) {
			if (this.direction.getContrayDirection().equals(direction)) {
				return false;
			} else {
				this.direction = direction;
				return true;
			}
		}
	}

	public void addShackle(Shackle lostShackle) {
		synchronized (this) {
			shackles.add(0, lostShackle);
		}
	}

	public boolean doesShackleExistsInList(int x, int y) {
		synchronized (this) {
			for (Shackle shackle : shackles) {
				if (shackle.getX() == x && shackle.getY() == y) {
					return true;

				}
			}
			return false;
		}
	}

	public List<Shackle> getShackles() {
		return shackles;
	}

	public SnakeDirections getDirection() {
		return direction;
	}

	
}
