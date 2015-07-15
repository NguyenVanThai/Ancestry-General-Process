/**
 * 
 */
package com.digitexx.ancestry.conts;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lqnhu
 *
 */
public enum EnumSpecialField {
	event_type_export     ("event_type"),
	general_year_export   ("general_year"),
	vital_year_export     ("vital_year"),
	birth_year_export     ("birth_year"),
	header_year_export    ("header_year"),
	neighborhood          ("neighborhood_export"),
	
	military_day_export   ("military_day"),
	military_month_export ("military_month"),
	military_year_export  ("military_year"),
	regiment_export       ("regiment"),
	day_multiple_export   ("day_multiple"),
	month_multiple_export ("month_multiple"),
	year_multiple_export  ("year_multiple"),
	military_place_export ("military_place"),

	;
	 
	private String value;
 
	private EnumSpecialField(String value) {
		this.value = value;
	}
 
	public String getValue() {
		return value;
	}
	
	public static Map<String, String> toMap() {
		Map<String, String> mapEnumSpecialField = new HashMap<String, String>();
		for (EnumSpecialField enumSpecial : EnumSpecialField.values()) {
			mapEnumSpecialField.put(enumSpecial.name(), enumSpecial.value);
		}
		return mapEnumSpecialField;
	}
}
