package ashish.standalonescripts;

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
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("admin");

		System.out.println("STEP - Enter password");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("h@s4WMi1LR");

		System.out.println("VERIFY - User click on Login button on Login Page");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
	}

	@Test
	public void updateCompanyNameTest() {
		
		driver.findElement(By.xpath("//li[@id='left_menu_item_1']//a[1]/span[contains(text(),'HR Administration')]")).click();
		System.out.println("VERIFY - Clicked on HR Administration tab");
		
		driver.findElement(By.xpath("//a[@data-automation-id='menu_admin_Organization']")).click();
		System.out.println("VERIFY - Clicked on Organization tab");
		
		WebElement generalInfoElement = driver.findElement(By.xpath("//a[@data-automation-id='menu_admin_viewOrganizationGeneralInformation']"));
		
		Actions action1 = new Actions(driver);
		action1.moveToElement(generalInfoElement).click().build().perform();
		
		String companyNewName = "Anything2 Pvt. Ltd.";
		WebElement companyNameElement = driver.findElement(By.xpath("//input[@id='name']"));
		companyNameElement.clear();
		companyNameElement.sendKeys(companyNewName);
		System.out.println("VERIFY - Changeed Organization Name to Anything");
		
		Assert.assertFalse(driver.findElement(By.xpath("//input[@id='numemp']")).isEnabled());
		System.out.println("VERIFY-  Number of Employees field is disabled");
		
		driver.findElement(By.xpath("//button[@class=' btn waves-effect waves-green ']")).click();
		System.out.println("VERIFY- Saved the information");
		
		WebElement userProfileElement = driver.findElement(By.xpath("//div[@id='sidebar-profile-picture']//img"));
		Assert.assertTrue(userProfileElement.isDisplayed());
		System.out.println("VERIFY -  User profile is displayed on UI");

		Actions action2 = new Actions(driver);
		action2.moveToElement(userProfileElement)
				.click(driver.findElement(By.xpath("//div[@id='sidebar-profile-picture']//a/i"))).build().perform();
		System.out.println("VERIFY -  Mouse Hover on Profile and Clicked on setting icon on profile");

		driver.findElement(By.xpath("//a[@id='aboutDisplayLink']")).click();
		System.out.println("VERIFY - Clicked on about section");
		
		String actualCompanyName = driver.findElement(By.xpath("//div[@id='companyInfo']/div/div[1]")).getText().split(":")[1].trim();
		Assert.assertEquals(companyNewName, actualCompanyName);
		driver.findElement(By.xpath("//a[@id='heartbeatSubmitBtn']")).click();
		System.out.println("VERIFY - Verified that updated Organization name display as Anything");
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
