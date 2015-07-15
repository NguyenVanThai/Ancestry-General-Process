package com.digitexx.ancestry.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.ancestry.bean.CustomerFeedbackDetailQC;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.component.PanelProcessImage;
import com.digitexx.ancestry.dao.DaoCompareAndAnalyze;
import com.digitexx.ancestry.jai.util.DisplayLineSampleableDEM;
import com.digitexx.ancestry.jai.util.ImageUtil;
import com.digitexx.ancestry.table.render.HighlightTableCellRendererCompare;
import com.digitexx.ancestry.util.AncestryException;
import com.digitexx.ancestry.util.AppUtility;
import com.digitexx.ancestry.util.ExcelExporter;
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
public class FrmAnalyzeAndCompareForQMD extends javax.swing.JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JPanel panelMain;
	private JPanel panelHeader;
	private JPanel panelContent;
	private JPanel panelFooter;
	private JSplitPane splitPane;
	private ButtonGroup buttonGroup;
	private JButton buttonFinish;
	private JTable tableViewData;
	private JScrollPane scrollPaneData;
	private JScrollPane scrollPaneImage;
	private JComboBox comboboxPath;
	private JPanel panelViewImage;
	private JPanel panelViewData;
    private PanelProcessImage panelProcessImage;
	private ImageUtil imageUtil;
	private DisplayLineSampleableDEM imageCanvas;
    
    private Tbl_Projects project;
	private String userId;
	private FrmStep frmStep;
	private DaoCompareAndAnalyze daoCompareAndAnalyze;
	private List<String> listPath;
	private List<String> listVersion;
	private List<CustomerFeedbackDetailQC> listDataCompare ;
	private List<String> listMistake ;
	private DefaultTableModel model;
	private JLabel jLabel1;
	private JComboBox comboboxVersion;
	private JButton buttonExport;
	private JButton buttonBrowse;
	private JTextField txtPath;
	private boolean isCompare;
	
	private Tbl_Projects projectDigiSoft = new Tbl_Projects();
	private List<String> listManagementId = new ArrayList<String>();
	private Map<String , String> mapUserId    = new HashMap<String , String>();
	private Map<String , String> mapIdAndName = new HashMap<String , String>();
	
	public FrmAnalyzeAndCompareForQMD(Tbl_Projects project , String userId , FrmStep frmStep , boolean isCompare) {
		super();
		this.project = project;
		this.userId = userId;
		this.frmStep = frmStep;
		this.isCompare = isCompare;
		daoCompareAndAnalyze = new DaoCompareAndAnalyze(project);
		initGUI();
		initData();
	}
	
	private void initGUI() {
		try {
			imageUtil = new ImageUtil();
			imageCanvas = imageUtil.imageCanvas;
			this.setTitle("Form Analyze & Compare Data");
			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			{
				panelMain = new JPanel();
				AnchorLayout panelMainLayout = new AnchorLayout();
				getContentPane().add(panelMain, BorderLayout.CENTER);
				panelMain.setLayout(panelMainLayout);
				{
					panelHeader = new JPanel();
					AnchorLayout panelHeaderLayout = new AnchorLayout();
					panelMain.add(panelHeader, new AnchorConstraint(0, 1000, 68, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					panelHeader.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
					panelHeader.setLayout(panelHeaderLayout);
					panelHeader.setPreferredSize(new java.awt.Dimension(908, 39));
					{
						panelProcessImage = new PanelProcessImage();
						panelHeader.add(getJLabel1(), new AnchorConstraint(59, 949, 1011, 900, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						panelHeader.add(getComboboxVersion(), new AnchorConstraint(59, 998, 964, 952, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						panelHeader.add(panelProcessImage, new AnchorConstraint(11, 247, 964, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						panelProcessImage.setPreferredSize(new java.awt.Dimension(243, 40));
						panelProcessImage.setImageUtil(imageUtil);

					}
					{
						comboboxPath = new JComboBox();
						panelHeader.add(comboboxPath, new AnchorConstraint(11, 899, 964, 247, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						comboboxPath.setFont(new java.awt.Font("Arial",0,14));
						comboboxPath.setPreferredSize(new java.awt.Dimension(642, 40));
						comboboxPath.addActionListener(this);
					}
				}
				{
					panelContent = new JPanel();
					BorderLayout panelContentLayout = new BorderLayout();
					panelContent.setLayout(panelContentLayout);
					panelMain.add(panelContent, new AnchorConstraint(68, 1000, 936, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					panelContent.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
					panelContent.setPreferredSize(new java.awt.Dimension(908, 502));
					{
						splitPane = new JSplitPane();
						panelContent.add(splitPane, BorderLayout.CENTER);
						splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
						{
							panelViewData = new JPanel();
							BorderLayout panelViewDataLayout = new BorderLayout();
							panelViewData.setLayout(panelViewDataLayout);
							splitPane.add(panelViewData, JSplitPane.RIGHT);
							panelViewData.setPreferredSize(new java.awt.Dimension(902, 237));
							{
								scrollPaneData = new JScrollPane();
								panelViewData.add(scrollPaneData, BorderLayout.CENTER);
								{
									tableViewData = new JTable() {
										@Override
										public boolean isCellEditable(int row,int column) {
											if(getColumnName(column).equals("value_qc") ||
											   getColumnName(column).equals("value_db3") ||
											   getColumnName(column).equals("mistake")) {
												return true;
											}else {
												return false;
											}
										}
									};
									scrollPaneData.setViewportView(tableViewData);
									tableViewData.getSelectionModel().addListSelectionListener(
											new ListSelectionListener() {
												@Override
												public void valueChanged(ListSelectionEvent e) {
													if (tableViewData.getSelectedRow() != -1) {
														if (!e.getValueIsAdjusting()) {
															valueChangeJTable(tableViewData.getSelectedRow());
														}
													}
												}
									});
								}
							}
						}
						{
							panelViewImage = new JPanel();
							BorderLayout panelViewImageLayout = new BorderLayout();
							panelViewImage.setLayout(panelViewImageLayout);
							splitPane.add(panelViewImage, JSplitPane.LEFT);
							panelViewImage.setPreferredSize(new java.awt.Dimension(902, 214));
							{
								scrollPaneImage = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
								panelViewImage.add(scrollPaneImage, BorderLayout.CENTER);
								imageCanvas.setScrollPane(scrollPaneImage);
							}
						}
					}
				}
				{
					panelFooter = new JPanel();
					AnchorLayout panelFooterLayout = new AnchorLayout();
					panelMain.add(panelFooter, new AnchorConstraint(938, 1000, 1000, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					panelFooter.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
					panelFooter.setLayout(panelFooterLayout);
					panelFooter.setPreferredSize(new java.awt.Dimension(908, 36));
					{
						buttonFinish = new JButton();
						panelFooter.add(getButtonExport(), new AnchorConstraint(64, 741, 961, 659, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						panelFooter.add(getButtonBrowse(), new AnchorConstraint(64, 659, 961, 577, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						panelFooter.add(getTxtPath(), new AnchorConstraint(64, 577, 961, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						panelFooter.add(buttonFinish, new AnchorConstraint(69, 998, 958, 913, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						buttonFinish.setText("Finish");
						buttonFinish.setFont(new java.awt.Font("Tahoma",1,12));
						buttonFinish.setForeground(new java.awt.Color(255,0,0));
						buttonFinish.setPreferredSize(new java.awt.Dimension(77, 32));
						buttonFinish.addActionListener(this);
					}
				}
			}
			pack();
			this.setSize(992, 656);
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
	
	
	private JTextField getTxtPath() {
		if(txtPath == null) {
			txtPath = new JTextField();
			txtPath.setPreferredSize(new java.awt.Dimension(568, 35));
		}
		return txtPath;
	}
	
	private JButton getButtonBrowse() {
		if(buttonBrowse == null) {
			buttonBrowse = new JButton();
			buttonBrowse.setText("Browse");
			buttonBrowse.setPreferredSize(new java.awt.Dimension(80, 35));
			buttonBrowse.setFont(new java.awt.Font("Tahoma",1,12));
			buttonBrowse.addActionListener(this);
			
		}
		return buttonBrowse;
	}
	
	private JButton getButtonExport() {
		if(buttonExport == null) {
			buttonExport = new JButton();
			buttonExport.setText("Export");
			buttonExport.setPreferredSize(new java.awt.Dimension(81, 35));
			buttonExport.setFont(new java.awt.Font("Tahoma",1,12));
			buttonExport.addActionListener(this);
		}
		return buttonExport;
	}
	
	private void exit() {
		if(AppUtility.msgConfirm(this, "Do you want to exit ??") == JOptionPane.OK_OPTION) {
			frmStep.setVisible(true);
			this.dispose();
		}
	}
	
	private JComboBox getComboboxVersion() {
		if(comboboxVersion == null) {
			comboboxVersion = new JComboBox();
			comboboxVersion.setPreferredSize(new java.awt.Dimension(45, 38));
			comboboxVersion.setFont(new java.awt.Font("Tahoma",1,14));
			comboboxVersion.addActionListener(this);
		}
		return comboboxVersion;
	}
	
	private JLabel getJLabel1() {
		if(jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Version");
			jLabel1.setPreferredSize(new java.awt.Dimension(48, 40));
			jLabel1.setFont(new java.awt.Font("Tahoma",1,12));
			jLabel1.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			jLabel1.setForeground(new java.awt.Color(255,0,0));
		}
		return jLabel1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object action = e.getSource();
		if(action == comboboxPath) {
			if(comboboxPath.getModel().getSize() > 0) {
				loadVersion(comboboxPath.getSelectedItem().toString());
			}
		}
		if(action == comboboxVersion) {
			if(comboboxVersion.getModel().getSize() > 0) {
				loadData(false , comboboxVersion.getSelectedItem().toString());
			}else {
				loadData(true ,  "");
			}
		}
		if(action == buttonBrowse){
		   browse();	
		}
		if(action == buttonExport) {
			export();
		}
		if(action == buttonFinish) {
			finish();
		}
		
	}
	
	//=================================================================================================================
	

	private void initData() {
		try {
			loadFilePath();
			projectDigiSoft = daoCompareAndAnalyze.getProjectInformation(project.getProj_name()+"_for_qc");
			
			mapIdAndName = new HashMap<String , String>();
			mapIdAndName = daoCompareAndAnalyze.getMapIdAndName(projectDigiSoft);
		} catch (AncestryException e) {
			e.printStackTrace();
			AppUtility.msgError(this, "initData : "  + e.toString());
		}

	}
	
	private void browse()
	{
		JFileChooser filechooser;
		String directories = txtPath.getText().trim();
		
		if(!directories.equals(""))
			filechooser = new JFileChooser(directories);
		else
			filechooser = new JFileChooser();
		
		filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		filechooser.setMultiSelectionEnabled(true);
		
		int chooser = filechooser.showOpenDialog(filechooser);
		if(chooser == JFileChooser.APPROVE_OPTION)
		{
			File f = filechooser.getSelectedFile();
			txtPath.setText(f.getAbsoluteFile()+"");
		}
	}
	
	private void export() 
	{
		if(!txtPath.getText().isEmpty()) 
		{
			  String path = txtPath.getText()+"/" + "Summary.xls";
			  path = path.replace("\\", "/");
	          File file = new File(path);
	          ExcelExporter.fillData(tableViewData, file , "Summary");
	          AppUtility.msgInfo( this, "Export file successfull !!");
		}else {
			AppUtility.msgInfo(this, "Please select path !!");
		}

	}
	
	/**
	 * set format jtable
	 */
	private void styleTable(JTable tableData) {
		tableData.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JTableHeader header = tableData.getTableHeader();
		header.setForeground(Color.RED);
		tableData.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tableData.setFont(new Font("Arial", Font.PLAIN, 16));

		tableData.setShowGrid(true);
		tableData.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		tableData.setRowHeight(30);
		//JTableUtil.fitTableColumns(tableData);
	}
	
	/**
	 * load filepath
	 */
	private void loadFilePath() throws AncestryException
	{
	   try 
	   {
	       listPath = new ArrayList<String>();
	       listPath = daoCompareAndAnalyze.getListPath();
	       if(listPath.size() >0) {
	    	   comboboxPath.removeAllItems();
	    	   for (String str :  listPath) {
	    		   str = str.substring(0 , str.lastIndexOf("/Images"));
				  comboboxPath.addItem(str);
			   }
	       }
	   } 
	   catch (Exception e) {
		   throw new AncestryException("loadFilePath : "  + e.toString(), e);
	   }
	}
	
	/**
	 * load version
	 */
	private void loadVersion(String version) 
	{
	   try 
	   {
	       listVersion = new ArrayList<String>();
	       listVersion = daoCompareAndAnalyze.getListVersion(version);
	       if(listVersion.size() >0) {
	    	   comboboxVersion.removeAllItems();
	    	   for (String str :  listVersion) {
	    		   comboboxVersion.addItem(str);
			   }
	       }
	   } 
	   catch (Exception e) {
		   e.printStackTrace();
		   AppUtility.msgError(this, "initData : "  + e.toString());
	   }
	}
	
	/**
	 * load data by filepath
	 */
	private void loadData(boolean isOnlyFilePath , String version) {

		try {
			if(comboboxPath.getSelectedIndex() > -1) 
			{
				listMistake = new ArrayList<String>();
				listDataCompare = new ArrayList<CustomerFeedbackDetailQC>();
				String [] headers;
				JTableUtil.removeAllRow(tableViewData);
				String path = StringUtil.setNotNull(comboboxPath.getSelectedItem().toString());
				if(isOnlyFilePath) {
					listDataCompare = daoCompareAndAnalyze.getListDataCustomerByPath(path , version , isOnlyFilePath );
				}else {
					listDataCompare = daoCompareAndAnalyze.getListDataCustomerByPath(path , version , isOnlyFilePath);
				}
				
				if(listDataCompare.size() > 0) {
					if(isCompare) {
						headers = new String [] { "id" ,"image_path" , "image_name" , "managementid" , "version" , 
								"seq_number" , "field" , "value_db3" , "value_dpo" ,"user_type" , "user_qc"};	
					}else {
						headers = new String [] { "id" ,"image_path" , "image_name" , "managementid" , "version" ,
								"seq_number" , "field", "value_db3" , "value_dpo" , "value_qc" ,"user_type" , "mistake" , "user_qc"};
					}
					
					model = new DefaultTableModel(headers ,0);
					Object [] values;
					for (CustomerFeedbackDetailQC cust : listDataCompare)
					{
						if(!listManagementId.contains(cust.getManagement_id()+"")) {
							listManagementId.add(cust.getManagement_id()+"");
						}
						if(isCompare) {
							values = new Object [] { 
									                 cust.getId(),
									                 cust.getImage_path() ,
									                 cust.getImage_name() ,
									                 cust.getManagement_id(),
									                 cust.getCount(),
									                 cust.getSeq_number() ,
									                 cust.getField(),
									                 cust.getValue_db3() ,
					                                 cust.getValue_dpo()  ,
					                                 cust.getUser_type(),
					                                 ""};							
						}else {
							values = new Object [] { 
					                                 cust.getId(),
								                     cust.getImage_path() ,
									                 cust.getImage_name() ,
									                 cust.getManagement_id(),
									                 cust.getCount(),
									                 cust.getSeq_number() ,
									                 cust.getField(),
									                 cust.getValue_db3() ,
									                 cust.getValue_dpo(),
					                                 cust.getValue_qc()  ,
					                                 cust.getUser_type(),
					                                 cust.getMistake(),
					                                 ""
					                                 };
						}
						model.addRow(values);
					}
					tableViewData.setModel(model);
					if(isCompare) {
						TableColumnModel cmodel = tableViewData.getColumnModel(); 
						HighlightTableCellRendererCompare textAreaRenderer = new HighlightTableCellRendererCompare();
						int idxDB3 = tableViewData.getColumnModel().getColumnIndex("value_db3");
						int idxDPO = tableViewData.getColumnModel().getColumnIndex("value_dpo");
						cmodel.getColumn(idxDB3).setCellRenderer(textAreaRenderer);
						cmodel.getColumn(idxDPO).setCellRenderer(textAreaRenderer); 
					}else {
		                listMistake     = daoCompareAndAnalyze.getListMistakes();
						JTableUtil.comboboxJtable(tableViewData, "mistake", listMistake, "Select mistake");
					}
					setValueColumUserQC();
				}
				styleTable(tableViewData);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "loadData : "  + e.toString());
		}
	}
	
	/**
	 * set value for column user_qc
	 */
	private void setValueColumUserQC() throws AncestryException
	{
		try 
		{
			if (listManagementId.size() > 0) {
				String managementids = StringUtil.join(listManagementId, ",");
				mapUserId    = new HashMap<String, String>();
				mapUserId    = daoCompareAndAnalyze.getMapUserIdQC(managementids, projectDigiSoft);

				int totalRow = tableViewData.getRowCount();
				String userId  = "";
				String username = "";
				String managementid = "";
				for (int row = 0; row < totalRow; row++) {
                     managementid = JTableUtil.getValuesByHeaderName(tableViewData, "managementid", row);
                     userId       = mapUserId.get(managementid);
                     username     = mapIdAndName.get(userId);
                     tableViewData.setValueAt(username, row, tableViewData.getColumnCount()-1);
				}
			}
		} catch (Exception e) {
			throw new AncestryException("setValueColumUserQC : "  + e.toString(), e);
		}
	}
	
	private void valueChangeJTable(int row) {
		if (row > -1)
		{
			String filepath = JTableUtil.getValuesByHeaderName(tableViewData,"image_path", row);
			String filename = JTableUtil.getValuesByHeaderName(tableViewData,"image_name", row);
			filepath = filepath.replace("\\", "/");
			String path = filepath + "/" + filename;
			imageUtil.displayImage(path);
			this.setTitle(path);
		}
	}
	
	/**
	 * process finish
	 */
	private void finish() 
	{
		int option = AppUtility.msgConfirm(this, "Do you want to finish this path ??");
		if(option == JOptionPane.OK_OPTION) {
			int rows = tableViewData.getRowCount();
			boolean flag = false;
			try {
				if (tableViewData.getRowCount() > 0)
				{
					Map<Long, String[]> mapData = new HashMap<Long, String[]>();
					String id = "";
					String value_qc = "";
					String mistake;
					
					for (int i = 0; i < rows; i++) {
						id = Objects.toString(JTableUtil.getValuesByHeader(tableViewData, "id", i),"");
						value_qc = Objects.toString(JTableUtil.getValuesByHeader(tableViewData, "value_qc" ,i), "");
						mistake = Objects.toString(JTableUtil.getValuesByHeader(tableViewData, "mistake" ,i), "");
						mapData.put(Long.parseLong(id),new String [] { value_qc , mistake });
					}
					if (mapData.size() > 0) {
						flag = daoCompareAndAnalyze.finishPath(mapData);
						if(flag) {
							loadFilePath();
						}
					}
				}
			} 
			catch (Exception e) {
				e.printStackTrace();
				AppUtility.msgInfo(this, "finish : "  + e.toString());
			}
		}

	}


}
