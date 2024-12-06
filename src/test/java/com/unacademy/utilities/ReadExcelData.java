package com.unacademy.utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
public class ReadExcelData {
	public static XSSFSheet Excel() throws IOException {
		InputStream input=new FileInputStream("C:\\Users\\ashwin.murugan\\eclipse-workspace\\Project\\src\\test\\java\\com\\unacademy\\testdata\\unacademy.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(input);
		XSSFSheet sheet=workbook.getSheet("unacademy");
		System.out.println(sheet.getRow(0).getCell(0).getStringCellValue());
		return sheet;
	}
}
