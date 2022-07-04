package sachinP;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class OrangeHrmTC1 {
	public static WebDriver driver;
	
	public void loginSetup(String url) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver= new ChromeDriver();		
		System.out.println("Step-Launch URL");
		driver.get(url);
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	public void verifyWidget() {
		loginSetup("https://techsachin-trials7501.orangehrmlive.com/securityAuthentication/retryLogin");
		
		System.out.println("VERIFY : Logo displayed on login page");		
		boolean islogodisplayedflag = driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();
		Assert.assertTrue(islogodisplayedflag);
		
		System.out.println("VERIFY : Login panel is displayed on login page");	
		boolean ispaneldisplayedflag = driver.findElement(By.xpath("//*//div[@class='orangehrm-form']")).isDisplayed();
		Assert.assertTrue(ispaneldisplayedflag);
		
		
		System.out.println("Step : Enter username");					
		WebElement usernameElement = driver.findElement(By.xpath("//input[@id='txtUsername']"));
		usernameElement.sendKeys("Admin");
		
		System.out.println("VERIFY : User able to enter username");
		String actualUsername= usernameElement.getAttribute("value");
		Assert.assertEquals(actualUsername, "Admin");
		
		
		System.out.println("Step : Enter password");					
		WebElement ispasswordflag = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		ispasswordflag.sendKeys("@ugF02HCjL");
		
		System.out.println("VERIFY : User able to enter password");
		String actualpassword = ispasswordflag.getAttribute("value");
		Assert.assertEquals(actualpassword, "@ugF02HCjL");

		System.out.println("Click on Login button");	
		driver.findElement(By.xpath("//button[@id='btnLogin']")).click();
		
		System.out.println("VERIFY : Dashboard page is displayed");	
		boolean isEmployeeManagement =driver.findElement(By.xpath("//div[text()='Employee Management']")).isDisplayed();
		Assert.assertTrue(isEmployeeManagement);
		
		
				
		driver.close();		
	}
	
	public static void main(String[] args) {
		new OrangeHrmTC1().verifyWidget();
		
	}

}
