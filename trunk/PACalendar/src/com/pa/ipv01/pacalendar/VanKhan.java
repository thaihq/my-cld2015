package com.pa.ipv01.pacalendar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;

import com.pa.ipv01.customadapter.ExpandableAdapter;
import com.pa.ipv01.resource.VanKhanres;
import com.pa.pacalendar.R;

public class VanKhan extends Activity {

	private ExpandableListView expandableListView;
	private ExpandableAdapter listAdapter;
	private List<String> listDataHeader;
	private HashMap<String, List<String>> listDataChild;

	public static String isClicked;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vankhan);
		expandableListView = (ExpandableListView) findViewById(R.id.exp_listview);

		prepareListData();

		listAdapter = new ExpandableAdapter(this, listDataHeader, listDataChild);

		expandableListView.setAdapter(listAdapter);

		expandableListView.setOnGroupClickListener(new OnGroupClickListener() {

			@Override
			public boolean onGroupClick(ExpandableListView parent, View v,
					int groupPosition, long id) {
				// Toast.makeText(getApplicationContext(),
				// "Group Clicked " + listDataHeader.get(groupPosition),
				// Toast.LENGTH_SHORT).show();
				return false;
			}
		});

		expandableListView
				.setOnGroupExpandListener(new OnGroupExpandListener() {

					@Override
					public void onGroupExpand(int groupPosition) {
						// Toast.makeText(
						// getApplicationContext(),
						// listDataHeader.get(groupPosition) + " Expanded",
						// Toast.LENGTH_SHORT).show();
					}
				});

		expandableListView
				.setOnGroupCollapseListener(new OnGroupCollapseListener() {

					@Override
					public void onGroupCollapse(int groupPosition) {
						// Toast.makeText(
						// getApplicationContext(),
						// listDataHeader.get(groupPosition)
						// + " Collapsed", Toast.LENGTH_SHORT)
						// .show();
					}
				});

		expandableListView.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				// Toast.makeText(
				// getApplicationContext(),
				// listDataHeader.get(groupPosition)
				// + " : "
				// + listDataChild.get(
				// listDataHeader.get(groupPosition)).get(
				// childPosition), Toast.LENGTH_SHORT)
				// .show();
				isClicked = listDataChild
						.get(listDataHeader.get(groupPosition)).get(
								childPosition);
				Intent intent = new Intent(VanKhan.this, VanKhanDetail.class);
				startActivity(intent);
				return true;
			}
		});

	}

	private void prepareListData() {
		listDataHeader = new ArrayList<String>();
		listDataChild = new HashMap<String, List<String>>();

		// Adding child data
		listDataHeader.add(VanKhanres.letet);
		listDataHeader.add(VanKhanres.hangthang);
		listDataHeader.add(VanKhanres.giatrach);
		listDataHeader.add(VanKhanres.hieuhy);
		listDataHeader.add(VanKhanres.cacngaytettrongnam);
		listDataHeader.add(VanKhanres.dinhchua);
		listDataHeader.add(VanKhanres.giatien);
		listDataHeader.add(VanKhanres.giaihan);

		// Adding child data
		List<String> letet = new ArrayList<String>();
		letet.add(VanKhanres.totien);
		letet.add(VanKhanres.thanlinh);
		letet.add(VanKhanres.tatnien);
		letet.add(VanKhanres.gtngoai);
		letet.add(VanKhanres.gttrong);
		letet.add(VanKhanres.ta);
		letet.add(VanKhanres.ongtao);
		letet.add(VanKhanres.lemochap);
		letet.add(VanKhanres.thammo);

		List<String> hangthang = new ArrayList<String>();
		hangthang.add(VanKhanres.tienchu);
		hangthang.add(VanKhanres.thanhsu);
		hangthang.add(VanKhanres.thocong);
		hangthang.add(VanKhanres.thantai);
		hangthang.add(VanKhanres.m1nram);
		hangthang.add(VanKhanres.ttdangle);

		List<String> giatrach = new ArrayList<String>();
		giatrach.add(VanKhanres.chuyennha);
		giatrach.add(VanKhanres.tangia);
		giatrach.add(VanKhanres.nhaptrach);
		giatrach.add(VanKhanres.cuahang);
		giatrach.add(VanKhanres.diamach);
		giatrach.add(VanKhanres.dongtho);

		List<String> hieuhy = new ArrayList<String>();
		hieuhy.add(VanKhanres.letang);
		hieuhy.add(VanKhanres.thuongtho);
		hieuhy.add(VanKhanres.cuoiga);
		hieuhy.add(VanKhanres.giohet);
		hieuhy.add(VanKhanres.giodau);
		hieuhy.add(VanKhanres.cungmu);

		List<String> cacngaytettrongnam = new ArrayList<String>();
		cacngaytettrongnam.add(VanKhanres.chungsinh);
		cacngaytettrongnam.add(VanKhanres.thanhminh);
		cacngaytettrongnam.add(VanKhanres.trungthu);
		cacngaytettrongnam.add(VanKhanres.trungnguyen);
		cacngaytettrongnam.add(VanKhanres.trunguyen1);
		cacngaytettrongnam.add(VanKhanres.hanthuc);
		cacngaytettrongnam.add(VanKhanres.hanguyen);
		cacngaytettrongnam.add(VanKhanres.doanngo);
		cacngaytettrongnam.add(VanKhanres.nguyentieu);

		List<String> dinhchua = new ArrayList<String>();
		dinhchua.add(VanKhanres.thanhhoang);
		dinhchua.add(VanKhanres.mieu);
		dinhchua.add(VanKhanres.chuakho);
		dinhchua.add(VanKhanres.chua);
		dinhchua.add(VanKhanres.phat);
		dinhchua.add(VanKhanres.thanhtran);
		dinhchua.add(VanKhanres.thanhhien);
		dinhchua.add(VanKhanres.quanam);
		dinhchua.add(VanKhanres.uminh);
		dinhchua.add(VanKhanres.congdong);

		List<String> giatien = new ArrayList<String>();
		giatien.add(VanKhanres.thuong);
		giatien.add(VanKhanres.cung);
		giatien.add(VanKhanres.cautu);

		List<String> giaihan = new ArrayList<String>();
		giaihan.add(VanKhanres.benhtat);
		giaihan.add(VanKhanres.saohan);
		giaihan.add(VanKhanres.ledang);

		listDataChild.put(listDataHeader.get(0), letet);
		listDataChild.put(listDataHeader.get(1), hangthang);
		listDataChild.put(listDataHeader.get(2), giatrach);
		listDataChild.put(listDataHeader.get(3), hieuhy);
		listDataChild.put(listDataHeader.get(4), cacngaytettrongnam);
		listDataChild.put(listDataHeader.get(5), dinhchua);
		listDataChild.put(listDataHeader.get(6), giatien);
		listDataChild.put(listDataHeader.get(7), giaihan);

	}

}
