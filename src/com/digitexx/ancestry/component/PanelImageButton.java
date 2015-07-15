/**
 * 
 */
package com.digitexx.ancestry.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.ancestry.jai.util.ImagePerfectJAI;

/**
 * @author lqnhu
 *
 */
public class PanelImageButton extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JButton buttonZoomIn;
	private JButton buttonRotateLeft;
	private JButton buttonRotateRight;
	private JButton buttonUp;
	private JButton buttonDown;
	private JButton buttonRight;
	private JButton buttonLeft;
	private JButton buttonZoomOut;
	private JComboBox<String> comboboxZoom;
	JFrame frame;
	ImagePerfectJAI perfectJAI ;
	
	public PanelImageButton() {
		initGUI();
		addListenter();
	}

	private void initGUI() {
		try {
			{
				AnchorLayout thisLayout = new AnchorLayout();
				this.setLayout(thisLayout);
				this.setPreferredSize(new java.awt.Dimension(316, 31));
				{
					buttonZoomOut = new JButton();
					this.add(buttonZoomOut, new AnchorConstraint(48, 109, 983, 17, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonZoomOut.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/digitexx/images/zoomout.png")));
					buttonZoomOut.setBounds(5, 1, 29, 29);
					buttonZoomOut.addActionListener(this);
				}
				{
					ComboBoxModel<String> comboboxZoomModel =  new DefaultComboBoxModel<String>(
							new String[] { "200", "190", "180", "170", "160", "150",
									"140", "130", "120", "110", "100", "90", "80",
									"70", "60", "50", "40", "30", "20", "10" });
					comboboxZoom = new JComboBox<String>();
					this.add(comboboxZoom, new AnchorConstraint(48, 299, 983, 115, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					comboboxZoom.setModel(comboboxZoomModel);
					comboboxZoom.setBounds(36, 1, 58, 29);
					comboboxZoom.setSelectedItem("100");
					comboboxZoom.addActionListener(this);
				}
				{
					buttonZoomIn = new JButton();
					this.add(buttonZoomIn, new AnchorConstraint(48, 397, 983, 305, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonZoomIn.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/digitexx/images/zoomin.png")));
					buttonZoomIn.setBounds(96, 1, 29, 29);
					buttonZoomIn.addActionListener(this);
				}
				{
					buttonUp = new JButton();
					this.add(buttonUp, new AnchorConstraint(48, 495, 983, 403, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonUp.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/digitexx/images/up.png")));
					buttonUp.setPreferredSize(new java.awt.Dimension(29, 29));
					buttonUp.setBounds(127, 1, 29, 29);
					buttonUp.addActionListener(this);
				}
				{
					buttonDown = new JButton();
					this.add(buttonDown, new AnchorConstraint(48, 593, 983, 501, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonDown.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/digitexx/images/down.png")));
					buttonDown.setPreferredSize(new java.awt.Dimension(29, 29));
					buttonDown.setBounds(158, 1, 29, 29);
					buttonDown.addActionListener(this);
				}
				{
					buttonLeft = new JButton();
					this.add(buttonLeft, new AnchorConstraint(48, 691, 983, 599, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonLeft.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/digitexx/images/left.png")));
					buttonLeft.setBounds(189, 1, 29, 29);
					buttonLeft.addActionListener(this);
				}
				{
					buttonRight = new JButton();
					this.add(buttonRight, new AnchorConstraint(48, 789, 983, 697, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonRight.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/digitexx/images/right.png")));
					buttonRight.setBounds(220, 1, 29, 29);
					buttonRight.addActionListener(this);
				}
				{
					buttonRotateRight = new JButton();
					this.add(buttonRotateRight, new AnchorConstraint(48, 887, 983, 795, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonRotateRight.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/digitexx/images/rotator_right.jpg")));
					buttonRotateRight.setBounds(251, 1, 29, 29);
					buttonRotateRight.addActionListener(this);
				}
				{
					buttonRotateLeft = new JButton();
					this.add(buttonRotateLeft, new AnchorConstraint(48, 985, 983, 893, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonRotateLeft.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/digitexx/images/rotator_left.jpg")));
					buttonRotateLeft.setBounds(282, 1, 29, 29);
					buttonRotateLeft.addActionListener(this);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//hot keys
	private void addListenter()
	{
		java.awt.Toolkit.getDefaultToolkit().addAWTEventListener(
			new java.awt.event.AWTEventListener() 
			{
				public void eventDispatched(java.awt.AWTEvent event) 
				{
					KeyEvent e = (KeyEvent) event;
					if ( e.getID() == KeyEvent.KEY_PRESSED)
					{
						if(e.isControlDown())
						{
							switch (e.getKeyCode())
							{
							case KeyEvent.VK_LEFT:
								buttonZoomOut.doClick();
								e.consume();
								break;

							case KeyEvent.VK_RIGHT:
								buttonZoomIn.doClick();
								e.consume();
								break;

							case KeyEvent.VK_UP:
								buttonRotateLeft.doClick();
								e.consume();
								break;

							case KeyEvent.VK_DOWN:
								buttonRotateRight.doClick();
								e.consume();
								break;
						    }
						}
						else if(e.isAltDown())
						{
							switch (e.getKeyCode()) {
							case KeyEvent.VK_RIGHT:
								buttonRight.doClick();
								e.consume();
								break;
							
							case KeyEvent.VK_LEFT:
								buttonLeft.doClick();
								e.consume();
								break;

							case KeyEvent.VK_UP:
								buttonUp.doClick();
								e.consume();
								break;
								
							case KeyEvent.VK_DOWN:
								buttonDown.doClick();
								e.consume();
								break;	
							}								
						}
					}									
				}
			}, java.awt.AWTEvent.KEY_EVENT_MASK
		);
	}

	public void actionPerformed(ActionEvent evt)
	{
		Object obj = evt.getSource();
		if(obj == buttonZoomIn)
		{
			perfectJAI.zoomIn(comboboxZoom);
		}
		if(obj == buttonZoomOut)
		{
			perfectJAI.zoomOut(comboboxZoom);
		}
		if(obj == comboboxZoom)
		{
			perfectJAI.changeZoom(comboboxZoom);
		}
		if(obj == buttonUp)
		{
			perfectJAI.upImage();
		}
		if(obj == buttonDown)
		{
			perfectJAI.downImage();
		}
		if(obj == buttonLeft)
		{
			perfectJAI.leftImage();
		}
		if(obj == buttonRight)
		{
			perfectJAI.rightImage();
		}
		if(obj == buttonRotateLeft)
		{
			perfectJAI.rotateLeft();
		}
		if(obj == buttonRotateRight)
		{
			perfectJAI.rotateRight();
		}
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	
	public JComboBox<String> getComboboxZoom() {
		return comboboxZoom;
	}

	public void setComboboxZoom(JComboBox<String> comboboxZoom) {
		this.comboboxZoom = comboboxZoom;
	}

	/**
	 * @return the perfectJAI
	 */
	public ImagePerfectJAI getPerfectJAI() {
		return perfectJAI;
	}

	/**
	 * @param perfectJAI the perfectJAI to set
	 */
	public void setPerfectJAI(ImagePerfectJAI perfectJAI) {
		this.perfectJAI = perfectJAI;
	}
	
	
}
