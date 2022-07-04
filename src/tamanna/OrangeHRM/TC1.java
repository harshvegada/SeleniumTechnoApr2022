/*"1. Launch https://<your server name>-trials71.orangehrmlive.com/auth/login
2. Verify Logo displayed on Login Page
3. Verify Login Panel displayed on Login Page
4. User able to enter username as """"your username""""
5. User able to enter password as """"your password""""
6. User click on Login button on Login Page
7. User should navigate to home page, Verify ""Employee Management"" header should be visible.
"*/

package tamanna.OrangeHRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC1 {

	WebDriver driver;

	TC1() {
		driver = PredefinedActions.setUp();
	}

	void LogIn() {

	}

	// 2. Verify Logo displayed on Login Page
	@Test
	void S1verifyLogo() {
		WebElement element = driver.findElement(By.xpath("//div[@class='organization-logo shadow']"));
		Assert.assertTrue(element.isDisplayed());
	}

	// 3. Verify Login Panel displayed on Login Page
	@Test
	void S2verifyLogInPanel() {
		WebElement element = driver.findElement(By.xpath("//div[@class='login-form shadow']"));
		Assert.assertTrue(element.isDisplayed());
	}

	// 4. User able to enter username as """"your username""""
	@Test
	void S3verifyUserNameEntry() {
		WebElement element = driver.findElement(By.id("txtUsername"));
		element.clear();
		element.sendKeys("Admin");
		Assert.assertEquals(element.getAttribute("value"), "Admin");
	}

	// 5. User able to enter password as """"your password""""
	@Test
	void S4verifyPasswordEntry() {
		WebElement element = driver.findElement(By.id("txtPassword"));
		element.clear();
		element.sendKeys("f0WV3@MqHp");
		Assert.assertEquals(element.getAttribute("value"), "f0WV3@MqHp");
	}

	// 6. User click on Login button on Login Page
	void clickLoginButton() {
		WebElement element = driver.findElement(By.xpath("//div[@class='button-holder']/button"));
		element.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	// 7. User should navigate to home page, Verify ""Employee Management"" header
	// should be visible.
	@Test
	void S6verifyNavigation() {
		clickLoginButton();
		WebElement element = driver.findElement(By.xpath("//ul[@class='topbar-title']//div"));
		Assert.assertEquals(element.getText(), "Employee Management");
	}
}
