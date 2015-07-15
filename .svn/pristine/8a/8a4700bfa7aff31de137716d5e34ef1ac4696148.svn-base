package com.digitexx.ancestry.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class TableModelUtil {

	public static void setHeaderAndData(DefaultTableModel tableDataModel, ResultSet resultSet,String listField) 
	{
		List<String> listAllColumn = new ArrayList<String>();
		tableDataModel.addColumn("No.");
		try {
			if(listField.equals("*"))
			{
				ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
				for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) 
				{
					listAllColumn.add(resultSetMetaData.getColumnName(i));
					tableDataModel.addColumn(resultSetMetaData.getColumnName(i));
				}
			}
			else
			{
				String [] fields = listField.split(",");
				for(String field : fields)
				{
					field = field.trim();
					listAllColumn.add(field);
					tableDataModel.addColumn(field);
				}
				
			}
			int index = 0;
			while(resultSet.next())
			{
				index ++;
				Vector<Object> vector = new Vector<Object>();
				vector.add(index);
				for(int i = 0; i < listAllColumn.size() ; i++){
					vector.add(resultSet.getObject(listAllColumn.get(i)));
				}
				tableDataModel.addRow(vector);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
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
