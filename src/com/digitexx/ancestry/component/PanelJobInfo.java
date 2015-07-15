package com.digitexx.ancestry.component;
import javax.swing.JLabel;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.ancestry.dao.TimeManagementDao;

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
public class PanelJobInfo extends javax.swing.JPanel 
{
	private static final long serialVersionUID = 165853193501977616L;
	private JLabel labelSpeed;
	private JLabel labelTotalTime;
	private JLabel labelStep;
	private JLabel labelUser;

	private String userId;
	private String project;
	private String step;
	private TimeManagementDao timeManagementDao = new TimeManagementDao();

	public PanelJobInfo(String userId , String project , String step) {
		super();
		this.userId = userId;
		this.project = project;
		this.step = step;
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(442, 27));
			AnchorLayout thisLayout = new AnchorLayout();
			this.setLayout(thisLayout);
			this.setFont(new java.awt.Font("Dialog",1,12));
			{
				labelUser = new JLabel();
				this.add(labelUser, new AnchorConstraint(18, 216, 1018, 1, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				labelUser.setText("");
				labelUser.setFont(new java.awt.Font("Tahoma",1,11));
				labelUser.setForeground(new java.awt.Color(255,0,0));
				labelUser.setPreferredSize(new java.awt.Dimension(95, 27));
			}
			{
				labelStep = new JLabel();
				this.add(labelStep, new AnchorConstraint(18, 476, 1018, 229, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				labelStep.setText("");
				labelStep.setFont(new java.awt.Font("Tahoma",1,11));
				labelStep.setForeground(new java.awt.Color(255,0,0));
				labelStep.setPreferredSize(new java.awt.Dimension(109, 27));
			}
			{
				labelTotalTime = new JLabel();
				this.add(labelTotalTime, new AnchorConstraint(18, 736, 1018, 489, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				labelTotalTime.setText("");
				labelTotalTime.setFont(new java.awt.Font("Tahoma",1,11));
				labelTotalTime.setForeground(new java.awt.Color(255,0,0));
				labelTotalTime.setPreferredSize(new java.awt.Dimension(109, 27));
			}
			{
				labelSpeed = new JLabel();
				this.add(labelSpeed, new AnchorConstraint(18, 996, 1018, 750, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				labelSpeed.setText("");
				labelSpeed.setFont(new java.awt.Font("Tahoma",1,11));
				labelSpeed.setPreferredSize(new java.awt.Dimension(109, 27));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadTime() {

		timeManagementDao.loadSpeed(labelSpeed, labelTotalTime, userId, 4);
		labelUser.setText(userId);
		labelStep.setText(step);
	}

}
