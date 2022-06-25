/*Step 1 : Go to URL - https://www.facebook.com/
Step 2 : Click on Create New Account button
Step 3 : Fill Signup form 
 */

package sachinP;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment3 {

	public static WebDriver driver;

	public void browserSetUp(String url) {
		System.out.println("Step-Launch Chrome brower");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		System.out.println("Step 1-Go to URL - https://www.facebook.com/");
		driver.get(url);
		driver.manage().window().maximize();
	}

	void createAccount() {

		browserSetUp("https://www.facebook.com/");

		System.out.println("Step 2-Click on Create New Account button");
		driver.findElement(By.linkText("Create New Account")).click();

		System.out.println("Step 3-Fill Signup form");

		System.out.println("Enter name");
		WebElement firstNameElement = driver.findElement(By.name("firstname"));
		firstNameElement.clear();
		firstNameElement.sendKeys("Sachin");

		WebElement lastNameElement = driver.findElement(By.name("lastname"));
		lastNameElement.clear();
		lastNameElement.sendKeys("Pawar");

		System.out.println("Enter email");
		WebElement emailElement = driver.findElement(By.name("reg_email__"));
		emailElement.clear();
		emailElement.sendKeys("sachinpawar@gmail.com");

		WebElement emailConfirmElement = driver.findElement(By.name("reg_email_confirmation__"));
		emailConfirmElement.clear();
		emailConfirmElement.sendKeys("sachinpawar@gmail.com");

		System.out.println("Enter password");
		WebElement passwordElement = driver.findElement(By.id("password_step_input"));
		passwordElement.clear();
		passwordElement.sendKeys("sachin@1234");

		System.out.println("Select BirthDate");
		Select dateSelect = new Select(driver.findElement(By.name("birthday_day")));
		dateSelect.selectByIndex(16);

		Select monthSelect = new Select(driver.findElement(By.name("birthday_month")));
		monthSelect.selectByVisibleText("Nov");

		Select yearSelect = new Select(driver.findElement(By.id("year")));
		yearSelect.selectByValue("1985");

		System.out.println("Select gender");
		driver.findElement(By.xpath("//input[@value='-1']")).click();

		WebElement pronounElement = driver.findElement(By.name("preferred_pronoun"));
		Select pronounSelect = new Select(pronounElement);
		pronounSelect.selectByValue("2");
		System.out.println("Browser Closed");
		driver.close();
	}

	public static void main(String[] args) {
		new Assignment3().createAccount();
	}
}
