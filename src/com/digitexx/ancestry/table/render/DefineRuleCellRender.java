/**
 * 
 */
package com.digitexx.ancestry.table.render;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import com.digitexx.ancestry.bean.BeanDefineRule;
import com.digitexx.ancestry.util.StringUtil;
/**
 * @author lqnhu
 *
 */
@SuppressWarnings("serial")
public class DefineRuleCellRender extends DefaultTableCellRenderer {
    
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof BeanDefineRule) {
            BeanDefineRule country = (BeanDefineRule) value;
            setText(country.getRule_name());
        }else {
     
        	value = StringUtil.setNotNull(value);
            if(value.equals("")) {
            	setText("");
            }
        }

        setFont( new Font("Arial" , Font.PLAIN  , 16));
        return this;
    }
     
}
