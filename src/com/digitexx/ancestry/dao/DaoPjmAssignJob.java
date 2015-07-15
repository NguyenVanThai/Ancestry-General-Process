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

import com.digitexx.ancestry.bean.BeanInfo;
import com.digitexx.ancestry.bean.CustomerFeedbackDetail;
import com.digitexx.ancestry.bean.DigiSoftManagement;
import com.digitexx.ancestry.bean.Management;
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
public class DaoPjmAssignJob {

	private Tbl_Projects project;
    private String management = "";
    private String proof      = "";
    private boolean isRework;
    private ConnectionDB db = ConnectionDB.getInstance();
    private BeanProcessor beanProcessor;
	
	public DaoPjmAssignJob(Tbl_Projects project , boolean isRework) {
		this.project = project;
		this.isRework = isRework;
	    this.management   = "";
	    this.proof        = "";
	    this.beanProcessor = new BeanProcessor();
	    setTable(isRework);
	}
	
	/**
	 * set table
	 */
	public void setTable(boolean isRework) {
        if(isRework) {
        	management = "management_rework";
        	proof      = "p1_form_n_proof_rework";
        }else {
        	management = "management";
        	proof      = "p1_form_n_proof";
        }
	}
	
	/**
	 * get list fields
	 */
	public List<String> getListField() throws AncestryException{

		List<String> listField = new ArrayList<String>();
		Connection con = null;
		String sql = "";
		try {
			sql = "SELECT column_name FROM information_schema.columns "
					+ "WHERE table_schema='"+project.getProj_schema()+"' "
					+ "AND table_name='p1_form_n_proof'";
            con = db.getConnectByProject(project);
            List<String> listTmp = JdbcHelper.queryToSingleList(con, sql , true);
            for (String str : listTmp)
            {
		    	   if(str.indexOf("check_anrede") > -1 || 
		    		  str.indexOf("status_") > -1      || 
		    		  str.equals("createdtime")  ||
		    		  str.indexOf("seq_number") > -1   || 
		    		  str.indexOf("filepath") > -1     || 
		    		  str.indexOf("filename") > -1     ||
		    		  str.indexOf("coordinates") > -1  ||
		    		  str.indexOf("managementid") > -1 ||
		    		  str.indexOf("header_place") > -1 ||
		    		  str.equals("id")          ||
		    		  str.equals("user_final")          ||
		    		  str.indexOf("_export") > -1) 
		    	   {
		    		   continue;
		    	   }else {
		    		   listField.add(str);
		    	   }
			}
		}
		catch (Exception e) {
			throw new AncestryException("getListField : "  + e.toString() ,e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listField;
	}
	
	/**
	 * get list fields
	 */
	public List<String> getListFieldFromFieldNameList() throws AncestryException{

		List<String> listField = new ArrayList<String>();
		Connection con = null;
		String sql = "";
		try {
			sql = "SELECT fieldname FROM fieldnamelist WHERE is_valid =1 GROUP BY fieldname ORDER BY fieldname";
            con = db.getConnectByProject(project);
            listField = JdbcHelper.queryToSingleList(con, sql , true);
		}
		catch (Exception e) {
			throw new AncestryException("getListFieldFromFieldNameList : "  + e.toString() ,e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listField;
	}
	
	/**
	 * get list id by filepath
	 */
	public List<String> getListFilePath() throws AncestryException {
		List<String> listFormKey = new ArrayList<String>();
		Connection con = null;
		String sql = "";
		try {
			sql = "SELECT filepath FROM "  + management + " WHERE step =4 GROUP BY filepath ORDER BY filepath";
			con = db.getConnectByProject(project);
			listFormKey = JdbcHelper.queryToSingleList(con, sql , true);
		} catch (Exception e) {
			throw new AncestryException("getListFilePath : "  + e.toString() ,e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listFormKey;
	}
	
	/**
	 * get list id by filepath
	 */
	public Map<String , String> getMapFieldAge() throws AncestryException {
		Map<String , String> mapFieldAge = new HashMap<String , String>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = "SELECT fieldname , detail_field FROM fieldnamelist WHERE fieldtype =3 GROUP BY fieldname , detail_field";
			con = db.getConnectByProject(project);
			pst = con.prepareStatement(sql);
			rs  = JdbcHelper.statementToResultset(con, pst, sql);
			while(rs.next()) {
				mapFieldAge.put(rs.getString("fieldname"), rs.getString("detail_field"));
			}
			
		} catch (Exception e) {
			throw new AncestryException("getMapFieldAge : "  + e.toString() ,e);
		}
		finally {
			JdbcHelper.closeAll(rs, pst, con);
		}
		return mapFieldAge;
	}
	
	/**
	 * get list form key by filepath
	 */
	public List<String> getListFormKey() throws AncestryException {
		List<String> listFormKey = new ArrayList<String>();
		Connection con = null;
		String sql = "";
		try {
			sql = " SELECT form_id FROM form_info WHERE is_key ORDER BY form_id";
			con = db.getConnectByProject(project);
			listFormKey = JdbcHelper.queryToSingleList(con, sql , true);
		} catch (Exception e) {
			throw new AncestryException("getListFormKey : "  + e.toString(),e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listFormKey;
	}
	
	/**
	 * get list form key by filepath
	 */
	public List<String> getListFormKeyByPath(String path) throws AncestryException {
		List<String> listFormKey = new ArrayList<String>();
		Connection con = null;
		String sql = "";
		try {
			sql = " SELECT DISTINCT( formid) FROM "+ management +" WHERE filepath ='"+path+"' AND formid IN ( SELECT form_id FROM form_info WHERE is_key) ORDER BY formid";
			con = db.getConnectByProject(project);
			listFormKey = JdbcHelper.queryToSingleList(con, sql , true);
		} catch (Exception e) {
			throw new AncestryException("getListFormKeyByPath : "  + e.toString(),e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listFormKey;
	}
	
	/**
	 * get list user_type
	 */
	public List<String> getListUserType() throws AncestryException {
		List<String> listFormKey = new ArrayList<String>();
		Connection con = null;
		String sql = "";
		try {
			sql = "SELECT user_type FROM " + proof + " GROUP BY user_type";
			con = db.getConnectByProject(project);
			listFormKey = JdbcHelper.queryToSingleList(con, sql , true);
		} catch (Exception e) {
			throw new AncestryException("getListFormKey : "  + e.toString(),e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listFormKey;
	}
	
	/**
	 * get list user_type
	 */
	public List<String> getListPathByUserType(String user) throws AncestryException {
		List<String> listFormKey = new ArrayList<String>();
		Connection con = null;
		String sql = "";
		try {
			sql = "SELECT m.filepath FROM " + management + " m JOIN " + proof + " p ON m.id = p.managementid "
				+ "AND p.user_type ='"+user+"' AND step =4 GROUP BY filepath";
			con = db.getConnectByProject(project);
			listFormKey = JdbcHelper.queryToSingleList(con, sql , true);
		} catch (Exception e) {
			throw new AncestryException("getListFormKey : "  + e.toString(),e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listFormKey;
	}
	
	/**
	 * get list id by filepath
	 */
	public List<String> getListIdByFilePath(String filepath , String user_type) throws AncestryException {
		List<String> listFormKey = new ArrayList<String>();
		Connection con = null;
		String sql = "";
		try {
			sql = "SELECT m.id FROM " + management + " m JOIN " + proof + " p ON m.id = p.managementid "
				+ "AND m.filepath ='"+filepath+"' and p.user_type ='"+user_type+"' AND step =4 GROUP BY m.id";
			con = db.getConnectByProject(project);
			listFormKey = JdbcHelper.queryToSingleList(con, sql , true);
		} catch (Exception e) {
			throw new AncestryException("getListIdByFilePath : "  + e.toString(),e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listFormKey;
	}
	
	/**
	 * get list id by filepath and by formid
	 */
	public List<String> getListIdByFilePathAndForm(String filepath , String formid) throws AncestryException {
		List<String> listFormKey = new ArrayList<String>();
		Connection con = null;
		String sql = "";
		try {
			sql = "SELECT id FROM " + management + " WHERE filepath ='"+filepath+"' AND step =4 AND formid ="+formid+" ORDER BY id";
			con = db.getConnectByProject(project);
			listFormKey = JdbcHelper.queryToSingleList(con, sql , true);
		} catch (Exception e) {
			throw new AncestryException("getListIdByFilePathAndForm : "  + e.toString(),e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listFormKey;
	}
	
	/**
	 * get list from id to id
	 */
	public List<String> getListIdFromTo(String from , String to , String formid) throws AncestryException {
		List<String> listFormKey = new ArrayList<String>();
		Connection con = null;
		String sql = "";
		try {
			sql = "SELECT id FROM " + management + " WHERE step =4 AND id BETWEEN "+ from +" AND "+ to +
				  " AND formid ="+formid+" ORDER BY id" ;
			con = db.getConnectByProject(project);
			listFormKey = JdbcHelper.queryToSingleList(con, sql , true);
		} catch (Exception e) {
			throw new AncestryException("getListIdFromTo : "  + e.toString(),e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listFormKey;
	}
	
	/**
	 * get user type may managementid
	 */
	public Map<Long , String> getUserTypeByManagementId(String ids) throws AncestryException {
		Map<Long , String> mapUserType = new HashMap<Long, String>();
		Connection con = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT user_type , m.id FROM "+management+" m JOIN "  + proof  +
					    " p ON m.id = p.managementid " +" WHERE m.id IN ("+ids+") AND step = 4 AND badimage = 0"
                      + " GROUP BY user_type , m.id";
			con = db.getConnectByProject(project);
			rs = JdbcHelper.queryToResultset(con, sql);
			while(rs.next()) {
				mapUserType.put(rs.getLong("id"), rs.getString("user_type"));
			}
		} catch (Exception e) {
			throw new AncestryException("getUserTypeByManagementId : "  + e.toString(),e);
		}
		finally {
			JdbcHelper.closeRS(rs);
			JdbcHelper.close(con);
		}
		return mapUserType;
	}
	
	/**
	 * get list management done by user
	 */
	public List<Management> getListManagementByIds(String ids , boolean isRework) throws AncestryException
	{
		setTable(isRework);
		List<Management> listManagement = new ArrayList<Management>();
		ResultSet rs = null;
		Connection con = null;
		String sql ="";
		try {
            sql = "SELECT m.* FROM " +  management + " "
            	+ " m WHERE step = 4 and badimage = 0 AND id IN ( SELECT managementid FROM "+ proof +" WHERE managementid IN ("+ids+")) "
            	+ " GROUP BY id";
            
            con = db.getConnectByProject(project);
            rs = JdbcHelper.queryToResultset(con, sql);
            listManagement = beanProcessor.toBeanList(rs, Management.class);
		} 
		catch (Exception e) {
			throw new AncestryException("getListManagementByIds : "  + e.toString(),e);
		}
		finally {
			JdbcHelper.closeRS(rs);
			JdbcHelper.close(con);
		}
		return listManagement;
	}
	
	/**
	 * get DigiSoft project information
	 */
	public Tbl_Projects getProjectInforFromPMS(String projectName) throws AncestryException
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
			throw new AncestryException("getProjectInforFromPMS : "  + e.toString() ,e);
		}
		finally {
			JdbcHelper.closeRS(rs);
			JdbcHelper.close(con);
		}
		return project;
	}
	
	/**
	 * get QMD Information
	 */
	public List<DigiSoftManagement> getDigiSoftInfo(Tbl_Projects digiSoftProject , String ids) throws AncestryException {
		List<DigiSoftManagement> listInfor = new ArrayList<DigiSoftManagement>();
		Connection con = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT id,ances_mana_id,capture_status,qc_status,ancestry_update_status FROM management WHERE ances_mana_id IN ("+ids+")";
			con = db.getConnectByProject(digiSoftProject);
			ids = ids.replaceAll(" ", "");
            rs = JdbcHelper.queryToResultset(con, sql);	
			listInfor = beanProcessor.toBeanList(rs, DigiSoftManagement.class);
			
		} catch (Exception e) {
			throw new AncestryException("getQmdInformation : "  + e.toString(),e);
		}
		finally {
			JdbcHelper.closeRS(rs);
			JdbcHelper.close(con);
		}
		return listInfor;
	}
	
	/**
	 * update qc_status in DigiSoft
	 */
	public boolean updateDigiSoftQcStatus(Tbl_Projects digiSoftProject , String ids) throws AncestryException {
		boolean flag  = false;
		Connection con = null;
		try {
			if(ids.endsWith(",")) {
				ids = ids.substring(0 , ids.lastIndexOf(","));
			}
			String sql = "UPDATE management SET ancestry_update_status=1 , capture_status=0 WHERE id in ("+ids+")";
			con = db.getConnectByProject(digiSoftProject);
			flag = JdbcHelper.executeNonQuery(con, sql);
			
		} catch (Exception e) {
			throw new AncestryException("updateDigiSoftQcStatus : "  + e.toString(),e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return flag;
	}
	
	/**
	 * move data to Ancestry 
	 */
	public boolean moveDataToAncestry( BeanInfo beanInfo , List<Long> listIds) throws AncestryException {

		boolean flag = true;
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "";
		try 
		{
			con = db.getConnectAncestryQC(project);
			for (long managementid : listIds) 
			{
				sql = "SELECT * from db_14_000_qc_ancestry.sp_moving_data_digisoft_to_ancestry_fp_dataQC(?,?,?,?,?,?,?)";
				pst = con.prepareStatement(sql);
				pst.setLong  (1, managementid);
		 		pst.setArray (2, con.createArrayOf("varchar", beanInfo.getColumn_DigiSoft()));
		 		pst.setArray (3, con.createArrayOf("varchar", beanInfo.getColumn_DigiSoft()));
		        pst.setString(4, beanInfo.getSchema_Ancestry());
		        pst.setString(5, beanInfo.getSchema_DigiSoft());
		        pst.setString(6, beanInfo.getVar_con());
		        pst.setString(7, beanInfo.getSearch_path());
		        
		        System.out.println("sssssssssssssssssss : " + pst.toString());
		        
	            flag = pst.execute();
	            
			}
            con.commit();
		} 
		catch (Exception e) {
			flag = false;
			throw new AncestryException("moveDataToAncestry : "  + e.toString(),e);
		}
		finally {
			JdbcHelper.closePS(pst);
			JdbcHelper.close(con);
		}
		return flag;
	}
	
	//========================================================================================================================
	
	
	/**
	 * update step
	 */
	public boolean updateStep( List<Management> listManagementId ,
			                   Map<Long , String> mapUserType , 
			                   List<String> listField , 
			                   String ids , 
			                   List<Long> listNotAssign,
			                   boolean isSaveTime,
			                   boolean isWithoutUser,
			                   int step)throws AncestryException {
		boolean flag = true;
		PreparedStatement pst = null;
		Connection con = null;
		String sql = "";
		try {
			if(!isWithoutUser) {
				sql = "UPDATE "  + management + " SET step = ? , present_user = ? , record_status = 1 WHERE id = ?";
			}else {
				sql = "UPDATE "  + management + " SET step = ? , present_user = ? , record_status = 0 WHERE id = ?";
			}
			con = db.getConnectByProject(project);
			pst = con.prepareStatement(sql);
			
			for (long id : mapUserType.keySet()) 
			{
				if(!listNotAssign.contains(id)) {
					pst.setInt(1, step);
					if(!isWithoutUser) {
						pst.setString(2, mapUserType.get(id));
					}else {
						pst.setString(2, "");
					}
					pst.setLong(3, id);
					pst.execute();
				}
			}
			flag = true;
			if(!isSaveTime) {
				flag = saveCustomerFeedbackDetail(con , listManagementId , mapUserType , listField , ids );
			}
			if(flag) {
			  con.commit();
		    }
		} catch (Exception e) {
			flag = false;
			throw new AncestryException("updateStep : "  + e.toString(),e);
		}
		finally {
			JdbcHelper.closePS(pst);
			JdbcHelper.close(con);
		}
		return flag;
	}
	
	/**
	 * assign job save time
     */
	public boolean saveCustomerFeedbackDetail(Connection con , 
			                                  List<Management> listManagement ,
			                                  Map<Long , String> mapUserType ,
			                                  List<String> listField ,
			                                  String ids ) throws AncestryException
	{
			boolean flag = true;
			List<CustomerFeedbackDetail> listCustomer = new ArrayList<CustomerFeedbackDetail>();
			CustomerFeedbackDetail custDetail ;
			try {
				String userType = "";
	            for (Management management : listManagement) 
	            {
	            	userType = mapUserType.get(management.getId());
	    			for (String field : listField) 
	    			{
	    				custDetail = new CustomerFeedbackDetail();
	    				custDetail.setManagement_id(management.getId());
	    				custDetail.setImage_path(management.getFilepath());
	    				custDetail.setImage_name(management.getFilename());
	    				custDetail.setForm_id(management.getFormid());
	    				custDetail.setField(field);
	    				custDetail.setUser_type(userType);
	    				custDetail.setGroup_field(field);
	    				custDetail.setFailure_reason("PJM assign job");
	    				custDetail.setIs_rework_field(true);
	    				custDetail.setRework_type(2);
	    				listCustomer.add(custDetail);
	    			}
				}
				if(listCustomer.size() > 0) {
					con = db.getConnectByProject(project);
					flag = JdbcHelper.saveListBean(con, TableName.customer_feedback_detail  , CustomerFeedbackDetail.class ,listCustomer, "id" , true);
				}
			} catch (Exception e) {
				flag = false;
				throw new AncestryException("saveCustomerFeedbackDetail : "  + e.toString(),e);
			}
			return flag;
	}
	
	

}
