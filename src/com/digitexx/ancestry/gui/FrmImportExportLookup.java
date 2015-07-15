package com.digitexx.ancestry.gui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.conts.TableName;
import com.digitexx.ancestry.dao.DaoImportExportLookup;
import com.digitexx.ancestry.db.ConnectionDB;
import com.digitexx.ancestry.util.AppUtility;
import com.digitexx.ancestry.util.FileUtility;
import com.digitexx.ancestry.util.JTableUtil;
import com.digitexx.ancestry.util.ReadTxtUtil;
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
public class FrmImportExportLookup extends javax.swing.JFrame {
	private JPanel panelHeader;
	private JPanel panelContent;
	private JPanel panelFooter;
	private JPanel panelRight;
	private JPanel panelLeft;
	private JProgressBar progressBar;
	private JComboBox comboboxField;
	private JLabel Field;
	private JTextField textFieldStatus;
	private JLabel jLabel1;
	private JTable tableDataFromFile;
	private JScrollPane scrollPaneRight;
	private JButton buttonImport;
	private JTable tableData;
	private JScrollPane scrollPaneLeft;
	private JTextField textFieldPathImport;
	private JButton buttonBrowseImport;
	private JComboBox comboboxTable;
	private JSplitPane splitPaneContent;
	private DaoImportExportLookup daoDaoImportExportLookup;
	private DefaultTableModel modelDataByTable;
	private DefaultTableModel modelDataFromFile;
	private FrmStep frmStep;
	
	private Thread threadImport ;
	private Tbl_Projects project =new Tbl_Projects();
	private List<Object[]> listData = new ArrayList<Object[]>();
	private List<String> listColumn = new ArrayList<String>();
	private List<String> listField = new ArrayList<String>();
	private List<String> listDataFromFile = new ArrayList<String>();
	private List<LinkedHashMap<String, Object>> listSaveData = new ArrayList<LinkedHashMap<String , Object>>();

	public FrmImportExportLookup(Tbl_Projects project , FrmStep frmStep) {
		super();
		this.project = project;
		this.frmStep = frmStep;
		this.daoDaoImportExportLookup = new DaoImportExportLookup(project);
		initGUI();
		initData();
	}
	
	private void initGUI() {
		try {
			this.setTitle("Form Import & Export Lookup");
			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			{
				panelHeader = new JPanel();
				AnchorLayout panelHeaderLayout = new AnchorLayout();
				getContentPane().add(panelHeader, new AnchorConstraint(0, 1000, 67, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelHeader.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelHeader.setLayout(panelHeaderLayout);
				panelHeader.setPreferredSize(new java.awt.Dimension(901, 35));
				{
					comboboxField = new JComboBox();
					panelHeader.add(comboboxField, new AnchorConstraint(60, 340, 987, 215, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					comboboxField.setPreferredSize(new java.awt.Dimension(157, 38));
					comboboxField.setFont(new java.awt.Font("Arial",1,14));
				}
				{
					Field = new JLabel();
					panelHeader.add(Field, new AnchorConstraint(60, 215, 963, 179, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					Field.setPreferredSize(new java.awt.Dimension(45, 37));
					Field.setText("Field");
					Field.setFont(new java.awt.Font("Arial",1,16));
					Field.setForeground(new java.awt.Color(0,0,255));
					Field.setBorder(new LineBorder(new java.awt.Color(0,0,255), 1, false));
				}
				{
					textFieldStatus = new JTextField();
					panelHeader.add(textFieldStatus, new AnchorConstraint(60, 417, 963, 385, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					textFieldStatus.setPreferredSize(new java.awt.Dimension(40, 37));
					textFieldStatus.setText("0");
					textFieldStatus.setFont(new java.awt.Font("Arial",1,22));
				}
				{
					jLabel1 = new JLabel();
					panelHeader.add(jLabel1, new AnchorConstraint(60, 383, 963, 340, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jLabel1.setText("Status");
					jLabel1.setPreferredSize(new java.awt.Dimension(54, 37));
					jLabel1.setFont(new java.awt.Font("Arial",1,16));
					jLabel1.setBorder(new LineBorder(new java.awt.Color(0,0,255), 1, false));
					jLabel1.setForeground(new java.awt.Color(0,0,255));
				}
				{
					comboboxTable = new JComboBox();
					panelHeader.add(comboboxTable, new AnchorConstraint(60, 175, 963, 1, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					comboboxTable.setFont(new java.awt.Font("Tahoma",0,16));
					comboboxTable.setPreferredSize(new java.awt.Dimension(219, 37));
					comboboxTable.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							comboboxTableActionPerformed(evt);
						}
					});
				}
				{
					buttonBrowseImport = new JButton();
					panelHeader.add(buttonBrowseImport, new AnchorConstraint(36, 998, 987, 923, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonBrowseImport.setText("Browse");
					buttonBrowseImport.setFont(new java.awt.Font("Arial",1,14));
					buttonBrowseImport.setPreferredSize(new java.awt.Dimension(95, 39));
					buttonBrowseImport.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							buttonBrowseImportActionPerformed(evt);
						}
					});
				}
				{
					textFieldPathImport = new JTextField();
					panelHeader.add(textFieldPathImport, new AnchorConstraint(12, 924, 987, 417, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					textFieldPathImport.setPreferredSize(new java.awt.Dimension(637, 40));
					textFieldPathImport.setFont(new java.awt.Font("Tahoma",0,14));
					textFieldPathImport.setEnabled(false);
				}
			}
			{
				panelContent = new JPanel();
				AnchorLayout panelContentLayout = new AnchorLayout();
				panelContent.setLayout(panelContentLayout);
				getContentPane().add(panelContent, new AnchorConstraint(67, 1000, 939, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelContent.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelContent.setPreferredSize(new java.awt.Dimension(901, 457));
				{
					splitPaneContent = new JSplitPane();
					panelContent.add(splitPaneContent, new AnchorConstraint(5, 998, 996, 2, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					splitPaneContent.setPreferredSize(new java.awt.Dimension(897, 453));
					splitPaneContent.setDividerLocation(600);
					{
						panelRight = new JPanel();
						BorderLayout panelRightLayout = new BorderLayout();
						panelRight.setLayout(panelRightLayout);
						splitPaneContent.add(panelRight, JSplitPane.RIGHT);
						panelRight.setBorder(BorderFactory.createTitledBorder(null, "Data From File Import", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,16), new java.awt.Color(255,0,0)));
						{
							scrollPaneRight = new JScrollPane();
							panelRight.add(scrollPaneRight, BorderLayout.CENTER);
							{
								tableDataFromFile = new JTable();
								scrollPaneRight.setViewportView(tableDataFromFile);
							}
						}
					}
					{
						panelLeft = new JPanel();
						BorderLayout panelLeftLayout = new BorderLayout();
						panelLeft.setLayout(panelLeftLayout);
						splitPaneContent.add(panelLeft, JSplitPane.LEFT);
						panelLeft.setPreferredSize(new java.awt.Dimension(573, 451));
						panelLeft.setBorder(BorderFactory.createTitledBorder(null, "Data From Database", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,16), new java.awt.Color(255,0,0)));
						{
							scrollPaneLeft = new JScrollPane();
							panelLeft.add(scrollPaneLeft, BorderLayout.CENTER);
							{
								tableData = new JTable() {
									@Override
									public boolean isCellEditable(int row,int column) {
										return false;
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
				getContentPane().add(panelFooter, new AnchorConstraint(939, 1000, 1000, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelFooter.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelFooter.setLayout(panelFooterLayout);
				panelFooter.setPreferredSize(new java.awt.Dimension(901, 32));
				{
					progressBar = new JProgressBar();
					panelFooter.add(progressBar, new AnchorConstraint(64, 807, 961, 1, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					progressBar.setPreferredSize(new java.awt.Dimension(1013, 35));
				}
				{
					buttonImport = new JButton();
					panelFooter.add(buttonImport, new AnchorConstraint(38, 998, 935, 912, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonImport.setText("Import");
					buttonImport.setPreferredSize(new java.awt.Dimension(108, 35));
					buttonImport.setForeground(new java.awt.Color(255,0,0));
					buttonImport.setFont(new java.awt.Font("Arial",1,16));
					buttonImport.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							buttonImportActionPerformed(evt);
						}
					});
				}
			}
			pack();
			this.setSize(1265, 658);
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
	
	private void buttonBrowseImportActionPerformed(ActionEvent evt) {
		FileUtility.browse(textFieldPathImport , JFileChooser.FILES_ONLY);
		loadDataLookupFromFile();
	}

	
	private void comboboxTableActionPerformed(ActionEvent evt) {
		loadDataByTable();
		loadFieldByTable();
	}

	
	private void buttonImportActionPerformed(ActionEvent evt) {
		processDataLookup(this);
	}
	
	//======================================================================================================================
	
	private void exit() {
		if(AppUtility.msgConfirm(this, "Do you want to exit ??") == JOptionPane.OK_OPTION) {
			frmStep.setVisible(true);
			this.dispose();
		}
	}
	
	public void initData() {
		try {
			loadTable();
            listField = daoDaoImportExportLookup.getListField();
            loadFieldByTable();
            JTableUtil.styleTable(tableDataFromFile, true);
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "initData : "  + e.toString());
		}
	}
	
	/**
	 * load table combobox
	 */
	private void loadTable() {
		try {
			List<String> listTable = new ArrayList<String>();
			listTable = daoDaoImportExportLookup.getListTableName();
			comboboxTable.removeAllItems();
			for (String str : listTable) {
				if(str.equals(TableName.p1_form_n_proof) || 
                   str.equals(TableName.p1_form_n_proof_rework)|| 
                   str.equals(TableName.p1_form_n_type)|| 
                   str.equals(TableName.p1_form_n_proof_history)|| 
                   str.equals(TableName.management)|| 
                   str.equals(TableName.management_rework)) 
				{
					continue;
				} else if(str.indexOf("lookup_") > -1) {
					comboboxTable.addItem(str);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "loadTable : "  + e.toString());
		}
	}
	
	/**
	 * load field for import lookup for table lookup_by_field
	 */
	private void loadFieldByTable() {
		comboboxField.removeAllItems();
        if(comboboxTable.getSelectedItem().toString().equals(TableName.lookup_by_field)) {
        	for (String str : listField) {
				comboboxField.addItem(str);
			}
        }
	}
	
	/**
	 * load data lookup from customer file
	 */
	private void loadDataLookupFromFile() {
		try {
			JTableUtil.removeAllRow(tableDataFromFile);
			String path = StringUtil.setNotNull(textFieldPathImport.getText());
			listDataFromFile = new ArrayList<String>();
			if(!path.equals("")) {
				List<String> listDataLookup = ReadTxtUtil.readList(path);
				for (String row : listDataLookup) {
					if(row.indexOf("<E>") > -1 && row.indexOf("</E>") > -1) {
						row = row.replace("<E>", "");
						row = row.replace("</E>", "");
						row = StringUtil.ltrim(row);
						row = StringUtil.setNotNull(row);
						listDataFromFile.add(row);
					}
				}
				String [] header = new String[] {"No." , "Data"};
				JTableUtil.loadListDataToGrid(tableDataFromFile, modelDataFromFile, header, listDataFromFile, true, false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "loadDataLookupFromFile : "  + e.toString());
		}
	}
	
	/**
	 * get array colum name
	 */
	private String [] getArrayColumn(List<String> listColumn) {

		int len = listColumn.size();
		String [] arr = new String[len];
		int index= 0;
		for (String str : listColumn) {
			arr[index] = str;
			++index;
		}
		return arr;
	}
	
	
	/**
	 * load data by table
	 */
	private void loadDataByTable() {
		try {
			listData = new ArrayList<Object[]>();
			listColumn = new ArrayList<String>();
			
			listColumn = daoDaoImportExportLookup.getListColumnByTable(comboboxTable.getSelectedItem().toString());
			listData   =  daoDaoImportExportLookup.getListDataByTable(project, comboboxTable.getSelectedItem().toString());
			String [] arrHeader = getArrayColumn(listColumn);
			modelDataByTable = new DefaultTableModel(arrHeader , 0);
			JTableUtil.loadListObjectToGrid(arrHeader, tableData, listData, null, false);
			JTableUtil.styleTable(tableData, true);
			JTableUtil.fitTableColumns(tableData);
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "loadDataByTable : "  + e.toString());
		}
 
	}

	/**
	 * process data lookup
	 */
	private void processDataLookup(final JFrame frame)
	{
		try 
		{
			if(AppUtility.msgConfirm(this,"Do you want to save data ??") == JOptionPane.OK_OPTION)
			{
				Thread thread = new Thread(new Runnable() 
				{
					@Override
					public synchronized void run() {
						try 
						{
							 boolean flag = false;
						     if(listDataFromFile.size()  >0) 
						     {
						    	 String table = comboboxTable.getSelectedItem().toString();
						    	 int id = Integer.parseInt(daoDaoImportExportLookup.getMaxId(table));
						    	 int totalColum = tableData.getColumnCount();
						    	 
						    	 int count = 0;
						    	 String columnName =  "";
						    	 progressBar.setMinimum(0);
						    	 progressBar.setMaximum(listDataFromFile.size());
						    	 
						    	 listSaveData = new ArrayList<LinkedHashMap<String , Object>>();
						    	 LinkedHashMap<String , Object> mapTmp = new LinkedHashMap<String , Object>();
						    	 
						    	 int indexColum = -1;
						    	 for (String data : listDataFromFile) 
						    	 {
						    		boolean check = false;
						    		mapTmp = new LinkedHashMap<String , Object>();
									for (int i = 0; i < totalColum; i++) 
									{
										columnName = tableData.getColumnName(i);
										if(columnName.equals("id")) {
											mapTmp.put("id", id);
										}
										else if(columnName.equals("field_value")){
											mapTmp.put(columnName, data);
										}
										else if(columnName.indexOf("_lower")  >-1) {
											indexColum = i;
											mapTmp.put(columnName, data.toLowerCase());
										}
										else if(columnName.equals("status")) {
											mapTmp.put(columnName, Integer.parseInt(textFieldStatus.getText()));
										}
										else if(comboboxField.getModel().getSize() > 0) {
											mapTmp.put("field", comboboxField.getSelectedItem().toString());
										}
										else {
											mapTmp.put(columnName, data);
										}
									}
									listSaveData.add(mapTmp);
									progressBar.setValue(count);
									++id;
									++count;
								 }
						    	 if(listSaveData.size() > 0) 
						    	 {
						    		 boolean isLokkupByField = false;
						    		 String columnLookupByField = "";
						    		 if(!comboboxField.equals("")){
						    			 columnLookupByField = comboboxField.getSelectedItem().toString();
						    		 }
						    		 String columnCheckExistValue = tableData.getColumnName(indexColum);
						    		 
						    		 if(comboboxField.getModel().getSize() > 0){
						    			 isLokkupByField = true;
						    		 }						    		
						    		 flag = daoDaoImportExportLookup.saveDataLookup(table, listSaveData , isLokkupByField , columnLookupByField , columnCheckExistValue);
						    		 if(flag) {
						    			 AppUtility.msgInfo(frame, "Import data successfull !!");
						    		 }
						    	 }
						     }
						} catch (Exception e) {
							e.printStackTrace();
							AppUtility.msgError(null, "runMoveData : "  + e.toString());
						}
					}
				});
				thread.start();
			}

		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "processDataLookup : "  + e.toString());
		}

	}

}
