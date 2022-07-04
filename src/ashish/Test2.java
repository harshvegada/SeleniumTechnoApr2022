package ashish;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Test2 {

	String firstName = "TestingFirstNameA", lastName = "TestingLastNameB", email = "asything6@test.com",
			password = "Testing@12#", city = "Pune", companyName = "Company address details",
			address = "Street address, P.O. Box, Company name, etc", pinCode = "37201",
			comments = "Additional comments", phoneNo = "9874561230", mobileNo = "20145698740", alias = "alias",
			url = "http://automationpractice.com/index.php";

	WebDriver driver;

	public void browserSetUp() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("STEP - Navigate to site ");
		driver.get(url);
		driver.manage().window().maximize();
	}

	public void verifyLoginPage() {
		System.out.println("STEP - Click on `Sign In` button top right corner");
		driver.findElement(By.xpath("//a[@class ='login']")).click();

		System.out.println("STEP - Verify whether URL contains `my-account` keyword or not");
		boolean iswordMyAccountPresent = driver.getCurrentUrl().contains("my-account");
		if (iswordMyAccountPresent) {
			System.out.println("URL contains `my-account` keyword");
		} else {
			System.out.println("URL does not contains `my-account` keyword");
		}

		System.out.println("STEP - enter any random email address");
		WebElement emailCreateElement = driver.findElement(By.xpath("//input[@id='email_create']"));
		emailCreateElement.clear();
		emailCreateElement.sendKeys(email);

		System.out.println("STEP - Click on `Create an account` button");
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
	}

	public void fillPersonalDetails() {
		driver.findElement(By.xpath("//input[@id='id_gender1']")).click();

		WebElement regFirstNameElement = driver.findElement(By.xpath("//input[@id='customer_firstname']"));
		regFirstNameElement.clear();
		regFirstNameElement.sendKeys(firstName);

		WebElement reglastNameElement = driver.findElement(By.xpath("//input[@id='customer_lastname']"));
		reglastNameElement.clear();
		reglastNameElement.sendKeys(lastName);

		WebElement regpasswordElement = driver.findElement(By.xpath("//input[@id='passwd']"));
		regpasswordElement.clear();
		regpasswordElement.sendKeys(password);

		// Enter date of birth
		WebElement dateElement = driver.findElement(By.xpath("//select[@id='days']"));
		Select dateSelect = new Select(dateElement);
		dateSelect.selectByIndex(1);

		WebElement monthElement = driver.findElement(By.xpath("//select[@id='months']"));
		Select monthSelect = new Select(monthElement);
		monthSelect.selectByIndex(1);

		WebElement yearElement = driver.findElement(By.xpath("//select[@id='years']"));
		Select yearSelect = new Select(yearElement);
		yearSelect.selectByIndex(1);
	}

	public void fillAddressDetails() {
		WebElement addDetailsFirstNameElement = driver.findElement(By.xpath("//input[@id='firstname']"));
		addDetailsFirstNameElement.clear();
		addDetailsFirstNameElement.sendKeys(firstName);

		WebElement addDetailsLastNameElement = driver.findElement(By.xpath("//input[@id='lastname']"));
		addDetailsLastNameElement.clear();
		addDetailsLastNameElement.sendKeys(lastName);

		WebElement addDetailsCompanyElement = driver.findElement(By.xpath("//input[@id='company']"));
		addDetailsCompanyElement.clear();
		addDetailsCompanyElement.sendKeys(companyName);

		WebElement addDetailsAddressElement = driver.findElement(By.xpath("//input[@id='address1']"));
		addDetailsAddressElement.clear();
		addDetailsAddressElement.sendKeys(address);

		WebElement addDetailsCityElement = driver.findElement(By.xpath("//input[@id='city']"));
		addDetailsCityElement.clear();
		addDetailsCityElement.sendKeys(city);

		WebElement addDetailsStateElement = driver.findElement(By.xpath("//select[@id='id_state']"));
		Select stateSelect = new Select(addDetailsStateElement);
		stateSelect.selectByIndex(1);

		WebElement addDetailspostcodeElement = driver.findElement(By.xpath("//input[@id='postcode']"));
		addDetailspostcodeElement.clear();
		addDetailspostcodeElement.sendKeys(pinCode);

		WebElement addDetailsCountryElement = driver.findElement(By.xpath("//select[@id='id_country']"));
		Select countrySelect = new Select(addDetailsCountryElement);
		countrySelect.selectByIndex(1);

		driver.findElement(By.xpath("//textarea[@id='other']")).sendKeys(comments);

		WebElement addDetailsHomePhoneElement = driver.findElement(By.xpath("//input[@id='phone']"));
		addDetailsHomePhoneElement.clear();
		addDetailsHomePhoneElement.sendKeys(phoneNo);

		WebElement addDetailsMobilePhoneElement = driver.findElement(By.xpath("//input[@id='phone_mobile']"));
		addDetailsMobilePhoneElement.clear();
		addDetailsMobilePhoneElement.sendKeys(mobileNo);

		WebElement addDetailsaliasElement = driver.findElement(By.xpath("//input[@id='alias']"));
		addDetailsaliasElement.clear();
		addDetailsaliasElement.sendKeys(alias);

		System.out.println("STEP - Click on `Register` button");
		driver.findElement(By.xpath("//button[@id='submitAccount']")).click();
	}

	public void verifyMyAccountPage() {
		System.out.println(
				"STEP - After Successfully registration you landed on My Account Page (Verify the title should contains My Account keyword)");

		if (driver.getTitle().contains("My account"))
			System.out.println("Result - Title  contains My Account keyword");
		else
			System.out.println("Result - Title does not contains My Account keyword");

		System.out.println("STEP - Verify logged in name is combination of firstName and lastName");

		String fullName = driver.findElement(By.xpath("//a[@title='View my customer account']/span")).getText();
		String[] userName = fullName.split(" ");
		if (userName[0].equals(firstName) && userName[1].equals(lastName))
			System.out.println("Result - The logged in name is combination of firstName and lastName");
		else
			System.out.println("Result - The logged in name is not combination of firstName and lastName");

		System.out.println("STEP -  Verify `Sign out` button is getting display");
		if (driver.findElement(By.xpath("//a[@title = 'Log me out']")).isDisplayed())
			System.out.println("Result -`Sign out` button is getting display");
		else
			System.out.println("Result -`Sign out` button is not display");

		System.out.println("STEP - Click on `Sign out` button");
		driver.findElement(By.xpath("//a[@title = 'Log me out']")).click();

		System.out.println("STEP - Verify you landed on Login screen(verify page title)");
		if (driver.getTitle().contains("Login"))
			System.out.println("Result - Landed on Login screen successfully");
		else
			System.out.println("Result - Not landed on Login screen");
	}

	public void tearDown() {
		driver.close();
	}

	@Test
	public void verifyCreateAccount() {
		// Environment and Browser Setup
		browserSetUp();
		// verify login page
		verifyLoginPage();
		// Fill YOUR PERSONAL INFORMATION details
		fillPersonalDetails();
		// Fill address details
		fillAddressDetails();
		// verify My Account Page
		verifyMyAccountPage();
		// Close browser
		tearDown();
	}
}
