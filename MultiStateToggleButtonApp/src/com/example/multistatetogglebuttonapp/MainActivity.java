package com.example.multistatetogglebuttonapp;

import org.honorato.multistatetogglebutton.MultiStateToggleButton;
import org.honorato.multistatetogglebutton.ThreeStateToggleButton;
import org.honorato.multistatetogglebutton.ToggleButton;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	protected static final String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ThreeStateToggleButton button = (ThreeStateToggleButton) this.findViewById(R.id.mstb_main_id);
		button.setOnValueChangedListener(new ToggleButton.OnValueChangedListener() {

			@Override
			public void onValueChanged(int position) {
				Log.d(TAG, "Position: " + position);

			}
		});

		MultiStateToggleButton button2 = (MultiStateToggleButton) this.findViewById(R.id.mstb_multi_id);

		// Position one is selected by default
		button2.setElements(R.array.dogs_array, 1);
		
		// Multiple elements can be selected simultaneously
		button2.enableMultipleChoice(true);
		
		// Set callback
		button2.setOnValueChangedListener(new ToggleButton.OnValueChangedListener() {

			@Override
			public void onValueChanged(int position) {
				Log.d(TAG, "Position: " + position);

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
