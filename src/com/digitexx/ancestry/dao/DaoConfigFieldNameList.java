/**
 * 
 */
package com.digitexx.ancestry.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.digitexx.ancestry.bean.BeanTmpConfig;
import com.digitexx.ancestry.bean.FieldNameList;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.db.ConnectionDB;
import com.digitexx.ancestry.db.JdbcHelper;
import com.digitexx.ancestry.util.AncestryException;

/**
 * @author lqnhu
 *
 */
public class DaoConfigFieldNameList {

	private ConnectionDB db = ConnectionDB.getInstance();
	private Tbl_Projects project;
	
	public DaoConfigFieldNameList(Tbl_Projects project) {
		this.project = project;
	}
	
	/**
	 * load data fieldnamelist by project
	 */
	public List<FieldNameList> getDataFieldNameList()throws AncestryException {
		List<FieldNameList> listData = new ArrayList<>();
		Connection con =null;
		try {
			String sql = "SELECT f.* FROM fieldnamelist f order by id ";
			con = db.getConnectByProject(project);
			listData = JdbcHelper.queryToListBean(con, FieldNameList.class, sql, true);
		} catch (Exception e) {
			throw new AncestryException("loadFieldNameList : "  + e.toString() , e);
		}finally {
			JdbcHelper.close(con);
		}
		return listData;
	}
	
	
	/**
	 * get list form
	 */
	public List<String> getListForm() throws AncestryException{

		List<String> listForm = new ArrayList<String>();
		Connection con = null;
		try {
			String sql = "SELECT form_id FROM form_info WHERE is_key ORDER BY form_id";
			con = db.getConnectByProject(project);
			listForm = JdbcHelper.queryToSingleList(con, sql , true);
		} catch (Exception e) {
			throw new AncestryException("getListForm : "  + e.toString(),e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listForm;
	}
	
    /**
	 * save config data
	 */
	public boolean saveConfigData( List<BeanTmpConfig> listSaveData , boolean isMinMax ) throws AncestryException {
		boolean flag = false;
		Connection con  = null;
		String sql = "";
		try {
			con = db.getConnectByProject(project);
			String value = "";
			String min = "";
			String max = "";
			
			for (BeanTmpConfig beanTmp : listSaveData) {
				if(!isMinMax) {
					value = beanTmp.getValue();
					min   = beanTmp.getMin();
					max   = beanTmp.getMax();
					sql = " UPDATE fieldnamelist SET " + beanTmp.getColumname()  + " ='"+value+"' WHERE fieldname ='"+ beanTmp.getFieldName() +"' AND form_id ="+ beanTmp.getFormId() +"";
				}
				else {
					sql = " UPDATE fieldnamelist SET other1 ='"+min+"' , other2 ='"+max+"' WHERE fieldname ='"+ beanTmp.getFieldName() +"' AND form_id ="+ beanTmp.getFormId() +"";
				}
				flag = JdbcHelper.executeNonQueryNotCommit(con, sql);
			}
			if(flag) {
				con.commit();
			}
		} catch (Exception e) {
			flag = false;
			throw new AncestryException("saveConfigData : "  + e.toString(),e);
		}finally {
			JdbcHelper.close(con);
		}
		return flag;
	}
}
