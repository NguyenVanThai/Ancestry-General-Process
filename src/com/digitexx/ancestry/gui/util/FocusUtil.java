/**
 * 
 */
package com.digitexx.ancestry.gui.util;

import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 * @author lqnhu
 *
 */
public class FocusUtil {

    public static void setNextFocusable(JComponent component, final JComponent nextFocusable) {
            component.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0), "setNextFocusable");
            component.getActionMap().put("setNextFocusable", new AbstractAction() {
                    public void actionPerformed(ActionEvent e) {
                            nextFocusable.requestFocusInWindow();
                    }
            });
    }

    public static void setFocusOrder(JComponent... components) {
            for (int i = 0; i < components.length - 1; i++) {
                    setNextFocusable(components[i], components[i+1]);                       
            }
            setNextFocusable(components[components.length - 1], components[0]);                     
    }
    
	public static int getCurrentIndex() 
	{
		int index = 0;
		if (KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner().hasFocus()) {
			Component c = FocusUtil.getCurrentFocus();
			if (c.getName() != null) {
				index = Integer.parseInt(c.getName());
			}
		}
		return index;
	}
    
	public static Component findNextFocus() {
		Component c = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
		Container root = c.getFocusCycleRootAncestor();
		FocusTraversalPolicy policy = root.getFocusTraversalPolicy();
		Component nextFocus = policy.getComponentAfter(root, c);
		if (nextFocus == null) {
			nextFocus = policy.getDefaultComponent(root);
		}
		return nextFocus;
	}

	public static Component findPrevFocus() {
		Component c = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
		Container root = c.getFocusCycleRootAncestor();
		FocusTraversalPolicy policy = root.getFocusTraversalPolicy();
		Component prevFocus = policy.getComponentBefore(root, c);
		if (prevFocus == null) {
			prevFocus = policy.getDefaultComponent(root);
		}
		return prevFocus;
	}

	public static Component smartRequestFocus(Component component) {
		if (requestFocus(component))
			return component;

		if (component instanceof JComponent) {
			FocusTraversalPolicy policy = ((JComponent) component).getFocusTraversalPolicy();

			if (policy != null) {
				Component focusComponent = policy.getDefaultComponent((Container) component);

				if (focusComponent != null && requestFocus(focusComponent)) {
					return focusComponent;
				}
			}
		}

		if (component instanceof Container) {
			Component[] children = ((Container) component).getComponents();

			for (int i = 0; i < children.length; i++) {
				component = smartRequestFocus(children[i]);

				if (component != null)
					return component;
			}
		}

		return null;
	}

	public static boolean requestFocus(Component component) {
		return KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner() == component|| component.requestFocusInWindow();
	}
	
	public static Component getCurrentFocus() {
		return KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner() ;
	}
	
	public static List<Component> getAllComponents(final Container c) {
		Component[] comps = c.getComponents();
		List<Component> compList = new ArrayList<Component>();
		for (Component comp : comps) {
			compList.add(comp);
			if (comp instanceof Container) {
				compList.addAll(getAllComponents((Container) comp));
			}
		}
		return compList;
	}
	
	public static final int getComponentIndex(Component component) {
		if (component != null && component.getParent() != null) {
			Container c = component.getParent();
			for (int i = 0; i < c.getComponentCount(); i++) {
				if (c.getComponent(i) == component)
					return i;
			}
		}

		return -1;
	}
	
	public static Component findFirstComponentOfType(Component comp, Class c) {
		if (c.isInstance(comp))
			return comp;

		if (comp instanceof Container) {
			Container container = (Container) comp;
			for (int i = 0; i < container.getComponentCount(); i++) {
				Component comp2 = findFirstComponentOfType(
						container.getComponent(i), c);
				if (comp2 != null)
					return comp2;
			}
		}
		return null;
	}
}
