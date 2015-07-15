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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.ancestry.dao.DaoInfoGroupUser;
import com.digitexx.ancestry.db.ConnectionDB;
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
public class FrmInfoGroupUser extends javax.swing.JFrame {
	private JPanel panelHeader;
	private JPanel panelContent;
	private JLabel jLabel2;
	private JTextField textField;
	private JComboBox comboboxPJM;
	private JLabel jLabel1;
	private JScrollPane scrollPaneData;
	private JScrollPane scrollPaneFooter;
	private JTable tableUser;
	private JTextPane textPaneUser;
	private JButton buttonGetUserByGroup;
	private JPanel panelFooter;
	
	private Map<Integer , String> mapGroup = new HashMap<Integer, String>();
	private List<Object[]> listUser = new ArrayList<Object[]>();
	private DaoInfoGroupUser daoInfoGroupUser = new DaoInfoGroupUser();
	private DefaultTableModel model;
	private List<String> listTmp = new ArrayList<String>();
    private FrmStep frmStep;
	
	public FrmInfoGroupUser(FrmStep frmStep) {
		super();
		this.frmStep = frmStep;
		initGUI();
		loadGroup();
		loadUserByPJM();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			{
				panelHeader = new JPanel();
				AnchorLayout panelHeaderLayout = new AnchorLayout();
				getContentPane().add(panelHeader, new AnchorConstraint(0, 1000, 64, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelHeader.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelHeader.setLayout(panelHeaderLayout);
				panelHeader.setPreferredSize(new java.awt.Dimension(893, 34));
				{
					jLabel1 = new JLabel();
					panelHeader.add(jLabel1, new AnchorConstraint(73, 57, 955, 10, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jLabel1.setText("PJM");
					jLabel1.setFont(new java.awt.Font("Tahoma",1,14));
					jLabel1.setBorder(new LineBorder(new java.awt.Color(255,0,0), 1, false));
					jLabel1.setForeground(new java.awt.Color(255,0,0));
					jLabel1.setPreferredSize(new java.awt.Dimension(42, 30));
					jLabel1.setBounds(8, 2, 42, 30);
				}
				{
					comboboxPJM = new JComboBox();
					panelHeader.add(comboboxPJM, new AnchorConstraint(73, 445, 955, 64, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					comboboxPJM.setFont(new java.awt.Font("Tahoma",1,14));
					comboboxPJM.setPreferredSize(new java.awt.Dimension(340, 30));
					comboboxPJM.setBounds(57, 2, 340, 30);
					comboboxPJM.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							comboboxPJMActionPerformed(evt);
						}
					});
				}
				{
					textField = new JTextField();
					panelHeader.add(textField, new AnchorConstraint(73, 839, 955, 527, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					textField.setFont(new java.awt.Font("Tahoma",1,16));
					textField.setPreferredSize(new java.awt.Dimension(315, 30));
				}
				{
					jLabel2 = new JLabel();
					panelHeader.add(jLabel2, new AnchorConstraint(44, 527, 926, 456, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jLabel2.setText("Search");
					jLabel2.setBorder(new LineBorder(new java.awt.Color(255,0,0), 1, false));
					jLabel2.setFont(new java.awt.Font("Tahoma",1,14));
					jLabel2.setForeground(new java.awt.Color(255,0,0));
					jLabel2.setPreferredSize(new java.awt.Dimension(71, 30));
				}
				{
					buttonGetUserByGroup = new JButton();
					panelHeader.add(buttonGetUserByGroup, new AnchorConstraint(73, 996, 955, 838, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonGetUserByGroup.setText("Get User By Group");
					buttonGetUserByGroup.setFont(new java.awt.Font("Arial",1,14));
					buttonGetUserByGroup.setForeground(new java.awt.Color(255,0,0));
					buttonGetUserByGroup.setPreferredSize(new java.awt.Dimension(159, 30));
					buttonGetUserByGroup.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							buttonGetUserByGroupActionPerformed(evt);
						}
					});
				}
			}
			{
				panelContent = new JPanel();
				BorderLayout panelContentLayout = new BorderLayout();
				panelContent.setLayout(panelContentLayout);
				getContentPane().add(panelContent, new AnchorConstraint(64, 1000, 743, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelContent.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelContent.setPreferredSize(new java.awt.Dimension(893, 365));
				{
					scrollPaneData = new JScrollPane();
					panelContent.add(scrollPaneData, BorderLayout.CENTER);
					{
						tableUser = new JTable() {
							@Override
							public boolean isCellEditable(int row,int column) {
								return false;
							}
						};
						scrollPaneData.setViewportView(tableUser);
					}
				}
			}
			{
				panelFooter = new JPanel();
				BorderLayout panelFooterLayout = new BorderLayout();
				panelFooter.setLayout(panelFooterLayout);
				getContentPane().add(panelFooter, new AnchorConstraint(742, 1000, 999, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelFooter.setEnabled(false);
				panelFooter.setBorder(BorderFactory.createTitledBorder("Users"));
				panelFooter.setPreferredSize(new java.awt.Dimension(893, 138));
				{
					scrollPaneFooter = new JScrollPane();
					panelFooter.add(scrollPaneFooter, BorderLayout.CENTER);
					scrollPaneFooter.setFont(new java.awt.Font("Dialog",0,16));
					{
						textPaneUser = new JTextPane();
						scrollPaneFooter.setViewportView(textPaneUser);
						textPaneUser.setFont(new java.awt.Font("Tahoma",0,14));
					}
				}
			}
			pack();
			this.setSize(1135, 571);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					exit();
				}
			});
			AppUtility.centerFrame(this);
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
	
	/**
	 * load all group in PMS
	 */
	private void loadGroup() 
	{
		try {
			mapGroup = new HashMap<Integer , String>();
			mapGroup = daoInfoGroupUser.getListGroupPMS(ConnectionDB.host);
			comboboxPJM.removeAllItems();
			comboboxPJM.addItem("All");
			String groupName = "";
			for (int group_id : mapGroup.keySet()) {
				groupName = mapGroup.get(group_id);
				comboboxPJM.addItem(groupName);
			}
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgInfo(this, "loadGroup : "  + e.toString());
		}
	}
	
	/**
	 * get group_id from map
	 */
	private int getGroupId(String value) {
		int group_id =-1;
		for (int key :  mapGroup.keySet()) {
			if(value.equals(mapGroup.get(key))) {
				group_id = key;
				break;
			}
		}
		return group_id;
	}
	
	/**
	 * load user by PJM
	 */
	private void loadUserByPJM() {
        try {
        	if(comboboxPJM.getSelectedIndex() > 0) 
        	{
    			listUser = new ArrayList<Object[]>();
    			int group_id = getGroupId(comboboxPJM.getSelectedItem().toString());
    			listUser =  daoInfoGroupUser.getListUserByPjm(group_id, ConnectionDB.host , false);
        	}else if(comboboxPJM.getSelectedIndex() ==0)  {
    			listUser = new ArrayList<Object[]>();
    			listUser =  daoInfoGroupUser.getListUserByPjm(0, ConnectionDB.host , true);
        	}
        	JTableUtil.removeAllRow(tableUser);
        	String [] arrHeader = new String [] { "No." , "User" , "FullName" , "Group" };
        	JTableUtil.loadListObjectToGrid(arrHeader, tableUser, listUser, textField, true);
        	JTableUtil.styleTableWithValue(tableUser ,30 , 20, true);
        	JTableUtil.fitTableColumns(tableUser);
        	
        	textPaneUser.setText("");
        	listTmp = new ArrayList<String>();
        	for (Object [] arr : listUser) {
				listTmp.add(arr[0].toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgInfo(this, "loadUserByPJM : "  + e.toString());
		}
	}
	
	/**
	 * set value from jtable to jtextpane
	 * after filter value in jtable
	 */
	private void setValueFromTableToTextPane() {

		int totalRow = tableUser.getRowCount();
		listTmp = new ArrayList<String>();
		for (int i = 0; i < totalRow; i++) {
			listTmp.add(JTableUtil.getValuesByHeaderName(tableUser, "User", i));
		}
    	textPaneUser.setText(com.digitexx.ancestry.util.StringUtil.join(listTmp, ","));
	}
	
	private void comboboxPJMActionPerformed(ActionEvent evt) {
		loadUserByPJM();
	}
	
	private void buttonGetUserByGroupActionPerformed(ActionEvent evt) {
		setValueFromTableToTextPane();
	}

}
