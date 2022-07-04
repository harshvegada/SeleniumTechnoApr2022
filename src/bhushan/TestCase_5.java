package bhushan;
/*"1. Launch https://<your server name>-trials71.orangehrmlive.com/auth/login
2. User able to enter username as ""your username""
3. User able to enter password as ""your password""
4. Click on HR Administration tab from left panel
5. Click on Manage User Roles tab from top panel
6. Verify by default 50 record should get display in table."*/

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_5 {
	@Test
	void verifyvalueDisplayInTableAccordingToPagination() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver=new ChromeDriver();
		System.out.println("Step-- Launch Browser  ");
		driver.get("https://bhushangdk-trials7501.orangehrmlive.com/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		System.out.println("Step-- Verify Logo displayed on Login Page ");
		boolean isLogoDisplayed=driver.findElement(By.xpath("//div[@class='organization-logo shadow']")).isDisplayed();
		Assert.assertEquals(isLogoDisplayed, true);
		
		System.out.println("Step-- Verify Login Panel displayed on Login Page ");
		boolean isLoginPanelDisplayed=driver.findElement(By.xpath("//div[@class='login-form shadow']")).isDisplayed();
		Assert.assertEquals(isLoginPanelDisplayed, true);
		
		System.out.println("Step-- User able to enter username as your username ");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		String actualUserName=driver.findElement(By.id("txtUsername")).getAttribute("value");
		String expectedUsername="Admin";
		Assert.assertEquals(actualUserName, expectedUsername);
		
		System.out.println("Step-- User able to enter username as your password ");
		driver.findElement(By.id("txtPassword")).sendKeys("h1J@DXvJ8t");
		String actualPassword=driver.findElement(By.id("txtPassword")).getAttribute("value");
		String expectedPassword="h1J@DXvJ8t";
		Assert.assertEquals(actualPassword, expectedPassword);

		System.out.println("Step-- User click on Login button on Login Page ");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		System.out.println("Step-- Click on HR Administration tab from left panel");
		 driver.findElement(By.xpath("//a[@id='menu_item_81'][1]")).click();
		
		 System.out.println("Step--Click on Manage User Roles tab from top panel");
		 driver.findElement(By.xpath("//a[@ui-sref='admin.user_roles']")).click();
		 
		 System.out.println("Step--Verify by default 50 record should get display in table");
		 boolean isRecordDisplayed=false;
		 int count=driver.findElements(By.xpath("//td[@class='cursor-pointer']")).size();
		 	if(count==8) {
			   isRecordDisplayed= true;
		 	}else
			   isRecordDisplayed= false;
			Assert.assertTrue(isRecordDisplayed);
		 
			System.out.println("System End");
			driver.close();
		
	}
}
