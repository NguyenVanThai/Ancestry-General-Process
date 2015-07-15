package com.digitexx.ancestry.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.dao.DaoProcessAnredeAndStatusGiven;
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
public class FrmProcessAnredeAndStatusGiven extends javax.swing.JFrame {
	private JPanel panelHeader;
	private JPanel panelContent;
	private JRadioButton radioAnrede;
	private JScrollPane scrollPanePath;
	private JPanel panelField;
	private JPanel panelLog;
	private JSplitPane splitPaneFooter;
	private JButton buttonRun;
	private ButtonGroup buttonGroup;
	private JRadioButton radioStatusGiven;
	private JPanel panelFooter;
	private JScrollPane scrollPaneLog;
	private JCheckBox checkboxIsRework;
	private JProgressBar progressBar;
	private JPanel panelProgess;
	private JTextPane textPaneLog;
	private JTable tableField;
	private JList jListPath;
	private JScrollPane scrollPaneField;
	private JPanel panelPath;
	private JSplitPane splitPaneContent;
	
	private Tbl_Projects project;
	private FrmStep frmStep;
	private DaoProcessAnredeAndStatusGiven daoProcessAnredeAndStatusGiven;
	private DefaultTableModel model = new DefaultTableModel();
	private DefaultListModel modelPath = new DefaultListModel();
	
	private List<String> listColumn = new ArrayList<String>();
	private List<String> listPath   = new ArrayList<String>();
	private List<LinkedHashMap<String, Object>> listData = new ArrayList<LinkedHashMap<String , Object>>();
	private List<Map<String, Object>> listUpdateData = new ArrayList<Map<String , Object>>();
	private List<String> listCheckStatusGiven = new ArrayList<String>();
	private Map<String , String> mapCheckAnrede = new HashMap<String , String>();
	private Thread threadProcess;

	public FrmProcessAnredeAndStatusGiven(Tbl_Projects project , FrmStep frmStep) {
		super();
		this.project = project;
		this.frmStep = frmStep;
		this.daoProcessAnredeAndStatusGiven = new DaoProcessAnredeAndStatusGiven(project);
		daoProcessAnredeAndStatusGiven.setTable(false);
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
					radioAnrede = new JRadioButton();
					panelHeader.add(getCheckboxIsRework(), new AnchorConstraint(83, 704, 883, 426, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					panelHeader.add(radioAnrede, new AnchorConstraint(83, 153, 950, 3, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					radioAnrede.setText("Anrede");
					radioAnrede.setFont(new java.awt.Font("Arial",1,16));
					getButtonGroup().add(radioAnrede);
					radioAnrede.setForeground(new java.awt.Color(255,0,0));
					radioAnrede.setPreferredSize(new java.awt.Dimension(103, 26));
					radioAnrede.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							radioAnredeActionPerformed(evt);
						}
					});
				}
				{
					radioStatusGiven = new JRadioButton();
					panelHeader.add(radioStatusGiven, new AnchorConstraint(116, 378, 950, 178, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					radioStatusGiven.setText("Status Given");
					radioStatusGiven.setFont(new java.awt.Font("Arial",1,16));
					getButtonGroup().add(radioStatusGiven);
					radioStatusGiven.setForeground(new java.awt.Color(255,0,0));
					radioStatusGiven.setPreferredSize(new java.awt.Dimension(138, 25));
					radioStatusGiven.setSelected(true);
					radioStatusGiven.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							radioStatusGivenActionPerformed(evt);
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
				{
					splitPaneContent = new JSplitPane();
					panelContent.add(splitPaneContent, BorderLayout.CENTER);
					splitPaneContent.setOrientation(JSplitPane.VERTICAL_SPLIT);
					splitPaneContent.setDividerLocation(250);
					{
						panelFooter = new JPanel();
						BorderLayout panelFooterLayout = new BorderLayout();
						panelFooter.setLayout(panelFooterLayout);
						splitPaneContent.add(panelFooter, JSplitPane.RIGHT);
						panelFooter.add(getSplitPaneFooter(), BorderLayout.CENTER);
					}
					{
						panelPath = new JPanel();
						BorderLayout panelPathLayout = new BorderLayout();
						panelPath.setLayout(panelPathLayout);
						splitPaneContent.add(panelPath, JSplitPane.LEFT);
						panelPath.setPreferredSize(new java.awt.Dimension(682, 129));
						panelPath.setBorder(BorderFactory.createTitledBorder(null, "File Path", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,16)));
						panelPath.add(getScrollPanePath(), BorderLayout.CENTER);
					}
				}
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
	
	private JScrollPane getScrollPanePath() {
		if(scrollPanePath == null) {
			scrollPanePath = new JScrollPane();
			scrollPanePath.setViewportView(getJListPath());
		}
		return scrollPanePath;
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

	
	private JList getJListPath() {
		if(jListPath == null) {
			jListPath = new JList();
			jListPath.setFont(new java.awt.Font("Arial",0,14));
		}
		return jListPath;
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
	
	
	private void radioAnredeActionPerformed(ActionEvent evt) {
		loadField(true);
	}
	
	private void radioStatusGivenActionPerformed(ActionEvent evt) {
		loadField(false);
	}
	
	
	private void checkboxIsReworkActionPerformed(ActionEvent evt) {
		daoProcessAnredeAndStatusGiven.setTable(checkboxIsRework.isSelected());
		initData();
	}

	//=====================================================================================================
	
	/**
	 * init default data
	 */
	private void initData() {
		try {
            listColumn = daoProcessAnredeAndStatusGiven.getListField(); 
            if(radioStatusGiven.isSelected()) {
            	listCheckStatusGiven = daoProcessAnredeAndStatusGiven.getListDataCheck();
            }
            else if(radioAnrede.isSelected()) {
            	mapCheckAnrede = daoProcessAnredeAndStatusGiven.getMapCheckAnrede();
            }
            loadField(false);
            loadPath();
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "initData : "  + e.toString());
		}
	}
	
	/**
	 * load field name anrede , status_given
	 */
	private void loadField(boolean isAnrede) {
	   model = new DefaultTableModel( new String [] {"No." , "Field" , "Check"},0);
	   int idx = 1;
	   Object []  values;
       for (String str : listColumn) {
		 if(isAnrede) {
			 if(str.indexOf("anrede") > -1) {
				 values = new Object [] { idx , str , Boolean.TRUE };
				 model.addRow(values);
				 ++idx;
			 }
		 }else {
			 if(str.indexOf("status") > -1 && str.indexOf("given")  >-1) {
				 values = new Object [] { idx , str , Boolean.TRUE };
				 model.addRow(values);
				 ++idx;
			 }
		 }
	   }
       tableField.setModel(model);
       JTableUtil.styleTable(tableField, true);
       JTableUtil.fitTableColumns(tableField);
	}
	
	/**
	 * load path
	 */
	private void loadPath() {
        try {
			listPath  = new ArrayList<String>();
			listPath  = daoProcessAnredeAndStatusGiven.getListFilePath();
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
				if(radioStatusGiven.isSelected()) {
					field = field.replace("status_", "");
				}
				else if(radioAnrede.isSelected()) {
					field = field.replace("check_anrede_", "");
				}
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
			List<String> listTmp = new ArrayList<String>();
			List<String> listFieldSelect = getListFieldSelect();
			String field = StringUtil.join(listFieldSelect, ",");
			
			if(jListPath.getSelectedValues().length  >0) {
				Object [] selectPath = jListPath.getSelectedValues();
				for (Object obj : selectPath) {
					listTmp.add(obj.toString());
				}
			}else {
				listTmp.addAll(listPath);
			}
			if(listTmp.size()  >0) {
				progressBar.setMinimum(0);
				progressBar.setMaximum(100);
				int count = 0;
				for (String path : listTmp) {
					AppUtility.appendText(textPaneLog, "Start : " + path, Color.BLACK);
					listData = new ArrayList<LinkedHashMap<String , Object>>();
					listData = daoProcessAnredeAndStatusGiven.getListDataByFilePath(path , field);
					boolean flag = updateStatusGiven(listFieldSelect);
					if(flag) {
						AppUtility.appendText(textPaneLog, "Finished : " + path, Color.BLUE);
					}else {
						break;
					}
					++count;
					progressBar.setValue(count);
				}
				progressBar.setValue(100);
				buttonRun.setEnabled(true);
				AppUtility.appendText(textPaneLog, "---------------------Process complete-------------------------", Color.RED);
				AppUtility.msgInfo(this, "Process complete !!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "processData  : "  + e.toString());
		}

	}
	
	/**
	 * update status_given
	 */
	private boolean updateStatusGiven(List<String> listFieldSelect) throws AncestryException
	{
        boolean flag = false;
        try {
            listUpdateData = new ArrayList<Map<String , Object>>();
            Map<String, Object> mapUpdateData = new HashMap<String , Object>();
            String value = "";
            String [] arrTmp = null;
            for (Map<String , Object> mapTmp : listData) 
            {
            	mapUpdateData = new HashMap<String , Object>();
    			for (String field : listFieldSelect) 
    			{
    				boolean found  = false;
    				if(!field.equals("id")) 
    				{
    					value = StringUtil.setNotNull(mapTmp.get(field));
    					value = value.toLowerCase();
    					if(!value.equals("")) 
    					{
        					arrTmp = value.split(" ");
        					for (String str : arrTmp) {
            					if(listCheckStatusGiven.contains(str) && !str.equals("")) {
            						mapUpdateData.put("status_"+field, 1);
            						found = true;
            						break;
            					}
    						}
    					}
                        if(!found) {
    						mapUpdateData.put("status_"+field, 0);
                        }
    				}
    			}
    			if(mapUpdateData.size() > 0) {
    				mapUpdateData.put("id", mapTmp.get("id"));
    				listUpdateData.add(mapUpdateData);
    			}
    		}
            flag = daoProcessAnredeAndStatusGiven.updateStatusGiven(listUpdateData);
		} catch (Exception e) {
			throw new AncestryException("saveData : "  + e.toString(), e);
		}
        return flag;
	}
	
	/**
	 * update anrede
	 */
	private boolean updateAnrede(List<String> listFieldSelect) throws AncestryException
	{
        boolean flag = false;
        try {
            listUpdateData = new ArrayList<Map<String , Object>>();
            Map<String, Object> mapUpdateData = new HashMap<String , Object>();
            String value = "";
            for (Map<String , Object> mapTmp : listData) 
            {
            	mapUpdateData = new HashMap<String , Object>();
    			for (String field : listFieldSelect) 
    			{
    				if(!field.equals("id")) 
    				{
    					value = StringUtil.setNotNull(mapTmp.get(field));
    					value = value.toLowerCase();
    					if(mapCheckAnrede.containsKey(value) && !value.equals("")) {
    						mapUpdateData.put("check_anrede_"+field, 1);
    					}
    				}
    			}
    			if(mapUpdateData.size() > 0) {
    				mapUpdateData.put("id", mapTmp.get("id"));
    				listUpdateData.add(mapUpdateData);
    			}
    		}
            flag = daoProcessAnredeAndStatusGiven.updateStatusGiven(listUpdateData);
		} catch (Exception e) {
			throw new AncestryException("saveData : "  + e.toString(), e);
		}
        return flag;
	}

}
