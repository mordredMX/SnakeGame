package org.quetzalcode.games.snake.listener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import org.quetzalcode.games.snake.constants.SnakeDirections;
import org.quetzalcode.games.snake.domain.Snake;

public class MovementKeyAdapter extends KeyAdapter {
 
	private Snake snake;
	
	public MovementKeyAdapter(){
		this.snake=Snake.getInstance();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_UP:
			snake.changeDirection(SnakeDirections.UP);
			break;
		case KeyEvent.VK_DOWN:
			snake.changeDirection(SnakeDirections.DOWN);
			break;
		case KeyEvent.VK_LEFT:
			snake.changeDirection(SnakeDirections.LEFT);
			break;
		case KeyEvent.VK_RIGHT:
			snake.changeDirection(SnakeDirections.RIGHT);
			break;
		}
		
	}
}
