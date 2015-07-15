/**
 * 
 */
package com.digitexx.ancestry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.conts.TableName;
import com.digitexx.ancestry.db.BeanProcessor;
import com.digitexx.ancestry.db.ConnectionDB;
import com.digitexx.ancestry.db.JdbcHelper;
import com.digitexx.ancestry.util.AncestryException;

/**
 * @author lqnhu
 *
 */
public class DaoJobInformation {

	private ConnectionDB db = ConnectionDB.getInstance();
	private BeanProcessor beanProcessor = new BeanProcessor();
	
	/**
	 * check exist table phase
	 */
	public boolean checkExistTablePhase(Tbl_Projects project) throws AncestryException {
		boolean flag = false;
		Connection con  =null;
		ResultSet rs = null;
		try {
			String sql = "SELECT true FROM pg_tables WHERE tablename = 'phases' AND schemaname = '"+project.getProj_schema()+"'";
			con = db.getConnectByProject(project);
			rs = JdbcHelper.queryToResultset(con, sql);
			if(rs != null) {
				if(rs.next()) {
					flag = rs.getBoolean(1);
				}
			}

		}
		catch (Exception e) {
			flag = false;
			throw new AncestryException("checkExistTablePhase : "  + e.toString() , e);
		}finally {
			JdbcHelper.closeRS(rs);
			JdbcHelper.close(con);
		}
		return flag;
	}
	
	/**
	 * get list project
	 */
	public Map<String , Tbl_Projects> getListProject(List<String> listProjectConfig) throws AncestryException{
		Map<String , Tbl_Projects> mapProject = new HashMap<String, Tbl_Projects>();
		List<Tbl_Projects> listProject = new ArrayList<Tbl_Projects>();
		Connection con =null;
		PreparedStatement pst =null;
		ResultSet rs = null;
		try {
			String sql = "SELECT proj_id , proj_name ,proj_serverip , proj_dbname , proj_schema , proj_uid, proj_pwd "
					   + " FROM tbl_projects WHERE proj_name in (%s)";
			
			sql = String.format(sql, JdbcHelper.preparePlaceHolders(listProjectConfig.size()));
			con = db.getConPMSByHost(ConnectionDB.host);
			pst = con.prepareStatement(sql);
			JdbcHelper.setValues(pst, listProjectConfig.toArray());
			rs = pst.executeQuery();
			
			listProject = beanProcessor.toBeanList(rs, Tbl_Projects.class);
			for (Tbl_Projects project : listProject) {
				mapProject.put(project.getProj_name(), project);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new AncestryException("getListProject : "  + e.toString(),e);
		}finally {
			JdbcHelper.closeRS(rs);
			JdbcHelper.closePS(pst);
			JdbcHelper.close(con);
		}
		return mapProject;
	}
	
	/**
	 * get data by project
	 */
	public List<Object[]> getListManagementByProject(Tbl_Projects project , boolean isPJM , String username , boolean isRework , boolean hasTablePhase) throws AncestryException {
		List<Object[]> listJobInfo = new ArrayList<Object[]>();
		Connection con = null;
		String sql = "";
		String table = "";
		try {
			if(isRework) {
				table = TableName.management_rework;
			}else {
				table = TableName.management;
			}
			if(hasTablePhase) {
				if(isPJM) {
					sql = "SELECT phase_name , formid , m.id , m.filepath , filename , step , present_user ,record_status "
						+ "FROM "+table+" m LEFT JOIN phases p ON m.filepath = p.filepath where step <> 4 AND record_status = 1  AND badimage = 0 "
						+ "AND formid in ( SELECT form_id FROM form_info WHERE is_key )"
						+ " GROUP BY phase_name , formid , m.id , m.filepath , filename , step , present_user ,record_status "
						+ "ORDER BY m.id";
				}else {
					sql = "SELECT phase_name , formid , m.id  , step , present_user "
						+ "FROM "+table+" m LEFT JOIN phases p ON m.filepath = p.filepath where step <> 4 and badimage = 0 and present_user ='"+username+"' "
						+ " GROUP BY phase_name , formid , m.id , step , present_user "
						+ "ORDER BY m.id";
				}
			}else {
				if(isPJM) {
					sql = "SELECT  formid , id , filepath , filename , step , present_user ,record_status "
						+ "FROM "+table+" WHERE step <> 4 AND record_status = 1  AND badimage = 0 ";
				}else {
					sql = "SELECT  formid , id , step , present_user  "
							+ "FROM "+table+" WHERE step <> 4 AND record_status = 1  AND badimage = 0 AND present_user ='"+username+"'";
				}
			}


			con = db.getConnectByProject(project);
			listJobInfo = JdbcHelper.queryToListObject(con, sql);
		} 
		catch (Exception e) {
			throw new AncestryException("getListManagementByProject : "  + e.toString(),e);
		}finally {
			JdbcHelper.close(con);
		}
		return listJobInfo;
	}
}
