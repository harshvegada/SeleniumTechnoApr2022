/* Assignment - 5 : 19th Jun'2022
Actions Assignment on Flipkart

1. To validate 13 widgets getting display on mouse hover of electronics
2. To validate non-zero widgets getting display under Audio section in electronics
 */
package rakesh;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment5 {

	@Test
	void flipkart() {
		WebDriver driver = PreReq.setUp("https://www.flipkart.com/");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		System.out.println("STEP - Close the login panel");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='_2KpZ6l _2doB4z']"))).click();
		System.out.println("STEP - Hover over Electronics ");
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[text()='Electronics']"))).build().perform();
		System.out.println("STEP - Get options below Electronics ");
		List<WebElement> ls = new ArrayList<>();
		ls = driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']//a"));
		System.out.println("STEP - Check 14 options below Electronics ");
		Assert.assertEquals(ls.size(), 14, "14 options are not present");
		System.out.println("STEP - Hover over Audio ");
		actions.moveToElement(driver.findElement(By.xpath("//a[text()='Audio']"))).build().perform();
		System.out.println("STEP - Get Audio options");
		List<WebElement> lsAudio = new ArrayList<>();
		lsAudio = driver.findElements(By.xpath("//div[@class='_3XS_gI']//a"));
		System.out.println("STEP - Check Non-zero options below Electronics ");
		Assert.assertTrue(ls.size()>0, "Error Zero options");
	}
}
