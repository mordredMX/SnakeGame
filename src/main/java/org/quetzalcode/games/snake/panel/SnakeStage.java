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
import org.quetzalcode.games.snake.shackle.Point;
import org.quetzalcode.games.snake.shackle.Shackle;

public class SnakeStage extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5108611173878433112L;

	private SnakeGame game;

	private int shackleSize;

	public SnakeStage(final SnakeGame snakeGame) {
		super();
		this.game = snakeGame;
	}

	public void setup() {
		final Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		int screenSize = screenDimension.height < screenDimension.width ? screenDimension.height
				: screenDimension.width;
		shackleSize = screenSize / game.getConfig().getRate();

		final JFrame frame = new JFrame();
		frame.add(this);
		frame.addKeyListener(new MovementKeyAdapter(game.getSnake()));
		frame.setSize(screenSize, screenSize);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}

	public boolean isInsidePanel(final Point point) {
		if (point.getX() >= -1 && point.getX() <= game.getConfig().getRate()
				&& point.getY() <= game.getConfig().getRate() && point.getY() >= -1) {
			return true;
		}
		return false;
	}

	@Override
	public void paint(final Graphics g) {
		super.paint(g);
		final Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		drawSnake(g2d);
		drawLostShackle(g2d);

	}

	private void drawSnake(final Graphics2D g2d) {
		for (Shackle shackle : game.getSnake().getShackles()) {
			drawShackle(g2d, shackle);
		}
	}

	private void drawLostShackle(final Graphics2D g2d) {
		drawShackle(g2d, game.getLostShackle());
	}

	private void drawShackle(final Graphics2D g2d, final Shackle shackle) {
		g2d.fillRect((int) shackle.getX() * shackleSize, (int) shackle.getY() * shackleSize, shackleSize, shackleSize);
	}

}
