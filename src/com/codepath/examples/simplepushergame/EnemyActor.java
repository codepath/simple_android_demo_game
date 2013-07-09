package com.codepath.examples.simplepushergame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.codepath.simplegame.AbstractGamePanel;
import com.codepath.simplegame.actors.SimpleMovingActor;

public class EnemyActor extends SimpleMovingActor {
	
	public final int STEP = 5;
	private int direction;

	public EnemyActor(int x, int y, int width, int height) {
		super(x, y, width, height);
		direction = 1; 
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

	public void move(AbstractGamePanel panel) {
		if (getY() >= (panel.getHeight() - getHeight())) {
			direction = 0;
		} else if (getY() < 0) {
			direction = 1;
		}
		
		if (direction == 1) {
			this.moveDown(STEP);	
		} else {
			this.moveUp(STEP);
		}
	}

}
