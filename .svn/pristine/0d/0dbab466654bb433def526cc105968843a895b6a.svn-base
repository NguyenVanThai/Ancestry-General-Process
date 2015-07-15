/*
 * Created on Jun 15, 2005
 * @author Rafael Santos (rafael.santos@lac.inpe.br)
 * 
 * Part of the Java Advanced Imaging Stuff site
 * (http://www.lac.inpe.br/~rafael.santos/Java/JAI)
 * 
 * STATUS: Complete.
 * 
 * Redistribution and usage conditions must be done under the
 * Creative Commons license:
 * English: http://creativecommons.org/licenses/by-nc-sa/2.0/br/deed.en
 * Portuguese: http://creativecommons.org/licenses/by-nc-sa/2.0/br/deed.pt
 * More information on design and applications are on the projects' page
 * (http://www.lac.inpe.br/~rafael.santos/Java/JAI).
 */

package com.digitexx.ancestry.jai.util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.RenderedImage;

import javax.swing.JScrollPane;

/**
 * This class can be used to show a DEM image. It listens to mouse movements and
 * mouse clicks so the user can draw a line over the image to get a profile of
 * it (as an array of doubles). The profile can be displayed by an instance of
 * the class DisplayDEMProfile.
 */
public class DisplayLineSampleableDEM extends DisplayDEM implements MouseListener {

	private boolean displayLine; // should we show the profile line ?
	private double[] pixel; // used to get pixels from the image
	private double[] profile; // used to represent the profile
	private int nBands; // number of bands on the image

	public int x0, y0, x1, y1; // the 2 points that defines the sampling line

	private boolean firstSelected; // true if the first point was selected
	private boolean secondSelected; // true if the second point was selected

	private boolean displayRec;

	private JScrollPane scrollPane = null;
	public int xp, yp, xd, yd;
	public int pointY = 0; 


	/**
	 * The constructor of the class, which will pass it to the constructor of
	 * the superclass and set some user interface stuff.
	 */
	public DisplayLineSampleableDEM(RenderedImage image) {
		super(image);
		nBands = image.getSampleModel().getNumBands();
		pixel = new double[nBands];
		addMouseListener(this);
		// Set some other stuff in this application.
		firstSelected = false;
		secondSelected = false;
		setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
	}

	/**
	 * This method is used to set the start and end points of the line that
	 * represents the profile.
	 */
	public void setLine(int x0, int y0, int x1, int y1) {
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x1;
		this.y1 = y1;
		displayLine = true;
		repaint();
	}

	/**
	 * This method can be used when we don't want to draw the profile line
	 * anymore.
	 */
	public void unsetLine() {
		displayLine = false;
		repaint();
	}

	/**
	 * This method is responsible for painting the component. It will call the
	 * paintComponent of the ancestral class and display the profile sampling
	 * line as an arrow.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (displayRec) {
			/*
			 * Graphics2D g2d = (Graphics2D)g; g2d.setColor(new
			 * Color(255,255,0,150)); g2d.setStroke(new BasicStroke(2.0f));
			 * g2d.drawLine(x0,y0,x1,y1);
			 */

			// We can do a little cute arrowhead here:
			/*
			 * double angle = Math.atan2((y1-y0),(x1-x0)); int arrow_x0 =
			 * (int)(x1+Math.cos(angle-2.618)*25); int arrow_y0 =
			 * (int)(y1+Math.sin(angle-2.618)*25); int arrow_x1 =
			 * (int)(x1+Math.cos(angle+2.618)*25); int arrow_y1 =
			 * (int)(y1+Math.sin(angle+2.618)*25);
			 * g2d.drawLine(arrow_x0,arrow_y0,x1,y1);
			 * g2d.drawLine(arrow_x1,arrow_y1,x1,y1);
			 */

			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.RED);
			g2d.setStroke(new BasicStroke(2.0f));

			int width = x1 - x0;
			int height = y1 - y0;

			g2d.drawLine(x0, y0, x0 + width, y0);
			g2d.drawLine(x0 + width, y0, x0 + width, y0 + height);
			g2d.drawLine(x0, y0, x0, y0 + height);
			g2d.drawLine(x0, y0 + height, x0 + width, y0 + height);

		}

		/*
		 * if( !displayLine ){
		 * 
		 * Graphics2D g2d = (Graphics2D)g; g2d.setColor(new
		 * Color(255,255,0,150)); g2d.setStroke(new BasicStroke(2.0f));
		 * 
		 * int x = x0 ; int y = y0 ; int width = x1 - x0 ; int height = y1 - y0
		 * ;
		 * 
		 * g2d.drawLine(x0 , y0 , x0+ width ,y0); g2d.drawLine(x0+width , y0 ,
		 * x0+width , y0 + height ); g2d.drawLine(x0,y0,x0,y0+height);
		 * g2d.drawLine(x0,y0+height,x0+width , y0 + height);
		 * 
		 * 
		 * }
		 */

	}

	/**
	 * This method will be called when the mouse is clicked.
	 */
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1)
		{
			displayRec = true;
			int x, y, w, h,vScroll;
			y = e.getY();
			x = 0;
			w = 5000;
			h = 1;
			setLine(x, y, w, h);
		}
	}
	
	

	/**
	 * This method does not do anything, it is here just to keep the
	 * MouseListener interface happy.
	 */
	public void mouseEntered(MouseEvent e) {

	}

	public void mouseDragged(MouseEvent e) {

		int xd = e.getX() - xp;
		int yd = e.getY() - yp;
		scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getValue() - yd);
		scrollPane.getHorizontalScrollBar().setValue(scrollPane.getHorizontalScrollBar().getValue() - xd);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

	}

	/**
	 * This method does not do anything, it is here just to keep the
	 * MouseListener interface happy.
	 */
	public void mouseExited(MouseEvent e) {
	}

	/**
	 * This method does not do anything, it is here just to keep the
	 * MouseListener interface happy.
	 */
	public void mousePressed(MouseEvent e) {
		
		xp = e.getX();
		yp = e.getY();
	}

	/**
	 * This method does not do anything, it is here just to keep the
	 * MouseListener interface happy.
	 */
	public void mouseReleased(MouseEvent e) {
	}

	/**
	 * This method returns the sampled data under the profile line. Note that
	 * this method should not be called before the line is sampled.
	 */
	public double[] getProfile() {
		return profile;
	}

	/**
	 * This method returns true if the data is ready to be collected.
	 */
	public boolean dataIsReady() {
		return secondSelected;
	}

	/**
	 * This method samples the data and return an array with the pixels' values.
	 */
	private double[] sampleData() {
		// We cannot estimate precisely how many data points will be needed.
		// A very safe estimate is three pixels times the length of the line.
		int len = 3 * (int) Math.sqrt((y1 - y0) * (y1 - y0) + (x1 - x0)* (x1 - x0));
		// Get a temporary array for the sampled points.
		double[] tempData = new double[len];
		// We need to get the data points on that line. We cannot do that with
		// ROIs,
		// so let's use the good old Digital Differential Analyzer Algorithm to
		// sample the pixel on the line between the two collected points.
		// Reference: http://graphics/csail.mit.edu/classes/6.837/F01/Lecture04
		int deltaX = x1 - x0;
		int deltaY = y1 - y0;
		int dxAbs = Math.abs(deltaX);
		int dyAbs = Math.abs(deltaY);
		int signalX = 0;
		if (deltaX > 0)
			signalX = 1;
		else if (deltaX < 0)
			signalX = -1;
		int signalY = 0;
		if (deltaY > 0)
			signalY = 1;
		else if (deltaY < 0)
			signalY = -1;
		int x = dyAbs >> 1; // integer division by 2
		int y = dxAbs >> 1;
		int px = x0;
		int py = y0;
		int cont = 0;
		// Get the first point
		
		readIterator.getPixel(px, py, pixel);
		tempData[cont++] = pixel[0];
		if (dxAbs >= dyAbs) // The line is more horizontal than vertical
		{
			for (int i = 0; i < dxAbs; i++) 
			{
				y += dyAbs;
				if (y >= dxAbs) {
					y -= dxAbs;
					py += signalY;
				}
				px += signalX;
				readIterator.getPixel(px, py, pixel); // get the next points
				tempData[cont++] = pixel[0];
			}
		}
		else // The line is more vertical than horizontal
		{
			for (int i = 0; i < dyAbs; i++) {
				x += dxAbs;
				if (x >= dyAbs) {
					x -= dyAbs;
					px += signalX;
				}
				py += signalY;
				readIterator.getPixel(px, py, pixel); // get the next points
				tempData[cont++] = pixel[0];
			}
		}
		// Since the number of collected points is smaller than the number
		// of points in the temporary array, we copy it to the smaller one.
		double[] data = new double[cont];
		for (int elem = 0; elem < cont; elem++)
			data[elem] = tempData[elem];
		return data;
	}

	/**
	 * @return the scrollPane
	 */
	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	/**
	 * @param scrollPane
	 *            the scrollPane to set
	 */
	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

}