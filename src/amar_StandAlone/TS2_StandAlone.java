package amar_StandAlone;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TS2_StandAlone {
	
	final String username = "admin";
	final String password = "C@sRqq3L4U";
	int expectedWidgetCount = 9;

	@Test
	public void tc2() {

		System.out.println("STEP - Launch Chrome brower");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("STEP - Load URL");
		driver.get("https://technoamar-trials7501.orangehrmlive.com/");
		driver.manage().window().maximize();
		System.out.println("VERIFY - Logo displayed on Login Page");
		boolean isLogoDisplayedFlag = driver.findElement(By.xpath("//div[@class='organization-logo shadow']/img"))
				.isDisplayed();
		Assert.assertTrue(isLogoDisplayedFlag);

		System.out.println("VERIFY - Login Panel displayed on Login Page");
		boolean isLoginFormDisplayFlag = driver.findElement(By.xpath("//div[@class='login-form shadow']"))
				.isDisplayed();
		Assert.assertTrue(isLoginFormDisplayFlag);

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

		System.out.println("VERIFY - user landed to dashboard page");
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.endsWith("dashboard"));

		System.out.println("STEP - Count total widgets displayed on dashboard");
		List<WebElement> listOfWidgets = driver.findElements(By.xpath(
				"//div[@class='dashboard-container']//div[@dragula-model='widgets']/div[not(contains(@class,'ng-hide'))]"));
		int currentWidgetCount = listOfWidgets.size();

		System.out.println("VERIFY - total widgets");
		Assert.assertEquals(currentWidgetCount, expectedWidgetCount);

		System.out.println("STEP - get widget text");
		List<WebElement> listOfWidgetsElements = driver.findElements(By.xpath(
				"//div[@class='dashboard-container']//div[@dragula-model='widgets']/div[not(contains(@class,'ng-hide'))]//div[@class='widget-header']/span[2]"));
		List<String> actualWidgetsHeaderText = new ArrayList<String>();
		for (WebElement widget : listOfWidgetsElements) {
			actualWidgetsHeaderText.add(widget.getText());
		}

		List<String> expectedWidgetsHeaderText = new ArrayList<String>();
		expectedWidgetsHeaderText.add("Quick Access");
		expectedWidgetsHeaderText.add("Buzz Latest Posts");
		expectedWidgetsHeaderText.add("My Actions");
		expectedWidgetsHeaderText.add("Headcount by Location");
		expectedWidgetsHeaderText.add("Employees on Leave Today");
		expectedWidgetsHeaderText.add("Time At Work");
		expectedWidgetsHeaderText.add("Latest Documents");
		expectedWidgetsHeaderText.add("Latest News");
		expectedWidgetsHeaderText.add("COVID-19 Report");

		System.out.println("VERIFY - all widget text");

		boolean flag = true;
		if (actualWidgetsHeaderText.size() != expectedWidgetsHeaderText.size()) {
			if (actualWidgetsHeaderText.size() > expectedWidgetsHeaderText.size()) {
				actualWidgetsHeaderText.removeAll(expectedWidgetsHeaderText);
			} else {
				flag = false;
				expectedWidgetsHeaderText.removeAll(actualWidgetsHeaderText);
			}
		} else {
			actualWidgetsHeaderText.removeAll(expectedWidgetsHeaderText);
		}

		Assert.assertEquals(actualWidgetsHeaderText.size(), 0, "Missing Widgets header : "
				+ (flag ? actualWidgetsHeaderText.toString() : expectedWidgetsHeaderText.toString()));

		driver.close();
		System.out.println("-:Current browser instance closed:-");
	}

}
