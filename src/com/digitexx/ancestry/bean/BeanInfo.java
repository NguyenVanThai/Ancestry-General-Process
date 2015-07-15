/**
 * 
 */
package com.digitexx.ancestry.bean;

/**
 * @author lqnhu
 * 
 */
public class BeanInfo {

	private String filepath;
	private String[] column_Ancestry;
	private String[] column_DigiSoft;
	private String schema_Ancestry;
	private String schema_DigiSoft;
	private String var_con;
	private String search_path;

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
	 * @return the column_Ancestry
	 */
	public String[] getColumn_Ancestry() {
		return column_Ancestry;
	}

	/**
	 * @param column_Ancestry
	 *            the column_Ancestry to set
	 */
	public void setColumn_Ancestry(String[] column_Ancestry) {
		this.column_Ancestry = column_Ancestry;
	}

	/**
	 * @return the column_DigiSoft
	 */
	public String[] getColumn_DigiSoft() {
		return column_DigiSoft;
	}

	/**
	 * @param column_DigiSoft
	 *            the column_DigiSoft to set
	 */
	public void setColumn_DigiSoft(String[] column_DigiSoft) {
		this.column_DigiSoft = column_DigiSoft;
	}

	/**
	 * @return the schema_Ancestry
	 */
	public String getSchema_Ancestry() {
		return schema_Ancestry;
	}

	/**
	 * @param schema_Ancestry
	 *            the schema_Ancestry to set
	 */
	public void setSchema_Ancestry(String schema_Ancestry) {
		this.schema_Ancestry = schema_Ancestry;
	}

	/**
	 * @return the schema_DigiSoft
	 */
	public String getSchema_DigiSoft() {
		return schema_DigiSoft;
	}

	/**
	 * @param schema_DigiSoft
	 *            the schema_DigiSoft to set
	 */
	public void setSchema_DigiSoft(String schema_DigiSoft) {
		this.schema_DigiSoft = schema_DigiSoft;
	}

	/**
	 * @return the var_con
	 */
	public String getVar_con() {
		return var_con;
	}

	/**
	 * @param var_con
	 *            the var_con to set
	 */
	public void setVar_con(String var_con) {
		this.var_con = var_con;
	}

	/**
	 * @return the search_path
	 */
	public String getSearch_path() {
		return search_path;
	}

	/**
	 * @param search_path
	 *            the search_path to set
	 */
	public void setSearch_path(String search_path) {
		this.search_path = search_path;
	}

}
