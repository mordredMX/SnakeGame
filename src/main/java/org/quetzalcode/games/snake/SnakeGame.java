package org.quetzalcode.games.snake;

import java.util.Random;

import org.quetzalcode.games.snake.config.SnakeConfiguration;
import org.quetzalcode.games.snake.constants.SnakeConstants;
import org.quetzalcode.games.snake.panel.SnakeStage;
import org.quetzalcode.games.snake.shackle.Shackle;

public class SnakeGame {
	private SnakeStage stage;
	private Snake snake;
	Shackle lostShackle;
	private SnakeConfiguration config;

	public SnakeGame() {

	}

	public void initialize() {
		this.snake = new Snake();
		generateNewLostShackle();
		this.config = new SnakeConfiguration();
		this.stage = new SnakeStage(this);
		this.stage.setup();
	}

	public SnakeConfiguration getConfig() {
		return config;
	}

	public void generateNewLostShackle() {
		synchronized (snake) {
			Random random = null;
			for (int i = 0; i < SnakeConstants.TRIES; i++) {
				random = new Random();
				int x = (random.nextInt(SnakeConstants.RATE)) + 1;
				int y = (random.nextInt(SnakeConstants.RATE)) + 1;
				if (!snake.doesShackleExistsInList(x, y)) {
					lostShackle = new Shackle(x, y);
					return;
				} else if (y != x && !snake.doesShackleExistsInList(y, x)) {
					lostShackle = new Shackle(y, x);
					return;
				}
			}
			throw new IllegalStateException();
		}
	}

	public Snake getSnake() {
		return snake;
	}

	public Shackle getLostShackle() {
		return lostShackle;
	}

	public boolean hasFoundLostShackle() {
		Shackle shackle = snake.getShackles().get(0);
		int nextX = shackle.getX();
		int nextY = shackle.getY();
		switch (snake.getDirection()) {
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
		return getLostShackle().getX() == nextX && getLostShackle().getY() == nextY;
	}

	public void start() throws InterruptedException {

		long initialSpeed = SnakeConstants.INITIAL_SPEED;
		while (true) {
			snake.move();
			stage.repaint();
			if (hasFoundLostShackle()) {
				snake.addShackle(lostShackle);
				generateNewLostShackle();
				initialSpeed -= 5;
			} else {

				Thread.sleep(initialSpeed);
			}

		}
	}
}
