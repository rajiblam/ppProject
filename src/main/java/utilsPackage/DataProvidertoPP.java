package utilsPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataProvidertoPP {
	
		
	@SuppressWarnings("resource")
	public static Object[][] getDataFromExcel(String sheetName) throws IOException
	{
		XSSFWorkbook workbook=null;
		File filePath=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\ppProjectData.xlsx");
		InputStream fis=new FileInputStream(filePath);
		workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		int rows=sheet.getLastRowNum();
		int cols=sheet.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[rows][cols];
		
		for(int i=0;i<rows;i++)
		{
			XSSFRow row = sheet.getRow(i+1);
			
			for(int j=0;j<cols;j++)
			{
				XSSFCell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				
				switch(cellType)
				{
					case STRING:
						data[i][j]=cell.getStringCellValue();
						break;
					case NUMERIC:
						data[i][j]= Integer.toString((int)cell.getNumericCellValue());
						break;
					case BOOLEAN:
						data[i][j]=cell.getBooleanCellValue();
						break;
				default:
					break;
				}
			}
			
		}
		return data;
	}

}
