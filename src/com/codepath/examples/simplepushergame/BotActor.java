package com.codepath.examples.simplepushergame;

import com.codepath.simplegame.Draggable;
import com.codepath.simplegame.actors.SpriteMovingActor;

import android.content.Context;

public class BotActor extends SpriteMovingActor implements Draggable {
	private boolean touched; // if droid is touched/picked up

	public BotActor(Context c, int x, int y) {
		super(c, R.drawable.ic_launcher, x, y);
	}
	
	public boolean isTouched() {
		return touched;
	}

	public void setTouched(boolean touched) {
		this.touched = touched;
	}

	public void handleActionDown(int eventX, int eventY) {
		if (eventX >= (getX() - getWidth() / 2) && (eventX <= (getX() + getWidth() / 2))) {
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
