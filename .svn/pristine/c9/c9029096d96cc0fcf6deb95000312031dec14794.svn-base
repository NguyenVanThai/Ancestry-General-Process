package com.digitexx.ancestry.component;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeSelectionModel;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.common.tree.DirExpansionListener;
import com.digitexx.common.tree.DirSelectionListener;
import com.digitexx.common.tree.FileNode;
import com.digitexx.common.tree.IconCellRenderer;
import com.digitexx.common.tree.IconData;
import com.digitexx.common.tree.TreeIconConst;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
/**
 * @author Le Quynh Nhu
 * 
 */
public class PanelTreeFolder extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;
	public JTree m_tree;
	public DefaultTreeModel m_model;
	public JTextField m_display;
	public DefaultMutableTreeNode top;
	private TreeIconConst treeIconConst;

	public PanelTreeFolder() {
		super();
		treeIconConst = new TreeIconConst();
		AnchorLayout thisLayout = new AnchorLayout();
		this.setLayout(thisLayout);
		setSize(200, 200);

		top = new DefaultMutableTreeNode(new IconData(treeIconConst.ICON_COMPUTER, null, "Computer"));

		DefaultMutableTreeNode node;
		File[] roots = File.listRoots();
		for (int k = 0; k < roots.length; k++) 
		{
			node = new DefaultMutableTreeNode(new IconData(treeIconConst.ICON_DISK, null, new FileNode(roots[k])));
			top.add(node);
			node.add(new DefaultMutableTreeNode(new Boolean(true)));
		}

		m_model = new DefaultTreeModel(top);
		m_tree = new JTree(m_model);

		m_tree.putClientProperty("JTree.lineStyle", "Angled");
		TreeCellRenderer renderer = new IconCellRenderer();
		m_tree.setCellRenderer(renderer);

		m_display = new JTextField();
		m_display.setEditable(false);
		
		m_tree.addTreeExpansionListener(new DirExpansionListener(m_model , m_display));
		m_tree.addTreeSelectionListener(new DirSelectionListener(m_display));

		m_tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		m_tree.setShowsRootHandles(true);
		m_tree.setEditable(false);
		m_tree.setRowHeight(30);

		JScrollPane s = new JScrollPane();
		s.getViewport().add(m_tree);
		m_tree.setFont(new java.awt.Font("Segoe UI",1,12));
		this.add(s, new AnchorConstraint(105, 1001, 1001, 1, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
		s.setPreferredSize(new java.awt.Dimension(400, 269));
		this.add(m_display, new AnchorConstraint(1, 1001, 105, 1, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
		m_display.setFont(new java.awt.Font("Segoe UI",1,12));
		m_display.setPreferredSize(new java.awt.Dimension(400, 31));

		WindowListener wndCloser = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		setVisible(true);
		initGUI();
	}

	private void initGUI() {
		try {
			setPreferredSize(new Dimension(400, 300));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	


}
