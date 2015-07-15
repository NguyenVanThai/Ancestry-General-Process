/**
 * 
 */
package com.digitexx.ancestry.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.digitexx.ancestry.bean.BeanDefineRule;
import com.digitexx.ancestry.bean.BeanFinalForm;
import com.digitexx.ancestry.bean.BeanFinalRule;
import com.digitexx.ancestry.bean.FieldNameList;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.conts.RuleStatus;
import com.digitexx.ancestry.conts.TableName;
import com.digitexx.ancestry.db.BeanProcessor;
import com.digitexx.ancestry.db.ConnectionDB;
import com.digitexx.ancestry.db.JdbcHelper;
import com.digitexx.ancestry.util.AncestryException;
import com.digitexx.ancestry.util.JTableUtil;
import com.digitexx.ancestry.util.StringUtil;

/**
 * @author lqnhu
 *
 */
public class DaoFinal 
{
	private Tbl_Projects project;
	private String management = "";
	private String proof      = "";
	private BeanProcessor beanProcessor;
	private ConnectionDB db = ConnectionDB.getInstance();
	
	public DaoFinal(Tbl_Projects project) {
		this.project = project;
		this.beanProcessor = new BeanProcessor();
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
	 * get listFieldNameList
	 */
	public List<FieldNameList> getListFieldNameList() throws AncestryException {
		List<FieldNameList> listField = new ArrayList<FieldNameList>();
		Connection con =null;
		try {
			String sql = "SELECT * FROM (SELECT *,row_number() OVER (PARTITION BY fieldname ORDER BY id) AS row_number FROM fieldnamelist) AS rows WHERE row_number = 1 ORDER BY id desc";
			con = db.getConnectByProject(project);
			listField = JdbcHelper.queryToListBean(con, FieldNameList.class, sql, true);
		} catch (Exception e) {
			throw new AncestryException("getListFieldNameList : "  + e.toString() ,e);
		}finally {
			JdbcHelper.close(con);
		}
		return listField;
	}
	
	/**
	 * get list field
	 */
	public List<String> getListColumnTable() throws AncestryException{
		List<String> listColumn = new ArrayList<String>();
		Connection con = null;
		try {
            con = db.getConnectByProject(project);
            listColumn = JdbcHelper.getListColumnOfTable(con , proof);
            listColumn.remove("id");
            listColumn.remove("managementid");
            listColumn.remove("user_type");
            listColumn.remove("createdtime");
            listColumn.remove("user_final");
            listColumn.remove("seq_number");
            listColumn.remove("coordinates");
		}
		catch (Exception e) {
			throw new AncestryException("getListColumnTable : " +  e.toString(),e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listColumn;
	}
	
	/**
	 * get list dont witr
	 */
	public List<String> getListDontWrite() throws AncestryException{
		List<String> listData = new ArrayList<String>();
		Connection con = null;
		try {
			String sql = "SELECT characters FROM list_dontwrite";
            con = db.getConnectByProject(project);
            listData = JdbcHelper.queryToSingleList(con, sql, true);
		}
		catch (Exception e) {
			throw new AncestryException("getListDontWrite : " +  e.toString(),e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listData;
	}
	
	/**
	 * get list dont witr
	 */
	public List<String> getListNonUpper() throws AncestryException{
		List<String> listData = new ArrayList<String>();
		Connection con = null;
		try {
			String sql = "SELECT field_value FROM list_non_upper";
            con = db.getConnectByProject(project);
            listData = JdbcHelper.queryToSingleList(con, sql,true);
		}
		catch (Exception e) {
			throw new AncestryException("getListNonUpper : " +  e.toString(),e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listData;
	}
	
	/**
	 * get list field
	 */
	public Map<String , String> getMapField(List<FieldNameList> listFieldNameList , int type) throws AncestryException{
		Map<String , String> mapField = new LinkedHashMap<String, String>();
		try {
            String detail_field ="";
            String fieldname = "";
            String [] arr;
            
            for (FieldNameList fieldNameList  : listFieldNameList) 
            {
            	if( type == RuleStatus.check_dont_wite && fieldNameList.getCheck_dont_write() ==0) {
            		continue;
            	}
            	else if( type == RuleStatus.check_non_upper && fieldNameList.getCheck_in_list() ==0) {
            		continue;
            	}
            	else {
    				detail_field = StringUtil.setNotNull(fieldNameList.getDetail_field());
    				fieldname    = StringUtil.setNotNull(fieldNameList.getFieldname());

    				if(!detail_field.equals("")) 
    				{
    					if(detail_field.contains(";")) {
    						arr = detail_field.split(";",-1);
    						for (String tmp :  arr) {
    							mapField.put(tmp, fieldname);
    						}
    					}else {
    						mapField.put(detail_field, fieldname);
    					}
    				}
            	}

			}
		}
		catch (Exception e) {
			throw new AncestryException("getMapField " +  e.toString(),e);
		}
		return mapField;
	}
	
	
	
	/**
	 * get data from sql command
	 */
	public List<Object[]> getData(String sql) throws AncestryException 
	{
		List<Object[]> listData = new ArrayList<Object []>();
		Connection con =null;
		try {
			con = db.getConnectByProject(project);
			listData = JdbcHelper.queryToListObject(con, sql);
		} catch (Exception e) {
			throw new AncestryException("getData : "  + e.toString(),e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listData;
	}
	
	public void loadDataBySqlCommand(String sql, JTable table , JTextField txtSearchData, boolean hasColumnNo ) throws AncestryException 
	{
		Connection con =null;
		try {
			con = db.getConnectByProject(project);
			JdbcHelper.queryToJtable(con, sql, table, txtSearchData ,hasColumnNo);
		} catch (Exception e) {
			throw new AncestryException("getData : "  + e.toString(),e);
		}
		finally {
			JdbcHelper.close(con);
		}
	}
	
	/**
	 * check existed rulename or sql command
	 */
	public boolean checkExistRule(String ruleName) throws AncestryException {

		boolean flag = false;
		Connection con = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = "SELECT id FROM final_rule WHERE rulename ='"+ ruleName +"'";
			con = db.getConnectByProject(project);
			rs = JdbcHelper.queryToResultset(con, sql);
			if(rs.next()) flag = true ;
			else flag = false;
		} 
		catch (Exception e) {
			throw new AncestryException("checkExistRule : "  + e.toString(),e);
		}
		finally {
			JdbcHelper.close(con);
			JdbcHelper.close(con);
		}
		return flag;
	}
	
	/**
	 * delete rule by condition
	 */
	public boolean deleteRuleById(String id) throws AncestryException {
		boolean flag = false;
		Connection con = null;
		try {
			String sql = "DELETE FROM final_rule WHERE id="+id+"";
			con = db.getConnectByProject(project);
			flag = JdbcHelper.executeNonQuery(con, sql);
		}
		catch (Exception e) {
			throw new AncestryException("deleteRuleById : "  + e.toString(),e);
		}finally {
			JdbcHelper.close(con);
		}
		return flag;
	}
	
	//=====================================================================================================================
	
	
	/**
	 * get list form rule
	 */
	public List<BeanFinalForm> getListFormRule() throws AncestryException{

		List<BeanFinalForm> listFinalForm = new ArrayList<BeanFinalForm>();
		Connection con = null;
		ResultSet rs =null;
		try {
			String sql ="SELECT * FROM final_form order by id";
			con  = db.getConnectByProject(project);
			rs  = JdbcHelper.queryToResultset(con, sql);
			BeanFinalForm beanFinalForm;
			while(rs.next()) {
				beanFinalForm = new BeanFinalForm();
				beanFinalForm.setId(rs.getInt("id"));
				beanFinalForm.setForm_ids(rs.getString("form_ids"));
				beanFinalForm.setForm_name(rs.getString("form_name"));
				beanFinalForm.setForm_rules(rs.getString("form_rules"));
				listFinalForm.add(beanFinalForm);
			}
			
		} catch (Exception e) {
			throw new AncestryException("getListForm : "  + e.toString(),e);
		}finally {
			JdbcHelper.close(con);
		}
		return listFinalForm;
	}
	
	/**
	 * get list form rule
	 */
	public List<BeanFinalRule> getListRule(String formRule) throws AncestryException{

		List<BeanFinalRule> listFinalRule = new ArrayList<BeanFinalRule>();
		Connection con = null;
		try {
			String sql = "SELECT * FROM final_rule WHERE id IN "+ formRule +" ORDER BY id";
			con  = db.getConnectByProject(project);
			listFinalRule = JdbcHelper.queryToListBean(con, BeanFinalRule.class, sql, true);		
		} catch (Exception e) {
			throw new AncestryException("getListRule : "  + e.toString(),e);
		}finally {
			JdbcHelper.close(con);
		}
		return listFinalRule;
	}
	
	/**
	 * get list rule by from
	 */
	public List<BeanFinalRule> getListRuleByForm(BeanFinalForm beanFinalForm , boolean isInForm) throws AncestryException{

		List<BeanFinalRule> listFinalRule = new ArrayList<BeanFinalRule>();
		Connection con = null;
		String sql = "";
		try {
			if(isInForm) {
				sql = "SELECT * FROM final_rule where id IN "+beanFinalForm.getForm_rules()+" ORDER BY id ";
			}else {
				sql = "SELECT * FROM final_rule where id NOT IN "+beanFinalForm.getForm_rules()+" ORDER BY id ";
			}
			con  = db.getConnectByProject(project);
			listFinalRule = JdbcHelper.queryToListBean(con, BeanFinalRule.class, sql, true);		
		} catch (Exception e) {
			throw new AncestryException("getListRuleByForm : "  + e.toString(),e);
		}finally {
			JdbcHelper.close(con);
		}
		return listFinalRule;
	}
	
	/**
	 * get list form rule
	 */
	public List<BeanDefineRule> getListDefineRule(int group_rule) throws AncestryException{

		List<BeanDefineRule> listFinalRule = new ArrayList<BeanDefineRule>();
		Connection con = null;
		try {
			String sql = "SELECT * FROM define_rule WHERE group_rule ="+group_rule+" ORDER BY id";
			con  = db.getConnectAncestryQC(project);
			listFinalRule = JdbcHelper.queryToListBean(con, BeanDefineRule.class, sql, true);		
		} catch (Exception e) {
			throw new AncestryException("getListDefineRule : "  + e.toString(),e);
		}finally {
			JdbcHelper.close(con);
		}
		return listFinalRule;
	}
	
	/**
	 * get list paths
	 */
	public List<String> getListPath( ) throws AncestryException{

		List<String> listPath = new ArrayList<String>();
		Connection con = null;
		String sql = "";
		try {
		    sql = "SELECT filepath FROM " + management + " m  JOIN form_info f ON m.formid = f.form_id GROUP BY 1 HAVING ARRAY_AGG(DISTINCT CASE WHEN badimage = 1 THEN 4 WHEN is_key THEN step ELSE 4 END)='{4}'ORDER BY 1 ";
            con = db.getConnectByProject(project);
            listPath = JdbcHelper.queryToSingleList(con, sql,true);
		}
		catch (Exception e) {
            throw new AncestryException("getListPath : "  + e.toString(),e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listPath;
	}
	
	/**
	 * get list paths
	 */
	public List<String> getListForm( ) throws AncestryException{

		List<String> listPath = new ArrayList<String>();
		Connection con = null;
		String sql = "";
		try {
		    sql = "SELECT name FROM form_info WHERE is_key ORDER BY form_id ";
            con = db.getConnectByProject(project);
            listPath = JdbcHelper.queryToSingleList(con, sql,true);
		}
		catch (Exception e) {
            throw new AncestryException("getListPath : "  + e.toString(),e);
		}
		finally {
			JdbcHelper.close(con);
		}
		return listPath;
	}
	
	/**
	 * save rule
	 */
	public boolean saveRule(BeanFinalRule beanFinalRule) throws AncestryException {
        boolean flag = false;
        Connection con = null;
        try {
			con = db.getConnectByProject(project);
			flag = JdbcHelper.saveBean(con, TableName.final_rule, BeanFinalRule.class, beanFinalRule, "id");
		} catch (Exception e) {
			throw new AncestryException("saveRule : "  + e.toString(),e);
		}
        finally {
        	JdbcHelper.close(con);
        }
		return flag;
	}
	
	/**
	 * update rule
	 */
	public boolean updateRule(BeanFinalRule beanFinalRule) throws AncestryException {
		Connection con =null;
		PreparedStatement pst = null;
		boolean flag = false;
        try {
			String sql = "UPDATE final_rule SET rulenote =? , condition =? , rulefield =? WHERE id =?";
			con = db.getConnectByProject(project);
			pst = con.prepareStatement(sql);
			pst.setString(1, beanFinalRule.getRuleNote());
			pst.setString(2, beanFinalRule.getCondition());
			pst.setString(3, beanFinalRule.getRuleField());
			pst.setLong(4, beanFinalRule.getId());
			pst.execute();
			con.commit();
			flag = true;
		} 
        catch (Exception e) {
			flag = false;
			throw new AncestryException("updateRule : "  + e.toString(),e);
		} finally {
			JdbcHelper.close(con);
		}
        return flag;
	}
	
	public boolean getData(boolean isrework, DefaultTableModel model, String allColumn, String formName,String ruleName, String filePaths) throws AncestryException {
		boolean result = false;
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		String sql = "{? = call sp_check_final(?,?,?)}";
		if (isrework) {
			sql = "{? = call sp_check_final_rework(?,?,?)}";
		}
		try {
			con = db.getConnectByProject(project);
			cs = con.prepareCall(sql);
			cs.registerOutParameter(1, Types.OTHER);
			cs.setString(2, formName);
			cs.setString(3, filePaths);
			cs.setString(4, ruleName);

			cs.execute();
			rs = (ResultSet) cs.getObject(1);
			JTableUtil.setHeaderAndData(model, rs, allColumn);
			result = true;
		} catch (Exception e) {
			throw new AncestryException("getData : " + e.toString(),e);
		} finally {
			JdbcHelper.closeRS(rs);
			JdbcHelper.closeCS(cs);
			JdbcHelper.close(con);
		}
		return result;
	}
	
	/**
	 * get BeanFinalForm by id
	 */
	public BeanFinalForm getBeanFinalFormByName(String form_name) throws AncestryException{
		BeanFinalForm beanFinalForm = new BeanFinalForm();
		Connection con =null;
		ResultSet rs =null;
		try {
			String sql = "SELECT * FROM final_form WHERE form_name='"+form_name+"'";
			con = db.getConnectByProject(project);
			rs = JdbcHelper.queryToResultset(con, sql);
			while(rs.next()) {
				beanFinalForm.setId(rs.getInt("id"));
				beanFinalForm.setForm_name(rs.getString("form_name"));
				beanFinalForm.setForm_ids(rs.getString("form_ids"));
				beanFinalForm.setForm_rules(rs.getString("form_rules"));
			}
		} catch (Exception e) {
			throw new AncestryException("getBeanFinalFormById : " +  e.toString(),e);
		}finally {
			JdbcHelper.close(con);
		}
		return beanFinalForm;
		
	}
	
	/**
	 * save form_rule
	 */
	public boolean saveFormRule(BeanFinalForm beanFinalForm) throws AncestryException {
		boolean flag = false;
		Connection con = null;
		try {
			con = db.getConnectByProject(project);
			flag = JdbcHelper.saveBean(con, TableName.final_form , BeanFinalForm.class, beanFinalForm, "");
		} catch (Exception e) {
			throw new AncestryException("saveFormRule : "  + e.toString(),e);
		}finally {
			JdbcHelper.close(con);
		}
		return flag;
	}
	
	/**
	 * assign rule by form
	 */
	public boolean updateFormRule(BeanFinalForm beanFinalForm) throws AncestryException {
		boolean flag = false;
		Connection con = null;
		String sql = "";
		try {
			sql = "UPDATE final_form SET form_rules ='"+beanFinalForm.getForm_rules()+"' WHERE id ="+beanFinalForm.getId()+"";
			con = db.getConnectByProject(project);
			flag = JdbcHelper.executeNonQuery(con, sql);
		} catch (Exception e) {
			throw new AncestryException("assignRule : "  + e.toString(),e);
		}finally {
			JdbcHelper.close(con);
		}
		return flag;
	}
	
}
