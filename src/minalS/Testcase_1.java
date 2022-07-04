package minalS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase_1 {

	@Test
	void verifyLoginFunctionality() {
		System.out.println("STEP-Launch a browser");
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("STEP-URL");
		driver.get("https://minals-trials7501.orangehrmlive.com/auth/seamlessLogin");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		System.out.println("Verify Logo displayed on login page");
		boolean logoElement=driver.findElement(By.xpath("//div[@class='organization-logo shadow']")).isDisplayed();
		Assert.assertTrue(logoElement);
		
		System.out.println("Verify login panel displayed on login page");
		boolean loginPanelElement=driver.findElement(By.xpath("//div[@class='login-form shadow']")).isDisplayed();
		Assert.assertTrue(loginPanelElement);
		
		System.out.println("Verify User Name");
		WebElement useNameElement=driver.findElement(By.id("txtUsername"));
		useNameElement.sendKeys("Admin");
		
		System.out.println("VERIFY-able to enter user name");
		String actualUserName=useNameElement.getAttribute("value");
		Assert.assertEquals(actualUserName, "Admin");
		
		System.out.println("Verify Passward");
		WebElement passwardElement=driver.findElement(By.id("txtPassword"));
		passwardElement.sendKeys("7@kOfBn8YV");
		
		System.out.println("VERIFY-able to enter passward");
		String actualPassward=passwardElement.getAttribute("value");
		Assert.assertEquals(actualPassward, "7@kOfBn8YV");
		
		System.out.println("Verify login button on login page");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		System.out.println("Verify Employee Management header should be visible");
		boolean isEmployeeManagementisDisplayed=driver.findElement(By.xpath("//div[text()='Employee Management']")).isDisplayed();
		Assert.assertTrue(isEmployeeManagementisDisplayed); 
		
		String expectedTitle="Employee Management";
		String currentTitle=driver.getTitle();
		Assert.assertEquals(currentTitle, expectedTitle);
		
		
	
		driver.close();
		}
}
