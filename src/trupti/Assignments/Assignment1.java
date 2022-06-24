package trupti.Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {
	void alertTest(WebDriver driver, String expectedAlertText) {
		System.out.println("STEP- Switch to Alert");
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		if (alertText.equals(expectedAlertText))
			System.out.println("Test pass");
		else
			System.out.println("Test fail");
	}

	void setCredentials(WebDriver driver, String useName, String pwd) {

		System.out.println("Enter username");
		WebElement nameElement = driver.findElement(By.id("unameSignin"));
		nameElement.clear();
		nameElement.sendKeys(useName);

		System.out.println("Enter password");
		WebElement passElement = driver.findElement(By.id("pwdSignin"));
		passElement.clear();
		passElement.sendKeys(pwd);

		driver.findElement(By.id("btnsubmitdetails")).click();
	}

	void loginTest(WebDriver driver) {
		System.out.println("click on Registration link");
		WebElement registrationElement = driver.findElement(By.id("registration2"));
		registrationElement.click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);//for wait/sleep

		System.out.println("verify alert message based on strong password ");
		setCredentials(driver, "maulik", "maulik123");
		String expectedAlertText = "Success!";
		alertTest(driver, expectedAlertText);

		System.out.println("verify alert message based on weak password ");
		setCredentials(driver, "maulik", "123");
		expectedAlertText = "Failed! please enter strong password";
		alertTest(driver, expectedAlertText);

		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		System.out.println("Launch Chrome brower");
		WebDriver driver = new ChromeDriver();
		System.out.println("Load  http://automationbykrishna.com");
		driver.get("http://automationbykrishna.com");
		new Assignment1().loginTest(driver);
	}
}
