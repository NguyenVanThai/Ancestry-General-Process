/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Machine2
 */
public class Java_SystemTray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String icoPath = "java.png";

        if (SystemTray.isSupported()) {
            final SystemTray systemTray = SystemTray.getSystemTray();
            final TrayIcon trayIcon = new TrayIcon(new ImageIcon(icoPath, "omt").getImage(), "Java App");
            trayIcon.setImageAutoSize(true);// Autosize icon base on space

            MouseAdapter mouseAdapter = new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    systemTray.remove(trayIcon);
                }
            };
            trayIcon.addMouseListener(mouseAdapter);
            try {
                systemTray.add(trayIcon);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}