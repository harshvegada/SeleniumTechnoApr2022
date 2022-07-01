package bhushan;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



/*
"1. Launch https://<your server name>-trials71.orangehrmlive.com/auth/login
2. Verify Logo displayed on Login Page
3. Verify Login Panel displayed on Login Page
4. User able to enter username as """"your username""""
5. User able to enter password as """"your password""""
6. User click on Login button on Login Page
7. User should navigate to home page, Verify ""Employee Management"" header should be visible.
"
*/
public class TestCase_1 {
	@Test
	void verifyLoginPage() {
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
		
		System.out.println("Step-- User should navigate to home page, Verify Employee Management header should be visible ");
		String titleName=driver.findElement(By.xpath("//div[@ng-if='!ohrmnavbar.isClickableTitle($index)']")).getText();
		Assert.assertEquals(titleName, "Employee Management");
		
		System.out.println("Step-- Driver close ");
		driver.close();
		
		
		
		
	}
	
	
	
	
	

}
