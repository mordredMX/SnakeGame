package org.quetzalcode.games.snake;

public class Main {


	public static void main(final String[] args) throws InterruptedException {
		final SnakeGame game=new SnakeGame();
		game.initialize();
		game.start();
	}
}
