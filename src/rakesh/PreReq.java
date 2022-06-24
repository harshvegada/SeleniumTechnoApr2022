package rakesh;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class PreReq {
	
	public static WebDriver setUp(String url) {
		System.setProperty("webdriver.chrome.driver", "D:\\work_dsi\\APR22\\SeleniumTechnoApr2022\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("======> Running prerequisites <==========");
		System.out.println("Chrome browser launched");
		driver.manage().window().maximize();
		driver.get(url);
		System.out.println("URL \"" + url +"\" launched");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}
	
	public static WebDriver setUp() {		
		return setUp("http://automationbykrishna.com/");
	}
	
//	public static void main(String[] args) {
//		setUp();
//		setUp("http://facebook.com/");
//	}
}
