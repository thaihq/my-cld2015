package com.pa.ipv01.pacalendar;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;

import com.pa.pacalendar.R;

/**
 * Created by Ipv01 on 1/19/2015.
 */
public class DayChoice extends Activity implements OnDateSetListener,
		OnClickListener {
	Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+07:00"));
	int day, moth, year;

	DatePicker dpRes;
	Button btnDongY;
	Button btnHuy;

	static final int DATE_DIALOG_ID = 999;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.day_choice);

		day = cal.get(Calendar.DAY_OF_MONTH);
		year = cal.get(Calendar.YEAR);
		moth = cal.get(Calendar.MONTH);

		dpRes = (DatePicker) findViewById(R.id.date_pk);
		dpRes.init(year, moth, day, null);

		btnDongY = (Button) findViewById(R.id.btn_dongy);
		btnHuy = (Button) findViewById(R.id.btn_huy);

		btnDongY.setOnClickListener(this);
		btnHuy.setOnClickListener(this);
		// showDialog(DATE_DIALOG_ID);
	}

	@Override
	@Deprecated
	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub
		// return super.onCreateDialog(id);
		switch (id) {
		case DATE_DIALOG_ID:
			return new DatePickerDialog(this, this, year, moth, day);
		}
		return null;
	}

	@Override
	public void onDateSet(DatePicker dp, int selectedYear, int selMonth,
			int selDay) {
		// TODO Auto-generated method stub
		year = selectedYear;
		moth = selMonth;
		day = selDay;
		dp.init(year, moth, day, null);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == (R.id.btn_dongy)) {
			btnDongY.setBackgroundResource(R.drawable.btn_dongy_down);
			day = dpRes.getDayOfMonth();
			moth = dpRes.getMonth();
			year = dpRes.getYear();
			cal.set(year, moth, day);
			DayNow.date = cal.getTime();
			MainActivity.tabHost.setCurrentTab(0);
		} else if (v.getId() == (R.id.btn_huy))
			btnHuy.setBackgroundResource(R.drawable.btn_huy_down);
		MainActivity.tabHost.setCurrentTab(0);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Date date = new Date();
		cal.setTime(date);
	}
}
