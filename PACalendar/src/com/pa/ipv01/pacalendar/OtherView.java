package com.pa.ipv01.pacalendar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.pa.ipv01.resource.OtherViewres;
import com.pa.pacalendar.R;

/**
 * Created by Ipv01 on 1/19/2015.
 */
public class OtherView extends Activity {

	private String title[] = { OtherViewres.meovat, OtherViewres.hoangdao,
			OtherViewres.tuvi };
	private ListView listView;
	private LayoutInflater layoutInflater;
	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.otherview);

		listView = (ListView) findViewById(R.id.ac_listview);
		listView.setAdapter(new VersionAdapter(this));

		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				System.out.println(arg2);
				switch (arg2) {
				case 0:
					// intent = new Intent(OtherView.this, uri);
					// startActivity(intent);
					break;
				case 1:
					intent = new Intent(OtherView.this, Zodiac.class);
					 startActivity(intent);
					break;
				case 2:
					intent = new Intent(OtherView.this, Horoscope.class);
					 startActivity(intent);
					break;

				default:
					break;
				}
			}
		});

	}

	private class VersionAdapter extends BaseAdapter {

		public VersionAdapter(OtherView activity) {
			layoutInflater = (LayoutInflater) activity
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public int getCount() {
			return title.length;
		}

		@Override
		public Object getItem(int position) {
			return position;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = layoutInflater.inflate(
						R.layout.item_list_otherview, null);
			}
			TextView tvTitle = (TextView) convertView
					.findViewById(R.id.listitem_tv);
			tvTitle.setText(title[position]);

			return convertView;
		}

	}
}
