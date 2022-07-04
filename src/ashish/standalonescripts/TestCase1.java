package ashish.standalonescripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase1 {
	private static WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = PredefinedActions.browserSetUp();
	}
	
	@Test
	public void loginTest() {
		
		System.out.println("VERIFY - Logo displayed on Login Page");
		boolean isLogoDisplayedFlag = driver.findElement(By.xpath("//div[@class='organization-logo shadow']/img"))
				.isDisplayed();
		Assert.assertTrue(isLogoDisplayedFlag);

		System.out.println("VERIFY - Login Panel displayed on Login Page");
		boolean isLoginFormDisplayed = driver.findElement(By.xpath("//div[@class='login-form shadow']")).isDisplayed();
		Assert.assertTrue(isLoginFormDisplayed);

		System.out.println("STEP - Enter userName");
		WebElement usernameElement = driver.findElement(By.xpath("//input[@id='txtUsername']"));
		usernameElement.sendKeys("admin");

		System.out.println("VERIFY - User able to enter username");
		String actualUserName = usernameElement.getAttribute("value");
		Assert.assertEquals(actualUserName, "admin");

		System.out.println("STEP - Enter password");
		WebElement passwordElement = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		passwordElement.sendKeys("h@s4WMi1LR");

		System.out.println("VERIFY - User able to enter password");
		String actualPassword = passwordElement.getAttribute("value");
		Assert.assertEquals(actualPassword, "h@s4WMi1LR");

		System.out.println("VERIFY - User click on Login button on Login Page");
		driver.findElement(By.xpath("//button[text()='Login']")).click();

		System.out.println("VERIFY - Employee Management header should be visible.");
		boolean isEmpManagementDisplayed = driver.findElement(By.xpath("//div[text()='Employee Management']"))
				.isDisplayed();
		Assert.assertTrue(isEmpManagementDisplayed);
	}
	
	@AfterClass
	public void tearDown(){
		driver.close();
	}
}
