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
Exam - 2 : 22nd Jun'2022
*/
package minalH;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test2 {
	
	WebDriver driver;
	String email = "minalh02@gmail.com";
	String firstName = "Minal";
	String lastName = "Hake";
	String password = "12345";
	String days = "30";
	String months = "4";
	String years = "1991";
	String city = "Pune";
	String address = "Airport";
	String postalCode = "41133";
	String phone = "9898989898";
	String signInUrl;
	
	
	void setup(String url) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe" );
		System.out.println("STEP - Launch browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP - Navigate to url");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	void createAccountPage() {
		setup("http://automationpractice.com/index.php");
		
		System.out.println("STEP - Click on Sign In button");
		driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
		
		System.out.println("STEP - Verify whether URL contains `my-account` keyword");
		signInUrl = driver.getCurrentUrl();
		if(driver.getCurrentUrl().contains("my-account"))
			System.out.println("Test pass !! - URL contains `my-account` keyword");
		else
		System.out.println("Test fail !! - URL does not contain `my-account` keyword");
		
		System.out.println("STEP - enter any email address");
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys(email);
		System.out.println("STEP - Click on `Create an account` button");
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
	}
	
	void fillRegistrationForm() {
		createAccountPage();
		System.out.println("STEP - Fill that form with any random details");
		System.out.println("Select title");
		driver.findElement(By.xpath("//input[@id='id_gender2']")).click();
		WebElement element = driver.findElement(By.xpath("//input[@id='firstname']"));
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true);", element);
		System.out.println("Enter First Name");
		WebElement fn = driver.findElement(By.xpath("//input[@id='customer_firstname']"));
		fn.sendKeys(firstName);
		//String firstName = fn.getAttribute("value");
		System.out.println("Enter Last Name");
		WebElement ln = driver.findElement(By.xpath("//input[@id='customer_lastname']"));
		ln.sendKeys(lastName);
		//String lastName = ln.getAttribute("value");
		System.out.println("Enter email address");
		
		if(driver.findElement(By.xpath("//input[@id='email']")).getAttribute("value").equals(email)) 
			System.out.println("Visible email is same as the email entered earlier");
		else 
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
		System.out.println("Enter password");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(password);
		
		System.out.println("Select Date of birth");
		Select day = new Select(driver.findElement(By.xpath("//select[@id='days']")));
		day.selectByValue(days);
		Select month = new Select(driver.findElement(By.xpath("//select[@id='months']")));
		month.selectByValue(months);
		Select year = new Select(driver.findElement(By.xpath("//select[@id='years']")));
		year.selectByValue(years);
		System.out.println("Your address");
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(address);
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys(city);
		Select state = new Select(driver.findElement(By.xpath("//select[@id='id_state']")));
		state.selectByValue("11");
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys(postalCode);
		/*
		 * Select country = new
		 * Select(driver.findElement(By.xpath("//select[@id='id_country']")));
		 * if(!((WebElement) country).isSelected()) country.selectByValue("21");
		 */
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys(phone);
		System.out.println("STEP - Click on Register button");
		driver.findElement(By.xpath("//button[@id='submitAccount']")).click();
		/*
		 * Alert alert = driver.switchTo().alert(); String currentMsg = alert.getText();
		 * alert.accept();
		 * 
		 * Alert alert2 = driver.switchTo().alert(); String currentMsg1 =
		 * alert2.getText(); alert2.dismiss();
		 */
	}
	
	void verifyRegistration() {
		fillRegistrationForm();
		System.out.println("STEP - After Successfully registration you landed on My Account Page (Verify the title should contains My Account keyword)");
		String title = driver.getTitle();
		if(title.contains("My Account"))
			System.out.println("Test pass !! - Successfully registered");
	}	
		
	void verifyLoginPage() {
		verifyRegistration();
		if(driver.findElement(By.xpath("//a[@title='View my customer account']")).getText().equals((firstName)+" "+(lastName)))
				System.out.println("Test pass !!- Correct login name");
		else
			System.out.println("Test fail !!- Incorrect login name");
		
		WebElement logout = driver.findElement(By.xpath("//a[@title='Log me out']"));
		if(logout.isDisplayed())
			System.out.println("Test pass !! - Logout button is visible");
		else
			System.out.println("Test fail !! - Logout button is not visible");
		logout.click();
		
		if(driver.getCurrentUrl().equals(signInUrl))
			System.out.println("Back to sign in page");
		
	}
	
	public static void main(String[] args) {
		Test2 test2 = new Test2();
		test2.verifyLoginPage();
	}

}
