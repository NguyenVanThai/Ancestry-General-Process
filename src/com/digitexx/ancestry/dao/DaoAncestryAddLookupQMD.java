/**
 * 
 */
package com.digitexx.ancestry.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.db.BeanProcessor;
import com.digitexx.ancestry.db.ConnectionDB;
import com.digitexx.ancestry.db.JdbcHelper;
import com.digitexx.ancestry.util.AncestryException;

/**
 * @author lqnhu
 *
 */
public class DaoAncestryAddLookupQMD {

	private BeanProcessor beanProcessor = new BeanProcessor();
	private ConnectionDB db = ConnectionDB.getInstance();
	
	/**
	 * get list table name by project
	 */
	public List<String> getListTableName(Tbl_Projects selectProject) throws AncestryException {

		List<String> listTable = new ArrayList<String>();
		Connection con = null;
		String sql = "";
		try {
			sql = "SELECT table_name FROM information_schema.tables WHERE table_schema ='"+selectProject.getProj_schema()+"' order by table_name";
			con = db.getConnectByProject(selectProject);
			listTable = JdbcHelper.queryToSingleList(con, sql,true);
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
	 * get all project Ancestry on PMS
	 */
	public LinkedHashMap<String, Tbl_Projects> getListProjectAncestryPMS(String host) {

		List<Tbl_Projects> listProject = new ArrayList<Tbl_Projects>();
        LinkedHashMap<String, Tbl_Projects> mapProject = new LinkedHashMap<String, Tbl_Projects>();
        Connection con = null;
        ResultSet rs = null;
        String sql = "";
        try 
        {
			sql = "SELECT p.* FROM tbl_projects AS p  where proj_name like '%Ancestry%' AND proj_prjstatus_id =1 ORDER BY proj_name";
			con = db.getConPMSByHost(host);
			rs = JdbcHelper.queryToResultset(con, sql);
			listProject = beanProcessor.toBeanList(rs, Tbl_Projects.class);
			
			String projectName ="";
			for (Tbl_Projects project : listProject) 
			{
				projectName = project.getProj_name();
				if(projectName.indexOf("_for_QC") == -1) {
					mapProject.put(project.getProj_name(), project);
				}
			}
			
		} catch (Exception e) {
			JdbcHelper.error(e, con);
		}
        finally {
        	JdbcHelper.closeRS(rs);
        	JdbcHelper.close(con);
        }
		
		return mapProject;
	}
	
	/**
	 * get array column name
	 */
	public String[] getArrayColumName(String table , Tbl_Projects project) throws Exception{
		String [] arr = null;;
		Connection con = null;
		try {
			con = db.getConnectByProject(project);
			List<String> listTmp = JdbcHelper.getListColumnOfTable(con, table);
			listTmp.add("Check");
			int size = listTmp.size();
			
			arr = new String [size];
			for (int i = 0; i <size; i++) {
				arr[i] = listTmp.get(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
		}finally {
			JdbcHelper.close(con);
		}
		return arr;
	}
	
	/**
	 * get list data by table
	 */
	public List<LinkedHashMap<String, Object>> getListDataByTable( String tableName ,Tbl_Projects project , String projectName , boolean isRight) throws Exception
	{
		List<LinkedHashMap<String, Object>> listData = new ArrayList<LinkedHashMap<String, Object>>();
		LinkedHashMap<String, Object> mapTmp;
		ResultSet rs = null;
		Connection con = null;
		String sql = "";
		try {
			if(!isRight) {
				sql = "SELECT p.* FROM "  + tableName + " p ORDER BY 1" ;
			}else {
				sql = "SELECT p.* FROM "  + tableName + " p WHERE project='"+projectName+"' ORDER BY 1" ;
			}
			con = db.getConnectByProject(project);
			rs = JdbcHelper.queryToResultset(con, sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			while(rs.next()) 
			{
				mapTmp = new LinkedHashMap<String, Object>();
				for (int i = 1; i < rsmd.getColumnCount()+1; i++) {
					mapTmp.put(rsmd.getColumnName(i), rs.getObject(rsmd.getColumnName(i)));
				}
				mapTmp.put("Check", Boolean.FALSE);
				listData.add(mapTmp);
			}
		} 
		catch (Exception e) {
			con.rollback();
			e.printStackTrace();
		}
		finally {
			JdbcHelper.closeRS(rs);
			JdbcHelper.close(con);
		}
		return listData;
	}
	
	/**
	 * save data
	 */
	public boolean saveData(Tbl_Projects project,List<LinkedHashMap<String, Object>> listMapData , String tableName)throws Exception
	{
		boolean flag = false;
		Connection con = null;
		try {
			con  = db.getConnectByProject(project);
	        flag = JdbcHelper.saveListMap(con, tableName, listMapData);
		} 
		catch (Exception e) {
			JdbcHelper.rollback(con);
			e.printStackTrace();
			throw new Exception("saveData : "  + e.toString());
		}
		finally {
			JdbcHelper.close(con);
		}
		return flag;
	}
	
	
}
