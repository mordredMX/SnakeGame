package org.quetzalcode.games.snake.panel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import org.quetzalcode.games.snake.constants.SnakeConstants;
import org.quetzalcode.games.snake.domain.Shackle;
import org.quetzalcode.games.snake.domain.Snake;
import org.quetzalcode.games.snake.manager.ShackleManager;

public class SnakeStage extends JPanel {

	private Shackle lostShackle;
	private Snake snake;
	private ShackleManager shackleManager;
	private int shackleSize;

	public SnakeStage( int shackleSize) {
		super();
		shackleManager = ShackleManager.getInstance();
		this.snake = Snake.getInstance();
		this.shackleSize=shackleSize;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -5108611173878433112L;

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		drawSnake(g2d);
		drawShackle(g2d, lostShackle);

	}

	private void drawSnake(Graphics2D g2d) {
		for (Shackle shackle : snake.getShackles()) {
			drawShackle(g2d, shackle);
		}
	}
	
	private void drawShackle(Graphics2D g2d,Shackle shackle){
		g2d.fillRect((int) shackle.getX()*shackleSize, (int) shackle.getY()*shackleSize, shackleSize, shackleSize);
	}

	public void start() throws InterruptedException {
		lostShackle = shackleManager.generateNewShackle(snake);
		long initialSpeed=SnakeConstants.INITIAL_SPEED;
		while (true) {
			snake.move();
			this.repaint();
			if (shackleManager.hasFoundLostShackle(lostShackle, snake.getShackles().get(0), snake.getDirection())) {
				snake.addShackle(lostShackle);
				lostShackle = shackleManager.generateNewShackle(snake);
				initialSpeed-=5;
			} else
			{
				
				Thread.sleep(initialSpeed);
			}

		}
	}
}
