package com.codepath.examples.simplepushergame;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MainGamePanel extends SurfaceView implements SurfaceHolder.Callback {

	private static final String TAG = GameActivity.class.getSimpleName();
	private GameLoopThread thread;

	public MainGamePanel(Context context) {
		super(context);
		// adding the callback (this) to the surface holder to intercept events
		getHolder().addCallback(this);
		// create the game loop thread
		thread = new GameLoopThread(getHolder(), this);
		// make the GamePanel focusable so it can handle events
		setFocusable(true);
	}

	// Handle touch input
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Log.d(TAG, "Coords: x=" + event.getX() + ",y=" + event.getY());
		return super.onTouchEvent(event);
	}

	// Draw the game board
	@Override
	protected void onDraw(Canvas canvas) {
		// ...
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		// ...
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		thread.setRunning(true);
		thread.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;
		while (retry) {
			try {
				thread.join();
				retry = false;
			} catch (InterruptedException e) {
				// try again shutting down the thread
			}
		}
	}
}