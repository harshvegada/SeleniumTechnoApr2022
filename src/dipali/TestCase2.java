package dipali;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/*"1. Launch https://<your server name>-trials71.orangehrmlive.com/auth/login
2. Verify Logo displayed on Login Page
3. Verify Login Panel displayed on Login Page
4. User able to enter username as ""your username""
5. User able to enter password as ""your password""
6. User click on Login button on Login Page
7. Verify ""user_roles"" should contains in URL
8. Verify total 9 widget's are disply on Dashboard page
9. Verify ""Quick Access"", ""Buzz Latest Posts"", ""My Actions"", ""Headcount by Location"", ""Employees on Leave Today"", ""Time At Work"", ""Latest Documents"", ""Latest News"" and  ""COVID-19 Report"" is displayed on Dashboard Page
"*/
public class TestCase2 {

	@Test	
	void VerifyUserabletologinand11widgetsshouldgetdisplayed() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver=new ChromeDriver();
		System.out.println("Step-- Launch Browser  ");
		driver.get("https://technodipali-trials7501.orangehrmlive.com/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		System.out.println("Step-- Verify Logo displayed on Login Page ");
		boolean isLogoDisplayed=driver.findElement(By.xpath("//div[@class='organization-logo shadow']")).isDisplayed();
		Assert.assertEquals(isLogoDisplayed, true);

		System.out.println("Step-- Verify Login Panel displayed on Login Page ");
		boolean isLoginPanelDisplayed=driver.findElement(By.xpath("//div[@class='login-form shadow']")).isDisplayed();
		Assert.assertEquals(isLoginPanelDisplayed, true);

		System.out.println("Step-- User able to enter username as your username ");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		String actualUserName=driver.findElement(By.id("txtUsername")).getAttribute("value");
		String expectedUsername="Admin";
		Assert.assertEquals(actualUserName, expectedUsername);

		System.out.println("Step-- User able to enter username as your password ");
		driver.findElement(By.id("txtPassword")).sendKeys("2Nm5@ZZhCv");
		String actualPassword=driver.findElement(By.id("txtPassword")).getAttribute("value");
		String expectedPassword="2Nm5@ZZhCv";
		Assert.assertEquals(actualPassword, expectedPassword);

		System.out.println("Step-- User click on Login button on Login Page ");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		System.out.println("Step-- Verify user_roles should contains in URL");
		String s=driver.getCurrentUrl();
	    Assert.assertTrue(s.contains("technodipali"), s);

	    System.out.println("Step-- VVerify total 9 widget's are disply on Dashboard page");
	    int cnt=driver.findElements(By.xpath("//div[@class='col-4 rh-3 oxd dashboard-widget-shell' or @class='col-8 rh-3 oxd dashboard-widget-shell']//span[@class='widget-header-text' or @style='margin-left: 0.75rem; text-align: left']")).size();
	    Assert.assertEquals(cnt, 9);

	    System.out.println("Step-- VVerify total 9 widget's Titles are disply on Dashboard page");
	    List<WebElement> actuallist=driver.findElements(By.xpath("//div[@class='col-4 rh-3 oxd dashboard-widget-shell' or @class='col-8 rh-3 oxd dashboard-widget-shell']//span[@class='widget-header-text' or @style='margin-left: 0.75rem; text-align: left']"));
		List <String> actualList=new ArrayList<String>();	
			for(WebElement element:actuallist) {
				actualList.add(element.getText());
			}
		 List<String> expectedList=new ArrayList<>();
			expectedList.add("Quick Access");
			expectedList.add("Buzz Latest Posts");
			expectedList.add("My Actions");
			expectedList.add("Headcount by Location");
			expectedList.add("Employees on Leave Today");
			expectedList.add("Time At Work");
			expectedList.add("Latest Documents");
			expectedList.add("Latest News");
			expectedList.add("COVID-19 Report");
			Assert.assertEquals(actualList, expectedList);

			System.out.println("Step-- Driver close");
			driver.close();

	}
}

