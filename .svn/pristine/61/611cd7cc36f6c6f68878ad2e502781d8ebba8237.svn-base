package com.digitexx.ancestry.util;

import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.db.ConnectionDB;
import com.digitexx.lib.databaseInfo;

public class Configuration {
	
	public static String WINDOW 		= "";
	public static String LINUX 			= "";
	public static String ProjectName	= "";
	
	public static String SERVER_DELETE ="";
	public static String USER_DELETE ="";
	public static String PASSWORD_DELETE ="";
	public static String FOLDER_DELETE ="";
	public static String FOLDER_COPY ="";

	
	public static void ConfigDB(databaseInfo clip) {
	    try 
	    {	      
	       WINDOW = clip.getWinFirstPath();
	       LINUX = clip.getLinuxFirstPath();	       
	       ConnectionDB.url						= "jdbc:postgresql://"+clip.getServer()+":5432/"+clip.getDatabase();
	       ConnectionDB.urlLookUp_DE 			= clip.getUrlLookup("de");
	       ConnectionDB.searchpath_lookup_DE 	= clip.getSearchpath("de")+";"; 
	       ConnectionDB.searchpath 				= "set search_path=" + clip.getSchema();
	       ConnectionDB.user					= clip.getSchemauserID();
	       ConnectionDB.pass					= clip.getSchemaPassword(); 
	       Configuration.ProjectName 			= clip.getProject_name(); 
	       ConnectionDB.host                    = clip.getServer();

	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
	
	public static void ConfigDB(databaseInfo clip , Tbl_Projects project) {
	    try 
	    {	      
	       WINDOW = clip.getWinFirstPath();
	       LINUX = clip.getLinuxFirstPath();	       
	       ConnectionDB.url						= "jdbc:postgresql://"+ project.getProj_serverip() +":5432/"+clip.getDatabase();
	       ConnectionDB.urlLookUp_DE 			= clip.getUrlLookup("de");
	       ConnectionDB.searchpath_lookup_DE 	= clip.getSearchpath("de")+";"; 
	       ConnectionDB.searchpath 				= "set search_path=" + project.getProj_schema();
	       ConnectionDB.user					= project.getProj_uid();
	       ConnectionDB.pass					= project.getProj_pwd(); 
	       Configuration.ProjectName 			= project.getProj_name();       
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
	
	public static String changePlatfom (String path) 
	{
		String result = path;
		if(result == null) result = "";		
		result = result.replace("\\", "/");		
		if (System.getProperty("os.name").contains("Linux")) result = result.replace(WINDOW, LINUX);
		else result = result.replace(LINUX, WINDOW);				
		return result;
	}
	

}
