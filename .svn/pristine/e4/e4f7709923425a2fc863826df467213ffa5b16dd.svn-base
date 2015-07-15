package com.digitexx.ancestry.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
public class PanelListItem extends JPanel{
	private JList<String> jListChosenItem;
	private JList<String> jListAllItem;
	private JScrollPane scrollPaneAllItem;
	private JScrollPane scrollPaneChosenItem;
	private JButton buttonRightToLeft;
	private JButton buttonLeftToRight;
	private DefaultListModel<String> jListAllItemModel;
	private DefaultListModel<String> jListChosenItemModel;
	
	public PanelListItem()
	{
		initGUI();
	}
	
	public JList<String> getjListChosenItem() {
		return jListChosenItem;
	}

	public JList<String> getjListAllItem() {
		return jListAllItem;
	}

	public DefaultListModel<String> getjListChosenItemModel() {
		return jListChosenItemModel;
	}

	public DefaultListModel<String> getjListAllItemModel() {
		return jListAllItemModel;
	}

	private void initGUI() {
		try 
		{
			{
				AnchorLayout panelListItemLayout = new AnchorLayout();
				this.setPreferredSize(new java.awt.Dimension(747, 175));
				this.setLayout(panelListItemLayout);
				{
					scrollPaneAllItem = new JScrollPane();
					this.add(scrollPaneAllItem, new AnchorConstraint(31, 476, 968, 7, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					scrollPaneAllItem.setPreferredSize(new java.awt.Dimension(351, 164));
					{
						jListAllItemModel =  new DefaultListModel<String>();
						jListAllItem = new JList<String>();
						scrollPaneAllItem.setViewportView(jListAllItem);
						jListAllItem.setModel(jListAllItemModel);
						jListAllItem.setFont(new java.awt.Font("Tahoma", 0, 12));
						jListAllItem.setBorder(BorderFactory.createTitledBorder(null, "List All Path", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,14), new java.awt.Color(255,0,0)));
					}
				}
				{
					scrollPaneChosenItem = new JScrollPane();
					this.add(scrollPaneChosenItem, new AnchorConstraint(31, 995, 968, 526, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					scrollPaneChosenItem.setPreferredSize(new java.awt.Dimension(351, 164));
					{
						jListChosenItemModel = new DefaultListModel<String>();
						jListChosenItem = new JList<String>();
						scrollPaneChosenItem.setViewportView(jListChosenItem);
						jListChosenItem.setModel(jListChosenItemModel);
						jListChosenItem.setFont(new java.awt.Font("Tahoma", 0, 12));
						jListChosenItem.setBorder(BorderFactory.createTitledBorder(null, "Selected Path", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,14), new java.awt.Color(255,0,0)));
					}
				}
				{
					buttonLeftToRight = new JButton();
					this.add(buttonLeftToRight, new AnchorConstraint(340, 518, 482, 484, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonLeftToRight.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/digitexx/images/right.png")));
					buttonLeftToRight.setFont(new java.awt.Font("Tahoma", 0, 12));
					buttonLeftToRight.setPreferredSize(new java.awt.Dimension(25, 25));
					buttonLeftToRight.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							moveLeftToRight();
						}
					});
				}
				{
					buttonRightToLeft = new JButton();
					this.add(buttonRightToLeft, new AnchorConstraint(517, 518, 660, 484, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonRightToLeft.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/digitexx/images/left.png")));
					buttonRightToLeft.setFont(new java.awt.Font("Tahoma", 0, 12));
					buttonRightToLeft.setPreferredSize(new java.awt.Dimension(25, 25));
					buttonRightToLeft.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							moveRightToLeft();
						}
					});
				}
			
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void moveLeftToRight()
	{
		List<String> selectedValues = jListAllItem.getSelectedValuesList();
		if(selectedValues.size() == 0)
		{
			JOptionPane.showMessageDialog(this, " Please choose item ! ","Warning", JOptionPane.WARNING_MESSAGE);
			return;
		}
		for(String selectedValue : selectedValues)
		{
			jListChosenItemModel.addElement(selectedValue);
			jListAllItemModel.removeElement(selectedValue);
		}
		
	}
	
	private void moveRightToLeft()
	{
		List<String> selectedValues = jListChosenItem.getSelectedValuesList();
		if(selectedValues.size() == 0)
		{
			JOptionPane.showMessageDialog(this, " Please choose item ! ","Warning", JOptionPane.WARNING_MESSAGE);
			return;
		}
		for(String selectedValue : selectedValues)
		{
			jListAllItemModel.addElement(selectedValue);
			jListChosenItemModel.removeElement(selectedValue);
		}
		
	}
}
