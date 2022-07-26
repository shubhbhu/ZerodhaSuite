package MyListeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseFeatures.InvokeBrowser;
import utilities.MyExtentReport;


public class TestListeners extends InvokeBrowser implements ITestListener
{
	ExtentTest test;
	MyExtentReport rp = new MyExtentReport();
	ExtentReports extent = rp.getReportObject();

	//for parallel testing
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result)
	{
		// test will start with extent report
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) 
	{
		// TODO Auto-generated method stub
		String passedTest = result.getMethod().getMethodName();
		test.log(Status.PASS, passedTest+"passed");
	}

	public void onTestFailure(ITestResult result) 
	{
		extentTest.get().fail(result.getThrowable());
		String testName = result.getMethod().getMethodName();
		WebDriver driver = null;
		
		try 
		{
			driver = (WebDriver)result.getTestClass().getRealClass().
					getDeclaredField("driver").get(result.getInstance());
		}
		catch (Exception e1) 
		{
			e1.printStackTrace();
		} 
		
		try
		{
			extentTest.get().addScreenCaptureFromPath(getScreenshot(driver, testName), testName);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}

}
