package madhuriR;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase5 {
		protected static WebDriver driver;
		public void setUp(String url) {
			System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.get(url);
			driver.manage().window().maximize();
			
		}
		@BeforeClass
		public void setUp() {
			setUp("https://apr22madhuri-trials7501.orangehrmlive.com/");
		}
		public void login() {
			driver.findElement(By.xpath("//input[@id=\"txtUsername\"]")).sendKeys("Admin");
			
			driver.findElement(By.xpath("//input[@id=\"txtPassword\"]")).sendKeys("cW@OfXD40d");
			
			//System.out.println("Click on login");
			driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
		}
		@Test
		public void testCase5() {
			System.out.println("Login with valid credential");
			login();
			System.out.println("click on HR Administration");
			driver.findElement(By.xpath("//a[@class=\" main-menu-item-1\"]/span[contains(text(),\"HR Administration\")]")).click();
			System.out.println("click on manage user roles");
			driver.findElement(By.xpath("//a[contains(text(),'Manage User Roles ')]")).click();
			System.out.println("verify by default 50 records should get display in table");
			WebElement perPageElement = driver.findElement(By.xpath("//input[@value='50']"));
			String perPage = perPageElement.getAttribute("value");
			int perPageCount = Integer.parseInt(perPage);
			Assert.assertEquals(perPageCount, 50);
			System.out.println("verify total record and showing count is same");
			WebElement paginationElement = driver.findElement(By.xpath("//li[@class='summary']"));
			String paginationCount = paginationElement.getText().split(" ")[4];
			int perPageRecords = Integer.parseInt(paginationCount);
			
			List<WebElement> element = driver.findElements(By.xpath("//div[@class=\"list-container\"]//table[@class=\"highlight bordered\"]//tbody/tr"));
			int totalRecord = element.size();
			
			Assert.assertEquals(totalRecord, perPageRecords);
			
			
		}
		@AfterTest()
		public void closeDriver() {
			driver.close();
		}
}
