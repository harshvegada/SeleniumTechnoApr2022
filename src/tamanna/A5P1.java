/*or Actions class practice

Assignment - 5 : 19th Jun'2022
Actions Assignment on Flipkart

1. To validate 13 widgets getting display on mouse hove of electronics
2. To validate non-zero widgets getting display under Audio section in electronics*/

package tamanna;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class A5P1 {

	WebDriver driver;
	A5P1(){
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
	}
	
	public void performTest() {
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		
		WebElement element=driver.findElement(By.xpath("//img[@alt='Electronics']"));
		Actions act=new Actions(driver);
		act.moveToElement(element).build().perform();
		
		List<WebElement> menuList=driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']/a"));
		System.out.println(menuList.size());
		System.err.println("Menu items");
		for(WebElement menuElement: menuList) {
			System.out.println(menuElement.getText());
		}
		
		System.out.println();
		WebElement auditElement=driver.findElement(By.xpath("//div[@class='_3XS_gI _7qr1OC']/a[1]"));
		act.moveToElement(auditElement).build().perform();
		List<WebElement> subMenuList=driver.findElements(By.xpath("//div[@class='_3XS_gI']/a"));
		if(subMenuList.size()>0) {
			System.err.println("Audio Submenu items:");
			for(WebElement subMenuElement: subMenuList) {
				System.out.println(subMenuElement.getText());
			}
		}
	}
	
	public static void main(String[] args) {
		A5P1 a5p1=new A5P1();
		a5p1.performTest();
	}
}
