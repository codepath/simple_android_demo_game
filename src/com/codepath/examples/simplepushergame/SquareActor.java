package com.codepath.examples.simplepushergame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.codepath.simplegame.Draggable;
import com.codepath.simplegame.actors.SimpleMovingActor;

public class SquareActor extends SimpleMovingActor implements Draggable {
	private boolean touched; // if actor is picked up

	public SquareActor(int x, int y) {
		super(x, y, 50, 50);
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

	public void setTouched(boolean touched) {
		this.touched = touched;
	}

	@Override
	public void draw(Canvas canvas) {
	  canvas.drawRect(getRect(), getPaint());
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
