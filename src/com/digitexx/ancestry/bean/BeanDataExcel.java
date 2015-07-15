/**
 * 
 */
package com.digitexx.ancestry.bean;

/**
 * @author lqnhu
 * 
 */
public class BeanDataExcel {

	private String batchName;
	private String status;
	private String priority;
	private String image;
	private String dataFiles;
	private String imagePath;

	public String getBatchName() {
		return batchName;
	}

	public String getStatus() {
		return status;
	}

	public String getPriority() {
		return priority;
	}

	public String getImage() {
		return image;
	}

	public String getDataFiles() {
		return dataFiles;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setDataFiles(String dataFiles) {
		this.dataFiles = dataFiles;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}
