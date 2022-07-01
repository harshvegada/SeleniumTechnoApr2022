package arti.standalonescripts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TC2_DashboardTest {

	private WebDriver driver;
	
	public void setup() {
		
		System.out.println("STEP - Launch browser");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		System.out.println("STEP - Load URL");
		driver.get("https://artitechno-trials7501.orangehrmlive.com/");
		
		System.out.println("VERIFY - User is able to enter the username ");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");

		System.out.println("VERIFY - User is able to enter the password ");
		driver.findElement(By.id("txtPassword")).sendKeys("6cyNOTm3N@");
		
		System.out.println("STEP - User click on Login button on Login Page");
		driver.findElement(By.xpath("//div[@class='button-holder']/button")).click();
	
		System.out.println("VERIFY - user landed to dashboard page");
		if(driver.getCurrentUrl().endsWith("dashboard"))
			System.out.println("User landed on dashboard page");
	}
	
	public void widgetsTest() {
		
		System.out.println("STEP - Count total widgets displayed on dashboard");
		int actualWidgetsCount = driver.findElements(By.xpath("//div[@class='dashboard-container']//div[@dragula-model='widgets']/div[not(contains(@class,'ng-hide'))]")).size();
		int expectedWidgetsCount = 9;
		
		System.out.println("VERIFY - total widgets");
		if(actualWidgetsCount == expectedWidgetsCount)
			System.out.println("All the widgets are displayed");
		
		System.out.println("STEP - get widget text");
		List<WebElement> listOfWidgets = driver.findElements(By.xpath("//div[@class='dashboard-container']//div[@dragula-model='widgets']/div[not(contains(@class,'ng-hide'))]//div[@class='widget-header']/span[2]"));
		
		List<String> listOfWidgetsText = new ArrayList<String>();
		
		for(WebElement widget : listOfWidgets) {
			listOfWidgetsText.add(widget.getText());
		}
		//List<String> actualWidgetsHeaderText = dashboardPage.getWidgetsHeaderText();
		
		List<String> expectedWidgetsHeaderText = getExpectedWidgetsText();
		System.out.println("VERIFY - all widget text");
		
		boolean flag = true;
		if(listOfWidgetsText.size() != expectedWidgetsHeaderText.size()) {
		
			if(listOfWidgetsText.size() > expectedWidgetsHeaderText.size()) {
			
				listOfWidgetsText.removeAll(expectedWidgetsHeaderText); 
			}
			else 
			{
				flag = false;
				expectedWidgetsHeaderText.removeAll(listOfWidgetsText);
			}
		}
		else
		{
			
			listOfWidgetsText.removeAll(expectedWidgetsHeaderText);
		}
		
		System.out.println("Missing Widgets header : " );
		
		if(listOfWidgetsText.size() == 0) 
			if(flag) 
				listOfWidgetsText.toString();
			else
				expectedWidgetsHeaderText.toString();
	
		driver.close();
	}
	
	private List<String> getExpectedWidgetsText(){
	
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
