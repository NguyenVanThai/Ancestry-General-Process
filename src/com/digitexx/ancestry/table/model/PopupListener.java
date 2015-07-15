/**
 * 
 */
package com.digitexx.ancestry.table.model;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPopupMenu;
import javax.swing.JTable;

/**
 * @author lqnhu
 *
 */
public class PopupListener extends MouseAdapter {

    private JPopupMenu popup;
    private JTable table;

    public PopupListener(JPopupMenu popupMenu , JTable table) {
        popup = popupMenu;
        this.table = table;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        maybeShowPopup(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {
        maybeShowPopup(e);
    }

    private void maybeShowPopup(MouseEvent e) {
        if (e.isPopupTrigger()) {
            popup.show(e.getComponent(), e.getX(), e.getY());
        }
    }
}