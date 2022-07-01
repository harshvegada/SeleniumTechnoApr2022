package prachi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2 {
	
	@Test
	void userAbleToLogin() {
		System.out.println("STEP - Launch a browser");
		System.setProperty("webdriver.chrome.driver", "D:\\Java Class\\technocredits\\SeleniumTechnoApr2022\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		System.out.println("STEP - Enter URL");
		driver.get("https://technoprachi-trials7501.orangehrmlive.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		System.out.println("STEP - Enter User Name");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");

		System.out.println("STEP - Enter Passward");
		driver.findElement(By.id("txtPassword")).sendKeys("@7GqSTCt7j");

		System.out.println("VERIFY -  Click on Login button on login page");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		System.out.println("Verify Employee Management header should be visible");
		boolean isEmployeeManagementisDisplayed = driver.findElement(By.xpath("//div[text()='Employee Management']")).isDisplayed();
		Assert.assertTrue(isEmployeeManagementisDisplayed);

		String expectedTitle = "Employee Management";
		String currentTitle = driver.getTitle();
		Assert.assertEquals(currentTitle, expectedTitle);

		System.out.println("VERIFY- User landed to  dashboardpage");
		Assert.assertTrue(driver.getCurrentUrl().endsWith("dashboard"));

		System.out.println("STEP - Count total widget displayed on dashboard page");
		List<WebElement> listOfWidgets = driver.findElements(By.xpath(
				"//div[@class='dashboard-container']//div[@dragula-model='widgets']/div[not(contains(@class,'ng-hide'))]//div[@class='widget-header']/span[2]"));
		int actualWidgetCount = listOfWidgets.size();
		int expectedWidgetCount = 9;
		Assert.assertEquals(actualWidgetCount, expectedWidgetCount);

		System.out.println("VERIFY - widget text");
		List<String> listOfactualWidgetstext = new ArrayList<String>();
		for (WebElement widget : listOfWidgets) {
			listOfactualWidgetstext.add(widget.getText());
		}

		List<String> expectedWidgetText = new ArrayList<String>();
		expectedWidgetText.add("Quick Access");
		expectedWidgetText.add("Buzz Latest Posts");
		expectedWidgetText.add("My Actions");
		expectedWidgetText.add("Headcount by Location");
		expectedWidgetText.add("Employees on Leave Today");
		expectedWidgetText.add("Time At Work");
		expectedWidgetText.add("Latest Documents");
		expectedWidgetText.add("Latest News");
		expectedWidgetText.add("COVID-19 Report");

		System.out.println("VERIFY- All widget text");
		Assert.assertEquals(listOfactualWidgetstext, expectedWidgetText);
	}

}
