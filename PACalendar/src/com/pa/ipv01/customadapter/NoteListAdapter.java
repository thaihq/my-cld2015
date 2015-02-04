package com.pa.ipv01.customadapter;

import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.pa.pacalendar.R;

public class NoteListAdapter extends BaseAdapter {

	private ArrayList<String> title;
	private ArrayList<String> content;
	private ArrayList<String> date;
	private ArrayList<String> time;
	private ArrayList<Integer> id;

	Activity activity;

	public NoteListAdapter(Activity activity, ArrayList<String> title,
			ArrayList<String> content, ArrayList<String> date,
			ArrayList<String> time, ArrayList<Integer> id) {
		super();
		// TODO Auto-generated constructor stub
		this.title = title;
		this.time = time;
		this.date = date;
		this.content = content;
		this.id = id;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return id.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return id.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		LayoutInflater inflater = activity.getLayoutInflater();
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.item_list_noteadd, null);
			holder.title = (TextView) convertView
					.findViewById(R.id.itemlist_noteadd_title);
			holder.content = (TextView) convertView
					.findViewById(R.id.itemlist_noteadd_content);
			holder.date = (TextView) convertView
					.findViewById(R.id.itemlist_noteadd_date);
			holder.time = (TextView) convertView
					.findViewById(R.id.itemlist_noteadd_time);
			convertView.setTag(holder);
//			holder.del = (Button) convertView
//					.findViewById(R.id.itemlist_noteadd_del);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.title.setText(title.get(position));
		holder.content.setText(content.get(position));
		holder.date.setText(date.get(position));
		holder.time.setText(time.get(position));
//		holder.del.setOnClickListener(new View.OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				System.out.println("Delete");
//			}
//		});

		return convertView;
	}

	public static class ViewHolder {
		public TextView title;
		public TextView content;
		public TextView time;
		public TextView date;
		public Button del;
		public int id;
	}

}
