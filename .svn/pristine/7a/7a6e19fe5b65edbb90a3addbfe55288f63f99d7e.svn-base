package com.digitexx.ancestry.gui;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
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
@SuppressWarnings("serial")
public class FrmViewLogPMS extends javax.swing.JFrame {
	private JPanel panelHeader;
	private JPanel panelContent;
	private JTable tableLog;
	private JTextField textFieldSearch;
	private JLabel labelTitleSearch;
	private JScrollPane scrollPaneContent;

	public FrmViewLogPMS() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				panelHeader = new JPanel();
				AnchorLayout panelHeaderLayout = new AnchorLayout();
				getContentPane().add(panelHeader);
				panelHeader.setBounds(0, 0, 704, 26);
				panelHeader.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				panelHeader.setLayout(panelHeaderLayout);
				{
					labelTitleSearch = new JLabel();
					panelHeader.add(labelTitleSearch, new AnchorConstraint(96, 90, 942, 3, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					labelTitleSearch.setText("Search");
					labelTitleSearch.setFont(new java.awt.Font("Arial",1,16));
					labelTitleSearch.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					labelTitleSearch.setPreferredSize(new java.awt.Dimension(61, 22));
				}
				{
					textFieldSearch = new JTextField();
					panelHeader.add(textFieldSearch, new AnchorConstraint(96, 997, 942, 90, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					textFieldSearch.setFont(new java.awt.Font("Arial",0,16));
					textFieldSearch.setPreferredSize(new java.awt.Dimension(639, 22));
				}
			}
			{
				panelContent = new JPanel();
				BorderLayout panelContentLayout = new BorderLayout();
				panelContent.setLayout(panelContentLayout);
				getContentPane().add(panelContent);
				panelContent.setBounds(0, 26, 704, 470);
				panelContent.setEnabled(false);
				panelContent.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				{
					scrollPaneContent = new JScrollPane();
					panelContent.add(scrollPaneContent, BorderLayout.CENTER);
					{
						tableLog = new JTable();
						scrollPaneContent.setViewportView(tableLog);
					}
				}
			}
			pack();
			this.setSize(712, 530);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
