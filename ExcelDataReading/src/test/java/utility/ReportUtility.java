package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportUtility {
	
	ExtentReports report;
	
	public ReportUtility()
	
	{
		
		
	}
	
	public void report()
	
	{
		report.createTest("login");
		
	}

}
