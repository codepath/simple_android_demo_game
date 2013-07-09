package com.codepath.examples.simplepushergame;

import com.codepath.simplegame.Draggable;
import com.codepath.simplegame.actors.SimpleMovingActor;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class SquareActor extends SimpleMovingActor implements Draggable {
	private boolean touched; // if droid is touched/picked up
	private boolean alive;

	public SquareActor(int x, int y) {
		super(x, y, 65, 65);
		alive = true;
	}

	@Override
	public void stylePaint(Paint paint) {
		paint.setColor(Color.GREEN);
		paint.setStyle(Paint.Style.FILL);
		// p.setStyle(Paint.Style.STROKE);
		// p.setStrokeWidth(5);
	}

	public boolean isTouched() {
		return touched;
	}
	
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public boolean isAlive() {
		return this.alive;
	}

	public void setTouched(boolean touched) {
		this.touched = touched;
	}

	@Override
	public void draw(Canvas canvas) {
		if (isAlive()) {
			canvas.drawRect(getRect(), getPaint());
		}
	}

	public void handleActionDown(int eventX, int eventY) {
		if (eventX >= (getX() - getWidth()) && (eventX <= (getX() + getWidth()))) {
			if (eventY >= (getY() - getHeight() / 2) && (getY() <= (getY() + getHeight() / 2))) {
				setTouched(true);
			} else {
				setTouched(false);
			}
		} else {
			setTouched(false);
		}

	}
}
