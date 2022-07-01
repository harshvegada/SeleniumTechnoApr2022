package arti.standalonescripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC5_HRAdministrationTab {

	WebDriver driver;
	
	@Test
	public void verifyHRAdministrationTab() {
		
	
		System.out.println("STEP - Launch browser");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
		System.out.println("STEP - Load URL");
		driver.get("https://artitechno-trials7501.orangehrmlive.com/");
	
		System.out.println("VERIFY - User is able to enter the username ");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");

		System.out.println("VERIFY - User is able to enter the password ");
		driver.findElement(By.id("txtPassword")).sendKeys("6cyNOTm3N@");
	
		System.out.println("STEP - User click on Login button on Login Page");
		driver.findElement(By.xpath("//div[@class='button-holder']/button")).click();
	
		System.out.println("STEP -  Click on HR Administration tab from left panel");
		driver.findElement(By.linkText("HR Administration")).click();
		
		System.out.println("STEP - Click on Manage User Roles tab from top panel");
		driver.findElement(By.linkText("Manage User Roles")).click();
	
		System.out.println("VERIFY -  Verify by default 50 record should get display in table.");
		int defaultRecords = Integer.parseInt(driver.findElement(By.xpath("//input[@value='50']")).getText());
		Assert.assertEquals(defaultRecords,50);
	}
}
