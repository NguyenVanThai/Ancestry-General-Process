package com.digitexx.ancestry.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.ancestry.bean.BeanInfo;
import com.digitexx.ancestry.bean.DigiSoftInfo;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.component.PanelTwoGrid;
import com.digitexx.ancestry.dao.DaoQMDTransferDataDPC;
import com.digitexx.ancestry.util.AppUtility;
import com.digitexx.ancestry.util.JTableUtil;
import com.digitexx.ancestry.util.StringUtil;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class FrmQMDTransferDataDPC extends javax.swing.JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panelHeader;
	private JPanel panelBottom;
	private JScrollPane scrollPaneLog;
	private ButtonGroup buttonGroup;
	private JRadioButton radioToDPC;
	private JRadioButton radioToQMD;
	private JButton butttonRun;
	private JProgressBar progressBar;
	private JPanel panelProcess;
	private JTextPane textPaneLog;
	private JTable tableColumn;
	private JScrollPane scrollPaneColumn;
	private JPanel panelColumn;
	private JPanel panelLog;
	private JSplitPane splitPaneFooter;
	private JPanel panelFooter;
	private JPanel panelMain;
	private List<String> listAll;
	private List<String> listSelect;
	private PanelTwoGrid panelTwoGrid;
	private DefaultTableModel model;
	private Tbl_Projects project;
	private String userId;
	private FrmStep frmStep;
	private DaoQMDTransferDataDPC daoQMDTransferDataDPC;
	private String schema = "";
	private DigiSoftInfo digiSoftInfo;
	private Tbl_Projects projectDigiSoft;

	public FrmQMDTransferDataDPC(Tbl_Projects project , String userId , FrmStep frmStep ) {
		super();
		this.project = project;
		this.userId  = userId;
		this.frmStep = frmStep;
		
		daoQMDTransferDataDPC = new DaoQMDTransferDataDPC(project);
		getListFilePath(false);
		initGUI();
		initData();
	}
	
	private void initGUI() {
		try {
			this.setTitle("Form Transfer Data Between QMD and DPC");
			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			{
				panelMain = new JPanel();
				AnchorLayout panelMainLayout = new AnchorLayout();
				getContentPane().add(panelMain, BorderLayout.CENTER);
				panelMain.setLayout(panelMainLayout);
				{
					panelHeader = new JPanel();
					BorderLayout panelHeaderLayout = new BorderLayout();
					panelHeader.setLayout(panelHeaderLayout);
					panelMain.add(panelHeader, new AnchorConstraint(0, 1000, 434, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					panelHeader.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
					panelHeader.setPreferredSize(new java.awt.Dimension(962, 303));
					{
						panelTwoGrid = new PanelTwoGrid(listAll, new String [] { "No." , "FilePath" });
						panelHeader.add(panelTwoGrid);
					}
				}
				{
					panelBottom = new JPanel();
					AnchorLayout panelBottomLayout = new AnchorLayout();
					panelMain.add(panelBottom, new AnchorConstraint(434, 1000, 482, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					panelBottom.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
					panelBottom.setLayout(panelBottomLayout);
					panelBottom.setPreferredSize(new java.awt.Dimension(962, 33));
					{
						butttonRun = new JButton();
						panelBottom.add(butttonRun, new AnchorConstraint(75, 998, 954, 923, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						butttonRun.setText("Run");
						butttonRun.setFont(new java.awt.Font("Arial",1,12));
						butttonRun.setPreferredSize(new java.awt.Dimension(72, 29));
						butttonRun.setBounds(887, 2, 73, 30);
						butttonRun.addActionListener(this);
					}
					{
						radioToQMD = new JRadioButton();
						panelBottom.add(radioToQMD, new AnchorConstraint(73, 123, 955, 1, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						radioToQMD.setText("To DIGI_SOFT");
						radioToQMD.setFont(new java.awt.Font("Arial",1,12));
						radioToQMD.setForeground(new java.awt.Color(255,0,0));
						radioToQMD.setSelected(true);
						radioToQMD.setPreferredSize(new java.awt.Dimension(117, 30));
						radioToQMD.addActionListener(this);
						getButtonGroup().add(radioToQMD);
					}
					{
						radioToDPC = new JRadioButton();
						panelBottom.add(radioToDPC, new AnchorConstraint(73, 220, 955, 134, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						radioToDPC.setText("To DPC");
						radioToDPC.setFont(new java.awt.Font("Arial",1,12));
						radioToDPC.setForeground(new java.awt.Color(255,0,0));
						radioToDPC.setPreferredSize(new java.awt.Dimension(83, 30));
						radioToDPC.addActionListener(this);
						getButtonGroup().add(radioToDPC);
					}
				}
				{
					panelFooter = new JPanel();
					AnchorLayout panelFooterLayout = new AnchorLayout();
					panelFooter.setLayout(panelFooterLayout);
					panelMain.add(panelFooter, new AnchorConstraint(482, 1000, 967, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					panelFooter.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
					panelFooter.setPreferredSize(new java.awt.Dimension(962, 339));
					{
						splitPaneFooter = new JSplitPane();
						panelFooter.add(splitPaneFooter, new AnchorConstraint(7, 998, 995, 2, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						splitPaneFooter.setPreferredSize(new java.awt.Dimension(958, 334));
						{
							panelLog = new JPanel();
							BorderLayout panelLogLayout = new BorderLayout();
							panelLog.setLayout(panelLogLayout);
							splitPaneFooter.add(panelLog, JSplitPane.RIGHT);
							panelLog.setBorder(BorderFactory.createTitledBorder(null, "Log Detail", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,14)));
							{
								scrollPaneLog = new JScrollPane();
								panelLog.add(scrollPaneLog, BorderLayout.CENTER);
								{
									textPaneLog = new JTextPane();
									scrollPaneLog.setViewportView(textPaneLog);
								}
							}
						}
						{
							panelColumn = new JPanel();
							BorderLayout panelColumnLayout = new BorderLayout();
							panelColumn.setLayout(panelColumnLayout);
							splitPaneFooter.add(panelColumn, JSplitPane.LEFT);
							panelColumn.setPreferredSize(new java.awt.Dimension(439, 333));
							panelColumn.setBorder(BorderFactory.createTitledBorder(null, "List All Column", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,14)));
							{
								scrollPaneColumn = new JScrollPane();
								panelColumn.add(scrollPaneColumn, BorderLayout.CENTER);
								{
									tableColumn = new JTable()
									{
										@Override
										public boolean isCellEditable(int row,int column) 
										{
											if(getColumnName(column).equals("Check")) {
												return true;
											}else {
												return false;
											}
										}
										
										@Override
										public Class<?> getColumnClass(int column) 
										{
											switch (column) {
											case 0:
												return Integer.class;

											case 1:
												return String.class;

											case 2:
												return Boolean.class;

											default:
												return String.class;
											}
										}
									};
									scrollPaneColumn.setViewportView(tableColumn);
								}
							}
						}
					}
				}
				{
					panelProcess = new JPanel();
					AnchorLayout panelProcessLayout = new AnchorLayout();
					panelProcess.setLayout(panelProcessLayout);
					panelMain.add(panelProcess, new AnchorConstraint(967, 999, 999, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					panelProcess.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
					panelProcess.setPreferredSize(new java.awt.Dimension(961, 22));
					{
						progressBar = new JProgressBar();
						panelProcess.add(progressBar, new AnchorConstraint(108, 998, 934, 2, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						progressBar.setPreferredSize(new java.awt.Dimension(957, 19));
					}
				}
			}
			pack();
			this.setSize(970, 732);
			AppUtility.centerFrame(this);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					exit();
				}
			});
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private ButtonGroup getButtonGroup() {
		if(buttonGroup == null) {
			buttonGroup = new ButtonGroup();
		}
		return buttonGroup;
	}

	private void exit() {
		if(AppUtility.msgConfirm(this, "Do you want to exit ??") == JOptionPane.OK_OPTION) {
			frmStep.setVisible(true);
			this.dispose();
		}
	}
	
	private void initData() 
	{
		listAll               = new ArrayList<String>();
		listSelect            = new ArrayList<String>();
		loadColumnName();
	}
	
	
	/**
	 * set format jtable
	 */
	private void styleTable(JTable tableData) 
	{
		tableData.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
		JTableHeader header = tableData.getTableHeader();
		header.setForeground(Color.black);
		tableData.setCellSelectionEnabled(true);
		tableData.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tableData.setFont(new java.awt.Font("Arial",Font.PLAIN,16));
		tableData.setShowGrid(true);
		tableData.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		tableData.setRowHeight(30);
		tableData.getTableHeader().setReorderingAllowed(false);
		JTableUtil.fitTableColumns(tableData);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		Object action = evt.getSource();
		if(action == butttonRun) {
		    processRun();
		}
		if(action == radioToQMD && radioToQMD.isSelected()) {
			getListFilePath(false);
			panelTwoGrid.reloadData(listAll);
		}
		if(action == radioToDPC && radioToDPC.isSelected()) {
			getListFilePath(true);
			panelTwoGrid.reloadData(listAll);
		}
	}
	
	//====================================================================================================================
	

	/**
	 * get list file path
	 */
	private void getListFilePath(boolean isDigiSoft) {

		try {
			listAll = new ArrayList<String>();
			if(!isDigiSoft) {
				setDigiSoftInfo();
				ArrayList<String> listIgnore = daoQMDTransferDataDPC.getListPathFromDigiSoft(digiSoftInfo , projectDigiSoft , true);
				listAll = daoQMDTransferDataDPC.getListPathByProject();
				listAll.removeAll(listIgnore);
			}else {
				setDigiSoftInfo();
				listAll = daoQMDTransferDataDPC.getListPathFromDigiSoft(digiSoftInfo , projectDigiSoft , false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgInfo(this, "getListFilePath : " + e.toString());
		}
	}
	
	/**
	 * load all column namme
	 */
	private void loadColumnName()
	{ 
		try {
			   int index = 1;
			   List<String> lisColumName = daoQMDTransferDataDPC.getListColumNameByProject();
		       String [] header = new String [] { "No." , "Field" , "Check" };
		       model = new DefaultTableModel(header , 0);
		       Object [] values;
		       for (String str : lisColumName) 
		       {
		    	   if(str.indexOf("check_anrede") > -1 || 
		    		  str.indexOf("status_") > -1      || 
		    		  str.equals("createdtime")  ||
		    		  str.indexOf("seq_number") > -1   || 
		    		  str.indexOf("filepath") > -1     || 
		    		  str.indexOf("filename") > -1     ||
		    		  str.indexOf("coordinates") > -1  ||
		    		  str.indexOf("managementid") > -1 ||
		    		  str.indexOf("header_place") > -1 ||
		    		  str.equals("form")||
		    		  str.equals("id")||   
		    		  str.indexOf("user_final") > -1  ||
		    		  str.indexOf("_export") > -1) 
		    	   {
                       continue;
		    	   }
		    	   else {
		    		   values = new Object [] { index ,  str , Boolean.TRUE };
		    		   ++ index;
		    		   model.addRow(values);
		    	   }
			   }
		       tableColumn.setModel(model);
		       styleTable(tableColumn);
		} 
		catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgInfo(this, "loadColumnName : " + e.toString());
		}

	}

	/**
	 * get array column name
	 */
	private String [] getArrayColumnName() {

		int totalRow = tableColumn.getRowCount();
		List listTmp = new ArrayList();
		String columnName = "";
		String check = "";
		for (int i = 0; i < totalRow; i++) {
			columnName = tableColumn.getValueAt(i, 1).toString();
			check = JTableUtil.getValuesByHeaderName(tableColumn, "Check", i);
			if(check.equals("true")) {
				listTmp.add(columnName);
			}
		}
		int idx = 0;
		String [] arrColumn = new String [listTmp.size()];
		for (Object str : listTmp) {
			arrColumn[idx] = str.toString();
			++idx;
		}
		return arrColumn;
	}
	
	//==========================================================================================================
	
	/**
	 * set information of DIGI-SOFT
	 */
	private void setDigiSoftInfo() 
	{
		try 
		{
	    	String projectNameDigiSoft = "";
	    	if(project.getProj_name().equals("105_140715_Ancestry_42638_DE")) {
	    		projectNameDigiSoft = "105_140715_Ancestry_for_qc";
	    	}else if(project.getProj_name().equals("116_140731_Ancestry_43963_DE")) {
	    		projectNameDigiSoft = "116_140731_Ancestry_for_qc";
	    	}else {
	    		projectNameDigiSoft = project.getProj_name()+"_for_qc";
	    	}
	    	projectDigiSoft = new Tbl_Projects();
	    	projectDigiSoft = daoQMDTransferDataDPC.getProjectInformation(projectNameDigiSoft);
	    	
	    	digiSoftInfo = new DigiSoftInfo();
	    	digiSoftInfo.setServer(projectDigiSoft.getProj_serverip());
	    	digiSoftInfo.setDatabse(projectDigiSoft.getProj_dbname());
	    	digiSoftInfo.setSchema("db_000_digisoft_for_qc");
	    	digiSoftInfo.setUsername("digisoft");
	    	digiSoftInfo.setPassword("digi-SOFT");
	    	digiSoftInfo.setSchema_qc(projectDigiSoft.getProj_schema());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * mont data DPC to DIGI-SOFT
	 */
	private boolean moveDataToDIGISOFT( List<String> listPath ) 
	{
        boolean flag = false;
        try
        {
        	setDigiSoftInfo();
            String [] arrColumn = getArrayColumnName();
            String filepath = "";
            String schema_ancestry = project.getProj_schema();
            String var_con = "";
            String search_path = "set search_path to " + project.getProj_schema();
            
            BeanInfo beanInfo;
            if(listPath.size() > 0) 
            {
            	AppUtility.appendText(textPaneLog, "Running move data from PRODUCTION to DIGI-SOFT" , Color.BLUE);
            	filepath = StringUtil.join(listPath, "`");
            	var_con  = "hostaddr="+project.getProj_serverip()+" dbname="+project.getProj_dbname()
            			 +" user="+project.getProj_uid()+" password="+project.getProj_pwd()+"";
            	
            	beanInfo = new BeanInfo();
            	beanInfo.setFilepath(filepath);
            	beanInfo.setColumn_Ancestry(arrColumn);
            	beanInfo.setColumn_DigiSoft(arrColumn);
            	beanInfo.setSchema_Ancestry(schema_ancestry);
            	beanInfo.setSchema_DigiSoft(digiSoftInfo.getSchema_qc());
            	beanInfo.setVar_con(var_con);
            	beanInfo.setSearch_path(search_path);
            	
            	boolean isAllPath = false;
            	if(panelTwoGrid.getRightPanelGridPath().getListPath().size() ==0) {
            		isAllPath = true;
            	}
            	flag = daoQMDTransferDataDPC.moveDataDigiSoft(beanInfo , digiSoftInfo , isAllPath);
            	if(flag) {
                	AppUtility.appendText(textPaneLog, "Finished move data from PRODUCTION to DIGI-SOFT" , Color.RED);
            		AppUtility.msgInfo(this, "Move data from Production to DIGI-SOFT sucessfull !!");
            	}
            }
		}
        catch (Exception e) {
        	e.printStackTrace();
        	AppUtility.appendText(textPaneLog, e.toString() , Color.RED);
		}
        return flag;
	}
	
	/**
	 * mont data QMD to DPC
	 */
	private boolean moveDataToDPC( List<String> listPath ) 
	{
        boolean flag = false;
        try
        {
            String [] arrColumn = getArrayColumnName();
            String filepath = "";
            String schema_ancestry = project.getProj_schema();
            String var_con = "";
            String search_path = "";
            
            BeanInfo beanInfo;
            if(listPath.size() > 0) 
            {
            	AppUtility.appendText(textPaneLog, "Running move data from DIGI-SOFT to PRODUCTION" , Color.BLUE);
            	
            	String projectNameDigiSoft = "";
            	if(project.getProj_name().equals("105_140715_Ancestry_42638_DE")) {
            		projectNameDigiSoft = "105_140715_Ancestry_for_qc";
            	}else if(project.getProj_name().equals("116_140731_Ancestry_43963_DE")) {
            		projectNameDigiSoft = "116_140731_Ancestry_for_qc";
            	}else {
            		projectNameDigiSoft = project.getProj_name()+"_for_qc";
            	}
            	Tbl_Projects projectDigiSoft = daoQMDTransferDataDPC.getProjectInformation(projectNameDigiSoft);
            	filepath = StringUtil.join(listPath, "`");
            	var_con  = "hostaddr="+project.getProj_serverip()+" dbname="+ projectDigiSoft.getProj_dbname()
            			 +" user="+projectDigiSoft.getProj_uid()+" password=" + projectDigiSoft.getProj_pwd()+"";
            	search_path = "set search_path to db_000_digisoft_for_qc";
            	
            	beanInfo = new BeanInfo();
            	beanInfo.setFilepath(filepath);
            	beanInfo.setColumn_Ancestry(arrColumn);
            	beanInfo.setColumn_DigiSoft(arrColumn);
            	beanInfo.setSchema_Ancestry(schema_ancestry);
            	beanInfo.setSchema_DigiSoft(projectDigiSoft.getProj_schema());
            	beanInfo.setVar_con(var_con);
            	beanInfo.setSearch_path(search_path);
            	
            	boolean isAllPath = false;
            	if(panelTwoGrid.getRightPanelGridPath().getListPath().size() ==0) {
            		isAllPath = true;
            	}
            	flag = daoQMDTransferDataDPC.moveDataToAncestry(beanInfo  , isAllPath);
            	if(flag) {
                	AppUtility.appendText(textPaneLog, "Finished move data from DIGI-SOFT to PRODUCTION" , Color.RED);
            		AppUtility.msgInfo(this, "Move data from DIGI-SOFT to PRODUCTION sucessfull !!");
            	}
            }
		}
        catch (Exception e) {
        	e.printStackTrace();
        	AppUtility.appendText(textPaneLog, e.toString() , Color.RED);
		}
        return flag;
	}
	
	
	/**
	 * process button run
	 */
	private void processRun() 
	{
		Thread thread = new Thread(new Runnable() {
				@Override
				public synchronized void run() 
				{
					butttonRun.setEnabled(false);
					List<String> listPath = new ArrayList<String>();
					if(panelTwoGrid.getRightPanelGridPath().getListPath().size() > 0) {
						listPath.addAll(panelTwoGrid.getRightPanelGridPath().getListPath());
					}
					else {
						listPath.addAll(panelTwoGrid.getLeftPanelGridPath().getListPath());
					}
					if(listPath.size() > 0) 
					{
						if(radioToQMD.isSelected()) {
							moveDataToDIGISOFT(listPath);
						}
						if(radioToDPC.isSelected()) {
							moveDataToDPC(listPath);
						}
					}
					butttonRun.setEnabled(true);
				}
			});
			thread.start();
	}

}
