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

/**
 * @author lqnhu
 *
 */
public class DaoTranferData {
	
	private ConnectionDB db = ConnectionDB.getInstance();
	
	public List<String> getListField(Tbl_Projects project) throws Exception
	{
		Connection con = null;
		List<String> listField = new ArrayList<String>();
		try {
			String sql = "SELECT table_name FROM information_schema.tables WHERE table_schema = '"+project.getProj_schema()+"'";
			con = db.getConnectByProject(project);
			listField = JdbcHelper.queryToSingleList(con, sql , true);
		}
		catch (Exception e) {
			JdbcHelper.rollback(con);
			e.printStackTrace();
			throw e;
		} 
		finally {
			JdbcHelper.close(con);
		}
		return listField;		
	}	
	

}
