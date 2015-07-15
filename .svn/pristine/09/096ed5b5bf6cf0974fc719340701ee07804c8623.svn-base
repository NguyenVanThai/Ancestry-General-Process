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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
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
import javax.swing.table.JTableHeader;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.component.PanelGridPath;
import com.digitexx.ancestry.dao.DaoReturnJobWithField;
import com.digitexx.ancestry.gui.util.WrapEditorKit;
import com.digitexx.ancestry.table.render.NumberOnly;
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
public class FrmReturnJobWithField extends javax.swing.JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JPanel panelHeader;
	private JPanel panelContent;
	private JPanel panelLeft;
	private JButton buttonGetData;
	private JTextField txtTo;
	private JLabel jLabel2;
	private JTextField txtFrom;
	private JLabel jLabel1;
	private JButton buttonClear;
	private JTextPane textPaneListManagementId;
	private JScrollPane scrollPaneListManagementId;
	private JScrollPane scrollPanePath;
	private JTable tableField;
	private JScrollPane scrollPaneField;
	private JPanel panelRigth;
	private JSplitPane splitPaneData;
	private JPanel panelPath;
	private JPanel panelData;
	private JSplitPane splitPaneContent;
	private JRadioButton radioProof;
	private ButtonGroup buttonGroup;
	private JButton buttonAssign;
	private JButton buttonCancel;
	private JRadioButton radioRework;
	private PanelGridPath panelGridPath;
	private Tbl_Projects project;
	private DaoReturnJobWithField daoReturnJobWithField;
	private List<String> listPath;
	private FrmStep frmStep ; 
	private List<String> listIds;
	private JTable tablePath;
	private List<String> listFieldSelect;
	
	private String userId ;  
	private boolean isRework;
	private int status = 1;

	public FrmReturnJobWithField(FrmStep frmStep, String userId , Tbl_Projects project) {
		super();
		this.frmStep = frmStep;
		this.userId  = userId;
		this.project = project;
		daoReturnJobWithField = new DaoReturnJobWithField(project , this);
		initData();
		initGUI();
		AppUtility.centerFrame(this);
		loadField();
	}
	
	private void initGUI() {
		try {
			this.setTitle("Form Assign Proof & Rework With Fields");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setPreferredSize(new java.awt.Dimension(1066, 623));
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			{
				panelHeader = new JPanel();
				AnchorLayout panelHeaderLayout = new AnchorLayout();
				getContentPane().add(panelHeader, new AnchorConstraint(0, 1000, 58, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelHeader.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelHeader.setLayout(panelHeaderLayout);
				panelHeader.setPreferredSize(new java.awt.Dimension(1002, 34));
				{
					radioProof = new JRadioButton();
					panelHeader.add(getButtonGetData(), new AnchorConstraint(14, 764, 955, 676, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					panelHeader.add(getButtonClear(), new AnchorConstraint(14, 844, 955, 767, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					panelHeader.add(radioProof, new AnchorConstraint(73, 73, 955, 2, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					radioProof.setText("Proof");
					radioProof.setFont(new java.awt.Font("Arial",1,12));
					radioProof.setForeground(new java.awt.Color(0,0,255));
					radioProof.setPreferredSize(new java.awt.Dimension(71, 30));
					radioProof.setBounds(2, 2, 71, 30);
					getButtonGroup().add(radioProof);
					radioProof.setSelected(true);
					radioProof.addActionListener(this);
				}
				{
					radioRework = new JRadioButton();
					panelHeader.add(radioRework, new AnchorConstraint(14, 204, 897, 102, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					radioRework.setText("Rework");
					radioRework.setFont(new java.awt.Font("Arial",1,12));
					radioRework.setForeground(new java.awt.Color(0,0,255));
					radioRework.setPreferredSize(new java.awt.Dimension(102, 30));
					radioRework.setBounds(102, 0, 102, 30);
					getButtonGroup().add(radioRework);
					radioRework.addActionListener(this);
				}
				{
					buttonCancel = new JButton();
					panelHeader.add(buttonCancel, new AnchorConstraint(14, 997, 955, 927, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonCancel.setText("Cancel");
					buttonCancel.setFont(new java.awt.Font("Arial",1,12));
					buttonCancel.setForeground(new java.awt.Color(255,0,0));
					buttonCancel.setPreferredSize(new java.awt.Dimension(70, 32));
				}
				{
					buttonAssign = new JButton();
					panelHeader.add(buttonAssign, new AnchorConstraint(44, 926, 926, 845, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					panelHeader.add(getJLabel1(), new AnchorConstraint(73, 274, 955, 217, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					panelHeader.add(getTxtFrom(), new AnchorConstraint(73, 454, 955, 273, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					panelHeader.add(getJLabel2(), new AnchorConstraint(73, 493, 955, 454, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					panelHeader.add(getTxtTo(), new AnchorConstraint(44, 676, 985, 494, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonAssign.setText("Assign");
					buttonAssign.setFont(new java.awt.Font("Arial",1,12));
					buttonAssign.setForeground(new java.awt.Color(255,0,0));
					buttonAssign.setPreferredSize(new java.awt.Dimension(81, 30));
					buttonAssign.addActionListener(this);
				}
			}
			{
				panelContent = new JPanel();
				BorderLayout panelPathLayout = new BorderLayout();
				panelContent.setLayout(panelPathLayout);
				getContentPane().add(panelContent, new AnchorConstraint(55, 1000, 1000, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelContent.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelContent.setPreferredSize(new java.awt.Dimension(1002, 557));
				panelContent.setForeground(new java.awt.Color(64,0,0));
				panelContent.add(getSplitPaneContent(), BorderLayout.CENTER);
			}
			pack();
			this.setSize(1066, 623);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					exit();
				}
			});
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private ButtonGroup getButtonGroup() {
		if(buttonGroup == null) {
			buttonGroup = new ButtonGroup();
		}
		return buttonGroup;
	}
	
	
	private JSplitPane getSplitPaneContent() {
		if(splitPaneContent == null) {
			splitPaneContent = new JSplitPane();
			splitPaneContent.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPaneContent.add(getJPanel1(), JSplitPane.RIGHT);
			splitPaneContent.add(getJPanel2(), JSplitPane.LEFT);
		}
		return splitPaneContent;
	}
	
	private JPanel getJPanel1() {
		if(panelData == null) {
			panelData = new JPanel();
			BorderLayout panelDataLayout = new BorderLayout();
			panelData.setLayout(panelDataLayout);
			panelData.add(getSplitPaneData(), BorderLayout.CENTER);
		}
		return panelData;
	}
	
	private JPanel getJPanel2() {
		if(panelPath == null) {
			panelPath = new JPanel();
			BorderLayout panelPathLayout1 = new BorderLayout();
			panelPath.setLayout(panelPathLayout1);
			panelPath.setPreferredSize(new java.awt.Dimension(996, 251));
			panelPath.add(getScrollPanePath(), BorderLayout.CENTER);
		}
		return panelPath;
	}
	
	private JSplitPane getSplitPaneData() {
		if(splitPaneData == null) {
			splitPaneData = new JSplitPane();
			splitPaneData.setDividerLocation(300);
			splitPaneData.add(getJPanel1x(), JSplitPane.RIGHT);
			splitPaneData.add(getJPanel2x(), JSplitPane.LEFT);
		}
		return splitPaneData;
	}
	
	private JPanel getJPanel1x() {
		if(panelRigth == null) {
			panelRigth = new JPanel();
			BorderLayout panelRigthLayout = new BorderLayout();
			panelRigth.setLayout(panelRigthLayout);
			panelRigth.setPreferredSize(new java.awt.Dimension(726, 291));
			panelRigth.setBorder(BorderFactory.createTitledBorder(null, "List ManagementIds", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,12), new java.awt.Color(255,0,0)));
			panelRigth.add(getScrollPaneListManagementId(), BorderLayout.CENTER);
		}
		return panelRigth;
	}
	
	private JPanel getJPanel2x() {
		if(panelLeft == null) {
			panelLeft = new JPanel();
			BorderLayout panelLeftLayout = new BorderLayout();
			panelLeft.setLayout(panelLeftLayout);
			panelLeft.setPreferredSize(new java.awt.Dimension(421, 291));
			panelLeft.setBorder(BorderFactory.createTitledBorder(null, "List Fields", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,12), new java.awt.Color(255,0,0)));
			panelLeft.add(getScrollPaneField(), BorderLayout.CENTER);
		}
		return panelLeft;
	}
	
	private JScrollPane getScrollPaneField() {
		if(scrollPaneField == null) {
			scrollPaneField = new JScrollPane();
			scrollPaneField.setViewportView(getTableField());
		}
		return scrollPaneField;
	}
	
	private JTable getTableField() {
		if(tableField == null) {
			tableField = new JTable() {
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

		}
		return tableField;
	}

	private JScrollPane getScrollPanePath() {
		if(scrollPanePath == null) {
			scrollPanePath = new JScrollPane();
			{
				panelGridPath = new PanelGridPath(listPath, new String [] { "No." , "FilePath" });
				scrollPanePath.setViewportView(panelGridPath);
				panelGridPath.setPreferredSize(new java.awt.Dimension(978, 246));
				tablePath = panelGridPath.getTablePath();
				tablePath.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						System.out.println();
						valueChangeAction();
					}
				});
			}
		}
		return scrollPanePath;
	}
	
	
	private JScrollPane getScrollPaneListManagementId() {
		if(scrollPaneListManagementId == null) {
			scrollPaneListManagementId = new JScrollPane();
			scrollPaneListManagementId.setViewportView(getTextPaneListManagementId());
		}
		return scrollPaneListManagementId;
	}
	
	private JTextPane getTextPaneListManagementId() {
		if(textPaneListManagementId == null) {
			textPaneListManagementId = new JTextPane();
			textPaneListManagementId.setEditorKit(new WrapEditorKit());
			textPaneListManagementId.setFont(new java.awt.Font("Arial",0,14));
		}
		return textPaneListManagementId;
	}
	
	
	private JButton getButtonClear() {
		if(buttonClear == null) {
			buttonClear = new JButton();
			buttonClear.setText("Clear");
			buttonClear.setPreferredSize(new java.awt.Dimension(77, 32));
			buttonClear.setFont(new java.awt.Font("Arial",1,12));
			buttonClear.addActionListener(this);
		}
		return buttonClear;
	}
	
	
	private JLabel getJLabel1() {
		if(jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("From ID: ");
			jLabel1.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			jLabel1.setFont(new java.awt.Font("Tahoma",1,11));
			jLabel1.setPreferredSize(new java.awt.Dimension(60, 30));
			jLabel1.setForeground(new java.awt.Color(255,0,0));
		}
		return jLabel1;
	}
	
	private JTextField getTxtFrom() {
		if(txtFrom == null) {
			txtFrom = new JTextField();
			txtFrom.setFont(new java.awt.Font("Tahoma",1,12));
			txtFrom.setPreferredSize(new java.awt.Dimension(181, 30));
			txtFrom.setDocument(new NumberOnly());
		}
		return txtFrom;
	}
	
	private JLabel getJLabel2() {
		if(jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("To ID:");
			jLabel2.setFont(new java.awt.Font("Tahoma",1,11));
			jLabel2.setPreferredSize(new java.awt.Dimension(42, 30));
			jLabel2.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			jLabel2.setForeground(new java.awt.Color(255,0,0));
		}
		return jLabel2;
	}
	
	private JTextField getTxtTo() {
		if(txtTo == null) {
			txtTo = new JTextField();
			txtTo.setFont(new java.awt.Font("Tahoma",1,12));
			txtTo.setPreferredSize(new java.awt.Dimension(182, 32));
			txtTo.setDocument(new NumberOnly());
		}
		return txtTo;
	}
	
	private JButton getButtonGetData() {
		if(buttonGetData == null) {
			buttonGetData = new JButton();
			buttonGetData.setText("Get Data");
			buttonGetData.setPreferredSize(new java.awt.Dimension(89, 32));
			buttonGetData.setFont(new java.awt.Font("Arial",1,12));
			buttonGetData.addActionListener(this);
		}
		return buttonGetData;
	}

	//====================================================================================================================

	private void exit() {
		if(AppUtility.msgConfirm(this, "Do you want to exit ??") == JOptionPane.OK_OPTION) {
			frmStep.setVisible(true);
			this.dispose();
		}
	}
	
	private void initData() {
		try {
			listPath= new ArrayList<String>();
			listPath = daoReturnJobWithField.getListPath(isRework);
		} 
		catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "initData : "  + e.toString());
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object action = e.getSource();
		if(action == radioProof) {
			isRework = false;
			status  = 2;
			reloadPath();
		}
		if(action == radioRework) {
			isRework = true;
			status = 2;
			reloadPath();
		}
		if(action == buttonClear) {
			textPaneListManagementId.setText("");
		}
		if(action == buttonAssign) {
			processAssign();
		}
		if(action == buttonGetData) {
			getDataFromTo();
		}
	}
	
	/**
	 * reload filepath
	 */
	private void reloadPath() {
		initData();
		panelGridPath.setListPath(listPath);
		panelGridPath.loadPath();
	}
	
	//========================================================================================================================
	
	private void styleTable(JTable tableData) {
		tableData.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JTableHeader header = tableData.getTableHeader();
		header.setForeground(Color.BLACK);
		JTableUtil.addHeaderRow(tableData);
		tableData.setFont(new Font("Arial", Font.PLAIN, 14));

		tableData.setShowGrid(true);
		tableData.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		tableData.setRowHeight(30);
		tableData.getTableHeader().setReorderingAllowed(false);
		JTableUtil.fitTableColumns(tableData);
	}
	
	/**
	 * load field
	 */
	private void loadField() {

		try {
			List<String> listField = daoReturnJobWithField.getListField();
			DefaultTableModel model ;
			if(listField.size() > 0) {
				JTableUtil.removeAllRow(tableField);
				model = new DefaultTableModel(new String [] { "No." , "FieldName" , "Check"} , 0);
				Object [] values = null;
				int index = 0;
				for (String field : listField) {
					values = new Object [] { index  , field , Boolean.FALSE  };
					model.addRow(values);
					++index;
				}
				tableField.setModel(model);
				styleTable(tableField);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "loadField : "  + e.toString());
		}
		
	}
	
	/**
	 * value change listener in jtable
	 */
	private void valueChangeAction() {
		listIds = new ArrayList<String>();
		try {
			int row = tablePath.getSelectedRow();
			if(row > -1)
			{
				textPaneListManagementId.setText("");
				String filepath = StringUtil.setNotNull(tablePath.getValueAt(row, 1));
				listIds = daoReturnJobWithField.getListManagementIdByFilePath(filepath, isRework);
				String ids = StringUtil.join(listIds, ",");
				textPaneListManagementId.setText(ids);
			}

		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "valueChangeAction " + e.toString());
		}

	}
	
	/**
	 * check select field
	 */
	private void checkSelectField() 
	{
		listFieldSelect = new ArrayList<String>();
		int rows = tableField.getRowCount();
		String check = "";
		String field = "";
		for (int i = 0; i < rows; i++) {
			check = tableField.getValueAt(i, 2).toString();
			field = tableField.getValueAt(i, 1).toString();
			if(check.equals("true")) {
				listFieldSelect.add(field);
			}
		}
	}
	
	/**
	 * get data from management to management
	 */
	private void getDataFromTo() {

		try {
			setRework();
			String from  = StringUtil.setNotNull(txtFrom.getText());
			String to    = StringUtil.setNotNull(txtTo.getText());
			textPaneListManagementId.setText("");
			if(from.equals("")) {
				AppUtility.msgError(this, "Please intput from value !!");
				txtFrom.requestFocus();
			}
			else if(to.equals("")) {
				AppUtility.msgError(this, "Please intput from to !!");
				txtTo.requestFocus();
			}else {
				listIds = new ArrayList<String>();
				listIds = daoReturnJobWithField.getListManagementIdByFromTo(from, to, isRework);
				if(listIds.size() > 0) {
					String ids = StringUtil.join(listIds, ",");
					textPaneListManagementId.setText(ids);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "getDataFromTo : " + e.toString());
		}

	}
	
    /**
	 * set status
	 */
	private void setRework() {
        if(radioRework.isSelected()) {
        	isRework = true;
        	status = 2;
        }
        if(radioProof.isSelected()) {
        	status = 2;
        }
	}
	
	private void processAssign() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public synchronized void run() {
				assign();
			}
		});
		thread.start();
	}
	
	/**
	 * process assign job
	 */
	private void assign() 
	{
		boolean flag = false;
		try {
			setRework();
			String ids = StringUtil.setNotNull(textPaneListManagementId.getText());
			checkSelectField();
			if(listFieldSelect.size() ==0) {
				AppUtility.msgInfo(this, "Please select field !!");
			}else if(ids.equals("")) {
				AppUtility.msgInfo(this, "Please input managementid !!");
				textPaneListManagementId.requestFocus();
			}else {
				flag = daoReturnJobWithField.assign(listFieldSelect, ids, status , isRework);
			}
			if(flag) {
				AppUtility.msgInfo(this, "Assign job successfull !!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "assign : "  + e.toString());
		}

	}


}
