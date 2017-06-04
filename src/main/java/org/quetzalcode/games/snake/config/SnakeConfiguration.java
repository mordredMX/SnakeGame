package org.quetzalcode.games.snake.config;

import org.quetzalcode.games.snake.constants.SnakeConstants;

public class SnakeConfiguration {
	public int getRate(){
		return SnakeConstants.RATE;
	}
	
	public int randomRetries(){
		return SnakeConstants.RANDOM_RETRIES;
	}
	
	public long getSleepTime(){
		return SnakeConstants.SLEEP_TIME;
	}
	
	public long getSleepDecrement(){
		return SnakeConstants.SLEEP_DECREMENT;
	}
	
	public int getInitialX(){
		return SnakeConstants.INITIAL_X;
	}
	
	public int getInitialY(){
		return SnakeConstants.INITIAL_Y;
	}
}
