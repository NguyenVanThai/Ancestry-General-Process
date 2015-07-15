package com.digitexx.ancestry.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.conts.BeanFieldDefinition;
import com.digitexx.ancestry.conts.BeanHeaderSQLite;
import com.digitexx.ancestry.conts.BeanRecordSQLite;
import com.digitexx.ancestry.dao.DaoCheckExport;
import com.digitexx.ancestry.db.ConnectionDB$SQLite;
import com.digitexx.ancestry.util.AppUtility;
import com.digitexx.ancestry.util.FileUtility;
import com.digitexx.ancestry.util.JTableUtil;
import com.digitexx.ancestry.util.StringUtil;
import com.digitexx.conts.FieldType;

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
public class FrmCheckExport extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JTextField textFieldFileCheckExport;
	private JButton buttonCheck;
	private JButton buttonBrowse;
	private JPanel panelFoderCheckExport;
	
	private FrmStep frmStep;
	private Tbl_Projects project;
	private JPanel panelContent;
	private JTable tableData;
	private JScrollPane scrollpaneTable;
	private DefaultTableModel tableDataModel = new DefaultTableModel();
	
	private String ori_file = "";
	private List<String> db3Files;
	
	private DaoCheckExport daoCheckExport;
	private ConnectionDB$SQLite db$sqLite ;
	private BeanFieldDefinition beanField = new BeanFieldDefinition();
	private Thread threadCheck;

	public FrmCheckExport(FrmStep frmStep , Tbl_Projects project) {
		super();
		this.frmStep = frmStep;
		this.project = project;
		db$sqLite 	= new ConnectionDB$SQLite();
		daoCheckExport = new DaoCheckExport(project);
		initGUI();		
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

	private void initGUI() {
		try {
			{
				setTitle("Form QMD Check Export");
				AnchorLayout thisLayout = new AnchorLayout();
				getContentPane().setLayout(thisLayout);
				{
					panelContent = new JPanel();
					BorderLayout panelContentLayout = new BorderLayout();
					panelContent.setLayout(panelContentLayout);
					getContentPane().add(panelContent, new AnchorConstraint(129, 1000, 902, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					panelContent.setPreferredSize(new java.awt.Dimension(887, 410));
					panelContent.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
					{
						scrollpaneTable = new JScrollPane();
						panelContent.add(scrollpaneTable);
						scrollpaneTable.setPreferredSize(new java.awt.Dimension(856, 406));
						{
							tableDataModel = 
									new DefaultTableModel(
											new String[][] { { "", "" } },
											new String[] { "No", "File", "Status", "Error" });
							tableData = new JTable(){
								@Override
								public Component prepareRenderer(
										TableCellRenderer renderer, int row,
										int column) {
									// TODO Auto-generated method stub
									Component c = super.prepareRenderer(renderer, row, column);
									if(column == 2){
										Object o = tableData.getValueAt(row, column);
										c.setFont(c.getFont().deriveFont(
												Font.BOLD));
										c.setForeground(Color.blue);
										if(o != null && o instanceof String){
											if(o.toString().trim().toLowerCase().equals("fail")){
												c.setForeground(Color.red);
											}
										}
									} 
									else if(column == 3){
										Object o = tableData.getValueAt(row, column);
										c.setFont(c.getFont().deriveFont(
												Font.BOLD));
										c.setForeground(Color.blue);
										if(o != null && o instanceof String){
											if(!o.toString().toLowerCase().equals("not error")){
												c.setForeground(Color.red);
											}
										}
									}
									else {
										c.setForeground(Color.blue);
									}
									
									return c;
								}
							};
							AnchorLayout tableDataLayout = new AnchorLayout();
							tableData.setLayout(tableDataLayout);
							scrollpaneTable.setViewportView(tableData);
							tableData.setModel(tableDataModel);
							tableData.setFont(new java.awt.Font("Tahoma",0,12));
							tableData.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
							tableData.getTableHeader().setPreferredSize(new java.awt.Dimension(865, 18));
						}
					}
				}
				{
					panelFoderCheckExport = new JPanel();
					AnchorLayout panelFoderCheckExportLayout = new AnchorLayout();
					getContentPane().add(panelFoderCheckExport, new AnchorConstraint(0, 1000, 106, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					panelFoderCheckExport.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
					panelFoderCheckExport.setLayout(panelFoderCheckExportLayout);
					panelFoderCheckExport.setPreferredSize(new java.awt.Dimension(887, 56));
					panelFoderCheckExport.setBounds(0, 0, 887, 56);
					{
						jLabel1 = new JLabel();
						panelFoderCheckExport.add(jLabel1, new AnchorConstraint(187, 130, 830, 9, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jLabel1.setText("Choose Folder");
						jLabel1.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
						jLabel1.setFont(new java.awt.Font("Tahoma",1,14));
						jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
						jLabel1.setPreferredSize(new java.awt.Dimension(107, 36));
					}
					{
						textFieldFileCheckExport = new JTextField();
						panelFoderCheckExport.add(textFieldFileCheckExport, new AnchorConstraint(205, 826, 812, 134, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						textFieldFileCheckExport.setPreferredSize(new java.awt.Dimension(614, 34));
						textFieldFileCheckExport.setText("");
					}
					{
						buttonBrowse = new JButton();
						panelFoderCheckExport.add(buttonBrowse, new AnchorConstraint(187, 989, 812, 840, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						buttonBrowse.setText("Browse");
						buttonBrowse.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
						buttonBrowse.setFont(new java.awt.Font("Tahoma",1,14));
						buttonBrowse.setHorizontalAlignment(SwingConstants.CENTER);
						buttonBrowse.setPreferredSize(new java.awt.Dimension(132, 35));
						buttonBrowse.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								buttonFileExportActionPerformed(evt);
							}
						});
					}
				}
				{
					buttonCheck = new JButton();
					getContentPane().add(buttonCheck, new AnchorConstraint(914, 559, 991, 416, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonCheck.setText("Check");
					buttonCheck.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
					buttonCheck.setFont(new java.awt.Font("Tahoma",1,14));
					buttonCheck.setHorizontalAlignment(SwingConstants.CENTER);
					buttonCheck.setBounds(402, 484, 127, 41);
					buttonCheck.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							buttonCheckFileExportActionPerformed(evt);
						}
					});
				}
			}
			{
				this.setSize(895, 564);
				AppUtility.centerFrame(this);
				this.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent evt) {
						exit();
					}
					
				});
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void exit() {
		int option = AppUtility.msgConfirm(this, "Do you want to exit ??");
		if(option == JOptionPane.YES_OPTION) {
			frmStep.setVisible(true);
			this.dispose();
		}
	}
	
	private void buttonFileExportActionPerformed(ActionEvent evt) {
		try{			
			ori_file = textFieldFileCheckExport.getText().trim();
			JFileChooser fileChooser ; 
			if( !"".equals( ori_file )  )
				fileChooser = new JFileChooser(ori_file);
			else
				fileChooser = new JFileChooser();

			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			
			int returnVal = fileChooser.showDialog(this, "Select Folder");
			
			String folders = "";
			if (returnVal == JFileChooser.APPROVE_OPTION)  {
				if(fileChooser.getSelectedFile().toString() == null){
					return ;
				}
				folders = fileChooser.getSelectedFile().toString();
				textFieldFileCheckExport.setText(folders);
				loadFileExport();
			}	
			loadFieldDefinition();
			//initData();
		}catch( Exception e ){
			e.printStackTrace();
		}
	}
	
	private void buttonCheckFileExportActionPerformed(ActionEvent evt) {
		doCheckExport();		
	}
	
	FileFilter fileFilter = new FileFilter() {
		@Override
		public boolean accept(File pathname) {
			if(pathname.isDirectory()){
				
			}else{
				String extendstion = pathname.getName();
				if(!"db3".equals(extendstion.substring(extendstion.lastIndexOf(".")+1)))
					return false;
			}
			return true;
		}
	};
	
	private void doCheckExport() {
		threadCheck = new Thread(new Runnable() {
			@Override
			public synchronized void run() {
				checkExport();
				
			}
		});
		threadCheck.start();
	}
	
	//=====================================================================================================
	
//	private void initData() {
//		try {
//			loadFieldDefinition();
//		} catch (Exception e) {
//			e.printStackTrace();
//			AppUtility.msgError(this, "initData : "  + e.toString());
//		}
//	}
	
	private void loadFieldDefinition() throws Exception{
		 beanField = new BeanFieldDefinition();
		 beanField = daoCheckExport.getListFieldExportHeader(db3Files.get(0));
	}
	
	private void loadFileExport()
	{
		try {
			tableDataModel = new DefaultTableModel(
							new String[][] { { "", "" } },
							new String[] { "No", "File", "Status", "Error" });
			File folder = new File(textFieldFileCheckExport.getText().trim());
			JTableUtil.removeAllRow(tableData);
			if(textFieldFileCheckExport.getText().length() == 0)
			{
				JOptionPane.showMessageDialog(this, "Vui lòng chọn đường dẫn !!");
				return;
			}
			if(!folder.exists())
			{
				JOptionPane.showMessageDialog(this, textFieldFileCheckExport.getText().trim() + " is not found !");
				return;
			}			
			db3Files = FileUtility.allFilesIncludeSubFolderDB3(textFieldFileCheckExport.getText());
			setValueToModelTable(db3Files);
			JTableUtil.styleTable(tableData, true);
			JTableUtil.fitTableColumns(tableData);
		} 
		catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "loadFileExport : " + e.toString());
		}
	}
	
	private void setValueToModelTable(List<String> listFile) {
		for(int i = 0; i < listFile.size(); i++){
			tableDataModel.addRow(new Object[]{i+1,listFile.get(i),"",""});
			this.tableData.setModel(tableDataModel);	
		}
    }
	
	private void reset() {
		JTableUtil.removeAllRow(tableData);
	}
	
	private void checkExport()
	{
		boolean flag;
		List<String> listimageid = new ArrayList<String>();
		List<String> listHeaderIdTableHeader = new ArrayList<String>();
		try {
			buttonCheck.setEnabled(false);
			reset();
			for(int i = 0; i < db3Files.size(); i++){				
				flag = true;
				listimageid = daoCheckExport.getListImageID(db3Files.get(i));
				listHeaderIdTableHeader = daoCheckExport.getListHeaderID(db3Files.get(i));
				if(listimageid.size() == 0){
					tableDataModel.addRow(new Object[]{i+1, db3Files.get(i), "Fail","Table Image have not data"});
					flag = false;
				}
				if(listHeaderIdTableHeader.size() == 0){
					tableDataModel.addRow(new Object[]{i+1, db3Files.get(i), "Fail","Table Header have not data"});
					flag = false;
				}
				if(!listimageid.equals(listHeaderIdTableHeader) && (listimageid.size() != listHeaderIdTableHeader.size())){
					tableDataModel.addRow(new Object[]{i+1, db3Files.get(i), "Fail","HeaderID in table Header not equal ImageID in table Image"});
					flag = false;
				}
				if(!checkDoctype(db3Files.get(i), i)){
					flag = false;
				}				
				if(!checkHeader(db3Files.get(i),i)){
					flag = false;
				}
				if(!checkRecord(db3Files.get(i),i)){
					flag = false;
				}
				if(!checkNullAllRecord(db3Files.get(i),i)){
					flag = false;
				}
				if(!checkNullAllHeader(db3Files.get(i),i)){
					flag = false;
				}
				if(flag){					
					tableDataModel.addRow(new Object[]{i+1, db3Files.get(i), "Success","Not Error"});
				}
				JTableUtil.fitTableColumnsDB3(tableData);
				
			}
			buttonCheck.setEnabled(true);
			AppUtility.msgInfo(this, "Finished check export !!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean checkDoctype(String file, int i)
	{
		boolean flag = true;
		List<String> listDocType = new ArrayList<String>();
		List<String> listDocTypeImage = new ArrayList<String>();
		try {
			listDocType = daoCheckExport.getListDoctype(file);
			listDocTypeImage = daoCheckExport.getListDoctypeImage(file);
			
			if(listDocType.size() == 0){
				tableDataModel.addRow(new Object[]{i+1, db3Files.get(i), "Fail","Have not data DocType"});
				flag = false;
			}
			else{
				for(String key : listDocTypeImage){
					if(!listDocType.contains(key)){
						tableDataModel.addRow(new Object[]{i+1, db3Files.get(i), "Fail","Type in table DocType not equal DocType in table Image"});
						flag = false;
					}else{
						flag = true;
					}
				}
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	//check Table Header
	private boolean checkHeader(String file, int i)
	{
		boolean flag = true;
		List<String> listImageIDTableImage= new ArrayList<String>();
		List<String> listHeaderIdTableHeader = new ArrayList<String>();
		BeanHeaderSQLite beanHeader = new BeanHeaderSQLite();
		try {
			listHeaderIdTableHeader = daoCheckExport.getListHeaderIDHeader(file);
			listImageIDTableImage = daoCheckExport.getListImageIdImage(file);
						
			if(listImageIDTableImage.size() != listHeaderIdTableHeader.size()){
				tableDataModel.addRow(new Object[]{i+1, db3Files.get(i), "Fail","HeaderID in table Header not equal ImageID in table Image"});
				flag = false;
			}
			for(int t = 0; t < beanField.getListFieldHeader().size(); t++){
				beanHeader = daoCheckExport.getListDataExportHeader(file, beanField.getListFieldHeader().get(t));
				if(beanHeader.getListDataHeader().size() == 0){
					tableDataModel.addRow(new Object[]{i+1, db3Files.get(i), "Fail","Have not data in table Header."});
					flag = false;
				}
				else{
					for(int f = 0; f < beanHeader.getListDataHeader().size(); f++){
						if(beanField.getListFieldHeader().get(t).endsWith("_edt")){
							if(beanHeader.getListDataHeader().get(f) != "null"){
								tableDataModel.addRow(new Object[]{i+1, db3Files.get(i), "Fail","Field "+beanField.getListFieldRecord().get(t)+", record "+(f+1)+" have not data null in table Record."});
								flag = false;
							}
						}
						if(beanField.getListFieldHeader().get(t).endsWith("_orig")){							
							if(beanHeader.getListDataHeader().get(f).equals("null") || 
									(beanHeader.getListDataHeader().get(f) == null)){
								tableDataModel.addRow(new Object[]{i+1, db3Files.get(i), "Fail","Field "+
									beanField.getListFieldHeader().get(t)+", record "+(f+1)+" have data null in table Header."});
								flag = false;
							}
							if(!StringUtil.specialWordFirst(beanHeader.getListDataHeader().get(f))){
								tableDataModel.addRow(new Object[]{i+1, db3Files.get(i), "Fail","Field "+beanField.getListFieldHeader().get(t)
										+", record "+(f+1)+ " Have -,+,/, first space, end space or more space in table Header"});
								flag = false;
							}
							if(!StringUtil.checkContainSpecial(beanHeader.getListDataHeader().get(f))){
								tableDataModel.addRow(new Object[]{i+1, db3Files.get(i), "Fail","Field "+beanField.getListFieldHeader().get(t)
										+", record "+(f+1)+ " Have %, @, #, *, & in table Header"});
								flag = false;
							}
						}						
					}
				}
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	private boolean checkNullAllRecord(String file, int i) throws Exception{
		boolean flag = true;
		BeanRecordSQLite beanRecord = new BeanRecordSQLite();
		List<String> listfield = new ArrayList<String>();
		List<String> listdata = new ArrayList<String>();
		List<List<String>> list = new ArrayList<List<String>>();
		try {
			listfield = beanField.getListFieldRecord();
			for(int j = 0; j < listfield.size(); j++){
				beanRecord = daoCheckExport.getListDataExportRecord(file, beanField.getListFieldRecord().get(j));
				listdata = beanRecord.getListDataRecord();
				list.add(listdata);
			}
			int count = 0;
			for(int k = 0; k < listdata.size(); k++){
				for(List<String> liststr : list){
					if(liststr.get(k).equals("")){
						++count;
					}
				}
				if(count == (listfield.size()/2)){
					tableDataModel.addRow(new Object[]{i+1, db3Files.get(i), "Fail","Row "+(k+1)+" have not data in table Record"});
					flag = false;
				}
				count = 0;
			}

			beanField.getListFieldRecord();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception("checkNullAllRecord : " + e.toString());
		}
		return flag;
	}
	
	private boolean checkNullAllHeader(String file, int i) throws Exception{
		boolean flag = true;
		BeanHeaderSQLite beanRecord = new BeanHeaderSQLite();
		List<String> listfield = new ArrayList<String>();
		List<String> listdata = new ArrayList<String>();
		List<List<String>> list = new ArrayList<List<String>>();
		List<String> listID = new ArrayList<String>();
		List<String> tableHeader = new ArrayList<String>();
		try {
			listfield = beanField.getListFieldHeader();
			tableHeader = daoCheckExport.getListTableHeader(file);
			for(int t = 0; t < tableHeader.size(); t++){
				System.out.println("table : "+tableHeader.get(t));
				listID = daoCheckExport.getListHeaderIDImage(file, tableHeader.get(t));
			}
			for(int j = 0; j < listfield.size(); j++){
				beanRecord = daoCheckExport.getListDataExportHeader(file, beanField.getListFieldHeader().get(j));
				listdata = beanRecord.getListDataHeader();
				list.add(listdata);
			}
			int count = 0;
			int num = 0;
			for(int k = 0; k < listID.size(); k++){
				for(List<String> liststr : list){
					num = Integer.parseInt(listID.get(k)) - 1;
					if(liststr.get(num).equals("")){
						++count;
					}
				}
				if(count == listfield.size()/2){
					tableDataModel.addRow(new Object[]{i+1, db3Files.get(i), "Fail","Row "+listID.get(k)+" have not data in table Header"});
					flag = false;
				}
				count = 0;
			}

			beanField.getListFieldRecord();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception("checkNullAllHeader : " + e.toString());
		}
		return flag;
	}
	
	private boolean checkRecord(String file, int i) throws Exception
	{
		boolean flag = true;		
		BeanRecordSQLite beanRecord = new BeanRecordSQLite();
		List<String> listHeaderIdTableRecord = new ArrayList<String>();
		List<String> listImageIDInputRecord = new ArrayList<String>();
		List<String> listTableRecord = new ArrayList<String>();
		int headerID = 0;
		int headerIDAfter = 0;
		int seq = 0;
		int seqAfter = 0;
		try {	
			listTableRecord = daoCheckExport.getListTableRecord(file);
			listHeaderIdTableRecord = daoCheckExport.getListHeaderIDRecord(file);
			listImageIDInputRecord = daoCheckExport.getListImageIDInput(file, listTableRecord);
			if(listImageIDInputRecord.size() != listHeaderIdTableRecord.size()){
				tableDataModel.addRow(new Object[]{i+1, db3Files.get(i), "Fail","HeaderID in table Record not equal ImageID in table Image"});
				flag = false;
			}
			for(int t = 0; t < beanField.getListFieldRecord().size(); t++){
				beanRecord = daoCheckExport.getListDataExportRecord(file, beanField.getListFieldRecord().get(t));
				
				if(beanRecord.getListDataRecord().size() == 0){
					tableDataModel.addRow(new Object[]{i+1, db3Files.get(i), "Fail","Have not data in table Record."});
					flag = false;
				}
				else{
					for(int f = 0; f < beanRecord.getListDataRecord().size(); f++){
						if(beanField.getListFieldRecord().get(t).endsWith("_edt")){
							if(beanRecord.getListDataRecord().get(f) != "null"){
								tableDataModel.addRow(new Object[]{i+1, db3Files.get(i), "Fail","Field "+beanField.getListFieldRecord().get(t)+", record "+(f+1)+" have not data null in table Record."});
								flag = false;
							}
						}
						if(beanField.getListFieldRecord().get(t).endsWith("_orig")){								
							if(beanRecord.getListDataRecord().get(f).equals("null") || 
									(beanRecord.getListDataRecord().get(f) == null)){
								tableDataModel.addRow(new Object[]{i+1, db3Files.get(i), "Fail","Field "+
									beanField.getListFieldRecord().get(t)+", record "+(f+1)+" have data null in table Record."});
								flag = false;
							}
							if(!StringUtil.specialWordFirst(beanRecord.getListDataRecord().get(f))){
								tableDataModel.addRow(new Object[]{i+1, db3Files.get(i), "Fail","Field "+beanField.getListFieldRecord().get(t)
										+", record "+(f+1)+ " Have -,+,/, first space, end space or more space, in table Record"});
								flag = false;
							}
							if(!StringUtil.checkContainSpecial(beanRecord.getListDataRecord().get(f))){
								tableDataModel.addRow(new Object[]{i+1, db3Files.get(i), "Fail","Field "+beanField.getListFieldRecord().get(t)
										+", record "+(f+1)+ " Have %, @, #, *, & in table Record"});
								flag = false;
							}							
						}						
					}
				}
			}
			//check seq
			for(int k = 0; k< beanRecord.getHeaderid().size();k++){
				headerID = Integer.parseInt(beanRecord.getHeaderid().get(k));
				seq = Integer.parseInt(beanRecord.getSeq().get(k));
				if((k == 0) && (seq != 0)){
					tableDataModel.addRow(new Object[]{i+1, db3Files.get(i), "Fail","Record 1 SequenceNum not equal 0 in table Record."});
					flag = false;
				}
				else if(k > 0){
					headerIDAfter = Integer.parseInt(beanRecord.getHeaderid().get(k-1));				
					seqAfter = Integer.parseInt(beanRecord.getSeq().get(k-1));
					if(headerID > headerIDAfter){
						if(seq != 0){
							tableDataModel.addRow(new Object[]{i+1, db3Files.get(i), "Fail","Row "+(k+1)+" SequenceNum not equal 0 in table Record."});
							flag = false;
						}
					}
					if(headerID == headerIDAfter){
						if(seq != (seqAfter +1)){
							tableDataModel.addRow(new Object[]{i+1, db3Files.get(i), "Fail","Row "+(k+1)+" SequenceNum not equal "+(seqAfter+1)+" in table Record."});
							flag = false;
						}
					}
				}
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception("checkRecord : " + e.toString());
		}
		return flag;
	}
	
	
	class CellRenderer extends JLabel implements TableCellRenderer{

		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			Color c = Color.black;
			if(value != null){
				if(value.toString().equals("Fail")){
					c = Color.red;
				}
			}
			this.setForeground(c);
			return this;
		}
		
	}
}
