package com.test.automation.uiautomation.excelReader;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Reader {

	public FileOutputStream fileout = null;
	public String path;
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;

	public Excel_Reader(String path) {
		this.path = path;

		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
		public String[][] getDataFromSheet(String ExcelName, String sheetName)
		{
			
			String[][] dataSets=null;
			try {
				

				//Get Sheet from excel workbook
				sheet=workbook.getSheet(sheetName);
				//count number of active rows
				int totalRow=sheet.getLastRowNum() + 1;
				//count number of active columns in row
				int totalColumn=sheet.getRow(0).getLastCellNum();
				
				//Create array of rows and columns
				dataSets=new String[totalRow-1][totalColumn];
				//run for loop and store data in 2d array
				//this for the loop run on row
				
				for(int i=1;i<totalRow;i++)
				{
					XSSFRow row=sheet.getRow(i);
					//this for the loop run on column of that row
					
					for(int j=0;j<totalColumn;j++)
					{
						XSSFCell cell=row.getCell(j);
						//If cell of type string then this if condition will perform
						if(cell.getCellType()==Cell.CELL_TYPE_STRING)
						{
						
							dataSets[i-1][j]=cell.getStringCellValue();
						}
						//If cell of type number then this else if condition will perform
						else if(cell.getCellType()== Cell.CELL_TYPE_NUMERIC)
						{
						
							String celltext=String.valueOf(cell.getNumericCellValue());
							dataSets[i-1][j]=celltext;
						
					}
						else {
						//If cell of type boolean then this else  condition will perform
							String celltext1=String.valueOf(cell.getBooleanCellValue());
							dataSets[i-1][j]=celltext1;
						}
					}
				}
				return dataSets;
				}
			catch(Exception e)
			{
				System.out.println("error in reading xlsx file:-"+e.getMessage());
				e.printStackTrace();
			}
	
			return dataSets;
		}
}
