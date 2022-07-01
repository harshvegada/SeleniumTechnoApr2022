package omkar.OrangeHRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_Case1 {
	WebDriver driver;
	void TC_1() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		
		System.out.println("Step-> Launching the URL");
		driver.get("https://omkarr-trials7501.orangehrmlive.com/auth/seamlessLogin");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		System.out.println("Step-> Entering ID and Password");
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("yV2TQB@a1m");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		System.out.println("Step-> Verifying the Employee Management visible or not");
		WebElement employeeMgmt=driver.findElement(By.xpath("//div[text()='Employee Management']"));
		System.out.println(employeeMgmt.isDisplayed());
		
	}
}
