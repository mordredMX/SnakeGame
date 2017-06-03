package org.quetzalcode.games.snake.config;

import org.quetzalcode.games.snake.constants.SnakeConstants;

public class SnakeConfiguration {
	public int getRate(){
		return SnakeConstants.RATE;
	}
	
	public int randomRetries(){
		return SnakeConstants.TRIES;
	}
	
	public long getInitialSpeed(){
		return SnakeConstants.INITIAL_SPEED;
	}
	
	public int getInitialX(){
		return SnakeConstants.INITIAL_X;
	}
	
	public int getInitialY(){
		return SnakeConstants.INITIAL_Y;
	}
}
