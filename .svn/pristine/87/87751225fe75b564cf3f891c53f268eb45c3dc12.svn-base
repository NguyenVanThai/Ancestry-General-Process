/**
 * 
 */
package com.digitexx.ancestry.table.render;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

import com.digitexx.ancestry.table.model.DynamicTableModel;

/**
 * @author lqnhu
 *
 */
public class EditValueCellRender extends DefaultTableCellRenderer 
{
	private static final long serialVersionUID = 7425607685176573693L;

	@Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        setOpaque(isSelected);
		TableModel model = table.getModel();
		if (model instanceof DynamicTableModel) 
		{
			DynamicTableModel myModel = (DynamicTableModel) model;
			if(!table.getColumnName(column).equals("is_rework_field")) 
			{
				if (myModel.mapEdit.size() > 0) 
				{
					if (myModel.mapEdit.containsKey(row + "-" + column)) {
						if (!isSelected) {
							setBackground(Color.YELLOW);
							setOpaque(true);
						}
					}
				}
			}

		}
		return this;
	}
}
