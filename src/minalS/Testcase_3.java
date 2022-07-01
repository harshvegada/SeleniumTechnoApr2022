package minalS;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase_3 {

	@Test
	void VerifyCompanyDetailsAndEmployeesAreNonZero() {
		System.out.println("STEP-Launch a browser");
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		System.out.println("STEP-URL");
		driver.get("https://minals-trials7501.orangehrmlive.com/auth/seamlessLogin");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		System.out.println("Enter User Name");
		WebElement useNameElement = driver.findElement(By.id("txtUsername"));
		useNameElement.sendKeys("Admin");

		System.out.println("Enter Passward");
		WebElement passwardElement = driver.findElement(By.id("txtPassword"));
		passwardElement.sendKeys("7@kOfBn8YV");

		System.out.println("Click on login button");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		System.out.println("VERIFY- user profile display");
		WebElement profileElement = driver.findElement(By.xpath("//div[@class='image-container']/img"));
		boolean isUserProfileDisplayed = profileElement.isDisplayed();
		Assert.assertTrue(isUserProfileDisplayed);

		System.out.println("mouse hover on profile and click on setting icon");
		WebElement settingsElement = driver
				.findElement(By.xpath("//a[@class='password-action profile-context-menu-handler']"));
		Actions act = new Actions(driver);
		act.moveToElement(profileElement).click(settingsElement).build().perform();

		System.out.println("VERIFY -user menu");
		List<WebElement> listOfUserMenu = driver.findElements(By
				.xpath("//div[@class='picture']//div[@class='sub-menu-item']/a[@class='sub-menu-item-link truncate']"));
		Assert.assertEquals(listOfUserMenu.size(), 2);

		System.out.println("VERIFY- total 2 elements are display");
		List<String> expectedList = new ArrayList<String>();
		expectedList.add("Change Password");
		expectedList.add("About");

		List<String> actualList = new ArrayList<String>();
		for (int i = 0; i < listOfUserMenu.size(); i++) {
			actualList.add(listOfUserMenu.get(i).getText().trim());
		}
		Assert.assertEquals(expectedList, actualList);
		System.out.println("VERIFY - actual list and expected list are matching");

		listOfUserMenu.get(1).click();
		System.out.println("Clicked on about button");

		System.out.println("");
		String empCountInString = driver.findElement(By.xpath("//div[@class='col s12'][3]/p")).getText();
		empCountInString = empCountInString.split(" ")[1];
		int empCount = Integer.parseInt(empCountInString);
		Assert.assertTrue(empCount > 0);
		System.out.println("VERIFY- employees are non zero");

		List<WebElement> companyWebElementInfoList = driver.findElements(By.xpath("//div[@class='col s12']"));
		List<String> actualCompanyInfo = new ArrayList<String>();
		List<String> expectedCompanyInfo = new ArrayList<String>();
		expectedCompanyInfo.add("Company Name");
		expectedCompanyInfo.add("Version");
		expectedCompanyInfo.add("Employees");
		expectedCompanyInfo.add("Users");
		expectedCompanyInfo.add("Renewal on");

		for (int i = 0; i < companyWebElementInfoList.size(); i++) {
			actualCompanyInfo.add(companyWebElementInfoList.get(i).getText().split(":")[0].trim());

		}
		Assert.assertEquals(expectedCompanyInfo, actualCompanyInfo);
		System.out.println("Verify- company info getting display");

		driver.findElement(By.xpath("//div[@class='modal-footer']/a[@id='heartbeatSubmitBtn']")).click();
		System.out.println("STEP- Clicked on OK button");
	}
}
