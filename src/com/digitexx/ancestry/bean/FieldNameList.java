/**
 * 
 */
package com.digitexx.ancestry.bean;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import com.digitexx.ancestry.util.ReflectionHelper;

/**
 * @author lqnhu
 * 
 */
public class FieldNameList 
{
	private long   id;
	private long   form_id;
	private int    file_id =1;
	private int    page_number;
	private String fieldname;
	private int    x = 0;
	private int    y = 0;
	private int    width = 0;
	private int    height = 0;
	private String vinputcheck = "0";
	private String vnotcheck;
	private int    scroll_vertical = 0;
	private int    scroll_horizontal = 0;
	private int    inputtype = 0;
	private int    fieldtype = 0;
	private String inputconstraint;
	private int    saveconstraint = 0;
	private int    searchtype = 0;
	private String fieldnames;
	private String s_where;
	private int    fix_lenth = 0;
	private int    check_in_list = 0;
	private String tablename;
	private String group_type;
	private String value_range;
	private int    checksum = 0;
	private String title;
	private String default_value;
	private String inputtimes;
	private String other1;
	private String other2;
	private String description;
	private String sql_search;
	private int    tab_order;
	private boolean obligation;
	private int     is_valid = 1;
	private String  detail_field;
	private int check_dont_write = 0;
	private int is_show =1;
	private int grid_copy =0;
	private String copy;
	private int f9_f10 =0;
	private String tooltip;
	private int first_upper = 0;
	private int upper_mc =0 ;
	private int non_upper = 0;
	private int remove_other =0;
	
	public FieldNameList() {
		super();
	}

	public long getId() {
		return id;
	}



	public long getForm_id() {
		return form_id;
	}



	public int getFile_id() {
		return file_id;
	}



	public int getPage_number() {
		return page_number;
	}



	public String getFieldname() {
		return fieldname;
	}



	public int getX() {
		return x;
	}



	public int getY() {
		return y;
	}



	public int getWidth() {
		return width;
	}



	public int getHeight() {
		return height;
	}



	public String getVinputcheck() {
		return vinputcheck;
	}



	public String getVnotcheck() {
		return vnotcheck;
	}



	public int getScroll_vertical() {
		return scroll_vertical;
	}



	public int getScroll_horizontal() {
		return scroll_horizontal;
	}



	public int getInputtype() {
		return inputtype;
	}



	public int getFieldtype() {
		return fieldtype;
	}



	public String getInputconstraint() {
		return inputconstraint;
	}



	public int getSaveconstraint() {
		return saveconstraint;
	}



	public int getSearchtype() {
		return searchtype;
	}



	public String getFieldnames() {
		return fieldnames;
	}



	public String getS_where() {
		return s_where;
	}



	public int getFix_lenth() {
		return fix_lenth;
	}



	public int getCheck_in_list() {
		return check_in_list;
	}



	public String getTablename() {
		return tablename;
	}



	public String getGroup_type() {
		return group_type;
	}



	public String getValue_range() {
		return value_range;
	}



	public int getChecksum() {
		return checksum;
	}



	public String getTitle() {
		return title;
	}



	public String getDefault_value() {
		return default_value;
	}



	public String getInputtimes() {
		return inputtimes;
	}



	public String getOther1() {
		return other1;
	}



	public String getOther2() {
		return other2;
	}



	public String getDescription() {
		return description;
	}



	public String getSql_search() {
		return sql_search;
	}



	public int getTab_order() {
		return tab_order;
	}



	public boolean isObligation() {
		return obligation;
	}



	public int getIs_valid() {
		return is_valid;
	}



	public String getDetail_field() {
		return detail_field;
	}



	public int getCheck_dont_write() {
		return check_dont_write;
	}



	public int getIs_show() {
		return is_show;
	}



	public int getGrid_copy() {
		return grid_copy;
	}



	public String getCopy() {
		return copy;
	}



	public int getF9_f10() {
		return f9_f10;
	}



	public String getTooltip() {
		return tooltip;
	}



	public int getFirst_upper() {
		return first_upper;
	}



	public int getUpper_mc() {
		return upper_mc;
	}



	public int getNon_upper() {
		return non_upper;
	}



	public int getRemove_other() {
		return remove_other;
	}



	public void setId(long id) {
		this.id = id;
	}



	public void setForm_id(long form_id) {
		this.form_id = form_id;
	}



	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}



	public void setPage_number(int page_number) {
		this.page_number = page_number;
	}



	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}



	public void setX(int x) {
		this.x = x;
	}



	public void setY(int y) {
		this.y = y;
	}



	public void setWidth(int width) {
		this.width = width;
	}



	public void setHeight(int height) {
		this.height = height;
	}



	public void setVinputcheck(String vinputcheck) {
		this.vinputcheck = vinputcheck;
	}



	public void setVnotcheck(String vnotcheck) {
		this.vnotcheck = vnotcheck;
	}



	public void setScroll_vertical(int scroll_vertical) {
		this.scroll_vertical = scroll_vertical;
	}



	public void setScroll_horizontal(int scroll_horizontal) {
		this.scroll_horizontal = scroll_horizontal;
	}



	public void setInputtype(int inputtype) {
		this.inputtype = inputtype;
	}



	public void setFieldtype(int fieldtype) {
		this.fieldtype = fieldtype;
	}



	public void setInputconstraint(String inputconstraint) {
		this.inputconstraint = inputconstraint;
	}



	public void setSaveconstraint(int saveconstraint) {
		this.saveconstraint = saveconstraint;
	}



	public void setSearchtype(int searchtype) {
		this.searchtype = searchtype;
	}



	public void setFieldnames(String fieldnames) {
		this.fieldnames = fieldnames;
	}



	public void setS_where(String s_where) {
		this.s_where = s_where;
	}



	public void setFix_lenth(int fix_lenth) {
		this.fix_lenth = fix_lenth;
	}



	public void setCheck_in_list(int check_in_list) {
		this.check_in_list = check_in_list;
	}



	public void setTablename(String tablename) {
		this.tablename = tablename;
	}



	public void setGroup_type(String group_type) {
		this.group_type = group_type;
	}



	public void setValue_range(String value_range) {
		this.value_range = value_range;
	}



	public void setChecksum(int checksum) {
		this.checksum = checksum;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public void setDefault_value(String default_value) {
		this.default_value = default_value;
	}



	public void setInputtimes(String inputtimes) {
		this.inputtimes = inputtimes;
	}



	public void setOther1(String other1) {
		this.other1 = other1;
	}



	public void setOther2(String other2) {
		this.other2 = other2;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public void setSql_search(String sql_search) {
		this.sql_search = sql_search;
	}



	public void setTab_order(int tab_order) {
		this.tab_order = tab_order;
	}



	public void setObligation(boolean obligation) {
		this.obligation = obligation;
	}



	public void setIs_valid(int is_valid) {
		this.is_valid = is_valid;
	}



	public void setDetail_field(String detail_field) {
		this.detail_field = detail_field;
	}



	public void setCheck_dont_write(int check_dont_write) {
		this.check_dont_write = check_dont_write;
	}



	public void setIs_show(int is_show) {
		this.is_show = is_show;
	}



	public void setGrid_copy(int grid_copy) {
		this.grid_copy = grid_copy;
	}



	public void setCopy(String copy) {
		this.copy = copy;
	}



	public void setF9_f10(int f9_f10) {
		this.f9_f10 = f9_f10;
	}



	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}



	public void setFirst_upper(int first_upper) {
		this.first_upper = first_upper;
	}



	public void setUpper_mc(int upper_mc) {
		this.upper_mc = upper_mc;
	}



	public void setNon_upper(int non_upper) {
		this.non_upper = non_upper;
	}



	public void setRemove_other(int remove_other) {
		this.remove_other = remove_other;
	}

	//--------------------------------------------------------------------------------------------------------


	public FieldNameList toBean(Map<String , Object> mapValue) {

		FieldNameList fieldNameList = new FieldNameList();
		List<Field> listField = ReflectionHelper.loadBeanFields(FieldNameList.class);
		for (Field field : listField)
		{
			ReflectionHelper.setField(fieldNameList, field.getName() , mapValue.get(field.getName()));
		}
		return fieldNameList;
	}
	
	

}
