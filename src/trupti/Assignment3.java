package trupti;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment3 {
	public static void main(String[] args) {
		System.out.println("Step: Launch Browser");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		System.out.println("Step 1 : Go to URL - https://www.facebook.com/");
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		System.out.println("Step 2 : Click on Create New Account button");
		driver.findElement(By.linkText("Create New Account")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		System.out.println("Step 3 : Fill Signup form");
		System.out.println("STEP:Enter UserName");
		driver.findElement(By.name("firstname")).sendKeys("Trupti");
	
		System.out.println("STEP:Enter Surname");
		driver.findElement(By.name("lastname")).sendKeys("Bhutkar");
	
		System.out.println("STEP:Enter emailaddress");
		driver.findElement(By.name("reg_email__")).sendKeys("bhutkartrupti@gmail.com");
		
		System.out.println("STEP:Re-enter password");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("bhutkartrupti@gmail.com");
		
		System.out.println("STEP:Enter new password");
		driver.findElement(By.name("reg_passwd__")).sendKeys("@123456");
		
		System.out.println("STEP:Select Birthday date");
		WebElement birthdayDateElement=driver.findElement(By.name("birthday_day"));
		Select dateSelect=new Select(birthdayDateElement);
		dateSelect.selectByValue("16");
		
		System.out.println("STEP:Select Birthday month");
		WebElement monthElement=driver.findElement(By.name("birthday_month"));
		new Select(monthElement).selectByIndex(7);
	
		System.out.println("STEP:Select Birthday year");
		WebElement yearElement=driver.findElement(By.name("birthday_year"));
		new Select(yearElement).selectByVisibleText("1991");
		
		System.out.println("STEP:Select female button");
		driver.findElement(By.name("sex")).click();
		
		driver.close();
		
	}
}
