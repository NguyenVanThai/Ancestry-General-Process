/**
 * 
 */
package com.digitexx.ancestry.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.db.ConnectionDB;
import com.digitexx.ancestry.db.JdbcHelper;
import com.digitexx.ancestry.util.AncestryException;

/**
 * @author lqnhu
 *
 */
public class DaoCreateRuleFinal {

	private ConnectionDB db = ConnectionDB.getInstance();

	/**
	 * get list form by project
	 */
	public List<String> getListFormByProject(Tbl_Projects project)throws AncestryException {
		List<String> listForm = new ArrayList<String>();
		Connection con = null;
        String sql = "";		
	    try {
			sql = "SELECT form_id FROM form_info WHERE is_key = true order by form_id";
			con = db.getConnectByProject(project);
			listForm = JdbcHelper.queryToSingleList(con, sql , true);
		}
	    catch (Exception e) {
	    	throw new AncestryException("getListFormByProject : "  + e.toString() , e);
		}
	    finally {
	    	JdbcHelper.close(con);
	    }
		return listForm;
	}
	
	/**
	 * get list path by project
	 */
	public List<String> getListPathByForm(Tbl_Projects project , int formid , boolean isRework)throws AncestryException {
		List<String> listForm = new ArrayList<String>();
		Connection con = null;
        String sql = "";	
        String table = "";
	    try {
	    	if(!isRework) {
	    		table = "management";
	    	}else {
	    		table = "management_rework";
	    	}
			sql = "SELECT DISTINCT(filepath) FROM " + table + " WHERE formid ="+formid+"";
			con = db.getConnectByProject(project);
			listForm = JdbcHelper.queryToSingleList(con, sql , true);
		}
	    catch (Exception e) {
	    	throw new AncestryException("getListPathByForm : "  + e.toString() , e);
		}
	    finally {
	    	JdbcHelper.close(con);
	    }
		return listForm;
	}
	
	/**
	 * get list column
	 */
	public List<String> getListFieldByForm(Tbl_Projects project , int formid) throws AncestryException {
		List<String> listField = new ArrayList<String>();
		List<String> listTmp = new ArrayList<String>();
		Connection con = null;
        String sql = "";
	    try {
			con = db.getConnectByProject(project);
			sql = "SELECT detail_field FROM fieldnamelist WHERE form_id = "+formid+"";
			listTmp = JdbcHelper.queryToSingleList(con, sql , true);
			
			String [] arrTmp;
			for (String str : listTmp)
			{
				if(str.contains(",")) 
				{
					arrTmp = str.split(",");
					for (String field : arrTmp) {
						listField.add(field);
					}
				}else {
					listField.add(str);
				}
			}
		}
	    catch (Exception e) {
	    	throw new AncestryException("getListFieldByForm : "  + e.toString() , e);
		}
	    finally {
	    	JdbcHelper.close(con);
	    }
		return listField;
	}
}
