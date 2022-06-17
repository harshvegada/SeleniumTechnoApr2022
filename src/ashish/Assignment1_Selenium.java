/*
Assignment-1 : 12th Jun'2022 

Write a script to automate below test steps :

1) Launch Chrome brower
2) Load http://automationbykrishna.com	
3) click on Registration link
4) Enter username
5) Enter password
6) Click on submit button
7) verify alter message based on password length
 */
package ashish;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1_Selenium {
	WebDriver driver = new ChromeDriver();

	void setUp(String url) {
		System.out.println("STEP - Launch Chrome brower");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		System.out.println("STEP - Load URL");
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
	}

	void loginTest() {
		System.out.println("PREREQUISITE - Browser Setup");
		setUp("http://automationbykrishna.com/");

		System.out.println("STEP - click on Registration Link");
		driver.findElement(By.id("registration2")).click();

		fastWait(3000);

		System.out.println("Enter credentials and click on submit button");
		enterCredentials("maulik", "mkanani1234");

		System.out.println("VERIFY - Alert message should be Success!");
		verifyAlertMessage(handleAlert(), "Success!");

		System.out.println("Alert message should be verified for incorrect password");
		System.out.println("Enter Credentials");
		enterCredentials("mkanani", "123");

		System.out.println("VERIFY - Alert message should be Failed!");
		verifyAlertMessage(handleAlert(), "Failed! please enter strong password");

	}

	String handleAlert() {
		System.out.println("Switch to alert");
		Alert alert = driver.switchTo().alert();

		System.out.println("Get Alert text");
		String alertMessage = alert.getText();

		System.out.println("Accept alert");
		alert.accept();

		return alertMessage;
	}

	void verifyAlertMessage(String actualMessage, String expectedMessage) {

		if (actualMessage.equals(expectedMessage))
			System.out.println("Test Pass");
		else
			System.out.println("Test Fail");
	}

	void enterCredentials(String userName, String password) {
		System.out.println("STEP - Enter Username");
		WebElement userNameElement = driver.findElement(By.id("unameSignin"));
		userNameElement.clear();
		userNameElement.sendKeys(userName);

		System.out.println("STEP - Enter Password");
		WebElement userPasswordElement = driver.findElement(By.id("pwdSignin"));
		userPasswordElement.clear();
		userPasswordElement.sendKeys(password);

		System.out.println("STEP - click on Submit button");
		driver.findElement(By.id("btnsubmitdetails")).click();
	}

	void fastWait(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
