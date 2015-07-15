package com.digitexx.ancestry.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.dao.DaoMoveDataFromTypeToProof;
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
public class FrmCopyDataFormTypeToProof extends javax.swing.JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel panelMain;
	private JSplitPane splitPaneMain;
	private JPanel panelLeft;
	private JButton buttonViewData;
	private JTable tableData;
	private JScrollPane scrollPaneData;
	private JPanel panelListId;
	private JPanel panelData;
	private JSplitPane splitPaneRight;
	private JTable tableColumn;
	private JScrollPane scrollPaneTableColumn;
	private JPanel panelRight;
	private JTextPane textPaneListId;
	private JScrollPane scrollPaneListId;
	private JButton buttonSave;
	private JPanel panelFooter;
	
	private Tbl_Projects project;
	private String userId;
	private FrmStep frmStep;
	private DaoMoveDataFromTypeToProof daoMoveDataFromTypeToProof ;

	public FrmCopyDataFormTypeToProof(Tbl_Projects project , String userId , FrmStep frmStep) {
		super();
		this.project    = project;
		this.userId     = userId;
		this.frmStep    = frmStep;
		daoMoveDataFromTypeToProof = new DaoMoveDataFromTypeToProof();
		initGUI();
		AppUtility.centerFrame(this);
		initData();
	}
	
	private void initGUI() {
		try {
			this.setTitle("Form Move Data Form Type To Proof");
			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			{
				panelMain = new JPanel();
				BorderLayout panelMainLayout = new BorderLayout();
				getContentPane().add(panelMain, new AnchorConstraint(0, 1000, 929, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelMain.setLayout(panelMainLayout);
				panelMain.setPreferredSize(new java.awt.Dimension(1047, 600));
				{
					splitPaneMain = new JSplitPane();
					panelMain.add(splitPaneMain, BorderLayout.CENTER);
					{
						panelLeft = new JPanel();
						BorderLayout jPanel1Layout = new BorderLayout();
						panelLeft.setLayout(jPanel1Layout);
						splitPaneMain.add(panelLeft, JSplitPane.RIGHT);
						{
							splitPaneRight = new JSplitPane();
							panelLeft.add(splitPaneRight, BorderLayout.CENTER);
							splitPaneRight.setOrientation(JSplitPane.VERTICAL_SPLIT);
							splitPaneRight.setDividerLocation(250);
							{
								panelData = new JPanel();
								BorderLayout panelDataLayout = new BorderLayout();
								panelData.setLayout(panelDataLayout);
								splitPaneRight.add(panelData, JSplitPane.RIGHT);
								panelData.setBorder(BorderFactory.createTitledBorder(null, "List Data", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,14)));
								{
									scrollPaneData = new JScrollPane();
									panelData.add(scrollPaneData, BorderLayout.CENTER);
									{
										tableData = new JTable() {
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
										scrollPaneData.setViewportView(tableData);
									}
								}
							}
							{
								panelListId = new JPanel();
								BorderLayout panelListIdLayout = new BorderLayout();
								panelListId.setLayout(panelListIdLayout);
								splitPaneRight.add(panelListId, JSplitPane.LEFT);
								panelListId.setPreferredSize(new java.awt.Dimension(811, 294));
								panelListId.setBorder(BorderFactory.createTitledBorder(null, "List ManagementIds", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,14)));
								{
									scrollPaneListId = new JScrollPane();
									panelListId.add(scrollPaneListId, BorderLayout.CENTER);
									{
										textPaneListId = new JTextPane();
										scrollPaneListId.setViewportView(textPaneListId);
									}
								}
							}
						}
					}
					{
						panelRight = new JPanel();
						BorderLayout jPanel2Layout = new BorderLayout();
						panelRight.setLayout(jPanel2Layout);
						splitPaneMain.add(panelRight, JSplitPane.LEFT);
						panelRight.setPreferredSize(new java.awt.Dimension(225, 644));
						panelRight.setBorder(BorderFactory.createTitledBorder(null, "List Column", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,12), new java.awt.Color(255,0,0)));
						{
							scrollPaneTableColumn = new JScrollPane();
							panelRight.add(scrollPaneTableColumn, BorderLayout.CENTER);
							{
								tableColumn = new JTable() {
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
								scrollPaneTableColumn.setViewportView(tableColumn);
							}
						}
					}
				}
			}
			{
				panelFooter = new JPanel();
				getContentPane().add(panelFooter, new AnchorConstraint(928, 1000, 993, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelFooter.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelFooter.setPreferredSize(new java.awt.Dimension(1047, 42));
				panelFooter.setLayout(null);
				{
					buttonSave = new JButton();
					panelFooter.add(buttonSave);
					buttonSave.setText("Save");
					buttonSave.setBounds(969, 2, 76, 38);
					buttonSave.setFont(new java.awt.Font("Tahoma",1,14));
					buttonSave.setForeground(new java.awt.Color(255,0,0));
					buttonSave.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							try {
								buttonSaveActionPerformed(evt);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					});
				}
				{
					buttonViewData = new JButton();
					panelFooter.add(buttonViewData);
					buttonViewData.setText("View Data");
					buttonViewData.setBounds(2, 2, 130, 38);
					buttonViewData.setFont(new java.awt.Font("Tahoma",1,12));
					buttonViewData.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							buttonViewDataActionPerformed(evt);
						}
					});
				}
			}
			pack();
			this.setSize(1055, 680);
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
	
	private void initData() {
		loadColumNames();
		styleTable(tableColumn);
	}
	
	//==============================================================================================================
	
	/**
	 * load all column name
	 */
	private void loadColumNames() 
	{
		try {
			String [] headers = new String [] { "No." , "Column" , "Check" };
			DefaultTableModel model = new DefaultTableModel(headers , 0);
			ArrayList<String> listColumn = daoMoveDataFromTypeToProof.getListColumType(project);
			if(listColumn.size() > 0) 
			{
				Object [] values;
				int index = 0;
				for (String str : listColumn) {
					values = new Object [] { index , str , Boolean.FALSE  };
					++index;
					model.addRow(values);
				}
				tableColumn.setModel(model);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * load data
	 * @throws Exception 
	 */
	private void loadData(String columns ,  String listIds ) throws Exception
	{
	    List<Object[]> listData = daoMoveDataFromTypeToProof.getListDataTypeByColumn(project, columns, listIds);
	    String [] headers = columns.split(",");
	    
	    DefaultTableModel model = new DefaultTableModel(headers , 0);
	    for (Object[] values : listData) {
			model.addRow(values);
		}
	    tableData.setModel(model);
		styleTable(tableData);
	}
	
	private void buttonViewDataActionPerformed(ActionEvent evt) 
	{
		try 
		{
			String listIds =StringUtil.setNotNull(textPaneListId.getText());
			if(listIds.equals("")) {
				textPaneListId.requestFocus();
				AppUtility.msgError(this, "Please input managementid !!");
			}
			else {
				int totalRow = tableColumn.getRowCount();
			    String check = "";
			    String column = "";
			    ArrayList<String> listColumn = new ArrayList<String>();
				for (int row = 0; row < totalRow; row++) 
				{
					check  = StringUtil.setNotNull(tableColumn.getValueAt(row, 2));
					column = StringUtil.setNotNull(tableColumn.getValueAt(row, 1));
					if(check.equals("true")) {
						listColumn.add(column);
					}
				}
				if(listColumn.size()  >0) 
				{
					String columns = StringUtil.join(listColumn, ",");
                    loadData(columns, listIds);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "buttonViewDataActionPerformed : "  + e.toString());
		}

	}
	
	private void buttonSaveActionPerformed(ActionEvent evt) throws Exception 
	{
		int totalRow = tableData.getRowCount();
		List<String []> listData = new ArrayList<String[]>();
	    String birthPlace = "";
	    String managementid = "";
	    String seq_number;
		for (int row = 0; row < totalRow; row++) 
		{
			birthPlace = StringUtil.setNotNull(JTableUtil.getValuesByHeader(tableData, "birth_place", row));
			managementid = StringUtil.setNotNull(JTableUtil.getValuesByHeader(tableData, "managementid", row));
			seq_number = StringUtil.setNotNull(JTableUtil.getValuesByHeader(tableData, "seq_number", row));
			listData.add(new String [] { birthPlace , managementid , seq_number });
		}
		if(listData.size() > 0) {
			daoMoveDataFromTypeToProof.save( project ,listData);
			buttonViewData.doClick();
		}
	}

}
