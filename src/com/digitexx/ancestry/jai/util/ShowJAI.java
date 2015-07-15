/**
 * 
 */
package com.digitexx.ancestry.jai.util;

import java.awt.event.MouseEvent;
import java.awt.image.RenderedImage;
import java.util.HashMap;

import javax.swing.JTextField;

/**
 * @author lqnhu
 *
 */
public class ShowJAI extends DisplayImageJAI{

	private static final long serialVersionUID = 1L;
	private String xs;
	private String ys;
	private String ws;
	private String hs;
	private String sh;
	private String sv ;
	public String fieldname = "";
	public int row = 0;
	public HashMap<String, JTextField> mapFocus = new HashMap<>();
	private String valueFocus = "";
	public boolean isRepaint = false;
    
	public ShowJAI(RenderedImage image){
		super(image);
	}

	public void mouseClicked(MouseEvent e)
	{
		if(rect != null && mapFocus.get(fieldname) != null)
		{
			xs = Integer.toString(e.getX() - anchorX);
			ys = Integer.toString(e.getY() - anchorY);

			ws = Integer.toString(rect.width);
			hs = Integer.toString(rect.height);

			sh = getScrollPane().getHorizontalScrollBar().getValue() + "";
			sv = getScrollPane().getVerticalScrollBar().getValue() + "";

			valueFocus = xs + ";" + ys + ";" + ws + ";" + hs + ";" + sh + ";" + sv ;
			mapFocus.get(fieldname).setText(valueFocus);
		}
		super.mouseClicked(e);
	}  

	/** Only show cursor posssition **/
	public void mouseMoved(MouseEvent me)
	{
		repaint() ;
		super.mouseMoved(me);
	}

	/** Draw Rectangle when user drag mouse **/    	   
	public void mouseDragged(MouseEvent me) 
	{
		// relative coordinate of X1,Y1 to Anchor Position    		  
		x1 =  me.getX() - anchorX  ; 
		y1 =  me.getY() - anchorY ; 

		//show width and height of selected field
		if(rect != null && mapFocus.get(fieldname) != null)
		{
			xs = Integer.toString( rect.x); 
			ys = Integer.toString( rect.y);	 

			ws = Integer.toString( rect.width); 
			hs = Integer.toString( rect.height);  
			
			sh = getScrollPane().getHorizontalScrollBar().getValue()+"";
			sv = getScrollPane().getVerticalScrollBar().getValue()+"";
			
			valueFocus = xs + ";" + ys + ";" + ws + ";" + hs + ";" + sh + ";" + sv;
			mapFocus.get(fieldname).setText(valueFocus);
		}			
		super.mouseDragged(me);
	}

	/**
	 * @return the xs
	 */
	public String getXs() {
		return xs;
	}

	/**
	 * @param xs the xs to set
	 */
	public void setXs(String xs) {
		this.xs = xs;
	}

	/**
	 * @return the ys
	 */
	public String getYs() {
		return ys;
	}

	/**
	 * @param ys the ys to set
	 */
	public void setYs(String ys) {
		this.ys = ys;
	}

	/**
	 * @return the ws
	 */
	public String getWs() {
		return ws;
	}

	/**
	 * @param ws the ws to set
	 */
	public void setWs(String ws) {
		this.ws = ws;
	}

	/**
	 * @return the hs
	 */
	public String getHs() {
		return hs;
	}

	/**
	 * @param hs the hs to set
	 */
	public void setHs(String hs) {
		this.hs = hs;
	}
	
	

	/**
	 * @return the sh
	 */
	public String getSh() {
		return sh;
	}

	/**
	 * @param sh the sh to set
	 */
	public void setSh(String sh) {
		this.sh = sh;
	}

	/**
	 * @return the sv
	 */
	public String getSv() {
		return sv;
	}

	/**
	 * @param sv the sv to set
	 */
	public void setSv(String sv) {
		this.sv = sv;
	}

	/**
	 * @return the fieldname
	 */
	public String getFieldname() {
		return fieldname;
	}

	/**
	 * @param fieldname the fieldname to set
	 */
	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}

	/**
	 * @return the mapFocus
	 */
	public HashMap<String, JTextField> getMapFocus() {
		return mapFocus;
	}

	/**
	 * @param mapFocus the mapFocus to set
	 */
	public void setMapFocus(HashMap<String, JTextField> mapFocus) {
		this.mapFocus = mapFocus;
	}

    	
}
