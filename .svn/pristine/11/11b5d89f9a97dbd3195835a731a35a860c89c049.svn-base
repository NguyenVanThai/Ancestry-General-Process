package com.digitexx.ancestry.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.component.PanelTwoJList;
import com.digitexx.ancestry.dao.DaoMoveDataRework;
import com.digitexx.ancestry.db.ConnectionDB;
import com.digitexx.ancestry.util.AppUtility;

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
public class FrmMoveDataBetweenProofAndRework extends javax.swing.JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panelHeader;
	private JPanel panelContent;
	private JPanel panelFooter;
	private JScrollPane scrollPaneLog;
	private ButtonGroup buttonGroup1;
	private JButton buttonRun;
	private JRadioButton radioProof;
	private JRadioButton radioRework;
	private JTextPane textPaneLog;
	private PanelTwoJList panelTwoJList;
	private Tbl_Projects project;
	private FrmStep frmStep;
	private DaoMoveDataRework daoMoveDataRework;
	
	private String userId;
	private List<String> listAllPath;
	private ArrayList<String> listSelect;
	private boolean isRework = true;
	private JCheckBox checkboxLoadAll;
	private boolean isLoadAll = false;;

	public FrmMoveDataBetweenProofAndRework(Tbl_Projects project , String userId , FrmStep frmStep) {
		super();
		this.project = project;
		this.userId  = userId;
		this.frmStep = frmStep;
        initData();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setTitle("Form Moving Data Between Proof and Rework");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			{
				panelHeader = new JPanel();
				BorderLayout panelHeaderLayout = new BorderLayout();
				panelHeader.setLayout(panelHeaderLayout);
				getContentPane().add(panelHeader, new AnchorConstraint(0, 1000, 615, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelHeader.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelHeader.setPreferredSize(new java.awt.Dimension(828, 343));
				{
					panelTwoJList = new PanelTwoJList(listAllPath, listSelect);
					panelHeader.add(panelTwoJList);
				}
			}
			{
				panelContent = new JPanel();
				BorderLayout panelContentLayout = new BorderLayout();
				panelContent.setLayout(panelContentLayout);
				getContentPane().add(panelContent, new AnchorConstraint(615, 1000, 909, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelContent.setBorder(BorderFactory.createTitledBorder(null, "Log Detail", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255,0,0)));
				panelContent.setPreferredSize(new java.awt.Dimension(828, 164));
				{
					scrollPaneLog = new JScrollPane();
					panelContent.add(scrollPaneLog, BorderLayout.CENTER);
					{
						textPaneLog = new JTextPane();
						scrollPaneLog.setViewportView(textPaneLog);
					}
				}
			}
			{
				panelFooter = new JPanel();
				AnchorLayout panelFooterLayout = new AnchorLayout();
				getContentPane().add(panelFooter, new AnchorConstraint(909, 1000, 990, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelFooter.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelFooter.setLayout(panelFooterLayout);
				panelFooter.setPreferredSize(new java.awt.Dimension(828, 45));
				{
					radioRework = new JRadioButton();
					panelFooter.add(getCheckboxLoadAll(), new AnchorConstraint(55, 708, 966, 300, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					panelFooter.add(radioRework, new AnchorConstraint(55, 133, 966, 3, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					radioRework.setText("To Rework");
					radioRework.setFont(new java.awt.Font("Arial",1,14));
					radioRework.setForeground(new java.awt.Color(255,0,0));
					radioRework.setPreferredSize(new java.awt.Dimension(108, 41));
					radioRework.addActionListener(this);
					radioRework.setSelected(true);
					getButtonGroup1().add(radioRework);
				}
				{
					radioProof = new JRadioButton();
					panelFooter.add(radioProof, new AnchorConstraint(55, 259, 966, 138, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					radioProof.setText("To Proof");
					radioProof.setFont(new java.awt.Font("Arial",1,14));
					radioProof.setForeground(new java.awt.Color(0,0,255));
					radioProof.setPreferredSize(new java.awt.Dimension(100, 41));
					radioProof.addActionListener(this);
					getButtonGroup1().add(radioProof);
				}
				{
					buttonRun = new JButton();
					panelFooter.add(buttonRun, new AnchorConstraint(55, 998, 966, 911, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonRun.setText("Run");
					buttonRun.setFont(new java.awt.Font("Arial",1,14));
					buttonRun.setForeground(new java.awt.Color(255,0,0));
					buttonRun.setPreferredSize(new java.awt.Dimension(72, 41));
					buttonRun.addActionListener(this);
				}
			}
			pack();
			this.setSize(836, 592);
			AppUtility.centerFrame(this);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					exit();
				}
			});
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		if(ConnectionDB.open_load_all.equals("0")) {
			checkboxLoadAll.setVisible(false);
		}
	}
	
	private void initData() 
	{
		listAllPath = new ArrayList<String>();
		listSelect = new ArrayList<String>();
		loadPath();
	}
	
	private void exit() {
		if(AppUtility.msgConfirm(this, "Do you want to exit ??") == JOptionPane.OK_OPTION) {
			frmStep.setVisible(true);
			this.dispose();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object action = e.getSource();
		if(action == radioProof) {
			if(radioProof.isSelected()) {
				isRework = false;
				reloadPath();
			}
		}
        if(action == radioRework) {
			if(radioRework.isSelected()) {
				isRework = true;
				reloadPath();
			}
		}
		if(action == buttonRun) {
			runMoveData();
		}
	}
	
	private ButtonGroup getButtonGroup1() {
		if(buttonGroup1 == null) {
			buttonGroup1 = new ButtonGroup();
		}
		return buttonGroup1;
	}
	
	private JCheckBox getCheckboxLoadAll() {
		if(checkboxLoadAll == null) {
			checkboxLoadAll = new JCheckBox();
			checkboxLoadAll.setText("Load All Path ( Contact SDD When Using )");
			checkboxLoadAll.setPreferredSize(new java.awt.Dimension(338, 41));
			checkboxLoadAll.setFont(new java.awt.Font("Arial",1,14));
			checkboxLoadAll.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					checkboxLoadAllActionPerformed(evt);
				}
			});
		}
		return checkboxLoadAll;
	}
	
	private void checkboxLoadAllActionPerformed(ActionEvent evt) {
		if(checkboxLoadAll.isSelected()) {
			isLoadAll = true;
		}else {
			isLoadAll = false;
		}
		reloadPath();
	}
	
	//=======================================================================================================================
	
	/**
	 * load all filepath
	 */
	private void loadPath() {

		try {
			daoMoveDataRework = new DaoMoveDataRework(project);
			listAllPath = new ArrayList<String>();
			
			if(checkboxLoadAll != null && checkboxLoadAll.isSelected()) {
				isLoadAll = true;
			}
			listAllPath = daoMoveDataRework.getListPath(isRework , isLoadAll);
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgInfo(this, "loadPath : "  + e.toString());
		}
	}
	
	/**
	 * reload data
	 */
	private void reloadPath() {
		
		try {
			listAllPath = new ArrayList<String>();
			listAllPath = daoMoveDataRework.getListPath(isRework , isLoadAll);
			panelTwoJList.reloadData(listAllPath);
		} 
		catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgInfo(this, "loadPath : "  + e.toString());
		}
		
	}
	
	/**
	 * process move data
	 */
	private void runMoveData() 
	{
        String message = "";
        if(isRework) {
        	message = "Do you want to move data from PROOF to REWORK ??";
        }else {
        	message = "Do you want to move data from REWORK to PROOF ??";
        }
		if(AppUtility.msgConfirm(this,message) == JOptionPane.OK_OPTION) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public synchronized void run() {
					try {
						moveDataByFilePath();
					} catch (Exception e) {
						e.printStackTrace();
						AppUtility.msgError(null, "runMoveData : "  + e.toString());
					}
				}
			});
			thread.start();
		}
	}
	
	public void moveDataByFilePath() throws Exception
	{
		try {
			ArrayList<String> listPathRun = new ArrayList<String>();
			if(panelTwoJList.getListSelect().size() >0) {
				listPathRun.addAll(panelTwoJList.getListSelect());
			}else {
				listPathRun.addAll(panelTwoJList.getListSelect());
			}
			if(listPathRun.size() > 0)
			{
				boolean flag = true;
				try {
					for (String path : listPathRun) {
						if(isRework) {
							daoMoveDataRework.moveDataFromProofToRework(path);
						}else {
							daoMoveDataRework.moveDataFromReworkToProof(path);
						}
					}
					if(flag) {
						AppUtility.msgInfo(this, "Move data successfully !!");
					}
				} 
				catch (Exception e) {
					e.printStackTrace();
					AppUtility.appendText(textPaneLog, e.toString() , Color.RED);
				}

			}else {
				AppUtility.msgInfo(this, "Please select path to run !!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("moveDataByFilePath : "  + e.toString());
		}

	}
	


}
