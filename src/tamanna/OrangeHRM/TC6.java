/*"1. Launch https://<your server name>-trials71.orangehrmlive.com/auth/login
2. User able to enter username as ""your username""
3. User able to enter password as ""your password""
5. Click on Qualifications tab
6. User click on Skills tab
7. User click on ""+"" icon on top right corner
8. On popup header should display as ""Add Skill""
9. User Enter Skill as ""Automation Test 1"" or any
10. User Enter any randon text in description
11. User click on ""save"" button
12. Verify that new skill getting display on Skill List"*/
package tamanna.OrangeHRM;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC6 {

	WebDriver driver;
	String addText = "Automation Test 1";
	String addDesc = "Test adding new skill.";

	TC6() {
		driver = PredefinedActions.setUp();
	}

	// 2. User able to enter username as """"your username""""
	@Test
	void S2verifyUserNameEntry() {
		WebElement element = driver.findElement(By.id("txtUsername"));
		element.clear();
		element.sendKeys("Admin");
		Assert.assertEquals(element.getAttribute("value"), "Admin");
	}

	// 3. User able to enter password as """"your password""""
	@Test(dependsOnMethods = "S2verifyUserNameEntry")
	void S3verifyPasswordEntry() {
		WebElement element = driver.findElement(By.id("txtPassword"));
		element.clear();
		element.sendKeys("f0WV3@MqHp");
		Assert.assertEquals(element.getAttribute("value"), "f0WV3@MqHp");
		clickLoginButton();
	}

	// User click on Login button on Login Page
	void clickLoginButton() {
		WebElement element = driver.findElement(By.xpath("//div[@class='button-holder']/button"));
		element.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	// 5. Click on Qualifications tab
	@Test(dependsOnMethods = "S3verifyPasswordEntry")
	void S5ClickQualificationTab() {
		WebElement element = driver.findElement(By.xpath("//a[@data-automation-id='more_menu_child_menu_top_more']"));
		Assert.assertTrue(element.isDisplayed());
		element.click();

		WebElement element1 = driver
				.findElement(By.xpath("//a[@data-automation-id='more_menu_child_menu_admin_Qualifications']"));
		Actions act = new Actions(driver);
		act.moveToElement(element1).perform();
	}

	// 6. User click on Skills tab
	@Test(dependsOnMethods = "S5ClickQualificationTab")
	void S6ClickSkillsTab() {
		WebElement element = driver
				.findElement(By.xpath("//a[@data-automation-id='more_menu_child_menu_admin_viewSkills']"));
		Assert.assertTrue(element.isDisplayed());
		element.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// 7. User click on ""+"" icon on top right corner
	@Test(dependsOnMethods = "S6ClickSkillsTab")
	void S7ClickAdd() {
		WebElement element = driver
				.findElement(By.xpath("//a[@class='btn-floating btn-large waves-effect waves-light']"));
		Assert.assertTrue(element.isDisplayed());
		element.click();
	}

	// 8. On popup header should display as ""Add Skill""
	@Test(dependsOnMethods = "S7ClickAdd")
	void S8VerifyHeader() {
		String elementText = driver.findElement(By.xpath("//div[@id='modal1']/h4")).getText();
		Assert.assertEquals(elementText, "Add Skill");
	}

	// 9. User Enter Skill as ""Automation Test 1"" or any
	@Test(dependsOnMethods = "S8VerifyHeader")
	void S9EnterSkill() {
		WebElement elementName = driver.findElement(By.id("name"));
		elementName.clear();
		elementName.sendKeys(addText);
		Assert.assertEquals(elementName.getAttribute("value"), addText);
	}

	// 10. User Enter any randon text in description@Test
	@Test(dependsOnMethods = "S9EnterSkill")
	void S91EnterDesc() {

		WebElement elementDesc = driver.findElement(By.xpath("//textarea[@id='description']"));
		elementDesc.clear();
		elementDesc.sendKeys(addDesc);
		Assert.assertEquals(elementDesc.getAttribute("value"), addDesc);
	}

	// 11. User click on ""save"" button
	@Test(dependsOnMethods = "S91EnterDesc")
	void S92ClickSave() {
		WebElement elementSave = driver
				.findElement(By.xpath("//a[@class='modal-action waves-effect waves-green btn primary-btn']"));
		Assert.assertTrue(elementSave.isDisplayed());
		elementSave.click();
		
	}

	// 12. Verify that new skill getting display on Skill List
	@Test(dependsOnMethods = "S92ClickSave")
	void S93VerifySkillAdded() {
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			WebElement elementAddedText = driver.findElement(By.xpath(
					"//div[@class='list-container']//table/tbody/tr/td//span[contains(text(),'" + addText + "')]"));
			Assert.assertTrue(elementAddedText.isDisplayed());
		} catch (NoSuchElementException nse) {
			Assert.assertTrue(false);
		}
		try {
		WebElement elementAddedDesc = driver.findElement(By
				.xpath("//div[@class='list-container']//table/tbody/tr/td//span[contains(text(),'" + addDesc + "')]"));
		Assert.assertTrue(elementAddedDesc.isDisplayed());
		}catch(NoSuchElementException nse) {
			Assert.assertTrue(false);
		}
	}
}
