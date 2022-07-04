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
Exam - 2 : 22nd Jun'2022*/
package pragati;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test2 {
	private WebDriver driver;

	void setUp(String url) {
		System.out.println("Step1:Launch Browser");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		System.out.println("Step2:-click on Sign In");
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();

	}

	void verifyMYAccount() {
		boolean url = driver.getCurrentUrl().contains("my-account");
		if (url) {
			System.out.println("Test case pass --> URL contains 'my-account' keyword");
		} else {
			System.out.println("Test case fail --> URL  not contains 'my-account' keyword");
		}

	}

	void fillPersonalDetails() {
		System.out.println("STEP: Enter email address");
	    driver.findElement(By.xpath("//input[@id=\"email_create\"]")).sendKeys("sawant1pragati410@gmail.com");
		driver.findElement(By.xpath("//button[@id=\"SubmitCreate\"]")).click();
		System.out.println("Fill Personal Info");
		
		System.out.println("STEP-Click on MRs button");
		driver.findElement(By.id("id_gender2")).click();
		
		System.out.println("STEP - Enter FirstName");
		driver.findElement(By.name("customer_firstname")).sendKeys("Pragati");
		System.out.println("STEP - Enter LastName");
		
		driver.findElement(By.name("customer_lastname")).sendKeys("Sawant");
		System.out.println("STEP - Enter Password");
		
		driver.findElement(By.name("passwd")).sendKeys("pragati1234");
		System.out.println("STEP - Enter Birth-day");
		WebElement birthDay = driver.findElement(By.name("days"));
		Select s1 = new Select(birthDay);
		s1.selectByValue("2");
		
		System.out.println("STEP - Enter Birth-month");
		WebElement birthMonth = driver.findElement(By.name("months"));
		Select s2 = new Select(birthMonth);
		s2.selectByValue("5");
		
		System.out.println("STEP - Enter Birth-year");
		WebElement birthYear = driver.findElement(By.name("years"));
		Select s3 = new Select(birthYear);
		s3.selectByValue("1992");
		
		System.out.println("click on checkbox");
		driver.findElement(By.id("optin")).click();
		
		System.out.println("STEP-Enter Company name");
		driver.findElement(By.xpath("//input[@id=\"company\"]")).sendKeys("Infosys");
		
		System.out.println("STEP-Enter Address");
		driver.findElement(By.xpath("//input[@id=\"address1\"]")).sendKeys("Morwadi, Pimpri");
		driver.findElement(By.id("address2")).sendKeys(" pin number : 37201");
		
		System.out.println("STEP-Enter city");
		driver.findElement(By.xpath("//input[@id=\"city\"]")).sendKeys("Pune");
		
		System.out.println("STEP-Enter State");
		driver.findElement(By.xpath("//input[@id=\"city\"]")).sendKeys("Pune");
		WebElement state = driver.findElement(By.id("id_state"));
		Select state1 = new Select(state);
		state1.selectByValue("5");

		System.out.println("STEP: Enter postal code");
		driver.findElement(By.id("postcode")).sendKeys("37201");

		System.out.println("STEP: Enter additional info");
		driver.findElement(By.id("other")).sendKeys("abcvg");

		System.out.println("STEP: Enter home phone");
		driver.findElement(By.id("phone")).sendKeys("1234567788");

		System.out.println("STEP: Enter mobile number");
		driver.findElement(By.id("phone_mobile")).sendKeys("7234567889");
		driver.findElement(By.id("alias")).sendKeys("chinchwad");
		
		
		System.out.println("STEP: Click on registration");
		driver.findElement(By.id("submitAccount")).click();

	}
	void verifyTitleContainMyAccount() {
		System.out.println("STEP: Verify title Contain My Account Keyword");
		String title = driver.getTitle();
		if (title.contains("My account")) {
			System.out.println("Test case pass:--> title verified");
		} else {
			System.out.println("Test case pass:--> title not verified");
		}
	}
    void verifyLoggedID() {
    	System.out.println("STEP:Verify logged in name is combination of firstName and lastName");
    	WebElement logInId = driver.findElement(By.linkText("Pragati Sawant"));
		String text = logInId.getText();
		if (text.equals("Pragati Sawant")) {
			System.out.println("Test case pass --> ");
		} else {
			System.out.println("Test case fail --> ");
		}
    }
    void VerifySignOutButton() {
    	System.out.println("STEP:Verify `Sign out` button is getting display");
    	System.out.println("STEP: Verify sign out button visible");
		boolean isDisplay = driver.findElement(By.linkText("Sign out")).isDisplayed();
		if (isDisplay) {
			System.out.println("Test case pass --> sign out button is displayed");
		} else {
			System.out.println("Test case pass --> sign out button is not displayed");
		}
		
    }
    void clickOnSignOut() {
    	System.out.println("STEP: click on sign out button");
		driver.findElement(By.linkText("Sign out")).click();

		System.out.println("STEP: Verify page title");
		String title2 = driver.getTitle();
		if (title2.contains("Login")) {
			System.out.println("Test case pass:--> title verified");
		} else {
			System.out.println("Test case pass:--> title not verified");
		}

	}
    
	public static void main(String[] args) {
		Test2 test2 = new Test2();
		test2.setUp("http://automationpractice.com/index.php");
		test2.verifyMYAccount();
		test2.fillPersonalDetails();
		test2.verifyTitleContainMyAccount();
        test2.verifyLoggedID();
        test2.VerifySignOutButton();
        test2.clickOnSignOut();
	}
}
