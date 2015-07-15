/**
 * 
 */
package com.digitexx.ancestry.jai.util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.RenderedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import com.digitexx.ancestry.conts.ContsColor;

/**
 * @author lqnhu
 *
 */
public class DisplayImageJAI extends DisplayDEM implements MouseListener{

	private static final long serialVersionUID = 1L;
	private boolean displayLine; // should we show the profile line ?
	private double[] pixel; // used to get pixels from the image
	private double[] profile; // used to represent the profile
	private int nBands; // number of bands on the image

	public String recColor = ContsColor.RED ; // default

	public int anchorX = 0 , anchorY = 0 ;

	/** the 2 points that defines the rectangle
	      this is ralative coordinate to Anchor Position **/    	  
	public int x0,y0,x1,y1; 

	private boolean firstSelected; // true if the first point was selected
	private boolean secondSelected; // true if the second point was selected

	public boolean displayRec = true;
	
	/**
	 * var define to drag, resize for Rectangle
	 */
	protected int frameWidth = 5;
	protected int startDragX,  startDragY;
	protected boolean resizeLeft,  resizeTop,  resizeRight,  resizeBottom,  move;
	protected int selX, selY, selW, selH;
	public Rectangle rect = null;
	private List<Rectangle> listRect = new ArrayList<Rectangle>();
	private List<Integer> listZoom = new ArrayList<Integer>();
	private int iZoom = 10;
	boolean pressOut = false;
	private int preX, preY;
	private boolean moving;
	protected int minSize = 5;
	private Point startPoint;
	public boolean preRange = false;
	public String  thongbao;
	public int prx0, pry0, prwidth, prheight;
	private JScrollPane scrollPane;
	
	/**
	 * The constructor of the class, which will pass it to the constructor of the
	 * superclass and set some user interface stuff.
	 */
	public DisplayImageJAI(RenderedImage image){

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
	 **/
	public void setLine(int x0,int y0,int x1,int y1){

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
	 **/
	public void unsetLine(){

		displayLine = false;
		repaint();
	}


	/**
	 * This method is responsible for painting the component. It will call
	 * the paintComponent of the ancestral class and display the profile sampling
	 * line as an arrow.
	 */
	public void paintComponent(Graphics g){

		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D)g;
		if(ContsColor.RED.equals(recColor) ){
			g2d.setColor(Color.RED );
		}
		else if (ContsColor.BLUE.equals(recColor) ){
			g2d.setColor(Color.BLUE );
		}
		else {
			g2d.setColor(Color.BLACK );
		}

		g2d.setStroke(new BasicStroke(2.0f));
		
		if ( displayRec ){
			
			int width  = x1 - x0 ; 
			int height = y1 - y0 ; 

			int x0_withAnchor = anchorX + x0 ;
			int y0_withAnchor = anchorY + y0 ; 
			
			if((width >= 10 || width <= -10) || (height >= 10 || height <= -10)){
				Rectangle[] squares = createSquares(new Rectangle(x0_withAnchor, y0_withAnchor, width , height));
	            for (Rectangle square : squares) {
	                g2d.draw(square);
	            }
			}			
			//g2d.drawRect(x0_withAnchor, y0_withAnchor, width , height);
			g2d.drawLine(x0_withAnchor, y0_withAnchor, x1, y0_withAnchor);
			g2d.drawLine(x0_withAnchor, y0_withAnchor, x0_withAnchor, y1);
			g2d.drawLine(x1, y0_withAnchor, x1, y1);
			g2d.drawLine(x0_withAnchor, y1, x1, y1);
			
			if(preRange) {
				g2d.setStroke(new BasicStroke(3.0f));
				g2d.setColor(Color.green);
				g2d.setFont(new Font("Tahoma", Font.BOLD, 20));
				//rect = new Rectangle(anchorX, anchorY, width, height);
				if(rect != null) {					
				//	g2d.draw(rect);
					g2d.drawRect(prx0, pry0, prwidth, prheight);
					//g2d.drawString(thongbao,prx0 + 20, pry0 + 100);
				}
			}
//			
//			for (int i = 0; i < listRect.size(); i++) {
//				g2d.setColor(Color.WHITE );
//				g2d.fillRect(
//						(listRect.get(i).x*iZoom)/listZoom.get(i), 
//						(listRect.get(i).y*iZoom)/listZoom.get(i), 
//						(listRect.get(i).width*iZoom)/listZoom.get(i), 
//						(listRect.get(i).height*iZoom)/listZoom.get(i));
//			}
		}

	}
	
	public void paintComponent1(Graphics g){

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;

		if(ContsColor.RED.equals(recColor) ){
			g2d.setColor(Color.RED );
		}
		else if (ContsColor.BLUE.equals(recColor) ){
			g2d.setColor(Color.BLUE );
		}
		else {
			g2d.setColor(Color.BLACK );
		}

		g2d.setStroke(new BasicStroke(2.0f));
		
		if ( displayRec ){

			int width  = x1 - x0 ; 
			int height = y1 - y0 ; 

			int x0_withAnchor = anchorX + x0 ;
			int y0_withAnchor = anchorY + y0 ; 
			
			if((width >= 10 || width <= -10) || (height >= 10 || height <= -10)){
				Rectangle[] squares = createSquares(new Rectangle(x0_withAnchor, y0_withAnchor, width , height));
	            for (Rectangle square : squares) {
	                g2d.draw(square);
	            }
			}			
			//g2d.drawRect(x0_withAnchor, y0_withAnchor, width , height);
			g2d.drawLine(x0_withAnchor, y0_withAnchor, x1, y0_withAnchor);
			g2d.drawLine(x0_withAnchor, y0_withAnchor, x0_withAnchor, y1);
			g2d.drawLine(x1, y0_withAnchor, x1, y1);
			g2d.drawLine(x0_withAnchor, y1, x1, y1);
			
			if(preRange) {
				g2d.setStroke(new BasicStroke(3.0f));
				g2d.setColor(Color.green);
				g2d.setFont(new Font("Tahoma", Font.BOLD, 20));
				//rect = new Rectangle(anchorX, anchorY, width, height);
				if(rect != null) {					
				//	g2d.draw(rect);
					g2d.draw3DRect(prx0, pry0, prwidth, prheight, true);
					g2d.drawString(thongbao,prx0 + 20, pry0 + 100);
				}
			}
//			
//			for (int i = 0; i < listRect.size(); i++) {
//				g2d.setColor(Color.WHITE );
//				g2d.fillRect(
//						(listRect.get(i).x*iZoom)/listZoom.get(i), 
//						(listRect.get(i).y*iZoom)/listZoom.get(i), 
//						(listRect.get(i).width*iZoom)/listZoom.get(i), 
//						(listRect.get(i).height*iZoom)/listZoom.get(i));
//			}
		}

	}
	
	/**
	 * x0,y0,x1,y1 is relative coordinate to Anchor Position
	 * 
	 * @param x0  
	 * @param y0
	 * @param x1
	 * @param y1
	 */
	public void drawRecangle( int x0 , int y0 , int x1 , int y1 )
	{
		this.x0 = x0 ;
		this.y0 = y0 ; 
		this.x1 = x1 ;
		this.y1 = y1 ; 

		displayRec = true ;
		repaint() ;    		  
	}
	
	/**
	 * create squares
	 */
	protected Rectangle[] createSquares(Rectangle rect) {
		
		ArrayList<Rectangle> ar = new ArrayList<Rectangle>();
		if(displayRec){
			int wh = 6;

			int x = rect.x - wh / 2;
			int y = rect.y - wh / 2;
			int w = rect.width;
			int h = rect.height;
			
			ar.add(new Rectangle(x, y, wh, wh));
			ar.add(new Rectangle(x + w / 2, y, wh, wh));
			ar.add(new Rectangle(x + w, y, wh, wh));
			ar.add(new Rectangle(x + w, y + h / 2, wh, wh));
			ar.add(new Rectangle(x + w, y + h, wh, wh));
			ar.add(new Rectangle(x + w / 2, y + h, wh, wh));
			ar.add(new Rectangle(x, y + h, wh, wh));
			ar.add(new Rectangle(x, y + h / 2, wh, wh));
		}
		return ar.toArray(new Rectangle[ar.size()]);
	}

	/**
	 * This method will be called when the mouse is clicked.
	 */
	public void mouseClicked(MouseEvent e){

		if (rect != null) {
			if (!rect.contains(e.getPoint())) {
				rect = null;
				//startPoint = null;
				if (!firstSelected){ // we don't have any point yet so let's get it

					/*x0 = e.getX() - anchorX ;
					y0 = e.getY() - anchorY ;*/
					x1 = x0 + 2 ;
					y1 = y0 + 2 ;

					firstSelected = true;
					secondSelected = false;
					setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));

					displayRec = true;

					repaint();

				}
				else if (!secondSelected) {// we have the first point so let's get the second

					x1 = e.getX() - anchorX ;
					y1 = e.getY() - anchorY ;
					x0 = x1-2 ;
					y0 = y1-2 ;

					firstSelected = false;
					secondSelected = true;
					setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
					displayRec = true;

					repaint();
				}
				
				repaint();
			}
		}
		
		
	}  


	/** This method does not do anything, it is here just to keep the MouseListener interface happy. **/    	  
	public void mouseEntered(MouseEvent e) {}


	/** Only show cursor posssition **/
	public void mouseMoved(MouseEvent me) {

		if( me.isControlDown()){

			setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			/** update anchor position label of current anchor **/
			//anchorX = me.getX() ;
			//anchorY = me.getY() ;
		
		}else {
			
			if(x1 - x0 < 0){
				int x = x0;
				x0 = x1;
				x1 = x;
			}
			if(y1 - y0 < 0){
				int y = y0;
				y0 = y1;
				y1 = y;
			}
			
			rect = new Rectangle(anchorX + x0, anchorY + y0, x1 - x0, y1 - y0);
			
			if (rect.width > 10 || rect.height > 10) {
				int rectX = rect.x;
				int rectY = rect.y;
				int rectW = rect.width;
				int rectH = rect.height;

				Rectangle leftFrame = new Rectangle(rectX, rectY, frameWidth, rectH);
				Rectangle topFrame = new Rectangle(rectX, rectY, rectW, frameWidth);
				Rectangle rightFrame = new Rectangle(rectX + rectW - frameWidth, rectY, frameWidth, rectH);
				Rectangle bottomFrame = new Rectangle(rectX, rectY + rectH - frameWidth, rectW, frameWidth);

				Point p = me.getPoint();

				boolean isInside = rect.contains(p);
				boolean isLeft = leftFrame.contains(p);
				boolean isTop = topFrame.contains(p);
				boolean isRight = rightFrame.contains(p);
				boolean isBottom = bottomFrame.contains(p);

				if (isLeft && isTop) {
					setCursor(Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR));
				} else if (isTop && isRight) {
					setCursor(Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR));
				} else if (isRight && isBottom) {
					setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));
				} else if (isBottom && isLeft) {
					setCursor(Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR));
				} else if (isLeft) {
					setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
				} else if (isTop) {
					setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
				} else if (isRight) {
					setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
				} else if (isBottom) {
					setCursor(Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR));
				} else if (isInside) {
					setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
				} else {
					setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
				}
			} else {
				setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
			}
		}

		repaint() ;

		super.mouseMoved(me);
	}

	/** Draw Rectangle when user drag mouse **/    	   
	public void mouseDragged(MouseEvent me) {
		
		
		if(SwingUtilities.isRightMouseButton(me))
		{
			int xd = me.getX() - x0;
			int yd = me.getY() - y0;

			scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getValue() - yd);
			scrollPane.getHorizontalScrollBar().setValue(scrollPane.getHorizontalScrollBar().getValue() - xd);
			setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			
		}else {
		
		prx0 = 0;
		pry0 =0;
		prwidth =0 ;
		prheight= 0;
		
		if (rect == null) {
			rect = new Rectangle();
		} else {
			
			int x = me.getX()  ; 
			int y = me.getY() ;

			if (pressOut) { // resize
				rect.x = Math.min(startPoint.x, x);
				rect.y = Math.min(startPoint.y, y);
				rect.width = Math.abs(x - startPoint.x);
				rect.height = Math.abs(y - startPoint.y);
				moving = true;
				repaint();
			} else { // move

				int diffX = startDragX - x;
				int diffY = startDragY - y;

				if (resizeLeft) {
					rect.x = selX - diffX;
					rect.width = selW + diffX;
				}

				if (resizeTop) {
					rect.y = selY - diffY;
					rect.height = selH + diffY;
				}

				if (resizeRight) {
					rect.width = selW - diffX;
				}

				if (resizeBottom) {
					rect.height = selH - diffY;
				}

				if (move) {
					moving = true;
					rect.setLocation(preX + x, preY + y);
				}

				
				
				if (rect.width > minSize && rect.height > minSize) {
					x0 = rect.x - anchorX;
					y0 = rect.y - anchorY;
					x1 =  x0 + rect.width;
					y1 =  y0 + rect.height;
					
					displayRec = true  ;
					repaint();
				}
			}
		}

		// relative coordinate of X1,Y1 to Anchor Position    		  
		/*x1 =  me.getX()- anchorX  ; 
		y1 =  me.getY() - anchorY ; 
		
		displayRec = true  ;

		repaint() ;*/
		}

		super.mouseDragged(me);
		

	}


	/**
	 * This method does not do anything, it is here just to keep the MouseListener interface happy.
	 */
	public void mouseExited(MouseEvent e) { }

	/**
	 * This method does not do anything, it is here just to keep the MouseListener interface happy.
	 */
	public void mousePressed(MouseEvent e) {
		
		if (SwingUtilities.isLeftMouseButton(e))
		{
			//System.out.println(e.toString());
			startPoint = e.getPoint();
			x0 = e.getX() - anchorX ;
			y0 = e.getY() - anchorY ;
			
			if (rect == null) {
				pressOut = true;
				//startPoint = e.getPoint();
			} else {
				selX = rect.x;
				selY = rect.y;
				selW = rect.width;
				selH = rect.height;

				Rectangle leftFrame = new Rectangle(selX, selY, frameWidth, selH);
				Rectangle topFrame = new Rectangle(selX, selY, selW, frameWidth);
				Rectangle rightFrame = new Rectangle(selX + selW - frameWidth, selY, frameWidth, selH);
				Rectangle bottomFrame = new Rectangle(selX, selY + selH - frameWidth, selW, frameWidth);

				Point p = e.getPoint();

				boolean isInside = rect.contains(p);
				boolean isLeft = leftFrame.contains(p);
				boolean isTop = topFrame.contains(p);
				boolean isRight = rightFrame.contains(p);
				boolean isBottom = bottomFrame.contains(p);

				if (isLeft && isTop) {
					resizeLeft = true;
					resizeTop = true;
					resizeRight = false;
					resizeBottom = false;
					move = false;
				} else if (isTop && isRight) {
					resizeLeft = false;
					resizeTop = true;
					resizeRight = true;
					resizeBottom = false;
					move = false;
				} else if (isRight && isBottom) {
					resizeLeft = false;
					resizeTop = false;
					resizeRight = true;
					resizeBottom = true;
					move = false;
				} else if (isBottom && isLeft) {
					resizeLeft = true;
					resizeTop = false;
					resizeRight = false;
					resizeBottom = true;
					move = false;
				} else if (isLeft) {
					resizeLeft = true;
					resizeTop = false;
					resizeRight = false;
					resizeBottom = false;
					move = false;
				} else if (isTop) {
					resizeLeft = false;
					resizeTop = true;
					resizeRight = false;
					resizeBottom = false;
					move = false;
				} else if (isRight) {
					resizeLeft = false;
					resizeTop = false;
					resizeRight = true;
					resizeBottom = false;
					move = false;
				} else if (isBottom) {
					resizeLeft = false;
					resizeTop = false;
					resizeRight = false;
					resizeBottom = true;
					move = false;
				} else if (isInside) {
					resizeLeft = false;
					resizeTop = false;
					resizeRight = false;
					resizeBottom = false;
					move = true;
				} else {
					resizeLeft = false;
					resizeTop = false;
					resizeRight = false;
					resizeBottom = false;
					move = false;
				}

				int x = e.getX();
				int y = e.getY();

				startDragX = x;
				startDragY = y;

				preX = rect.x - startDragX;
				preY = rect.y - startDragY;

				if (!rect.contains(p)) {
					startPoint = p;
					pressOut = true;
				}

			}
		}
	
		if(SwingUtilities.isRightMouseButton(e)) {
			x0 = e.getX();
			y0 = e.getY();
		}
	}

	/**
	 * This method does not do anything, it is here just to keep the MouseListener interface happy.
	 */
	public void mouseReleased(MouseEvent e) { 
		if (rect != null) {
			moving = false;
			pressOut = false;
			repaint();
		}
	}

	/**
	 * This method returns the sampled data under the profile line.
	 * Note that this method should not be called before the line is sampled.
	 */
	public double[] getProfile(){

		return profile;
	}

	/**
	 * This method returns true if the data is ready to be collected.
	 */
	public boolean dataIsReady(){

		return secondSelected;
	}
	
	public void cropImage(int zoom){
		if(rect != null){
			listRect.add(rect);
			listZoom.add(zoom);
		}
//		x0 = 0;
//		y0 = 0;
//		x1 = 0;
//		y1 = 0;
//		rect = null;

		repaint();
	}
	
	public void setZoom(int iZoom){
		this.iZoom = iZoom;
	}
	
	public void clearSelection(){
		listRect.clear();
		listZoom.clear();
		repaint();
	}

	/**
	 * @return the scrollPane
	 */
	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	/**
	 * @param scrollPane the scrollPane to set
	 */
	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}
	
	

}
