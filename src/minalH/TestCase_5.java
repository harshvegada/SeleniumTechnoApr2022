package minalH;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_5 {

	@Test
	public void verifyPagination() {
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP : Launch url");
		driver.get("https://minalhake-trials7501.orangehrmlive.com/auth/login");
		System.out.println("\n"+"STEP : Enter username");
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
		System.out.println("\n"+"STEP : Enter password");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("@tqGJP1nQ5");
		System.out.println("\n"+"STEP : User click on login button");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		System.out.println("STEP : Click on HR Administration tab");
		driver.findElement(By.xpath("//div[@id='menu-content']/ul/li[2]")).click();
		
		System.out.println("STEP : Click on Manage User Roles");
		driver.findElement(By.xpath("//div[@class='top-level-menu-item-container']/a[text()='Manage User Roles ']")).click();
		
		System.out.println("STEP : wait for table to load");
		//driver.findElement(By.xpath("//table[@class='highlight bordered']/tbody"));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("STEP : getting total rows from table");
		int rows = driver.findElements(By.xpath("//table[@class='highlight bordered']/tbody/tr")).size();
		
		System.out.println("STEP : Getting data from pagination");
		String pagination = driver.findElement(By.xpath("//li[@class='summary']")).getText().split(" ")[4];
		int totalRows = Integer.parseInt(pagination);
		
		System.out.println("STEP : Verify total rows and pagination rows");
		Assert.assertEquals(rows, totalRows);
		
		System.out.println("STEP : Verify default pagination is 50");
		WebElement perPageCount = driver.findElement(By.xpath("//input[@value='50']"));
		int pageCount = Integer.parseInt(perPageCount.getAttribute("value"));
		Assert.assertEquals(pageCount, 50);
		
	}
}
