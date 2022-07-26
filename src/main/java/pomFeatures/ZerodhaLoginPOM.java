package pomFeatures;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZerodhaLoginPOM
{
	WebDriver driver;
	
	@FindBy(xpath = "//h2")
	private WebElement title;
	
	@FindBy(xpath = "//input[@label='User ID']")
	private WebElement userID; 
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;
	
	@FindBy(xpath = "//a[text()='Forgot user ID or password?']")
	private WebElement forgotLink;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement button;
	
	
	public ZerodhaLoginPOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		
	}
	
	public WebElement getTitle()
	{
		return title;
	}
	
	
	public WebElement getUserID()
	{
		return userID;
	}
	
	public WebElement getPassword()
	{
		return password;
	}
	
	public WebElement getForgotLink()
	{
		return forgotLink;
	}
	
	public WebElement getButton()
	{
		return button;
	}
	

}
