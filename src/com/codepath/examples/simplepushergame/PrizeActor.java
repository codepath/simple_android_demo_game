package com.codepath.examples.simplepushergame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.codepath.simplegame.AbstractGamePanel;
import com.codepath.simplegame.Velocity;
import com.codepath.simplegame.actors.SimpleMovingActor;

public class PrizeActor extends SimpleMovingActor {
	
	public static final int STEP = 8;
	public static final int DRAWSIZE = 20;

	public PrizeActor(int x, int y) {
		super(x, y, DRAWSIZE, DRAWSIZE);
		getVelocity().stop().setXDirection(Velocity.DIRECTION_DOWN).setXSpeed(STEP);
	}
	
	@Override
	public void stylePaint(Paint paint) {
		paint.setColor(Color.RED);
		paint.setStyle(Paint.Style.FILL);
	}

	@Override
	public void draw(Canvas canvas) {
		canvas.drawRect(getRect(), getPaint());
	}
	
	public void respawn(AbstractGamePanel panel) { 
		setPos(randomCoordForPanel(panel.getWidth()), randomCoordForPanel(panel.getHeight()));
		int direction = 0+(int)(Math.random()*((1-0) + 1));
		if (direction == 0) { 
			getVelocity().stop().setXSpeed(STEP).setXDirection(Velocity.DIRECTION_DOWN);
		} else {
			getVelocity().stop().setYSpeed(STEP).setXDirection(Velocity.DIRECTION_RIGHT);
		}
	}
	
	protected int randomCoordForPanel(int max) {
		int multiplier = max / DRAWSIZE;
		int randomCoordinate = (int) (Math.random() * multiplier);
		return randomCoordinate * DRAWSIZE;
	}
	
	public void update(AbstractGamePanel panel) {
		if (getY() >= (panel.getHeight() - getHeight())) {
			getVelocity().toggleYDirection();
		} else if (getY() < 0) {
			getVelocity().toggleYDirection();
		} else if (getX() >= (panel.getWidth() - getWidth())) {
			getVelocity().toggleXDirection();
		} else if (getX() < 0) {
			getVelocity().toggleXDirection();
		}
		this.move();
	}

}
