/*Step 1 : Go to URL - https://www.facebook.com/
Step 2 : Click on Create New Account button
Step 3 : Fill Signup form 
 */

package minu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment3 {

	private WebDriver driver;

	private void browserSetUp(String url) {
		System.out.println("STEP-Launch Chrome brower");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		System.out.println("STEP-Go to URL - https://www.facebook.com/");
		driver.get(url);
		driver.manage().window().maximize();
	}

	void createAccount() {
		browserSetUp("https://www.facebook.com/");

		System.out.println("STEP-Click on Create New Account button");
		driver.findElement(By.linkText("Create New Account")).click();

		System.out.println("STEP-Fill Signup form");

		System.out.println("Enter first name");
		driver.findElement(By.name("firstname")).sendKeys("Test");

		System.out.println("Enter last name");
		driver.findElement(By.name("lastname")).sendKeys("Test");

		System.out.println("Enter email");
		driver.findElement(By.name("reg_email__")).sendKeys("test12@gmail.com");
		System.out.println("ReEnter email");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("test12@gmail.com");

		System.out.println("Enter password");
		driver.findElement(By.id("password_step_input")).sendKeys("Test@1234");

		System.out.println("Select BirthDate");
		WebElement dayElement = driver.findElement(By.name("birthday_day"));
		Select birthDateSelect = new Select(dayElement);
		birthDateSelect.selectByIndex(14);
		birthDateSelect = new Select(driver.findElement(By.name("birthday_month")));
		birthDateSelect.selectByVisibleText("Jun");
		birthDateSelect = new Select(driver.findElement(By.id("year")));
		birthDateSelect.selectByValue("1995");

		System.out.println("Select gender");
		driver.findElement(By.className("_8esa")).click();
	}

	public static void main(String[] args) {
		new Assignment3().createAccount();
	}
}
