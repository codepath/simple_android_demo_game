package com.codepath.examples.simplepushergame;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.codepath.simplegame.AbstractGamePanel;

public class MyGamePanel extends AbstractGamePanel {

	SquareActor player;
	ArrayList<SquareActor> otherPlayers;
	PrizeActor prize;
	int score = 0;

	public MyGamePanel(Context context) {
		super(context);
	}

	// This method is called when the game first launches. Use this to
	// initialize variables and set starting values.
	public void onStart() {
		player = new SquareActor(50, 50);
		prize = new PrizeActor(200, 200);
	}

	// This method is called once a "tick" to redraw the canvas,
	// so you can do things like draw the game actors.
	// Images: canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),
	// R.drawable.droid_1), 10, 10, null);
	public void redrawCanvas(Canvas canvas) {
		prize.draw(canvas);
		player.draw(canvas);
		drawScore(canvas);
	}

	// This method is called once a second, and it is a good place to
	// implement the game logic.
	public void onTimer() {
		prize.update(this);
		if (prize.intersect(player)) {
			score += 100;
			prize.respawn(this);
		}
	}

	// This method is called whenever a keyboard button is pressed
	// within your game. The keyCode represents the key the actual key pushed.
	// You can check which keyCode using 'KeyEvent' constants.
	// i.e keyCode == KeyEvent.KEYCODE_N
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// ...
		return false;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Log.d("GameActivity", event.getX() + ", " + event.getY());
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			// delegating event handling to the player
			player.handleActionDown((int) event.getX(), (int) event.getY());
		}
		if (event.getAction() == MotionEvent.ACTION_MOVE) {
			// the gestures
			if (player.isTouched() && event.getX() < (getWidth() - player.getWidth())
					&& event.getY() < (getHeight() - player.getHeight())) {
				// the player was picked up and is being dragged
				player.setX((int) event.getX());
				player.setY((int) event.getY());
			}
		}
		if (event.getAction() == MotionEvent.ACTION_UP) {
			// touch was released
			if (player.isTouched()) {
				player.setTouched(false);
			}
		}
		return true;
	}
	
	private void drawScore(Canvas canvas) {
		getPaint().setColor(Color.BLACK);
		getPaint().setTextSize(20);
		canvas.drawText("Score: " + score, 20, 20, getPaint());
	}

}
