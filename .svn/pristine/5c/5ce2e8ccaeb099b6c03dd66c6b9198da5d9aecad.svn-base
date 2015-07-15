package com.digitexx.ancestry.util;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;


/**
 * @author lqnhu
 *
 */
public class AppUtility {

	public static void msgWaring(Container container , String content) {
		JOptionPane.showMessageDialog(container,"<html><b><font color=blue size = 4>" + content + "</font></b></html>", "Information",JOptionPane.WARNING_MESSAGE);
	}

	public static void msgError(Container container ,String content) {
		JOptionPane.showMessageDialog(container,"<html><b><font color=red size = 4>" + content + "</font></b></html>", "Information",JOptionPane.ERROR_MESSAGE);
	}
	
	public static void msgInfo(Container container ,String content) {
		JOptionPane.showMessageDialog(container,"<html><b><font color=blue size = 4>" + content + "</font></b></html>", "Information",JOptionPane.INFORMATION_MESSAGE);
	}

	public static int msgConfirm(Container container ,String content) {
		return JOptionPane.showConfirmDialog(container,"<html><b><font color=red size = 4>" + content + "</font></b></html>", "Confirm",JOptionPane.YES_NO_OPTION);
	}
	
	public static void fullScreen(JFrame frame) 
	{
		Toolkit tk = Toolkit.getDefaultToolkit();
		int xSize = ((int) tk.getScreenSize().getWidth());
		int ySize = ((int) tk.getScreenSize().getHeight());
		frame.setSize(xSize, ySize);
	}
	
	public static void centerFrame(JFrame frame) {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
	}
	
	public static void appendText(JTextPane pane, String message , Color color)
	{
		SimpleAttributeSet set = new SimpleAttributeSet();
		StyleConstants.setBold(set, false);
		pane.setCharacterAttributes(set, true);

		set = new SimpleAttributeSet();
		StyleConstants.setItalic(set, false);
		StyleConstants.setFontSize(set, 16);
		StyleConstants.setForeground(set, color);
		Document doc = pane.getStyledDocument();
		try {
			doc.insertString(doc.getLength(), "\n"+  "==>>" + message + "\n", set);
			set = new SimpleAttributeSet();
			StyleConstants.setFontSize(set, 24);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}


	}
	
	public static void setLookAndFeeForAncestry()
	{	
		try 
		{
			if (System.getProperty("os.name").contains("Linux")) 
				UIManager.setLookAndFeel("com.incors.plaf.kunststoff.KunststoffLookAndFeel");			
			else 
				javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");													
		} 
		catch(Exception e) 	
		{
			try {
				javax.swing.UIManager.setLookAndFeel("com.jgoodies.looks.plastic.PlasticLookAndFeel");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}		
	}
	
	public static void setLookAndField(int type){
		try {

			if(System.getProperty("os.name").equals("Windows XP") || System.getProperty("os.name").equals("Windows 7")) {
				//UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
				UIManager.setLookAndFeel( "com.birosoft.liquid.LiquidLookAndFeel" );
				if(type ==1) {
					UIManager.setLookAndFeel( ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel());
				}
	 
			}else{
				javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	
	/**
	 * load data to jlist
	 */
	public static void loadDataJList(JList<String> jlist , DefaultListModel<String> model , List<String> lisData) 
	{
       model = new DefaultListModel();
       for (String str : lisData) {
		  model.addElement(str);
	   }
       jlist.setModel(model);
	}

	
}
