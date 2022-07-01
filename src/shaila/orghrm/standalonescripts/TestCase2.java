/*
 * 1. Launch https://<your server name>-trials71.orangehrmlive.com/auth/login
2. Verify Logo displayed on Login Page
3. Verify Login Panel displayed on Login Page
4. User able to enter username as "your username"
5. User able to enter password as "your password"
6. User click on Login button on Login Page
7. Verify "user_roles" should contains in URL
8. Verify total 9 widget's are disply on Dashboard page
9. Verify "Quick Access", "Buzz Latest Posts", "My Actions", "Headcount by Location", "Employees on Leave Today", "Time At Work", "Latest Documents", "Latest News" and  "COVID-19 Report" is displayed on Dashboard Page

 */


package shaila.orghrm.standalonescripts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TestCase2 {
	
	static WebDriver driver =null;
	void BrowserLaunchSetup(String url)
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	void loginTest() {
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
	public void totalWidgets() {
		System.out.println("Verify 'user_roles' should contains in URL");
			String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.endsWith("dashboard"));

		System.out.println("STEP - Verify total 9 widget's are disply on Dashboard page");
		List<WebElement> listOfWidgets = driver.findElements(By.xpath("//div[@class='dashboard-container']//div[@dragula-model='widgets']/div[not(contains(@class,'ng-hide'))]"));
		int actualWidgetsCount = listOfWidgets.size();
		int expectedWidgetsCount = 9;

		System.out.println("VERIFY - total 9 widget's are disply on Dashboard page");
		Assert.assertEquals(actualWidgetsCount, expectedWidgetsCount);

		System.out.println("STEP - get widget text");
		List<WebElement> listOfWidgetsHeader = driver.findElements(By.xpath(
				"//div[@class='dashboard-container']//div[@dragula-model='widgets']/div[not(contains(@class,'ng-hide'))]//div[@class='widget-header']/span[2]"));
		List<String> actualWidgetsHeaderText = new ArrayList<String>();

		List<String> expectedWidgetsHeaderText = getExpectedWidgetsText();
		for (WebElement widget : listOfWidgetsHeader) {
			actualWidgetsHeaderText.add(widget.getText());
		}

		System.out.println("VERIFY -  Quick Access, Buzz Latest Posts, My Actions, Headcount by Location, Employees on Leave Today, Time At Work, Latest Documents, Latest News and COVID-19 Report is displayed on Dashboard Page");
		Assert.assertEquals(actualWidgetsHeaderText, expectedWidgetsHeaderText);
	}

	private List<String> getExpectedWidgetsText() {
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
		return expectedWidgetsHeaderText;
	}
	
	@Test
	public void start() {
		BrowserLaunchSetup("https://javaselenium22-trials7501.orangehrmlive.com/");
		loginTest();
		totalWidgets();
	}
	
	@AfterClass
	void teardown() {
		driver.close();
	}
}
