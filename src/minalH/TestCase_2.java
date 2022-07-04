package minalH;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase_2 {
	WebDriver driver;
	
	void verifyWidgetsOnDashboard() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP : Launch url");
		driver.get("https://minalhake-trials7501.orangehrmlive.com/auth/login");
		
		System.out.println("\n"+"STEP : Enter username");
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
		System.out.println("\n"+"STEP : Enter password");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("@tqGJP1nQ5");
		System.out.println("Test pass !!");
		System.out.println("\n"+"STEP : User click on login button");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		System.out.println("Test pass !!");
		
		System.out.println("STEP : Verify total 9 widgets displayed on dashboard page");
		int numberOfWidgets = driver.findElements(By.xpath("//div[@dragula-model='widgets']/div[not(contains(@class,'ng-hide'))]")).size();
		System.out.println("Number of widgets "+numberOfWidgets);
		if(numberOfWidgets == 9)
			System.out.println("Test Pass !!");
		else
			System.out.println("Test Fail !!");
		System.out.println("\n"+"STEP : Verify titles of each widgets");
		List<WebElement> listOfElements = driver.findElements(By.xpath("//div[@class='dashboard-container']//div[@dragula-model='widgets']/div[not(contains(@class,'ng-hide'))]//div[@class='widget-header']/span[2]"));
		List<String> listOfWidgetText = new ArrayList<String>();
		for(WebElement widget : listOfElements) {
			listOfWidgetText.add(widget.getText());
		}
		System.out.println("\n"+"Titles of widgets "+"\n"+listOfWidgetText);
		System.out.println("Test Pass !!");
	}
	
	public static void main(String[] args) {
		TestCase_2 widgetTest = new TestCase_2();
		widgetTest.verifyWidgetsOnDashboard();

	}
}
