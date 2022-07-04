package madhuriR;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class TestCase2 {
	
		protected static WebDriver driver;
		public void setUp(String url) {
			System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			driver.get(url);
			driver.manage().window().maximize();
			
		}
		@BeforeClass
		public void setUp() {
			setUp("https://apr22madhuri-trials7501.orangehrmlive.com/");
		}
		
		@Test
		public void testCase2() {
			System.out.println("Lounch browser");
			setUp();
			
			System.out.println("Verify logo displayed or not");
			WebElement logoElement = driver.findElement(By.xpath("//div[@class=\"organization-logo shadow\"]/img"));
			Assert.assertTrue(logoElement.isDisplayed());
			
			System.out.println("Verify login panel is displyed or not");
			WebElement loginPanelElement = driver.findElement(By.xpath("//div[@class=\"login-form shadow\"]"));
			Assert.assertTrue(loginPanelElement.isDisplayed());
			
			System.out.println("Login with valid Credentials");
			
			driver.findElement(By.xpath("//input[@id=\"txtUsername\"]")).sendKeys("Admin");
			
			driver.findElement(By.xpath("//input[@id=\"txtPassword\"]")).sendKeys("cW@OfXD40d");
			
			System.out.println("Click on login");
			driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
			
			System.out.println("verify url endswith dashboard");
			Assert.assertTrue(driver.getCurrentUrl().endsWith("dashboard"));
			
			System.out.println("verify user roles contains in url or not");
			Assert.assertTrue(driver.getCurrentUrl().contains("madhuri"));
			
			System.out.println("verify total 9 widgets are displayed on page");
			List<WebElement> listOfWidgets = driver.findElements(By.xpath("//div[@class=\"dashboard-container\"]//div[@dragula-model=\"widgets\"]/div[not(contains(@class,'ng-hide'))]"));
			int totalWidgets = listOfWidgets.size();
			Assert.assertEquals(totalWidgets,9);
			
			System.out.println("verify widgets name is correct or not");
			List<WebElement> listOfElements = driver.findElements(By.xpath("//div[@class=\"dashboard-container\"]//div[@dragula-model=\"widgets\"]/div[not(contains(@class,'ng-hide'))]//div[@class=\"widget-header\"]/span[2]"));
			List<String> listofString = new ArrayList<String>();
			for(WebElement element:listOfElements) {
				listofString.add(element.getText());
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
			
			Assert.assertEquals(listofString,expectedWidgetsHeaderText);
			
			System.out.println("close driver");
			driver.close();
			
		
		}
	}


