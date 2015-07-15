package com.digitexx.ancestry.finals.admin;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.ancestry.bean.BeanFinalForm;
import com.digitexx.ancestry.bean.BeanFinalRule;
import com.digitexx.ancestry.bean.FieldNameList;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.dao.DaoFinal;
import com.digitexx.ancestry.gui.FrmStep;
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
public class FrmAdminFinal extends javax.swing.JFrame {
	private JPanel panelHeader;
	private JPanel panelContent;
	private JPanel panelRight;
	private JCheckBox checkboxIsRework;
	private JScrollPane scrollPaneLeft;
	private JPanel panelLeft;
	private JPanel panelPath;
	private JPanel panelData;
	private JSplitPane splitPaneContent;
	private JTable tableRule;
	private JButton buttonAddRule;
	private JButton buttonUpdate;
	private JButton buttonDelete;
	private JComboBox comboboxForm;
	private JLabel jLabel1;
	private JTable tableData;
	private JList jListPath;
	private JScrollPane scrollPaneData;
	private JScrollPane scrollPanePath;
	private JSplitPane splitPaneRight;
	
	private Tbl_Projects project;
	private FrmStep frmStep;
	private DaoFinal daoFinal;
	
	private DefaultTableModel modelRule = new DefaultTableModel();
	private DefaultListModel modelForm = new DefaultListModel();
	private DefaultTableModel modelData = new DefaultTableModel();
	private FrmSelectFieldAndRule frmSelectFieldAndRule;
	private FrmApplyRuleForForm frmApplyRuleForForm;
	private List<FieldNameList> listFieldNameList = new ArrayList<FieldNameList>();
	private List<BeanFinalForm> listForm = new ArrayList<BeanFinalForm>();
	private List<BeanFinalRule> listRule= new ArrayList<BeanFinalRule>();

	private List<String> listColumnTableProof = new ArrayList<String>();
	private JButton buttonApplyRuleForForm;
    private BeanFinalRule beanFinalRule = new BeanFinalRule();

	public FrmAdminFinal(Tbl_Projects project , FrmStep frmStep) {
		super();
		this.daoFinal = new DaoFinal(project);
		this.project = project;
		this.frmStep = frmStep;
		initGUI();
		initData();
	}
	
	private void initGUI() {
		try {
			this.setTitle("Form Admin Process Rule");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			{
				panelHeader = new JPanel();
				AnchorLayout panelHeaderLayout = new AnchorLayout();
				getContentPane().add(panelHeader, new AnchorConstraint(0, 1000, 58, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelHeader.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelHeader.setLayout(panelHeaderLayout);
				panelHeader.setPreferredSize(new java.awt.Dimension(960, 36));
				{
					buttonApplyRuleForForm = new JButton();
					panelHeader.add(buttonApplyRuleForForm, new AnchorConstraint(71, 534, 985, 327, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonApplyRuleForForm.setText("Apply Rule For Form");
					buttonApplyRuleForForm.setPreferredSize(new java.awt.Dimension(212, 32));
					buttonApplyRuleForForm.setFont(new java.awt.Font("Arial",1,14));
					buttonApplyRuleForForm.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							buttonApplyRuleForFormActionPerformed(evt);
						}
					});
				}
				{
					jLabel1 = new JLabel();
					panelHeader.add(jLabel1, new AnchorConstraint(71, 162, 957, 97, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jLabel1.setText("Form : ");
					jLabel1.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					jLabel1.setForeground(new java.awt.Color(0,0,0));
					jLabel1.setFont(new java.awt.Font("Arial",1,14));
					jLabel1.setPreferredSize(new java.awt.Dimension(67, 31));
				}
				{
					comboboxForm = new JComboBox();
					panelHeader.add(comboboxForm, new AnchorConstraint(71, 322, 957, 164, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					comboboxForm.setFont(new java.awt.Font("Arial",1,14));
					comboboxForm.setPreferredSize(new java.awt.Dimension(162, 31));
					comboboxForm.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							comboboxFormActionPerformed(evt);
						}
					});
				}
				{
					buttonDelete = new JButton();
					panelHeader.add(buttonDelete, new AnchorConstraint(42, 998, 928, 915, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonDelete.setText("Delete");
					buttonDelete.setFont(new java.awt.Font("Arial",1,14));
					buttonDelete.setForeground(new java.awt.Color(0,0,255));
					buttonDelete.setPreferredSize(new java.awt.Dimension(85, 31));
					buttonDelete.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							buttonDeleteActionPerformed(evt);
						}
					});
				}
				{
					buttonUpdate = new JButton();
					panelHeader.add(buttonUpdate, new AnchorConstraint(42, 914, 928, 830, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonUpdate.setText("Update");
					buttonUpdate.setFont(new java.awt.Font("Arial",1,14));
					buttonUpdate.setForeground(new java.awt.Color(0,0,255));
					buttonUpdate.setPreferredSize(new java.awt.Dimension(87, 31));
					buttonUpdate.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							buttonUpdateActionPerformed(evt);
						}
					});
				}
				{
					buttonAddRule = new JButton();
					panelHeader.add(buttonAddRule, new AnchorConstraint(39, 829, 934, 738, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonAddRule.setText("Add Rule");
					buttonAddRule.setFont(new java.awt.Font("Arial",1,14));
					buttonAddRule.setForeground(new java.awt.Color(0,0,255));
					buttonAddRule.setPreferredSize(new java.awt.Dimension(107, 34));
					buttonAddRule.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							buttonAddRuleActionPerformed(evt);
						}
					});
				}
				{
					checkboxIsRework = new JCheckBox();
					panelHeader.add(checkboxIsRework, new AnchorConstraint(71, 87, 957, 2, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					checkboxIsRework.setText("Rework");
					checkboxIsRework.setFont(new java.awt.Font("Arial",1,14));
					checkboxIsRework.setForeground(new java.awt.Color(255,0,0));
					checkboxIsRework.setPreferredSize(new java.awt.Dimension(88, 31));
					checkboxIsRework.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							checkboxIsReworkActionPerformed(evt);
						}
					});
				}
			}
			{
				panelContent = new JPanel();
				BorderLayout panelContentLayout = new BorderLayout();
				getContentPane().add(panelContent, new AnchorConstraint(58, 1000, 1000, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelContent.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelContent.setLayout(panelContentLayout);
				panelContent.setPreferredSize(new java.awt.Dimension(960, 583));
				{
					splitPaneContent = new JSplitPane();
					panelContent.add(splitPaneContent, BorderLayout.CENTER);
					{
						panelRight = new JPanel();
						BorderLayout jPanel1Layout = new BorderLayout();
						panelRight.setLayout(jPanel1Layout);
						splitPaneContent.add(panelRight, JSplitPane.RIGHT);
						{
							splitPaneRight = new JSplitPane();
							panelRight.add(splitPaneRight, BorderLayout.CENTER);
							splitPaneRight.setOrientation(JSplitPane.VERTICAL_SPLIT);
							splitPaneRight.setDividerLocation(100);
							{
								panelData = new JPanel();
								BorderLayout panelDataLayout = new BorderLayout();
								panelData.setLayout(panelDataLayout);
								splitPaneRight.add(panelData, JSplitPane.RIGHT);
								panelData.setBorder(BorderFactory.createTitledBorder(null, "Data", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,14), new java.awt.Color(0,0,0)));
								{
									scrollPaneData = new JScrollPane();
									panelData.add(scrollPaneData, BorderLayout.CENTER);
									{
										tableData = new JTable() {
											@Override
											public boolean isCellEditable(int row, int column) {
												return false;
											}
										};
										scrollPaneData.setViewportView(tableData);
									}
								}
							}
							{
								panelPath = new JPanel();
								BorderLayout panelPathLayout = new BorderLayout();
								panelPath.setLayout(panelPathLayout);
								splitPaneRight.add(panelPath, JSplitPane.LEFT);
								panelPath.setPreferredSize(new java.awt.Dimension(600, 150));
								panelPath.setBorder(BorderFactory.createTitledBorder(null, "File Path", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,14), new java.awt.Color(0,0,0)));
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
						panelLeft = new JPanel();
						BorderLayout jPanel2Layout = new BorderLayout();
						panelLeft.setLayout(jPanel2Layout);
						splitPaneContent.add(panelLeft, JSplitPane.LEFT);
						panelLeft.setPreferredSize(new java.awt.Dimension(414, 577));
						panelLeft.setBorder(BorderFactory.createTitledBorder(null, "Rules", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,16), new java.awt.Color(0,0,0)));
						{
							scrollPaneLeft = new JScrollPane();
							panelLeft.add(scrollPaneLeft, BorderLayout.CENTER);
							{
								tableRule = new JTable() {
									@Override
									public boolean isCellEditable(int row,int column) {
										return false;
									}
								};
								tableRule.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
									@Override
									public void valueChanged(ListSelectionEvent e) {
										if(tableRule.getSelectedRow() > -1)
										{
											valueChangeJtable(tableRule.getSelectedRow());
										}
									}
								});
								scrollPaneLeft.setViewportView(tableRule);
							}
						}
					}
				}
			}
			pack();
			this.setSize(1187, 695);
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
			if(frmApplyRuleForForm != null) {
				frmApplyRuleForForm.dispose();
			}
			if(frmSelectFieldAndRule != null) {
				frmSelectFieldAndRule.dispose();
			}
			this.dispose();
			frmStep.setVisible(true);
		}
	}
	
	private void checkboxIsReworkActionPerformed(ActionEvent evt) {
		initData();
	}
	
	
	private void buttonAddRuleActionPerformed(ActionEvent evt) {
		frmSelectFieldAndRule = new FrmSelectFieldAndRule(project, 
				                                          daoFinal,
				                                          listFieldNameList, 
				                                          listColumnTableProof ,
				                                          checkboxIsRework.isSelected(),
				                                          this);
		frmSelectFieldAndRule.setVisible(true);
	}
	
	private void buttonUpdateActionPerformed(ActionEvent evt)
	{
		try {
			if(tableRule.getSelectedRow() > -1) {
				FrmUpdateRule frmUpdateRule = new FrmUpdateRule(project , daoFinal , beanFinalRule , this);
				frmUpdateRule.setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "updateRule : "  + e.toString());
		}
	}
	
	private void buttonApplyRuleForFormActionPerformed(ActionEvent evt) {
		frmApplyRuleForForm = new FrmApplyRuleForForm(project, daoFinal , listRule);
		frmApplyRuleForForm.setVisible(true);
	}
	
	private void buttonDeleteActionPerformed(ActionEvent evt) {
		deleteRule();
	}
	
	private void comboboxFormActionPerformed(ActionEvent evt) {
		loadRule();
	}
	
	//==========================================================================================================
	
	/**
	 * load default data
	 */
	private void initData() {
		try {
			daoFinal.setTable(checkboxIsRework.isSelected());
		    loadForm();
		    loadPath();
		       
		    listFieldNameList    = daoFinal.getListFieldNameList();
		    listColumnTableProof = daoFinal.getListColumnTable();
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "initData : "  + e.toString());
		}

	}
	
	/**
	 * load form
	 */
	private void loadForm() 
	{
		listForm = new ArrayList<BeanFinalForm>();
		try {
			listForm = daoFinal.getListFormRule();
			for (BeanFinalForm beanFinalForm : listForm) {
				comboboxForm.addItem(beanFinalForm);
			}
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "loadForm : "  + e.toString());
		}
	}
	
	/**
	 * load rule
	 */
	public void loadRule() 
	{
		listRule= new ArrayList<BeanFinalRule>();
		try {
			BeanFinalForm beanFinalForm =  (BeanFinalForm) comboboxForm.getSelectedItem();
			listRule = daoFinal.getListRule(beanFinalForm.getForm_rules());
			modelRule = new DefaultTableModel(new String[] {"No." , "Id" , "Rule" , "Condition" , "Field"} , 0);
			Object[] values;
			int index = 1;
			for (BeanFinalRule beanFinalRule : listRule) {
				values = new Object [] { index , 
						                 beanFinalRule.getId() , 
						                 beanFinalRule.getRuleNote() , 
						                 beanFinalRule.getCondition() ,
						                 beanFinalRule.getRuleField()};
				modelRule.addRow(values);
				++index;
			}
			tableRule.setModel(modelRule);
			JTableUtil.styleTable(tableRule, true);
			JTableUtil.setPrefersizeColum(tableRule, 0, 70);
		} 
		catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "loadForm : "  + e.toString());
		}
	}
	
	/**
	 * load path
	 */
	private void loadPath() {
         try {
			List<String> listPath = new ArrayList<String>();
			modelForm = new DefaultListModel();
			listPath = daoFinal.getListPath();
			for (String str : listPath) {
				modelForm.addElement(str);
			}
			jListPath.setModel(modelForm);
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "loadPath : " + e.toString());
		}
	}
	
	public boolean loadData()throws Exception
	{	
		boolean flag = false;
		int row = tableRule.getSelectedRow();
		if(row > -1 && comboboxForm.getSelectedIndex() > -1 && jListPath.getSelectedIndex() > -1 ) {
			try 
			{
				modelData = new DefaultTableModel() {
					@Override
					public Class<?> getColumnClass(int columnIndex) {
						Object value = this.getValueAt(0, columnIndex);
						return (value == null ? Object.class : value.getClass());
					}
				};
				BeanFinalForm beanFinalForm = (BeanFinalForm) comboboxForm.getSelectedItem();
				String filepath = jListPath.getSelectedValue().toString();
				String formName = beanFinalForm.getForm_name();
				String ruleName = JTableUtil.getValuesByHeaderName(tableRule, "Rule", row);
				daoFinal.getData(checkboxIsRework.isSelected(), modelData, beanFinalRule.getRuleField(), formName, ruleName, filepath);
				tableData.setModel(modelData);
				JTableUtil.styleTable(tableData, true);
			} 
			catch (Exception e) 
			{
				flag = false;
				e.printStackTrace();
				throw new Exception("loadData : "  + e.toString());
			}
		}
		return flag;
	}
	
	/**
	 * value change Jtable
	 */
	private void valueChangeJtable(int row) {
        try {
			beanFinalRule = new BeanFinalRule();
			String ruleNote = StringUtil.setNotNull(JTableUtil.getValuesByHeaderName(tableRule, "Rule", row));
			String condition= StringUtil.setNotNull(JTableUtil.getValuesByHeaderName(tableRule, "Condition", row));
			String id= StringUtil.setNotNull(JTableUtil.getValuesByHeaderName(tableRule, "Id", row));
			String field= StringUtil.setNotNull(JTableUtil.getValuesByHeaderName(tableRule, "Field", row));

			beanFinalRule.setId(Integer.parseInt(id));
			beanFinalRule.setRuleNote(ruleNote);
			beanFinalRule.setCondition(condition);
			beanFinalRule.setRuleField(field);
			loadData();
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "valueChangeJtable " + e.toString());
		}
	}

	/**
	 * delete rule
	 */
	private void deleteRule() {
		try {
			int option = AppUtility.msgConfirm(this, "Do you want to delete this rule ?");
			if(option == JOptionPane.OK_OPTION)
			{
				int row = -1;
				row = tableRule.getSelectedRow();
				if(tableRule.getSelectedRow() > -1) {
					String id = StringUtil.setNotNull(JTableUtil.getValuesByHeaderName(tableRule, "Id", row));
	                boolean flag = daoFinal.deleteRuleById(id);
	                if(flag) {
	                	loadRule();
	                	AppUtility.msgInfo(this, "Delete rule successfull !!");
	                }
				}
			}
		}
		catch (Exception e) {
		   e.printStackTrace();
		   AppUtility.msgError(this, "valueChangeJtable " + e.toString());
		}
	}
	
	private void buttonAddAutoRuleActionPerformed(ActionEvent evt) {
		System.out.println("buttonAddAutoRule.actionPerformed, event="+evt);
		//TODO add your code for buttonAddAutoRule.actionPerformed
	}

}
