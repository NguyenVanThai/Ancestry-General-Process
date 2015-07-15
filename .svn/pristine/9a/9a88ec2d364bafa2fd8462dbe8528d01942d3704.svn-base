package com.digitexx.ancestry.gui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.conts.TableName;
import com.digitexx.ancestry.dao.DaoAncestryAddLookupQMD;
import com.digitexx.ancestry.db.ConnectionDB;
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
public class FrmAncestryAddLookupQMD extends javax.swing.JFrame {
	private JPanel panelContent;
	private JPanel panelFooter;
	private JButton buttonDelete;
	private JButton buttonImport;

	private JScrollPane scrollPaneLeft;
	private JComboBox comboboxTableImport;
	private JLabel labelProjectImport;
	private JComboBox comboboxTable;
	private JComboBox comboboxProject;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JPanel jPanel2;
	private JPanel jPanel1;
	private JSplitPane splitPaneContent;
	private JTable tableImportData;
	private JButton buttonSelectAll;
	private JTable tableData;
	private JScrollPane scrollPaneRight;
	private JPanel panelHeaderRight;
	private JPanel panelHeaderLeft;
	private JCheckBox checkboxDB10;
	
	private LinkedHashMap<String, Tbl_Projects> mapProject;
	private List<String> listTableName;
	private DefaultTableModel modelLeft;
	private DefaultTableModel modelRight;
	private Tbl_Projects project = new Tbl_Projects();
	private Tbl_Projects selectProject = new Tbl_Projects();
	private List<LinkedHashMap<String , Object>> listSaveData;
	private FrmStep frmStep;
	private DaoAncestryAddLookupQMD daoAncestryAddLookupQMD = new DaoAncestryAddLookupQMD();
	private String projectName;

	public FrmAncestryAddLookupQMD( FrmStep frmStep , LinkedHashMap<String, Tbl_Projects> mapProject , String projectName) {
		super();
		this.frmStep = frmStep;
		this.mapProject = mapProject;
		this.projectName = projectName;
		initGUI();
		initData();
	}
	
	private void initGUI() {
		try {
			this.setTitle("Import Lookup For QMD");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			{
				panelHeaderRight = new JPanel();
				AnchorLayout panelHeaderRightLayout = new AnchorLayout();
				panelHeaderRight.setLayout(panelHeaderRightLayout);
				getContentPane().add(panelHeaderRight, new AnchorConstraint(0, 1000, 173, 591, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelHeaderRight.setPreferredSize(new java.awt.Dimension(436, 113));
				panelHeaderRight.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				{
					comboboxTableImport = new JComboBox();
					panelHeaderRight.add(comboboxTableImport, new AnchorConstraint(590, 996, 972, 5, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					comboboxTableImport.setPreferredSize(new java.awt.Dimension(460, 21));
					comboboxTableImport.setFont(new java.awt.Font("Arial",1,16));
					comboboxTableImport.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							comboboxTableImportActionPerformed(evt);
						}
					});
				}
				{
					labelProjectImport = new JLabel();
					panelHeaderRight.add(labelProjectImport, new AnchorConstraint(48, 996, 482, 1, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					labelProjectImport.setPreferredSize(new java.awt.Dimension(434, 49));
					labelProjectImport.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					labelProjectImport.setForeground(new java.awt.Color(255,0,0));
					labelProjectImport.setFont(new java.awt.Font("Tahoma",1,18));
				}
			}
			{
				panelHeaderLeft = new JPanel();
				AnchorLayout panelHeaderLeftLayout = new AnchorLayout();
				panelHeaderLeft.setLayout(panelHeaderLeftLayout);
				getContentPane().add(panelHeaderLeft, new AnchorConstraint(0, 535, 173, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelHeaderLeft.setPreferredSize(new java.awt.Dimension(570, 113));
				panelHeaderLeft.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				{
					comboboxTable = new JComboBox();
					panelHeaderLeft.add(comboboxTable, new AnchorConstraint(562, 997, 973, 130, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					comboboxTable.setPreferredSize(new java.awt.Dimension(462, 23));
					comboboxTable.setFont(new java.awt.Font("Arial",1,16));
					comboboxTable.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							comboboxTableActionPerformed(evt);
						}
					});
				}
				{
					comboboxProject = new JComboBox();
					panelHeaderLeft.add(comboboxProject, new AnchorConstraint(39, 997, 455, 130, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					comboboxProject.setPreferredSize(new java.awt.Dimension(494, 47));
					comboboxProject.setFont(new java.awt.Font("Arial",1,16));
					comboboxProject.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							comboboxProjectActionPerformed(evt);
						}
					});
				}
				{
					jLabel1 = new JLabel();
					panelHeaderLeft.add(jLabel1, new AnchorConstraint(39, 130, 473, 4, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jLabel1.setText("Project :");
					jLabel1.setPreferredSize(new java.awt.Dimension(72, 49));
					jLabel1.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					jLabel1.setFont(new java.awt.Font("Arial",1,14));
					jLabel1.setForeground(new java.awt.Color(255,0,0));
				}
				{
					jLabel2 = new JLabel();
					panelHeaderLeft.add(jLabel2, new AnchorConstraint(526, 130, 973, 4, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jLabel2.setText("Table : ");
					jLabel2.setPreferredSize(new java.awt.Dimension(67, 25));
					jLabel2.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					jLabel2.setFont(new java.awt.Font("Arial",1,14));
					jLabel2.setForeground(new java.awt.Color(255,0,0));
				}
			}
			{
				panelContent = new JPanel();
				BorderLayout panelContentLayout = new BorderLayout();
				panelContent.setLayout(panelContentLayout);
				getContentPane().add(panelContent, new AnchorConstraint(173, 1000, 939, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelContent.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelContent.setPreferredSize(new java.awt.Dimension(1066, 502));
				{
					splitPaneContent = new JSplitPane();
					panelContent.add(splitPaneContent, BorderLayout.CENTER);
					splitPaneContent.setDividerLocation(500);
					{
						jPanel1 = new JPanel();
						BorderLayout jPanel1Layout = new BorderLayout();
						jPanel1.setLayout(jPanel1Layout);
						splitPaneContent.add(jPanel1, JSplitPane.RIGHT);
						{
							scrollPaneRight = new JScrollPane();
							jPanel1.add(scrollPaneRight, BorderLayout.CENTER);
							{
								tableImportData = new JTable() {
									@Override
									public boolean isCellEditable(int row,int column) {
										if(getColumnName(column).equals("Check")) {
											return true;
										}else {
											return false;
										}
									}
								};
								scrollPaneRight.setViewportView(tableImportData);
							}
						}
					}
					{
						jPanel2 = new JPanel();
						BorderLayout jPanel2Layout = new BorderLayout();
						jPanel2.setLayout(jPanel2Layout);
						splitPaneContent.add(jPanel2, JSplitPane.LEFT);
						jPanel2.setPreferredSize(new java.awt.Dimension(534, 513));
						{
							scrollPaneLeft = new JScrollPane();
							jPanel2.add(scrollPaneLeft, BorderLayout.CENTER);
							{
								tableData = new JTable() {
									@Override
									public boolean isCellEditable(int row,int column) {
										if(getColumnName(column).equals("Check")) {
											return true;
										}else {
											return false;
										}
									}
								};
								scrollPaneLeft.setViewportView(tableData);
							}
						}
					}
				}
			}
			{
				panelFooter = new JPanel();
				AnchorLayout panelFooterLayout = new AnchorLayout();
				getContentPane().add(panelFooter, new AnchorConstraint(938, 1000, 997, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelFooter.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelFooter.setLayout(panelFooterLayout);
				panelFooter.setPreferredSize(new java.awt.Dimension(744, 32));
				{
					buttonSelectAll = new JButton();
					panelFooter.add(buttonSelectAll, new AnchorConstraint(64, 214, 961, 128, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonSelectAll.setText("Select All");
					buttonSelectAll.setPreferredSize(new java.awt.Dimension(92, 35));
					buttonSelectAll.setFont(new java.awt.Font("Arial",1,16));
					buttonSelectAll.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							buttonSelectAllActionPerformed(evt);
						}
					});
				}
				{
					checkboxDB10 = new JCheckBox();
					panelFooter.add(checkboxDB10, new AnchorConstraint(69, 129, 958, 7, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					checkboxDB10.setText("10.10.5.10");
					checkboxDB10.setPreferredSize(new java.awt.Dimension(122, 32));
					checkboxDB10.setFont(new java.awt.Font("Arial",1,16));
					checkboxDB10.setForeground(new java.awt.Color(255,0,0));
					checkboxDB10.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
						    checkboxDB10ActionPerformed(evt);
						}
					});
				}
				{
					buttonImport = new JButton();
					panelFooter.add(buttonImport, new AnchorConstraint(46, 850, 953, 686, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonImport.setText("Import");
					buttonImport.setFont(new java.awt.Font("Arial",1,18));
					buttonImport.setPreferredSize(new java.awt.Dimension(122, 29));
					buttonImport.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							buttonImportActionPerformed(evt);
						}
					});
				}
				{
					buttonDelete = new JButton();
					panelFooter.add(buttonDelete, new AnchorConstraint(78, 997, 953, 875, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonDelete.setText("Delete");
					buttonDelete.setFont(new java.awt.Font("Arial",1,18));
					buttonDelete.setForeground(new java.awt.Color(255,0,0));
					buttonDelete.setPreferredSize(new java.awt.Dimension(91, 28));
					buttonDelete.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							buttonDeleteActionPerformed(evt);
						}
					});
				}
			}
			pack();
			this.setSize(1074, 689);
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
	
	private void exit() {
		if(AppUtility.msgConfirm(this, "Do you want to exit ??") == JOptionPane.OK_OPTION) {
			frmStep.setVisible(true);
			this.dispose();
		}
	}
	
	private void comboboxProjectActionPerformed(ActionEvent evt) {
		JTableUtil.removeAllRow(tableData);
		if(comboboxProject.getSelectedIndex() > -1) {
			String projectName = comboboxProject.getSelectedItem().toString();
			selectProject  = mapProject.get(projectName);
			loadTableName(false);
		}
	}
	
	private void comboboxTableActionPerformed(ActionEvent evt) {
		if(comboboxTable.getSelectedIndex() > -1) {
			String tableName = comboboxTable.getSelectedItem().toString();
			loadDataByTable(tableData, modelLeft, tableName , true , false);
		}
	}
	
	private void comboboxTableImportActionPerformed(ActionEvent evt) {
		String tableName = comboboxTableImport.getSelectedItem().toString();
		loadDataByTable(tableImportData, modelRight, tableName, false, true);
	}
	
	private void checkboxDB10ActionPerformed(ActionEvent evt) {
		if(checkboxDB10.isSelected()) {
			selectProject.setProj_serverip("10.10.5.10");
			loadProject("10.10.5.10" , true);

		}else {
			selectProject.setProj_serverip(ConnectionDB.host);
			loadProject(ConnectionDB.host , true);
		}
	}
	
	
	private void buttonImportActionPerformed(ActionEvent evt) {
	    save();	
	}
	
	
	private void buttonSelectAllActionPerformed(ActionEvent evt) {
		selectAll();
	}
	
	private void buttonDeleteActionPerformed(ActionEvent evt) {
		
	}
	
	/**
	 * init data
	 */
	private void initData() {
		loadProject("" , false);
		setDatabaseInfo();
		loadTableName(true);
		labelProjectImport.setText(projectName);
	}
	
	
	/**
	 * set database information
	 */
	private void setDatabaseInfo() {
		project.setProj_dbname("Production1");
		project.setProj_serverip(ConnectionDB.host);
		project.setProj_schema("db_14_000_qc_ancestry");
		project.setProj_uid("ancestry");
		project.setProj_pwd("ancestry");
	}
	
	
	//===========================================================================================================================

	private void loadProject(String host , boolean isReload) {
		comboboxProject.removeAllItems();
		JTableUtil.removeAllRow(tableData);
		if(isReload) {
			mapProject = new LinkedHashMap<String , Tbl_Projects>();
			mapProject = daoAncestryAddLookupQMD.getListProjectAncestryPMS(host);
		}
        for (String key : mapProject.keySet()) {
			comboboxProject.addItem(key);
		}
	}
	
	/**
	 * load table name
	 */
	private void loadTableName(boolean isRight) {
		try {
	        listTableName = new ArrayList<String>();
	        if(!isRight) {
	        	listTableName = daoAncestryAddLookupQMD.getListTableName(selectProject);
	        }else {
	        	listTableName = daoAncestryAddLookupQMD.getListTableName(project);
	        }
	        
	        if(!isRight) {
	        	comboboxTable.removeAllItems();
	        }else {
	        	comboboxTableImport.removeAllItems();
	        }
	        for (String str : listTableName) {
				if(str.equals(TableName.p1_form_n_proof) || 
						   str.equals(TableName.p1_form_n_proof_rework) || 
						   str.equals(TableName.p1_form_n_type) ||
						   str.equals(TableName.p1_form_n_proof_history) ||
						   str.equals(TableName.management) ||
						   str.equals(TableName.management_rework)||
						   str.equals(TableName.work_details)) 
						   {
			                   continue;						
							}else {
								if(!isRight) {
									comboboxTable.addItem(str);
								}else {
									if(str.contains("ancestry")) {
										comboboxTableImport.addItem(str);
									}
								}
							}
			}
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "loadTableName : "  + e.toString());
		}
	}

	
	/**
	 * load data by table name
	 */
	private void loadDataByTable(final JTable tbl ,DefaultTableModel model , String tableName , final boolean hasCheck , boolean isRight) 
	{
		try
		{
			List<LinkedHashMap<String, Object>> listData = new ArrayList<LinkedHashMap<String, Object>>();
			String[] headers;
			if(!isRight) {
				listData = daoAncestryAddLookupQMD.getListDataByTable(tableName , selectProject , "" , isRight);
				headers  = daoAncestryAddLookupQMD.getArrayColumName(tableName  , selectProject);
			}else {
				listData = daoAncestryAddLookupQMD.getListDataByTable(tableName , project ,projectName , isRight);
				headers  = daoAncestryAddLookupQMD.getArrayColumName(tableName  , project);
			}
			model = new DefaultTableModel(headers, 0) {
		           public Class getColumnClass(int column) {
		        	   if(column == tbl.getColumnCount() -1) {
	                        return Boolean.class;
		        	   }else {
	                        return String.class;
		        	   }
		            }
			};

			Object[] values = null;
			for (LinkedHashMap<String, Object> mapTmp : listData)
			{
				values = StringUtil.mapToArray(mapTmp);
				model.addRow(values);
			}
			tbl.setModel(model);
			JTableUtil.styleTable(tbl, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
       
	}
	
	/**
	 * select all
	 */
	private void selectAll() {
		int totalRow = tableData.getRowCount();
		for (int i = 0; i < totalRow; i++)
		{
			tableData.setValueAt(true, i, tableData.getColumnCount()-1);
		}
	}
	
	/**
	 * convert table to map data
	 */
	private void convertJtableToMap() throws Exception 
	{
		listSaveData = new ArrayList<LinkedHashMap<String , Object>>();
		int totalRow   = tableData.getRowCount();
		int totalColum = tableData.getColumnCount();
		
		LinkedHashMap<String, Object> mapTmp;
		String check = "";
		String columName = "";
		Object value ;
		for (int row = 0; row < totalRow; row++) {
			check = StringUtil.setNotNull(JTableUtil.getValuesByHeaderName(tableData, "Check", row));
			if(check.equals("true")) 
			{
				mapTmp = new LinkedHashMap<String , Object>();
				for (int col = 0; col < totalColum; col++) {
					columName = tableData.getColumnName(col);
					if(!columName.equals("Check") && !columName.equals("id")) {
						value = tableData.getValueAt(row, col);
						if(value == null ) {
							value = StringUtil.setNotNull(value);
						}
						mapTmp.put(columName, value);
					}
				}
				mapTmp.put("project", projectName);
				listSaveData.add(mapTmp);
			}

		}
	}
	
	/**
	 * save data lookup QMD
	 */
	private void save() 
	{
		boolean flag = false;
		try {
			int option = AppUtility.msgConfirm(this, "Do you want to save data lookup for " +  projectName + " ??");
			if(option == JOptionPane.OK_OPTION) 
			{
				convertJtableToMap();
				if(listSaveData.size() > 0) {
					String tableName = comboboxTableImport.getSelectedItem().toString();
					flag = daoAncestryAddLookupQMD.saveData(project, listSaveData, tableName);
					if(flag) {
						AppUtility.msgInfo(this, "Save data successfull !!");
						listSaveData.clear();
						System.gc();
					}
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "save : "  + e.toString());
		}
	}


}
