/**
 * 
 */
package com.digitexx.ancestry.bean;

import java.sql.Timestamp;

/**
 * @author lqnhu
 * 
 */
public class ListRule 
{
	private long id;
	private long formid;
	private String filepath;
	private String rule_name;
	private String condition;
	private int status;
	private String note;
	private Timestamp createdtime;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the formid
	 */
	public long getFormid() {
		return formid;
	}

	/**
	 * @param formid
	 *            the formid to set
	 */
	public void setFormid(long formid) {
		this.formid = formid;
	}

	/**
	 * @return the filepath
	 */
	public String getFilepath() {
		return filepath;
	}

	/**
	 * @param filepath
	 *            the filepath to set
	 */
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * @return the rule_name
	 */
	public String getRule_name() {
		return rule_name;
	}

	/**
	 * @param rule_name
	 *            the rule_name to set
	 */
	public void setRule_name(String rule_name) {
		this.rule_name = rule_name;
	}

	/**
	 * @return the condition
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * @param condition
	 *            the condition to set
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note
	 *            the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * @return the createdtime
	 */
	public Timestamp getCreatedtime() {
		return createdtime;
	}

	/**
	 * @param createdtime
	 *            the createdtime to set
	 */
	public void setCreatedtime(Timestamp createdtime) {
		this.createdtime = createdtime;
	}

}
