package com.pa.ipv01.pacalendar;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.pa.ipv01.customadapter.HoroscopeGridAdapter;
import com.pa.ipv01.resource.Horoscoperes;
import com.pa.pacalendar.R;

public class Horoscope extends Activity {
	private ArrayList<Integer> title;
	private ArrayList<Integer> icon;
	private GridView gridView;
	private HoroscopeGridAdapter adapter;
	public static int isClicked;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.horoscope);
		
		prepareListData();
		adapter = new HoroscopeGridAdapter(this, title, icon);
		gridView = (GridView) findViewById(R.id.ac_tuvi_grid);
		gridView.setAdapter(adapter);

		gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				isClicked = title.get(position);

				// Intent intent = new Intent(Horoscope.this, TVDetail.class);
				// startActivity(intent);

			}
		});
	}
	
	public void prepareListData() {

		title = new ArrayList<Integer>();
		title.add(Horoscoperes.titlety);
		title.add(Horoscoperes.titlesuu);
		title.add(Horoscoperes.titledan);
		title.add(Horoscoperes.titlemao);
		title.add(Horoscoperes.titlethin);
		title.add(Horoscoperes.titleti);
		title.add(Horoscoperes.titlengo);
		title.add(Horoscoperes.titlemui);
		title.add(Horoscoperes.titlethan);
		title.add(Horoscoperes.titledau);
		title.add(Horoscoperes.titletuat);
		title.add(Horoscoperes.titlehoi);

		icon = new ArrayList<Integer>();
		icon.add(Horoscoperes.iconty);
		icon.add(Horoscoperes.iconsuu);
		icon.add(Horoscoperes.icondan);
		icon.add(Horoscoperes.iconmao);
		icon.add(Horoscoperes.iconthin);
		icon.add(Horoscoperes.iconti);
		icon.add(Horoscoperes.iconngo);
		icon.add(Horoscoperes.iconmui);
		icon.add(Horoscoperes.iconthan);
		icon.add(Horoscoperes.icondau);
		icon.add(Horoscoperes.icontuat);
		icon.add(Horoscoperes.iconhoi);
	}
}
