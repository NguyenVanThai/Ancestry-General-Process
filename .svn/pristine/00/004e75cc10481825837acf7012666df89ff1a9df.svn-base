package com.digitexx.ancestry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.digitexx.ancestry.bean.DesignField;
import com.digitexx.ancestry.bean.Form;
import com.digitexx.ancestry.db.ConnectionDB;
import com.enterprisedt.util.debug.Logger;

public class FormDesignDao {
 
	private ConnectionDB db = ConnectionDB.getInstance();

    public List<String[]> getAllForm( long projectId ){
		List<String[]> forms = new ArrayList<String[]>() ;
		Connection con = db.getCon() ;  
		
		try{
			String sql = "select * from form_info where projectid = "+projectId+" order by form_id" ; 
			Statement st1 = con.createStatement() ; 
			ResultSet rs = st1.executeQuery( sql ) ; 
			
			while( rs.next() ){
				long formId    = rs.getLong("form_id")  ;
				String formName =  rs.getString("name") ;
				String[] tmp = new String[]{ Long.toString(formId) , formName } ;
				forms.add( tmp ) ; 
			}
		}
		catch( Exception e ){
		       return new ArrayList<String[]>() ; 
		}
		finally{
			try{
			     con.close() ;
			}catch(Exception ex){} ;      
		}  
		
		return forms ; 
		
	}
				
	public List<String> getListDontWrite(){

		String sql 							= "select characters from list_dontwrite" ; 
		List<String> listDontWrite 			= new ArrayList<String>();
		Connection connection 				= null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet 				= null;
		try
		{			
			connection 						= db.getCon();
			preparedStatement 				= connection.prepareStatement(sql);
			resultSet 						= preparedStatement.executeQuery() ;
			while(resultSet.next())
			{
				listDontWrite.add(resultSet.getString(1));
			}	
			return listDontWrite ;
		}
		catch( Exception e )
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			try
			{
				if(preparedStatement != null) preparedStatement.close();
				if(resultSet != null) resultSet.close();
				if(connection != null) connection.close();
			}
			catch( Exception ex )
			{
				ex.printStackTrace();
			}
		}	
	}
	
	public Form getFormDesignFieldNameList( long form_id ){
	
		Form form = new Form() ; 	   
		Connection connection 	= null; 
		Statement statement1 	= null;
		Statement statement2 	= null;
		ResultSet resultSet1 	= null;
		ResultSet resultSet2 	= null;
					
		try
		{
			connection = db.getCon() ;
			
			String sql1 = " select form_id , projectid , name , zoom_percent" 
						+ " from form_info  " 
						+ " where form_id = " + form_id ; 
			statement1 = connection.createStatement() ; 			
			resultSet1 = statement1.executeQuery( sql1 ) ;
			
			if(resultSet1.next())
			{
				long formId 		= resultSet1.getLong( "form_id" ) ;
				long projectId 		= resultSet1.getLong( "projectid" ) ;
				String formName 	= resultSet1.getString( "name" ) ;
				int zoomPercent 	= resultSet1.getInt( "zoom_percent" ) ;
				
				form.setId( formId ) ; 
				form.setProject_id( projectId ) ; 
				form.setName( formName ) ;
				form.setZoomPercent( zoomPercent ) ;
				
			}
			
			
			String sql2 = "select * from fieldnamelist where is_valid = 1 and form_id = "+form_id +" order by tab_order" ; 
			statement2 = connection.createStatement() ; 
			resultSet2 = statement2.executeQuery(sql2) ; 
			
			while(resultSet2.next())
			{
				DesignField designField = new DesignField() ; 			
				designField.setId( resultSet2.getLong("id") ) ;  
				designField.setForm_id( resultSet2.getLong( "form_id" ) ) ;  
				designField.setPage_number( resultSet2.getInt("page_number") ) ; 
				designField.setFieldname( resultSet2.getString("fieldname") ) ;   
				designField.setX( resultSet2.getInt("x") ) ; 
				designField.setY( resultSet2.getInt("y") ) ;
				designField.setWidth( resultSet2.getInt("width") ) ;
				designField.setHeight(resultSet2.getInt("height") ) ;
				designField.setVinputcheck( resultSet2.getString("vinputcheck") ) ; 
				designField.setVnotcheck( resultSet2.getString("vnotcheck") ) ; 
				designField.setScroll_horizontal( resultSet2.getInt("scroll_horizontal") ) ;
				designField.setScroll_vertical( resultSet2.getInt("scroll_vertical") ) ; 
				designField.setInputtype( resultSet2.getInt("inputtype") ) ;   
				designField.setFieldtype( resultSet2.getInt("fieldtype") ) ; 
				designField.setInputconstraint( resultSet2.getString("inputconstraint") ) ;    
				designField.setSaveconstraint( resultSet2.getInt("saveconstraint") ) ;    
				designField.setSearchtype( resultSet2.getInt("searchtype") ) ;    
				designField.setFix_lenth( resultSet2.getByte("fix_lenth") ) ;    
				designField.setGroup_type( resultSet2.getString("group_type") ) ;    
				designField.setTitle( resultSet2.getString("title") ) ; 
				designField.setDefault_value( resultSet2.getString("default_value") ) ;      
				designField.setInputtimes( resultSet2.getString("inputtimes") ) ;    
				designField.setTabOrder( resultSet2.getByte("tab_order") ) ;
				designField.setObligation( resultSet2.getBoolean("obligation") ) ; 
				designField.setDescription( resultSet2.getString("description") ) ; 
				designField.setSql_search( resultSet2.getString("sql_search") ) ; 
				designField.setIs_valid( resultSet2.getInt( "is_valid" ) );
				designField.setCheck_dont_write( resultSet2.getString( "check_dont_write" ) );
				designField.setOther1(resultSet2.getString("other1"));
				form.addDesignField( designField ) ;							
			}
		}
		catch( Exception e )
		{
			e.printStackTrace();
			return new Form() ; 				
		}
		finally
		{		
			try
			{
			   if(connection != null) connection.close();
			   if(statement1 != null) statement1.close();
			   if(statement2 != null) statement2.close();
			   if(resultSet1 != null) resultSet1.close();
			   if(resultSet2 != null) resultSet2.close();
			}
			catch( Exception ex )
			{
				ex.printStackTrace();
			} 		
		}		
		return form ; 
		
	}
	
    
	
	
}
