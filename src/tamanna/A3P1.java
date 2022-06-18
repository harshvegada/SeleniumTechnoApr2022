/*Assignment - 3 : 17th Jun'2022

Step 1 : Go to URL - https://www.facebook.com/
Step 2 : Click on Create New Account button
Step 3 : Fill Signup form

Note : Don't click on Sign up button.*/

package tamanna;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class A3P1 {

	WebDriver driver;
	
	public void preRequisites() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	}
	
	void executeTest() {
		driver.findElement(By.linkText("Create New Account")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WebElement fNameElement=driver.findElement(By.name("firstname"));
		fNameElement.clear();
		fNameElement.sendKeys("Tamanna");
		
		WebElement lNameElement=driver.findElement(By.name("lastname"));
		lNameElement.clear();
		lNameElement.sendKeys("Shah");
		
		WebElement emailElement=driver.findElement(By.name("reg_email__"));
		emailElement.clear();
		emailElement.sendKeys("tamy@test.com");
		
		WebElement emailConfirmElement=driver.findElement(By.name("reg_email_confirmation__"));
		emailConfirmElement.clear();
		emailConfirmElement.sendKeys("tamy@test.com");
		
		WebElement passwordElement=driver.findElement(By.name("reg_passwd__"));
		passwordElement.clear();
		passwordElement.sendKeys("tamy@test");
		
		Select dobDaySelect=new Select(driver.findElement(By.name("birthday_day")));
		dobDaySelect.selectByValue("17");
		
		Select dobMonthSelect=new Select(driver.findElement(By.name("birthday_month")));
		dobDaySelect.selectByValue("1");
		
		Select dobYearSelect=new Select(driver.findElement(By.name("birthday_year")));
		dobYearSelect.selectByValue("1993");
		
		List<WebElement> genderRadioList=driver.findElements(By.xpath("//span[@data-name='gender_wrapper']//input[@type=\"radio\"]"));
		if(genderRadioList.size()>0)
			genderRadioList.get(0).click();
		
	}
	
	public static void main(String[] args) {
		A3P1 a3p1=new A3P1();
		a3p1.preRequisites();
		a3p1.executeTest();
	}
}

