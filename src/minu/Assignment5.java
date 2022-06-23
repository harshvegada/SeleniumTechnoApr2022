/*Actions Assignment on Flipkart
1. To validate 13 widgets getting display on mouse hove of electronics
2. To validate non-zero widgets getting display under Audio section in electronics
 */

package minu;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment5 {

	private WebDriver driver;

	private void browserSetUp() {
		System.out.println("STEP-Launch Chrome brower");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		System.out.println("STEP-Load URL");
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.manage().window().maximize();
	}

	void verifyTotalNumberOfWidgets() {
		browserSetUp();

		System.out.println("Navigate to Electronics Section");
		WebElement element = driver.findElement(By.xpath("//img[@alt='Electronics']"));

		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();

		System.out.println("STEP-To validate all widgets getting display on mouse hover of electronics");
		List<WebElement> listOfElectronics = driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']//a"));
		System.out.println("Total number of widgets in Electronic section: " + (listOfElectronics.size()));

		System.out.println("Name of the widgets available under Electronics Section");
		for (WebElement electronics : listOfElectronics)
			System.out.println(electronics.getText());
		driver.close();
	}

	void verifyNonZeroWidgets() {
		browserSetUp();

		System.out.println("Navigate to Electronics Section");
		WebElement element = driver.findElement(By.xpath("//img[@alt='Electronics']"));

		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();

		System.out.println("STEP-To validate non-zero widgets getting display under Audio section in electronics");

		List<WebElement> listOfAudio = driver
				.findElements(By.xpath("//div[@class='_3XS_gI']/a[@class='_6WOcW9 _3YpNQe']"));
		int audioSectionSize = listOfAudio.size();

		if (audioSectionSize > 0)
			System.out.println("Widgets are available in Audio section");
		else
			System.out.println("Widgets are not available in Audio section");

		System.out.println("Name of the widgets available under Audio Section");
		for (WebElement audiosElement : listOfAudio)
			System.out.println(audiosElement.getText());

		driver.close();
	}

	public static void main(String[] args) {
		Assignment5 assignment5 = new Assignment5();

		System.out.println("TestCase 1 Execution");
		assignment5.verifyTotalNumberOfWidgets();

		System.out.println("\nTestCase 2 Execution");
		assignment5.verifyNonZeroWidgets();
	}

}
