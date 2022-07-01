package ashish.standalonescripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {

	public static WebDriver browserSetUp(String url) {
		System.out.println("STEP-Launch Chrome brower");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("STEP-Load URL");
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}

	public static WebDriver browserSetUp() {
		return browserSetUp("https://ashishapr22-trials7501.orangehrmlive.com/");
	}

}