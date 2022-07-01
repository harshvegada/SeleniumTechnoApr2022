package amar_StandAlone;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TS1_StandAlone {
	
	final String username = "admin";
	final String password = "C@sRqq3L4U";

	@Test
	public void tc1() {

		System.out.println("STEP - Launch Chrome brower");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("STEP - Load URL");
		driver.get("https://technoamar-trials7501.orangehrmlive.com/");
		driver.manage().window().maximize();
		System.out.println("VERIFY - Logo displayed on Login Page");
		boolean isLogoDisplayedFlag = driver.findElement(By.xpath("//div[@class='organization-logo shadow']/img"))
				.isDisplayed();
		Assert.assertTrue(isLogoDisplayedFlag);

		System.out.println("VERIFY - Login Panel displayed on Login Page");
		boolean isLoginFormDisplayFlag = driver.findElement(By.xpath("//div[@class='login-form shadow']"))
				.isDisplayed();
		Assert.assertTrue(isLoginFormDisplayFlag);

		System.out.println("STEP - Enter username");
		WebElement usernameElement = driver.findElement(By.xpath("//input[@id='txtUsername']"));
		usernameElement.sendKeys(username);

		System.out.println("VERIFY - User able to enter username");
		String actualUsername = usernameElement.getAttribute("value");
		Assert.assertEquals(actualUsername, username);

		System.out.println("STEP - Enter password");
		WebElement passwordElement = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		passwordElement.sendKeys(password);

		System.out.println("VERIFY - User able to enter username");
		String actualPassword = passwordElement.getAttribute("value");
		Assert.assertEquals(actualPassword, password);

		System.out.println("STEP - User click on Login button on Login Page");
		driver.findElement(By.xpath("//div[@class='button-holder']/button")).click();

		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		boolean isEmpManagementDisplayed = driver.findElement(By.xpath("//div[text()='Employee Management']"))
				.isDisplayed();
		Assert.assertTrue(isEmpManagementDisplayed);

		driver.close();
		System.out.println("-:Current browser instance closed:-");
	}

}
