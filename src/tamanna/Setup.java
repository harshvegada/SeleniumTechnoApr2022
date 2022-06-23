package tamanna;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Setup {
	public static WebDriver setUp(String url) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}
	
	public static void navigate(String id,WebDriver driver) {
		driver.findElement(By.id(id)).click();
		staticWait(5000);
	}
	
	public static void browserClose(WebDriver driver) {
		driver.close();
	}
	
	
	public static void staticWait(int miliSec) {
		try {
			Thread.sleep(miliSec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
