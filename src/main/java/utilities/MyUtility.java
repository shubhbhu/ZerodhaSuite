package utilities;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyUtility 
{
	
	public static void tabValue(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		
		
		js.executeScript("arguments[0].value='DV1510'", element);
		
		
	}
	
	public static void clickOn(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		
		js.executeScript("arguments[0].click();", element);
		
	}
	
	
}
