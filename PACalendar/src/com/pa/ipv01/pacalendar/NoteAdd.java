package com.pa.ipv01.pacalendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;

import com.pa.ipv01.customadapter.NoteListAdapter;
import com.pa.ipv01.object.objNote;
import com.pa.pacalendar.R;

/**
 * Created by Ipv01 on 1/19/2015.
 */
public class NoteAdd extends Activity {
	private ListView list;
	private NoteListAdapter adapter;
	private Button btn_add;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.noteadd);

		btn_add = (Button) findViewById(R.id.noteadd_btn_add);
		btn_add.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(NoteAdd.this, NoteDetail.class);
				startActivity(intent);
			}
		});

		objNote note[] = new objNote[] {
				new objNote("baothuc", "day di nhau", "6/2/2015", "12:30 pm"),
				new objNote(
						"hoang dao",
						"day di nhau, day di nhau, day di nhau, day di nhau, day di nhau, day di nhau, day",
						"7/2/2015", "12:30 pm"),

		};
		adapter = new NoteListAdapter(this, R.layout.item_list_noteadd, note);
		list = (ListView) findViewById(R.id.noteadd_list);
		list.setAdapter(adapter);
	}
}
