package com.digitexx.ancestry.gui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.ancestry.bean.BeanInfo;
import com.digitexx.ancestry.bean.DigiSoftManagement;
import com.digitexx.ancestry.bean.FieldNameList;
import com.digitexx.ancestry.bean.Management;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.dao.DaoPjmAssignJob;
import com.digitexx.ancestry.gui.util.WrapEditorKit;
import com.digitexx.ancestry.table.render.HeaderCheckBoxHandler;
import com.digitexx.ancestry.table.render.HeaderRenderer;
import com.digitexx.ancestry.util.AppUtility;
import com.digitexx.ancestry.util.JTableUtil;
import com.digitexx.ancestry.util.NumberOnly;
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
public class FrmPjmAssignJob extends javax.swing.JFrame {
	private JPanel panelContent;
	private JPanel panelFooter;
	private JPanel panelRigth;
	private JPanel panelLeft;
	private JButton buttonClear;
	private JList jListPath;
	private JList jListUser;
	private JScrollPane scrollPanePath;
	private JScrollPane scrollPaneUser;
	private JPanel panelUser;
	private JPanel panelPath;
	private JSplitPane splitPaneHeader;
	private JPanel panelHeader;
	private ButtonGroup buttonGroup;
	private JButton buttonAssignJob;
	private JRadioButton radioRework;
	private JRadioButton radioProof;
	private JTable tableStatusQC;
	private JTextPane textPaneManagementId;
	private JScrollPane scrollPaneDown;
	private JComboBox comboboxTopForm;
	private JLabel labelTitleForm;
	private JButton buttonGetId;
	private JTextField textFieldTo;
	private JLabel labelTitleTo;
	private JTextField textFieldFrom;
	private JLabel labelTileFrom;
	private JPanel panelCondition;
	private JCheckBox checkboxWithForm;
	private JComboBox comboboxForm;
	private JRadioButton radioType;
	private JCheckBox checkboxAssignWithUser;
	private JScrollPane scrollPaneTop;
	private JPanel panelTop;
	private JPanel panelDown;
	private JSplitPane splitPaneRight;
	private JTable tableField;
	private JScrollPane scrollPaneRight;
	private JScrollPane scrollPaneLeft;
	private JSplitPane splitPaneContent;
	private DefaultTableModel modelField;
	private DefaultTableModel modelQmdInformation;
	private DaoPjmAssignJob daoPjmAssignJob;
	private DefaultListModel modelUser;
	private DefaultListModel modelPath;
	
	private Tbl_Projects project;
	private String userId;
	private FrmStep frmStep;
	private String title;
	private Map<Long , String> mapUserType;
	private List<String> listFieldSelect;
	private List<Management> listManagement;
	private Tbl_Projects projectDigiSoft;
	private List<DigiSoftManagement> listDigiSoftManagement = new ArrayList<DigiSoftManagement>();
	private List<String> listField = new ArrayList<String>();
	private List<Long> listIdNotAssign = new ArrayList<Long>();
	private List<String> listUserType = new ArrayList<String>();
	private List<String> listPath= new ArrayList<String>();
	private List<String> listTmp= new ArrayList<String>();
	private List<String> listFormKey = new ArrayList<String>();
	private Map<String , String> mapFieldAge = new HashMap<String , String>();
	private BeanInfo beanInfo;

	private int step =2;
	private boolean isRework = false;
	private boolean isSaveTime;

	public FrmPjmAssignJob(Tbl_Projects project , String userId , FrmStep frmStep , boolean isSaveTime , String title) {
		super();
		this.project = project;
		this.userId  = userId;
		this.frmStep = frmStep;
		this.title   = title;
		this.isSaveTime = isSaveTime;
		initGUI();
		initData();
	}
	
	private void initGUI() {
		try {
			this.setTitle(title);
			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			{
				panelContent = new JPanel();
				BorderLayout panelContentLayout = new BorderLayout();
				panelContent.setLayout(panelContentLayout);
				getContentPane().add(getJPanel1x(), new AnchorConstraint(0, 1000, 45, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				getContentPane().add(getPanelHeader(), new AnchorConstraint(45, 1000, 261, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				getContentPane().add(panelContent, new AnchorConstraint(261, 1000, 942, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelContent.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelContent.setPreferredSize(new java.awt.Dimension(979, 394));
				{
					splitPaneContent = new JSplitPane();
					panelContent.add(splitPaneContent, BorderLayout.CENTER);
					splitPaneContent.setDividerLocation(200);
					{
						panelRigth = new JPanel();
						BorderLayout panelRigthLayout = new BorderLayout();
						panelRigth.setLayout(panelRigthLayout);
						splitPaneContent.add(panelRigth, JSplitPane.RIGHT);
						panelRigth.setPreferredSize(new java.awt.Dimension(756, 540));
						{
							scrollPaneRight = new JScrollPane();
							panelRigth.add(scrollPaneRight, BorderLayout.CENTER);
							{
								splitPaneRight = new JSplitPane();
								scrollPaneRight.setViewportView(splitPaneRight);
								splitPaneRight.setOrientation(JSplitPane.VERTICAL_SPLIT);
								{
									panelDown = new JPanel();
									BorderLayout panelDownLayout = new BorderLayout();
									panelDown.setLayout(panelDownLayout);
									splitPaneRight.add(panelDown, JSplitPane.RIGHT);
									panelDown.setBorder(BorderFactory.createTitledBorder(null, "QMD Information", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,16), new java.awt.Color(0,0,0)));
									{
										scrollPaneDown = new JScrollPane();
										panelDown.add(scrollPaneDown, BorderLayout.CENTER);
										scrollPaneDown.setPreferredSize(new java.awt.Dimension(737, 101));
										{
											tableStatusQC = new JTable() {
												@Override
												public boolean isCellEditable(int row, int column) {
													if(getColumnName(column).equals("Get Data")) {
														return true;
													}else {
														return false;
													}
												}
											};
											scrollPaneDown.setViewportView(tableStatusQC);
										}
									}
								}
								{
									panelTop = new JPanel();
									BorderLayout panelTopLayout = new BorderLayout();
									panelTop.setLayout(panelTopLayout);
									splitPaneRight.add(panelTop, JSplitPane.LEFT);
									panelTop.setPreferredSize(new java.awt.Dimension(723, 248));
									panelTop.setBorder(BorderFactory.createTitledBorder("Management_ID"));
									{
										scrollPaneTop = new JScrollPane();
										panelTop.add(scrollPaneTop, BorderLayout.CENTER);
										{
											textPaneManagementId = new JTextPane();
											scrollPaneTop.setViewportView(textPaneManagementId);
											textPaneManagementId.setFont(new java.awt.Font("Arial",0,16));
											textPaneManagementId.setEditorKit(new WrapEditorKit());
											textPaneManagementId.addFocusListener(new FocusListener() {
												
												@Override
												public void focusLost(FocusEvent e) {
													//loadQmdInformation();
												}
												
												@Override
												public void focusGained(FocusEvent e) {
													
												}
											});
											
											textPaneManagementId.addKeyListener(new KeyListener() {
												
												@Override
												public void keyTyped(KeyEvent e) {
													
												}
												
												@Override
												public void keyReleased(KeyEvent e) {
													if(e.getKeyCode() == KeyEvent.VK_ENTER) {
														loadQmdInformation();
														e.consume();
													}
												}
												
												@Override
												public void keyPressed(KeyEvent e) {
													
												}
											});
										}
									}
								}
							}
						}
					}
					{
						panelLeft = new JPanel();
						BorderLayout panelLeftLayout = new BorderLayout();
						panelLeft.setLayout(panelLeftLayout);
						splitPaneContent.add(panelLeft, JSplitPane.LEFT);
						panelLeft.setPreferredSize(new java.awt.Dimension(238, 540));
						panelLeft.setBorder(BorderFactory.createTitledBorder(null, "Fields", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,16), new java.awt.Color(255,0,0)));
						{
							scrollPaneLeft = new JScrollPane();
							panelLeft.add(scrollPaneLeft, BorderLayout.CENTER);
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
				panelFooter.setPreferredSize(new java.awt.Dimension(979, 34));
				{
					buttonAssignJob = new JButton();
					panelFooter.add(getCheckboxAssignWithUser(), new AnchorConstraint(132, 213, 955, 2, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					panelFooter.add(getButtonClear(), new AnchorConstraint(102, 901, 985, 812, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					panelFooter.add(buttonAssignJob, new AnchorConstraint(102, 998, 985, 901, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					panelFooter.add(getComboboxForm(), new AnchorConstraint(44, 386, 955, 316, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					panelFooter.add(getCheckboxWithForm(), new AnchorConstraint(44, 316, 955, 232, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonAssignJob.setText("Assign");
					buttonAssignJob.setFont(new java.awt.Font("Arial",1,16));
					buttonAssignJob.setPreferredSize(new java.awt.Dimension(95, 30));
					buttonAssignJob.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							buttonAssignJobActionPerformed(evt);
						}
					});
				}
			}
			pack();
			this.setSize(987, 613);
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
	
	
	private ButtonGroup getButtonGroup() {
		if(buttonGroup == null) {
			buttonGroup = new ButtonGroup();
		}
		return buttonGroup;
	}
	
	private JPanel getPanelHeader() {
		if(panelHeader == null) {
			panelHeader = new JPanel();
			BorderLayout panelHeaderLayout = new BorderLayout();
			panelHeader.setLayout(panelHeaderLayout);
			panelHeader.setPreferredSize(new java.awt.Dimension(979, 125));
			panelHeader.add(getSplitPaneHeader(), BorderLayout.CENTER);
		}
		return panelHeader;
	}
	
	private JSplitPane getSplitPaneHeader() {
		if(splitPaneHeader == null) {
			splitPaneHeader = new JSplitPane();
			splitPaneHeader.add(getJPanel1(), JSplitPane.RIGHT);
			splitPaneHeader.add(getJPanel2(), JSplitPane.LEFT);
		}
		return splitPaneHeader;
	}
	
	private JPanel getJPanel1() {
		if(panelPath == null) {
			panelPath = new JPanel();
			BorderLayout panelPathLayout = new BorderLayout();
			panelPath.setLayout(panelPathLayout);
			panelPath.setBorder(BorderFactory.createTitledBorder(null, "FilePath", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,14), new java.awt.Color(0,0,255)));
			panelPath.add(getScrollPanePath(), BorderLayout.CENTER);
		}
		return panelPath;
	}
	
	private JPanel getJPanel2() {
		if(panelUser == null) {
			panelUser = new JPanel();
			BorderLayout panelUserLayout = new BorderLayout();
			panelUser.setLayout(panelUserLayout);
			panelUser.setPreferredSize(new java.awt.Dimension(205, 149));
			panelUser.setBorder(BorderFactory.createTitledBorder(null, "User_Type", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,14), new java.awt.Color(0,0,255)));
			panelUser.add(getScrollPaneUser(), BorderLayout.CENTER);
		}
		return panelUser;
	}
	
	private JScrollPane getScrollPaneUser() {
		if(scrollPaneUser == null) {
			scrollPaneUser = new JScrollPane();
			scrollPaneUser.setViewportView(getJListUser());
		}
		return scrollPaneUser;
	}
	
	private JScrollPane getScrollPanePath() {
		if(scrollPanePath == null) {
			scrollPanePath = new JScrollPane();
			scrollPanePath.setViewportView(getJListPath());
		}
		return scrollPanePath;
	}
	
	private JList getJListUser() {
		if(jListUser == null) {
			jListUser = new JList();
			jListUser.setFont(new java.awt.Font("Tahoma",1,20));
			jListUser.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent evt) {
					jListUserValueChanged(evt);
				}
			});
		}
		return jListUser;
	}
	
	private JList getJListPath() {
		if(jListPath == null) {
			jListPath = new JList();
			jListPath.setFont(new java.awt.Font("Tahoma",0,14));
			jListPath.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent evt) {
					jListPathValueChanged(evt);
				}
			});
		}
		return jListPath;
	}
	
	private JButton getButtonClear() {
		if(buttonClear == null) {
			buttonClear = new JButton();
			buttonClear.setText("Clear");
			buttonClear.setPreferredSize(new java.awt.Dimension(87, 30));
			buttonClear.setFont(new java.awt.Font("Arial",1,16));
			buttonClear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					buttonClearActionPerformed(evt);
				}
			});
		}
		return buttonClear;
	}
	
	private JCheckBox getCheckboxAssignWithUser() {
		if(checkboxAssignWithUser == null) {
			checkboxAssignWithUser = new JCheckBox();
			checkboxAssignWithUser.setText("Assign Without User");
			checkboxAssignWithUser.setPreferredSize(new java.awt.Dimension(207, 28));
			checkboxAssignWithUser.setFont(new java.awt.Font("Arial",1,14));
			checkboxAssignWithUser.setBorder(new LineBorder(new java.awt.Color(255,0,0), 1, false));
		}
		return checkboxAssignWithUser;
	}
	
	private JComboBox getComboboxForm() {
		if(comboboxForm == null) {
			comboboxForm = new JComboBox();
			comboboxForm.setFont(new java.awt.Font("Arial",1,16));
			comboboxForm.setPreferredSize(new java.awt.Dimension(69, 31));
			comboboxForm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					comboboxFormActionPerformed(evt);
				}
			});
			comboboxForm.setVisible(false);
		}
		return comboboxForm;
	}

	private JCheckBox getCheckboxWithForm() {
		if(checkboxWithForm == null) {
			checkboxWithForm = new JCheckBox();
			checkboxWithForm.setText("Form");
			checkboxWithForm.setFont(new java.awt.Font("Arial",1,16));
			checkboxWithForm.setForeground(new java.awt.Color(255,0,0));
			checkboxWithForm.setPreferredSize(new java.awt.Dimension(82, 31));
			checkboxWithForm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					checkboxWithFormActionPerformed(evt);
				}
			});
		}
		return checkboxWithForm;
	}
	
	private JPanel getJPanel1x() {
		if(panelCondition == null) {
			panelCondition = new JPanel();
			AnchorLayout panelConditionLayout = new AnchorLayout();
			panelCondition.setPreferredSize(new java.awt.Dimension(979, 26));
			panelCondition.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
			panelCondition.setLayout(panelConditionLayout);
			panelCondition.add(getComboboxTopForm(), new AnchorConstraint(57, 870, 1019, 811, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			panelCondition.add(getLabelTitleForm(), new AnchorConstraint(57, 808, 942, 762, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			panelCondition.add(getLabelTileFrom(), new AnchorConstraint(57, 366, 942, 295, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			panelCondition.add(getJTextField1(), new AnchorConstraint(57, 550, 1019, 366, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			panelCondition.add(getLabelTitleTo(), new AnchorConstraint(57, 596, 980, 550, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			panelCondition.add(getJTextField1x(), new AnchorConstraint(19, 765, 1019, 596, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			panelCondition.add(getRadioType(), new AnchorConstraint(96, 81, 942, 2, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			{
				radioProof = new JRadioButton();
				panelCondition.add(radioProof, new AnchorConstraint(134, 169, 942, 86, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				radioProof.setText("Proof");
				radioProof.setFont(new java.awt.Font("Arial",1,16));
				radioProof.setForeground(new java.awt.Color(0,0,0));
				radioProof.setSelected(true);
				radioProof.setPreferredSize(new java.awt.Dimension(81, 21));
				getButtonGroup().add(radioProof);
				radioProof.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						radioProofActionPerformed(evt);
					}
				});
			}
			{
				radioRework = new JRadioButton();
				panelCondition.add(radioRework, new AnchorConstraint(96, 276, 942, 180, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelCondition.add(getButtonGetId(), new AnchorConstraint(57, 998, 1019, 916, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				radioRework.setText("Rework");
				radioRework.setFont(new java.awt.Font("Arial",1,16));
				radioRework.setForeground(new java.awt.Color(0,0,0));
				radioRework.setPreferredSize(new java.awt.Dimension(94, 22));
				getButtonGroup().add(radioRework);
				radioRework.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						radioReworkActionPerformed(evt);
					}
				});
			}
		}
		return panelCondition;
	}
	
	private JLabel getLabelTileFrom() {
		if(labelTileFrom == null) {
			labelTileFrom = new JLabel();
			labelTileFrom.setText("From Id");
			labelTileFrom.setBorder(new LineBorder(new java.awt.Color(255,0,0), 1, false));
			labelTileFrom.setFont(new java.awt.Font("Arial",1,14));
			labelTileFrom.setForeground(new java.awt.Color(255,0,0));
			labelTileFrom.setPreferredSize(new java.awt.Dimension(69, 23));
		}
		return labelTileFrom;
	}
	
	private JTextField getJTextField1() {
		if(textFieldFrom == null) {
			textFieldFrom = new JTextField();
			textFieldFrom.setFont(new java.awt.Font("Arial",1,18));
			textFieldFrom.setPreferredSize(new java.awt.Dimension(180, 25));
			textFieldFrom.setDocument(new NumberOnly());
			textFieldFrom.addFocusListener(new FocusListener() {
				
				@Override
				public void focusLost(FocusEvent e) {
					
				}
				
				@Override
				public void focusGained(FocusEvent e) {
					jListPath.setEnabled(false);
					jListUser.setEnabled(false);
				}
			});
		}
		return textFieldFrom;
	}
	
	private JLabel getLabelTitleTo() {
		if(labelTitleTo == null) {
			labelTitleTo = new JLabel();
			labelTitleTo.setText("To Id");
			labelTitleTo.setFont(new java.awt.Font("Arial",1,14));
			labelTitleTo.setForeground(new java.awt.Color(255,0,0));
			labelTitleTo.setBorder(new LineBorder(new java.awt.Color(255,0,0), 1, false));
			labelTitleTo.setPreferredSize(new java.awt.Dimension(45, 24));

		}
		return labelTitleTo;
	}
	
	private JTextField getJTextField1x() {
		if(textFieldTo == null) {
			textFieldTo = new JTextField();
			textFieldTo.setFont(new java.awt.Font("Arial",1,18));
			textFieldTo.setPreferredSize(new java.awt.Dimension(166, 26));
			textFieldTo.setDocument(new NumberOnly());
			textFieldTo.addFocusListener(new FocusListener() {
				
				@Override
				public void focusLost(FocusEvent e) {
					
				}
				
				@Override
				public void focusGained(FocusEvent e) {
					jListPath.setEnabled(false);
					jListUser.setEnabled(false);

				}
			});
		}
		return textFieldTo;
	}
	
	private JButton getButtonGetId() {
		if(buttonGetId == null) {
			buttonGetId = new JButton();
			buttonGetId.setText("Get Id");
			buttonGetId.setFont(new java.awt.Font("Arial",1,14));
			buttonGetId.setForeground(new java.awt.Color(255,0,0));
			buttonGetId.setPreferredSize(new java.awt.Dimension(80, 25));
			buttonGetId.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					buttonGetIdActionPerformed(evt);
				}
			});
		}
		return buttonGetId;
	}
	
	private JLabel getLabelTitleForm() {
		if(labelTitleForm == null) {
			labelTitleForm = new JLabel();
			labelTitleForm.setText("Form");
			labelTitleForm.setPreferredSize(new java.awt.Dimension(45, 23));
			labelTitleForm.setBorder(new LineBorder(new java.awt.Color(255,0,0), 1, false));
			labelTitleForm.setForeground(new java.awt.Color(255,0,0));
			labelTitleForm.setFont(new java.awt.Font("Arial",1,14));
		}
		return labelTitleForm;
	}
	
	private JComboBox getComboboxTopForm() {
		if(comboboxTopForm == null) {
			comboboxTopForm = new JComboBox();
			comboboxTopForm.setPreferredSize(new java.awt.Dimension(58, 25));
			comboboxTopForm.setFont(new java.awt.Font("Arial",1,16));
		}
		return comboboxTopForm;
	}
	
	private void buttonGetIdActionPerformed(ActionEvent evt) {
	    loadIdFromTo();	
	}
	
	private void jListPathValueChanged(ListSelectionEvent evt) {
		if (!evt.getValueIsAdjusting()) {
            loadIdByPathAndUser();
		}
	}
	
	private void jListUserValueChanged(ListSelectionEvent evt) {
		if(!evt.getValueIsAdjusting()) {
			loadUserTypeOrFilePath(false);
		}
	}

	
	private void checkboxWithFormActionPerformed(ActionEvent evt) 
	{
		try {
			if(checkboxWithForm.isSelected()) {
				comboboxForm.setVisible(true);
				jListUser.setEnabled(false);
				
				listTmp = new ArrayList<String>();
				listTmp = daoPjmAssignJob.getListFilePath();
	            AppUtility.loadDataJList(jListPath, modelPath, listTmp);
	            textPaneManagementId.setText("");
	            setHiddenControl(false);
			}else {
				modelPath = new DefaultListModel();
                jListPath.setModel(modelPath);				
				comboboxForm.setVisible(false);
				jListUser.setEnabled(true);
				textPaneManagementId.setText("");
				setHiddenControl(true);
			}
			JTableUtil.removeAllRow(tableStatusQC);
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "checkboxWithFormActionPerformed : "  + e.toString());
		}

	}
	
	/**
	 * set hidden control
	 */
	private void setHiddenControl(boolean flag) {
        labelTileFrom.setVisible(flag);
        labelTitleTo.setVisible(flag);
        labelTitleForm.setVisible(flag);
        textFieldFrom.setVisible(flag);
        textFieldTo.setVisible(flag);
        comboboxTopForm.setVisible(flag);
        buttonGetId.setVisible(flag);
        jListUser.setEnabled(flag);
	}
	
	private void comboboxFormActionPerformed(ActionEvent evt) {
		loadIdByPathAndForm();
	}

	
	//=====================================================================================================
	
	private void radioTypeActionPerformed(ActionEvent evt) {
		step = 1;
		isRework = false;
		daoPjmAssignJob.setTable(isRework);
		loadUserTypeOrFilePath(true);
	}
	
	private void radioProofActionPerformed(ActionEvent evt) {
		step = 2;
		isRework = false;
		daoPjmAssignJob.setTable(isRework);
		loadUserTypeOrFilePath(true);
	}
	
	private void radioReworkActionPerformed(ActionEvent evt) {
		step = 2;
		isRework = true;
		daoPjmAssignJob.setTable(isRework);
		loadUserTypeOrFilePath(true);
	}
	
	private JRadioButton getRadioType() {
		if(radioType == null) {
			radioType = new JRadioButton();
			radioType.setText("Type");
			radioType.setFont(new java.awt.Font("Arial",1,16));
			radioType.setForeground(new java.awt.Color(0,0,0));
			radioType.setPreferredSize(new java.awt.Dimension(77, 22));
			radioType.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					radioTypeActionPerformed(evt);
				}
			});
			getButtonGroup().add(radioType);
		}
		return radioType;
	}
	
	private void exit() {
		if(AppUtility.msgConfirm(this, "Do you want to exit ??") == JOptionPane.OK_OPTION) {
			frmStep.setVisible(true);
			this.dispose();
		}
	}

	/**
	 * reset check jtable
	 */
	public void resetCheck(JTable tableData , int colum , int totalRow) 
	{
		for (int i = 0; i < totalRow; i++) {
			tableData.setValueAt(Boolean.FALSE, i, colum);
		}
	}
	
	private void buttonAssignJobActionPerformed(ActionEvent evt) 
	{
		boolean flag = true;
		try {
			setFieldAssign();
			int option = 0;
			if(isSaveTime) {
				option = AppUtility.msgConfirm(this, "Do you want to assign these jobs with save time ??");
			}else {
				option = AppUtility.msgConfirm(this, "Do you want to assign these jobs without save time ??");
			}
			if(option == JOptionPane.OK_OPTION) 
			{
				String ids = Objects.toString(textPaneManagementId.getText() , "").trim();
				if(listFieldSelect == null ||listFieldSelect.size() ==0) {
					AppUtility.msgError(this, "Please select field for assign job !!");
					textPaneManagementId.requestFocus();
				}
				else if(ids.equals("")) 
				{
					AppUtility.msgError(this, "Please input managementid !!");
					textPaneManagementId.requestFocus();
				}
				else {
					if(radioProof.isSelected()) {
						if(listDigiSoftManagement != null &&listDigiSoftManagement.size() ==0) {
							loadQmdInformation();
						}
						flag  = updateFromDigiSoft();
					}
					if(flag) {
						assignJob(ids);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgInfo(this, "buttonAssignJobActionPerformed : "  + e.toString());
		}


	}
	
	//========================================================================================================================
	
	private void initData() {

		try {
			daoPjmAssignJob = new DaoPjmAssignJob(project , isRework);
			loadUserTypeOrFilePath(true);
			setDigiSoftInfo();
			loadField();
			loadForm(true);
			mapFieldAge = daoPjmAssignJob.getMapFieldAge();
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "initData : "  + e.toString());
		}

	}
	
	private void setDigiSoftInfo() 
	{
		try 
		{
	    	String projectNameDigiSoft = project.getProj_name()+"_for_qc";
	    	projectDigiSoft = new Tbl_Projects();
	    	projectDigiSoft = daoPjmAssignJob.getProjectInforFromPMS(projectNameDigiSoft);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * load form
	 */
	private void loadForm(boolean isLoadAllForm) {
		try {
			if(!isLoadAllForm) {
				comboboxForm.removeAllItems();
				if(jListPath.getSelectedIndex()  >-1) {
					listFormKey = new ArrayList<String>();
					listFormKey = daoPjmAssignJob.getListFormKeyByPath(jListPath.getSelectedValue().toString());
					for (String str : listFormKey) {
						comboboxForm.addItem(str);
					}
				}
			}else {
				comboboxTopForm.removeAllItems();
				listFormKey = new ArrayList<String>();
				listFormKey = daoPjmAssignJob.getListFormKey();
				for (String str : listFormKey) {
					comboboxTopForm.addItem(str);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "loadForm : "  + e.toString());
		}
	}
	
	/**
	 * load field
	 */
	private void loadField() {
		try {
			listField = new ArrayList<String>();
			modelField = new DefaultTableModel(new String [] {"No." , "FieldName" , "Check"  } , 0) {
                Class[] types = new Class [] {  
                        java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class 
                    };  
           
                    public Class getColumnClass(int columnIndex) {  
                        return types [columnIndex];  
                    } 
			};
			listField = daoPjmAssignJob.getListFieldFromFieldNameList();
			Object []  values = null;
			int index = 0;
	        for (String str : listField) {
				values = new Object [] { (index +1) , str , Boolean.TRUE };
				modelField.addRow(values);
				++index;
			}
	        tableField.setModel(modelField);
			TableCellRenderer renderer = new HeaderRenderer(tableField.getTableHeader(), 2);
	        tableField.getColumnModel().getColumn(2).setHeaderRenderer(renderer);
	        modelField.addTableModelListener(new HeaderCheckBoxHandler(tableField, 2));
	        JTableUtil.styleTable(tableField, true);
		} 
		catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "loadPath : " + e.toString());
		}
	}
	
	/**
	 * load user_type or filepath
	 */
	private void loadUserTypeOrFilePath(boolean isUserType){
		try {
			if(isUserType) {
				listUserType = new ArrayList<String>();
				listUserType = daoPjmAssignJob.getListUserType();
				AppUtility.loadDataJList(jListUser, modelUser, listUserType);
				
			}else {
				listPath = new ArrayList<String>();
				if(jListUser.getSelectedIndex() > -1) {
					String user = StringUtil.setNotNull(jListUser.getSelectedValue().toString());
					listPath = daoPjmAssignJob.getListPathByUserType(user);
				}
				AppUtility.loadDataJList(jListPath, modelPath, listPath);
			}
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgInfo(this, "loadUserTypeOrFilePath : "  + e.toString());
		}
	}
	
	/**
	 * set field assign
	 */
	private void setFieldAssign() {

		int totalRow = tableField.getRowCount();
		listFieldSelect  = new ArrayList<String>();
		String check = "";
		String field = "";
		for (int i = 0; i < totalRow; i++) {
			check = Objects.toString(tableField.getValueAt(i, 2));
			field = Objects.toString(tableField.getValueAt(i, 1));
			if(check.equals("true")) {
				listFieldSelect.add(field);
			}
		}
	}
	
	/**
	 * assign job
	 */
	private void assignJob(String ids) throws Exception {
		try 
		{
			boolean flag = true;
			mapUserType    = new HashMap<Long, String>();
			listManagement = new ArrayList<Management>();
			mapUserType    = daoPjmAssignJob.getUserTypeByManagementId(ids);
			listManagement = daoPjmAssignJob.getListManagementByIds(ids, isRework);
			ids = ids.replaceAll(" ", "");
					
			if(!isSaveTime) {
				flag = daoPjmAssignJob.updateStep(listManagement, 
						                          mapUserType,
						                          listFieldSelect ,
						                          ids, 
						                          listIdNotAssign ,
						                          false , 
						                          checkboxAssignWithUser.isSelected(),
						                          step);
			}else {
				flag = daoPjmAssignJob.updateStep(listManagement, 
						                          mapUserType, 
						                          listFieldSelect ,
						                          ids, 
						                          listIdNotAssign ,
						                          true , 
						                          checkboxAssignWithUser.isSelected(),
						                          step);
			}
			if (flag) {
				textPaneManagementId.setText("");
				listIdNotAssign = new ArrayList<Long>();
				AppUtility.msgInfo(this, "Assign job successfull !!");
			 }
		} 
		catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "assignJob : "  + e.toString());
		}
	}
	
	
	/**
	 * load QMD Information
	 */
	public void loadQmdInformation() 
	{
		try {
			if(radioProof.isSelected() || radioType.isSelected())
			{
				modelQmdInformation = new DefaultTableModel(new String [] { "No." ,"Id" , "Capture Status" , "QC Status" , "Ancestry Status" , "ManagementId" , "Assign"} , 0);
				listDigiSoftManagement = new ArrayList<DigiSoftManagement>();
				String ids = Objects.toString(textPaneManagementId.getText(), "").trim();
				JTableUtil.removeAllRow(tableStatusQC);

	            if(projectDigiSoft != null) {
	    			if(!ids.equals("")) {
	    				if(!ids.equals("")) {
	    					listDigiSoftManagement = daoPjmAssignJob.getDigiSoftInfo(projectDigiSoft , ids);
	    				}
	    				
	    				int index = 1;
	    				Object[] values;
	    				if(listDigiSoftManagement.size() > 0) 
	    				{
	    					String qcStatus = "";
	    					for (DigiSoftManagement digiSofManagement : listDigiSoftManagement) {
	    						if(digiSofManagement.getQc_status() ==0) {
	    							qcStatus = "Not QC";
	    						}else if(digiSofManagement.getQc_status() ==1){
	    							qcStatus = "Finished QC";
	    						}else if(digiSofManagement.getQc_status() ==100){
    						       	qcStatus = "Doing QC";
    						    }
	    						else if(digiSofManagement.getQc_status() ==101) {
	    							qcStatus = "Doing Approve";
    						    }
	    						else if(digiSofManagement.getQc_status() == 2) {
	    							qcStatus = "Approved";
	    						}
	                            
	    						values = new Object [] {
	    				                 index,
	    				                 digiSofManagement.getId() ,
	    				                 digiSofManagement.getCapture_status(),
	    				                 qcStatus,
	    				                 digiSofManagement.getAncestry_update_status(),
	    				                 digiSofManagement.getAnces_mana_id(),
	    				                 "Not Assign"
	    				                };
	    						++index;
	    						modelQmdInformation.addRow(values);
	    					}
	    					tableStatusQC.setModel(modelQmdInformation);
	    					JTableUtil.styleTable(tableStatusQC, true);
	    					JTableUtil.fitTableColumns(tableStatusQC);
	    				}
	    			}
	            }
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, " Not found data in DIGI-SOFT !! ");
		}

	}
	
	/**
	 * get array column name
	 */
	private String [] getArrayColumnName() {
		String tmp = "";
		List<String> listTmp = new ArrayList<String>();
		String [] arr;
		for (String str : listField) 
		{
			if(!mapFieldAge.containsKey(str)) {
				listTmp.add(str);
			}else {
				tmp = mapFieldAge.get(str);
				arr = tmp.split(";");
				for (String s : arr) {
					listTmp.add(s);
				}
			}
		}
		String arrColumn[] = listTmp.toArray(new String[listTmp.size()]);
		return arrColumn;
	}
	
	private void setBeanInfo() 
	{
    	String var_con  = "hostaddr="+project.getProj_serverip()+" dbname="+ projectDigiSoft.getProj_dbname()
    			 +" user="+projectDigiSoft.getProj_uid()+" password=" + projectDigiSoft.getProj_pwd()+"";
    	String search_path = "set search_path to "  + projectDigiSoft.getProj_schema();
    	
    	beanInfo = new BeanInfo();
    	String [] arrCols = getArrayColumnName();
    	beanInfo.setColumn_Ancestry(arrCols);
    	beanInfo.setColumn_DigiSoft(arrCols);
    	beanInfo.setSchema_Ancestry(project.getProj_schema());
    	beanInfo.setSchema_DigiSoft(projectDigiSoft.getProj_schema());
    	beanInfo.setVar_con(var_con);
    	beanInfo.setSearch_path(search_path);
	}
	
	/**
	 * update from DigiSOft
	 */
	private boolean updateFromDigiSoft() throws Exception{
		boolean flag = true;
		try {
			StringBuilder sbNotQC = new StringBuilder();
			List<Long> listTmp = new ArrayList<Long>();
			listIdNotAssign = new ArrayList<Long>();
			if(listDigiSoftManagement.size() > 0) 
			{
				int qcStatus = 0;
				for (DigiSoftManagement digiSoftManagement :  listDigiSoftManagement) {
					qcStatus = digiSoftManagement.getQc_status();
					if(qcStatus == 0 ) {
						sbNotQC.append(digiSoftManagement.getId());
						sbNotQC.append(",");
					}else if(qcStatus == 1) {
						listTmp.add(digiSoftManagement.getAnces_mana_id());
					}else if(qcStatus ==100 || qcStatus == 101) {
						listIdNotAssign.add(digiSoftManagement.getAnces_mana_id());
					}
				}
				
				String tmp = Objects.toString(sbNotQC.toString()).trim();
				if(!tmp.equals("")) {
					flag = daoPjmAssignJob.updateDigiSoftQcStatus(projectDigiSoft, sbNotQC.toString());
				}
				if(flag && listTmp.size() > 0) {
					setBeanInfo();
					flag = daoPjmAssignJob.moveDataToAncestry(beanInfo, listTmp);
				}
				if(flag) {
					JTableUtil.removeAllRow(tableStatusQC);
				}

			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception("updateFromDigiSoft : "  + e.toString());
		}
		return flag;
	}
	
	
	private void buttonClearActionPerformed(ActionEvent evt) {
		textPaneManagementId.setText("");
		resetCheck(tableField, 2, tableField.getRowCount());
		listDigiSoftManagement.clear();
		listManagement.clear();
		listTmp.clear();
		listIdNotAssign.clear();
		JTableUtil.removeAllRow(tableStatusQC);
	}
	
	/**
	 * load id by filepath and user
	 */
	private void loadIdByPathAndUser() {
		try {
			
			if(checkboxWithForm.isSelected() && comboboxForm.isVisible()) {
				loadForm(false);
			}else {
				if(jListUser.getSelectedIndex() > -1&& jListPath.getSelectedIndex() > -1) {
					textPaneManagementId.setText("");
					listTmp = new ArrayList<String>();
							
					String userType = jListUser.getSelectedValue().toString();
					String filepath = jListPath.getSelectedValue().toString();
						
					listTmp = daoPjmAssignJob.getListIdByFilePath(filepath , userType);
					String ids = StringUtil.join(listTmp, ",");
					textPaneManagementId.setText(ids);
					loadQmdInformation();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgInfo(this, "loadPath : "  + e.toString());
		}
	}
	
	/**
	 * load id by filepath and form
	 */
	private void loadIdByPathAndForm() {
		try {
			
			if(checkboxWithForm.isSelected()) {
				if(jListPath.getSelectedIndex() > -1 && comboboxForm.getSelectedIndex() > -1) {
					textPaneManagementId.setText("");
					listTmp = new ArrayList<String>();
							
					String formid = comboboxForm.getSelectedItem().toString();
					String filepath = jListPath.getSelectedValue().toString();
						
					listTmp = daoPjmAssignJob.getListIdByFilePathAndForm(filepath, formid);
					String ids = StringUtil.join(listTmp, ",");
					textPaneManagementId.setText(ids);
					loadQmdInformation();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgInfo(this, "loadIdByPathAndForm : "  + e.toString());
		}
	}
	
	/**
	 * load from id to id
	 */
	private void loadIdFromTo() {
		try {
			String from = StringUtil.setNotNull(textFieldFrom.getText());
			String to   = StringUtil.setNotNull(textFieldTo.getText());
			String formId = comboboxTopForm.getSelectedItem().toString();
			if(!from.equals("") || !to.equals("")) {
				textPaneManagementId.setText("");
				listTmp = new ArrayList<String>();
						
				listTmp = daoPjmAssignJob.getListIdFromTo(from, to , formId);
				String ids = StringUtil.join(listTmp, ",");
				textPaneManagementId.setText(ids);
				loadQmdInformation();
			}else {
				AppUtility.msgInfo(this, "Please input from id to id !!");
				textFieldFrom.requestFocus();
			}
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgInfo(this, "loadIdByPathAndForm : "  + e.toString());
		}
	}
	


}
