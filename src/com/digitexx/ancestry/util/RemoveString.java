/**
 * 
 */
package com.digitexx.ancestry.util;


/**
 * @author lqnhu
 *
 */
public class RemoveString 
{

	/**
	 * remove ohne Beruf
	 */
	public static String removeOhneBeruf(String columnName , String fieldValue) 
	{
		// Nếu trong dữ liệu có từ “ohne Beruf” thì tự động remove khi save
		fieldValue = fieldValue.replaceAll("[oO][hH][nN][eE][ ][bB][eE][rR][uU][fF]", "");
		fieldValue = StringUtil.ltrim(fieldValue);
		return fieldValue;
	}
	
	public static void main(String[] args) {
		
		String str = "dntcuong M/V. s.s. s. u.s.s. vessel carrier dntcuong M/V";
		
		System.out.println(removeForEnglish("",str));
		
	}
	
	
	/**
	 * remove U.S.S , S.S , and co , & co
	 */
	public static String removeForEnglish(String columnName , String fieldValue) 
	{
		fieldValue = fieldValue.replaceAll("(?i)(^| )((u[.])?s[.]s[.]( |$))+", " ");
			  
		fieldValue = fieldValue.replaceAll("(?i)(^| )((s[.])?s[.]( |$))+", " ");
			  
		fieldValue = fieldValue.replaceAll("(?i)(^| )((m[/])?v( |$))+", " ");
			  
		fieldValue = fieldValue.replaceAll("(?i)(^| )vessel( |$)", " ");
		
		fieldValue = fieldValue.replaceAll("(?i)(^| )carrier( |$)", " ");

		//fieldValue = fieldValue.replaceAll("(?i)(^| )((and|&) co( |$))+", " ");
		//fieldValue = fieldValue.replaceAll("(?i)(^| )(co( |$)+)", "");
		fieldValue = StringUtil.ltrim(fieldValue);
		return fieldValue;
	}
	
	/**
	 * remove kind , knabe , keinen , tochter , noch nicht
	 */
	public static String removeOther(String columnName , String fieldValue) 
	{
		fieldValue = fieldValue.replaceAll("(^| )(?i)kind( |$)", " ");
		fieldValue = fieldValue.replaceAll("(^| )(?i)knabe( |$)", " ");
		fieldValue = fieldValue.replaceAll("(^| )(?i)keinen( |$)", " ");
		fieldValue = fieldValue.replaceAll("(^| )(?i)tochter( |$)", " ");
		fieldValue = fieldValue.replaceAll("(^| )(?i)noch nicht( |$)", " ");
		fieldValue = fieldValue.replaceAll("(^| )(?i)keine Vorname( |$)", " ");
		fieldValue = StringUtil.ltrim(fieldValue);
		return fieldValue;
	}
	
}
