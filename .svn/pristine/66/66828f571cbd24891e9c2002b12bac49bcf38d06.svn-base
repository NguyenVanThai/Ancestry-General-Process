/**
 * 
 */
package com.digitexx.ancestry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.db.ConnectionDB;
import com.digitexx.ancestry.db.JdbcHelper;
import com.digitexx.ancestry.util.StringUtil;

/**
 * @author lqnhu
 *
 */
public class DaoSupportMoveData {

	private ConnectionDB db = ConnectionDB.getInstance();

	/**
	 * get list table name by project
	 */
	public List<String> getListTableName(Tbl_Projects project) throws Exception {

		List<String> listTable = new ArrayList<String>();
		Connection con = null;
		String sql = "";
		try {
			sql = "SELECT table_name FROM information_schema.tables WHERE table_schema ='"+project.getProj_schema()+"' order by table_name";
			con = db.getConnectByProject(project);
			listTable = JdbcHelper.queryToSingleList(con, sql , true);
		} 
		catch (Exception e) {
			con.rollback();
			e.printStackTrace();
		}
		finally {
			JdbcHelper.close(con);
		}
		return listTable;
		
	}
	
	/**
	 * get list data by table
	 */
	public List<LinkedHashMap<String, Object>> getListDataByTable(Tbl_Projects project , String tableName , boolean isLeft) throws Exception
	{
		List<LinkedHashMap<String, Object>> listData = new ArrayList<LinkedHashMap<String, Object>>();
		LinkedHashMap<String, Object> mapTmp;
		ResultSet rs = null;
		Connection con = null;
		String sql = "";
		try {
			sql = "select p.* from "  + tableName + " p order by 1" ;
			if(isLeft) {
				con = db.getConnectByProjectDB10(project);
			}else {
				con = db.getConnectByProject(project);
			}
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
	public boolean saveData(List<LinkedHashMap<String, Object>> listMapData ,
			                Tbl_Projects project ,
			                String tableName ,
			                int nextId ,
			                String colunNameId) throws Exception
	{
		boolean flag = false;
		Connection con = null;
		try {
			con  = db.getConnectByProject(project);
	        flag = JdbcHelper.saveListMapWithId(con, tableName, listMapData , nextId , colunNameId);
		} 
		catch (Exception e) {
			JdbcHelper.rollback(con);
			e.printStackTrace();
			throw e;
		}
		finally {
			JdbcHelper.close(con);
		}
		return flag;
	}
	
	/**
	 * save data
	 */
	public boolean saveDataWithId(List<LinkedHashMap<String, Object>> listMapData ,Tbl_Projects project ,String tableName) throws Exception
	{
		boolean flag = false;
		Connection con = null;
		try {
			con  = db.getConnectByProject(project);
	        flag = JdbcHelper.saveListMap(con ,tableName ,listMapData);
		} 
		catch (Exception e) {
			JdbcHelper.rollback(con);
			e.printStackTrace();
			throw e;
		}
		finally {
			JdbcHelper.close(con);
		}
		return flag;
	}
	
	/**
	 * delete field
	 */
	public boolean delete(Tbl_Projects project ,List<String> listId , String table) throws Exception {

		boolean flag = true;
		Connection con = null;
		PreparedStatement pst =null;
		String sql = "";
		try {
			String [] arrTableIgnore = new String [] { "p1_form_n_proof" , "p1_form_n_proof_history" , "p1_form_n_proof_rework" ,
					                                   "p1_form_n_type"  , "temp_p1_form_n_proof" , "management" , "management_rework"};
			List listTableIgnore = Arrays.asList(arrTableIgnore);
			if(!listTableIgnore.contains(table)) {
				sql = "DELETE FROM "+table+" WHERE id =?";
				con = db.getConnectByProject(project);
				pst = con.prepareStatement(sql);
				
				for (String id : listId) {
					pst.setLong(1, Long.parseLong(id));
					pst.execute();
				}
				con.commit();
			}

		}
		catch (Exception e) {
			JdbcHelper.rollback(con);
			flag = false;
			e.printStackTrace();
		}
		finally {
			JdbcHelper.closePS(pst);
			JdbcHelper.close(con);
		}
		return flag;
	}
	
	public int getNextId(Tbl_Projects project , String tableName) throws Exception
	{
		int tabOther = 1;
		String sql ="";
		Connection con = null;
		try {
			sql = "SELECT max(id) FROM "+tableName+"";
			con = db.getConnectByProject(project);
			String result = StringUtil.setNotNull(JdbcHelper.queryToObject(con, sql));
			if(!result.equals("")) {
				tabOther = Integer.parseInt(result) +1;
			}
		} 
		catch (Exception e) {
			JdbcHelper.rollback(con);
			e.printStackTrace();
		}
		finally {
			JdbcHelper.close(con);
		}
		return tabOther;
	}
}
