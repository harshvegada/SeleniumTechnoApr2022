/*Assignment - 5 : 19th Jun'2022
Actions Assignment on Flipkart

1. To validate 13 widgets getting display on mouse hove of electronics
2. To validate non-zero widgets getting display under Audio section in electronics
*/
package alka;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Assignment5 {
	private WebDriver driver; 
	private	void setProperty(String url)
	{
		   System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	       driver=new ChromeDriver();
	       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	       driver.get(url);
	       driver.manage().window().maximize();
	}
	void displayWidgetsOnMousehover()
	{
		setProperty("https://www.flipkart.com");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebElement element=driver.findElement(By.xpath("//img[@alt='Electronics']"));
        Actions act=new Actions(driver);
        act.moveToElement(element).build().perform();
        List<WebElement> lstWidgets=driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']//a"));
        System.out.println(lstWidgets.size());
	}
	
	void nonZeroWidgets()
	{
		WebElement element=driver.findElement(By.xpath("//img[@alt='Electronics']"));
        Actions act=new Actions(driver);
        act.moveToElement(element).build().perform();
        List<WebElement> element1 = driver.findElements(By.xpath("//div[@class='_2IjXr8']//div[@class='_3XS_gI']//a"));
		int sizeOfElements = element1.size();
		if(sizeOfElements>0) {
			System.out.println("Audio section is non zero");
		}
		
	}
	public static void main(String[] args) 
	{
		Assignment5 objAssignment5=new Assignment5();
		objAssignment5.displayWidgetsOnMousehover();
		objAssignment5.nonZeroWidgets();
    	
	}

	
}
