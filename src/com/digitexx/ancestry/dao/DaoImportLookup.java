/**
 * 
 */
package com.digitexx.ancestry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.conts.TableName;
import com.digitexx.ancestry.db.ConnectionDB;
import com.digitexx.ancestry.db.JdbcHelper;
import com.digitexx.ancestry.util.AncestryException;
import com.digitexx.ancestry.util.AppUtility;
import com.digitexx.ancestry.util.ReadTxtUtil;
import com.digitexx.ancestry.util.StringUtil;

/**
 * @author lqnhu
 *
 */
public class DaoImportLookup {

	private ConnectionDB db = ConnectionDB.getInstance();
	private Tbl_Projects project;
	private String management = "";
	private String proof      = "";
	private List<String> listField = new ArrayList<String>();
	private Map<String, List<String>> mapLookup = new HashMap<String, List<String>>();
	
	public DaoImportLookup(Tbl_Projects project) {
		this.project = project;
	}
	
	public void setTable(boolean isRework) {
        if(!isRework) {
        	management = TableName.management;
        	proof      = TableName.p1_form_n_proof;
        }else {
        	management = TableName.management_rework;
        	proof      = TableName.p1_form_n_proof_rework;
        }
	}
	
	/**
	 * get all filepath
	 */
	public List<String> getListFilePath()throws AncestryException {
		List<String> listPath = new ArrayList<String>();
		Connection con =null;
		String sql = "";
		try {
			sql = "SELECT filepath FROM " + management + " WHERE step =4 GROUP BY 1 ORDER BY 1";
			con = db.getConnectByProject(project);
			listPath = JdbcHelper.queryToSingleList(con, sql, true);
		} catch (Exception e) {
			throw new AncestryException("getListFilePath : "  + e.toString() ,e);
		}finally {
			JdbcHelper.close(con);
		}
		return listPath;
		
	}
	
	public int getNumberLookup()throws AncestryException {
		int kq = 0;
		Connection con =null;
		String sql = "";
		try {
			sql = "SELECT number_lookup FROM project_info GROUP BY 1 ORDER BY 1";
			con = db.getConnectByProject(project);
			//kq = JdbcHelper.queryToSingleList(con, sql);
			String result = StringUtil.setNotNull(JdbcHelper.queryToObject(con, sql));
			if(!result.equals("")) {
				kq = Integer.parseInt(result);
			}
		} catch (Exception e) {
			throw new AncestryException("getListFilePath : "  + e.toString() ,e);
		}finally {
			JdbcHelper.close(con);
		}
		return kq;
		
	}
	
//	public List<String> loadField() {
//		try {
//			String path = ReadTxtUtil.getPathOfFile("/config/FieldLookup.txt");
//			listField = ReadTxtUtil.readList(path);
//			if(listField.size() == 0) {
//				AppUtility.msgError(null, "Not found file : FieldLookup.txt  !!");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			AppUtility.msgError(null, "loadPjm : "  + e.toString());
//		}
//		return listField;
//	}
	
	public Map<String,List<String>> loadFieldLookup() {
		try {
			String path = ReadTxtUtil.getPathOfFile("/config/FieldLookup.txt");
			mapLookup = ReadTxtUtil.readMap(path);
			if(mapLookup.size() == 0) {
				AppUtility.msgError(null, "Not found file : FieldLookup.txt  !!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(null, "loadPjm : "  + e.toString());
		}
		//System.out.println("ggggg : "+mapLookup.keySet());
		return mapLookup;
	}
	
	/**
	 * get list field anrede or status_given
	 */
	public List<String> getListField()throws AncestryException {
		List<String> listPath = new ArrayList<String>();
		Connection con =null;
		try {
			con = db.getConnectByProject(project);
			listPath = JdbcHelper.getListColumnOfTable(con, proof);
		} catch (Exception e) {
			throw new AncestryException("getListFilePath : "  + e.toString() ,e);
		}finally {
			JdbcHelper.close(con);
		}
		return listPath;
	}
	
	
	/**
	 * get list data for check
	 */
	public List<String> getListDataCheck()throws AncestryException {
		List<String> listData = new ArrayList<String>();
		Connection con = null;
		String sql = "";
		try {
			sql = "SELECT anrede_given_lower FROM ancestry_anrede_status_given WHERE status_given = 1";
			con = db.getConnectAncestryQC(project);
			listData = JdbcHelper.queryToSingleList(con, sql, true);
		} catch (Exception e) {
			throw new AncestryException("getListDataCheck : "  + e.toString(), e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listData;
	}
	
	/**
	 * get Map data for check anrede
	 */
	public Map<String, String> getMapCheckAnrede() throws AncestryException{
		Map<String, String> mapData = new HashMap<String, String>();
		PreparedStatement pst = null;
		Connection con = null;
		ResultSet rs =null;
		try {
			String sql = "SELECT anrede , anrede_given_lower FROM ancestry_anrede_status_given WHERE anrede IS NOT NULL";
			con = db.getConnectAncestryQC(project);
			rs = JdbcHelper.statementToResultset(con, pst, sql);
			
			String anrede =  "";
			String anrede_given_lower  = "";
			while(rs.next()) {
				anrede             = StringUtil.setNotNull(rs.getString("anrede"));
				anrede_given_lower = StringUtil.setNotNull(rs.getString("anrede_given_lower"));
				mapData.put(anrede_given_lower, anrede);
			}
		} catch (Exception e) {
			throw new AncestryException("getMapCheckAnrede : "  + e.toString(), e);
		}finally {
			JdbcHelper.closeAll(rs, pst, con);
		}
		return mapData;
	}
	
	/**
	 * get list data by filepath
	 */
	public List<LinkedHashMap<String, Object>> getListDataByFilePath(String filepath , String field) throws AncestryException{
		List<LinkedHashMap<String, Object>> listData = new ArrayList<LinkedHashMap<String , Object>>();
		Connection con = null;
		String sql = "";
		try {
			sql = "SELECT p.id , "+ field +" FROM "  + management + " m JOIN "  + proof +  " p ON m.id = p.managementid and filepath='"+filepath+"'";
			con = db.getConnectByProject(project);
			listData = JdbcHelper.queryToListLinkMap(con, sql);
		} catch (Exception e) {
			throw new AncestryException("getListDataByFilePath : "  + e.toString(), e);
		}finally {
			JdbcHelper.close(con);
		}
		return listData;
	}
	
	
	public ArrayList<String> getListColumnTable(String table)throws AncestryException {
		ArrayList<String> listPath = new ArrayList<String>();
		Connection con =null;
		try {
			con = db.getConnectByProject(project);
			
			listPath = JdbcHelper.getListColumnOfTable(con, table);
		} catch (Exception e) {
			throw new AncestryException("getListFilePath : "  + e.toString() ,e);
		}finally {
			JdbcHelper.close(con);
		}
		return listPath;
	}
	
	public ArrayList<String> getListColumnTableLookup(Connection con,String table,boolean isCommit)throws AncestryException {
		ArrayList<String> listPath = new ArrayList<String>();
		//Connection con =null;
		try {
			//con = db.getConnectByProject(project);
			
			listPath = JdbcHelper.getListColumnOfTableLookup(con, table,isCommit);
		} catch (Exception e) {
			throw new AncestryException("getListFilePath : "  + e.toString() ,e);
		}finally {
			//JdbcHelper.close(con);
		}
		return listPath;
	}
	/**
	 * insert data
	 */
	public boolean insertLookup(Connection con,ArrayList<String> listData, ArrayList<String> listColumn, String table, boolean isCommit)throws AncestryException {
        boolean flag = false;
        try {
			flag = JdbcHelper.executeInsert(con, table, listColumn, listData, isCommit);
		} catch (Exception e) {
			throw new AncestryException("updateStatusGiven  : "  + e.toString(), e);
		}
        finally {
        }
        return flag;
	}
	
	public List<String> getListDataLookup(Connection con,String field, String tableLookup, String fieldadd, String ad, boolean isCommit)throws AncestryException {
		List<String> listData = new ArrayList<String>();
		String sql = "";
		try {
			if(tableLookup.equals("lookup_by_field")){
				sql = "SELECT * FROM sp_get_data_lookup('"+field+"','"+proof+"','"+
						tableLookup+"','"+project.getProj_schema()+"','"+fieldadd+"','"+ad+"')";
			}else{
				sql = "SELECT * FROM sp_get_data_lookup('"+field+"','"+proof+"','"+tableLookup+"','"+project.getProj_schema()+"','"+fieldadd+"')";
			}
			listData = JdbcHelper.queryToSingleList(con, sql , isCommit);
		} catch (Exception e) {
			throw new AncestryException("getListDataCheck : "  + e.toString(), e);
		}
		finally {
		}
		return listData;
	}
	
	public int getMaxId(Connection con,String tableLookup, boolean isCommit)throws AncestryException {
		int kq = 0;
		//Connection con =null;
		String sql = "";
		try {
			sql = "SELECT id FROM "+tableLookup+" ORDER BY id DESC LIMIT 1";
			//con = db.getConnectByProject(project);
			//kq = JdbcHelper.queryToSingleList(con, sql);
			String result = StringUtil.setNotNull(JdbcHelper.queryToObjectLookup(con, sql,isCommit));
			if(!result.equals("")) {
				kq = Integer.parseInt(result);
			}
		} catch (Exception e) {
			throw new AncestryException("getMaxId : "  + e.toString() ,e);
		}finally {
			//JdbcHelper.close(con);
		}
		return kq;
	}
}
