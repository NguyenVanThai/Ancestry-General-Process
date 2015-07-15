/**
 * 
 */
package com.digitexx.ancestry.component;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * @author Le Quynh Nhu
 * 
 */
public class PanelTrayIcon extends JPanel
{
	private static final long serialVersionUID = -3004054220710195742L;
	private SystemTray tray;
	private TrayIcon icon;
	private JFrame frame;

	public PanelTrayIcon(final JFrame frame , String title) 
	{
		if(tray != null) {
			removeTrayIcon();
		}
		this.frame = frame;
		setPreferredSize(new Dimension(320, 240));
		if (!SystemTray.isSupported()) {
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			return;
		}
		frame.addWindowStateListener(new WindowAdapter() {
			public void windowIconified(WindowEvent e) {
				frame.dispose();
			}
		});
		tray = SystemTray.getSystemTray();

		final Image image = new ImageIcon(getClass().getClassLoader().getResource("com/digitexx/images/a_red.png")).getImage();
		final PopupMenu popup = new PopupMenu();
		icon = new TrayIcon(image, title , popup);

		MenuItem item1 = new MenuItem("OPEN");
		item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
			}
		});
		
		MenuItem item2 = new MenuItem("EXIT");
		item2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tray.remove(icon);
				frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				frame.dispose();
			}
		});
		popup.add(item1);
		popup.add(item2);

		try {
			tray.add(icon);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * remove tray icon
	 */
	public void removeTrayIcon() {
		tray.remove(icon);
	}
	
	protected void paintComponent(Graphics g) {
		
//		final Image image = new ImageIcon(getClass().getClassLoader()
//		.getResource("com/digitexx/images/spring.jpg")).getImage();
//		
//		 if(image!=null) g.drawImage(image, 0, 0,
//		 this.getWidth(), this.getHeight(), this);
	}
}
