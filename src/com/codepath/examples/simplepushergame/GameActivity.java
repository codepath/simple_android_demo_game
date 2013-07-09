package com.codepath.examples.simplepushergame;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

public class GameActivity extends Activity {
	private static final String TAG = GameActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// requesting to turn the title OFF
	 	requestWindowFeature(Window.FEATURE_NO_TITLE);
	 	// making it full screen
	 	getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	 		WindowManager.LayoutParams.FLAG_FULLSCREEN);
	 	// set our MainGamePanel as the View
	 	setContentView(new MainGamePanel(this));
	 	Log.d(TAG, "View added");
	}
	
	@Override
	 protected void onDestroy() {
	  Log.d(TAG, "Destroying...");
	  super.onDestroy();
	 }

	 @Override
	 protected void onStop() {
	  Log.d(TAG, "Stopping...");
	  super.onStop();
	 }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}

}
