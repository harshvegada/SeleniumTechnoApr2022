package minu.orghrm.standalonescript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase4 {

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
	public void verifyMyInfo() {

		System.out.println("VERIFY - Employee Management title should be visible.");
		String title = driver.getTitle();
		Assert.assertTrue(title.equals("Employee Management"));

		System.out.println("STEP - Click on My Info tab");
		driver.findElement(By.partialLinkText("Info")).click();

		System.out.println("VERIFY - user Personal details displayed");
		WebElement personalDetailElement = driver
				.findElement(By.xpath("//div[@id='personal_details_tab']//input[@id='firstName']"));
		Assert.assertTrue(personalDetailElement.isDisplayed());

		System.out.println("STEP - Click on Salary tab");
		driver.findElement(By.linkText("Salary")).click();

		System.out.println("VERIFY -  payable (CTC) amount is non-zero");
		WebElement ctcElement = driver.findElement(
				By.xpath("//div[@class='col-9 summary-cards-container']/div[1]/div[2][contains(text(),'$')]"));
		String ctcPayableString = ctcElement.getText();
		ctcPayableString = ctcPayableString.replace("$", "").replace(",", "");
		ctcPayableString = ctcPayableString.substring(0, ctcPayableString.indexOf("."));

		int ctcAmount = Integer.parseInt(ctcPayableString);
		Assert.assertTrue(ctcAmount > 0);
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
