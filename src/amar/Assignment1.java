/*
 * Assignment-1 : 12th Jun'2022 

Write a script to automate below test steps :

1) Launch Chrome brower
2) Load http://automationbykrishna.com
3) click on Registration link
4) Enter username
5) Enter password
6) Click on submit button
7) verify alter message based on password length
 */

package amar;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {
	
	WebDriver driver;
	String url = "http://automationbykrishna.com";	
	
	void loginTest() {
		System.out.println("Prerequisite - Browser setup");
		setUp(url);
		
		driver.findElement(By.id("registration2")).click();
		fastWait(3000);
		
		System.out.println("Enter credentials and click on submit button");
		enterCredentials("maulik", "mkanani1234");
		
		verifyAlertmessage(handleAlert(), "Success!");
		
		System.out.println("Alert message should be verified for incorrect password");
		enterCredentials("mkanani", "123");
		
		System.out.println("VERIFY - Alert message should be Failed!");
		verifyAlertmessage(handleAlert(), "Failed! please enter strong password");
		
		driver.close();
	}
	
	void setUp(String url) {
		
		System.setProperty("webdriver.chrome.driver", "F:\\SeleniumPractice\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	void fastWait(int time) {
		try {
			Thread.sleep(time);
		}catch(InterruptedException e){
			e.printStackTrace();
		}		
	}

	void enterCredentials(String userName, String password) {
		System.out.println("Enter Username");
		WebElement userNameElement = driver.findElement(By.id("unameSignin"));
		userNameElement.clear();
		userNameElement.sendKeys(userName);
		
		System.out.println("Enter Password");
		WebElement userPasswordElement = driver.findElement(By.id("pwdSignin"));
		userPasswordElement.clear();
		userPasswordElement.sendKeys(password);
		
		System.out.println("click on Submit button");
		driver.findElement(By.id("btnsubmitdetails")).click();
	}
	
	void verifyAlertmessage(String actualMessage, String expectedMessage) {
		if(actualMessage.equals(expectedMessage))
			System.out.println(actualMessage+ " - Test Pass");
		else
			System.out.println(actualMessage+ " - Test Fail");
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
	
	public static void main(String[] args) {
		Assignment1 obj = new Assignment1();
		obj.loginTest();
		
	}


}
