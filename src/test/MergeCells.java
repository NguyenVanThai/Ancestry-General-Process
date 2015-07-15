/**
 * 
 */
package test;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Component;
import java.util.StringTokenizer;

/**
 * @author lqnhu
 * 
 */
class myCellRenderer extends JTextArea implements TableCellRenderer {

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {

		if (isSelected)
			setBackground(table.getSelectionBackground());
		else
			setBackground(Color.white);
		// set column height
		String stmp;
		StringTokenizer st;
		int rowHight = table.getRowHeight() + table.getRowMargin() + 1;
		int fold;

		stmp = (String) value;
		st = new StringTokenizer(stmp, "\n");
		fold = st.countTokens();
		if (table.getRowHeight(row) != fold * rowHight) {
			table.setRowHeight(row, fold * rowHight);
		}
		setLineWrap(true);
		setWrapStyleWord(true);
		setText(value.toString());

		return this;
	}
}

public class MergeCells extends JPanel {
	private boolean DEBUG = false;

	public MergeCells() {
		super(new GridLayout(1, 0));

		String[] columnNames = { "Persons", "Class" };

		Object[][] data = {
				{ "HugoJone \n Sep Dion \n Tom Saw\n Saron Xie", "Math" },
				{ "Harry Potter\n Alice Petty", "Musice" },
				{ "Tom Sawyer", "English" },
				{ "AliceWonder\n Taylor Emo \nJim Setty \n Emi learn ",
						"www.kidslovepc.com" } };

		final JTable table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		int cols = table.getColumnCount();
		myCellRenderer mcr = new myCellRenderer();
		TableColumn column;
		int i;

		// set first column multiple line
		column = table.getColumnModel().getColumn(0);
		column.setCellRenderer(mcr);

		// Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);

		// Add the scroll pane to this panel.
		add(scrollPane);
	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		JFrame.setDefaultLookAndFeelDecorated(true);

		// Create and set up the window.
		JFrame frame = new JFrame("SimpleTableDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		MergeCells newContentPane = new MergeCells();
		newContentPane.setOpaque(true); // content panes must be opaque
		frame.setContentPane(newContentPane);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

}
