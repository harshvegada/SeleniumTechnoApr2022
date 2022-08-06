package Gaurav;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC5 {
	
	@Test
	void case5() {
			
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
			
			driver.findElement(By.xpath("//a[@id='menu_item_81'][1]")).click();
			
			int rowcount = driver.findElements(By.xpath("//table[@class='highlight bordered']/tbody/tr")).size();
			String recordcount = driver.findElement(By.xpath("//li[@class='summary']")).getText().split(" ")[4];
			
			int record = Integer.parseInt(recordcount);
			Assert.assertEquals(rowcount, record);
			
			WebElement pagerecordcount = driver.findElement(By.xpath("//input[@value='50']"));
			System.out.println("pagerecordcount is : " + pagerecordcount.getText());
			System.out.println("pagerecordcount is : " + pagerecordcount.getAttribute("Value"));
			
			int attributevalue = Integer.parseInt(pagerecordcount.getAttribute("value"));
			Assert.assertEquals(attributevalue, 50);
			
	}

}
