/**
 * 
 */
package com.digitexx.ancestry.table.render;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTable;

/**
 * @author lqnhu
 *
 */
public class ButtonEditor extends DefaultCellEditor 
{
	private static final long serialVersionUID = -7245380900034122108L;
	protected JButton button;
	private String label;
	private boolean isPushed;
	private JFrame frame;
	private String headerName;

	public ButtonEditor( String headerName ,JCheckBox checkBox , JFrame frame ) 
	{
	    super(checkBox);
	    this.frame = frame;
	    this.headerName = headerName;
	    button = new JButton();
	    button.setFont(new Font ("Arial" , 1 , 14));
	    button.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        fireEditingStopped();
	      }
	    });
	  }

	 public Component getTableCellEditorComponent(JTable table, Object value,boolean isSelected, int row, int column)
	 {
	    label = (value == null) ? headerName : value.toString();
	    button.setText(label);
	    isPushed = true;
	    return button;
	  }

	 public Object getCellEditorValue() 
	 {
	    isPushed = false;
	    return new String(label);
	 }

	 public boolean stopCellEditing() {
	    isPushed = false;
	    return super.stopCellEditing();
	 }

	 protected void fireEditingStopped() {
	    super.fireEditingStopped();
	 }
}

