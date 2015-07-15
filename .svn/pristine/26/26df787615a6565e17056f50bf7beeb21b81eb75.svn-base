package com.digitexx.ancestry.gui;
import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.ancestry.bean.BeanInfo;
import com.digitexx.ancestry.bean.DigiSoftInfo;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.component.PanelTwoGrid;
import com.digitexx.ancestry.dao.DaoMoveDataOtherProject;
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
@SuppressWarnings("serial")
public class FrmMoveDataDpcQmdOtherProject extends javax.swing.JFrame {

	private FrmStep frmStep ;
	private Tbl_Projects project ;
	private JPanel panelHeader;
	private JPanel panelButton;
	private JPanel panelFooter;
	private JScrollPane scrollPaneLog;
	private ButtonGroup buttonGroup;
	private JButton buttonRun;
	private JRadioButton radioToDPC;
	private JRadioButton radioToDigiSoft;
	private JTextPane textPaneLog;
	private JTable tableField;
	private JScrollPane scrollPaneField;
	private JPanel panelField;
	private JPanel panelLog;
	private JSplitPane splitPaneFooter;
	private String userId;
	private List<String> listPath;
	
	private DefaultTableModel modelField;
	private DaoMoveDataOtherProject daoMoveDataOtherProject;
	private PanelTwoGrid panelTwoGrid;
	private DigiSoftInfo digiSoftInfo;
	private Tbl_Projects projectDigiSoft;

	public FrmMoveDataDpcQmdOtherProject(FrmStep frmStep , Tbl_Projects project , String userId) {
		super();
		this.frmStep = frmStep;
		this.project = project;
		this.userId  = userId;
		daoMoveDataOtherProject = new DaoMoveDataOtherProject(project);
		loadPath(false);
		initGUI();
		initData();
	}
	
	private void initGUI() {
		try {
			this.setTitle("Move Data Between DPC And QMD For Other Project");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			{
				panelHeader = new JPanel();
				BorderLayout panelHeaderLayout = new BorderLayout();
				panelHeader.setLayout(panelHeaderLayout);
				getContentPane().add(panelHeader, new AnchorConstraint(0, 1000, 484, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelHeader.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelHeader.setPreferredSize(new java.awt.Dimension(993, 287));
				{
					panelTwoGrid = new PanelTwoGrid(listPath, new String [] { "No." , "FilePath" });
					panelHeader.add(panelTwoGrid);
				}
			}
			{
				panelButton = new JPanel();
				AnchorLayout panelButtonLayout = new AnchorLayout();
				getContentPane().add(panelButton, new AnchorConstraint(484, 1000, 535, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelButton.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelButton.setLayout(panelButtonLayout);
				panelButton.setPreferredSize(new java.awt.Dimension(993, 30));
				{
					radioToDigiSoft = new JRadioButton();
					panelButton.add(radioToDigiSoft, new AnchorConstraint(73, 238, 955, 81, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					radioToDigiSoft.setText("To DIGI-SOFT");
					radioToDigiSoft.setFont(new java.awt.Font("Arial",1,16));
					radioToDigiSoft.setForeground(new java.awt.Color(0,0,255));
					radioToDigiSoft.setSelected(true);
					radioToDigiSoft.setPreferredSize(new java.awt.Dimension(181, 30));
					radioToDigiSoft.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							radioToDigiSoftActionPerformed(evt);
						}
					});
					getButtonGroup().add(radioToDigiSoft);
				}
				{
					radioToDPC = new JRadioButton();
					panelButton.add(radioToDPC, new AnchorConstraint(73, 420, 955, 276, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					radioToDPC.setText("To DPC");
					radioToDPC.setFont(new java.awt.Font("Arial",1,16));
					radioToDPC.setForeground(new java.awt.Color(0,0,255));
					radioToDPC.setPreferredSize(new java.awt.Dimension(166, 30));
					radioToDPC.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							radioToDPCActionPerformed(evt);
						}
					});
					getButtonGroup().add(radioToDPC);
				}
				{
					buttonRun = new JButton();
					panelButton.add(buttonRun, new AnchorConstraint(83, 998, 950, 916, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonRun.setText("Run");
					buttonRun.setFont(new java.awt.Font("Arial",1,16));
					buttonRun.setPreferredSize(new java.awt.Dimension(81, 26));
					buttonRun.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							buttonRunActionPerformed(evt);
						}
					});
				}
			}
			{
				panelFooter = new JPanel();
				BorderLayout panelFooterLayout = new BorderLayout();
				panelFooter.setLayout(panelFooterLayout);
				getContentPane().add(panelFooter, new AnchorConstraint(535, 1000, 1000, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelFooter.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelFooter.setPreferredSize(new java.awt.Dimension(993, 276));
				{
					splitPaneFooter = new JSplitPane();
					panelFooter.add(splitPaneFooter);
					splitPaneFooter.setBounds(182, 406, 145, 23);
					{
						panelLog = new JPanel();
						BorderLayout jPanel1Layout = new BorderLayout();
						panelLog.setLayout(jPanel1Layout);
						splitPaneFooter.add(panelLog, JSplitPane.RIGHT);
						panelLog.setBorder(BorderFactory.createTitledBorder(null, "Log", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,16), new java.awt.Color(255,0,0)));
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
						panelField = new JPanel();
						BorderLayout jPanel2Layout = new BorderLayout();
						panelField.setLayout(jPanel2Layout);
						splitPaneFooter.add(panelField, JSplitPane.LEFT);
						panelField.setPreferredSize(new java.awt.Dimension(303, 270));
						panelField.setBorder(BorderFactory.createTitledBorder(null, "Fields", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,16), new java.awt.Color(255,0,0)));
						{
							scrollPaneField = new JScrollPane();
							panelField.add(scrollPaneField, BorderLayout.CENTER);
							{
								tableField = new JTable() 
								{
									@Override
									public boolean isCellEditable(int row,int column) {
										if(getColumnName(column).equals("No.") || getColumnName(column).equals("Field")) {
											return false;
										}else {
											return true;
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
								scrollPaneField.setViewportView(tableField);
							}
						}
					}
				}
			}
			pack();
			this.setSize(1161, 697);
			AppUtility.centerFrame(this);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					exit();
				}
			});
		} catch (Exception e) {
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
	
	/**
	 * init data
	 */
	private void initData() {
		loadField();
	}
	
	//========================================================================================================================
	
	/**
	 * laod field
	 */
	private void loadField() {
		try {
			   int index = 1;
			   List<String> lisColumName = daoMoveDataOtherProject.getListColumNameByProject("form_type");
		       String [] header = new String [] { "No." , "Field" , "Check" };
		       modelField = new DefaultTableModel(header , 0);
		       Object [] values;
		       for (String str : lisColumName) 
		       {
		    	   if(str.equals("managementid") || str.equals("status") || str.equals("seq_number") || str.equals("createdtime") || str.equals("id")) 
		    	   {
                    continue;
		    	   }
		    	   else {
		    		   values = new Object [] { index ,  str , Boolean.TRUE };
		    		   ++ index;
		    		   modelField.addRow(values);
		    	   }
			   }
		       tableField.setModel(modelField);
		       JTableUtil.styleTableWithValue(tableField , 30 , 16, true);
		       JTableUtil.fitTableColumns(tableField);
		} 
		catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgInfo(this, "loadField : " + e.toString());
		}
	}
	
	
	/**
	 * get list file path
	 */
	private void loadPath(boolean isDigiSoft) {

		try {
			listPath = new ArrayList<String>();
			if(!isDigiSoft) {
				setDigiSoftInfo();
				ArrayList<String> listIgnore = daoMoveDataOtherProject.getListPathFromDigiSoft(digiSoftInfo , projectDigiSoft);
				listPath = daoMoveDataOtherProject.getListPathByProject();
				listPath.removeAll(listIgnore);
			}else {
				setDigiSoftInfo();
				listPath = daoMoveDataOtherProject.getListPathFromDigiSoft(digiSoftInfo , projectDigiSoft);
			}
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgInfo(this, "loadPath : " + e.toString());
		}
	}
	
	/**
	 * set information of DIGI-SOFT
	 */
	private void setDigiSoftInfo() 
	{
		try 
		{
	    	String projectNameDigiSoft = project.getProj_name()+"_for_qc";
	    	projectDigiSoft = new Tbl_Projects();
	    	projectDigiSoft = daoMoveDataOtherProject.getProjectInformation(projectNameDigiSoft);
	    	
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
	 * get array column name
	 */
	private String [] getArrayColumnName() {

		int totalRow = tableField.getRowCount();
		String [] arrColumn = new String [totalRow];
		String check = "";
		for (int i = 0; i < totalRow; i++) {
			check = JTableUtil.getValuesByHeaderName(tableField, "Check", i);
			if(check.equals("true")) {
				arrColumn[i] = tableField.getValueAt(i, 1).toString();
			}
		}
		return arrColumn;
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
            	flag = daoMoveDataOtherProject.moveDataDigiSoft(beanInfo , digiSoftInfo , isAllPath);
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
            	
            	String projectNameDigiSoft = project.getProj_name()+"_for_qc";
            	Tbl_Projects projectDigiSoft = daoMoveDataOtherProject.getProjectInformation(projectNameDigiSoft);
            	filepath = StringUtil.join(listPath, "`");
            	var_con  = "hostaddr="+project.getProj_serverip()+" dbname="+ projectDigiSoft.getProj_dbname()
            			 +" user="+projectDigiSoft.getProj_uid()+" password=" + projectDigiSoft.getProj_pwd()+"";
            	search_path = "set search_path to db_092_140627_bayer_invoice_scanning_te_for_qc";
            	
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
            	flag = daoMoveDataOtherProject.moveDataToDPC(beanInfo  , isAllPath);
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
					buttonRun.setEnabled(false);
					List<String> listPath = new ArrayList<String>();
					if(panelTwoGrid.getRightPanelGridPath().getListPath().size() > 0) {
						listPath.addAll(panelTwoGrid.getRightPanelGridPath().getListPath());
					}
					else {
						listPath.addAll(panelTwoGrid.getLeftPanelGridPath().getListPath());
					}
					if(listPath.size() > 0) 
					{
						if(radioToDigiSoft.isSelected()) {
							moveDataToDIGISOFT(listPath);
						}
						if(radioToDPC.isSelected()) {
							moveDataToDPC(listPath);
						}
					}
					buttonRun.setEnabled(true);
				}
			});
			thread.start();
	}
	
	private void buttonRunActionPerformed(ActionEvent evt) {
		processRun();
	}
	
	private void radioToDigiSoftActionPerformed(ActionEvent evt) {
		loadPath(false);
		panelTwoGrid.reloadData(listPath);
	}
	
	private void radioToDPCActionPerformed(ActionEvent evt) {
		loadPath(true);
		panelTwoGrid.reloadData(listPath);
	}

}
