package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {

	WebDriver driver;

	public ScreenshotUtility(WebDriver driver)

	{
		this.driver = driver;
	}

	public void takescreenshot() throws IOException

	{

		File Src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date objDate = new Date(); // Current System Date and time is assigned to objDate
		SimpleDateFormat objSDF = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String date = objSDF.format(objDate);
		FileUtils.copyFile(Src, new File(
				"C:\\Users\\kalid\\eclipse-workspace\\ExcelDataReading\\src\\ScreenShots\\Screenshot_" + date + ".png"));

	}

}
