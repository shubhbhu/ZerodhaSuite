package zerodhaTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseFeatures.InvokeBrowser;
import pomFeatures.HomepagePOM;
import pomFeatures.ZerodhaInputPinPOM;
import pomFeatures.ZerodhaLoginPOM;
import utilities.MyUtility;

public class ZerodhaInputPinTest extends InvokeBrowser
{
	WebDriver driver;
	
	@BeforeClass
	public void getLogin() throws IOException
	{
		driver = openBrowser();
		driver.get(url);
		//input userID
		ZerodhaLoginPOM log = new ZerodhaLoginPOM(driver);
		WebElement userID = log.getUserID();
		userID.sendKeys("DV1510");
		//input password
		WebElement password = log.getPassword();
		password.sendKeys("Goal@123");
		//hit login button
		log.getButton().click();
		
	}
	@Test
	public void verifyID()
	{
		ZerodhaInputPinPOM pin = new ZerodhaInputPinPOM(driver);
		pin.getID().isDisplayed();
	}
	
	@Test
	public void verifyPin()
	{
		String expected = "959594";
		ZerodhaInputPinPOM pin = new ZerodhaInputPinPOM(driver);
		pin.getPin().sendKeys(expected);
		String actual = pin.getPin().getAttribute("value");
		Assert.assertEquals(expected, actual);
		
	}
	
	@Test
	public void getHomepage() 
	{
		ZerodhaInputPinPOM pin = new ZerodhaInputPinPOM(driver);
		
		
		//hit countinue button
		pin.getClick().click();
		
		
		HomepagePOM home= new HomepagePOM(driver);
		WebElement nickname = home.getNickname();
		nickname.isDisplayed();
		
		
	}

}
