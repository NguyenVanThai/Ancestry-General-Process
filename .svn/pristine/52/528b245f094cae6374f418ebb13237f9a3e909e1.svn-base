/**
 * 
 */
package com.digitexx.ancestry.table.render;

import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 * @author lqnhu
 *
 */
public class HeaderCheckBoxHandler implements TableModelListener {
    private final JTable table;
    private final int targetColumnIndex;
    public HeaderCheckBoxHandler(JTable table, int index) {
        this.table = table;
        this.targetColumnIndex = index;
    }
    @Override public void tableChanged(TableModelEvent e) {
        int vci = table.convertColumnIndexToView(targetColumnIndex);
        TableColumn column = table.getColumnModel().getColumn(vci);
        Object status = column.getHeaderValue();
        TableModel m = table.getModel();
        if (e.getType() == TableModelEvent.UPDATE && e.getColumn() == targetColumnIndex) {
            if (Status.INDETERMINATE.equals(status)) {
                boolean selected = true;
                boolean deselected = true;
                for (int i = 0; i < m.getRowCount(); i++) {
                    Boolean b = (Boolean) m.getValueAt(i, targetColumnIndex);
                    selected &= b;
                    deselected &= !b;
                    if (selected == deselected) {
                        return;
                    }
                }
                if (deselected) {
                    column.setHeaderValue(Status.DESELECTED);
                } else if (selected) {
                    column.setHeaderValue(Status.SELECTED);
                } else {
                    return;
                }
            } else {
                column.setHeaderValue(Status.INDETERMINATE);
            }
        }
        JTableHeader h = table.getTableHeader();
        h.repaint(h.getHeaderRect(vci));
    }
}
