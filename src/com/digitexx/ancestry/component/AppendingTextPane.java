package com.digitexx.ancestry.component;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.StyledDocument;

public class AppendingTextPane extends JTextPane {
	public AppendingTextPane() {
		super();
		// setBackground(new Color(FrmConfigColor.rgbBackGround));
		setBackground(Color.WHITE);

		KeyStroke tabKey = KeyStroke.getKeyStroke("TAB");
		getInputMap().put(tabKey, tabAction);
	}

	public AppendingTextPane(StyledDocument doc) {
		super(doc);
		KeyStroke tabKey = KeyStroke.getKeyStroke("TAB");
		getInputMap().put(tabKey, tabAction);
	}

	// Appends text to the document and ensure that it is visible
	public void appendText(String text) {
		try {
			Document doc = getDocument();

			// Move the insertion point to the end
			setCaretPosition(doc.getLength());

			// Insert the text
			replaceSelection(text);

			// Convert the new end location
			// to view co-ordinates
			Rectangle r = modelToView(doc.getLength());

			// Finally, scroll so that the new text is visible
			if (r != null) {
				scrollRectToVisible(r);
			}
		} catch (BadLocationException e) {
			System.out.println("Failed to append text: " + e);
		}
	}

	public void appendText(String text, int car, int lenReplace) {
		try {
			Document doc = getDocument();

			doc.remove(car + 1, lenReplace);
			// Move the insertion point to the end
			setCaretPosition(car + 1);

			// Insert the text
			replaceSelection(text);

			// Convert the new end location
			// to view co-ordinates
			Rectangle r = modelToView(doc.getLength());

			// Finally, scroll so that the new text is visible
			if (r != null) {
				scrollRectToVisible(r);
			}
		} catch (BadLocationException e) {
			System.out.println("Failed to append text: " + e);
		}
	}

	private AbstractAction tabAction = new AbstractAction() {
		public void actionPerformed(ActionEvent e) {
			// replace here with your own action
			replaceSelection("");
		}
	};

}
