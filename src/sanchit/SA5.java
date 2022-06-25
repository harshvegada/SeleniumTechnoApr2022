/*Assignment - 5 : 19th Jun'2022
Actions Assignment on Flipkart

1. To validate 13 widgets getting display on mouse hover of electronics
2. To validate non-zero widgets getting display under Audio section in electronics*/

package sanchit;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SA5 {

	private static WebDriver driver;

	void launchFlipkart() {
		System.out.println("Launch Chrome Browser");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("Load Flipkart");
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
	}

	// 1. To validate 13 widgets getting display on mouse hover of electronics
	void mouseHoverAndWidgetsCountInElectronicsFlipkart() {
		System.out.println("> TEST1. To validate 13 widgets getting display on mouse hover of electronics");
		Actions actions = new Actions(driver);
		System.out.println("Mouse hover on electronics");
		actions.moveToElement(driver.findElement(By.xpath("//img[@alt='Electronics']"))).build().perform();
		List<WebElement> listOfWidgets = driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']//a"));
		System.out
				.println("Widgets count under 'Electronics': '" + listOfWidgets.size() + "', All widgets are below:- ");
		System.out.println("-------------------------------------------------------");
		for (WebElement widget : listOfWidgets) {
			System.out.println(widget.getText());
		}
		System.out.println("-------------------------------------------------------\n");
	}

	// 2. To validate non-zero widgets getting display under Audio section in
	// electronics
	void nonZeroWidgetsUnderAudioInElectronics() {
		System.out.println("> TEST2. To validate non-zero widgets getting display under Audio section in electronics");
		Actions actions = new Actions(driver);
		System.out.println("Mouse hover on electronics");
		actions.moveToElement(driver.findElement(By.xpath("//img[@alt='Electronics']"))).build().perform();
		List<WebElement> listOfWidgetsUnderAudio = driver.findElements(By.xpath("//div[@class='_3XS_gI']/a"));
		System.out.println("Non-Zero widgets count under 'Audio' section in 'Electronics': '"
				+ listOfWidgetsUnderAudio.size() + "', All widgets are below:- ");
		System.out.println("-------------------------------------------------------");
		for (WebElement audioWidget : listOfWidgetsUnderAudio) {
			System.out.println(audioWidget.getText());
		}
		System.out.println("-------------------------------------------------------");
	}

	public static void main(String[] args) {
		SA5 sa5 = new SA5();
		sa5.launchFlipkart();

		sa5.mouseHoverAndWidgetsCountInElectronicsFlipkart();
		sa5.nonZeroWidgetsUnderAudioInElectronics();

		driver.quit();
	}
}
