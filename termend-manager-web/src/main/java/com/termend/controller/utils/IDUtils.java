package com.termend.controller.utils;



import java.util.Random;


public class IDUtils {

	public static String genImageName() {
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		Random random = new Random();
		int end3 = random.nextInt(999);
		String str = millis + String.format("%03d", end3);
		
		return str;
	}
	
	
	public static long genItemId() {
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		Random random = new Random();
		int end2 = random.nextInt(99);
		String str = millis + String.format("%02d", end2);
		long id = new Long(str);
		return id;
	}
	
	public static void main(String[] args) {
		for(int i=0;i< 100;i++)
		System.out.println(genItemId());
	}
}
