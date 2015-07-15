package com.digitexx.ancestry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import DigitexxCreateLogger.DigitexxWriteLog;

import com.digitexx.ancestry.util.Configuration;
import com.digitexx.ancestry.util.StringUtil;

public class ExecuteSQLDao {

	private static DigitexxWriteLog digitexxWriteLog = new DigitexxWriteLog(Configuration.ProjectName);
	
	public static boolean update(Connection connection, String tableName,String condition ,
			HashMap<String, Object> hashMapValues) throws Exception{

		boolean flag = false;
		PreparedStatement pst = null;
		try {
			
			String sql = "update " + tableName + " set ";
			String values = "";
			for (String columnName : hashMapValues.keySet()) {								
				values += columnName + " = ? , ";				
			}			
					
			values = values.substring(0,values.lastIndexOf(","));						
			sql += values;		
			sql += condition;
			pst = connection.prepareStatement(sql);			
			int index = 0;
			for (String columnName : hashMapValues.keySet()) 
			{	
				index ++;
				pst.setObject(index, hashMapValues.get(columnName));		
			}
			System.out.println(sql);
			pst.executeUpdate();
			flag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		finally 
		{
			try 
			{
				if(pst != null) pst.close();
			} catch (SQLException e) {
				e.printStackTrace();			
			}
		}
		return flag;
	}
		
	public static boolean excuteSQL(Connection connection, String sql) throws Exception
	{
		boolean flag = false;
		PreparedStatement pst = null;
		System.out.println("ExcuteSQL : " + sql);
		try {	
			pst = connection.prepareStatement(sql);
			pst.executeUpdate();
			flag = true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			throw e;
		} 
		finally 
		{
			try {
				if(pst != null) pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
		}
		return flag;
	}
	

}
