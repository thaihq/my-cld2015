package com.pa.ipv01.pacalendar;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;

import com.pa.ipv01.business.SQLiteHelper;
import com.pa.ipv01.customadapter.NoteListAdapter;
import com.pa.ipv01.object.objNote;
import com.pa.pacalendar.R;

public class ViewNote extends Activity {
	private ListView list;
	private NoteListAdapter adapter;
	private Button btn_add;
	private ArrayList<objNote> notes;
	private SQLiteHelper sqLiteHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.viewnote);
		
		sqLiteHelper = new SQLiteHelper(this);

		btn_add = (Button) findViewById(R.id.noteadd_btn_add);
		btn_add.setOnClickListener(new View.OnClickListener() {
			

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ViewNote.this, NoteDetail.class);
				startActivity(intent);
			}
		});

		notes = new ArrayList<objNote>();
		adapter = new NoteListAdapter(this, R.layout.item_list_noteadd,
				sqLiteHelper.showall(notes));
		list = (ListView) findViewById(R.id.noteadd_list);
		list.setAdapter(adapter);
	}

}
