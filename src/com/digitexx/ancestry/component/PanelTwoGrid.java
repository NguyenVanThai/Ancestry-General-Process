package com.digitexx.ancestry.component;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
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
public class PanelTwoGrid extends javax.swing.JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JPanel panelGridMain;
	private JScrollPane scrollPaneGridRight;
	private JScrollPane scrollPaneGridLeft;
	private JButton buttonRemoveAll;
	private JButton buttonSelectOne;
	private JButton buttonSelectAll;
	private JLabel jLabel3;
	private JButton buttonRemoveOne;
	private JLabel jLabel2;
	private JPanel panelGridRight;
	private JPanel panelGridCenter;
	private JPanel panelGridLeft;
    private List<String> listAll;
    private List<String> listSelect;
    private PanelGridPath leftPanelGridPath;
    private PanelGridPath rightPanelGridPath;
	
	public PanelTwoGrid(List<String> listAll , String [] arrHeader) {
		super();
		this.listAll = listAll;
		this.listSelect = new ArrayList<String>();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(706, 282));
			BorderLayout thisLayout = new BorderLayout();
			this.setLayout(thisLayout);
			{
				panelGridMain = new JPanel();
				AnchorLayout panelGridMainLayout = new AnchorLayout();
				this.add(panelGridMain, BorderLayout.CENTER);
				panelGridMain.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelGridMain.setLayout(panelGridMainLayout);
				panelGridMain.setPreferredSize(new java.awt.Dimension(675, 263));
				{
					panelGridLeft = new JPanel();
					BorderLayout panelGridLeftLayout = new BorderLayout();
					panelGridLeft.setLayout(panelGridLeftLayout);
					panelGridMain.add(panelGridLeft, new AnchorConstraint(9, 455, 994, 3, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					panelGridLeft.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
					panelGridLeft.setPreferredSize(new java.awt.Dimension(305, 259));
					{
						scrollPaneGridLeft = new JScrollPane();
						panelGridLeft.add(scrollPaneGridLeft, BorderLayout.CENTER);
						{
							leftPanelGridPath  = new PanelGridPath(listAll, new String [] { "No." , "FilePath" });
							scrollPaneGridLeft.setViewportView(leftPanelGridPath);
							leftPanelGridPath.setPreferredSize(new java.awt.Dimension(308, 263));
						}
					}
				}
				{
					panelGridCenter = new JPanel();
					panelGridMain.add(panelGridCenter, new AnchorConstraint(9, 531, 994, 454, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					panelGridCenter.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
					panelGridCenter.setLayout(new GridLayout(7, 1));
					panelGridCenter.setPreferredSize(new java.awt.Dimension(52, 259));
					{
						jLabel2 = new JLabel();
						panelGridCenter.add(jLabel2);
					}
					{
						buttonSelectOne = new JButton();
						panelGridCenter.add(buttonSelectOne);
						buttonSelectOne.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/digitexx/images/right.png")));
						buttonSelectOne.addActionListener(this);
					}
					{
						buttonRemoveOne = new JButton();
						panelGridCenter.add(buttonRemoveOne);
						buttonRemoveOne.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/digitexx/images/left.png")));
						buttonRemoveOne.addActionListener(this);
					}
					{
						jLabel3 = new JLabel();
						panelGridCenter.add(jLabel3);
					}
					{
						buttonSelectAll = new JButton();
						panelGridCenter.add(buttonSelectAll);
						buttonSelectAll.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/digitexx/images/arrow-right-big.png")));
						buttonSelectAll.addActionListener(this);
					}
					{
						buttonRemoveAll = new JButton();
						panelGridCenter.add(buttonRemoveAll);
						buttonRemoveAll.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/digitexx/images/arrow-left-big.png")));
						buttonRemoveAll.addActionListener(this);
					}
				}
				{
					panelGridRight = new JPanel();
					BorderLayout panelGridRightLayout = new BorderLayout();
					panelGridRight.setLayout(panelGridRightLayout);
					panelGridMain.add(panelGridRight, new AnchorConstraint(8, 999, 994, 529, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					panelGridRight.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
					panelGridRight.setPreferredSize(new java.awt.Dimension(317, 286));
					{
						scrollPaneGridRight = new JScrollPane();
						panelGridRight.add(scrollPaneGridRight, BorderLayout.CENTER);
						{
							rightPanelGridPath = new PanelGridPath(listSelect, new String [] { "No." , "FilePath" });
							scrollPaneGridRight.setViewportView(rightPanelGridPath);
							rightPanelGridPath.setPreferredSize(new java.awt.Dimension(311, 270));
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object action = e.getSource();
		if(action == buttonSelectOne) {
			addSelectRow(leftPanelGridPath.getTablePath(), rightPanelGridPath.getTablePath(), leftPanelGridPath.getTablePath().getSelectedRows() , true);
		}
		if(action == buttonRemoveOne) {
			addSelectRow(rightPanelGridPath.getTablePath() ,leftPanelGridPath.getTablePath(), rightPanelGridPath.getTablePath().getSelectedRows() , false);
		}
		if(action == buttonSelectAll) {
			addAllRow(leftPanelGridPath.getTablePath(), rightPanelGridPath.getTablePath() , true);
		}
		if(action == buttonRemoveAll) {
			addAllRow( rightPanelGridPath.getTablePath() , leftPanelGridPath.getTablePath() , false);
		}
	}
	
	//==================================================================================================================

	/**
	 * add select row
	 */
	private void addSelectRow(JTable leftTable , JTable rightTable , int [] rows , boolean isLeft) 
	{
        String filepath = "";
		for (int i : rows) 
		{
			filepath = Objects.toString(JTableUtil.getValuesByHeader(leftTable, "FilePath", i) ,"");
			if(isLeft) {
				rightPanelGridPath.getListPath().add(filepath);
				leftPanelGridPath.getListPath().remove(filepath);
			}else {
				leftPanelGridPath.getListPath().add(filepath);
				rightPanelGridPath.getListPath().remove(filepath);
			}
		}
		rightPanelGridPath.loadPath();
		leftPanelGridPath.loadPath();
	}

	/**
	 * add all row
	 */
	private void addAllRow(JTable leftTable , JTable rightTable , boolean isLeft) 
	{
        String filepath = "";
        int totalRow = leftTable.getRowCount();
        for (int i = 0; i < totalRow; i++) {
			filepath = Objects.toString(JTableUtil.getValuesByHeader(leftTable, "FilePath", i) ,"");
			if(isLeft) {
				rightPanelGridPath.getListPath().add(filepath);
				leftPanelGridPath.getListPath().remove(filepath);
			}else {
				leftPanelGridPath.getListPath().add(filepath);
				rightPanelGridPath.getListPath().remove(filepath);
			}
		}
		rightPanelGridPath.loadPath();
		leftPanelGridPath.loadPath();
	}

	public void reloadData(List<String> listData) 
	{
		leftPanelGridPath.getListPath().clear();
		rightPanelGridPath.getListPath().clear();
		listAll.clear();
		listSelect.clear();
		listAll.addAll(listData);
		leftPanelGridPath.loadPath();
	}
	
	//======================================================================================================================
	
	
	/**
	 * @return the leftPanelGridPath
	 */
	public PanelGridPath getLeftPanelGridPath() {
		return leftPanelGridPath;
	}

	/**
	 * @param leftPanelGridPath the leftPanelGridPath to set
	 */
	public void setLeftPanelGridPath(PanelGridPath leftPanelGridPath) {
		this.leftPanelGridPath = leftPanelGridPath;
	}

	/**
	 * @return the rightPanelGridPath
	 */
	public PanelGridPath getRightPanelGridPath() {
		return rightPanelGridPath;
	}

	/**
	 * @param rightPanelGridPath the rightPanelGridPath to set
	 */
	public void setRightPanelGridPath(PanelGridPath rightPanelGridPath) {
		this.rightPanelGridPath = rightPanelGridPath;
	}
}
