package Gaurav;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC2 {
	
	void case2() {
		
		System.setProperty("webdriver.driver.chrome", "chromebrowser");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get("https://gauravselenium-trials7501.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		boolean logo = driver.findElement(By.xpath("//div[@class='organization-logo shadow']")).isDisplayed();
		System.out.println(logo + " Logo is displayed");
		
		boolean loginform = driver.findElement(By.xpath("//div[@class='login-form shadow']")).isDisplayed();
		System.out.println(loginform + " Loginform is displayed");
		
		WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
		username.sendKeys("Admin");
		
		WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		password.sendKeys("UR1icg5I@L");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		boolean topbar = driver.findElement(By.xpath("//div[text()='Employee Management']")).isDisplayed();
		System.out.println(topbar +" Employee Management topbar is displayed");
		
		List<WebElement> listofwidgets = driver.findElements(By.xpath("//div[@class='dashboard-container']//div[@dragula-model='widgets']/div[not(contains(@class,'ng-hide'))]//div[@class='widget-header']/span[2]"));
		System.out.println("Total widgets on Dashboard " + listofwidgets.size());
		
		List<String> widgettext = new ArrayList<String>();
		for(WebElement widget: listofwidgets) {
			widgettext.add(widget.getText());
		}
			System.out.println(widgettext);
		
			
		boolean userprofile = driver.findElement(By.xpath("//div[@class='image-container']/img")).isDisplayed();
		System.out.println("User Profile id displayed: "+ userprofile);
		
		
		
}

public static void main(String[] args) {
	
	TC2 tc2 = new TC2();
	tc2.case2();
}



}
