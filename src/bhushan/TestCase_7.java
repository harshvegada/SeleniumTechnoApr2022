package bhushan;
/*"1. Launctps://<your server name>-trials71.orangehrmlive.com/auth/login
2. User able to enh htter username as ""your username""
3. User able to enter password as ""your password""
4. Click on HR Administration tab
5. click  on Organization tab
6. User click on General Information tab
7. User change Organization Name to ""Anything""
8. Verify Number of Employees field is disabled
9. User save the information
10. User mouse hover on user profile and click on Settin icon
11. User click on about section
12. Verify that updated Organization name display as ""Anything"""*/

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_7 {
	@Test
	void updateCompanyName() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver=new ChromeDriver();
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
		
		System.out.println("Step-- Click on HR Administration tab ");
		driver.findElement(By.xpath("//a[@id='menu_item_81'][1]")).click();
		
		System.out.println("Step--click on Organization tab");
		driver.findElement(By.xpath("//a[text()='Organization ']")).click();
		
		System.out.println("Step--User click on General Information tab");
		 driver.findElement(By.xpath("//a[text()=' General Information ']")).click();
		 
	    System.out.println("Step--User change Organization Name to technocredit");
		 System.out.println("Clear first name");
		   WebElement firstname=driver.findElement(By.xpath("//input[@id='name']"));
		   firstname.clear();
		   firstname.sendKeys("technocredits");
		   
		   System.out.println("Step--Verify Number of Employees field is disabled");
		   boolean isNumberofEmployeesfielddisabled= driver.findElement(By.xpath("//input[@id='numemp']")).isEnabled();
		   Assert.assertFalse(isNumberofEmployeesfielddisabled);
		
		   System.out.println("Step--User save the information");
		   driver.findElement(By.xpath("//button[@type='submit']")).click(); 
		   
		   System.out.println("Step--User mouse hover on user profile and click on Settin icon");
		   System.out.println("mouse hover");
		   WebElement userprofileElement=driver.findElement(By.xpath("//div[@class='image-container']"));
		   Actions actions =new Actions(driver);
		   actions.moveToElement(userprofileElement).build().perform();
		   System.out.println("click on setting");
		   driver.findElement(By.xpath("//a[@class='password-action profile-context-menu-handler']/i")).click();  
	   
		   System.out.println("Step--User click on about section");
		   driver.findElement(By.xpath("//a[@id='aboutDisplayLink']")).click();
		   
		   System.out.println("Step-Verify that updated Organization name display as technocredit");
		   String s=driver.findElement(By.xpath("//div[@class='col s12'][1]/p")).getText();
		   String orgName=s.split(":")[1].trim();
		   System.out.println(orgName);
		   Assert.assertEquals(orgName, "technocredits");
		   
		   System.out.println("System end");
		   driver.close();
		
	}
	
	
	

}
