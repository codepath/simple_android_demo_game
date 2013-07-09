package com.codepath.examples.simplepushergame;

import android.os.Bundle;

import com.codepath.simplegame.GameActivity;

public class MyGameActivity extends GameActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MyGamePanel panel = new MyGamePanel(this);
	 	setContentView(panel);
	}

}
