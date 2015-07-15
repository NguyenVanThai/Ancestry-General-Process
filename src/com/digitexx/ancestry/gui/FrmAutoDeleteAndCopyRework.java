package com.digitexx.ancestry.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
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

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.conts.StatusDelete;
import com.digitexx.ancestry.dao.DaoAutoDeleteData;
import com.digitexx.ancestry.util.AncestryException;
import com.digitexx.ancestry.util.AppUtility;
import com.digitexx.ancestry.util.Configuration;
import com.digitexx.ancestry.util.CopyFileUtil;
import com.digitexx.ancestry.util.DB3FileFilter;
import com.digitexx.ancestry.util.ExcelSheetReader;
import com.digitexx.ancestry.util.FileUtility;
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
public class FrmAutoDeleteAndCopyRework extends javax.swing.JFrame {
	private JPanel panelHeader;
	private JPanel panelFooter;
	private JScrollPane scrollPaneLog;
	private JButton buttonRunCopyRework;
	private JTable tableData;
	private JTable tableFile;
	private JScrollPane scrollPaneData;
	private JScrollPane scrollPaneFile;
	private JPanel panelFile;
	private JPanel panelData;
	private JSplitPane splitPaneFile;
	private JTextPane textPaneLog;
	private JPanel panelContent;
	private JPanel panelProgess;
	private JButton buttonRunDelete;
	private JPanel panelContentFile;
	private JPanel panelLog;
	private JSplitPane splitPaneContent;
	private JProgressBar progressBar;
	private JButton buttonBrowse;
	private JTextField textFieldPath;
	private JLabel jLabel1;
	
	private String [] arrExt = new String [] { "xls"  ,"xlsx" , "ods"};
	private List listExtension = new ArrayList();
	private List<File> listFileExcel = new ArrayList<File>();
	private List<List<String>> listDataExcel = new ArrayList<List<String>>();
	private List<String> listFileFinished = new ArrayList<String>();
	private List<File> listFileDelete = new ArrayList<File>();
	
	private DefaultTableModel modelFile = new DefaultTableModel();
	private DefaultTableModel modelData = new DefaultTableModel();
	private DaoAutoDeleteData daoAutoDeleteData ;
	private Tbl_Projects project;
	private FrmStep frmStep;
	private String username;
	private boolean isDelete;
	private String customerProjectId = "";

	public FrmAutoDeleteAndCopyRework(String username,Tbl_Projects project, boolean isDelete , FrmStep frmStep) {
		super();
		this.username = username;
		this.project = project;
		this.isDelete = isDelete;
		this.frmStep = frmStep;
		this.daoAutoDeleteData = new DaoAutoDeleteData(project);
		initGUI();
		initData();
	}
	
	private void initGUI() {
		try {
			if(isDelete) {
				this.setTitle("Form Auto Delete Data : " + project.getProj_name());
			}else {
				this.setTitle("Form Auto Copy Rework : " + project.getProj_name());
			}
			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			{
				panelHeader = new JPanel();
				AnchorLayout panelHeaderLayout = new AnchorLayout();
				getContentPane().add(panelHeader, new AnchorConstraint(0, 1000, 50, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelHeader.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelHeader.setLayout(panelHeaderLayout);
				panelHeader.setPreferredSize(new java.awt.Dimension(864, 26));
				{
					jLabel1 = new JLabel();
					panelHeader.add(jLabel1, new AnchorConstraint(57, 120, 942, 2, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jLabel1.setText("Select Folder");
					jLabel1.setFont(new java.awt.Font("Arial",1,14));
					jLabel1.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					jLabel1.setPreferredSize(new java.awt.Dimension(102, 23));
				}
				{
					textFieldPath = new JTextField();
					panelHeader.add(textFieldPath, new AnchorConstraint(17, 904, 982, 125, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					textFieldPath.setPreferredSize(new java.awt.Dimension(751, 27));
				}
				{
					buttonBrowse = new JButton();
					panelHeader.add(buttonBrowse, new AnchorConstraint(96, 998, 903, 905, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonBrowse.setText("Browse");
					buttonBrowse.setFont(new java.awt.Font("Arial",1,14));
					buttonBrowse.setPreferredSize(new java.awt.Dimension(80, 21));
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
				getContentPane().add(panelContent, new AnchorConstraint(48, 999, 917, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelContent.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelContent.setPreferredSize(new java.awt.Dimension(863, 457));
				{
					splitPaneContent = new JSplitPane();
					panelContent.add(splitPaneContent, BorderLayout.CENTER);
					splitPaneContent.setOrientation(JSplitPane.VERTICAL_SPLIT);
					{
						panelLog = new JPanel();
						BorderLayout panelLogLayout = new BorderLayout();
						panelLog.setLayout(panelLogLayout);
						splitPaneContent.add(panelLog, JSplitPane.RIGHT);
						panelLog.setBorder(BorderFactory.createTitledBorder(null, "Log", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,16), new java.awt.Color(255,0,0)));
						{
							scrollPaneLog = new JScrollPane();
							panelLog.add(scrollPaneLog, BorderLayout.CENTER);
							{
								textPaneLog = new JTextPane();
								scrollPaneLog.setViewportView(textPaneLog);
								textPaneLog.setFont(new java.awt.Font("Arial",0,14));
							}
						}
					}
					{
						panelContentFile = new JPanel();
						BorderLayout panelContentFileLayout = new BorderLayout();
						panelContentFile.setLayout(panelContentFileLayout);
						splitPaneContent.add(panelContentFile, JSplitPane.LEFT);
						panelContentFile.setPreferredSize(new java.awt.Dimension(857, 245));
						{
							splitPaneFile = new JSplitPane();
							panelContentFile.add(splitPaneFile, BorderLayout.CENTER);
							splitPaneFile.setDividerLocation(400);
							{
								panelData = new JPanel();
								BorderLayout panelDataLayout = new BorderLayout();
								panelData.setLayout(panelDataLayout);
								splitPaneFile.add(panelData, JSplitPane.RIGHT);
								panelData.setBorder(BorderFactory.createTitledBorder(null, "Data Of File", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,14), new java.awt.Color(0,0,255)));
								{
									scrollPaneData = new JScrollPane();
									panelData.add(scrollPaneData, BorderLayout.CENTER);
									{
										tableData = new JTable() {
											@Override
											public boolean isCellEditable(int row, int column) {
												return false;
											}
										};
										scrollPaneData.setViewportView(tableData);
									}
								}
							}
							{
								panelFile = new JPanel();
								BorderLayout panelFileLayout = new BorderLayout();
								panelFile.setLayout(panelFileLayout);
								splitPaneFile.add(panelFile, JSplitPane.LEFT);
								panelFile.setPreferredSize(new java.awt.Dimension(304, 243));
								panelFile.setBorder(BorderFactory.createTitledBorder(null, "List Files", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,14), new java.awt.Color(0,0,255)));
								{
									scrollPaneFile = new JScrollPane();
									panelFile.add(scrollPaneFile, BorderLayout.CENTER);
									{
										tableFile = new JTable() {;
										    public boolean isCellEditable(int row, int column) {
										    	return false;
										    }
										};
										tableFile.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
											
											@Override
											public void valueChanged(ListSelectionEvent e) {
												readDataExcel(tableFile.getSelectedRow());
											}
											
										});
										scrollPaneFile.setViewportView(tableFile);
									}
								}
							}
						}
					}
				}
			}
			{
				panelFooter = new JPanel();
				AnchorLayout panelFooterLayout = new AnchorLayout();
				getContentPane().add(panelFooter, new AnchorConstraint(951, 1000, 1000, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelFooter.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelFooter.setLayout(panelFooterLayout);
				panelFooter.setPreferredSize(new java.awt.Dimension(864, 26));
				{
					buttonRunCopyRework = new JButton();
					panelFooter.add(buttonRunCopyRework, new AnchorConstraint(17, 240, 948, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonRunCopyRework.setText("Run Copy Rework");
					buttonRunCopyRework.setPreferredSize(new java.awt.Dimension(231, 27));
					buttonRunCopyRework.setFont(new java.awt.Font("Arial",1,16));
					buttonRunCopyRework.setForeground(new java.awt.Color(0,0,255));
					buttonRunCopyRework.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							buttonRunCopyReworkActionPerformed(evt);
						}
					});
				}
				{
					buttonRunDelete = new JButton();
					panelFooter.add(buttonRunDelete, new AnchorConstraint(86, 998, 948, 866, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonRunDelete.setText("Run Delete");
					buttonRunDelete.setFont(new java.awt.Font("Arial",1,16));
					buttonRunDelete.setForeground(new java.awt.Color(255,0,0));
					buttonRunDelete.setPreferredSize(new java.awt.Dimension(127, 25));
					buttonRunDelete.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							buttonRunActionPerformed(evt);
						}
					});
				}
			}
			{
				panelProgess = new JPanel();
				BorderLayout jPanel1Layout = new BorderLayout();
				panelProgess.setLayout(jPanel1Layout);
				getContentPane().add(panelProgess, new AnchorConstraint(917, 1000, 951, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelProgess.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelProgess.setPreferredSize(new java.awt.Dimension(864, 18));
				{
					progressBar = new JProgressBar();
					panelProgess.add(progressBar, BorderLayout.CENTER);
				}
			}
			pack();
			this.setSize(971, 611);
			AppUtility.centerFrame(this);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					exit();
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(isDelete) {
			buttonRunDelete.setVisible(true);
			buttonRunCopyRework.setVisible(false);
		}else {
			buttonRunDelete.setVisible(false);
			buttonRunCopyRework.setVisible(true);
		}
	}
	
	private void exit() {
		if(AppUtility.msgConfirm(this, "Do you want to exit ??") == JOptionPane.OK_OPTION) {
			frmStep.setVisible(true);
			this.dispose();
		}
	}
	
	private void buttonBrowseActionPerformed(ActionEvent evt) {
		FileUtility.browse(textFieldPath, JFileChooser.DIRECTORIES_ONLY);
		loadListFileExcelFromPath();
	}
	
	private void buttonRunCopyReworkActionPerformed(ActionEvent evt) {
		int option = AppUtility.msgConfirm(this, "Do you want to copy data ??");
		if(option == JOptionPane.OK_OPTION) 
		{
//			Thread threadCopy = new Thread(new Runnable() {
//				@Override
//				public void run() {
			        copyDataByFile();	
//				}
//			});
//			threadCopy.start();
		}
	}
	
	private void buttonRunActionPerformed(ActionEvent evt) {
		int option = AppUtility.msgConfirm(this, "Do you want to delete data ??");
		if(option == JOptionPane.OK_OPTION) 
		{
			Thread threadDelete = new Thread(new Runnable() {
				@Override
				public void run() {
			        deleteDataByFile();	
				}
			});
			threadDelete.start();
		}
	}
	
	//===================================================================================================
	
	/**
	 * init default data
	 */
	private void initData() {
		try {
			listExtension = Arrays.asList(arrExt);
			customerProjectId = daoAutoDeleteData.getCustomerProjectId();
			if(customerProjectId.equals("")) {
				AppUtility.msgError(this, "Not found projectid from table project_info . Please check again !!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "initData : "  + e.toString());
		}
	}
	
	/**
	 * @return the listFileExcel
	 */
	public void loadListFileExcelFromPath() {
		try {
			listFileExcel = new ArrayList<File>();
			String path = StringUtil.setNotNull(textFieldPath.getText());
			listFileExcel = FileUtility.listFilesAndFilesSubDirectories(path);
			
			String [] headers = new String [] {"No." , "FileName" , "Extension" , "Status"};
			int idx = 1;
			Object [] values;
			String filename = "";
			String ext  ="";
			modelFile = new DefaultTableModel(headers ,0);
			for (File file : listFileExcel) 
			{
				filename = file.getName();
				ext = filename.substring(filename.lastIndexOf(".")+1);
				if(listExtension.contains(ext.toLowerCase())) {
					values = new Object [] {idx , filename , ext , "Pending" };
					modelFile.addRow(values);
					++idx;
				}
			}
			tableFile.setModel(modelFile);
			JTableUtil.styleTable(tableFile, true);
			JTableUtil.fitTableColumns(tableFile);
			readDataExcel(0);
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.appendText(textPaneLog, "loadListFileExcelFromPath : "  + e.toString(), Color.RED);
			AppUtility.msgError(this, "loadListFileExcelFromPath : "  + e.toString());
		}
	}
	
	/**
	 * read data of file excel
	 */
	private void readDataExcel(int row) {
		try {
			if(row > -1) {
				String path = textFieldPath.getText();
				String filename = StringUtil.setNotNull(JTableUtil.getValuesByHeaderName(tableFile, "FileName", row));
				String ext  = StringUtil.setNotNull(JTableUtil.getValuesByHeaderName(tableFile, "Extension", row));
				listDataExcel = new ArrayList<List<String>>();
				if(ext.equals("ods") || ext.equals("xls")) {
					listDataExcel = ExcelSheetReader.readExcelFile2003(path + "/"+filename);
				}else {
					listDataExcel = ExcelSheetReader.readExcel2007(path + "/"+filename);
				}
				
				JTableUtil.removeAllRow(tableData);
				if(listDataExcel.size() > 0) 
				{
					List<String> listHeader = listDataExcel.get(0);
					listHeader.add(0, "No.");
					String [] headers = StringUtil.listToArray(listHeader);
					modelData = new DefaultTableModel(headers ,0);
					
					String batch = "";
					String status = "";
					Object [] values ;
					int idx = 1;
					boolean isFirst = true;
					for (List<String> listTmp : listDataExcel) 
					{
						if(!isFirst) 
						{
							listTmp.add(0, idx+"");
							values = new String [ listTmp.size() ];
							values = StringUtil.listToArray(listTmp);
							status = StringUtil.setNotNull(listTmp.get(2));
							batch  = StringUtil.setNotNull(listTmp.get(1));
							
							if(status.equalsIgnoreCase(StatusDelete.Idx_Complete) || !isDelete) {
								modelData.addRow(values);
								listFileFinished.add(batch);
								++idx;
							}
						}
                        isFirst = false;
					}
					tableData.setModel(modelData);
					JTableUtil.styleTable(tableData, true);
					JTableUtil.fitTableColumns(tableData);
				}
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			AppUtility.appendText(textPaneLog, "readDataExcel : "  + e.toString(), Color.RED);
			AppUtility.msgError(this, "readDataExcel : "  + e.toString());
		}
	}
	
	/*======PROCESS DELETE FILE===========================================================================*/
	
	/**
	 * delete data by file
	 */
	private void deleteDataByFile() {
		int totalFiles = tableFile.getRowCount();
		boolean flag = true;
		try {
			if (totalFiles > 0) 
			{
				for (int row = 0; row < totalFiles; row++) {
					tableFile.setValueAt("Processing", row, 3);
					readDataExcel(row);
					if(processDeleteData()) {
						tableFile.setValueAt("Finished", row, 3);
					}
				}
			}
		} catch (Exception e) {
			flag = false;
			AppUtility.appendText(textPaneLog,"deleteDataByFile : " + e.toString(), Color.RED);
			AppUtility.msgError(this, "deleteDataByFile : " + e.toString());
		}
		if(flag) {
			if(flag) {
	        	AppUtility.appendText(textPaneLog, "-----------FINISHED DELETE DATA FROM P & 10.10.5.206------------------------------------------------", Color.BLACK);
	            AppUtility.msgInfo(this, "FINISHED DELETE DATA FROM P & 10.10.5.206");
	            progressBar.setValue(100);
			}
		}

	}
	
	/**
	 * process delete data
	 */
	private boolean processDeleteData() throws AncestryException
	{
		textPaneLog.setText("");
		boolean flag = true;
		try {
			int totalRow = tableData.getRowCount();
			String batchName = "";
			StringBuilder imagePathServer = new StringBuilder();
			String imagePathLocal = "";
			File fileServer ;
			File fileLocal ;
			
			if(totalRow > 0)
			{
				int count =0;
				for (int i = 0; i < totalRow; i++)
				{
					progressBar.setMinimum(0);
					progressBar.setMaximum(100);
					
					imagePathServer = new StringBuilder();
					batchName = JTableUtil.getValuesByHeaderName(tableData, "Batch Name", i);
					AppUtility.appendText(textPaneLog, "Start process : "  + batchName, Color.BLACK);
                    imagePathLocal = daoAutoDeleteData.getFilePathFromBatch(batchName);
                    
                    /*******DELETE FROM P ****************/
                    
					AppUtility.appendText(textPaneLog, "Start delete : "  + imagePathLocal, Color.BLUE);
					if(imagePathLocal.endsWith("Images")) {
						imagePathLocal = imagePathLocal.substring(0 , imagePathLocal.lastIndexOf("Images")-1);
			        }
                    fileLocal = new File(imagePathLocal);
					if(FileUtility.removeDirectory(fileLocal)) {
                    	AppUtility.appendText(textPaneLog, "Finished delete : "  + imagePathLocal, Color.BLUE);
                    	++count;
                    	progressBar.setValue(count);
                    }
                    
                    /*******DELETE FROM SERVER ***********/
                    
                    imagePathServer.append("\\\\");
                    imagePathServer.append(Configuration.SERVER_DELETE);
                    imagePathServer.append("\\");
                    imagePathServer.append(Configuration.FOLDER_DELETE);
                    imagePathServer.append("\\");
                    imagePathServer.append(customerProjectId);
                    imagePathServer.append("\\");
                    imagePathServer.append(batchName);
                    
                    fileServer = new File(imagePathServer.toString());
					AppUtility.appendText(textPaneLog, "Start delete : "  + imagePathServer.toString(), Color.BLUE);
                    if(FileUtility.removeDirectory(fileServer)) {
                    	AppUtility.appendText(textPaneLog, "Finished delete : "  + imagePathServer.toString(), Color.BLUE);
                    	++count;
                    	progressBar.setValue(count);
                    }
                	AppUtility.appendText(textPaneLog, "------------------------------------------------------------", Color.BLACK);
				}
			}
		} catch (Exception e) {
			flag = false;
            throw new AncestryException("processDeleteData : "  + e.toString(), e);
		}
		return flag;
	}

	/*======PROCESS COPY FILE======================================================================*/
	
	/**
	 * copy data by file
	 */
	private void copyDataByFile() {
		int totalFiles = tableFile.getRowCount();
		boolean flag = true;
		try {
			if (totalFiles > 0) 
			{
				for (int row = 0; row < totalFiles; row++) {
					tableFile.setValueAt("Processing", row, 3);
					readDataExcel(row);
					if(processcopyData()) {
						tableFile.setValueAt("Finished", row, 3);
					}
				}
			}
		} catch (Exception e) {
			flag = false;
			AppUtility.appendText(textPaneLog,"copyDataByFile : " + e.toString(), Color.RED);
			AppUtility.msgError(this, "copyDataByFile : " + e.toString());
		}
		if(flag) {
			if(flag) {
	        	AppUtility.appendText(textPaneLog, "-----------FINISHED COPY DATA FROM 10.10.5.206------------------------------------------------", Color.BLACK);
	            AppUtility.msgInfo(this, "FINISHED COPY DATA FROM 10.10.5.206");
	            progressBar.setValue(100);
			}
		}

	}
	
	/**
	 * process copy data
	 */
	private boolean processcopyData() throws AncestryException
	{
		textPaneLog.setText("");
		boolean flag = true;
		try {
			int totalRow = tableData.getRowCount();
			String currentDate = StringUtil.getStringCurrentDate();
			String batchName = "";
			StringBuilder imagePathServer = new StringBuilder();
			String imagePathLocal = "";
			File fileServer = null ;
			File fileLocal ;
			
			if(totalRow > 0)
			{
				int count =0;
				for (int i = 0; i < totalRow; i++)
				{
					progressBar.setMinimum(0);
					progressBar.setMaximum(100);
					
					imagePathServer = new StringBuilder();
					batchName = JTableUtil.getValuesByHeaderName(tableData, "Batch Name", i);
					AppUtility.appendText(textPaneLog, "Start process : "  + batchName, Color.BLACK);
                    imagePathLocal = daoAutoDeleteData.getFilePathFromBatch(batchName);
                    imagePathLocal = imagePathLocal.replace("\\", "/");
                    imagePathLocal = imagePathLocal.substring( 0 , imagePathLocal.indexOf("Images")-1);
                    imagePathLocal = imagePathLocal + "/Feedback_SQLite/";
                    
                    /*******GET PATH FROM SERVER***********/
                    
                    imagePathServer.append("\\\\");
                    imagePathServer.append(Configuration.SERVER_DELETE);
                    imagePathServer.append("\\");
                    imagePathServer.append(Configuration.FOLDER_COPY);
                    imagePathServer.append("\\");
                    imagePathServer.append(customerProjectId);
                    imagePathServer.append("\\");
                    imagePathServer.append(batchName);
                    
                    /*******COPY FILE FROM 10.10.5.206 TO P/.../Feedback_SQLite ****************/
                    
                    System.out.println("imagePathServer : "  + imagePathServer  +"\t : imagePathLocal "  + imagePathLocal);
                    
					AppUtility.appendText(textPaneLog, "Start copy to Feedback_SQLite : "  + imagePathLocal, Color.BLUE);
                    fileLocal = new File(imagePathLocal);
					if(CopyFileUtil.copyDirectory(fileServer, fileLocal , new DB3FileFilter())) {
                    	AppUtility.appendText(textPaneLog, "Finished copy to Feedback_SQLite : "  + imagePathLocal, Color.BLUE);
                    	++count;
                    	progressBar.setValue(count);
                    }
                    
                    /*******COPY FILE FROM 10.10.5.206 TO P/.../Feedback ***********/
                    
					imagePathLocal = imagePathLocal.replace("Feedback_SQLite", "Managings_Tool");
					imagePathLocal = imagePathLocal + "/Feedback/" + currentDate;
					
                    fileServer = new File(imagePathServer.toString());
					AppUtility.appendText(textPaneLog, "Start copy to Feedback : "  + imagePathServer.toString(), Color.BLUE);
					if(CopyFileUtil.copyDirectory(fileServer, fileLocal , new DB3FileFilter()))  {
                    	AppUtility.appendText(textPaneLog, "Finished copy to Feedback : "  + imagePathServer.toString(), Color.BLUE);
                    	++count;
                    	progressBar.setValue(count);
                    }
                	AppUtility.appendText(textPaneLog, "------------------------------------------------------------", Color.BLACK);
				}
			}
		} catch (Exception e) {
			flag = false;
            throw new AncestryException("processcopyData : "  + e.toString(), e);
		}
		return flag;
	}

}
