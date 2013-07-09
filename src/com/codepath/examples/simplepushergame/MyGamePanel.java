package com.codepath.examples.simplepushergame;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.codepath.simplegame.AbstractGamePanel;
import com.codepath.simplegame.Draggable;
import com.codepath.simplegame.actors.Actor;

public class MyGamePanel extends AbstractGamePanel {

	SquareActor player;
	BotActor bot;
	EnemyActor enemy;
	ArrayList<Draggable> actors;

	public MyGamePanel(Context context) {
		super(context);
	}

	// This method is called when the game first launches. Use this to
	// initialize variables and set starting values.
	public void onStart() {
		player = new SquareActor(10, 10);
		bot = new BotActor(getContext(), 100, 100);
		actors = new ArrayList<Draggable>();
		actors.add(player);
		actors.add(bot);
		enemy = new EnemyActor(getWidth() / 2, getHeight() / 2, 65, 65);
	}

	// This method is called once a "tick" to redraw the canvas,
	// so you can do things like draw the game actors.
	// Images: canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),
	// R.drawable.droid_1), 10, 10, null);
	public void redrawCanvas(Canvas canvas) {
		enemy.draw(canvas);
		for (Draggable actor : actors) {
			((Actor) actor).draw(canvas);
		}
		if (!player.isAlive()) {
			getPaint().setColor(Color.BLACK);
			getPaint().setTextSize(30);
			canvas.drawText("Game Over!", 200, getHeight() / 2, getPaint());
		}
	}

	// This method is called once a second, and it is a good place to
	// implement the game logic.
	public void onTimer() {
		enemy.move(this);
		if (enemy.intersect(player)) {
			player.setAlive(false);
		}
	}

	// This method is called whenever a keyboard button is pressed
	// within your game. The keyCode represents the key the actual key pushed.
	// You can check which keyCode using 'KeyEvent' constants.
	// i.e keyCode == KeyEvent.KEYCODE_N
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_N) {
			player.setAlive(true);
		}
		return false;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		for (Draggable actor : actors) {
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				// delegating event handling to the player
				actor.handleActionDown((int) event.getX(), (int) event.getY());
			}
			if (event.getAction() == MotionEvent.ACTION_MOVE) {
				// the gestures
				if (actor.isTouched() && event.getX() < (getWidth() - actor.getWidth())
						&& event.getY() < (getHeight() - actor.getHeight())) {
					// the player was picked up and is being dragged
					actor.setX((int) event.getX());
					actor.setY((int) event.getY());
				}
			}
			if (event.getAction() == MotionEvent.ACTION_UP) {
				// touch was released
				if (actor.isTouched()) {
					actor.setTouched(false);
				}
			}
		}
		return true;
	}

}
