/*
 * 1. Launch https://<your server name>-trials71.orangehrmlive.com/auth/login
2. User able to enter username as "your username"
3. User able to enter password as "your password"
4. User click on Login button on Login Page
5. Verify User profile is displayed
6. Mouse Hover on Profile and Click on setting icon on profile
7. Verify user menu total 2 options are displayed (About, Change Password) on after click on Arrow.
8. Click on About
9. Verify Employee is more than 0
10. Verify the company details  fields are getting displayed on information alert (Company Name, Version, Employees, Users & Renewal on)
11. Click on OK button on popup.
 */

package shaila.orghrm.standalonescripts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TestCase3 {

	static WebDriver driver =null;
	void BrowserLaunchSetup(String url)
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
	}

	void login() {
		System.out.println("STEP - Enter userName");
		WebElement usernameElement = driver.findElement(By.xpath("//input[@id='txtUsername']"));
		usernameElement.sendKeys("Admin");
		System.out.println("STEP - Enter password");
		WebElement passwordElement = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		passwordElement.sendKeys("5N@f8UhNPd");
		System.out.println("VERIFY - User click on Login button on Login Page");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
	}


@Test
public void CheckCompanyDetails() {
	System.out.println("STEP:-- Launch https://<your server name>-trials71.orangehrmlive.com/auth/login");
	BrowserLaunchSetup("https://javaselenium22-trials7501.orangehrmlive.com/auth/seamlessLogin");
	System.out.println("STEP:- Login with user");
	login();
	System.out.println("VERIFY - User profile is displayed");
	WebElement userProfile = driver.findElement(By.xpath("//div[@class='image-container']/img"));
	Assert.assertTrue(userProfile.isDisplayed());

	System.out.println("STEP - Mouse Hover on Profile and Click on setting icon on profile");
	Actions userAction = new Actions(driver);
	userAction.moveToElement(userProfile)
			.click(driver.findElement(By.xpath("//div[@class='image-container']//i[@class='material-icons']")))
			.build().perform();

	System.out.println("VERIFY - user menu total 2 options are displayed ");
	List<WebElement> listOfUserMenuElement = driver.findElements(
			By.xpath("//div[@class='sub-menu-container-php profile-context-menu-handler opened']//a"));
	Assert.assertEquals(listOfUserMenuElement.size(), 2);

	List<String> excpectedList = new ArrayList<String>();
	excpectedList.add("Change Password");
	excpectedList.add("About");

	List<String> actualList = new ArrayList<String>();

	for (WebElement userMenu : listOfUserMenuElement) {
		actualList.add(userMenu.getText().trim());
	}

	System.out.println("VERIFY - About and Change Password only 2 options are displayed");
	Assert.assertEquals(actualList, excpectedList);

	System.out.println("STEP - Click on About");
	listOfUserMenuElement.get(1).click();

	System.out.println("VERIFY - Employee is more than 0");
	String empCountInString = driver.findElement(By.xpath("//div[@class='col s12'][3]/p")).getText();
	empCountInString = empCountInString.split(" ")[1];
	int empCount = Integer.parseInt(empCountInString);
	Assert.assertTrue(empCount > 0);

	System.out.println("STEP - find total list of company Info");
	List<WebElement> companyInfoList = driver.findElements(By.xpath("//div[@class='col s12']"));

	List<String> expectedCompanyInfo = new ArrayList<String>();
	expectedCompanyInfo.add("Company Name");
	expectedCompanyInfo.add("Version");
	expectedCompanyInfo.add("Employees");
	expectedCompanyInfo.add("Users");
	expectedCompanyInfo.add("Renewal on");

	List<String> actualCompanyInfo = new ArrayList<String>();
	for (int index = 0; index < companyInfoList.size(); index++) {
		actualCompanyInfo.add(companyInfoList.get(index).getText().split(":")[0].trim());
	}

	System.out.println(
			"VERIFY -  company details fields are getting displayed on information alert (Company Name, Version, Employees, Users & Renewal on)");
	Assert.assertEquals(actualCompanyInfo, expectedCompanyInfo);

	System.out.println("STEP - Click on OK button on popup.");
	driver.findElement(By.id("heartbeatSubmitBtn")).click();
}

@AfterClass
void closeBrowser() {
	driver.close();
}}	
