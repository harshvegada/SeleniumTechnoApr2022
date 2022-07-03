package minu.orghrm.standalonescript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase6 {

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
	public void verifySkillList() {

		System.out.println("STEP - Click on More button from top panel");
		driver.findElement(By.xpath("//a[contains(text(),'More')]")).click();

		WebElement qualificationElement = driver
				.findElement(By.xpath("//a[@data-automation-id='more_menu_child_menu_admin_Qualifications']"));

		System.out.println("STEP - Mouse hover on Qualifications tab and click on Skills tab");
		Actions action = new Actions(driver);
		action.moveToElement(qualificationElement).click(driver.findElement(By.xpath("//*[text()='Skills']"))).build()
				.perform();

		System.out.println("STEP - click on Add icon on top right corner ");
		driver.findElement(By.xpath("//i[text()='add']")).click();

		System.out.println("VERIFY - On popup header should display as Add Skill");
		boolean isAddSkillDisplayed = driver.findElement(By.xpath("//h4[contains(text(),'Add Skill')]")).isDisplayed();
		Assert.assertTrue(isAddSkillDisplayed);

		System.out.println("STEP - Enter Skill");
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Selenium_Automation Script");

		System.out.println("STEP - Enter description");
		driver.findElement(By.id("description")).sendKeys("Writing selenium script using Java");

		System.out.println("STEP - click on save button");
		driver.findElement(By.xpath("//a[text()='Save']")).click();

		driver.navigate().refresh();

		System.out.println("VERIFY - new skill getting display on Skill List");
		boolean isSkillDisplayed = driver
				.findElement(
						By.xpath("//table[@class='highlight bordered']//tr/td[2]//span[contains(text(),'Selenium_Automation')]"))
				.isDisplayed();
		Assert.assertTrue(isSkillDisplayed);
	}

}
