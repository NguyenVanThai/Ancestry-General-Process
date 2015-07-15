/**
 * 
 */
package com.digitexx.ancestry.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.db.ConnectionDB;
import com.digitexx.ancestry.db.JdbcHelper;
import com.digitexx.ancestry.util.AncestryException;
import com.digitexx.ancestry.util.StringUtil;

/**
 * @author lqnhu
 *
 */
public class DaoImportExportLookup {

    private Tbl_Projects project;
    private ConnectionDB db = ConnectionDB.getInstance();
    
	public DaoImportExportLookup(Tbl_Projects project) {
		this.project = project;
	}
	
	public List<String> getListTableName() throws AncestryException {

	    List<String> listTable = new ArrayList<String>();
		Connection con = null;
		String sql = "";
		try {
			sql = "SELECT table_name FROM information_schema.tables WHERE table_schema ='"+project.getProj_schema()+"' order by table_name";
			con = db.getConnectByProject(project);
			listTable = JdbcHelper.queryToSingleList(con, sql , true);
		} 
		catch (Exception e) {
			throw new AncestryException("getListTableName : "  + e.toString() , e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listTable;
		
	}
	
	/**
	 * get list column by table
	 */
	public List<String> getListColumnByTable(String tableName) throws AncestryException {
		List<String> listColumn = new ArrayList<String>();
		Connection con = null;
		try {
			con = db.getConnectByProject(project);
			listColumn = JdbcHelper.getListColumnOfTable(con, tableName);
			listColumn.remove("land");
			listColumn.remove("anrede");
			listColumn.remove("ext");
			listColumn.remove("note");
		} catch (Exception e) {
			throw new AncestryException("getListColumnByTable : "  + e.toString(),e);
		}finally {
			JdbcHelper.close(con);
		}
		return listColumn;
	}
	
	/**
	 * get list column by table
	 */
	public List<String> getListField() throws AncestryException {
		List<String> listColumn = new ArrayList<String>();
		Connection con = null;
		try {
			String sql = "SELECT DISTINCT(fieldname) FROM fieldnamelist where searchtype = 7";
			con = db.getConnectByProject(project);
			listColumn = JdbcHelper.queryToSingleList(con, sql,true);
		} catch (Exception e) {
			throw new AncestryException("getListField : "  + e.toString(),e);
		}finally {
			JdbcHelper.close(con);
		}
		return listColumn;
	}
	
	/**
	 * get list data by table
	 */
	public List<Object[]> getListDataByTable(Tbl_Projects project , String tableName) throws AncestryException
	{
		List<Object[]> listData = new ArrayList<Object[]>();
		Connection con = null;
		String sql = "";
		try {
			sql = "select p.* from "  + tableName + " p order by 1" ;
			con = db.getConnectByProject(project);
			listData  = JdbcHelper.queryToListObject(con, sql);
		} 
		catch (Exception e) {
			throw new AncestryException("getListDataByTable : "  + e.toString(),e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listData;
	}
	
	
	/**
	 * check existed data when import
	 */
	public String getMaxId(String table)throws AncestryException {
		String result = "";
		Connection con = null;
		try {
			String sql = "SELECT MAX(id) FROM " +  table;
			con = db.getConnectByProject(project);
			result = StringUtil.setNotNull(JdbcHelper.queryToString(con, sql, false));
			if(result.equals("")) {
				result = "1";
			}else {
				result = (Integer.parseInt(result)+1)+"";
			}
		} catch (Exception e) {
			throw new AncestryException("getMaxId : "  + e.toString() , e);
		}finally {
			JdbcHelper.close(con);
		}
		return result;
	}
	
	/**
	 * check existed data when import
	 */
	public boolean checkExistedValue( Connection con ,String column ,String value , String fieldName , String table)throws AncestryException {

		boolean flag = true;
		String sql = "";
		try {
			value = StringUtil.getReplaceChar(value);
			if(fieldName.equals("")) {
				sql = "SELECT "  + column + " FROM "  + table + " WHERE " + column + " ='"+value+"'";
			}else {
				sql = "SELECT "  + column + " FROM "  + table + " WHERE " + column + " ='"+value+"' and field ='"+fieldName+"'";
			}
			String result = StringUtil.setNotNull(JdbcHelper.queryToString(con, sql, false));
            if(result.equals("")) {
            	flag = false;
            }else {
            	flag = true;
            }
		} catch (Exception e) {
			throw new AncestryException("checkExistedValue : "  + e.toString() , e);
		}
		return flag;
	}
	
	/**
	 * save data lookup
	 */
	public boolean saveDataLookup(String table , List<LinkedHashMap<String, Object>> listData , boolean isLookupByField , String columnLookupByField , String columnCheckExistValue) throws AncestryException {
		boolean flag = false;
		Connection con = null;
		try {
			con = db.getConnectByProject(project);
			String data = "";
		    for (LinkedHashMap<String, Object> mapTmp : listData) 
		    {
		    	boolean check = false;
		    	data = StringUtil.setNotNull(mapTmp.get(columnCheckExistValue));
		    	if(!data.equals("")){
		    		if(!isLookupByField) {
		    			check = checkExistedValue(con , columnCheckExistValue , data.toLowerCase() ,"" , table);
		    		}else {
		    			check = checkExistedValue(con , columnCheckExistValue , data.toLowerCase() , columnLookupByField , table);
		    		}
		    		if(!check){
		    			flag = JdbcHelper.saveMap(con, table, mapTmp);
		    		}
		    	}

			}
		} catch (Exception e) {
			throw new AncestryException("saveDataLookup : "  + e.toString(), e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return flag;
	}
	
	
	
	
}
