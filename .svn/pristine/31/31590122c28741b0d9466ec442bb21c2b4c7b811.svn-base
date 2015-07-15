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
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.component.PanelGridPath;
import com.digitexx.ancestry.component.PanelTreeFolder;
import com.digitexx.ancestry.dao.DaoConvertImage;
import com.digitexx.ancestry.util.AppUtility;
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
public class FrmConvertImage extends javax.swing.JFrame {
	private JPanel panelHeader;
	private JPanel panelContent;
	private JPanel panelProcess;
	private JRadioButton radioFromDatabase;
	private JRadioButton radioFromComputer;
	private JComboBox comboboxOutput;
	private JLabel jLabel1;
	private ButtonGroup buttonGroup;
	private JButton buttonConvert;
	private JButton buttonBrowse;
	private JTextField textFieldOutput;
	private JPanel jPanel2;
	private JPanel panelLog;
	private JSplitPane splitPaneContent;
	private JLabel jLabel2;
	private JCheckBox checkboxOuttputWithTheSameInput;
	private JProgressBar progressBar;
	private JPanel panellFooter;
	private JScrollPane scrollPaneLog;
	private JPanel panelPath;
	private JTable tableInputFormat;
	private JScrollPane scrollPaneRight;
	private JScrollPane scrollPaneLeft;
	private JTextPane textPaneLog;
	private JPanel panelLeft;
	private JButton buttonConfig;
	private JCheckBox checkboxDeleteExisted;
	private JPanel panelRight;
	private JSplitPane splitPaneTop;

	private FrmStep frmStep;
	private Tbl_Projects project;
	private DefaultTableModel modelInput;
	private PanelGridPath panelGridPath;
	private PanelTreeFolder panelTreeFolder;
	private List<String> listFilePath = new ArrayList<String>();
	private List<String> listFileName = new ArrayList<String>();
	private DaoConvertImage daoConvertImage;

	public FrmConvertImage(FrmStep frmStep , Tbl_Projects project) {
		super();
		this.frmStep = frmStep;
		this.project = project;
		this.daoConvertImage = new DaoConvertImage(project);
		initGUI();
		loadFromComputer();
		loadInputFormat();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			{
				panelHeader = new JPanel();
				AnchorLayout panelHeaderLayout = new AnchorLayout();
				getContentPane().add(panelHeader, new AnchorConstraint(0, 1000, 51, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelHeader.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelHeader.setLayout(panelHeaderLayout);
				panelHeader.setPreferredSize(new java.awt.Dimension(936, 30));
				{
					radioFromDatabase = new JRadioButton();
					panelHeader.add(getButtonConfig(), new AnchorConstraint(42, 736, 957, 666, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					panelHeader.add(getCheckboxDeleteExisted(), new AnchorConstraint(100, 659, 957, 545, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					panelHeader.add(radioFromDatabase, new AnchorConstraint(71, 145, 957, 2, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					radioFromDatabase.setText("From Database");
					radioFromDatabase.setFont(new java.awt.Font("Arial",1,16));
					getButtonGroup().add(radioFromDatabase);
					radioFromDatabase.setForeground(new java.awt.Color(0,0,255));
					radioFromDatabase.setPreferredSize(new java.awt.Dimension(170, 31));
					radioFromDatabase.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							radioFromDatabaseActionPerformed(evt);
						}
					});
				}
				{
					radioFromComputer = new JRadioButton();
					panelHeader.add(radioFromComputer, new AnchorConstraint(71, 289, 957, 149, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					radioFromComputer.setText("From Computer");
					radioFromComputer.setFont(new java.awt.Font("Arial",1,16));
					getButtonGroup().add(radioFromComputer);
					radioFromComputer.setForeground(new java.awt.Color(0,0,255));
					radioFromComputer.setPreferredSize(new java.awt.Dimension(166, 31));
					radioFromComputer.setSelected(true);
					radioFromComputer.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							radioFromComputerActionPerformed(evt);
						}
					});
				}
				{
					comboboxOutput = new JComboBox();
					panelHeader.add(comboboxOutput, new AnchorConstraint(83, 998, 950, 876, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					comboboxOutput.setFont(new java.awt.Font("Arial",1,14));
					comboboxOutput.setForeground(new java.awt.Color(0,0,255));
					comboboxOutput.setPreferredSize(new java.awt.Dimension(114, 26));
				}
				{
					jLabel1 = new JLabel();
					panelHeader.add(jLabel1, new AnchorConstraint(83, 871, 950, 750, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					panelHeader.add(getCheckboxOuttputWithTheSameInput(), new AnchorConstraint(100, 540, 957, 296, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jLabel1.setText("Output Format");
					jLabel1.setFont(new java.awt.Font("Arial",1,14));
					jLabel1.setForeground(new java.awt.Color(0,0,255));
					jLabel1.setBorder(new LineBorder(new java.awt.Color(0,0,255), 1, false));
					jLabel1.setPreferredSize(new java.awt.Dimension(113, 26));
				}
			}
			{
				panelContent = new JPanel();
				BorderLayout panelContentLayout = new BorderLayout();
				panelContent.setLayout(panelContentLayout);
				getContentPane().add(panelContent, new AnchorConstraint(51, 1000, 908, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelContent.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelContent.setPreferredSize(new java.awt.Dimension(936, 512));
				panelContent.add(getSplitPaneContent(), BorderLayout.CENTER);
			}
			{
				panelProcess = new JPanel();
				BorderLayout panelProcessLayout = new BorderLayout();
				getContentPane().add(panelProcess, new AnchorConstraint(908, 1000, 938, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				getContentPane().add(getPanellFooter(), new AnchorConstraint(938, 1000, 990, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelProcess.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelProcess.setLayout(panelProcessLayout);
				panelProcess.setPreferredSize(new java.awt.Dimension(936, 18));
				panelProcess.add(getProgressBar(), BorderLayout.CENTER);
			}
			pack();
			this.setSize(1192, 732);
			AppUtility.centerFrame(this);
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
	
	private ButtonGroup getButtonGroup() {
		if(buttonGroup == null) {
			buttonGroup = new ButtonGroup();
		}
		return buttonGroup;
	}

	private JPanel getPanellFooter() {
		if(panellFooter == null) {
			panellFooter = new JPanel();
			AnchorLayout panellFooterLayout = new AnchorLayout();
			panellFooter.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
			panellFooter.setLayout(panellFooterLayout);
			panellFooter.setPreferredSize(new java.awt.Dimension(936, 31));
			panellFooter.add(getJLabel2(), new AnchorConstraint(80, 118, 951, 2, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			panellFooter.add(getTextFieldOutput(), new AnchorConstraint(48, 707, 951, 118, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			panellFooter.add(getButtonBrowse(), new AnchorConstraint(46, 819, 953, 706, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			panellFooter.add(getButtonConvert(), new AnchorConstraint(15, 998, 953, 869, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
		}
		return panellFooter;
	}
	
	private JProgressBar getProgressBar() {
		if(progressBar == null) {
			progressBar = new JProgressBar();
		}
		return progressBar;
	}
	
	private JCheckBox getCheckboxOuttputWithTheSameInput() {
		if(checkboxOuttputWithTheSameInput == null) {
			checkboxOuttputWithTheSameInput = new JCheckBox();
			checkboxOuttputWithTheSameInput.setText("Output With The Same Folder Input");
			checkboxOuttputWithTheSameInput.setFont(new java.awt.Font("Arial",1,14));
			checkboxOuttputWithTheSameInput.setForeground(new java.awt.Color(0,0,255));
			checkboxOuttputWithTheSameInput.setBorder(new LineBorder(new java.awt.Color(0,0,255), 1, false));
			checkboxOuttputWithTheSameInput.setPreferredSize(new java.awt.Dimension(289, 30));
			checkboxOuttputWithTheSameInput.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					checkboxOuttputWithTheSameInputActionPerformed(evt);
				}
			});
		}
		return checkboxOuttputWithTheSameInput;
	}
	
	private JLabel getJLabel2() {
		if(jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("Output Folder");
			jLabel2.setFont(new java.awt.Font("Arial",1,14));
			jLabel2.setBorder(new LineBorder(new java.awt.Color(255,0,0), 1, false));
			jLabel2.setForeground(new java.awt.Color(255,0,0));
			jLabel2.setPreferredSize(new java.awt.Dimension(108, 27));
		}
		return jLabel2;
	}
	
	private JTextField getTextFieldOutput() {
		if(textFieldOutput == null) {
			textFieldOutput = new JTextField();
			textFieldOutput.setPreferredSize(new java.awt.Dimension(552, 28));
		}
		return textFieldOutput;
	}
	
	private JButton getButtonBrowse() {
		if(buttonBrowse == null) {
			buttonBrowse = new JButton();
			buttonBrowse.setText("Browse");
			buttonBrowse.setFont(new java.awt.Font("Arial",1,14));
			buttonBrowse.setForeground(new java.awt.Color(255,0,0));
			buttonBrowse.setPreferredSize(new java.awt.Dimension(106, 29));
			buttonBrowse.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					buttonBrowseActionPerformed(evt);
				}
			});
		}
		return buttonBrowse;
	}
	
	private JButton getButtonConvert() {
		if(buttonConvert == null) {
			buttonConvert = new JButton();
			buttonConvert.setText("Convert");
			buttonConvert.setFont(new java.awt.Font("Arial",1,16));
			buttonConvert.setForeground(new java.awt.Color(255,0,0));
			buttonConvert.setPreferredSize(new java.awt.Dimension(121, 30));
			buttonConvert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					buttonConvertActionPerformed(evt);
				}
			});
		}
		return buttonConvert;
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
		if(panelLog == null) {
			panelLog = new JPanel();
			BorderLayout jPanel1Layout = new BorderLayout();
			panelLog.setLayout(jPanel1Layout);
			panelLog.setBorder(BorderFactory.createTitledBorder(null, "Log Detail", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,16), new java.awt.Color(0,0,0)));
			panelLog.add(getScrollPaneLog(), BorderLayout.CENTER);
		}
		return panelLog;
	}
	
	private JPanel getJPanel2() {
		if(jPanel2 == null) {
			jPanel2 = new JPanel();
			BorderLayout jPanel2Layout = new BorderLayout();
			jPanel2.setLayout(jPanel2Layout);
			jPanel2.setPreferredSize(new java.awt.Dimension(993, 405));
			jPanel2.add(getSplitPaneTop(), BorderLayout.CENTER);
		}
		return jPanel2;
	}
	
	private JSplitPane getSplitPaneTop() {
		if(splitPaneTop == null) {
			splitPaneTop = new JSplitPane();
			splitPaneTop.add(getJPanel3(), JSplitPane.RIGHT);
			splitPaneTop.add(getJPanel4(), JSplitPane.LEFT);
		}
		return splitPaneTop;
	}
	
	private JPanel getJPanel3() {
		if(panelRight == null) {
			panelRight = new JPanel();
			BorderLayout jPanel3Layout = new BorderLayout();
			panelRight.setLayout(jPanel3Layout);
			panelRight.setBorder(BorderFactory.createTitledBorder(null, "Path", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,16), new java.awt.Color(255,0,0)));
			panelRight.add(getScrollPaneRight(), BorderLayout.CENTER);
		}
		return panelRight;
	}
	
	private JPanel getJPanel4() {
		if(panelLeft == null) {
			panelLeft = new JPanel();
			BorderLayout jPanel4Layout = new BorderLayout();
			panelLeft.setLayout(jPanel4Layout);
			panelLeft.setPreferredSize(new java.awt.Dimension(278, 403));
			panelLeft.setBorder(BorderFactory.createTitledBorder(null, "Input Format", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,16), new java.awt.Color(255,0,0)));
			panelLeft.add(getScrollPaneLeft(), BorderLayout.CENTER);
		}
		return panelLeft;
	}
	
	private JScrollPane getScrollPaneLog() {
		if(scrollPaneLog == null) {
			scrollPaneLog = new JScrollPane();
			scrollPaneLog.setViewportView(getTextPaneLog());
		}
		return scrollPaneLog;
	}
	
	private JTextPane getTextPaneLog() {
		if(textPaneLog == null) {
			textPaneLog = new JTextPane();
		}
		return textPaneLog;
	}
	
	private JScrollPane getScrollPaneLeft() {
		if(scrollPaneLeft == null) {
			scrollPaneLeft = new JScrollPane();
			scrollPaneLeft.setViewportView(getTableInputFormat());
		}
		return scrollPaneLeft;
	}
	
	private JScrollPane getScrollPaneRight() {
		if(scrollPaneRight == null) {
			scrollPaneRight = new JScrollPane();
			scrollPaneRight.setViewportView(getPanelPath());
		}
		return scrollPaneRight;
	}
	
	private JTable getTableInputFormat() {
		if(tableInputFormat == null) {
			tableInputFormat = new JTable();
		}
		return tableInputFormat;
	}
	
	private JPanel getPanelPath() {
		if(panelPath == null) {
			panelPath = new JPanel();
			BorderLayout panelPathLayout = new BorderLayout();
			panelPath.setLayout(panelPathLayout);
		}
		return panelPath;
	}
	
	
	private JCheckBox getCheckboxDeleteExisted() {
		if(checkboxDeleteExisted == null) {
			checkboxDeleteExisted = new JCheckBox();
			checkboxDeleteExisted.setText("Delete Existed");
			checkboxDeleteExisted.setPreferredSize(new java.awt.Dimension(135, 30));
			checkboxDeleteExisted.setFont(new java.awt.Font("Arial",1,16));
			checkboxDeleteExisted.setForeground(new java.awt.Color(255,0,0));
		}
		return checkboxDeleteExisted;
	}
	
	
	private JButton getButtonConfig() {
		if(buttonConfig == null) {
			buttonConfig = new JButton();
			buttonConfig.setText("Config");
			buttonConfig.setPreferredSize(new java.awt.Dimension(82, 32));
			buttonConfig.setFont(new java.awt.Font("Arial",1,16));
			buttonConfig.setForeground(new java.awt.Color(255,0,0));
			buttonConfig.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					buttonConfigActionPerformed(evt);
				}
			});
		}
		return buttonConfig;
	}
	
	private void buttonConfigActionPerformed(ActionEvent evt) {
		
	}

	private void checkboxOuttputWithTheSameInputActionPerformed(ActionEvent evt) {
		
	}
	
	private void buttonBrowseActionPerformed(ActionEvent evt) {
		FileUtility.browse(textFieldOutput, JFileChooser.DIRECTORIES_ONLY);
	}
	
	private void buttonConvertActionPerformed(ActionEvent evt) {
		
	}
	
	private void radioFromDatabaseActionPerformed(ActionEvent evt) {
		loadFromDatabase();
	}
	
	private void radioFromComputerActionPerformed(ActionEvent evt) {
		loadFromComputer();
	}

	//====================================================================================================================
	
	
	private void loadInputFormat() {

		List<String> listInputFormat = FileUtility.getListAllExtension(false);
		String [] arrHeader = new String [] { "No." , "Format" , "Check" };
		JTableUtil.loadListDataToGrid(tableInputFormat, modelInput, arrHeader, listInputFormat, true, true);
		JTableUtil.styleTable(getTableInputFormat(), true);
		
		for (String str : listInputFormat) {
			comboboxOutput.addItem(str);
		}
		comboboxOutput.setSelectedItem("jpg");
	}
	
	/**
	 * load folder from database
	 */
	private void loadFromDatabase() {
		try {
			panelPath.removeAll();
			listFilePath = new ArrayList<String>();
			listFilePath = daoConvertImage.getListPathFromDatabase();
			panelGridPath = new PanelGridPath(listFilePath, new String [] { "No." , "File Path" });
			panelPath.add(panelGridPath, BorderLayout.NORTH);
			panelGridPath.setPreferredSize(new java.awt.Dimension(678, 394));
			panelPath.revalidate();
		} 
		catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "loadFromDatabase : "  + e.toString());
		}

	}
	
	/**
	 * load folder from computer
	 */
	private void loadFromComputer() 
	{
		panelPath.removeAll();
        panelTreeFolder = new PanelTreeFolder();
        panelPath.add(panelTreeFolder, BorderLayout.CENTER);
        panelPath.revalidate();
	}
	
	/**
	 * convert from database
	 */
	private void convertFromDatabase() 
	{
		JTable table = panelGridPath.getTablePath();
		try {
			String pathOutput = StringUtil.setNotNull(textFieldOutput.getText());
			if(!checkboxOuttputWithTheSameInput.isSelected() && pathOutput.equals("")) {
				AppUtility.msgError(this, "Please select output folder !!");
				textFieldOutput.requestFocus();
			}else {
				if(panelGridPath.getListPath().size() > 0) {
					int row = panelGridPath.getRowSelected();
					String path = StringUtil.setNotNull(JTableUtil.getValuesByHeaderName(table, "Format", row));
					listFileName = new ArrayList<String>();
					listFileName = daoConvertImage.getListFileNameByPath(path);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "convertFromDatabase : " + e.toString() );
		}

	}
	
	/**
	 * process convert images
	 */
	public boolean convertImage(String path , List<String> listFileName) 
	{
		boolean flag =false;
		try {
			String inputExtension = "";
			String outputPath = "";
			String fileOutput = "";
			String fileInput = "";
			String outputExtension = comboboxOutput.getSelectedItem().toString();
			for (String filename : listFileName) {
				inputExtension = "." +FileUtility.getFileExtension(filename);
				
				if(checkboxOuttputWithTheSameInput.isSelected()) {
					outputPath = path;
				}else {
					outputPath = textFieldOutput.getText();
				}
				
				fileInput = path + "/" + filename;
				fileOutput = outputPath + filename;
				fileOutput = fileOutput.replace( inputExtension , outputExtension);
				AppUtility.appendText(textPaneLog, "Start convert : "  + fileInput , Color.BLUE);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			AppUtility.appendText(textPaneLog, "convertImage : ", Color.RED);
		}
		return flag;

	}


}
