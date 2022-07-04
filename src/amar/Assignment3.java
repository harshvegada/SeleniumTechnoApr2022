/* Assignment - 3 : 17th Jun'2022

Step 1 : Go to URL - https://www.facebook.com/
Step 2 : Click on Create New Account button
Step 3 : Fill Signup form

Note : Don't click on Sign up button.
 */

package amar;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment3 {
	
	WebDriver driver;
	String url = "https://www.facebook.com/";
	
	void setup(String url) {
		System.out.println("STEP - Launch Chrome browser");
		System.setProperty("webdriver.chrome.driver", "F:\\\\SeleniumPractice\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		System.out.println("STEP - Load URL");
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	void fillSignupForm(String firstName, String lastName, String numOrEmail, String password, String date, int month, String year) {
		setup(url);
		System.out.println("Step 2 : Click on Create New Account button");
		driver.findElement(By.linkText("Create New Account")).click();
		
		System.out.println("Step 3 : Fill Signup form");
		WebElement firstNameElement = driver.findElement(By.name("firstname"));
		firstNameElement.clear();
		firstNameElement.sendKeys(firstName);
		
		WebElement lastNameElement = driver.findElement(By.name("lastname"));
		lastNameElement.clear();
		lastNameElement.sendKeys(lastName);
		
		WebElement numOrEmailElement = driver.findElement(By.name("reg_email__"));
		numOrEmailElement.clear();
		numOrEmailElement.sendKeys(numOrEmail);
		
		WebElement confirmNumOrEmailElement = driver.findElement(By.name("reg_email__"));
		confirmNumOrEmailElement.clear();
		confirmNumOrEmailElement.sendKeys(numOrEmail);
		
		WebElement passwordElement = driver.findElement(By.name("reg_passwd__"));
		passwordElement.click();
		passwordElement.sendKeys(password);
		
		Select daySelect = new Select(driver.findElement(By.id("day")));
		daySelect.selectByValue(date);
		
		Select monthSelect = new Select(driver.findElement(By.id("month")));
		monthSelect.selectByIndex(month);
		
		Select yearSelect = new Select(driver.findElement(By.id("year")));
		yearSelect.selectByVisibleText(year);
		
		WebElement genderElement = driver.findElement(By.xpath("//label[normalize-space()='Male']"));
		genderElement.click();
		
		System.out.println("All form value entered successfully - Test Pass");
		driver.close();
	}
	
	public static void main(String[] args) {
		Assignment3 obj = new Assignment3();
		String firstName = "Amar", lastName = "Kadam", numOrEmail = "amarkadam@gmail.com", password = "Amar1234", date = "18", year = "1994";
		int month = 1;
		obj.fillSignupForm(firstName, lastName, numOrEmail, password, date, month, year);
	}
}
