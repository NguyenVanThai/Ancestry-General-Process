/**
 * 
 */
package com.digitexx.ancestry.table.render;

import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

/**
 * @author lqnhu
 * 
 */
public class ComponentIcon implements Icon {
	private final JComponent cmp;

	public ComponentIcon(JComponent cmp) {
		this.cmp = cmp;
	}

	public int getIconWidth() {
		return cmp.getPreferredSize().width;
	}

	public int getIconHeight() {
		return cmp.getPreferredSize().height;
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		SwingUtilities.paintComponent(g, cmp, (Container) c, x, y,
				getIconWidth(), getIconHeight());
	}
}