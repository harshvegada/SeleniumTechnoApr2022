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

package tamanna.Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeTest1 {

	WebDriver driver;
	
	SeTest1(){
		System.out.println("1. Navigate to site `http://automationpractice.com/index.php");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
	}
	
	void navigateToElement(String elementXpath) {
		driver.findElement(By.xpath(elementXpath)).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	void createAccount() {
		System.out.println("4. enter any random email address");
		WebElement emailElement=driver.findElement(By.xpath("//input[@id='email_create']"));
		emailElement.clear();
		emailElement.sendKeys("tamy@etest.com");
		
		System.out.println("5. Click on `Create an account` button");
		navigateToElement("//button[@id='SubmitCreate']");
	}
	
	void fillTextBox(String xpath,String value) {
		WebElement element=driver.findElement(By.xpath(xpath));
		element.clear();
		element.sendKeys(value);
		
	}
	
	void SelectDDValue(String xpath,String value) {
		WebElement element=driver.findElement(By.xpath(xpath));
		Select ddSelect=new Select(element);
		ddSelect.selectByValue(value);
	}
	
	void selectClickElements(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	void fillForm() {
		selectClickElements("//input[@id='id_gender2']");
		fillTextBox("//input[@name='customer_firstname']", "Tamanna");
		fillTextBox("//input[@name='customer_lastname']", "Shah");
		fillTextBox("//input[@name='passwd']", "abc123");
		
		SelectDDValue("//select[@id='days']", "17");
		SelectDDValue("//select[@id='years']", "1993");
		SelectDDValue("//select[@id='months']", "1");
		
		selectClickElements("//input[@id='newsletter']");
		selectClickElements("//input[@id='optin']");
		
		fillTextBox("//input[@id='firstname']", "Tamanna");
		fillTextBox("//input[@id='lastname']", "Shah");
		fillTextBox("//input[@id='company']", "ERIN Technology");
		fillTextBox("//input[@id='address1']", "ABC, 123 DEF");
		fillTextBox("//input[@id='address2']", "GHI 745 KLM");
		fillTextBox("//input[@id='city']", "Vadodara");
		
		SelectDDValue("//select[@id='id_state']", "32");
		fillTextBox("//input[@id='postcode']", "37201");
		fillTextBox("//textarea[@id='other']", "this is QA Exam 1.");
		fillTextBox("//input[@id='phone']", "855 558 4512");
		fillTextBox("//input[@id='phone_mobile']", "452 014 5263");
		fillTextBox("//input[@id='alias']", "home");
		fillTextBox("//input[@id='postcode']", "37201");
		
		System.out.println("7. Click on `Register` button");
		navigateToElement("//button[@id='submitAccount']");
	}
	
	void verifyUsername() {
		String username=driver.findElement(By.xpath("//a[@class='account']/span")).getText();
		if(username.equals("Tamanna Shah")) {
			System.out.println("Username verified.");
		}else {
			System.out.println("Username cant be verified.");
		}
	}
	
	void performTest() {
		System.out.println("2. Click on `Sign In` button top right corner");
		navigateToElement("//a[@class=\"login\"]");
		
		System.out.println("3. Verify whether URL contains `my-account` keyword or not");
		if(driver.getCurrentUrl().contains("my-account")) {
			System.out.println("URL contains my-account word.");
		}else {
			System.out.println("URL does not contain my-account word.");
		}
		
		createAccount();
		
		System.out.println("6. Fill that form with any random details");
		fillForm();
		
		System.out.println("8. After Successfully registration you landed on My Account Page (Verify the title should contains My Account keyword)");
		if(driver.getTitle().contains("My account")) {
			System.out.println("My account in title verified.");
		}else {
			System.out.println("My account in title not available.");
		}
		
		System.out.println("9. Verify logged in name is combination of firstName and lastName");
		verifyUsername();
		
		System.out.println("10. Verify `Sign out` button is getting display");
		WebElement element=driver.findElement(By.xpath("//*[text()='Sign out']"));
		if(element.isDisplayed()) {
			System.out.println("Sign out button is displayed.");
			System.out.println("11. Click on `Sign out` button");
			element.click();
			
			System.out.println("12. Verify you landed on Login screen(verify page title)");
			if(driver.getTitle().contains("Login")) {
				System.out.println("You landed on login screen.");
			}
			else {
				System.out.println("You are not landed on login screen.");
			}
		}else {
			System.out.println("Cant find signout button.");
		}
	}
	
	public static void main(String[] args) {
		SeTest1 seTest1=new SeTest1();
		seTest1.performTest();
		System.out.println("Test completed.");
	}
}
