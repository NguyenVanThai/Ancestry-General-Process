/**
 * 
 */
package com.digitexx.ancestry.bean;

import java.sql.Timestamp;

/**
 * @author lqnhu
 * 
 */
public class TblLogUpdateDb 
{
	private long logdb_id;
	private String logdb_proj_name;
	private Timestamp logdb_createdtime;
	private String logdb_query;
	private String logdb_usr_name;
	private String logdb_oldvalue;

	/**
	 * @return the logdb_id
	 */
	public long getLogdb_id() {
		return logdb_id;
	}

	/**
	 * @param logdb_id
	 *            the logdb_id to set
	 */
	public void setLogdb_id(long logdb_id) {
		this.logdb_id = logdb_id;
	}

	/**
	 * @return the logdb_proj_name
	 */
	public String getLogdb_proj_name() {
		return logdb_proj_name;
	}

	/**
	 * @param logdb_proj_name
	 *            the logdb_proj_name to set
	 */
	public void setLogdb_proj_name(String logdb_proj_name) {
		this.logdb_proj_name = logdb_proj_name;
	}

	/**
	 * @return the logdb_createdtime
	 */
	public Timestamp getLogdb_createdtime() {
		return logdb_createdtime;
	}

	/**
	 * @param logdb_createdtime
	 *            the logdb_createdtime to set
	 */
	public void setLogdb_createdtime(Timestamp logdb_createdtime) {
		this.logdb_createdtime = logdb_createdtime;
	}

	/**
	 * @return the logdb_query
	 */
	public String getLogdb_query() {
		return logdb_query;
	}

	/**
	 * @param logdb_query
	 *            the logdb_query to set
	 */
	public void setLogdb_query(String logdb_query) {
		this.logdb_query = logdb_query;
	}

	/**
	 * @return the logdb_usr_name
	 */
	public String getLogdb_usr_name() {
		return logdb_usr_name;
	}

	/**
	 * @param logdb_usr_name
	 *            the logdb_usr_name to set
	 */
	public void setLogdb_usr_name(String logdb_usr_name) {
		this.logdb_usr_name = logdb_usr_name;
	}

	/**
	 * @return the logdb_oldvalue
	 */
	public String getLogdb_oldvalue() {
		return logdb_oldvalue;
	}

	/**
	 * @param logdb_oldvalue
	 *            the logdb_oldvalue to set
	 */
	public void setLogdb_oldvalue(String logdb_oldvalue) {
		this.logdb_oldvalue = logdb_oldvalue;
	}

}
