package com.pa.ipv01.pacalendar;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.pa.ipv01.customadapter.ZodiacGridAdapter;
import com.pa.ipv01.resource.Zodiacres;
import com.pa.pacalendar.R;

public class Zodiac extends Activity {

	private GridView gridView;
	private ZodiacGridAdapter adapter;
	private ArrayList<String> title;
	private ArrayList<Integer> icon;

	public static String isClicked;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.zodiac_grid);

		prepareListData();
		adapter = new ZodiacGridAdapter(this, title, icon);
		gridView = (GridView) findViewById(R.id.accunghd_gridview);
		gridView.setAdapter(adapter);

		gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				isClicked = title.get(position);
				Intent intent = new Intent(Zodiac.this, ZodiacDetail.class);
				startActivity(intent);

			}
		});
	}

	public void prepareListData() {

		title = new ArrayList<String>();
		title.add(Zodiacres.bachduong);
		title.add(Zodiacres.kimnguu);
		title.add(Zodiacres.songtu);
		title.add(Zodiacres.cugiai);
		title.add(Zodiacres.sutu);
		title.add(Zodiacres.xunu);
		title.add(Zodiacres.thienbinh);
		title.add(Zodiacres.bocap);
		title.add(Zodiacres.nhanma);
		title.add(Zodiacres.maket);
		title.add(Zodiacres.baobinh);
		title.add(Zodiacres.songngu);

		icon = new ArrayList<Integer>();
		icon.add(Zodiacres.bd);
		icon.add(Zodiacres.kn);
		icon.add(Zodiacres.sgt);
		icon.add(Zodiacres.cg);
		icon.add(Zodiacres.sut);
		icon.add(Zodiacres.xn);
		icon.add(Zodiacres.tb);
		icon.add(Zodiacres.bc);
		icon.add(Zodiacres.nm);
		icon.add(Zodiacres.mk);
		icon.add(Zodiacres.bb);
		icon.add(Zodiacres.sn);
	}
}
