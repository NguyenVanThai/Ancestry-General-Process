package com.digitexx.ancestry.table.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import com.digitexx.ancestry.bean.BeanEditTable;

/**
 * @author lqnhu
 * 
 */
public class DynamicTableModel extends DefaultTableModel {

	private static final long serialVersionUID = -1906953078171818239L;
	protected ArrayList<String> listColumnNames;
	protected ArrayList<Class<?>> listColumnClasses;
	protected ArrayList<ArrayList<Object>> values;
	protected String[] arrayEditColum;
	protected int columnCount = 0;
	private short[][] editable;
	public HashMap<String, BeanEditTable> mapEdit = new HashMap<String, BeanEditTable>();
	private BeanEditTable beanEdit;
	private JTable tableBinding;

	public DynamicTableModel() {

		listColumnNames = new ArrayList<String>();
		listColumnClasses = new ArrayList<Class<?>>();
		values = new ArrayList<ArrayList<Object>>();

		values  = new ArrayList<ArrayList<Object>>();
		mapEdit = new HashMap<String, BeanEditTable>();
	}

	public void processEditable(ArrayList<String> listColumsNotEdit,
			Object[][] data) {
		int size = listColumsNotEdit.size();
		data = new Object[size][3];
		editable = new short[size][3];

		for (int i = 0; i < size; i++) {
			data[i][0] = new Boolean(true);
			editable[i][0] = 1;

			data[i][1] = listColumsNotEdit.get(i);
			editable[i][1] = 0;

			data[i][2] = listColumsNotEdit.get(i);
			editable[i][2] = 1;
		}
	}

	public DynamicTableModel(String[] columnNames, Class<?>[] columnClasses) {
		this();
		setTableMeta(columnNames, columnClasses);
	}

	public void setTableMeta(String[] columnNames, Class<?>[] columnClasses) {
		this.listColumnNames.addAll(Arrays.asList(columnNames));
		this.listColumnClasses.addAll(Arrays.asList(columnClasses));
		columnCount = listColumnNames.size();
		fireTableStructureChanged();
	}

	public void setColumnName(int column, String columnName) {
		listColumnNames.set(column, columnName);
		fireTableStructureChanged();
	}

	public void setColumnClass(int column, Class<?> columnClass) {
		listColumnClasses.set(column, columnClass);
		fireTableStructureChanged();
	}

	public void addColumn(String columnName, Class<?> columnClass) {
		listColumnNames.add(columnName);
		listColumnClasses.add(columnClass);
		columnCount = listColumnNames.size();
		fireTableStructureChanged();
	}

	public void removeColumn(int index) {
		listColumnNames.remove(index);
		columnCount = listColumnNames.size();
		fireTableStructureChanged();
	}

	public void removeDataJtable() {
		for (int i = getRowCount() - 1; i >= 0; i--) {
			removeRow(i);
		}
	}

	public void addRow(ArrayList<Object> row) {
		values.add(row);
		int size = values.size();
		fireTableRowsInserted(size - 1, size - 1);
	}

	public void addRow(Object[] row) {

		ArrayList<Object> val = new ArrayList<Object>();
		for (int i = 0; i < row.length; i++) {
			val.add(row[i]);
		}
		addRow(val);
	}

	public void removeRow(int rowIndex) {
		values.remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);
	}

	public void removeRows(int startIndex, int endIndex) {
		for (int i = startIndex; i <= endIndex; i++) {
			values.remove(i);
		}
		fireTableRowsDeleted(startIndex, endIndex);
	}
	
	public void removeAllRows() {
		DefaultTableModel dtm = (DefaultTableModel) tableBinding.getModel();
		for (int i = dtm.getRowCount() - 1; i >= 0; i--) {
			dtm.removeRow(i);
		}
	}

	public ArrayList<Object> getRow(int index) {
		return values.get(index);
	}

	/**
	 * searches for find in each row at column searchColumnIndex and returns if
	 * found if not found a new row is created and added to the end of values
	 * 
	 * @param searchColumnIndex
	 * @param find
	 * @return
	 */
	public ArrayList<Object> findRowOrCreate(int searchColumnIndex, Object find) {

		ArrayList<Object> row = null;
		for (int i = 0; i < values.size(); i++) {
			row = values.get(i);
			if (row == null) {
				continue;
			}
			Object o = row.get(searchColumnIndex);
			if ((o != null) && o.equals(find)) {
				break;
			}
		}

		if (row == null) // object not found
		{
			createEmptyRow();
		}
		return row;

	}

	/**
	 * @return
	 */
	public ArrayList<Object> createEmptyRow() {
		ArrayList<Object> row = new ArrayList<Object>();
		for (int i = 0; i < columnCount; i++) {
			if (listColumnClasses.get(i).equals(Integer.class)) {
				row.add(0);
			} else if (listColumnClasses.get(i).equals(Double.class)) {
				row.add(0.0);
			} else if (listColumnClasses.get(i).equals(String.class)) {
				row.add("");
			} else if (listColumnClasses.get(i).equals(Date.class)) {
				row.add("");
			} else if (listColumnClasses.get(i).equals(Object.class)) {
				row.add("");
			} else if (listColumnClasses.get(i).equals(Timestamp.class)) {
				row.add("");
			} else {
				row.add("");
			}
		}
		addRow(row);
		return row;
	}

	/**
	 * @return
	 */
	public ArrayList<Object> createEmptyRow(String str) {

		if (!str.equals("empty")) {
			return null;
		}
		ArrayList<Object> row = new ArrayList<Object>();
		for (int i = 0; i < columnCount; i++) {
			row.add("");
		}
		addRow(row);
		return row;
	}

	public ArrayList<ArrayList<Object>> findRows(int searchColumnIndex,
			Object find) {

		ArrayList<ArrayList<Object>> found = new ArrayList<ArrayList<Object>>();
		for (int i = 0; i < values.size(); i++) {
			ArrayList<Object> row = values.get(i);
			if (row == null) {
				continue;
			}
			Object o = row.get(searchColumnIndex);
			if ((o != null) && o.equals(find)) {
				found.add(row);
			}
		}
		return found;
	}

	public void clear() {
		values.clear();
		fireTableDataChanged();
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Object valueBefore = setNotNull(values.get(rowIndex).get(columnIndex));
		int idxManaId = tableBinding.getColumnModel().getColumnIndex("management_id");
		int idxField  = tableBinding.getColumnModel().getColumnIndex("field");
		int idxSeq    = tableBinding.getColumnModel().getColumnIndex("seq_number");
		
		if (!valueBefore.equals(aValue)) 
		{
			beanEdit = new BeanEditTable();
			beanEdit.setColumnName(tableBinding.getValueAt(rowIndex, idxField)+"");
			beanEdit.setId(tableBinding.getValueAt(rowIndex, idxManaId).toString());
			beanEdit.setNewValue(aValue.toString());
			beanEdit.setOldValue(valueBefore.toString());
			beanEdit.setColumNameId(tableBinding.getColumnName(idxManaId));
			beanEdit.setSeq_number(Integer.parseInt(tableBinding.getValueAt(rowIndex, idxSeq).toString()));
			
			mapEdit.put(rowIndex + "-" + getTableBinding().getSelectedColumn(),beanEdit);
		}
		values.get(rowIndex).set(columnIndex, aValue);
		fireTableCellUpdated(rowIndex, columnIndex);
	}

	public int getRowCount() {
		if (values != null) {
			return values.size();
		} else {
			return 0;
		}
	}

	public int getColumnCount() {
		return columnCount;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Object val = null;
		ArrayList<Object> row = values.get(rowIndex);
		val = row.get(columnIndex);
		return val;
	}

	@Override
	public String getColumnName(int column) {
		return listColumnNames.get(column);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return listColumnClasses.get(columnIndex);
	}

	public void setEditable(int row, int col, short editability) {
		editable[row][col] = editability;
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		boolean flag = true;
		if (getArrayEditColum() != null && getArrayEditColum().length > 0) {
			List listColumn = Arrays.asList(getArrayEditColum());
			if (listColumn.contains(getColumnName(col))) {
				flag = false;
			} else {
				flag = true;
			}
		}
		return flag;
	}

	private Object setNotNull(Object obj) {
		if (obj == null) {
			return "";
		} else {
			return obj.toString().trim();
		}
	}

	public void clearMapEdit() {
		mapEdit.clear();
	}

	// ====================================================================================================================

	public String[] getArrayEditColum() {
		return arrayEditColum;
	}

	public void setArrayEditColum(String[] arrayEditColum) {
		this.arrayEditColum = arrayEditColum;
	}

	/**
	 * @return the tableBinding
	 */
	public JTable getTableBinding() {
		return tableBinding;
	}

	/**
	 * @param tableBinding
	 *            the tableBinding to set
	 */
	public void setTableBinding(JTable tableBinding) {
		this.tableBinding = tableBinding;
	}

}
