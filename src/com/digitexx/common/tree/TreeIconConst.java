/**
 * 
 */
package com.digitexx.common.tree;

import javax.swing.ImageIcon;

/**
 * @author Le Quynh Nhu
 *
 */
public class TreeIconConst
{
	public TreeIconConst(){
		
	}
	public  final ImageIcon ICON_COMPUTER = 
			new ImageIcon(this.getClass().getClassLoader().getResource("com/digitexx/images/1387834853_dashboard_green.png"));
	
	public  final ImageIcon ICON_DISK = 
			new ImageIcon(this.getClass().getClassLoader().getResource("com/digitexx/images/bullet_red.png"));
	
	public  final ImageIcon ICON_FOLDER = 
			new ImageIcon(this.getClass().getClassLoader().getResource("com/digitexx/images/1379548893_bullet-green.png"));
	
	public  final ImageIcon ICON_EXPANDEDFOLDER =
			new ImageIcon(this.getClass().getClassLoader().getResource("com/digitexx/images/1381619073_bullet-yellow.png"));
	
	public  final ImageIcon ICON_FILE = 
			new ImageIcon(this.getClass().getClassLoader().getResource("com/digitexx/images/text_right.png"));

}
