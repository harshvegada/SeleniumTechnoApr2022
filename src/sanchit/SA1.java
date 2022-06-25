/*Assignment-1 : 12th Jun'2022 

Write a script to automate below test steps :

1) Launch Chrome brower
2) Load http://automationbykrishna.com
3) click on Registration link
4) Enter username
5) Enter password
6) Click on submit button
7) verify alter message based on password length*/

package sanchit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SA1 {

	private static WebDriver driver;

	void hardWait(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void launchChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}

	void loadUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	void loginUnderRegistration(String userName, String password) {
		System.out.println("Step- Navigate to Registration");
		driver.findElement(By.id("registration2")).click();
		hardWait(3000);
		System.out.println("Step- Username: " + userName);
		WebElement elementUserName = driver.findElement(By.id("unameSignin"));
		elementUserName.clear();
		elementUserName.sendKeys(userName);
		System.out.println("Step- Password: " + password);
		WebElement elementPassword = driver.findElement(By.id("pwdSignin"));
		elementPassword.clear();
		elementPassword.sendKeys(password);
		System.out.println("Step- Submit");
		driver.findElement(By.id("btnsubmitdetails")).click();
	}

	private String alertHandle() {
		Alert alert = driver.switchTo().alert();
		System.out.println("Get Alert text");
		String alertMessage = alert.getText();
		System.out.println("Accept alert");
		alert.accept();
		System.out.println("Return alert text");
		return alertMessage;
	}

	void alertMsgVerify(String expectedMessage, String actualMessage) {
		if (expectedMessage.equals(actualMessage)) {
			System.out.println("Test Pass, Alert Mesaage: " + actualMessage);
		} else {
			System.out.println("Test Fail, Alert Message: " + actualMessage);
		}
	}

	void loginTest(String userName, String password, String expectedMessage) {
		loginUnderRegistration(userName, password);
		String actualMessage = alertHandle();
		alertMsgVerify(expectedMessage, actualMessage);
	}

	public static void main(String[] args) {
		SA1 sa1 = new SA1();

		System.out.println("Step- Launch Chrome browser");
		sa1.launchChromeBrowser();
		System.out.println("Step- Load URL");
		sa1.loadUrl("http://automationbykrishna.com");

		// Positive scenario
		System.out.println("-----:Verify alert message for strong password:-----");
		sa1.loginTest("mkanani", "mkanani1234", "Success!");
		System.out.println("************************************\n");

		// Negative scenario
		System.out.println("-----:Verify alert message for week password:-----");
		sa1.loginTest("mkanani", "mkan", "Success!");
		
		driver.quit();
	}
}
