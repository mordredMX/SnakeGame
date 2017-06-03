package org.quetzalcode.games.snake.utils;

import org.quetzalcode.games.snake.constants.SnakeDirections;
import org.quetzalcode.games.snake.shackle.Point;

public class SnakeUtils {
	private SnakeUtils(){
		
	}
	public static Point getNextPoint(final Point point ,final SnakeDirections direction){
		int nextX = point.getX();
		int nextY = point.getY();
		switch (direction) {
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
		return new Point(nextX,nextY);
	}
}
