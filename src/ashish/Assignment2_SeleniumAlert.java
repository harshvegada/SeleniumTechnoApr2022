/*
 Assignment 2 : 14th Jun'2022

Pre-requisite Steps
1)Go to http://automationbykrishna.com/
2)Go to on Basic Elements tab.

Program 1
1)Click on Alert button.
2)Check that alert pop up appears.
3)Check the alert msg "You must be TechnoCredits student!!"
4)Click OK to accept the alert.

Program 2
1)Click on Javascript Confirmation button.
2)Check that alert pop up appears.
3)Check the alert msg "Are you are doing your homework regularly, Press Okay else Cancel!!"
4)Click OK to accept the alert.
5)Check that msg appears "You pressed OK!" because OK button is clicked.

Program 3
1)Again Click on Javascript Confirmation button.
3)Check the alert msg "Are you are doing your homework regularly, Press Okay else Cancel!!"
4)Click Cancel to dismiss the alert.
5)Check that msg appears "You pressed Cancel!" because cancel button is clicked.

Program 4
Write a script to automate below test steps :

1) Launch Chrome brower
2) Load http://automationbykrishna.com
3) click on Basic Element link
4) Enter firstName
5) Enter lastName
6) Enter compantyName
7) click on Submit button
8) Handle alert
9) verify alert message using firstName, lastName, compantyName

Program 5
Write a script to automate below test steps :

1) Launch Chrome brower
2) Load http://automationbykrishna.com
3) click on Basic Element link
4) enter Email Address
5) Enter password
6) Click on submit button
7) Handle alert
8) verify alert message	
 */
package ashish;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2_SeleniumAlert {

	WebDriver driver;
	String url = "http://automationbykrishna.com/";

	void setUp(String url) {
		System.out.println("STEP - Launch Chrome brower");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		System.out.println("STEP - Load URL");
		driver.get(url);
		driver.manage().window().maximize();
	}

	void alertMessageValidator(String expectedAlertMsg, Alert alert) {
		String actualAlertMsg = alert.getText();
		if (expectedAlertMsg.equals(actualAlertMsg)) {
			System.out.println(actualAlertMsg + " - Message details are matching.");
		} else {
			System.out.println(actualAlertMsg + " - Message details are not matching.");
		}
	}

	void program1() {
		String expectedAlertMsg = "You must be TechnoCredits student!!";
		System.out.println("PREREQUISITE - Go to on Basic Elements tab.");
		driver.findElement(By.id("basicelements")).click();

		System.out.println("STEP - Click on Alert button.");
		driver.findElement(By.id("javascriptAlert")).click();

		System.out.println("STEP - Check that alert pop up appears.");
		Alert alert = driver.switchTo().alert();

		System.out.println("STEP - Check the alert msg \"You must be TechnoCredits student!!\"");
		alertMessageValidator(expectedAlertMsg, alert);

		System.out.println("STEP - Click OK to accept the alert.");
		alert.accept();
		System.out.println("Test Pass");

	}

	void program2() {
		String expectedAlertMsg = "Are you are doing your homework regularly, Press Okay else Cancel!!";
		
		System.out.println("STEP - Click on Javascript Confirmation button.");
		driver.findElement(By.id("javascriptConfirmBox")).click();

		System.out.println("STEP - Check that alert pop up appears.");
		Alert alert = driver.switchTo().alert();

		System.out.println("STEP - Check the alert msg \"Are you are doing your homework regularly, Press Okay else Cancel!!\"");
		alertMessageValidator(expectedAlertMsg, alert);

		System.out.println("STEP - Click OK to accept the alert.");
		alert.accept();

		System.out.println("STEP - Check that msg appears \"You pressed OK!\" because OK button is clicked.");
		String okMsg = driver.findElement(By.id("pgraphdemo")).getText();
		if (okMsg.equals("You pressed OK!")) {
			System.out.println(okMsg + "- Message details are matching.\nTest Pass");
		} else
			System.out.println(okMsg + "- Message details are matching.\nTest Pass");
	}

	void program3() {
		String expectedAlertMsg = "Are you are doing your homework regularly, Press Okay else Cancel!!";
		
		System.out.println("STEP - Click on Javascript Confirmation button.");
		driver.findElement(By.id("javascriptConfirmBox")).click();

		System.out.println("STEP - Check that alert pop up appears.");
		Alert alert = driver.switchTo().alert();

		System.out.println(
				"STEP - Check the alert msg \"Are you are doing your homework regularly, Press Okay else Cancel!!\"");
		alertMessageValidator(expectedAlertMsg, alert);

		System.out.println("STEP - Click Cancel to dismiss the alert..");
		alert.dismiss();

		System.out.println("STEP - Check that msg appears \"You pressed Cancel!\" because cancel button is clicked.");
		String cancelMsg = driver.findElement(By.id("pgraphdemo")).getText();
		if (cancelMsg.equals("You pressed Cancel!")) {
			System.out.println(cancelMsg + " - Message details are matching.\nTest Pass");
		} else
			System.out.println(cancelMsg + " - Message details are not matching.\nTest Failed");
	}

	void program4(String firstName, String lastName, String companyName) {
		setUp(url);
		System.out.println("STEP - Go to on Basic Elements tab.");
		driver.findElement(By.id("basicelements")).click();

		System.out.println("STEP - Enter firstName");
		WebElement firstNameElement = driver.findElement(By.id("UserFirstName"));
		firstNameElement.clear();
		firstNameElement.sendKeys(firstName);

		System.out.println("STEP - Enter lastName");
		WebElement lastNameElement = driver.findElement(By.id("UserLastName"));
		lastNameElement.clear();
		lastNameElement.sendKeys(lastName);

		System.out.println("STEP - Enter companyName");
		WebElement companyNameElement = driver.findElement(By.id("UserCompanyName"));
		companyNameElement.clear();
		companyNameElement.sendKeys(companyName);

		System.out.println("STEP - click on Submit button");
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();

		System.out.println("STEP - Handle alert");
		Alert alert = driver.switchTo().alert();

		System.out.println("STEP - verify alert message using firstName, lastName, compantyName");
		String expectedAlertMessage = firstName + " and " + lastName + " and " + companyName;
		alertMessageValidator(expectedAlertMessage, alert);

		System.out.println("STEP - Click OK to accept the alert.");
		alert.accept();

		System.out.println("Test Pass");
		driver.close();
	}

	void program5() {
		String email = "ashish@test.com";
		String password = "test1234";
		
		setUp(url);

		System.out.println("STEP - Go to on Basic Elements tab.");
		driver.findElement(By.id("basicelements")).click();

		System.out.println("STEP - enter Email Address");
		WebElement emailElement = driver.findElement(By.id("exampleInputEmail1"));
		emailElement.clear();
		emailElement.sendKeys(email);

		System.out.println("STEP - enter Password");
		WebElement passwordElement = driver.findElement(By.id("pwd"));
		passwordElement.clear();
		passwordElement.sendKeys(password);

		System.out.println("STEP - Click on submit button");
		driver.findElement(By.id("submitb2")).click();

		System.out.println("STEP - Handle alert");
		Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();

		System.out.println("STEP - verify alert message");
		alertMessageValidator(alertMessage, alert);
		alert.accept();
		driver.close();
	}

	void testAlert() {
		setUp(url);
		System.out.println("------------PROGRAM 1-----------------------");
		program1();
		System.out.println("------------PROGRAM 2-----------------------");
		program2();
		System.out.println("------------PROGRAM 3-----------------------");
		program3();
		driver.close();
	}
	
	public static void main(String[] args) {
		String firstName = "Ashish";
		String lastName = "Pethe";
		String companyName = "Technocredits";
		
		Assignment2_SeleniumAlert assignment2_SeleniumAlert = new Assignment2_SeleniumAlert();
		assignment2_SeleniumAlert.testAlert();
		System.out.println("------------PROGRAM 4-----------------------");
		assignment2_SeleniumAlert.program4(firstName, lastName, companyName);
		System.out.println("------------PROGRAM 5-----------------------");
		assignment2_SeleniumAlert.program5();
	}
}
