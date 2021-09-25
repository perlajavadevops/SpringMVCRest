package com.pgr.jsp;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TodayDateDemo {

	public String getTodayDate() {
		Date date  = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss:sss:zz");//12-09-2021//12-Sep-2021//12/09/2021//12/9/21
		String todayDate = sdf.format(date);
		return todayDate;
	}
	
	/*public static void main(String[] args) {
		System.out.println(getTodayDate());
	}*/
}
