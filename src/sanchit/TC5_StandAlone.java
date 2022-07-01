package sanchit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC5_StandAlone {

	final String username = "admin";
	final String password = "Vc0@vIHqZ3";

	@Test
	public void tc5() {

		System.out.println("STEP - Launch Chrome brower");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("STEP - Load URL");
		driver.get("https://technosanchit-trials7501.orangehrmlive.com/");
		driver.manage().window().maximize();

		System.out.println("STEP - Enter username");
		WebElement usernameElement = driver.findElement(By.xpath("//input[@id='txtUsername']"));
		usernameElement.sendKeys(username);
		String actualUsername = usernameElement.getAttribute("value");
		Assert.assertEquals(actualUsername, username);
		System.out.println("VERIFY - Username Entered");

		System.out.println("STEP - Enter password");
		WebElement passwordElement = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		passwordElement.sendKeys(password);
		String actualPassword = passwordElement.getAttribute("value");
		Assert.assertEquals(actualPassword, password);
		System.out.println("VERIFY - Password Entered");

		System.out.println("STEP - User click on Login button on Login Page");
		driver.findElement(By.xpath("//div[@class='button-holder']/button")).click();
		System.out.println("VERIFY: Clicked on login button");

		System.out.println("STEP: Click on HR Administration tab from left panel");
		driver.findElement(By.xpath("//a[@class=' main-menu-item-1']//span[text()='HR Administration']")).click();
		System.out.println("VERIFY: HR Administration page displayed");

		System.out.println("STEP: Click on Manage User Roles tab from top panel");
		driver.findElement(By.xpath("//a[contains(text(),'Manage User Roles')]")).click();
		System.out.println("VERIFY: Manage User Roles section displayed");

		System.out.println("STEP: Verify by default 50 record per page should get display in table");
		int defaultRecordCount = Integer
				.parseInt(driver.findElement(By.xpath("//input[@value='50']")).getAttribute("value"));
		Assert.assertTrue(defaultRecordCount == 50);
		System.out.println("VERIFY: 50 records per page displayed by default in table");

		System.out.println("STEP: Verify total record and showing count of record in right corner of page");
		int recordCountUnderManageUserRoles = driver
				.findElements(By.xpath("//table[@class='highlight bordered']/tbody/tr")).size();
		int pagination = Integer
				.parseInt(driver.findElement(By.xpath("//li[@class='summary']")).getText().split(" ")[4]);
		Assert.assertEquals(recordCountUnderManageUserRoles, pagination);
		System.out.println("VERIFY: Current record count in table: " + pagination);

		driver.close();
		System.out.println("-:Current browser instance closed:-");
	}
}
