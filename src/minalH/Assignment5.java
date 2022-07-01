/*Assignment - 5 : 19th Jun'2022 
Actions Assignment on Flipkart

1. To validate 13 widgets getting display on mouse hove of electronics
2. To validate non-zero widgets getting display under Audio section in electronics*/

package minalH;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment5 {

	WebDriver driver;
	
	void preRequisites() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
	}
	
	void mouseHoverOnElectronics() {
		preRequisites();
		System.out.println("STEP : Click on X button on login window");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		System.out.println("STEP : Mouse hover on Electronics");
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//div[text()='Electronics']"))).build().perform();
	}
	void validateWidgets() {
		mouseHoverOnElectronics();
		System.out.println("STEP : Verify 14 widgets visible on mouse hover on Electronics");
		int widgets = driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']/a")).size();
		System.out.println("Number of widgets present under Electronics section : "+widgets);
		if(widgets == 14)
			System.out.println("Test Pass !!");
		else
			System.out.println("Test Fail !!");
		driver.close();
		
	}
	
	void validateNonZeroElements() {
		mouseHoverOnElectronics();
		//Actions act = new Actions(driver);
		System.out.println("STEP : To validate non-zero widgets getting display under Audio section in electronics");
		int size = driver.findElements(By.xpath("//div[@class='_3XS_gI']/a")).size();
		System.out.println("Number of elements present under Audio section : "+size);
		if(size > 0 )
			System.out.println("Test Pass !!");
		else
			System.out.println("Test Fail !!");
		driver.close();
	}
	
	public static void main(String[] args) {
		Assignment5 assignment5 = new Assignment5();
		assignment5.validateWidgets();
		assignment5.validateNonZeroElements();

	}

}
