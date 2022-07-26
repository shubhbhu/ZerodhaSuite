package pomFeatures;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZerodhaInputPinPOM
{
	WebDriver driver;
	
	@FindBy(xpath = "//input[@id='pin']")
	private WebElement pin;
	
	@FindBy(xpath = "//h2")
	private WebElement id;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement button;
	
	public ZerodhaInputPinPOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		
	}
	
	public WebElement getPin()
	{
		return pin;
	}

	public WebElement getID()
	{
		return id;
	}
	
	public WebElement getClick()
	{
		return button;
	}
}
