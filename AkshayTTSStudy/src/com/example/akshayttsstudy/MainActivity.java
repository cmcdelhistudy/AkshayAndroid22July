package com.example.akshayttsstudy;

import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText ed;

	TextToSpeech tts;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ed = (EditText) findViewById(R.id.editText1);

		tts = new TextToSpeech(getBaseContext(), new OnInitListener() {
			@Override
			public void onInit(int status) {

				if (tts == null) {
					Toast.makeText(getBaseContext(),
							"You device doesnot have TTS feature ",
							Toast.LENGTH_LONG).show();
				} else {
					tts.setLanguage(Locale.getDefault());
					tts.setPitch(1.4f);
					tts.setSpeechRate(1.2f);
				}

			}
		});

	}

	public void speakOut(View v) {
		String str = ed.getText().toString();
		tts.speak(str, TextToSpeech.QUEUE_FLUSH, null);
	}

}
