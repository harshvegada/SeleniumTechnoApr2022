/*Automate below scenario
1. Navigate to site `http://automationpractice.com/index.php`
2. Click on `Sign In` button top right corner
3. Verify whether URL contains `my-account` keyword or not
4. enter any random email address
5. Click on `Create an account` button
6. Fill that form with any random details
	a. use pin number as `37201`
7. Click on `Register` button
8. After Successfully registration you landed on My Account Page (Verify the title should contains My Account keyword)
9. Verify logged in name is combination of firstName and lastName
10. Verify `Sign out` button is getting display
11. Click on `Sign out` button
12. Verify you landed on Login screen(verify page title)
 */

package minu.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test2 {

	private WebDriver driver;

	private void browserSetUp() {
		System.out.println("STEP-Launch Chrome brower");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		System.out.println("STEP-Navigate to site-'http://automationpractice.com/index.php'");
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
	}

	void verifySignInDetails(String firstName, String lastName, String email, String password) {
		browserSetUp();
		System.out.println("STEP-Click on `Sign In` button top right corner");
		driver.findElement(By.linkText("Sign in")).click();

		System.out.println("STEP-Verify whether URL contains `my-account` keyword or not");
		String actualURLText = driver.getCurrentUrl();
		System.out.println("Current URL: " + actualURLText);
		if (actualURLText.contains("my-account")) {
			System.out.println("Test Case Pass--> Current URL contains `my-account` keyword");
		} else
			System.out.println("Test Case fail--> Current URL not contains `my-account` keyword");

		System.out.println("STEP-enter any random email address");
		driver.findElement(By.id("email_create")).sendKeys(email);

		System.out.println("STEP-Click on `Create an account` button");
		driver.findElement(By.id("SubmitCreate")).click();

		System.out.println("STEP-Fill that form with any random details");
		System.out.println("Select title");
		driver.findElement(By.xpath("//input[@value='2']")).click();

		System.out.println("Enter name");
		driver.findElement(By.name("customer_firstname")).sendKeys(firstName);
		driver.findElement(By.name("customer_lastname")).sendKeys(lastName);

		System.out.println("Enter password");
		driver.findElement(By.id("passwd")).sendKeys(password);

		System.out.println("Select Date of Birth");
		WebElement dayElement = driver.findElement(By.name("days"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", dayElement);
		Select birthDateSelect = new Select(dayElement);
		birthDateSelect.selectByIndex(14);
		birthDateSelect = new Select(driver.findElement(By.name("months")));
		birthDateSelect.selectByValue("7");
		birthDateSelect = new Select(driver.findElement(By.id("years")));
		birthDateSelect.selectByValue("1995");

		System.out.println("Select checkbox");
		driver.findElement(By.id("newsletter")).click();
		driver.findElement(By.id("optin")).click();

		System.out.println("Enter address");
		WebElement addressElement = driver.findElement(By.id("address1"));

		js.executeScript("arguments[0].scrollIntoView(true)", addressElement);
		addressElement.sendKeys("UN-12");

		driver.findElement(By.name("city")).sendKeys("Nashville");

		Select stateSelect = new Select(driver.findElement(By.id("id_state")));
		stateSelect.selectByValue("5");
		driver.findElement(By.id("postcode")).sendKeys("37201");

		System.out.println("Enter phone number");
		driver.findElement(By.id("phone_mobile")).sendKeys("7654321132");

		System.out.println("STEP-Click on 'Register' button");
		WebElement registerElement = driver.findElement(By.xpath("//button[@id = 'submitAccount']"));
		js.executeScript("arguments[0].scrollIntoView(true)", registerElement);
		registerElement.click();

		System.out.println("STEP-After Successfully registration you landed on My Account Page");
		String currentPageTitle = driver.getTitle();
		System.out.println("Title of the page: " + currentPageTitle);
		System.out.println("STEP-Verify the title should contains My Account keyword");
		if (currentPageTitle.contains("My account"))
			System.out.println("Test Case Pass--> Current title contains 'My account' keyword");
		else
			System.out.println("Test Case fail--> Current title not contains 'My account' keyword");

		System.out.println("STEP-Verify logged in name is combination of firstName and lastName");
		String expectedUserName = firstName + " " + lastName;
		String userName = driver.findElement(By.className("account")).getText();
		if (userName.equals(expectedUserName))
			System.out.println("Test Case Pass--> logged name is combination of firstName and lastName");
		else
			System.out.println("Test Case fail--> logged name is incorrect");

		System.out.println("STEP-Verify 'Sign out' button is getting display");
		boolean isSignOut = driver.findElement(By.linkText("Sign out")).isDisplayed();
		if (isSignOut)
			System.out.println("Test Case Pass--> SignOut button is getting displayed");
		else
			System.out.println("Test Case fail--> SignOut button is not displayed");

		System.out.println("STEP-Click on 'Sign out' button");
		driver.findElement(By.linkText("Sign out")).click();

		System.out.println("STEP-Verify you landed on Login screen");
		String pageTitle = driver.getTitle();
		if (pageTitle.contains("Login")) {
			System.out.println("Test Case Pass--> Current page title is Login");
		} else
			System.out.println("Test Case fail--> Current page title is different");
	}

	public static void main(String[] args) {
		new Test2().verifySignInDetails("Minu", "Kumari", "minuexam2@gmail.com", "Test12345");
	}

}
