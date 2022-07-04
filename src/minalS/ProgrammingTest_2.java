package minalS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

///WAP to Automate below scenario 
/*1.Navigate to site 'http://automationpractise.com/index.php'
2.Click on 'Sign In' button top right corner
3.Verify whether URL contains 'my-account' keyword or not.
4.enter any random email address
5.Click on 'Create an account' botton
6.Fill that form with any random deatils
 a. use pin numbers as '37201'
7.Click on 'Register' button
8.After Successfully registration you landed on my Account Page(Verify the title should contains My Account keyword)
9.Verify logged in name is combination of firstname and lastname
10.Verify 'Sign out' botton is getting display
11.Click on 'Sign out' button
12.Verify you landed on Login screen(Verify page title )*/
public class ProgrammingTest_2 {

	private static WebDriver driver;

	void launchBrowser() {
		System.out.println("STEP - Launch Chrome browser");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Minal\\Selenium\\SeleniumTechnoApr2022\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("STEP - Load URL");
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		System.out.println("STEP: Click on Sign In botton");
		driver.findElement(By.className("login")).click();

		boolean url = driver.getCurrentUrl().contains("my-account");
		if (url) {
			System.out.println("Test case pass --> URL contains 'my-account' keyword");
		} else {
			System.out.println("Test case fail --> URL  not contains 'my-account' keyword");
		}
		System.out.println("STEP: Enter email address");
		WebElement emailId = driver.findElement(By.id("email_create"));
		emailId.sendKeys("minal45@gmail.com");

		System.out.println("STEP: Click on create account");
		driver.findElement(By.id("SubmitCreate")).click();

		System.out.println("STEP: Click on Mrs.");
		driver.findElement(By.id("id_gender2")).click();

		System.out.println("STEP: Enter name");
		WebElement userName = driver.findElement(By.id("customer_firstname"));
		userName.sendKeys("Minal");

		System.out.println("STEP: Enter last name");
		WebElement userLastName = driver.findElement(By.id("customer_lastname"));
		userLastName.sendKeys("Shende");

		System.out.println("STEP: Enter password");
		WebElement password = driver.findElement(By.id("passwd"));
		password.sendKeys("kjgutfcvjsg56");

		System.out.println("STEP: Select day");
		WebElement day = driver.findElement(By.id("days"));
		Select dateOfBirth = new Select(day);
		dateOfBirth.selectByValue("8");

		System.out.println("STEP: Select month");
		WebElement month = driver.findElement(By.id("months"));
		Select monthOfBirth = new Select(month);
		monthOfBirth.selectByValue("8");

		System.out.println("STEP: Select year");
		WebElement year = driver.findElement(By.id("years"));
		Select yearOfBirth = new Select(year);
		yearOfBirth.selectByValue("1994");

		System.out.println("STEP: Click on checkbox");
		driver.findElement(By.id("optin")).click();

		System.out.println("STEP: Enter company name");
		WebElement companyName = driver.findElement(By.id("company"));
		companyName.sendKeys("Globant");

		System.out.println("STEP: Enter address");
		WebElement address = driver.findElement(By.id("address1"));
		address.sendKeys("Wadi naka");

		System.out.println("STEP: Enter address 2");
		WebElement address2 = driver.findElement(By.id("address2"));
		address2.sendKeys("Amaravati road");

		System.out.println("STEP: Enter city");
		WebElement city = driver.findElement(By.id("city"));
		city.sendKeys("Nagpur");

		System.out.println("STEP: Select state");
		WebElement state = driver.findElement(By.id("id_state"));
		Select state1 = new Select(state);
		state1.selectByValue("5");

		System.out.println("STEP: Enter postal code");
		WebElement postalCode = driver.findElement(By.id("postcode"));
		postalCode.sendKeys("37201");

		System.out.println("STEP: Enter additional info");
		WebElement additionalInfo = driver.findElement(By.id("other"));
		additionalInfo.sendKeys("ABC");

		System.out.println("STEP: Enter home phone");
		WebElement homePhone = driver.findElement(By.id("phone"));
		homePhone.sendKeys("87678453273");

		System.out.println("STEP: Enter mobile number");
		WebElement mobileNo = driver.findElement(By.id("phone_mobile"));
		mobileNo.sendKeys("73678453273");

		System.out.println("STEP: Enter mobile number");
		WebElement addressForfuture = driver.findElement(By.id("alias"));
		addressForfuture.clear();
		addressForfuture.sendKeys("Wadi naka nagpur");

		System.out.println("STEP: Click on registration");
		driver.findElement(By.id("submitAccount")).click();

		System.out.println("STEP: Verify title");
		String title = driver.getTitle();
		if (title.contains("My account")) {
			System.out.println("Test case pass:--> title verified");
		} else {
			System.out.println("Test case pass:--> title not verified");
		}

		System.out.println("STEP: Verify logged in Id");
		WebElement logInId = driver.findElement(By.linkText("Minal Shende"));
		String text = logInId.getText();
		if (text.equals("Minal Shende")) {
			System.out.println("Test case pass --> ");
		} else {
			System.out.println("Test case fail --> ");
		}

		System.out.println("STEP: Verify sign out button visible");
		boolean isDisplay = driver.findElement(By.linkText("Sign out")).isDisplayed();
		if (isDisplay) {
			System.out.println("Test case pass --> sign out button is displayed");
		} else {
			System.out.println("Test case pass --> sign out button is not displayed");
		}

		System.out.println("STEP: click on sign out button");
		driver.findElement(By.linkText("Sign out")).click();

		System.out.println("STEP: Verify title");
		String title2 = driver.getTitle();
		if (title2.contains("Login")) {
			System.out.println("Test case pass:--> title verified");
		} else {
			System.out.println("Test case pass:--> title not verified");
		}

	}

	public static void main(String[] args) {
		ProgrammingTest_2 test = new ProgrammingTest_2();
		test.launchBrowser();
	}
}
