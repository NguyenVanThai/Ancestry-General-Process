package com.digitexx.ancestry.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.db.BeanProcessor;
import com.digitexx.ancestry.db.ConnectionDB;
import com.digitexx.ancestry.db.JdbcHelper;
import com.digitexx.ancestry.util.AncestryException;
import com.digitexx.ancestry.util.StringUtil;

public class DaoLogin {

	private BeanProcessor beanProcessor = new BeanProcessor();
	private ConnectionDB db  = ConnectionDB.getInstance();

	/**
	 * get all project Ancestry on PMS
	 */
	public LinkedHashMap<String, Tbl_Projects> getListProjectAncestryPMS(String host) {

		List<Tbl_Projects> listProject = new ArrayList<Tbl_Projects>();
        LinkedHashMap<String, Tbl_Projects> mapProject = new LinkedHashMap<String, Tbl_Projects>();
        Connection con = null;
        ResultSet rs = null;
        String sql = "";
        try 
        {
			sql = "SELECT p.* FROM tbl_projects AS p  where proj_name like '%Ancestry%' AND proj_prjstatus_id =1 ORDER BY proj_name";
			con = db.getConPMSByHost(host);
			rs = JdbcHelper.queryToResultset(con, sql);
			listProject = beanProcessor.toBeanList(rs, Tbl_Projects.class);
			
			String projectName ="";
			for (Tbl_Projects project : listProject) 
			{
				projectName = project.getProj_name();
				if(projectName.indexOf("_for_QC") == -1) {
					mapProject.put(project.getProj_name(), project);
				}
			}
			
		} catch (Exception e) {
			JdbcHelper.error(e, con);
		}
        finally {
        	JdbcHelper.closeRS(rs);
        	JdbcHelper.close(con);
        }
		
		return mapProject;
	}
	
	/**
	 * get all project Ancestry on PMS
	 */
	public LinkedHashMap<String, Tbl_Projects> getListProjectPMS(String host) {

		List<Tbl_Projects> listProject = new ArrayList<Tbl_Projects>();
        LinkedHashMap<String, Tbl_Projects> mapProject = new LinkedHashMap<String, Tbl_Projects>();
        Connection con = null;
        ResultSet rs = null;
        String sql = "";
        try 
        {
			sql = "SELECT p.* FROM tbl_projects AS p ORDER BY proj_name";
			con = db.getConPMSByHost(host);
			rs = JdbcHelper.queryToResultset(con, sql);
			listProject = beanProcessor.toBeanList(rs, Tbl_Projects.class);
			
			for (Tbl_Projects project : listProject) {
				mapProject.put(project.getProj_name(), project);
			}
		} catch (Exception e) {
			JdbcHelper.error(e, con);
		}
        finally {
        	JdbcHelper.closeRS(rs);
        	JdbcHelper.close(con);
        }
		return mapProject;
	}
	
	/**
	 * check user is admin
	 */
	public boolean checkIsAdminOfProject(String username , Tbl_Projects project , byte role)throws AncestryException {
		boolean flag = false;
		Connection con =null;
		String id = "";
		String sql = "";
		try {
			sql = "SELECT id FROM user_working WHERE projectid ="+project.getProj_id()+" AND userid ='"+username+"' AND role ="+role+"";
			con = db.getConnectByProject(project);
			id = StringUtil.setNotNull(JdbcHelper.queryToString(con, sql, true));
			if(!id.equals("")) {
				flag = true;
			}
		} catch (Exception e) {
			throw new AncestryException("checkIsAdminOfProject : "  + e.toString(), e);
		}finally {
			JdbcHelper.close(con);
		}
		return flag;
	}


}
