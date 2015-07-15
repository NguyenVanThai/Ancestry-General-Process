/**
 * 
 */
package com.digitexx.ancestry.bean;

import com.digitexx.ancestry.util.StringUtil;

/**
 * @author lqnhu
 *
 */
public class XY_WH_SH_SV 
{
     private String x = "0";
     private String y = "0";
     private String w = "0";
     private String h = "0";
     private String sh = "0";
     private String sv = "0";
     
     public XY_WH_SH_SV() {
    	 
     }
     
     public XY_WH_SH_SV(String valueFocus) {
    	 
     }
     
     public XY_WH_SH_SV(String x , String y , String w, String h , String sh, String sv) {
    	 this.x = x;
    	 this.y = y;
    	 this.w = w;
    	 this.h = h;
         this.sh = sh;
    	 this.sv = sv;
     }
     

	/**
	 * @return the x
	 */
	public String getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(String x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public String getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(String y) {
		this.y = y;
	}

	/**
	 * @return the w
	 */
	public String getW() {
		return w;
	}

	/**
	 * @param w the w to set
	 */
	public void setW(String w) {
		this.w = w;
	}

	/**
	 * @return the h
	 */
	public String getH() {
		return h;
	}

	/**
	 * @param h the h to set
	 */
	public void setH(String h) {
		this.h = h;
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
	 * split value to field
	 */
	public XY_WH_SH_SV toObject(String value) 
	{
		value = StringUtil.setNotNull(value);
        if(value.equals("")) {
        	value = "0;0;0;0;0;0";
        }
        String[] arrTmp = value.split(";");
        x  = arrTmp[0].toString();
        y  = arrTmp[1].toString();
        w  = arrTmp[2].toString();
        h  = arrTmp[3].toString();
        sh = arrTmp[4].toString();
        sv = arrTmp[5].toString();
        
        return new XY_WH_SH_SV(x, y, w, h, sh, sv);
	}
     
    @Override
    public String toString() {
    	return x + ";" + y + ";" + w + ";" + h + ";" + sh + ";"+ sv;
    } 
    
    
}
