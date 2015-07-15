/**
 * 
 */
package com.digitexx.ancestry.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.digitexx.ancestry.bean.Management;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.db.BeanProcessor;
import com.digitexx.ancestry.db.ConnectionDB;
import com.digitexx.ancestry.db.JdbcHelper;
import com.digitexx.ancestry.util.AncestryException;
import com.digitexx.ancestry.util.StringUtil;

/**
 * @author lqnhu
 *
 */
public class DaoPanelViewPathByUser {

    private String management = "";
    private String proof      = "";
    private Tbl_Projects project;
    private BeanProcessor beanProcessor;
    
	private ConnectionDB db = ConnectionDB.getInstance();	public DaoPanelViewPathByUser(Tbl_Projects project) {
		this.project = project;
	    this.management   = "";
	    this.proof        = "";
	    this.beanProcessor = new BeanProcessor();
	}
	
	/**
	 * set table
	 */
	public void setTable(boolean isRework) {
        if(isRework) {
        	management = "management_rework";
        	proof      = "p1_form_n_proof_rework";
        }else {
        	management = "management";
        	proof      = "p1_form_n_proof";
        }
	}
	
	/**
	 * get list users
	 */
	public List<String> getListUser(boolean isRework) throws AncestryException{

		List<String> listPath = new ArrayList<String>();
		Connection con = null;
		String sql = "";
		try {
			if(isRework) {
				sql = "SELECT distinct(user_type) FROM p1_form_n_proof_rework";
			}else {
				sql = "SELECT distinct(user_type) FROM p1_form_n_proof";
			}
            con = db.getConnectByProject(project);
            listPath = JdbcHelper.queryToSingleList(con, sql ,true);
		}
		catch (Exception e) {
			throw new AncestryException("getListUser : "  + e.toString() ,e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listPath;
	}
	
	/**
	 * get list fields
	 */
	public List<String> getListField() throws AncestryException{

		List<String> listPath = new ArrayList<String>();
		Connection con = null;
		String sql = "";
		try {
            sql = "SELECT fieldname FROM fieldnamelist group by fieldname";
            con = db.getConnectByProject(project);
            listPath = JdbcHelper.queryToSingleList(con, sql , true);
		}
		catch (Exception e) {
			throw new AncestryException("getListField  : "  + e.toString() , e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listPath;
	}
	
	/**
	 * get list users
	 */
	public List<String> getListPathByUser( String user_type , boolean isRework) throws AncestryException{
        setTable(isRework);
		List<String> listPath = new ArrayList<String>();
		Connection con = null;
		String sql = "";
		try {
			if(!isRework) {
				sql = "SELECT filepath FROM management m join p1_form_n_proof p ON m.id = p.managementid "
						+ "WHERE p.user_type ='"+user_type+"' AND step =4 GROUP BY filepath";
			}else {
				sql = "SELECT filepath FROM management_rework m join p1_form_n_proof_rework p ON m.id = p.managementid "
						+ "WHERE p.user_type ='"+user_type+"' AND step =4 GROUP BY filepath";
			}
            con = db.getConnectByProject(project);
            listPath = JdbcHelper.queryToSingleList(con, sql , true);
		}
		catch (Exception e) {
			throw new AncestryException("getListPathByUser : "  + e.toString() ,e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listPath;
	}
	
	/**
	 * get list management by filepath
	 */
	public List<Management> getListIdByFilePath(String filepath , String user , boolean isRework) throws AncestryException {
		setTable(isRework);
		List<Management> listIds = new ArrayList<Management>();
		Connection con = null;
		ResultSet rs=  null;
		try {
			String sql = "";
			if(!isRework) {
				sql = "SELECT m.* FROM management m JOIN p1_form_n_proof p ON m.id = p.managementid "
						+ " WHERE filepath='"+filepath+"' AND step =4 AND p.user_type ='"+user+"' GROUP BY m.id ORDER BY m.id";
			}else {
				sql = "SELECT m.* FROM management_rework m JOIN p1_form_n_proof_rework p ON m.id = p.managementid "
						+ " WHERE filepath='"+filepath+"' AND step =4 AND p.user_type ='"+user+"' GROUP BY m.id ORDER BY m.id";
			}
			con = db.getConnectByProject(project);
			rs = JdbcHelper.queryToResultset(con, sql);
			listIds = beanProcessor.toBeanList(rs, Management.class);
		}
		catch (Exception e) {
			throw new AncestryException("getListIdByFilePath : " + e.toString(),e );
		}finally {
			JdbcHelper.closeRS(rs);
			JdbcHelper.close(con);
		}
		return listIds;
	}
	
	/**
	 * get list management by filepath
	 */
	public String getListManagementIdByFilePath(String filepath , String user , boolean isRework) throws AncestryException {
		setTable(isRework);
		String ids = "";
		Connection con = null;
		try {
			String sql = "";
			if(!isRework) {
				sql = "SELECT m.id FROM management m JOIN p1_form_n_proof p ON m.id = p.managementid "
						+ " WHERE filepath='"+filepath+"' AND step =4 AND p.user_type ='"+user+"' GROUP BY m.id ORDER BY m.id";
			}else {
				sql = "SELECT m.id FROM management_rework m JOIN p1_form_n_proof_rework p ON m.id = p.managementid "
						+ " WHERE filepath='"+filepath+"' AND step =4 AND p.user_type ='"+user+"' GROUP BY m/id ORDER BY m.id";
			}
			con = db.getConnectByProject(project);
			List<String> listId = JdbcHelper.queryToSingleList(con, sql , true);
			ids = StringUtil.join(listId, ",");
		}
		catch (Exception e) {
			throw new AncestryException("getListManagementIdByFilePath : " + e.toString(),e );
		}finally {
			JdbcHelper.close(con);
		}
		return ids;
	}
	
	
}
