package pragati;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_2 {

	private WebDriver driver;

	void setUp(String url) {
		System.out.println("STEP:Launch Browser");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();

	}

	@Test
	public void setUp() {
		setUp("https://technopragati-trials7501.orangehrmlive.com/auth/seamlessLogin");

		System.out.println("STEP - Enter userName");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");

		System.out.println("STEP - Enter password");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("oVD1lqX5@Z");

		System.out.println("VERIFY - User click on Login button on Login Page");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
	}

	@Test
	public void totalWidgets() {

		System.out.println("VERIFY- User landed to dashboard page");
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.endsWith("dashboard"));

		System.out.println("STEP - Count total widgets displayed on dashboard");
		List<WebElement> listOfWidgets = driver.findElements(By.xpath(
				"//div[@class='dashboard-container']//div[@dragula-model='widgets']/div[not(contains(@class,'ng-hide'))]"));
		int actualWidgetsCount = listOfWidgets.size();
		int extectedWidgetsCount = 9;

		System.out.println("VERIFY - total 9 widget's are disply on Dashboard page");
		Assert.assertEquals(actualWidgetsCount, extectedWidgetsCount);

		System.out.println("STEP - get widget text");
		List<WebElement> listOfWidgetsHeader = driver.findElements(By.xpath(
				"//div[@class='dashboard-container']//div[@dragula-model='widgets']/div[not(contains(@class,'ng-hide'))]//div[@class='widget-header']/span[2]"));
		List<String> actualWidgetsHeaderText = new ArrayList<String>();

		List<String> expectedWidgetsHeaderText = getExpectedWidgetsText();
		for (WebElement widget : listOfWidgetsHeader) {
			actualWidgetsHeaderText.add(widget.getText());
		}

		System.out.println(
				"VERIFY -  Quick Access, Buzz Latest Posts, My Actions, Headcount by Location, Employees on Leave Today, Time At Work, Latest Documents, Latest News and COVID-19 Report is displayed on Dashboard Page");
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

}