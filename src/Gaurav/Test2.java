package Gaurav;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test2 {
	
void signin() {
		
		System.setProperty("webdriver.driver.chrome", "chromebrowser");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Sign in")).click();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		System.out.println(url.contains("my-account"));
		
		WebElement email = driver.findElement(By.id("email_create"));
		email.sendKeys("abc.123456987@qmail.com");
		driver.findElement(By.xpath("//span/i[@class='icon-user left']")).click();
		driver.findElement(By.id("id_gender1")).click();
		
		WebElement firstname = driver.findElement(By.id("customer_firstname"));
		firstname.sendKeys("Gaurav");
		String str1 = firstname.getAttribute("value");
		System.out.println(str1);		
		
		WebElement lastname = driver.findElement(By.id("customer_lastname"));
		lastname.sendKeys("khandelwal");
		String str2 = lastname.getAttribute("value");
		System.out.println(str2);
		
		WebElement password = driver.findElement(By.id("passwd"));
		password.sendKeys("12345");
		
		WebElement day = driver.findElement(By.id("days"));
		Select dayselect = new Select(day);
		dayselect.selectByValue("22");
		
		WebElement month = driver.findElement(By.id("months"));
		Select monthselect = new Select(month);
		monthselect.selectByValue("2");
		
		WebElement year = driver.findElement(By.id("years"));
		Select yearselect = new Select(year);
		yearselect.selectByValue("1982");
		
		WebElement address = driver.findElement(By.id("address1"));
		address.sendKeys("440 Essxe Street");
		
		WebElement city = driver.findElement(By.id("city"));
		city.sendKeys("Hackensack");
		
		WebElement state = driver.findElement(By.id("id_state"));
		Select stateselect = new Select(state);
		stateselect.selectByValue("30");
		
		WebElement zipcode = driver.findElement(By.id("postcode"));
		zipcode.sendKeys("07601");
		
		WebElement phone = driver.findElement(By.id("phone_mobile"));
		phone.sendKeys("01234567891");
		driver.findElement(By.xpath("//button//span/i[@class='icon-chevron-right right']")).click();
		String url1 = driver.getCurrentUrl();
		System.out.println(url1.contains("my-account"));
		
		WebElement myaccount = driver.findElement(By.xpath("//a[@class='account']"));
		String actualaccountname = myaccount.getText();
		System.out.println(actualaccountname);		
		String expectedaccountname = str1 +" "+ str2;
		if(actualaccountname.equals(expectedaccountname))
			System.out.println("Username is correct");
	    
		driver.findElement(By.linkText("Sign out")).isDisplayed();
	    driver.findElement(By.linkText("Sign out")).click();
	    System.out.println(driver.getTitle());
	    driver.quit();
	    
		
}


public static void main(String[] args) {
	
	Test2 test = new Test2();
	test.signin();
}
}
