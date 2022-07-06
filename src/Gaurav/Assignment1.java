package Gaurav;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {
	public static void main (String[] args){
		System.setProperty("webdriver.driver.chrome", "chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("registration2")).click();
		WebElement username = driver.findElement(By.id("unameSignin"));
		username.clear();
		username.sendKeys("mkanani");
		WebElement password = driver.findElement(By.id("pwdSignin"));
		password.clear();
		password.sendKeys("mkanani1234");
		driver.findElement(By.id("btnsubmitdetails")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
	}
	

}
