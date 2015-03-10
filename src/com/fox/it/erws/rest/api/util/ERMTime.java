package com.fox.it.erws.rest.api.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;


//Singleton
public class ERMTime {
	
	private static ERMTime instance;
	
	private ERMTime() {
		new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	}
	
	public static ERMTime getInstance() {
		if (instance==null)
			instance = new ERMTime();
		
		return instance;
	}
	
	public static String getTime() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(Calendar.getInstance().getTimeInMillis());
	}

}
