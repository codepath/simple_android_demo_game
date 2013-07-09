package com.codepath.simplegame.actors;

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class Actor {
	// Defines the default paint
	private Paint paint;
	
	public Actor() {
		paint = new Paint();
		stylePaint(paint);
	}
	
	public Paint getPaint() {
		return paint;
	}
	
	// Define the default paint style
	public abstract void stylePaint(Paint p);
	// Defines how the actor is drawn
	public abstract void draw(Canvas canvas);
}
