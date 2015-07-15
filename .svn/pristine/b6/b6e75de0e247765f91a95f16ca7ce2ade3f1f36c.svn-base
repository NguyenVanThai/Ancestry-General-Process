package com.digitexx.ancestry.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.digitexx.ancestry.bean.AuditResult;
import com.digitexx.ancestry.bean.ExportHeader;
import com.digitexx.ancestry.bean.ExportRecord;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.conts.BeanFieldDefinition;
import com.digitexx.ancestry.conts.BeanHeaderSQLite;
import com.digitexx.ancestry.conts.BeanRecordSQLite;
import com.digitexx.ancestry.db.ConnectionDB;
import com.digitexx.ancestry.db.ConnectionDB$SQLite;
import com.digitexx.ancestry.db.JdbcHelper;
import com.digitexx.ancestry.util.StringUtil;

public class DaoCheckAnrede {
	Tbl_Projects project;
	ConnectionDB db = ConnectionDB.getInstance();
	
	public DaoCheckAnrede(Tbl_Projects project) {
		this.project = project;
	}
	
	public String checkAnrede(Connection con,String given) throws Exception
	{
		String result 	     = ""; 
		CallableStatement cs = null;
		ResultSet rs  = null;
		//Connection con = null;
		try {
			//con = db.getConnectByProject(project);
			cs = con.prepareCall("SELECT sp_getanrede(i) FROM regexp_split_to_table(?, E' +') i GROUP BY sp_getanrede(i) ORDER BY 1");
			cs.setString(1, given);
			rs = cs.executeQuery();
			if(rs.next())
				result =  rs.getString(1);
		} 
		catch (SQLException ex) 
		{
			JdbcHelper.rollback(con);
			throw ex;
		} 
		finally 
		{
			JdbcHelper.closeRS(rs);
			JdbcHelper.closeCS(cs);
			//JdbcHelper.close(con);
		}
		return result;
	}
	
	
	public List<String> getListGiven(Tbl_Projects project,String field) throws Exception {
		List<String> listdata = new ArrayList<String>();
		Connection con = null;
		ResultSet rs  = null;
		String sql = "";
		String doc = "";
		try {
			con = db.getConnectByProject(project);
			sql = "SELECT "+field+" from p1_form_n_proof";
			rs = JdbcHelper.queryToResultset(con, sql);
			rs = JdbcHelper.queryToResultset(con, sql);
			while(rs.next())
			{
				doc = rs.getString(field);
				//if(!doc.equals("") && !doc.equals("null")){
					listdata.add(doc);
				//}
			}
		}
		catch (Exception e) {
			JdbcHelper.rollback(con);
			throw e;
		}
		finally {
            JdbcHelper.close(con);
		}
		return listdata;
	}
	
//	public List<String> getListGiven(Connection connection, String field) {
//		List<String> listdata = new ArrayList<String>();
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet					= null;
//		String sql							= "SELECT "+field+" from p1_form_n_proof";
//		String doc 					= "";
//		try {
//			preparedStatement = connection.prepareStatement(sql);						
//			//preparedStatement.setString(1, field);
//			resultSet = preparedStatement.executeQuery();
//			if (resultSet.next()) {
//				doc = resultSet.getString(field);
//				listdata.add(doc);
//				System.out.println("fffff : "+listdata);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally
//		{
//			try {
//				if(preparedStatement != null) preparedStatement.close();
//				if(resultSet != null) resultSet.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
//		return listdata;
//	}
	
	public  boolean updateCheckAnrede(Tbl_Projects project,String field, String checkanrede) {
		Connection con = null;
		boolean result = false;
		try {
			con = db.getConnectByProject(project);
			con.setAutoCommit(false);
			con.createStatement().execute(ConnectionDB.searchpath);
			String sql = "UPDATE " + "p1_form_n_proof " + " SET "
					+ " check_anrede_"+field+" = ?"
					+ " WHERE " + field+" = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, checkanrede);
			ps.setString(2, field);
			System.out.println(ps.toString());
			ps.execute();
			con.commit();
			result = true;
		} catch (Exception ex) {
			result = false;
			ex.toString();
		} finally {
			JdbcHelper.close(con);
		}
		return result;
	}
	
}
