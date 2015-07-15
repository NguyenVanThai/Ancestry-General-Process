package com.digitexx.ancestry.gui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.digitexx.ancestry.bean.BeanTmpConfig;
import com.digitexx.ancestry.bean.FieldNameList;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.conts.FieldNameConfig;
import com.digitexx.ancestry.conts.FieldType;
import com.digitexx.ancestry.dao.DaoConfigFieldNameList;
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
@SuppressWarnings("serial")
public class FrmConfigFieldNameList extends javax.swing.JFrame implements ActionListener {
	private JPanel panelContent;
	private JPanel panelFooter;
	private JPanel panelRight;
	private JPanel panelLeft;
	private JButton buttonSave;
	private JRadioButton radioOtherValidation;
	private JRadioButton radioQuickField;
	private JRadioButton radioLimitedYear;
	private JRadioButton radioCheckInListDonotWrite;
	private JPanel panelTypeUpdate;
	private JRadioButton radioLookupF9F10;
	private JRadioButton radioCopyDataOnGrid;
	private JRadioButton radioHiddenField;
	private JRadioButton radioToolTipField;
	private JRadioButton radioTitleField;
	private JRadioButton radioCopyInputField;
	private JRadioButton radioTabOrder;
	private JTable tableData;
	private JScrollPane scrollPaneLeft;
	private JScrollPane scrollPaneRight;
	private JSplitPane splitPaneContent;
	
	private FrmStep frmStep ;
	private Tbl_Projects project;
	private DaoConfigFieldNameList daoConfigFieldNameList;
	private List<FieldNameList> listFieldNameList = new ArrayList<FieldNameList>();
	private String fieldConfig = "tab_order";
	private String [] headers;
	private JRadioButton radioRemoveData;
	private JRadioButton radioNonUpperCase;
	private JRadioButton radioUppercaseMc;
	private JRadioButton radioUppercaseFirst;
	private ButtonGroup buttonGroup;
	private JComboBox comboboxForm;
	private JLabel jLabel1;
	private DefaultTableModel model;
	private int isNumber = 0;
	private List<BeanTmpConfig> listSaveData = new ArrayList<BeanTmpConfig>();
	private BeanTmpConfig beanTmpConfig = new BeanTmpConfig();

	public FrmConfigFieldNameList(FrmStep frmStep , Tbl_Projects project) {
		super();
		this.frmStep = frmStep;
		this.project = project;
		this.daoConfigFieldNameList = new DaoConfigFieldNameList(project);
		initGUI();
		initData();
	}
	
	private void initGUI() {
		try {
			this.setTitle("Form Config Data Field Name List");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				panelContent = new JPanel();
				BorderLayout panelContentLayout = new BorderLayout();
				getContentPane().add(panelContent);
				panelContent.setBounds(0, 0, 932, 556);
				panelContent.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelContent.setLayout(panelContentLayout);
				{
					splitPaneContent = new JSplitPane();
					panelContent.add(splitPaneContent, BorderLayout.CENTER);
					splitPaneContent.setDividerLocation(300);
					{
						panelRight = new JPanel();
						BorderLayout panelRightLayout = new BorderLayout();
						panelRight.setLayout(panelRightLayout);
						splitPaneContent.add(panelRight, JSplitPane.RIGHT);
						{
							scrollPaneRight = new JScrollPane();
							panelRight.add(scrollPaneRight, BorderLayout.CENTER);
							{
								tableData = new JTable() {
									@Override
									public boolean isCellEditable(int row,int column) {
										if(getColumnName(column).equals(fieldConfig) || getColumnName(column).equals("Min") || getColumnName(column).equals("Max")) {
											return true;
										}else {
											return false;
										}
									}
								};
								scrollPaneRight.setViewportView(tableData);
							}
						}
					}
					{
						panelLeft = new JPanel();
						BorderLayout panelLeftLayout = new BorderLayout();
						panelLeft.setLayout(panelLeftLayout);
						splitPaneContent.add(panelLeft, JSplitPane.LEFT);
						panelLeft.setPreferredSize(new java.awt.Dimension(243, 550));
						{
							scrollPaneLeft = new JScrollPane();
							panelLeft.add(scrollPaneLeft, BorderLayout.CENTER);
							{
								panelTypeUpdate = new JPanel();
								BoxLayout panelTypeUpdateLayout = new BoxLayout(panelTypeUpdate, javax.swing.BoxLayout.Y_AXIS);
								panelTypeUpdate.setLayout(panelTypeUpdateLayout);
								scrollPaneLeft.setViewportView(panelTypeUpdate);
								{
									radioTabOrder = new JRadioButton();
									panelTypeUpdate.add(radioTabOrder);
									radioTabOrder.setText("Tab Order");
									radioTabOrder.setFont(new java.awt.Font("Arial",0,18));
									getButtonGroup().add(radioTabOrder);
									radioTabOrder.addActionListener(this);
								}
								{
									radioCopyInputField = new JRadioButton();
									panelTypeUpdate.add(radioCopyInputField);
									radioCopyInputField.setText("Copy Input Field");
									radioCopyInputField.setFont(new java.awt.Font("Arial",0,18));
									getButtonGroup().add(radioCopyInputField);
									radioCopyInputField.addActionListener(this);
								}
								{
									radioTitleField = new JRadioButton();
									panelTypeUpdate.add(radioTitleField);
									radioTitleField.setText("Title Field");
									radioTitleField.setFont(new java.awt.Font("Arial",0,18));
									getButtonGroup().add(radioTitleField);
									radioTitleField.addActionListener(this);

								}
								{
									radioToolTipField = new JRadioButton();
									panelTypeUpdate.add(radioToolTipField);
									radioToolTipField.setText("Tooltip Field");
									radioToolTipField.setFont(new java.awt.Font("Arial",0,18));
									getButtonGroup().add(radioToolTipField);
									radioToolTipField.addActionListener(this);

								}
								{
									radioHiddenField = new JRadioButton();
									panelTypeUpdate.add(radioHiddenField);
									radioHiddenField.setText("Hidden Field");
									radioHiddenField.setFont(new java.awt.Font("Arial",0,18));
									getButtonGroup().add(radioHiddenField);
									radioHiddenField.addActionListener(this);

								}
								{
									radioCopyDataOnGrid = new JRadioButton();
									panelTypeUpdate.add(radioCopyDataOnGrid);
									radioCopyDataOnGrid.setText("Copy Data On Grid");
									radioCopyDataOnGrid.setFont(new java.awt.Font("Arial",0,18));
									getButtonGroup().add(radioCopyDataOnGrid);
									radioCopyDataOnGrid.addActionListener(this);

								}
								{
									radioLookupF9F10 = new JRadioButton();
									panelTypeUpdate.add(radioLookupF9F10);
									radioLookupF9F10.setText("Lookup F9 & F10");
									radioLookupF9F10.setFont(new java.awt.Font("Arial",0,18));
									getButtonGroup().add(radioLookupF9F10);
									radioLookupF9F10.addActionListener(this);

								}
								{
									radioCheckInListDonotWrite = new JRadioButton();
									panelTypeUpdate.add(radioCheckInListDonotWrite);
									radioCheckInListDonotWrite.setText("Check In List Do not Write");
									radioCheckInListDonotWrite.setFont(new java.awt.Font("Arial",0,18));
									getButtonGroup().add(radioCheckInListDonotWrite);
									radioCheckInListDonotWrite.addActionListener(this);

								}
								{
									radioLimitedYear = new JRadioButton();
									panelTypeUpdate.add(radioLimitedYear);
									radioLimitedYear.setText("Limited Year");
									radioLimitedYear.setFont(new java.awt.Font("Arial",0,18));
									getButtonGroup().add(radioLimitedYear);
									radioLimitedYear.addActionListener(this);

								}
								{
									radioQuickField = new JRadioButton();
									panelTypeUpdate.add(radioQuickField);
									radioQuickField.setText("Quick Field");
									radioQuickField.setFont(new java.awt.Font("Arial",0,18));
									getButtonGroup().add(radioQuickField);
									radioQuickField.addActionListener(this);

								}
								{
									radioOtherValidation = new JRadioButton();
									panelTypeUpdate.add(getRadioUppercaseFirst());
									panelTypeUpdate.add(getRadioUppercaseMc());
									panelTypeUpdate.add(getRadioNonUpperCase());
									panelTypeUpdate.add(getRadioRemoveData());
									panelTypeUpdate.add(radioOtherValidation);
									radioOtherValidation.setText("Other Validation ( Only For SDD)");
									radioOtherValidation.setFont(new java.awt.Font("Arial",0,18));
									getButtonGroup().add(radioOtherValidation);
									radioOtherValidation.addActionListener(this);

								}
							}
						}
					}
				}
			}
			{
				panelFooter = new JPanel();
				panelFooter.setLayout(null);
				getContentPane().add(panelFooter);
				panelFooter.setBounds(0, 556, 932, 32);
				panelFooter.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				{
					buttonSave = new JButton();
					panelFooter.add(buttonSave, "Center");
					buttonSave.setText("Save");
					buttonSave.setBounds(824, 2, 106, 28);
					buttonSave.setFont(new java.awt.Font("Arial",1,16));
					buttonSave.setForeground(new java.awt.Color(255,0,0));
					buttonSave.addActionListener(this);
				}
				{
					jLabel1 = new JLabel();
					panelFooter.add(jLabel1);
					jLabel1.setText("Form : ");
					jLabel1.setBounds(301, 2, 63, 28);
					jLabel1.setBorder(new LineBorder(new java.awt.Color(255,0,0), 1, false));
					jLabel1.setFont(new java.awt.Font("Arial",1,16));
					jLabel1.setForeground(new java.awt.Color(255,0,0));
				}
				{
					comboboxForm = new JComboBox();
					panelFooter.add(comboboxForm);
					comboboxForm.setBounds(369, 2, 121, 28);
					comboboxForm.setFont(new java.awt.Font("Arial",1,16));
					comboboxForm.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							comboboxFormActionPerformed(evt);
						}
					});
				}
			}
			pack();
			this.setSize(940, 623);
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
	
	private ButtonGroup getButtonGroup() {
		if(buttonGroup == null) {
			buttonGroup = new ButtonGroup();
		}
		return buttonGroup;
	}
	
	private JRadioButton getRadioUppercaseFirst() {
		if(radioUppercaseFirst == null) {
			radioUppercaseFirst = new JRadioButton();
			radioUppercaseFirst.setText("Uppercase First Letter");
			radioUppercaseFirst.setFont(new java.awt.Font("Tahoma",0,18));
			radioUppercaseFirst.addActionListener(this);
			getButtonGroup().add(radioUppercaseFirst);
		}
		return radioUppercaseFirst;
	}
	
	private JRadioButton getRadioUppercaseMc() {
		if(radioUppercaseMc == null) {
			radioUppercaseMc = new JRadioButton();
			radioUppercaseMc.setText("Uppercase MC");
			radioUppercaseMc.setFont(new java.awt.Font("Tahoma",0,18));
			radioUppercaseMc.addActionListener(this);
			getButtonGroup().add(radioUppercaseMc);
		}
		return radioUppercaseMc;
	}
	
	private JRadioButton getRadioNonUpperCase() {
		if(radioNonUpperCase == null) {
			radioNonUpperCase = new JRadioButton();
			radioNonUpperCase.setText("Non Uppercase");
			radioNonUpperCase.setFont(new java.awt.Font("Tahoma",0,18));
			radioNonUpperCase.addActionListener(this);
			getButtonGroup().add(radioNonUpperCase);
		}
		return radioNonUpperCase;
	}
	
	private JRadioButton getRadioRemoveData() {
		if(radioRemoveData == null) {
			radioRemoveData = new JRadioButton();
			radioRemoveData.setText("Remove Data");
			radioRemoveData.setFont(new java.awt.Font("Tahoma",0,18));
			radioRemoveData.addActionListener(this);
			getButtonGroup().add(radioRemoveData);
		}
		return radioRemoveData;
	}


	@Override
	public void actionPerformed(ActionEvent evt) {
		Object action = evt.getSource();
		if(action == radioTabOrder) {
			fieldConfig = FieldNameConfig.tab_order.name();
			loadDataByFieldName();
		}
		if(action == radioCopyInputField) {
			fieldConfig = FieldNameConfig.copy.name();
			loadDataByFieldName();
		}
		if(action == radioTitleField) {
			fieldConfig = FieldNameConfig.title.name();
			loadDataByFieldName();
		}
		if(action == radioToolTipField) {
			fieldConfig = FieldNameConfig.tooltip.name();
			loadDataByFieldName();
		}
		if(action == radioHiddenField) {
			fieldConfig = FieldNameConfig.is_valid.name();
			loadDataByFieldName();
		}
		if(action == radioCopyDataOnGrid) {
			fieldConfig = FieldNameConfig.grid_copy.name();
			loadDataByFieldName();
		}
		if(action == radioLookupF9F10) {
			fieldConfig = FieldNameConfig.f9_f10.name();
			loadDataByFieldName();
		}
		if(action == radioCheckInListDonotWrite) {
			fieldConfig = FieldNameConfig.check_dont_write.name();
			loadDataByFieldName();
		}
		if(action == radioQuickField) {
			fieldConfig = FieldNameConfig.value_range.name();
			loadDataByFieldName();
		}
		
		if(action == radioUppercaseFirst) {
			fieldConfig = FieldNameConfig.first_upper.name();
			loadDataByFieldName();
		}
		if(action == radioUppercaseMc) {
			fieldConfig = FieldNameConfig.upper_mc.name();
			loadDataByFieldName();
		}
		if(action == radioNonUpperCase) {
			fieldConfig = FieldNameConfig.non_upper.name();
			loadDataByFieldName();
		}
		if(action == radioRemoveData) {
			fieldConfig = FieldNameConfig.remove_other.name();
			loadDataByFieldName();
		}
		
		//=================================================
		if(action == radioLimitedYear) {
			loadDataByFieldName();
		}
		if(action == radioOtherValidation) {
			loadDataByFieldName();
		}
		if(action == buttonSave) {
			saveData();
		}

	}
	
	
	private void comboboxFormActionPerformed(ActionEvent evt) {
		if(comboboxForm.getModel().getSize() >0) {
			loadDataByFieldName();
		}
	}
	
	//======================================================================================================================
	
	/**
	 * init default value
	 */
	private void initData() {
		getListData();
		loadForm();
	}
	
	/**
	 * get list all fieldnamelist
	 */
	private void getListData() {
		try {
			listFieldNameList = new ArrayList<FieldNameList>();
			listFieldNameList = daoConfigFieldNameList.getDataFieldNameList();
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "getListData : "  + e.toString());
		}
	}
	
	/**
	 * load all form
	 */
	private void loadForm() {

		try {
			List<String> listForm = new ArrayList<String>();
			listForm = daoConfigFieldNameList.getListForm();
			comboboxForm.removeAllItems();
			for (String str : listForm) {
				comboboxForm.addItem(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "loadForm : "  + e.toString());
		}
	}
	
	/**
	 * load data by fieldname
	 */
	private void loadDataByFieldName() {
		try {
			isNumber = FieldNameConfig.getByValue(fieldConfig);
			Object [] values;
			if(radioLimitedYear.isSelected()) {
				headers = new String [] { "No." ,"Form" ,"Field Name" , "Min" , "Max" };
			}
			else {
				headers = new String [] { "No." ,"Form" ,"Field Name" , fieldConfig };
			}
			List<Field> listField = ReflectionHelper.loadBeanFields(FieldNameList.class);
			long form = Long.parseLong(comboboxForm.getSelectedItem().toString());
			
			int index = 1;
			Object fieldValue = "";
			model = new DefaultTableModel(headers , 0);
			for (FieldNameList fieldNameList : listFieldNameList) 
			{
				if(form == fieldNameList.getForm_id()) 
				{
					for (Field field : listField) 
					{
						if(field.getName().equals(fieldConfig)) {
							fieldValue =  ReflectionHelper.getFieldValue(fieldNameList, field.getName());
							if(radioLimitedYear.isSelected()) {
								values = new Object [] { index ,fieldNameList.getForm_id() , fieldNameList.getFieldname() , fieldNameList.getOther1() ,   fieldNameList.getOther2()} ;
							}else {
								values = new Object [] { index ,fieldNameList.getForm_id() , fieldNameList.getFieldname() , fieldValue} ;
							}
							model.addRow(values);
							++index;
						}
					}
				}
			}
			tableData.setModel(model);
			JTableUtil.styleTable(tableData, true);
			JTableUtil.setPrefersizeColum(tableData, 0, 80);
			JTableUtil.setPrefersizeColum(tableData, 1, 50);
			JTableUtil.setPrefersizeColum(tableData, 2, 150);
			JTableUtil.setPrefersizeColum(tableData, 3, 150);
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "loadDataByFieldName : "  + e.toString());
		}
	}
	
	
	/**
	 * save config
	 */
	private void saveData() {
		boolean flag = true;
		int option = AppUtility.msgConfirm(this, "Do you want to save data !!");
		if(option == JOptionPane.OK_OPTION) {
			int totalRow = tableData.getRowCount();
			try {
				if(totalRow > 0) {
					int totalColumn = tableData.getColumnCount();
					String fieldName ="";
					String value ="";
					String min = "";
					String max = "";
					
					listSaveData = new ArrayList<BeanTmpConfig>();
					for (int row = 0; row < totalRow; row++) 
					{
						beanTmpConfig = new BeanTmpConfig();
	                    fieldName = JTableUtil.getValuesByHeaderName(tableData, "Field Name", row);
	                    beanTmpConfig.setFieldName(fieldName);
	                    beanTmpConfig.setFormId(comboboxForm.getSelectedItem().toString());
	                    beanTmpConfig.setColumname(fieldConfig);
	                    
	                    if(radioLimitedYear.isSelected()) {
	                    	min = JTableUtil.getValuesByHeaderName(tableData, "Min", row);
	                    	max = JTableUtil.getValuesByHeaderName(tableData, "Max", row);
	                    	
	                    	if(!StringUtil.isNumber(min) && isNumber == FieldType.number ) 
	                    	{
	                            AppUtility.msgError(this, "Row : "  + row + " must is integer number !!");
	                            flag = false;
	                            break;
		                    }
	                    	else if(!StringUtil.isNumber(min) && isNumber == FieldType.number) 
	                    	{
	                            AppUtility.msgError(this, "Row : "  + row + " must is integer number !!");
	                            flag = false;
	                            break;
		                    }else {
		                    	beanTmpConfig.setMin(min);
		                    	beanTmpConfig.setMax(max);
			                    listSaveData.add(beanTmpConfig);
		                    }
	                    }else {
	                    	value = StringUtil.setNotNull(tableData.getValueAt(row, totalColumn-1));
	                    	if(!StringUtil.isNumber(value) && isNumber == FieldType.number) {
                               AppUtility.msgError(this, "Row : "  + row + " must is integer number !!");
                               flag = false;
                               break;
	                    	}else {
	                    		beanTmpConfig.setValue(value);
	    	                    listSaveData.add(beanTmpConfig);
	                    	}
	                    }
					}
					
					if(listSaveData.size() > 0) {
						if(radioLimitedYear.isSelected()) {
							flag  = daoConfigFieldNameList.saveConfigData(listSaveData, true);
						}else {
							flag  = daoConfigFieldNameList.saveConfigData(listSaveData ,false);
						}
					}
					if(flag) {
						getListData();
						AppUtility.msgInfo(this, "Update data complete !!");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				AppUtility.msgError(this, "saveData : "  + e.toString());
			}
		}

	}

}
