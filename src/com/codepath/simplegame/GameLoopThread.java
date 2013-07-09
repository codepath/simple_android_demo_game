package com.codepath.simplegame;


import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

public class GameLoopThread extends Thread {
	private static final String TAG = GameActivity.class.getSimpleName();

	// Store references to the game panel and holder
	private SurfaceHolder surfaceHolder;
	private AbstractGamePanel gamePanel;

	// flag to hold game state
	private boolean running;
	long tickCount;

	public GameLoopThread(SurfaceHolder surfaceHolder, AbstractGamePanel gamePanel) {
		super();
		this.surfaceHolder = surfaceHolder;
		this.gamePanel = gamePanel;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public boolean isRunning() {
		return this.running;
	}

	public long getTickCount() {
		return tickCount;
	}

	@Override
	public void run() {
		Canvas canvas;
		//tickCount = 0L;
		Log.d(TAG, "Starting game loop");
		while (running) {
			canvas = null;
			//tickCount++;
			// try locking the canvas for exclusive pixel editing on the surface
			try {
				canvas = this.surfaceHolder.lockCanvas();
				synchronized (surfaceHolder) {
					// update game state
					this.gamePanel.onTimer();
					// draws the canvas on the panel
					this.gamePanel.onDraw(canvas);
				}
			} finally {
				// in case of an exception the surface is not left in
				// an inconsistent state
				if (canvas != null) {
					surfaceHolder.unlockCanvasAndPost(canvas);
				}
			} // end finally
		}
	}
}
