package com.pa.ipv01.pacalendar;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.pa.ipv01.business.busCalendar;
import com.pa.ipv01.object.objCalendar;
import com.pa.ipv01.object.objDanhNgon;
import com.pa.ipv01.object.objNgayLe;
import com.pa.pacalendar.R;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;


/**
 * Created by Ipv01 on 1/19/2015.
 */

public class DayNow extends Activity implements OnClickListener{
	
	objCalendar datelunar =new objCalendar();
	busCalendar buscalendar =new busCalendar();
	static Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+07:00"));
	static Date date;
	
	Animation animationleft;
	private ViewFlipper viewFlipper;
	private float lastX;
	final Context context = this;
	LayoutInflater inflater;
	static final float wideScreen=100.0f;
	RelativeLayout rDialogView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.day_now_viewflipper);
		
		viewFlipper = (ViewFlipper) findViewById(R.id.view_flipper);
		viewFlipper.addView(getDayNow());
		
		Button buttonHomNay=(Button)findViewById(R.id.btn_homnay);
		Button buttonDetail=(Button)findViewById(R.id.btn_detail);	
		Button buttonPre=(Button)findViewById(R.id.btn_pre);
		Button buttonNext=(Button)findViewById(R.id.btn_next);
		
		date = new Date();
		getDay(date);
		
		viewFlipper.setOnTouchListener(this.listener);
		buttonNext.setOnClickListener(this);
		buttonPre.setOnClickListener(this);
		buttonHomNay.setOnClickListener(this);		
		buttonDetail.setOnClickListener(this);
	}

	private void getDay(Date date) {
		try {
//			calendar.setTime(date);
			objNgayLe ngayLe=new objNgayLe();
			objDanhNgon danhNgon=new objDanhNgon();
			
			buscalendar=new busCalendar();
			datelunar=new objCalendar();
			datelunar=buscalendar.getConvertSolar2Lunar(date);
			int isHoangDao=buscalendar.hoangDao(datelunar.getMonth()
					, buscalendar.getCanChiLunarDay(datelunar.getDaySolar()
													, datelunar.getMonthSolar()
													, datelunar.getYearSolar())[1]);
			String isNgayLe=ngayLe.getNgayLe(datelunar);

			TextView tvMonthYearDuong = (TextView) findViewById(R.id.tv_monthyearduong);
			TextView tvThuDay = (TextView) findViewById(R.id.tv_thu);
			TextView tvCanChiYear = (TextView) findViewById(R.id.tv_canchiyear);
//			TextView tvCanChiDay = (TextView) findViewById(R.id.tvCanChiDay);
			TextView tvCanChiMonth = (TextView) findViewById(R.id.tv_canchimonth);
//			TextView tvHour = (TextView) findViewById(R.id.tvGio);
			TextView tvDayAM = (TextView) findViewById(R.id.tv_dayam);
			TextView tvMothAm = (TextView) findViewById(R.id.tv_montham);
//			TextView tvYearAm = (TextView) findViewById(R.id.tvYearAM);
			TextView tvHoangDao= (TextView) findViewById(R.id.tv_hoangdao);
			TextView tvDanhNgonOrLe=(TextView) findViewById(R.id.tv_danhngon);
			TextView tvLeap=(TextView) findViewById(R.id.tv_monthnhuan);

			tvMonthYearDuong.setText("Tháng "+datelunar.getMonthSolar()+" Năm "
											+datelunar.getYearSolar());
			tvThuDay.setText(datelunar.getThuOfWeek());
			getIcDate(datelunar.getDaySolar());
			getIcCanChiDay(datelunar);
//			tvHour.setText(datelunar.getHour()+":"+datelunar.getMin()+"Giờ");
			tvDayAM.setText(String.valueOf(datelunar.getDay()));
//			tvCanChiDay.setText(datelunar.getCanChiDay());
			tvMothAm.setText(String.valueOf(datelunar.getMonth()));
			tvCanChiMonth.setText("Tháng "+datelunar.getCanChiMonth());
//			tvYearAm.setText(String.valueOf(datelunar.getYear()));
			tvCanChiYear.setText("Năm "+datelunar.getCanChiYear());
			
			if(isHoangDao==0)
			{			
				tvHoangDao.setText("Ngày hoàng đạo");
				tvHoangDao.setTextColor(this.getResources().getColor(R.color.yellow));
			}
			else if(isHoangDao==1)
			{
				tvHoangDao.setText("Ngày hắc đạo");
				tvHoangDao.setTextColor(this.getResources().getColor(R.color.red));
			}
			else 
			{
				tvHoangDao.setText("Ngày bình thường");
				tvHoangDao.setTextColor(this.getResources().getColor(R.color.white));
			}
			
			if(isNgayLe==null||isNgayLe=="")
			{
				tvDanhNgonOrLe.setText(danhNgon.randDanhNgon());
				tvDanhNgonOrLe.setTextColor(this.getResources().getColor(R.color.white));
			}
			else
			{
				tvDanhNgonOrLe.setText(isNgayLe);
				if(ngayLe.red==true)
					tvDanhNgonOrLe.setTextColor(this.getResources().getColor(R.color.red));
				else
					tvDanhNgonOrLe.setTextColor(this.getResources().getColor(R.color.white));
			}
			
			if(datelunar.getLunarLeap()==1)
			{
				tvLeap.setText("Nhuận Tháng "+datelunar.getMonth());
				tvLeap.setVisibility(View.VISIBLE);
			}
			else 
			{
				tvLeap.setVisibility(View.INVISIBLE);
			}
			
		} catch (NullPointerException e) {
			Log.e("loi->", e.toString());
		}
	}

	private void getDayDetail(Date date)
	{
//		calendar.setTime(date);

		buscalendar=new busCalendar();
		datelunar=new objCalendar();
		datelunar=buscalendar.getConvertSolar2Lunar(date);
		
		String DaySolar ="+ Ngày: "+(datelunar.getDaySolar())+ " - "
				+ (datelunar.getMonthSolar()) + " - "
				+ datelunar.getYearSolar();
		
		final Dialog dialog = new Dialog(context);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.dialog_day_detail);
				
		TextView textDayDuong = (TextView) dialog.findViewById(R.id.tvDayDuongDt);
		TextView textThu=(TextView)dialog.findViewById(R.id.tvThuDt);
		TextView textDayAm=(TextView)dialog.findViewById(R.id.tvDayAmDt);
		TextView textYearCanChi=(TextView)dialog.findViewById(R.id.tvNamCanChiDt);
		TextView textMonthCanChi=(TextView)dialog.findViewById(R.id.tvThangCanChiDt);
		TextView textDayCanChi=(TextView)dialog.findViewById(R.id.tvDayCanChiDt);
		
		textDayDuong.setText(DaySolar);
		textThu.setText("+ Tháng: "+datelunar.getThuOfWeek());
		textDayAm.setText("+ Ngày: "+datelunar.getDay()+ " - "+datelunar.getMonth()+" - "+datelunar.getYear());
		textYearCanChi.setText("+ Năm "+datelunar.getCanChiYear());
		textMonthCanChi.setText("+ Tháng "+datelunar.getCanChiMonth());
		textDayCanChi.setText("+ Ngày "+datelunar.getCanChiDay());				
		
		Button dialogButton = (Button) dialog.findViewById(R.id.btn_dia_close);
		dialogButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
		});
		
		dialog.show();
	}
	
	private Date getDayWithTouch(Date date, int day) {
		calendar.setTime(date);
		calendar.add(Calendar.DATE, day);
		return calendar.getTime();
	}
	
	private Date getMonthWithTouch(Date date, int month) {
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, month);
		return calendar.getTime();
	}

	private void getIcDate(int day)
	{
		ImageView iconSo1=(ImageView)findViewById(R.id.icon_so1);
		ImageView iconSo2=(ImageView)findViewById(R.id.icon_so2);
		
		int[] so=new int[]{R.drawable.so0_bt,R.drawable.so1_bt,R.drawable.so2_bt
				,R.drawable.so3_bt,R.drawable.so4_bt,R.drawable.so5_bt
				,R.drawable.so6_bt,R.drawable.so7_bt,R.drawable.so8_bt,
				R.drawable.so9_bt};
		int chuc=(int)(day/10);
		int donvi=day%10;
		
		iconSo1.setImageResource(so[chuc]);
		iconSo2.setImageResource(so[donvi]);
	}
	
	private void getIcCanChiDay(objCalendar objDate)
	{
//		calendar.setTime(date);
		
//		int day = calendar.get(Calendar.DAY_OF_MONTH);
//		int month = calendar.get(Calendar.MONTH) + 1;
//		int year = calendar.get(Calendar.YEAR);
				
		ImageView iconChi=(ImageView)findViewById(R.id.icon_convat);
		
		int[] convat=new int[]{R.drawable.iconty,R.drawable.iconsuu,R.drawable.icondan,
				R.drawable.iconmao,R.drawable.iconthin,R.drawable.icontyj,R.drawable.iconngo,
				R.drawable.iconmui,R.drawable.iconthan,R.drawable.icondau,R.drawable.icontuat,R.drawable.iconhoi};
		
		iconChi.setImageResource(convat[buscalendar.getCanChiLunarDay(objDate.getDaySolar()
								, objDate.getMonthSolar(), objDate.getYearSolar())[1]]);
	}
	
	View.OnTouchListener listener = new View.OnTouchListener()
	  {
	    public boolean onTouch(View view, MotionEvent event)
	    {
	      switch (event.getAction())
	      {
	      case 0:
	    	  DayNow.this.lastX = event.getX();
	    	  break;
	      case 1:
	        float currentX = event.getX();
	        if ((DayNow.this.lastX < currentX) && (currentX - DayNow.this.lastX > wideScreen))
	        	{
				
	        		viewFlipper.setInAnimation(DayNow.this, R.anim.in_from_left);
	        		viewFlipper.setOutAnimation(DayNow.this, R.anim.out_to_right);
							
	        		date=getDayWithTouch(date, -1);
	        		getDay(date);
	        		viewFlipper.showPrevious();
	        	}
	        if ((DayNow.this.lastX > currentX) && (DayNow.this.lastX - currentX > wideScreen))
	        	{
				
	        		viewFlipper.setInAnimation(DayNow.this, R.anim.in_from_right);
	        		viewFlipper.setOutAnimation(DayNow.this, R.anim.out_to_left);
							
	        		date=getDayWithTouch(date, 1);
	        		getDay(date);
	        		viewFlipper.showNext();
	        	}
	        break;
	      }
	      return true;
	    }
	  };
	
	private View getDayNow() {
		inflater = getLayoutInflater();
		LinearLayout layout = (LinearLayout) inflater.inflate(
			R.layout.day_now, null);
		return layout;
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_homnay:
			date=new Date();
			getDay(date);
			break;
		case R.id.btn_detail:
			getDayDetail(date);
			break;
		case R.id.btn_pre:
			viewFlipper.setInAnimation(this,R.anim.in_from_down);
			viewFlipper.setOutAnimation(this,R.anim.out_to_up);
			date=getMonthWithTouch(date, -1);
			getDay(date);
			viewFlipper.showPrevious();
			break;
		case R.id.btn_next:
			viewFlipper.setInAnimation(this,R.anim.in_from_up);
			viewFlipper.setOutAnimation(this,R.anim.out_to_down);
			date=getMonthWithTouch(date, 1);
			getDay(date);
			viewFlipper.showNext();
			break;
		default:
			break;
		}	
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		getDay(date);
	}
	
}
