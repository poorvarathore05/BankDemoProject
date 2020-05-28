package com.bank.demosite.HelperClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcelFile {

	
	public static Object[][] getExcelData (String filename , String sheetName) throws IOException{
		
		File f = new File("D:\\Work\\BankDemo\\src\\test\\resource\\"+filename);
		FileInputStream file = new FileInputStream(f);
		//System.out.println(file.toString());
		XSSFWorkbook book = new XSSFWorkbook(file);
		//XSSFWorkbook book = new XSSFWorkbook(ReadExcelFile.class.getClassLoader().getResourceAsStream("\\resource\\banklogindetails.xlsx"));
		
		XSSFSheet sheet = book.getSheet(sheetName);
		XSSFRow row = null;
		XSSFCell cell = null;
		Map<String, Object> map = null;
		
		
		row = sheet.getRow(0);
		String []header = new String[row.getLastCellNum()];
		Object [][] data = new Object[sheet.getLastRowNum()][1];
		for(int j =row.getFirstCellNum();j <row.getLastCellNum();j++){
			cell = row.getCell(j);
			header[j] = cell.getStringCellValue();
		}
		
		for(int i =sheet.getFirstRowNum()+1;i<=sheet.getLastRowNum();i++){
			row = sheet.getRow(i);
			map = new LinkedHashMap<String, Object>();
			
			for(int j = row.getFirstCellNum();j<row.getLastCellNum();j++){
				cell = row.getCell(j);
				
				switch(cell.getCellType()){
				 
				case XSSFCell.CELL_TYPE_STRING :
					map.put(header[j], cell.getStringCellValue());
					break;
					
				case XSSFCell.CELL_TYPE_NUMERIC :
					map.put(header[j], cell.getNumericCellValue());
					break;
					
				default:
					break;
				}		
			}
			data[i-1][0]=map;
		}
		return data;

		
	}
}
