package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class MyExtentReport
{
	ExtentReports extent;
	public ExtentReports getReportObject()
	{
		// reoprt path
		String path = System.getProperty("user.dir")+"//reports//ZerodhaReport.html";
		// important classes
		//1. ExtentSparkReporter
		//2. ExtentReports
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		
		reporter.config().setDocumentTitle("ZerodhaExtentReport");
		reporter.config().setReportName("ZerodhaKite");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "SHubham");
		return extent;
		
	}

}
