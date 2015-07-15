/**
 * 
 */
package com.digitexx.ancestry.gui.util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;

/**
 * @author lqnhu
 *
 */
public class OnlyNumberStyled extends DefaultStyledDocument 
{
	private static final long serialVersionUID = 3093902353691125962L;
	public OnlyNumberStyled() 
	{}
	public void insertString(int offs, String str, AttributeSet a)throws BadLocationException 
	{
		if (str == null)return;
		char[] chars = str.toCharArray();
		for(char tmp : chars)
		{
			if (((tmp < '0' || tmp > '9'))) return;
		}		
		super.insertString(offs, new String(chars), a);
	}
}
