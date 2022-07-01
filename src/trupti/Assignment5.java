package trupti;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment5 {
	static private WebDriver driver;

	static void setUp(String url) {
		System.out.println("STEP -Launch Browser");
		System.setProperty("webdriver.chrome.driver", "./resourse/chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("STEP-go to URL");
		driver.get(url);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	void validate14Widgets() {
		System.out.println("STEP -  Click on pop up close function");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();

		WebElement element = driver.findElement(By.xpath("//img[@alt='Electronics']"));
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();

		boolean isVisible = driver.findElement(By.xpath("//div[@class='_2IjXr8']")).isDisplayed();
		if (isVisible)
			System.out.println("Section is visible");
		else
			System.out.println("Section is not visible");

		int length = driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']//a")).size();
		if (length == 14)
			System.out.println("Test Case Pass 14 widgets display");
		else
			System.out.println("Test Case Fail");
	}

	void validateNonZeroWidgets() {
		WebElement element = driver.findElement(By.xpath("//img[@alt='Electronics']"));
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
		int length = driver.findElements(By.xpath("//div[@class='_3XS_gI']//a")).size();
		if (length > 0)
			System.out.println("Non-zero widgets getting display under Audio section in electronics");
		else
			System.out.println("Test Case Fail");
	}

	public static void main(String[] args) {
		Assignment5 assignment5 = new Assignment5();
		setUp("https://www.flipkart.com");
		assignment5.validate14Widgets();
		assignment5.validateNonZeroWidgets();
	}

}
