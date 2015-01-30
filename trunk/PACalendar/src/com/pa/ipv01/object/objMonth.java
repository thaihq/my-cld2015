package com.pa.ipv01.object;


public class objMonth {
	private int month;
	private int year;
	private int days;
	
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
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	
	public objMonth(){}
	public objMonth(int month,int year)
	{
		this.month=month;
		this.year=year;
		this.days=getDaysOfMonth(month, year);
	}
	
	public int getDaysOfMonth(int month,int year)
	{
		int numDay;
		if(month==4||month==6
				||month==9
				||month==11)
			numDay=30;
		else if(month==2)
		{
			if(year%400==0||(year%4==0&&year%100!=0))
			{
				numDay=29;
			}
			else
				numDay=28;
		}
		else
			numDay=31;
		return numDay;
	}
}
