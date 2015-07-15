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
public class DaoMoveDataRework {

	private Tbl_Projects project ;
    private String management = "";
	private ConnectionDB db = ConnectionDB.getInstance();
	
	public DaoMoveDataRework(Tbl_Projects project) {
	    management   = "";
		this.project     = project;
	}
	
	/**
	 * set table
	 */
	public void setTable(boolean isRework) {
        if(isRework) {
        	management = "management";
        }else {
        	management = "management_rework";
        }
	}
	
	/**
	 * get list paths
	 */
	public List<String> getListPath( boolean isRework , boolean isLoadAll) throws AncestryException{

		setTable(isRework);
		List<String> listPath = new ArrayList<String>();
		Connection con = null;
		String sql = "";
		try {
			if(!isLoadAll) {
				sql = "SELECT filepath FROM " + management + " m  JOIN form_info f ON m.formid = f.form_id GROUP BY 1 HAVING ARRAY_AGG(DISTINCT CASE WHEN badimage = 1 THEN 4 WHEN is_key THEN step ELSE 4 END)='{4}'ORDER BY 1 ";
			}else {
				sql = "SELECT filepath FROM "  + management  + " GROUP BY filepath ORDER BY filepath";
			}
            con = db.getConnectByProject(project);
            listPath = JdbcHelper.queryToSingleList(con, sql ,true);
		}
		catch (Exception e) {
            throw new AncestryException("getListPath : "  + e.toString(),e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listPath;
	}
	
	/**
	 * run query with new connection
	 */
	public boolean runQuery(Connection con ,String sql) throws AncestryException {

		boolean flag = false;
		try {
			flag = JdbcHelper.executeNonQueryNotCommit(con, sql);
		} 
		catch (Exception e) {
			flag = false;
            throw new AncestryException("runQuery : "  + e.toString(),e);
		}
		return flag;
	}
	
	public boolean moveDataFromProofToRework(String filePath) throws AncestryException
	{
		boolean flag = true;
		Connection con = null;
		try {
			con = db.getConnectByProject(project);

			String sqlInsertProofRework = "INSERT INTO p1_form_n_proof_rework "
					+ "( SELECT p.* FROM p1_form_n_proof p JOIN management m ON p.managementid = m.id WHERE m.filepath = '"+filePath+"' ) ";
			if(!runQuery(con , sqlInsertProofRework)){
				flag = false;
			}
			
			String sqlInsertProofTemp = "INSERT INTO temp_p1_form_n_proof "
					+ "( SELECT p.* FROM p1_form_n_proof p JOIN management m ON p.managementid = m.id WHERE m.filepath = '"+filePath+"' ) ";
			if(!runQuery(con , sqlInsertProofTemp)){
				flag = false;
			}
			
			String sqlDeleteProof = "DELETE FROM p1_form_n_proof WHERE managementid IN (SELECT id FROM management WHERE filepath = '"+filePath+"' ) ";
			if(!runQuery(con , sqlDeleteProof)){
				flag = false;
			}
			
			String sqlInsertManagementRework = "INSERT INTO management_rework ( SELECT * from management where filepath = '"+filePath+"' ) ";
			if(!runQuery(con , sqlInsertManagementRework)){
				flag = false;
			}
			
			String sqlInsertManagementTemp = "INSERT INTO temp_management ( SELECT * FROM management WHERE filepath = '"+filePath+"' ) ";
			if(!runQuery(con , sqlInsertManagementTemp)){
				flag = false;
			}
			
			String sqlDeleteManagement = "DELETE FROM management WHERE filepath = '"+filePath+"' ";
			if(!runQuery(con , sqlDeleteManagement)){
				flag = false;
			}
			
			if(flag) {
				con.commit();
			}
		} 
		catch (Exception e) 
		{		
			flag = false;
            throw new AncestryException("moveDataFromProofToRework : "  + e.toString(),e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return flag;
	}
	
	
	public boolean moveDataFromReworkToProof(String filePath) throws AncestryException 
	{
		boolean flag = true;
		Connection con = null;
		try {
			con = db.getConnectByProject(project);

			String sqlInsertProof = "INSERT INTO p1_form_n_proof "
					+ "( SELECT p.* FROM p1_form_n_proof_rework p JOIN management_rework m ON p.managementid = m.id WHERE m.filepath = '"+filePath+"' ) ";
			if(!runQuery(con , sqlInsertProof)){
				flag = false;
			}
			
			String sqlDeleteProofRework = "DELETE FROM p1_form_n_proof_rework WHERE managementid IN (SELECT id FROM management_rework WHERE filepath = '"+filePath+"' ) ";
			if(!runQuery(con , sqlDeleteProofRework)){
				flag = false;
			}
			
			String sqlDeleteTempProof = "DELETE FROM temp_p1_form_n_proof WHERE managementid IN (SELECT id FROM management_rework WHERE filepath = '"+filePath+"' ) ";
			if(!runQuery(con , sqlDeleteTempProof)){
				flag = false;
			}
			
			String sqlDeleteTempManagement = "DELETE FROM temp_management WHERE id IN (SELECT id FROM management_rework WHERE filepath = '"+filePath+"' ) ";
			if(!runQuery(con , sqlDeleteTempManagement)){
				flag = false;
			}
			
			String sqlInsertManagement = "INSERT INTO management ( SELECT * from management_rework where filepath = '"+filePath+"' ) ";
			if(!runQuery(con , sqlInsertManagement)){
				flag = false;
			}
			
			String sqlDeleteManagement = "DELETE FROM management_rework WHERE filepath = '"+filePath+"' ";
			if(!runQuery(con ,sqlDeleteManagement)){
				flag = false;
			}
			if(flag) {
				con.commit();
			}
		} 
		catch (Exception e) 
		{	
			flag = false;
            throw new AncestryException("moveDataFromReworkToProof : "  + e.toString(),e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return flag;
	}
	
	/**
	 * check exist table
	 */
	public boolean checkExistTable(Connection con ,String tableName) throws AncestryException {
		boolean flag = false;
		try {
			String sql = "";
		} catch (Exception e) {
			throw new AncestryException("checkExistTable : "  + e.toString(),e);
		}
		return flag;
	}
}
