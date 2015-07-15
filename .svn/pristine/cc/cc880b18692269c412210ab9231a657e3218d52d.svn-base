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
import java.util.Objects;

import com.digitexx.ancestry.bean.CustomerFeedbackDetailQC;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.db.BeanProcessor;
import com.digitexx.ancestry.db.ConnectionDB;
import com.digitexx.ancestry.db.JdbcHelper;
import com.digitexx.ancestry.util.AncestryException;

/**
 * @author lqnhu
 *
 */
public class DaoCompareAndAnalyze {
    private BeanProcessor beanProcessor;
    private Tbl_Projects project;
    private ConnectionDB db = ConnectionDB.getInstance();

    
	public DaoCompareAndAnalyze(Tbl_Projects project) {
	    this.project = project;
	    beanProcessor = new BeanProcessor();
	}
	
	/**
	 * get list paths
	 */
	public List<String> getListPath() throws AncestryException{

		List<String> listPath = new ArrayList<String>();
		Connection con = null;
		String sql = "";
		try {
            sql = "SELECT image_path FROM customer_feedback_detail where qc_status = 0 GROUP BY image_path ORDER BY image_path";
            con = db.getConnectByProject(project);
            listPath = JdbcHelper.queryToSingleList(con, sql,true);
		}
		catch (Exception e) {
			throw new AncestryException("getListPath : "  + e.toString() , e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listPath;
	}
	
	/**
	 * get list version
	 */
	public List<String> getListVersion(String path) throws AncestryException{

		List<String> listPath = new ArrayList<String>();
		Connection con = null;
		String sql = "";
		try {
            sql = "SELECT count FROM customer_feedback_detail WHERE image_path like '"+path+"%' "
            		+ "group by count order by count desc";
            con = db.getConnectByProject(project);
            listPath = JdbcHelper.queryToSingleList(con, sql , true);
		}
		catch (Exception e) {
			throw new AncestryException("getListVersion : "  + e.toString() , e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listPath;
	}
	
	/**
	 * get list data table customer_feedback_detail
	 */
	public List<CustomerFeedbackDetailQC> getListDataCustomerByPath(String path , String count , boolean isOnlyFilePath) throws AncestryException 
	{
		List<CustomerFeedbackDetailQC> listData = new ArrayList<CustomerFeedbackDetailQC>();
		Connection con = null;
		ResultSet rs = null;
		String sql = "";
		try {
			if(isOnlyFilePath) {
				sql = "SELECT id ,image_path , image_name , value_db3 , value_dpo , value_qc , mistake ,user_type , field , seq_number , count , management_id "
						+ "FROM customer_feedback_detail c WHERE image_path like '"+path+"%'"
						+ " AND rework_type = 0";
			}else {
				sql = "SELECT id ,image_path , image_name , value_db3 , value_dpo , value_qc , mistake , user_type , field , seq_number , count , management_id "
					 + "FROM customer_feedback_detail c WHERE  image_path like'"+path+"%' "
					 + "and count ="+count+" AND rework_type = 0";
			}
			con = db.getConnectByProject(project);
			rs  = JdbcHelper.queryToResultset(con, sql);
			listData = beanProcessor.toBeanList(rs, CustomerFeedbackDetailQC.class);
		} 
		catch (Exception e) {
			throw new AncestryException("getListDataCustomerByPath : "  + e.toString() , e);
		}
		finally {
			JdbcHelper.closeRS(rs);
			JdbcHelper.close(con);
		}
		return listData;
	}
	
	/**
	 * finish qc
	 */
	public boolean finishPath(Map<Long , String[]> mapData) throws AncestryException {
         boolean flag = true;
         Connection con = null;
         PreparedStatement pst = null;
         try {
			String sql = "update customer_feedback_detail set qc_status = 1 , value_qc =? , mistake = ? where id =?";
			con = db.getConnectByProject(project);
			String [] arr;
			for (long id :  mapData.keySet()) 
			{
				arr = mapData.get(id);
				pst = con.prepareStatement(sql);
				pst.setString(1, Objects.toString(arr[0],""));
				pst.setString(2, Objects.toString(arr[1],""));
				pst.setLong(3, id);
				pst.execute();
			}
			con.commit();
			
		 } 
         catch (Exception e) {
        	 flag = false;
        	 throw new AncestryException("finishPath : "  + e.toString() , e);
		 }
         return flag;
	}
	
	/**
	 * get list mistake
	 */
	public List<String> getListMistakes() throws AncestryException {
		List<String> listMistake = new ArrayList<String>();
		Connection con = null;
		try {
			String sql = "select error from mistake order by id";
			con = db.getConnectAncestryQC(project);
			listMistake  = JdbcHelper.queryToSingleList(con, sql,true);
		} catch (Exception e) {
			throw new AncestryException("getListMistakes : "  + e.toString() , e);
		}finally {
			JdbcHelper.close(con);
		}
		return listMistake;
	}
	
	/**
	 * get DigiSoft project information
	 */
	public Tbl_Projects getProjectInformation(String projectName) throws AncestryException
	{
		Tbl_Projects project = new Tbl_Projects();
		Connection con = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = "SELECT proj_serverip ,proj_schema , proj_dbname , proj_uid , proj_pwd FROM tbl_projects p WHERE proj_name='"+projectName+"'";
			con = db.getConPMSByHost(db.host);
			rs = JdbcHelper.queryToResultset(con, sql);
			if(rs.next()) {
				project.setProj_serverip(rs.getString("proj_serverip"));
				project.setProj_dbname(rs.getString("proj_dbname"));
				project.setProj_uid(rs.getString("proj_uid"));
				project.setProj_pwd(rs.getString("proj_pwd"));
				project.setProj_schema(rs.getString("proj_schema"));
			}
		}
		catch (Exception e) {
			throw new AncestryException("getProjectInformation : "  + e.toString() ,e);
		}
		finally {
			JdbcHelper.closeRS(rs);
			JdbcHelper.close(con);
		}
		return project;
	}
	
	
	/**
	 * get list user_id of QC
	 */
	public Map<String , String> getMapUserIdQC(String managementids ,  Tbl_Projects projectDigiSoft) throws AncestryException{
		Map<String , String> mapUserId = new HashMap<String , String>();
		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection con = null;
		try {
			String sql = "SELECT user_id ,  notes FROM work_details WHERE process_step = 7 AND STRING_TO_ARRAY(notes,',') && STRING_TO_ARRAY('"+managementids+"',',')";
			con = db.getConnectByProject(projectDigiSoft);
			pst = con.prepareStatement(sql);
			rs = JdbcHelper.statementToResultset(con, pst, sql);
			
			String userId = "";
			String notes  = "";
			String [] arr ;
			while(rs.next()) {
				userId = rs.getString("user_id");
				notes  = rs.getString("notes");
				if(!notes.equals("")) 
				{
					if(notes.contains(",")) {
						arr = notes.split(",");
						for (String str : arr) {
							mapUserId.put(str, userId);	
						}
					}else {
						mapUserId.put(notes, userId);
					}
				}
			}
		} catch (Exception e) {
			throw new AncestryException("getListUserIdQC : "  + e.toString(), e);
		}finally {
			JdbcHelper.close(con);
		}
		return mapUserId;
	}
	
	/**
	 * get Map userid , username
	 */
	public Map<String , String> getMapIdAndName(Tbl_Projects projectDigiSoft) throws AncestryException {
		Map<String , String> mapUser = new HashMap<String, String>();
		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection con = null;
		try {
			String sql = "SELECT id , username FROM production.user_info WHERE status = true";
			con = db.getConnectByProject(projectDigiSoft);
			pst = con.prepareStatement(sql);
            rs = JdbcHelper.statementToResultset(con, pst, sql);
            while(rs.next()) {
            	mapUser.put(rs.getString("id"), rs.getString("username"));
            }
		} catch (Exception e) {
			throw new AncestryException("getMapUserId : "  + e.toString(), e);
		}
		finally {
			JdbcHelper.closeAll(rs, pst, con);
		}
		return mapUser;
	}
}
