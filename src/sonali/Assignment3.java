/*Assignment - 3 : 17th Jun'2022 

Step 1 : Go to URL -  https://www.facebook.com/ 
Step 2 : Click on  Create New Account  button
Step 3 : Fill Signup form

Note : Don't click on  Sign up  button.*/
package sonali;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Assignment3 {
	void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Resource/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement createbutton =driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
		createbutton.click();
		WebElement firstname =driver.findElement(By.name("firstname"));
		firstname.sendKeys("Sonali");
		WebElement lastname =driver.findElement(By.name("lastname"));
		lastname.sendKeys("Mahale");
		WebElement email =driver.findElement(By.name("reg_email__"));
		email.sendKeys("sonaliborase23@gmail.com");
		WebElement pass =driver.findElement(By.id("password_step_input"));
		pass.sendKeys("Sonali");
		WebElement dropdownday =driver.findElement(By.id("day"));
		Select dropdown = new Select(dropdownday);  
		dropdown.selectByIndex(5); 
		WebElement dropdownmonth =driver.findElement(By.id("month"));
		Select dropdown1 = new Select(dropdownmonth);  
		dropdown1.selectByIndex(5); 
		WebElement dropdownyear =driver.findElement(By.id("year"));
		Select dropdown2 = new Select(dropdownyear);  
		dropdown2.selectByIndex(5); 
		WebElement radio=driver.findElement(By.xpath("//input[@value=\"1\"]"));
		radio.click();
		
		
		
}
	public static void main(String[] args) throws InterruptedException {
		Assignment3 assignment3=new Assignment3();
		assignment3.setup();
	}
}
