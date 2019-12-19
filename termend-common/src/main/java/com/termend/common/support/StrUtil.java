package com.termend.common.support;



public class StrUtil {

	public static String createId(String type) {
		return type+System.currentTimeMillis();
	}
	
	
	public static String createId(String type,Integer num) {
		return type + (num<10?"0"+num.toString():num.toString());
	}
}
