package madhuriR;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase4 {
	protected static WebDriver driver;
	public void setUp(String url) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	@BeforeClass
	public void setUp() {
		setUp("https://apr22madhuri-trials7501.orangehrmlive.com/");
	}
	
	public void login() {
		driver.findElement(By.xpath("//input[@id=\"txtUsername\"]")).sendKeys("Admin");
		
		driver.findElement(By.xpath("//input[@id=\"txtPassword\"]")).sendKeys("cW@OfXD40d");
		
		//System.out.println("Click on login");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
	
	}
	@Test
	void testCase4() {
		System.out.println("Login with valid Credential");
		login();
		
		System.out.println("click on my info tab");
		driver.findElement(By.xpath("//div[@class=\"top-level-menu-item-container\"]/a[contains(text(),\"My Info \")]")).click();
		
		System.out.println("verify personal info is displayed");
		WebElement isPersonalInfo = driver.findElement(By.xpath("//input[@id=\"firstName\"]"));
		Assert.assertTrue(isPersonalInfo.isDisplayed());
		
		System.out.println("click on salary");
		driver.findElement(By.xpath("//a[contains(text(),\"Salary \")]")).click();
		
		System.out.println("verify salary is non-zero or not");
		String salary = driver.findElement(By.xpath("//div[contains(text(),\"$\")]")).getText();
		salary = salary.replace("$","").replace(",","");
		String excatSalary = salary.substring(0,salary.indexOf("."));
		int ctcInt = Integer.parseInt(excatSalary);
		Assert.assertTrue(ctcInt>0,"current salary is non zero");
		
	}
	@AfterTest()
	public void closeDriver() {
		driver.close();
	}
}
