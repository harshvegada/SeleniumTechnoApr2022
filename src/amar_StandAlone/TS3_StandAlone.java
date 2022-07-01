package amar_StandAlone;

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

public class TS3_StandAlone {
	
	final String username = "admin";
	final String password = "C@sRqq3L4U";

	@Test
	public void tc3() {

		System.out.println("STEP - Launch Chrome brower");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("STEP - Load URL");
		driver.get("https://technoamar-trials7501.orangehrmlive.com/");
		driver.manage().window().maximize();

		System.out.println("STEP - Enter username");
		WebElement usernameElement = driver.findElement(By.xpath("//input[@id='txtUsername']"));
		usernameElement.sendKeys(username);

		System.out.println("VERIFY - User able to enter username");
		String actualUsername = usernameElement.getAttribute("value");
		Assert.assertEquals(actualUsername, username);

		System.out.println("STEP - Enter password");
		WebElement passwordElement = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		passwordElement.sendKeys(password);

		System.out.println("VERIFY - User able to enter username");
		String actualPassword = passwordElement.getAttribute("value");
		Assert.assertEquals(actualPassword, password);

		System.out.println("STEP - User click on Login button on Login Page");
		driver.findElement(By.xpath("//div[@class='button-holder']/button")).click();

		System.out.println("STEP: Verify user profile displayed");
		boolean userProfileDisplayed = driver.findElement(By.xpath("//div[@class='image-container']/img"))
				.isDisplayed();
		Assert.assertTrue(userProfileDisplayed);

		System.out.println("STEP: Mouse Hover on Profile and click on Setting icon on profile");
		WebElement profile = driver.findElement(By.xpath("//div[@class='image-container']/img"));
		WebElement profileSettings = driver
				.findElement(By.xpath("//a[@class='password-action profile-context-menu-handler']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(profile).click(profileSettings).build().perform();

		System.out.println(
				"STEP: Verify user menu total 2 options are displayed (About, Change Password) on after click on setting icon");
		List<WebElement> profileSettingMenuList = driver.findElements(By.xpath(
				"//div[@class='sub-menu-container-php profile-context-menu-handler opened']/div[@class='sub-menu-container']/div"));
		int profileSettingMenuListSize = profileSettingMenuList.size();
		List<WebElement> profileSettingMenuOptions = new ArrayList<WebElement>();
		for (int index = 1; index <= profileSettingMenuListSize; index++) {
			profileSettingMenuOptions.add(driver.findElement(By.xpath(
					"//div[@class='sub-menu-container-php profile-context-menu-handler opened']/div[@class='sub-menu-container']/div["
							+ index + "]")));
		}

		System.out.println(profileSettingMenuListSize + " options avialable under profile settings");
		for (WebElement profileSettingMenu : profileSettingMenuList) {
			System.out.println(profileSettingMenu.getText());
		}

		System.out.println("STEP: Click on About option under profile setting menu");
		profileSettingMenuList.get(1).click();

		System.out.println("STEP9: Verify Employees count is more than 0");
		List<WebElement> companyAllInfoList = driver.findElements(By.xpath("//div[@id='companyInfo']/div[1]/div"));
		int comapanyAllInfoListSize = companyAllInfoList.size();
		List<WebElement> companyInfoAllRows = new ArrayList<WebElement>();
		for (int index = 1; index <= comapanyAllInfoListSize; index++) {
			companyInfoAllRows.add(driver.findElement(By.xpath("//div[@id='companyInfo']/div[1]/div[" + index + "]")));
		}
		int employeeCount = Integer.parseInt(companyInfoAllRows.get(2).getText().split(": ")[1].split(" ")[0]);
		Assert.assertTrue(employeeCount > 0);

		System.out.println(
				"STEP: Verify the company details fields are getting displayed on information alert (Company Name, Version, Employees, Users & Renewal on)");
		int companyAllInfoCount = companyInfoAllRows.size();
		List<String> companyAllInfoFields = new ArrayList<String>();
		for (int index = 0; index < companyAllInfoCount; index++) {
			companyAllInfoFields.add(companyInfoAllRows.get(index).getText().split(":")[0]);
		}
		List<String> companyAllInfoExpectedFields = new ArrayList<String>();
		companyAllInfoExpectedFields.add("Company Name");
		companyAllInfoExpectedFields.add("Version");
		companyAllInfoExpectedFields.add("Employees");
		companyAllInfoExpectedFields.add("Users");
		companyAllInfoExpectedFields.add("Renewal on");

		Assert.assertEquals(companyAllInfoFields, companyAllInfoExpectedFields);

		System.out.println("STEP: Click on OK button on popup");
		driver.findElement(By.xpath("//a[@id='heartbeatSubmitBtn']")).click();

		driver.close();
		System.out.println("-:Current browser instance closed:-");
	}

}
