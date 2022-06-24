/*Assignment - 5 : 19th Jun'2022 
Actions Assignment on Flipkart

1. To validate 13 widgets getting display on mouse hove of electronics
2. To validate non-zero widgets getting display under Audio section in electronics*/

package arti;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment4FlipkartMouseHoverExample {

	static WebDriver driver;

	void setUp() {

		System.out.println("STEP : Browser Setup");

		System.setProperty("webdriver.chrome.driver", "C:\\Technocredit\\SeleniumTechnoApr2022\\drivers\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		System.out.println("\nSTEP : Load URL");

		driver.get("https://www.flipkart.com");

	}

	void verifyMouseHoverElectronics() {

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

		System.out.println("\nTotal widgets displayed under Electronics navigation = " + size);

		if (size == 13)
			System.out.println("\nResult : Test Pass");
		else
			System.out.println("\nTest Fail");
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

		Assignment4FlipkartMouseHoverExample a4 = new Assignment4FlipkartMouseHoverExample();

		a4.setUp();

		System.out.println("\nTest Case : Verify that 13 widgets are getting displayed on mouse hover of Electronics");
		a4.verifyMouseHoverElectronics();

		System.out.println(
				"\n**************************************************************************************************\n");

		System.out.println(
				"\nTest Case : Verify that non-zero widgets getting displayed under Audio section in Electronics");
		a4.verifyNonZeroWidgets();

		driver.close();
	}
}
