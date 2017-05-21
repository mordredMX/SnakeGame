package org.quetzalcode.games.snake.constants;

public enum SnakeDirections {
	LEFT, RIGHT, UP, DOWN;
	
	public SnakeDirections getContrayDirection(){
		switch(this){
		 case DOWN:
			 return UP;
		 case LEFT:
			 return RIGHT;
		 case UP:
			 return DOWN;
		 case RIGHT:
			 return LEFT;
		}
		return null;
	}
}
