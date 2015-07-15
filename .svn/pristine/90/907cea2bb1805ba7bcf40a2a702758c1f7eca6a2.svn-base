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

import com.digitexx.ancestry.bean.FormType;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.db.ConnectionDB;
import com.digitexx.ancestry.db.JdbcHelper;
import com.digitexx.ancestry.table.model.SqlResultTableModel;
import com.digitexx.ancestry.util.AncestryException;
import com.digitexx.ancestry.util.StringUtil;

/**
 * @author lqnhu
 *
 */
public class DaoAnalyzeRework 
{
	Tbl_Projects project;
	ConnectionDB db = ConnectionDB.getInstance();

	public DaoAnalyzeRework(Tbl_Projects project) {
		this.project = project;
	}
	
	/**
	 * check exist table name
	 */
	public boolean checkExistTable(String tableName) throws AncestryException {
       boolean flag = false;
       Connection con = null;
       ResultSet rs = null;
       try {
           String sql = "SELECT distinct(table_name) FROM information_schema.tables WHERE table_name ='"+tableName+"'";
           con = db.getConnectByProject(project);
           rs = JdbcHelper.queryToResultset(con, sql);
           if(rs.next()) {
        	   flag = true;
           }
		} catch (Exception e) {
			throw new AncestryException("checkExistTable : "  + e.toString() ,e);
		}
        finally {
        	JdbcHelper.closeRS(rs);
        	JdbcHelper.close(con);
        }
       return flag;
	}
	
	/**
	 * check exist column name 
	 */
	public boolean checkExistColumn(String columName) throws AncestryException {
       boolean flag = false;
       Connection con = null;
       ResultSet rs = null;
       try {
           String sql = "SELECT distinct(column_name) FROM information_schema.columns "
           		+ "WHERE table_name='form_info' and column_name='"+columName+"'";
           con = db.getConnectByProject(project);
           rs = JdbcHelper.queryToResultset(con, sql);
           if(rs.next()) {
        	   flag = true;
           }
		} catch (Exception e) {
			throw new AncestryException("checkExistColumn : "  + e.toString() ,e);
		}
        finally {
        	JdbcHelper.closeRS(rs);
        	JdbcHelper.close(con);
        }
       return flag;
	}
	
	
	/**
	 * get list filepath by project
	 */
	public List<String> getListFilepathByProject(boolean isHoldJob) throws AncestryException
	{
        List<String> listPath = new ArrayList<String>();
        Connection con = null;
        String sql = "";
        
        try {
        	if(!isHoldJob) {
        		sql = "SELECT image_path FROM customer_feedback "
        				+ "WHERE is_analyzed = false GROUP BY image_path";
        	}else {
        		sql = "SELECT image_path FROM customer_feedback "
        				+ "WHERE is_analyzed IS NULL GROUP BY image_path";
        	}
			con = db.getConnectByProject(project);
			listPath = JdbcHelper.queryToSingleList(con, sql,true);
			
		} catch (Exception e) {
			throw new AncestryException("getListFilepathByProject : "  + e.toString(),e);
		}
        finally {
        	JdbcHelper.close(con);
        }
        return listPath;
	}
	
	/**
	 * get count by filepath
	 */
	public int getCountByFilePath(String filepath) throws AncestryException{

		int count = 1;
		Connection con = null;
		String sql = "";
		String tmp;
        try {
			sql = "SELECT DISTINCT(count) , id FROM customer_feedback "
				+ "WHERE image_path = '"+filepath+"' ORDER BY id DESC LIMIT 1";
			con = db.getConnectByProject(project);
			tmp = StringUtil.setNotNull(JdbcHelper.queryToObject(con, sql));
			if(!tmp.equals("")) {
				count = Integer.parseInt(tmp);
			}
		} 
        catch (Exception e) {
        	throw new AncestryException("getCountByFilePath : " +  e.toString() ,e);
		}			
        finally {
        	JdbcHelper.close(con);
        }
		return count;
	}
	
	/**
	 * get data rework by filepath and by project
	 */
	public SqlResultTableModel getDataReworkByFilePath(String filepath , boolean isHoldJob) throws AncestryException
	{
		SqlResultTableModel model = new SqlResultTableModel();
		Connection con =null;
		ResultSet rs = null;
		String sql ="";
		try {
			if(!isHoldJob) {
				sql = "SELECT management_id,form_id,image_path,image_name, seq_number, "
						+ "group_field, field,value_db3,value_dpo,failure_reason,user_type,count,is_rework_field "
						+ "FROM customer_feedback_detail "
						+ "WHERE image_path ='"+filepath+"' "
						+ "AND is_rework_field = false AND is_analyzed = false AND rework_type = 0 ORDER BY id";
			}else {
				sql = "SELECT management_id,form_id,image_path,image_name, seq_number, "
						+ "group_field, field,value_db3,value_dpo,failure_reason,user_type,count,is_rework_field "
						+ "FROM customer_feedback_detail "
						+ "WHERE image_path ='"+filepath+"' "
						+ "AND is_rework_field = false AND is_analyzed IS NULL AND rework_type = 0 ORDER BY id";
			}
			
			con = db.getConnectByProject(project);
			rs = JdbcHelper.queryToResultset(con, sql);
			
			model.setResultSet(rs);
			
		} catch (Exception e) {
			throw new AncestryException("getDataReworkByFilePath : "  + e.toString() ,e);
		}
		finally {
			JdbcHelper.closeRS(rs);
			JdbcHelper.close(con);
		}
		return model;
	}
	
	/**
	 * update column is_analyzed in table customer_feedback
	 */
	public boolean updateStatusFeedBack( String filepath , int status , int count) throws AncestryException
	{
		boolean flag = false;
		Connection con = null;
		String sql = "";
		try {
			con = db.getConnectByProject(project);
			if(status == 0) 
			{
				sql = "UPDATE customer_feedback SET is_analyzed = true "
						+ "WHERE image_path ='" + filepath + "' AND count ="+count+"";
			}else {
				sql = "UPDATE customer_feedback_detail SET is_analyzed = true "
						+ "WHERE image_path ='" + filepath + "' AND count ="+count+" AND rework_type = 0";
			}
			flag = JdbcHelper.executeNonQuery(con, sql);
		} catch (Exception e) {
			throw new AncestryException("updateStatusFeedBack : "  + e.toString() ,e);
		}finally {
			JdbcHelper.close(con);
		}
		return flag;
	}
	
	/**
	 * update column is_analyzed in table customer_feedback
	 */
	public boolean updateReworkFeedBack( List<String[]> listData , int count , int status) throws AncestryException
	{
		boolean flag = false;
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "";
		try {
			if(status == 0) {
				sql = "UPDATE customer_feedback_detail SET is_rework_field = true , is_analyzed = true "
					+ "WHERE management_id = ? AND group_field =? AND seq_number =? "
					+ "AND rework_type =0 AND count ="+count+"";
			}
			else {
				sql = "UPDATE customer_feedback SET is_rework = true , is_analyzed = true "
					+ "WHERE management_id = ? AND group_field =? AND seq_number =? AND count ="+count+"";
			}
			con = db.getConnectByProject(project);
			pst = con.prepareStatement(sql);
			for (String[] arrTmp : listData) 
			{
				pst.setLong  (1, Long.parseLong(arrTmp[0]));
				pst.setString(2, arrTmp[1]);
				pst.setInt   (3, Integer.parseInt(arrTmp[2]));
				pst.execute();
			}
			con.commit();
			flag = true;
			
		} catch (Exception e) {
			throw new AncestryException("updateReworkFeedBack " + e.toString() ,e );
		}
		finally {
			JdbcHelper.close(con);
		}
		return flag;
	}
	
	
	/**
	 * process rework
	 */
	public boolean updateStepReworkNotFormMixed(String filepath) throws AncestryException {
        boolean flag = false;
        Connection con = null;
        String sql = "";
        try {
			sql = "UPDATE management_rework set STEP = 2 WHERE formid IN "
					+ "( "
					+ "SELECT form_id FROM fieldnamelist " 
					+ "WHERE fieldname IN " 
					+ "(SELECT field FROM customer_feedback_detail WHERE is_rework_field and image_path ='"+filepath+"' AND is_rework_field = true AND rework_type = 0) "
					+ ") "
					+ "and filepath ='"+filepath+"'";
			
			con = db.getConnectByProject(project);
			flag = JdbcHelper.executeNonQuery(con, sql);
		} 
        catch (Exception e) {
        	throw new AncestryException("updateStepReworkNotFormMixed : "  + e.toString() ,e);
		}
        finally {
		    JdbcHelper.close(con);	
		}
        return flag;
	}
	
	/**
	 * process rework
	 */
	public boolean updateStepReworkNotFormMixed4(String filepath) throws AncestryException {
        boolean flag = false;
        Connection con = null;
        String sql = "";
        try {
			sql = "UPDATE management_rework set STEP = 4 WHERE formid IN "
					+ "( "
					+ "SELECT form_id FROM fieldnamelist " 
					+ "WHERE fieldname IN " 
					+ "(SELECT field FROM customer_feedback_detail WHERE is_rework_field and image_path ='"+filepath+"' AND is_rework_field = true AND rework_type = 0) "
					+ ") "
					+ "and filepath ='"+filepath+"'";
			
			con = db.getConnectByProject(project);
			flag = JdbcHelper.executeNonQuery(con, sql);
		} 
        catch (Exception e) {
        	throw new AncestryException("updateStepReworkNotFormMixed4 : "  + e.toString() , e);
		}
        finally {
		    JdbcHelper.close(con);	
		}
        return flag;
	}
	
	/**
	 * process rework
	 */
	public boolean updateStepRework( String filepath) throws AncestryException 
	{
        boolean flag = false;
        Connection con = null;
        String formMixed = "";
        String sql = "";
        try 
        {
        	boolean hasColumnMixed = checkExistColumn("mixed");
        	List<String> listFormMixed = new ArrayList<String>();
        	if(hasColumnMixed) {
        		listFormMixed = getListFormMixedByFilePath(filepath);
        	}
        	con = db.getConnectByProject(project);
        	if(listFormMixed.size() > 0) 
        	{
        		formMixed = StringUtil.join(listFormMixed, ",");
        		sql = "UPDATE management_rework SET step = 2 WHERE formid IN ("+formMixed+") AND filepath ='"+filepath+"'";
        		flag = JdbcHelper.executeNonQuery(con, sql);
        	}
            updateStepReworkNotFormMixed(filepath);
		} 
        catch (Exception e) {
        	throw new AncestryException("updateStepRework : "  + e.toString() , e);
		}
        finally {
		    JdbcHelper.close(con);	
		}
        return flag;
	}
	
	/**
	 * get list form by filepath
	 */
	public List<String> getListFormMixedByFilePath(String filepath) throws AncestryException 
	{
		List<String> listForm = new ArrayList<String>();
		Connection con = null;
		String sql ="";
		try {
			sql = "SELECT form_id FROM form_info where mixed =1";
			con = db.getConnectByProject(project);
			listForm = JdbcHelper.queryToSingleList(con, sql,true);
		} 
		catch (Exception e) {
			throw new AncestryException("getListFormMixedByFilePath : "  + e.toString() , e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listForm;
	}
	
	/**
	 * process rework wrong count
	 */
	public boolean reworkWrongCount( String filepath) throws AncestryException{
        boolean flag = false;
        Connection con = null;
        String sql = "";
        try {
			con = db.getConnectByProject(project);
			sql = "UPDATE management_rework SET step = 2 WHERE id in "
					+ "( "
					+ "SELECT m.id FROM management_rework m, form_info f " 
					+ "WHERE m.formid =  f.form_id " 
					+ "AND filepath ='"+filepath+"' "
					+ "AND f.is_key "
					+ "AND f.is_key = true AND f.status = 0 "
					+ ") ";
			flag = JdbcHelper.executeNonQuery(con, sql);
		} 
        catch (Exception e) {
        	throw new AncestryException("reworkWrongCount : "  + e.toString() ,e);
		}
        finally {
		    JdbcHelper.close(con);	
		}
        return flag;
	}
	

	
	/**
	 * update formid
	 */
	public boolean updateFormId( String formid , long managementid) throws AncestryException
	{
        boolean flag = false;
        Connection con = null;
        String sql = "";
        try {
			con = db.getConnectByProject(project);
			sql = "UPDATE management_rework SET formid = " + formid + ", wrong_form = 1, step = 2 WHERE id = " + managementid;
			flag = JdbcHelper.executeNonQuery(con, sql);
		} 
        catch (Exception e) {
        	throw new AncestryException("updateFormId : "  + e.toString() , e);
		}
        finally {
		    JdbcHelper.close(con);	
		}
        return flag;
	}
	
	/**
	 * delete data in table proof rework
	 */
	public boolean deleteProofRework( long managementid) throws AncestryException{

		boolean flag = false;
		Connection con = null;
		String sql ="";
		try {
			con = db.getConnectByProject(project);
			sql = "DELETE FROM p1_form_n_proof_rework WHERE managementid = " + managementid;
            flag = JdbcHelper.executeNonQuery(con, sql);
		} 
        catch (Exception e) {
        	throw new AncestryException("deleteProofRework : "  + e.toString() , e);
		}
        finally {
		    JdbcHelper.close(con);	
		}
		return flag;
	}
	
	
	/**
	 * convert age value to Map
	 */
	public Map<String , Object> ageValueToMap(String value , String ext) 
	{
		Map<String , Object> mapAge = new HashMap<String , Object>();
		String [] arrField ;
		if(!value.equals("") && value.indexOf("|") > -1) {
			arrField = StringUtil.split(value, "|");
			mapAge.put("age_"+ext+"_jahr"  , arrField[0]);
			mapAge.put("age_"+ext+"_monat" , arrField[1]);
			mapAge.put("age_"+ext+"_woche" , arrField[2]);
			mapAge.put("age_"+ext+"_tag"   , arrField[3]);
			mapAge.put("age_"+ext+"_stunde", arrField[4]);
		}
		return mapAge;
	}
	
	
	//=======================================================================================================================
	
	/**
	 * save data not field age
	 */
	public boolean updateValueNotFieldAge(String value , String columnName , String managementid , String seq_number) throws AncestryException
	{
        boolean flag = false;
        Connection con = null;
        PreparedStatement pst = null;
        String sql = "";
        try {
        	if(!columnName.equals("")) 
        	{
            	con = db.getConnectByProject(project);
            	sql = "UPDATE p1_form_n_proof_rework SET "+columnName+" =? WHERE managementid = ? AND seq_number = ?";
                pst = con.prepareStatement(sql);
                
                pst.setString(1, value);
                pst.setLong  (2, Long.parseLong(managementid));
                pst.setInt   (3, Integer.parseInt(seq_number));
                
    			System.out.println("updateValueNotFieldAge : "  + pst.toString());
                
                pst.execute();
                con.commit();
            	flag = true;
        	}

		} 
        catch (Exception e) {
        	throw new AncestryException("updateValueNotFieldAge : "  + e.toString() , e);
		}
        finally {
        	JdbcHelper.closePS(pst);
		    JdbcHelper.close(con);	
		}
        return flag;
	}
	
	/**
	 * update value field age
	 */
	public boolean updateDataFieldAge(Map<String, String> mapEnumAge , String value , String columnName , String managementid , String seq_number) throws AncestryException
	{
		boolean flag = false;
		Connection con = null;
		PreparedStatement pst = null;
		Map<String , Object> mapValueAge = new HashMap<String,Object>();
		
		String sql = "";
		String ext = "";
		
		try {
    		con = db.getConnectByProject(project);
    		ext = mapEnumAge.get(columnName);
			mapValueAge  = ageValueToMap(value, ext);
			
			if(mapValueAge.size() > 0) 
			{
				sql = JdbcHelper.buildUpdateCommandFiedAge("p1_form_n_proof_rework", mapValueAge, "managementid", managementid);
				sql = sql + " AND seq_number = "  + seq_number;
				pst = con.prepareStatement(sql);
				
				System.out.println("updateDataFieldAge : "  + pst.toString());
				
				pst.execute();
	        	con.commit();
	        	flag = true;
			}

		} 
		catch (Exception e) {
			throw new AncestryException("updateDataFieldAge : "  + e.toString() , e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return flag;
	}
	
	
	/**
	 * update image not rework
	 */
	public boolean updateImageNotrework(List<String> listManagementId) throws AncestryException {

		boolean flag = false;
		Connection con = null;
		String sql ="";
		try {
			String id = StringUtil.join(listManagementId, ",");
			sql = "UPDATE management_rework SET step =4 WHERE id IN ("+id+")";
			con = db.getConnectByProject(project);
			flag = JdbcHelper.executeNonQuery(con, sql);
		}
		catch (Exception e) {
			throw new AncestryException("updateImageNotrework : "  + e.toString() , e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return flag;
	}
	
	/**
	 * save hold job
	 */
	public boolean saveHoldJob(String filepath , String count) throws AncestryException {

		boolean flag = false;
		Connection con = null;
		try {
			String sqlCustomer = "UPDATE customer_feedback SET is_analyzed = null , is_rework = false WHERE image_path ='"+filepath+"' and count ="+count+"";
			String sqlCustomerDetail = "UPDATE customer_feedback_detail SET is_rework_field = false , is_analyzed = null WHERE image_path ='"+filepath+"' AND rework_type = 0 AND count ="+count+"";
			con = db.getConnectByProject(project);
			flag = JdbcHelper.executeNonQuery(con, sqlCustomer);
			if(flag) {
				con = db.getConnectByProject(project);
				flag = JdbcHelper.executeNonQuery(con, sqlCustomerDetail);
			}
		}
		catch (Exception e) {
			throw new AncestryException("saveHoldJob  : "  + e.toString() , e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return flag;
	}
	
	/**
	 * get page 2
	 */
	 public FormType getPage2(long managementid) throws AncestryException {

		 FormType formType = new FormType();
		 Connection con = null;
		 ResultSet rs = null;
		 try {
			String sql = "SELECT id , filepath , filename FROM management_rework WHERE group_id = "+managementid+" AND formid =11";
            con = db.getConnectByProject(project);
            rs= JdbcHelper.queryToResultset(con, sql);
            if(rs.next()) {
            	formType.setID(rs.getLong("id"));
            	formType.setFilePath(rs.getString("filepath"));
            	formType.setFileName(rs.getString("filename"));
            }
		 }
		 catch (Exception e) {
			 throw new AncestryException("getPage2 : "  + e.toString() , e);
		 }finally {
			 JdbcHelper.closeRS(rs);
			 JdbcHelper.close(con);
		 }
		 return formType;
	}

}
