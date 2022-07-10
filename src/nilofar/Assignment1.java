package nilofar;

/* Write a script to automate below test steps :
1) Launch Chrome brower
2) Load http://automationbykrishna.com
3) click on Registration link
4) Enter username
5) Enter password
6) Click on submit button
7) verify alter message based on password length*/

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	WebDriver driver;

	// Launch Browser
	void launchBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		System.out.println("STEP 1 - Launch Chrome brower");
		driver = new ChromeDriver();// Launch browser
		System.out.println("STEP 2 - Load http://automationbykrishna.com");
		try {
			driver.get(url);

		} catch (Exception e) {
			System.out.println("Please connect your internet.");
		}
		driver.manage().window().maximize();
		fastWait(3000);
		System.out.println("STEP 3 - click on Registration link");
		driver.findElement(By.id("registration2")).click();
	}

	void fastWait(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void setUserNamePwd(String name, String pwd) {
		WebElement userName = driver.findElement(By.id("unameSignin"));
		userName.clear();
		System.out.println("STEP 4 - Enter username");
		userName.sendKeys(name);
		WebElement password = driver.findElement(By.id("pwdSignin"));
		password.clear();
		System.out.println("STEP 5 - Enter password");
		password.sendKeys(pwd);
		System.out.println("STEP 6 - Click on submit button");
		driver.findElement(By.id("btnsubmitdetails")).click();
		verifyAlertmessage(handleAlert(), "Success!");
	}

	String handleAlert() {
		Alert alert = driver.switchTo().alert();
		String actualMsg = alert.getText();
		alert.accept();
		return actualMsg;
	}

	void verifyAlertmessage(String expectedMsg, String actualMsg) {
		if (expectedMsg.equals(actualMsg)) {
			System.out.println("User Registration Successful!!");
		} else {
			System.out.println("User Registration Failed:-(");
		}
	}

	void closeBrowser() {
		driver.close();
	}

	public static void main(String[] args) {
		Assignment1 test = new Assignment1();
		test.launchBrowser("http://automationbykrishna.com");
		test.fastWait(2000);
		System.out.println("1st attempt");
		test.setUserNamePwd("nilofar", "abc");
		System.out.println("2nd attempt");
		test.setUserNamePwd("nilofar", "Xyz!23456");
		test.closeBrowser();

	}
}
