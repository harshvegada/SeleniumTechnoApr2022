package deepshikha;

import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*Assignment - 5 : 19th Jun'2022
Actions Assignment on Flipkart

1. To validate 13 widgets getting display on mouse hove of electronics
2. To validate non-zero widgets getting display under Audio section in electronics*/

public class Assignment5 {

	private static WebDriver driver;

	void mouseHover() {
		System.out.println("STEP - Launch Chrome browser");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("STEP - Load URL");
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();

		WebElement element = driver.findElement(By.xpath("//img[@alt='Electronics']"));
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();

		boolean isVisible = driver.findElement(By.xpath("//div[@class='_2IjXr8']")).isDisplayed();

		if (isVisible) {
			System.out.println("Electronics menu driven section is visible");
		} else {
			System.out.println("Electronics menu driven section is not visible");
		}

		List<WebElement> list = driver.findElements(By.xpath("//a[contains(@class, '_6WOcW9 ')]"));
		int length1 = list.size();

		System.out.println("Total widgets displayed under Electronics section --> " + length1);

		// int length=driver.findElements(By.xpath("//div[@class='_3XS_gI
		// _7qr1OC']//a")).size();
		if (length1 == 14) {
			System.out.println("Test case pass  --> 14 widgets display");

		} else {
			System.out.println("Test case fail");
		}

	}

	void verifyNonZero() {
		int length = driver.findElements(By.xpath("//div[@class='_3XS_gI']//a")).size();
		if (length > 0) {
			System.out.println("Non-zero widgets getting display under Audio section in electronics");

		} else {
			System.out.println("Test case fail");
		}
	}

	public static void main(String[] args) {
		Assignment5 assignment5 = new Assignment5();
		assignment5.mouseHover();
		assignment5.verifyNonZero();
	}
}


