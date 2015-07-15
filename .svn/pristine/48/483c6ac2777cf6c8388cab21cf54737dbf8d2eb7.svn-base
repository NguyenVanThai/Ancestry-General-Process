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

import com.digitexx.ancestry.bean.Management;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.db.BeanProcessor;
import com.digitexx.ancestry.db.ConnectionDB;
import com.digitexx.ancestry.db.JdbcHelper;

/**
 * @author lqnhu
 *
 */
public class DaoSetPriorityGetjob {
	
	private ConnectionDB db = ConnectionDB.getInstance();
	private Tbl_Projects project;
	private BeanProcessor beanProcessor;
	
	public DaoSetPriorityGetjob(Tbl_Projects project) {
		this.project = project;
		this.beanProcessor = new BeanProcessor();
	}

	/**
	 * get list phase in PMS
	 */
	public List<String> getListPhasePms(long projectId) throws Exception {
		List<String> listPhase = new ArrayList<String>();
		Connection con =null;
		try {
             String sql = "SELECT amp_phasename FROM tbl_adv_manager_phases WHERE amp_prj_id ="+projectId+"";
             con = db.getConPMSByHost(ConnectionDB.host);
             listPhase = JdbcHelper.queryToSingleList(con, sql , true);
             
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			throw new Exception("getListPhasePms : "  + e.toString());
		}
		finally {
			JdbcHelper.close(con);
		}
		return listPhase;
	}
	
	/**
	 * get map phase priority
	 */
	public Map<String , String> getMapPhasePriority() throws Exception{
		Map<String , String> mapPhasePriority = new HashMap<String, String>();
		Connection con = null;
		ResultSet rs = null;
		try {
			String sql = "select phase_name , priority from phases group by phase_name , priority order by phase_name , priority";
			con = db.getConnectByProject(project);
			rs = JdbcHelper.queryToResultset(con, sql);
			while(rs.next()) {
				mapPhasePriority.put(rs.getString("phase_name"), rs.getString("priority"));
			}
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			throw new Exception("getMapPhasePriority : "  + e.toString());
		}
		finally {
			JdbcHelper.closeRS(rs);
			JdbcHelper.close(con);
		}
		return mapPhasePriority;
	}
	
	/**
	 * get list path by phase name in PMS
	 */
	public List<String> getListPathByPhaseName(String phaseName) throws Exception {
		List<String> listPath = new ArrayList<String>();
		Connection con =null;
		String sql = "";
		try {
			sql = "SELECT ami_filepath FROM tbl_adv_manager_path a JOIN tbl_adv_manager_phases b "
				+ " ON a.ami_phase_id = b.amp_id WHERE amp_phasename ='"+phaseName+"' ORDER BY ami_filepath";
			
            con = db.getConPMSByHost(ConnectionDB.host);
            listPath = JdbcHelper.queryToSingleList(con, sql , true);
             
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			throw new Exception("getListPathByPhaseName : "  + e.toString());
		}
		finally {
			JdbcHelper.close(con);
		}
		return listPath;
	}
	
	/**
	 * get user get job by phase name
	 */
	public List<Management> getUserGetJobByPhaseName(String phaseName) throws Exception  {
		List<Management> listManagement  = new ArrayList<Management>();
		Connection con =null;
		ResultSet rs = null;
		try {
			String sql = "SELECT m.id , filename , present_user , record_status , step , phase_name "
					    + " FROM management m join phases p ON m.filepath = p.filepath "
					    + " WHERE record_status =1 AND badimage = 0 and phase_name ='"+phaseName+"' order by m.id";
			con = db.getConnectByProject(project);
			rs = JdbcHelper.queryToResultset(con, sql);
			listManagement = beanProcessor.toBeanList(rs, Management.class);
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			throw new Exception("getUserGetJobByPhaseName : "  + e.toString());
		}
		finally {
			JdbcHelper.closeRS(rs);
			JdbcHelper.close(con);
		}
		return listManagement;
	}
	
	
	/**
	 * get list filepath from Ancestry
	 */
	public List<String> getListPathFromAncestry(String phase_name) throws Exception {
		List<String> listPath = new ArrayList<String>();
		Connection con = null;
		try {
			String sql = "select filepath from phases where phase_name ='"+phase_name+"'";
			con = db.getConnectByProject(project);
			listPath = JdbcHelper.queryToSingleList(con, sql , true);
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			throw new Exception("getListPathFromAncestry : "  + e.toString());
		}finally {
			JdbcHelper.close(con);
		}
		return listPath;
	}
	
    /**
	 * save phase
	 */
	public boolean savePhase(String phase , String priority , List<String> listPathPMS) throws Exception {
		boolean flag = false;
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "";
		try {
			List<String> listCheckeckPath = getListPathFromAncestry(phase);
			con = db.getConnectByProject(project);
			for (String path : listPathPMS) 
			{
				if(!listCheckeckPath.contains(path)) {
					sql = "INSERT INTO phases (phase_name , filepath , priority) VALUES (? ,? ,?)";
				}else {
					sql = "UPDATE phases set priority =? WHERE filepath = ? AND phase_name = ?";
				}
	            pst = con.prepareStatement(sql);
	            
	            if(!listCheckeckPath.contains(path)) {
	            	pst.setString(1, phase);
	            	pst.setString(2, path);
	            	pst.setInt   (3, Integer.parseInt(priority));
	            }else {
	            	pst.setInt   (1, Integer.parseInt(priority));
	            	pst.setString(2, path);
	            	pst.setString(3, phase);
	            }
	            pst.execute();
			}
			flag = true;
            con.commit();		
		} catch (Exception e) {
			con.rollback();
			flag = false;
			e.printStackTrace();
			throw new Exception("savePhase : "  + e.toString());
		}
		finally {
			JdbcHelper.closePS(pst);
			JdbcHelper.close(con);
		}
		return flag;
	}
	
	/**
	 * save phase priority
	 */
	public boolean savePriorityManagement( String phase , String priority , List<String> listPath) throws Exception {
		boolean flag = true;
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "";
		try {
			sql = "update management set priority = ?  where filepath =?";
			con = db.getConnectByProject(project);
		    for (String str : listPath) {
				pst = con.prepareStatement(sql);
				pst.setInt(1, Integer.parseInt(priority));
				pst.setString(2, str);
				pst.execute();
			}
		    flag = true;
		    con.commit();
		} catch (Exception e) {
			con.rollback();
			flag = false;
			e.printStackTrace();
			throw new Exception("savePhasepriority : "  + e.toString());
		}
		finally {
			JdbcHelper.closePS(pst);
			JdbcHelper.close(con);
		}
		return flag;
	}
}
