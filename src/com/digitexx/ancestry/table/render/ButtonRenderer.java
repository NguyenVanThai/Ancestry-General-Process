/**
 * 
 */
package com.digitexx.ancestry.table.render;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * @author lqnhu
 *
 */
@SuppressWarnings("serial")
public class ButtonRenderer extends JButton implements TableCellRenderer {

	String headerName;

	public ButtonRenderer(String headerName) {
	    this.setFont(new Font ("Arial" , 1 , 14));
	    this.headerName = headerName;
	  }

	  public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) {
	    value = headerName;
	    setText((value == null) ? headerName : value.toString());
	    return this;
	  }
	}
