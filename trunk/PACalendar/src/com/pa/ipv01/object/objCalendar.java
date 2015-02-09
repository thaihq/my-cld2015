package com.pa.ipv01.object;

public class objCalendar {

	private int day;
	private int month;
	private int year;
	private int hour;
	private int min;
	private int daySolar;
	private int monthSolar;
	private int yearSolar;
	private String canChiYear;
	private String canChiMonth;
	private String canChiDay;
	private String thuOfWeek;
	private int lunarLeap;
	
	public int getLunarLeap() {
		return lunarLeap;
	}
	public void setLunarLeap(int lunarLeap) {
		this.lunarLeap = lunarLeap;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getDaySolar() {
		return daySolar;
	}
	public void setDaySolar(int daySolar) {
		this.daySolar = daySolar;
	}
	public int getMonthSolar() {
		return monthSolar;
	}
	public void setMonthSolar(int monthSolar) {
		this.monthSolar = monthSolar;
	}
	public int getYearSolar() {
		return yearSolar;
	}
	public void setYearSolar(int yearSolar) {
		this.yearSolar = yearSolar;
	}
	public String getCanChiYear() {
		return canChiYear;
	}
	public void setCanChiYear(String canChiYear) {
		this.canChiYear = canChiYear;
	}
	public String getCanChiMonth() {
		return canChiMonth;
	}
	public void setCanChiMonth(String canChiMonth) {
		this.canChiMonth = canChiMonth;
	}
	public String getCanChiDay() {
		return canChiDay;
	}
	public void setCanChiDay(String canChiDay) {
		this.canChiDay = canChiDay;
	}
	public String getThuOfWeek() {
		return thuOfWeek;
	}
	public void setThuOfWeek(String thuOfWeek) {
		this.thuOfWeek = thuOfWeek;
	}
	
	public objCalendar() {}
	
	public objCalendar(int day, int month,int year,int hour,String canchiyear
			,String canchimonth,String canchiday, String thuofday,int min
			,int daysolar, int monthsolar, int yearsolar, int leap) 
	{
		this.day=day;
		this.month=month;
		this.year=year;
		this.hour=hour;
		this.canChiDay=canchiday;
		this.canChiMonth=canchimonth;
		this.canChiYear=canchiyear;
		this.thuOfWeek=thuofday;
		this.min=min;
		this.daySolar=daysolar;
		this.monthSolar=monthsolar;
		this.yearSolar=yearsolar;
		this.lunarLeap=leap;
	}
}
