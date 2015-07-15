package com.digitexx.ancestry.bean;

import java.util.ArrayList;
import java.util.List;

public class ExportHeader {
	private int headerID;
	private int imageID;
	private List<String> data = new ArrayList<String>();
	public List<String> getData() {
		return data;
	}
	public void setData(List<String> data) {
		this.data = data;
	}
	public int getHeaderID() {
		return headerID;
	}
	public int getImageID() {
		return imageID;
	}
	public void setHeaderID(int headerID) {
		this.headerID = headerID;
	}
	public void setImageID(int imageID) {
		this.imageID = imageID;
	}

}
