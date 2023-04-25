package week5.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xcel_CommonIntegration 
{
	public static String[][] excelRead(String fileName) throws IOException {
		// TODO Auto-generated method stub
		XSSFWorkbook wbook=new XSSFWorkbook("./Xcel_Data/"+fileName+".xlsx");
		XSSFSheet sheetAt = wbook.getSheetAt(0);
		
		//No of rows
		int row = sheetAt.getLastRowNum();
		System.out.println(row);
		
		//No of columns
		int cell = sheetAt.getRow(0).getLastCellNum();
		System.out.println(cell);
		
		String[][] data=new String[row][cell];
		//Printing the values in excel
		for(int i=1;i<=row;i++)
		{
			XSSFRow rowCount = sheetAt.getRow(i);
			for(int j=0;j<cell;j++)
			{
				String stringCellValue = rowCount.getCell(j).getStringCellValue();
				System.out.println(stringCellValue);
				data[i-1][j]=stringCellValue;
			}
		}
		
		wbook.close();
		return data;

	}

}
