package prasad;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase1 {

	@Test 
		 void login() 
		 { 
		 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		  WebDriver driver = new ChromeDriver(); 
		  String URL = "https://sirus-trials7501.orangehrmlive.com/";
		 driver.get(URL); driver.manage().window().maximize(); 
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  WebElement logo = driver.findElement(By.xpath("//div[@class='organization-logo shadow']")); 
		 Assert.assertTrue(logo.isDisplayed()); 
		 System.out.println("Logo Displayed");
		 System.out.println("Enter UserName");
		  WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']")); 
		 username.sendKeys("Admin"); System.out.println("Enter Password"); 
		 WebElement password = driver.findElement(By.xpath("//input[@id=\'txtPassword\']")); 
		 password.sendKeys("svyYI27LY@"); 
		 WebElement loginclick = driver.findElement(By.xpath("//button[@type='submit']"));
		 loginclick.click(); 
		 System.out.println("Clcik on login buton");
		 String confirmUrl = driver.getCurrentUrl();
		  System.out.println("Here current URL is " + confirmUrl); 
		 WebElement text = driver.findElement(By.xpath("//div[contains(text(),'Employee Management')]")); 
		 Assert.assertTrue(text.isDisplayed()); 
		 System.out.println("Employee management Displayed");
		 driver.close();
		 } 

}
