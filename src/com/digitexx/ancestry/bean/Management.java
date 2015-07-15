/**
 * 
 */
package com.digitexx.ancestry.bean;

import java.sql.Timestamp;

/**
 * @author lqnhu
 * 
 */
public class Management
{
	private long id;
	private int formid;
	private long projectid;
	private String filepath;
	private String filename;
	private int step;
	private String present_user;
	private int record_status;
	private int badimage;
	private String bad_image_name;
	private int classify_status;
	private String comment;
	private int total_rework;
	private int wrong_form;
	private int export_status;
	private Timestamp export_date;
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
	public int getFormid() {
		return formid;
	}

	/**
	 * @param formid
	 *            the formid to set
	 */
	public void setFormid(int formid) {
		this.formid = formid;
	}

	/**
	 * @return the projectid
	 */
	public long getProjectid() {
		return projectid;
	}

	/**
	 * @param projectid
	 *            the projectid to set
	 */
	public void setProjectid(long projectid) {
		this.projectid = projectid;
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
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * @param filename
	 *            the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * @return the step
	 */
	public int getStep() {
		return step;
	}

	/**
	 * @param step
	 *            the step to set
	 */
	public void setStep(int step) {
		this.step = step;
	}

	/**
	 * @return the present_user
	 */
	public String getPresent_user() {
		return present_user;
	}

	/**
	 * @param present_user
	 *            the present_user to set
	 */
	public void setPresent_user(String present_user) {
		this.present_user = present_user;
	}

	/**
	 * @return the record_status
	 */
	public int getRecord_status() {
		return record_status;
	}

	/**
	 * @param record_status
	 *            the record_status to set
	 */
	public void setRecord_status(int record_status) {
		this.record_status = record_status;
	}

	/**
	 * @return the badimage
	 */
	public int getBadimage() {
		return badimage;
	}

	/**
	 * @param badimage
	 *            the badimage to set
	 */
	public void setBadimage(int badimage) {
		this.badimage = badimage;
	}

	/**
	 * @return the bad_image_name
	 */
	public String getBad_image_name() {
		return bad_image_name;
	}

	/**
	 * @param bad_image_name
	 *            the bad_image_name to set
	 */
	public void setBad_image_name(String bad_image_name) {
		this.bad_image_name = bad_image_name;
	}

	/**
	 * @return the classify_status
	 */
	public int getClassify_status() {
		return classify_status;
	}

	/**
	 * @param classify_status
	 *            the classify_status to set
	 */
	public void setClassify_status(int classify_status) {
		this.classify_status = classify_status;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the total_rework
	 */
	public int getTotal_rework() {
		return total_rework;
	}

	/**
	 * @param total_rework
	 *            the total_rework to set
	 */
	public void setTotal_rework(int total_rework) {
		this.total_rework = total_rework;
	}

	/**
	 * @return the wrong_form
	 */
	public int getWrong_form() {
		return wrong_form;
	}

	/**
	 * @param wrong_form
	 *            the wrong_form to set
	 */
	public void setWrong_form(int wrong_form) {
		this.wrong_form = wrong_form;
	}

	/**
	 * @return the export_status
	 */
	public int getExport_status() {
		return export_status;
	}

	/**
	 * @param export_status
	 *            the export_status to set
	 */
	public void setExport_status(int export_status) {
		this.export_status = export_status;
	}

	/**
	 * @return the export_date
	 */
	public Timestamp getExport_date() {
		return export_date;
	}

	/**
	 * @param export_date
	 *            the export_date to set
	 */
	public void setExport_date(Timestamp export_date) {
		this.export_date = export_date;
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
