package com.digitexx.ancestry.util;

import java.io.File;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	// TOTAL FILE IMAGE ( .TIF OR .JPG ) OF FOLDER
	private static long totalFile = 0;
	private static long totalFile_image = 0;
	private static long fileSize_image = 0;

	public static String[][] splitTime(String st) throws Exception {
		String[][] result = new String[7][4];
		st = st.substring(0, st.lastIndexOf("#"));
		String[] oneDay = st.split("#");
		for (int i = 0; i < oneDay.length; i++) {
			String[] start_endTime = oneDay[i].split("@");
			result[i][0] = start_endTime[0];
			result[i][1] = start_endTime[1];
			result[i][2] = start_endTime[2];
			result[i][3] = start_endTime[3];
		}
		return result;
	}

	public static int toInt(String value) {
		try {
			return Integer.parseInt(value.trim());
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static String getSendMailTime(String st) throws Exception {

		st = st.substring(st.lastIndexOf("#") + 1);

		return st;

	}

	public static boolean isContaint(List<String[]> fileNames, String fileName) {

		if (fileNames == null || fileNames.size() == 0) {

			return false;
		} else {

			for (int i = 0; i < fileNames.size(); i++) {

				if (fileName.equals(fileNames.get(i)[1])) {

					return true;
				}

			}

		}

		return false;

	}

	public static boolean isContaintSSH(List<String[]> fileNames,
			String fileName) {

		if (fileNames == null || fileNames.size() == 0) {

			return false;
		} else {

			for (int i = 0; i < fileNames.size(); i++) {

				if (fileName.contains(fileNames.get(i)[1])) {

					return true;
				}

			}

		}

		return false;

	}

	private static List<String> listSubFolder = new ArrayList<String>();

	private static void getSubFolder(String path) {
		File file = new File(path);
		if (file.isDirectory()) {
			File[] listFile = file.listFiles();
			for (int i = 0; i < listFile.length; i++) {
				if (listFile[i].isDirectory()) {
					listSubFolder.add(listFile[i].toString());
					getSubFolder(listFile[i].toString());
				}
			}
		}
	}

	/**
	 * getFolderIndex()
	 * 
	 * @author ntbang
	 * @return
	 */
	private static String getFolderIndex(String localFolder) {
		String result = "";
		File file = new File(localFolder);
		File[] filelist = file.listFiles();
		List<String> listFileDirectory = new ArrayList<String>();
		for (int i = 0; i < filelist.length; i++) {
			if (filelist[i].isDirectory()) {
				String dir = filelist[i].getName();
				String index = "";
				String date = "";
				if (dir.contains("_")) {
					index = dir.substring(0, dir.indexOf("_"));
					date = dir.substring(dir.lastIndexOf("_") + 1);
				}
				if (index.length() == 3 && date.length() == 8) {
					try {
						Integer.parseInt(index);
						Integer.parseInt(date);
						listFileDirectory.add(filelist[i].getName());
					} catch (Exception e) {
						continue;
					}
				}
			}
		}
		Collections.sort(listFileDirectory);
		if (listFileDirectory.size() > 0) {
			result = listFileDirectory.get(listFileDirectory.size() - 1);
		} else {
			result = "Images";
		}
		return result;
	}

	public static void computeTotalFiles(File dir) {

		/** get all file in current forder **/
		if (dir.isDirectory()) {

			File[] children = dir.listFiles();

			for (int i = 0; i < children.length; i++) {

				if (!children[i].isDirectory()
						&& (children[i].getName().toLowerCase().indexOf(".tif") != -1
								|| children[i].getName().toLowerCase()
										.indexOf(".jpg") != -1
								|| children[i].getName().toLowerCase()
										.indexOf(".tiff") != -1
								|| children[i].getName().toLowerCase()
										.indexOf(".pdf") != -1 || children[i]
								.getName().toLowerCase().indexOf(".png") != -1)) {

					totalFile++;
				} else {

					computeTotalFiles(children[i]);
				}

			}

		}

	}

	public static void computeTotalFiles_image(File dir) {

		/** get all file in current forder **/
		if (dir.isDirectory()) {

			File[] children = dir.listFiles();

			for (int i = 0; i < children.length; i++) {

				if (!children[i].isDirectory()
						&& (children[i].getName().toLowerCase().indexOf(".tif") != -1
								|| children[i].getName().toLowerCase()
										.indexOf(".jpg") != -1
								|| children[i].getName().toLowerCase()
										.indexOf(".tiff") != -1
								|| children[i].getName().toLowerCase()
										.indexOf(".pdf") != -1 || children[i]
								.getName().toLowerCase().indexOf(".png") != -1)) {

					totalFile_image++;
					fileSize_image += children[i].length();
				} else {

					computeTotalFiles(children[i]);
				}

			}

		}

	}

	public static String createUploadMailReport(List<String[]> uploadResults,
			HashMap<String, List<String[]>> contentSessionHM,
			HashMap<String, String[]> timeHM) {

		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

		String content = "<html>"
				+ "<head>"
				+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\"> "
				+ "</head>"
				+

				"<body>"
				+

				"<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">"
				+ "<tr>"
				+ "<td align=\"center\" colspan=\"4\" height=\"60\" ><b> Upload Results ( "
				+ df.format(new Date()) + " ) </b></td>" + "</tr>" + "<tr>"
				+ "<td width=\"150\"><b>File Name</b></td>"
				+ "<td width=\"120\"><b>Upload Status</b></td>"
				+ "<td width=\"120\"><b>Start</b></td>"
				+ "<td width=\"120\"><b>End</b></td>"
				+ "<td width=\"120\"><b>Records</b></td>" + "</tr>"
				+ "<tr height=\"20\">" + "<td width=\"150\"></td>"
				+ "<td width=\"120\"></td>" + "<td width=\"120\"></td>"
				+ "<td width=\"120\"></td>" + "<td width=\"120\"></td>"
				+ "</tr>";

		for (String[] utiFileArr : uploadResults) {

			System.out.println("ENTER");

			String uploadFileName = utiFileArr[0];
			String uploadResult = utiFileArr[1];

			// GET START TIME , END TIME
			String[] startEnd = timeHM.get(uploadFileName);

			// GET CONTENT OF FILE
			List<String[]> contentOfFile = contentSessionHM.get(uploadFileName);

			System.out.println("Content of file ");
			for (String[] st : contentOfFile) {

				System.out.println(st[0] + " : " + st[1]);
			}

			String uploadStatus = "1".equals(uploadResult) ? "Success" : "Fail";
			String startTime = startEnd[0];
			String endTime = startEnd[1];
			String records = "";

			if (contentOfFile.size() == 1) { // UPLOAD ONE FILE

				System.out.println("Content When upload one file : "
						+ contentOfFile.get(0)[0]);
				records = contentOfFile.get(0)[1];
			}

			content += "<tr height=\"20\">" + "<td width=\"150\">"
					+ uploadFileName + "</td>" + "<td width=\"120\">"
					+ uploadStatus + "</td>" + "<td width=\"120\">" + startTime
					+ "</td>" + "<td width=\"120\">" + endTime + "</td>"
					+ "<td width=\"120\">" + records + "</td>" + "</tr>";

			System.out.println("content at this time : " + content);

			if (contentOfFile.size() > 1) {

				for (String[] line : contentOfFile) {

					String folderPath = line[0].substring(0,
							line[0].lastIndexOf("\\"));
					String fileName = line[0].substring(line[0]
							.lastIndexOf("\\") + 1);

					content += "<tr height=\"20\">" + "<td width=\"150\">"
							+ "</td>" + "<td width=\"120\">" + "</td>"
							+ "<td width=\"120\">" + folderPath + "</td>"
							+ "<td width=\"120\">" + fileName + "</td>"
							+ "<td width=\"120\">" + line[1] + "</td>"
							+ "</tr>";

				}

			}

		}

		content += "</table>" + "</body>" + "</html>";

		return content;

	}

	public static void main(String a[]) throws Exception {

		String s = "-1";
		System.out.println(getStringCurrentDate());
	}

	public static boolean startWith(String field, String value) {
		try {
			return field.toLowerCase().startsWith(value.toLowerCase());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean endWith(String field, String value) {
		try {
			return field.toLowerCase().endsWith(value.toLowerCase());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean contains(String field, String value) {
		try {
			return field.toLowerCase().contains(value.toLowerCase());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static String setNotNull(Object str) {
		if (str == null)
			return "";
		else
			return str.toString().trim();
	}

	public static boolean isNumeric(String str) {
		NumberFormat formatter = NumberFormat.getInstance();
		ParsePosition pos = new ParsePosition(0);
		formatter.parse(str, pos);
		return str.length() == pos.getIndex();
	}

	public static boolean isNumber(String str) {
		for (char c : str.toCharArray()) {
			if (!Character.isDigit(c))
				return false;
		}
		return true;
	}

	public static String getStringCurrentDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		String currentdate = "" + format.format(date);
		return currentdate;
	}

	public static String getReplaceChar(String strIn) {
		String strOut = "";
		if (strIn != null && !"".equals(strIn)) {
			while (strIn.indexOf("  ") > -1) {
				strIn = strIn.replace("  ", " ");
			}
			strOut = strIn.replace("\\", "\\\\");
			strOut = strOut.replace("'", "''");
			strOut = strOut.replace(";", ",");
			while (strOut.indexOf("\\\\'") > -1) {
				strOut = strOut.replace("\\\\'", "\\'");
			}
			strOut = strOut.trim();
		}
		return strOut;
	}

	public static <T> String join(final Collection<T> collection,
			final String delimiter) {
		final StringBuilder sb = new StringBuilder();
		for (final Iterator<T> i = collection.iterator(); i.hasNext();) {
			sb.append(i.next());
			if (i.hasNext()) {
				sb.append(delimiter);
			}
		}
		return sb.toString();
	}

	public static String setNotNull(String strIn) {
		try {
			if (strIn != null) {

				return strIn.trim();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String[] split(String src, String splitter) {
		if (src.lastIndexOf(splitter) == -1) {
			return new String[] { src };
		} else {
			StringBuilder sb = new StringBuilder(src);
			int index = sb.indexOf(splitter);
			List<String> tokenList = new LinkedList<String>();
			while (index != -1) {
				tokenList.add(sb.substring(0, index));
				sb.delete(0, index + splitter.length());
				index = sb.indexOf(splitter);
			}
			tokenList.add(sb.toString());
			String[] ret = new String[tokenList.size()];
			tokenList.toArray(ret);
			return ret;
		}
	}

	/**
	 * set array header for Jtable
	 */
	public static String[] setArrayHeader(
			List<LinkedHashMap<String, Object>> listData) {
		String[] arrHeader = new String[1];
		int index = 0;
		if (listData.size() > 0) {
			int size = listData.get(0).size();

			arrHeader = new String[size];
			for (String str : listData.get(0).keySet()) {
				arrHeader[index] = str;
				++index;
			}
		}
		return arrHeader;
	}

	/**
	 * map to array
	 */
	public static Object[] mapToArray(LinkedHashMap<String, Object> mapData) {

		Object[] result = new Object[mapData.size()];
		try {
			int index = 0;
			for (String key : mapData.keySet()) {
				result[index] = mapData.get(key);
				++index;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// code cung tam thoi
	public static boolean specialWordFirst(String word) {
		boolean flag = true;
		if (word != null) {
			if (word.startsWith(" ") || word.startsWith("-")
					|| word.startsWith("+") || word.startsWith("/")) {
				flag = false;
			} else if (word.endsWith(" ")) {
				flag = false;
			} else if (word.contains("  ")) {
				flag = false;
			} else
				flag = true;
		}
		return flag;
	}

	public static boolean checkContainSpecial(String word) {
		boolean flag = true;
		Pattern p = Pattern.compile("[\\%@#*&].*");
		Matcher m = p.matcher(word);
		if (m.find()) {
			flag = false;
		}
		return flag;
	}

	// su dung regular trong db de sau nay cho ng dung chinh rule cho tung field
	// lam them reg lay tu db db_14_000_qc_ancestry column expression table rule
	public static boolean CheckSpecialWordDB(String word, String reg) {
		boolean flag = true;
		String[] sp = reg.split(",");
		for (int i = 0; i < sp.length; i++) {
			if (word != null) {
				if (word.startsWith(" ") || word.startsWith(sp[i])) {
					flag = false;
				} else if (word.endsWith(" ")) {
					flag = false;
				} else if (word.contains("  ")) {
					flag = false;
				} else
					flag = true;
			}
		}

		return flag;
	}

	// su dung regular trong db de sau nay cho ng dung chinh rule cho tung field
	public static boolean checkContainSpecialDB(String word, String reg) {
		boolean flag;
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(word);
		flag = m.find();
		return flag;
	}

	public static String capitalizeByCondition(String givenString,String Separateur) {
		StringBuffer sb = new StringBuffer();
		boolean ToCap = false;
		for (int i = 0; i < givenString.length(); i++) {
			if (ToCap)
				sb.append(Character.toUpperCase(givenString.charAt(i)));
			else
				sb.append(Character.toLowerCase(givenString.charAt(i)));

			if (Separateur.indexOf(givenString.charAt(i)) >= 0)
				ToCap = true;
			else
				ToCap = false;
		}
		return sb.toString().trim();
	}
	
	public static String upperCaseFirstCharacter(String text)
	{
		String result = "";
		char[]arrayTemp = text.toCharArray();
		if(!text.equals(""))
		{
			arrayTemp[0] = Character.toUpperCase(arrayTemp[0]);
			for(char charTemp : arrayTemp){
				result += charTemp;
			}
			return result;
		}
		return text;
	}
	
	public static String updateMc(String text)
	{
		if(text == null || text.equals("")) return "";
		String result = "";
		if(text.contains(" "))
		{
			String []array = text.split(" ");
			for(int i = 0; i<array.length; i ++)
			{
				String temp = updateMcOneWord(array[i]);
				result += temp + " ";
			}
		} 
		else{
			String temp = updateMcOneWord(text);
			result += temp + " ";
		}
		result = result.trim();
		return result;
	}
	

	public static String [] listToArray(List<String> listSource) {
		String arr[] = new String [listSource.size()] ;
		int idx = 0;
		for (String str : listSource) {
			arr[idx] = str;
			++idx;
		}
		return arr;
	}
	
	public static String updateInvertedComma(String text)
	{
		if(text == null || text.equals("")) return "";
		String temp = "";
		
		if(text.contains("'"))
		{
			String []array = text.split("'");
			for(int i = 0; i<array.length; i ++)
			{
				if(i != 0)
					array[i] = upperCaseFirstCharacter(array[i]);
				if(i == array.length-1)
					temp += array[i];
				else temp += array[i] + "'";
			}
			return temp;
		}
		else
			return text;
		
	}
	
	public static String updateMcOneWord(String text)
	{
		String result = "";
		char[]arrayTemp = text.toCharArray();
		if(arrayTemp.length >=3 ){
			if(Character.toString(arrayTemp[0]).equalsIgnoreCase("m")
					&&Character.toString(arrayTemp[1]).equalsIgnoreCase("c"))
			{
				arrayTemp[2] = Character.toUpperCase(arrayTemp[2]);
			}
			for(char charTemp : arrayTemp){
				result += charTemp;
			}
			return result;
		}
		return text;
	}
	
	public static String ltrim(String s) {
		int i = 0;
		while (i < s.length() && Character.isWhitespace(s.charAt(i))) {
			i++;
		}
		return s.substring(i);
	}
	
	public static String trimspace(String str)
	{
	    str = str.replaceAll("\\s+", " ");
	    str = str.replaceAll("(^\\s+|\\s+$)", "");
	    return str;
	}

}
