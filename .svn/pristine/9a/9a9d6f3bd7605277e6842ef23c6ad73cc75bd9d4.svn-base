/**
 * 
 */
package com.digitexx.ancestry.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.digitexx.ancestry.bean.FieldNameList;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.db.ConnectionDB;
import com.digitexx.ancestry.db.JdbcHelper;
import com.digitexx.ancestry.util.AncestryException;

/**
 * @author lqnhu
 *
 */
public class DaoUpperLowerData {

    private String management = "";
    private String proof = "";
	private Tbl_Projects project;
	private ConnectionDB db =  ConnectionDB.getInstance();
	public DaoUpperLowerData(Tbl_Projects project) {
		this.project = project;
	}
	
	/**
	 * set table
	 */
	public void setTable(boolean isRework) {
        if(isRework) {
        	management = "management_rework";
        	proof      =  "p1_form_n_proof_rework";
        }else {
        	management = "management";
        	proof      = "p1_form_n_proof";
        }
	}
	
	/**
	 * get list paths
	 */
	public List<String> getListPath( ) throws AncestryException{

		List<String> listPath = new ArrayList<String>();
		Connection con = null;
		String sql = "";
		try {
            sql = "SELECT filepath FROM " + management + " GROUP BY filepath ORDER BY filepath";
            con = db.getConnectByProject(project);
            listPath = JdbcHelper.queryToSingleList(con, sql , true);
		}
		catch (Exception e) {
			throw new AncestryException("getListPath : "  + e.toString() ,e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listPath;
	}
	
	/**
	 * get list field
	 */
	public List<String> getListColumn() throws AncestryException{

		List<String> listPath = new ArrayList<String>();
		Connection con = null;
		try {
            con = db.getConnectByProject(project);
            listPath = JdbcHelper.getListColumnOfTable(con, proof);
		}
		catch (Exception e) {
			throw new AncestryException("getListField : "  + e.toString() ,e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listPath;
	}
	
	public List<String> getListNonUpper() throws AncestryException {
		Connection con = null;
		List<String> list = new ArrayList<String>();
		try {
			String sql = "SELECT field_value FROM list_non_upper";
			con = db.getConnectByProject(project);
			list = JdbcHelper.queryToSingleList(con, sql , true);
		} catch (Exception ex) {
			throw new AncestryException("getListNonUpper : " +  ex.toString() , ex);
		} finally {
			JdbcHelper.close(con);
		}
		return list;
	}
	
	/**
	 * get list data fo table fieldnamelist
	 */
	public List<FieldNameList> getListFieldNameList() throws AncestryException{
		List<FieldNameList> listField = new ArrayList<FieldNameList>();
		Connection con =null;
		try {
			String sql = "SELECT * FROM fieldnamelist WHERE is_valid =1 ORDER BY id";
			con = db.getConnectByProject(project);
			listField = JdbcHelper.queryToListBean(con, FieldNameList.class, sql, true);
		} catch (Exception e) {
			throw new AncestryException("getListFieldNameList : "  + e.toString(), e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listField;
	}
	
	/**
	 * get list data by field
	 */
	public List<Map<String, Object>> getListData(String field , String filepath)throws AncestryException {
		List<Map<String, Object>>listData = new ArrayList<Map<String , Object>>();
		Connection con = null;
		StringBuilder sbSql = new StringBuilder();
		try {
			sbSql.append("SELECT ");
			sbSql.append(" formid , p.id , ");
			sbSql.append(field);
			sbSql.append(" FROM ");
			sbSql.append(proof);
			sbSql.append(" p ");
			sbSql.append(" JOIN ");
			sbSql.append(management);
			sbSql.append(" m ");
			sbSql.append(" ON m.id = p.managementid ");
			sbSql.append(" and filepath ='"+filepath+"' ORDER BY p.id");
			
			con = db.getConnectByProject(project);
            listData = JdbcHelper.queryToListMap(con, sbSql.toString());
		} catch (Exception e) {
			throw new AncestryException("getListData : "  + e.toString(), e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listData;
	}
	
	/**
	 * save data
	 */
	public boolean saveData(List<Map<String , Object>> listData)throws AncestryException {
        boolean flag = false;
        Connection con = null;
        try {
			con = db.getConnectByProject(project);
			flag = JdbcHelper.updateListMap(con, "id", proof , listData, true);
		} catch (Exception e) {
			throw new AncestryException("saveData : "  + e.toString(), e);
		}
        finally {
        	JdbcHelper.close(con);
        }
        return flag;
	}
}
