/**
 * 
 */
package com.digitexx.ancestry.dao;

import jar.e;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.swing.JTextPane;

import com.digitexx.ancestry.bean.AuditResult;
import com.digitexx.ancestry.bean.CustomerFeedback;
import com.digitexx.ancestry.bean.CustomerFeedbackDetail;
import com.digitexx.ancestry.bean.SubInfor;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.conts.EnumFieldAge;
import com.digitexx.ancestry.conts.EnumSpecialField;
import com.digitexx.ancestry.db.ConnectionDB;
import com.digitexx.ancestry.db.ConnectionDB$SQLite;
import com.digitexx.ancestry.db.JdbcHelper;
import com.digitexx.ancestry.util.AncestryException;
import com.digitexx.ancestry.util.AppUtility;
import com.digitexx.ancestry.util.StringUtil;

/**
 * @author lqnhu
 *
 */
public class DaoImportFeedback {
	
	private ConnectionDB$SQLite db$sqLite ;
	private JTextPane textPaneLog ;
	private Tbl_Projects project;
	private ConnectionDB db = ConnectionDB.getInstance();
	
	public DaoImportFeedback(JTextPane textPaneLog , Tbl_Projects project) {
		this.textPaneLog = textPaneLog;
		db$sqLite 	= new ConnectionDB$SQLite();
		this.project = project;
	}
	
	/**
	 * get list feedback data
	 */
	public List<AuditResult> getListFeedBackData(String pathSqlLite) throws AncestryException {
		List<AuditResult>listFeedback = new ArrayList<AuditResult>();
		Connection con = null;
		ResultSet rs= null;
		String sql = "";
		try {
			sql = "	SELECT ar.* FROM AuditResult ar " + 
				  "	JOIN ( SELECT imagename, max(AuditDate) AS AuditDate FROM AuditResult GROUP BY imagename) AS x " + 
				  "	ON ar.[ImageName] = x.imagename AND x.AuditDate = ar.AuditDate " + 
				  "	WHERE  ar.result = 'Failed' ORDER BY ar.AuditDate Desc, ar.ImageName ";
			
			con = db$sqLite.getCon(pathSqlLite);
			rs = JdbcHelper.queryToResultset(con, sql);
			AuditResult auditResult;
			while(rs.next())
			{
				auditResult = new AuditResult();
				auditResult.setAuditDate(java.sql.Timestamp.valueOf(rs.getString("AuditDate")));
				auditResult.setImageName(StringUtil.setNotNull(rs.getString("ImageName")));
				auditResult.setSequenceNum(rs.getInt("SequenceNum"));
				auditResult.setAuditStep(rs.getString("AuditStep"));
				auditResult.setFieldName(StringUtil.setNotNull(rs.getString("FieldName")));
				auditResult.setFieldValue(StringUtil.setNotNull(rs.getString("FieldValue")));
				auditResult.setResult(StringUtil.setNotNull(rs.getString("Result")));
				auditResult.setFailureReason(StringUtil.setNotNull(rs.getString("FailureReason")));
				listFeedback.add(auditResult);
			}
		}
		catch (Exception e) {
			throw new AncestryException("getListFeedBackData : "  + e.toString() ,e);
		}
		finally {
            JdbcHelper.close(con);
		}
		
		return listFeedback;
	}
	
	
	/**
	 * get filepth
	 */
	public String getFilePath(String batchName) throws AncestryException{
		
		Connection con = null;
		ResultSet rs	= null;
		String sql		= "";
		String imagePath= "";
		try {
			sql		= "SELECT filepath FROM management_rework WHERE filepath like '%"+batchName+"%' GROUP BY filepath";
			con = db.getConnectByProject(project);
			rs = JdbcHelper.queryToResultset(con, sql);
			if (rs.next()) {
				imagePath = rs.getString("filepath");
			}
		}
		catch (Exception e) {
			throw new AncestryException("getFilePath : "  + e.toString() ,e);
		}
		finally
		{
			JdbcHelper.closeRS(rs);
			JdbcHelper.close(con);
		}
		return imagePath;
	}
	
	
	/**
	 * get data from table check_export
	 */
	public Map<String, String> getMapCheckExport() throws AncestryException
	{
		Connection con 	= null;
		ResultSet rs 	= null;
		String sql 				= "SELECT column_name_sqllite , column_name_final FROM check_export";
		Map<String, String> hashMapColumnIMPORT = new HashMap<String, String>();
		try {
			con = db.getConnectByProject(project);
			rs = JdbcHelper.queryToResultset(con, sql);
			while (rs.next()) {
				hashMapColumnIMPORT.put(rs.getString("column_name_sqllite").trim(),
						                rs.getString("column_name_final").trim());
			}
		}
		catch (Exception ex) {
			throw new AncestryException("getMapCheckExport : "  + ex.toString() , ex);
		}
		finally
		{
			JdbcHelper.closeRS(rs);
			JdbcHelper.close(con);
		}
		return hashMapColumnIMPORT;
	}
	
	
	/**
	 * get version file export
	 */
	public Integer getVersionExportFile(String pathSlLite) throws AncestryException
	{
		Integer version = 0;
		ResultSet rs    = null;
		Connection con  = null;
		try {
			con = db$sqLite.getCon(pathSlLite);
			String sql = "SELECT * FROM audit GROUP BY date(completed) ORDER BY 1";
			rs = JdbcHelper.queryToResultset(con, sql);
			while (rs.next()) {
				version ++;
			}
		} 
		catch (Exception ex) {
			throw new AncestryException("getVersionExportFile : " + ex.toString() ,ex );
		}
		finally
		{
//          JdbcHelper.closeRS(rs);
            JdbcHelper.close(con);
		}
		return version;
	}
	
	
	/**
	 * get version file import
	 */
	public Integer getVersionImport(String batchName) throws AncestryException
	{
		Connection con          = null;
		Integer version 		= 0;
		ResultSet rs 	= null;
		try {
			String sql 	= "select count(*) from customer_feedback where image_path like '%"+batchName+"%' GROUP BY date(audit_date) ORDER BY 1";
			con = db.getConnectByProject(project);
			rs = JdbcHelper.queryToResultset(con, sql);
			while (rs.next()) {
				version ++; 
			}
		} 
		catch (Exception ex) {
			throw new AncestryException("getVersionImport : " + ex.toString() ,ex );
		}
		finally
		{
			JdbcHelper.closeRS(rs);
			JdbcHelper.close(con);
		}
		return version;
	}
	
	
	
	
	/**
	 * get map management
	 */
	public HashMap<String, SubInfor> getMapManagement( String filepath , String allImageName) throws AncestryException
	{
		HashMap<String, SubInfor> mapManagement = new HashMap<String , SubInfor>();
	    Connection con = null;
	    ResultSet rs = null;
	    String sql = "";
	    try {
			sql = "SELECT m.id , filename , formid FROM management_rework m"
				+ " WHERE filepath ='"+filepath+"' AND filename IN ("+ allImageName +")";
			con = db.getConnectByProject(project);
			rs = JdbcHelper.queryToResultset(con, sql);
			
			SubInfor subInfor ;
			while(rs.next()) 
			{
				subInfor = new SubInfor();
				subInfor.setId(rs.getLong("id"));
				subInfor.setFilename(rs.getString("filename"));
				subInfor.setFormid(rs.getInt("formid"));
				mapManagement.put(rs.getString("filename"), subInfor);
			}
		}
	    catch (Exception e) {
	    	throw new AncestryException("getMapManagement : "  + e.toString() ,e);
		}
		finally {
			JdbcHelper.closeRS(rs);
			JdbcHelper.close(con);
		}
		return mapManagement;
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
				count = count + 1;
			}
		} 
        catch (Exception e) {
        	throw new AncestryException("getCountByFilePath : "  + e.toString() ,e);
		}			
        finally {
        	JdbcHelper.close(con);
        }
		return count;
	}
	
	/**
	 * get string image name
	 */
	public String getStringImageName(List<AuditResult> listAuditResult) 
	{
		String result = "";
		List<String> listImage = new ArrayList<String>();
		String filename = "";
		for (AuditResult auditResult : listAuditResult)
		{
			filename  = "'" + auditResult.getImageName() + ".j2k" + "'";
			listImage.add(filename);
		}
		result = StringUtil.join(listImage, ",");
		return result;
	}
	
	/**
	 * get all image name from file DB3
	 */
	private String getAllImageName(List<AuditResult> listFeedbackData) 
	{
		String result = "";
		List<String> listTmp = new ArrayList<String>();
		for (AuditResult auditResult : listFeedbackData) 
		{
			listTmp.add("'"+auditResult.getImageName()+".j2k"+"'");
		}
		result = StringUtil.join(listTmp, ",");
		return result;
	}
	
	/**
	 * save data customer_feedback , customer_feedback_detail
	 */
	public boolean saveFeedBack(List<AuditResult> listFeedbackData ,
		                    	String pathDB3 , String filepath , 
			                    String batchName ,  
			                    Map<String, String> mapCheckExport ,
			                    boolean importExist,
			                    boolean checkImportNew ) throws AncestryException
	{
		boolean flag = false;
		Connection con = null;
		List<CustomerFeedback> listFeedback  = new ArrayList<CustomerFeedback>();
		CustomerFeedback  customerFeedback;
		SubInfor subInfor;
		String allImageName = "";
		String filename = "";
		String valueCheck = "";
		String group_field = "";
		int count = 0;
		int seq_number = 0;
        try 
        {
        	allImageName = Objects.toString(getStringImageName(listFeedbackData) ,"");
        	if(allImageName.equals("")) {
        		AppUtility.appendText(textPaneLog, "Not found data rework in batch " + batchName, Color.PINK);
        	}else {
            	HashMap<String, SubInfor> mapManagement = getMapManagement( filepath , allImageName);
    			HashMap<String, String> mapCheckImport = getMapFeedBackByPath( filepath);
            	count = getCountByFilePath(filepath);

            	String value = "";
    			for (AuditResult auditResult : listFeedbackData)
    			{
    				customerFeedback   = new CustomerFeedback();
    				filename = auditResult.getImageName()+".j2k";
    				seq_number = auditResult.getSequenceNum();
    				seq_number = seq_number +1;
    				valueCheck = auditResult.getFieldName() + "|" +  auditResult.getFailureReason() + "|" + auditResult.getFieldValue();
    				
    				if(mapCheckImport != null) {
        				if(!importExist) 
        				{
        					value = Objects.toString(mapCheckImport.get(filepath + "/"+ filename), "");
        					if(value.equals(valueCheck))
        					{
        						AppUtility.appendText(textPaneLog, batchName + "==>" + filename + "==>" +
        						auditResult.getFailureReason() + "==>" + auditResult.getFieldName() + " : has been imported before !!" , Color.RED);
        					    continue;
        					}
        				}
        				
        				if(!checkImportNew && count > 1) 
        				{
        					if(mapCheckImport.containsKey(filepath + "/"+ filename))
        					{
        						group_field = mapCheckImport.get(filepath + "/"+ filename);
        						group_field = group_field.substring(0 , group_field.indexOf("|"));
        						
        						if(!group_field.equals(auditResult.getFieldName())) 
        						{
        							AppUtility.appendText(textPaneLog, batchName + "==>" + filename + "==>" + " : are new group fields !!" , new java.awt.Color(92, 163, 117));
        							continue;
        						}
        						
        					}
        				}
    				}
    				
    				if(mapManagement.containsKey(filename)) 
    				{
    					subInfor  = mapManagement.get(filename);
    					customerFeedback.setManagement_id(subInfor.getId());
    					customerFeedback.setAudit_date(auditResult.getAuditDate());
    					customerFeedback.setImage_path(filepath);
    					customerFeedback.setImage_name(filename);
    					customerFeedback.setSeq_number(seq_number);
    					customerFeedback.setGroup_field(auditResult.getFieldName());
    					customerFeedback.setValue_db3(auditResult.getFieldValue());
    					customerFeedback.setFailure_reason(auditResult.getFailureReason());
    					customerFeedback.setNote("");
    					customerFeedback.setIs_analyzed(false);
    					customerFeedback.setIs_rework(false);
    					customerFeedback.setImport_date(new Timestamp(Calendar.getInstance().getTime().getTime()));
    					customerFeedback.setFolder(pathDB3);
    					customerFeedback.setCount(count);
    					
    					listFeedback.add(customerFeedback);
    				}
    				else {
    					AppUtility.appendText(textPaneLog, filename + " : not found in MANAGEMENT_REWORK !!" , Color.RED);
    					continue;
    				}
    			}
    			if(listFeedback.size() > 0) {
    				con = db.getConnectByProject(project);
    				flag = JdbcHelper.saveListBean(con, "customer_feedback", CustomerFeedback.class, listFeedback, "id" , true);
    				saveFeedbackDetail(filepath, mapCheckExport);
    			}
        	}

		} 
        catch (Exception e) {
        	throw new AncestryException("saveFeedBack : "  + e.toString() ,e);
		}
        finally {
        	JdbcHelper.close(con);
        }
		return flag;
	}
	
	public static String getValueAge(ResultSet rs, String key){
		String valueAge = "";
		try {
			String age_Jahr   = StringUtil.setNotNull(rs.getString("age_" + key + "_jahr"));
			String age_Monat  = StringUtil.setNotNull(rs.getString("age_" + key + "_monat"));
			String age_Woche  = StringUtil.setNotNull(rs.getString("age_" + key + "_woche"));
			String age_Tag    = StringUtil.setNotNull(rs.getString("age_" + key + "_tag"));
			String age_Stunde = StringUtil.setNotNull(rs.getString("age_" + key + "_stunde"));
			valueAge = age_Jahr.trim() + "|" + age_Monat.trim() + "|" + age_Woche.trim() + "|" 
					  + age_Tag.trim() + "|"+ age_Stunde.trim() + "|";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return valueAge;
	}
	
	
    /**
	 * save feedback_detail
	 */
	public boolean saveFeedbackDetail( String filepath ,  Map<String, String> mapCheckExport) throws AncestryException
	{
		boolean flag = false;
		Connection con = null;
		ResultSet rs = null;
		String sql = "";
		String group_field = "";
		String [] arrField;
		String field = "";
		String valueDPO = "";
		String wrong_form = "";
		CustomerFeedbackDetail customerFeedbackDetail;
		List<CustomerFeedbackDetail> listFeedbackDetail = new ArrayList<CustomerFeedbackDetail>();
		Map<String , String> mapEnumAge = EnumFieldAge.toMap();
		Map<String , String> mapSpecialField = EnumSpecialField.toMap();
		try {
			
			 sql    = "SELECT * from ( SELECT * FROM " 
					+ "customer_feedback c LEFT JOIN management_rework m ON " 
					+ "c.image_path = m.filepath AND c.image_name = m.filename " 
					+ "WHERE image_path ='"+filepath+"'"
					+ "AND is_analyzed = false )as cm "
					+ "LEFT JOIN p1_form_n_proof_rework p "
					+ "ON cm.management_id = p.managementid AND cm.seq_number = p.seq_number ";  
			
			con = db.getConnectByProject(project);
			rs  = JdbcHelper.queryToResultset(con, sql);
			
			while(rs.next()) 
			{
				group_field = StringUtil.setNotNull(rs.getString("group_field"));
				wrong_form  = rs.getString("failure_reason");
				customerFeedbackDetail = new CustomerFeedbackDetail();
				if(!group_field.equals(""))
				{
					    customerFeedbackDetail = setValueCustomerFeedbackDetail(rs);
					    if(group_field.contains(",")) 
					    {
					    	arrField = group_field.split(",");
					    	for (String str : arrField)
					    	{
					    		field = StringUtil.setNotNull(mapCheckExport.get(str));
					    		if(field.endsWith("_export")) {
					    			field  = field.replace("_export", "");
					    		}
					    		if(field.equals("")) {
					    			AppUtility.appendText(textPaneLog, str + " : check config data in table CHECK_EXPORT !!" , Color.RED);
					    		}
						    	if(wrong_form.indexOf("Wrong Form") == -1 && wrong_form.indexOf("Wrong Record Count") == -1) 
						    	{
							    	if(mapEnumAge.containsKey(str)) {
								    	valueDPO = getValueAge(rs, mapEnumAge.get(field));
							    	}else {
				                         valueDPO = StringUtil.setNotNull(rs.getString(field));
							    	}
						    	}
						    	customerFeedbackDetail.setValue_dpo(valueDPO);
						    	if(mapSpecialField.containsKey(field)) {
							         field = mapSpecialField.get(field);	
							    }
						    	customerFeedbackDetail.setField(field);
							    listFeedbackDetail.add(customerFeedbackDetail);
								customerFeedbackDetail = setValueCustomerFeedbackDetail(rs);
							}
					    }
					    else 
					    {
				    		field = StringUtil.setNotNull(mapCheckExport.get(group_field));
				    		if(field.endsWith("_export")) {
				    			field  = field.replace("_export", "");
				    		}
				    		if(field.equals("")) {
				    			AppUtility.appendText(textPaneLog, group_field + " : check config data in table CHECK_EXPORT !!" , Color.RED);
				    		}

								if (wrong_form.indexOf("Wrong Form") == -1 && 
								wrong_form.indexOf("Wrong Record Count") == -1)
								{
									if (mapEnumAge.containsKey(field)) {
										valueDPO = getValueAge(rs,mapEnumAge.get(field));
									} else {
										valueDPO = StringUtil.setNotNull(rs.getString(field));
									}
								}
					    		customerFeedbackDetail.setValue_dpo(valueDPO);
					    		
					    		if(mapSpecialField.containsKey(field)) {
					    		   field = mapSpecialField.get(field);	
					    		}
						    	customerFeedbackDetail.setField(field);
						    	listFeedbackDetail.add(customerFeedbackDetail);
				    		

					    }
					}

			}
			flag = JdbcHelper.saveListBean(con, "customer_feedback_detail",CustomerFeedbackDetail.class, listFeedbackDetail, "id,rework_type" , true);
			
		} catch (Exception e) {
			throw new AncestryException("saveFeedbackDetail : "  + e.toString() ,e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return flag;
	}
	

	public CustomerFeedbackDetail setValueCustomerFeedbackDetail(ResultSet rs) throws Exception {

		CustomerFeedbackDetail customerFeedbackDetail = new CustomerFeedbackDetail();
		customerFeedbackDetail.setManagement_id(rs.getLong("management_id"));
		customerFeedbackDetail.setForm_id(rs.getInt("formid"));
		customerFeedbackDetail.setImage_path(rs.getString("image_path"));
		customerFeedbackDetail.setImage_name(rs.getString("image_name"));
		customerFeedbackDetail.setSeq_number(rs.getInt("seq_number"));
		customerFeedbackDetail.setGroup_field(rs.getString("group_field"));
		customerFeedbackDetail.setValue_db3(rs.getString("value_db3"));
		customerFeedbackDetail.setFailure_reason(rs.getString("failure_reason"));
        customerFeedbackDetail.setImport_date(new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()));
		customerFeedbackDetail.setFolder(rs.getString("folder"));
    	customerFeedbackDetail.setUser_type(rs.getString("user_type"));
		customerFeedbackDetail.setCount(rs.getInt("count"));
		customerFeedbackDetail.setIs_rework_field(false);
		customerFeedbackDetail.setIs_analyzed(false);
		
		return customerFeedbackDetail;
	}
	
	public static String getStringAuditResult(List<AuditResult> listAuditResult) throws AncestryException
	{
		String result = "";
		List<String> listTmp = new ArrayList<String>();
		int seq_number = 0;
		for (AuditResult auditResult : listAuditResult) 
		{
			listTmp.add(auditResult.getAuditDate()+"");
			listTmp.add(auditResult.getFieldName());
			listTmp.add(auditResult.getFieldValue());
			listTmp.add(auditResult.getFailureReason());
			seq_number = auditResult.getSequenceNum();
			seq_number = seq_number + 1;
			listTmp.add(seq_number+"");
		}
		result = StringUtil.join(listTmp, "|");
		return result;
	}
	
	
	public  HashMap<String, String> getMapFeedBackByPath(String imagePath) throws AncestryException
	{
		HashMap<String, String> mapData = new HashMap<String , String>();
		Connection con = null;
		ResultSet rs  = null;
		String sql = "";
		try 
		{
			sql = "select c.* from customer_feedback c where image_path ='"+imagePath+"'";
			con = db.getConnectByProject(project);
			rs = JdbcHelper.queryToResultset(con, sql);
			
			String group_field = "";
			String image_name = "";
			String failure_reason = "";
			String value_db3 = "";
			while (rs.next()) 
			{
				group_field = StringUtil.setNotNull(rs.getString("group_field"));
				image_name  = StringUtil.setNotNull(rs.getString("image_name"));
				failure_reason  = StringUtil.setNotNull(rs.getString("failure_reason"));
				value_db3  = StringUtil.setNotNull(rs.getString("value_db3"));
				mapData.put(imagePath + "/" + image_name,  group_field +  "|" +failure_reason +"|"  + value_db3);
			}
		} 
		catch (Exception e) {
			throw new AncestryException("getMapFeedBackByPath : "  + e.toString() , e);
		}
		finally
		{
			JdbcHelper.closeRS(rs);
			JdbcHelper.close(con);
		}
		return mapData;
	}
	
	/**
	 * update status feedback
	 */
	public boolean updateStatusFeedBack(String filepath , int count , int status) throws AncestryException
	{
		boolean flag = false;
		Connection con = null;
		String sql = "";
		try {
			if(status ==0) {
				sql = "UPDATE customer_feedback SET is_analyzed = true WHERE image_path ='"+filepath+"' AND count ="+count+"";
			}else {
				sql = "UPDATE customer_feedback_detail SET is_analyzed = true WHERE image_path ='"+filepath+"' AND count ="+count+"";
			}
			con = db.getConnectByProject(project);
			flag = JdbcHelper.executeNonQuery(con, sql);
		}
		catch (Exception e) {
			throw new AncestryException("updateStatusFeedBack : "  + e.toString() , e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return flag;
	}
	
	/**
	 * get map seq_number by filepath
	 */
	public List<String> getListSeqNumberByFilePath(String filepath , String image_name) throws AncestryException
	{
		List<String> listData = new ArrayList<String>();
		String filename = "";
		int seq_number = 0;
		Connection con = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = "SELECT p.seq_number , m.filename FROM p1_form_n_proof_rework p JOIN management_rework m ON m.id = p.managementid "
				+ " WHERE m.filename IN ("+image_name+") AND m.filepath ='"+filepath+"' ORDER BY p.id";
			con = db.getConnectByProject(project);
			rs = JdbcHelper.queryToResultset(con, sql);
			
			while(rs.next())
			{
				filename  = rs.getString("filename");
				seq_number = rs.getInt("seq_number");
				listData.add(filename+ "|" + seq_number);
			}
			
		} 
		catch (Exception e) {
			throw new AncestryException("getListSeqNumberByFilePath : "  + e.toString() ,e);
		}
		finally {
			JdbcHelper.closeRS(rs);
			JdbcHelper.close(con);
		}
		return listData;
	}

}
