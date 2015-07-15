/**
 * 
 */
package com.digitexx.ancestry.job.info;

import static java.util.concurrent.TimeUnit.SECONDS;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.component.PanelTrayIcon;
import com.digitexx.ancestry.dao.DaoJobInformation;
import com.digitexx.ancestry.db.ConnectionDB;
import com.digitexx.ancestry.util.AppUtility;
import com.digitexx.ancestry.util.ReadTxtUtil;
import com.digitexx.ancestry.util.SystemUtil;

/**
 * @author lqnhu
 *
 */
public class ScheduleAncestryJobInfo {
	
	private int DELAY = 3600;
	private Map<String , Tbl_Projects> mapBeanProject = new LinkedHashMap<String , Tbl_Projects>();
	private DaoJobInformation  daoJobInformation = new DaoJobInformation();
	private List<Object[]> listJobInfo = new ArrayList<Object[]>();
	public  Map<String, List<Object[]>> mapJobType = new LinkedHashMap<String , List<Object[]>>();
	public  Map<String, List<Object[]>> mapJobRework = new LinkedHashMap<String , List<Object[]>>();
	private List<String> listPjm = new ArrayList<String>();
	private String username = "";
	private boolean isPjm;

	public ScheduleAncestryJobInfo() {
		this.mapJobType = new LinkedHashMap<String , List<Object[]>>();
		this.mapJobRework = new LinkedHashMap<String , List<Object[]>>();

		getUserLogin();
		readConfig();
		loadPjm();
		checkRole();
		loadProject();
		initData();
	}

	
	private void getUserLogin() 
	{
		try {
			if(SystemUtil.getOsName().contains("Linux"))
			{
				//username = SystemUtil.getUserMountLinux();
				if(username.equals("")) {
					List<String> listTmp = ReadTxtUtil.readList(SystemUtil.getUserHome()+"/" +"curent_user_ancestry.log");
				    if(listTmp.size()  >0) {
				    	username = listTmp.get(0);
				    }
				}
			}else {
				this.username = SystemUtil.getUserName();
				username = username.substring(username.lastIndexOf("\\") + 1);
			}
			if(username.equals("")) {
				AppUtility.msgError(null, "Please mount in system again !!");
			}
			if(username.equals("lqnhu")) {
				username ="tttdiem";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * init data
	 */
	public void initData() 
	{
		this.mapJobType = new LinkedHashMap<String , List<Object[]>>();
		this.mapJobRework = new LinkedHashMap<String , List<Object[]>>();
		loadJobInfo(false);
		loadJobInfo(true);
	}
	
	public void readConfig() {
		try {
			String path = ReadTxtUtil.getPathOfFile("config/db.properties");
			Properties propertiesConfig = new Properties();
			propertiesConfig.load(new FileInputStream(path));
			if(!propertiesConfig.isEmpty())
			{
				ConnectionDB.delay = propertiesConfig.getProperty("delay");
				ConnectionDB.host = propertiesConfig.getProperty("database");
				String tmp  = Objects.toString(ConnectionDB.delay , "");
				if(!tmp.equals("")) {
					DELAY = Integer.parseInt(ConnectionDB.delay);
				}			
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
			AppUtility.msgError(null, "readConfig : "  + e.toString());
		}

	}
	
	/**
	 * load all PJM from file config
	 */
	private void loadPjm() {
		try {
			String path = ReadTxtUtil.getPathOfFile("/config/pjm.txt");
			listPjm = ReadTxtUtil.readList(path);
			if(listPjm.size() == 0) {
				AppUtility.msgError(null, "Not found file : pjm.txt  !!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(null, "loadPjm : "  + e.toString());
		}
	}
	
	/**
	 * load all project from file config
	 */
	private void loadProject() {
		try {
			mapBeanProject = new LinkedHashMap<String , Tbl_Projects>();
			List<String> listProject = new ArrayList<String>();
			
			String path = ReadTxtUtil.getPathOfFile("/config/project.txt");
			listProject = ReadTxtUtil.readList(path);
			if(listProject.size() > 0) {
                  mapBeanProject = daoJobInformation.getListProject(listProject);
			}else {
				AppUtility.msgError(null, "Not found config data !!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(null, "loadProject : "  + e.toString());
		}
	}
	
	/**
	 * check role
	 */
	private void checkRole() {
		if (listPjm.contains(username)) {
			isPjm = true;
		}
	}
	
	/**
	 * load job infomation
	 */
	private void loadJobInfo(boolean isRework) {
		try {
			for (String projectName : mapBeanProject.keySet()) {
				Tbl_Projects project = mapBeanProject.get(projectName);
				boolean hasTablePhase = daoJobInformation.checkExistTablePhase(project);
				
				listJobInfo = new ArrayList<Object[]>();
				listJobInfo = daoJobInformation.getListManagementByProject(project , isPjm , username , isRework , hasTablePhase);
			
				if(listJobInfo.size() > 0) {
					if(!isRework) {
						mapJobType.put(projectName, listJobInfo);
					}else {
						mapJobRework.put(projectName, listJobInfo);
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * start run schedule
	 */
	public void startSchedule() 
	{
	    ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
	    final ThreadRunSchedule threadSchedule = new ThreadRunSchedule(this ,listPjm , mapBeanProject , username , isPjm);
	    final ScheduledFuture<?> timeHandle = scheduler.scheduleAtFixedRate( threadSchedule , 0, DELAY, SECONDS);    

	    scheduler.schedule(new Runnable() {
	      public void run() {
	        timeHandle.cancel(false);
	      }
	      
	    }, 60*60, SECONDS);
	}
	
	//=========================================================================================================================
	
	public static void main(String[] args)
	{
		ScheduleAncestryJobInfo scheduleAncestryJobInfo = new ScheduleAncestryJobInfo();
		scheduleAncestryJobInfo.startSchedule();
	}
}

class ThreadRunSchedule implements Runnable {

	private FrmUserJobInformation frmUserJobInformation ;
	private Map<String , Tbl_Projects> mapBeanProject ;
	private ScheduleAncestryJobInfo scheduleAncestryJobInfo;
	private String username;
	private boolean isPjm;
	public PanelTrayIcon panelTrayIcon;
	
	public ThreadRunSchedule(ScheduleAncestryJobInfo scheduleAncestryJobInfo,
			                 List<String> listPjm , Map<String , Tbl_Projects> mapBeanProject ,
			                 String username , 
			                 boolean isPjm)
	{
		this.scheduleAncestryJobInfo = scheduleAncestryJobInfo;
		this.mapBeanProject = mapBeanProject;
		this.username = username;
		this.isPjm = isPjm;
	}
	
	public void run() {
		if(panelTrayIcon != null) {
			panelTrayIcon.removeTrayIcon();
			frmUserJobInformation.dispose();
		}

		if(scheduleAncestryJobInfo.mapJobType.size() == 0 && scheduleAncestryJobInfo.mapJobRework.size() ==0) {
			System.out.println("NOT FOUND JOB : " + new Date());
			
		}else {
			if(frmUserJobInformation!= null) {
				scheduleAncestryJobInfo.initData();
				System.out.println("reeeeeeeeeeee time : %tr%n" + new Date());
			}
			frmUserJobInformation = new FrmUserJobInformation(panelTrayIcon ,mapBeanProject , scheduleAncestryJobInfo.mapJobType , scheduleAncestryJobInfo.mapJobRework , username , isPjm);
			panelTrayIcon = new PanelTrayIcon(frmUserJobInformation , "Ancestry");
			frmUserJobInformation.add(panelTrayIcon);
			frmUserJobInformation.setVisible(true);
		}
	}
	
	
}
