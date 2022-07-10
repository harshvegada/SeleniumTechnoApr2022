package alka;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {
	
	protected static WebDriver driver;
	
	static public WebDriver setUp(String url )
	{
		System.out.println("Launch Chrome Browser");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		System.out.println("Step-Load URL ");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}
	static public WebDriver setUp()
	{
		return setUp("https://alkaorg-trials7501.orangehrmlive.com/client/#/dashboard");
	}
	public  String getTitle()
	{
		return driver.getTitle();
	}
	public  String getCurrentUrl()
	{
		return driver.getCurrentUrl();
	}
	
}
