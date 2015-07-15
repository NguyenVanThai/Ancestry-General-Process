package com.digitexx.ancestry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.digitexx.ancestry.bean.BeanUserPMS;
import com.digitexx.ancestry.bean.BeanUserWorking;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.db.ConnectionDB;
import com.digitexx.ancestry.db.JdbcHelper;
import com.digitexx.ancestry.util.AncestryException;

public class DaoAssignRoleForAllStep {

	private ConnectionDB db = ConnectionDB.getInstance();
	private Tbl_Projects project;
	public DaoAssignRoleForAllStep(Tbl_Projects project) {
		this.project = project;
	}
	

	/**
	 * get list all user pjm
	 */
	public List<String> getListUserPJMPMS()throws AncestryException {
		List<String> listAllUserPJM = new ArrayList<String>();
		String sql = "select * from sp_get_list_pjm_name()";
		Connection con = null;
		try {
			
            con = db.getConPMSByHost(ConnectionDB.host);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            	listAllUserPJM.add(rs.getString("sp_get_list_pjm_name"));
            }

		} catch (Exception e) {
			throw new AncestryException("getListUserWorkingTeamLeaderGroup : "  + e.toString() , e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listAllUserPJM;
	}
	
	
	/**
	 * get list user pjm by group
	 */
	public List<String[]> getListUserPJMPMSByUser(String groupName)throws AncestryException {
		List<String[]> listAllUserPJM = new ArrayList<String[]>();
		String sql = "select * from sp_get_DPO('"+groupName+"')";
		Connection con = null;
		try {
			
            con = db.getConPMSByHost(ConnectionDB.host);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            	listAllUserPJM.add(new String[]{rs.getString("usrer_id"),rs.getString("usrer_name")});
            }

		} catch (Exception e) {
			throw new AncestryException("getListUserWorkingByGroup : "  + e.toString() , e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listAllUserPJM;
	}
	
	
	

	/**
	 * get list all user
	 */
	public List<BeanUserPMS> getListUserPMS()throws AncestryException {
		List<BeanUserPMS> listAllUser = new ArrayList<BeanUserPMS>();
		Connection con = null;
		try {
			String sql = "SELECT * FROM tbl_users ORDER BY usr_name";
            con = db.getConPMSByHost(ConnectionDB.host);
            listAllUser = JdbcHelper.queryToListBean(con, BeanUserPMS.class, sql, true);
		} catch (Exception e) {
			throw new AncestryException("getListUserWorking : "  + e.toString() , e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listAllUser;
	}
	
	/**
	 * get list all user
	 */
	public List<BeanUserWorking> getListUserWorkingByRole(int role)throws AncestryException {
		List<BeanUserWorking> listAllUser = new ArrayList<BeanUserWorking>();
		Connection con = null;
		try {
			String sql = "SELECT * FROM user_working where role ="+role+"";
            con = db.getConnectByProject(project);
            listAllUser = JdbcHelper.queryToListBean(con, BeanUserWorking.class, sql, true);
		} catch (Exception e) {
			throw new AncestryException("getListUserWorkingByRole : "  + e.toString() , e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listAllUser;
	}

	public boolean saveAssignRole(long projectId, Object[] userId,byte userRole) throws AncestryException {
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "SELECT id FROM user_working ORDER BY id DESC LIMIT 1 ";
		try {
			con = db.getConnectByProject(project);
			String maxId = JdbcHelper.queryToString(con, sql, false);
			if("".equals(maxId)){
				maxId = "0";
			}
			
			sql = " INSERT INTO user_working(id ,projectid, userid, role) VALUES (?,?,?,?); ";
			pst = con.prepareStatement(sql);
			int len = userId.length;
			long id = Long.parseLong(maxId);
			for (int i = 0; i < len; i++) {
				++id;
				pst.setLong  (1, id);
				pst.setLong  (2, projectId);
				pst.setString(3, userId[i].toString());
				pst.setByte  (4, userRole);
				pst.addBatch();
				pst.execute();
			}
			con.commit();

		} catch (Exception e) {
			throw new AncestryException("insertUserWorking :" + e.toString() , e);
		} finally {
			JdbcHelper.closePS(pst);
			JdbcHelper.close(con);
		}

		return true;

	}

	public boolean deleteAssignRole(long projectId, Object[] userId,byte userRole) throws AncestryException {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = db.getConnectByProject(project);
			String sql = "DELETE FROM user_working WHERE projectid=? AND userid=? AND role=? ";

			pst = con.prepareStatement(sql);
			int len = userId.length;
			for (int i = 0; i < len; i++) {
				pst.setLong(1, projectId);
				pst.setString(2, userId[i].toString());
				pst.setByte(3, userRole);
				pst.addBatch();
			}
			pst.executeBatch();
			con.commit();
		} catch (Exception e) {
			throw new AncestryException("deleteUserWorking :" + e.toString() , e);
		} finally {
			JdbcHelper.closePS(pst);
			JdbcHelper.close(con);
		}
		return true;
	}
}
