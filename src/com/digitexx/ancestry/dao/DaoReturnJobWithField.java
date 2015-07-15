/**
 * 
 */
package com.digitexx.ancestry.dao;

import java.awt.Container;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.digitexx.ancestry.bean.CustomerFeedbackDetail;
import com.digitexx.ancestry.bean.Management;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.db.BeanProcessor;
import com.digitexx.ancestry.db.ConnectionDB;
import com.digitexx.ancestry.db.JdbcHelper;
import com.digitexx.ancestry.util.AncestryException;
import com.digitexx.ancestry.util.AppUtility;
import com.digitexx.ancestry.util.StringUtil;

/**
 * @author lqnhu
 *
 */
public class DaoReturnJobWithField {

	private Tbl_Projects project;
    private String management = "";
    private String proof = "";
    private BeanProcessor beanProcessor;
    private Container container;
	private ConnectionDB db = ConnectionDB.getInstance();
	
	public DaoReturnJobWithField(Tbl_Projects project , Container container) {
		this.project = project;
		this.container = container;
	    management   = "";
	    proof = "";
	    beanProcessor = new BeanProcessor();
	}
	
	/**
	 * set table
	 */
	public void setTable(boolean isRework) {
        if(isRework) {
        	management = "management_rework";
        	proof      =  "p1_form_n_proof_rework";
        }else {
        	management = "management";
        	proof      = "p1_form_n_proof";
        }
	}
	
	/**
	 * get list paths
	 */
	public List<String> getListPath( boolean isRework) throws AncestryException{

		setTable(isRework);
		List<String> listPath = new ArrayList<String>();
		Connection con = null;
		String sql = "";
		try {
            sql = "SELECT filepath FROM " + management + " GROUP BY filepath ORDER BY filepath";
            con = db.getConnectByProject(project);
            listPath = JdbcHelper.queryToSingleList(con, sql , true);
		}
		catch (Exception e) {
			throw new AncestryException("getListPath : "  + e.toString() ,e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listPath;
	}
	
	/**
	 * get list fields
	 */
	public List<String> getListField() throws AncestryException{

		List<String> listPath = new ArrayList<String>();
		Connection con = null;
		String sql = "";
		try {
            sql = "SELECT fieldname FROM fieldnamelist group by fieldname";
            con = db.getConnectByProject(project);
            listPath = JdbcHelper.queryToSingleList(con, sql , true);
		}
		catch (Exception e) {
			throw new AncestryException("getListField : "  + e.toString() ,e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listPath;
	}
	
	/**
	 * get list management by filepath
	 */
	public List<String> getListManagementIdByFilePath(String filepath , boolean isRework) throws AncestryException {
		setTable(isRework);
		List<String> listId = new ArrayList<String>();
		Connection con = null;
		try {
			String sql = "SELECT id FROM " +  management + " WHERE filepath ='"+filepath+"' order by id";
			con = db.getConnectByProject(project);
			listId = JdbcHelper.queryToSingleList(con, sql , true);
		}
		catch (Exception e) {
			throw new AncestryException("getListManagementIdByFilePath : "  + e.toString() ,e);
		}finally {
			JdbcHelper.close(con);
		}
		return listId;
	}
	
	/**
	 * get list management by filepath
	 */
	public List<String> getListManagementIdByFromTo(String from , String to , boolean isRework) throws AncestryException {
		setTable(isRework);
		List<String> listId = new ArrayList<String>();
		Connection con = null;
		try {
			String sql = "SELECT managementid FROM " +  proof + " WHERE id between " +  from + " and "  + to + "";
			con = db.getConnectByProject(project);
			listId = JdbcHelper.queryToSingleList(con, sql , true);
		}
		catch (Exception e) {
			throw new AncestryException("getListManagementIdByFromTo : "  + e.toString() ,e);
		}finally {
			JdbcHelper.close(con);
		}
		return listId;
	}
	
	/**
	 * get list managementid by list id
	 */
	public List<Management> getListManagementByListId(String ids , boolean isRework) throws AncestryException {
		List<Management> listManagement = new ArrayList<Management>();
		Connection con = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM " + management + " WHERE id IN("+ids+")";
			con = db.getConnectByProject(project);
			rs = JdbcHelper.queryToResultset(con, sql);
			listManagement = beanProcessor.toBeanList(rs, Management.class);
		} catch (Exception e) {
			throw new AncestryException("getListManagementByListId : "  + e.toString() ,e);
		}
		finally {
			JdbcHelper.closeRS(rs);
			JdbcHelper.close(con);
		}
		return listManagement;
	}
	
	
	/**
	 * save data table customer_feedback_detail
	 */
	public boolean saveCustomerFeedbackDetail(List<CustomerFeedbackDetail> listData) throws AncestryException{
		boolean flag = false;
		Connection con =null;
		try {
			con = db.getConnectByProject(project);
			flag = JdbcHelper.saveListBean(con, "customer_feedback_detail"  , CustomerFeedbackDetail.class ,listData, "id" , true);
			
		} catch (Exception e) {
			throw new AncestryException("saveCustomerFeedbackDetail : "  + e.toString() ,e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return flag;
	}
	
	/**
	 * update step
	 */
	public boolean updateStep(boolean isRework ,int status , String ids) throws AncestryException
	{
		boolean flag = false;
		setTable(isRework);
		Connection con = null;
		String sql ="";
		try {
			ids = StringUtil.setNotNull(ids);
			if(!ids.equals("")) {
				sql ="UPDATE "  + management + " SET step = "+status+" WHERE id IN ("+ids+")";
				con = db.getConnectByProject(project);
				flag = JdbcHelper.executeNonQuery(con, sql);
			}
		}
		catch (Exception e) {
			throw new AncestryException("updateStep : "  + e.toString() ,e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return flag;
	}
	
	
    /**
	 * set value for bean
	 */
	public boolean assign(List<String> listField , String ids , int status , boolean isRework) throws AncestryException
	{
		boolean flag = false;
		List<CustomerFeedbackDetail> listCustomer = new ArrayList<CustomerFeedbackDetail>();
		CustomerFeedbackDetail custDetail ;
		try {
			List<Management> listManagement = getListManagementByListId(ids, isRework);
			if(listManagement.size()  >0) {
	            for (Management management : listManagement) 
	            {
	    			for (String field : listField) 
	    			{
	    				custDetail = new CustomerFeedbackDetail();
	    				custDetail.setManagement_id(management.getId());
	    				custDetail.setImage_path(management.getFilepath());
	    				custDetail.setImage_name(management.getFilename());
	    				custDetail.setForm_id(management.getFormid());
	    				custDetail.setField(field);
	    				custDetail.setGroup_field(field);
	    				custDetail.setFailure_reason("PJM assign job");
	    				custDetail.setIs_rework_field(true);
	    				custDetail.setRework_type(2);
	    				listCustomer.add(custDetail);
	    			}
				}
				if(listCustomer.size() > 0) {
					flag = saveCustomerFeedbackDetail(listCustomer);
				}
				if(flag) {
					updateStep(isRework, status, ids);
				}
			}else {
				AppUtility.msgError(container, "Not found : " +  ids + " in " + management + " !!");
			}

		} catch (Exception e) {
			throw new AncestryException("assign : "  + e.toString() ,e);
		}
		return flag;
	}	
	

	
}
