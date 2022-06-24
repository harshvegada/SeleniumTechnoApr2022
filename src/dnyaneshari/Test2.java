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
Exam - 2 : 22nd Jun'2022 */
package dnyaneshari;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test2 {
	private WebDriver driver;

	String Test(String url) {
		System.setProperty("webdriver.chrome.driver", "E:\\\\chromedriver_win32\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.get(url);
		String pagetitle = driver.getTitle();
		return pagetitle;
	}

	void enterdetail(String email) {
		driver.findElement(By.xpath("//a[@class='login']")).click();
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		if (currentUrl.contains("my-account")) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}

		System.out.println("Step-Enter Email address");
		WebElement emailaddress = driver.findElement(By.xpath("//input[@id='email_create']"));
		emailaddress.sendKeys(email);
		driver.findElement(By.id("SubmitCreate")).click();

	}

	void createAccountDetails(String FirstName, String LastName, String pwd, String dob, int dom, String doy) {
		driver.findElement(By.xpath("//input[@name='id_gender' and @value=1]")).click();

		System.out.println("Step-Enter Name");
		WebElement firstName = driver.findElement(By.id("customer_firstname"));
		firstName.clear();
		firstName.sendKeys(FirstName);
		WebElement lastName = driver.findElement(By.id("customer_lastname"));
		lastName.clear();
		lastName.sendKeys(LastName);
		WebElement password = driver.findElement(By.id("passwd"));
		password.clear();
		password.sendKeys(LastName);

		System.out.println("Enter DOB");
		WebElement day = driver.findElement(By.id("days"));
		Select date = new Select(day);
		date.selectByValue(dob);
		WebElement months = driver.findElement(By.id("months"));
		Select month = new Select(months);
		month.selectByIndex(dom);
		WebElement years = driver.findElement(By.name("years"));
		Select year = new Select(years);
		year.selectByValue(doy);

	}

	void addressDetails(String FirstName, String LastName, String companyname, String addressone, String addresstwo,
			String city, String pincode) {
		WebElement fname = driver.findElement(By.id("firstname"));
		fname.clear();
		fname.sendKeys(FirstName);

		WebElement lname = driver.findElement(By.id("lastname"));
		lname.clear();
		lname.sendKeys(LastName);

		WebElement company = driver.findElement(By.id("company"));
		company.clear();
		company.sendKeys(companyname);

		WebElement address1 = driver.findElement(By.id("address1"));
		address1.clear();
		address1.sendKeys(addressone);

		WebElement address2 = driver.findElement(By.id("address2"));
		address2.clear();
		address2.sendKeys(addresstwo);

		WebElement cityname = driver.findElement(By.id("city"));
		cityname.clear();
		cityname.sendKeys(city);

		WebElement state = driver.findElement(By.name("id_state"));
		Select selectState = new Select(state);
		selectState.selectByVisibleText("Oklahoma");

		WebElement postcode = driver.findElement(By.id("postcode"));
		postcode.clear();
		postcode.sendKeys(pincode);

		WebElement country = driver.findElement(By.name("id_country"));
		Select selectCountry = new Select(country);
		selectCountry.selectByVisibleText("United States");

		WebElement otherinfo = driver.findElement(By.id("other"));
		otherinfo.clear();
		otherinfo.sendKeys("No More information");

		WebElement homephonenumber = driver.findElement(By.id("phone"));
		homephonenumber.clear();
		homephonenumber.sendKeys("7854218787");

		WebElement mobilenumber = driver.findElement(By.id("phone_mobile"));
		mobilenumber.clear();
		mobilenumber.sendKeys("7854218858");

		WebElement myaddress = driver.findElement(By.xpath("//input[@value='My address']"));
		myaddress.clear();
		myaddress.sendKeys("Address 123");

		driver.findElement(By.xpath("//*[text()='Register']")).click();

		System.out.println("Enter Page Title");
		String title = driver.getTitle();

		System.out.println(title);

		if (title.contains("My account"))
			System.out.println("Pass");
		else
			System.out.println("fail");
	}

	void verifyLogInname(String FirstName, String LastName) {
		WebElement loginname = driver.findElement(By.xpath("//a[@class='account']"));
		String loginInUserName = loginname.getText();
		if (loginInUserName.equals(FirstName + " " + LastName))
			System.out.println("User is login with correct First and Last Name");
		else
			System.out.println("invalide name");

	}

	String verifySignOutbutton() {
		WebElement Signout = driver.findElement(By.xpath("//a[@class='logout']"));
		if (Signout.isDisplayed())
			System.out.println("Sign out button is displayed");
		else
			System.out.println("Sign out button is not displayed");
		Signout.click();
		String title = driver.getTitle();
		System.out.println(title);

		return title;
	}

	void verifyLoginpagetitle(String expectedTitle, String actualTitle) {

		if (expectedTitle.equals(actualTitle))
			System.out.println("pass");
		else
			System.out.println("fail");
	}

	void runTest() {
		String actualTitle = Test("http://automationpractice.com/index.php");
		enterdetail("rudra140p@gmail.com");
		createAccountDetails("Rudra", "panchal", "password", "26", 6, "1997");
		addressDetails("Rudra", "panchal", "company1", "maharashtra", "india", "pune", "37201");
		verifyLogInname("Rudra", "panchal");
		String expectedPageTitle = verifySignOutbutton();
		verifyLoginpagetitle(expectedPageTitle, actualTitle);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test2 test2 = new Test2();
		test2.runTest();

	}

}
