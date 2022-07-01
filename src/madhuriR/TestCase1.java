package madhuriR;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCase1 {
	protected static WebDriver driver;
	public void setUp(String url) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	public void setUp() {
		setUp("https://apr22madhuri-trials7501.orangehrmlive.com/");
	}
	@Test
	public void testCase1() {
		System.out.println("Lounch browser");
		setUp();
		
		System.out.println("Verify logo displayed or not");
		WebElement logoElement = driver.findElement(By.xpath("//div[@class=\"organization-logo shadow\"]/img"));
		Assert.assertTrue(logoElement.isDisplayed());
		
		System.out.println("Verify login panel is displyed or not");
		WebElement loginPanelElement = driver.findElement(By.xpath("//div[@class=\"login-form shadow\"]"));
		Assert.assertTrue(loginPanelElement.isDisplayed());
		
		System.out.println("Login with valid Credentials");
		
		driver.findElement(By.xpath("//input[@id=\"txtUsername\"]")).sendKeys("Admin");
		
		driver.findElement(By.xpath("//input[@id=\"txtPassword\"]")).sendKeys("cW@OfXD40d");
		
		System.out.println("Click on login");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
		System.out.println("verify url endswith dashboard");
		Assert.assertTrue(driver.getCurrentUrl().endsWith("dashboard"));
		
		System.out.println("close driver");
		driver.close();
		
	
	}
}
