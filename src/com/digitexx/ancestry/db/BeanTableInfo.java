/**
 * 
 */
package com.digitexx.ancestry.db;

import java.util.List;

/**
 * @author lqnhu
 *
 */
public class BeanTableInfo 
{
	private List<Object[]> listData;
	private String [] headers;
	
	/**
	 * @return the listData
	 */
	public List<Object[]> getListData() {
		return listData;
	}
	/**
	 * @param listData the listData to set
	 */
	public void setListData(List<Object[]> listData) {
		this.listData = listData;
	}
	/**
	 * @return the headers
	 */
	public String[] getHeaders() {
		return headers;
	}
	/**
	 * @param headers the headers to set
	 */
	public void setHeaders(String[] headers) {
		this.headers = headers;
	}
	
	
}
