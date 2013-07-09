package com.codepath.simplegame.actors;

import android.graphics.Point;
import android.graphics.Rect;

public abstract class SimpleMovingActor extends Actor {
	private Point pos;
	private int height;
	private int width;

	public SimpleMovingActor(int x, int y) {
		this.pos = new Point(x, y);
	}
	
	public SimpleMovingActor(int x, int y, int width, int height) { 
		this.pos = new Point(x, y);
		this.setDimensions(width, height);
	}
	
	public void moveUp(int steps) {
		this.pos.y -= steps;
	}
	
	public void moveDown(int steps) {
		this.pos.y += steps;
	}
	
	public void moveLeft(int steps) {
		this.pos.x -= steps;
	}
	
	public void moveRight(int steps) {
		this.pos.x += steps;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public void setDimensions(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public Rect getRect() {
		return new Rect(getX(), getY(), getX() + width, getY() + height);
	}
	
	public void setPos(int x, int y) {
		this.pos = new Point(x, y);
	}

	public int getX() {
		return this.pos.x;
	}

	public void setX(int x) {
		this.pos.x = x;
	}

	public int getY() {
		return this.pos.y;
	}

	public void setY(int y) {
		this.pos.y = y;
	}
	
	public boolean intersect(SimpleMovingActor actor) {
		return getRect().intersect(actor.getRect());
	}
}
