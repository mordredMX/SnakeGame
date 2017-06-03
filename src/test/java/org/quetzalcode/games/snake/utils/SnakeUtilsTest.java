package org.quetzalcode.games.snake.utils;

import static org.junit.Assert.*;

import org.junit.Test;
import org.quetzalcode.games.snake.constants.SnakeDirections;
import org.quetzalcode.games.snake.shackle.Point;

public class SnakeUtilsTest {

	@Test
	public void testGetNextPointDown() {
		Point nextPoint=SnakeUtils.getNextPoint(new Point(1,1), SnakeDirections.DOWN);
		assertEquals(1, nextPoint.getX());
		assertEquals(2,nextPoint.getY());
	}

}
