/**
 * 
 */
package com.digitexx.ancestry.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.digitexx.ancestry.db.ConnectionDB;
import com.digitexx.ancestry.db.JdbcHelper;
import com.digitexx.ancestry.util.AncestryException;

/**
 * @author lqnhu
 *
 */
public class DaoInfoGroupUser {

	private ConnectionDB db = ConnectionDB.getInstance();
	/**
	 * get list group PMS
	 */
	public Map<Integer , String> getListGroupPMS(String host) throws AncestryException{
		Map<Integer , String> mapGroup = new HashMap<Integer, String>();
		Connection con = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = "SELECT grp_id , grp_name FROM tbl_groups where grp_prdregion_name NOT IN ('Other') ORDER BY grp_id";
			con = db.getConPMSByHost(host);
			rs = JdbcHelper.queryToResultset(con, sql);
			while(rs.next()) {
				mapGroup.put(rs.getInt("grp_id"), rs.getString("grp_name"));
			}
		} catch (Exception e) {
			throw new AncestryException("getListGroupPMS : "  + e.toString() , e);
		}finally {
			JdbcHelper.closeRS(rs);
			JdbcHelper.close(con);
		}
		return mapGroup;
	}
	
	public List<Object[]> getListUserByPjm(int group_id , String host , boolean isGetAll) throws AncestryException{
		List<Object[]> listUser = new ArrayList<Object[]>();
		Connection con = null;
		String sql = "";
		try {
			if(!isGetAll) {
				sql = "SELECT usr_name , usr_fullname , grp_name FROM tbl_users u JOIN tbl_groups g ON u.usr_grp_id = g.grp_id "
						+ " WHERE usr_status =1 AND usr_grp_id ="+group_id+"";	
			}else {
				sql = "SELECT usr_name , usr_fullname , grp_name FROM tbl_users u JOIN tbl_groups g ON u.usr_grp_id = g.grp_id "
						+ " WHERE usr_status =1";
			}
			con = db.getConPMSByHost(host);
			listUser = JdbcHelper.queryToListObject(con, sql);
		} catch (Exception e) {
			throw new AncestryException("getListUserByPjm : "  + e.toString() , e);
		}finally {
			JdbcHelper.close(con);
		}
		return listUser;
	}
}
