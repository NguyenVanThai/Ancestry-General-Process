package com.digitexx.ancestry.db;


import java.sql.Connection;
import java.sql.DriverManager;

import org.sqlite.SQLiteConfig;


public class ConnectionDB$SQLite
{
	public ConnectionDB$SQLite()
	{}
	
	public static ConnectionDB$SQLite instance;
	
	public static ConnectionDB$SQLite getInstance()
	{
		if(instance==null)
			synchronized(ConnectionDB$SQLite.class){
				if(instance==null)
					instance = new ConnectionDB$SQLite();				
			}
		return instance; 
	}
	
	public void configSQL()
	{
		SQLiteConfig config = new SQLiteConfig();		
		config.setReadOnly(true);   
		config.setSharedCache(true);
		config.toProperties();
	}
	
	Connection con;
	String sJdbc = "jdbc:sqlite:";
	
	public Connection getCon(String conString)
	{
		try
		{
			Class.forName("org.sqlite.JDBC").newInstance();
			con = DriverManager.getConnection("jdbc:sqlite:"+conString);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	


}