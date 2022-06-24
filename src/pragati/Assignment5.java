/*Assignment - 5 : 19th Jun'2022
Actions Assignment on Flipkart
1. To validate 13 widgets getting display on mouse hove of electronics
2. To validate non-zero widgets getting display under Audio section in electronics
*/
package pragati;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment5 {
	private WebDriver driver;

	void setUp(String url) {
		System.out.println("STEP:Launch Browser");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();

	}

	void ValidateWidgetsOnMouseHover() {
		System.out.println("STEP:To validate 13 widgets getting display on mouse hove of electronics");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebElement element = driver.findElement(By.xpath("//img[@alt='Electronics']"));
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
		WebElement electronicsMenuDriven = driver
				.findElement(By.xpath("//div[@class='ZEl_b_ _3joddx _2ogGYG _23xUYh _3pAV4E']"));

		if (electronicsMenuDriven.isDisplayed())
			System.out.println("\nElectronics menu driven section is visible");
		else
			System.out.println("\nElectonics menu driven section is not visible");

	List<WebElement> list = driver.findElements(By.xpath("//a[contains(@class, '_6WOcW9 ')]"));
	int size = list.size();

	System.out.println("\nTotal widgets displayed under Electronics navigation = "+size);

	if(size==13)System.out.println("\nResult : Test Pass");else System.out.println("\nTest Fail");
}

	void verifyNonZeroWidgets() {

		int numberOfWidgets = driver.findElements(By.xpath("//a[@class = '_6WOcW9 _3YpNQe']")).size();

		if (numberOfWidgets > 0) {
			System.out.println("\nNon zero widgets are present in Audio menu");
			System.out.println("\nResult :  Test Pass");
		} else
			System.out.println("\nResult : Test Fail");
	}

	public static void main(String[] args) {
		Assignment5 assignment5 = new Assignment5();
		assignment5.setUp("https://www.flipkart.com");
		assignment5.ValidateWidgetsOnMouseHover();

	}
}
