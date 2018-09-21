package com.test.tony;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateTesting {

	private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS";

	private Long convertDateStringToMilliseconds(String date, String timezone) {
		SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
		Date d = new Date();
		System.out.println(sdf.format(d) + " --- " + TimeZone.getDefault());
		sdf.setTimeZone(TimeZone.getTimeZone(timezone.toUpperCase()));
		try {
			Date d1 = sdf.parse(date);
			sdf.setTimeZone(TimeZone.getTimeZone(timezone.toUpperCase()));
			System.out.println("=====>"+d1);

		} catch (ParseException pe) {
			System.out.println(pe);
		}
		System.out.println(d.getTime());
		System.out.println(TimeZone.getTimeZone(timezone.toUpperCase()));
		return d.getTime();

	}
	
	public static void convertDateString(String d, String timezone) {
		/*try{
		SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
		sdf.setTimeZone(TimeZone.getTimeZone("EST"));
		Date date=sdf.parse(d);  
		//Date date=sdf.parse(sdf.format(new Date()));  
	    
	    System.out.println(date);
		}catch(Exception e){
			
		}*/
		Calendar calendar = Calendar.getInstance();
		TimeZone fromTimeZone = calendar.getTimeZone();
		TimeZone toTimeZone = TimeZone.getTimeZone("IST");

		calendar.setTimeZone(fromTimeZone);
		calendar.add(Calendar.MILLISECOND, fromTimeZone.getRawOffset() * -1);
		if (fromTimeZone.inDaylightTime(calendar.getTime())) {
		    calendar.add(Calendar.MILLISECOND, calendar.getTimeZone().getDSTSavings() * -1);
		}

		calendar.add(Calendar.MILLISECOND, toTimeZone.getRawOffset());
		if (toTimeZone.inDaylightTime(calendar.getTime())) {
		    calendar.add(Calendar.MILLISECOND, toTimeZone.getDSTSavings());
		}

		System.out.println(calendar.getTimeInMillis());
	}

	public static void main(String[] args) {
		DateTesting t = new DateTesting();
		//t.convertDateStringToMilliseconds("2018-08-13T18:45:02.565", "est");
		convertDateString("2018-08-13T18:45:02.565", "IST");
		System.out.println(System.currentTimeMillis());
	}
}
