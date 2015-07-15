package com.digitexx.ancestry.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.ancestry.bean.Focus_Field;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.component.PanelImageButton;
import com.digitexx.ancestry.component.PanelListField;
import com.digitexx.ancestry.dao.DaoPaintFocus;
import com.digitexx.ancestry.jai.util.ImagePerfectJAI;
import com.digitexx.ancestry.jai.util.ShowJAI;
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
public class FrmPaintMultiFocus extends javax.swing.JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	{
		System.setProperty("com.sun.media.jai.disableMediaLib", "true");

	}
	private JPanel panelHeader;
	private JPanel panelContent;
	private JSplitPane splitPane;
	private JScrollPane scrollPaneData;
	private JPanel panelData;
	private JPanel panelField;
	private JScrollPane scrollPaneField;
	private JScrollPane scrollPaneImage;
	private JComboBox comboboxForm;
	private JComboBox comboboxTable;
	private JPanel panelFooter;
	private JButton buttonBrowse;
	private JButton buttonSave;
	private JButton buttonDeleteRow;
	private JButton buttonUpdate;
	private JButton buttonAdd;
	private JTable tableData;
	private JPanel panelMain;
	private JPanel panelImage;
	private JTextField txtPath;
	private ButtonGroup buttonGroup;
    private PanelImageButton panelProcessImage = new PanelImageButton();
    private DaoPaintFocus daoPaintFocus ;
	private ImagePerfectJAI imageUtil = new ImagePerfectJAI();
	private ShowJAI imageCanvas;
    private String projectName;
    private Tbl_Projects project;
    private FrmStep frmStep;
    private PanelListField panelListField;
    private DefaultTableModel model ;
    private JLabel jLabel2;
    private JLabel jLabel1;
    private JComboBox comboboxQuality;
    private JButton buttonRefresh;
    private JButton buttonClearCell;
    private String [] header;
    private HashMap<Integer, JTextField> mapTextField;
    private List<Focus_Field> listFocusField;
	
	public FrmPaintMultiFocus( FrmStep frmStep,String projectName , Tbl_Projects project) {
		super();
		this.frmStep = frmStep;
		this.projectName = projectName;
		this.project = project;
		
		imageCanvas = imageUtil.imageCanvas;
		panelProcessImage.setPerfectJAI(imageUtil);
		daoPaintFocus = new DaoPaintFocus(project);
		initGUI();
		AppUtility.fullScreen(this);
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
				getContentPane().add(getPanelData(), new AnchorConstraint(799, 1000, 1000, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				getContentPane().add(getPanelFooter(), new AnchorConstraint(742, 1000, 799, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
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
				getContentPane().add(panelContent, new AnchorConstraint(40, 1000, 743, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelContent.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelContent.setPreferredSize(new java.awt.Dimension(1207, 528));
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
			buttonSave.setFont(new java.awt.Font("Arial",1,16));
			buttonSave.setForeground(new java.awt.Color(255,0,0));
			buttonSave.setPreferredSize(new java.awt.Dimension(66, 33));
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
			buttonBrowse.setForeground(new java.awt.Color(255,0,0));
			buttonBrowse.addActionListener(this);
		}
		return buttonBrowse;
	}
	
	private JPanel getPanelFooter() {
		if(panelFooter == null) {
			panelFooter = new JPanel();
			AnchorLayout panelFooterLayout = new AnchorLayout();
			panelFooter.setPreferredSize(new java.awt.Dimension(1207, 43));
			panelFooter.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
			panelFooter.setLayout(panelFooterLayout);
			panelFooter.add(getJLabel2(), new AnchorConstraint(58, 316, 965, 271, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			panelFooter.add(getJLabel1(), new AnchorConstraint(58, 484, 965, 425, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			panelFooter.add(getComboboxQuality(), new AnchorConstraint(81, 552, 988, 484, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			panelFooter.add(getButonClear(), new AnchorConstraint(34, 659, 988, 582, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			panelFooter.add(getButtonClearCell(), new AnchorConstraint(58, 731, 965, 659, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			panelFooter.add(getButtonDeleteRow(), new AnchorConstraint(34, 936, 988, 858, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			panelFooter.add(getButtonUpdate(), new AnchorConstraint(58, 858, 965, 798, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			panelFooter.add(getButonAdd(), new AnchorConstraint(67, 798, 959, 741, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			panelFooter.add(getComboboxTable(), new AnchorConstraint(81, 253, 965, 2, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			panelFooter.add(getComboboxForm(), new AnchorConstraint(81, 407, 965, 321, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			panelFooter.add(getButtonSave(), new AnchorConstraint(67, 996, 959, 941, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
		}
		return panelFooter;
	}
	
	private JComboBox getComboboxTable() {
		if(comboboxTable == null) {
			comboboxTable = new JComboBox();
			comboboxTable.setBorder(BorderFactory.createTitledBorder(null, "List all tables", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,12), new java.awt.Color(255,0,0)));
			comboboxTable.setPreferredSize(new java.awt.Dimension(304, 38));
			comboboxTable.setFont(new java.awt.Font("Arial",1,18));
			comboboxTable.addActionListener(this);
		}
		return comboboxTable;
	}
	
	private JComboBox getComboboxForm() {
		if(comboboxForm == null) {
			comboboxForm = new JComboBox();
			comboboxForm.setPreferredSize(new java.awt.Dimension(104, 38));
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
	
	
	private JPanel getPanelData() {
		if(panelData == null) {
			panelData = new JPanel();
			BorderLayout panelDataLayout = new BorderLayout();
			panelData.setLayout(panelDataLayout);
			panelData.setPreferredSize(new java.awt.Dimension(1207, 151));
			panelData.setBorder(BorderFactory.createTitledBorder(""));
			panelData.add(getScrollPaneData());
		}
		return panelData;
	}
	
	private JScrollPane getScrollPaneData() {
		if(scrollPaneData == null) {
			scrollPaneData = new JScrollPane();
			scrollPaneData.setViewportView(getTableData());
		}
		return scrollPaneData;
	}
	
	private JTable getTableData() {
		if(tableData == null) {
			tableData = new JTable();
			tableData.addKeyListener(new KeyAdapter() {         
	             public void keyPressed(KeyEvent e) {
	             }
	        });
			
			tableData.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				
				@Override
				public void valueChanged(ListSelectionEvent e) {
					valueChangeEvent();
				}
				
			});
			
			tableData.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					valueChangeEvent();
				}
			});
		}
		return tableData;
	}
	
	
	private JButton getButonAdd() {
		if(buttonAdd == null) {
			buttonAdd = new JButton();
			buttonAdd.setText("Add");
			buttonAdd.setPreferredSize(new java.awt.Dimension(68, 33));
			buttonAdd.setFont(new java.awt.Font("Arial",1,16));
			buttonAdd.setForeground(new java.awt.Color(128,0,128));
			buttonAdd.addActionListener(this);
			buttonAdd.setMnemonic(KeyEvent.VK_A);

		}
		return buttonAdd;
	}
	
	private JButton getButtonUpdate() {
		if(buttonUpdate == null) {
			buttonUpdate = new JButton();
			buttonUpdate.setText("Update");
			buttonUpdate.setPreferredSize(new java.awt.Dimension(73, 39));
			buttonUpdate.setFont(new java.awt.Font("Arial",1,16));
			buttonUpdate.setForeground(new java.awt.Color(128,0,128));
			buttonUpdate.addActionListener(this);
			buttonUpdate.setMnemonic(KeyEvent.VK_U);
		}
		return buttonUpdate;
	}
	
	private JButton getButtonDeleteRow() {
		if(buttonDeleteRow == null) {
			buttonDeleteRow = new JButton();
			buttonDeleteRow.setText("Delete Row");
			buttonDeleteRow.setPreferredSize(new java.awt.Dimension(94, 41));
			buttonDeleteRow.setFont(new java.awt.Font("Arial",1,16));
			buttonDeleteRow.setForeground(new java.awt.Color(128,0,128));
			buttonDeleteRow.addActionListener(this);
			buttonDeleteRow.setMnemonic(KeyEvent.VK_D);

		}
		return buttonDeleteRow;
	}
	
	private JButton getButtonClearCell() {
		if(buttonClearCell == null) {
			buttonClearCell = new JButton();
			buttonClearCell.setText("Clear Cell");
			buttonClearCell.setPreferredSize(new java.awt.Dimension(87, 39));
			buttonClearCell.setFont(new java.awt.Font("Arial",1,16));
			buttonClearCell.setForeground(new java.awt.Color(0,0,0));
			buttonClearCell.addActionListener(this);
			buttonClearCell.setMnemonic(KeyEvent.VK_C);

		}
		return buttonClearCell;
	}
	
	
	private JButton getButonClear() {
		if(buttonRefresh == null) {
			buttonRefresh = new JButton();
			buttonRefresh.setText("Refresh");
			buttonRefresh.setPreferredSize(new java.awt.Dimension(92, 41));
			buttonRefresh.setFont(new java.awt.Font("Arial",1,16));
			buttonRefresh.setForeground(new java.awt.Color(0,0,0));
			buttonRefresh.addActionListener(this);
			buttonRefresh.setMnemonic(KeyEvent.VK_C);

		}
		return buttonRefresh;
	}
	
	
	//=========================================================================================================================
	
	private void initData() {
       loadTables();
       styleTable();
       addHeaderJtable();
       addHotKeyListener();
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
			addHeaderJtable();
			loadDataToGrid();
		}
		if(action == buttonSave) {
			save();
		}
		if(action == buttonAdd) {
			add();
		}
		if(action == buttonDeleteRow) {
			delete();
		}
		if(action == buttonClearCell) {
			clearCell();
		}
		if(action ==buttonUpdate) {
			update();
		}
		if(action == buttonRefresh) {
			clear();
		}
	}
	
	private void addHotKeyListener() 
	{
		java.awt.Toolkit.getDefaultToolkit().addAWTEventListener(
				new java.awt.event.AWTEventListener() 
			{
				public void eventDispatched(java.awt.AWTEvent event) 
				{
					KeyEvent e = (KeyEvent) event;
					if (e.getID() == KeyEvent.KEY_PRESSED && FrmPaintMultiFocus.this.isFocused()) 
					{
						
						if ((e.getKeyCode() == KeyEvent.VK_A && e.isAltDown()))
						{
							 add();
							 e.consume();
						     return;
						}
						if (e.getKeyCode() == KeyEvent.VK_U && e.isAltDown()) 
						{
							update();
							e.consume();
							return;
						}
						
						if(e.getKeyCode() == KeyEvent.VK_D && e.isAltDown())
						{
							delete();
							e.consume();
							return;
						}
						
						if(e.getKeyCode() == KeyEvent.VK_C && e.isAltDown())
						{
							clear();
							e.consume();
							return;
						}
						
						
					}
				}
			}, java.awt.AWTEvent.KEY_EVENT_MASK);
	}
	
	private JComboBox getComboboxQuality() {
		if(comboboxQuality == null) {
			ComboBoxModel comboboxQualityModel = 
					new DefaultComboBoxModel(
							new String[] { "4", "8" });
			comboboxQuality = new JComboBox();
			comboboxQuality.setModel(comboboxQualityModel);
			comboboxQuality.setPreferredSize(new java.awt.Dimension(82, 39));
			comboboxQuality.setFont(new java.awt.Font("Arial",1,12));
			comboboxQuality.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					comboboxQualityActionPerformed(evt);
				}
			});
		}
		return comboboxQuality;
	}

	//=========================================================================================================================

	/**
	 * set format jtable
	 */
	private void styleTable() 
	{
		tableData.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
		JTableHeader header = tableData.getTableHeader();
	
		header.setForeground(Color.BLUE);
		tableData.setCellSelectionEnabled(true);
		tableData.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tableData.setFont(new java.awt.Font("Tahoma",1,12));
		tableData.setShowGrid(true);
		tableData.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		tableData.setRowHeight(30);
		tableData.getTableHeader().setReorderingAllowed(false);
	}
	
	private void setSizeColumnJTable() {
		int totalColumn = tableData.getColumnCount();
		for (int i = 1; i < totalColumn; i++) {
			JTableUtil.setPrefersizeColum(tableData, i, 150);
		}
	}
	
	/**
	 * load all table of schema
	 */
	public void loadTables() 
	{
		try {
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
			AppUtility.msgInfo(this, "loadTables : " + e.toString());
		}

	}
	
	/**
	 * load formid
	 */
	public void loadForm() 
	{
		try {
			
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
			AppUtility.msgInfo(this, "loadForm : " + e.toString());
		}
	}
	
	/**
	 * load fieldname of form
	 */
	private void loadField() 
	{
		try {
			imageCanvas = imageUtil.imageCanvas;
			imageCanvas.mapFocus.clear();
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
	 * load data to grid
	 */
	public void loadDataToGrid()
	{
	   int idx = 0;
	   try 
		{
			model = new DefaultTableModel(header , 0);
			listFocusField = daoPaintFocus.getListFocusFieldByForm(Integer.parseInt(comboboxForm.getSelectedItem().toString()));
			int len = listFocusField.size();
			Object [] values = new Object [header.length];
			Focus_Field  focus_Field;
			
			if(listFocusField.size() > 0) 
			{
				for (int i = 0; i < len ;i++) 
				{
					focus_Field = new Focus_Field();
					focus_Field = listFocusField.get(i);
					String focus = StringUtil.setNotNull(focus_Field.getFocus());
					int seq_number = focus_Field.getSeq_number();
					
					if (i == 0) {
						idx = 1;
						values[0] = seq_number;
						values[1] = focus;
					} 
					else if ((i > 0 && seq_number == listFocusField.get(i - 1).getSeq_number())) {
						values[idx] = focus;
					} 
					else if (seq_number != listFocusField.get(i - 1).getSeq_number()) 
					{
						model.addRow(values);
						values = new Object[header.length];
						
						idx = 1;
						values[0] = seq_number;
						values[1] = focus;
					}
					if (i == len - 1)
					{
						values[idx] = focus;
						model.addRow(values);
						values = new Object[header.length];
					}
					++idx;
					
				}
				tableData.setModel(model);
				setSizeColumnJTable();
			}

		} 
		catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgInfo(this, "loadDataToGrid : " + e.toString());
		}

	}
	
	/**
	 * value change event
	 */
	private void valueChangeEvent() 
	{
		String fieldname = "";
		String value = "";
		int row = -1;
		row = tableData.getSelectedRow();
		
		try {
			
			if(row > -1) 
			{
				for (int key :  mapTextField.keySet()) {
					fieldname = mapTextField.get(key).getName();
					value = JTableUtil.getValuesByHeaderName(tableData, fieldname, row);
					mapTextField.get(key).setText(value);
				}
				int col = tableData.getSelectedColumn();
				if(col > 0) 
				{
				    String columName = tableData.getColumnName(col);
					for (int key :  mapTextField.keySet()) 
					{
						fieldname = mapTextField.get(key).getName();
						if(fieldname.equals(columName)) {
							panelListField.mapTextField.get(key).requestFocus();
							break;
						}
					}
				}
			}
		} 
		catch (Exception e) {
			AppUtility.msgInfo(this, e.toString());
		}
	}
	
	/**
	 * clear value field
	 */
	private void clear() 
	{
		for (int key :  mapTextField.keySet()) {
			mapTextField.get(key).setText("");
		}
		imageCanvas.mapFocus.clear();
	}

	
	/**
	 * add header Jtable
	 */
	private void addHeaderJtable() 
	{
		mapTextField = new HashMap<Integer, JTextField>();
    	mapTextField = panelListField.mapTextField;
    	int len = mapTextField.size();
    	header = new String [len+1];
    	header[0] = "seq_number";
    	JTextField txtTmp;
    	
    	int index = 1;
    	for (int key :  mapTextField.keySet())
    	{
    		txtTmp = mapTextField.get(key);
    		header[index] = txtTmp.getName();
    		++index;
		}
    	model = new DefaultTableModel( header , 0);
    	tableData.setModel(model);
		setSizeColumnJTable();

	}
	
    /**
	 * add row
	 */
    private void add() 
    {
    	try {
    		int len = mapTextField.size();
    		Object [] values = new Object [len+1];
    		values[0] = tableData.getRowCount()+1;
    		int index = 1;
    		JTextField txtTmp;
    		
    		values[0] = tableData.getRowCount() +1;
    		for (int key :  mapTextField.keySet())
    		{
    			txtTmp = mapTextField.get(key);
    			values[index] = StringUtil.setNotNull(txtTmp.getText());
    			++index;
    		}
    		model.addRow(values);
    		tableData.setModel(model);
    		setSizeColumnJTable();
    		clear();
    	    panelListField.getMapTextField().get(0).requestFocus();

		} 
    	catch (Exception e) {
    		e.printStackTrace();
    		AppUtility.msgError(this, e.toString());
		}
    }
    
    /**
	 * delete row
	 */
	private void delete() 
	{
        int row = -1;
        row = tableData.getSelectedRow();
        boolean flag = false;
        
        try {
            if(row > -1) 
            {
            	if(listFocusField.size() > 0) 
            	{
            		int formid = Integer.parseInt(comboboxForm.getSelectedItem().toString());
            		if(listFocusField.size() > 0) 
            		{
            			flag = daoPaintFocus.deleteAll(formid);
            			if(flag) 
            			{
                        	model.removeRow(row);
            				save();
            			}
            		}
            	}
            	else 
            	{
                	model.removeRow(row);
                	int totalRow = tableData.getRowCount();
                	for (int i = 0; i < totalRow; i++) {
        				tableData.setValueAt((i+1), i, 0);
        			}
            	}
            }
		} 
        catch (Exception e) {
        	e.printStackTrace();
        	AppUtility.msgInfo(this, e.toString());
		}

	}
	
	/**
	 * clear cell
	 */
	private boolean clearCell() 
	{
		boolean flag = false;
		try 
		{
			int row = -1;
			row = tableData.getSelectedRow();
			if(row > -1) 
			{
				if(listFocusField.size() > 0) {
					
				}
	            int formid = Integer.parseInt(comboboxForm.getSelectedItem().toString());
	            String fieldname = tableData.getColumnName(tableData.getSelectedColumn());
	            int seq_number = Integer.parseInt(tableData.getValueAt(row, 0).toString());
	            flag = daoPaintFocus.updateCell(formid, seq_number , fieldname);
	            if(flag) {
	            	clear();
	            	loadDataToGrid();
	            }
	            else {
					int col = tableData.getSelectedColumn();
					if(col > 0) {
						tableData.setValueAt("", row, col);
					}
	            }
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgInfo(this, "clearCell : " + e.toString());
		}
		return flag;
	}
	
	/**
	 * update value focus
	 */
	private void update() {
		
		boolean flag = false;
		int row = -1;
		row = tableData.getSelectedRow();
		
		try {
			if(row > -1) 
			{
				if(listFocusField.size() > 0) 
				{
					String fieldname = "";
					String value = "";
					int formid = Integer.parseInt(comboboxForm.getSelectedItem().toString());
					int seq_number = Integer.parseInt(tableData.getValueAt(row, 0).toString());
					HashMap<String, String> mapData = new HashMap<String , String>();
					
					for (int key :  mapTextField.keySet()) 
					{
						fieldname = mapTextField.get(key).getName();
						value = StringUtil.setNotNull(mapTextField.get(key).getText());
						mapData.put(fieldname, value);
					}
					flag = daoPaintFocus.updateRow( mapData, formid, seq_number);
					if(flag) {
						loadDataToGrid();
						clear();
					}
				}
				else {
					int col = tableData.getSelectedColumn();
					if(col > 0) {
						String field = tableData.getColumnName(col);
						if(imageCanvas.mapFocus.get(field) != null) {
							String focus = StringUtil.setNotNull(imageCanvas.mapFocus.get(field).getText());
							tableData.setValueAt(focus, row, col);
						}
					}
				}
			}
			else {
				AppUtility.msgError(this, "Please select row !!");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgInfo(this, e.toString());
		}
		
	}
	

	/**
	 * save value focus
	 */
	private boolean save()
	{
		boolean flag = false;
		List<Focus_Field> listSaveData = new ArrayList<Focus_Field>();
		int totalRow = tableData.getRowCount();
		int totalColumn = tableData.getColumnCount();
		Focus_Field focus_Field;
		String columName = "";
		String value = "";
		int seq_number = 1;
		
		try {
			
			for (int row = 0; row < totalRow; row++) 
			{
	            for (int column = 1; column <  totalColumn; column++) 
	            {
	            	focus_Field = new Focus_Field();
					columName = tableData.getColumnName(column);
					value = StringUtil.setNotNull(tableData.getValueAt(row, column));
					
					focus_Field.setFormid(Integer.parseInt(comboboxForm.getSelectedItem().toString()));
					focus_Field.setFieldname(columName);
					focus_Field.setFocus(value);
					focus_Field.setSeq_number(seq_number);
					listSaveData.add(focus_Field);
				}			
	            ++ seq_number;
			}
			flag = daoPaintFocus.deleteAll(Long.parseLong(comboboxForm.getSelectedItem().toString()));
			if(flag) {
				flag = daoPaintFocus.saveMultiFocus(listSaveData);
			}
			if(flag) {
				flag = daoPaintFocus.updateStatusForm(comboboxForm.getSelectedItem().toString());
			}
			
			if(flag) {
				loadDataToGrid();
				clear();
				imageCanvas.mapFocus.clear();
				AppUtility.msgInfo(this, "Save data successfull !!");
			}
			
		} catch (Exception e) {
			AppUtility.msgInfo(this, e.toString());
		}
		return flag;
	}
	
	private void comboboxQualityActionPerformed(ActionEvent evt) {
		if(txtPath.getText().length() >0) {
			int quality = Integer.parseInt(comboboxQuality.getSelectedItem().toString());
			imageUtil.displayImage(txtPath.getText(), quality);
			panelListField.getMapTextField().get(0).requestFocus();
		}
	}
	
	private JLabel getJLabel1() {
		if(jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Quality");
			jLabel1.setPreferredSize(new java.awt.Dimension(71, 39));
			jLabel1.setFont(new java.awt.Font("Arial",1,16));
			jLabel1.setBorder(new LineBorder(new java.awt.Color(255,0,0), 1, false));
			jLabel1.setForeground(new java.awt.Color(255,0,0));
		}
		return jLabel1;
	}
	
	private JLabel getJLabel2() {
		if(jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("Form");
			jLabel2.setPreferredSize(new java.awt.Dimension(55, 39));
			jLabel2.setFont(new java.awt.Font("Arial",1,16));
			jLabel2.setBorder(new LineBorder(new java.awt.Color(255,0,0), 1, false));
			jLabel2.setForeground(new java.awt.Color(255,0,0));
		}
		return jLabel2;
	}

	//=========================================================================================================================


}
