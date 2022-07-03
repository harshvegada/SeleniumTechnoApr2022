package minu.orghrm.standalonescript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase5 {

	private static WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = PredefinedActions.browserSetUp();

		System.out.println("STEP - Enter userName");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");

		System.out.println("STEP - Enter password");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("2lCagM@9EB");

		System.out.println("VERIFY - User click on Login button on Login Page");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
	}

	@Test
	public void verifyRecord() {

		System.out.println("STEP - Click on HR Administration tab from left panel");
		driver.findElement(By.linkText("HR Administration")).click();

		System.out.println("STEP - Click on Manage User Roles tab from top panel");
		driver.findElement(By.partialLinkText("Manage User Roles")).click();

		System.out.println("STEP - get total record per page.");
		WebElement recordsElement = driver.findElement(By.xpath("//div[@class='select-wrapper']//input"));
		int actualRecordPerPage = Integer.parseInt(recordsElement.getAttribute("value"));
		int expectedRecordPerPage = 50;

		System.out.println("VERIFY - default 50 record should get display in table.");
		Assert.assertEquals(actualRecordPerPage, expectedRecordPerPage);
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
