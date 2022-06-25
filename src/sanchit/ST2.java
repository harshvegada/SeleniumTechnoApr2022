/*Exam - 2 : 22nd Jun'2022

1.Navigate to site http://automationpractice.com/index.php
2.Click on 'Sign In' button top right corner
3.Verify URL contains 'My-account' keyword or not
4.Enter any random email address
5.Click on create an account button
6.Fill that form with any random details
	a.use pin number as '37201'
7.Click on 'Register' button
8.After successful registration you landed on My Account Page(Verify the title, should contain My Account keyword)
9.Verify logged-In name, In combination of firstName and lastName
10.Verify 'sign out' button is getting displayed
11.Click on 'sign out' button
12.Verify, you landed on Login screen(Verify page title)*/

package sanchit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ST2 {

	private static WebDriver driver;
	private static Select dropDownSelect;
	String cusFirstName = "Qazwsx";
	String cusLastName = "Zsa";
	String emailId = "mytest@testThis.in";
	String pwd = "123qwe123";
	String DOBDay = "1";
	String DOBMonth = "2";
	String DOBYear = "1995";
	String companyName = "ABC";
	String address1 = "Rimjhim";
	String address2 = "PeriPeri";
	String city = "MyTown";
	String state = "Alaska";
	String pinNumber = "37201";
	String additionalInformation = "Others";
	String phone = "210-76789";
	String mobile = "9879879876";
	String extraEmailAlias = "@asd.com";

	void launchBrowserLoadUrl() {
		System.out.println("Launch Chrome Browser");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("STEP1.Navigate to site http://automationpractice.com/index.php");
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	void navigateTocreateAccountThroughSignIn() {
		System.out.println("STEP2.Click on 'Sign In' button top right corner");
		driver.findElement(By.xpath("//div[@class='header_user_info']/a[@class='login']")).click();
		String currentUrl = driver.getCurrentUrl();
		System.out.println("STEP3.Verify URL contains 'My-account' keyword or not");
		System.out.println("Current URL contains my-account key word: " + currentUrl.contains("my-account"));
		System.out.println("STEP4.Enter any random email address");
		driver.findElement(By.id("email_create")).sendKeys(emailId);
		System.out.println("Email ID: " + emailId);
		System.out.println("STEP5.Click on create an account button");
		driver.findElement(By.id("SubmitCreate")).click();
	}

	void fillAndRegisterCreateAccountForm() {
		System.out.println("STEP6.Fill that form with any random details");
		driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys(cusFirstName);
		System.out.println("Customer first name: " + cusFirstName);
		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys(cusLastName);
		System.out.println("Customer last name: " + cusLastName);
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(pwd);
		System.out.println("Password: " + pwd);

		dropDownSelect = new Select(driver.findElement(By.xpath("//select[@id='days']")));
		dropDownSelect.selectByValue(DOBDay);
		System.out.println("Day of date of birth: " + DOBDay);
		dropDownSelect = new Select(driver.findElement(By.xpath("//select[@id='months']")));
		dropDownSelect.selectByValue(DOBMonth);
		System.out.println("Month of date of birth: " + DOBMonth);
		dropDownSelect = new Select(driver.findElement(By.xpath("//select[@id='years']")));
		dropDownSelect.selectByValue(DOBYear);
		System.out.println("Year of date of birth: " + DOBYear);

		driver.findElement(By.xpath("//input[@id='newsletter']")).click();
		System.out.println("NewsLetter checkbox selected");

		WebElement elementFirstName = driver.findElement(By.xpath("//input[@id='firstname']"));
		elementFirstName.clear();
		elementFirstName.sendKeys(cusFirstName);
		System.out.println("Customer first name: " + cusFirstName);
		WebElement elementLastName = driver.findElement(By.xpath("//input[@id='lastname']"));
		elementLastName.clear();
		elementLastName.sendKeys(cusLastName);
		System.out.println("Customer first name: " + cusLastName);
		WebElement elementEmail = driver.findElement(By.xpath("//input[@id='email']"));
		elementEmail.clear();
		elementEmail.sendKeys(emailId);
		System.out.println("Email ID: " + emailId);
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys(companyName);
		System.out.println("Company Name: " + companyName);
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(address1);
		System.out.println("Address1 : " + address1);
		driver.findElement(By.xpath("//input[@id='address2']")).sendKeys(address2);
		System.out.println("Address2: " + address2);
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys(city);
		System.out.println("City: " + city);

		dropDownSelect = new Select(driver.findElement(By.xpath("//select[@id='id_state']")));
		dropDownSelect.selectByVisibleText(state);
		System.out.println("State: " + state);

		System.out.println("STEP6- a.use pin number as '37201'");
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys(pinNumber);
		System.out.println("Pin Number: " + pinNumber);

		driver.findElement(By.xpath("//textarea[@id='other']")).sendKeys(additionalInformation);
		System.out.println("Additional Information: " + additionalInformation);
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(phone);
		System.out.println("Phone Number: " + phone);
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys(mobile);
		System.out.println("Mobile Number: " + mobile);
		WebElement elementAddressAlias = driver.findElement(By.xpath("//input[@id='alias']"));
		elementAddressAlias.clear();
		elementAddressAlias.sendKeys(extraEmailAlias);
		System.out.println("Extra email alias: " + extraEmailAlias);

		System.out.println("STEP7.Click on 'Register' button");
		driver.findElement(By.xpath("//button[@id='submitAccount']")).click();
	}

	void verificationPostRegistration() {
		System.out.println(
				"STEP8.After successful registration you landed on My Account Page(Verify the title, should contain My Account keyword)");
		String elementPostregistrationTitle = driver.getTitle();
		System.out.println(elementPostregistrationTitle);
		System.out.println("Post registration page title contains My account: "
				+ elementPostregistrationTitle.contains("My account"));
		System.out.println("STEP9.Verify logged-In name, In combination of firstName and lastName");
		String loggedInName = driver.findElement(By.xpath("//a[@title='View my customer account']")).getText();
		System.out.println("Expected combination of Logged-In name: '" + cusFirstName + " " + cusLastName + "'");
		System.out.println("Logged-In name in combination of firstName and lastName: "
				+ loggedInName.equals(cusFirstName + " " + cusLastName));
	}

	void signOut() {
		WebElement elementSignOut = driver.findElement(By.xpath("//a[@title='Log me out']"));
		System.out.println("STEP10.Verify 'sign out' button is getting displayed");
		System.out.println("'Sign Out' button is getting displayed: " + elementSignOut.isDisplayed());
		System.out.println("STEP11.Click on 'sign out' button");
		elementSignOut.click();
		System.out.println("STEP12.Verify, you landed on Login screen(Verify page title)");
		System.out.println("Current page title: " + driver.getTitle());
	}

	public static void main(String[] args) {
		ST2 st2 = new ST2();
		st2.launchBrowserLoadUrl();

		st2.navigateTocreateAccountThroughSignIn();
		st2.fillAndRegisterCreateAccountForm();
		st2.verificationPostRegistration();
		st2.signOut();

		driver.quit();
	}
}
