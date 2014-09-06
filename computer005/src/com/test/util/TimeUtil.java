package com.test.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
  public static String getnow(){
	  Date date=new Date();
	  SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
	  return format.format(date);
  }
}
