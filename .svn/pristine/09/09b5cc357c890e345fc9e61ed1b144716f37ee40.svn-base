package com.digitexx.ancestry.gui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.ancestry.bean.Management;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.dao.DaoSetPriorityGetjob;
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
public class FrmSetPriorityGetJob extends javax.swing.JFrame 
{
	private JPanel panelContent;
	private JPanel panelFooter;
	private JButton buttonApply;
	private FrmStep frmStep ;
	private String userId ;
	private Tbl_Projects project;
	private JPanel panelLeft;
	private JTable tableUser;
	private JTable tablePath;
	private JScrollPane scrollPaneUser;
	private JScrollPane scrollPanePath;
	private JPanel panelPath;
	private JPanel panelUser;
	private JSplitPane splitPaneRight;
	private JScrollPane scrollPaneRight;
	private JTable tablePhase;
	private JPanel panelRight;
	private JScrollPane scrollPaneLeft;
	private JSplitPane splitPaneContent;
	private List<String> listPath;
	private DefaultTableModel modelPhase;
	private DefaultTableModel modelPath;
	private DefaultTableModel modelUser;
	private Map<String , String> mapPhasePriority;
	private DaoSetPriorityGetjob daoSetPriorityGetjob;
	private List<Management> listManagement;

	public FrmSetPriorityGetJob(FrmStep frmStep, String userId , Tbl_Projects project) {
		super();
		this.frmStep = frmStep;
		this.userId  = userId;
		this.project = project;
		daoSetPriorityGetjob = new DaoSetPriorityGetjob(project);
		initGUI();
		loadPhaseName();
	}
	
	private void initGUI() {
		try {
			setTitle("Form Set Priority Get Job");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			{
				panelContent = new JPanel();
				BorderLayout panelContentLayout = new BorderLayout();
				panelContent.setLayout(panelContentLayout);
				getContentPane().add(panelContent, new AnchorConstraint(1, 1000, 938, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelContent.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelContent.setPreferredSize(new java.awt.Dimension(812, 463));
				{
					splitPaneContent = new JSplitPane();
					panelContent.add(splitPaneContent, BorderLayout.CENTER);
					splitPaneContent.setDividerLocation(300);
					{
						panelRight = new JPanel();
						BorderLayout panelRightLayout = new BorderLayout();
						panelRight.setLayout(panelRightLayout);
						splitPaneContent.add(panelRight, JSplitPane.RIGHT);
						panelRight.setBorder(BorderFactory.createTitledBorder(null, "File Path", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,12), new java.awt.Color(255,0,0)));
						{
							scrollPaneRight = new JScrollPane();
							panelRight.add(scrollPaneRight, BorderLayout.CENTER);
							{
								splitPaneRight = new JSplitPane();
								scrollPaneRight.setViewportView(splitPaneRight);
								splitPaneRight.setOrientation(JSplitPane.VERTICAL_SPLIT);
								splitPaneRight.setDividerLocation(100);
								{
									panelUser = new JPanel();
									BorderLayout panelUserLayout = new BorderLayout();
									panelUser.setLayout(panelUserLayout);
									splitPaneRight.add(panelUser, JSplitPane.RIGHT);
									{
										scrollPaneUser = new JScrollPane();
										panelUser.add(scrollPaneUser, BorderLayout.CENTER);
										scrollPaneUser.setPreferredSize(new java.awt.Dimension(654, 232));
										{
											tableUser = new JTable();
											scrollPaneUser.setViewportView(tableUser);
										}
									}
								}
								{
									panelPath = new JPanel();
									BorderLayout panelPathLayout = new BorderLayout();
									panelPath.setLayout(panelPathLayout);
									splitPaneRight.add(panelPath, JSplitPane.LEFT);
									panelPath.setPreferredSize(new java.awt.Dimension(654, 240));
									{
										scrollPanePath = new JScrollPane();
										panelPath.add(scrollPanePath, BorderLayout.CENTER);
										{
											tablePath = new JTable();
											scrollPanePath.setViewportView(tablePath);
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
						panelLeft.setPreferredSize(new java.awt.Dimension(247, 457));
						panelLeft.setBorder(BorderFactory.createTitledBorder(null, "Phase", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,12), new java.awt.Color(255,0,0)));
						{
							scrollPaneLeft = new JScrollPane();
							panelLeft.add(scrollPaneLeft, BorderLayout.CENTER);
							{
								tablePhase = new JTable() {
									@Override
									public boolean isCellEditable(int row,int column) {
										if(getColumnName(column).equals("Priority")) {
											return true;
										}else {
											return false;
										}
									}
								};
								scrollPaneLeft.setViewportView(tablePhase);
								tablePhase.getSelectionModel().addListSelectionListener(
										new ListSelectionListener() {
											@Override
											public void valueChanged(ListSelectionEvent e) {
												if (!e.getValueIsAdjusting()) {
													valueChangeTable(tablePhase.getSelectedRow());
												}
											}
								});
							}
						}
					}
				}
			}
			{
				panelFooter = new JPanel();
				AnchorLayout panelFooterLayout = new AnchorLayout();
				getContentPane().add(panelFooter, new AnchorConstraint(938, 1000, 1001, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelFooter.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelFooter.setLayout(panelFooterLayout);
				panelFooter.setPreferredSize(new java.awt.Dimension(812, 31));
				{
					buttonApply = new JButton();
					panelFooter.add(buttonApply, new AnchorConstraint(73, 155, 955, 1, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonApply.setText("Apply Priority");
					buttonApply.setFont(new java.awt.Font("Tahoma",1,14));
					buttonApply.setPreferredSize(new java.awt.Dimension(151, 30));
					buttonApply.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							buttonApplyActionPerformed(evt);
						}
					});
				}
			}
			pack();
			this.setSize(989, 580);
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

	
	private void buttonApplyActionPerformed(ActionEvent evt) {
		applyPriority();
	}
	
	//====================================================================================================================
	
	private void valueChangeTable(int row) {
		try {
			String phase = Objects.toString( JTableUtil.getValuesByHeader(tablePhase, "Phase", row) , "");
			loadPathByPhase(row , phase);
			loadUserGetJob(phase);
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgInfo(this, "comboboxPhaseActionPerformed : "  + e.toString());
		}
	}
	
	private void loadPathByPhase(int row , String phase) throws Exception
	{
		try {
			listPath = new ArrayList<String>();
			listPath = daoSetPriorityGetjob.getListPathByPhaseName(phase);
			modelPath = new DefaultTableModel( new String [] {"No." , "FilePath"} , 0);
			JTableUtil.removeAllRow(tablePath);
			
			Object [] values ;
			int index = 0 ;
			for (String str : listPath) {
				values = new Object [] { (index+1) , str };
				modelPath.addRow(values);
				++index;
			}
			tablePath.setModel(modelPath);
			JTableUtil.styleTable(tablePath, false);
            JTableUtil.fitTableColumns(tablePath);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("loadPathByPhase : "  + e.toString());
		}
	}
	
	private void loadPhaseName() {
		try {
			
			mapPhasePriority = new HashMap<String, String>();
			mapPhasePriority = daoSetPriorityGetjob.getMapPhasePriority();
			
			List<String> listPhaseName = new ArrayList<String>();
			listPhaseName = daoSetPriorityGetjob.getListPhasePms(project.getProj_id());
			modelPhase = new DefaultTableModel(new String [] { "No." , "Phase" , "Priority" } , 0);
			
			int index = 0;
			Object [] values = null;
			String priority = "0";
			for (String str : listPhaseName) 
			{
				if(mapPhasePriority.containsKey(str)) {
					priority = mapPhasePriority.get(str);
				}else {
					priority = "0";
				}
				values = new Object [] { (index+1) , str , Integer.parseInt(priority) };
				modelPhase.addRow(values);
				++index;
			}
			tablePhase.setModel(modelPhase);
			JTableUtil.styleTable(tablePhase, false);
			JTableUtil.fitTableColumns(tablePhase);
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgInfo(this, "loadPhaseName : "  + e.toString());
		}
	}
	
	private void loadUserGetJob(String phase) throws Exception {
		try {
			listManagement = new ArrayList<Management>();
			listManagement = daoSetPriorityGetjob.getUserGetJobByPhaseName(phase);
			modelUser = new DefaultTableModel( new String [] {"No." , "Id" , "FileName" , "User" , "Step"} , 0);
			JTableUtil.removeAllRow(tableUser);
			
			Object [] values ;
			int index = 1 ;
			for (Management management : listManagement) {
				values = new Object []  { index , management.getId() ,management.getFilename() , management.getPresent_user() , management.getStep() } ;
				modelUser.addRow(values);
				++index;
			}
			tableUser.setModel(modelUser);
			JTableUtil.styleTable(tableUser, true);
			JTableUtil.fitTableColumns(tableUser);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("loadUserGetJob : "  + e.toString());
		}
	}
	
	public boolean applyPriority() 
	{
		boolean flag = true;
		try {
	        int totalRow = tablePhase.getRowCount();
	        
	        String priority = "";
	        String phase = "";
	        List<String> listPath;
			for (int row = 0; row < totalRow; row++) 
			{
				flag = false;
				priority = Objects.toString(JTableUtil.getValuesByHeaderName(tablePhase, "Priority", row), "");
				phase    = Objects.toString(JTableUtil.getValuesByHeaderName(tablePhase, "Phase", row), "");

				if(!StringUtil.isNumeric(priority)) {
					AppUtility.msgError(this, "Dòng "  + (row + 1 ) + " nhập  giá trị cột priority không hợp lệ !!");
					flag = false;
					break;
				}
				else {
					listPath = new ArrayList<String>();
					listPath = daoSetPriorityGetjob.getListPathByPhaseName(phase);
					if(listPath.size() > 0) {
						flag = daoSetPriorityGetjob.savePhase(phase, priority , listPath);
					}else {
						flag = true;
						continue;
					}
					if(!flag) {
						break;
					}
				}
				if(! flag) {
					break;
				}
			}
			if(flag) {
				AppUtility.msgInfo(this, "Process priority completed!!");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgInfo(this, "applyPriority : "  + e.toString());
		}
		return flag;
	}

}
