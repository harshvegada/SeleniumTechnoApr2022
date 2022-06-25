package madhuriR;
/*Assignment - 3 : 17th Jun'2022

Step 1 : Go to URL - https://www.facebook.com/
Step 2 : Click on Create New Account button
Step 3 : Fill Signup form

Note : Don't click on Sign up button.*/
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class A3FBAccountCreation {
	void m1() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Create New Account")).click();
		
		WebElement firstName = driver.findElement(By.name("firstname"));
		firstName.clear();
		firstName.sendKeys("Madhuri");
		
		WebElement lastName = driver.findElement(By.name("lastname"));
		lastName.clear();
		lastName.sendKeys("Rajole");
		
		WebElement mobileNumber = driver.findElement(By.name("reg_email__"));
		mobileNumber.clear();
		mobileNumber.sendKeys("8329616915");
		
		WebElement passElement = driver.findElement(By.name("reg_passwd__"));
		passElement.clear();
		passElement.sendKeys("Madhu@1234");
		
		WebElement dayElement = driver.findElement(By.id("day"));
		Select select = new Select(dayElement);
		select.selectByValue("17");
		
		WebElement monthElement = driver.findElement(By.name("birthday_month"));
		Select select1 = new Select(monthElement);
		select1.selectByValue("11");
		
		WebElement yearElement = driver.findElement(By.name("birthday_year"));
		Select select2 = new Select(yearElement);
		select2.selectByValue("1995");
		
		driver.findElement(By.name("sex")).click();
		
	}
	public static void main(String[] args) {
		A3FBAccountCreation fb = new A3FBAccountCreation();
		fb.m1();
	}
}
