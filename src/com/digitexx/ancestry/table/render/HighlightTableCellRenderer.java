/**
 * 
 */
package com.digitexx.ancestry.table.render;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

/**
 * @author lqnhu
 * 
 */
public class HighlightTableCellRenderer extends JTextPane implements TableCellRenderer 
{
	private static final long serialVersionUID = 1L;
	private static final Color BACKGROUND_SELECTION_COLOR = new Color(220, 240,255);
	private final transient Highlighter.HighlightPainter highlightPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
	private String pattern = "";
	private String prev;

	public boolean setPattern(String str) {
		if (str == null || str.equals(pattern)) {
			return false;
		} else {
			prev = pattern;
			pattern = str;
			return true;
		}
	}

	public HighlightTableCellRenderer() {
		super();
		setOpaque(true);
		setBorder(BorderFactory.createEmptyBorder());
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
		setEditable(false);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {

      String txt = Objects.toString(value, "");
      Highlighter highlighter = getHighlighter();
      highlighter.removeAllHighlights();
      setText(txt);
      setBackground(isSelected ? BACKGROUND_SELECTION_COLOR : Color.WHITE);
      if (pattern != null && !pattern.isEmpty() && !pattern.equals(prev)) {
          Matcher matcher = Pattern.compile(pattern).matcher(txt);
          if (matcher.find()) {
              int start = matcher.start();
              int end   = matcher.end();
              try {
                  highlighter.addHighlight(start, end, highlightPainter);
              } catch (BadLocationException | PatternSyntaxException e) {
                  e.printStackTrace();
              }
          }
      }
      setFont(new Font("Arial", Font.PLAIN, 16));
		return this;
	}
}
