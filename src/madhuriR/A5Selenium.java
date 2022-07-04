package madhuriR;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*For Actions class practice

Assignment - 5 : 19th Jun'2022
Actions Assignment on Flipkart

1. To validate 13 widgets getting display on mouse hove of electronics
2. To validate non-zero widgets getting display under Audio section in electronics



Demo of core features in jQuery Drag and Drop widget | Kendo UI for jQuery
https://demos.telerik.com
*/
public class A5Selenium {
	WebDriver driver;
	WebDriver setUp() {
		System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		return driver;
	}

	void displayWidgets() {
		WebDriver  driver = setUp();
		driver.findElement(By.xpath("//button[@class=\"_2KpZ6l _2doB4z\"]")).click();
		WebElement element = driver.findElement(By.xpath("//div[text()=\"Electronics\"]"));
		
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class=\"_3XS_gI _7qr1OC\"]//a"));
		System.out.println(elements.size());	
	}
	void nonZeroWidgets() {
		WebDriver  driver = setUp();
		driver.findElement(By.xpath("//button[@class=\"_2KpZ6l _2doB4z\"]")).click();
		WebElement element = driver.findElement(By.xpath("//div[text()=\"Electronics\"]"));
		
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
		
		List<WebElement> element1 = driver.findElements(By.xpath("//div[@class=\"_3XS_gI _7qr1OC\"]//a"));
		int sizeOfElements = element1.size();
		if(sizeOfElements>0) {
			System.out.println("Audio section is non zero");
		}
		
	}
	public static void main(String[] args) {
		A5Selenium a5 = new A5Selenium();
		a5.displayWidgets();
		a5.nonZeroWidgets();
	}
}
