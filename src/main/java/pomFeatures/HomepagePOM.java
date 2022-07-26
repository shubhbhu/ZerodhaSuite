package pomFeatures;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomepagePOM 
{
	WebDriver driver;
	@FindBy(xpath = "//span[@class='nickname']")
	private WebElement nickname;
	
	//@FindBy(xpath = "//div[@class='app-nav']/a")
	//private WebElement navBar;
	
	By nav = By.xpath("//div[@class='app-nav']/a");
	
	public HomepagePOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		
	}
	
	public WebElement getNickname()
	{
		return nickname;
	}
	
	public int getCount()
	{
		List<WebElement> navbar = driver.findElements(nav);
		int size = navbar.size();
		return size;
	}

}
