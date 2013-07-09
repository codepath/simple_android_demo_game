package com.codepath.examples.simplepushergame;

import android.util.Log;
import android.view.SurfaceHolder;

public class GameLoopThread extends Thread {
	private static final String TAG = GameActivity.class.getSimpleName();
	
	// Store references to the game panel and holder
	private SurfaceHolder surfaceHolder;
	private MainGamePanel gamePanel;

	// flag to hold game state
	private boolean running;

	public GameLoopThread(SurfaceHolder surfaceHolder, MainGamePanel gamePanel) {
		super();
		this.surfaceHolder = surfaceHolder;
		this.gamePanel = gamePanel;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	@Override
	public void run() {
		long tickCount = 0L;
		Log.d(TAG, "Starting game loop");
		while (running) {
			tickCount++;
			// update game state
			// render state to the screen
		}
	}
}
