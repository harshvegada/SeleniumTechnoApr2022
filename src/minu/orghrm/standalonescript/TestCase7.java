package minu.orghrm.standalonescript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase7 {

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
	void verifyUpdatedCompanyName() {

		System.out.println("STEP - Click on HR Administration tab");
		driver.findElement(By.xpath("//a//span[text()='HR Administration']")).click();

		System.out.println("STEP - Click on Organization tab");
		driver.findElement(By.partialLinkText("Organization")).click();

		System.out.println("STEP - click on General Information tab");
		driver.findElement(By.xpath("//a[contains(text(),'General Information')]")).click();

		System.out.println("STEP - change Organization Name");
		WebElement companyNameElement = driver.findElement(By.id("name"));
		companyNameElement.clear();
		companyNameElement.sendKeys("TechnoCredits QA");

		System.out.println("VERIFY - Number of Employees field is disabled");
		boolean isNumberOfEmployee = driver.findElement(By.xpath("//input[@id='numemp']")).isEnabled();
		Assert.assertFalse(isNumberOfEmployee);

		System.out.println("STEP - save the information");
		driver.findElement(By.xpath("//button[text()='Save']")).click();

		WebElement saveSucess = driver.findElement(By.xpath("//div[text()='Successfully Updated']"));
		Assert.assertEquals(saveSucess.getText(), "Successfully Updated");

		WebElement userProfile = driver.findElement(By.xpath("//div[@class='image-container']/img"));

		System.out.println("STEP - Mouse Hover on Profile and Click on setting icon on profile");
		Actions userAction = new Actions(driver);
		userAction.moveToElement(userProfile)
				.click(driver.findElement(By.xpath("//div[@class='image-container']//i[@class='material-icons']")))
				.build().perform();

		System.out.println("STEP - click on about section");
		driver.findElement(By.linkText("About")).click();

		System.out.println("STEP - Get company name");
		String companyInfoText = driver.findElement(By.xpath("//div[@class='col s12'][1]/p")).getText();
		String actualCompanyName = companyInfoText.split(": ")[1];
		String expectedCompanyName = "TechnoCredits QA";

		System.out.println("VERIFY - updated Organization name display");
		Assert.assertEquals(actualCompanyName, expectedCompanyName);

		System.out.println("STEP - Click on OK button on popup.");
		driver.findElement(By.id("heartbeatSubmitBtn")).click();
	}
	
	@AfterClass
	public void tearDown(){
		driver.close();
	}

}
