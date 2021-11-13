package com.oragangeHRM.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelData {
	@Test
	final static public Object[][] getTableData() throws Throwable {
		File file = new File ("./TestData/data_addEmp.xlsx");
		FileInputStream input = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(input);
		Sheet sheet= wb.getSheet("sheet1");
		
		int totalRows= sheet.getLastRowNum();
		int totalCloumn	= sheet.getRow(0).getLastCellNum();
		Object[][] tabelData = new Object [totalRows] [totalCloumn];
		
		System.out.println(totalRows); // 3 : 0,1,2 
		System.out.println(totalCloumn);// 8 : 0, ..7
		System.out.println("---------------");
		for (int i= 1; i<= totalRows; i++ ) {
			for (int j=0; j<totalCloumn; j++) {
				Cell cell= sheet.getRow(i).getCell(j);
			/*	if(CellType.NUMERIC == cell.getCellType()) {
					System.out.println( String.valueOf(cell.getNumericCellValue()));
					int n= Integer.parseInt( String.valueOf(cell.getNumericCellValue()));
					System.out.println("Post conversion: "+n);
				}
				else 
					System.out.println(cell);
				
				System.out.println(cell.getCellType());
				System.out.println("*****");*/
				if(CellType.NUMERIC == cell.getCellType()) {
					tabelData[i-1][j]= String.valueOf(cell.getNumericCellValue());
				}else if (CellType.STRING== cell.getCellType()) {
					tabelData[i-1][j]= cell.getStringCellValue();
				}
				
			}
		}
		 return tabelData;
	}

}
