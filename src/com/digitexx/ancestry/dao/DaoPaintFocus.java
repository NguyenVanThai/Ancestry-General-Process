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

import com.digitexx.ancestry.bean.Focus_Field;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.bean.XY_WH_SH_SV;
import com.digitexx.ancestry.db.BeanProcessor;
import com.digitexx.ancestry.db.ConnectionDB;
import com.digitexx.ancestry.db.JdbcHelper;
import com.digitexx.ancestry.util.AncestryException;
import com.digitexx.ancestry.util.StringUtil;

/**
 * @author lqnhu
 *
 */
public class DaoPaintFocus {
	
	private BeanProcessor beanProcessor;
	private Tbl_Projects project;
	private ConnectionDB db = ConnectionDB.getInstance();
	
	public DaoPaintFocus (Tbl_Projects project){
		beanProcessor = new BeanProcessor();
		this.project = project;
	}
	
	/**
	 * get list table by schema
	 */
	public List<String> getListTableBySchema() throws AncestryException
	{
		Connection con = null;
		List<String> listTable = new ArrayList<String>();
		try {
			String sql = "SELECT table_name FROM information_schema.tables WHERE table_schema = '"+project.getProj_schema()+"'";
			con = db.getConnectByProject(project);
			listTable = JdbcHelper.queryToSingleList(con, sql,true);
		}
		catch (Exception e) {
			throw new AncestryException("getListTableBySchema : "  + e.toString(),e);
		} 
		finally {
			JdbcHelper.close(con);
		}
		return listTable;
	}
	
	/**
	 * get list formid by schema
	 */
	public List<String> getListFormBySchema(String table) throws AncestryException
	{
		Connection con = null;
		List<String> listForm = new ArrayList<String>();
		try {
			String sql = "SELECT form_id FROM "+table+" group by form_id order by form_id";
			con = db.getConnectByProject(project);
			listForm = JdbcHelper.queryToSingleList(con, sql ,true);
		}
		catch (Exception e) {
			throw new AncestryException("getListFormBySchema : "  + e.toString() , e);
		} 
		finally {
			JdbcHelper.close(con);
		}
		return listForm;
	}
	
	/**
	 * get list fieldname by form
	 */
	public List<String> getListFieldByForm(String formid , String table) throws AncestryException
	{
		Connection con = null;
		List<String> listField = new ArrayList<String>();
		try {
			String sql = "SELECT fieldname FROM "+table+" WHERE form_id ='"+formid+"' ORDER BY tab_order";
			con = db.getConnectByProject(project);
			listField = JdbcHelper.queryToSingleList(con, sql,true);
		}
		catch (Exception e) {
			throw new AncestryException("getListFormBySchema : "  + e.toString() , e);
		}  
		finally {
			JdbcHelper.close(con);
		}
		return listField;
	}
	
	/**
	 * update focus of field
	 */
	public boolean updateFocusOfFieldDB3(HashMap<String, String> mapData ,
			String table , String formid ) throws AncestryException
	{

		boolean flag = false;
		Connection  con = null;
		PreparedStatement pst = null;
		XY_WH_SH_SV xywh = new XY_WH_SH_SV();
		String sql ="";
		try {
             sql = "UPDATE "+table+" SET x = ? , y =? ,width = ? , height = ? , scroll_vertical =? , scroll_horizontal = ?"
             	+ " WHERE fieldname = ? AND form_id = ?";	
             con = db.getConnectByProject(project);
             pst = con.prepareStatement(sql);
             
             for (String fiedname : mapData.keySet()) 
             {
            	String valueFocus = mapData.get(fiedname);
            	if(valueFocus.contains(";")) 
            	{
            		xywh = new XY_WH_SH_SV();
            		xywh = xywh.toObject(valueFocus);
            		pst.setInt(1,Integer.parseInt(xywh.getX()));
            		pst.setInt(2, Integer.parseInt(xywh.getY()));
            		pst.setInt(3, Integer.parseInt(xywh.getW()));
            		pst.setInt(4, Integer.parseInt(xywh.getH()));
            		pst.setInt(5, Integer.parseInt(xywh.getSv()));
            		pst.setInt(6, Integer.parseInt(xywh.getSh()));
            		pst.setString(7, fiedname);
            		pst.setLong(8,Long.parseLong(formid));
            		
            		flag = pst.execute();
            	}
			 }
             con.commit();
             flag = true;
		}
		catch (Exception e) {
			throw new AncestryException("updateFocusOfFieldDB3 : "  + e.toString() ,e);
		} 
		finally {
			JdbcHelper.closePS(pst);
			JdbcHelper.close(con);
		}
		return flag;
	}
	
	
	/**
	 * update focus of field
	 */
	public boolean updateFocusOfFieldDB10(HashMap<String, String> mapData , 
			String table , String formid ) throws AncestryException
	{

		boolean flag = false;
		Connection  con = null;
		PreparedStatement pst = null;
		XY_WH_SH_SV xywh = new XY_WH_SH_SV();
		String sql ="";
		try {
             sql = "UPDATE "+table+" SET x = ? , y =? ,width = ? , height = ? , scroll_vertical =? , scroll_horizontal = ?"
             	+ " WHERE fieldname = ? AND form_id = ?";	
             con = db.getConnectByProjectDB10(project);
             pst = con.prepareStatement(sql);
             
             for (String fiedname : mapData.keySet()) 
             {
            	String valueFocus = mapData.get(fiedname);
            	if(valueFocus.contains(";")) 
            	{
            		xywh = new XY_WH_SH_SV();
            		xywh = xywh.toObject(valueFocus);
            		pst.setInt(1,Integer.parseInt(xywh.getX()));
            		pst.setInt(2, Integer.parseInt(xywh.getY()));
            		pst.setInt(3, Integer.parseInt(xywh.getW()));
            		pst.setInt(4, Integer.parseInt(xywh.getH()));
            		pst.setInt(5, Integer.parseInt(xywh.getSv()));
            		pst.setInt(6, Integer.parseInt(xywh.getSh()));
            		pst.setString(7, fiedname);
            		pst.setLong(8,Long.parseLong(formid));
            		
            		flag = pst.execute();
            	}
			 }
             con.commit();
             flag = true;
		}
		catch (Exception e) {
			throw new AncestryException("updateFocusOfFieldDB10 : "  + e.toString(),e);
		} 
		finally {
			JdbcHelper.closePS(pst);
			JdbcHelper.close(con);
		}
		return flag;
	}
	
	/**
	 * getb list focus field
	 */
	public List<Focus_Field> getListFocusFieldByForm(int formId) throws Exception{

		List<Focus_Field> listFocusField = new ArrayList<Focus_Field>();
		Connection con = null;
		ResultSet rs=  null;
		String sql = "";
		try {
			sql ="SELECT f.* FROM focus_field f WHERE formid ="+formId+" ORDER BY id";
			con = db.getConnectByProject(project);
			rs = JdbcHelper.queryToResultset(con, sql);
			if(rs != null) {
				listFocusField = beanProcessor.toBeanList(rs, Focus_Field.class);
			}
			
		} 
		catch (Exception e) {
			JdbcHelper.rollback(con);
			e.printStackTrace();
			throw e;
		} 
		finally {
			JdbcHelper.closeRS(rs);
			JdbcHelper.close(con);
		}
		
		return listFocusField;
	}
	
	/**
	 * save multi focus
	 */
	public boolean saveMultiFocus(List<Focus_Field> listSaveData) throws AncestryException
	{
		boolean flag = false;
		Connection con = null;
		PreparedStatement pst = null;
		String sql ="";
		
		try {
			con = db.getConnectByProject(project);
			sql = "INSERT INTO focus_field (formid , fieldname , focus , seq_number) values(?,?,?,?)";
			pst = con.prepareStatement(sql);
			for (Focus_Field focus_Field : listSaveData) 
			{
				pst.setInt   (1, focus_Field.getFormid());
				pst.setString(2, focus_Field.getFieldname());
				pst.setString(3, focus_Field.getFocus());
				pst.setInt   (4, focus_Field.getSeq_number());
				
				pst.execute();
			}
			con.commit();
			flag = true;
			
		}
		catch (Exception e) {
			throw new AncestryException("saveMultiFocus : "  + e.toString(), e);
		} 
		finally {
			JdbcHelper.closePS(pst);
			JdbcHelper.close(con);
		}
		
		return flag;
	} 
	
	/**
	 * delete row
	 */
	public boolean delete( int formid , int seq_number) throws AncestryException
	{
		boolean flag = false;
		Connection con = null;
		String sql = "";
		try {
			sql ="DELETE FROM focus_field WHERE formid ="+ formid +" AND seq_number ="+ seq_number +"";
			con = db.getConnectByProject(project);
			flag = JdbcHelper.executeNonQuery(con, sql);
		} 
		catch (Exception e) {
			throw new AncestryException("delete : "  + e.toString() ,e);
		} 
		finally {
			JdbcHelper.close(con);
		}
		return flag;
	}
	
	/**
	 * delete row
	 */
	public boolean deleteAll(long formid) throws AncestryException
	{
		boolean flag = false;
		Connection con = null;
		String sql = "";
		try {
			sql ="DELETE FROM focus_field WHERE formid ="+ formid +"";
			con = db.getConnectByProject(project);
			flag = JdbcHelper.executeNonQuery(con, sql);
		} 
		catch (Exception e) {
			throw new AncestryException("deleteAll : "  + e.toString() , e);
		} 
		finally {
			JdbcHelper.close(con);
		}
		return flag;
	}
	
	/**
	 * update cell
	 */
	public boolean updateCell(int formid , int seq_number , String fieldname) throws AncestryException
	{
		boolean flag = false;
		Connection con = null;
		String sql = "";
		try {
			sql ="UPDATE focus_field SET focus ='' WHERE formid ="+ formid +" AND seq_number ="+ seq_number +" AND fieldname='"+fieldname+"'";
			con = db.getConnectByProject(project);
			flag = JdbcHelper.executeNonQuery(con, sql);
		} 
		catch (Exception e) {
			throw new AncestryException("updateCell : "  + e.toString() ,e);
		} 
		finally {
			JdbcHelper.close(con);
		}
		return flag;
	}
	
	
	/**
	 * update row
	 */
	public boolean updateRow(HashMap<String, String> mapData , int formid , int seq_number) throws AncestryException {

		boolean flag = false;
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "";
		try {
			sql = "UPDATE focus_field SET focus =? WHERE fieldname =? AND seq_number =? AND formid =?";
			con = db.getConnectByProject(project);
			pst = con.prepareStatement(sql);
			
			String value = "";
			for (String fielname :  mapData.keySet())
			{
				value = StringUtil.setNotNull(mapData.get(fielname));
				pst.setString(1, value);
				pst.setString(2, fielname);
				pst.setInt   (3, seq_number);
				pst.setInt   (4, formid);
				pst.execute();
			}
			con.commit();
			flag = true;
		} 
		catch (Exception e) {
			throw new AncestryException("updateRow : "  + e.toString() ,e);
		} 
		finally {
			JdbcHelper.closePS(pst);
			JdbcHelper.close(con);
		}
		
		return flag;
	}
	
	/**
	 * delete row
	 */
	public boolean updateStatusForm( String formid) throws AncestryException
	{
		boolean flag = false;
		Connection con = null;
		String sql = "";
		try {
			sql ="UPDATE form_info SET multi_focus =1 WHERE form_id ="+ formid +"";
			con = db.getConnectByProject(project);
			flag = JdbcHelper.executeNonQuery(con, sql);
		} 
		catch (Exception e) {
			throw new AncestryException("updateStatusForm : "  + e.toString() ,e);
		} 
		finally {
			JdbcHelper.close(con);
		}
		return flag;
	}
	

}
