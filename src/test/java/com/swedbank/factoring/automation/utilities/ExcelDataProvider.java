package com.swedbank.factoring.automation.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;

	public ExcelDataProvider() {
		File src = new File("./TestData/Data.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		}catch (Exception e) {
			System.out.println("Unable to read the excel file"+e.getMessage());
		}
	}
	public String getStringData(String sheetName,int row, int col) {
		return(wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue());
	}
	public Double getNumData(String sheetName, int row, int col) {
		return(wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue());
	}
}
