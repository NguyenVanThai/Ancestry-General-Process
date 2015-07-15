/**
 * 
 */
package com.digitexx.ancestry.jai.util;

import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.ParameterBlock;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.media.jai.BorderExtender;
import javax.media.jai.Interpolation;
import javax.media.jai.InterpolationNearest;
import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.text.html.ImageView;

import com.digitexx.ancestry.util.Configuration;
import com.sun.media.imageio.plugins.jpeg2000.J2KImageReadParam;

/**
 * @author lqnhu
 *
 */
public class ImageUtil {
	
	private PlanarImage originalImage;
	protected PlanarImage zoomedImage;
	//private boolean displayRec;
	protected static int iZoom = 60;
	protected int iZoomStep = 10;
	int alphaY = 0;
	int oldh = 0;
	int oldv = 0;
	private int iExt = 0;
	int x1 = 0;
	int x2 = 0;
	int y1 = 0;
	int y2 = 0;
	int currh = 0;
	int currv = 0;
	
	private int xM = 0, yM = 0;
	private boolean displayRec;
	
	public DisplayLineSampleableDEM imageCanvas ;
	
	public ImageUtil()
	{
		imageCanvas = new DisplayLineSampleableDEM(loadImage("image/logo.jpg "));
	}
	
	private PlanarImage zoomJPG(int iWantedZoom) {
		PlanarImage zoomedOrgImage = null;
		PlanarImage rotatedOrgImage = null;
		ParameterBlock pb = new ParameterBlock();
		rotatedOrgImage = originalImage;
		pb.addSource(rotatedOrgImage);
		int ZOOM_DEFAUL = 100;
		if (iWantedZoom < 100) {
            if (iWantedZoom > 30) {
                pb.add((double) iWantedZoom / ZOOM_DEFAUL);
                pb.add((double) iWantedZoom / ZOOM_DEFAUL);
                pb.add(0.0F);
                pb.add(0.0F);
                pb.add(Interpolation.getInstance(Interpolation.INTERP_BICUBIC_2));
                Map<RenderingHints.Key, Object> map = new HashMap<RenderingHints.Key, Object>();
                map.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                map.put(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
                map.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
                map.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                map.put(RenderingHints.KEY_TEXT_LCD_CONTRAST, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
                map.put(JAI.KEY_BORDER_EXTENDER, BorderExtender.createInstance(BorderExtender.BORDER_COPY));
                RenderingHints qualityHints = new RenderingHints(map);
                zoomedOrgImage = JAI.create("SubsampleAverage", pb, qualityHints);
            } else {
                pb.add((float) iWantedZoom / ZOOM_DEFAUL);
                pb.add((float) iWantedZoom / ZOOM_DEFAUL);
                pb.add(0.0F);
                pb.add(0.0F);
                pb.add(Interpolation.getInstance(Interpolation.INTERP_BICUBIC_2));
                zoomedOrgImage = JAI.create("scale", pb, null);
            }
        } else {
            pb.add((float) iWantedZoom / ZOOM_DEFAUL);
            pb.add((float) iWantedZoom / ZOOM_DEFAUL);
            pb.add(0.0F);
            pb.add(0.0F);
            pb.add(Interpolation.getInstance(Interpolation.INTERP_NEAREST));
            zoomedOrgImage = JAI.create("scale", pb, null);
        }
		zoomedImage = zoomedOrgImage;
		return zoomedOrgImage;
	}
	
	private PlanarImage zoom(int iWantedZoom) 
	{
		PlanarImage zoomedOrgImage = null;
		PlanarImage rotatedOrgImage = null;
		ParameterBlock pb = new ParameterBlock();
		rotatedOrgImage = originalImage;
		pb.addSource(rotatedOrgImage);
		pb.add((float) iWantedZoom / 100);
		pb.add((float) iWantedZoom / 100);
		pb.add(0.0F);
		pb.add(0.0F);
		pb.add(new InterpolationNearest());
		
		zoomedOrgImage = JAI.create("scale", pb, null);
		zoomedImage = zoomedOrgImage;
		return zoomedOrgImage;
	}
	
	
	public PlanarImage loadBackgroundImage() {

		PlanarImage source = null;

		int width = 1;
		int height = 1;
		BufferedImage bufferImage = new BufferedImage(width, height,BufferedImage.TYPE_INT_ARGB);

		/* Image bufferImage = createImage(1 , 1 ); */
		// source = JAI.create("AWTImage", bufferImage);
		ParameterBlock pbIDCT = (new ParameterBlock()).addSource(bufferImage);
		source = JAI.create("idct", pbIDCT, null);

		// set orgininalImage
		originalImage = source;
		zoomedImage = source;
		// zoom with current setting of application
		iZoom = 100;
		return zoom(iZoom);

	}
	
	public static PlanarImage readJ2KToPlanarImage(String imageName){
        try {
//            ImageInputStream in = ImageIO.createImageInputStream(new File(imageName));
//            javax.imageio.ImageReader reader = ImageIO.getImageReaders(in).next();
//            reader.setInput(in);
           
//            SeekableStream s = new FileSeekableStream(imageName);
           
            J2KImageReadParam param = new J2KImageReadParam();
           
            ParameterBlock pb = new ParameterBlock();
            pb.add(imageName);
            pb.add(new Integer(0));
            pb.add(new Boolean(true)); // Read
            pb.add(new Boolean(true));
            pb.add(new Boolean(false)); //
            pb.add(null); // Add
            pb.add(null); // Locale
            pb.add(param);
            pb.add(null); //
           
            /**
             * in current this image is 8 bit per inch
             */
            PlanarImage imae = JAI.create("ImageRead", pb, null);//PlanarImage.wrapRenderedImage(reader.read(0, param));
           
            return imae;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
	
	public PlanarImage loadImage(String filePath) {

		PlanarImage source = null;
		
		try {

			if (filePath != null) {
				
				if(filePath.endsWith(".j2k")) source = readJ2KToPlanarImage(filePath);
				else source = PlanarImage.wrapRenderedImage(getJ2kImage(filePath));
				
				originalImage = source;
				zoomedImage = source;
				return zoom(iZoom);

			} else {
				return loadBackgroundImage();
			}

		} catch (Exception e) {
			return loadBackgroundImage();
		}
	}
	
	public PlanarImage loadImageJPG(String filePath) {
		//System.out.println(filePath);
		
		PlanarImage source = null;
		try {

			filePath = Configuration.changePlatfom(filePath);
			
			if (filePath != null) {
				ParameterBlock pb = new ParameterBlock();
				pb.add(filePath);
				source = JAI.create("fileload", pb);
				
				// set orgininalImage
				originalImage = source;
				zoomedImage = source;				
				// zoom with current setting of application
				return zoomJPG(iZoom);

			} else {
				return loadBackgroundImage();

			}

		} catch (Exception e) {

			return loadBackgroundImage();
		}

	}
	
	private void drawRec(int x, int y, int w, int h) {

		if(imageCanvas.getScrollPane() == null)
		{
			return;
		}
			imageCanvas.x0 = x;
			imageCanvas.y0 = y;
			imageCanvas.x1 = x + w;
			imageCanvas.y1 = y + h;

			int v_scroll = 0;
			int h_scroll = 0;

			imageCanvas.getScrollPane().getVerticalScrollBar().setValue(v_scroll + alphaY);
			imageCanvas.getScrollPane().getHorizontalScrollBar().setValue(h_scroll);
			
			//displayRec = true;
			imageCanvas.repaint();

	}
	
	private void drawWhenZoom() {

		// draw image
		int x, y, w, h;

		x = 10;
		y = 10+ alphaY;
		w = 10;
		h = 10;

		// Draw with zoom

		x = (int) (x * iZoom) / 80;
		y = (int) (y * iZoom) / 80;
		w = (int) (w * iZoom) / 80;
		h = (int) (h * iZoom) / 80;

		// draw rectangle
		drawRec(x, y, w, h);

	}
	
	private PlanarImage rotate(int iAngle) {

		/** Begin rotate * */
		boolean bLandscape = true;
		float fDelta = (float) (zoomedImage.getWidth())
				- (float) (zoomedImage.getHeight());
		if (fDelta < 0) {
			bLandscape = false;
			fDelta = Math.abs(fDelta);
		}
		fDelta /= 2;
		ParameterBlock pb = new ParameterBlock();
		pb.addSource(zoomedImage);
		pb.add((float) zoomedImage.getWidth() / 2);
		pb.add((float) zoomedImage.getHeight() / 2);
		pb.add((float) (iAngle * (Math.PI / 180.0F)));
		pb.add(new InterpolationNearest());

		PlanarImage p = JAI.create("Rotate", pb, null);

		pb = new ParameterBlock();
		pb.addSource(p);
		if (iAngle % 180 == 90 || iAngle % 180 == -90) {
			if (bLandscape) {
				pb.add(-fDelta);
				pb.add(fDelta);
			} else {
				pb.add(fDelta);
				pb.add(-fDelta);
			}
		} else {
			pb.add(0F);
			pb.add(0F);
		}

		pb.add(Interpolation.getInstance(Interpolation.INTERP_NEAREST)); // The

		// interpolation
		return JAI.create("translate", pb, null);
	}
	
	private PlanarImage doZoom(int iWantedZoom) throws Exception {
		zoom(iWantedZoom);
		return rotate(iExt);
	}
	
	private void doRotate(int iAngle) throws Exception {

		/** Zoom before rotate * */
		zoom(iZoom);
		
		/** Begin rotate * */
		imageCanvas.set(rotate(iAngle));
	}
	
	@SuppressWarnings("unused")
	private void rotateImage() {

		String strValue = JOptionPane.showInputDialog("Enter an wanted angle to rotate");

		if ("".equals(strValue) || strValue == null)
			return;

		try {
			int iRotateTmp = Integer.parseInt(strValue);
			if (iRotateTmp != 0) {

				doRotate(iRotateTmp);
				iExt = iRotateTmp;
			} else {
					imageCanvas.set(zoom(iZoom));
			}

		} 
		catch (NumberFormatException nbex) 
		{
//			AppUtility.msgWaring("Input is invalid number !!");
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
//			AppUtility.msgWaring("Input is invalid number !!");
		}


	}
	
	public RenderedImage getJ2kImage(String imageName) 
	{
		//System.out.println(imageName);
		try {
			ImageInputStream in = ImageIO.createImageInputStream(new File(imageName));
			ImageReader reader = ImageIO.getImageReaders(in).next();
			reader.setInput(in);

			J2KImageReadParam param = new J2KImageReadParam();
			if(imageName.contains("087_120926_Ancestry_40087"))
			{
				param.setResolution(4);
			}
			else{
				param.setResolution(8);
			}
			
			RenderedImage image = reader.read(0, param);
			return image;

		} catch (IOException ex) {
			Logger.getLogger(ImageView.class.getName()).log(Level.SEVERE, null,ex);
		}
		return null;
	} 
	
	
	//------------------------------------------------------------------------------------------------------------------------
	
	@SuppressWarnings("rawtypes")
	public void zoomImageOut(JComboBox comboboxZoom) 
	{
		if(iZoom > 200)
		{
			iZoom = 200;
		}
		iZoom = iZoom - iZoomStep;
		comboboxZoom.setSelectedItem(Integer.toString(iZoom));
	}
	@SuppressWarnings("rawtypes")
	public void zoomImageIn(JComboBox comboboxZoom)
	{
		if(iZoom < 10)
		{
			iZoom = 10;
		}
		iZoom = iZoom + iZoomStep;
		comboboxZoom.setSelectedItem(Integer.toString(iZoom));
	}
	@SuppressWarnings("rawtypes")
	public void zoomCombobox(JComboBox comboboxZoom) 
	{
		try 
		{
			String zoomValueSt = (String) comboboxZoom.getSelectedItem();
			int zoomValue = Integer.parseInt(zoomValueSt);
			imageCanvas.set(doZoom(zoomValue));
			iZoom = zoomValue;
			drawWhenZoom();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void leftImage() {
		imageCanvas.getScrollPane().getHorizontalScrollBar().setValue(imageCanvas.getScrollPane().getHorizontalScrollBar().getValue() - 200);
	}
	
	public void rightImage( ) {
		imageCanvas.getScrollPane().getHorizontalScrollBar().setValue(imageCanvas.getScrollPane().getHorizontalScrollBar().getValue() + 200);
	}
	
	public void upImage() {
		imageCanvas.getScrollPane().getVerticalScrollBar().setValue(imageCanvas.getScrollPane().getVerticalScrollBar().getValue() - 200);
	}
	
	public void downImage() {
		imageCanvas.getScrollPane().getVerticalScrollBar().setValue(imageCanvas.getScrollPane().getVerticalScrollBar().getValue() + 200);
	}
	
	public void rotateRight() 
	{
		try {
			iExt += 90;
			doRotate(iExt);
			if (iExt >= 360) 
			{
				iExt = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void rotateLeft() 
	{
		try {
			iExt -= 90;
			doRotate(iExt);
			if (iExt <= -360) 
			{
				iExt = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void rotateUp() {
		try {
			this.doRotate(0);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void rotateDown() {
		try {
			this.doRotate(180);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void srollPaneMousePressed(MouseEvent evt) 
	{
		oldv = imageCanvas.getScrollPane().getVerticalScrollBar().getValue();
		oldh = imageCanvas.getScrollPane().getHorizontalScrollBar().getValue();
		x1 = evt.getX();
		y1 = evt.getY();
		x2 = 0;
		y2 = 0;
		
	}

	public int loadAlphaY(int yFirst, PlanarImage planImage) 
	{
		// Point point = pixelUtil.getY(formid, planImage.getAsBufferedImage());
		// int yLast = point.y ;
		// this.category = point.x ;
		// System.out.println("YLast : " + yLast + " formid : " + formid);

		// return yLast - yFirst;
		/*
		 * if(formid == 3) return 100; else
		 */
		return 0;
	}
	
	
	public void displayImage(String imagePath) {

		/** show image * */
		if (imagePath.equals("") || imagePath == null) {
			imageCanvas.set(loadBackgroundImage());
		}
		else 
		{
			try {
				imagePath = Configuration.changePlatfom(imagePath);
				if(!new File(imagePath).exists()){
					JOptionPane.showMessageDialog(null, "Image not exits !", "Error", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				int yFirst = 100;
				imageCanvas.set(loadImage(imagePath));
				try 
				{
					alphaY = this.loadAlphaY(yFirst, zoomedImage);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}

			} catch (Exception e) {
				imageCanvas.set(loadBackgroundImage());
			}
		}
	}
	
	public void displayImageJPG(String imagePath) {
		
		if(imagePath.equals("") || imagePath == null){
			imageCanvas.set(  loadBackgroundImage() ) ;
		}else{
			
			try{
				imagePath = Configuration.changePlatfom(imagePath);
				File file = new File(imagePath);
				if(!file.exists()) {
					imageCanvas.set(  loadBackgroundImage() ) ;
					return ;
				}
				 PlanarImage planImage = loadImageJPG( imagePath ) ; 
			     imageCanvas.set( planImage ) ;
			     
			     try{
			    	 int yFirst = 100;
			    	 alphaY = this.loadAlphaY( yFirst,  zoomedImage ) ;
			    	 
			     }catch( Exception e ){
			    	 e.printStackTrace() ;
			     }
			     
			}catch(Exception e ){
				
				imageCanvas.set(  loadBackgroundImage() ) ;
			}
			
		}
		
	}
	
	PrintStream printStream = null;
	String toolImageViewPath = Configuration.WINDOW + "/Application/Available/TOOL IMAGE/Image Viewer/ImageViewer.jar";
	String[] commandLineString = new String[]{};
	
	public void openImage(String fullFileName) 
	{
			try 
			{
				if (printStream == null) 
				{
					commandLineString = new String[] {
						"java",
						"-Dsun.java2d.opengl=false",
						"-Dsun.java2d.d3d=false",
						"-Dsun.java2d.noddraw=true", 
						"-jar", 
						"-Xms256m",
						"-Xmx512m",
						Configuration.changePlatfom(toolImageViewPath),
						"j2k:4" };
					printStream = new PrintStream(new BufferedOutputStream(Runtime.getRuntime().exec(commandLineString).getOutputStream()));
				}	
				printStream.println(fullFileName);
				printStream.flush();
				if (printStream.checkError()) 
				{
					printStream.close();
					printStream = null;
					openImage(fullFileName);
				}

			} catch (Exception e) {
				e.printStackTrace();

			}
		
	}

}
