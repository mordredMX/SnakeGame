package org.quetzalcode.games.snake;

import java.util.Random;

import org.quetzalcode.games.snake.config.SnakeConfiguration;
import org.quetzalcode.games.snake.constants.SnakeDirections;
import org.quetzalcode.games.snake.panel.SnakeStage;
import org.quetzalcode.games.snake.shackle.Point;
import org.quetzalcode.games.snake.shackle.Shackle;
import org.quetzalcode.games.snake.utils.SnakeUtils;

public class SnakeGame {
	private SnakeStage stage;
	private Snake snake;
	private Shackle lostShackle;
	private SnakeConfiguration config;

	public SnakeGame() {

	}

	public void initialize() {
		this.config = new SnakeConfiguration();
		this.snake = new Snake(config.getInitialX(),config.getInitialY(),SnakeDirections.RIGHT);
		generateNewLostShackle();

		this.stage = new SnakeStage(this);
		this.stage.setup();
	}


	public void generateNewLostShackle() {
		synchronized (snake) {
			Random random = null;
			for (int i = 0; i < config.randomRetries(); i++) {
				random = new Random();
				final int x = (random.nextInt(config.getRate())) + 1;
				final int y = (random.nextInt(config.getRate())) + 1;
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

	public SnakeConfiguration getConfig() {
		return config;
	}
	
	public Snake getSnake() {
		return snake;
	}

	public Shackle getLostShackle() {
		return lostShackle;
	}

	public boolean hasFoundLostShackle() {
		final Shackle shackle = snake.getShackles().get(0);
		final Point nextPoint=SnakeUtils.getNextPoint(shackle, snake.getDirection());
		return lostShackle.equals(nextPoint);
	}
	

	
	
	public boolean hasCrashWithBorder(){
		
		return false;
	}

	public void start() throws InterruptedException {
		long initialSpeed = config.getInitialSpeed();
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
