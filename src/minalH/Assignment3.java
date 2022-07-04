/*Assignment - 3 : 17th Jun'2022

Step 1 : Go to URL - https://www.facebook.com/
Step 2 : Click on Create New Account button
Step 3 : Fill Signup form

Note : Don't click on Sign up button.
*/
package minalH;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment3 {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		System.out.println("STEP - Go to url");
		driver.get("https://www.facebook.com/");
		System.out.println("STEP - Click on Create Account button");
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("STEP - Fill signup form");
		driver.findElement(By.name("firstname")).sendKeys("Minal");
		driver.findElement(By.name("lastname")).sendKeys("Hake");
		driver.findElement(By.name("reg_email__")).sendKeys("minal.hake333@gmail.com");
		driver.findElement(By.name("reg_passwd__")).sendKeys("12345");
		
		Select day = new Select(driver.findElement(By.xpath("//select[@name='birthday_day']")));
		day.selectByValue("30");
		Select month = new Select(driver.findElement(By.xpath("//select[@name='birthday_month']")));
		month.selectByValue("4");
		Select year = new Select(driver.findElement(By.xpath("//select[@name='birthday_year']")));
		year.selectByValue("1991");
		driver.findElement(By.xpath("//input[@value='2']")).click();
	}

}
