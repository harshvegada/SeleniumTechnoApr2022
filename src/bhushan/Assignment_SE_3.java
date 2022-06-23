package bhushan;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_SE_3 {
	/*Assignment - 3 : 17th Jun'2022

	Step 1 : Go to URL - https://www.facebook.com/
	Step 2 : Click on Create New Account button
	Step 3 : Fill Signup form

	Note : Don't click on Sign up button.*/
	
	void m1() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(" https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//driver.findElement(By.linkText("Create New Account")).click();
		driver.findElement(By.xpath("//a[@role='button' and @class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
	
		System.out.println("Enter Fisrt Name");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Bhushan");
		System.out.println("Enter Last Name");
		driver.findElement(By.xpath("//input[@name='lastname' and @data-type='text' ]")).sendKeys("gadakh");
		System.out.println("Enter email id");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("1234567890");
		System.out.println("confirm email");
		//driver.findElement(By.xpath("reg_email_confirmation__")).sendKeys("bhushan@gmail.com");
		System.out.println("Enter password");
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("bhushan123456789");
		
		System.out.println("Select DOB_Date");
		WebElement birthdate=driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select sel=new Select(birthdate);
		sel.selectByValue("24");
		
		System.out.println("Select DOB_Month");
		WebElement birthmonth=driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select sel1=new Select(birthmonth);
		sel1.selectByValue("11");
		
		System.out.println("Select DOB_Year");
		WebElement birthyear=driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select sel3=new Select(birthyear);
		sel3.selectByValue("1994");
		System.out.println("Click on gender");
		driver.findElement(By.xpath("//input[@name='sex' and @value='2']")).click();
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		Assignment_SE_3 ass3=new Assignment_SE_3();
		ass3.m1();
		
		
	}
	
	
}
