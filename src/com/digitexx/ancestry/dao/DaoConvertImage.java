/**
 * 
 */
package com.digitexx.ancestry.dao;

import java.sql.Connection;
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
public class DaoConvertImage {

	private Tbl_Projects project;
	private ConnectionDB db = ConnectionDB.getInstance();
	
	public DaoConvertImage(Tbl_Projects project) {
		this.project = project;
	}
	
	/**
	 * get list path from database
	 */
	public List<String> getListPathFromDatabase() throws AncestryException {
		List<String> listPath = new ArrayList<String>();
		Connection con  = null;
		try {
			String sql = "SELECT filepath FROM management GROUP BY filepath";
			con = db.getConnectByProject(project);
			listPath = JdbcHelper.queryToSingleList(con, sql , true);
		} catch (Exception e) {
			throw new AncestryException("getListPathFromDatabase : "  + e.toString(),e);
		}finally {
			JdbcHelper.close(con);
		}
		return listPath;
	}
	
	/**
	 * get list filename bt filepath from database
	 */
	public List<String> getListFileNameByPath(String path) throws AncestryException {
		List<String> listPath = new ArrayList<String>();
		Connection con  = null;
		try {
			String sql = "SELECT filepath , filename FROM management WHERE filepath ='"+path+"' ORDER BY filename";
			con = db.getConnectByProject(project);
			listPath = JdbcHelper.queryToSingleList(con, sql , true);
		} catch (Exception e) {
			throw new AncestryException("getListPathFromDatabase : "  + e.toString(),e);
		}finally {
			JdbcHelper.close(con);
		}
		return listPath;
	}
}
