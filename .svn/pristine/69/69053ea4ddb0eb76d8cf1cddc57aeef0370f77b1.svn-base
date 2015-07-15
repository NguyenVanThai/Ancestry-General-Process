package com.digitexx.ancestry.component;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import java.util.regex.PatternSyntaxException;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.ancestry.table.render.HighlightTableCellRenderer;
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
public class PanelGridPath extends javax.swing.JPanel
{
	private static final long serialVersionUID = 1L;
	private JPanel panelTop;
	private JPanel panelBottom;
	private JTable tablePath;
	private JScrollPane scrollPaneGrid;
	private JTextField txtSearch;
	private JLabel jLabel1;
	private List<String> listPath;
	private String [] arrHeader;
	private DefaultTableModel modelTablePath;
	private final HighlightTableCellRenderer renderer = new HighlightTableCellRenderer();
    private static final Color WARNING_COLOR = new Color(255, 200, 200);
    private int rowSelected;
	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
		
	public PanelGridPath(List<String> listPath , String [] arrHeader) {
		super();
		this.listPath  = listPath;
		this.arrHeader = arrHeader;
		initGUI();
		loadPath();
	}
	
	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(528, 300));
			AnchorLayout thisLayout = new AnchorLayout();
			this.setLayout(thisLayout);
			{
				panelTop = new JPanel();
				AnchorLayout panelTopLayout = new AnchorLayout();
				this.add(panelTop, new AnchorConstraint(1, 1000, 131, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelTop.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelTop.setLayout(panelTopLayout);
				panelTop.setPreferredSize(new java.awt.Dimension(528, 39));
				{
					jLabel1 = new JLabel();
					panelTop.add(jLabel1, new AnchorConstraint(64, 112, 961, 4, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jLabel1.setText("Search");
					jLabel1.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					jLabel1.setFont(new java.awt.Font("Tahoma",1,12));
					jLabel1.setForeground(new java.awt.Color(255,0,0));
					jLabel1.setPreferredSize(new java.awt.Dimension(57, 35));
				}
				{
					txtSearch = new JTextField();
					panelTop.add(txtSearch, new AnchorConstraint(64, 997, 961, 112, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					txtSearch.setFont(new java.awt.Font("Tahoma",1,12));
					txtSearch.setPreferredSize(new java.awt.Dimension(467, 35));
				}
			}
			{
				panelBottom = new JPanel();
				BorderLayout panelBottomLayout = new BorderLayout();
				panelBottom.setLayout(panelBottomLayout);
				this.add(panelBottom, new AnchorConstraint(128, 1000, 1015, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelBottom.setPreferredSize(new java.awt.Dimension(528, 266));
				{
					scrollPaneGrid = new JScrollPane();
					panelBottom.add(scrollPaneGrid, BorderLayout.CENTER);
					{
						tablePath = new JTable();
						tablePath.getSelectionModel().addListSelectionListener(
								new ListSelectionListener() {
									@Override
									public void valueChanged(ListSelectionEvent e) {
										if (tablePath.getSelectedRow() != -1) {
											if (!e.getValueIsAdjusting()) {
												setRowSelected(tablePath.getSelectedRow());
											}
										}
									}
						});
						scrollPaneGrid.setViewportView(tablePath);
					}
				}
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
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
	 * @return the modelTablePath
	 */
	public DefaultTableModel getModelTablePath() {
		return modelTablePath;
	}

	/**
	 * @param modelTablePath the modelTablePath to set
	 */
	public void setModelTablePath(DefaultTableModel modelTablePath) {
		this.modelTablePath = modelTablePath;
	}

	/**
	 * @return the listPath
	 */
	public List<String> getListPath() {
		return listPath;
	}

	/**
	 * @param listPath the listPath to set
	 */
	public void setListPath(List<String> listPath) {
		this.listPath = listPath;
	}
	
	
	/**
	 * @return the rowSelected
	 */
	public int getRowSelected() {
		return rowSelected;
	}

	/**
	 * @param rowSelected the rowSelected to set
	 */
	public void setRowSelected(int rowSelected) {
		this.rowSelected = rowSelected;
	}
	
	
	//======================================================================================================================


	private void styleTable(JTable tableData) {
		tableData.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JTableHeader header = tableData.getTableHeader();
		header.setForeground(Color.BLACK);
		JTableUtil.addHeaderRow(tableData);
		tableData.setFont(new Font("Arial", Font.PLAIN, 14));

		tableData.setShowGrid(true);
		tableData.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		tableData.setRowHeight(30);
		tableData.setRowHeight(30);
		tableData.getTableHeader().setReorderingAllowed(false);
		JTableUtil.fitTableColumns(tableData);
	}
	
    private void fireDocumentChangeEvent(TableRowSorter<? extends TableModel> sorter ) 
    {
        txtSearch.setBackground(Color.WHITE);
        String pattern = txtSearch.getText().trim();
        if (pattern.isEmpty()) {
            sorter.setRowFilter(null);
            renderer.setPattern("");
        } else if (renderer.setPattern(pattern)) {
            try {
                sorter.setRowFilter(RowFilter.regexFilter(pattern));
            } catch (PatternSyntaxException ex) {
            	txtSearch.setBackground(WARNING_COLOR);
            }
        }
    }
	
	/**
	 * load list path
	 */
	public void loadPath() 
	{
		try 
		{
			modelTablePath = new DefaultTableModel( arrHeader ,0);
			JTableUtil.removeAllRow(tablePath);
			if(listPath.size() > 0) 
			{
				Object [] values = null;
				int index = 1;
				for (String path : listPath) {
					values = new Object [] { index  , path };
					modelTablePath.addRow(values);
					++index;
				}
				tablePath.setModel(modelTablePath);
			    final TableRowSorter<? extends TableModel> sorter = new TableRowSorter<>(modelTablePath);
			    tablePath.setRowSorter(sorter);
			    tablePath.setDefaultRenderer(String.class, renderer);

			    txtSearch.getDocument().addDocumentListener(new DocumentListener() {
			            @Override public void insertUpdate(DocumentEvent e) {
			                fireDocumentChangeEvent(sorter);
			            }
			            @Override public void removeUpdate(DocumentEvent e) {
			                fireDocumentChangeEvent(sorter);
			            }
			            @Override public void changedUpdate(DocumentEvent e) { /* not needed */ }
			     });
			     fireDocumentChangeEvent(sorter );
				 styleTable(tablePath);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
