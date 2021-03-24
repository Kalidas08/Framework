package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	XSSFWorkbook workbook;

	public ExcelUtility() throws IOException

	{
		File f = new File("C:\\Users\\kalid\\eclipse-workspace\\ExcelDataReading\\src\\ExcelFile\\data.xlsx");

		FileInputStream fis = new FileInputStream(f);

		workbook = new XSSFWorkbook(fis);

	}

	public String email(String sheetname, int row, int column)

	{

		return workbook.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();

	}

	public double password(String sheetname, int row, int column)

	{

		return workbook.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();

	}

}
