package com.digitexx.ancestry.gui;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;


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
public class FrmFormat extends javax.swing.JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jPanel1;
	private JPanel panelTool;
	private JLabel labelImage;
	private JLabel jLabel13;
	private JButton buttonSetDefault;
	private JComboBox<String> comboBoxFontSize;
	private JTextField textFieldImage;
	private JLabel jLabel1;
	private JLabel jLabel14;
	private JLabel jLabelFontStyle;
	private JComboBox<String> comboBoxFontName;
	private JComboBox<String> comboBoxFontStyle;
	
	FrmAnalyzeRework formMain = null;
	
	/**
	 * ======================== get fontname
	 */
	
	//Get the local graphics environment  
	GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();  
	   
	 //Get the font names from the graphics environment  
	String[] fontNames = env.getAvailableFontFamilyNames(); 
	
	String[] fontStyles = new String[] {"Regular","BOLD","ITALIC","BOLD ITALIC"};

	//String pathConfig = System.getProperty("user.dir") + "/config.properties";
	private JButton buttonImage;
	
	public FrmFormat(JFrame frame) {
		super(frame);
		initGUI();
	}
	
	public FrmFormat(FrmAnalyzeRework frame) {
		super(frame);
		this.formMain = frame;
		initGUI();
	}
	
	@SuppressWarnings("serial")
	private void initGUI() {
		try {
			{
				this.setTitle("Format font & size");
				this.setModal(true);
				this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				
			}
			{
				final Image image;
				image = new ImageIcon(getClass().getClassLoader().getResource("com/digitexx/images/background_panel.jpg")).getImage();
				jPanel1 = new JPanel(){
					protected void paintComponent(Graphics g) {
						if(image!=null){
							g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);
						}
					};
				};
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				jPanel1.setPreferredSize(new java.awt.Dimension(763, 49));
				jPanel1.setLayout(null);
				{
					panelTool = new JPanel();
					jPanel1.add(panelTool);
					panelTool.setBounds(7, 7, 689, 106);
					panelTool.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
					panelTool.setLayout(null);
					panelTool.setOpaque(false);
					{
						jLabel13 = new JLabel();
						panelTool.add(jLabel13);
						jLabel13.setText("Font Name:");
						jLabel13.setBounds(7, 7, 77, 21);
						jLabel13.setHorizontalAlignment(SwingConstants.CENTER);
						jLabel13.setFont(new java.awt.Font("Tahoma",0,11));
						jLabel13.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
					}
					{
						ComboBoxModel<String> comboBoxFontNameModel = new DefaultComboBoxModel<String>(fontNames);
						comboBoxFontName = new JComboBox<String>();
						panelTool.add(comboBoxFontName);
						comboBoxFontName.setModel(comboBoxFontNameModel);
						comboBoxFontName.setSelectedItem(formMain.fontName);
						comboBoxFontName.setBounds(84, 7, 175, 21);
						comboBoxFontName.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								comboBoxFontNameActionPerformed(evt);
							}
							});
					}
					{
						jLabel14 = new JLabel();
						panelTool.add(jLabel14);
						jLabel14.setText("Font Size:");
						jLabel14.setHorizontalAlignment(SwingConstants.CENTER);
						jLabel14.setFont(new java.awt.Font("Tahoma",0,11));
						jLabel14.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
						jLabel14.setBounds(273, 7, 77, 21);
					}
					{
						ComboBoxModel<String> comboBoxFontSizeModel = new DefaultComboBoxModel<String>(
								new String[] { "6", "7", "8", "9", "10", "11", "12", "13",
										"14", "15", "16", "17", "18", "19", "20",
										"21", "22", "23", "24", "25", "26", "27",
										"28", "29", "30", "31", "32", "33", "34",
										"36", "38", "40", "42", "44", "46", "48", "50"});
						comboBoxFontSize = new JComboBox<String>();
						panelTool.add(comboBoxFontSize);
						comboBoxFontSize.setModel(comboBoxFontSizeModel);
						comboBoxFontSize.setSelectedItem(formMain.fontSize+"");
						comboBoxFontSize.setEditable(true);
						comboBoxFontSize.setBounds(350, 7, 63, 21);
						comboBoxFontSize.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								comboBoxFontSizeActionPerformed(evt);
							}
							});
						comboBoxFontSize.addKeyListener(new KeyAdapter() {
							public void keyReleased(KeyEvent evt) {
								comboBoxFontSizeKeyReleased(evt);
							}
						});
					}
					{
						jLabelFontStyle = new JLabel();
						panelTool.add(jLabelFontStyle);
						jLabelFontStyle.setText("Font Style:");
						jLabelFontStyle.setBounds(427, 7, 77, 21);
						jLabelFontStyle.setHorizontalAlignment(SwingConstants.CENTER);
						jLabelFontStyle.setFont(new java.awt.Font("Tahoma",0,11));
						jLabelFontStyle.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
					}
					{
						ComboBoxModel<String> comboBoxFontNameModel = new DefaultComboBoxModel<String>(fontStyles);
						comboBoxFontStyle = new JComboBox<String>();
						panelTool.add(comboBoxFontStyle);
						comboBoxFontStyle.setModel(comboBoxFontNameModel);
						comboBoxFontStyle.setSelectedItem(translateFontStyle_Reverse(formMain.fontStyle));
						comboBoxFontStyle.setBounds(504, 7, 175, 21);
						comboBoxFontStyle.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								comboBoxFontStyleActionPerformed(evt);
							}
							});
					}
					{
						buttonSetDefault = new JButton();
						panelTool.add(buttonSetDefault);
						buttonSetDefault.setText("Set Default");
						buttonSetDefault.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/digitexx/images/config.png")));
						buttonSetDefault.setBounds(131, 51, 462, 42);
						buttonSetDefault
							.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								buttonSetDefaultActionPerformed(evt);
							}
							});
					}
					{
						jLabel1 = new JLabel();
						panelTool.add(jLabel1);
						jLabel1.setText("Image:");
						jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
						jLabel1.setFont(new java.awt.Font("Tahoma",0,11));
						jLabel1.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
						jLabel1.setBounds(7, 44, 77, 21);
						jLabel1.setFocusable(false);
						jLabel1.setVisible(false);
						jLabel1.setEnabled(false);
					}
					{
						textFieldImage = new JTextField();
						panelTool.add(textFieldImage);
						textFieldImage.setBounds(84, 44, 288, 20);
						textFieldImage.setEditable(false);
						textFieldImage.setEnabled(false);
						textFieldImage.setFocusable(false);
						textFieldImage.setVisible(false);
						textFieldImage.setRequestFocusEnabled(false);
						//textFieldImage.setText(formMain.image);
					}
					{
						labelImage = new JLabel();
						panelTool.add(labelImage);
						//labelImage.setIcon(formMain.icon);
						labelImage.setHorizontalAlignment(SwingConstants.CENTER);
						labelImage.setBounds(423, 7, 118, 91);
						labelImage.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
						labelImage.setEnabled(false);
						labelImage.setFocusable(false);
						labelImage.setVisible(false);
						labelImage.setRequestFocusEnabled(false);
					}
					{
						buttonImage = new JButton();
						panelTool.add(buttonImage);
						buttonImage.setText("...");
						buttonImage.setBounds(372, 43, 45, 23);
						buttonImage.setEnabled(false);
						buttonImage.setFocusable(false);
						buttonImage.setVisible(false);
						buttonImage.setRequestFocusEnabled(false);
						buttonImage.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								buttonImageActionPerformed(evt);
							}
						});
					}

				}
			}
			this.setSize(712, 154);
			this.setResizable(false);
			this.setLocation(300, 100);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void comboBoxFontNameActionPerformed(ActionEvent evt) {
		if("".equals(comboBoxFontName.getSelectedItem().toString()) ||
				comboBoxFontName.getSelectedItem()==null) return;
		
		formMain.fontName = comboBoxFontName.getSelectedItem().toString();
		formMain.tableData.setFont(new java.awt.Font(formMain.fontName, formMain.fontStyle,formMain.fontSize));
		formMain.tableData.repaint();
	}
	
	private void comboBoxFontSizeActionPerformed(ActionEvent evt) {
		if("".equals(comboBoxFontSize.getSelectedItem().toString()) ||
				comboBoxFontSize.getSelectedItem()==null) return;
		
		formMain.fontSize = Integer.parseInt(comboBoxFontSize.getSelectedItem().toString());
		formMain.tableData.setFont(new java.awt.Font(formMain.fontName, formMain.fontStyle,formMain.fontSize));
		formMain.tableData.repaint();
		
//		JTableUtil.addHeaderRow(formMain.tableData);
//		JTableUtil.addHeaderRowByValue(formMain.tableData , formMain.fontName,formMain.fontStyle,formMain.fontSize );
	}
	
	private void comboBoxFontStyleActionPerformed(ActionEvent evt) {
		if("".equals(comboBoxFontStyle.getSelectedItem().toString()) ||
				comboBoxFontStyle.getSelectedItem()==null) return;
		
		formMain.fontStyle = translateFontStyle(comboBoxFontStyle.getSelectedItem().toString());
		formMain.tableData.setFont(new java.awt.Font(formMain.fontName, formMain.fontStyle,formMain.fontSize));
		formMain.tableData.repaint();
	}
	
	private int translateFontStyle(String fontStyleName){
		int fontStyle = Font.PLAIN;
		
		switch (fontStyleName) {
		case "Regular":
			
			break;
		
		case "BOLD":
			fontStyle = Font.BOLD;
			break;
			
		case "ITALIC":
			fontStyle = Font.ITALIC;
			break;
			
		case "BOLD ITALIC":
			fontStyle = Font.BOLD | Font.ITALIC;
			break;

		default:
			break;
		}
		
		
		return fontStyle;
	}
	
	private String translateFontStyle_Reverse(int fontStyle){
		String fontStyleName = "Regular";
		
		switch (fontStyle) {
		case 0:
			break;
		case Font.BOLD:
			fontStyleName= "BOLD";
		case Font.ITALIC:
			fontStyleName= "ITALIC";
		case (Font.BOLD | Font.ITALIC):
			fontStyleName= "BOLD ITALIC";
		default:
			break;
		}
		
		return fontStyleName;
	}
	
	
	private void comboBoxFontSizeKeyReleased(KeyEvent evt) {
		if(evt.getKeyCode() == KeyEvent.VK_ENTER){
			if("".equals(comboBoxFontSize.getSelectedItem().toString()) ||
					comboBoxFontSize.getSelectedItem()==null) return;
			
			formMain.fontSize = Integer.parseInt(comboBoxFontSize.getSelectedItem().toString());
			formMain.tableData.setFont(new java.awt.Font(formMain.fontName,0,formMain.fontSize));
			formMain.tableData.repaint();
			

		}
	}
	
	private void buttonSetDefaultActionPerformed(ActionEvent evt) {

		//Properties properties = new Properties();
		try {  
			//File f = new File(pathConfig);
//			if(!f.exists()) f.mkdir();
	    	//properties.setProperty("font_name", formMain.fontName);
	    	//properties.setProperty("font_size", formMain.fontSize+"");
	    	//properties.setProperty("image", textFieldImage.getText().trim());
	    	
	    	//properties.store(new FileOutputStream(f),null);
			
			formMain.fontName = "Tahoma";
			formMain.fontSize = 13;
			formMain.fontStyle = Font.PLAIN;
			
			formMain.tableData.setFont(new java.awt.Font(formMain.fontName,formMain.fontStyle,formMain.fontSize));
			formMain.tableData.repaint();
			
			
	    } 
		catch (Exception e) 
	    {
		    e.printStackTrace();
		    JOptionPane.showMessageDialog(this, e.toString() + "\n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		    return;
		}
	    JOptionPane.showMessageDialog(this, "Set default Ok!");
	
	}
	
	
	
	String ori_file = "";
	private void buttonImageActionPerformed(ActionEvent evt) {
		try{
			ori_file = textFieldImage.getText().trim();
			JFileChooser fileChooser ; 
			if( !"".equals( ori_file )  )
				fileChooser = new JFileChooser(ori_file);
			else
				fileChooser = new JFileChooser();

			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			
			int returnVal = fileChooser.showDialog(this, "Select Image");
			
			String folders = "";
			if (returnVal == JFileChooser.APPROVE_OPTION)  {
				if(fileChooser.getSelectedFile().toString() == null){
					return ;
				}
				folders = fileChooser.getSelectedFile().toString();
				if(folders.toLowerCase().endsWith(".png") || folders.toLowerCase().endsWith(".jpg") ||
						folders.toLowerCase().endsWith(".tif") || folders.toLowerCase().endsWith(".bmp")){
					textFieldImage.setText(folders) ;
					if(new File(folders).exists()){
						//formMain.icon = new ImageIcon(folders);
						//labelImage.setIcon(formMain.icon);
					}
				}else{
					//JOptionPane.showMessageDialog(this, "File image not valid!", "ERROR", JOptionPane.ERROR_MESSAGE, formMain.icon);
					textFieldImage.setText("") ;
				}

				
			}

		}catch( Exception e ){
			e.printStackTrace();
		}
	}

}
