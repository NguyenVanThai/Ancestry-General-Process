package com.digitexx.ancestry.finals.admin;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DebugGraphics;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.ancestry.bean.BeanFinalRule;
import com.digitexx.ancestry.bean.FieldNameList;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.conts.GroupOfRule;
import com.digitexx.ancestry.conts.RuleStatus;
import com.digitexx.ancestry.dao.DaoFinal;
import com.digitexx.ancestry.table.render.HeaderCheckBoxHandler;
import com.digitexx.ancestry.table.render.HeaderRenderer;
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
public class FrmSelectFieldAndRule extends javax.swing.JFrame {
	private JPanel panelContent;
	private JPanel panelFooter;
	private JPanel panelRight;
	private JPanel panelLeft;
	private JRadioButton radioRuleGivenFatherMother;
	private JButton buttonAddRuleManual;
	private JRadioButton radioRuleGivenSurnameAliasSurname;
	private JRadioButton radioNameAndGender;
	private JRadioButton radioRuleAgeAndAnotherField;
	private JRadioButton radioRuleForAge;
	private JRadioButton radioAutoRuleYearByFolder;
	private JRadioButton radioRuleForDayMonthYear;
	private JButton Search;
	private JTextField textFieldSearch;
	private JLabel jLabel1;
	private JPanel panelSearch;
	private JRadioButton radioRuleDifferencesColumns;
	private JRadioButton radioRuleForStatusGiven;
	private JButton buttonCreate;
	private JRadioButton radioRuleCheckInListNonUpper;
	private JRadioButton radioRuleCheckInListDoNotWrite;
	private ButtonGroup buttonGroup;
	private JRadioButton radioRuleForAnrede;
	private JRadioButton radioRuleCertificateNumber;
	private JRadioButton radioCompareDates;
	private JRadioButton radioSimpleRule;
	private JTable tableField;
	private JScrollPane scrollPaneLeft;
	private JSplitPane splitPaneContent;
	private Tbl_Projects project;
	private DefaultTableModel model;
    private FrmSimpleRule frmSimpleRule;
	
	private DaoFinal daoFinal;
	private List<String> listDontWrite;
	private List<String> listNonUpper;
	private List<String> listFieldSelect = new ArrayList<String>();
	private List<FieldNameList> listFieldNameList   = new ArrayList<FieldNameList>();
	private List<String> listColumnProof = new ArrayList<String>();
	private FrmAdminFinal frmAdminFinal;
	private FrmUpdateRule frmUpdateRule;
	private int group_rule =0;
	private boolean isAutoRule = false;

	public FrmSelectFieldAndRule(Tbl_Projects project , 
			                    DaoFinal daoFinal , 
			                    List<FieldNameList> listFieldNameList, 
			                    List<String> listColumnProof ,
			                    boolean isRework,
			                    FrmAdminFinal frmAdminFinal) {
		super();
		this.project           = project;
		this.listFieldNameList = listFieldNameList;
		this.listColumnProof   = listColumnProof;
		this.daoFinal          = daoFinal;
		this.frmAdminFinal     = frmAdminFinal;
		initGUI();
		initDataFromTableProof(RuleStatus.none);
		group_rule  = GroupOfRule.group1;
	}
	
	private void initGUI() {
		try {
			this.setTitle("Form Select Field & Rule");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			{
				panelContent = new JPanel();
				BorderLayout panelContentLayout = new BorderLayout();
				panelContent.setLayout(panelContentLayout);
				getContentPane().add(getPanelSearch(), new AnchorConstraint(0, 1000, 49, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				getContentPane().add(panelContent, new AnchorConstraint(45, 1000, 942, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelContent.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelContent.setPreferredSize(new java.awt.Dimension(904, 536));
				{
					splitPaneContent = new JSplitPane();
					panelContent.add(splitPaneContent, BorderLayout.CENTER);
					splitPaneContent.setDividerLocation(500);
					{
						panelRight = new JPanel();
						BoxLayout panelRightLayout = new BoxLayout(panelRight, javax.swing.BoxLayout.Y_AXIS);
						panelRight.setLayout(panelRightLayout);
						splitPaneContent.add(panelRight, JSplitPane.RIGHT);
						{
							radioSimpleRule = new JRadioButton();
							panelRight.add(radioSimpleRule);
							radioSimpleRule.setText("Simple Rule");
							radioSimpleRule.setFont(new java.awt.Font("Arial",0,18));
							radioSimpleRule.setSelected(true);
							getButtonGroup().add(radioSimpleRule);
							radioSimpleRule.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
							radioSimpleRule.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									radioSimpleRuleActionPerformed(evt);
								}
							});
						}
						{
							radioCompareDates = new JRadioButton();
							panelRight.add(radioCompareDates);
							radioCompareDates.setText("Compare Dates");
							radioCompareDates.setFont(new java.awt.Font("Arial",0,18));
							radioCompareDates.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
							getButtonGroup().add(radioCompareDates);
							radioCompareDates.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									radioCompareDatesActionPerformed(evt);
								}
							});
						}
						{
							radioRuleForAnrede = new JRadioButton();
							panelRight.add(radioRuleForAnrede);
							radioRuleForAnrede.setText("Rule For Anrede");
							radioRuleForAnrede.setFont(new java.awt.Font("Arial",0,18));
							radioRuleForAnrede.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
							getButtonGroup().add(radioRuleForAnrede);
							radioRuleForAnrede.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									radioRuleForAnredeActionPerformed(evt);
								}
							});
						}
						{
							radioRuleCheckInListDoNotWrite = new JRadioButton();
							panelRight.add(radioRuleCheckInListDoNotWrite);
							radioRuleCheckInListDoNotWrite.setText("Rule Check In List Dont Write");
							radioRuleCheckInListDoNotWrite.setFont(new java.awt.Font("Arial",0,18));
							radioRuleCheckInListDoNotWrite.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
							getButtonGroup().add(radioRuleCheckInListDoNotWrite);
							radioRuleCheckInListDoNotWrite.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									radioRuleCheckInListDoNotWriteActionPerformed(evt);
								}
							});
						}
						{
							radioRuleCheckInListNonUpper = new JRadioButton();
							panelRight.add(radioRuleCheckInListNonUpper);
							panelRight.add(getRadioRuleForStatusGiven());
							panelRight.add(getRadioRuleDifferencesColumns());
							panelRight.add(getRadioRuleForDayMonthYear());
							{
								radioRuleCertificateNumber = new JRadioButton();
								panelRight.add(getRadioRuleForAge());
								panelRight.add(getRadioRuleAgeAndAnotherField());
								panelRight.add(getRadioNameAndGender());
								panelRight.add(getRadioRuleGivenSurnameAliasSurname());
								panelRight.add(getRadioRuleGivenFatherMother());
								panelRight.add(radioRuleCertificateNumber);
								panelRight.add(getRadioAutoRuleYearByFolder());
								radioRuleCertificateNumber.setText("Auto Rule Certificate Number");
								radioRuleCertificateNumber.setFont(new java.awt.Font("Arial",0,18));
								radioRuleCertificateNumber.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
								radioRuleCertificateNumber.setForeground(new java.awt.Color(255,0,0));
								getButtonGroup().add(radioRuleCertificateNumber);
								radioRuleCertificateNumber.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										radioRuleCertificateNumberActionPerformed(evt);
									}
								});
							}
							radioRuleCheckInListNonUpper.setText("Check In List Non Upper");
							radioRuleCheckInListNonUpper.setFont(new java.awt.Font("Arial",0,18));
							radioRuleCheckInListNonUpper.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
							getButtonGroup().add(radioRuleCheckInListNonUpper);
							radioRuleCheckInListNonUpper.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									radioRuleCheckInListNonUpperActionPerformed(evt);
								}
							});
						}
					}
					{
						panelLeft = new JPanel();
						BorderLayout panelLeftLayout = new BorderLayout();
						panelLeft.setLayout(panelLeftLayout);
						splitPaneContent.add(panelLeft, JSplitPane.LEFT);
						panelLeft.setPreferredSize(new java.awt.Dimension(607, 557));
						{
							scrollPaneLeft = new JScrollPane();
							panelLeft.add(scrollPaneLeft, BorderLayout.CENTER);
							scrollPaneLeft.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
							{
								tableField = new JTable() {
									@Override
									public boolean isCellEditable(int row,int column) {
										if(getColumnName(column).equals("Check")) {
											return true;
										}else {
											return false;
										}
									}
								};
								scrollPaneLeft.setViewportView(tableField);
							}
						}
					}
				}
			}
			{
				panelFooter = new JPanel();
				AnchorLayout panelFooterLayout = new AnchorLayout();
				getContentPane().add(panelFooter, new AnchorConstraint(942, 1000, 1000, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelFooter.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelFooter.setLayout(panelFooterLayout);
				panelFooter.setPreferredSize(new java.awt.Dimension(904, 35));
				panelFooter.add(getButtonAddRuleManual(), new AnchorConstraint(128, 200, 985, 1, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelFooter.add(getButtonCreate(), new AnchorConstraint(42, 998, 957, 906, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			}
			pack();
			this.setSize(912, 632);
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
	
	private ButtonGroup getButtonGroup() {
		if(buttonGroup == null) {
			buttonGroup = new ButtonGroup();
		}
		return buttonGroup;
	}
	
	private JButton getButtonCreate() {
		if(buttonCreate == null) {
			buttonCreate = new JButton();
			buttonCreate.setText("Create");
			buttonCreate.setFont(new java.awt.Font("Arial",1,16));
			buttonCreate.setPreferredSize(new java.awt.Dimension(83, 32));
			buttonCreate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					buttonCreateActionPerformed(evt);
				}
			});
		}
		return buttonCreate;
	}
	
	private JRadioButton getRadioRuleForStatusGiven() {
		if(radioRuleForStatusGiven == null) {
			radioRuleForStatusGiven = new JRadioButton();
			radioRuleForStatusGiven.setText("Rule For Status Given");
			radioRuleForStatusGiven.setFont(new java.awt.Font("Arial",0,18));
			getButtonGroup().add(radioRuleForStatusGiven);
			radioRuleForStatusGiven.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					radioRuleForStatusGivenActionPerformed(evt);
				}
			});
			getButtonGroup().add(radioRuleForStatusGiven);
		}
		return radioRuleForStatusGiven;
	}
	
	private JRadioButton getRadioRuleDifferencesColumns() {
		if(radioRuleDifferencesColumns == null) {
			radioRuleDifferencesColumns = new JRadioButton();
			radioRuleDifferencesColumns.setText("Rule Diferences Columns");
			radioRuleDifferencesColumns.setFont(new java.awt.Font("Arial",0,18));
			getButtonGroup().add(radioRuleDifferencesColumns);
			radioRuleDifferencesColumns.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					radioRuleDifferencesColumnsActionPerformed(evt);
				}
			});
		}
		return radioRuleDifferencesColumns;
	}

	private JPanel getPanelSearch() {
		if(panelSearch == null) {
			panelSearch = new JPanel();
			panelSearch.setLayout(null);
			panelSearch.setPreferredSize(new java.awt.Dimension(904, 29));
			panelSearch.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
			panelSearch.add(getJLabel1(), "Center");
			panelSearch.add(getTextFieldSearch());
			panelSearch.add(getSearch());
		}
		return panelSearch;
	}
	
	private JLabel getJLabel1() {
		if(jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Search :");
			jLabel1.setBounds(2, 2, 58, 25);
			jLabel1.setFont(new java.awt.Font("Tahoma",1,14));
			jLabel1.setBorder(new LineBorder(new java.awt.Color(255,0,0), 1, false));
			jLabel1.setForeground(new java.awt.Color(255,0,0));
		}
		return jLabel1;
	}
	
	private JTextField getTextFieldSearch() {
		if(textFieldSearch == null) {
			textFieldSearch = new JTextField();
			textFieldSearch.setBounds(66, 2, 384, 25);
		}
		return textFieldSearch;
	}
	
	private JButton getSearch() {
		if(Search == null) {
			Search = new JButton();
			Search.setText("Search");
			Search.setBounds(450, 2, 85, 25);
			Search.setFont(new java.awt.Font("Tahoma",1,14));
			Search.setForeground(new java.awt.Color(255,0,0));
		}
		return Search;
	}
	
	private JRadioButton getRadioRuleForDayMonthYear() {
		if(radioRuleForDayMonthYear == null) {
			radioRuleForDayMonthYear = new JRadioButton();
			radioRuleForDayMonthYear.setText("Rule Valid Day Month Year");
			radioRuleForDayMonthYear.setFont(new java.awt.Font("Arial",0,18));
			getButtonGroup().add(radioRuleForDayMonthYear);
			radioRuleForDayMonthYear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					radioRuleForDayMonthYearActionPerformed(evt);
				}
			});
		}
		return radioRuleForDayMonthYear;
	}
	
	private JRadioButton getRadioAutoRuleYearByFolder() {
		if(radioAutoRuleYearByFolder == null) {
			radioAutoRuleYearByFolder = new JRadioButton();
			radioAutoRuleYearByFolder.setText("Auto Rule Year By Folder");
			radioAutoRuleYearByFolder.setFont(new java.awt.Font("Arial",0,18));
			radioAutoRuleYearByFolder.setForeground(new java.awt.Color(255,0,0));
			getButtonGroup().add(radioAutoRuleYearByFolder);
			radioAutoRuleYearByFolder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					radioAutoRuleYearByFolderActionPerformed(evt);
				}
			});
		}
		return radioAutoRuleYearByFolder;
	}
	
	private JRadioButton getRadioRuleForAge() {
		if(radioRuleForAge == null) {
			radioRuleForAge = new JRadioButton();
			radioRuleForAge.setText("Rule For Age");
			radioRuleForAge.setFont(new java.awt.Font("Arial",0,18));
			getButtonGroup().add(radioRuleForAge);
			radioRuleForAge.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					radioRuleForAgeActionPerformed(evt);
				}
			});
		}
		return radioRuleForAge;
	}
	
	private JRadioButton getRadioRuleAgeAndAnotherField() {
		if(radioRuleAgeAndAnotherField == null) {
			radioRuleAgeAndAnotherField = new JRadioButton();
			radioRuleAgeAndAnotherField.setText("Rule Age And Another Field");
			radioRuleAgeAndAnotherField.setFont(new java.awt.Font("Arial",0,18));
			getButtonGroup().add(radioRuleAgeAndAnotherField);
			radioRuleAgeAndAnotherField.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					radioRuleAgeAndAnotherFieldActionPerformed(evt);
				}
			});
		}
		return radioRuleAgeAndAnotherField;
	}
	
	private JRadioButton getRadioNameAndGender() {
		if(radioNameAndGender == null) {
			radioNameAndGender = new JRadioButton();
			radioNameAndGender.setText("Rule For Name And Gender");
			radioNameAndGender.setFont(new java.awt.Font("Arial",0,18));
			getButtonGroup().add(radioNameAndGender);
			radioNameAndGender.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					radioNameAndGenderActionPerformed(evt);
				}
			});
		}
		return radioNameAndGender;
	}
	
	private JRadioButton getRadioRuleGivenSurnameAliasSurname() {
		if(radioRuleGivenSurnameAliasSurname == null) {
			radioRuleGivenSurnameAliasSurname = new JRadioButton();
			radioRuleGivenSurnameAliasSurname.setText("Rule For Given , Surname Alias , Surname");
			radioRuleGivenSurnameAliasSurname.setFont(new java.awt.Font("Arial",0,18));
			getButtonGroup().add(radioRuleGivenSurnameAliasSurname);
			radioRuleGivenSurnameAliasSurname.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					radioRuleGivenSurnameAliasSurnameActionPerformed(evt);
				}
			});
		}
		return radioRuleGivenSurnameAliasSurname;
	}
	
	private JButton getButtonAddRuleManual() {
		if(buttonAddRuleManual == null) {
			buttonAddRuleManual = new JButton();
			buttonAddRuleManual.setText("Add Rule Manual");
			buttonAddRuleManual.setPreferredSize(new java.awt.Dimension(180, 30));
			buttonAddRuleManual.setFont(new java.awt.Font("Arial",1,16));
			buttonAddRuleManual.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					buttonAddRuleManualActionPerformed(evt);
				}
			});
		}
		return buttonAddRuleManual;
	}
	
	private JRadioButton getRadioRuleGivenFatherMother() {
		if(radioRuleGivenFatherMother == null) {
			radioRuleGivenFatherMother = new JRadioButton();
			radioRuleGivenFatherMother.setText("Rule Given-Father-Mother");
			radioRuleGivenFatherMother.setFont(new java.awt.Font("Arial",0,18));
			getButtonGroup().add(radioRuleGivenFatherMother);
			radioRuleGivenFatherMother.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					radioRuleGivenFatherMotherActionPerformed(evt);
				}
			});
		}
		return radioRuleGivenFatherMother;
	}
	
	private void buttonAddRuleManualActionPerformed(ActionEvent evt) {
		frmUpdateRule = new FrmUpdateRule(project, daoFinal, frmAdminFinal);
		frmUpdateRule.setVisible(true);
		this.dispose();
	}
	
	//-----------------------------------------------------------------------------------------

	private void buttonCreateActionPerformed(ActionEvent evt) {
		processRule();
	}
	
	private void radioRuleForAnredeActionPerformed(ActionEvent evt) {
		initDataFromTableProof(RuleStatus.anrede);
		group_rule  = GroupOfRule.group2;
	}
	
	private void radioRuleForStatusGivenActionPerformed(ActionEvent evt) {
		initDataFromTableProof(RuleStatus.status_given);
		group_rule  = GroupOfRule.group1;
	}
	
	private void radioRuleCertificateNumberActionPerformed(ActionEvent evt) {
		initDataFromTableProof(RuleStatus.certificate_number);
		group_rule  = GroupOfRule.group1;
		isAutoRule = true;
	}
	
	private void radioRuleCheckInListNonUpperActionPerformed(ActionEvent evt) {
		initDataFromTableProof(RuleStatus.check_dont_wite);
		group_rule  = GroupOfRule.group1;
	}
	
	private void radioSimpleRuleActionPerformed(ActionEvent evt) {
		initDataFromTableProof(RuleStatus.none);
		group_rule  = GroupOfRule.group1;
	}
	
	private void radioAutoRuleYearByFolderActionPerformed(ActionEvent evt) {
		initDataFromTableProof(RuleStatus.auto_year);
		group_rule  = GroupOfRule.group0;
		isAutoRule = true;
	}
	
	private void radioRuleCheckInListDoNotWriteActionPerformed(ActionEvent evt) {
		initDataFromTableProof(RuleStatus.check_dont_wite);
		group_rule  = GroupOfRule.group1;
	}
	
	private void radioNameAndGenderActionPerformed(ActionEvent evt) {
		initDataFromTableProof(RuleStatus.name_and_gender);
		group_rule  = GroupOfRule.group5;
	}

	
	//-------------------------------------------------------------------------------------
	
	private void radioRuleForAgeActionPerformed(ActionEvent evt) {
		initDataFromFieldNameList(RuleStatus.age);
		group_rule  = GroupOfRule.group4;

	}
	
	private void radioCompareDatesActionPerformed(ActionEvent evt) {
		initDataFromFieldNameList(RuleStatus.compare_two_date);
		group_rule  = GroupOfRule.group3;

	}
		
	private void radioRuleForDayMonthYearActionPerformed(ActionEvent evt) {
		initDataFromFieldNameList(RuleStatus.day_month_year_invalid);
		group_rule  = GroupOfRule.group3;

	}
	
	private void radioRuleAgeAndAnotherFieldActionPerformed(ActionEvent evt) {
		initDataFromFieldNameList(RuleStatus.age_and_field);
		group_rule  = GroupOfRule.group1;
	}
	
	private void radioRuleGivenSurnameAliasSurnameActionPerformed(ActionEvent evt) {
		initDataFromFieldNameList(RuleStatus.given_surname_alias_surname);
		group_rule  = GroupOfRule.group6;
	}
	
	private void radioRuleDifferencesColumnsActionPerformed(ActionEvent evt) {
		initDataFromFieldNameList(RuleStatus.differences_columns);
		group_rule  = GroupOfRule.group7;
	}
	
	private void radioRuleGivenFatherMotherActionPerformed(ActionEvent evt) {
		initDataFromFieldNameList(RuleStatus.given_with_father_mother);
		group_rule  = GroupOfRule.group8;
	}


	//=======================================================================================================================

	/**
	 * set header jtable
	 */
	private void setHeader() {
		String [] headers = new String [] {"No." , "Field Name" , "Column Data" , "Check"};
		model = new DefaultTableModel(headers , 0) {
            Class[] types = new Class [] {  
                    java.lang.Object.class, java.lang.Object.class,java.lang.Object.class, java.lang.Boolean.class 
                };  
       
                public Class getColumnClass(int columnIndex) {  
                    return types [columnIndex];  
                } 
		};
	}
	
	/**
	 * set model for Jtable
	 */
	private void setModelTable() {
		tableField.setModel(model);
		TableCellRenderer renderer = new HeaderRenderer(tableField.getTableHeader(), 3);
        tableField.getColumnModel().getColumn(3).setHeaderRenderer(renderer);
        model.addTableModelListener(new HeaderCheckBoxHandler(tableField, 3));
		JTableUtil.styleTableWithValue(tableField, 30, 16, true);
		JTableUtil.setSortByText(textFieldSearch, model, tableField);
		setSizeTable();
	}
	
	/**
	 * init data from table fieldnamelist
	 */
	private void initDataFromFieldNameList(int status) {

		setHeader();
		Object []  values = null;
		int index = 1;
		
		String fieldname = "";
		String detail_field = "";
		String [] tmp;
		String day_month_year ="";
		listFieldSelect = new ArrayList<String>();
		
		List<String> listCheck = new ArrayList<String>();
		if(status == RuleStatus.age || 
		  status == RuleStatus.day_month_year_invalid || 
		  status == RuleStatus.compare_two_date ||
		  status == RuleStatus.age_and_field || 
		  status == RuleStatus.given_surname_alias_surname || 
		  status == RuleStatus.differences_columns ||
		  status == RuleStatus.given_with_father_mother)
		{
			for (FieldNameList fieldNameList :  listFieldNameList) 
			{
					fieldname    = fieldNameList.getFieldname();
					detail_field = fieldNameList.getDetail_field();
					
					if((status == RuleStatus.day_month_year_invalid ) && ( fieldname.contains("_day") || fieldname.contains("_month") || fieldname.contains("_year") )) {
						if(!fieldname.contains("header") && !fieldname.contains("export")) {
							
							fieldname = fieldname.replace("_day"   , "");
							fieldname = fieldname.replace("_month" , "");
							fieldname = fieldname.replace("_year"  , "");
							if(!listCheck.contains(fieldname)) 
							{
								day_month_year = fieldname +"_day," + fieldname +"_month,"  +fieldname +"_year";
								values = new Object [] { index ,  day_month_year , day_month_year , Boolean.FALSE };
								model.addRow(values);
								++index;
								listFieldSelect.add(detail_field);
								listCheck.add(fieldname);
							}

						}
					}

					else if((status == RuleStatus.compare_two_date ) && ( fieldname.contains("_day") || fieldname.contains("_month") || fieldname.contains("_year") )) {
						if(!fieldname.contains("header") && !fieldname.contains("export")) {
							values = new Object [] { index ,  fieldname , detail_field , Boolean.FALSE };
							model.addRow(values);
							++index;
							listFieldSelect.add(detail_field);
						}
					}
					else if(status == RuleStatus.age && fieldNameList.getFieldtype() ==3) {
						detail_field = detail_field.replace(";", ",");
						values = new Object [] { index ,  fieldname , detail_field , Boolean.FALSE };
						model.addRow(values);
						++index;
						listFieldSelect.add(detail_field);
					}
					else if(status == RuleStatus.differences_columns && fieldNameList.getFieldtype() !=3) {
						values = new Object [] { index ,  fieldname , detail_field , Boolean.FALSE };
						model.addRow(values);
						++index;
						listFieldSelect.add(detail_field);
					}
					else if(status == RuleStatus.age_and_field) 
					{
						if(fieldname.contains("_age") || fieldname.contains("given") || fieldname.contains("surname")) {
							detail_field = detail_field.replace(";", ",");
							values = new Object [] { index ,  fieldname , detail_field , Boolean.FALSE };
							model.addRow(values);
							++index;
							listFieldSelect.add(detail_field);
						}		

					}

			}
			List<String>listTmp = new ArrayList<String>();
			if(status == RuleStatus.given_surname_alias_surname) 
			{
				fieldname = "given,surname_alias,surname";
				values = new Object [] { index ,  fieldname , fieldname , Boolean.FALSE };
				model.addRow(values);
				++index;
				listFieldSelect.add(fieldname);
			}
			else if(status == RuleStatus.given_with_father_mother) 
			{
				listTmp.add("given,father_given,mother_given");
				listTmp.add("spouse_given,spouse_father_given,spouse_mother_given");
				for (String str : listTmp) {
					values = new Object [] { index ,  str , str , Boolean.FALSE };
					model.addRow(values);
					++index;
					listFieldSelect.add(fieldname);
				}
			}
			setModelTable();
		}


	}
	
	/**
	 * init data from table proof
	 */
	private void initDataFromTableProof(int status) {

		setHeader();
		Object []  values = null;
		int index = 1;
		
		if(status != RuleStatus.age || status != RuleStatus.day_month_year_invalid || status != RuleStatus.compare_two_date ||
		   status != RuleStatus.age_and_field || status != RuleStatus.given_surname_alias_surname)
		{
			listFieldSelect = new ArrayList<String>();
			for (String fieldname : listColumnProof) 
			{
				if (fieldname.contains("check_anrede") && status == RuleStatus.anrede) {
					values = new Object[] { index, fieldname ,fieldname , Boolean.FALSE };
					model.addRow(values);
					++index;
					listFieldSelect.add(fieldname);
				} 
				else if (fieldname.contains("status") && !fieldname.contains("anrede") && status == RuleStatus.status_given) {
					values = new Object[] { index, fieldname ,fieldname , Boolean.FALSE };
					model.addRow(values);
					++index;
					listFieldSelect.add(fieldname);
				}
				else if (fieldname.contains("certificate_number") && status == RuleStatus.certificate_number) {
					values = new Object[] { index, fieldname ,fieldname , Boolean.FALSE };
					model.addRow(values);
					++index;
					listFieldSelect.add(fieldname);
				}
				else if (status ==RuleStatus.check_dont_wite || status == RuleStatus.check_non_upper) 
				{
					if(!fieldname.contains("day") && !fieldname.contains("month") && !fieldname.contains("year") &&
					  !fieldname.contains("age") && !fieldname.contains("status") && !fieldname.contains("anrede")) 
					{
						values = new Object[] { index, fieldname ,fieldname , Boolean.FALSE };
						model.addRow(values);
						++index;
						listFieldSelect.add(fieldname);
					}

				}
				else if(status == RuleStatus.auto_year  && fieldname.contains("_year")) {
					if(!fieldname.contains("header") && !fieldname.contains("export")) {
						values = new Object [] { index ,  fieldname , fieldname , Boolean.FALSE };
						model.addRow(values);
						++index;
						listFieldSelect.add(fieldname);
					}
				}
				else if(status == RuleStatus.name_and_gender && fieldname.contains("anrede")) 
				{
					values = new Object [] { index ,  fieldname , fieldname , Boolean.FALSE };
					model.addRow(values);
					++index;
					listFieldSelect.add(fieldname);
				}
				else if (status == RuleStatus.none) 
				{
					if(!fieldname.contains("check_anrede") && !fieldname.contains("status") && !fieldname.contains("anrede") ) 
					{
						values = new Object[] { index, fieldname ,fieldname , Boolean.FALSE };
						model.addRow(values);
						++index;
						listFieldSelect.add(fieldname);
					}

				}
			}
			setModelTable();
		}

	}
	
	/**
	 * set size jtable
	 */
	private void setSizeTable() {
		JTableUtil.setPrefersizeColum(tableField, 0, 70);
		JTableUtil.setPrefersizeColum(tableField, 1, 150);
		JTableUtil.setPrefersizeColum(tableField, 2, 150);
		JTableUtil.setPrefersizeColum(tableField, 3, 100);
	}
	
	/**
	 * get select field
	 */
	private void getSelectField() {
		listFieldSelect = new ArrayList<String>();
		int totalRow = tableField.getRowCount();
		String check = "";
		String field = "";
		
		for (int row = 0; row < totalRow; row++) 
		{
			if(radioRuleForDayMonthYear.isSelected()) {
				check = tableField.getValueAt(row, 3).toString();
				field = JTableUtil.getValuesByHeaderName(tableField, "Field Name", row);
			}
			else {
				check = tableField.getValueAt(row, 3).toString();
				field = JTableUtil.getValuesByHeaderName(tableField, "Column Data", row);
			}
			if(check.equals("true"))
			{
			    listFieldSelect.add(field);
			}
		}
	}
	
	/**
	 * get select field
	 */
	private void getSelectFieldSpecial() 
	{
		listFieldSelect = new ArrayList<String>();
		int totalRow = tableField.getRowCount();
		String check = "";
		String field = "";
		
		StringBuilder sb = new StringBuilder();
		for (int row = 0; row < totalRow; row++) 
		{
			if(radioCompareDates.isSelected() || radioRuleDifferencesColumns.isSelected()) {
				check = tableField.getValueAt(row, 3).toString();
				field = JTableUtil.getValuesByHeaderName(tableField, "Field Name", row);
			}
			if (check.equals("true") && row <= 1) 
			{
				sb.append(field);
				if(row == 0) {
					sb.append(",");
				}
			}
		}
	    listFieldSelect.add(sb.toString());

	}
	
	
	//======================================================================================================================
	
	/**
	 * process rule
	 */
	private void processRule() 
	{
		if(!isAutoRule) 
		{
			if(radioCompareDates.isSelected() || radioRuleDifferencesColumns.isSelected()) {
				getSelectFieldSpecial();
			}else {
				getSelectField();
			}
	    	if(listFieldSelect.size()  >0) {
	            frmSimpleRule = new FrmSimpleRule(listFieldSelect , daoFinal , group_rule ,frmAdminFinal);
	            frmSimpleRule.setVisible(true);
	            frmSimpleRule.loadField();
	            this.dispose();
	    	}else {
	    		AppUtility.msgInfo(this, "Please select field !!");
	    	}
		}else {
			processAutoRule();
		}


	}
	
	
	/**
	 * process auto rule
	 */
	private void processAutoRule()
	{
		boolean flag = false;
		BeanFinalRule beanFinalRule = new BeanFinalRule();
		try {
			int totalRow = tableField.getRowCount();
			if(radioRuleCertificateNumber.isSelected()) 
			{
				if(totalRow >0) {
					String ruleName = "folder_certificate_number_+1";
					beanFinalRule.setRuleName(ruleName);
					beanFinalRule.setRuleNote("Trong cùng 1 folder: certificate_number của record sau luôn là certificate_number của record trước +1.");
					beanFinalRule.setCondition("");
					beanFinalRule.setRuleField("managementid,filepath , filename, seq_number, certificate_number, user_type");
					flag = daoFinal.checkExistRule(ruleName);
					if(!flag) {
						flag = daoFinal.saveRule(beanFinalRule);
						if(flag) {
							AppUtility.msgInfo(this, "Add rule successfull !!");
						}
					}else {
	        			AppUtility.msgInfo(this, "This rule existed !!");
					}
				}
			}
			else if(radioAutoRuleYearByFolder.isSelected()) {
			    flag = saveRuleAutoYear(totalRow);	 
			}

		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "processAutoRule : "  + e.toString());
		}

	}
	
	
	/**
	 * save rule auto by field year
	 * @throws Exception 
	 */
	private boolean saveRuleAutoYear(int total) throws Exception {
		boolean flag = false;
		String check ="";
		String field ="";
		String ruleName ="";
		BeanFinalRule beanFinalRule = new BeanFinalRule();
		
		String ruleNote  ="";
		String ruleField ="";
		for (int row = 0; row < total; row++) {
			check = tableField.getValueAt(row, 3).toString();
			field = JTableUtil.getValuesByHeaderName(tableField, "Field Name", row);
			if(check.equals("true")) 
			{
				ruleName  = "folder_"  + field + "_>";
				ruleNote  = "Trong cùng 1 folder: "+field+" của record sau luôn lớn hơn "+field+" của record trước. Nếu ko thỏa điều này thì lọc ra 2 record trước & sau không liên tục nhau";
				ruleField = "managementid, filepath, filename, "+field+" , user_type";
				
				beanFinalRule.setRuleName(ruleName);
				beanFinalRule.setRuleNote(ruleNote);
				beanFinalRule.setRuleField(ruleField);
				beanFinalRule.setCondition("");
				flag = daoFinal.checkExistRule(ruleName);
                if(!flag) {
                	flag = daoFinal.saveRule(beanFinalRule);
        			if(flag) {
        				AppUtility.msgInfo(this, "Add rule successfull !!");
        			}
                }else {
        			AppUtility.msgInfo(this, "This rule existed !!");
                }
			}
		}
		if(!flag) {
			AppUtility.msgInfo(this, "Please select field !!");
		}
		return flag;
	}
	


}
