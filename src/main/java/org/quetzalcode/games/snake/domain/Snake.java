package org.quetzalcode.games.snake.domain;

import java.util.ArrayList;
import java.util.List;

import org.quetzalcode.games.snake.constants.SnakeConstants;
import org.quetzalcode.games.snake.constants.SnakeDirections;
import org.quetzalcode.games.snake.exception.GameOverException;

public class Snake {
	private List<Shackle> shackles;

	public List<Shackle> getShackles() {
		return shackles;
	}

	public static Snake getInstance() {
		return SnakeHolder.snake;
	}

	private static class SnakeHolder {
		private static Snake snake = new Snake();
	}

	private Snake() {
		shackles = new ArrayList<Shackle>();
		Shackle shackle = new Shackle(SnakeConstants.INITIAL_X, SnakeConstants.INITIAL_Y);
		shackles.add(shackle);
		this.direction = SnakeDirections.RIGHT;
	}

	public void move() {
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

	public SnakeDirections getDirection() {
		return direction;
	}

	public boolean changeDirection(SnakeDirections direction) {
		if (this.direction.getContrayDirection().equals(direction)) {
			return false;
		} else {
			this.direction = direction;
			return true;
		}
	}

	private SnakeDirections direction;

	public void addShackle(Shackle lostShackle) {
		shackles.add(0, lostShackle);
	}

}
