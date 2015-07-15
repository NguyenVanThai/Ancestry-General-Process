/**
 * 
 */
package com.digitexx.ancestry.util;

import java.awt.Desktop;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;



/**
 * @author lqnhu
 * 
 */
public class FileUtility 
{
	/**
	 * find all directories from path
	 */
	public File[] findDirectories(File root) {
		return root.listFiles(new FileFilter() {
			public boolean accept(File f) {
				return f.isDirectory();
			}
		});
	}

	/**
	 * find all file form path
	 */
	public File[] findFiles(File root) {
		return root.listFiles(new FileFilter() {
			public boolean accept(File f) {
				return f.isFile();
			}
		});
	}

	/**
	 * list all directories
	 */
	public static File[] directory(File dir) {
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.listFiles() != null)
				directory(file);
		}
		return files;
	}

	
	/**
	 * list all files and folder
	 */
	public File[] listArrayFilesAndFolders(String directoryName) {
		File directory = new File(directoryName);
		File[] fList = directory.listFiles();
		return fList;
	}
	
	
	/**
	 * list all files
	 */
	public static List<File> getListFile(String directoryName)
	{
		File directory = new File(directoryName);
		File[] fList = directory.listFiles();
		List<File> listAllFile = new ArrayList<File>();
		
		for (File file : fList) {
			listAllFile.add(file);
		}
		return listAllFile;
	}
	
	/**
	 * list all file and list file in sub folder
	 */
	public static List<String> allFilesIncludeSubFolder (String directoryName) 
	{
		File directory = new File(directoryName);
		File[] fList = directory.listFiles();
		List<String> listAllFile = new ArrayList<String>();
		
		try 
		{
			for (File file : fList) 
			{
				if (file.isFile()) {
					listAllFile.add(file.getAbsolutePath());
				} 
				else if (file.isDirectory()) {
					allFilesIncludeSubFolder (file.getAbsolutePath());
				}
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return listAllFile;
	}
	
	public static List<String> allFileDB3(File [] fList, List<String> listAllFile){
		try 
		{
			for (File file : fList) 
			{
				if (file.isFile()) {
					if(file.getAbsolutePath().endsWith(".db3")){
						listAllFile.add(file.getAbsolutePath());
					}
				} 
				else if (file.isDirectory()) {
					fList = file.listFiles();
					allFileDB3(fList, listAllFile);
				}
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return listAllFile;	
	}
	/**
	 * list all file and list file in sub folder and file db3
	 */
	public static List<String> allFilesIncludeSubFolderDB3 (String directoryName) 
	{
		File directory = new File(directoryName);
		File[] fList = directory.listFiles();
		List<String> listAllFile = new ArrayList<String>();
		try 
		{
			for (File file : fList) 
			{
				if (file.isFile()) {
					if(file.getAbsolutePath().endsWith(".db3")){
						listAllFile.add(file.getAbsolutePath());
					}
				} 
				else if (file.isDirectory()) {
					fList = file.listFiles();
					allFileDB3(fList, listAllFile);
				}
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return listAllFile;
	}
	
	/**
	 * list filename form path
	 */
	public static ArrayList<String> listFileNameFromPath(String path) 
	{
		ArrayList<String> listFileName = new ArrayList<String>();
		ImageValidator imageValidator = new ImageValidator();
		File directory = new File(path);
		File[] fList = directory.listFiles();
		
		for (int i = 0; i < fList.length; i++) 
		{
			if (imageValidator.validate(fList[i].getName())) {
			   listFileName.add(fList[i].getName());
			}
		}
		return listFileName;
	}
	
	/**
	 * open webpage by url
	 */
	public static void openWebpage(String urlString) {
	    try {
	        Desktop.getDesktop().browse(new URL(urlString).toURI());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	/**
	 * browse image
	 */
	public static void browseImage(JFrame frame , JTextArea txtPath ) 
	{
		JFileChooser fileChooser = new JFileChooser();
//		ImagePreviewPanel preview = new ImagePreviewPanel();
//		fileChooser.setAccessory(preview);
//		fileChooser.addPropertyChangeListener(preview);
		
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
		fileChooser.setAcceptAllFileFilterUsed(true);
		int result = fileChooser.showOpenDialog(frame);
		
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			txtPath.setText(selectedFile.toString());
		}
		else {
			txtPath.setText("");;
		}

	}
	
	public static void copyFile(String fileName, String fileNameNew){
		
		try {
			File srcFile = new File(fileName);
			File dstFile = new File(fileNameNew);
			
			if(srcFile.exists() && srcFile.isFile())
			{
				InputStream in = new FileInputStream(srcFile);
				OutputStream out = new FileOutputStream(dstFile);
				byte[] buf = new byte[1024];

				int len;
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
				out.flush();
				in.close();
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * browse image
	 */
	public static void browseImage(JFrame frame , JTextField txtPath ) 
	{
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp", "j2k"));
		fileChooser.setAcceptAllFileFilterUsed(true);
		int result = fileChooser.showOpenDialog(frame);
		
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			txtPath.setText(selectedFile.toString());
		}
		else {
			txtPath.setText("");;
		}
	}
	
	public static File browseImage(JFrame frame) 
	{
		JFileChooser fileChooser = new JFileChooser();
		File selectedFile = null;
		
		//ImagePreviewPanel preview = new ImagePreviewPanel();
		//fileChooser.setAccessory(preview);
		//fileChooser.addPropertyChangeListener(preview);
		
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp" ,"jpeg"));
		fileChooser.setAcceptAllFileFilterUsed(true);
		int result = fileChooser.showOpenDialog(frame);
		
		ImageValidator imageValidator = new ImageValidator();
		if (result == JFileChooser.APPROVE_OPTION) 
		{
			selectedFile = fileChooser.getSelectedFile();
			if(imageValidator.validate(selectedFile.getName()))
			{
				return selectedFile; 
			}
			else {
				return null;
			}
		}
		return selectedFile; 
	}
	
	public static void browse(JTextField txtPath , int type)
	{
		JFileChooser filechooser;
		String directories = txtPath.getText().trim();
		
		if(!directories.equals(""))
			filechooser = new JFileChooser(directories);
		else
			filechooser = new JFileChooser();
		
		filechooser.setFileSelectionMode(type);
		filechooser.setMultiSelectionEnabled(true);
		
		int chooser = filechooser.showOpenDialog(filechooser);
		if(chooser == JFileChooser.APPROVE_OPTION)
		{
			File f = filechooser.getSelectedFile();
			txtPath.setText(f.getAbsoluteFile()+"");
		}
	}
	
	
	 /**
     * List all the files and folders from a directory
     * @param directoryName to be listed
     */
    public static List<File> listFilesAndFolders(String directoryName){
 
    	List<File> listFiles = new ArrayList<File>();
        File directory = new File(directoryName);
        File[] fList = directory.listFiles();
        for (File file : fList){
            listFiles.add(file);
        }
        return listFiles;
    }
    
    /**
	 * get last folder
	 */
	public static String getLastFolder(File file) {
        String path = file.getAbsolutePath();
        path = path.replace("\\", "/");
        path = path.substring(0 ,path.lastIndexOf("/"));
        path = path.substring(path.lastIndexOf("/")+1);
        return path;
	}
	
    /**
	 * get path
	 */
	public static String getFilePath(File file) {
        String path = file.getAbsolutePath();
        path = path.replace("\\", "/");
        path = path.substring(0 ,path.lastIndexOf("/"));
        return path;
	}
	
	public static String getFileExtension(String filePath)
    {
        File f = new File(filePath);
        String name = f.getName();
        int k = name.lastIndexOf(".");
        String ext = null;
        if(k != -1)
            ext = name.substring(k + 1, name.length());
        return ext;
    }
 
    /**
     * List all the files under a directory
     * @param directoryName to be listed
     */
    public static List<File> listFiles(String directoryName){
 
        File directory = new File(directoryName);
        List<File> listFiles = new ArrayList<File>();
        File[] fList = directory.listFiles();
 
        for (File file : fList){
            if (file.isFile()){
            	listFiles.add(file);
            }
        }
        return listFiles;
    }
 
    /**
     * List all the folder under a directory
     * @param directoryName to be listed
     */
    public List<File> listFolders(String directoryName){
 
        File directory = new File(directoryName);
        List<File> listFiles = new ArrayList<File>();
        File[] fList = directory.listFiles();
 
        for (File file : fList){
            if (file.isDirectory()){
            	listFiles.add(file);
            }
        }
        return listFiles;
    }
 
    /**
     * List all files from a directory and its subdirectories
     * @param directoryName to be listed
     */
    public static List<File> listFilesAndFilesSubDirectories(String directoryName){
     	
    	List<File> listFiles = new ArrayList<File>();
        File directory = new File(directoryName);
        File[] fList = directory.listFiles();
        
        if(new File(directoryName).isFile()) {
        	listFiles.add(new File(directoryName));
        }else {
        	if(fList != null) {
        		for (File file : fList){
        			if (file.isFile()){
        				listFiles.add(file);
        			} else if (file.isDirectory()){
        				listFiles.addAll(listFilesAndFilesSubDirectories(file.getAbsolutePath()));
        			}
        		}
        	}
        }
        return listFiles;
    }
    
    
    public static String setNotNull(String str) {
    	if(str.equals(null)) {
    		return "";
    	}else {
    		return str;
    	}
    }
    
	/**
	 * get list extension of file
	 */
	public static List<String> getListFileExtension() 
	{
		List<String> listResult = new ArrayList<String>();
		String [] arrFiles = new String [] {"txt" , "csv" , "scm", "pdf" ,"doc","docx" , 
				                            "dob" , "xls" , "xlsx","xml"};
		for (String str : arrFiles) {
			listResult.add(str);
		}
		return listResult;
	}
	
	
	/**
	 * get list extension of image
	 */
	public static List<String> getListImageExtension() 
	{
		List<String> listResult = new ArrayList<String>();
		String names[] = ImageIO.getReaderFormatNames();
		for (int i = 0; i < names.length; ++i) 
		{
			listResult.add(names[i]);
		}
		listResult.add("j2k");
		return listResult;
	}
	
	
	/**
	 * get list all extension
	 */
	public static List<String> getListAllExtension(boolean isIncludeFile) 
	{
		List<String> listResult = new ArrayList<String>();
		List<String> listTmp = new ArrayList<String>();
		
		if(isIncludeFile) {
			listTmp = getListFileExtension();
			for (String str : listTmp) {
				listResult.add(str);
			}
		}
		
		listTmp = new ArrayList<String>();
		listTmp = getListImageExtension();
		for (String str : listTmp) {
			listResult.add(str);
		}
		return listResult;
	}
 		 
	public static final String getFullExtension(final String filename) {
		  if (filename == null) return null;
		  final String afterLastSlash = filename.substring(filename.lastIndexOf('/') + 1);
		  final int afterLastBackslash = afterLastSlash.lastIndexOf('\\') + 1;
		  final int dotIndex = afterLastSlash.indexOf('.', afterLastBackslash);
		  return (dotIndex == -1) ? "" : afterLastSlash.substring(dotIndex + 1);
	}
	
	public static void createFolderByPath(String path) {
          File f = new File(path);
          if(!f.exists()) {
        	  f.mkdirs();
          }
	}
	
	public static void createFolderByFile(File f) {
        if(!f.exists()) {
      	  f.mkdirs();
        }
	}

	
	public static boolean deleteDir(File file) throws AncestryException{
		boolean flag = false;
		try {
			if(!file.isDirectory() || file.listFiles().length==0){
				file.delete();
			}else {
				for(File f :file.listFiles()){
					f.delete();
				}
			}
		} catch (Exception e) {
			flag = false;
			throw new AncestryException("deleteDir : "  + e.toString() ,e);
		}
		return flag;
	}
	
	public static boolean removeDirectory(File directory)throws AncestryException {
		try {
			if (directory == null)
				return false;
			if (!directory.exists())
				return true;
			if (!directory.isDirectory())
				return false;

			String[] list = directory.list();
			if (list != null) 
			{
				for (int i = 0; i < list.length; i++) {
					File entry = new File(directory, list[i]);
					if (entry.isDirectory()) {
						if (!removeDirectory(entry))
							return false;
					} else {
						if (!entry.delete())
							return false;
					}
				}
			}
		} catch (Exception e) {
			throw new AncestryException("removeDirectory : "  + e.toString(), e);
		}
		return directory.delete();
	}

	
	public static void main(String[] args) {
		
//		String path = "O:\\119_111017_2HM_ImageProcessing\\ACTIONS";
		String path = "\\\\10.10.5.206\\Dexter\\ExternalBatches\\Test\\44249\\2441567_2_000_249_ALT^^E^01^1874";
        File f = new File(path);
		try {
			removeDirectory(f);
		} catch (AncestryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
