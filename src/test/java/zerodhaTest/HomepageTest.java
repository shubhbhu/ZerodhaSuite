package zerodhaTest;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseFeatures.InvokeBrowser;
import pomFeatures.HomepagePOM;
import pomFeatures.ZerodhaInputPinPOM;
import pomFeatures.ZerodhaLoginPOM;

public class HomepageTest extends InvokeBrowser
{
	@BeforeClass
	public void getHomepage() throws IOException
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
		//enter pin
		String pin1 = "959594";
		ZerodhaInputPinPOM pin = new ZerodhaInputPinPOM(driver);
		pin.getPin().sendKeys(pin1);
		//hit countinue button
		pin.getClick().click();
	}
	
	@Test
	public void verifyNickname()
	{
		HomepagePOM home= new HomepagePOM(driver);
		WebElement nickname = home.getNickname();
		String actual = nickname.getText();
		String expected = "Kulkarni";
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test
	public void navBarCount()
	{
		HomepagePOM home= new HomepagePOM(driver);
		int actual = home.getCount();
		int expected = 6;
		Assert.assertEquals(actual, expected);
	}
}
