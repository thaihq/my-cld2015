package com.pa.ipv01.pacalendar;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.pa.ipv01.customadapter.MonthViewAdapter;
import com.pa.ipv01.object.objMonth;
import com.pa.pacalendar.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

/**
 * Created by Ipv01 on 1/19/2015.
 */
public class MonthCalendar extends Activity implements OnClickListener{

	GridView gridView;
	Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+07:00"));

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.month_gridview);
		
		Date date=new Date();
		calendar.setTime(date);
		
		int month = calendar.get(Calendar.MONTH) + 1;
		int year = calendar.get(Calendar.YEAR);
		
		objMonth monthview=new objMonth(month, year);
		
		setMonthView(monthview);
		
		gridView=(GridView) findViewById(R.id.calendar_girdview);
		gridView.setAdapter(new MonthViewAdapter(this, monthview));
		
		Button buttonPre=(Button)findViewById(R.id.btn_pre_gridview);
		Button buttonNext=(Button)findViewById(R.id.btn_next_gridview);
		
		
		buttonPre.setOnClickListener(this);
		buttonNext.setOnClickListener(this);
	}

	private void setMonthView(objMonth monthview)
	{
		String tempMonth="Tháng "+monthview.getMonth()+" Năm "+monthview.getYear();
		TextView tvMonth=(TextView) findViewById(R.id.tvmonth_gridview);
		
		tvMonth.setText(tempMonth);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==(R.id.btn_pre_gridview))
		{
			calendar.add(Calendar.MONTH, -1);
			int month = calendar.get(Calendar.MONTH) + 1;
			int year = calendar.get(Calendar.YEAR);
			objMonth monthview=new objMonth(month, year);
			
			setMonthView(monthview);
			gridView.setAdapter(new MonthViewAdapter(this, monthview));
		}
		else if(v.getId()==(R.id.btn_next_gridview))
		{
			calendar.add(Calendar.MONTH, 1);
			int month = calendar.get(Calendar.MONTH) + 1;
			int year = calendar.get(Calendar.YEAR);
			objMonth monthview=new objMonth(month, year);
			
			setMonthView(monthview);
			gridView.setAdapter(new MonthViewAdapter(this, monthview));
		}
	}
	
}
