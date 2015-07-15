/**
 * 
 */
package com.digitexx.ancestry.conts;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lqnhu
 *military_age
 */
public enum EnumFieldAge {
	vital_age             ("v"),
	spouse_marriage_age   ("s"),
	age_at_death          ("d"),
	age_at_marriage       ("m"),
	spouse_age            ("s"),
	departure_age         ("d"),
	age                   ("r"),
	marriage_age          ("m"),
	death_age             ("d"),
	arrival_age           ("a"),
	military_age          ("m"),
	other_age             ("o"),
	;
	 
	private String value;
 
	private EnumFieldAge(String value) {
		this.value = value;
	}
 
	public String getValue() {
		return value;
	}
	
	public static Map<String, String> toMap() {
		Map<String, String> mapEnumAge = new HashMap<String, String>();
		for (EnumFieldAge enumAge : EnumFieldAge.values()) {
			mapEnumAge.put(enumAge.name(), enumAge.value);
		}
		return mapEnumAge;
	}
	
	public static void main(String[] args) {
	   Map<String, String> mapAge = EnumFieldAge.toMap();
	   for (String str : mapAge.keySet()) {
		System.out.println(str + "\t " +  mapAge.get(str));
	   }
	}
}
