/**
 * 
 */
package com.digitexx.ancestry.table.render;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import com.digitexx.ancestry.util.JTableUtil;
import com.digitexx.ancestry.util.StringUtil;

/**
 * @author lqnhu
 *
 */
public class CompareCellRender extends DefaultTableCellRenderer  
{
	private static final long serialVersionUID = 1L;
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        String value_db3 = StringUtil.setNotNull(JTableUtil.getValuesByHeaderName(table, "value_db3", row));
        String value_dpo = StringUtil.setNotNull(JTableUtil.getValuesByHeaderName(table, "value_dpo", row));
        if(table.getValueAt(row, column).equals("Y")){
            cellComponent.setBackground(Color.YELLOW);
        } else if(table.getValueAt(row, column).equals("N")){
            cellComponent.setBackground(Color.GRAY);
        }
        return cellComponent;
    }
}
