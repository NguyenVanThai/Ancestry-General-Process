/**
 * 
 */
package com.digitexx.ancestry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.digitexx.ancestry.bean.FieldNameList;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.db.BeanProcessor;
import com.digitexx.ancestry.db.ConnectionDB;
import com.digitexx.ancestry.db.JdbcHelper;
import com.digitexx.ancestry.util.AncestryException;
import com.digitexx.ancestry.util.StringUtil;

/**
 * @author lqnhu
 *
 */
public class DaoAddField 
{
	BeanProcessor beanProcessor ;
	ConnectionDB db = ConnectionDB.getInstance();
	public DaoAddField() {
		beanProcessor = new BeanProcessor();
	}
	
	/**
	 * get project infor by project name
	 */
	public Tbl_Projects getProjectInforByName(String projectName)throws AncestryException {

		Tbl_Projects project = new Tbl_Projects();
		Connection con = null;
		ResultSet rs = null;
		String sql ="";
		try {
			sql = "SELECT p.* FROM tbl_projects AS p  where proj_name ='"+projectName+"'";
			rs = JdbcHelper.queryToResultset(con, sql);
			project = (Tbl_Projects) beanProcessor.toBean(rs, Tbl_Projects.class);
		} 
		catch (Exception e) {
			JdbcHelper.rollback(con);
			throw new AncestryException("getProjectInforByName : "  + e.toString() ,e);
		}
		finally {
			JdbcHelper.closeRS(rs);
			JdbcHelper.close(con);
		}
		return project;
	}
	
	/**
	 * get list fieldnamelist
	 */
	public List<FieldNameList> getListFieldNameList(Tbl_Projects project , boolean isDB10) throws AncestryException{

		List<FieldNameList> listField = new ArrayList<FieldNameList>();
		Connection con =null;
		ResultSet rs = null;
		String sql ="";
		try {
            sql = "select f.* from fieldnamelist f order by id";
            if(isDB10) {
            	con = db.getConnectByProjectDB10(project);
            }else {
            	con = db.getConnectByProject(project);
            }
            rs = JdbcHelper.queryToResultset(con, sql);
            listField = beanProcessor.toBeanList(rs, FieldNameList.class);
            
		} 
		catch (Exception e) {
			JdbcHelper.rollback(con);
			throw new AncestryException("getListFieldNameList : "  + e.toString() ,e);
		}
		finally {
			JdbcHelper.closeRS(rs);
			JdbcHelper.close(con);
		}
		return listField;
	}
	
	/**
	 * get list fieldnamelist
	 */
	public List<FieldNameList> getListFieldNameListByForm(Tbl_Projects project , String form , boolean isDB10) throws AncestryException{

		List<FieldNameList> listField = new ArrayList<FieldNameList>();
		Connection con =null;
		ResultSet rs = null;
		String sql ="";
		try {
            sql = "SELECT f.* FROM fieldnamelist f WHERE form_id ="+form+" ORDER BY id";
            con = db.getConnectByProject(project);
            rs = JdbcHelper.queryToResultset(con, sql);
            listField = beanProcessor.toBeanList(rs, FieldNameList.class);
            
		} 
		catch (Exception e) {
			JdbcHelper.rollback(con);
			throw new AncestryException("getListFieldNameListByForm : "  + e.toString() ,e);
		}
		finally {
			JdbcHelper.closeRS(rs);
			JdbcHelper.close(con);
		}
		return listField;
	}
	
	/**
	 * get list form by project
	 */
	public List<String> getFormByProject(Tbl_Projects project) throws AncestryException 
	{
		List<String> listForm  =  new ArrayList<String>();
		Connection con = null;
		String sql = "";
		try {
			sql ="select form_id from form_info where is_key =true order by form_id";
			con = db.getConnectByProject(project);
			listForm = JdbcHelper.queryToSingleList(con, sql,true);
		}
		catch (Exception e) {
			JdbcHelper.rollback(con);
			throw new AncestryException("getFormByProject : "  + e.toString() , e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listForm;

	}
	
	/**
	 * save fieldnamelist
	 */
	public boolean saveFieldNameList(List<LinkedHashMap<String, Object>> listMapData , Tbl_Projects project) throws AncestryException
	{
		boolean flag = false;
		Connection con = null;
		try {
			con = db.getConnectByProject(project);
	        flag = JdbcHelper.saveListMap(con, "fieldnamelist", listMapData);
		} 
		catch (Exception e) {
			JdbcHelper.rollback(con);
			throw new AncestryException("saveFieldNameList : "  + e.toString() ,e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return flag;
	}
	
	
	/**
	 * delete field
	 */
	public boolean delete(Tbl_Projects project ,List<String> listId) throws AncestryException {

		boolean flag = true;
		Connection con = null;
		PreparedStatement pst =null;
		String sql = "";
		try {
			sql = "DELETE FROM fieldnamelist WHERE id =?";
			con = db.getConnectByProject(project);
			pst = con.prepareStatement(sql);
			
			for (String id : listId) {
				pst.setLong(1, Long.parseLong(id));
				pst.execute();
			}
			con.commit();
		}
		catch (Exception e) {
			JdbcHelper.rollback(con);
			flag = false;
			throw new AncestryException("delete : "  + e.toString() ,e);
		}
		finally {
			JdbcHelper.closePS(pst);
			JdbcHelper.close(con);
		}
		return flag;
	}
	
	public int getTabOther(Tbl_Projects project , String formId , boolean isId) throws AncestryException
	{
		int tabOther = 1;
		String sql ="";
		Connection con = null;
		try {
			if(isId) {
				sql = "SELECT max(id) FROM fieldnamelist";
			}else {
				sql = "SELECT max(tab_order) FROM fieldnamelist WHERE form_id ="+formId+"";
			}
			con = db.getConnectByProject(project);
			String result = StringUtil.setNotNull(JdbcHelper.queryToObject(con, sql));
			if(!result.equals("")) {
				tabOther = Integer.parseInt(result) +1;
			}
		} 
		catch (Exception e) {
			JdbcHelper.rollback(con);
			throw new AncestryException("getTabOther : "  + e.toString() ,e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return tabOther;
	}
	
}
