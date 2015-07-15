package com.digitexx.ancestry.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author vqtuan
 * all attributes of one field design of one form  
 */
 public class DesignField {

	 private long id ; 
	 
	 private long form_id ; 
  	
	 private int file_id ;
	 
	 private int page_number ;
	 
	 private String fieldname ;
	 
	 private int x ;
	 
	 private int y ;
	 
	 private int width ;
	 
	 private int height ;
	 
	 private String vinputcheck ;
	 
	 private String vnotcheck ;
	 
	 private int scroll_vertical ;
	 
	 private int scroll_horizontal ;
	 
	 private int inputtype ;
	 
	 private int fieldtype ;
	 
	 private String inputconstraint ;
	 
	 private int saveconstraint ;
	 
	 private int searchtype ;
	 	 	 
	 private byte fix_lenth ;
	 	 	 
	 private String group_type ;
	 
	 private String value_range ;
	 
	 private byte checksum ;
	 
	 private String title ;
	 
	 private String default_value ;
	 
	 private String inputtimes ;
	 
	 private byte tabOrder ; 
	 
	 private boolean obligation ; 
	 
	 private String description ; 
	 
	 private String sql_search ; 
	 
	 private String check_dont_write;
	 
	 /**
	 *  Fields has not used at the moment 
	 */
	 
     private byte check_in_list ;
	 
	 private String tablename ;
	 
     private String fieldnames ;
	 
	 private String s_where ;
	 
	 private String other1 ;
	 
	 private String other2 ;
	 
	 private String other3 ;
	 
	 private String other4 ;
	 
	 private int is_valid;
	 
	 private List<DesignField> listFieldVerify;
	 
	 
	 public DesignField() {
		 
			super();
			listFieldVerify = new ArrayList<DesignField>() ; 
	 }

	public byte getCheck_in_list() {
		return check_in_list;
	}

	public void setCheck_in_list(byte check_in_list) {
		this.check_in_list = check_in_list;
	}

	public byte getChecksum() {
		return checksum;
	}

	public void setChecksum(byte checksum) {
		this.checksum = checksum;
	}

	public String getDefault_value() {
		return default_value;
	}

	public void setDefault_value(String default_value) {
		this.default_value = default_value;
	}

	public String getFieldname() {
		return fieldname;
	}

	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}

	public String getFieldnames() {
		return fieldnames;
	}

	public void setFieldnames(String fieldnames) {
		this.fieldnames = fieldnames;
	}

	public int getFieldtype() {
		return fieldtype;
	}

	public void setFieldtype(int fieldtype) {
		this.fieldtype = fieldtype;
	}

	public int getFile_id() {
		return file_id;
	}

	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}

	public byte getFix_lenth() {
		return fix_lenth;
	}

	public void setFix_lenth(byte fix_lenth) {
		this.fix_lenth = fix_lenth;
	}

	public long getForm_id() {
		return form_id;
	}

	public void setForm_id(long form_id) {
		this.form_id = form_id;
	}

	public String getGroup_type() {
		return group_type;
	}

	public void setGroup_type(String group_type) {
		this.group_type = group_type;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInputconstraint() {
		return inputconstraint;
	}

	public void setInputconstraint(String inputconstraint) {
		this.inputconstraint = inputconstraint;
	}

	public String getInputtimes() {
		return inputtimes;
	}

	public void setInputtimes(String inputtimes) {
		this.inputtimes = inputtimes;
	}

	public int getInputtype() {
		return inputtype;
	}

	public void setInputtype(int inputtype) {
		this.inputtype = inputtype;
	}

	public String getOther1() {
		return other1;
	}

	public void setOther1(String other1) {
		this.other1 = other1;
	}

	public String getOther2() {
		return other2;
	}

	public void setOther2(String other2) {
		this.other2 = other2;
	}

	public String getOther3() {
		return other3;
	}

	public void setOther3(String other3) {
		this.other3 = other3;
	}

	public String getOther4() {
		return other4;
	}

	public void setOther4(String other4) {
		this.other4 = other4;
	}

	public int getPage_number() {
		return page_number;
	}

	public void setPage_number(int page_number) {
		this.page_number = page_number;
	}

	public String getS_where() {
		return s_where;
	}

	public void setS_where(String s_where) {
		this.s_where = s_where;
	}

	public int getSaveconstraint() {
		return saveconstraint;
	}

	public void setSaveconstraint(int saveconstraint) {
		this.saveconstraint = saveconstraint;
	}

	public int getScroll_horizontal() {
		return scroll_horizontal;
	}

	public void setScroll_horizontal(int scroll_horizontal) {
		this.scroll_horizontal = scroll_horizontal;
	}

	public int getScroll_vertical() {
		return scroll_vertical;
	}

	public void setScroll_vertical(int scroll_vertical) {
		this.scroll_vertical = scroll_vertical;
	}

	public int getSearchtype() {
		return searchtype;
	}

	public void setSearchtype(int searchtype) {
		this.searchtype = searchtype;
	}

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getValue_range() {
		return value_range;
	}

	public void setValue_range(String value_range) {
		this.value_range = value_range;
	}

	public String getVinputcheck() {
		return vinputcheck;
	}

	public void setVinputcheck(String vinputcheck) {
		this.vinputcheck = vinputcheck;
	}

	public String getVnotcheck() {
		return vnotcheck;
	}

	public void setVnotcheck(String vnotcheck) {
		this.vnotcheck = vnotcheck;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public byte getTabOrder() {
		return tabOrder;
	}

	public void setTabOrder(byte tabOrder) {
		this.tabOrder = tabOrder;
	}

	public boolean isObligation() {
		return obligation;
	}

	public void setObligation(boolean obligation) {
		this.obligation = obligation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSql_search() {
		return sql_search;
	}

	public void setSql_search(String sql_search) {
		this.sql_search = sql_search;
	}

	public int getIs_valid() {
		return is_valid;
	}

	public void setIs_valid(int is_valid) {
		this.is_valid = is_valid;
	}

	public List<DesignField> getListFieldVerify() {
		return listFieldVerify;
	}

	public void setListFieldVerify(List<DesignField> listFieldVerify) {
		this.listFieldVerify = listFieldVerify;
	}

	public String getCheck_dont_write() {
		return check_dont_write;
	}

	public void setCheck_dont_write(String check_dont_write) {
		this.check_dont_write = check_dont_write;
	}



	
	 
	 
	
 }
