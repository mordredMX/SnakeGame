package org.quetzalcode.games.snake.panel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.quetzalcode.games.snake.SnakeGame;
import org.quetzalcode.games.snake.listener.MovementKeyAdapter;
import org.quetzalcode.games.snake.shackle.Shackle;

public class SnakeStage extends JPanel {

	private SnakeGame game;

	private int shackleSize;

	public SnakeStage(SnakeGame snakeGame) {
		super();
		this.game = snakeGame;
	}

	public void setup() {
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		int screenSize = screenDimension.height < screenDimension.width ? screenDimension.height
				: screenDimension.width;
		shackleSize = screenSize / game.getConfig().getRate();

		JFrame frame = new JFrame();
		frame.add(this);
		frame.addKeyListener(new MovementKeyAdapter(game.getSnake()));
		frame.setSize(screenSize, screenSize);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
		drawLostShackle(g2d);

	}

	private void drawSnake(Graphics2D g2d) {
		for (Shackle shackle : game.getSnake().getShackles()) {
			drawShackle(g2d, shackle);
		}
	}

	private void drawLostShackle(Graphics2D g2d) {
		drawShackle(g2d, game.getLostShackle());
	}

	private void drawShackle(Graphics2D g2d, Shackle shackle) {
		g2d.fillRect((int) shackle.getX() * shackleSize, (int) shackle.getY() * shackleSize, shackleSize, shackleSize);
	}

}
