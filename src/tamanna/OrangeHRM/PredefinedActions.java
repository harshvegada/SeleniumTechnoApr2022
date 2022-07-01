package tamanna.OrangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {
	
	public static WebDriver setUp() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://tamyshah-trials7501.orangehrmlive.com/auth/login");
		driver.manage().window().maximize();
		return driver;
	}
}
