package com.digitexx.ancestry.job.info;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
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

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.component.PanelTrayIcon;
import com.digitexx.ancestry.dao.DaoJobInformation;
import com.digitexx.ancestry.util.AppUtility;
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
@SuppressWarnings("serial")
public class FrmUserJobInformation extends javax.swing.JFrame {
	{
		try {
			AppUtility.setLookAndField(1);
		} catch (Exception e) {
			e.printStackTrace();			
		}
	}
	private JPanel panelHeader;
	private JPanel panelContent;
	private JPanel panelFooter;
	private JScrollPane scrollPaneLog;
	private JCheckBox checkboxRework;
	private JTextPane textPaneLog;
	private JTable tableData;
	private JLabel jLabel2;
	private JScrollPane scrollPaneData;
	private JPanel panelLog;
	private JPanel panelData;
	private JSplitPane splitPaneContent;
	private JTextField txtSearch;
	private JProgressBar progressBar;
	private JButton buttonGetMore;
	private JComboBox comboboxProject;
	private JLabel jLabel1;
	
	private Map<String , Tbl_Projects> mapBeanProject = new LinkedHashMap<String , Tbl_Projects>();
	private DaoJobInformation  daoJobInformation = new DaoJobInformation();
	private Map<String, List<Object[]>> mapJobType = new LinkedHashMap<String, List<Object[]>>();
	private Map<String, List<Object[]>> mapJobRework = new LinkedHashMap<String, List<Object[]>>();
	private List<Object[]> listJobInfo = new ArrayList<Object[]>();
	
	private boolean isPjm = false;
	private boolean isRework = false;
	private String username = "";
	public PanelTrayIcon panelTrayIcon;

	public FrmUserJobInformation(
			                     PanelTrayIcon panelTrayIcon,
			                     Map<String , Tbl_Projects> mapBeanProject, 
			                     Map<String, List<Object[]>> mapJobType, 
			                     Map<String, List<Object[]>> mapJobRework , 
			                     String username , 
			                     boolean isPjm) 
	{
		super();
		this.panelTrayIcon = panelTrayIcon;
		this.mapBeanProject = mapBeanProject;
		this.mapJobType = mapJobType;
		this.mapJobRework = mapJobRework;
		this.username = username;
		this.isPjm = isPjm;
		initGUI();
		loadProjectCombobox();
		isRework = checkboxRework.isSelected();
		loadJob();
	}
	
	private void initGUI() {
		try {
			this.setTitle("Ancestry Job Information");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			{
				panelHeader = new JPanel();
				AnchorLayout panelHeaderLayout = new AnchorLayout();
				getContentPane().add(panelHeader, new AnchorConstraint(0, 1000, 55, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelHeader.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelHeader.setLayout(panelHeaderLayout);
				panelHeader.setPreferredSize(new java.awt.Dimension(967, 32));
				{
					jLabel1 = new JLabel();
					panelHeader.add(jLabel1, new AnchorConstraint(78, 67, 953, 2, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jLabel1.setText("Project");
					jLabel1.setFont(new java.awt.Font("Arial",1,14));
					jLabel1.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, true));
					jLabel1.setPreferredSize(new java.awt.Dimension(63, 28));
					jLabel1.setForeground(new java.awt.Color(255,0,0));
					jLabel1.setBounds(1, 2, 63, 28);
				}
				{
					comboboxProject = new JComboBox();
					panelHeader.add(comboboxProject, new AnchorConstraint(78, 452, 953, 70, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					comboboxProject.setFont(new java.awt.Font("Arial",1,16));
					comboboxProject.setForeground(new java.awt.Color(255,0,0));
					comboboxProject.setBounds(67, 2, 402, 28);
					comboboxProject.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							comboboxProjectActionPerformed(evt);
						}
					});
				}
				{
					buttonGetMore = new JButton();
					panelHeader.add(buttonGetMore, new AnchorConstraint(46, 998, 921, 871, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonGetMore.setText("Get More");
					buttonGetMore.setFont(new java.awt.Font("Arial",1,16));
					buttonGetMore.setForeground(new java.awt.Color(0,0,255));
					buttonGetMore.setPreferredSize(new java.awt.Dimension(123, 28));
					buttonGetMore.setBounds(842, 1, 123, 28);
					buttonGetMore.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							buttonGetMoreActionPerformed(evt);
						}
					});
				}
				{
					jLabel2 = new JLabel();
					panelHeader.add(jLabel2, new AnchorConstraint(15, 662, 890, 601, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jLabel2.setText("Search");
					jLabel2.setFont(new java.awt.Font("Arial",1,16));
					jLabel2.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					jLabel2.setPreferredSize(new java.awt.Dimension(59, 28));
					jLabel2.setBounds(581, 0, 59, 28);
				}
				{
					txtSearch = new JTextField();
					panelHeader.add(txtSearch, new AnchorConstraint(46, 866, 890, 669, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					txtSearch.setPreferredSize(new java.awt.Dimension(190, 27));
					txtSearch.setFont(new java.awt.Font("Arial",1,18));
					txtSearch.setBounds(646, 1, 191, 27);
				}
				{
					checkboxRework = new JCheckBox();
					panelHeader.add(checkboxRework, new AnchorConstraint(41, 579, 791, 489, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					checkboxRework.setText("Rework");
					checkboxRework.setFont(new java.awt.Font("Arial",1,16));
					checkboxRework.setForeground(new java.awt.Color(255,0,0));
					checkboxRework.setPreferredSize(new java.awt.Dimension(89, 27));
					checkboxRework.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							checkboxReworkActionPerformed(evt);
						}
					});
				}
			}
			{
				panelContent = new JPanel();
				BorderLayout panelContentLayout = new BorderLayout();
				panelContent.setLayout(panelContentLayout);
				getContentPane().add(panelContent, new AnchorConstraint(55, 1000, 966, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelContent.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelContent.setPreferredSize(new java.awt.Dimension(967, 538));
				//panelContent.add(panelTrayIcon);
				{
					splitPaneContent = new JSplitPane();
					panelContent.add(splitPaneContent, BorderLayout.CENTER);
					splitPaneContent.setOrientation(JSplitPane.VERTICAL_SPLIT);
					{
						panelLog = new JPanel();
						BorderLayout panelLogLayout = new BorderLayout();
						panelLog.setLayout(panelLogLayout);
						splitPaneContent.add(panelLog, JSplitPane.RIGHT);
						panelLog.setBorder(BorderFactory.createTitledBorder(null, "Log Detail", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,16), new java.awt.Color(255,0,0)));
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
						panelData = new JPanel();
						BorderLayout panelDataLayout = new BorderLayout();
						panelData.setLayout(panelDataLayout);
						splitPaneContent.add(panelData, JSplitPane.LEFT);
						panelData.setPreferredSize(new java.awt.Dimension(961, 451));
						panelData.setBorder(BorderFactory.createTitledBorder(null, "Job Information", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,16), new java.awt.Color(0,0,0)));
						{
							scrollPaneData = new JScrollPane();
							panelData.add(scrollPaneData, BorderLayout.CENTER);
							{
								tableData = new JTable() {
									@Override
									public boolean isCellEditable(int row,int column) {
										return false;
									}
								};
								scrollPaneData.setViewportView(tableData);
							}
						}
					}
				}
			}
			{
				panelFooter = new JPanel();
				BorderLayout panelFooterLayout = new BorderLayout();
				panelFooter.setLayout(panelFooterLayout);
				getContentPane().add(panelFooter, new AnchorConstraint(965, 1000, 999, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelFooter.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelFooter.setPreferredSize(new java.awt.Dimension(967, 20));
				{
					progressBar = new JProgressBar();
					panelFooter.add(progressBar, BorderLayout.CENTER);
				}
			}
			pack();
			this.setSize(992, 696);
			AppUtility.centerFrame(this);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					if(!isPjm) {
						dispose();
					}else {
						System.exit(0);
					}
				}
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @return the mapJobType
	 */
	public Map<String, List<Object[]>> getMapJobType() {
		return mapJobType;
	}

	/**
	 * @param mapJobType the mapJobType to set
	 */
	public void setMapJobType(LinkedHashMap<String, List<Object[]>> mapJobType) {
		this.mapJobType = mapJobType;
	}

	/**
	 * @return the mapJobRework
	 */
	public Map<String, List<Object[]>> getMapJobRework() {
		return mapJobRework;
	}

	/**
	 * @param mapJobRework the mapJobRework to set
	 */
	public void setMapJobRework(LinkedHashMap<String, List<Object[]>> mapJobRework) {
		this.mapJobRework = mapJobRework;
	}
	
	
	//=======================================================================================================================
	
	/**
	 * load project name
	 */
	private void loadProjectCombobox() {
		comboboxProject.removeAllItems();
        for (String key : mapBeanProject.keySet()) {
			comboboxProject.addItem(key);
		}
        comboboxProject.setSelectedIndex(0);
	}
	
	/**
	 * load job infomation
	 */
	private void loadJobInfo(String projectName , boolean isGetMore) {
		listJobInfo = new ArrayList<Object[]>();
		try {
			textPaneLog.setText("");
			String [] arrHeader = new String [] { "No." , "Phase" , "Form" , "Id" ,"Path" , "File Name" , "Step" , "User"  , "Record Status"};
			if(!isPjm) {
				arrHeader = new String [] { "No." , "Phase" , "Form" , "Id" , "Step" , "User"};
			}
			
			JTableUtil.removeAllRow(tableData);
			if(comboboxProject.getSelectedIndex() > -1) 
			{
				Tbl_Projects project = mapBeanProject.get(comboboxProject.getSelectedItem().toString());
				
				boolean hasTablePhase = daoJobInformation.checkExistTablePhase(project);
				if(hasTablePhase == false) {
					arrHeader = new String [] { "No." , "Form" , "Id" ,"Path" , "File Name" , "Step" , "User"  , "Record Status"};
					if(!isPjm) {
						arrHeader = new String [] { "No." , "Form" , "Id" , "Step" , "User"};	
					}
				}
				if(!isGetMore) {
					if(!isRework) {
						listJobInfo = mapJobType.get(projectName);
					}else {
						listJobInfo = mapJobRework.get(projectName);
					}
				}else {
					listJobInfo = daoJobInformation.getListManagementByProject(project , isPjm , username , isRework , hasTablePhase);
				}
				if(listJobInfo != null && listJobInfo.size()  >0) {
					JTableUtil.loadListObjectToGrid( arrHeader, tableData, listJobInfo, txtSearch, true);
					JTableUtil.styleTable(tableData, true);
					AppUtility.appendText(textPaneLog, "Finished load information !!", Color.BLUE);
				}else {
					this.dispose();
				}
			}

			
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.appendText(textPaneLog, "loadJobInfo : "  + e.toString(), Color.RED);
		}
	}
	
	private void comboboxProjectActionPerformed(ActionEvent evt) {
		if(comboboxProject.getSelectedIndex() > -1) {
			textPaneLog.setText("");
			loadJob();
		}
	}
	
	private void loadJob() {
		String projectName = comboboxProject.getSelectedItem().toString();
		if(!projectName.equals("")) {
			loadJobInfo(projectName ,false);
		}
	}
	
	private void checkboxReworkActionPerformed(ActionEvent evt) {
		if(checkboxRework.isSelected() ) {
			isRework = true;
		}else {
			isRework = false;
		}
		loadJob();
	}
	
	private void buttonGetMoreActionPerformed(ActionEvent evt) {
		String projectName = Objects.toString(comboboxProject.getSelectedItem() , "");
		loadJobInfo(projectName ,true);
	}
	


}
