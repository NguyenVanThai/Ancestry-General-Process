package com.digitexx.ancestry.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.conts.TableName;
import com.digitexx.ancestry.dao.DaoSupportMoveData;
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
public class FrmSupportMoveData extends javax.swing.JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JPanel panelHeader;
	private JPanel panelContent;
	private JPanel panelFooter;
	private JSplitPane splitPane;
	private JButton buttonDelete;
	private JButton buttonSave;
	private JScrollPane scrollPaneRight;
	private JScrollPane scrollPaneLeft;
	private JComboBox comboboxProject;
	private JPanel panelLeft;
	private JButton buttonSelectAllRight;
	private JButton buttonSelectAllLeft;
	private JTable tableRight;
	private JScrollPane jScrollPane2;
	private JComboBox comboboxRightTable;
	private JPanel jPanel2;
	private JPanel jPanel1;
	private JSplitPane splitPaneRight;
	private JTable tableLeft;
	private JScrollPane jScrollPane1;
	private JComboBox comboboxLeftTable;
	private JPanel panelTopLeft;
	private JPanel panelLeftData;
	private JSplitPane splitPaneLeft;
	private ButtonGroup buttonGroup;
	private JPanel panelRight;
	private Tbl_Projects project;
	private String userId;
	private FrmStep frmStep;
	private LinkedHashMap<String, Tbl_Projects> mapProject;
	private Tbl_Projects leftProject;
    private DefaultTableModel leftModel;
    private DefaultTableModel rightModel;
    private DaoSupportMoveData daoSupportMoveData;

	public FrmSupportMoveData(Tbl_Projects project , String userId , FrmStep frmStep , LinkedHashMap<String, Tbl_Projects> mapProject)
	{
		super();
		this.project    = project;
		this.userId     = userId;
		this.frmStep    = frmStep;
		this.mapProject = mapProject;
		daoSupportMoveData = new DaoSupportMoveData();
		initGUI();
		AppUtility.fullScreen(this);
		initData();
	}
	
	private void initGUI() {
		try {
			this.setTitle("Form Support Move Data");
			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			{
				panelHeader = new JPanel();
				AnchorLayout panelHeaderLayout = new AnchorLayout();
				getContentPane().add(panelHeader, new AnchorConstraint(0, 1000, 58, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelHeader.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelHeader.setLayout(panelHeaderLayout);
				panelHeader.setPreferredSize(new java.awt.Dimension(1084, 38));
				{
					comboboxProject = new JComboBox();
					panelHeader.add(comboboxProject, new AnchorConstraint(13, 409, 934, 2, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					comboboxProject.setPreferredSize(new java.awt.Dimension(441, 35));
					comboboxProject.setFont(new java.awt.Font("Arial",1,16));
					comboboxProject.addActionListener(this);
				}
			}
			{
				panelContent = new JPanel();
				BorderLayout panelContentLayout = new BorderLayout();
				panelContent.setLayout(panelContentLayout);
				getContentPane().add(panelContent, new AnchorConstraint(68, 1000, 940, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelContent.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelContent.setPreferredSize(new java.awt.Dimension(1084, 576));
				{
					splitPane = new JSplitPane();
					panelContent.add(splitPane, BorderLayout.CENTER);
					{
						panelRight = new JPanel();
						BorderLayout jPanel1Layout = new BorderLayout();
						panelRight.setLayout(jPanel1Layout);
						splitPane.add(panelRight, JSplitPane.RIGHT);
						panelRight.setBorder(BorderFactory.createTitledBorder(null, project.getProj_name() , TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,14), new java.awt.Color(255,0,0)));
						{
							scrollPaneRight = new JScrollPane();
							panelRight.add(scrollPaneRight, BorderLayout.CENTER);
							scrollPaneRight.setViewportView(getSplitPaneRight());
						}
					}
					{
						panelLeft = new JPanel();
						BorderLayout jPanel2Layout = new BorderLayout();
						panelLeft.setLayout(jPanel2Layout);
						splitPane.add(panelLeft, JSplitPane.LEFT);
						panelLeft.setPreferredSize(new java.awt.Dimension(566, 572));
						panelLeft.setBorder(BorderFactory.createTitledBorder("10.10.5.10"));
						{
							scrollPaneLeft = new JScrollPane();
							panelLeft.add(scrollPaneLeft, BorderLayout.CENTER);
							scrollPaneLeft.setViewportView(getSplitPaneLeft());
						}
					}
				}
			}
			{
				panelFooter = new JPanel();
				AnchorLayout panelFooterLayout = new AnchorLayout();
				getContentPane().add(panelFooter, new AnchorConstraint(940, 1000, 990, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelFooter.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelFooter.setLayout(panelFooterLayout);
				panelFooter.setPreferredSize(new java.awt.Dimension(1084, 33));
				{
					buttonSave = new JButton();
					panelFooter.add(getButtonSelectAllRight(), new AnchorConstraint(75, 922, 954, 794, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					panelFooter.add(getButtonSelectAllLeft(), new AnchorConstraint(75, 141, 1015, 2, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					panelFooter.add(buttonSave, new AnchorConstraint(75, 226, 954, 152, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonSave.setText("Save");
					buttonSave.setFont(new java.awt.Font("Tahoma",1,14));
					buttonSave.setPreferredSize(new java.awt.Dimension(80, 29));
					buttonSave.addActionListener(this);
				}
				{
					buttonDelete = new JButton();
					panelFooter.add(buttonDelete, new AnchorConstraint(-15, 998, 954, 934, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonDelete.setText("Delete");
					buttonDelete.setFont(new java.awt.Font("Tahoma",1,14));
					buttonDelete.setPreferredSize(new java.awt.Dimension(70, 32));
					buttonDelete.addActionListener(this);
				}
			}
			pack();
			this.setSize(1092, 695);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					exit();
				}
			});
			
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void exit() {
		if(AppUtility.msgConfirm(this, "Do you want to exit ??") == JOptionPane.OK_OPTION) {
			frmStep.setVisible(true);
			this.dispose();
		}
	}
	
	
	private ButtonGroup getButtonGroup() {
		if(buttonGroup == null) {
			buttonGroup = new ButtonGroup();
		}
		return buttonGroup;
	}
	
	private JSplitPane getSplitPaneLeft() {
		if(splitPaneLeft == null) {
			splitPaneLeft = new JSplitPane();
			splitPaneLeft.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPaneLeft.add(getJPanel1(), JSplitPane.RIGHT);
			splitPaneLeft.add(getJPanel2(), JSplitPane.LEFT);
		}
		return splitPaneLeft;
	}
	
	private JPanel getJPanel1() {
		if(panelLeftData == null) {
			panelLeftData = new JPanel();
			BorderLayout panelLeftDataLayout = new BorderLayout();
			panelLeftData.setLayout(panelLeftDataLayout);
			panelLeftData.add(getJScrollPane1(), BorderLayout.CENTER);
		}
		return panelLeftData;
	}
	
	private JPanel getJPanel2() {
		if(panelTopLeft == null) {
			panelTopLeft = new JPanel();
			BorderLayout panelTopLeftLayout = new BorderLayout();
			panelTopLeft.setLayout(panelTopLeftLayout);
			panelTopLeft.setPreferredSize(new java.awt.Dimension(551, 37));
			panelTopLeft.add(getComboboxLeftTable(), BorderLayout.CENTER);
		}
		return panelTopLeft;
	}
	
	private JComboBox getComboboxLeftTable() {
		if(comboboxLeftTable == null) {
			comboboxLeftTable = new JComboBox();
			comboboxLeftTable.setFont(new java.awt.Font("Tahoma",1,16));
			comboboxLeftTable.addActionListener(this);

		}
		return comboboxLeftTable;
	}
	
	private JScrollPane getJScrollPane1() {
		if(jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setViewportView(getTableLeft());
		}
		return jScrollPane1;
	}
	
	private JTable getTableLeft() {
		if(tableLeft == null) {
			tableLeft = new JTable() 
			{
				@Override
				public Class<?> getColumnClass(int column) 
				{
                     if(getColumnName(column).equals("Check")) {
							return Boolean.class;
                     }else {
							return String.class;
                     }
				}
				
				@Override
				public boolean isCellEditable(int row,int column) 
				{
                    if(getColumnName(column).equals("Check")) {
							return true;
                    }else {
							return false;
                    }
				}
			};
		}
		return tableLeft;
	}
	
	private JSplitPane getSplitPaneRight() {
		if(splitPaneRight == null) {
			splitPaneRight = new JSplitPane();
			splitPaneRight.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPaneRight.add(getJPanel1x(), JSplitPane.RIGHT);
			splitPaneRight.add(getJPanel2x(), JSplitPane.LEFT);
		}
		return splitPaneRight;
	}
	
	private JPanel getJPanel1x() {
		if(jPanel1 == null) {
			jPanel1 = new JPanel();
			BorderLayout jPanel1Layout1 = new BorderLayout();
			jPanel1.setLayout(jPanel1Layout1);
			jPanel1.add(getJScrollPane2(), BorderLayout.CENTER);
		}
		return jPanel1;
	}
	
	private JPanel getJPanel2x() {
		if(jPanel2 == null) {
			jPanel2 = new JPanel();
			BorderLayout jPanel2Layout1 = new BorderLayout();
			jPanel2.setLayout(jPanel2Layout1);
			jPanel2.setPreferredSize(new java.awt.Dimension(498, 35));
			jPanel2.add(getComboboxRightTable(), BorderLayout.CENTER);
		}
		return jPanel2;
	}
	
	private JComboBox getComboboxRightTable() {
		if(comboboxRightTable == null) {
			comboboxRightTable = new JComboBox();
			comboboxRightTable.setFont(new java.awt.Font("Tahoma",1,16));
			comboboxRightTable.addActionListener(this);
		}
		return comboboxRightTable;
	}
	
	private JScrollPane getJScrollPane2() {
		if(jScrollPane2 == null) {
			jScrollPane2 = new JScrollPane();
			jScrollPane2.setViewportView(getTableRight());
		}
		return jScrollPane2;
	}
	
	
	private JButton getButtonSelectAllLeft() {
		if(buttonSelectAllLeft == null) {
			buttonSelectAllLeft = new JButton();
			buttonSelectAllLeft.setText("Left Select All");
			buttonSelectAllLeft.setPreferredSize(new java.awt.Dimension(151, 31));
			buttonSelectAllLeft.setFont(new java.awt.Font("Tahoma",1,12));
			buttonSelectAllLeft.setForeground(new java.awt.Color(255,0,0));
			buttonSelectAllLeft.addActionListener(this);
		}
		return buttonSelectAllLeft;
	}
	
	private JButton getButtonSelectAllRight() {
		if(buttonSelectAllRight == null) {
			buttonSelectAllRight = new JButton();
			buttonSelectAllRight.setText("Right Select All");
			buttonSelectAllRight.setPreferredSize(new java.awt.Dimension(139, 29));
			buttonSelectAllRight.setFont(new java.awt.Font("Tahoma",1,12));
			buttonSelectAllRight.setForeground(new java.awt.Color(255,0,0));
			buttonSelectAllRight.addActionListener(this);
		}
		return buttonSelectAllRight;
	}
	
	private JTable getTableRight() {
		if(tableRight == null) {
			tableRight = new JTable() {
				@Override
				public Class<?> getColumnClass(int column) 
				{
                     if(getColumnName(column).equals("Check")) {
							return Boolean.class;
                     }else {
							return String.class;
                     }
				}
				
				@Override
				public boolean isCellEditable(int row,int column) 
				{
                    if(getColumnName(column).equals("Check")) {
							return true;
                    }else {
							return false;
                    }
				}
			};
		}
		return tableRight;
	}
	
	//=============================================================================================================================

	@Override
	public void actionPerformed(ActionEvent evt) {
		
		Object action = evt.getSource();
		if(action == comboboxProject) 
		{
        	leftProject = mapProject.get(comboboxProject.getSelectedItem().toString());
			loadLeftTable();
		}
        
        if(action == buttonSave) {
        	save();
        }
        
        if(action == buttonDelete) {
        	delete();
        }
        
        if(action == comboboxLeftTable) 
        {
    		if(comboboxLeftTable.getSelectedIndex() > -1) 
    		{
    			loadDataByTable(true, tableLeft, leftModel, leftProject, comboboxLeftTable.getSelectedItem().toString());
    		}
        }
        
        if(action == comboboxRightTable) 
        {
    		if(comboboxLeftTable.getSelectedIndex() > -1) 
    		{
        	   loadDataByTable(false, tableRight, rightModel, project, comboboxRightTable.getSelectedItem().toString());
    		}
        }
        
        if(action == buttonSelectAllLeft) {
        	selectAll(tableLeft);
        }
        
        if(action == buttonSelectAllRight) {
        	selectAll(tableRight);
        }
		
	}
	
	private void initData()
	{
		loadProject();
		loadRightTable();
	}
	
	private void styleTable(JTable tableData) {
		tableData.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JTableHeader header = tableData.getTableHeader();
		header.setForeground(Color.BLACK);
		JTableUtil.addHeaderRow(tableData);
		tableData.setFont(new Font("Arial", Font.PLAIN, 14));

		tableData.setShowGrid(true);
		tableData.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		tableData.setRowHeight(30);
		tableData.setRowHeight(30);
		tableData.getTableHeader().setReorderingAllowed(false);
	}
	
	//===============================================================================================================
	
	/**
	 * load all project
	 */
	private void loadProject()
	{
		comboboxProject.removeAllItems();
		for (String key : mapProject.keySet()) {
			if(key.indexOf("_for_qc") ==-1) {
				comboboxProject.addItem(key);
			}
		}
	}
	
	/**
	 * load all table left
	 */
	private void loadLeftTable() {
		try {
			comboboxLeftTable.removeAllItems();
			List<String> listLeft = daoSupportMoveData.getListTableName(leftProject);
			if(listLeft.size() > 0) 
			{
				for (String str : listLeft) {
					if(str.equals(TableName.p1_form_n_proof) || 
					   str.equals(TableName.p1_form_n_proof_rework) || 
					   str.equals(TableName.p1_form_n_type) ||
					   str.equals(TableName.p1_form_n_proof_history) ||
					   str.equals(TableName.management) ||
					   str.equals(TableName.management_rework) ||
					   str.equals(TableName.work_details)) 
					{
                        continue;						
					}else {
						comboboxLeftTable.addItem(str);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * load all table right
	 */
	private void loadRightTable() {
		try {
			comboboxRightTable.removeAllItems();
			List<String> listLeft = daoSupportMoveData.getListTableName(project);
			if(listLeft.size() > 0) 
			{
				for (String str : listLeft) {
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
						   comboboxRightTable.addItem(str);
						}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * set array header for Jtable
	 */
	private String [] setArrayHeader(List<LinkedHashMap<String, Object>> listData) 
	{
		String [] arrHeader = new String [1];
		int index = 0;
		if(listData.size()  >0) 
		{
	        int size  = listData.get(0).size();
	        
	        arrHeader = new String [size];
	        for (String str : listData.get(0).keySet()) 
	        {
	        	arrHeader[index] = str;
			    ++index;
			}
		}
        return arrHeader;
	}

	/**
	 * map to array
	 */
	public static Object[] mapToArray(LinkedHashMap<String, Object> mapData) {

		Object [] result = new Object[mapData.size()];
		try 
		{
			int index = 0;
			for (String key :  mapData.keySet()) {
				result[index] = mapData.get(key);
				++index;
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * load data by table name
	 */
	private void loadDataByTable( boolean isLeft,JTable tbl , DefaultTableModel model , Tbl_Projects project , String tableName) 
	{
		try
		{
			List<LinkedHashMap<String, Object>> listData = new ArrayList<LinkedHashMap<String, Object>>();
			if (isLeft) {
				listData = daoSupportMoveData.getListDataByTable(leftProject,tableName , isLeft);
			} else {
				listData = daoSupportMoveData.getListDataByTable(project,tableName , isLeft);
			}
			String[] headers = setArrayHeader(listData);
			model = new DefaultTableModel(headers, 0);

			Object[] values = null;
			for (LinkedHashMap<String, Object> mapTmp : listData)
			{
				values = mapToArray(mapTmp);
				model.addRow(values);
			}
			tbl.setModel(model);
			styleTable(tbl);
		} catch (Exception e) {
			e.printStackTrace();
		}
       
	}
	
	
	/**
	 * save data
	 * @throws Exception 
	 */
	private void save() 
	{
		boolean flag = true;
		if(tableLeft.getRowCount() > 0) 
		{
			try 
			{
		        LinkedHashMap<String , Object> mapTmp = new LinkedHashMap<String , Object>();
		        List<LinkedHashMap<String, Object>> listSaveData = new ArrayList<LinkedHashMap<String , Object>>();
		        
		        int totalRow     = tableLeft.getRowCount();
		        int totalColumn  = tableLeft.getColumnCount();
		        String columnName = "";
		        Object value = "";
		        String check = "";
		        String tableName = comboboxRightTable.getSelectedItem().toString();
		        
		        for (int row = 0; row < totalRow; row++) 
		        {
		        	mapTmp = new LinkedHashMap<String , Object>();
					check  = StringUtil.setNotNull(JTableUtil.getValuesByHeader(tableLeft , "Check", row));
					
					for (int col = 0; col < totalColumn-1; col++) 
					{
						columnName = tableLeft.getColumnName(col);
						value      = tableLeft.getValueAt(row, col);
						if(check.equals("true")) 
						{
							mapTmp.put(columnName, value);
						}else {
							continue;
						}
					}
					if(mapTmp.size() >0) 
					{
						if(mapTmp.containsKey("key") && tableName.equals("form_info")) {
							mapTmp.remove("key");
						}
						listSaveData.add(mapTmp);
					}

				}
		        if(listSaveData.size() > 0) 
		        {
		        	if(!tableName.equals("form_info")) {
		        		int nextId = daoSupportMoveData.getNextId(project, tableName);
		        		String coluNameId = tableRight.getColumnName(0);
		        		flag = daoSupportMoveData.saveData(listSaveData, project, tableName,nextId,coluNameId);
		        	}else {
		        		flag = daoSupportMoveData.saveDataWithId(listSaveData, project, tableName);
		        	}
		        }
		        if(flag) 
		        {
		        	loadDataByTable(false, tableRight, rightModel, project, tableName);
		        	AppUtility.msgInfo(this, "Save succesull !!");
		        }
			} 
			catch (Exception e) {
				e.printStackTrace();
				AppUtility.msgError(this, "Save : "  + e.toString());
			}
		}
	}
	
	
	/**
	 * delete field
	 */
	public boolean delete()
	{
		boolean flag = false;
		int totalRow = tableRight.getRowCount();
		String check = "";
		String id = "";
		List<String> listId = new ArrayList<String>();
		try 
		{
			for (int i = 0; i < totalRow; i++) 
			{
				check  = StringUtil.setNotNull(JTableUtil.getValuesByHeader(tableRight , "Check", i));
				id     = StringUtil.setNotNull(JTableUtil.getValuesByHeader(tableRight , "id", i));
				
	            if(check.equals("true")) {
	            	listId.add(id);
	            }
			}
			if(listId.size() > 0) 
			{
				if(AppUtility.msgConfirm(this, "Do you want to delete field ??") == JOptionPane.OK_OPTION) {
					flag = daoSupportMoveData.delete(project, listId , comboboxRightTable.getSelectedItem().toString());
				}
			}
			if(flag) {
				JTableUtil.removeAllRow(tableRight);
				AppUtility.msgInfo(this, "Delete field successfull !!");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "Delete : " +  e.toString());
		}
		return flag;
	}
	
	/**
	 * check all 
	 */
	private void selectAll(JTable tableData) {
		int totalRow = tableData.getRowCount();
		for (int i = 0; i < totalRow; i++)
		{
			tableData.setValueAt(true, i, tableData.getColumnCount()-1);
		}
		
	}


}
