/*Assignment-1 : 12th Jun'2022 

Write a script to automate below test steps :

1) Launch Chrome brower
2) Load http://automationbykrishna.com
3) click on Registration link
4) Enter username
5) Enter password
6) Click on submit button
7) verify alter message based on password length*/
package arti;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1RegistrationTabLoginForm {

	WebDriver driver;

	void setUpBrowser(String url) {

		System.out.println("STEP - Launch Chrome brower");

		System.setProperty("webdriver.chrome.driver", "C:\\Technocredit\\SeleniumTechnoApr2022\\drivers\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		System.out.println("\nSTEP - Load URL");

		driver.get(url);

		driver.manage().window().maximize();
	}

	void enterCredentials(String uname, String pwd) {

		System.out.println("\nSTEP - Enter Username");
		WebElement userName = driver.findElement(By.id("unameSignin"));
		userName.clear();
		userName.sendKeys(uname);

		System.out.println("\nSTEP - Enter Password");
		WebElement password = driver.findElement(By.id("pwdSignin"));
		password.clear();
		password.sendKeys(pwd);

		System.out.println("\nSTEP - Click on the Submit button");
		driver.findElement(By.id("btnsubmitdetails")).click();
	}

	String handleAlert() {

		System.out.println("\nSTEP - Switch to Alert window");

		Alert alert = driver.switchTo().alert();

		System.out.println("\nGet Actual Message from Alert window");
		String actualMessage = alert.getText();

		System.out.println("\nSTEP - Click on OK button to accept Alert");
		alert.accept();

		return actualMessage;
	}

	void verifyAlertMsg(String actualMsg, String expectedMsg) {

		if (actualMsg.equals(expectedMsg))
			System.out.println("\nRESULT - TEST PASS!!");
		else
			System.out.println("\nRESULT - TEST FAIL!!");
	}

	void verifyRegistrationAndLogin() {

		System.out.println("\n************************************************************************************");
		System.out.println("PRERQUISITE - Browser Setup");

		setUpBrowser("http://automationbykrishna.com");

		System.out.println("\nSTEP - Click on Registration Link");
		driver.findElement(By.id("registration2")).click();
		System.out.println("\n************************************************************************************");

		System.out.println("\nTest Case 1 - Verify Entering username, password and click on the submit button");
		enterCredentials("artishinde", "arti@1234");
		System.out.println("\n************************************************************************************");

		System.out.println("\nTest Case 2 - Verify Alert Message should be Success!");
		verifyAlertMsg(handleAlert(), "Success!");
		System.out.println("\n************************************************************************************");

		System.out.println("\nTest Case 3 - Verify Alert Message for weak password should be Failed!");
		System.out.println("\nEnter Credentials with password having length < 8 chars");

		enterCredentials("artishinde", "arti");
		verifyAlertMsg(handleAlert(), "Failed! please enter strong password");
		System.out.println("\n************************************************************************************");
	}

	public static void main(String[] args) {

		new Assignment1RegistrationTabLoginForm().verifyRegistrationAndLogin();
	}
}
