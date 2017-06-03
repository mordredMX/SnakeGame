package org.quetzalcode.games.snake;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.quetzalcode.games.snake.constants.SnakeDirections;
import org.quetzalcode.games.snake.panel.SnakeStage;
import org.quetzalcode.games.snake.shackle.Shackle;

public class SnakeGameTest {

	@InjectMocks
	private SnakeGame game;
	
	@Mock
	private Snake snake;
	
	@Mock
	private SnakeStage stage;
	
	@Mock
	private Shackle lostShackle=new Shackle(5, 4);
	
//	@Before
//	public void init(){
//		MockitoAnnotations.initMocks(this);
//	}
//	
//	@Test
//	public void test() {
//		List<Shackle>shackles=new ArrayList<Shackle>();
//		shackles.add(new Shackle(5, 5));
//		Mockito.when(snake.getDirection()).thenReturn(SnakeDirections.LEFT);
//		Mockito.when(snake.getShackles()).thenReturn(shackles);
//		//Mockito.when(lostShackle.equals(Mockito.any(Object.class))).thenReturn(true);
//		assertTrue(game.hasFoundLostShackle());
//	}

}
