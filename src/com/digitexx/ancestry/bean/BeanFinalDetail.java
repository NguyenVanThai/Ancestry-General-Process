/**
 * 
 */
package com.digitexx.ancestry.bean;

/**
 * @author lqnhu
 * 
 */
public class BeanFinalDetail {
	private long id;
	private int formid;
	private int ruleid;
	private String filepath;
	private String element;
	private int status;
	private String note;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the formid
	 */
	public int getFormid() {
		return formid;
	}

	/**
	 * @return the ruleid
	 */
	public int getRuleid() {
		return ruleid;
	}

	/**
	 * @return the filepath
	 */
	public String getFilepath() {
		return filepath;
	}

	/**
	 * @return the element
	 */
	public String getElement() {
		return element;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @param formid
	 *            the formid to set
	 */
	public void setFormid(int formid) {
		this.formid = formid;
	}

	/**
	 * @param ruleid
	 *            the ruleid to set
	 */
	public void setRuleid(int ruleid) {
		this.ruleid = ruleid;
	}

	/**
	 * @param filepath
	 *            the filepath to set
	 */
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * @param element
	 *            the element to set
	 */
	public void setElement(String element) {
		this.element = element;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @param note
	 *            the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}

}
