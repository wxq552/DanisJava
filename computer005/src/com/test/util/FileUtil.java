package com.test.util;

public class FileUtil {
  public static String getFileExt(String filename){
	  return filename.substring(filename.lastIndexOf("."));
  }
}
