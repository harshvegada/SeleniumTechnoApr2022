/*"1. Launch https://<your server name>-trials71.orangehrmlive.com/auth/login
2. User able to enter username as ""your username""
3. User able to enter password as ""your password""
4. User click on login button
5. User click on Employee Management tab
6. Click on My Info tab
7. Verify user Personal info displayed
8. Click on ""Salary""
9. Check the payable (CTC) amount is non-zero"*/

package tamanna.OrangeHRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC4 {

	WebDriver driver;

	TC4() {
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
	@Test
	void S3verifyPasswordEntry() {
		WebElement element = driver.findElement(By.id("txtPassword"));
		element.clear();
		element.sendKeys("f0WV3@MqHp");
		Assert.assertEquals(element.getAttribute("value"), "f0WV3@MqHp");
		clickLoginButton();
	}

	// 4. User click on Login button on Login Page
	void clickLoginButton() {
		WebElement element = driver.findElement(By.xpath("//div[@class='button-holder']/button"));
		element.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	// 5. User click on Employee Management tab
	@Test
	void S5ClickOnEmployeeManagement() {
		WebElement element = driver.findElement(By.xpath(
				"//a[@data-automation-id='menu_pim_viewEmployeeList'][@id='menu_item_37'][@data-tooltip='Employee Management'][1]"));
		Assert.assertTrue(element.isDisplayed());
		element.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	// 6. Click on My Info tab
	@Test
	void S6ClickOnEmployeeManagement() {
		WebElement element = driver
				.findElement(By.xpath("//div[@class='top-level-menu-item-container']//a[contains(text(),'My Info ')]"));
		Assert.assertTrue(element.isDisplayed());
		element.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	// 7. Verify user Personal info displayed
	@Test
	void S7VerifyUserPersonalInfo() {
		WebElement element = driver.findElement(By.xpath("//div[@id='personal_details_tab']"));
		Assert.assertTrue(element.isDisplayed());
	}

	// 8. lick on ""Salary""
	@Test
	void S8ClickOnSalary() {
		WebElement element = driver.findElement(By.xpath("//a[@data-automation-id='menu_employee_profile_Salary']"));
		Assert.assertTrue(element.isDisplayed());
		element.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	// 9. Check the payable (CTC) amount is non-zero
	@Test
	void S9VerifySalary() {
		WebElement element = driver.findElement(By.xpath("//div[@class='col-9 summary-cards-container']//div[@class='summary-card col-6'][1]//div[contains(text(),'$')]"));
		Assert.assertTrue(element.isDisplayed());
		double salaryAmount=Double.parseDouble(element.getText().replace("$", "").replace(",", ""));
		Assert.assertTrue(salaryAmount>0);
	}
}
