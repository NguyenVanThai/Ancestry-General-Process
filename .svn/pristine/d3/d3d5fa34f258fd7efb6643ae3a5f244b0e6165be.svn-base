package com.digitexx.ancestry.finals.admin;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.digitexx.ancestry.bean.BeanFinalForm;
import com.digitexx.ancestry.bean.BeanFinalRule;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.dao.DaoFinal;
import com.digitexx.ancestry.table.render.ButtonEditor;
import com.digitexx.ancestry.table.render.ButtonRenderer;
import com.digitexx.ancestry.util.AppUtility;
import com.digitexx.ancestry.util.JTableUtil;

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
public class FrmApplyRuleForForm extends javax.swing.JFrame {
	private JSplitPane splitPaneMain;
	private JPanel panelBottom;
	private JTable tableAllRule;
	private JTable tableRuleOfForm;
	private JList jListForm;
	private JScrollPane scrollPaneRule;
	private JScrollPane scrollPaneForm;
	private JScrollPane scrollPaneTop;
	private JPanel panelForm;
	private JPanel panelRule;
	private JSplitPane splitPaneBottom;
	private JPanel panelTop;
	
	private Tbl_Projects project ;
	private DaoFinal daoFinal;
	private List<BeanFinalRule> listAllRule = new ArrayList<BeanFinalRule>() ;
	private List<BeanFinalRule> listRuleByForm = new ArrayList<BeanFinalRule>() ;
	private DefaultListModel modelForm = new DefaultListModel();
	private DefaultTableModel modelAllRule = new DefaultTableModel();
	private DefaultTableModel modelRuleForm = new DefaultTableModel();
	private BeanFinalForm beanCurrentForm = new BeanFinalForm();
	
	public FrmApplyRuleForForm(Tbl_Projects project , DaoFinal daoFinal , List<BeanFinalRule> listAllRule) {
		super();
		this.project = project;
		this.daoFinal = daoFinal;
		this.listAllRule = listAllRule;
		initGUI();
		initData();
	}
	
	private void initGUI() {
		try {
			this.setTitle("Form Drag And Drop Rule For Form");
			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			{
				splitPaneMain = new JSplitPane();
				getContentPane().add(splitPaneMain, new AnchorConstraint(0, 1000, 1000, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				splitPaneMain.setOrientation(JSplitPane.VERTICAL_SPLIT);
				splitPaneMain.setDividerLocation(200);
				splitPaneMain.setPreferredSize(new java.awt.Dimension(803, 522));
				{
					panelBottom = new JPanel();
					BorderLayout panelBottomLayout = new BorderLayout();
					panelBottom.setLayout(panelBottomLayout);
					splitPaneMain.add(panelBottom, JSplitPane.RIGHT);
					{
						splitPaneBottom = new JSplitPane();
						panelBottom.add(splitPaneBottom, BorderLayout.CENTER);
						{
							panelRule = new JPanel();
							BorderLayout panelRuleLayout = new BorderLayout();
							panelRule.setLayout(panelRuleLayout);
							splitPaneBottom.add(panelRule, JSplitPane.RIGHT);
							panelRule.setBorder(BorderFactory.createTitledBorder(null, "Rule For Form", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,14), new java.awt.Color(0,0,255)));
							{
								scrollPaneRule = new JScrollPane();
								panelRule.add(scrollPaneRule, BorderLayout.CENTER);
								{
									tableRuleOfForm = new JTable() {
										
										@Override
										public boolean isCellEditable(int row,int column) {
											if(getColumnName(column).equals("Delete")) {
												return true;
											}else {
												return false;
											}
										}
									};
									tableRuleOfForm.addMouseListener(new java.awt.event.MouseAdapter() {
									    @Override
									    public void mouseClicked(java.awt.event.MouseEvent evt) {
									        int row = tableRuleOfForm.rowAtPoint(evt.getPoint());
                                            if(row > -1) {
                                            	deleteRule(row);
                                            }
									    }
									});
									scrollPaneRule.setViewportView(tableRuleOfForm);
								}
							}
						}
						{
							panelForm = new JPanel();
							BorderLayout jPanel2Layout = new BorderLayout();
							panelForm.setLayout(jPanel2Layout);
							splitPaneBottom.add(panelForm, JSplitPane.LEFT);
							panelForm.setPreferredSize(new java.awt.Dimension(191, 326));
							panelForm.setBorder(BorderFactory.createTitledBorder(null, "Form", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,14), new java.awt.Color(0,0,255)));
							{
								scrollPaneForm = new JScrollPane();
								panelForm.add(scrollPaneForm, BorderLayout.CENTER);
								{
									jListForm = new JList();
									scrollPaneForm.setViewportView(jListForm);
									jListForm.setFont(new java.awt.Font("Arial",1,16));
									jListForm.addListSelectionListener(new ListSelectionListener() {
										public void valueChanged(ListSelectionEvent evt) {
											jListFormValueChanged(evt);
										}
									});
								}
							}
						}
					}
				}
				{
					panelTop = new JPanel();
					BorderLayout panelTopLayout = new BorderLayout();
					panelTop.setLayout(panelTopLayout);
					splitPaneMain.add(panelTop, JSplitPane.LEFT);
					panelTop.setPreferredSize(new java.awt.Dimension(801, 185));
					panelTop.setBorder(BorderFactory.createTitledBorder(null, "List All Rules", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,14), new java.awt.Color(0,0,255)));
					{
						scrollPaneTop = new JScrollPane();
						panelTop.add(scrollPaneTop, BorderLayout.CENTER);
						{
							tableAllRule = new JTable() {
								@Override
								public boolean isCellEditable(int row,int column) {
									if(getColumnName(column).equals("Assign")) {
										return true;
									}else {
										return false;
									}
								}
							};
							tableAllRule.addMouseListener(new java.awt.event.MouseAdapter() {
							    @Override
							    public void mouseClicked(java.awt.event.MouseEvent evt) {
							        int row = tableAllRule.rowAtPoint(evt.getPoint());
							        int col = tableAllRule.columnAtPoint(evt.getPoint());
                                    if(row > -1 && col ==3) {
                                    	assignRuleForForm(row);
                                    }
							    }
							});
							scrollPaneTop.setViewportView(tableAllRule);
						}
					}
				}
			}
			pack();
			this.setSize(811, 556);
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
		this.dispose();
	}
	
	private void jListFormValueChanged(ListSelectionEvent evt) {
		if(!evt.getValueIsAdjusting()) {
			loadRuleByForm();
		}
	}
	
	/**
	 * init data
	 */
	private void initData() {
       loadAllRule(true);
       loadForm();
	}
	
	//--------------------------------------------------------------------------------------------------------------------

	/**
	 * set size table
	 */
	private void setSizeTable(JTable table) {
        JTableUtil.setPrefersizeColum(table, 0, 70);
        JTableUtil.setPrefersizeColum(table, 1, 70);
        JTableUtil.setPrefersizeColum(table, 2, 400);
        JTableUtil.setPrefersizeColum(table, 3, 80);
	}
	
	/**
	 * load all rule
	 */
	private void loadAllRule(boolean isInForm) {
		try {
			modelAllRule = new DefaultTableModel(new String [] {"No." , "Id" , "Rule" , "Assign"} ,0);
			int index =1;
			Object [] values;
			List<BeanFinalRule> listRule = new ArrayList<BeanFinalRule>();
			if(!isInForm) {
				listRule = new ArrayList<BeanFinalRule>();
				listRule = daoFinal.getListRuleByForm(beanCurrentForm, false);

			}else {
				listRule.addAll(listAllRule);
			}
			for (BeanFinalRule beanFinalRule : listRule) {
				values = new Object [] { index , beanFinalRule.getId() ,beanFinalRule.getRuleNote() ,"" };
				modelAllRule.addRow(values);
				++index;
			}
			tableAllRule.setModel(modelAllRule);
			tableAllRule.getColumn("Assign").setCellRenderer(new ButtonRenderer("Assign"));
			tableAllRule.getColumn("Assign").setCellEditor(new ButtonEditor("Assign",new JCheckBox(), this));
			JTableUtil.styleTable(tableAllRule, true);
			setSizeTable(tableAllRule);
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "loadAllRule : "  + e.toString());
		}
	}
	
	
	/**
	 * load all form
	 */
	private void loadForm() {
		try {
			List<String> listForm = daoFinal.getListForm();
			AppUtility.loadDataJList(jListForm, modelForm, listForm);
		} 
		catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "loadForm : "  + e.toString());
		}
	}
	

	/**
	 * load all rule
	 */
	private void loadRuleByForm()
	{
		if(jListForm.getSelectedIndex() > -1) 
		{
			try {
				beanCurrentForm = new BeanFinalForm();
				String formName = jListForm.getSelectedValue().toString();
				beanCurrentForm = daoFinal.getBeanFinalFormByName(formName);
				if(!beanCurrentForm.getForm_name().equals("")) {
					modelRuleForm  = new DefaultTableModel(new String [] {"No." , "Id" , "Rule" , "Delete"} ,0);
					listRuleByForm = new ArrayList<BeanFinalRule>();
					listRuleByForm = daoFinal.getListRuleByForm(beanCurrentForm , true);
					int index =1;
					Object [] values;
					for (BeanFinalRule beanFinalRule : listRuleByForm) {
						values = new Object [] { index , beanFinalRule.getId() ,beanFinalRule.getRuleNote() ,"" };
						modelRuleForm.addRow(values);
						++index;
					}
					tableRuleOfForm.setModel(modelRuleForm);
					tableRuleOfForm.getColumn("Delete").setCellRenderer(new ButtonRenderer("Delete"));
					tableRuleOfForm.getColumn("Delete").setCellEditor(new ButtonEditor("Delete",new JCheckBox(), this));
					JTableUtil.styleTable(tableRuleOfForm, true);
					setSizeTable(tableRuleOfForm);
					loadAllRule(false);
				}else {
					loadAllRule(true);
					JTableUtil.removeAllRow(tableRuleOfForm);
				}

			} catch (Exception e) {
				e.printStackTrace();
				AppUtility.msgError(this, "loadRuleByForm : "  + e.toString());
			}
		}

	}
	
	
	/**
	 * assign rule for form
	 */
	private void assignRuleForForm(int row) {
		boolean flag = false;
		try {
			if(jListForm.getSelectedIndex()  >-1) {
				String id = "";
				String formRule ="";
				String formName = jListForm.getSelectedValue().toString();
				id = JTableUtil.getValuesByHeaderName(tableAllRule, "Id", row);
				
				BeanFinalForm beanFinalForm = new BeanFinalForm();
				formRule = JTableUtil.getValuesByHeaderName(tableAllRule, "Rule", row);
			    if(beanCurrentForm.getId() ==0) {
			    	formRule = "(" + id +")";
					beanFinalForm.setForm_rules(formRule);
					beanFinalForm.setForm_name(formName);
					formName = formName.replace("Form ", "").trim();
					beanFinalForm.setForm_ids("(" + formName + ")");
					beanFinalForm.setId(Integer.parseInt(formName));
					
					flag = daoFinal.saveFormRule(beanFinalForm);
				}else {
					formRule = beanCurrentForm.getForm_rules();
					formRule = formRule.replace(")", "");
					formRule = formRule + "," + id + ")";
					beanFinalForm.setForm_rules(formRule);
					 
					beanFinalForm.setId(beanCurrentForm.getId());
					flag = daoFinal.updateFormRule(beanFinalForm);
				 }
			    if(flag) {
			    	loadRuleByForm();
			    	loadAllRule(false);
			    	AppUtility.msgInfo(this, "Assign rule successfull !!" );
			    }
			}else {
				AppUtility.msgError(this, "Please select form !!");
			}

			
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "assignRuleForForm : "  + e.toString());
		}
	}
	
	/**
	 * delete rule of form
	 */
	private void deleteRule(int row) {
		try {
			if(tableRuleOfForm.getRowCount() > 0 && jListForm.getSelectedIndex() > -1) {
				String id = JTableUtil.getValuesByHeaderName(tableRuleOfForm, "Id", row);
			    String formRule = beanCurrentForm.getForm_rules();
			    formRule = formRule.replace("," +id, "");
			    
			    BeanFinalForm beanFinalForm = new BeanFinalForm();
			    beanFinalForm.setId(beanCurrentForm.getId());
			    beanFinalForm.setForm_rules(formRule);
			    boolean flag = daoFinal.updateFormRule(beanFinalForm);
			    if(flag) {
			    	loadRuleByForm();
			    	AppUtility.msgInfo(this, "Update rule for form successfull !!");
			    }
			}
		} 
	    catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "deleteRule : "  + e.toString());
		}
	}


}
