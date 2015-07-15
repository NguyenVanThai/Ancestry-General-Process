package com.digitexx.ancestry.bean;

public class FormType
{
	long ID; //management id
    long formID;
    long projectID;
    String filePath;
    String fileName;
    String comment;
    String badImageName;
    int totalRework;
    int step;
	int wrongForm;
	long group_id;
	int total_row;
	
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public long getFormID() {
		return formID;
	}
	public void setFormID(long formID) {
		this.formID = formID;
	}
	public long getProjectID() {
		return projectID;
	}
	public void setProjectID(long projectID) {
		this.projectID = projectID;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getBadImageName() {
		return badImageName;
	}
	public void setBadImageName(String badImageName) {
		this.badImageName = badImageName;
	}
	public int getTotalRework() {
		return totalRework;
	}
	public void setTotalRework(int totalRework) {
		this.totalRework = totalRework;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getWrongForm() {
		return wrongForm;
	}
	public void setWrongForm(int wrongForm) {
		this.wrongForm = wrongForm;
	}
	public long getGroup_id() {
		return group_id;
	}
	public void setGroup_id(long group_id) {
		this.group_id = group_id;
	}
	public int getTotal_row() {
		return total_row;
	}
	public void setTotal_row(int total_row) {
		this.total_row = total_row;
	}
	
	
}