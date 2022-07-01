package minalS;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase_2 {

	@Test
	void userAbleToLogin() {
		System.out.println("STEP-Launch a browser");
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		System.out.println("STEP-URL");
		driver.get("https://minals-trials7501.orangehrmlive.com/auth/seamlessLogin");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		System.out.println("Enter User Name");
		WebElement useNameElement=driver.findElement(By.id("txtUsername"));
		useNameElement.sendKeys("Admin");
		
		System.out.println("Enter Passward");
		WebElement passwardElement=driver.findElement(By.id("txtPassword"));
		passwardElement.sendKeys("7@kOfBn8YV");
		
		System.out.println("Click on login button");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		

		System.out.println("VERIFY-user land to  dashboardpage");
		Assert.assertTrue(driver.getCurrentUrl().endsWith("dashboard"));

		System.out.println("STEP-Count total widget displayed on dashboard page");
		List<WebElement> listOfWidgets = driver.findElements(By.xpath(
				"//div[@class='dashboard-container']//div[@dragula-model='widgets']/div[not(contains(@class,'ng-hide'))]//div[@class='widget-header']/span[2]"));
		int actualWidgetCount = listOfWidgets.size();
		int expectedWidgetCount = 9;
		Assert.assertEquals(actualWidgetCount, expectedWidgetCount);

		System.out.println("VERIFY-widget text");
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
