/**
 * 
 */
package com.digitexx.ancestry.table.render;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.table.TableCellEditor;

/**
 * @author lqnhu
 *
 */
@SuppressWarnings("serial")
public class TablePopupEditor extends DefaultCellEditor implements TableCellEditor {
	private PopupDialog popup;
	private String currentText = "";
	private JButton editorComponent;
	private String fieldname="";

	public TablePopupEditor(String fielname) {
		super(new JTextField());
        this.fieldname = fielname;
		setClickCountToStart(1);
		editorComponent = new JButton();
		editorComponent.setBackground(Color.white);
		editorComponent.setBorderPainted(false);
		editorComponent.setContentAreaFilled(false);
		editorComponent.setFocusable(false);
		popup = new PopupDialog();
	}

	public Object getCellEditorValue() {
		return currentText;
	}

	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				popup.setText(currentText);
				// popup.setLocationRelativeTo( editorComponent );
				Point p = editorComponent.getLocationOnScreen();
				popup.setLocation(p.x, p.y + editorComponent.getSize().height);
				popup.show();
				fireEditingStopped();
			}
		});

		currentText = value.toString();
		editorComponent.setText(currentText);
		return editorComponent;
	}

	/*
	 * Simple dialog containing the actual editing component
	 */
	class PopupDialog extends JDialog implements ActionListener {
		private JTextArea textArea;

		public PopupDialog() {
			super((Frame) null, fieldname , true);

			textArea = new JTextArea(5, 20);
			textArea.setLineWrap(true);
			textArea.setWrapStyleWord(true);
			textArea.setFont( new Font("Arial" , Font.PLAIN , 16));
			KeyStroke keyStroke = KeyStroke.getKeyStroke("ENTER");
			textArea.getInputMap().put(keyStroke, "none");
			JScrollPane scrollPane = new JScrollPane(textArea);
			getContentPane().add(scrollPane);

			JButton cancel = new JButton("Cancel");
			cancel.addActionListener(this);
			JButton ok = new JButton("Ok");
			ok.setPreferredSize(cancel.getPreferredSize());
			ok.addActionListener(this);

			JPanel buttons = new JPanel();
			buttons.add(ok);
			buttons.add(cancel);
			getContentPane().add(buttons, BorderLayout.SOUTH);
			pack();

			getRootPane().setDefaultButton(ok);
		}

		public void setText(String text) {
			textArea.setText(text);
		}

		public void actionPerformed(ActionEvent e) {
			if ("Ok".equals(e.getActionCommand())) {
				currentText = textArea.getText();
			}

			textArea.requestFocusInWindow();
			setVisible(false);
		}
	}


}
