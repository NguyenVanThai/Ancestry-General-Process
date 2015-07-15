package com.digitexx.ancestry.db;

import java.lang.reflect.Field;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.swing.JTable;
import javax.swing.JTextField;

import com.digitexx.ancestry.util.AncestryException;
import com.digitexx.ancestry.util.DateUtil;
import com.digitexx.ancestry.util.JTableUtil;
import com.digitexx.ancestry.util.ObjectUtil;
import com.digitexx.ancestry.util.ReflectionHelper;
import com.digitexx.ancestry.util.StringUtil;

/**
 * 
 * @author lqnhu
 */
public class JdbcHelper {

	private static final String SEP = ", ";

	/**
	 * query to List Of Class Object
	 */
	public static List queryToListBean(Connection con, Class<?> clazz,String sql, boolean isCommit) throws AncestryException {
		List listBeanData = new ArrayList();
		ResultSet rs = null;
		PreparedStatement pst = null;
		try {
			BeanProcessor beanProcessor = new BeanProcessor();
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			listBeanData = beanProcessor.toBeanList(rs, clazz);
			if (isCommit) {
				con.commit();
			}
		} catch (Exception e) {
			rollback(con);
			throw new AncestryException("queryToListBean : " + e.toString(), e);
		} finally {
			JdbcHelper.closeRS(rs);
			JdbcHelper.closePS(pst);
			if (isCommit) {
				close(con);
			}
		}
		return listBeanData;
	}

	public static JDBCRow findOne(Connection con, String sql, boolean isCommit,Object... args) throws AncestryException {
		List<JDBCRow> rows = findToList(con, sql, isCommit, args);
		return rows == null ? null : rows.isEmpty() ? null : rows.get(0);
	}

	public static List<JDBCRow> findToList(Connection con, String sql,boolean isCommit, Object... args) throws AncestryException {
		if (con == null || sql == null || sql.trim().length() == 0)
			return null;
		List<JDBCRow> listResult = new ArrayList<JDBCRow>();
		PreparedStatement pst = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		try {
			pst = con.prepareStatement(sql);
			if (args != null && args.length > 0) {
				for (int i = 0; i < args.length; ++i) {
					pst.setObject(i + 1, args[i]);
				}
			}
			rs = pst.executeQuery();
			rsmd = rs.getMetaData();
			List<String> columns = new ArrayList<String>();
			for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
				columns.add(rsmd.getColumnName(i));
			}
			while (rs.next()) {
				JDBCRow jdbcResultSet = new JDBCRow(rs.getRow());
				for (int i = 1; i <= columns.size(); ++i) {
					int index = i - 1;
					String name = columns.get(index);
					Object value = rs.getObject(name);
					jdbcResultSet.columns().add(new JDBCColumn(index, name, value));
				}
				listResult.add(jdbcResultSet);
			}
		} catch (Exception e) {
			throw new AncestryException("find : " + e.toString(), e);
		} finally {
			closeRS(rs);
			closePS(pst);
			if (isCommit) {
				close(con);
			}
		}
		return listResult;
	}


	public static List<LinkedHashMap<String, Object>> queryToListLinkMap(Connection con, String sql) throws AncestryException {
		List<LinkedHashMap<String, Object>> listData = new ArrayList<LinkedHashMap<String, Object>>();
		LinkedHashMap<String, Object> mapData;
		ResultSet rs = null;
		PreparedStatement pst = null;

		try {
			System.out.println("queryToListLinkMap :" + sql);
			con.setAutoCommit(false);
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();

			while (rs.next()) {
				mapData = new LinkedHashMap<String, Object>();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					String key = rsmd.getColumnName(i);
					Object value = rs.getObject(i);
					mapData.put(key, value);
				}
				listData.add(mapData);
			}
			con.commit();
		} catch (Exception e) {
			rollback(con);
			throw new AncestryException("queryToListLinkMap : " + e.toString(),
					e);
		} finally {
			closeRS(rs);
			closePS(pst);
			close(con);
		}
		return listData;
	}

	public static List<Object[]> queryToListObject(Connection con, String sql)throws AncestryException {
		List<Object[]> listData = new ArrayList<Object[]>();
		ResultSet rs = null;
		PreparedStatement pst = null;
		try {
			System.out.println("queryToListObject :" + sql);
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			con.commit();

			ResultSetMetaData rsmd = rs.getMetaData();
			Object[] arrTmp;
			Object value;
			int len = rsmd.getColumnCount();
			while (rs.next()) {
				arrTmp = new Object[len];
				for (int i = 1; i <= len; i++) {
					value = rs.getObject(i);
					arrTmp[(i - 1)] = value;
				}
				listData.add(arrTmp);
			}
		} catch (Exception e) {
			rollback(con);
			throw new AncestryException("queryToListObject : " + e.toString(),e);
		} finally {
			closePS(pst);
			closeRS(rs);
			close(con);
		}
		return listData;
	}

	public static void queryToJtable(Connection con, String sql, JTable table,JTextField txtSearchData, boolean hasColumnNo)throws AncestryException {
		List<Object[]> listData = new ArrayList<Object[]>();
		String[] arrHeader = new String[] { "" };
		ResultSet rs = null;
		PreparedStatement pst = null;
		try {
			System.out.println("queryToJtable :" + sql);
			con.setAutoCommit(false);
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			Object[] arrTmp;
			Object value;
			int row = 0;
			int size = rsmd.getColumnCount();
			while (rs.next()) {
				arrTmp = new Object[size];
				if (row == 0) {
					if (hasColumnNo) {
						arrHeader = new String[size + 1];
						arrHeader[0] = "No.";
					} else {
						arrHeader = new String[size];
					}
				}
				for (int i = 1; i <= size; i++) {
					value = rs.getObject(i);
					arrTmp[(i - 1)] = value;
					if (row == 0) {
						if (hasColumnNo) {
							arrHeader[i] = rsmd.getColumnName(i);
						} else {
							arrHeader[(i - 1)] = rsmd.getColumnName(i);
						}
					}
				}
				listData.add(arrTmp);
				++row;
			}
			con.commit();
			JTableUtil.loadListObjectToGrid(arrHeader, table, listData,
					txtSearchData, hasColumnNo);
		} catch (Exception e) {
			rollback(con);
			throw new AncestryException("queryToJtable : " + e.toString(), e);
		} finally {
			closeRS(rs);
			closePS(pst);
			close(con);
		}
	}

	public static List<Map<String, Object>> queryToListMap(Connection con, String sql) throws AncestryException {
		List<Map<String, Object>> listData = new ArrayList<Map<String, Object>>();
		Map<String, Object> mapData;
		ResultSet rs = null;
		PreparedStatement pst = null;

		try {
			System.out.println("queryToListMap :" + sql);
			con.setAutoCommit(false);
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();

			while (rs.next()) {
				mapData = new LinkedHashMap<String, Object>();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					String key = rsmd.getColumnName(i);
					Object value = rs.getObject(i);
					mapData.put(key, value);
				}
				listData.add(mapData);
			}
			con.commit();
		} catch (Exception e) {
			rollback(con);
			throw new AncestryException("queryToListMap : " + e.toString(),e);
		} finally {
			closeRS(rs);
			closePS(pst);
			close(con);
		}
		return listData;
	}


	public static ResultSet functionToResultSet(String strsql, Connection con)throws AncestryException {
		ResultSet rs = null;
		CallableStatement cs = null;

		try {
			con.setAutoCommit(false);
			cs = con.prepareCall("{ call " + strsql + " }");
			cs.execute();
			rs = cs.getResultSet();
			con.commit();
		} catch (Exception ex) {
			rollback(con);
			throw new AncestryException("functionToResultSet : "+ ex.toString(), ex);
		} finally {
			JdbcHelper.closePS(cs);
		}
		return rs;
	}

	public static void excuteFunctionNonquery(String strsql, Connection con)throws AncestryException {
		CallableStatement cs = null;
		try {
			con.setAutoCommit(false);
			cs = con.prepareCall("{ call " + strsql + " }");
			cs.execute();
			con.commit();
		} catch (Exception ex) {
			rollback(con);
			throw new AncestryException("excuteFunctionNonquery : "
					+ ex.toString(), ex);
		} finally {
			closeCS(cs);
		}
	}


	public static ResultSet queryToResultset(Connection con, String sql)throws AncestryException {
		ResultSet rs = null;
		PreparedStatement pst = null;
		try {
			System.out.println("queryToResultset : " + sql);
			con.setAutoCommit(false);
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			con.commit();
		} catch (Exception e) {
			rollback(con);
			throw new AncestryException("queryToResultset : " + e.toString(), e);
		}
		return rs;
	}
	
	public static ResultSet statementToResultset(Connection con,PreparedStatement pst , String sql)throws AncestryException {
		ResultSet rs = null;
		try {
			System.out.println("statementToResultset : " + pst.toString());
			con.setAutoCommit(false);
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			con.commit();
		} catch (Exception e) {
			rollback(con);
			throw new AncestryException("statementToResultset : " + e.toString(), e);
		}
		return rs;
	}


	public static final List<String> getListColumnLabel(ResultSet rs)throws AncestryException {
		List<String> listComlums = new ArrayList<String>();
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();

			for (int i = 0; i < columnCount; i++) {
				listComlums.add(rsmd.getColumnLabel(i + 1));

			}
		} catch (Exception e) {
			throw new AncestryException("getListColumnLabel : " + e.toString(),
					e);
		} finally {
			closeRS(rs);
		}
		return listComlums;
	}


	public static List<LinkedHashMap<Object, Object>> getResult2List(ResultSet rs) throws AncestryException {

		List<LinkedHashMap<Object, Object>> list = new ArrayList<LinkedHashMap<Object, Object>>();
		List<String> listColums = getListColumnLabel(rs);
		int i, length = listColums.size();
		LinkedHashMap<Object, Object> map = new LinkedHashMap<Object, Object>();

		try {
			while (rs.next()) {
				map = new LinkedHashMap<Object, Object>();
				for (i = 1; i <= length; i++) {
					map.put(listColums.get(i - 1), rs.getString(i));
				}
				list.add(map);
			}
		} catch (Exception e) {
			throw new AncestryException("getResult2List : " + e.toString(), e);
		} finally {
			closeRS(rs);
		}

		return list;
	}


	public static Map<String, ArrayList<String>> getResult2Map(ResultSet rs)throws AncestryException {
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		try {
			List<String> listColums = getListColumnLabel(rs);
			int i, length = listColums.size();
			ArrayList<String>[] lists = new ArrayList[length];

			for (i = 0; i < length; i++) {
				lists[i] = new ArrayList<String>();
			}
			while (rs.next()) {
				for (i = 0; i < length; i++) {
					lists[i].add(rs.getString(i + 1));
				}
			}
			for (i = 0; i < length; i++) {
				map.put(listColums.get(i), lists[i]);
			}
		} catch (Exception e) {
			throw new AncestryException("getResult2Map : " + e.toString(), e);
		}
		return map;
	}


	public static List<String> queryToSingleList(Connection con, String sql, boolean isCommit)throws AncestryException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<String> listData = new ArrayList<String>();

		try {
			System.out.println("queryToSingleList :" + sql);
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				listData.add(rs.getString(1));
			}
			if(isCommit) {
				con.commit();
			}
		} catch (Exception e) {
			rollback(con);
			throw new AncestryException("queryToSingleList : " + e.toString(),e);
		} finally {
			closeRS(rs);
			closePS(pst);
			if(isCommit) {
				close(con);
			}
		}
		return listData;
	}
	

	public static List<String> querySelectIN(Connection con, String sql,List<String> listCondition , boolean isCommit)throws AncestryException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<String> listData = new ArrayList<String>();

		try {
			sql = String.format(sql, JdbcHelper.preparePlaceHolders(listCondition.size()));
			pst = con.prepareStatement(sql);
			JdbcHelper.setValues(pst, listCondition.toArray());
			rs = pst.executeQuery();
			
			System.out.println("querySelectIN :" + pst.toString());
			while (rs.next()) {
				listData.add(rs.getString(1));
			}
			if(isCommit) {
				con.commit();
			}
		} catch (Exception e) {
			rollback(con);
			throw new AncestryException("querySelectIN : " + e.toString(),e);
		} finally {
			closeRS(rs);
			closePS(pst);
			if(isCommit) {
				close(con);
			}
		}
		return listData;
	}


	public static List<ArrayList<Object>> queryToNestedList(Connection con, String sql) throws AncestryException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<ArrayList<Object>> listResult = new ArrayList<ArrayList<Object>>();
		ArrayList<Object> listTmp = new ArrayList<Object>();

		try {
			con.setAutoCommit(false);
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();

			while (rs.next()) {
				listTmp = new ArrayList<Object>();
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					listTmp.add(rs.getObject(rsmd.getColumnName(i + 1)));
				}
				listResult.add(listTmp);
			}
			con.commit();
		} catch (Exception e) {
			rollback(con);
			throw new AncestryException("queryToNestedList : " + e.toString(),
					e);
		} finally {
			closeRS(rs);
			closePS(pst);
			close(con);
		}
		return listResult;
	}

	/**
	 * get data return List<Object[]>
	 */
	public static List<Object[]> queryToListArray(Connection con, String sql)throws AncestryException {

		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<Object[]> listResult = new ArrayList<Object[]>();
		Object[] arrTmp = null;
		int totalColumn = 0;

		try {
			con.setAutoCommit(false);
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			totalColumn = rsmd.getColumnCount();

			while (rs.next()) {
				arrTmp = new Object[totalColumn];
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					arrTmp[(i - 1)] = rs.getString(rsmd.getColumnName(i));
				}
				listResult.add(arrTmp);
			}
			con.commit();

		} catch (Exception e) {
			rollback(con);
			throw new AncestryException("queryToListArray : " + e.toString(), e);
		} finally {
			closeRS(rs);
			closePS(pst);
			close(con);
		}
		return listResult;
	}
	
	/********************* SqlLite *****************************************************/

	public static List<Object[]> queryToListArraySQLite(Connection con,String sql) throws AncestryException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<Object[]> listResult = new ArrayList<Object[]>();
		Object[] arrTmp = null;
		int totalColumn = 0;

		try {
			con.setAutoCommit(false);
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			totalColumn = rsmd.getColumnCount();

			while (rs.next()) {
				arrTmp = new Object[totalColumn];
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					arrTmp[(i - 1)] = rs.getString(rsmd.getColumnName(i));
				}
				listResult.add(arrTmp);
			}
			con.commit();

		} catch (Exception e) {
			rollback(con);
			throw new AncestryException("queryToListArray : " + e.toString(), e);
		} finally {
			// closeRS(rs);
			// closePS(pst);
			// close(con);
		}
		return listResult;
	}

	public static ArrayList<String> queryToSingleListSQLite(Connection con,String sql) throws AncestryException {

		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<String> listData = new ArrayList<String>();

		try {
			System.out.println("queryToSingleList :" + sql);
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				listData.add(rs.getString(1));
			}
			// con.commit();
		} catch (Exception e) {
			rollback(con);
			throw new AncestryException("queryToSingleList : " + e.toString(),
					e);
		} finally {
			// closeRS(rs);
			// closePS(pst);
		}
		return listData;
	}


	public static final ArrayList<String> getListColumnOfTable(Connection con,String tableName) throws AncestryException {

		String sql = " SELECT p.* FROM " + tableName + " p limit 1";
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<String> listComlums = new ArrayList<String>();

		try {
			con.setAutoCommit(false);
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();

			for (int i = 0; i < columnCount; i++) {
				listComlums.add(rsmd.getColumnLabel(i + 1));
			}
			con.commit();

		} catch (Exception e) {
			rollback(con);
			throw new AncestryException("getListColumnOfTable : "
					+ e.toString(), e);
		} finally {
			closeRS(rs);
			closePS(pst);
			//close(con);
		}
		return listComlums;
	}
	
	public static final ArrayList<String> getListColumnOfTableLookup(Connection con,String tableName, boolean isCommit) throws AncestryException {

		String sql = " SELECT p.* FROM " + tableName + " p limit 1";
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<String> listComlums = new ArrayList<String>();

		try {
			con.setAutoCommit(false);
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();

			for (int i = 0; i < columnCount; i++) {
				listComlums.add(rsmd.getColumnLabel(i + 1));
			}
			if(isCommit){
				con.commit();
			}

		} catch (Exception e) {
			rollback(con);
			throw new AncestryException("getListColumnOfTable : "
					+ e.toString(), e);
		} finally {
			//closeRS(rs);
			//closePS(pst);
			//close(con);
		}
		return listComlums;
	}

	public static Object queryToObject(Connection con, String sql)throws AncestryException {

		Object obj = "";
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			System.out.println("queryToObject : " + sql);
			con.setAutoCommit(false);

			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs.next()) {
				obj = rs.getObject(1);
			}
			con.commit();

		} catch (Exception ex) {
			rollback(con);
			throw new AncestryException("queryToObject : " + ex.toString(), ex);
		} finally {
			closeRS(rs);
			closePS(pst);
			close(con);
		}
		return obj;
	}
	
	public static Object queryToObjectLookup(Connection con, String sql, boolean isCommit)throws AncestryException {

		Object obj = "";
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			System.out.println("queryToObject : " + sql);
			con.setAutoCommit(false);

			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs.next()) {
				obj = rs.getObject(1);
			}
			if(isCommit){
				con.commit();
			}

		} catch (Exception ex) {
			rollback(con);
			throw new AncestryException("queryToObject : " + ex.toString(), ex);
		} finally {
			//closeRS(rs);
			//closePS(pst);
			//close(con);
		}
		return obj;
	}

	public static String queryToString(Connection con, String sql,boolean isCommit) throws AncestryException {

		PreparedStatement pst = null;
		ResultSet rs = null;
		String objValue = new String();
		try {
			System.out.println("queryToString : "  + sql);
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs.next()) {
				objValue = StringUtil.setNotNull(rs.getString(1));
			}
			if (isCommit) {
				con.commit();
			}

		} catch (Exception e) {
			rollback(con);
			throw new AncestryException("queryToString : " + e.toString(), e);
		} finally {
			closePS(pst);
			closeRS(rs);
			if (isCommit) {
				close(con);
			}
		}
		return objValue;
	}

	/******************** UPDATE ************************************************/

	/**
	 * build insert command from Map
	 */
	public static String buildUpdateSqlFromMap(String fieldNameId,
			String valueId, String tableName, Map<String, Object> mapData) {
		StringBuilder sb = new StringBuilder("UPDATE ");
		sb.append(tableName).append(" SET ");
		int index = 1;
		int size = mapData.size();
		for (String key : mapData.keySet()) {
			if (!key.equals(fieldNameId)) {
				sb.append(key + "= ? ");
				if (index < size) {
					sb.append(SEP);
				}
			}
			++index;
		}
		sb.append(" WHERE ");
		sb.append(fieldNameId);
		sb.append(" = ");
		sb.append(valueId);
		return sb.toString();
	}

	/**
	 * build insert command from Map
	 */
	public static String buildUpdateSqlFromBean(String fieldNameId,
			Object valueId, String tableName, List<Field> listField,
			Object objectBean, Class<?> clazz) {
		StringBuilder sb = new StringBuilder("UPDATE ");
		sb.append(tableName).append(" SET ");
		int size = listField.size();
		int index = 1;
		String key = "";
		for (Field field : listField) {
			key = field.getName();
			if (!key.equals(fieldNameId)) {
				sb.append(key + "= ? ");
				if (index < size) {
					sb.append(SEP);
				}
			}
			++index;
		}
		sb.append(" WHERE ");
		sb.append(fieldNameId);
		sb.append(" = ");
		sb.append(valueId);
		return sb.toString();
	}

	/**
	 * update with list map data
	 */
	public static boolean updateListMap(Connection con, String fieldNameId,
			String tableName, List<Map<String, Object>> listMap,
			boolean hasCommit) throws AncestryException {

		boolean flag = false;
		PreparedStatement pst = null;
		String sql = "";
		Object value;
		String id = "";
		try {

			for (Map<String, Object> mapTmp : listMap) {
				int index = 1;
				id = Objects.toString(mapTmp.get(fieldNameId), "");
				sql = JdbcHelper.buildUpdateSqlFromMap(fieldNameId, id,
						tableName, mapTmp);
				pst = con.prepareStatement(sql);
				for (String key : mapTmp.keySet()) {
					if (!key.equals(fieldNameId)) {
						value = mapTmp.get(key);
						if (value instanceof Long) {
							pst.setLong(index, ObjectUtil.toLong(value));
						} else if (value instanceof Integer) {
							pst.setInt(index, ObjectUtil.toInteger(value));
						} else if (value instanceof Float) {
							pst.setFloat(index, ObjectUtil.toFloat(value));
						} else if (value instanceof Timestamp) {
							pst.setTimestamp(index, DateUtil.toTimestamp(value));
						} else {
							pst.setObject(index, value);
						}
						++index;
					}

				}
				pst.execute();
			}
			if (hasCommit) {
				con.commit();
			}
			flag = true;

		} catch (Exception e) {
			flag = false;
			rollback(con);
			throw new AncestryException("updateListMap : " + e.toString(), e);
		} finally {
			JdbcHelper.closePS(pst);
		}
		return flag;
	}

	/**
	 * update with list map data
	 */
	public static boolean updateListBean(Connection con, String fieldNameId,
			String tableName, List<?> listBean, Class<?> clazz,
			boolean hasCommit) throws AncestryException {

		boolean flag = false;
		PreparedStatement pst = null;
		String sql = "";
		Object value;
		Object valueId = "";
		String key = "";
		try {

			List<Field> listField = ReflectionHelper.loadBeanFields(clazz);
			for (Object objectBean : listBean) {
				int index = 1;
				valueId = ReflectionHelper.getFieldValue(objectBean,
						fieldNameId);
				sql = JdbcHelper.buildUpdateSqlFromBean(fieldNameId, valueId,
						tableName, listField, objectBean, clazz);
				pst = con.prepareStatement(sql);
				for (Field field : listField) {
					key = field.getName();
					if (!key.equals(fieldNameId)) {
						value = ReflectionHelper.getFieldValue(objectBean, key);
						if (value instanceof Long) {
							pst.setLong(index, ObjectUtil.toLong(value));
						} else if (value instanceof Integer) {
							pst.setInt(index, ObjectUtil.toInteger(value));
						} else if (value instanceof Float) {
							pst.setFloat(index, ObjectUtil.toFloat(value));
						} else if (value instanceof Timestamp) {
							pst.setTimestamp(index, DateUtil.toTimestamp(value));
						} else {
							pst.setObject(index, value);
						}
						++index;
					}
				}
				pst.execute();
			}
			if (hasCommit) {
				con.commit();
			}
			flag = true;

		} catch (Exception e) {
			flag = false;
			rollback(con);
			throw new AncestryException("updateListBean : " + e.toString(), e);
		} finally {
			JdbcHelper.closePS(pst);
		}
		return flag;
	}

	/******************** CRUD ************************************************/

	public static boolean executeNonQuery(Connection con, String sql)
			throws AncestryException {
		boolean flag = true;
		PreparedStatement pst = null;
		try {
			System.out.println("executeNonQuery : " + sql);

			con.setAutoCommit(false);
			pst = con.prepareStatement(sql);
			pst.executeUpdate();
			con.commit();
			flag = true;

		} catch (Exception ex) {
			flag = false;
			rollback(con);
			throw new AncestryException("executeNonQuery : " + ex.toString(),
					ex);
		} finally {
			closePS(pst);
			close(con);
		}
		return flag;

	}

	public static boolean executeNonQueryNotCommit(Connection con, String sql)
			throws AncestryException {
		boolean flag = true;
		PreparedStatement pst = null;
		try {
			System.out.println("executeNonQueryNotCommit : " + sql);
			con.setAutoCommit(false);
			pst = con.prepareStatement(sql);
			pst.executeUpdate();
			flag = true;

		} catch (Exception ex) {
			flag = false;
			rollback(con);
			throw new AncestryException("executeNonQueryNotCommit : "
					+ ex.toString(), ex);
		} finally {
			closePS(pst);
		}
		return flag;
	}

	public static boolean excuteNonQueryStatement(Connection con,
			PreparedStatement pst, boolean isCommit) throws AncestryException {
		boolean flag = false;
		try {
			System.out.println("excuteNonQueryStatement : " + pst.toString());
			pst.executeUpdate();
			if (isCommit) {
				con.commit();
			}
			flag = true;

		} catch (Exception ex) {
			flag = false;
			rollback(con);
			throw new AncestryException("excuteNonQuery : " + ex.toString(), ex);
		} finally {
			closePS(pst);
			if (isCommit) {
				close(con);
			}
		}
		return flag;

	}

	/******************** BUILD INSERT ************************************************/

	/**
	 * set value PreparedStatement
	 */
	public static PreparedStatement mapToPreparedStatement(
			PreparedStatement pst, LinkedHashMap<String, Object> mapData,
			HashMap<String, String> mapDataType) {
		int index = 1;
		for (String key : mapData.keySet()) {
			try {
				String dataType = mapDataType.get(key);
				if (dataType.equals("int")) {
					pst.setInt(index,
							Integer.parseInt(mapData.get(key).toString()));
				} else if (dataType.equals("long")) {
					pst.setLong(index,
							Long.parseLong(mapData.get(key).toString()));
				} else {
					pst.setObject(index, mapData.get(key));
				}
				++index;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pst;

	}

	public static String buildInsertStatement(String tableName,
			ArrayList<String> columnNames, ArrayList<String> values) {

		StringBuilder sb = new StringBuilder("INSERT ");
		sb.append(" INTO ");
		sb.append(tableName).append(" (");
		sb.append(join(columnNames, SEP));
		sb.append(") VALUES (");

		final List<String> insertedValues = new ArrayList<String>();
		if (values != null) {
			for (String value : values) {
				value = StringUtil.getReplaceChar(value);
				insertedValues.add("'" + value + "'");
			}
		}
		while (insertedValues.size() < columnNames.size()) {
			insertedValues.add("?");
		}
		sb.append(join(insertedValues, SEP));
		sb.append(")");
		return sb.toString();
	}

	/**
	 * save object bean
	 */
	public static boolean saveBean(Connection con, String tableName,
			Class<?> clazz, Object beanValue, String removeField)
			throws AncestryException {
		boolean flag = false;
		PreparedStatement pst = null;
		LinkedHashMap<String, Object> mapData = ReflectionHelper.beanToMap(
				clazz, beanValue, removeField);
		String sql = "";
		try {
			sql = buildInsertCommandGeneric(tableName, mapData);
			pst = con.prepareStatement(sql);
			int index = 1;
			Object value;

			for (String key : mapData.keySet()) {
				value = mapData.get(key);
				if (value instanceof Long) {
					pst.setLong(index, ObjectUtil.toLong(value));
				} else if (value instanceof Integer) {
					pst.setInt(index, ObjectUtil.toInteger(value));
				} else if (value instanceof Float) {
					pst.setFloat(index, ObjectUtil.toFloat(value));
				} else if (value instanceof Timestamp) {
					pst.setTimestamp(index, DateUtil.toTimestamp(value));
				} else {
					pst.setObject(index, value);
				}
				++index;
			}
			pst.execute();
			con.commit();
			flag = true;
		} catch (Exception e) {
			rollback(con);
			throw new AncestryException("saveBean : " + e.toString(), e);
		} finally {
			closePS(pst);
		}
		return flag;

	}

	/**
	 * save object bean
	 * 
	 * @param <T>
	 */
	public static boolean saveListBean(Connection con, String tableName,
			Class<?> clazz, List<?> listBeanValue, String removeField,
			boolean isCommit) throws AncestryException {
		boolean flag = true;
		PreparedStatement pst = null;
		LinkedHashMap<String, Object> mapData;
		String sql = "";
		Object value;
		int index = 0;
		try {

			for (Object objectBean : listBeanValue) {
				mapData = ReflectionHelper.beanToMap(clazz, objectBean,
						removeField);
				sql = buildInsertCommandGeneric(tableName, mapData);
				pst = con.prepareStatement(sql);
				index = 1;
				for (String key : mapData.keySet()) {
					value = mapData.get(key);
					if (value instanceof Long) {
						pst.setLong(index, ObjectUtil.toLong(value));
					} else if (value instanceof Integer) {
						pst.setInt(index, ObjectUtil.toInteger(value));
					} else if (value instanceof Float) {
						pst.setFloat(index, ObjectUtil.toFloat(value));
					} else if (value instanceof Timestamp) {
						pst.setTimestamp(index, DateUtil.toTimestamp(value));
					} else {
						pst.setObject(index, value);
					}
					++index;
				}
				pst.execute();

			}
			if (isCommit) {
				con.commit();
			}
			flag = true;
		} catch (Exception e) {
			flag = false;
			rollback(con);
			throw new AncestryException("saveListBean : " + e.toString(), e);
		} finally {
			closePS(pst);
		}
		return flag;
	}

	/**
	 * save Map Data
	 */
	public static boolean saveMap(Connection con, String tableName,
			LinkedHashMap<String, Object> mapData) throws AncestryException {

		boolean flag = false;
		PreparedStatement pst = null;
		String sql = "";
		Object value;
		try {
			sql = JdbcHelper.buildInsertCommandGeneric(tableName, mapData);
			pst = con.prepareStatement(sql);
			int index = 1;
			for (String key : mapData.keySet()) {
				value = mapData.get(key);
				if (value instanceof Long) {
					pst.setLong(index, ObjectUtil.toLong(value));
				} else if (value instanceof Integer) {
					pst.setInt(index, ObjectUtil.toInteger(value));
				} else if (value instanceof Float) {
					pst.setFloat(index, ObjectUtil.toFloat(value));
				} else if (value instanceof Timestamp) {
					pst.setTimestamp(index, DateUtil.toTimestamp(value));
				} else {
					pst.setObject(index, value);
				}
				++index;
			}
			pst.execute();
			con.commit();
			flag = true;

		} catch (Exception e) {
			rollback(con);
			throw new AncestryException("saveMap : " + e.toString(), e);
		} finally {
			closePS(pst);
		}
		return flag;
	}

	/**
	 * save List Map Data
	 */
	public static boolean saveListMap(Connection con, String tableName,
			List<LinkedHashMap<String, Object>> listMapData)
			throws AncestryException {

		boolean flag = false;
		PreparedStatement pst = null;
		String sql = "";
		Object value;
		try {
			int index = 0;
			for (LinkedHashMap<String, Object> mapData : listMapData) {
				sql = JdbcHelper.buildInsertCommandGeneric(tableName, mapData);
				pst = con.prepareStatement(sql);
				index = 1;
				for (String key : mapData.keySet()) {
					value = mapData.get(key);
					if (value instanceof Long) {
						pst.setLong(index, ObjectUtil.toLong(value));
					} else if (value instanceof Integer) {
						pst.setInt(index, ObjectUtil.toInteger(value));
					} else if (value instanceof Float) {
						pst.setFloat(index, ObjectUtil.toFloat(value));
					} else if (value instanceof Timestamp) {
						pst.setTimestamp(index, DateUtil.toTimestamp(value));
					} else {
						pst.setObject(index, value);
					}
					++index;
				}
				pst.execute();
			}
			con.commit();
			flag = true;

		} catch (Exception e) {
			rollback(con);
			throw new AncestryException("saveListMap : " + e.toString(), e);
		} finally {
			closePS(pst);
		}
		return flag;
	}

	/**
	 * save List Map Data with new Id
	 */
	public static boolean saveListMapWithId(Connection con, String tableName,
			List<LinkedHashMap<String, Object>> listMapData, int nextId,
			String columNameId) throws AncestryException {

		boolean flag = false;
		PreparedStatement pst = null;
		String sql = "";
		Object value;
		try {
			int index = 0;
			for (LinkedHashMap<String, Object> mapData : listMapData) {
				sql = JdbcHelper.buildInsertCommandGeneric(tableName, mapData);
				pst = con.prepareStatement(sql);
				index = 1;
				for (String key : mapData.keySet()) {
					value = mapData.get(key);
					if (key.equals(columNameId)) {
						pst.setLong(index, Long.parseLong(nextId + ""));
					} else if (value instanceof Long) {
						pst.setLong(index, ObjectUtil.toLong(value));
					} else if (value instanceof Integer) {
						pst.setInt(index, ObjectUtil.toInteger(value));
					} else if (value instanceof Float) {
						pst.setFloat(index, ObjectUtil.toFloat(value));
					} else if (value instanceof Timestamp) {
						pst.setTimestamp(index, DateUtil.toTimestamp(value));
					} else {
						pst.setObject(index, value);
					}
					++index;
				}
				++nextId;
				pst.execute();
			}
			con.commit();
			flag = true;

		} catch (Exception e) {
			rollback(con);
			throw new AncestryException("saveListMapWithId : " + e.toString(),
					e);
		} finally {
			closePS(pst);
		}
		return flag;
	}

	/******************** INSERT BATCH ************************************************/

	public static int[] executeBatch(Connection con, String sql,
			boolean isCommit, Object[]... args) throws AncestryException {
		if (con == null || sql == null || sql.trim().length() == 0)
			return null;
		int[] result = new int[] { 0 };
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			for (int i = 0; i < args.length; ++i) {
				for (int j = 0; j < args[i].length; j++) {
					pst.setObject(j + 1, args[i][j]);
				}
				pst.addBatch();
			}
			int[] rows = pst.executeBatch();
			if (rows != null && rows.length > 0) {
				result = new int[rows.length];
				if (sql.toUpperCase().contains("INSERT INTO")) {
					ResultSet rs = pst.getGeneratedKeys();
					int i = 0;
					while (rs.next()) {
						result[i] = rs.getInt(1);
						i++;
					}
				} else {
					for (int i = 0; i < rows.length; i++) {
						result[i] = rows[i];
					}
				}
			}
			pst.close();
		} catch (Throwable e) {
			throw new AncestryException("batchExecute : " + e.toString(), e);
		} finally {
			JdbcHelper.closePS(pst);
			if (isCommit) {
				JdbcHelper.close(con);
			}
		}
		return result;
	}

	public static int execute(Connection con, String sql, boolean isCommit,
			Object... args) throws AncestryException {
		if (con == null || sql == null || sql.trim().length() == 0)
			return 0;
		int result = 0;
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			fillArgs(new Object[][] { args }, pst, 0);
			result = pst.executeUpdate();
			if (result > 0 && sql.toUpperCase().contains("INSERT INTO")) {
				ResultSet rs = pst.getGeneratedKeys();
				if (rs.next()) {
					result = rs.getInt(1);
				}
			}
			pst.close();
		} catch (Throwable e) {
			throw new AncestryException("execute : " + e.toString(), e);
		} finally {
			JdbcHelper.closePS(pst);
			if (isCommit) {
				JdbcHelper.close(con);
			}
		}
		return result;
	}
	
	public static boolean executeInsert(Connection con, String tableName,
			ArrayList<String> columnNames, ArrayList<String> values, boolean isCommit) {
		try {

			con.setAutoCommit(false);
			String sql = JdbcHelper.buildInsertStatement(tableName,columnNames, values);
			//System.out.println(sql);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.executeUpdate();
			if(isCommit){
				con.commit();
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			if (isCommit) {
				JdbcHelper.close(con);
			}
		}

		return true;

	}

	// ==============================================================================================================

	/**
	 * get list table name by project
	 */
	public static List<String> getListTableName(Connection con, String schema)
			throws Exception {

		List<String> listTable = new ArrayList<String>();
		String sql = "";
		try {
			sql = "SELECT table_name FROM information_schema.tables WHERE table_schema ='"
					+ schema + "' order by table_name";
			listTable = JdbcHelper.queryToSingleList(con, sql,true);
		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
			throw new Exception("getListTableName : " + e.toString());
		} finally {
			close(con);
		}
		return listTable;

	}

	public static List<String> getTables(Connection con) throws Exception {
		String TABLE_NAME = "TABLE_NAME";
		String TABLE_SCHEMA = "TABLE_SCHEM";
		String[] TABLE_TYPES = { "TABLE" };
		DatabaseMetaData dbmd = con.getMetaData();
		List<String> listTableName = new ArrayList<String>();
		try {
			ResultSet tables = dbmd.getTables(null, null, null, TABLE_TYPES);
			while (tables.next()) {
				listTableName.add(tables.getString(TABLE_NAME));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("getTables : " + e.toString());
		} finally {
			close(con);
		}
		return listTableName;
	}

	// ========================================================================================================================

	public static String preparePlaceHolders(int length) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < length;) {
			builder.append("?");
			if (++i < length) {
				builder.append(",");
			}
		}
		return builder.toString();
	}

	public static void setValues(PreparedStatement preparedStatement,
			Object... values) throws SQLException {
		for (int i = 0; i < values.length; i++) {
			preparedStatement.setObject(i + 1, values[i]);
		}
	}

	private static void fillArgs(Object[][] args, PreparedStatement pstmt, int i)
			throws SQLException {
		if (args == null || args.length == 0)
			return;
		if (args[i] == null || args[i].length == 0)
			return;
		for (int j = 0; j < args[i].length; ++j)
			pstmt.setObject(j + 1, args[i][j]);
	}

	public static Class<?>[] createClasses(ResultSetMetaData meta)
			throws SQLException {
		int numColumns = meta.getColumnCount() + 1;
		Class<?>[] classes = new Class<?>[numColumns];
		classes[0] = Integer.class;
		for (int i = 1; i < numColumns; i++) {
			try {
				classes[i] = Class.forName(meta.getColumnClassName(i));
			} catch (Exception e) {
				System.out.println("Class not found for "
						+ meta.getColumnClassName(i));
				classes[i] = String.class;
			}
		}
		return classes;
	}

	public static <T> String join(final Collection<T> collection,
			final String delimiter) {

		final StringBuilder sb = new StringBuilder();
		for (final Iterator<T> i = collection.iterator(); i.hasNext();) {
			sb.append(i.next());
			if (i.hasNext()) {
				sb.append(delimiter);
			}
		}
		return sb.toString();
	}

	public static String buildInsertMapCommand(String tableName,
			HashMap<String, Object> mapData) {
		ArrayList<String> columnNames = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		for (String key : mapData.keySet()) {
			columnNames.add(key);
			values.add(mapData.get(key));
		}
		StringBuilder sb = new StringBuilder("INSERT ");
		sb.append(" INTO ");
		sb.append(tableName).append(" (");
		sb.append(join(columnNames, SEP));
		sb.append(") VALUES (");

		final List<String> insertedValues = new ArrayList<String>();
		if (values != null) {
			for (Object value : values) {
				value = StringUtil.getReplaceChar(StringUtil.setNotNull(value));
				insertedValues.add("'" + value + "'");
			}
		}
		while (insertedValues.size() < columnNames.size()) {
			insertedValues.add("?");
		}
		sb.append(join(insertedValues, SEP));
		sb.append(")");
		return sb.toString();
	}

	/**
	 * build insert command from HashMap
	 */
	public static String buildInsertCommandGeneric(String tableName,
			Map<String, Object> mapData) {
		ArrayList<String> columnNames = new ArrayList<String>();
		for (String key : mapData.keySet()) {
			columnNames.add(key);
		}

		StringBuilder sb = new StringBuilder("INSERT ");
		sb.append(" INTO ");
		sb.append(tableName).append(" (");
		sb.append(join(columnNames, SEP));
		sb.append(") VALUES (");

		final List<Object> insertedValues = new ArrayList<Object>();
		while (insertedValues.size() < columnNames.size()) {
			insertedValues.add("?");
		}
		sb.append(join(insertedValues, SEP));
		sb.append(")");
		return sb.toString();
	}

	/**
	 * build update command from HashMap
	 */
	public static String buildUpdateCommandFiedAge(String tableName,
			Map<String, Object> mapData, String columnNameId, String valueId) {
		String value = "";
		StringBuilder sb = new StringBuilder(" UPDATE ");
		sb.append(tableName);
		sb.append(" SET ");

		List<String> listTmp = new ArrayList<String>();
		for (String key : mapData.keySet()) {
			value = StringUtil.setNotNull(mapData.get(key));
			if (value.equals("")) {
				value = "''";
			}
			listTmp.add(key + " = " + value + " ");

		}
		sb.append(StringUtil.join(listTmp, ","));
		sb.append(" WHERE ");
		sb.append(columnNameId);
		sb.append(" = ");
		sb.append(valueId);
		return sb.toString();
	}

	/******************** CLOSE ************************************************/

	public static void close(Connection con) {
		try {
			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeRS(ResultSet rs) {
		try {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closePS(PreparedStatement pst) {
		try {
			if (pst != null && !pst.isClosed()) {
				pst.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeCS(CallableStatement cs) {
		try {
			if (cs != null && !cs.isClosed()) {
				cs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeST(Statement st) {
		try {
			if (st != null && !st.isClosed()) {
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeAll(ResultSet rs , PreparedStatement pst , Connection con ) {
		try {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
			if (pst != null && !pst.isClosed()) {
				pst.close();
			}
			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void error(Exception ex, Connection con) {
		rollback(con);
	}

	public static void rollback(Connection con) {
		try {
			if (con != null && !con.isClosed()) {
				con.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/******************** displayResults ************************************************/

	public static void displayResults(ResultSet rs) {
		ResultSetMetaData metaData;
		try {
			metaData = rs.getMetaData();
			int columns = metaData.getColumnCount();
			String text = "";

			while (rs.next()) {
				for (int i = 1; i <= columns; ++i) {
					text += "" + metaData.getColumnName(i) + ":\t";
					text += rs.getString(i);
					text += "\n";
				}
				text += "\n";
				System.out.println(text);
				text = "";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
