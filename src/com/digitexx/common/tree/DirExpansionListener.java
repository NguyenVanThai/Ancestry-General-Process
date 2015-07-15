/**
 * 
 */
package com.digitexx.common.tree;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 * @author lqnhu
 * 
 */
public class DirExpansionListener implements TreeExpansionListener 
{
	DefaultTreeModel m_model;
	JTextField m_display;
	public DirExpansionListener(DefaultTreeModel m_model,JTextField m_display) {
		this.m_model   = m_model;
		this.m_display = m_display;
	}
	
	public void treeExpanded(TreeExpansionEvent event) {
		final DefaultMutableTreeNode node = TreeUtil.getTreeNode(event.getPath());
		final FileNode fnode = TreeUtil.getFileNode(node);

		Thread runner = new Thread() {
			public void run() {
				if (fnode != null && fnode.expand(node)) {
					Runnable runnable = new Runnable() {
						public void run() {
							m_model.reload(node);
						}
					};
					SwingUtilities.invokeLater(runnable);
				}
			}
		};
		runner.start();
	}

	public void treeCollapsed(TreeExpansionEvent event) {
	}
}