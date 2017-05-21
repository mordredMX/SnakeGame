package org.quetzalcode.games.snake;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import org.quetzalcode.games.snake.listener.MovementKeyAdapter;
import org.quetzalcode.games.snake.panel.SnakeStage;
import org.quetzalcode.games.snake.constants.SnakeConstants;

public class Main {


	public static void main(String[] args) throws InterruptedException {
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		int screenSize = screenDimension.height < screenDimension.width ? screenDimension.height
				: screenDimension.width;
		int shackleSize = screenSize / SnakeConstants.RATE;
		JFrame frame = new JFrame();
		SnakeStage snakeStage = new SnakeStage(shackleSize);
		frame.add(snakeStage);
		frame.addKeyListener(new MovementKeyAdapter());
		frame.setSize(screenSize, screenSize);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		snakeStage.start();
	}
}
