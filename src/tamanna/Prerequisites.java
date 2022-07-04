package tamanna;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Prerequisites {

	public static WebDriver loadURL() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		return driver;
	}
	
	public static void redirect(WebDriver driver, String elementId) {
		driver.findElement(By.id(elementId)).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
}
