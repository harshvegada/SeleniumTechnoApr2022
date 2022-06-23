package bhushan;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

/*https://demos.telerik.com/kendo-ui/dragdrop/index

For Actions class practice

Assignment - 5 : 19th Jun'2022
Actions Assignment on Flipkart

1. To validate 13 widgets getting display on mouse hove of electronics
2. To validate non-zero widgets getting display under Audio section in electronics*/

public class Assignment5 {
	
	void validate14WidgetsGettingDisplay() {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebElement element=driver.findElement(By.xpath("//img[@alt='Electronics']"));
		Actions act=new Actions(driver);
		act.moveToElement(element).build().perform();
		
		int totalC=driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']//a")).size();
		System.out.println(totalC);
		driver.close();
	}
	
	void validateNonZeroWidgetsGettingDisplayUnderAudioSsectionInElectronics() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebElement element=driver.findElement(By.xpath("//img[@alt='Electronics']"));
		Actions act=new Actions(driver);
		act.moveToElement(element).build().perform();
		
		int total=driver.findElements(By.xpath("//div[@class='_3XS_gI']//a")).size();
		if(total>0)
			System.out.println("Widgets Getting Display Unde Audio Section");
		else
			System.out.println("Widgets Not Getting Display Under Audio Section");
		driver.close();
	}
	
	
	
	
	
public static void main(String[] args) {
	Assignment5 ass5=new Assignment5();
	//ass5.validate14WidgetsGettingDisplay();
	ass5.validateNonZeroWidgetsGettingDisplayUnderAudioSsectionInElectronics();
}
}
