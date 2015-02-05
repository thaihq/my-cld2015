package com.pa.ipv01.pacalendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.pa.pacalendar.R;

public class NoteDetail extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.note_detail);
	}

}
