package com.digitexx.ancestry.conts;

import java.util.HashMap;


public class ContsColor {

	public static final String RED = "RED";
	
	public static final String BLUE = "BLUE";
	
	public static final String BLACK = "BLACK";
	
	public static final String GREEN = "GREEN";
	
	
	public static final HashMap<String, Integer> HM_COLORID = new HashMap<String, Integer>();
	
	public static final HashMap<Integer, String> HM_COLOR = new HashMap<Integer, String>();

	public static HashMap<String, Integer> getHM_COLORID() {
		HM_COLORID.put(RED, 1);
		HM_COLORID.put(BLUE, 2);
		HM_COLORID.put(BLACK, 3);
		HM_COLORID.put(GREEN, 4);
		
		return HM_COLORID;
	}
	
	public static HashMap<Integer, String> getHM_COLOR() {
		HM_COLOR.put(1, RED);
		HM_COLOR.put(2, BLUE);
		HM_COLOR.put(3, BLACK);
		HM_COLOR.put(4, GREEN);
		
		return HM_COLOR;
	}
	
}
