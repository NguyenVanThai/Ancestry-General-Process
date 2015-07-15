/**
 * 
 */
package com.digitexx.ancestry.dao;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;

import com.digitexx.ancestry.bean.TimeInfo;
import com.digitexx.ancestry.conts.MyInfoConstant;
import com.digitexx.ancestry.db.ConnectionDB;
import com.digitexx.ancestry.db.JdbcHelper;

/**
 * @author lqnhu
 *
 */
public class TimeManagementDao
{
	ConnectionDB db = ConnectionDB.getInstance();
	public void loadTimeInfo(String userId , int step , JLabel labelSpeed , JLabel labelTotalTime){

		try{	

			TimeInfo timeInfo = new TimeInfo();
			try{
				timeInfo = loadTimeInfo( userId, MyInfoConstant.QC_FINAL );
			}
			catch (Exception e) {
				e.printStackTrace();
			}

			MyInfoConstant.SPEED_TYPE1	= timeInfo.getSpeedType1();
			MyInfoConstant.SPEED_TYPE2 	= timeInfo.getSpeedType2();
			MyInfoConstant.SPEED_VERIFY 	= timeInfo.getSpeedVerify();
			MyInfoConstant.LIST_SPEED	= timeInfo.getListSpeed();

			MyInfoConstant.TOTAL_TIME	= timeInfo.getTotalTime();
			MyInfoConstant.TOTAL_JOB_SPEED = timeInfo.getTotalJob();
			MyInfoConstant.TOTAL_SPEED = 0;
			
			for( int i = 0; i < MyInfoConstant.LIST_SPEED.size() ; i++ ){
				
				MyInfoConstant.TOTAL_SPEED+= MyInfoConstant.LIST_SPEED.get(i);
			}

			float speedStandar ;
			if( step == 1 ){
				speedStandar = MyInfoConstant.SPEED_TYPE1;
			}else {
				speedStandar = MyInfoConstant.SPEED_QC_FINAL;
			}
			
			compareSpeedTime_Process( speedStandar ,labelSpeed, labelTotalTime);

		}catch( Exception e ){
			e.printStackTrace();
		}
	}
	
	public void loadSpeed(JLabel labelSpeed , JLabel labelTotalTime , String user , int step)
	{
		try {
			Float arr[] = getSpeed(user, step);
			MyInfoConstant.TOTAL_TIME = arr[0];
			
			MyInfoConstant.TOTAL_SPEED = arr[1];			
			MyInfoConstant.TOTAL_JOB_SPEED = arr[2];
			
			float speedStandar;
			speedStandar = MyInfoConstant.SPEED_TYPE2;
			compareSpeedTime_Process( speedStandar ,labelSpeed, labelTotalTime);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadSpeedProcessImage(JLabel labelSpeed , JLabel labelTotalTime , String user , int step)
	{
		try {
			Float arr[] = getSpeed(user, step);
			MyInfoConstant.TOTAL_TIME = arr[0];
			
			MyInfoConstant.TOTAL_SPEED = arr[1];			
			MyInfoConstant.TOTAL_JOB_SPEED = arr[2];
			
			float speedStandar;
			speedStandar = MyInfoConstant.SPEED_PROCESS_IMAGE;
			compareSpeedTime_Process( speedStandar ,labelSpeed, labelTotalTime);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Float[] getSpeed( String username, int step){

		Float timeInfo[] = new Float[]{(float) 0, (float) 0};
		Connection con = null;
		String sql = "" ;
		String strStep = "" ;
		float speed_Speci = 0;
		float totaltime_Global = 0;
		float totaltime_speed = 0;

		try{

			con = db.getConnect();
			if( step == 1 ){
				strStep = MyInfoConstant.TYPE;

			}else if( step == 2 ){
				strStep = MyInfoConstant.PROOF;
			}
			else if( step == 3 ){
				strStep = MyInfoConstant.VERIFY;
			}
			else if( step == 4 ){
				strStep = MyInfoConstant.QC_FINAL;
			}

			sql = "SELECT SUM(totalimages) as speed, round(sum(totaltime)/60, 2) as totaltime_speed "+ 
			" FROM work_details where datework = current_date and user_name = '"+username+"' and step = '"+strStep+"';" ;

			System.out.println("sql speed: " + sql );
			ResultSet rs = JdbcHelper.queryToResultset(con, sql);

			while( rs.next() ){
				speed_Speci = rs.getFloat("speed");
				totaltime_speed = rs.getFloat("totaltime_speed");
			}

			sql = "select round(sum(totaltime)/60, 2) as totaltime from work_details where datework = current_date and user_name = '"+username+"'" ;
			System.out.println("sql totaltime: " + sql );
			rs = JdbcHelper.queryToResultset(con, sql);

			while( rs.next() ){
				totaltime_Global = rs.getFloat("totaltime");
			}
			timeInfo = new Float[]{totaltime_Global , totaltime_speed, speed_Speci };
			con.commit();

		}
		catch( Exception ex) 
		{
			JdbcHelper.rollback(con);
			ex.printStackTrace();
		}
		finally{
            JdbcHelper.close(con);
		}
		return timeInfo ;

	}
	
	public boolean compareSpeedTime_Process( float standSpeed, JLabel speedLabel, JLabel totalTimeLabel )
	{		
		boolean isOK = false ;
		try {
			
			float speed = 0 ;
			float totalTime = 0 ;
			totalTime = MyInfoConstant.TOTAL_TIME;

			totalTime = totalTime*100;
			totalTime = (float)Math.round( totalTime )/100;
			speed = MyInfoConstant.TOTAL_SPEED/MyInfoConstant.TOTAL_JOB_SPEED;
			speed = speed*100;
			speed = (float)Math.round( speed)/100;
			
			speedLabel.setText( speed + "" );
			totalTimeLabel.setText( totalTime + "" );
			
			if( speed > standSpeed ){
				speedLabel.setForeground( Color.RED );
				
			}else if( speed < standSpeed ){
				speedLabel.setForeground( Color.BLUE );
				
			}else if( speed == standSpeed ){
				speedLabel.setForeground( Color.BLACK );
			}
			isOK = true;
			
		}
		catch( Exception e ){
			e.printStackTrace();
		}
		
		return isOK;
	}
	
	public TimeInfo loadTimeInfo(String username, String stepName)
	{
		TimeInfo timeInfo = new TimeInfo();
		String strDateNow = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

		Connection con = null;
		String sql = "";
		String strStep = stepName;

		try {

			con = db.getConnect();

			timeInfo.setProjID(0);
			timeInfo.setUnitID(0);
			timeInfo.setSpeedType1(0);
			timeInfo.setSpeedType2(0);
			timeInfo.setSpeedVerify(0);

			sql = "SELECT totaltime FROM work_details where datework='"+ strDateNow + "' and user_name='" + username
					+ "' and step='" + strStep + "';";
			
			System.out.println("sql: " + sql);
			ResultSet rs = JdbcHelper.queryToResultset(con, sql);
			List<Float> listSpeed = new ArrayList<Float>();

			while (rs.next()) {
				listSpeed.add(rs.getFloat("totaltime"));
			}
			timeInfo.setListSpeed(listSpeed);

			sql = "SELECT sum(totaltime) as total FROM work_details where datework='"+ strDateNow + "' and user_name='" + username + "';";
			System.out.println("sql: " + sql);
			rs = JdbcHelper.queryToResultset(con, sql);

			while (rs.next()) {
				timeInfo.setTotalTime(rs.getFloat("total"));
			}
			con.commit();

		} catch (Exception ex) {
			JdbcHelper.rollback(con);
			ex.printStackTrace();

		} finally {
			JdbcHelper.close(con);
		}
		return timeInfo;

	}
}
