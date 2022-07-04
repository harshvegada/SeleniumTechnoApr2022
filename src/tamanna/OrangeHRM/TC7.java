/*"1. Launch https://<your server name>-trials71.orangehrmlive.com/auth/login
2. User able to enter username as ""your username""
3. User able to enter password as ""your password""
4. Click on HR Administration tab
5. Mouse Hover on Organization tab
6. User click on General Information tab
7. User change Organization Name to ""Anything""
8. Verify Number of Employees field is disabled
9. User save the information
10. User mouse hover on user profile and click on Settin icon
11. User click on about section
12. Verify that updated Organization name display as ""Anything""" */

package tamanna.OrangeHRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC7 {

	WebDriver driver;
	String orgName = "Anything";

	TC7() {
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

	// 4. Click on HR Administration tab from left panel
	@Test(dependsOnMethods = "S3verifyPasswordEntry")
	void S4clickHRAdmin() {
		WebElement element = driver.findElement(By.xpath("//span[text()='HR Administration']"));
		Assert.assertTrue(element.isDisplayed());
		element.click();
	}

	// 5. Mouse Hover on Organization tab
	@Test(dependsOnMethods = "S4clickHRAdmin")
	void S5clickOrgTab() {
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Organization')]"));
		Assert.assertTrue(element.isDisplayed());
		element.click();
	}

	// 6. User click on General Information tab
	@Test(dependsOnMethods = "S5clickOrgTab")
	void S6ClickGenInfo() {
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),' General Information')]"));
		Assert.assertTrue(element.isDisplayed());
		element.click();
	}

	// 7. User change Organization Name to ""Anything""
	@Test(dependsOnMethods = "S6ClickGenInfo")
	void S7ChangeOrgName() {
		WebElement element = driver.findElement(By.xpath("//input[@id='name']"));
		element.clear();
		element.sendKeys(orgName);
		Assert.assertEquals(element.getAttribute("value"), orgName);
	}

	// 8. Verify Number of Employees field is disabled
	@Test(dependsOnMethods = "S7ChangeOrgName")
	void S8VerifyEmpField() {
		WebElement element = driver.findElement(By.xpath("//input[@id='numemp']"));
		Assert.assertFalse(element.isEnabled());
	}

	// 9. User save the information
	@Test(dependsOnMethods = "S8VerifyEmpField")
	void S9ClickSave() {
		WebElement element = driver.findElement(By.xpath("//button[@type='submit']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		try {
			Thread.sleep(5000);
		}catch(Exception ex) {
			
		}
		element.click();
	}

	@Test(dependsOnMethods = "S9ClickSave")
	void S9VerifyToast() {
		WebElement element = driver.findElement(By.xpath("//div[@class='toast-message']"));
		Assert.assertTrue(element.isDisplayed());
	}

	// 10. User mouse hover on user profile and click on Settin icon
	@Test(dependsOnMethods = "S9VerifyToast")
	void S91clickSettingIcon() {
		WebElement element = driver.findElement(By.xpath("//div[@class='picture']"));
		Assert.assertTrue(element.isDisplayed());
		Actions actProfile = new Actions(driver);
		actProfile.moveToElement(element).perform();
		WebElement elementSettings = driver
				.findElement(By.xpath("//a[@class='password-action profile-context-menu-handler']"));
		Assert.assertTrue(elementSettings.isDisplayed());
		elementSettings.click();
	}

	// 11. User click on about section
	@Test(dependsOnMethods = "S91clickSettingIcon")
	void S92ClickAbout() {
		WebElement element = driver.findElement(By.xpath(
				"//div[@class='sub-menu-container-php profile-context-menu-handler opened']//div[@class='sub-menu-item'][2]//a[@class='sub-menu-item-link truncate']"));
		Assert.assertTrue(element.isDisplayed());
		element.click();
	}

	// 12. Verify that updated Organization name display as ""Anything"
	@Test(dependsOnMethods = "S92ClickAbout")
	void S93VerifyOrgName() {
		// Company Name: OrangeHRM (Pvt) Ltd(Parallel Demo)
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.xpath("//div[@id='companyInfo']//p[1]"));
		String orgStr = element.getText().trim();
		String[] strOrgVals = orgStr.split(":");
		Assert.assertEquals(strOrgVals[1].trim(), orgName);
	}
}
