package Gaurav;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program5 {
	
	void basicFormSubmit() {
		
		System.setProperty("webdriver.driver.chrome", "chromebrowser");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("basicelements")).click();
		WebElement email = driver.findElement(By.id("exampleInputEmail1"));
		email.sendKeys("gaurav.khandelwal82@gmail.com");
		WebElement password = driver.findElement(By.id("pwd"));
		password.sendKeys("123");
		driver.findElement(By.id("submitb2")).click();
		Alert alert = driver.switchTo().alert();
		String message = alert.getText();
		System.out.println(message);
		alert.accept();
		
		driver.quit();
		
	}

	
public static void main(String[] args) {
		
		Program5 program5 = new Program5();
		program5.basicFormSubmit();
		
	}

}


