package zerodhaTest;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseFeatures.InvokeBrowser;
import pomFeatures.ZerodhaInputPinPOM;
import pomFeatures.ZerodhaLoginPOM;


public class ZerodhaLoginTest extends InvokeBrowser
{
	ZerodhaLoginPOM log;
	@BeforeClass
	public void getLoginPage() throws IOException
	{
		openBrowser();
		driver.get(url);
	}
	
	@Test (priority = 1)
	public void verifyTitle()
	{
		log = new ZerodhaLoginPOM(driver);
		String actualTitle = log.getTitle().getText();
		String expectedTitle = "Login to Kite";
		
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test (priority = 2)
	public void verifyUserID()
	{
		log = new ZerodhaLoginPOM(driver);
		WebElement userID = log.getUserID();
		userID.sendKeys("DV1510");
		//MyUtility.tabValue(driver, userID);
	}
	
	@Test (priority = 3)
	public void verifyPassword()
	{
		log = new ZerodhaLoginPOM(driver);
		WebElement password = log.getPassword();
		password.sendKeys("Goal@123");
		
		String actualText = password.getAttribute("value");
		System.out.println(actualText);
		String expectedText = "Goal@123";
		Assert.assertEquals(actualText, expectedText);
		
	}
	
	@Test (priority = 4)
	public void verifyForgotText()
	{
		log = new ZerodhaLoginPOM(driver);
		String actual = log.getForgotLink().getText();
		String expected = "Forgot user ID or password?";
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test(priority = 5)
	public void getLogin() 
	{
		log = new ZerodhaLoginPOM(driver);
		log.getButton().click();
		
		ZerodhaInputPinPOM pin = new ZerodhaInputPinPOM(driver);
		Assert.assertTrue(pin.getPin().isDisplayed());
	}

}
