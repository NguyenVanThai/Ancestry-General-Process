/**
 * 
 */
package test;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

import com.digitexx.ancestry.table.render.ComboRenderer;
import com.digitexx.ancestry.table.render.EditableHeader;
import com.digitexx.ancestry.table.render.EditableHeaderTableColumn;
/**
 * @author lqnhu
 *
 */
@SuppressWarnings("serial")
public class EditableHeaderTableExample2 extends JFrame {

	  public EditableHeaderTableExample2() {
	    super("EditableHeader Example");

	    JTable table = new JTable(7, 5);
	    TableColumnModel columnModel = table.getColumnModel();
	    table.setTableHeader(new EditableHeader(columnModel));

	    String[] items = { "Dog", "Cat" };
	    JComboBox combo = new JComboBox();
	    for (int i = 0; i < items.length; i++) {
	      combo.addItem(items[i]);
	    }
	    ComboRenderer renderer = new ComboRenderer(items);

	    EditableHeaderTableColumn col;
	    // column 1
	    col = (EditableHeaderTableColumn) table.getColumnModel().getColumn(1);
	    col.setHeaderValue(combo.getItemAt(0));
	    col.setHeaderRenderer(renderer);
	    col.setHeaderEditor(new DefaultCellEditor(combo));

	    // column 3
	    col = (EditableHeaderTableColumn) table.getColumnModel().getColumn(3);
	    col.setHeaderValue(combo.getItemAt(0));
	    col.setHeaderRenderer(renderer);
	    col.setHeaderEditor(new DefaultCellEditor(combo));

	    JScrollPane pane = new JScrollPane(table);
	    getContentPane().add(pane);
	  }



	  public static void main(String[] args) {
	    EditableHeaderTableExample2 frame = new EditableHeaderTableExample2();
	    frame.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
	        System.exit(0);
	      }
	    });
	    frame.setSize(300, 100);
	    frame.setVisible(true);
	  }
	}






