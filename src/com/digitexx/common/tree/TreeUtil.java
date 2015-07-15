/**
 * 
 */
package com.digitexx.common.tree;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import com.digitexx.common.tree.FileNode;
import com.digitexx.common.tree.IconData;

/**
 * @author Le Quynh Nhu
 * 
 */
public class TreeUtil {

	public static DefaultMutableTreeNode getTreeNode(TreePath path) {
		return (DefaultMutableTreeNode) (path.getLastPathComponent());
	}

	public static FileNode getFileNode(DefaultMutableTreeNode node) {
		if (node == null)
			return null;
		Object obj = node.getUserObject();
		if (obj instanceof IconData)
			obj = ((IconData) obj).getObject();
		if (obj instanceof FileNode)
			return (FileNode) obj;
		else
			return null;
	}

	public static boolean isDescendant(TreePath path1, TreePath path2) {
		int count1 = path1.getPathCount();
		int count2 = path2.getPathCount();
		if (count1 <= count2)
			return false;
		while (count1 != count2) {
			path1 = path1.getParentPath();
			count1--;
		}
		return path1.equals(path2);
	}

	public static String getExpansionState(JTree tree, int row) {
		TreePath rowPath = tree.getPathForRow(row);
		StringBuffer buf = new StringBuffer();
		int rowCount = tree.getRowCount();
		for (int i = row; i < rowCount; i++) {
			TreePath path = tree.getPathForRow(i);
			if (i == row || isDescendant(path, rowPath)) {
				if (tree.isExpanded(path))
					buf.append("," + String.valueOf(i - row));
			} else
				break;
		}
		return buf.toString();
	}

	public static void restoreExpanstionState(JTree tree, int row,
			String expansionState) {
		StringTokenizer stok = new StringTokenizer(expansionState, ",");
		while (stok.hasMoreTokens()) {
			int token = row + Integer.parseInt(stok.nextToken());
			tree.expandRow(token);
		}
	}
	
	public static TreePath getPath(TreeNode treeNode) {
		List<Object> nodes = new ArrayList<Object>();
		if (treeNode != null) 
		{
			nodes.add(treeNode);
			treeNode = treeNode.getParent();
			while (treeNode != null) {
				nodes.add(0, treeNode);
				treeNode = treeNode.getParent();
			}
		}
		return nodes.isEmpty() ? null : new TreePath(nodes.toArray());
	}
	
	public static TreePath findByName(JTree tree, String[] names) {
		TreeNode root = (TreeNode) tree.getModel().getRoot();
		return find(tree, new TreePath(root), names, 0);
	}

	private static TreePath find(JTree tree, TreePath parent, Object[] nodes,int depth) {
		TreeNode node = (TreeNode) parent.getParentPath();
		Object o = node;

		if (o.equals(nodes[depth])) {
			if (depth == nodes.length - 1) {
				return parent;
			}
			if (node.getChildCount() >= 0) {
				for (Enumeration e = node.children(); e.hasMoreElements();) {
					TreeNode n = (TreeNode) e.nextElement();
					TreePath path = parent.pathByAddingChild(n);
					TreePath result = find(tree, path, nodes, depth + 1);
					if (result != null) {
						return result;
					}
				}
			}
		}
		return null;
	}
	
	public static TreePath findByString(DefaultMutableTreeNode root, String s) {
	    Enumeration<DefaultMutableTreeNode> e = root.depthFirstEnumeration();
	    while (e.hasMoreElements()) {
	        DefaultMutableTreeNode node = e.nextElement();
	        if (node.toString().equalsIgnoreCase(s)) {
	            return new TreePath(node.getPath());
	        }
	    }
	    return null;
	}
	
	public static DefaultMutableTreeNode addObjectByPath(Object child, String [] arrName, JTree m_tree,DefaultTreeModel m_model) {
		TreePath parentPath = findByName(m_tree , arrName);
		DefaultMutableTreeNode parentNode = null;
		parentNode = getTreeNode(parentPath);
		return addObject(parentNode, child, true , m_tree , m_model , parentNode );
	}

	public static DefaultMutableTreeNode addObject(Object child, JTree m_tree,DefaultTreeModel m_model, DefaultMutableTreeNode top) {
		DefaultMutableTreeNode parentNode = null;
		TreePath parentPath = m_tree.getSelectionPath();

		if (parentPath == null) {
			parentNode = top;
		} else {
			parentNode = (DefaultMutableTreeNode) (parentPath.getLastPathComponent());
		}
		return addObject(parentNode, child, true , m_tree , m_model , top );
	}

	public static DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,Object child , JTree m_tree ,
			  DefaultTreeModel m_model , DefaultMutableTreeNode top) {
		return addObject(parent, child, false , m_tree , m_model , top);
	}

	public static DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,
			Object child, boolean shouldBeVisible, JTree m_tree,
			DefaultTreeModel m_model, DefaultMutableTreeNode top) 
	{
		DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child);

		if (parent == null) {
			parent = top;
		}

		// It is key to invoke this on the TreeModel, and NOT
		// DefaultMutableTreeNode
		m_model.insertNodeInto(childNode, parent, parent.getChildCount());

		// Make sure the user can see the lovely new node.
		if (shouldBeVisible) {
			m_tree.scrollPathToVisible(new TreePath(childNode.getPath()));
		}
		return childNode;
	}
	
	  /** Remove the currently selected node. */
	  public static void removeCurrentNode(JTree m_tree,DefaultTreeModel m_model) 
	  {
	    TreePath currentSelection = m_tree.getSelectionPath();
	    if (currentSelection != null) 
	    {
	      DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) (currentSelection.getLastPathComponent());
	      MutableTreeNode parent = (MutableTreeNode) (currentNode.getParent());
	      if (parent != null) {
	    	  m_model.removeNodeFromParent(currentNode);
	        return;
	      }
	    }
	  }
	  
	public static List<TreeNode> findPath(TreeNode root, TreeNode leaf) {
		LinkedList<TreeNode> path = new LinkedList<TreeNode>();
		findPathHelper(root, leaf, path);
		return path;
	}

	private static boolean findPathHelper(TreeNode root, TreeNode leaf,
			List<TreeNode> path) {
		if (root == leaf) {
			path.add(root);
			return true;
		}

		for (TreeNode treeNode : path) {
			if (findPathHelper(treeNode, leaf, path)) {
				path.add(root);
				return true;
			}
		}
		return false;
	}
	
	public TreePath[] getPaths(JTree tree, boolean expanded) {
		TreeNode root = (TreeNode) tree.getModel().getRoot();
		List<TreePath> list = new ArrayList<TreePath>();
		getPaths(tree, new TreePath(root), expanded, list);

		return (TreePath[]) list.toArray(new TreePath[list.size()]);
	}

	public void getPaths(JTree tree, TreePath parent, boolean expanded,List<TreePath> list) {
		if (expanded && !tree.isVisible(parent)) {
			return;
		}
		list.add(parent);
		TreeNode node = (TreeNode) parent.getLastPathComponent();
		if (node.getChildCount() >= 0)
		{
			for (Enumeration e = node.children(); e.hasMoreElements();) {
				TreeNode n = (TreeNode) e.nextElement();
				TreePath path = parent.pathByAddingChild(n);
				getPaths(tree, path, expanded, list);
			}
		}
	}
		
	public static void expand(JTree tree) 
	{
		Enumeration<?> topLevelNodes = ((TreeNode) tree.getModel().getRoot()).children();
		while (topLevelNodes.hasMoreElements()) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) topLevelNodes.nextElement();
			tree.expandPath(new TreePath(node.getPath()));
		}
	}
	
	public static boolean expandAll(JTree tree, TreePath parent, boolean expand) 
	{
		TreeNode node = (TreeNode) parent.getLastPathComponent();
		if (node.getChildCount() > 0) 
		{
			boolean childExpandCalled = false;
			for (Enumeration e = node.children(); e.hasMoreElements();) 
			{
				TreeNode n = (TreeNode) e.nextElement();
				TreePath path = parent.pathByAddingChild(n);
				childExpandCalled = expandAll(tree, path, expand)|| childExpandCalled; 
			}
			if (!childExpandCalled) 
			{ 
				if (expand) {
					tree.expandPath(parent);
				} else {
					tree.collapsePath(parent);
				}
			}
			return true;
		} 
		else {
			return false;
		}
	}
}
