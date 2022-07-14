package Gaurav;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program1 {
	
	

	void alertAutomation() {
		String expectedmessage = "You must be TechnoCredits student!!";
		System.setProperty("webdriver.driver.chrome", "chromebrowser");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("basicelements")).click();
		driver.findElement(By.id("javascriptAlert")).click();
		Alert alert = driver.switchTo().alert();
		String actualmessage = alert.getText();
		if(actualmessage.equals(expectedmessage))
		System.out.println("Test Pass");
		else
			System.out.println("Test Fail");
		alert.accept();
		driver.quit();
		
	}

	
public static void main(String[] args) {
		
		Program1 program1 = new Program1();
		program1.alertAutomation();
		
	}

}
