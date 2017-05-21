package org.quetzalcode.games.snake.manager;

import java.util.List;
import java.util.Random;

import org.quetzalcode.games.snake.constants.SnakeConstants;
import org.quetzalcode.games.snake.constants.SnakeDirections;
import org.quetzalcode.games.snake.domain.Shackle;
import org.quetzalcode.games.snake.domain.Snake;

public class ShackleManager {

	private ShackleManager() {
		super();
	}

	public static ShackleManager getInstance() {
		return ShackleManagerHolder.shackleManager;
	}

	private static class ShackleManagerHolder {
		private static ShackleManager shackleManager = new ShackleManager();
	}

	public Shackle generateNewShackle(Snake snake) {
		Random random = null;
		for (int i = 0; i < SnakeConstants.TRIES; i++) {
			random = new Random();
			int x = (random.nextInt(SnakeConstants.RATE)) + 1;
			int y = (random.nextInt(SnakeConstants.RATE)) + 1;
			if (!doesShackleExistsInList(x, y, snake.getShackles())) {
				return new Shackle(x, y);
			} else if (y != x && !doesShackleExistsInList(y, x, snake.getShackles())) {
				return new Shackle(y, x);
			}
		}
		throw new IllegalStateException();
	}

	public boolean doesShackleExistsInList(int x, int y, List<Shackle> shackles) {
		for (Shackle shackle : shackles) {
			if (shackle.getX() == x && shackle.getY() == y) {
				return true;

			}
		}
		return false;
	}

	public boolean hasFoundLostShackle(Shackle lostShackle, Shackle shackle, SnakeDirections direction) {
		int nextX = shackle.getX();
		int nextY = shackle.getY();
		switch (direction) {
		case RIGHT:
			nextX += 1;
			break;
		case LEFT:
			nextX -= 1;
			break;
		case UP:
			nextY -= 1;
			break;
		case DOWN:
			nextY += 1;
			break;
		}
		return lostShackle.getX() == nextX && lostShackle.getY() == nextY;
	}

}
