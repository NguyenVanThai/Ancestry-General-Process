/**
 * 
 */
package com.digitexx.ancestry.component;
import java.awt.BorderLayout;
import java.awt.Font;
import java.util.List;
import java.util.Objects;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.digitexx.ancestry.bean.Tbl_Projects;
import com.digitexx.ancestry.dao.DaoPanelViewPathByUser;
import com.digitexx.ancestry.gui.util.WrapEditorKit;
import com.digitexx.ancestry.table.render.HeaderCheckBoxHandler;
import com.digitexx.ancestry.table.render.HeaderRenderer;
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
/**
 * @author lqnhu
 *
 */
public class PanelViewPathByUser extends JPanel {
	private JSplitPane splitPaneMain;
	public JTextPane textPaneManagementId;
	private JScrollPane scrollPaneIds;
	public JTable tableField;
	private JScrollPane scrollPaneField;
	private JTable tablePath;
	private JScrollPane scrollPanePath;
	private JList jListUser;
	private JScrollPane scrollPaneUser;
	private JPanel panelBotoom;
	private JPanel panelField;
	private JPanel panelIds;
	private JPanel panelUser;
	private JPanel panelPath;
	private JSplitPane splitPaneBottom;
	private JSplitPane splitPaneTop;
	private JPanel panelTop;
	private DefaultListModel modelUser;
	private DefaultTableModel modelField;
	private DefaultTableModel modelPath;
	
	private DaoPanelViewPathByUser daoPanelViewPathByUser;
	private Tbl_Projects project;
	private String userSelect;
	private boolean isRework;

	public PanelViewPathByUser(Tbl_Projects project , boolean isRework) {
		this.project  = project;
		this.isRework = isRework;
		daoPanelViewPathByUser = new DaoPanelViewPathByUser(project);
		initGUI();
		initData();
	}
	
	private void initGUI() {
		try {
			{
				BorderLayout thisLayout = new BorderLayout();
				this.setLayout(thisLayout);
				this.setPreferredSize(new java.awt.Dimension(690, 406));
				{
					splitPaneMain = new JSplitPane();
					this.add(splitPaneMain, BorderLayout.CENTER);
					splitPaneMain.setOrientation(JSplitPane.VERTICAL_SPLIT);
					{
						panelBotoom = new JPanel();
						BorderLayout jPanel1Layout = new BorderLayout();
						panelBotoom.setLayout(jPanel1Layout);
						splitPaneMain.add(panelBotoom, JSplitPane.RIGHT);
						{
							splitPaneBottom = new JSplitPane();
							panelBotoom.add(splitPaneBottom, BorderLayout.CENTER);
							{
								panelIds = new JPanel();
								BorderLayout panelIdsLayout = new BorderLayout();
								panelIds.setLayout(panelIdsLayout);
								splitPaneBottom.add(panelIds, JSplitPane.RIGHT);
								panelIds.setBorder(BorderFactory.createTitledBorder(null, "ManagementId", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,14)));
								{
									scrollPaneIds = new JScrollPane();
									panelIds.add(scrollPaneIds, BorderLayout.CENTER);
									{
										textPaneManagementId = new JTextPane();
										textPaneManagementId.setFont(new java.awt.Font("Courier New",0,14));
										textPaneManagementId.setEditorKit(new WrapEditorKit());
										scrollPaneIds.setViewportView(textPaneManagementId);
									}
								}
							}
							{
								panelField = new JPanel();
								BorderLayout panelFieldLayout = new BorderLayout();
								panelField.setLayout(panelFieldLayout);
								splitPaneBottom.add(panelField, JSplitPane.LEFT);
								panelField.setPreferredSize(new java.awt.Dimension(230, 185));
								panelField.setBorder(BorderFactory.createTitledBorder(null, "Fields", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,14)));
								{
									scrollPaneField = new JScrollPane();
									panelField.add(scrollPaneField, BorderLayout.CENTER);
									{
										tableField = new JTable() {
											@Override
											public boolean isCellEditable(int row, int column) {
												if(column == 2) {
													return true;
												}else {
													return false;
												}
											}
										};
										scrollPaneField.setViewportView(tableField);
									}
								}
							}
						}
					}
					{
						panelTop = new JPanel();
						BorderLayout jPanel2Layout = new BorderLayout();
						panelTop.setLayout(jPanel2Layout);
						splitPaneMain.add(panelTop, JSplitPane.LEFT);
						panelTop.setPreferredSize(new java.awt.Dimension(688, 210));
						{
							splitPaneTop = new JSplitPane();
							panelTop.add(splitPaneTop, BorderLayout.CENTER);
							{
								panelPath = new JPanel();
								BorderLayout panelPathLayout = new BorderLayout();
								panelPath.setLayout(panelPathLayout);
								splitPaneTop.add(panelPath, JSplitPane.RIGHT);
								panelPath.setPreferredSize(new java.awt.Dimension(356, 208));
								panelPath.setBorder(BorderFactory.createTitledBorder(null, "FilePath", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,14), new java.awt.Color(255,0,0)));
								{
									scrollPanePath = new JScrollPane();
									panelPath.add(scrollPanePath, BorderLayout.CENTER);
									{
										tablePath = new JTable() {
											@Override
											public boolean isCellEditable(int row, int column) {
												return false;
											}
										};
										scrollPanePath.setViewportView(tablePath);
										tablePath.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
											
											@Override
											public void valueChanged(ListSelectionEvent e) {
												valueChangeJtable();
											}
											
										});
									}
								}
							}
							{
								panelUser = new JPanel();
								BorderLayout panelUserLayout = new BorderLayout();
								panelUser.setLayout(panelUserLayout);
								splitPaneTop.add(panelUser, JSplitPane.LEFT);
								panelUser.setPreferredSize(new java.awt.Dimension(218, 208));
								panelUser.setBorder(BorderFactory.createTitledBorder(null, "Users", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,14), new java.awt.Color(255,0,0)));
								panelUser.setFont(new java.awt.Font("Arial",1,14));
								{
									scrollPaneUser = new JScrollPane();
									panelUser.add(scrollPaneUser, BorderLayout.CENTER);
									{
										jListUser = new JList();
										jListUser.setFont(new java.awt.Font("Arial",1,18));
										scrollPaneUser.setViewportView(jListUser);
										jListUser.addListSelectionListener(new ListSelectionListener() {
											public void valueChanged(ListSelectionEvent evt) {
												jListUserValueChanged(evt);
											}
										});
									}
								}
							}
						}
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * init data
	 */
	private void initData() {
         loadUser();
         loadField();
	}
	
	public void reloadData(boolean isRework) {
		this.isRework = isRework;
        loadUser();
        JTableUtil.removeAllRow(tablePath);
        textPaneManagementId.setText("");
        userSelect = "";
	}
	
	/**
	 * load user
	 */
	private void loadUser() {
		try {
			modelUser = new DefaultListModel();
			modelUser.removeAllElements();
	        List<String> listUser = daoPanelViewPathByUser.getListUser(isRework);
	        for (String str : listUser) {
				modelUser.addElement(str);
			}
	        jListUser.setModel(modelUser);
		} 
		catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "loadUser : " + e.toString());
		}

	}
	
	/**
	 * load path
	 */
	private void loadPath(String user) {
		try {
			List<String> listPath = daoPanelViewPathByUser.getListPathByUser(user, isRework);
			JTableUtil.loadListDataToGrid(tablePath, modelPath, new String [] {"No." , "FilePath"  }, listPath, true , false);
			styleTable(tablePath);
		} 
		catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "loadPath : " + e.toString());
		}

	}
	
	/**
	 * load field
	 */
	private void loadField() {
		try {
			modelField = new DefaultTableModel(new String [] {"No." , "FieldName" , "Check"  } , 0) {
                Class[] types = new Class [] {  
                        java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class 
                    };  
           
                    public Class getColumnClass(int columnIndex) {  
                        return types [columnIndex];  
                    } 
			};
			List<String> listField = daoPanelViewPathByUser.getListField();
			Object []  values = null;
			int index = 0;
	        for (String str : listField) {
				values = new Object [] { (index +1) , str , Boolean.TRUE };
				modelField.addRow(values);
				++index;
			}
	        tableField.setModel(modelField);
			TableCellRenderer renderer = new HeaderRenderer(tableField.getTableHeader(), 2);
	        tableField.getColumnModel().getColumn(2).setHeaderRenderer(renderer);
	        modelField.addTableModelListener(new HeaderCheckBoxHandler(tableField, 2));
			styleTable(tableField);
		} 
		catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "loadPath : " + e.toString());
		}
	}
	
	/**
	 * jlist action
	 */
	private void jListUserValueChanged(ListSelectionEvent evt) {
		boolean adjust = evt.getValueIsAdjusting();
		if(!adjust) {
			if(modelUser.getSize() > 0) {
				userSelect =jListUser.getSelectedValue().toString(); 
				loadPath(jListUser.getSelectedValue().toString());
			}
		}
	}
	
	private void styleTable(JTable tableData) {
		tableData.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JTableUtil.addHeaderRow(tableData);
		tableData.setFont(new Font("Arial", Font.PLAIN, 14));

		tableData.setShowGrid(true);
		tableData.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		tableData.setRowHeight(30);
		tableData.setRowHeight(30);
		tableData.getTableHeader().setReorderingAllowed(false);
		JTableUtil.fitTableColumns(tableData);
	}
	
	/**
	 * value change in jtable
	 */
	private void valueChangeJtable() {
		try {
			int row = tablePath.getSelectedRow();
			textPaneManagementId.setText("");
			if(row > -1) {
				String path = Objects.toString(JTableUtil.getValuesByHeaderName(tablePath, "FilePath", row) ,"");
				String user = Objects.toString((jListUser.getSelectedValue()) ,"");
				String ids = daoPanelViewPathByUser.getListManagementIdByFilePath(path , user , isRework);
				textPaneManagementId.setText(ids);
			}
		} catch (Exception e) {
			e.printStackTrace();
			AppUtility.msgError(this, "valueChangeJtable : "  + e.toString());
		}

	}
	
	//======================================================================================================================

	/**
	 * @return the textPaneManagementId
	 */
	public JTextPane getTextPaneManagementId() {
		return textPaneManagementId;
	}

	/**
	 * @param textPaneManagementId the textPaneManagementId to set
	 */
	public void setTextPaneManagementId(JTextPane textPaneManagementId) {
		this.textPaneManagementId = textPaneManagementId;
	}
	
	

	/**
	 * @return the tabelField
	 */
	public JTable getTabelField() {
		return tableField;
	}

	/**
	 * @param tabelField the tabelField to set
	 */
	public void setTabelField(JTable tabelField) {
		this.tableField = tabelField;
	}

	/**
	 * @return the tablePath
	 */
	public JTable getTablePath() {
		return tablePath;
	}

	/**
	 * @param tablePath the tablePath to set
	 */
	public void setTablePath(JTable tablePath) {
		this.tablePath = tablePath;
	}

	/**
	 * @return the userSelect
	 */
	public String getUserSelect() {
		return userSelect;
	}

	/**
	 * @param userSelect the userSelect to set
	 */
	public void setUserSelect(String userSelect) {
		this.userSelect = userSelect;
	}
	
	


}
