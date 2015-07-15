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
import javax.swing.JPanel;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import com.digitexx.ancestry.jai.util.ImagePerfectJAI;
import com.digitexx.ancestry.jai.util.ImageUtil;

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
 * @author lqnhu
 *
 */
public class PanelProcessImage extends JPanel implements ActionListener
{
	private static final long serialVersionUID = -1282515605968597426L;
	private JButton buttonZoomIn;
	private JButton buttonRotateLeft;
	private JButton buttonRotateRight;
	private JButton buttonUp;
	public JComboBox comboboxZoom;
	private JButton buttonDown;
	private JButton buttonRight;
	private JButton buttonLeft;
	private JButton buttonZoomOut;
	private ImageUtil imageUtil;
	private ImagePerfectJAI perfectJAI ;
	
	public PanelProcessImage() {
		initGUI();
		addListenter();
	}

	private void initGUI() {
		try {
			{
				AnchorLayout thisLayout = new AnchorLayout();
				this.setLayout(thisLayout);
				this.setPreferredSize(new java.awt.Dimension(302, 31));
				{
					buttonZoomIn = new JButton();
					this.add(buttonZoomIn, new AnchorConstraint(16, 82, 919, 1, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonZoomIn.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/digitexx/images/zoomin.png")));
					buttonZoomIn.setPreferredSize(new java.awt.Dimension(30, 28));
					buttonZoomIn.addActionListener(this);
				}
				{
					ComboBoxModel comboboxZoomModel =  new DefaultComboBoxModel(
							new String[] { "200", "190", "180", "170", "160", "150",
									"140", "130", "120", "110", "100", "90", "80",
									"70", "60", "50", "40", "30", "20", "10" });
					comboboxZoom = new JComboBox();
					this.add(comboboxZoom, new AnchorConstraint(16, 248, 919, 82, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					comboboxZoom.setModel(comboboxZoomModel);
					comboboxZoom.setPreferredSize(new java.awt.Dimension(61, 28));
					comboboxZoom.setSelectedItem("60");
					comboboxZoom.addActionListener(this);
				}
				{
					buttonZoomOut = new JButton();
					this.add(buttonZoomOut, new AnchorConstraint(16, 329, 951, 246, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonZoomOut.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/digitexx/images/zoomout.png")));
					buttonZoomOut.setPreferredSize(new java.awt.Dimension(25, 29));
					buttonZoomOut.addActionListener(this);
				}
				{
					buttonLeft = new JButton();
					this.add(buttonLeft, new AnchorConstraint(16, 411, 951, 330, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonLeft.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/digitexx/images/left.png")));
					buttonLeft.setPreferredSize(new java.awt.Dimension(30, 29));
					buttonLeft.addActionListener(this);
				}
				{
					buttonRight = new JButton();
					this.add(buttonRight, new AnchorConstraint(16, 493, 951, 411, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonRight.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/digitexx/images/right.png")));
					buttonRight.setPreferredSize(new java.awt.Dimension(30, 29));
					buttonRight.addActionListener(this);
				}
				{
					buttonDown = new JButton();
					this.add(buttonDown, new AnchorConstraint(16, 574, 951, 491, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonDown.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/digitexx/images/down.png")));
					buttonDown.setPreferredSize(new java.awt.Dimension(25, 29));
					buttonDown.addActionListener(this);
				}
				{
					buttonUp = new JButton();
					this.add(buttonUp, new AnchorConstraint(16, 656, 919, 574, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonUp.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/digitexx/images/up.png")));
					buttonUp.setPreferredSize(new java.awt.Dimension(30, 28));
					buttonUp.addActionListener(this);
				}
				{
					buttonRotateRight = new JButton();
					this.add(buttonRotateRight, new AnchorConstraint(16, 745, 919, 656, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonRotateRight.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/digitexx/images/rotator_right.jpg")));
					buttonRotateRight.setPreferredSize(new java.awt.Dimension(33, 28));
					buttonRotateRight.addActionListener(this);
				}
				{
					buttonRotateLeft = new JButton();
					this.add(buttonRotateLeft, new AnchorConstraint(16, 835, 919, 745, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					buttonRotateLeft.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/digitexx/images/rotator_left.jpg")));
					buttonRotateLeft.setPreferredSize(new java.awt.Dimension(33, 28));
					buttonRotateLeft.addActionListener(this);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//======================================================================================================================
	
	private void addListenter(){

		java.awt.Toolkit.getDefaultToolkit().addAWTEventListener(
				new java.awt.event.AWTEventListener() {

					public void eventDispatched(java.awt.AWTEvent event) {

						KeyEvent e = (KeyEvent) event;

						if ( e.getID() == KeyEvent.KEY_PRESSED)
						{
							if(e.isControlDown())
							{

								switch (e.getKeyCode())
								{
								case KeyEvent.VK_RIGHT:
									buttonZoomOut.doClick();
									e.consume();
									break;

								case KeyEvent.VK_LEFT:
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
				}, java.awt.AWTEvent.KEY_EVENT_MASK);

	}

	public void actionPerformed(ActionEvent evt)
	{
		Object obj = evt.getSource();
		if(obj == buttonZoomIn)
		{
			imageUtil.zoomImageIn(comboboxZoom);
		}
		if(obj == buttonZoomOut)
		{
			imageUtil.zoomImageOut(comboboxZoom);
		}
		if(obj == comboboxZoom)
		{
			imageUtil.zoomCombobox(comboboxZoom);
		}
		if(obj == buttonUp)
		{
			imageUtil.upImage();
		}
		if(obj == buttonDown)
		{
			imageUtil.downImage();
		}
		if(obj == buttonLeft)
		{
			imageUtil.leftImage();
		}
		if(obj == buttonRight)
		{
			imageUtil.rightImage();
		}
		if(obj == buttonRotateLeft)
		{
			imageUtil.rotateLeft();
		}
		if(obj == buttonRotateRight){
			imageUtil.rotateRight();
		}
	}


	//============================================================================================================================

	/**
	 * @return the imageUtil
	 */
	public ImageUtil getImageUtil() {
		return imageUtil;
	}

	/**
	 * @param imageUtil the imageUtil to set
	 */
	public void setImageUtil(ImageUtil imageUtil) {
		this.imageUtil = imageUtil;
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
