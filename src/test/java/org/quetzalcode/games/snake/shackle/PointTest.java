package org.quetzalcode.games.snake.shackle;

import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {

	@Test
	public void testEquals() {
		Point point1=new Point(1,2);
		Point point2 =new Point(1,2);
		assertTrue(point1.equals(point2));
	}

}
