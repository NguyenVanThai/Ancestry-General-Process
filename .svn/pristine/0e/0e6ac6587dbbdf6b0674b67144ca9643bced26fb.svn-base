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
import javax.swing.JCheckBox;
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
import com.digitexx.ancestry.bean.FieldNameList;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.dao.DaoAddField;
import com.digitexx.ancestry.table.render.DragHook;
import com.digitexx.ancestry.util.AppUtility;
import com.digitexx.ancestry.util.JTableUtil;
import com.digitexx.ancestry.util.ReflectionHelper;
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
public class FrmAddFieldNameList extends javax.swing.JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JPanel panelHeader;
	private JPanel panelContent;
	private JPanel panelFooter;
	private JSplitPane splitPane;
	private JButton buttonDelete;
	private JButton buttonSave;
	private JTable tableRight;
	private JTable tableLeft;
	private JScrollPane scrollPaneRight;
	private JScrollPane scrollPaneLeft;
	private JComboBox comboboxLeftForm;
	private JComboBox comboboxProject;
	private JPanel panelLeft;
	private JCheckBox checkboxDB10;
	private ButtonGroup buttonGroup;
	private JComboBox comboboxRightForm;
	private JPanel panelRight;
	private Tbl_Projects project;
	private String userId;
	private FrmStep frmStep;
	private LinkedHashMap<String, Tbl_Projects> mapProject;
	private DaoAddField daoAddField;
	private Tbl_Projects leftProject;
    private DefaultTableModel leftModel;
    private DefaultTableModel rightModel;
    private List<FieldNameList>listFieldLeft;
    private List<FieldNameList>listFieldRight;
    private String [] arrHeaderLeft;
    private String [] arrHeaderRight;

	public FrmAddFieldNameList(Tbl_Projects project , String userId , FrmStep frmStep , LinkedHashMap<String, Tbl_Projects> mapProject)
	{
		super();
		this.project    = project;
		this.userId     = userId;
		this.frmStep    = frmStep;
		this.mapProject = mapProject;
		daoAddField     =  new DaoAddField();
		initGUI();
		AppUtility.fullScreen(this);
		initData();
	}
	
	private void initGUI() {
		try {
			this.setTitle("Form Add Field");
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
					checkboxDB10 = new JCheckBox();
					panelHeader.add(checkboxDB10, new AnchorConstraint(65, 644, 960, 541, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					checkboxDB10.setText("10.10.5.10");
					checkboxDB10.setPreferredSize(new java.awt.Dimension(112, 34));
					checkboxDB10.setFont(new java.awt.Font("Tahoma",1,14));
					checkboxDB10.setForeground(new java.awt.Color(255,0,128));
					checkboxDB10.addActionListener(this);
				}
				{
					comboboxRightForm = new JComboBox();
					panelHeader.add(comboboxRightForm, new AnchorConstraint(75, 996, 954, 918, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					comboboxRightForm.setPreferredSize(new java.awt.Dimension(85, 29));
					comboboxRightForm.setBorder(BorderFactory.createTitledBorder(null, "Right Form", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,12), new java.awt.Color(255,0,0)));
					comboboxRightForm.setFont(new java.awt.Font("Arial",1,12));
					comboboxRightForm.addActionListener(this);
				}
				{
					comboboxProject = new JComboBox();
					panelHeader.add(comboboxProject, new AnchorConstraint(13, 532, 960, 106, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					comboboxProject.setPreferredSize(new java.awt.Dimension(462, 36));
					comboboxProject.setFont(new java.awt.Font("Arial",1,16));
					comboboxProject.addActionListener(this);
				}
				{
					comboboxLeftForm = new JComboBox();
					panelHeader.add(comboboxLeftForm, new AnchorConstraint(13, 89, 960, 2, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					comboboxLeftForm.setPreferredSize(new java.awt.Dimension(95, 36));
					comboboxLeftForm.setFont(new java.awt.Font("Arial",1,12));
					comboboxLeftForm.setBorder(BorderFactory.createTitledBorder(null, "Left Form", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,12)));
					comboboxLeftForm.addActionListener(this);
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
							{
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
									
									@Override
									protected JTableHeader createDefaultTableHeader() {
										JTableHeader header = new JTableHeader(getColumnModel()) {
											DragHook hook;

											@Override
											public void updateUI() {
												if (hook != null) {
													hook.uninstallHook();
													hook = null;
												}
												super.updateUI();
												hook = new DragHook(this, "No.");
											}

										};
										return header;
									}
								};
								scrollPaneRight.setViewportView(tableRight);
							}
						}
					}
					{
						panelLeft = new JPanel();
						BorderLayout jPanel2Layout = new BorderLayout();
						panelLeft.setLayout(jPanel2Layout);
						splitPane.add(panelLeft, JSplitPane.LEFT);
						panelLeft.setPreferredSize(new java.awt.Dimension(566, 572));
						panelLeft.setBorder(BorderFactory.createTitledBorder(null, "Project Reference", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,14)));
						{
							scrollPaneLeft = new JScrollPane();
							panelLeft.add(scrollPaneLeft, BorderLayout.CENTER);
							{
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
								scrollPaneLeft.setViewportView(tableLeft);
							}
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
					panelFooter.add(buttonSave, new AnchorConstraint(75, 78, 954, 2, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonSave.setText("Save");
					buttonSave.setFont(new java.awt.Font("Tahoma",1,14));
					buttonSave.setPreferredSize(new java.awt.Dimension(83, 29));
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

	@Override
	public void actionPerformed(ActionEvent evt) {
		
		Object action = evt.getSource();
		if(action == comboboxProject) {
			loadLeftForm();
			loadListFielLeft(false);
		}
        if(action == comboboxLeftForm) 
        {
        	if(comboboxLeftForm.getSelectedIndex() > 0) {
            	loadListFielLeft(true);
        	}else {
            	loadListFielLeft(false);
        	}
        }
        if(action == comboboxRightForm) 
        {
        	if(comboboxRightForm.getSelectedIndex() > 0) {
        		loadListFielRight(true);
        	}else {
        		loadListFielRight(false);
        	}
        }
        
        if(action == buttonSave) {
        	save();
        }
        if(action == buttonDelete) {
        	delete();
        }
        if(action == checkboxDB10) 
        {
        	loadListFielLeft(false);
        }
		
	}
	
	private void initData() {
		loadProject();
		loadListFielRight(false);
		loadRightForm();
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
	 * load left form
	 */
	private void loadRightForm()
	{
		try
		{
			comboboxRightForm.removeAllItems();
			List<String> listRightForm = daoAddField.getFormByProject(project);
			comboboxRightForm.addItem("All");
			if(listRightForm.size() >0 )
			{
			   for (String str : listRightForm) {
				   comboboxRightForm.addItem(str);
			   }
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * load all project
	 */
	private void loadProject()
	{
		comboboxProject.removeAllItems();
		for (String key : mapProject.keySet()) {
			if(key.indexOf("_for_qc") == -1) {
				comboboxProject.addItem(key);
			}
		}
	}
	
	/**
	 * load left form
	 */
	private void loadLeftForm()
	{
		try
		{
			comboboxLeftForm.removeAllItems();
			leftProject = mapProject.get(comboboxProject.getSelectedItem().toString());
			List<String> listLeftForm = daoAddField.getFormByProject(leftProject);
			comboboxLeftForm.addItem("All");
			if(listLeftForm.size() >0 )
			{
			   for (String str : listLeftForm) {
				   comboboxLeftForm.addItem(str);
			   }
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * set array header for Jtable
	 */
	private void setArrayHeader(boolean isLeft) 
	{
        List<String> listFieldName = ReflectionHelper.getListFieldName(FieldNameList.class);
        listFieldName.add("Check");
        int index = 0;
        if(isLeft) {
        	arrHeaderLeft = new String [listFieldName.size()];
        }else {
        	arrHeaderRight = new String [ listFieldName.size() ];
        }
        for (String str : listFieldName) 
        {
		    if(isLeft) {
		    	arrHeaderLeft[index] = str;
		    }else {
		    	arrHeaderRight[index] = str;
		    }
		    ++index;
		}
	}
	
	/**
	 * load list field of left table
	 */
	private void loadListFielLeft(boolean isByForm) 
	{
        try 
        {
        	setArrayHeader(true);
            leftModel = new DefaultTableModel( arrHeaderLeft , 0 );
            if(!isByForm){
            		listFieldLeft = daoAddField.getListFieldNameList(leftProject , checkboxDB10.isSelected());
            }else {
            		listFieldLeft = daoAddField.getListFieldNameListByForm(leftProject, 
            				                                               comboboxLeftForm.getSelectedItem().toString(),
            				                                               checkboxDB10.isSelected());
            }
    		Object [] values = null ;
    		for (FieldNameList fieldNameList :  listFieldLeft)
    		{
    			values = ReflectionHelper.beanToArrayObject(fieldNameList.getClass(), fieldNameList);
    			leftModel.addRow(values);
    		}
    		tableLeft.setModel(leftModel);
    		styleTable(tableLeft);

		} 
        catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * load list field of right table
	 */
	private void loadListFielRight(boolean isByForm) 
	{
	        try 
	        {
	        	setArrayHeader(false);
	        	rightModel = new DefaultTableModel( arrHeaderLeft , 0 );
	        	if(!isByForm) {
	        		listFieldRight = daoAddField.getListFieldNameList(project , false);
	        	}else {
	        		listFieldRight = daoAddField.getListFieldNameListByForm(project, 
	        				                                                comboboxRightForm.getSelectedItem().toString(),
	        				                                                false);
	        	}
				Object [] values ;
				for (FieldNameList fieldNameList :  listFieldRight)
				{
	    			values = ReflectionHelper.beanToArrayObject(fieldNameList.getClass(), fieldNameList);
					rightModel.addRow(values);
				}
				tableRight.setModel(rightModel);
				styleTable(tableRight);
			} 
	        catch (Exception e) {
				e.printStackTrace();
			}

	}
	
	/**
	 * save field
	 * @throws Exception 
	 */
	private void save() 
	{
		boolean flag = true;
		if(comboboxRightForm.getSelectedIndex() > 0) 
		{
			try 
			{
		        LinkedHashMap<String , Object> mapTmp = new LinkedHashMap<String , Object>();
		        List<LinkedHashMap<String, Object>> listSaveData = new ArrayList<LinkedHashMap<String , Object>>();
		        
		        int totalRow     = tableLeft.getRowCount();
		        int totalColumn  = tableLeft.getColumnCount();
		        int id =1;
		        String formid = comboboxRightForm.getSelectedItem().toString();
		        String columnName = "";
		        Object value = "";
		        String check = "";
		        
		        int tabOrder = daoAddField.getTabOther(project, formid , false);
				id = daoAddField.getTabOther(project, formid , true);

		        for (int row = 0; row < totalRow; row++) 
		        {
		        	mapTmp = new LinkedHashMap<String , Object>();
					check  = StringUtil.setNotNull(JTableUtil.getValuesByHeader(tableLeft , "Check", row));
					
					for (int col = 1; col < totalColumn-1; col++) 
					{
						columnName = tableLeft.getColumnName(col);
						value      = tableLeft.getValueAt(row, col);
						if(columnName.equals("form_id")) {
							mapTmp.put(columnName, Long.parseLong(formid));
						}
						else if(columnName.equals("first_upper") || columnName.equals("upper_mc") || columnName.equals("non_upper") || columnName.equals("remove_other")) {
							mapTmp.put(columnName, Integer.parseInt(formid));
						}
						else {
							mapTmp.put(columnName, value);
						}
					}
					
					if(check.equals("true")) 
					{
						mapTmp.put("id", id);
						mapTmp.put("tab_order", tabOrder);
						
						listSaveData.add(mapTmp);
						++ tabOrder;
						++ id;
					}
				}
		        if(listSaveData.size() > 0) {
		        	flag = daoAddField.saveFieldNameList(listSaveData, project);
		        }
		        if(flag) {
		        	loadListFielRight(true);
		        	resetCheck();
		        	AppUtility.msgInfo(this, "Add field successfull !!");
		        }
			} 
			catch (Exception e) {
				e.printStackTrace();
				AppUtility.msgError(this, "Save : "  + e.toString());
			}
		}
	}
	
	/**
	 * reset check box jtable
	 */
	private void resetCheck() 
	{
       int rows = tableLeft.getRowCount();
       for (int i = 0; i < rows ; i++) {
		     tableLeft.setValueAt(Boolean.FALSE, i, tableLeft.getColumnCount()-1);
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
					flag = daoAddField.delete(project, listId);
				}
			}
			if(flag) {
				loadListFielRight(true);
				AppUtility.msgInfo(this, "Delete field successfull !!");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "Delete : " +  e.toString());
		}
		return flag;
	}
	

}
