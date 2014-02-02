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
			public void onValueChanged(int value) {
				Log.d(TAG, "Value: " + value);

			}
		});

		MultiStateToggleButton button2 = (MultiStateToggleButton) this.findViewById(R.id.mstb_multi_id);
		button2.setElements(R.array.dogs_array);
		button2.setOnValueChangedListener(new ToggleButton.OnValueChangedListener() {

			@Override
			public void onValueChanged(int value) {
				Log.d(TAG, "Value: " + value);

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
