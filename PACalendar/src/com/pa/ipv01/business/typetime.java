package com.pa.ipv01.business;

import com.pa.ipv01.object.mytime;

public class typetime {

	public typetime() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String Totime(mytime mytime) {
		String time = null;
		if (mytime.getType() == 1) {
			time = mytime.getH() + ":" + mytime.getM() + " " + "PM";
		} else if (mytime.getType() == 0) {
			time = mytime.getH() + ":" + mytime.getM() + " " + "AM";
		}
		return time;
	}

}
