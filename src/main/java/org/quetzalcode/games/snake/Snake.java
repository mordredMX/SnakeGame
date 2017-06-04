package org.quetzalcode.games.snake;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

import org.quetzalcode.games.snake.constants.SnakeDirections;
import org.quetzalcode.games.snake.exception.GameOverException;
import org.quetzalcode.games.snake.shackle.Point;
import org.quetzalcode.games.snake.shackle.Shackle;

public class Snake {
	private static final int SNAKE_CAPACITY = 500;

	private BlockingDeque<Shackle> shackles;

	private SnakeDirections direction;

	public Snake(final int initialX,final int initialY,final SnakeDirections initialDirection) {
		shackles = new LinkedBlockingDeque<Shackle>(SNAKE_CAPACITY);
		Shackle shackle = new Shackle(initialX, initialY);
		shackles.add(shackle);
		this.direction = initialDirection;
	}

	public void move() {
		synchronized (this) {
			Shackle firstShacke = shackles.getFirst();
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
			shackles.addFirst(newShackle);
			shackles.removeLast();
		}
	}

	public boolean changeDirection(final SnakeDirections direction) {
		synchronized (this) {
			if (this.direction.getContrayDirection().equals(direction)) {
				return false;
			} else {
				this.direction = direction;
				return true;
			}
		}
	}

	public void addShackle(final Shackle lostShackle) {
		synchronized (this) {
			shackles.addFirst(lostShackle);
		}
	}

	public boolean doesShackleExistsInList(final Point point) {
		synchronized (this) {
			return shackles.contains(point);
		}
	}

	public Shackle[] getShackles(){
		return shackles.toArray(new Shackle[0]);
	}
	
	public Shackle getFirstShackle(){
		return shackles.getFirst();
	}

	public SnakeDirections getDirection() {
		return direction;
	}

	
}
