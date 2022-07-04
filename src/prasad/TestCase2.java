package prasad;
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
	void dashboard() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		  WebDriver driver = new ChromeDriver(); 
		  String URL = "https://sirus-trials7501.orangehrmlive.com/";
		 driver.get(URL); driver.manage().window().maximize(); 
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  WebElement logo = driver.findElement(By.xpath("//div[@class=\"organization-logo shadow\"]")); 
		 Assert.assertTrue(logo.isDisplayed()); 
		 System.out.println("Logo Displayed");
		 System.out.println("Enter UserName");
		  WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']")); 
		 username.sendKeys("Admin"); System.out.println("Enter Password"); 
		 WebElement password = driver.findElement(By.xpath("//input[@id=\'txtPassword\']")); 
		 password.sendKeys("svyYI27LY@"); 
		 WebElement loginclick = driver.findElement(By.xpath("//button[@type='submit']"));
		 loginclick.click(); 
		List<WebElement> listOfWidgets = driver.findElements(By.xpath(
				"//div[@class='dashboard-container']//div[@dragula-model='widgets']/div[not(contains(@class,'ng-hide'))]"));
		Assert.assertEquals(listOfWidgets.size(), 9);
		System.out.println("List size is 9");
		List<WebElement> listOfWidgetsOndashboard=driver.findElements(By.xpath(
				"//div[@class='dashboard-container']//div[@dragula-model='widgets']/div[not(contains(@class,'ng-hide'))]//div[@class='widget-header']/span[2]"));
		List<String> listOfWidgetText = new ArrayList<String>();
		for(WebElement widget:listOfWidgetsOndashboard) {
			listOfWidgetText.add(widget.getText());
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
		boolean value=listOfWidgetText.equals(expectedWidgetsHeaderText);
		Assert.assertTrue(value);
		System.out.println("List are equal");
	}
}
