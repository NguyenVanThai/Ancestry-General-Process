/**
 * 
 */
package com.digitexx.ancestry.table.render;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.event.MouseInputListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 * @author lqnhu
 *
 */
public class DragHook implements MouseInputListener {

    private JTableHeader header;
    private MouseListener mouseDelegate;
    private MouseMotionListener mouseMotionDelegate;
    private int maxX;
    private String columnName;

    public DragHook(JTableHeader header , String columnName) {
        this.header = header;
        this.columnName = columnName;
        installHook();
    }

    /**
     * Implemented to do some tweaks/bookkeeping before/after
     * passing the event to the original
     * 
     * - temporarily disallow reordering if hit on first column
     * - calculate the max mouseX that's allowable in dragging to the left
     * 
     */
    @Override
    public void mousePressed(MouseEvent e) {
        int index = header.columnAtPoint(e.getPoint());
        boolean reorderingAllowed = header.getReorderingAllowed();
        if (index == 0) {
            // temporarily disable re-ordering 
            header.setReorderingAllowed(false);
        }
        mouseDelegate.mousePressed(e);
        header.setReorderingAllowed(reorderingAllowed);
        if (header.getDraggedColumn() != null) {
            Rectangle r = header.getHeaderRect(index);
            maxX = header.getColumnModel().getColumn(0).getWidth() 
                    + e.getX() - r.x -1; 
        }
    }

    /**
     * Implemented to pass the event to the original only if the
     * mouseX doesn't lead to dragging the column over the first.
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        TableColumn dragged = header.getDraggedColumn();
        //int index = getViewIndexForColumn(header.getColumnModel(), dragged);
        // dragged column is at second position, allow only drags to the right
        int indexColumn = header.getColumnModel().getColumnIndex(columnName);
        if (indexColumn == 1) {
            if (e.getX() < maxX) return;
        }
        mouseMotionDelegate.mouseDragged(e);
    }

    //-------- delegating-only methods

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseDelegate.mouseReleased(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        mouseDelegate.mouseClicked(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        mouseDelegate.mouseEntered(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouseDelegate.mouseExited(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseMotionDelegate.mouseMoved(e);
    }

    //------------ un-/install listeners

    protected void installHook() {
        installMouseHook();
        installMouseMotionHook();
    }

    protected void installMouseMotionHook() {
        MouseMotionListener[] listeners = header.getMouseMotionListeners();
        for (int i = 0; i < listeners.length; i++) {
            MouseMotionListener l = listeners[i];
            if (l.getClass().getName().contains("TableHeaderUI")) {
                this.mouseMotionDelegate = l;
                listeners[i] = this;
            }
            header.removeMouseMotionListener(l);
        }
        for (MouseMotionListener l : listeners) {
            header.addMouseMotionListener(l);
        }
    }

    protected void installMouseHook() {
        MouseListener[] listeners = header.getMouseListeners();
        for (int i = 0; i < listeners.length; i++) {
            MouseListener l = listeners[i];
            if (l.getClass().getName().contains("TableHeaderUI")) {
                this.mouseDelegate = l;
                listeners[i] = this;
            }
            header.removeMouseListener(l);
        }
        for (MouseListener l : listeners) {
            header.addMouseListener(l);
        }
    }

    public void uninstallHook() {
        uninstallMouseHook();
        uninstallMouseMotionHook();
    }

    protected void uninstallMouseMotionHook() {
        MouseMotionListener[] listeners = header.getMouseMotionListeners();
        for (int i = 0; i < listeners.length; i++) {
            MouseMotionListener l = listeners[i];
            if (l == this) {
                listeners[i] = mouseMotionDelegate;
            }
            header.removeMouseMotionListener(l);
        }
        for (MouseMotionListener l : listeners) {
            header.addMouseMotionListener(l);
        }
    }

    protected void uninstallMouseHook() {
        MouseListener[] listeners = header.getMouseListeners();
        for (int i = 0; i < listeners.length; i++) {
            MouseListener l = listeners[i];
            if (l == this) {
                listeners[i] = mouseDelegate;
            }
            header.removeMouseListener(l);
        }
        for (MouseListener l : listeners) {
            header.addMouseListener(l);
        }
    }

}
