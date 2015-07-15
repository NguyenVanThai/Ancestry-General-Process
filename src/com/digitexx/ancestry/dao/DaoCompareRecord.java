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
public class DaoCompareRecord {
	
	private ConnectionDB db = ConnectionDB.getInstance();
	
	/**
	 * get list path
	 */
	public List<String> getLisPath(Tbl_Projects project) throws AncestryException {

		List<String> lisPath = new ArrayList<String>();
		Connection con = null;
		String sql = "";
		try {
		  sql = "SELECT filepath FROM management m JOIN p1_form_n_proof p ON m.id = p.managementid "
		  	  + "GROUP BY filepath ORDER BY filepath";
		  con = db.getConnectByProject(project);
		  lisPath = JdbcHelper.queryToSingleList(con, sql,true);
			
		} catch (Exception e) {
			throw new AncestryException("getLisPath : "  + e.toString() , e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return lisPath;
	}
	

}
