package com.example.akshaybroadcastrecieverstudy;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	BroadcastReceiver br;

	IntentFilter inf;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		inf = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);

		br = new BroadcastReceiver() {
			@Override
			public void onReceive(Context arg0, Intent i) {

				boolean airplaneState = i.getBooleanExtra("state", false);

				Toast.makeText(getBaseContext(),
						"Airplane Mode " + airplaneState, Toast.LENGTH_LONG)
						.show();
			}
		};

	}

	@Override
	protected void onResume() {
		registerReceiver(br, inf);
		super.onResume();
	}

	@Override
	protected void onPause() {
		unregisterReceiver(br);
		super.onPause();
	}
}
