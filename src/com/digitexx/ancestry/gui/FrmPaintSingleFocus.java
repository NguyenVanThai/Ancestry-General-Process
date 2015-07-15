package com.digitexx.ancestry.gui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.component.PanelImageButton;
import com.digitexx.ancestry.component.PanelListField;
import com.digitexx.ancestry.dao.DaoAnalyzeRework;
import com.digitexx.ancestry.dao.DaoPaintFocus;
import com.digitexx.ancestry.jai.util.ImagePerfectJAI;
import com.digitexx.ancestry.jai.util.ShowJAI;
import com.digitexx.ancestry.util.AppUtility;
import com.digitexx.ancestry.util.FileUtility;


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
public class FrmPaintSingleFocus extends javax.swing.JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	{
		System.setProperty("com.sun.media.jai.disableMediaLib", "true");

	}
	{
		{
			try {
				javax.swing.UIManager
						.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private JPanel panelHeader;
	private JPanel panelContent;
	private JSplitPane splitPane;
	private JButton buttonClear;
	private JPanel panelField;
	private JScrollPane scrollPaneField;
	private JScrollPane scrollPaneImage;
	private JComboBox comboboxForm;
	private JComboBox comboboxTable;
	private JPanel panelFooter;
	private JButton buttonBrowse;
	private JButton buttonSave;
	private JComboBox comboboxQuality;
	private JPanel panelMain;
	private JPanel panelImage;
	private JTextField txtPath;
	private ButtonGroup buttonGroup;
    private PanelImageButton panelProcessImage =new PanelImageButton();
    private DaoAnalyzeRework daoAnalyzeRework ;
    private DaoPaintFocus daoPaintFocus ;
	private ImagePerfectJAI imageUtil = new ImagePerfectJAI();
	private ShowJAI imageCanvas;
    private String projectName;
    private Tbl_Projects project;
    private FrmStep frmStep;
    private PanelListField panelListField;
	
	public FrmPaintSingleFocus( FrmStep frmStep,String projectName , Tbl_Projects project) {
		super();
		this.frmStep = frmStep;
		this.projectName = projectName;
		this.project = project;
		
		daoAnalyzeRework = new DaoAnalyzeRework(project);
		imageCanvas = imageUtil.imageCanvas;
		panelProcessImage.setPerfectJAI(imageUtil);
		daoPaintFocus = new DaoPaintFocus(project);
		initGUI();
		AppUtility.centerFrame(this);
		initData();
	}
	
	private void initGUI() {
		try {
			this.setTitle( "Paint focus field of project : "+projectName);

			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			{
				panelHeader = new JPanel();
				AnchorLayout panelHeaderLayout = new AnchorLayout();
				getContentPane().add(getPanelFooter(), new AnchorConstraint(918, 1000, 1000, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				getContentPane().add(panelHeader, new AnchorConstraint(0, 1000, 43, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelHeader.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelHeader.setLayout(panelHeaderLayout);
				panelHeader.setPreferredSize(new java.awt.Dimension(1178, 31));
				panelHeader.add(panelProcessImage, new AnchorConstraint(83, 229, 950, 2, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelHeader.add(getTxtPath(), new AnchorConstraint(83, 925, 983, 234, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelHeader.add(getButtonBrowse(), new AnchorConstraint(50, 998, 1016, 930, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelProcessImage.setPreferredSize(new java.awt.Dimension(275, 26));
			}
			{
				panelContent = new JPanel();
				AnchorLayout panelContentLayout = new AnchorLayout();
				panelContent.setLayout(panelContentLayout);
				getContentPane().add(panelContent, new AnchorConstraint(41, 1000, 918, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelContent.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelContent.setPreferredSize(new java.awt.Dimension(1207, 658));
				{
					splitPane = new JSplitPane();
					panelContent.add(splitPane, new AnchorConstraint(3, 998, 997, 2, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					splitPane.setPreferredSize(new java.awt.Dimension(1203, 643));
					{
						panelImage = new JPanel();
						BorderLayout panelImageLayout = new BorderLayout();
						panelImage.setLayout(panelImageLayout);
						splitPane.add(panelImage, JSplitPane.LEFT);
						panelImage.setBounds(-37, 92, 10, 10);
						panelImage.setPreferredSize(new java.awt.Dimension(929, 681));
						panelImage.add(getScrollPaneImage(), BorderLayout.CENTER);
					}
					{
						panelMain = new JPanel();
						BorderLayout panelMainLayout = new BorderLayout();
						panelMain.setLayout(panelMainLayout);
						splitPane.add(panelMain, JSplitPane.RIGHT);
						panelMain.add(getScrollPaneField(), BorderLayout.CENTER);
					}
				}
			}
			pack();
			this.setSize(1215, 785);
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
	
	
	private ButtonGroup getButtonGroup() {
		if(buttonGroup == null) {
			buttonGroup = new ButtonGroup();
		}
		return buttonGroup;
	}

	private JTextField getTxtPath() {
		if(txtPath == null) {
			txtPath = new JTextField();
			txtPath.setFont(new java.awt.Font("Tahoma",1,12));
			txtPath.setPreferredSize(new java.awt.Dimension(834, 27));
		}
		return txtPath;
	}
	
	private JButton getButtonSave() {
		if(buttonSave == null) {
			buttonSave = new JButton();
			buttonSave.setText("Save");
			buttonSave.setFont(new java.awt.Font("Tahoma",1,12));
			buttonSave.setForeground(new java.awt.Color(255,0,0));
			buttonSave.setPreferredSize(new java.awt.Dimension(82, 58));
			buttonSave.addActionListener(this);
		}
		return buttonSave;
	}
	
	private JButton getButtonBrowse() {
		if(buttonBrowse == null) {
			buttonBrowse = new JButton();
			buttonBrowse.setText("Browse");
			buttonBrowse.setFont(new java.awt.Font("Tahoma",1,12));
			buttonBrowse.setPreferredSize(new java.awt.Dimension(82, 29));
			buttonBrowse.addActionListener(this);
		}
		return buttonBrowse;
	}
	
	private JPanel getPanelFooter() {
		if(panelFooter == null) {
			panelFooter = new JPanel();
			AnchorLayout panelFooterLayout = new AnchorLayout();
			panelFooter.setPreferredSize(new java.awt.Dimension(1207, 62));
			panelFooter.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
			panelFooter.setLayout(panelFooterLayout);
			panelFooter.add(getComboboxQuality(), new AnchorConstraint(72, 652, 975, 533, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			panelFooter.add(getButtonClear(), new AnchorConstraint(40, 997, 975, 925, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			panelFooter.add(getComboboxTable(), new AnchorConstraint(88, 364, 959, 2, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			panelFooter.add(getComboboxForm(), new AnchorConstraint(72, 514, 975, 379, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			panelFooter.add(getButtonSave(), new AnchorConstraint(40, 920, 975, 852, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
		}
		return panelFooter;
	}
	
	private JComboBox getComboboxTable() {
		if(comboboxTable == null) {
			comboboxTable = new JComboBox();
			comboboxTable.setBorder(BorderFactory.createTitledBorder(null, "List all tables", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,14)));
			comboboxTable.setPreferredSize(new java.awt.Dimension(438, 54));
			comboboxTable.setFont(new java.awt.Font("Tahoma",1,12));
			comboboxTable.addActionListener(this);
		}
		return comboboxTable;
	}
	
	private JComboBox getComboboxForm() {
		if(comboboxForm == null) {
			comboboxForm = new JComboBox();
			comboboxForm.setBorder(BorderFactory.createTitledBorder(null, "List all forms", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,14)));
			comboboxForm.setPreferredSize(new java.awt.Dimension(163, 56));
			comboboxForm.setFont(new java.awt.Font("Tahoma",1,12));
			comboboxForm.addActionListener(this);
		}
		return comboboxForm;
	}
	
	private JScrollPane getScrollPaneImage() {
		if(scrollPaneImage == null) {
			scrollPaneImage = new JScrollPane(imageCanvas,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			imageCanvas.setScrollPane(scrollPaneImage);
		}
		return scrollPaneImage;
	}
	
	private JScrollPane getScrollPaneField() {
		if(scrollPaneField == null) {
			scrollPaneField = new JScrollPane();
			scrollPaneField.setViewportView(getPanelField());
		}
		return scrollPaneField;
	}
	
	private JPanel getPanelField() {
		if(panelField == null) {
			panelField = new JPanel();
			BorderLayout panelFieldLayout = new BorderLayout();
			panelField.setLayout(panelFieldLayout);
		}
		return panelField;
	}
	
	
	private JButton getButtonClear() {
		if(buttonClear == null) {
			buttonClear = new JButton();
			buttonClear.setText("Clear");
			buttonClear.setPreferredSize(new java.awt.Dimension(88, 58));
			buttonClear.setFont(new java.awt.Font("Tahoma",1,12));
			buttonClear.addActionListener(this);
		}
		return buttonClear;
	}
	
	private JComboBox getComboboxQuality() {
		if(comboboxQuality == null) {
			ComboBoxModel comboboxQualityModel = new DefaultComboBoxModel(new String[] { "4", "8" });
			comboboxQuality = new JComboBox();
			comboboxQuality.setModel(comboboxQualityModel);
			comboboxQuality.setPreferredSize(new java.awt.Dimension(143, 56));
			comboboxQuality.setBorder(BorderFactory.createTitledBorder(null, "Quality", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,14)));
			comboboxQuality.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					comboboxQualityActionPerformed(evt);
				}
			});
		}
		return comboboxQuality;
	}
	
	
	//=========================================================================================================================
	
	private void initData() {
       loadTables();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object action = e.getSource();
		if(action == buttonBrowse)
		{
			FileUtility.browseImage(this, txtPath);
			if(txtPath.getText().length() >0) {
				int quality = Integer.parseInt(comboboxQuality.getSelectedItem().toString());
				imageUtil.displayImage(txtPath.getText(), quality);
				panelListField.getMapTextField().get(0).requestFocus();
			}
		}
		if(action == comboboxTable) {
			loadForm();
		}
		if(action == comboboxForm) {
			loadField();
		}
		if(action == buttonSave) {
			save();
		}
		if(action  == buttonClear) {
			clear();
		}
	}

	//=========================================================================================================================

	/**
	 * load all table of schema
	 */
	public void loadTables()
	{
		try 
		{
			comboboxTable.removeAllItems();
			List<String> listTable = new ArrayList<String>();
			listTable = daoPaintFocus.getListTableBySchema();
			for (String str : listTable) {
				if(str.equals("fieldnamelist") || str.equals("fieldnamelist_verify")) {
					comboboxTable.addItem(str);
				}
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgInfo(this, "loadTables : "  + e.toString());
		}

	}
	
	/**
	 * load formid
	 */
	public void loadForm() 
	{
		try
		{
			if(comboboxTable.getSelectedIndex() > -1) 
			{
				comboboxForm.removeAllItems();
				List<String> listForm = new ArrayList<String>();
				String table = comboboxTable.getSelectedItem().toString();
				listForm = daoPaintFocus.getListFormBySchema(table);
				if(listForm.size() > 0) {
					for (String str : listForm) {
						comboboxForm.addItem(str);
					}
				}
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgInfo(this, "loadForm : " +  e.toString());
		}

	}
	
	/**
	 * load fieldname of form
	 */
	private void loadField() 
	{
		try 
		{
			   imageCanvas = imageUtil.imageCanvas;
		       List<String> listFieldName = new ArrayList<String>();
		       String form = comboboxForm.getSelectedItem().toString();
		       String table = comboboxTable.getSelectedItem().toString();
		       listFieldName = daoPaintFocus.getListFieldByForm(form ,table);
		       
		       panelField.removeAll();
		       panelListField = new PanelListField(listFieldName , imageCanvas , panelProcessImage.getComboboxZoom() , scrollPaneImage);
		       panelField.add(panelListField, BorderLayout.CENTER);
		       panelListField.revalidate();
		       panelListField.getMapTextField().get(0).requestFocus();
		} 
		catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgInfo(this, "loadField : " + e.toString());
		}

	}
	

	/**
	 * save value focus
	 */
	private boolean save()
	{
		HashMap<String, JTextField> mapFocus = imageCanvas.mapFocus;
		HashMap<String, String> mapResult = new HashMap<String , String>();
		boolean flag = false;
        try {
    		for (String key : mapFocus.keySet()) 
    		{
    			String value = mapFocus.get(key).getText();
    			mapResult.put(key, value);
    		}
    		String table = comboboxTable.getSelectedItem().toString();
    		flag = daoPaintFocus.updateFocusOfFieldDB3(mapResult,table, comboboxForm.getSelectedItem().toString());
    		flag = daoPaintFocus.updateFocusOfFieldDB10(mapResult,table, comboboxForm.getSelectedItem().toString());

    		if(flag) {
    			AppUtility.msgInfo(this, "Update value focus table "+table+" successfully !!");
    			panelListField.getMapTextField().get(0).requestFocus();
    		}
		} 
        catch (Exception e) {
        	e.printStackTrace();
        	AppUtility.msgInfo(this, "save : " + e.toString());
		}

		return flag;
	}
	
	/**
	 * clear data
	 */
	private void clear() {
		panelListField.clearData();
	}
	
	private void comboboxQualityActionPerformed(ActionEvent evt) {
		clear();
		if(txtPath.getText().length() >0) {
			int quality = Integer.parseInt(comboboxQuality.getSelectedItem().toString());
			imageUtil.displayImage(txtPath.getText(), quality);
			panelListField.getMapTextField().get(0).requestFocus();
		}
	}

	//=========================================================================================================================


}
