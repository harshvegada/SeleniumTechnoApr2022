package vrinda.StandAloneTC;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Orange_TC1 {
	private WebDriver driver;
	void launchBrowser(String url){
	System.setProperty("webdriver.chrome.driver","resource/chromedriver.exe");
	driver = new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	}
	
	@ Test
	public void logIn() {
		System.out.println(" Step : \"1. Launch https://<your server name>-trials71.orangehrmlive.com/auth/login");
		launchBrowser("https://vrinda-trials7501.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		System.out.println("Step : Verify Logo displayed on Login Page");
		boolean isLogoDisplay=driver.findElement(By.xpath("//div[@class='organization-logo shadow']")).isDisplayed();
		Assert.assertTrue(isLogoDisplay);
		
		System.out.println("Step : Verify Login Panel displayed on Login Page");
		boolean isLoginPanelDispayed=driver.findElement(By.xpath("//div[@class='login-form shadow']")).isDisplayed();
		Assert.assertTrue(isLoginPanelDispayed);
		
		final String username="Admin";
		final String password="H5@n5njQKR";
		
		System.out.println("Step :Enter username ");
		WebElement usernameElement=driver.findElement(By.xpath("//input[@id='txtUsername']"));
		usernameElement.sendKeys(username);
		
		System.out.println("Step :Enter password ");
		WebElement passwordElement=driver.findElement(By.xpath("//input[@id='txtPassword']"));
		passwordElement.sendKeys(password);
		
		System.out.println("Step : User able to enter username");
		String actualName =usernameElement.getAttribute("value");
		Assert.assertEquals(actualName,username);
		
		System.out.println("Step : User able to enter password");
		String actualPassword=passwordElement.getAttribute("value");
		Assert.assertEquals(actualPassword,password);
		
		
		System.out.println("Step :User click on Login button on Login Page");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		System.out.println("Verify:'Employee Management' header should be visible.");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		boolean isEmployeeManagementVisible=driver.findElement(By.xpath("//div[text()=\"Employee Management\"]")).isDisplayed();
		Assert.assertTrue(isEmployeeManagementVisible);
		}
	
}
