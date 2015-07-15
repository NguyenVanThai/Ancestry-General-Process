/**
 * 
 */
package com.digitexx.common.tree;

import javax.swing.JTextField;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * @author lqnhu
 * 
 */
public class DirSelectionListener implements TreeSelectionListener 
{
	JTextField m_display;

	public DirSelectionListener(JTextField m_display) {
		this.m_display = m_display;
	}

	public void valueChanged(TreeSelectionEvent event) {
		DefaultMutableTreeNode node = TreeUtil.getTreeNode(event.getPath());
		FileNode fnode = TreeUtil.getFileNode(node);
		if (fnode != null)
			m_display.setText(fnode.getFile().getAbsolutePath());
		else
			m_display.setText("");
	}
}