package Gaurav;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FbSignUp {
	
	
	void signup() {
		
		System.setProperty("webdriver.driver.chrome", "chromebrowser");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Create New Account")).click();
		WebElement firstname = driver.findElement(By.name("firstname"));
		firstname.sendKeys("Gaurav");
		WebElement lastname = driver.findElement(By.name("lastname"));
		lastname.sendKeys("Khandelwal");
		WebElement email = driver.findElement(By.name("reg_email__"));
		email.sendKeys("gaurav.Khandelwal82@gmail.com");
		WebElement emailconfirm = driver.findElement(By.name("reg_email_confirmation__"));
		emailconfirm.sendKeys("gaurav.Khandelwal82@gmail.com");
		WebElement password = driver.findElement(By.name("reg_passwd__"));
		password.sendKeys("12345678");
		WebElement day = driver.findElement(By.name("birthday_day"));
		Select dayselect = new Select(day);
		dayselect.selectByValue("22");
		WebElement month = driver.findElement(By.id("month"));
		Select monthselect = new Select(month);
		monthselect.selectByValue("2");
		WebElement year = driver.findElement(By.id("year"));
		Select yearselect = new Select(year);
		yearselect.selectByValue("1982");
		driver.findElement(By.xpath("//input[@value='2']")).click();
		System.out.println("Form Filled successfully");
		driver.quit();

}
	
public static void main(String[] args) {
		
		FbSignUp signup = new FbSignUp();
		signup.signup();
		
	}
	
}
