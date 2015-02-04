package com.pa.ipv01.customadapter;

import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pa.pacalendar.R;

public class ZodiacGridAdapter extends BaseAdapter {
	private ArrayList<String> title;
	private ArrayList<Integer> icon;
	private Activity activity;

	public ZodiacGridAdapter(Activity activity, ArrayList<String> title,
			ArrayList<Integer> icon) {
		super();
		// TODO Auto-generated constructor stub
		this.activity = activity;
		this.title = title;
		this.icon = icon;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return icon.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return icon.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder view;
		LayoutInflater inflater = activity.getLayoutInflater();
		if (convertView == null) {
			view = new ViewHolder();
			convertView = inflater.inflate(R.layout.item_grid_zodiac, null);
			view.textView = (TextView) convertView
					.findViewById(R.id.griditem_cunghd_tvcunghd);
			view.imageView = (ImageView) convertView
					.findViewById(R.id.griditem_cunghd_imgicon);
			convertView.setTag(view);
		} else {
			view = (ViewHolder) convertView.getTag();
		}
		view.textView.setText(title.get(position));
		view.imageView.setImageResource(icon.get(position));

		return convertView;
	}

	public static class ViewHolder {
		public ImageView imageView;
		public TextView textView;
	}

}
