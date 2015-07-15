package com.digitexx.ancestry.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;
import java.util.Vector;
import java.util.regex.PatternSyntaxException;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.digitexx.ancestry.gui.util.NumberOnly;
import com.digitexx.ancestry.gui.util.WrapEditorKit;
import com.digitexx.ancestry.table.model.SqlResultTableModel;
import com.digitexx.ancestry.table.render.EditValueCellRender;
import com.digitexx.ancestry.table.render.HighlightTableCellRenderer;

/**
 * @author lqnhu
 * 
 */
public class JTableUtil {

	private static final HighlightTableCellRenderer renderer = new HighlightTableCellRenderer();
    private static final Color WARNING_COLOR = new Color(255, 200, 200);
    
	public static void comboboxJtable(JTable table, String columName,List<String> listData, String tooltip) 
	{
		try {
			JComboBox comboBox = new JComboBox();
			int index = 0;
			for (String str : listData) {
				comboBox.insertItemAt(str, index);
				++index;
			}
			int idxCondition = table.getColumnModel().getColumnIndex(columName);
			TableColumn column =  table.getColumnModel().getColumn(idxCondition);
			comboBox.setFont(new Font("Arial" , Font.BOLD , 16));
			column.setCellEditor(new DefaultCellEditor(comboBox));
			DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
			renderer.setToolTipText(tooltip);
			column.setCellRenderer(renderer);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void alignCenter(JTable table, int column) {
	    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
	    rightRenderer.setHorizontalAlignment(JLabel.CENTER);
	    table.getColumnModel().getColumn(column).setCellRenderer(rightRenderer);
	}

	public static void addComboboxMinutesColumn(JTable tableData, int column) {
		TableColumn timeColumn = tableData.getColumnModel().getColumn(column);

		JComboBox comboBox = new JComboBox();
		boolean amPM = false;// false = am true = pm
		String mString = "AM";
		Integer startHour = 8;
		for (int i = 0; i < 24; i++) 
		{
			for (int j = 0; j < 12; j++) 
			{
				int minutes = j * 5;
				String minString;
				if (String.valueOf(minutes).length() == 1) {
					minString ="0" +  minutes ;
				} 
				else {
					minString = "" + minutes;
				}
				if (amPM) {
					mString = " PM";
				} else {
					mString = " AM";
				}
				String startTime = startHour + ":" + minString + mString;
				comboBox.addItem(startTime);
			}
			startHour++;
			if (startHour == 12) {
				amPM = !amPM;
			}
			if (startHour > 12) {
				startHour = 1;
			}

		}
		timeColumn.setCellEditor(new DefaultCellEditor(comboBox));
	}
	
	public static void mouseSelectHeaderRow(final JTable headerTable , final int columCheck)
	{
		  headerTable.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer() {

	            public Component getTableCellRendererComponent(JTable x, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

	                boolean selected = headerTable.getSelectionModel().isSelectedIndex(row);
	                Component component = headerTable.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(headerTable, value, false, false, -1, -2);
	                ((JLabel) component).setHorizontalAlignment(SwingConstants.CENTER);
	               
	                if (selected) 
	                {
	                    component.setFont(component.getFont().deriveFont(Font.BOLD));
	                    component.setForeground(Color.red);
	                    headerTable.setValueAt(Boolean.TRUE, row, columCheck);
	                }
	                else 
	                {
	                    component.setFont(component.getFont().deriveFont(Font.BOLD));
	                    component.setForeground(Color.BLUE);
	                    //headerTable.setValueAt(Boolean.FALSE, row, columCheck);
	                }
	                return component;
	            }
	        });
	}


	public static void setTableCellAlignment(int alignment, JTable table,int col) 
	{
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(alignment);
		for (int i = 0; i < table.getColumnCount() - col; i++) {
			table.setDefaultRenderer(table.getColumnClass(i), renderer);
		}
		table.updateUI();
	}

	public static void setPrefersizeColum(JTable tableData, int colum, int width) {
		TableColumnModel colModel = tableData.getColumnModel();
		colModel.getColumn(colum).setMinWidth(width);
		// colModel.getColumn(colum).setMaxWidth(width);
		colModel.getColumn(colum).setPreferredWidth(width);
	}
	
	public static void setFixedsizeColum(JTable tableData, int colum, int width) {
		TableColumnModel colModel = tableData.getColumnModel();
		colModel.getColumn(colum).setMinWidth(width);
		 colModel.getColumn(colum).setMaxWidth(width);
		colModel.getColumn(colum).setPreferredWidth(width);
	}

	public static void hidenColum(JTable tableData, int colum, int width) {
		TableColumnModel colModel = tableData.getColumnModel();
		colModel.getColumn(colum).setMinWidth(width);
		colModel.getColumn(colum).setMaxWidth(width);
		colModel.getColumn(colum).setPreferredWidth(width);
	}

	public static void visibleColum(JTable tableData, int colum, int width) {
		TableColumnModel colModel = tableData.getColumnModel();
		colModel.getColumn(colum).setMinWidth(width);
		colModel.getColumn(colum).setMaxWidth(width);
		colModel.getColumn(colum).setPreferredWidth(width);
	}

	public static void selectRow(JTable table, int row, boolean bScroll) {
		assert (row >= 0 && row < table.getRowCount());
		if (row >= 0 && row < table.getRowCount()) {
			table.setRowSelectionInterval(row, row);
			if (bScroll) {
				Rectangle rect = table.getCellRect(row, 0, true);
				table.scrollRectToVisible(rect);
			}
		}
	}

	public static void setTableHeaderCellRenderer(TableColumn tableCol) {
		tableCol.setHeaderRenderer(new DefaultTableCellRenderer() {
			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				if (table != null) {
					// TableCellRenderer renderer =
					// table.getTableHeader().getDefaultRenderer();
					JComponent c = (JComponent) table.getTableHeader()
							.getDefaultRenderer();
					setForeground(c.getForeground());
					setBackground(c.getBackground());
					setFont(c.getFont());
					setBorder(UIManager.getBorder("TableHeader.cellBorder"));
					// setBorder(c.getBorder());
				}
				setText(value != null ? value.toString() : "");
				// setBorder(UIManager.getBorder("TableHeader.cellBorder"));
				setHorizontalAlignment(JLabel.CENTER);
				return this;
			}
		});
	}

	public static void setTableHeaderCellRenderer(JTable table) {
		TableColumnModel colModel = table.getColumnModel();
		int i, anzahl = colModel.getColumnCount();
		for (i = 0; i < anzahl; i++)
			setTableHeaderCellRenderer(colModel.getColumn(i));
	}

	public static void autoAdjustColWidths(JTable table) {
		int i, j, h;
		for (i = 0; i < table.getColumnCount(); i++) {
			DefaultTableColumnModel colModel = (DefaultTableColumnModel) table
					.getColumnModel();
			TableColumn col = colModel.getColumn(i);
			int width = 4;
			TableCellRenderer renderer = col.getHeaderRenderer();
			if (renderer == null)
				renderer = table.getTableHeader().getDefaultRenderer();
			Component comp = renderer.getTableCellRendererComponent(table,
					col.getHeaderValue(), false, false, 0, i);
			width = comp.getPreferredSize().width + 4;
			for (j = 0; j < table.getRowCount(); j++) {
				if ((renderer = table.getCellRenderer(j, i)) == null)
					table.getDefaultRenderer(String.class);
				if ((h = renderer.getTableCellRendererComponent(table,
						table.getValueAt(j, i), false, false, j, i)
						.getPreferredSize().width + 4) > width)
					width = h;
			}
			col.setPreferredWidth(width);
		}
	}

	public static void scrollToPosition(JTable table, int insertRow) {
		Rectangle rectangle = table.getCellRect(insertRow, 1, true);
		table.scrollRectToVisible(rectangle);
	}

	public static void selectPositions(final JTable table, final int index0,
			final int index1) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				table.getSelectionModel().setSelectionInterval(index0, index1);
			}
		});
	}

	public static boolean isFirstToLastRow(TableModelEvent e) {
		return e.getFirstRow() == 0 && e.getLastRow() == Integer.MAX_VALUE;
	}

	public static void forceRowSelection(JTable table, MouseEvent evt) {
		if (table.getSelectedRows().length == 0) {
			if (SwingUtilities.isRightMouseButton(evt)) {
				int rowNumber = table.rowAtPoint(evt.getPoint());
				table.getSelectionModel().setSelectionInterval(rowNumber,
						rowNumber);
				table.getSelectionModel().setLeadSelectionIndex(rowNumber);
			}
		}
	}

	public static int[] getSelectedRows(JTable table) {
		int[] selectedRows = table.getSelectedRows();
		for (int i = 0; i < selectedRows.length; i++) {
			selectedRows[i] = table.convertRowIndexToModel(selectedRows[i]);
		}
		return selectedRows;
	}
	
	public static void removeRows(JTable jtable, int[] rows) {
		DefaultTableModel dtm = (DefaultTableModel) jtable.getModel();
		for (int i = rows.length - 1; i >= 0; i--) {
			dtm.removeRow(i);
		}
	}

	public static void removeAllRow(JTable jtable){
		DefaultTableModel dtm = (DefaultTableModel) jtable.getModel();
		for (int i = dtm.getRowCount() - 1; i >= 0; i--) {
				dtm.removeRow(i);
		}
	}
	
	public static void removeAllRow(JTable jtable , SqlResultTableModel model) {
		for (int i = model.getRowCount() - 1; i >= 0; i--) {
			model.removeRow(i);
		}
	}
	
	public static void fitTableColumns(JTable table) {
		JTableHeader header = table.getTableHeader();
		int rowCount = table.getRowCount();
		Enumeration columns = table.getColumnModel().getColumns();
		while (columns.hasMoreElements()) {
			TableColumn column = (TableColumn) columns.nextElement();
			int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
			int width = (int) table
					.getTableHeader()
					.getDefaultRenderer()
					.getTableCellRendererComponent(table,column.getIdentifier(), false, false, -1, col)
					.getPreferredSize().getWidth();

			for (int row = 0; row < rowCount; row++) {
				int preferedWidth = (int) table.getCellRenderer(row, col)
						.getTableCellRendererComponent(table,
						table.getValueAt(row, col), false, false, row,col).getPreferredSize().getWidth();
				width = Math.max(width, preferedWidth);
			}
			header.setResizingColumn(column);
			column.setWidth(width + table.getIntercellSpacing().width);
		}

	}
	public static void fitTableColumnsDB3(JTable table) {
		JTableHeader header = table.getTableHeader();
		int rowCount = table.getRowCount();
		Enumeration columns = table.getColumnModel().getColumns();
		while (columns.hasMoreElements()) {
			TableColumn column = (TableColumn) columns.nextElement();
			int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
			int width = (int) table
					.getTableHeader()
					.getDefaultRenderer()
					.getTableCellRendererComponent(table,column.getIdentifier(), false, false, -1, col)
					.getPreferredSize().getWidth();

			for (int row = 0; row < rowCount; row++) {
				int preferedWidth = (int) table.getCellRenderer(row, col)
						.getTableCellRendererComponent(table,
						table.getValueAt(row, col), false, false, row,col).getPreferredSize().getWidth();
				width = Math.max(width, preferedWidth);
			}
			header.setResizingColumn(column);
			column.setWidth(width + table.getIntercellSpacing().width+50);
			
			
		}

	}

	public static void fitTableColumns(JTable table, int[] columnWidths) {
		for (int i = 0; i < columnWidths.length; i++) {
			table.getColumnModel().getColumn(i)
					.setPreferredWidth(columnWidths[i]);
		}
	}

	public static BigDecimal calculateTotalForColumn(
			final TableModel tableModel, final int column) {
		int numRows = tableModel.getRowCount();
		BigDecimal total = new BigDecimal("0");
		for (int row = 0; row < numRows; row++) {
			Object value = tableModel.getValueAt(row, column);
			if (value instanceof BigDecimal) {
				BigDecimal decimalValue = (BigDecimal) value;
				total = total.add(decimalValue);
			} else {
				// Logger.logGeneralFailure("", ErrorCodes.GUI_ERROR, this);
			}
		}
		return total;
	}

	public static void deleteAllRows(final DefaultTableModel model) {
		for (int i = model.getRowCount() - 1; i >= 0; i--) {
			model.removeRow(i);
		}
	}

	public static void clearTable(final JTable table) {
		for (int i = 0; i < table.getRowCount(); i++)
			for (int j = 0; j < table.getColumnCount(); j++) {
				table.setValueAt("", i, j);
			}
	}

	public static void betterAddColumn(JTable table, Object headerLabel,Object[] values) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		TableColumn col = new TableColumn(model.getColumnCount());

		// Ensure that auto-create is off
		if (table.getAutoCreateColumnsFromModel()) {
			throw new IllegalStateException();
		}
		col.setHeaderValue(headerLabel);
		table.addColumn(col);
		model.addColumn(headerLabel.toString(), values);
	}

	public static Object getValueTable(JTable table, int colum) {
		int row = table.getSelectedRow();
		return table.getValueAt(row, colum);
	}

	public static Object getValueAtPont(JTable table, MouseEvent evt) {
		int rowClick = table.rowAtPoint(evt.getPoint());
		int colClick = table.columnAtPoint(evt.getPoint());
		return table.getValueAt(rowClick, colClick);
	}

	public static Object getValueByHeader(JTable table, String headerName) {
		int row = table.getSelectedRow();
		int idx = table.getColumnModel().getColumnIndex(headerName);
		return table.getValueAt(row, idx);
	}

	public static Object getValuesByHeader(JTable table, String headerName,int row) {
		int idx = table.getColumnModel().getColumnIndex(headerName);
		return table.getValueAt(row, idx);
	}

	public static String getValuesByHeaderName(JTable table, String headerName,int row) {
		String s = "";
		try {
			int idx = table.getColumnModel().getColumnIndex(headerName);
			s = StringUtil.setNotNull(table.getValueAt(row, idx).toString());
		} catch (NullPointerException ne) {
			s = "";
		}
		return s;
	}

	public static TableCellRenderer formatDateJtable() {
		TableCellRenderer tableCellRenderer = new DefaultTableCellRenderer() {

			SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");

			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				if (value instanceof Date) {
					value = f.format(value);
				}
				return super.getTableCellRendererComponent(table, value,
						isSelected, hasFocus, row, column);
			}
		};

		return tableCellRenderer;
	}

	public static void addHeaderRow(final JTable headerTable) {
		headerTable.getColumnModel().getColumn(0)
				.setCellRenderer(new TableCellRenderer() {

					public Component getTableCellRendererComponent(JTable x,
							Object value, boolean isSelected, boolean hasFocus,
							int row, int column) {

						boolean selected = headerTable.getSelectionModel()
								.isSelectedIndex(row);
						Component component = headerTable
								.getTableHeader()
								.getDefaultRenderer()
								.getTableCellRendererComponent(headerTable,
										value, false, false, -1, -2);
						((JLabel) component)
								.setHorizontalAlignment(SwingConstants.CENTER);

						if (selected) {
							component.setFont(component.getFont().deriveFont(
									Font.BOLD));
							component.setForeground(Color.red);

						} else {
							component.setFont(component.getFont().deriveFont(
									Font.BOLD));
							component.setForeground(Color.BLUE);
						}
						return component;
					}
				});
	}
	
	public static void addHeaderRowByValue(final JTable headerTable,
			final String fontName, final int fontSize, final int fontStyle) {
		headerTable.getColumnModel().getColumn(0)
				.setCellRenderer(new TableCellRenderer() {

					public Component getTableCellRendererComponent(JTable x,
							Object value, boolean isSelected, boolean hasFocus,
							int row, int column) {

						boolean selected = headerTable.getSelectionModel()
								.isSelectedIndex(row);
						Component component = headerTable
								.getTableHeader()
								.getDefaultRenderer()
								.getTableCellRendererComponent(headerTable,
										value, false, false, -1, -2);
						((JLabel) component)
								.setHorizontalAlignment(SwingConstants.CENTER);

						if (selected) {
							component.setFont(new java.awt.Font(fontName,
									fontStyle, fontSize));
							component.setForeground(Color.red);

						} else {
							component.setFont(component.getFont().deriveFont(
									Font.BOLD));
							component.setForeground(Color.BLUE);
						}
						return component;
					}
				});
	}

	public static void createBorderRow(final JTable table) {
		Border outside = new MatteBorder(2, 0, 2, 0, Color.RED);
		Border inside = new EmptyBorder(0, 2, 0, 2);
		final Border highlight = new CompoundBorder(outside, inside);

		for (int i = 1; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i)
					.setCellRenderer(new TableCellRenderer() {

						public Component getTableCellRendererComponent(
								JTable x, Object value, boolean isSelected,
								boolean hasFocus, int row, int column) {

							boolean selected = table.getSelectionModel()
									.isSelectedIndex(row);
							Component component = table
									.getTableHeader()
									.getDefaultRenderer()
									.getTableCellRendererComponent(table,
											value, false, false, -1, -2);
							((JLabel) component)
									.setHorizontalAlignment(SwingConstants.CENTER);

							if (selected) {
								component.setFont(component.getFont()
										.deriveFont(Font.PLAIN));
								component.setForeground(Color.black);

								JComponent jc = (JComponent) component;
								jc.setBorder(highlight);
							} else {
								component.setFont(component.getFont()
										.deriveFont(Font.PLAIN));
								component.setForeground(Color.BLACK);
							}
							return component;
						}
					});
		}

	}
	
	public static void setColorCellEdit(JTable tableData) 
	{
		for (int i = 1; i < tableData.getColumnCount(); i++) 
		{
			if(!tableData.getColumnName(i).equals("is_rework_field")) 
			{
				tableData.getColumnModel().getColumn(i).setCellRenderer(new EditValueCellRender());
			}
		}
	}
	
	public static void stopEditTable(JTable tableData){
		if(tableData.isEditing()) tableData.getCellEditor().stopCellEditing();
	}

	public static void listToTable(ArrayList<String> listData, JTable tbl,String[] header) {
		try {
			int col = header.length;
			DefaultTableModel dt = new DefaultTableModel(header, 0);

			if (listData.size() > 0) {
				String[] arrValues = new String[col];
				String tmp = "";

				for (int i = 0; i < listData.size(); i++) {
					tmp = "";
					tmp = listData.get(i).toString();
					arrValues = new String[] { (i + 1) + "", tmp, "", "", "",
							"", "", "FTP", "", "" };
					dt.addRow(arrValues);
				}
			}
			tbl.setModel(dt);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static void nestedListToTable(List<List<String>> listData,JTable tbl, String[] header) {
		DefaultTableModel dt;
		String[] values = null;
		List<String> listTmp = new ArrayList<String>();

		try {
			int col = header.length;
			dt = new DefaultTableModel(header, 0);

			if (listData.size() > 0) {
				for (int i = 0; i < listData.size(); i++) {
					listTmp = new ArrayList<String>();
					listTmp = listData.get(i);
					values = new String[col];

					for (int j = 0; j < values.length; j++) {
						values[j] = listTmp.get(j).toString();
					}

					dt.addRow(values);
				}
			}

			RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(dt);
			tbl.setRowSorter(sorter);
			tbl.setModel(dt);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static void listToTable(ArrayList<String> listData, JTable tbl,
			String[] header, DefaultTableModel dt) {
		try {
			int col = header.length;
			dt = new DefaultTableModel(header, 0);

			if (listData.size() > 0) {
				String[] arrValues = new String[col];
				String tmp = "";

				for (int i = 0; i < listData.size(); i++) {
					tmp = "";
					tmp = listData.get(i).toString();
					arrValues = new String[] { (i + 1) + "", tmp, "Browse" };
					dt.addRow(arrValues);
				}
			}
			tbl.setModel(dt);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
    private static void fireDocumentChangeEvent(TableRowSorter<? extends TableModel> sorter , JTextField txtSearch ) 
    {
    	try {
            txtSearch.setBackground(Color.WHITE);
            String pattern = Objects.toString(txtSearch.getText() ,"");
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
		} catch (Exception e) {
			e.printStackTrace();
		}

    }
	
	/**
	 * set search by textfield
	 */
	public static void setSortByText( final JTextField txtSearch ,DefaultTableModel model , JTable tableData) 
	{
		try 
		{
			final TableRowSorter<? extends TableModel> sorter = new TableRowSorter<>(model);
			tableData.setRowSorter(sorter);
			tableData.setDefaultRenderer(Object.class, renderer);
			txtSearch.getDocument().addDocumentListener(new DocumentListener() {
				@Override
				public void insertUpdate(DocumentEvent e) {
					fireDocumentChangeEvent(sorter, txtSearch);
				}

				@Override
				public void removeUpdate(DocumentEvent e) {
					fireDocumentChangeEvent(sorter, txtSearch);
				}

				@Override
				public void changedUpdate(DocumentEvent e) { /* not needed */
				}
			});
			fireDocumentChangeEvent(sorter, txtSearch);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void styleTable(JTable tableData , boolean isReorderColumn) {
		tableData.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JTableHeader header = tableData.getTableHeader();
		header.setForeground(Color.RED);
		if(tableData.getColumnCount() >1) {
			JTableUtil.addHeaderRow(tableData);
		}
		tableData.setFont(new Font("Tahoma", Font.PLAIN, 14));

		tableData.setShowGrid(true);
		tableData.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		tableData.setRowHeight(30);
		tableData.setRowHeight(30);
		if(isReorderColumn) {
			tableData.getTableHeader().setReorderingAllowed(false);
		}
	}
	
	public static void styleTableWithValue(JTable tableData , int width , int fontSize , boolean isReorderColumn) {
		tableData.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JTableHeader header = tableData.getTableHeader();
		header.setForeground(Color.RED);
		JTableUtil.addHeaderRow(tableData);
		tableData.setFont(new Font("Tahoma", Font.PLAIN, fontSize));

		tableData.setShowGrid(true);
		tableData.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
		tableData.setRowHeight(width);
		tableData.setRowHeight(width);
		if(isReorderColumn) {
			tableData.getTableHeader().setReorderingAllowed(false);
		}
	}
	
	/**
	 * add JTextPane to Jtable
	 */
	public static void addJTextPane(JTable tableData , int column) {
		tableData.getColumnModel().getColumn(column).setCellRenderer(new TableCellRenderer() {
	        public Component getTableCellRendererComponent(JTable table, final Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	            final JTextPane lab = new JTextPane();
	            lab.setText(value+"");
	            lab.setEditorKit(new WrapEditorKit());
	            lab.setFont(new Font("Arial" , Font.BOLD , 12));
	            return lab;
	        }
	    });
	}
	
	/**
	 * add JTextPane to Jtable
	 */
	public static void addJTextField(JTable tableData , int column) {
		tableData.getColumnModel().getColumn(column).setCellRenderer(new TableCellRenderer() {
	        public Component getTableCellRendererComponent(JTable table, final Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	            final JTextField lab = new JTextField();
	            lab.setText(value+"");
	            lab.setDocument(new NumberOnly());
	            lab.setFont(new Font("Arial" , Font.BOLD , 12));
	            return lab;
	        }
	    });
	}
	
	/**
	 * load data to jtable
	 */
	public static void loadListDataToGrid(JTable table,
			                             DefaultTableModel model ,
			                             String[] header , 
			                             List<String> listData ,
			                             boolean hasColumnNo,
			                             boolean hasColumCheck) 
	{
		 if(hasColumCheck) {
	         model = new DefaultTableModel(header , 0) {
                 Class[] types = new Class [] {  
                     java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class 
                 };  
        
                 public Class getColumnClass(int columnIndex) {  
                     return types [columnIndex];  
                 }  
         };
		 }else {
			 model = new DefaultTableModel(header , 0);
		 }
         int idx = 1;
         Object[] values;
         for (String str : listData) {
        	 if(hasColumnNo) {
        		 values = new Object [] { idx , str };
        	 }
        	 else if(hasColumCheck) {
        		 values = new Object [] { idx , str , Boolean.FALSE };
        	 }
        	 else {
        		 values = new Object [] { str };
        	 }
        	 model.addRow(values);
        	 ++idx;
		 }
         table.setModel(model);
	}
	
	
	/**
	 * load list object to jtable
	 */
	public static void loadListObjectToGrid(String [] arrHeader ,JTable table , List<Object[]> listData , JTextField txtSearhData  , boolean hasColumnNo) throws AncestryException {

		try 
		{
			JTableUtil.removeAllRow(table);
			DefaultTableModel model = new DefaultTableModel(arrHeader , 0);
			Object [] values = null ;
			
			if(listData.size() > 0) {
				int size = listData.get(0).length;
				if (hasColumnNo) {
					values = new Object[size + 1];
				} else {
					values = new Object[size];
				}
				
				int index = 1;
				for (Object[] tmp : listData) {
					if(hasColumnNo) 
					{
						values[0] = index;
						int i = 1;
						for (Object obj : tmp) {
							values[i] = obj;
							++i;
						}
						model.addRow(values);
					}
					else {
						model.addRow(tmp);
					}
					++index;
				}
			}
			table.setModel(model);
			if(txtSearhData != null) {
				JTableUtil.setSortByText(txtSearhData, model, table);
			}
		} 
		catch (Exception e) {
			throw new AncestryException("loadListObjectToGrid : "  + e.toString() , e);
		}

	}
	
	/**
	 * set header and data for Jtable by selected field
	 */
	public static void setHeaderAndData(DefaultTableModel model, ResultSet rs,String allField) 
	{
		List<String> listAllColumn = new ArrayList<String>();
		model.addColumn("No.");
		try {
			if(allField.equals("*"))
			{
				ResultSetMetaData rsmd = rs.getMetaData();
				String columName = "";
				for (int i = 1; i <= rsmd.getColumnCount(); i++) 
				{
					columName = rsmd.getColumnName(i);
					if(!columName.contains("_export") && !columName.equals("coordinates")) {
						listAllColumn.add(columName);
						model.addColumn(columName);
					}
				}
			}
			else
			{
				String [] fields = allField.split(",");
				for(String field : fields)
				{
					field = field.trim();
					listAllColumn.add(field);
					model.addColumn(field);
				}
				
			}
			int index = 0;
			String field = "";
			while(rs.next())
			{
				index ++;
				Vector<String> vector = new Vector<String>();
				vector.add(index+"");
				for(int i = 0; i < listAllColumn.size() ; i++){
					field = listAllColumn.get(i);
					vector.add(rs.getString(field));
				}
				model.addRow(vector);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * set header and data for Jtable from Resultset
	 */
	public static void setHeaderAndData(DefaultTableModel tableDataModel, ResultSet resultSet) 
	{
		List<String> listAllColumn = new ArrayList<String>();
		tableDataModel.addColumn("No.");
		try {
			
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) 
			{
				listAllColumn.add(resultSetMetaData.getColumnName(i));
				tableDataModel.addColumn(resultSetMetaData.getColumnName(i));
			}
			
			tableDataModel.addColumn("check");
			int index = 0;
			while(resultSet.next())
			{
				index ++;
				Vector<Object> vector = new Vector<Object>();
				vector.add(index);
				for(int i = 0; i < listAllColumn.size() ; i++){
					vector.add(resultSet.getObject(listAllColumn.get(i)));
				}
				vector.add(false);
				tableDataModel.addRow(vector);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	

}
