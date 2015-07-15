package com.digitexx.ancestry.util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

@SuppressWarnings("serial")
public class NumberOnly extends PlainDocument {
	private int maxLength = 0;

	public NumberOnly() {
	}

	public NumberOnly(int maxLength) {
		this.maxLength = maxLength;
	}

	public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
		if (str == null) return;
		char[] chars = str.toCharArray();

		if (maxLength > 0) {
			for (int i = 0; i < chars.length; i++) {
				char tmp = chars[i];
				if (((tmp < '0' || tmp > '9'))
						|| (getLength() > maxLength - 1)) {
					return;
				}
			}
		} else {
			for (int i = 0; i < chars.length; i++) {
				if ((chars[i] < '0' || chars[i] > '9')) {
					return;
				}
			}
		}
		super.insertString(offs, new String(chars), a);
	}
}
