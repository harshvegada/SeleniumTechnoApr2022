/*"1. Launch https://<your server name>-trials71.orangehrmlive.com/auth/login
2. User able to enter username as ""your username""
3. User able to enter password as ""your password""
4. Click on HR Administration tab from left panel
5. Click on Manage User Roles tab from top panel
6. Verify by default 50 record should get display in table.
7. Verify total record and showing count of record in right corner of page"*/

package tamanna.OrangeHRM;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC5 {

	WebDriver driver;

	TC5() {
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

	// User click on Login button on Login Page
	void clickLoginButton() {
		WebElement element = driver.findElement(By.xpath("//div[@class='button-holder']/button"));
		element.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	// 4. Click on HR Administration tab from left panel
	@Test
	void S4clickHRAdmin() {
		WebElement element = driver.findElement(By.xpath("//span[text()='HR Administration']"));
		Assert.assertTrue(element.isDisplayed());
		element.click();
	}

	//5. Click on Manage User Roles tab from top panel
	@Test
	void S5ClickManageUser() {
		WebElement element = driver.findElement(By.xpath("//a[@data-automation-id='menu_admin_viewUserRoles']"));
		Assert.assertTrue(element.isDisplayed());
		element.click();
	}

	//6. Verify by default 50 record should get display in table.
	@Test
	void S6VerifyRowCount() {
		WebElement element = driver.findElement(By.xpath("//div[@class='select-wrapper']//input"));
		Assert.assertTrue(element.isDisplayed());
		int countOfRows=Integer.parseInt(element.getAttribute("value"));
		Assert.assertEquals(countOfRows, 50);
	}
	
	//7.Verify total record and showing count of record in right corner of page
	@Test
	void S7VerifyRecordsDisplay() {
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='list-container']//table/tbody/tr"));
		WebElement elementCount = driver.findElement(By.xpath("//li[@class='summary']"));
		Assert.assertTrue(elementCount.isDisplayed());
		int countOfRows=Integer.parseInt(elementCount.getText().trim().split(" ")[2]);
		Assert.assertEquals(elements.size(), countOfRows);
	}
	
	public static void main(String[] args) {
		System.out.println("1 - 50 of 81".trim().split(" ")[2]);
	}
}
