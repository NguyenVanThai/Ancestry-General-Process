/**
 * 
 */
package com.digitexx.ancestry.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 * @author lqnhu
 *
 */
public class ExcelSheetReader 
{

	public static ArrayList<ArrayList<String>> readExcelFileToArrayList(String fileName) 
	{
		ArrayList<ArrayList<String>> cellDataList = new ArrayList<ArrayList<String>>();
		String value = "";
		
		try 
		{
			FileInputStream fileInputStream = new FileInputStream(fileName);
			POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream);
			HSSFWorkbook workBook = new HSSFWorkbook(fsFileSystem);
			boolean isFirst = true;
			int columnAmount = 0;
			int numSheet = workBook.getNumberOfSheets();
			
			for (int i = 0; i < numSheet ; i++) 
			{
				HSSFSheet hssfSheet = workBook.getSheetAt(i);

				Iterator<?> rowIterator = hssfSheet.rowIterator();
				isFirst = true;
				columnAmount = 0;
				
				while (rowIterator.hasNext()) 
				{
					HSSFRow hssfRow = (HSSFRow) rowIterator.next();
					
					int idx = hssfRow.getRowNum();
					int idxColumNr = findRow(hssfSheet, "Nr.");
					
					if( idx > idxColumNr)
					{
						ArrayList<String> cellTempList = new ArrayList<String>();
						
						if(isFirst)
						{
							columnAmount = hssfRow.getLastCellNum();
							isFirst = false;	
						}

						for (int j = 0; j < columnAmount; j++) 
						{
							value = "";
							
							HSSFCell hssfCell = hssfRow.getCell(j);
							value = getCellValue(hssfCell);
							cellTempList.add(value);
						}
						cellDataList.add(cellTempList);
					}

				}

			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}
//		printToConsole(cellDataList);
		return cellDataList;
	}
	
	public static int findRow(HSSFSheet sheet, String cellContent)
	{
	    for (Row row : sheet) 
	    {
	        for (Cell cell : row)
	        {
	            if (cell.getCellType() == Cell.CELL_TYPE_STRING)
	            {
	                if (cell.getRichStringCellValue().getString().trim().equals(cellContent)) {
	                    return row.getRowNum();  
	                }
	            }
	        }
	    }               
	    return 0;
	}
	
	public static List<List<String>> readExcelFile2003(String fileName) throws AncestryException
	{
		List<List<String>> cellDataList = new ArrayList<List<String>>();
		try 
		{
			FileInputStream fileInputStream = new FileInputStream(fileName);
			POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream);
			HSSFWorkbook workBook = new HSSFWorkbook(fsFileSystem);
			boolean isFirst = true;
			int columnAmount = 0;
			
			for (int i = 0; i < workBook.getNumberOfSheets(); i++) 
			{
				HSSFSheet hssfSheet = workBook.getSheetAt(i);
				Iterator<?> rowIterator = hssfSheet.rowIterator();
				isFirst = true;
				columnAmount = 0;
				
				while (rowIterator.hasNext()) {
					HSSFRow hssfRow = (HSSFRow) rowIterator.next();
					
					List<String> cellTempList = new ArrayList<String>();
					if(isFirst){
						columnAmount = hssfRow.getLastCellNum();
						isFirst = false;	
					}
					
					for (int j = 0; j < columnAmount; j++) {
						HSSFCell hssfCell = hssfRow.getCell(j);
						cellTempList.add(getCellValue(hssfCell));
					}
					
					cellDataList.add(cellTempList);
				}

			}

			
		} catch (Exception e) {
			throw new AncestryException("readExcelFile2003 : "  + e.toString() , e);
		}
		//printToConsole(cellDataList);
		return cellDataList;
	}
	
	private static String getCellValue(HSSFCell cell) throws AncestryException {
        String str;

        if (cell == null) {
            return "";
        }

        switch (cell.getCellType())
        {
            case HSSFCell.CELL_TYPE_NUMERIC:
            	cell.setCellType(Cell.CELL_TYPE_STRING);
                str = String.valueOf(cell.getStringCellValue());
                break;

            case HSSFCell.CELL_TYPE_STRING:
                str = cell.getStringCellValue();
                break;

            case HSSFCell.CELL_TYPE_BLANK:
                str = "";
                break;

            case HSSFCell.CELL_TYPE_BOOLEAN:
                str = String.valueOf(cell.getBooleanCellValue());
                break;

            case HSSFCell.CELL_TYPE_FORMULA:
                str = cell.getRichStringCellValue().toString();
                break;

            default:
                System.out.println("Not a supported cell type");
                str = "";
                break;
        }

        return str;
    }
	
	private static String getCellValue207(Cell cell) throws AncestryException {
        String str;

        if (cell == null) {
            return "";
        }

        switch (cell.getCellType())
        {
            case HSSFCell.CELL_TYPE_NUMERIC:
            	cell.setCellType(Cell.CELL_TYPE_STRING);
                str = String.valueOf(cell.getStringCellValue());
                break;

            case HSSFCell.CELL_TYPE_STRING:
                str = cell.getStringCellValue();
                break;

            case HSSFCell.CELL_TYPE_BLANK:
                str = "";
                break;

            case HSSFCell.CELL_TYPE_BOOLEAN:
                str = String.valueOf(cell.getBooleanCellValue());
                break;

            case HSSFCell.CELL_TYPE_FORMULA:
                str = cell.getRichStringCellValue().toString();
                break;

            default:
                System.out.println("Not a supported cell type");
                str = "";
                break;
        }

        return str;
    }
	
    public static List<List<String>> readExcel2007(String fileName) throws AncestryException
    {
    	List<List<String>> listValues = new ArrayList<List<String>>();
        List<String> listTmp = new ArrayList<String>();
        try {
            FileInputStream fis = new FileInputStream(fileName);
            Workbook workbook = null;
            if(fileName.toLowerCase().endsWith("xlsx")){
                workbook = new XSSFWorkbook(fis);
            }else if(fileName.toLowerCase().endsWith("xls")){
                workbook = new HSSFWorkbook(fis);
            }
             
            int numberOfSheets = workbook.getNumberOfSheets();
            for(int i=0; i < numberOfSheets; i++){
                Sheet sheet = workbook.getSheetAt(i);
                Iterator<Row> rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) 
                {
                    Row row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator();
                    listTmp = new ArrayList<String>();

                    while (cellIterator.hasNext()) 
                    {
                        Cell cell = cellIterator.next();
                        listTmp.add(getCellValue207(cell));
                    }
                    listValues.add(listTmp);
                }
            } 
            fis.close();
             
        } catch (Exception e) {
        	throw new AncestryException("readExcel2007 : "  + e.toString(), e);
        }
         
        return listValues;
    }

	/**
	 * write excel 2007
	 */
	public static void writeExcel2007(Map<String, Object[]> mapData , String pathExport) throws AncestryException
	{
		XSSFWorkbook book;
		XSSFSheet sheet;
	    try {
	            File excel = new File(pathExport + ".xlsx");
	            FileInputStream fis = new FileInputStream(excel);
	            book = new XSSFWorkbook(fis);
	            sheet = book.getSheetAt(0);
	            Iterator<Row> itr = sheet.iterator();

	            // Iterating over Excel file in Java
	            while (itr.hasNext()) {
	                Row row = itr.next();

	                // Iterating over each column of Excel file
	                Iterator<Cell> cellIterator = row.cellIterator();
	                while (cellIterator.hasNext()) {

	                    Cell cell = cellIterator.next();

	                    switch (cell.getCellType()) {
	                    case Cell.CELL_TYPE_STRING:
	                        System.out.print(cell.getStringCellValue() + "\t");
	                        break;
	                    case Cell.CELL_TYPE_NUMERIC:
	                        System.out.print(cell.getNumericCellValue() + "\t");
	                        break;
	                    case Cell.CELL_TYPE_BOOLEAN:
	                        System.out.print(cell.getBooleanCellValue() + "\t");
	                        break;
	                    default:

	                    }
	                }
	                System.out.println("");
	            }

	            Set<String> newRows = mapData.keySet();
	            int rownum = sheet.getLastRowNum();

	            for (String key : newRows) {
	                Row row = sheet.createRow(rownum++);
	                Object[] objArr = mapData.get(key);
	                int cellnum = 0;
	                for (Object obj : objArr) {
	                    Cell cell = row.createCell(cellnum++);
	                    if (obj instanceof String) {
	                        cell.setCellValue((String) obj);
	                    } else if (obj instanceof Boolean) {
	                        cell.setCellValue((Boolean) obj);
	                    } else if (obj instanceof Date) {
	                        cell.setCellValue((Date) obj);
	                    } else if (obj instanceof Double) {
	                        cell.setCellValue((Double) obj);
	                    }
	                }
	            }

	            // open an OutputStream to save written data into Excel file
	            FileOutputStream os = new FileOutputStream(excel);
	            book.write(os);
	            System.out.println("Writing on Excel file Finished ...");

	            // Close workbook, OutputStream and Excel file to prevent leak
	            os.close();
	            fis.close();

	        }catch (Exception e) {
	        	throw new AncestryException("readExcel2007 : "  + e.toString(), e);
	        }
	    }

    
	private static void printToConsole(List<List<String>> cellDataList)
	{

		for (int i = 0; i < cellDataList.size(); i++) 
		{
			List<String> cellTempList =  cellDataList.get(i);
			for (int j = 0; j < cellTempList.size(); j++) 
			{
				String stringCellValue = cellTempList.get(j);
				System.out.print(stringCellValue + "\t\t");
			}
			System.out.println();
		}
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		String fileName = "C:\\Documents and Settings\\lqnhu\\Desktop\\delete\\20150417.xls";
		
		System.out.println("fileName : " + fileName);
		List<List<String>> listData;
		try {
			listData = new ExcelSheetReader().readExcelFile2003(fileName);
			printToConsole(listData);
		} catch (AncestryException e) {
			e.printStackTrace();
		}
	}
}
