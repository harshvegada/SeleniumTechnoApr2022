package Gaurav;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program4 {
	
	

	void alertDemoSubmit() {
	
		System.setProperty("webdriver.driver.chrome", "chromebrowser");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("basicelements")).click();
		WebElement username = driver.findElement(By.id("UserFirstName"));
		username.sendKeys("Gaurav");
		WebElement password = driver.findElement(By.id("UserLastName"));
		password.sendKeys("Khandelwal");
		WebElement company = driver.findElement(By.id("UserCompanyName"));
		company.sendKeys("ABC");
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();
		Alert alert = driver.switchTo().alert();
		String actualmessage = alert.getText();
		System.out.println(actualmessage);
		String expectedmessage = (username  +" and " + password + " and " + company);
		System.out.println(expectedmessage);
		if (expectedmessage.equals(actualmessage))
			System.out.println("Test Pass");
		else
			System.out.println("Test Fail");
		alert.accept();
		
		driver.quit();
		
	}

	
public static void main(String[] args) {
		
		Program4 program4 = new Program4();
		program4.alertDemoSubmit();
		
	}

}

