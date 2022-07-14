package Gaurav;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TC6 {
	
	@Test
	void case6() {
			
			System.setProperty("webdriver.driver.chrome", "chromebrowser");
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			driver.get("https://gauravselenium-trials7501.orangehrmlive.com/");
			driver.manage().window().maximize();
			
			
			WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
			username.sendKeys("Admin");
			
			WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
			password.sendKeys("UR1icg5I@L");
			
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			
			
			driver.findElement(By.xpath("//div[@class='top-level-menu-item-container']/a[contains(text(), 'More')]")).click();
			
			WebElement qual = driver.findElement(By.xpath("//div[@class='sub-menu-item']/a[contains(text(), 'Qualifications')]"));
			
			Actions action = new Actions(driver);
			action.moveToElement(qual).click(driver.findElement(By.xpath("//*[text()='Skills']"))).build().perform();
			
			driver.findElement(By.xpath("//a[@class='btn-floating btn-large waves-effect waves-light']/i[@class='material-icons']")).click();
			
			driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Automation");
			driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys("Selenium Automation");
			driver.findElement(By.xpath("//a[@class='modal-action waves-effect waves-green btn primary-btn']")).click();
			
			
			
			
	}

}
