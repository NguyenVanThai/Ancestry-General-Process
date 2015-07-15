/**
 * 
 */
package com.digitexx.ancestry.bean;

import java.sql.Timestamp;

/**
 * @author lqnhu
 * 
 */
public class CustomerFeedbackDetail
{
	private long id;
	private long management_id;
	private int form_id;
	private String image_path;
	private String image_name;
	private int seq_number;
	private String group_field;
	private String field;
	private String value_db3;
	private String value_dpo;
	private String failure_reason;
	private String user_type;
	private Timestamp import_date;
	private String folder;
    private int count;
    private boolean is_rework_field;
    private boolean is_analyzed;
    private int rework_type;
    
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the management_id
	 */
	public long getManagement_id() {
		return management_id;
	}
	/**
	 * @param management_id the management_id to set
	 */
	public void setManagement_id(long management_id) {
		this.management_id = management_id;
	}
	/**
	 * @return the form_id
	 */
	public int getForm_id() {
		return form_id;
	}
	/**
	 * @param form_id the form_id to set
	 */
	public void setForm_id(int form_id) {
		this.form_id = form_id;
	}
	/**
	 * @return the image_path
	 */
	public String getImage_path() {
		return image_path;
	}
	/**
	 * @param image_path the image_path to set
	 */
	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}
	/**
	 * @return the image_name
	 */
	public String getImage_name() {
		return image_name;
	}
	/**
	 * @param image_name the image_name to set
	 */
	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}
	/**
	 * @return the seq_number
	 */
	public int getSeq_number() {
		return seq_number;
	}
	/**
	 * @param seq_number the seq_number to set
	 */
	public void setSeq_number(int seq_number) {
		this.seq_number = seq_number;
	}
	/**
	 * @return the group_field
	 */
	public String getGroup_field() {
		return group_field;
	}
	/**
	 * @param group_field the group_field to set
	 */
	public void setGroup_field(String group_field) {
		this.group_field = group_field;
	}
	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}
	/**
	 * @param field the field to set
	 */
	public void setField(String field) {
		this.field = field;
	}
	/**
	 * @return the value_db3
	 */
	public String getValue_db3() {
		return value_db3;
	}
	/**
	 * @param value_db3 the value_db3 to set
	 */
	public void setValue_db3(String value_db3) {
		this.value_db3 = value_db3;
	}
	/**
	 * @return the value_dpo
	 */
	public String getValue_dpo() {
		return value_dpo;
	}
	/**
	 * @param value_dpo the value_dpo to set
	 */
	public void setValue_dpo(String value_dpo) {
		this.value_dpo = value_dpo;
	}
	/**
	 * @return the failure_reason
	 */
	public String getFailure_reason() {
		return failure_reason;
	}
	/**
	 * @param failure_reason the failure_reason to set
	 */
	public void setFailure_reason(String failure_reason) {
		this.failure_reason = failure_reason;
	}
	/**
	 * @return the user_type
	 */
	public String getUser_type() {
		return user_type;
	}
	/**
	 * @param user_type the user_type to set
	 */
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	/**
	 * @return the import_date
	 */
	public Timestamp getImport_date() {
		return import_date;
	}
	/**
	 * @param import_date the import_date to set
	 */
	public void setImport_date(Timestamp import_date) {
		this.import_date = import_date;
	}
	/**
	 * @return the folder
	 */
	public String getFolder() {
		return folder;
	}
	/**
	 * @param folder the folder to set
	 */
	public void setFolder(String folder) {
		this.folder = folder;
	}
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * @return the is_rework_field
	 */
	public boolean isIs_rework_field() {
		return is_rework_field;
	}
	/**
	 * @param is_rework_field the is_rework_field to set
	 */
	public void setIs_rework_field(boolean is_rework_field) {
		this.is_rework_field = is_rework_field;
	}
	/**
	 * @return the is_analyzed
	 */
	public boolean isIs_analyzed() {
		return is_analyzed;
	}
	/**
	 * @param is_analyzed the is_analyzed to set
	 */
	public void setIs_analyzed(boolean is_analyzed) {
		this.is_analyzed = is_analyzed;
	}
	/**
	 * @return the rework_type
	 */
	public int getRework_type() {
		return rework_type;
	}
	/**
	 * @param rework_type the rework_type to set
	 */
	public void setRework_type(int rework_type) {
		this.rework_type = rework_type;
	}
    
	
	

}
