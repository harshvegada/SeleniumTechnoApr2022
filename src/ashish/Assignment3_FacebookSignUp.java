/*
Assignment - 3 : 17th Jun'2022

Step 1 : Go to URL - https://www.facebook.com/
Step 2 : Click on Create New Account button
Step 3 : Fill Signup form
*/
package ashish;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment3_FacebookSignUp {

	WebDriver driver;
	String url = "https://www.facebook.com/";
	
	void setUp(String url) {
		System.out.println("STEP - Launch Chrome brower");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		System.out.println("STEP - Load URL");
		driver.get(url);
		driver.manage().window().maximize();
	}	
	
	void fillSignupForm(String firstname, String lastname, String regNumOrEmail, String regPassword, String day, int month, String year){
		setUp(url);
		System.out.println("Step 2 : Click on Create New Account button");
		driver.findElement(By.linkText("Create New Account")).click();
		
		System.out.println("Step 3 : Fill Signup form");
		WebElement firstNameElement = driver.findElement(By.name("firstname"));
		firstNameElement.clear();
		firstNameElement.sendKeys(firstname);
		
		WebElement lastNameElement = driver.findElement(By.name("lastname"));
		lastNameElement.clear();
		lastNameElement.sendKeys(lastname);
		
		WebElement regNumOrEmailElement = driver.findElement(By.name("reg_email__"));
		regNumOrEmailElement.clear();
		regNumOrEmailElement.sendKeys(regNumOrEmail);
		
		WebElement confirmRregNumOrEmailElement = driver.findElement(By.name("reg_email_confirmation__"));
		confirmRregNumOrEmailElement.clear();
		confirmRregNumOrEmailElement.sendKeys(regNumOrEmail);
		
		WebElement regPasswordElement = driver.findElement(By.name("reg_passwd__"));
		regPasswordElement.clear();
		regPasswordElement.sendKeys(regPassword);
		
		Select daySelect = new Select(driver.findElement(By.id("day")));
		daySelect.selectByValue(day);
		
		Select monthSelect = new Select(driver.findElement(By.id("month")));
		monthSelect.selectByIndex(month);
		
		Select yearSelect = new Select(driver.findElement(By.id("year")));
		yearSelect.selectByVisibleText(year);
		
		WebElement genderElement =driver.findElement(By.xpath("//label[normalize-space()='Male']"));
		genderElement.click();
		
		System.out.println("All form value entered successfully - Test Pass");
		driver.close();
	}
	
	public static void main(String[] args) {
		String firstname = "Ashish" , lastname = "TestDemo", regNumOrEmail = "test@test.com", regPassword = "testPassW@rd", day = "11", year = "2010";
		int month = 11;
		Assignment3_FacebookSignUp assignment3_FacebookSignUp = new Assignment3_FacebookSignUp();
		assignment3_FacebookSignUp.fillSignupForm(firstname,lastname , regNumOrEmail, regPassword , day , month, year);
	}
}
