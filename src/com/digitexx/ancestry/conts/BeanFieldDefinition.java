package com.digitexx.ancestry.conts;

import java.util.ArrayList;
import java.util.List;

public class BeanFieldDefinition {
	public List<String> listFieldHeader = new ArrayList<String>();
	public List<String> listFieldRecord = new ArrayList<String>();
	public List<String> getListFieldHeader() {
		return listFieldHeader;
	}
	public List<String> getListFieldRecord() {
		return listFieldRecord;
	}
	public void setListFieldHeader(List<String> listFieldHeader) {
		this.listFieldHeader = listFieldHeader;
	}
	public void setListFieldRecord(List<String> listFieldRecord) {
		this.listFieldRecord = listFieldRecord;
	}
}
