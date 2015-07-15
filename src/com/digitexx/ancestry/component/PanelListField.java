/**
 * 
 */
package com.digitexx.ancestry.component;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.digitexx.ancestry.bean.XY_WH_SH_SV;
import com.digitexx.ancestry.jai.util.ShowJAI;
import com.digitexx.ancestry.util.StringUtil;


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
public class PanelListField extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private List<String> listFieldName;
	private ShowJAI imageCanvas;
	private int totalField;
	private int index = 0;
	public HashMap<Integer, JTextField> mapTextField = new HashMap<Integer , JTextField>();
	private JComboBox comboboxZoom ;
	private JScrollPane scrollpane;
	
	public PanelListField(List<String> listFieldName , ShowJAI imageCanvas , JComboBox comboboxZoom , JScrollPane scrollpane) {
		super();
		this.listFieldName = listFieldName;
		this.imageCanvas = imageCanvas;
		this.comboboxZoom = comboboxZoom;
		this.scrollpane = scrollpane;
		totalField = listFieldName.size();
		index = 0;
		initGUI();
		initData();
		addKeyEvent();
	}

	private void initGUI() {
		try {
			{
				this.setLayout(new GridLayout(totalField , 1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void initData() 
	{
		int idx = 0;
		mapTextField = new HashMap<Integer , JTextField>();
        for (final String fieldname : listFieldName) 
        {
			final JTextField txtFieldName = new JTextField();
			txtFieldName.setFont(new java.awt.Font("Tahoma",1,14));
			txtFieldName.setBorder(BorderFactory.createTitledBorder(null, fieldname, 
			TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,14)));
			//txtFieldName.setEditable(false);
			txtFieldName.setBackground(Color.WHITE);
			txtFieldName.setName(fieldname);
			mapTextField.put(idx, txtFieldName);
			
			txtFieldName.addFocusListener(new FocusAdapter() {
				public void focusGained(FocusEvent evt) 
				{
					index = findIndex(fieldname);
					txtFieldName.setBorder(BorderFactory.createTitledBorder(null, fieldname, TitledBorder.LEADING, 
					TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,14), new java.awt.Color(255,0,0)));
					imageCanvas.getMapFocus().put(fieldname, txtFieldName );
					imageCanvas.fieldname  = fieldname;
					
					 java.awt.Component focusedComponent = evt.getComponent();
				     scrollRectToVisible(focusedComponent.getBounds(null));
				     repaint();
				     
				     String valueFocus = txtFieldName.getText();
				     repaintFocus(valueFocus);
				     if(index > 1) 
				     {
				    	 String tmp = StringUtil.setNotNull(mapTextField.get((index-1)).getText());
				    	 if(!tmp.equals("")) {
				    		 txtFieldName.setText(tmp);
				    	 }
				     }
				}
				
			});
			
        	++ idx;
			txtFieldName.addFocusListener(new FocusAdapter() {
				public void focusLost(FocusEvent evt) 
				{
					txtFieldName.setBorder(BorderFactory.createTitledBorder(null, fieldname, 
					TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,14)));
					
				}
			});
			
			txtFieldName.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					index = findIndex(fieldname);
				}
			});
			
			this.add(txtFieldName);
		}
        this.revalidate();
	}
	
	private void addKeyEvent()
	{
		java.awt.Toolkit.getDefaultToolkit().addAWTEventListener(
				new java.awt.event.AWTEventListener() {

					public void eventDispatched(java.awt.AWTEvent event) {
						KeyEvent e = (KeyEvent) event;

						if (e.getID() == KeyEvent.KEY_PRESSED) 
                        {
							if (e.getKeyCode() == KeyEvent.VK_ENTER) {
								setFocusField(true);
							}
							if (e.getKeyCode() == KeyEvent.VK_PAGE_UP|| e.getKeyCode() == KeyEvent.VK_UP) {
								setFocusField(false);
							}
							if (e.getKeyCode() == KeyEvent.VK_PAGE_DOWN|| e.getKeyCode() == KeyEvent.VK_DOWN) {
								setFocusField(true);
							}
							return;
						}

					}
				}, java.awt.AWTEvent.KEY_EVENT_MASK);
	}
	
	/**
	 * set value next field 
	 */
	private void setDefaultValue() {
		if(mapTextField.size() > 1) {
			if(index > -1 && index <= mapTextField.size()-1) {

				JTextField textFieldTmp = mapTextField.get(index);
				
				if(!imageCanvas.mapFocus.containsKey(textFieldTmp.getName())) 
				{
					String value = StringUtil.setNotNull(mapTextField.get((index-1)).getText());
					mapTextField.get(index).setText(value);
				}
			}
		}
	}
	
	/**
	 * set focus of field
	 */
	private void setFocusField(boolean flag)
	{
		if (flag) {
			++index;
			setDefaultValue();
		} else {
			--index;
		}
		if(index < 0) {
			index = 0;
		}else if(index >  totalField-1) {
			index = totalField-1;
		}
		mapTextField.get(index).requestFocus();
	}
	
	private int findIndex(String fieldname) 
	{
		try {
			int len = mapTextField.size();
			for (int i = 0; i < len; i++) 
			{
				if(mapTextField.get(i).getName().equals(fieldname)) {
					return i;
				}
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return 0;
	}
	
	
	/**
	 * repaint image when focus field
	 */
	public void repaintFocus(String value) 
	{
		if(value.contains(";")) 
		{
			int iZoom = Integer.parseInt(comboboxZoom.getSelectedItem().toString());
			XY_WH_SH_SV xywh = new XY_WH_SH_SV();
	           
			imageCanvas.preRange = true;
			xywh  = xywh.toObject(value);
			int x = (Integer.parseInt(xywh.getX()) * iZoom ) / 100;
 			int y = (Integer.parseInt(xywh.getY()) * iZoom ) / 100;
 			int w = (Integer.parseInt(xywh.getW()) * iZoom ) / 100;
 			int h = (Integer.parseInt(xywh.getH()) * iZoom ) / 100;
 			
 			int sh = (Integer.parseInt(xywh.getSh()) * iZoom ) / 100;
 			int sv = (Integer.parseInt(xywh.getSv()) * iZoom ) / 100;
 			
// 			scrollpane.getHorizontalScrollBar().setValue(x - 100);
// 			scrollpane.getVerticalScrollBar().setValue(y - 100);
 			
 			scrollpane.getHorizontalScrollBar().setValue(sh);
 			scrollpane.getVerticalScrollBar().setValue(sv);
 			
			imageCanvas.prx0 = x;
 			imageCanvas.pry0 = y;
 			imageCanvas.prwidth = w;
 			imageCanvas.prheight = h;
			imageCanvas.drawRecangle(x , x, x , x);
		}
		else {
			imageCanvas.drawRecangle(0 , 0, 0 , 0);
		}
	}
	
	/**
	 * clear data
	 */
	public void clearData()
	{
		int len = mapTextField.size();
		for (int i = 0; i < len; i++) 
		{
			mapTextField.get(i).setText("");
		}
	}

	/**
	 * @return the mapTextField
	 */
	public HashMap<Integer, JTextField> getMapTextField() {
		return mapTextField;
	}

	/**
	 * @param mapTextField the mapTextField to set
	 */
	public void setMapTextField(HashMap<Integer, JTextField> mapTextField) {
		this.mapTextField = mapTextField;
	}


	
	//=========================================================================================================================
	
	

}
