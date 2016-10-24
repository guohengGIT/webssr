package com.hp.webssr.common;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 * deal with DateTime
 * */
public class DateTimeUtility {
	/**
	 * return current date time in Beijing Time Zone
	 * format: yyyy-MM-dd HH:mm:ss 
	 * */
	public static String getSystemCurrentDateTime()
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(new Date());
	}
}
