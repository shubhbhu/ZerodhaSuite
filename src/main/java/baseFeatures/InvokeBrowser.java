package baseFeatures;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
//https://github.com/shubhbhu/ZerodhaSuite.git
	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	

public class InvokeBrowser 
{
	public WebDriver driver;
	public Properties pro;
	public String url;
	public WebDriver openBrowser() throws IOException
	{
		pro = new Properties();
		String path = "C:\\Users\\HP\\eclipse-workspace\\Zerodha\\src\\main\\resources\\resources\\data.property";
		FileInputStream fis = new FileInputStream(path);
		pro.load(fis);
		String browser = pro.getProperty("browser");
		url = pro.getProperty("loginURL");
			
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
			if(browser.equals("edge"))
			{
				System.setProperty("webdriver.edge.driver", "G:\\Velocity_Testing\\Apps\\ChromeDriver\\chromedriver.exe");
				driver = new EdgeDriver();
			}
		
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			return driver;
		}
		
	public String getScreenshot(WebDriver driver, String testName) throws IOException
	{
		TakesScreenshot ts = ((TakesScreenshot)driver);
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"//screenshots"+testName+".png";
		FileUtils.copyFile(src, new File(path));
		return path;
	}
		

}



