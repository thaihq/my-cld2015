package com.pa.ipv01.pacalendar;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.pa.ipv01.business.SQLiteHelper;
import com.pa.ipv01.business.typetime;
import com.pa.ipv01.object.DatePicker;
import com.pa.ipv01.object.DatePicker.DateWatcher;
import com.pa.ipv01.object.TimePicker;
import com.pa.ipv01.object.TimePicker.TimeWatcher;
import com.pa.ipv01.object.mydate;
import com.pa.ipv01.object.mytime;
import com.pa.pacalendar.R;

public class NoteDetail extends Activity implements OnClickListener,
		DateWatcher, TimeWatcher {
	Calendar calendar;

	mydate mydate;
	mytime mytime;
	SQLiteHelper sqLiteHelper;

	EditText ed_title, ed_content;
	Button btn_save, btn_cancel;

	String title, content, date, time;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.note_detail);

		sqLiteHelper = new SQLiteHelper(this);

		ed_title = (EditText) findViewById(R.id.ed_ghichu_title);
		ed_content = (EditText) findViewById(R.id.ed_ghichu_content);
		ed_title.setFocusable(true);

		btn_save = (Button) findViewById(R.id.btn_ghichu_save);
		btn_cancel = (Button) findViewById(R.id.btn_ghichu_cancel);

		calendar = Calendar.getInstance();
		int m = (calendar.get(Calendar.MONTH) + 1);
		int d = calendar.get(Calendar.DAY_OF_MONTH);
		int y = calendar.get(Calendar.YEAR);
		mydate = new mydate(d, m, y);

		DatePicker picker = (DatePicker) findViewById(R.id.lay_datepicker);
		picker.setDateChangedListener(this);

		try {
			picker.setStartYear(1900);
			picker.setEndYear(2100);
		} catch (Exception e) {
			Log.e("", e.toString());
		}
		TimePicker t = (TimePicker) findViewById(R.id.lay_timepicker);
		t.setTimeChangedListener(this);
		t.setCurrentTimeFormate(TimePicker.HOUR_12);
		t.setAMPMVisible(true);

		btn_cancel.setOnClickListener(this);
		btn_save.setOnClickListener(this);

	}

	@Override
	public void onTimeChanged(int h, int m, int am_pm) {
		// TODO Auto-generated method stub
		mytime = new mytime(h, m, am_pm);
	}

	@Override
	public void onDateChanged(Calendar c) {
		// TODO Auto-generated method stub
		int m = (c.get(Calendar.MONTH) + 1);
		int d = c.get(Calendar.DAY_OF_MONTH);
		int y = c.get(Calendar.YEAR);
		mydate = new mydate(d, m, y);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_ghichu_save:
			title = ed_title.getText().toString();
			content = ed_content.getText().toString();
			date = mydate.getD() + "/" + mydate.getM() + "/" + mydate.getY();
			time = new typetime().Totime(mytime);

			sqLiteHelper.insert(title, content, date, time);
			// update
			finish();

			break;
		case R.id.btn_ghichu_cancel:
			ed_title.setText("");
			ed_content.setText("");
			ed_title.setFocusable(true);

			break;

		default:
			break;
		}
	}
}
