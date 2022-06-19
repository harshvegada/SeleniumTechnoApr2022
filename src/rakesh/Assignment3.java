/* Assignment - 3 : 17th Jun'2022

Step 1 : Go to URL - https://www.facebook.com/
Step 2 : Click on Create New Account button
Step 3 : Fill Signup form

Note : Don't click on Sign up button.
 */
package rakesh;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment3 {
	
	
	WebDriver driver = PreReq.setUp("https://www.facebook.com/");
	
	void facebookNewAcc() {
		
		driver.findElement(By.xpath("//a[contains(@id, 'u_0_2')]")).click();
		System.out.println("Clicked on Create New Account Button");
		driver.findElement(By.name("firstname")).sendKeys("Rakesh");
		driver.findElement(By.name("lastname")).sendKeys("Borse");
		driver.findElement(By.name("reg_email__")).sendKeys("7588015383");
		driver.findElement(By.name("reg_passwd__")).sendKeys("123@abc#456def");
		System.out.println("Entered first name, last name and mob number");
		
		Select ddBirthDay = new Select(driver.findElement(By.name("birthday_day")));
		Select ddBirthMonth = new Select(driver.findElement(By.name("birthday_month")));
		Select ddBirthYear = new Select(driver.findElement(By.name("birthday_year")));
		ddBirthDay.selectByVisibleText("16"); 
		ddBirthMonth.selectByVisibleText("Aug"); 
		ddBirthYear.selectByVisibleText("1991");
		System.out.println("Entered the DOB");
		
		driver.findElement(By.xpath("//label[text()='Custom']")).click();
		Select pronoun = new Select(driver.findElement(By.name("preferred_pronoun")));
		pronoun.selectByIndex(2);
		System.out.println("Selected the gender");
		System.out.println("ALL STEPS PASSED");
	}
	
	public static void main(String[] args) {
		Assignment3 obj = new Assignment3();
		System.out.println("\n======> Selenium Assignment 3 <==========");
		obj.facebookNewAcc();
	}
}
