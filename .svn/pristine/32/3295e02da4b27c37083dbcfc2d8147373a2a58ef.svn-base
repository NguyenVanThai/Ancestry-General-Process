package com.digitexx.ancestry.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author vqtuan
 * define one Form . One Form have to containt one or many DesignField
 */
 public class Form {
	 
	 private long id ; 
	 
	 private long project_id ; 
	 
	 private String name ;
	 
	 private long file_id ;
	 
	 private String fileImagePath ; 
	 
	 private int anchor_x ; 
	 
	 private int anchor_y ; 
	 
	 private byte ratio ; 
	 
	 private byte orientationAnchor ; 
	 
	 private byte colorRec ; 
     
	 // percent zoom image
	 private int zoomPercent ; 
	 
	 private List<DesignField> designFields ;


	public Form() 
	{
		super();	
		designFields = new ArrayList<DesignField>() ; 		
	 }

		 
	public List<DesignField> getDesignFields() {
		return designFields;
	}

	public void setDesignFields(List<DesignField> designFields) {
		this.designFields = designFields;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getAnchor_x() {
		return anchor_x;
	}


	public void setAnchor_x(int anchor_x) {
		this.anchor_x = anchor_x;
	}


	public int getAnchor_y() {
		return anchor_y;
	}


	public void setAnchor_y(int anchor_y) {
		this.anchor_y = anchor_y;
	}




	public long getFile_id() {
		return file_id;
	}


	public void setFile_id(long file_id) {
		this.file_id = file_id;
	}


	public byte getRatio() {
		return ratio;
	}


	public void setRatio(byte ratio) {
		this.ratio = ratio;
	}


	public long getProject_id() {
		return project_id;
	}


	public void setProject_id(long project_id) {
		this.project_id = project_id;
	}

	/** Function for DesignField List **/
	
    public void addDesignField( DesignField dField ){    	
    	designFields.add( dField ) ;     	
    }
	
    public void removeDesignField( int index ){
    	designFields.remove( index ) ;
    }
	 
    public void removeAllDesignField(){
    	designFields.clear() ; 
    }
    
    public DesignField getDesignField( int index ){
    	return  designFields.get( index ) ;  
    }
	 
	public int getDesignFieldSize(){
		return designFields.size() ; 
	}
  
	public void replaceDesignField( int index , DesignField dgField ){
		designFields.set(index, dgField ) ;  
	}


	public String getFileImagePath() {
		return fileImagePath;
	}


	public void setFileImagePath(String fileImagePath) {
		this.fileImagePath = fileImagePath;
	}


	public byte getColorRec() {
		return colorRec;
	}


	public void setColorRec(byte colorRec) {
		this.colorRec = colorRec;
	}


	public byte getOrientationAnchor() {
		return orientationAnchor;
	}


	public void setOrientationAnchor(byte orientationAnchor) {
		this.orientationAnchor = orientationAnchor;
	}


	public int getZoomPercent() {
		return zoomPercent;
	}


	public void setZoomPercent(int zoomPercent) {
		this.zoomPercent = zoomPercent;
	}
	
	
 }
