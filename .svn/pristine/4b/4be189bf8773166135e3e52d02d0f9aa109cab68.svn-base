/**
 * 
 */
package com.digitexx.ancestry.gui.util;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * @author lqnhu
 * 
 */
public class LineDiff 
{
	public List<List<Integer>> getDataNew(String data1, String data2)
	{
		List<List<Integer>> lst = new ArrayList<List<Integer>>();
		try {

			while (data1.indexOf("  ") > -1) {
				data1 = data1.replace("  ", " ");
			}
			while (data2.indexOf("  ") > -1) {
				data2 = data2.replace("  ", " ");
			}

			String arr1[] = data1.split(" ");
			String arr2[] = data2.split(" ");

			int len = arr1.length;

			if (arr1.length > arr2.length)
				len = arr1.length;
			else if (arr1.length < arr2.length)
				len = arr2.length;

			int index1 = 0;
			int index2 = 0;

			List<Integer> lst1 = new ArrayList<Integer>();
			List<Integer> lst2 = new ArrayList<Integer>();

			for (int i = 0; i < len; i++) {
				String tmp1 = "";
				String tmp2 = "";

				if (arr1.length >= i + 1)
					tmp1 = arr1[i];
				if (arr2.length >= i + 1)
					tmp2 = arr2[i];

				if (!tmp1.equals(tmp2)) {
					char[] arr = tmp1.toCharArray();
					char[] arr_1 = tmp2.toCharArray();
					for (int j = 0; j < arr.length; j++) {
						if (arr_1.length >= j + 1) {
							if (!(arr_1[j] + "").equalsIgnoreCase((arr[j] + ""))) {
								lst1.add(j + index1);
							}
						} else {
							lst1.add(j + index1);
						}
					}

					for (int j = 0; j < arr_1.length; j++) {
						if (arr.length >= j + 1) {
							if (!(arr_1[j] + "").equalsIgnoreCase((arr[j] + ""))) {
								lst2.add(j + index2);
							}
						} else {
							lst2.add(j + index2);
						}
					}
				} else {
					// don't action
				}

				if (!tmp1.equals(""))
					index1 += (arr1[i].toCharArray().length) + 1;
				if (!tmp2.equals(""))
					index2 += (arr2[i].toCharArray().length) + 1;

			}

			lst.add(lst1);
			lst.add(lst2);

			System.out.println(lst1);
			System.out.println(lst2);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lst;
	}
	
	public  void addStyleTestNew(JTextPane textPane1,  String data) {

		StyledDocument doc = textPane1.getStyledDocument();
		SimpleAttributeSet sas = new SimpleAttributeSet();
		StyleConstants.setForeground(sas, Color.black);
		
		try {
			
			char [] arr = data.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				int index = i;
				int len =   1+index;

				for(int j =index;j<len;j++){
					doc.setCharacterAttributes(j , 1 , sas, false);
				}
			}
			textPane1.validate();
			textPane1.repaint();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public  void addStyleTestNew(JTextPane textPane1,  List<Integer> lst) {

		StyledDocument doc = textPane1.getStyledDocument();
		SimpleAttributeSet sas = new SimpleAttributeSet();
		StyleConstants.setForeground(sas, Color.red);
		
		try {
			
			for (int i = 0; i < lst.size(); i++) {
				int index = lst.get(i);
				int len =   1+index;

				for(int j =index;j<len;j++){
					doc.setCharacterAttributes(j , 1 , sas, false);
				}
			}
			textPane1.validate();
			textPane1.repaint();	
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void checkForeground(JTextPane txtType1, JTextPane txtType2) {
		List<List<List<Integer>>> lst = null;
		LineDiff lineDiff = new LineDiff();
		boolean isActive = true;
		try {

			if(isActive){
				String data1 = txtType1.getText().trim();
				String data2 = txtType2.getText().trim();
				List<List<Integer>> lstResult = lineDiff.getDataNew(data1, data2);
				
				for (int i = 0; i < lstResult.size(); i++) {
					if(i ==0){
						lineDiff.addStyleTestNew(txtType1, lstResult.get(i));
					}else{
						lineDiff.addStyleTestNew(txtType2, lstResult.get(i));
					}
				}
				
			}else{
				for (int i = 0; i < lst.size(); i++) {
					List<List<Integer>> lstTmp = lst.get(i);
					List<Integer> lst1 = lstTmp.get(0);
					List<Integer> lst2  = lstTmp.get(1);
					
					lineDiff.addStyleTestNew(txtType1, lst1);
					lineDiff.addStyleTestNew(txtType2, lst2);
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addStyleTest(JTextPane textPane1, List<Integer[]> listI1) {
		StyledDocument doc = textPane1.getStyledDocument();
		SimpleAttributeSet sas = new SimpleAttributeSet();
		StyleConstants.setForeground(sas, Color.red);
		try {

			for (int i = 0; i < listI1.size(); i++) {
				int index1 = listI1.get(i)[0];
				int index2 = listI1.get(i)[1];

				for (int j = index1; j < index2; j++) {
					int index = j;
					int len = 1 + index;
					for (int k = index; k < len; k++) {
						doc.setCharacterAttributes(k, 1, sas, false);
					}
				}

			}
			textPane1.validate();
			textPane1.repaint();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
