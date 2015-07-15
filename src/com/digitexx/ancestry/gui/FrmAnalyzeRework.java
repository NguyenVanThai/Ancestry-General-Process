package com.digitexx.ancestry.gui;

import image.helper.component.PanelTwoImage;
import image.helper.gui.FrmViewTwoImage;
import image.helper.util.Configuration;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.JTableHeader;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.ancestry.bean.FormType;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.component.PanelJobInfo;
import com.digitexx.ancestry.component.PanelProcessImage;
import com.digitexx.ancestry.conts.EnumFieldAge;
import com.digitexx.ancestry.dao.DaoAnalyzeRework;
import com.digitexx.ancestry.jai.util.DisplayLineSampleableDEM;
import com.digitexx.ancestry.jai.util.ImageUtil;
import com.digitexx.ancestry.table.model.SqlResultTableModel;
import com.digitexx.ancestry.util.AppUtility;
import com.digitexx.ancestry.util.ExcelAdapter;
import com.digitexx.ancestry.util.JTableUtil;
import com.digitexx.ancestry.util.StringUtil;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class FrmAnalyzeRework extends javax.swing.JFrame implements ActionListener 
{
	private static final long serialVersionUID = 1L;
	private JPanel panelMain;
	private JPanel panelHeader;
	private JPanel panelContent;
	private JPanel panelFooter;
	private PanelProcessImage panelProcessImage = new PanelProcessImage();
	private PanelJobInfo panelJobInfo = new PanelJobInfo("", "", "");
	public JTable tableData;
	private JScrollPane scrollPaneTable;
	private JScrollPane scrollPaneImage;
	private JPanel panelImage;
	private JPanel panelData;
	private JSplitPane splitPane;
	private JComboBox comboboxPath;
	private JPanel panelBottom;
	private JPanel panelPath;
	private JButton buttonExit;
	private JButton buttonSave;
	private String userId;
	private DaoAnalyzeRework daoAnalyzeRework;
	private Tbl_Projects project;
	private ImageUtil imageUtil;
	private DisplayLineSampleableDEM imageCanvas;
	private FrmViewTwoImage frmViewTwoImage;
	private FormType formPage2 = new FormType();
	
	private String path;
	private long managementid;
	private SqlResultTableModel model;
	private JButton buttonConfigFont;
	private JPanel panelConfig;
	private String[] arrColumnName;
	private FrmStep frmStep;
	private int count = 1;
	public String fontName = "Tahoma";
	private JButton buttonHoldJob;
	private JCheckBox checkboxGetHoldJob;
	int fontSize = 13;
	int fontStyle = Font.PLAIN;
	private List<String> listIdNotRework;
	private boolean isHoldJob = false;

	public FrmAnalyzeRework( FrmStep frmStep, String userId , Tbl_Projects project) {
		super();
		listIdNotRework = new ArrayList<String>();
		this.frmStep = frmStep;
		this.userId = userId;
		this.project = project;
		
		daoAnalyzeRework = new DaoAnalyzeRework(project);
		initGUI();
		AppUtility.centerFrame(this);
		initData();
	}

	private void initGUI() {
		try {
			this.setTitle("Form Analyze Rework Customer");
			imageUtil = new ImageUtil();
			imageCanvas = imageUtil.imageCanvas;
			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			{
				panelMain = new JPanel();
				AnchorLayout panelMainLayout = new AnchorLayout();
				panelMain.setLayout(panelMainLayout);
				getContentPane().add(
						panelMain,
						new AnchorConstraint(0, 1000, 1000, 0,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
				panelMain.setPreferredSize(new java.awt.Dimension(1103, 747));
				{
					panelFooter = new JPanel();
					AnchorLayout panelFooterLayout = new AnchorLayout();
					panelFooter.setLayout(panelFooterLayout);
					panelMain.add(panelFooter, new AnchorConstraint(954, 1000,
							1000, 0, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					panelFooter.setBorder(BorderFactory
							.createEtchedBorder(BevelBorder.LOWERED));
					panelFooter.setBounds(0, 715, 1103, 32);
					{
						buttonHoldJob = new JButton();
						panelFooter.add(buttonHoldJob, new AnchorConstraint(42, 114, 957, 2, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						buttonHoldJob.setText("Hold Jobs");
						buttonHoldJob.setPreferredSize(new java.awt.Dimension(124, 32));
						buttonHoldJob.setFont(new java.awt.Font("Tahoma",1,14));
						buttonHoldJob.setForeground(new java.awt.Color(255,0,0));
						buttonHoldJob.addActionListener(this);
					}
					{
						buttonExit = new JButton();
						panelFooter.add(buttonExit, new AnchorConstraint(71,
								995, 957, 936, AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
						buttonExit.setText("Exit");
						buttonExit.setPreferredSize(new java.awt.Dimension(65,
								31));
						buttonExit.setFont(new java.awt.Font("Tahoma",1,14));
						buttonExit.setForeground(new java.awt.Color(255, 0, 0));
						buttonExit.addActionListener(this);
					}
					{
						buttonSave = new JButton();
						panelFooter.add(buttonSave, new AnchorConstraint(71,
								928, 957, 867, AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
						buttonSave.setText("Save");
						buttonSave.setPreferredSize(new java.awt.Dimension(68,
								31));
						buttonSave.setFont(new java.awt.Font("Tahoma",1,14));
						buttonSave.addActionListener(this);
					}
				}
				{
					panelContent = new JPanel();
					AnchorLayout panelContentLayout = new AnchorLayout();
					panelContent.setLayout(panelContentLayout);
					panelMain.add(panelContent, new AnchorConstraint(39, 1000,
							956, 0, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					panelContent.setBorder(BorderFactory
							.createEtchedBorder(BevelBorder.LOWERED));
					panelContent.setBounds(0, 30, 1103, 685);
					{
						panelPath = new JPanel();
						BorderLayout panelPathLayout = new BorderLayout();
						panelPath.setLayout(panelPathLayout);
						panelContent.add(panelPath, new AnchorConstraint(3,
								997, 56, -2, AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
						panelPath.setBorder(BorderFactory
								.createEtchedBorder(BevelBorder.LOWERED));
						panelPath.setPreferredSize(new java.awt.Dimension(1103,
								36));
						{
							comboboxPath = new JComboBox();
							panelPath.add(comboboxPath, BorderLayout.CENTER);
							comboboxPath.setFont(new java.awt.Font("Tahoma", 1,
									12));
							comboboxPath.setForeground(new java.awt.Color(255,
									0, 0));
							comboboxPath.setPreferredSize(new java.awt.Dimension(652, 32));
							comboboxPath.addActionListener(this);
						}
					}
					{
						panelBottom = new JPanel();
						BorderLayout panelBottomLayout = new BorderLayout();
						panelBottom.setLayout(panelBottomLayout);
						panelContent.add(panelBottom, new AnchorConstraint(56,
								996, 996, 2, AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
						panelBottom.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
						panelBottom.setPreferredSize(new java.awt.Dimension(
								1097, 644));
						{
							splitPane = new JSplitPane();
							panelBottom.add(splitPane, BorderLayout.CENTER);
							splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
							splitPane.setDividerLocation(400);
							{
								panelData = new JPanel();
								BorderLayout panelDataLayout = new BorderLayout();
								panelData.setLayout(panelDataLayout);
								splitPane.add(panelData, JSplitPane.RIGHT);
								{
									scrollPaneTable = new JScrollPane();
									panelData.add(scrollPaneTable,BorderLayout.CENTER);
									{
										tableData = new JTable()
										{

											@Override
											public void editingStopped(ChangeEvent e)
											{
												int row = tableData.getSelectedRow();
												int col = tableData.getSelectedColumn();
												String oldValue = StringUtil.setNotNull(tableData.getValueAt(row, col));
												super.editingStopped(e);
												editOnJtable(oldValue);
											}
										};
										scrollPaneTable.setViewportView(tableData);
									}
									
									ExcelAdapter ed = new ExcelAdapter(tableData , this);
									tableData.getSelectionModel().addListSelectionListener(
													new ListSelectionListener() {
														@Override
														public void valueChanged(ListSelectionEvent e) {
															if (tableData.getSelectedRow() != -1) {
																if (!e.getValueIsAdjusting()) {
																	valueChangeJTable(tableData.getSelectedRow());
																}
															}
														}
													});
								}
							}
							{
								panelImage = new JPanel();
								BorderLayout jPanel2Layout = new BorderLayout();
								panelImage.setLayout(jPanel2Layout);
								splitPane.add(panelImage, JSplitPane.LEFT);
								panelImage.setPreferredSize(new java.awt.Dimension(1093, 449));
								{
									scrollPaneImage = new JScrollPane(
											imageCanvas,
											JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
											JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
									panelImage.add(scrollPaneImage,
											BorderLayout.CENTER);
									imageCanvas.setScrollPane(scrollPaneImage);
								}
							}
						}
					}
				}
				{
					panelHeader = new JPanel();
					AnchorLayout panelHeaderLayout = new AnchorLayout();
					panelMain.add(panelHeader, new AnchorConstraint(0, 1000,
							42, 0, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					panelHeader.setPreferredSize(new java.awt.Dimension(1103,
							29));
					panelHeader.setBorder(BorderFactory
							.createEtchedBorder(BevelBorder.LOWERED));
					panelHeader.setLayout(panelHeaderLayout);
					panelHeader.setBounds(0, 0, 1103, 29);
					{
						panelConfig = new JPanel();
						AnchorLayout panelConfigLayout = new AnchorLayout();
						panelHeader.add(panelConfig, new AnchorConstraint(16, 476, 951, 286, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						panelConfig.setPreferredSize(new java.awt.Dimension(210, 29));
						panelConfig.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
						panelConfig.setLayout(panelConfigLayout);
						{
							checkboxGetHoldJob = new JCheckBox();
							panelConfig.add(checkboxGetHoldJob, new AnchorConstraint(17, 992, 948, 340, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
							checkboxGetHoldJob.setText("Get Hold Job");
							checkboxGetHoldJob.setPreferredSize(new java.awt.Dimension(137, 27));
							checkboxGetHoldJob.setFont(new java.awt.Font("Tahoma",1,14));
							checkboxGetHoldJob.setForeground(new java.awt.Color(255,0,0));
							checkboxGetHoldJob.addActionListener(this);
						}
						{
							buttonConfigFont = new JButton();
							panelConfig.add(buttonConfigFont, new AnchorConstraint(17, 316, 948, 7, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
							buttonConfigFont.setFont(new java.awt.Font("Tahoma",1,12));
							buttonConfigFont.setPreferredSize(new java.awt.Dimension(65, 27));
							buttonConfigFont.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/digitexx/images/config.png")));
							buttonConfigFont.addActionListener(this);
						}
					}
					panelJobInfo = new PanelJobInfo("", "", "");
					panelHeader.add(panelJobInfo, new AnchorConstraint(86,
							1003, 1017, 771, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					panelJobInfo.setPreferredSize(new java.awt.Dimension(255,
							27));
					panelHeader.add(panelProcessImage, new AnchorConstraint(16,
							287, 951, 2, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					panelProcessImage.setPreferredSize(new java.awt.Dimension(
							315, 29));
					panelProcessImage
							.setFont(new java.awt.Font("Tahoma", 1, 12));
					panelProcessImage.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));

				}
			}
			pack();
			this.setSize(1111, 781);
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

	@Override
	public void actionPerformed(ActionEvent evt) {
		Object action = evt.getSource();
		if (action == comboboxPath) {
			loadDataByFilepath();
		}
		if (action == buttonSave) {
			save();
		}
		if(action == buttonExit) {
			exit();
		}
		if(action == buttonConfigFont) {
			(new FrmFormat(this)).setVisible(true);
		}
		if(action == checkboxGetHoldJob) {
			if(model != null) {
				model.removeAllRows();
			}
			if(checkboxGetHoldJob.isSelected()) {
				isHoldJob = true;
				loadPathByProject();
			}else {
				isHoldJob = false;
				loadPathByProject();
			}
		}
		if(action == buttonHoldJob) {
			saveHoldJob();
		}
	}

	private void initData() {
		panelProcessImage.setImageUtil(imageUtil);
		addKeyListener();
		loadPathByProject();
	}

	private void addKeyListener() {
		java.awt.Toolkit.getDefaultToolkit().addAWTEventListener(
				new java.awt.event.AWTEventListener() {
					public void eventDispatched(java.awt.AWTEvent event) {
						KeyEvent e = (KeyEvent) event;
						if (e.getID() == KeyEvent.KEY_PRESSED
								&& tableData.isFocusable()) {
							// ctrl + O : mở hình
							if (e.getKeyCode() == KeyEvent.VK_O
									&& e.isControlDown()) {
								imageUtil.openImage(path);
								e.consume();
								return;
							}
						}
					}
				}, java.awt.AWTEvent.KEY_EVENT_MASK);
	}

	// ==========================================================================================================================

	/**
	 * set format jtable
	 */
	private void styleTable() {
		tableData.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JTableHeader header = tableData.getTableHeader();
		header.setForeground(Color.RED);
		tableData.setFont(new Font("Arial", Font.PLAIN, 16));
		tableData.setCellSelectionEnabled(true);
		tableData.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableData.setShowGrid(true);
		tableData.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		tableData.setRowHeight(30);
		tableData.setCellSelectionEnabled(true);
	}

	/**
	 * reset Table Model of Jtable
	 */
	private void resetTableModel() {
		model = new SqlResultTableModel();
		model.removeDataJtable();
		tableData.setModel(model);
	}

	private void loadPathByProject() 
	{
		try 
		{
			if (daoAnalyzeRework.checkExistTable("customer_feedback")) {
				List<String> listPath = daoAnalyzeRework.getListFilepathByProject(isHoldJob);
				comboboxPath.removeAllItems();
				if(listPath.size() > 0) {
					for (String str : listPath) {
						comboboxPath.addItem(str);
					}
					resetTableModel();
					comboboxPath.setSelectedIndex(0);
				}
			} else {
				AppUtility.msgInfo(this,"Not found table customer_feedback_detail . Check database again !!");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "loadPathByProject : "  + e.toString());
		}
	}

	/**
	 * get header of Jtable to List
	 */
	private void setHeaderJTableToList() {
		if (tableData.getRowCount() > 0) {
			int total = tableData.getColumnCount() - 1;
			arrColumnName = new String[total];
			for (int i = 0; i < total; i++) {
				arrColumnName[i] = tableData.getColumnName(i);
			}
		}
	}
	

	private void loadDataByFilepath() 
	{
		if (comboboxPath.getSelectedIndex() > -1)
		{
			try 
			{
				setHeaderJTableToList();
				model = new SqlResultTableModel();
				String filepath = comboboxPath.getSelectedItem().toString();
				count = daoAnalyzeRework.getCountByFilePath(filepath);
				model = daoAnalyzeRework.getDataReworkByFilePath( filepath , isHoldJob);
				tableData.setModel(model);
				model.setTableBinding(tableData);
				
				String[] arrColumnNotEdit = new String[] { "No.", "image_path",
						"image_name", "management_id", "seq_number", "group_field",
						"field", "value_db3", "failure_reason", "user_type" , "count" };
				
				model.setArrayEditColum(arrColumnNotEdit);
				JTableUtil.setColorCellEdit(tableData);
				if(tableData.getRowCount() > 0) {
					valueChangeJTable(0);
				}else {
					imageUtil.displayImage("");
				}
				styleTable();
			}
			catch (Exception e) {
				e.printStackTrace();
				AppUtility.msgError(this, "loadDataByFilepath : "  + e.toString());
			}

		}
	}
	

	private void valueChangeJTable(int row) {
		if (row > -1)
		{
			String filepath = JTableUtil.getValuesByHeaderName(tableData,"image_path", row);
			String filename = JTableUtil.getValuesByHeaderName(tableData,"image_name", row);
			managementid = Long.parseLong(JTableUtil.getValuesByHeaderName(tableData, "management_id", row));
			filepath = filepath.replace("\\", "/");
			path = filepath + "/" + filename;
			imageUtil.displayImage(path);
			//viewPage2(path , managementid);
			this.setTitle(path);
		}
	}
	
	/**
	 * view page 2
	 */
	private void viewPage2(String imagePath , long managementid) 
	{
		try {
			if(imagePath.indexOf("128_140903_Ancestry_42302_DE") > -1) 
			{
				if(frmViewTwoImage != null) {
					frmViewTwoImage.dispose();
				}
				frmViewTwoImage = new FrmViewTwoImage();
				getInfoPage2(frmViewTwoImage.getPanelTwoImage(), managementid, imagePath, 4);
				frmViewTwoImage.setTitle(imagePath);
				frmViewTwoImage.setVisible(true);
			}

		}
		catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "viewPage2 : "  + e.toString());
		}

	}
	
	/**
	 * load image page 2
	 */
	private void getInfoPage2(PanelTwoImage panelTwoImage  , long managementID , String fullFileName , int  quality ) {

		try {
			formPage2 = new FormType();
			formPage2 = daoAnalyzeRework.getPage2(managementID);
			
			panelTwoImage.getLeftImage().setResolution(quality);
			panelTwoImage.getLeftImage().setPath(fullFileName);
			panelTwoImage.getLeftImage().loadImage();
			if(!StringUtil.setNotNull(formPage2.getFileName()).equals("")) {
				String pathPage2 = Configuration.changePlatfom(formPage2.getFilePath() + "/" + formPage2.getFileName());	
				panelTwoImage.getRightImage().setResolution(quality);
				panelTwoImage.getRightImage().setPath(pathPage2);
				panelTwoImage.getRightImage().loadImage();
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "loadImagePage2 : " + e.toString());
		}

	}

	/**
	 * process event edit on jtable
	 */
	private void editOnJtable(String oldValue) 
	{
		int row = tableData.getSelectedRow();
		int col = tableData.getSelectedColumn();
		Object value = tableData.getValueAt(row, col);
		String columnName = tableData.getColumnName(col);

		try 
		{
			if (columnName.equals("form_id"))
			{
				String formID = value.toString();
				if(StringUtil.isNumber(formID)) 
				{
					if(AppUtility.msgConfirm(this, "DO YOU WANT TO CHANGE FORM ?") == JOptionPane.OK_OPTION)
					{
						boolean resultUpdateFormID = daoAnalyzeRework.updateFormId(formID, managementid);
						boolean resultDeleteProofRework = daoAnalyzeRework.deleteProofRework(managementid);
						if (resultUpdateFormID && resultDeleteProofRework) {
							AppUtility.msgInfo(this, "Change form sucessfully!");
						}
					}
					else {
						tableData.setValueAt(oldValue, row, col);
					}
				}
			}
			if (columnName.equals("value_dpo"))
			{
				update();
			}

			if (columnName.equals("is_rework_field")) 
			{
				String imageName = JTableUtil.getValuesByHeaderName(tableData,"image_name", row);
				String groupField = JTableUtil.getValuesByHeaderName(tableData,"group_field", row);
				int total = tableData.getRowCount();
				for (int i = 0; i < total; i++) 
				{
					String tempGroupField = JTableUtil.getValuesByHeaderName(tableData, "group_field", i);
					String tempImageName = JTableUtil.getValuesByHeaderName(tableData , "image_name", i);
					if (tempGroupField.equals(groupField)&& tempImageName.equals(imageName)) {
						tableData.setValueAt(value, i, col);
					}
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, e.toString());
		}

	}

	private boolean save() 
	{
		boolean flag = false;
		int rowCount = tableData.getRowCount();
		try 
		{
			if (rowCount > 0) {
				if (AppUtility.msgConfirm(this, "DO YOU WANT TO FINISH THIS PATH ??") == JOptionPane.YES_OPTION) {
					String filepath = comboboxPath.getSelectedItem().toString();
					boolean wrongCount = false;
					List<String[]> listRework = new ArrayList<String[]>();

					String groupField;
					Boolean check;
					String failureReason;
					String seq_number = "";
					String management_id = "";
					int index = 0;
					
					for (int i = 0; i < rowCount; i++)
					{
						groupField    = JTableUtil.getValuesByHeaderName(tableData, "group_field", i).toString();
						check         = (Boolean) JTableUtil.getValuesByHeader(tableData, "is_rework_field", i);
						failureReason = (String) JTableUtil.getValuesByHeader(tableData, "failure_reason", i);
						seq_number    =  JTableUtil.getValuesByHeader(tableData, "seq_number", i).toString();
						management_id =  JTableUtil.getValuesByHeader(tableData, "management_id", i).toString();

						if (check) {
							if (failureReason.trim().indexOf("Wrong Record Count")> -1) {
								wrongCount = true;
							}
							listRework.add(new String[] { management_id , groupField , seq_number });
						}else {
							++index;
						}
					}
					if(index == rowCount) {
						if (AppUtility.msgConfirm(this, "You do not select any fields for rework ! Do you want to save ??") == JOptionPane.YES_OPTION) {
							flag = true;
						}else {
							flag = false;
						}
					}else {
						flag = true;
					}
					if(flag)
					{
						int count = Integer.parseInt(JTableUtil.getValuesByHeaderName(tableData, "count", 0));
						if (wrongCount) {
							daoAnalyzeRework.reworkWrongCount(filepath);
						}
						flag = daoAnalyzeRework.updateReworkFeedBack(listRework , count ,0);
						flag = daoAnalyzeRework.updateReworkFeedBack(listRework , count ,1);
						
						if(flag) {
							flag = daoAnalyzeRework.updateStatusFeedBack(filepath , 0 , count);
							flag = daoAnalyzeRework.updateStatusFeedBack(filepath , 1 , count);
						}
						if(flag) {
							if(index != tableData.getRowCount()) {
								flag = daoAnalyzeRework.updateStepRework(filepath);
							}
	                    	if(listIdNotRework.size() > 0) {
	                    		flag = daoAnalyzeRework.updateImageNotrework(listIdNotRework);
	                    	}
						}
						AppUtility.msgInfo(this, "Analyze Successfully !!");
						loadPathByProject();
						listIdNotRework.clear();
					}

				}
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "save : "  + e.toString());
		}
        return flag;

	}

	/**
	 * update data on Jtable
	 */
	private boolean update() 
	{
		boolean flag = true;
		try 
		{
			if(tableData.getRowCount() > 0) 
			{
				int row = -1;
				JTableUtil.stopEditTable(tableData);
				row = tableData.getSelectedRow();
				if (row > -1) 
				{
		        	String columnName   = JTableUtil.getValuesByHeaderName(tableData, "field", row) ;

					if (AppUtility.msgConfirm(this,"Do you want to update data on colum : "  + columnName + " ??") == JOptionPane.OK_OPTION) 
					{
						int col = tableData.getColumnModel().getColumnIndex("value_dpo");
			        	Map<String, String> mapEnumAge = EnumFieldAge.toMap();
			        	
			        	String value        = StringUtil.setNotNull(tableData.getValueAt(row, col));
			        	String managementid = JTableUtil.getValuesByHeaderName(tableData, "management_id", row) ;
			        	String seq_number   = JTableUtil.getValuesByHeaderName(tableData, "seq_number", row) ;
			        	
			        	if(!columnName.equals("")) 
			        	{
				        	if(mapEnumAge.containsKey(columnName)) {
				        		flag = daoAnalyzeRework.updateDataFieldAge( mapEnumAge, value, columnName, managementid, seq_number);
				        	}else {
				        		flag = daoAnalyzeRework.updateValueNotFieldAge(value, columnName, managementid, seq_number);
				        	}
	                        if(flag) {
	                        	listIdNotRework.add(managementid);
	                        	AppUtility.msgInfo(this, "Update data on P1_FORM_N_PROOF_REWORK complete !!");
	                        }else {
	                        	AppUtility.msgInfo(this, "Please click mouse at row want to update !!");
	                        }
			        	}

					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "processUpdate : "  + e.toString());
		}
        return flag;
	}
	
	/**
	 * process hold job
	 */
	private void saveHoldJob() {
		boolean flag = false;
		try {
			int rows = tableData.getRowCount();
			if(rows > 0) 
			{
				if(AppUtility.msgConfirm(this, "Do you want to hold job this path ??") == JOptionPane.OK_OPTION) {
					String filepath = comboboxPath.getSelectedItem().toString();
					String count    = JTableUtil.getValuesByHeaderName(tableData, "count", 0);
					flag = daoAnalyzeRework.saveHoldJob(filepath, count);
					if(flag) {
						loadPathByProject();
						AppUtility.msgInfo(this, "Finished process hold job !!");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "saveHoldJob : " +  e.toString());
		}

	}

	// ==========================================================================================================================

}
