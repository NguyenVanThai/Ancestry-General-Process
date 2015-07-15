/*
 * conn.java
 *
 * Created on September 6, 2006, 11:19 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.digitexx.ancestry.db;

/**
 *
 * @author nqdung
 */

import java.sql.Connection;
import java.sql.DriverManager;

import com.digitexx.ancestry.bean.DigiSoftInfo;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.util.Configuration;
import com.enterprisedt.util.debug.Logger;

//Chevrolet_DreamGarage

/**
 * 
 * @author
 */
public class ConnectionDB {

	/**
	 * for database PRD
	 */
	public static String url = "";
	public static String searchpath = "";
	public static String user = "";
	public static String pass = "";
	public static String host = "";
	public static String condition = "";
	public static String delay = "";
	public static String user_login = "";
	public static String open_load_all = "";

	
	public  String urlDigiSoft = "";
	public  String searchpathDigiSoft = "";
	public  String userDigiSoft = "";
	public  String passDigiSoft = "";
	public  String hostDigiSoft = "";
	
	public  String url_qc = "";
	public  String searchpath_qc = "";
	public  String user_qc = "";
	public  String pass_qc = "";

	/**
	 * lookup description
	 */
	public  String urlLookUp = "jdbc:postgresql://10.10.1.4:5432/production";
	public  String searchpathLookUp = "set search_path to lookup_ancestry_eng;";
	public  String userLookUp = "ps_lookup";
	public  String passLookUp = "digilookup";

	/**
	 * for user account
	 */
	public  String urlPMS = "jdbc:postgresql://10.10.5.10:5432/pms";
	public  String userPMS = "ps_pms";
	public  String passwordPMS = "digipms";
	public  String searchpath_PMS = "set search_path = db_09_000_pms;";

	/*
	 * DE search path lookup DE
	 */
	public static  String searchpath_lookup_DE = "";
	public static  String urlLookUp_DE = "";
	public  String urlLookUp_DE_db7 = "jdbc:postgresql://10.10.1.7/kliktel_2008";
	public  String searchpath_lookup_db7 = "set search_path to data_barcode;";
	public  String urlLookUp_db7 = "jdbc:postgresql://10.10.1.7/lookup_barcode";
	public  String searchpath_db7 = "set search_path to rule_mailresponse;";
	public  String url_db7 = "jdbc:postgresql://10.10.1.7/rule_mailresponse";
	public  String user_db7 = "ps_lookup";
	public  String pass_db7 = "digilookup";
	private  Connection connection;
	
	
	public static  ConnectionDB instance = null;
	public  synchronized static ConnectionDB getInstance(){
		if(instance==null){
			instance = new ConnectionDB();
		}
		return instance;
	}

	public void loadDriver() {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
		} catch (Exception e) {
			System.out.println("Failed to load PostgreSQL driver."+ e.toString());
		}
	}
	
	public  Connection getCon() {
		try {
			if (connection == null) {
				Class.forName("org.postgresql.Driver").newInstance();
			}
			connection = DriverManager.getConnection(url +  "?ApplicationName="+Configuration.ProjectName + "?user="+ ConnectionDB.user_login, user, pass);
			connection.setAutoCommit(false);
			connection.createStatement().execute(searchpath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public  Connection getConnect()
	{
		try
		{
			if( connection == null ){
				Class.forName("org.postgresql.Driver").newInstance();
			}
			connection = DriverManager.getConnection( url =  "?ApplicationName="+Configuration.ProjectName + "?user="+ ConnectionDB.user_login, user, pass );
			connection.createStatement().execute(searchpath);
			connection.setAutoCommit(false);

		}catch(Exception e){
			e.printStackTrace() ;
		}
		return connection ;   
	}
	
	public  Connection getConnectDigiSoft(DigiSoftInfo digiSoftInfo)
	{
		try
		{
			urlDigiSoft        = "jdbc:postgresql://"+ digiSoftInfo.getServer() +":5432/"+ digiSoftInfo.getDatabse();
			userDigiSoft       = digiSoftInfo.getUsername();
			passDigiSoft       = digiSoftInfo.getPassword();
			searchpathDigiSoft = digiSoftInfo.getSchema();
			urlDigiSoft = urlDigiSoft +  "?ApplicationName="+Configuration.ProjectName + "?user="+ ConnectionDB.user_login;
			if( connection == null ){
				Class.forName("org.postgresql.Driver").newInstance();
			}
			
			System.out.println("urlDigiSoft : "  + urlDigiSoft + "\t : searchpathDigiSoft "  + searchpathDigiSoft + "\t ");
			
			connection = DriverManager.getConnection( urlDigiSoft, userDigiSoft, passDigiSoft );
			connection.createStatement().execute("set search_path to "+searchpathDigiSoft);
			connection.setAutoCommit(false);

		}
		catch(Exception e){
			e.printStackTrace() ;
		}
		return connection ;   
	}
	
	
	public Connection getConnectByProject(Tbl_Projects project)
	{
		try
		{
			url = "jdbc:postgresql://"+ project.getProj_serverip() +":5432/"+ project.getProj_dbname();
			user = project.getProj_uid();
			pass = project.getProj_pwd();
			searchpath = project.getProj_schema();
			
			if( connection == null ){
				Class.forName("org.postgresql.Driver").newInstance();
			}
			connection = DriverManager.getConnection( url + "?ApplicationName="+Configuration.ProjectName + "?user="+ ConnectionDB.user_login, user, pass );
			connection.createStatement().execute("set search_path = "+searchpath);
			connection.setAutoCommit(false);
			System.out.println(url + "\t : searchpath : "  + searchpath);
		}
		catch(Exception e){
			e.printStackTrace() ;
		}
		return connection ;   
	}
	
	public  Connection getConnectAncestryQC(Tbl_Projects project)
	{
		try
		{
			url_qc = "jdbc:postgresql://"+ project.getProj_serverip() +":5432/"+ project.getProj_dbname();
			user_qc = "ancestry";
			pass_qc = "ancestry";
			searchpath_qc = "db_14_000_qc_ancestry";
			url_qc = url_qc +  "?ApplicationName="+Configuration.ProjectName + "?user="+ ConnectionDB.user_login;
			
			if( connection == null ){
				Class.forName("org.postgresql.Driver").newInstance();
			}
			connection = DriverManager.getConnection( url_qc, user_qc, pass_qc );        		
			connection.createStatement().execute("set search_path to "+searchpath_qc);
			connection.setAutoCommit(false);
		}
		catch(Exception e){
			e.printStackTrace() ;
		}
		return connection ;   
	}
	
	
	public  Connection getConnectByProjectAndDBName(Tbl_Projects project , String database)
	{
		try
		{
			url = "jdbc:postgresql://"+ project.getProj_serverip() +":5432/"+ database;
			user = project.getProj_uid();
			pass = project.getProj_pwd();
			searchpath = project.getProj_schema();
			
			if( connection == null ){
				Class.forName("org.postgresql.Driver").newInstance();
			}
			connection = DriverManager.getConnection( url + "?ApplicationName="+Configuration.ProjectName + "?user="+ ConnectionDB.user_login, user, pass );
			searchpath = database;
			connection.createStatement().execute("set search_path = "+searchpath);
			connection.setAutoCommit(false);
		}
		catch(Exception e){
			e.printStackTrace() ;
		}
		return connection ;   
	}
	
	
	public  Connection getConnectByProjectDB10(Tbl_Projects project)
	{
		try
		{
			url = "jdbc:postgresql://"+ "10.10.5.10" +":5432/"+ project.getProj_dbname();
			user = project.getProj_uid();
			pass = project.getProj_pwd();
			
			searchpath = project.getProj_schema();
			if( connection == null ){
				Class.forName("org.postgresql.Driver").newInstance();
			}
			connection = DriverManager.getConnection( url + "?ApplicationName="+Configuration.ProjectName + "?user="+ ConnectionDB.user_login, user, pass );
			connection.createStatement().execute("set search_path = "+searchpath);
			connection.setAutoCommit(false);

		}catch(Exception e){
			e.printStackTrace() ;
		}
		return connection ;   
	}

	public  Connection getConPMS() throws Exception {
		try {
			if (connection == null || connection.isClosed()) {
				Class.forName("org.postgresql.Driver").newInstance();
				connection = DriverManager.getConnection(urlPMS + "?ApplicationName="+Configuration.ProjectName + "?user="+ ConnectionDB.user_login, userPMS,passwordPMS);
				connection.setAutoCommit(false);
				connection.createStatement().execute(searchpath_PMS);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public  Connection getConPMSByHost(String host) throws Exception {
		try {
			if (connection == null || connection.isClosed()) 
			{
				Class.forName("org.postgresql.Driver").newInstance();
				urlPMS = "jdbc:postgresql://"+host+":5432/pms";
				connection = DriverManager.getConnection(urlPMS + "?ApplicationName="+Configuration.ProjectName + "?user="+ ConnectionDB.user_login, userPMS,passwordPMS);
				connection.setAutoCommit(false);
				connection.createStatement().execute(searchpath_PMS);
				System.out.println("aaaaaa:"+searchpath_PMS);
				System.out.println("aaaaaa:"+host);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}


}