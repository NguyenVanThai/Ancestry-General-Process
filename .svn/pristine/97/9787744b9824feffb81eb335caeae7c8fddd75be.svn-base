package com.digitexx.ancestry.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.digitexx.ancestry.bean.ExportRecord;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.conts.BeanFieldDefinition;
import com.digitexx.ancestry.conts.BeanHeaderSQLite;
import com.digitexx.ancestry.conts.BeanRecordSQLite;
import com.digitexx.ancestry.db.ConnectionDB;
import com.digitexx.ancestry.db.ConnectionDB$SQLite;
import com.digitexx.ancestry.db.JdbcHelper;
import com.digitexx.ancestry.util.AncestryException;
import com.digitexx.ancestry.util.StringUtil;

public class DaoCheckExport {
	Tbl_Projects project;
	ConnectionDB db = ConnectionDB.getInstance();
	private ConnectionDB$SQLite db$sqLite ;
	
	public DaoCheckExport(Tbl_Projects project) {
		this.project = project;
		db$sqLite 	= new ConnectionDB$SQLite();
	}
	
	/**
	 * get data from table check_export
	 */
	
	public List<String> getListDoctype(String pathSqlLite) throws AncestryException {
		List<String> listdata = new ArrayList<String>();
		Connection con = null;
		ResultSet rs= null;
		String sql = "";
		String doc = "";
		try {
			sql = "	SELECT * FROM DocType " ; 
			con = db$sqLite.getCon(pathSqlLite);
			rs = JdbcHelper.queryToResultset(con, sql);
			while(rs.next())
			{
				doc = rs.getString("Type");
				if(!doc.equals("*")){
					listdata.add(doc);
				}
			}
		}
		catch (Exception e) {
			JdbcHelper.rollback(con);
			throw new AncestryException("getListDoctype : "  + e.toString() ,e);
		}
		finally {
            JdbcHelper.close(con);
		}
		return listdata;
	}
	
	public List<String> getListTableRecord(String pathSqlLite) throws AncestryException {
		List<String> listdata = new ArrayList<String>();
		Connection con = null;
		ResultSet rs= null;
		String sql = "";
		String data = "";
		try {
			sql = "	SELECT DocType FROM DocTypeDataTable Group by DocType having count(DocType) = 2 " ; 
			con = db$sqLite.getCon(pathSqlLite);
			rs = JdbcHelper.queryToResultset(con, sql);
			while(rs.next())
			{
				data = rs.getString("DocType");
				listdata.add(data);
			}
		}
		catch (Exception e) {
			JdbcHelper.rollback(con);
			throw new AncestryException("getListTableRecord : " + e.toString() , e);
		}
		finally {
            JdbcHelper.close(con);
		}
		
		return listdata;
	}
	
	public List<String> getListTableHeader(String pathSqlLite) throws AncestryException {
		List<String> listdata = new ArrayList<String>();
		Connection con = null;
		ResultSet rs= null;
		String sql = "";
		String data = "";
		try {
			sql = "	SELECT DocType FROM DocTypeDataTable Group by DocType having count(DocType) = 1 " ; 
			con = db$sqLite.getCon(pathSqlLite);
			rs = JdbcHelper.queryToResultset(con, sql);
			while(rs.next())
			{
				data = rs.getString("DocType");
				if(!data.equals("*")){
					listdata.add(data);
				}
			}
		}
		catch (Exception e) {
			JdbcHelper.rollback(con);
			throw new AncestryException("getListTableHeader  : "  + e.toString() , e);
		}
		finally {
            JdbcHelper.close(con);
		}
		
		return listdata;
	}
	
	public List<String> getListImageIDInput(String pathSqlLite, List<String> listdoc) throws AncestryException {
		List<String> listdata = new ArrayList<String>();
		Connection con = null;
		ResultSet rs= null;
		String sql = "";
		String lin = "";
		String data = "";
		try {
			if(listdoc.size() > 1){
				sql = "	SELECT * FROM Image where " ; 
				for(int i = 0; i< listdoc.size(); i++){
					if(i < 1){
						lin += "DocType = '"+listdoc.get(i)+"'";
					}else
						lin += " or DocType = '"+listdoc.get(i)+"'";
				}
				sql = sql + lin;
			}else
				sql = "	SELECT * FROM Image where DocType = '"+listdoc.get(0)+"'" ; 
			con = db$sqLite.getCon(pathSqlLite);
			rs = JdbcHelper.queryToResultset(con, sql);
			while(rs.next())
			{
				data = rs.getString("ImageID");
				listdata.add(data);
			}
		}
		catch (Exception e) {
			JdbcHelper.rollback(con);
			throw new AncestryException("getListImageIDInput : " + e.toString() , e);
		}
		finally {
            JdbcHelper.close(con);
		}
		return listdata;
	}
	
	public List<String> getListDoctypeImage(String pathSqlLite) throws AncestryException {
		List<String> listdata = new ArrayList<String>();
		Connection con = null;
		ResultSet rs= null;
		String sql = "";
		String doc = "";
		try {
			sql = "	SELECT * FROM Image " ; 
			con = db$sqLite.getCon(pathSqlLite);
			rs = JdbcHelper.queryToResultset(con, sql);
			while(rs.next())
			{
				doc = rs.getString("DocType");
				listdata.add(doc);
			}
		}
		catch (Exception e) {
			JdbcHelper.rollback(con);
			throw new AncestryException("getListDoctypeImage : "  + e.toString() ,e);
		}
		finally {
            JdbcHelper.close(con);
		}
		return listdata;
	}
	
	public List<String> getListImageIdImage(String pathSqlLite) throws AncestryException {
		List<String> listdata = new ArrayList<String>();
		Connection con = null;
		ResultSet rs= null;
		String sql = "";
		String doc = "";
		try {
			sql = "	SELECT * FROM Image " ; 
			con = db$sqLite.getCon(pathSqlLite);
			rs = JdbcHelper.queryToResultset(con, sql);
			while(rs.next())
			{
				doc = rs.getString("ImageID");
				listdata.add(doc);
			}
		}
		catch (Exception e) {
			JdbcHelper.rollback(con);
			throw new AncestryException("getListImageIdImage : "  + e.toString() , e);
		}
		finally {
            JdbcHelper.close(con);
		}
		return listdata;
	}
		
	public List<String> getListImageID(String pathSqlLite) throws AncestryException {
		List<String> listimage = new ArrayList<String>();
		Connection con = null;
		ResultSet rs= null;
		String sql = "";
		String imageid = "";
		try {
			sql = "	SELECT * FROM Image " ; 
			con = db$sqLite.getCon(pathSqlLite);
			rs = JdbcHelper.queryToResultset(con, sql);
			while(rs.next())
			{
				imageid = rs.getString("ImageID");
				listimage.add(imageid);
			}
		}
		catch (Exception e) {
			JdbcHelper.rollback(con);
			throw new AncestryException("getListImageID : "  + e.toString() , e);
		}
		finally {
            JdbcHelper.close(con);
		}
		return listimage;
	}
	
	public List<String> getListHeaderID(String pathSqlLite) throws AncestryException {
		List<String> listimage = new ArrayList<String>();
		Connection con = null;
		ResultSet rs= null;
		String sql = "";
		String imageid = "";
		try {
			sql = "	SELECT * FROM Header " ; 
			con = db$sqLite.getCon(pathSqlLite);
			rs = JdbcHelper.queryToResultset(con, sql);
			while(rs.next())
			{
				imageid = rs.getString("HeaderID");
				listimage.add(imageid);
			}
		}
		catch (Exception e) {
			JdbcHelper.rollback(con);
			throw new AncestryException("getListHeaderID : "  + e.toString() , e);
		}
		finally {
            JdbcHelper.close(con);
		}
		return listimage;
	}
	
	public List<String> getListHeaderIDRecord(String pathSqlLite) throws AncestryException {
		List<String> listimage = new ArrayList<String>();
		Connection con = null;
		ResultSet rs= null;
		String sql = "";
		String imageid = "";
		try {
			sql = "	SELECT distinct HeaderID FROM Record " ; 
			con = db$sqLite.getCon(pathSqlLite);
			rs = JdbcHelper.queryToResultset(con, sql);
			while(rs.next())
			{
				imageid = rs.getString("HeaderID");
				listimage.add(imageid);
			}
		}
		catch (Exception e) {
			JdbcHelper.rollback(con);
			throw new AncestryException("getListHeaderIDRecord : "  + e.toString() , e);
		}
		finally {
            JdbcHelper.close(con);
		}
		return listimage;
	}
	
	public List<String> getListHeaderIDHeader(String pathSqlLite) throws AncestryException {
		List<String> listimage = new ArrayList<String>();
		Connection con = null;
		ResultSet rs= null;
		String sql = "";
		String imageid = "";
		try {
			sql = "	SELECT distinct HeaderID FROM Header " ; 
			con = db$sqLite.getCon(pathSqlLite);
			rs = JdbcHelper.queryToResultset(con, sql);
			while(rs.next())
			{
				imageid = rs.getString("HeaderID");
				listimage.add(imageid);
			}
		}
		catch (Exception e) {
			JdbcHelper.rollback(con);
			throw new AncestryException("getListHeaderIDHeader : "  + e.toString() , e);
		}
		finally {
            JdbcHelper.close(con);
		}
		return listimage;
	}

	public BeanFieldDefinition getListFieldExportHeader(String pathSqlLite) throws AncestryException {
		BeanFieldDefinition beanFieldDefinition = new BeanFieldDefinition();
		List<Object[]>listTmp = new ArrayList<Object[]>();
		Connection con = null;
		String sql = "";
		try {
			sql = "	SELECT ColumnName , TableName FROM FieldDefinition " ;
			con = db$sqLite.getCon(pathSqlLite);
			listTmp = JdbcHelper.queryToListArraySQLite(con, sql);
			
			String columnName = "";
			String tableName = "";
			for (Object[] arrValue : listTmp) {
				columnName = StringUtil.setNotNull(arrValue[0]);
				tableName = StringUtil.setNotNull(arrValue[1]);	
			    if(tableName.equals("Header")){
			    	beanFieldDefinition.getListFieldHeader().add(columnName);
			    }else if(tableName.equals("Record")){
			    	beanFieldDefinition.getListFieldRecord().add(columnName);
			    }
			}
		}
		catch (Exception e) {
			throw new AncestryException("getListFieldExportHeader : "  + e.toString() ,e);
		}
		finally {
            JdbcHelper.close(con);
		}
		return beanFieldDefinition;
	}
	
	public BeanRecordSQLite getListDataExportRecord(String pathSqlLite, String field) throws AncestryException {
		BeanRecordSQLite beandata = new BeanRecordSQLite();
		List<Object[]>listTmp = new ArrayList<Object[]>();
		Connection con = null;
		String sql = "";
		String data = "";
		try {
			sql = "	SELECT "+field+",HeaderID, SequenceNum FROM Record" ;
			con = db$sqLite.getCon(pathSqlLite);
			listTmp = JdbcHelper.queryToListArraySQLite(con, sql);			

			for(Object[] arrValues : listTmp){
				if(arrValues[0] == null){
					arrValues[0] = "null";
				}
				data = arrValues[0].toString();
				String headerid = arrValues[1].toString();
				String seq = arrValues[2].toString();
				beandata.getHeaderid().add(headerid);
				beandata.getSeq().add(seq);
				beandata.getListDataRecord().add(data);
			}
		}
		catch (Exception e) {
			throw new AncestryException("getListDataExportRecord : "  + e.toString() ,e);
		}
		finally {
            JdbcHelper.close(con);
		}
		return beandata;
	}
	
	public ExportRecord getListDataExportID(String pathSqlLite) throws AncestryException {
		List<ExportRecord> list = new ArrayList<ExportRecord>();
		ExportRecord beandata = new ExportRecord();
		List<Object[]>listTmp = new ArrayList<Object[]>();
		Connection con = null;
		String sql = "";
		String headerid = "";
		String seq = "";
		try {
			sql = "	SELECT HeaderID, SequenceNum FROM Record" ;
			con = db$sqLite.getCon(pathSqlLite);
			listTmp = JdbcHelper.queryToListArraySQLite(con, sql);	
			for(Object[] values : listTmp){
				headerid = StringUtil.setNotNull(values[0]);
				seq = StringUtil.setNotNull(values[1]);				
				beandata.setHeaderID(headerid);
				beandata.setSeqnumber(seq);
			}
		}
		catch (Exception e) {
			throw new AncestryException("getListDataExportRecord : "  + e.toString() , e);
		}
		finally {
            JdbcHelper.close(con);
		}
		return beandata;
	}
	
	public BeanHeaderSQLite getListDataExportHeader(String pathSqlLite, String field) throws AncestryException {
		BeanHeaderSQLite beandata = new BeanHeaderSQLite();
		List<Object[]>listTmp = new ArrayList<Object[]>();
		Connection con = null;
		String sql = "";
		String data = "";
		try {
			sql = "	SELECT "+field+" FROM Header" ;
			con = db$sqLite.getCon(pathSqlLite);
			listTmp = JdbcHelper.queryToListArraySQLite(con, sql);			

			for(Object[] arrValues : listTmp){
				if(arrValues[0] == null){
					arrValues[0] = "null";
				}
				data = arrValues[0].toString();
				beandata.getListDataHeader().add(data);
			}
		}
		catch (Exception e) {
			throw new AncestryException("getListDataExportRecord : "  + e.toString() , e);
		}
		finally {
            JdbcHelper.close(con);
		}
		return beandata;
	}
	
	public List<String> getListHeaderIDImage(String pathSqlLite, String doc) throws AncestryException {
		List<String> listimage = new ArrayList<String>();
		Connection con = null;
		ResultSet rs= null;
		String sql = "";
		String imageid = "";
		try {
			sql = "	SELECT ImageID FROM Image where DocType = '"+doc+"'" ; 
			con = db$sqLite.getCon(pathSqlLite);
			rs = JdbcHelper.queryToResultset(con, sql);
			while(rs.next())
			{
				imageid = rs.getString("ImageID");
				listimage.add(imageid);
			}
		}
		catch (Exception e) {
			JdbcHelper.rollback(con);
			throw new AncestryException("getListHeaderIDImage : "  + e.toString() , e);
		}
		finally {
            JdbcHelper.close(con);
		}
		return listimage;
	}
}
