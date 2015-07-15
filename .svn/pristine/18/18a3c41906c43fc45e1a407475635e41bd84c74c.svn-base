package com.digitexx.ancestry.table.model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author lqnhu
 *
 */
public class SqlResultTableModel extends DynamicTableModel {

	private static final long serialVersionUID = 1684181012782741249L;
	//private int numRows = 0;
    private int numColumns = 0;
    private Class<?>[] columnClasses = null;
    private String[] columnNames = null;
    private String[] columnNameReplacement = null;

    public SqlResultTableModel() {
        super();
    }

	public Class getColumnClass(int column) {
        Class returnValue = Object.class;
        try {
      	  if ((column >= 0) && (column < getColumnCount())) {
      		  returnValue = getValueAt(0, column).getClass();
      	  } else {
      		  returnValue = Object.class;
      	  }
			
        } catch (Exception e) {
      	  return returnValue;
        }
        return returnValue;
      }

    
    /**
     * @param columnNameReplacement the columnNameReplacement to set
     */
    public void setColumnNameReplacement(String[] columnNameReplacement) {
        this.columnNameReplacement = columnNameReplacement;
    }

    public void setResultSet(ResultSet resultSet, String[] columnNameReplacement) throws SQLException {
        setColumnNameReplacement(columnNameReplacement);
        setResultSet(resultSet);
    }

    /**
     * @param resultSet the resultSet to set
     * @throws SQLException
     */
	public void setResultSet(ResultSet resultSet)
	{
		try {
			numColumns = 0;
			if (resultSet == null) 
			{
				return;
			}
			ResultSetMetaData meta = resultSet.getMetaData();
			numColumns = meta.getColumnCount();
			Class<?>[] cClasses = createClasses(meta);
			String[] cNames = createColumnNames(meta);

			if (hasMetaChanged(cClasses, cNames)) 
			{
				columnClasses = cClasses;
				columnNames = cNames;
				setTableMeta(cNames, cClasses);
			}
			addResults(resultSet);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

    /**
     * @param cClasses
     * @param cNames
     * @return
     */
    private boolean hasMetaChanged(Class<?>[] cClasses, String[] cNames) {

        if ((columnClasses == null) || (columnClasses.length != cClasses.length)) {
            return true;
        }

        if ((columnNames == null) || (columnNames.length != cNames.length)) {
            return true;
        }

        int o = cClasses.length - 1;

        for (int i = o; i >= 0; i--) {
            if (!columnClasses[i].equals(cClasses[i])) {
                return true;
            }
        }
        for (int i = o; i >= 0; i--) {
            if (!columnNames[i].equals(cNames[i])) {
                return true;
            }
        }
        return false;
    }

    private String[] createColumnNames(ResultSetMetaData meta) throws SQLException {

        int numColumns = meta.getColumnCount()+1;
        String[] names = new String[numColumns];
        names[0] = "No.";
        for (int i = 1; i < numColumns; i++) {

            if ((columnNameReplacement != null) && (i < columnNameReplacement.length)) {
                names[i] = columnNameReplacement[i];
            } else {
                names[i] = meta.getColumnName(i);
            }
        }
        return names;
    }

    private Class<?>[] createClasses(ResultSetMetaData meta) throws SQLException {

        int numColumns = meta.getColumnCount()+1;
        Class<?>[] classes = new Class<?>[numColumns];
        classes[0] = Integer.class;
        for (int i = 1; i < numColumns; i++) 
        {
            try 
            {
                classes[i] = Class.forName(meta.getColumnClassName(i));
            } 
            catch (Exception e) {

                System.out.println("Class not found for " + meta.getColumnClassName(i));
                classes[i] = String.class;
            }
        }
        return classes;
    }

    /**
     * @param resultSet2
     * @throws SQLException
     */
    private void addResults(ResultSet resultSet)
    {
    	try
    	{
            ArrayList<Object> t = new ArrayList<Object>();
            t.clear();
            int auto = 0;
            while (resultSet.next())
            {
                t = createEmptyRow();
                t.set(0, ++auto);
                for (int i = 1; i <= numColumns; i++) 
                {
                    t.set(i, resultSet.getObject(i));
                }
            }
            values.add(t);
            values.remove(getNumRows()-1);
            fireTableDataChanged();
    	}
        catch(SQLException ex)
        {
        	ex.printStackTrace();
        }
    }
    

    /**
     * @return the numRows
     */
    public int getNumRows() {
        return values.size();
    }

    
    
}
