/**
 * 
 */
package com.digitexx.ancestry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.digitexx.ancestry.bean.BeanInfo;
import com.digitexx.ancestry.bean.DigiSoftInfo;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.db.ConnectionDB;
import com.digitexx.ancestry.db.JdbcHelper;
import com.digitexx.ancestry.util.AncestryException;

/**
 * @author lqnhu
 *
 */
public class DaoMoveDataOtherProject {

	private Tbl_Projects project;
	private ConnectionDB db = ConnectionDB.getInstance();

	public DaoMoveDataOtherProject(Tbl_Projects project) {
		this.project = project;
	}
	
	/**
	 * get list column name of table proof by project
	 */
	public List<String> getListColumNameByProject(String tableName) throws AncestryException {

		List<String> listAllPath = new ArrayList<String>();
		Connection con = null;
		String sql = "";
		try {
			sql = "SELECT column_name FROM information_schema.columns "
				+ "WHERE table_schema='"+project.getProj_schema()+"' "
				+ "AND table_name='"+tableName+"'";
			con = db.getConnectByProject(project);
			listAllPath = JdbcHelper.queryToSingleList(con, sql,true);
			
		} catch (Exception e) {
			throw new AncestryException("getListColumNameByProject : "  + e.toString() ,e);
		}finally {
			JdbcHelper.close(con);
		}
		return listAllPath;
	}
	
	/**
	 * get list path in dababase 10.10.1.3 by project
	 */
	public ArrayList<String> getListPathFromDigiSoft(DigiSoftInfo digiSoftInfo , Tbl_Projects project) throws AncestryException {

		ArrayList<String> listAllPath = new ArrayList<String>();
		ResultSet rs = null;
		Connection con = null;
		String sql = "";
		try {
			sql = "SELECT filepath FROM management WHERE qc_status = 2 GROUP BY filepath";
			con = db.getConnectByProject(project);
			rs = JdbcHelper.queryToResultset(con, sql);
			String fileparh = "";
			while(rs.next()) {
				fileparh = rs.getString("filepath");
				listAllPath.add("P:"+ fileparh);
			}
			
		} catch (Exception e) {
			throw new AncestryException("getListPathFromDigiSoft : "  + e.toString() , e);
		}finally {
			JdbcHelper.close(con);
		}
		return listAllPath;
	}
	
	/**
	 * get list path in dababase 10.10.1.3 by project
	 */
	public List<String> getListPathByProject() throws AncestryException {
		List<String> listAllPath = new ArrayList<String>();
		Connection con = null;
		String sql = "";
		try {
			sql = "SELECT filepath FROM management WHERE step =2 AND badimage = 0 GROUP BY filepath";
			con = db.getConnectByProject(project);
			listAllPath = JdbcHelper.queryToSingleList(con, sql,true);
			
		} catch (Exception e) {
			throw new AncestryException("getListPathByProject : "  + e.toString() , e);
		}finally {
			JdbcHelper.close(con);
		}
		return listAllPath;
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
			throw new AncestryException("getProjectInformation : "  + e.toString() , e);
		}
		finally {
			JdbcHelper.closeRS(rs);
			JdbcHelper.close(con);
		}
		return project;
	}
	
	/**
	 * move data to DIGI-SOFT
	 */
	public boolean moveDataDigiSoft( BeanInfo beanInfo , DigiSoftInfo digiSoftInfo , boolean isAllPath) throws AncestryException {

		boolean flag = false;
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "";
		try 
		{
			con = db.getConnectDigiSoft(digiSoftInfo);
			if(!isAllPath) 
			{
				sql = "SELECT * from sp_moving_data_ancestry_to_digisoft_fp_toolqc_092_140627_Bayer_TE_for_qc(?,?,?,?,?,?,?)";
				pst = con.prepareStatement(sql);
				pst.setString(1, beanInfo.getFilepath());
				pst.setArray (2, con.createArrayOf("varchar", beanInfo.getColumn_Ancestry()));
	 			pst.setArray (3, con.createArrayOf("varchar", beanInfo.getColumn_DigiSoft()));
	            pst.setString(4, beanInfo.getSchema_Ancestry());
	            pst.setString(5, beanInfo.getSchema_DigiSoft());
	            pst.setString(6, beanInfo.getVar_con());
	            pst.setString(7, beanInfo.getSearch_path());
				
			}
			else {
				sql = "SELECT * from sp_moving_data_ancestry_to_digisoft_nofp_toolqc_092_140627_Bayer_TE_for_qc(?,?,?,?,?,?)";
				pst = con.prepareStatement(sql);
				pst.setArray (1, con.createArrayOf("varchar", beanInfo.getColumn_Ancestry()));
	 			pst.setArray (2, con.createArrayOf("varchar", beanInfo.getColumn_DigiSoft()));
	            pst.setString(3, beanInfo.getSchema_Ancestry());
	            pst.setString(4, beanInfo.getSchema_DigiSoft());
	            pst.setString(5, beanInfo.getVar_con());
	            pst.setString(6, beanInfo.getSearch_path());
			}
            flag = pst.execute();
            con.commit();
            
		} 
		catch (Exception e) {
			throw new AncestryException("moveDataDigiSoft : "  + e.toString() , e);
		}
		finally {
			JdbcHelper.closePS(pst);
			JdbcHelper.close(con);
		}
		return flag;
	}
	
	
	/**
	 * move data to PDC 
	 */
	public boolean moveDataToDPC( BeanInfo beanInfo , boolean isAllPath) throws AncestryException {

		boolean flag = false;
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "";
		try 
		{
			con = db.getConnectAncestryQC(project);
			if(!isAllPath) 
			{
				sql = "SELECT * from db_14_000_QC_ancestry.sp_moving_data_digisoft_to_ancestry_fp_toolqc_092_140627_Bayer_TE(?,?,?,?,?,?,?)";
				pst = con.prepareStatement(sql);
				pst.setString(1, beanInfo.getFilepath());
				pst.setArray (2, con.createArrayOf("varchar", beanInfo.getColumn_Ancestry()));
	 			pst.setArray (3, con.createArrayOf("varchar", beanInfo.getColumn_DigiSoft()));
	            pst.setString(4, beanInfo.getSchema_Ancestry());
	            pst.setString(5, beanInfo.getSchema_DigiSoft());
	            pst.setString(6, beanInfo.getVar_con());
	            pst.setString(7, beanInfo.getSearch_path());
				
			}
			else {
				sql = "SELECT * from db_14_000_QC_ancestry.sp_moving_data_digisoft_to_ancestry_nofp_toolqc_092_140627_Bayer_TE(?,?,?,?,?,?)";
				pst = con.prepareStatement(sql);
				pst.setArray (1, con.createArrayOf("varchar", beanInfo.getColumn_Ancestry()));
	 			pst.setArray (2, con.createArrayOf("varchar", beanInfo.getColumn_DigiSoft()));
	            pst.setString(3, beanInfo.getSchema_Ancestry());
	            pst.setString(4, beanInfo.getSchema_DigiSoft());
	            pst.setString(5, beanInfo.getVar_con());
	            pst.setString(6, beanInfo.getSearch_path());
			}
            flag = pst.execute();
            con.commit();
		} 
		catch (Exception e) {
			throw new AncestryException("moveDataDigiSoft : "  + e.toString() , e);
		}
		finally {
			JdbcHelper.closePS(pst);
			JdbcHelper.close(con);
		}
		return flag;
	}
}
