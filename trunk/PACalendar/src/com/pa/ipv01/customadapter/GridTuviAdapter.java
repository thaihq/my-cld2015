package com.pa.ipv01.customadapter;

import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.pa.pacalendar.R;

public class GridTuviAdapter extends BaseAdapter {
	private ArrayList<Integer> title;
	private ArrayList<Integer> icon;
	private Activity activity;

	public GridTuviAdapter(Activity activity, ArrayList<Integer> title,
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
			convertView = inflater.inflate(R.layout.item_grid_horoscope, null);
			view.imageViewtitle = (ImageView) convertView
					.findViewById(R.id.griditem_tuvi_imgtext);
			view.imageViewicon = (ImageView) convertView
					.findViewById(R.id.griditem_tuvi_imgicon);
			convertView.setTag(view);
		} else {
			view = (ViewHolder) convertView.getTag();
		}
		view.imageViewtitle.setImageResource(title.get(position));
		view.imageViewicon.setImageResource(icon.get(position));

		return convertView;
	}

	public static class ViewHolder {
		public ImageView imageViewicon, imageViewtitle;
	}

}
