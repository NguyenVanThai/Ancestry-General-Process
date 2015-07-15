package com.digitexx.ancestry.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.dao.DaoImportLookup;
import com.digitexx.ancestry.db.ConnectionDB;
import com.digitexx.ancestry.util.AncestryException;
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
public class FrmImportLookup extends javax.swing.JFrame {
	private JPanel panelHeader;
	private JPanel panelContent;
	private JRadioButton radioLookup;
	private JPanel panelField;
	private JPanel panelLog;
	private JSplitPane splitPaneFooter;
	private JButton buttonRun;
	private ButtonGroup buttonGroup;
	private JPanel panelFooter;
	private JScrollPane scrollPaneLog;
	private JCheckBox checkboxIsRework;
	private JProgressBar progressBar;
	private JPanel panelProgess;
	private JTextPane textPaneLog;
	private JTable tableField;
	private JScrollPane scrollPaneField;
	private JSplitPane splitPaneContent;
	private JTextField textField;
	
	private Tbl_Projects project;
	private FrmStep frmStep;
	private DaoImportLookup daoProcessImportLookup;
	private DefaultTableModel model = new DefaultTableModel();
	private DefaultListModel modelPath = new DefaultListModel();
	
	private List<String> listColumn = new ArrayList<String>();
	private List<String> listPath   = new ArrayList<String>();
	private List<LinkedHashMap<String, Object>> listData = new ArrayList<LinkedHashMap<String , Object>>();
	private List<Map<String, Object>> listUpdateData = new ArrayList<Map<String , Object>>();
	private Map<String , String> mapCheckLookup = new HashMap<String , String>();
	private List<String> listValueAdd = new ArrayList<String>();
	private ArrayList<String> listadd = new ArrayList<String>();
	private Map<String,String> mapfieldlookup = new HashMap<String, String>();
	private Thread threadProcess;
	
	private ConnectionDB db = ConnectionDB.getInstance();

	public FrmImportLookup(Tbl_Projects project , FrmStep frmStep) {
		super();
		this.project = project;
		this.frmStep = frmStep;
		this.daoProcessImportLookup = new DaoImportLookup(project);
		initGUI();
		initData();
	}
	
	private void initGUI() {
		try {
			this.setTitle("Form Process Anrede & Status Given");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			{
				panelHeader = new JPanel();
				AnchorLayout panelHeaderLayout = new AnchorLayout();
				getContentPane().add(getPanelProgess(), new AnchorConstraint(974, 1000, 1000, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				getContentPane().add(panelHeader, new AnchorConstraint(1, 1000, 75, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelHeader.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelHeader.setLayout(panelHeaderLayout);
				panelHeader.setPreferredSize(new java.awt.Dimension(688, 30));
				{
					radioLookup = new JRadioButton();
					panelHeader.add(getCheckboxIsRework(), new AnchorConstraint(83, 704, 883, 426, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					panelHeader.add(radioLookup, new AnchorConstraint(83, 153, 950, 3, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					radioLookup.setText("Add Lookup");
					radioLookup.setFont(new java.awt.Font("Arial",1,16));
					getButtonGroup().add(radioLookup);
					radioLookup.setForeground(new java.awt.Color(255,0,0));
					radioLookup.setPreferredSize(new java.awt.Dimension(103, 26));
					radioLookup.setSelected(true);
					radioLookup.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							radioLookupActionPerformed(evt);
						}
					});
				}
				{
					buttonRun = new JButton();
					panelHeader.add(buttonRun, new AnchorConstraint(83, 996, 950, 827, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonRun.setText("Run");
					buttonRun.setFont(new java.awt.Font("Arial",1,16));
					buttonRun.setPreferredSize(new java.awt.Dimension(116, 26));
					buttonRun.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							buttonRunActionPerformed(evt);
						}
					});
				}
			}
			{
				panelContent = new JPanel();
				BorderLayout panelContentLayout = new BorderLayout();
				panelContent.setLayout(panelContentLayout);
				getContentPane().add(panelContent, new AnchorConstraint(73, 1000, 974, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelContent.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelContent.setPreferredSize(new java.awt.Dimension(800, 543));
				panelContent.add(getSplitPaneFooter(), BorderLayout.CENTER);
			}
			pack();
			this.setSize(808, 637);
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
	
	private JSplitPane getSplitPaneFooter() {
		if(splitPaneFooter == null) {
			splitPaneFooter = new JSplitPane();
			splitPaneFooter.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPaneFooter.add(getJPanel1(), JSplitPane.RIGHT);
			splitPaneFooter.add(getJPanel2(), JSplitPane.LEFT);
		}
		return splitPaneFooter;
	}
	
	private JPanel getJPanel1() {
		if(panelLog == null) {
			panelLog = new JPanel();
			BorderLayout panelLogLayout = new BorderLayout();
			panelLog.setLayout(panelLogLayout);
			panelLog.setBorder(BorderFactory.createTitledBorder(null, "Log", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,16)));
			panelLog.add(getScrollPaneLog(), BorderLayout.CENTER);
		}
		return panelLog;
	}
	
	private JPanel getJPanel2() {
		if(panelField == null) {
			panelField = new JPanel();
			BorderLayout panelFieldLayout = new BorderLayout();
			panelField.setLayout(panelFieldLayout);
			panelField.setPreferredSize(new java.awt.Dimension(680, 111));
			panelField.setBorder(BorderFactory.createTitledBorder(null, "Field", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,16)));
			panelField.add(getScrollPaneField(), BorderLayout.CENTER);
		}
		return panelField;
	}

	private JScrollPane getScrollPaneField() {
		if(scrollPaneField == null) {
			scrollPaneField = new JScrollPane();
			scrollPaneField.setViewportView(getTableField());
		}
		return scrollPaneField;
	}
	
	private JScrollPane getScrollPaneLog() {
		if(scrollPaneLog == null) {
			scrollPaneLog = new JScrollPane();
			scrollPaneLog.setViewportView(getTextPaneLog());
		}
		return scrollPaneLog;
	}

	private JTable getTableField() {
		if(tableField == null) {
			tableField = new JTable() {
				@Override
				public boolean isCellEditable(int row, int column) {
					if(tableField.getColumnName(column).equals("Check")) {
						return true;
					}else {
						return false;
					}
				}
				@Override
				public Class<?> getColumnClass(int column) {
					if(tableField.getColumnName(column).equals("Check")) {
						return Boolean.class;
					}else {
						return String.class;
					}
				}
			};
		}
		return tableField;
	}
	
	private JTextPane getTextPaneLog() {
		if(textPaneLog == null) {
			textPaneLog = new JTextPane();
		}
		return textPaneLog;
	}
	
	private void exit() {
		if(AppUtility.msgConfirm(this, "Do you want to exit ??") == JOptionPane.OK_OPTION) {
			frmStep.setVisible(true);
			this.dispose();
		}
	}
	
	private JCheckBox getCheckboxIsRework() {
		if(checkboxIsRework == null) {
			checkboxIsRework = new JCheckBox();
			checkboxIsRework.setText("Is Rework");
			checkboxIsRework.setPreferredSize(new java.awt.Dimension(191, 24));
			checkboxIsRework.setFont(new java.awt.Font("Arial",1,16));
			checkboxIsRework.setForeground(new java.awt.Color(0,0,255));
			checkboxIsRework.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					checkboxIsReworkActionPerformed(evt);
				}
			});
		}
		return checkboxIsRework;
	}
	
	private JPanel getPanelProgess() {
		if(panelProgess == null) {
			panelProgess = new JPanel();
			BorderLayout panelProgessLayout = new BorderLayout();
			panelProgess.setLayout(panelProgessLayout);
			panelProgess.setPreferredSize(new java.awt.Dimension(800, 16));
			panelProgess.add(getProgressBar(), BorderLayout.CENTER);
		}
		return panelProgess;
	}
	
	private JProgressBar getProgressBar() {
		if(progressBar == null) {
			progressBar = new JProgressBar();
		}
		return progressBar;
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
	
	
	private void radioLookupActionPerformed(ActionEvent evt) {
		loadField(true);
	}
	
//	private void radioStatusGivenActionPerformed(ActionEvent evt) {
//		loadField(false);
//	}
	
	
	private void checkboxIsReworkActionPerformed(ActionEvent evt) {
		if(checkboxIsRework.isSelected()) {
			daoProcessImportLookup.setTable(true);
			initData();
		}else {
			daoProcessImportLookup.setTable(false);
			initData();
		}
	}

	//=====================================================================================================
	
	/**
	 * init default data
	 */
	private void initData() {
		try {
			daoProcessImportLookup.setTable(false);
            listColumn = daoProcessImportLookup.getListField(); 
//            if(radioLookup.isSelected()) {
//            	mapCheckLookup = daoProcessImportLookup.getMapCheckAnrede();
//            }
            loadField(true);
            //loadPath();
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "initData : "  + e.toString());
		}
	}
	
	/**
	 * load field name lookup
	 */
	private void loadField(boolean haveLookup) {
	   model = new DefaultTableModel( new String [] {"No." , "Field" , "Check"},0);
	   int idx = 1;
	   String tableLookup = "";
	   Object []  values;
//	   ArrayList<String> listColumnLookup = new ArrayList<String>();
	   Map<String,List<String>> listfieldlookup = new HashMap<String,List<String>>();
	   listfieldlookup = daoProcessImportLookup.loadFieldLookup();
	  
	   //listColumnTable = daoProcessImportLookup.getListColumnTable(table);
       for (String str : listColumn) {
		 if(haveLookup) {
			 for(String key : listfieldlookup.keySet()){
				 if(str.equals(key)) {
					 tableLookup = listfieldlookup.get(key).get(0);
//					 try {
//						listColumnLookup = daoProcessImportLookup.getListColumnTable(tableLookup);
//					 } catch (AncestryException e) {
//						e.printStackTrace();
//					 }					 
					 values = new Object [] { idx , str , Boolean.TRUE};
					 model.addRow(values);
					 
					 ++idx;
				 }
			 }
		 }
	   }
       
       
//       TableModel model = table.getModel();
//       for(int i = 0; i < model.getRowCount(); i++) {
//           if((Boolean)model.getValueAt(i, 0)) {
//               // delete the row
//            }
//       }
       //tableField.setCellEditor(textField);
       tableField.setModel(model);
       JTableUtil.styleTable(tableField, true);
       JTableUtil.fitTableColumns(tableField);
	}
	
	/**
	 * get selected field for process
	 */
	private List<String> getListFieldSelect() {
		int totalRow = tableField.getRowCount();
		List<String> listTmp  = new ArrayList<String>();
		String check = "";
		String field = "";
		for (int i = 0; i < totalRow; i++) {
			check = JTableUtil.getValuesByHeaderName(tableField, "Check", i);
			if(check.equals("true")) {
				field  = JTableUtil.getValuesByHeaderName(tableField, "Field", i);
				listTmp.add(field);
			}
		}
		return listTmp;
	}
	
	
	
    /**
	 * process data 
	 */
	private void processData() 
	{
		try {
			buttonRun.setEnabled(false);
			Map<String,List<String>> mapfieldlookup = new HashMap<String,List<String>>();
			   mapfieldlookup = daoProcessImportLookup.loadFieldLookup();
			List<String> listTmp = new ArrayList<String>();
			List<String> listFieldSelect = getListFieldSelect();
			progressBar.setMinimum(0);
			progressBar.setMaximum(100);			
			
			boolean flag = insertLookup(listFieldSelect, mapfieldlookup);
			if(flag) {
				AppUtility.appendText(textPaneLog, "Process Insert Finished" , Color.BLUE);
			}else{
				AppUtility.appendText(textPaneLog, "Process Insert Not Finished" , Color.RED);
			}
			
			progressBar.setValue(100);
			buttonRun.setEnabled(true);
			AppUtility.appendText(textPaneLog, "---------------------Process complete-------------------------", Color.RED);
			AppUtility.msgInfo(this, "Process complete !!");
			
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "processData  : "  + e.toString());
		}

	}
	
	/**
	 * update status_given
	 */
	private boolean insertLookup(List<String> listFieldSelect,Map<String,List<String>> mapfieldlookup) throws AncestryException
	{
		Connection con =null;
        boolean flag = false;
        try {
        	//System.out.println("test : "+db.getConnectByProject(project));
            Map<String, Object> mapUpdateData = new HashMap<String , Object>();
            ArrayList<String> listColumn = new ArrayList<String>();
            String value = "";
            String table = "";
            int id = 0;
            String status = "";
            String ad = "";
            String fieldadd = "";
            String path = "";
            
            mapUpdateData = new HashMap<String , Object>();
			for (String field : listFieldSelect) 
			{
	        	con = db.getConnectByProject(project);
				table = mapfieldlookup.get(field).get(0);
				status = mapfieldlookup.get(field).get(2);
				ad = mapfieldlookup.get(field).get(1);
				fieldadd = mapfieldlookup.get(field).get(3);
				listValueAdd = new ArrayList<String>();				
				listValueAdd = daoProcessImportLookup.getListDataLookup(con,field,table,fieldadd,ad, false);
				System.out.println("data : "+listValueAdd);
				id = daoProcessImportLookup.getMaxId(con,table, false);
				listColumn = daoProcessImportLookup.getListColumnTableLookup(con,table,false);
				if(listValueAdd.size() == 0){
					AppUtility.appendText(textPaneLog, "Field : "+field+" have not data insert" , Color.RED);
					//break;
				}
				else{
					for (String s : listValueAdd) 
		            {
						Pattern p = Pattern.compile("[^a-zA-Z0-9-,.() ]", Pattern.CASE_INSENSITIVE);
						Matcher m = p.matcher(s);
						boolean b = m.find();
						if(!b){
							if(!s.equals(".") ){
							listadd = new ArrayList<String>();
		    				for(int i = 0; i < listColumn.size(); i++){
		    					if(i == 0){
		    						listadd.add((id+1)+"");
		    					}
		    					if(i == 1){
		    						listadd.add(ad);
		    					}
		    					if(i == 2){
		    						listadd.add(s);
		    					}
		    					if(i == 3){
		    						listadd.add(s.toLowerCase());
		    					}
		    					if(i == 4){
		    						listadd.add(status);
		    					}
		    					else if(i > 4){
		    						listadd.add("");
		    					}	    				
		    				}
		    				flag = daoProcessImportLookup.insertLookup(con,listadd,listColumn,table,false);
		    				id++;
							}
						}
	    			}
				}
				con.commit();
    		}
			
            
		} catch (Exception e) {
			throw new AncestryException("saveData : "  + e.toString(), e);
		}
        return flag;
	}

}
