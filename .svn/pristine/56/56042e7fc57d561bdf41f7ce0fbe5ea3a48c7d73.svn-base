/**
 * 
 */
package com.digitexx.ancestry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.db.ConnectionDB;
import com.digitexx.ancestry.db.JdbcHelper;
import com.digitexx.ancestry.util.AncestryException;

/**
 * @author lqnhu
 *
 */
public class DaoMoveDataFromTypeToProof {

	private ConnectionDB db = ConnectionDB.getInstance();

	/**
	 * get list column type
	 */
	public ArrayList<String> getListColumType(Tbl_Projects project) throws AncestryException
	{
		ArrayList<String> listColumn = new ArrayList<String>();
		Connection con =null;
		try {
			con = db.getConnectByProject(project);
			listColumn = JdbcHelper.getListColumnOfTable(con, "p1_form_n_type");
		} 
		catch (Exception e)
		{
			throw new AncestryException("getListColumType : "  + e.toString() , e);
		}finally {
			JdbcHelper.close(con);
		}
		return listColumn;
	}
	
	/**
	 * get list data type by column
	 */
	public List<Object[]> getListDataTypeByColumn(Tbl_Projects project , String columns , String ids) throws AncestryException {

		List<Object[]> listData = new ArrayList<Object[]>();
		Connection con =null;
		ResultSet rs = null;
        String sql = "";
        try {
			sql = "select "  + columns  + " from p1_form_n_type" + " where managementid in ("+ ids +") order by managementid , seq_number";
			con = db.getConnectByProject(project);
			rs = JdbcHelper.queryToResultset(con, sql);
			Object []  values ;
			
			ResultSetMetaData rsmd = rs.getMetaData();
			String columnName = "";
			int totalCol = rsmd.getColumnCount();
			while(rs.next()) 
			{
				values = new Object [totalCol];
				for (int i = 1; i < totalCol +1; i++) {
					columnName = rsmd.getColumnName(i);
					values[(i-1)] = rs.getObject(columnName);
				}
				listData.add(values);
			}
		} 
        catch (Exception e) {
			throw new AncestryException("getListDataTypeByColumn : "  + e.toString() , e);
		}
        finally {
        	JdbcHelper.closeRS(rs);
        	JdbcHelper.close(con);
        }
		return listData;
	}
	
	/**
	 * save data
	 */
	public boolean save(Tbl_Projects project , List<String[]> listData) throws AncestryException
	{
       boolean flag = false;
       Connection con = null;
       PreparedStatement pst = null;
       String sql ="";
       try 
       {
		   con = db.getConnectByProject(project);
		   for (String [] arr : listData) 
		   {
    		   sql = "update p1_form_n_proof set birth_place = ? where managementid =? and seq_number = ?";
               pst = con.prepareStatement(sql);
			   
               pst.setString(1, arr[0]);
               pst.setLong (2, Long.parseLong(arr[1]));
               pst.setInt(3, Integer.parseInt(arr[2]));
               pst.execute();
		   }
		   con.commit();
		   flag = true;
	    } 
        catch (Exception e) {
			throw new AncestryException("save : "  + e.toString() , e);
	    }
        finally {
    	   JdbcHelper.closePS(pst);
    	   JdbcHelper.close(con);
        }
		return flag;
	}
}
