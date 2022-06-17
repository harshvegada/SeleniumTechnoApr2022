/*Write a script to automate below test steps :
1) Launch Chrome brower
2) Load http://automationbykrishna.com
3) click on Registration link
4) Enter username
5) Enter password
6) Click on submit button
7) verify alter message based on password length
 */

package minu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	private WebDriver driver;

	private void browserSetUp(String url) {
		System.out.println("STEP-Launch Chrome brower");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		System.out.println("STEP-Load URL");
		driver.get(url);
		driver.manage().window().maximize();
	}

	private void enterCredentials(String userName, String password) {
		System.out.println("STEP-Enter username");
		WebElement userNameElement = driver.findElement(By.id("unameSignin"));
		userNameElement.clear();
		userNameElement.sendKeys(userName);

		System.out.println("STEP-Enter password");
		WebElement passwordElement = driver.findElement(By.id("pwdSignin"));
		passwordElement.clear();
		passwordElement.sendKeys(password);

		System.out.println("STEP-Click on submit button");
		driver.findElement(By.id("btnsubmitdetails")).click();
	}

	private String handleAlert() {
		System.out.println("Switch to alert");
		Alert alert = driver.switchTo().alert();

		System.out.println("Get alert text message");
		String actualmessage = alert.getText();

		System.out.println("Accept alert");
		alert.accept();
		return actualmessage;
	}

	private void verifyAlertMessage(String expectedMessage, String actualMessage) {
		if (actualMessage.equals(expectedMessage)) {
			System.out.println("Test Pass");
		} else
			System.out.println("Test Fail");
	}

	void registrationLogin() {
		System.out.println("PREREQUISITE- Browser setup");
		browserSetUp("http://automationbykrishna.com");

		System.out.println("STEP-click on Registration link");
		driver.findElement(By.id("registration2")).click();

		System.out.println("Enter userName,password and click on login button");
		enterCredentials("Minu", "MinuK12345");

		System.out.println("VERIFY - Alert message should be Success!");
		verifyAlertMessage(handleAlert(), "Sucess!");

		System.out.println("VERIFY - Alert message for weak password");

		System.out.println("STEP - Enter Credentials");
		enterCredentials("Minu", "Minu");

		System.out.println("VERIFY - Alert message should be Failed!");
		verifyAlertMessage(handleAlert(), "Failed! please enter strong password");

	}

	public static void main(String[] args) {
		new Assignment1().registrationLogin();
	}
}
