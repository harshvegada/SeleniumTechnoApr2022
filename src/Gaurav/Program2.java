package Gaurav;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program2 {
	
	

	void confirmationOk() {
	
		System.setProperty("webdriver.driver.chrome", "chromebrowser");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("basicelements")).click();
		driver.findElement(By.id("javascriptConfirmBox")).click();
		Alert alert = driver.switchTo().alert();
		String actualmessage = alert.getText();
		System.out.println(actualmessage);
		alert.accept();
		String message = driver.findElement(By.id("pgraphdemo")).getText();
		System.out.println(message);
		
		driver.quit();
		
	}

	
public static void main(String[] args) {
		
		Program2 program2 = new Program2();
		program2.confirmationOk();
		
	}

}