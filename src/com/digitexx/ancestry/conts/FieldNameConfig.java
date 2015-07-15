/**
 * 
 */
package com.digitexx.ancestry.conts;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author lqnhu
 *
 */
public enum FieldNameConfig {
	
	year_min_max      ( FieldType.number ),
	tab_order         ( FieldType.number ),
	is_valid          ( FieldType.number ),
	f9_f10            ( FieldType.number ),
	grid_copy         ( FieldType.number ),
	check_dont_write  ( FieldType.number ),
	
    first_upper       ( FieldType.number ),
	upper_mc          ( FieldType.number ),
	non_upper         ( FieldType.number ),
	remove_other      ( FieldType.number ),
	
	value_range       ( FieldType.letter ),
	title             ( FieldType.letter ),
	tooltip           ( FieldType.letter ),
	description       ( FieldType.letter),
	copy              ( FieldType.letter ),

	;
	
    private static final Map<String, Integer> BY_CODE_MAP = new LinkedHashMap<>();
    static {
        for (FieldNameConfig fieldConfig : FieldNameConfig.values()) {
            BY_CODE_MAP.put(fieldConfig.name() , fieldConfig.value);
        }
    }
	
	private int value;
	private FieldNameConfig(int value) {
		this.value = value;
	}
	
	
    public int getValue() {
        return value;
    }

    public static int getByValue(String name) {
        return BY_CODE_MAP.get(name);
    }
    
    public static void main(String[] args)
    {
        System.out.println("enum1==>" + getByValue(FieldNameConfig.check_dont_write.name()));

    }
}
