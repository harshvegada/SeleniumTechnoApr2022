package sonali;

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

public class Testcase3 {
	@Test
	void setUp() {
		System.setProperty("webdriver.chrome.driver", "./Resource/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://ojaswi-trials7501.orangehrmlive.com/");
		System.out.println("STEP: navigat to url");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		System.out.println("STEP: entered user name");
		driver.findElement(By.id("txtPassword")).sendKeys("@7VoLAPs6i");
		System.out.println("STEP: entered password");

		driver.findElement(By.xpath("//div[@class='button-holder']/button")).click();
		System.out.println("STEP: click on login button");

		WebElement userProfile = driver.findElement(By.xpath("//div[@class='image-container']/img"));
		Assert.assertTrue(userProfile.isDisplayed());
		System.out.println("VERIFY: user profile is display on UI");

		Actions action = new Actions(driver);
		action.moveToElement(userProfile)
				.click(driver.findElement(By.xpath("//a[@class='password-action profile-context-menu-handler']/i")))
				.build().perform();

		List<WebElement> listOfWebElment = driver.findElements(
				By.xpath("//div[@class='sub-menu-container-php profile-context-menu-handler opened']//div//a"));
		Assert.assertEquals(listOfWebElment.size(), 2);
		System.out.println("VERIFY: total 2 element is display");

		List<String> expectedList = new ArrayList<>();
		expectedList.add("Change Password");
		expectedList.add("About");

		List<String> actualList = new ArrayList<>();

		for (int i = 0; i < listOfWebElment.size(); i++) {
			actualList.add(listOfWebElment.get(i).getText().trim());
		}

		Assert.assertEquals(expectedList, actualList);
		System.out.println("VERIFY: actual list and expected list are matching");

		listOfWebElment.get(1).click();

		String empCountInString = driver.findElement(By.xpath("//div[@class='col s12'][3]/p")).getText();
		System.out.println("empCountInString");
		empCountInString = empCountInString.split(" ")[1];
		System.out.println("empCountInString");
		int empCount = Integer.parseInt(empCountInString);
		Assert.assertTrue(empCount > 0);
		System.out.println("VERIFY: Employeess are non-zero");

		List<WebElement> companyWebElementInfoList = driver.findElements(By.xpath("//div[@class='col s12']"));
		List<String> actualCompanyInfo = new ArrayList<>();
		List<String> expectedCompanyInfo = new ArrayList<>();

		expectedCompanyInfo.add("Company Name");
		expectedCompanyInfo.add("Version");
		expectedCompanyInfo.add("Employees");
		expectedCompanyInfo.add("Users");
		expectedCompanyInfo.add("Renewal on");

		for (int i = 0; i < companyWebElementInfoList.size(); i++) {
			actualCompanyInfo.add(companyWebElementInfoList.get(i).getText().split(":")[0].trim());
		}
		Assert.assertTrue(expectedCompanyInfo.equals(actualCompanyInfo));
		System.out.println("VERIFY: Company information getting display");
		
		driver.findElement(By.xpath("//a[@id='heartbeatSubmitBtn']")).click();
		driver.close();
	}
}
