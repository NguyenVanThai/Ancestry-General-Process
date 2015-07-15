package com.digitexx.ancestry.finals.admin;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.ancestry.bean.BeanDefineRule;
import com.digitexx.ancestry.bean.BeanFinalRule;
import com.digitexx.ancestry.dao.DaoFinal;
import com.digitexx.ancestry.table.render.DefineRuleCellEditor;
import com.digitexx.ancestry.table.render.DefineRuleCellRender;
import com.digitexx.ancestry.table.render.TablePopupEditor;
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
public class FrmSimpleRule extends javax.swing.JFrame {
	private JPanel panelHeader;
	private JPanel panelContent;
	private JTextPane textPaneRuleName;
	private JButton buttonSave;
	private JPanel panelFooter;
	private JTable tableField;
	private JScrollPane scrollPaneField;
	private JScrollPane scrollPaneRuleName;
	private List<String> listField = new ArrayList<String>();
	private DefaultTableModel model = new DefaultTableModel();
	private ButtonGroup buttonGroup;
	private JRadioButton radioAnd;
	private JRadioButton radioOr;
	private List<BeanDefineRule> listDefineRule = new ArrayList<BeanDefineRule>();
	private Map<String , BeanDefineRule> mapDefineRule = new HashMap<String , BeanDefineRule>();
	private DaoFinal daoFinal;
	private FrmAdminFinal frmAdminFinal;
	private int group_rule =0;
	private String or_and = " OR ";

	public FrmSimpleRule(List<String> listField , DaoFinal daoFinal , int group_rule ,FrmAdminFinal frmAdminFinal) {
		super();
		this.listField = listField;
		this.daoFinal  = daoFinal;
		this.group_rule = group_rule;
		this.frmAdminFinal = frmAdminFinal;
		initGUI();
		initData();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			{
				panelHeader = new JPanel();
				AnchorLayout panelHeaderLayout = new AnchorLayout();
				panelHeader.setLayout(panelHeaderLayout);
				getContentPane().add(panelHeader, new AnchorConstraint(1, 1000, 162, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelHeader.setBorder(BorderFactory.createTitledBorder(null, "Rule Name", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,14)));
				panelHeader.setPreferredSize(new java.awt.Dimension(585, 64));
				{
					scrollPaneRuleName = new JScrollPane();
					panelHeader.add(scrollPaneRuleName, new AnchorConstraint(304, 992, 929, 9, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					scrollPaneRuleName.setPreferredSize(new java.awt.Dimension(575, 40));
					{
						textPaneRuleName = new JTextPane();
						scrollPaneRuleName.setViewportView(textPaneRuleName);
						textPaneRuleName.setFont(new java.awt.Font("Arial",0,18));
					}
				}
			}
			{
				panelContent = new JPanel();
				BorderLayout panelContentLayout = new BorderLayout();
				panelContent.setLayout(panelContentLayout);
				getContentPane().add(panelContent, new AnchorConstraint(162, 1000, 920, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelContent.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelContent.setPreferredSize(new java.awt.Dimension(585, 300));
				{
					scrollPaneField = new JScrollPane();
					panelContent.add(scrollPaneField, BorderLayout.CENTER);
					{
						tableField = new JTable() 
						{
							@Override
							public boolean isCellEditable(int row, int column) {
								if(getColumnName(column).equals("No.") || getColumnName(column).equals("Field Name")) {
									return false;
								}else {
									return true;
								}
							}
						};
//						tableField.addMouseListener(new java.awt.event.MouseAdapter() {
//						    @Override
//						    public void mouseClicked(java.awt.event.MouseEvent evt) {
//						        int row = tableField.rowAtPoint(evt.getPoint());
//						        int col = tableField.columnAtPoint(evt.getPoint());
//						        mouseClickJtable(row, col);
//						    }
//						});
						scrollPaneField.setViewportView(tableField);
					}
				}
			}
			{
				panelFooter = new JPanel();
				AnchorLayout panelFooterLayout = new AnchorLayout();
				getContentPane().add(panelFooter, new AnchorConstraint(917, 1000, 998, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelFooter.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelFooter.setLayout(panelFooterLayout);
				panelFooter.setPreferredSize(new java.awt.Dimension(585, 32));
				{
					buttonSave = new JButton();
					panelFooter.add(getRadioAnd(), new AnchorConstraint(54, 238, 967, 92, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					panelFooter.add(getRadioOr(), new AnchorConstraint(54, 82, 967, 2, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					panelFooter.add(buttonSave, new AnchorConstraint(54, 998, 923, 873, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonSave.setText("Save");
					buttonSave.setFont(new java.awt.Font("Arial",1,18));
					buttonSave.setPreferredSize(new java.awt.Dimension(129, 40));
					buttonSave.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							buttonSaveActionPerformed(evt);
						}
					});
				}
			}
			pack();
			this.setSize(1042, 604);
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
	
	
	private JRadioButton getRadioOr() {
		if(radioOr == null) {
			radioOr = new JRadioButton();
			radioOr.setText("OR");
			radioOr.setPreferredSize(new java.awt.Dimension(83, 42));
			radioOr.setFont(new java.awt.Font("Arial",1,18));
			radioOr.isSelected();
			radioOr.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					radioOrActionPerformed(evt);
				}
			});
		}
		return radioOr;
	}
	
	private JRadioButton getRadioAnd() {
		if(radioAnd == null) {
			radioAnd = new JRadioButton();
			radioAnd.setText("AND");
			radioAnd.setPreferredSize(new java.awt.Dimension(151, 42));
			radioAnd.setFont(new java.awt.Font("Arial",1,18));
			radioAnd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					radioAndActionPerformed(evt);
				}
			});
		}
		return radioAnd;
	}
	
	private ButtonGroup getButtonGroup() {
		if(buttonGroup == null) {
			buttonGroup = new ButtonGroup();
		}
		return buttonGroup;
	}
	
	
	private void radioOrActionPerformed(ActionEvent evt) {
		or_and = " OR ";
	}
	
	private void radioAndActionPerformed(ActionEvent evt) {
		or_and = " AND ";
	}
	
	private void exit() {
		this.dispose();
	}
	
	//----------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * init data
	 */
	private void initData() {
		try {
			listDefineRule = new ArrayList<BeanDefineRule>();
			listDefineRule = daoFinal.getListDefineRule(group_rule);
			for (BeanDefineRule beanDefineRule : listDefineRule) {
				mapDefineRule.put(beanDefineRule.getRule_name(), beanDefineRule);
			}
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "initData");
		}
	}
	
	/**
	 * get list condition
	 */
	private List<String> getListCondition() {
		List<String> listCondition = new ArrayList<String>();
        for (BeanDefineRule beanDefineRule : listDefineRule) {
			listCondition.add(beanDefineRule.getRule_name());
		}
		return listCondition;
	}
	
	/**
	 * load field
	 */
	public void loadField()
	{
		String [] headers = new String [] {"No." , "Field Name" , "Condition" , "Field Value"};
        model = new DefaultTableModel(headers , 0);	
        Object [] values;
        int index = 1;
        
        for (String str : listField) {
			values = new Object [] { index , str , "" , "" };
			model.addRow(values);
			++index;
		}
        tableField.setRowHeight(50);
        tableField.setModel(model);
        
        TableColumn col = tableField.getColumnModel().getColumn(2);
        col.setCellEditor(new DefineRuleCellEditor(listDefineRule , mapDefineRule , this));
        col.setCellRenderer(new DefineRuleCellRender());
        
        int idx = tableField.getColumnModel().getColumnIndex("Field Value");
		TablePopupEditor popupEditor = new TablePopupEditor("Field Value");
		tableField.getColumnModel().getColumn(idx).setCellEditor(popupEditor);
		
        JTableUtil.styleTable(tableField, true);
        setSizeTable();
	}
	
	/**
	 * set size column
	 */
	private void setSizeTable() {
        JTableUtil.setPrefersizeColum(tableField, 0, 70);
        JTableUtil.setPrefersizeColum(tableField, 1, 100);
        JTableUtil.setPrefersizeColum(tableField, 2, 250);
        JTableUtil.setPrefersizeColum(tableField, 3, 500);
	}
	
	
	private void buttonSaveActionPerformed(ActionEvent evt) 
	{
		int totalRow = tableField.getRowCount();
		try {
			if(totalRow >0) 
			{
				String fieldName = "";
				String fieldValue = "";
				String condition ="";
				StringBuilder sbCondition = new StringBuilder("(");
				StringBuilder sbField = new StringBuilder("managementid, formid ,filepath, filename, seq_number, user_type ,");
				
				BeanFinalRule beanFinalRule = new BeanFinalRule() ;
				for (int row = 0; row < totalRow; row++) 
				{
					fieldName  = JTableUtil.getValuesByHeaderName(tableField, "Field Name", row);
					fieldValue = StringUtil.setNotNull(JTableUtil.getValuesByHeaderName(tableField, "Field Value", row));
					condition  = JTableUtil.getValuesByHeaderName(tableField, "Condition", row);
					if(!fieldValue.equals("")) {
						if(row > 0) {
							sbCondition.append(or_and);
						}
						sbCondition.append(fieldValue);
					}
                    if(row >0) {
                    	sbField.append(",");
                    }
                    sbField.append(fieldName);
				}
				sbCondition.append(")");
				beanFinalRule.setRuleName(textPaneRuleName.getText());
				beanFinalRule.setRuleNote(textPaneRuleName.getText());
				beanFinalRule.setRuleField(sbField.toString());
				beanFinalRule.setCondition(sbCondition.toString());
				boolean flag = daoFinal.saveRule(beanFinalRule);
				if(flag) {
					frmAdminFinal.loadRule();
					AppUtility.msgError(this, "Add new rule successfull !!");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this ,"buttonSaveActionPerformed : "  + e.toString());
		}
	}



}
