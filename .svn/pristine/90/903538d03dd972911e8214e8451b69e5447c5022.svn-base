package com.digitexx.ancestry.component;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

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
public class PanelTwoJListFinal extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JPanel panelLeft;
	private JButton buttonRemoveAll;
	private JPanel panelRight;
	private JButton buttonSelectOne;
	private JButton buttonSelectAll;
	private JLabel jLabel2;
	private JButton buttonRemoveOne;
	private JLabel jLabel1;
	private JList jListRight;
	private JList jListLeft;
	private JScrollPane scrollPaneRight;
	private JScrollPane scrollPaneLeft;
	private DefaultListModel<String> modelAll;
	private DefaultListModel<String> modelSelect;
	private JPanel panelCenter;
	private List<String> listAll = new ArrayList<String>();
	private List<String> listSelect = new ArrayList<String>();

	public PanelTwoJListFinal() {
		super();
		initGUI();
		initData();
	}
	
	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(678, 300));
			AnchorLayout thisLayout = new AnchorLayout();
			this.setLayout(thisLayout);
			{
				panelLeft = new JPanel();
				BorderLayout panelLeftLayout = new BorderLayout();
				panelLeft.setLayout(panelLeftLayout);
				this.add(panelLeft, new AnchorConstraint(1, 457, 1001, 2, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelLeft.setBorder(BorderFactory.createTitledBorder(null, "List All Path", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,14)));
				panelLeft.setPreferredSize(new java.awt.Dimension(309, 300));
				{
					scrollPaneLeft = new JScrollPane();
					panelLeft.add(scrollPaneLeft, BorderLayout.CENTER);
					{
						jListLeft = new JList();
						scrollPaneLeft.setViewportView(jListLeft);
						jListLeft.setFont(new java.awt.Font("Tahoma",0,14));
					}
				}
			}
			{
				panelRight = new JPanel();
				BorderLayout panelRightLayout = new BorderLayout();
				panelRight.setLayout(panelRightLayout);
				this.add(panelRight, new AnchorConstraint(1, 1000, 1001, 542, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelRight.setBorder(BorderFactory.createTitledBorder(null, "List Selected Paths", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,14)));
				panelRight.setPreferredSize(new java.awt.Dimension(311, 300));
				{
					scrollPaneRight = new JScrollPane();
					panelRight.add(scrollPaneRight, BorderLayout.CENTER);
					{
						jListRight = new JList();
						scrollPaneRight.setViewportView(jListRight);
						jListRight.setFont(new java.awt.Font("Tahoma",0,14));
					}
				}
			}
			{
				panelCenter = new JPanel();
				this.add(panelCenter, new AnchorConstraint(1, 544, 1001, 457, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				panelCenter.setLayout(new GridLayout(7,1));
				panelCenter.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelCenter.setPreferredSize(new java.awt.Dimension(59, 300));
				{
					jLabel1 = new JLabel();
					panelCenter.add(jLabel1);
				}
				{
					buttonSelectOne = new JButton();
					panelCenter.add(buttonSelectOne);
					buttonSelectOne.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/digitexx/image/right.png")));
					buttonSelectOne.addActionListener(this);
				}
				{
					buttonRemoveOne = new JButton();
					panelCenter.add(buttonRemoveOne);
					buttonRemoveOne.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/digitexx/image/left.png")));
					buttonRemoveOne.addActionListener(this);
				}
				{
					jLabel2 = new JLabel();
					panelCenter.add(jLabel2);
				}
				{
					buttonSelectAll = new JButton();
					panelCenter.add(buttonSelectAll);
					buttonSelectAll.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/digitexx/image/arrow-right-big.png")));
					buttonSelectAll.addActionListener(this);
				}
				{
					buttonRemoveAll = new JButton();
					panelCenter.add(buttonRemoveAll);
					buttonRemoveAll.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/digitexx/image/arrow-left-big.png")));
					buttonRemoveAll.addActionListener(this);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent evt) 
	{
		Object action = evt.getSource();
		if(action == buttonSelectOne) {
			select(false);
		}
		if(action == buttonRemoveOne) {
			removeSelect(false);
		}
		if(action == buttonSelectAll) {
			select(true);
		}
		if(action == buttonRemoveAll) {
			removeSelect(true);
		}
	}
	
	private void initData() 
	{
		modelAll   = new DefaultListModel<String>();
		modelSelect= new DefaultListModel<String>();
		listSelect = new ArrayList<String>();
		loadData(listAll , modelAll , jListLeft);
	}
	
	public void reloadData(List<String> listData) 
	{
		modelAll.removeAllElements();
		modelSelect.removeAllElements();
		listAll.clear();
		listSelect.clear();
		listAll.addAll(listData);
		loadData(listAll , modelAll , jListLeft);
	}
	
	private void loadData(List<String> listData , DefaultListModel<String> model , JList jlist)
	{
		if(listData.size() > 0) 
		{
			for (String str : listData) {
				model.addElement(str);
			}
			jlist.setModel(model);
		}
	}
	
	//=====================================================================================================================
	
	/**
	 * select path in jlist
	 */
	private void select(boolean isSelectAll) 
	{
        if(isSelectAll) 
        {
        	listSelect.addAll(listAll);
        	listAll.clear();
        }
        else 
        {
        	Object [] paths = jListLeft.getSelectedValues();
        	if(paths != null) 
        	{
        		for (Object obj : paths) {
        			listSelect.add(obj.toString());
        			listAll.remove(obj.toString());
				}
        	}
        }
        modelAll.removeAllElements();
        modelSelect.removeAllElements();
		loadData(listAll    , modelAll    , jListLeft);
		loadData(listSelect , modelSelect , jListRight);

	}
	
	/**
	 * remove select path in jlist
	 */
	private void removeSelect(boolean isSelectAll) 
	{
        if(isSelectAll) 
        {
        	listAll.addAll(listSelect);
        	listSelect.clear();
        }
        else 
        {
        	Object [] paths = jListRight.getSelectedValues();
        	if(paths != null) 
        	{
        		for (Object obj : paths) {
        			listAll.add(obj.toString());
        			listSelect.remove(obj.toString());
				}
        	}
        }
        modelAll.removeAllElements();
        modelSelect.removeAllElements();
		loadData(listAll    , modelAll    , jListLeft);
		loadData(listSelect , modelSelect , jListRight);
	}

	/**
	 * @return the listAll
	 */
	public List<String> getListAll() {
		return listAll;
	}

	/**
	 * @param listAll the listAll to set
	 */
	public void setListAll(List<String> listAll) {
		this.listAll = listAll;
	}

	/**
	 * @return the listSelect
	 */
	public List<String> getListSelect() {
		return listSelect;
	}

	/**
	 * @param listSelect the listSelect to set
	 */
	public void setListSelect(List<String> listSelect) {
		this.listSelect = listSelect;
	}
	
	//====================================================================
	
	


}
