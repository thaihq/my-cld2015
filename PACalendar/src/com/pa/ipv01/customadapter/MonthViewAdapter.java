package com.pa.ipv01.customadapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import com.pa.ipv01.business.busCalendar;
import com.pa.ipv01.object.objMonth;
import com.pa.pacalendar.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MonthViewAdapter extends BaseAdapter implements OnClickListener{

	private final Context context;
	private final objMonth monthView;
	ArrayList<DayMonth> listDayMonth;
	static busCalendar busMonth=new busCalendar();
	int[] listColors=new int[]{R.color.lightgray,R.color.white,R.color.orrange};
	
	public MonthViewAdapter(Context context,objMonth monthview)
	{
		this.context=context;
		this.monthView=monthview;
		getDayMonth();	
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listDayMonth.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return listDayMonth.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View row = convertView;
		if (row == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.item_of_month, parent, false);
		}
		
		TextView tvDay=(TextView)row.findViewById(R.id.tv_day_gridview);
		tvDay.setText(String.valueOf(listDayMonth.get(position).day));
		tvDay.setTextColor(listColors[listDayMonth.get(position).colorDay]);
		
		ImageView imgHD=(ImageView) row.findViewById(R.id.img_ngayhd);
		if(listDayMonth.get(position).ngayHD==0)
		{
			imgHD.setImageResource(R.drawable.hoangdao);
		}
		else if(listDayMonth.get(position).ngayHD==1)
		{
			imgHD.setImageResource(R.drawable.hacdao);
		}
		
		return row;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

	private void getDayMonth()
	{
		
		int thuDayFirst=busMonth.getThuOfDay(1, monthView.getMonth(), monthView.getYear());
		int thuDayLast=busMonth.getThuOfDay(monthView.getDays(), monthView.getMonth(), monthView.getYear());
		
		listDayMonth=new ArrayList<DayMonth>();
			
		for(int i=thuDayFirst;i>0;i--)
		{
			Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+07:00"));
			calendar.set(monthView.getYear(), monthView.getMonth()-1, 1);
			calendar.add(Calendar.DATE, -i);
			int tempday=calendar.get(Calendar.DAY_OF_MONTH);
			int temmonth=calendar.get(Calendar.MONTH)+1;
			int temyear=calendar.get(Calendar.YEAR);
			int[] daylunar=busMonth.convertSolar2Lunar(tempday, temmonth, temyear, 7.0);
			int[] chiDay=busMonth.getCanChiLunarDay(tempday, temmonth, temyear);
			int hd=busMonth.hoangDao(daylunar[1], chiDay[1]);
			DayMonth tempDayMonth=new DayMonth(tempday, 0, hd);
			listDayMonth.add(tempDayMonth);
		}
		
		for(int i=1;i<=monthView.getDays();i++)
		{
			int[] daylunar=busMonth.convertSolar2Lunar(i, monthView.getMonth(), monthView.getYear(), 7.0);
			int[] chiDay=busMonth.getCanChiLunarDay(i, monthView.getMonth(), monthView.getYear());
			int hd=busMonth.hoangDao(daylunar[1], chiDay[1]);
			DayMonth tempDayMonth=new DayMonth(i, 1, hd);
			listDayMonth.add(tempDayMonth);
		}
				
		for(int i=1;i<=(6-thuDayLast);i++)
		{
			Calendar calendar = Calendar.getInstance(Locale.CHINESE);
			calendar.set(monthView.getYear(), monthView.getMonth()-1, monthView.getDays());
			calendar.add(Calendar.DAY_OF_MONTH, i);
			int tempday=calendar.get(Calendar.DAY_OF_MONTH);
			int temmonth=calendar.get(Calendar.MONTH)+1;
			int temyear=calendar.get(Calendar.YEAR);
			int[] daylunar=busMonth.convertSolar2Lunar(tempday, temmonth, temyear, 7.0);
			int[] chiDay=busMonth.getCanChiLunarDay(tempday, temmonth, temyear);
			int hd=busMonth.hoangDao(daylunar[1], chiDay[1]);
			DayMonth tempDayMonth=new DayMonth(tempday, 0, hd);
			listDayMonth.add(tempDayMonth);
		}
	}
}

class DayMonth{
	int day;
	int colorDay;
	int ngayHD;
	public DayMonth(int day, int color,int hd)
	{
		this.day=day;
		this.colorDay=color;
		this.ngayHD=hd;
	}
}
