package com.digitexx.ancestry.gui;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.lang.StringUtils;

import com.digitexx.ancestry.bean.FieldNameList;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.dao.DaoUpperLowerData;
import com.digitexx.ancestry.util.AncestryException;
import com.digitexx.ancestry.util.AppUtility;
import com.digitexx.ancestry.util.JTableUtil;
import com.digitexx.ancestry.util.RemoveString;
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
public class FrmUpperLowerData extends javax.swing.JFrame {
	private JPanel panelMain;
	private JPanel panelFooter;
	private JSplitPane splitPaneMain;
	private JScrollPane scrollPaneLog;
	private JList jListPath;
	private JTextPane textPaneLog;
	private JTable tableField;
	private JScrollPane scrollPaneColumn;
	private JPanel panelColumn;
	private JPanel panelLog;
	private JCheckBox checkboxRework;
	private JButton buttonRun;
	private JScrollPane scrollPanePath;
	private JPanel panelColumnLog;
	private JPanel panelPath;
	private Tbl_Projects project;
	private JSplitPane splitPaneColumnAndLog;
	private FrmStep frmStep;
	private DaoUpperLowerData daoUpperLowerData;
	private Thread threadProcess;
	
	private DefaultTableModel model = new DefaultTableModel();
	private DefaultListModel modelPath = new DefaultListModel();
	
	private List<String> listPath = new ArrayList<String>();
	private List<String> listColumns = new ArrayList<String>();
	private List<FieldNameList> listField = new ArrayList<FieldNameList>();
	private List<String> listNonUpper= new ArrayList<String>();
	private List<Map<String, Object>> listData = new ArrayList<Map<String , Object>>();
	private List<Map<String, Object>> listUpdate = new ArrayList<Map<String , Object>>();
	private String [] arrColumnIgnore = new String [] { "id"   , "managementid" , "user_type" , "createdtime",
			                                            "notes", "seq_number" , "user_final" , "coordinates" };

	public FrmUpperLowerData(FrmStep frmStep , Tbl_Projects project) {
		super();
		this.frmStep = frmStep;
		this.project = project;
		this.daoUpperLowerData = new DaoUpperLowerData(project);
		initGUI();
		initData();
	}
	
	private void initGUI() {
		try {
			this.setTitle("Uppercase & Lowercase data");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			{
				panelMain = new JPanel();
				BorderLayout panelMainLayout = new BorderLayout();
				panelMain.setLayout(panelMainLayout);
				getContentPane().add(panelMain, new AnchorConstraint(0, 1000, 944, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelMain.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelMain.setPreferredSize(new java.awt.Dimension(775, 488));
				{
					splitPaneMain = new JSplitPane();
					panelMain.add(splitPaneMain, BorderLayout.CENTER);
					splitPaneMain.setOrientation(JSplitPane.VERTICAL_SPLIT);
					splitPaneMain.setDividerLocation(200);
					{
						panelColumnLog = new JPanel();
						BorderLayout panelLogLayout = new BorderLayout();
						panelColumnLog.setLayout(panelLogLayout);
						splitPaneMain.add(panelColumnLog, JSplitPane.RIGHT);
						panelColumnLog.setPreferredSize(new java.awt.Dimension(417, 482));
						{
							splitPaneColumnAndLog = new JSplitPane();
							panelColumnLog.add(splitPaneColumnAndLog, BorderLayout.CENTER);
							splitPaneColumnAndLog.setDividerLocation(200);
							{
								panelLog = new JPanel();
								BorderLayout panelLogLayout1 = new BorderLayout();
								panelLog.setLayout(panelLogLayout1);
								splitPaneColumnAndLog.add(panelLog, JSplitPane.RIGHT);
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
								splitPaneColumnAndLog.add(panelColumn, JSplitPane.LEFT);
								{
									scrollPaneColumn = new JScrollPane();
									panelColumn.add(scrollPaneColumn, BorderLayout.CENTER);
									{
										tableField = new JTable() {
											@Override
											public boolean isCellEditable(int row, int column) {
												if(getColumnName(column).equals("Check")) {
													return true;
												}else {
													return false;
												}
											}
											
											@Override
											public Class<?> getColumnClass(int column) {
												if(getColumnName(column).equals("Check")) {
													return Boolean.class;
												}else {
													return super.getColumnClass(column);
												}
											}
										};
										scrollPaneColumn.setViewportView(tableField);
									}
								}
							}
						}
					}
					{
						panelPath = new JPanel();
						BorderLayout panelPathLayout = new BorderLayout();
						panelPath.setLayout(panelPathLayout);
						splitPaneMain.add(panelPath, JSplitPane.LEFT);
						panelPath.setPreferredSize(new java.awt.Dimension(769, 316));
						{
							scrollPanePath = new JScrollPane();
							panelPath.add(scrollPanePath, BorderLayout.CENTER);
							{
								jListPath = new JList();
								scrollPanePath.setViewportView(jListPath);
								jListPath.setFont(new java.awt.Font("Arial",0,14));
							}
						}
					}
				}
			}
			{
				panelFooter = new JPanel();
				AnchorLayout panelFooterLayout = new AnchorLayout();
				getContentPane().add(panelFooter, new AnchorConstraint(944, 1000, 1000, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelFooter.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelFooter.setLayout(panelFooterLayout);
				panelFooter.setPreferredSize(new java.awt.Dimension(775, 29));
				{
					buttonRun = new JButton();
					panelFooter.add(buttonRun, new AnchorConstraint(86, 998, 948, 890, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonRun.setText("Run");
					buttonRun.setFont(new java.awt.Font("Arial",1,16));
					buttonRun.setPreferredSize(new java.awt.Dimension(83, 25));
					buttonRun.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							buttonRunActionPerformed(evt);
						}
					});
				}
				{
					checkboxRework = new JCheckBox();
					panelFooter.add(checkboxRework, new AnchorConstraint(86, 155, 948, 3, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					checkboxRework.setText("Rework");
					checkboxRework.setFont(new java.awt.Font("Arial",1,16));
					checkboxRework.setForeground(new java.awt.Color(255,0,0));
					checkboxRework.setPreferredSize(new java.awt.Dimension(118, 25));
					checkboxRework.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							checkboxReworkActionPerformed(evt);
						}
					});
				}
			}
			pack();
			this.setSize(783, 551);
			AppUtility.centerFrame(this);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					exit();
				}
			});;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void exit() {
		if(AppUtility.msgConfirm(this, "Do you want to exit ??") == JOptionPane.OK_OPTION) {
			frmStep.setVisible(true);
			this.dispose();
		}
	}
	
	private void buttonRunActionPerformed(ActionEvent evt) {
		threadProcess = new Thread(new Runnable() {
			@Override
			public synchronized void run() {
				processData();
			}
		});
		threadProcess.start();
	}
	
	private void checkboxReworkActionPerformed(ActionEvent evt) {
		daoUpperLowerData.setTable(checkboxRework.isSelected());
		loadPath();
		loadColumn();
	}

	//====================================================================================================
	
	/**
	 * init defaul data
	 */
	private void initData() {
		try {
			daoUpperLowerData.setTable(false);
			listField = new ArrayList<FieldNameList>();
			listField = daoUpperLowerData.getListFieldNameList();
			
			listNonUpper = new ArrayList<String>();
			listNonUpper = daoUpperLowerData.getListNonUpper();
			loadPath();
			loadColumn();
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "initData : "  + e.toString());
		}
	}
	
	/**
	 * load filepath
	 */
	private void loadPath() {
		try {
             listPath = new ArrayList<String>();
             listPath = daoUpperLowerData.getListPath();
             modelPath.removeAllElements();
             for (String str : listPath) {
				modelPath.addElement(str);
			 }
             jListPath.setModel(modelPath);
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "loadPath : "  + e.toString());
		}
	}
	
	/**
	 * load column of table
	 */
	private void loadColumn() {
		try {
			 List listIgnore = Arrays.asList(arrColumnIgnore);
             listColumns = new ArrayList<String>();
             listColumns = daoUpperLowerData.getListColumn();
             String[] header = new String [] {  "No." , "Field" , "Check"};
             model = new DefaultTableModel(header ,0);
             
             Object [] values;
             int idx =1;
             for (String str : listColumns) {
            	if(!listIgnore.contains(str) && str.indexOf("status") == -1  && str.indexOf("check") == -1) {
            		values = new Object[] { idx , str , Boolean.TRUE };
            		model.addRow(values);
            		++idx;
            	}
			 }
             tableField.setModel(model);
             JTableUtil.styleTable(tableField, true);
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "loadPath : "  + e.toString());
		}
	}
	
	/**
	 * get field select
	 */
	private String getFieldSelect() {
        StringBuilder sb = new StringBuilder();
        int totalRow = tableField.getRowCount();
        String field = "";
        String check = "";
        for (int i = 0; i < totalRow; i++) {
			field = JTableUtil.getValuesByHeaderName(tableField, "Field", i);
			check = JTableUtil.getValuesByHeaderName(tableField, "Check", i);
			if(check.equals("true")) {
				sb.append(field);
				sb.append(",");
			}
		}
        return sb.toString();
	}
	
	/**
	 * process data
	 */
	private void processData() 
	{
		boolean flag = false;
		try {
		       List<String> listPathSelect = new ArrayList<String>();
		       if( jListPath.getSelectedValues().length > 0) {
		    	   listPathSelect.addAll(listPath);
		       }else {
		    	   Object [] arrTmp = jListPath.getSelectedValues();
		    	   for (Object obj : arrTmp) {
					   listPathSelect.add(obj.toString());
			       }
		       }
		       String field = getFieldSelect();
		       if(field.endsWith(",")) {
		    	   field = field.substring(0 , field.lastIndexOf(","));
		       }
		       for (String path : listPathSelect) {
		    	  AppUtility.appendText(textPaneLog, "Start : "  + path, Color.BLUE);
				  flag = updateDataByPath(field,path);
				  AppUtility.appendText(textPaneLog, "End : "  + path, Color.RED);
				  if(!flag) {
					  break;
				  }
			   }
		       AppUtility.msgInfo(this, "Process data successfull !!");
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "processData : "  + e.toString());
		}

	}
	
	/**
	 * get list field of form
	 */
	private FieldNameList getListFielOfForm(long formid , String field) {

		FieldNameList  fieldNameList = new FieldNameList() ;
		for (FieldNameList frm : listField) {
			if(frm.getForm_id() == formid && frm.getFieldname().equals(field)) {
				fieldNameList = frm;
			}
		}
		return fieldNameList;
	}
	
	/**
	 * process for list non upper
	 */
	private String processNonUpper(String fieldValue) 
	{
		String arrTemp [] = fieldValue.split(" ");
		if(arrTemp.length > 1)
		{
			for(int i = 0; i< arrTemp.length; i ++)
			{
				if(listNonUpper.contains(arrTemp[i].toLowerCase()))
					arrTemp[i] = arrTemp[i].toLowerCase();										
			}
		}
		fieldValue = StringUtils.join(arrTemp, " ");	
		fieldValue = fieldValue.trim();
		return fieldValue;
	}
	
	/**
	 * update data
	 */
	private boolean updateDataByPath( String field ,String path)throws AncestryException {
		boolean flag = false;
		try {
			listUpdate = new ArrayList<Map<String , Object>>();
			listData = new ArrayList<Map<String , Object>>();
			listData = daoUpperLowerData.getListData(field, path); 
			
			long formid = 0;
			long id = 0;
			String value = "";
			FieldNameList fieldNameList;
			Map<String , Object> mapUpdate = new HashMap<String, Object>();
			for (Map<String , Object> mapTmp : listData)
			{
				mapUpdate = new HashMap<String, Object>();
				
				formid = Long.parseLong(mapTmp.get("formid").toString());
				id     = Long.parseLong(mapTmp.get("id").toString());
				mapUpdate.put("id", id);
				for (String key : mapTmp.keySet()) 
				{
					value  = StringUtil.setNotNull(mapTmp.get(key));
					if(!key.equals("formid") && !key.equals("id")) 
					{
						fieldNameList = getListFielOfForm(formid, key);
						value = StringUtil.capitalizeByCondition(value, "-.' ");
						if(key.equals("prefix") || key.equals("suffix")) {
							value = StringUtil.upperCaseFirstCharacter(value);
						}
						if(fieldNameList.getFirst_upper() ==1)
						{
							value = StringUtil.upperCaseFirstCharacter(value);
						}
						if(fieldNameList.getUpper_mc() == 1)
						{
							value = StringUtil.updateMc(value);
							value = StringUtil.updateInvertedComma(value);
						}
						if(fieldNameList.getRemove_other() ==1 || fieldNameList.getRemove_other() ==4)
						{
							value = RemoveString.removeOhneBeruf(key, value);
							value = StringUtil.ltrim(value);
							value = StringUtil.trimspace(value);
						}
						if(fieldNameList.getRemove_other() ==2 || fieldNameList.getRemove_other() ==4)
						{
							value = RemoveString.removeOhneBeruf(key, value);
							value = RemoveString.removeOther(key, value);
							value = StringUtil.ltrim(value);
							value = StringUtil.trimspace(value);
						}
						if(fieldNameList.getRemove_other() ==3 || fieldNameList.getRemove_other() ==4)
						{
							value = RemoveString.removeForEnglish(key, value);
							value = StringUtil.ltrim(value);
							value = StringUtil.trimspace(value);
						}
						if(fieldNameList.getNon_upper() ==1)
						{
							value = processNonUpper(value);
						}
						mapUpdate.put(key, value);
					}
				}
				listUpdate.add(mapUpdate);
			}
			flag = daoUpperLowerData.saveData(listUpdate);
		} catch (Exception e) {
			throw new AncestryException("updateDataByPath : "  + e.toString() , e);
		}
		return flag;
	}

}
