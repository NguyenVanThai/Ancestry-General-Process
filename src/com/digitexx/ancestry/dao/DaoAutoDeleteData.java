/**
 * 
 */
package com.digitexx.ancestry.dao;

import java.sql.Connection;

import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.db.ConnectionDB;
import com.digitexx.ancestry.db.JdbcHelper;
import com.digitexx.ancestry.util.AncestryException;

/**
 * @author lqnhu
 *
 */
public class DaoAutoDeleteData {
	private ConnectionDB db = ConnectionDB.getInstance();
	private Tbl_Projects project;
	
	public DaoAutoDeleteData(Tbl_Projects project) {
		this.project = project;
	}
	

	/**
	 * get filepath from batch
	 */
	public String getFilePathFromBatch(String batch)throws AncestryException {
		String filepath = "";
		Connection con =null;
		try {
			String sql = "SELECT filepath FROM management WHERE filepath LIKE '%"+batch+"%' LIMIT 1";
			con  = db.getConnectByProject(project);
			filepath = JdbcHelper.queryToString(con, sql, false);
			if(filepath.equals("")) {
				sql = "SELECT filepath FROM management_rework WHERE filepath LIKE '%"+batch+"%' LIMIT 1";
				filepath = JdbcHelper.queryToString(con, sql, false);
			}
			con.commit();
		} catch (Exception e) {
			throw new AncestryException("getFilePathFromBatch : "  + e.toString(), e);
		}finally {
			JdbcHelper.close(con);
		}
		return filepath;
	}
	
	/**
	 * get project_id of customer
	 */
	public String getCustomerProjectId()throws AncestryException {
		String projectId = "";
		Connection con =null;
		try {
			String sql = "SELECT project_id FROM project_info";
			con = db.getConnectByProject(project);
			projectId = JdbcHelper.queryToString(con, sql, true);
		} catch (Exception e) {
			throw new AncestryException("getCustomerProjectId : "  + e.toString(), e);
		}finally {
			JdbcHelper.close(con);
		}
		return projectId;
	}

}
