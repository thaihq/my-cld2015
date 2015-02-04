package com.pa.ipv01.pacalendar;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.pa.ipv01.customadapter.NoteListAdapter;
import com.pa.pacalendar.R;

/**
 * Created by Ipv01 on 1/19/2015.
 */
public class NoteAdd extends Activity {

	ListView list;
	NoteListAdapter adapter;
	ArrayList<String> title;
	ArrayList<String> content;
	ArrayList<String> date;
	ArrayList<String> time;
	ArrayList<Integer> del;
	ArrayList<Integer> id;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.noteadd);
		prepareListData();
//		adapter = new NoteListAdapter(this, title, content, date, time, id);
		list = (ListView) findViewById(R.id.noteadd_list);
		list.setAdapter(adapter);
		list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				System.out.println("clicked :" + position);
			}
		});
	}

	public void prepareListData() {

		id = new ArrayList<Integer>();
		id.add(1);
		id.add(2);
		id.add(3);
		id.add(4);

		title = new ArrayList<String>();
		title.add("nha giao vn");
		title.add("quoc te phu nu");
		title.add("Valentine");
		content = new ArrayList<String>();
		content.add("nha giao vn");
		content.add("quoc te phu nu");
		content.add("Valentine");
		date = new ArrayList<String>();
		date.add("nha giao vn");
		date.add("quoc te phu nu");
		date.add("Valentine");
		time = new ArrayList<String>();
		time.add("nha giao vn");
		time.add("quoc te phu nu");
		time.add("Valentine");

	}

}
