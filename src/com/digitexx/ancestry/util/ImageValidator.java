/**
 * 
 */
package com.digitexx.ancestry.util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @author lqnhu
 *
 */
public class ImageValidator{
	 
	   private Pattern pattern;
	   private Matcher matcher;
	 
	   private static final String IMAGE_PATTERN = 
               "([^\\s]+(\\.(?i)(jpg|png|gif|bmp|jpeg|psd|pdf|tiff|TIFF|tif|TIF|PNG|GIF|JPG|JPEG|BMP|PSD))$)";
	 
	   public ImageValidator(){
		  pattern = Pattern.compile(IMAGE_PATTERN);
	   }
	 
	   /**
	   * Validate image with regular expression
	   * @param image image for validation
	   * @return true valid image, false invalid image
	   */
	   public boolean validate(final String image){
	 
		  matcher = pattern.matcher(image);
		  return matcher.matches();
	 
	   }
	}
