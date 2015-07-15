package com.digitexx.ancestry.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.ancestry.bean.AuditResult;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.dao.DaoImportFeedback;
import com.digitexx.ancestry.table.render.DragHook;
import com.digitexx.ancestry.util.AppUtility;
import com.digitexx.ancestry.util.FileUtility;
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
public class FrmImportCustomerFeedback extends javax.swing.JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel panelHeader;
	private JPanel panelContent;
	private JPanel panelFooter;
	private JScrollPane scrollPaneLog;
	private JCheckBox checkboxImportWithotAuditData;
	private JCheckBox checkboxImportNewGroupField;
	private JCheckBox checkboxImportExist;
	private JProgressBar progressBar;
	private JPanel panelProcess;
	private JButton buttonImport;
	private JTextPane textPaneLog;
	private JTable tableFile;
	private JScrollPane scrollPaneTable;
	private JPanel panelLog;
	private JPanel panelTable;
	private JSplitPane splitPaneContent;
	private JButton buttonBrowse;
	private JTextField txtPath;

    private String projectName;
    private Tbl_Projects project;
    private FrmStep frmStep;
    private DaoImportFeedback daoImportFeedback ;
    private List<AuditResult> listFeedbackData = new ArrayList<AuditResult>();
    private File[] db3Files;
    private DefaultTableModel model;
	
	public FrmImportCustomerFeedback(FrmStep frmStep,String projectName , Tbl_Projects project) {
		super();
		this.frmStep = frmStep;
		this.projectName = projectName;
		this.project = project;
		initGUI();
		AppUtility.centerFrame(this);
		daoImportFeedback = new DaoImportFeedback(textPaneLog , project);
	}
	
	private void initGUI() {
		try {
			this.setTitle("Form Import Customer Feedback");
			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			{
				panelProcess = new JPanel();
				BorderLayout panelProcessLayout = new BorderLayout();
				panelProcess.setLayout(panelProcessLayout);
				getContentPane().add(panelProcess, new AnchorConstraint(910, 1000, 946, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelProcess.setPreferredSize(new java.awt.Dimension(888, 21));
				panelProcess.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				{
					progressBar = new JProgressBar();
					panelProcess.add(progressBar, BorderLayout.CENTER);
				}
			}
			{
				panelHeader = new JPanel();
				AnchorLayout panelHeaderLayout = new AnchorLayout();
				getContentPane().add(panelHeader, new AnchorConstraint(0, 1000, 52, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelHeader.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelHeader.setLayout(panelHeaderLayout);
				panelHeader.setPreferredSize(new java.awt.Dimension(888, 30));
				{
					txtPath = new JTextField();
					panelHeader.add(txtPath, new AnchorConstraint(83, 904, 950, 2, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					txtPath.setPreferredSize(new java.awt.Dimension(801, 26));
					txtPath.setFont(new java.awt.Font("Tahoma",0,14));
				}
				{
					buttonBrowse = new JButton();
					panelHeader.add(buttonBrowse, new AnchorConstraint(50, 998, 950, 904, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonBrowse.setText("Browse");
					buttonBrowse.setFont(new java.awt.Font("Tahoma",1,14));
					buttonBrowse.setPreferredSize(new java.awt.Dimension(83, 27));
					buttonBrowse.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							buttonBrowseActionPerformed(evt);
						}
					});
				}
			}
			{
				panelContent = new JPanel();
				BorderLayout panelContentLayout = new BorderLayout();
				panelContent.setLayout(panelContentLayout);
				getContentPane().add(panelContent, new AnchorConstraint(52, 1000, 910, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelContent.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelContent.setPreferredSize(new java.awt.Dimension(888, 502));
				{
					splitPaneContent = new JSplitPane();
					panelContent.add(splitPaneContent, BorderLayout.CENTER);
					splitPaneContent.setDividerLocation(250);
					splitPaneContent.setOrientation(JSplitPane.VERTICAL_SPLIT);
					{
						panelLog = new JPanel();
						BorderLayout panelLogLayout = new BorderLayout();
						panelLog.setLayout(panelLogLayout);
						splitPaneContent.add(panelLog, JSplitPane.RIGHT);
						panelLog.setBorder(BorderFactory.createTitledBorder(null, "Log", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,14), new java.awt.Color(255,0,0)));
						{
							scrollPaneLog = new JScrollPane();
							panelLog.add(scrollPaneLog, BorderLayout.CENTER);
							{
								textPaneLog = new JTextPane();
								scrollPaneLog.setViewportView(textPaneLog);
							}
						}
					}
					{
						panelTable = new JPanel();
						BorderLayout panelTableLayout = new BorderLayout();
						panelTable.setLayout(panelTableLayout);
						splitPaneContent.add(panelTable, JSplitPane.LEFT);
						panelTable.setPreferredSize(new java.awt.Dimension(179, 506));
						panelTable.setBorder(BorderFactory.createTitledBorder(null, "List Files", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,14), new java.awt.Color(0,0,0)));
						{
							scrollPaneTable = new JScrollPane();
							panelTable.add(scrollPaneTable, BorderLayout.CENTER);
							{
								tableFile = new JTable() {
									@Override
									public boolean isCellEditable(int row,int column) {
										if(getColumnName(column).equals("Import Existed") || getColumnName(column).equals("Import New Group Field"))
										{
											return true;
										}else {
											return false;
										}
									}
									
									@Override
									public Class<?> getColumnClass(int column) 
									{
                                         if(getColumnName(column).equals("Import Existed") || getColumnName(column).equals("Import New Group Field")) {
 											return Boolean.class;
                                         }else {
 											return String.class;
                                         }
									}
									
									@Override
									protected JTableHeader createDefaultTableHeader() {
										JTableHeader header = new JTableHeader(getColumnModel()) {
											DragHook hook;

											@Override
											public void updateUI() {
												if (hook != null) {
													hook.uninstallHook();
													hook = null;
												}
												super.updateUI();
												hook = new DragHook(this, "No.");
											}

										};
										return header;
									}
									
									
								};
								scrollPaneTable.setViewportView(tableFile);
							}
						}
					}
				}
			}
			{
				panelFooter = new JPanel();
				AnchorLayout panelFooterLayout = new AnchorLayout();
				getContentPane().add(panelFooter, new AnchorConstraint(947, 1000, 1000, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelFooter.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelFooter.setLayout(panelFooterLayout);
				panelFooter.setPreferredSize(new java.awt.Dimension(888, 31));
				{
					checkboxImportWithotAuditData = new JCheckBox();
					panelFooter.add(checkboxImportWithotAuditData, new AnchorConstraint(109, 653, 953, 419, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					checkboxImportWithotAuditData.setText("Import Without Audit Data");
					checkboxImportWithotAuditData.setPreferredSize(new java.awt.Dimension(208, 27));
					checkboxImportWithotAuditData.setFont(new java.awt.Font("Arial",1,14));
					checkboxImportWithotAuditData.setForeground(new java.awt.Color(255,0,0));
				}
				{
					checkboxImportNewGroupField = new JCheckBox();
					panelFooter.add(checkboxImportNewGroupField, new AnchorConstraint(46, 418, 953, 176, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					checkboxImportNewGroupField.setText("Import New Group Field");
					checkboxImportNewGroupField.setPreferredSize(new java.awt.Dimension(215, 29));
					checkboxImportNewGroupField.setFont(new java.awt.Font("Arial",1,14));
					checkboxImportNewGroupField.setForeground(new java.awt.Color(0,0,255));
					checkboxImportNewGroupField.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							checkboxImportNewGroupFieldActionPerformed(evt);
						}
					});
				}
				{
					checkboxImportExist = new JCheckBox();
					panelFooter.add(checkboxImportExist, new AnchorConstraint(46, 171, 953, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					checkboxImportExist.setText("Import Existed");
					checkboxImportExist.setPreferredSize(new java.awt.Dimension(152, 29));
					checkboxImportExist.setFont(new java.awt.Font("Arial",1,14));
					checkboxImportExist.setForeground(new java.awt.Color(0,0,255));
					checkboxImportExist.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							checkboxImportExistActionPerformed(evt);
						}
					});
				}
				{
					buttonImport = new JButton();
					panelFooter.add(buttonImport, new AnchorConstraint(80, 998, 951, 902, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonImport.setText("Import");
					buttonImport.setFont(new java.awt.Font("Tahoma",1,14));
					buttonImport.setForeground(new java.awt.Color(255,0,0));
					buttonImport.setPreferredSize(new java.awt.Dimension(85, 27));
					buttonImport.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							buttonImportActionPerformed(evt);
						}
					});
				}
			}
			pack();
			this.setSize(896, 619);
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
	
	private void exit() {
		if(AppUtility.msgConfirm(this, "Do you want to exit ??") == JOptionPane.OK_OPTION) {
			frmStep.setVisible(true);
			this.dispose();
		}
	}
	
	//===========================================================================================================================
	
	FileFilter fileFilter = new FileFilter() {
		@Override
		public boolean accept(File pathname) {
			String extendstion = pathname.getName();
			if(!"db3".equals(extendstion.substring(extendstion.lastIndexOf(".")+1)))
				return false;
			return true;
		}
	};
	
	private void buttonBrowseActionPerformed()
	{
		JFileChooser filechooser;
		FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Just get db3 file.", "db3");
		String directories = txtPath.getText().trim();
		
		if(!directories.equals(""))
			filechooser = new JFileChooser(directories);
		else
			filechooser = new JFileChooser();
		
		filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		filechooser.setMultiSelectionEnabled(true);
		filechooser.setFileFilter(extensionFilter);
		
		int chooser = filechooser.showOpenDialog(filechooser);
		if(chooser == JFileChooser.APPROVE_OPTION)
		{
			File f = filechooser.getSelectedFile();
			txtPath.setText(f.getAbsoluteFile()+"");
			String path = Objects.toString(txtPath.getText(), "");
			loadInfoToGrid(path);
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
		JTableUtil.fitTableColumns(tableData);
	}
	
	private void doImportFeedBack() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public synchronized void run() {
				textPaneLog.setText("");
				importFeedBack();
			}
		});
		thread.start();
	}
	
	private void loadInfoToGrid(String path) 
	{
		List<String> listFileName = new ArrayList<String>();
		listFileName = FileUtility.allFilesIncludeSubFolder(path);
		
        model = new DefaultTableModel(new String [] { "No." , "File" , "Import Existed" , "Import New Group Field" , "Status" } , 0);
        JTableUtil.removeAllRow(tableFile);
        if(listFileName.size()  >0) 
        {
            Object []  values ;
            int index =1;
            for (String str : listFileName) {
            	str = str.replace("\\", "/");
            	str = str.substring(str.lastIndexOf("/")+1);
            	if(str.contains(".db3")) {
            		values = new Object [] { index , str , Boolean.FALSE , Boolean.FALSE , "Processing" };
            		model.addRow(values);
            		++index;
            	}
    		}
            tableFile.setModel(model);
            styleTable(tableFile);
        }

	}
	
	private int findRowByValue(String value) {
		int result = -1;
		int total = tableFile.getRowCount();
		String filename = "";
		int idx = tableFile.getColumnModel().getColumnIndex("File");
		for (int i = 0; i < total; i++) {
			filename = Objects.toString(tableFile.getValueAt(i, idx ) , "");
			if(filename.equals(value)) {
				result = i;
				break;
			}
		}
		return result;
	}
	
	private void resetValueJtable(String batchName , String status) 
	{
		int row = findRowByValue(batchName);
		if(row > -1) {
			int column = tableFile.getColumnModel().getColumnIndex("Status");
			tableFile.setValueAt(status, row, column);
		}
	}
	
	
	//===================================================================================================================
	
	private void importFeedBack()
	{
		listFeedbackData = new ArrayList<AuditResult>();
		
		try {
			
			Map<String, String> mapCheckExport = daoImportFeedback.getMapCheckExport();
			if(mapCheckExport.size() == 0)
			{
				JOptionPane.showMessageDialog(this, "Thiếu dữ liệu trong check_export !!");
				return;
			}
			
			File folder = new File(txtPath.getText().trim());
			if(txtPath.getText().length() == 0)
			{
				JOptionPane.showMessageDialog(this, "Vui lòng chọn đường dẫn !!");
				return;
			}
			if(!folder.exists())
			{
				JOptionPane.showMessageDialog(this, txtPath.getText().trim() + " is not found !");
				return;
			}
			
			db3Files = folder.listFiles(fileFilter);
			progressBar.setMaximum(db3Files.length);
			int index = 0;
			boolean flag = true;
			boolean flagCheckFile;
			String batchName = "";
			Integer versionExportFile;
			Integer versionImport;
			
			String path = txtPath.getText();
			String filename = "";
			boolean importExist = false;
			boolean importNew = false;
			int totalRow = tableFile.getRowCount();
			StringBuilder sbTemplate = new StringBuilder();
			String tmp = "";
			File db3File = null;
			for (int row = 0; row < totalRow; row++) 
			{
				sbTemplate = new StringBuilder();
				importExist = Boolean.parseBoolean(JTableUtil.getValuesByHeader(tableFile, "Import Existed", row).toString());
				importNew   = Boolean.parseBoolean(JTableUtil.getValuesByHeader(tableFile, "Import New Group Field", row).toString());
				filename    = Objects.toString(JTableUtil.getValuesByHeader(tableFile, "File", row),"");
				db3File     = new File(path + "/"  +filename);
				
				listFeedbackData = daoImportFeedback.getListFeedBackData(db3File.getAbsolutePath());
				batchName = db3File.getName().replace("_VendorReport.db3", "");
				flagCheckFile = false;
				index ++;
				try {
					
					String imagePath = daoImportFeedback.getFilePath(batchName);
					imagePath = imagePath.replace("\\", "/");
					if(imagePath.length() == 0)
					{
						AppUtility.appendText(textPaneLog, batchName + " NOT FOUND IN MANAGEMENT_REWORK ! \n" , Color.RED);
						continue;
					}
					
					String arrFilePath[] = imagePath.split("/");
					for (int i=0 ; i< arrFilePath.length-1 ;i++) {
						tmp = arrFilePath[i];
						if(tmp.equals("Images")) {
							break;
						}
						sbTemplate.append(tmp);
						sbTemplate.append("/");
					}
					sbTemplate.append("Feedback_SQLite/");
					sbTemplate.append(batchName);
					sbTemplate.append(".db3");
					String db3FilePathExport = sbTemplate.toString();
					
//					String db3FilePathExport = arrFilePath[0] + "/" + arrFilePath[1] + "/Feedback_SQLite/" + batchName + ".db3";
					File db3FileExport = new File(db3FilePathExport);

					if (!db3FileExport.exists()) {
						AppUtility.appendText(textPaneLog, "\n NOT FOUND FILE DB3 TEMPLATE ! PLEASE CHECK AGAIN! "  + db3FilePathExport , Color.RED);
						flag = false;
						continue;
					}
					
					versionExportFile = daoImportFeedback.getVersionExportFile(db3FileExport.getAbsolutePath());
					versionImport = daoImportFeedback.getVersionImport(batchName);
					if(versionExportFile == 0 && !checkboxImportWithotAuditData.isSelected())
					{
						AppUtility.appendText(textPaneLog, "WRONG FILE DB3 FEEDBACK_SQLITE ==> Not found data in table Audit of file export !!" , Color.BLACK);
						flag = false;
						continue;
					}
					if (versionImport != (versionExportFile - 1)) {
						flagCheckFile = true;
					}
					
					boolean flagInsert = daoImportFeedback.saveFeedBack(listFeedbackData, 
							                                            db3File.getAbsolutePath(),
							                                            imagePath , 
							                                            batchName , 
							                                            mapCheckExport,
							                                            importExist,
							                                            importNew);
					if(flagInsert) {
						AppUtility.appendText(textPaneLog , "Finished import file : " + batchName + " !!" , Color.BLUE);
					}
				} 
				catch (Exception e) {
					e.printStackTrace();
					resetValueJtable(db3File.getName() , "Error");
					AppUtility.appendText(textPaneLog, e.toString() , Color.RED);

				}
				resetValueJtable(db3File.getName() , "Finished");
				progressBar.setValue(index);
			}
			AppUtility.msgInfo(this, "Finished process import data !!");
		} 
		catch (Exception e) {
			e.printStackTrace();
			AppUtility.appendText(textPaneLog, e.toString() , Color.RED);
		}
					
	}
	
	/**
	 * set check all jtable
	 */
	private void checkAllTable(String columName , boolean flag) {

		int totalRow = tableFile.getRowCount();
		int col = tableFile.getColumnModel().getColumnIndex(columName);
		for (int i = 0; i < totalRow; i++) {
			tableFile.setValueAt(flag, i, col);
		}
	}
	
	//===================================================================================================================
	
	
	
	private void buttonBrowseActionPerformed(ActionEvent evt) {
		buttonBrowseActionPerformed();
	}
	
	private void buttonImportActionPerformed(ActionEvent evt) {
		doImportFeedBack();
	}
	
	private void checkboxImportExistActionPerformed(ActionEvent evt) {
		if(checkboxImportExist.isSelected()) {
			checkAllTable("Import Existed" , Boolean.TRUE);
		}else {
			checkAllTable("Import Existed" , Boolean.FALSE);
		}
	}
	
	private void checkboxImportNewGroupFieldActionPerformed(ActionEvent evt) {
		if(checkboxImportNewGroupField.isSelected()) {
			checkAllTable("Import New Group Field" , Boolean.TRUE);
		}else {
			checkAllTable("Import New Group Field" , Boolean.FALSE);
		}
	}

}
