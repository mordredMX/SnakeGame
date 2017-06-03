package org.quetzalcode.games.snake.shackle;

public class Point {
	private int x;
	private int y;
	public Point(int x, int y){
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public boolean equals(Object other){
		if(!(other instanceof Point)){
			return false;
		}
		return (this.getX()==((Point)other).getX() && this.getY()==((Point)other).getY());
	}

	@Override
	public String toString(){
		return "x:"+this.getX()+" ; y"+this.getY();
	}
}
