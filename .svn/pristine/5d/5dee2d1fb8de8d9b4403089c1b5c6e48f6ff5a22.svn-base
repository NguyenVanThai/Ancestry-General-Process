package test;
//-*- mode:java; encoding:utf-8 -*-
// vim:set fileencoding=utf-8:
//http://ateraimemo.com/Swing/TableHeaderCheckBox.html
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import com.digitexx.ancestry.table.render.HeaderCheckBoxHandler;
import com.digitexx.ancestry.table.render.HeaderRenderer;

public final class CheckAllJtable extends JPanel {
    private static final int MODEL_COLUMN_INDEX = 0;
    private final Object[] columnNames = {"", "Integer", "String"};
    private final Object[][] data = {
        {true, 1, "BBB"}, {false, 12, "AAA"},
        {true, 2, "DDD"}, {false,  5, "CCC"},
        {true, 3, "EEE"}, {false,  6, "GGG"},
        {true, 4, "FFF"}, {false,  7, "HHH"}
    };
    private final DefaultTableModel model = new DefaultTableModel(data, columnNames) {
        @Override public Class<?> getColumnClass(int column) {
            return getValueAt(0, column).getClass();
        }
    };
    private final JTable table = new JTable(model) {
    };

    public CheckAllJtable() {
        super(new BorderLayout());

        TableCellRenderer renderer = new HeaderRenderer(table.getTableHeader(), MODEL_COLUMN_INDEX);
        table.getColumnModel().getColumn(MODEL_COLUMN_INDEX).setHeaderRenderer(renderer);
        model.addTableModelListener(new HeaderCheckBoxHandler(table, MODEL_COLUMN_INDEX));

        add(new JScrollPane(table));
        setPreferredSize(new Dimension(320, 240));
    }

    public static void main(String... args) {
        EventQueue.invokeLater(new Runnable() {
            @Override public void run() {
                createAndShowGUI();
            }
        });
    }
    public static void createAndShowGUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException
               | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        JFrame frame = new JFrame("TableHeaderCheckBox");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(new CheckAllJtable());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

