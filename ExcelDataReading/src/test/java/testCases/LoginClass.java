package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import objectRepository.LoginPage;
import utility.ExcelUtility;
import utility.ScreenshotUtility;

public class LoginClass {

	WebDriver driver;

	ExtentReports report;

	ExtentTest logger;

	ExtentSparkReporter extent;

	@BeforeTest

	public void beforetest()

	{

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\kalid\\Downloads\\chromedriver_win32 (5)\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://ui.cogmento.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@AfterMethod

	public void screenshot() throws IOException

	{
		ScreenshotUtility screen = new ScreenshotUtility(driver);

		screen.takescreenshot();

	}

	@AfterMethod

	public void report()

	{
		extent = new ExtentSparkReporter(
				"C:\\Users\\kalid\\eclipse-workspace\\ExcelDataReading\\src\\Reports\\LoginReport");

		report = new ExtentReports();

		report.attachReporter(extent);

		logger = report.createTest("Login");

		logger.pass("Successful login");

		report.flush();

	}

	@Test

	public void login() throws IOException

	{

		LoginPage lp = new LoginPage(driver);

		ExcelUtility ut = new ExcelUtility();

		String emailid = ut.email("Login", 0, 0);

		double password = ut.password("Login", 0, 1);

		String user_password = Double.toString(password);

		lp.email().sendKeys(emailid);

		lp.password().sendKeys(user_password);

	}

}
