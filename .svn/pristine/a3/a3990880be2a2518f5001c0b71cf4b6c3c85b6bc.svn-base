/**
 * 
 */
package com.digitexx.ancestry.util;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Set;

import javax.swing.*;
import javax.swing.table.*;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jxl.*;
import jxl.write.*;

public class ExcelExporter {

   public static void fillData(JTable table, File file , String sheetName) 
   {
        try {

            WritableWorkbook workbook1 = Workbook.createWorkbook(file);
            WritableSheet sheet1 = workbook1.createSheet(sheetName, 0); 
            TableModel model = table.getModel();

            for (int i = 0; i < model.getColumnCount(); i++) {
                Label column = new Label(i, 0, model.getColumnName(i));
                sheet1.addCell(column);
            }
            int j = 0;
            for (int i = 0; i < model.getRowCount(); i++) {
                for (j = 0; j < model.getColumnCount(); j++) {
                    Label row = new Label(j, i + 1, Objects.toString(model.getValueAt(i, j) , ""));
                    sheet1.addCell(row);
                }
            }
            workbook1.write();
            workbook1.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
   
	public void toExcel(JTable table, File file) {
		try {
			TableModel model = table.getModel();
			FileWriter excel = new FileWriter(file);

			for (int i = 0; i < model.getColumnCount(); i++) {
				excel.write(model.getColumnName(i) + "\t");
			}

			excel.write("\n");

			for (int i = 0; i < model.getRowCount(); i++) {
				for (int j = 0; j < model.getColumnCount(); j++) {
					excel.write(model.getValueAt(i, j).toString() + "\t");
				}
				excel.write("\n");
			}

			excel.close();

		} catch (IOException e) {
			System.out.println(e);
		}
	}
	

   
    //==========================================================================================================================

    public static void main(String[] args) {
        String[][] data = {{"Housewares", "Rs.1275.00"},
            {"Pets", "Rs.125.00"}, {"Electronics", "Rs.2533.00"},
            {"Menswear", "Rs.497.00"}
        };
        String[] headers = {"Department", "Daily Revenue"};

        JFrame frame = new JFrame("JTable to Excel");
        DefaultTableModel model = new DefaultTableModel(data, headers);
        final JTable table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);

        JButton export = new JButton("Export");
        export.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

                try {
                    ExcelExporter exp = new ExcelExporter();
                    exp.fillData(table, new File("D:\\result.xls"), "aaa");
                    JOptionPane.showMessageDialog(null, "Data saved at " +
                            "'D: \\ result.xls' successfully", "Message",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        frame.getContentPane().add("Center", scroll);
        frame.getContentPane().add("South", export);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }
}
