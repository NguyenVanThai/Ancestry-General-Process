package com.digitexx.ancestry.finals.admin;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.ancestry.bean.BeanFinalRule;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.dao.DaoFinal;
import com.digitexx.ancestry.util.AppUtility;
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
public class FrmUpdateRule extends javax.swing.JFrame {
	private JPanel panelRuleName;
	private JPanel panelCondition;
	private JTextPane textPaneRuleNote;
	private JTextPane textPaneCondition;
	private JButton butttonSave;
	private JScrollPane scrollPaneRuleNote;
	private JScrollPane scrollPaneRuleName;
	private JPanel panelFooter;
	private JTextPane textPaneField;
	private JScrollPane scrollPaneField;
	private FrmAdminFinal frmAdminFinal;
	private Tbl_Projects project;
	private JPanel panelField;
	private DaoFinal daoFinal;
	private BeanFinalRule beanFinalRule;
	private boolean isInsert = false;

	/*for insert new rule*/
	public FrmUpdateRule(Tbl_Projects project , DaoFinal daoFinal , FrmAdminFinal frmAdminFinal) {
		super();
		this.project = project;
		this.daoFinal = daoFinal;
		this.frmAdminFinal = frmAdminFinal;
		this.isInsert = true;
		initGUI();
		textPaneField.setText("managementid, formid ,filepath, filename, seq_number, user_type ,");
	}
	
	/*for update rule*/
	public FrmUpdateRule(Tbl_Projects project , DaoFinal daoFinal , BeanFinalRule beanFinalRule , FrmAdminFinal frmAdminFinal) {
		super();
		this.project = project;
		this.daoFinal = daoFinal;
		this.beanFinalRule = beanFinalRule;
		this.frmAdminFinal = frmAdminFinal;
		this.isInsert = false;
		initGUI();
		initData();
	}
	
	private void initGUI() {
		try {
			this.setTitle("Form Admin Update Rule");
			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			{
				panelField = new JPanel();
				BorderLayout panelFieldLayout = new BorderLayout();
				panelField.setLayout(panelFieldLayout);
				getContentPane().add(panelField, new AnchorConstraint(712, 1000, 931, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelField.setPreferredSize(new java.awt.Dimension(596, 94));
				panelField.setBorder(BorderFactory.createTitledBorder(null, "Field", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,16), new java.awt.Color(255,0,0)));
				{
					scrollPaneField = new JScrollPane();
					panelField.add(scrollPaneField, BorderLayout.CENTER);
					{
						textPaneField = new JTextPane();
						scrollPaneField.setViewportView(textPaneField);
						textPaneField.setFont(new java.awt.Font("Arial",0,16));
					}
				}
			}
			{
				panelRuleName = new JPanel();
				AnchorLayout panelRuleNameLayout = new AnchorLayout();
				panelRuleName.setLayout(panelRuleNameLayout);
				getContentPane().add(panelRuleName, new AnchorConstraint(1, 1000, 187, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelRuleName.setBorder(BorderFactory.createTitledBorder(null, "Rule Note", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,16), new java.awt.Color(255,0,0)));
				panelRuleName.setPreferredSize(new java.awt.Dimension(596, 80));
				{
					scrollPaneRuleName = new JScrollPane();
					panelRuleName.add(scrollPaneRuleName, new AnchorConstraint(268, 992, 943, 9, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					scrollPaneRuleName.setPreferredSize(new java.awt.Dimension(586, 54));
					{
						textPaneRuleNote = new JTextPane();
						scrollPaneRuleName.setViewportView(textPaneRuleNote);
						textPaneRuleNote.setFont(new java.awt.Font("Arial",0,16));
					}
				}
			}
			{
				panelCondition = new JPanel();
				AnchorLayout panelRuleNoteLayout = new AnchorLayout();
				panelCondition.setLayout(panelRuleNoteLayout);
				getContentPane().add(panelCondition, new AnchorConstraint(187, 1000, 712, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelCondition.setBorder(BorderFactory.createTitledBorder(null, "Condition", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,16), new java.awt.Color(255,0,0)));
				panelCondition.setPreferredSize(new java.awt.Dimension(596, 226));
				{
					scrollPaneRuleNote = new JScrollPane();
					panelCondition.add(scrollPaneRuleNote, new AnchorConstraint(67, 992, 985, 9, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					scrollPaneRuleNote.setPreferredSize(new java.awt.Dimension(586, 294));
					{
						textPaneCondition = new JTextPane();
						scrollPaneRuleNote.setViewportView(textPaneCondition);
						textPaneCondition.setFont(new java.awt.Font("Arial",0,16));
					}
				}
			}
			{
				panelFooter = new JPanel();
				AnchorLayout panelFooterLayout = new AnchorLayout();
				getContentPane().add(panelFooter, new AnchorConstraint(929, 1000, 1001, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelFooter.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelFooter.setLayout(panelFooterLayout);
				panelFooter.setPreferredSize(new java.awt.Dimension(596, 31));
				{
					butttonSave = new JButton();
					panelFooter.add(butttonSave, new AnchorConstraint(80, 177, 951, 4, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					butttonSave.setText("Save");
					butttonSave.setFont(new java.awt.Font("Arial",1,14));
					butttonSave.setForeground(new java.awt.Color(0,0,255));
					butttonSave.setPreferredSize(new java.awt.Dimension(103, 27));
					butttonSave.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							butttonSaveActionPerformed(evt);
						}
					});
				}
			}
			pack();
			this.setSize(604, 464);
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
	
	private void butttonSaveActionPerformed(ActionEvent evt) {
		saveRule();
	}
	
	//--------------------------------------------------------------------------------------------------------------------
	
	/**
	 * init data
	 */
	private void initData() {
        textPaneRuleNote.setText(beanFinalRule.getRuleNote());
        textPaneCondition.setText(beanFinalRule.getCondition());
        textPaneField.setText(beanFinalRule.getRuleField());
	}
	
	/**
	 * update rule
	 */
	private void saveRule() {
		boolean flag = false;
		try {
			String ruleNote = StringUtil.setNotNull(textPaneRuleNote.getText());
			String condition = StringUtil.setNotNull(textPaneCondition.getText());
			String ruleField = StringUtil.setNotNull(textPaneField.getText());
			if(ruleField.equals("")) {
				textPaneRuleNote.requestFocus();
				AppUtility.msgError(this, "Nhập rule note !!");
			}else if(condition.equals("")) {
				textPaneCondition.requestFocus();
				AppUtility.msgError(this, "Nhập condition !!");
			}else if(ruleField.equals("")) {
				textPaneField.requestFocus();
				AppUtility.msgError(this, "Nhập field !!");
			}else {
				BeanFinalRule beanTmp = new BeanFinalRule();
				beanTmp.setRuleNote(ruleNote);
				beanTmp.setCondition(condition);
				beanTmp.setRuleField(ruleField);
				if(!isInsert) {
					beanTmp.setId(beanFinalRule.getId());
					flag = daoFinal.updateRule(beanTmp);
				}else {
					beanTmp.setRuleName(ruleNote);
					flag = daoFinal.saveRule(beanTmp);
				}
				if(flag) 
				{
					frmAdminFinal.loadRule();
					AppUtility.msgInfo(this, "Save rule successfull !!");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "updateRule : "  + e.toString());
		}
	}
	
	

}
