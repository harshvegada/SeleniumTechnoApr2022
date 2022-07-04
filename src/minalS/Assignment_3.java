package minalS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*Assignment - 3 : 17th Jun'2022

Step 1 : Go to URL - https://www.facebook.com/
Step 2 : Click on Create New Account button
Step 3 : Fill Signup form

Note : Don't click on Sign up button.
*/
public class Assignment_3 {

	void createNewAccount() {
		System.out.println("STEP - Launch Chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		System.out.println("STEP - Load URL");
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		System.out.println("STEP - Click on create new account");
		driver.findElement(By.linkText("Create New Account")).click();
		
		
		System.out.println("STEP - Enter first name");
		WebElement firstnameElement=driver.findElement(By.name("firstname"));
		firstnameElement.sendKeys("Minal");
		
		System.out.println("STEP - Enter last name");
		WebElement lastnameElement=driver.findElement(By.name("lastname"));
		lastnameElement.sendKeys("Shende");
		
		System.out.println("STEP - Enter mobile number");
		WebElement mobNumberElement=driver.findElement(By.name("reg_email__"));
		mobNumberElement.sendKeys("7385822185");
		
		System.out.println("STEP - Enter mobile number");
		WebElement passwordElement=driver.findElement(By.name("reg_passwd__"));
		passwordElement.sendKeys("bdf@hngyqw");
		
		System.out.println("STEP -Enter Date of birth");
		WebElement dateElement=driver.findElement(By.id("day"));
		
		Select daySelect=new Select(dateElement);
		daySelect.selectByValue("8");
		
		System.out.println("STEP - Enter month of birth");
		WebElement monthElement=driver.findElement(By.id("month"));
		
		Select monthSelect=new Select(monthElement);
		monthSelect.selectByValue("8");
		
		System.out.println("STEP -Enter Year of birth");
		WebElement yearElement=driver.findElement(By.id("year"));
		
		Select yearSelect=new Select(yearElement);
		yearSelect.selectByValue("1994");
		
		
		driver.findElement(By.xpath(".//input[@value='1']")).click();
		
		
		
	}
	public static void main(String[] args) {
		Assignment_3 assignment3=new Assignment_3();
		assignment3.createNewAccount();
	}
}
