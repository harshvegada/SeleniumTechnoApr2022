/*Exam 2 = Automate below scenario

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
package rakesh;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Exam2 {
	
	String fn = "Rakesh";
	String ln = "Borse";
	
	WebDriver driver = PreReq.setUp("http://automationpractice.com/index.php");
	
	boolean checkTitle(String str) {
		if(driver.getTitle().contains(str))
			System.out.println("STEP PASSED - verify page title");
		else
			System.out.println("STEP FAILED - verify page title");
		return driver.getTitle().contains(str);
	}
	
	void signInWithEmail(String email) {
		
		driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
		System.out.println("STEP PASSED - 2. Click on `Sign In` button top right corner");
		if(driver.getCurrentUrl().contains("my-account"))
			System.out.println("STEP PASSED - 3. Verify whether URL contains `my-account` keyword or not");
		else
			System.out.println("STEP FAILED - 3. Verify whether URL contains `my-account` keyword or not");
		
		driver.findElement(By.id("email_create")).sendKeys(email);
		System.out.println("STEP PASSED - 4. enter any random email address");
		driver.findElement(By.name("SubmitCreate")).click();
		System.out.println("STEP PASSED - 5. Click on `Create an account` button");
	}
	
	void fillDetails() {
		
		driver.findElement(By.xpath("//label[@for='id_gender1']")).click();
		driver.findElement(By.name("customer_firstname")).sendKeys(fn);
		driver.findElement(By.name("customer_lastname")).sendKeys(ln);
		driver.findElement(By.name("passwd")).sendKeys("123455791022");

		Select dateDD = new Select(driver.findElement(By.id("days")));
		dateDD.selectByValue("16");
		Select monthDD = new Select(driver.findElement(By.id("months")));
		monthDD.selectByValue("8");
		Select yearDD = new Select(driver.findElement(By.id("years")));
		yearDD.selectByValue("1991");
		driver.findElement(By.id("uniform-newsletter")).click();
		driver.findElement(By.id("uniform-optin")).click();
		driver.findElement(By.name("company")).sendKeys("dassault systems");
		driver.findElement(By.name("address1")).sendKeys("F313 aqua marina shindevasti");
		driver.findElement(By.name("address2")).sendKeys("ravet near SB patil school");
		driver.findElement(By.name("city")).sendKeys("PUNE");
		Select stateDD = new Select(driver.findElement(By.id("id_state")));
		stateDD.selectByValue("6");
		driver.findElement(By.name("postcode")).sendKeys("41210");
		Select countryDD = new Select(driver.findElement(By.id("id_country")));
		countryDD.selectByValue("21");
		driver.findElement(By.name("other")).sendKeys("This is additional info being put by autoamtion");
		driver.findElement(By.name("phone_mobile")).sendKeys("7387706828");
		driver.findElement(By.name("alias")).sendKeys("RHB_ADDRESS_01");
		System.out.println("STEP PASSED - 6. Fill that form with any random details");
		driver.findElement(By.name("submitAccount")).click();
		System.out.println("STEP PASSED - 7. Click on `Register` button");
		checkTitle("My Account");	
	}
	
	void afterLoginChecks() {
		if(driver.findElement(By.xpath("//a[@title='View my customer account']")).getText().contains(fn + " " + ln))
			System.out.println("STEP PASSED - 9. Verify logged in name is combination of firstName and lastName");
		else
			System.out.println("STEP FAILED - 9. Verify logged in name is combination of firstName and lastName");
		
		if(driver.findElement(By.xpath("//a[@title='Log me out']")).isDisplayed())
			System.out.println("STEP PASSED - 10. Verify `Sign out` button is getting display");
		else
			System.out.println("STEP FAILED - 10. Verify `Sign out` button is getting display");
		
		driver.findElement(By.xpath("//a[@title='Log me out']")).click();
		System.out.println("STEP FAILED - 11. Click on `Sign out` button");
		checkTitle("Login");
	}

	public static void main(String[] args) {
		Exam2 obj = new Exam2();
		System.out.println("======>Exam 2 <========");
		obj.signInWithEmail("rhborse20@gmail.com");
		obj.fillDetails();
		obj.afterLoginChecks();
	}
}
