/**
 * 
 */
package com.digitexx.ancestry.jai.util;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.ParameterBlock;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
import javax.media.jai.Interpolation;
import javax.media.jai.InterpolationNearest;
import javax.media.jai.JAI;
import javax.media.jai.NullOpImage;
import javax.media.jai.OpImage;
import javax.media.jai.PlanarImage;
import javax.media.jai.RenderedImageAdapter;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

import org.w3c.dom.Element;

import com.digitexx.ancestry.util.Configuration;
import com.sun.media.imageio.plugins.jpeg2000.J2KImageReadParam;
import com.sun.media.jai.codec.FileSeekableStream;
import com.sun.media.jai.codec.ImageCodec;
import com.sun.media.jai.codec.ImageDecoder;
import com.sun.media.jai.codec.SeekableStream;
import com.sun.media.jai.codec.TIFFDecodeParam;
import com.sun.media.jai.codec.TIFFEncodeParam;
import com.sun.media.jai.codec.TIFFField;

/**
 * @author lqnhu
 *
 */
public class ImagePerfectJAI {
	
	public ShowJAI imageCanvas ;
	public JScrollPane scrollPane;
	public PlanarImage originalImage ;
	public int angle = 0;
	public PlanarImage zoomImage;
	public int iZoom = 100;
	public int iZoomStep = 10;
	
	PrintStream printStream = null;
	String toolImageViewPath = Configuration.WINDOW + "/Application/Available/TOOL IMAGE/Image Viewer/ImageViewer.jar";
	String[] commandLineString = new String[]{};
	

	public ImagePerfectJAI(){
		imageCanvas = new ShowJAI(loadEmpty(""));
	}

	public PlanarImage loadEmpty( String filePath ){
		PlanarImage source = null ;

		if(new File(filePath).exists())
		{
			ParameterBlock pb = new ParameterBlock();
			pb.add( filePath );
			try {
				source = JAI.create("fileload", pb);
				if( source == null ){
					source = loadBackgroundImageJAI() ; 
				}
			}     
			catch( Exception e ){   
				source = loadBackgroundImageJAI() ;	
			}
		}else {
			source = loadBackgroundImageJAI() ;	
		}
		return  source ; 
	}
	
	public PlanarImage loadImageJAI( String filePath , int resolution ){
		PlanarImage source = null ;

		if(new File(filePath).exists())
		{
			ParameterBlock pb = new ParameterBlock();
			pb.add( filePath );
			try {
				source = JAI.create("fileload", pb);
				source = PlanarImage.wrapRenderedImage(getJ2kImage(filePath,resolution));
				if( source == null ){
					source = loadBackgroundImageJAI() ; 
				}
			}     
			catch( Exception e ){   
				source = loadBackgroundImageJAI() ;	
			}
		}else {
			source = loadBackgroundImageJAI() ;	
		}
		return  source ; 
	}
	
	private RenderedImage getJ2kImage(String imagePath,int resolution) 
	{
		try 
		{
			ImageInputStream in = ImageIO.createImageInputStream(new File(imagePath));
			ImageReader reader = ImageIO.getImageReaders(in).next();
			reader.setInput(in);
			J2KImageReadParam param = new J2KImageReadParam();
			/**
			 * in current this image is 8 bit per inch
			 */
			param.setDecodingRate(Double.MAX_VALUE * 0.9);
			param.setResolution(resolution);
			RenderedImage image = reader.read(0, param);
			return image;
		} 
		catch (IOException ex) 
		{
			ex.printStackTrace();
			imageCanvas.set(loadBackgroundImageJAI());
		}
		return null;
	}
	
	
	public PlanarImage loadImage( String filePath , int zoom){
		PlanarImage source = null ;

		if(new File(filePath).exists()){
			ParameterBlock pb = new ParameterBlock();
			pb.add( filePath );
			try {
				source = JAI.create("fileload", pb);
				if( source == null ){
					source = loadBackgroundImageJAI() ; 
				}else {
					originalImage = source;
					source = zoom(zoom);
				}
			}     
			catch( Exception e ){   
				source = loadBackgroundImageJAI() ;
			}
		}else {
			source = loadBackgroundImageJAI() ;	
		}
		return  source ; 
	}

	public PlanarImage loadImageMutiTiff(String filePath, int pageToLoad) {

		PlanarImage source = null ;
		try {

			File file = new File(filePath);
			if (file.exists()) {
				SeekableStream s = new FileSeekableStream(file);

				TIFFDecodeParam param = null;
				ImageDecoder dec = ImageCodec.createImageDecoder("tiff", s, param);
				if(dec == null){
					dec = ImageCodec.createImageDecoder("jpeg", s, param);
				}

				// Which of the multiple images in the TIFF file do we want to  load
				RenderedImage op = new NullOpImage(dec.decodeAsRenderedImage(pageToLoad), null, OpImage.OP_IO_BOUND, null);

				source = new RenderedImageAdapter(op);
			} else {
				source = loadBackgroundImageJAI() ;	
			}

		} catch (Exception e) {
			source = loadBackgroundImageJAI() ;
			e.printStackTrace();
		}

		return source;
	}

	public PlanarImage loadBackgroundImageJAI(){
		PlanarImage source = null ;
		try{  
			int width = 1;
			int height = 1;
			BufferedImage bufferImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);

			ParameterBlock pbIDCT = (new ParameterBlock()).addSource( bufferImage );
			source = JAI.create("idct", pbIDCT, null);

		}catch(Exception e){
			e.printStackTrace();
		}

		return source ;
	}

	public int countPage(String imageMulti){
		int count = 0;
		try {
			File file = new File(imageMulti);
			if(file.exists()){
				SeekableStream s = new FileSeekableStream(file);

				TIFFDecodeParam param = null;
				ImageDecoder dec = null;
				if(imageMulti.toLowerCase().lastIndexOf(".tif") > -1){
					dec = ImageCodec.createImageDecoder("tiff", s, param);
				}else if(imageMulti.toLowerCase().lastIndexOf(".jpeg") > -1){
					dec = ImageCodec.createImageDecoder("jpeg", s, param);
				}

				if(dec != null)
					count = dec.getNumPages();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public PlanarImage zoom(int iWantedZoom ){

		PlanarImage zoomedOrgImage = null;
		if( originalImage != null ){

			PlanarImage rotatedOrgImage = null;
			ParameterBlock pb = new ParameterBlock();
			rotatedOrgImage = originalImage ;
			pb.addSource( rotatedOrgImage );
			pb.add( (float)iWantedZoom / 100 );
			pb.add( (float)iWantedZoom / 100 );
			pb.add( 0.0F );
			pb.add( 0.0F );
			pb.add( new InterpolationNearest() );
			zoomedOrgImage = JAI.create( "scale", pb, null );
		}
		return zoomedOrgImage ;                             
	}
	
	

	public PlanarImage getOriginalImage() {
		return originalImage;
	}

	public void setOriginalImage(PlanarImage originalImage) {
		this.originalImage = originalImage;
	}
	
	
	private PlanarImage rotate(int iAngle) {

		/** Begin rotate * */
		boolean bLandscape = true;
		float fDelta = (float) (zoomImage.getWidth())
				- (float) (zoomImage.getHeight());
		if (fDelta < 0) {
			bLandscape = false;
			fDelta = Math.abs(fDelta);
		}
		fDelta /= 2;
		ParameterBlock pb = new ParameterBlock();
		pb.addSource(zoomImage);
		pb.add((float) zoomImage.getWidth() / 2);
		pb.add((float) zoomImage.getHeight() / 2);
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
	
	
	public boolean save(BufferedImage buff, String fileStore){
		try {
			if (fileStore.toLowerCase().endsWith(".jpg")) {
				try {
					JAI.create("filestore", buff, fileStore, "JPEG");
				} catch (Exception e1) {
					try {
						ImageIO.write(buff, "JPEG", new File(fileStore));
					} catch (Exception e) {
						throw e;
					}
				}
			
			}else if (fileStore.toLowerCase().endsWith(".tiff") || fileStore.toLowerCase().endsWith(".tif")) {
				try {
					JAI.create("filestore", buff, fileStore, "TIFF");
				} catch (Exception e1) {
					try {
						ImageIO.write(buff, "tif", new File(fileStore));
					} catch (Exception e) {
						throw e;
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	public boolean save(BufferedImage sourceImage, String fileStore, int dpi){
		try {
			if (fileStore.toLowerCase().endsWith(".jpg") || fileStore.toLowerCase().endsWith(".bmp"))
			{
				
				ImageWriter imageWriter = ImageIO.getImageWritersBySuffix("jpeg").next();
				ImageOutputStream ios = ImageIO.createImageOutputStream(new File(fileStore));
				imageWriter.setOutput(ios);
				ImageWriteParam jpegParams =  imageWriter.getDefaultWriteParam();

				IIOMetadata data = imageWriter.getDefaultImageMetadata(new ImageTypeSpecifier(sourceImage), jpegParams);
				Element tree = (Element)data.getAsTree("javax_imageio_jpeg_image_1.0");
				Element jfif = (Element)tree.getElementsByTagName("app0JFIF").item(0);
				jfif.setAttribute("Xdensity", Integer.toString(dpi));
				jfif.setAttribute("Ydensity", Integer.toString(dpi));
				jfif.setAttribute("resUnits", "1"); // density is dots per inch                 
				data.mergeTree("javax_imageio_jpeg_image_1.0", tree);

				// Write and clean up
				imageWriter.write(data, new IIOImage(sourceImage, null, data), jpegParams);
				ios.close();
				imageWriter.dispose();
			
			}
			else if (fileStore.toLowerCase().endsWith(".tiff") || fileStore.toLowerCase().endsWith(".tif")) 
			{

				try {
					TIFFEncodeParam tepParam = new TIFFEncodeParam();
					tepParam.setCompression(1);
					
					TIFFDecodeParam decode = new TIFFDecodeParam();
					decode.setDecodePaletteAsShorts(false);
					decode.setJPEGDecompressYCbCrToRGB(false);
					
					TIFFField[] fields = new TIFFField[2];

					//		XResolution
					TIFFField fieldXRes = new TIFFField(282, TIFFField.TIFF_RATIONAL, 1, (Object) new long[][] { { 300 , 1} });
					fields[0] = fieldXRes;

					//		YResolution
					TIFFField fieldYRes = new TIFFField(283, TIFFField.TIFF_RATIONAL, 1, (Object) new long[][] { { 300 , 1} });
					fields[1] = fieldYRes;
						
					tepParam.setExtraFields(fields);
					tepParam.setJPEGCompressRGBToYCbCr(true);
				    
					JAI.create("filestore", sourceImage, fileStore, "TIFF",tepParam).dispose();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	public void displayImage(String imagePath , int resolution)
	{
		try {
			System.out.println(imagePath);
			imagePath  = imagePath.replace("\\", "/");
			imagePath  = Configuration.changePlatfom(imagePath);
			PlanarImage planar = null;
			
			try {
				if(imagePath.length() > 1 && new File(imagePath).exists())
				{
					originalImage =  loadImageJAI(imagePath , resolution) ;
					setOriginalImage(originalImage);
					planar =  zoom( iZoom );
					if(planar == null)
					{
						planar = loadBackgroundImageJAI();
					}
				}
				else
				{
					originalImage = loadBackgroundImageJAI();
					planar = originalImage;
				}
			} 
			catch (Exception e) {
				originalImage = loadBackgroundImageJAI();
				planar = originalImage;
			}
			imageCanvas.set(planar);
			imageCanvas.repaint();
			imageCanvas.getScrollPane().getVerticalScrollBar().setValue(900);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void changeZoom(JComboBox comboBoxZoom)
	{
		iZoom = Integer.parseInt((String) comboBoxZoom.getSelectedItem());
		setOriginalImage(originalImage);
		zoomImage = zoom(iZoom);

		if (zoomImage != null) 
		{
			imageCanvas.set(zoomImage);
			imageCanvas.setZoom(iZoom);
			imageCanvas.repaint();
			
		}
	}
	
	public void doRotate(int iAngle){

		/** Zoom before rotate * */
		zoom(iZoom);
		
		/** Begin rotate * */
		imageCanvas.set(rotate(iAngle));

	}

	public void rotateRight() 
	{
		try {
			angle += 90;
			doRotate(angle);
			if (angle >= 360) 
			{
				angle = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void rotateLeft() 
	{
		try {
			angle -= 90;
			doRotate(angle);
			if (angle <= -360) 
			{
				angle = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public void zoomOut(JComboBox comboBoxZoom) 
	{
		if(iZoom > 10){
			iZoom = iZoom - iZoomStep;
			comboBoxZoom.setSelectedItem(iZoom+"");
		}
	}
	
	public void zoomIn(JComboBox comboBoxZoom) {
		if(iZoom < 200){
			iZoom = iZoom + iZoomStep;
			comboBoxZoom.setSelectedItem(iZoom+"");
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
	
	
	//=================================================================================================================


}

