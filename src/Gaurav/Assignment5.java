package Gaurav;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment5 {

	
void flipcartwidgets() {
		
		System.setProperty("webdriver.driver.chrome", "chromebrowser");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebElement electronic = driver.findElement(By.xpath("//img[@alt='Electronics']"));
		Actions action = new Actions(driver);
		action.moveToElement(electronic).build().perform();
		List<WebElement> listofelectronics = driver.findElements(By.xpath(""));
}

public static void main(String[] args) {
	
	Assignment5 flipcart = new Assignment5();
	flipcart.flipcartwidgets();
}
}
