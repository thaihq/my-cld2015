package com.pa.ipv01.business;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.pa.ipv01.object.objCalendar;
import com.pa.ipv01.object.objMonth;


public class busCalendar {
	
	public static String[] CAN=new String[]{"Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ", "Canh", "Tân", "Nhâm", "Quý"};
	public static String[] CHI=new String[]{"Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ", "Ngọ", "Mùi", "Thân", "Dậu", "Tuất", "Hợi"};

	public objCalendar getConvertSolar2Lunar(Date date)
	{
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+07:00"));
		calendar.setTime(date);
		
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH) + 1;
		int year = calendar.get(Calendar.YEAR);
		int hour=calendar.get(Calendar.HOUR_OF_DAY);
		int min=calendar.get(Calendar.MINUTE);
		double timezone=7.0;
		
		int[] objdatelunar=convertSolar2Lunar(day, month, year, timezone);
		
		String canchiyear=CAN[getCanChiLunarYear(objdatelunar[2])[0]]+" "+CHI[getCanChiLunarYear(objdatelunar[2])[1]];
		String canchimonth=CAN[getCanChiMonth(objdatelunar[1], objdatelunar[2])[0]]+" "+CHI[getCanChiMonth(objdatelunar[1], objdatelunar[2])[1]];
		String canchiday=CAN[getCanChiLunarDay(day, month, year)[0]]+" "+CHI[getCanChiLunarDay(day, month, year)[1]];		
		String thuofday=getThu(day, month, year);
				
		objCalendar datelunar=new objCalendar(objdatelunar[0], objdatelunar[1], objdatelunar[2], hour, canchiyear, canchimonth, canchiday,thuofday,min
				,day,month,year);
		
		return datelunar;
		
	}
	
	public objMonth getMonthView(int month, int year)
	{
		objMonth objMonthView=new objMonth(month, year);
		return objMonthView;
	}
	
	public String isNgayLe(objCalendar objDate)
	{
		return null;
	}
	/**cac phuong thuc tinh toan lich am
	 * 
	 */
	public static int jdFromDate(int dd,int  mm,int yy)
	{
		int a, y, m, jd;
		a = (int)((14 - mm) / 12);
		y = yy+4800-a;
		m = mm+12*a-3;
		jd = dd + (int)((153*m+2)/5) + 365*y + (int)(y/4) - (int)(y/100) + (int)(y/400) - 32045;
		if (jd < 2299161) {
			jd = dd + (int)((153*m+2)/5) + 365*y + (int)(y/4) - 32083;
		}
		return jd;
	}

	public static int[] jdToDate(int jd)
	{
		int a, b, c, d, e, m, day, month, year;
		if (jd > 2299160) { // After 5/10/1582, Gregorian calendar
			a = jd + 32044;
			b = (int)((4*a+3)/146097);
			c = a - (int)((b*146097)/4);
		} else {
			b = 0;
			c = jd + 32082;
		}
		d = (int)((4*c+3)/1461);
		e = c - (int)((1461*d)/4);
		m = (int)((5*e+2)/153);
		day = e - (int)((153*m+2)/5) + 1;
		month = m + 3 - 12*(int)(m/10);
		year = b*100 + d - 4800 + (int)(m/10);
		return new int[]{day, month, year};
	}

	public static int getNewMoonDay(int k,Double timeZone)
	{
		double T, T2, T3, dr, Jd1, M, Mpr, F, C1, deltat, JdNew;
		T = k/1236.85; // Time in Julian centuries from 1900 January 0.5
		T2 = T * T;
		T3 = T2 * T;
		dr = Math.PI/180;
		Jd1 = 2415020.75933 + 29.53058868*k + 0.0001178*T2 - 0.000000155*T3;
		Jd1 = Jd1 + 0.00033*Math.sin((166.56 + 132.87*T - 0.009173*T2)*dr); // Mean new moon
		M = 359.2242 + 29.10535608*k - 0.0000333*T2 - 0.00000347*T3; // Sun's mean anomaly
		Mpr = 306.0253 + 385.81691806*k + 0.0107306*T2 + 0.00001236*T3; // Moon's mean anomaly
		F = 21.2964 + 390.67050646*k - 0.0016528*T2 - 0.00000239*T3; // Moon's argument of latitude
		C1=(0.1734 - 0.000393*T)*Math.sin(M*dr) + 0.0021*Math.sin(2*dr*M);
		C1 = C1 - 0.4068*Math.sin(Mpr*dr) + 0.0161*Math.sin(dr*2*Mpr);
		C1 = C1 - 0.0004*Math.sin(dr*3*Mpr);
		C1 = C1 + 0.0104*Math.sin(dr*2*F) - 0.0051*Math.sin(dr*(M+Mpr));
		C1 = C1 - 0.0074*Math.sin(dr*(M-Mpr)) + 0.0004*Math.sin(dr*(2*F+M));
		C1 = C1 - 0.0004*Math.sin(dr*(2*F-M)) - 0.0006*Math.sin(dr*(2*F+Mpr));
		C1 = C1 + 0.0010*Math.sin(dr*(2*F-Mpr)) + 0.0005*Math.sin(dr*(2*Mpr+M));
		if (T < -11) {
			deltat= 0.001 + 0.000839*T + 0.0002261*T2 - 0.00000845*T3 - 0.000000081*T*T3;
		} else {
			deltat= -0.000278 + 0.000265*T + 0.000262*T2;
		};
		JdNew = Jd1 + C1 - deltat;
		return (int)(JdNew + 0.5 + timeZone/24);
	}

	public static int getSunLongitude(int jdn,Double timeZone)
	{
		double T, T2, dr, M, L0, DL, L;
		T = (jdn - 2451545.5 - timeZone/24) / 36525; // Time in Julian centuries from 2000-01-01 12:00:00 GMT
		T2 = T*T;
		dr = Math.PI/180; // degree to radian
		M = 357.52910 + 35999.05030*T - 0.0001559*T2 - 0.00000048*T*T2; // mean anomaly, degree
		L0 = 280.46645 + 36000.76983*T + 0.0003032*T2; // mean longitude, degree
		DL = (1.914600 - 0.004817*T - 0.000014*T2)*Math.sin(dr*M);
		DL = DL + (0.019993 - 0.000101*T)*Math.sin(dr*2*M) + 0.000290*Math.sin(dr*3*M);
		L = L0 + DL; // true longitude, degree
		L = L*dr;
		L = L - Math.PI*2*((int)(L/(Math.PI*2))); // Normalize to (0, 2*PI)
		return (int)(L / Math.PI * 6);
	}

	public static int getLunarMonth11(int yy,Double timeZone)
	{
		int k, off, nm, sunLong;
		off = jdFromDate(31, 12, yy) - 2415021;
		k = (int)(off / 29.530588853);
		nm = getNewMoonDay(k, timeZone);
		sunLong = getSunLongitude(nm, timeZone); // sun longitude at local midnight
		if (sunLong >= 9) {
			nm = getNewMoonDay(k-1, timeZone);
		}
		return nm;
	}

	public static int getLeapMonthOffset(int a11,Double timeZone)
	{
		int k, last, arc, i;
		k = (int)((a11 - 2415021.076998695) / 29.530588853 + 0.5);
		last = 0;
		i = 1; // We start with the month following lunar month 11
		arc = getSunLongitude(getNewMoonDay(k+i, timeZone), timeZone);
		do {
			last = arc;
			i++;
			arc = getSunLongitude(getNewMoonDay(k+i, timeZone), timeZone);
		} while (arc != last && i < 14);
		return i-1;
	}

	public int[] convertSolar2Lunar(int dd,int mm,int yy,Double timeZone)
	{
		int k, dayNumber, monthStart, a11, b11, lunarDay, lunarMonth, lunarYear, lunarLeap;
		dayNumber = jdFromDate(dd, mm, yy);
		k = (int)((dayNumber - 2415021.076998695) / 29.530588853);
		monthStart = getNewMoonDay(k+1, timeZone);
		if (monthStart > dayNumber) {
			monthStart = getNewMoonDay(k, timeZone);
		}
		a11 = getLunarMonth11(yy, timeZone);
		b11 = a11;
		if (a11 >= monthStart) {
			lunarYear = yy;
			a11 = getLunarMonth11(yy-1, timeZone);
		} else {
			lunarYear = yy+1;
			b11 = getLunarMonth11(yy+1, timeZone);
		}
		lunarDay = dayNumber-monthStart+1;
		int diff = (int)((monthStart - a11)/29);
		lunarLeap = 0;
		lunarMonth = diff+11;
		int leapMonthDiff;
		if (b11 - a11 > 365) {
			leapMonthDiff = getLeapMonthOffset(a11, timeZone);
			if (diff >= leapMonthDiff) {
				lunarMonth = diff + 10;
				if (diff == leapMonthDiff) {
					lunarLeap = 1;
				}
			}
		}
		if (lunarMonth > 12) {
			lunarMonth = lunarMonth - 12;
		}
		if (lunarMonth >= 11 && diff < 4) {
			lunarYear -= 1;
		}
		return new int[]{lunarDay,lunarMonth,lunarYear,lunarLeap};
	}

	public int[] convertLunar2Solar(int lunarDay,int lunarMonth,int lunarYear,int lunarLeap,Double timeZone)
	{
		int k, a11, b11, off, leapOff, leapMonth, monthStart;
		if (lunarMonth < 11) {
			a11 = getLunarMonth11(lunarYear-1, timeZone);
			b11 = getLunarMonth11(lunarYear, timeZone);
		} else {
			a11 = getLunarMonth11(lunarYear, timeZone);
			b11 = getLunarMonth11(lunarYear+1, timeZone);
		}
		off = lunarMonth - 11;
		if (off < 0) {
			off += 12;
		}
		if (b11 - a11 > 365) {
			leapOff = getLeapMonthOffset(a11, timeZone);
			leapMonth = leapOff - 2;
			if (leapMonth < 0) {
				leapMonth += 12;
			}
			if (lunarLeap != 0 && lunarMonth != leapMonth) {
				return new int[]{0, 0, 0};
			} else if (lunarLeap != 0 || off >= leapOff) {
				off += 1;
			}
		}
		k = (int)(0.5 + (a11 - 2415021.076998695) / 29.530588853);
		monthStart = getNewMoonDay(k+off, timeZone);
		return jdToDate(monthStart+lunarDay-1);
	}
	
	public int[] getCanChiLunarYear(int yy)
	{
		return new int[]{(yy+6)%10,(yy+8)%12};
	}
	
	public int[] getCanChiLunarDay(int dd,int mm,int yy)
	{
		int jd=jdFromDate(dd, mm, yy);
		return new int[]{(jd+9)%10,(jd+1)%12};
	}
	
	public int[] getCanChiMonth(int m,int y)
	{
		int chi=0;
		for(int i=0;i<12;i++)
		{
		int mm;
			if(i<2)
			{
				mm=i+11;
			}
			else
			{
				mm=i-1;
			}
			if(mm==m)
			{
				chi=i;
			}
		}
		
		return new int[]{(y*12+m+3)%10,chi};
	}
	
	public String getThu(int dd,int mm,int yy)
	{
		String thu;
		
		int jd=jdFromDate(dd, mm, yy);
		
		if(((jd%7)+2)==8)
		{
			thu="Chủ nhật";
		}
		else
		{
			thu="Thứ "+((jd%7)+2);
		}
		return thu;
	}
	
	public int getThuOfDay(int day,int month,int year)
	{
		int jd=jdFromDate(day, month, year);
		int thu;
		
		if((jd%7)==6)
			thu=0;
		else
			thu=(jd%7)+1;
		
		return thu;
	}
	
	public int hoangDao(int monthLunar, int chiDay)
	{
		int hd=2; //Ngay binh thuong
		switch (monthLunar) {
		case 12:
		case 7:
			if(chiDay==0
			||chiDay==1
			||chiDay==5
			||chiDay==7)
				hd=0;//hoang dao
			else if(chiDay==3
					||chiDay==6
					||chiDay==9
					||chiDay==11)
				hd=1;//hac dao
			break;
		case 2:
		case 8:
			if(chiDay==2
			||chiDay==3
			||chiDay==7
			||chiDay==9)
				hd=0;//hoang dao
			else if(chiDay==1
					||chiDay==5
					||chiDay==8
					||chiDay==11)
				hd=1;//hac dao
			break;
		case 3:
		case 9:
			if(chiDay==4
			||chiDay==5
			||chiDay==9
			||chiDay==11)
				hd=0;//hoang dao
			else if(chiDay==1
					||chiDay==7
					||chiDay==10
					||chiDay==8)
				hd=1;//hac dao
			break;
		case 4:
		case 10:
			if(chiDay==1
			||chiDay==6
			||chiDay==7
			||chiDay==9)
				hd=0;//hoang dao
			else if(chiDay==0
					||chiDay==3
					||chiDay==5
					||chiDay==9)
				hd=1;//hac dao
			break;
		case 5:
		case 1:
			if(chiDay==1
			||chiDay==3
			||chiDay==8
			||chiDay==9)
				hd=0;//hoang dao
			else if(chiDay==2
					||chiDay==5
					||chiDay==7
					||chiDay==11)
				hd=1;//hac dao
			break;
		case 6:
		case 11:
			if(chiDay==3
			||chiDay==5
			||chiDay==10
			||chiDay==11)
				hd=0;//hoang dao
			else if(chiDay==1
					||chiDay==4
					||chiDay==7
					||chiDay==9)
				hd=1;//hac dao
			break;
		default:
			break;
		}
		return hd;
	}
}
