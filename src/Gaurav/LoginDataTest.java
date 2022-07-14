package Gaurav;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDataTest {
	
	@Test(dataProvider = "loginData")
	void dataproviderlogin() {
			
			System.setProperty("webdriver.driver.chrome", "chromebrowser");
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			driver.get("https://gauravselenium-trials7501.orangehrmlive.com/");
			driver.manage().window().maximize();
			
			
			WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
			username.sendKeys("Admin");
			
			WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
			password.sendKeys("1234");
			
	}
	
	@DataProvider(name="loginData")
	public Object[][] loginDataProvider(){
		Object[][] data = new Object[3][2];
		
		data[0][0] = "admin1";
		data[0][1] = "admin-1234";
		
		data[1][0] = "admin2";
		data[1][1] = "admin-1308";
		
		data[2][0] = "admin3";
		data[2][1] = "admin-4444";
		
		return data;
	}

}
