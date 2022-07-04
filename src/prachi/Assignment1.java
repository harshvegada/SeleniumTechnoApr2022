/*Assignment-1 : 12th Jun'2022 

Write a script to automate below test steps :

1) Launch Chrome brower
2) Load http://automationbykrishna.com	
3) click on Registration link
4) Enter username
5) Enter password
6) Click on submit button
7) verify alter message based on password length
 */


package prachi;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {
	
	WebDriver driver;

	void setUp(String url ) {
		System.out.println("STEP - Launch Chrome Browser");
		System.setProperty("webdriver.chrome.driver", "D:\\Java Class\\technocredits\\SeleniumTechnoApr2022\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP - Load http://automationbykrishna.com/");
		driver.get(url);
	}
	
	void fastWait(int time) {
		try {
			Thread.sleep(time);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	void enterCredentials(String username, String password) {
		WebElement unameElement = driver.findElement(By.id("unameSignin"));
		WebElement passwordElement = driver.findElement(By.id("pwdSignin"));
		System.out.println("STEP - Enter username");
		unameElement.clear();
		unameElement.sendKeys(username);
		System.out.println("STEP - Enter password");
		passwordElement.clear();
		passwordElement.sendKeys(password);
		System.out.println("STEP - Click on submit button");
		driver.findElement(By.id("btnsubmitdetails")).click();
		
	}
	
	String handleAlert() {
		Alert alert = driver.switchTo().alert();
		System.out.println("Get alert text");
		String currentMessage = alert.getText();
		System.out.println("Alert - "+currentMessage);
		alert.accept();
		return currentMessage;
	}
	
	void verifyAlertMessage(String currentMessage, String expectedMessage) {
		if(currentMessage.equals(expectedMessage))
			System.out.println("Test pass");
		else
			System.out.println("Test fail");
	}
	void loginProcess() {
		System.out.println("Setup Prerequisites");
		setUp("http://automationbykrishna.com/");
		System.out.println("STEP - Click on Registration link");
		driver.findElement(By.id("registration2")).click();
		fastWait(3000);
		System.out.println("Enter Credentials");
		enterCredentials("mkanani","mkanani1234");
		System.out.println("STEP - Verify alert message");
		verifyAlertMessage(handleAlert(),"Success!");
		System.out.println("Enter credentials");
		enterCredentials("mkanani","1234");
		System.out.println("STEP - Verify alert message");
		verifyAlertMessage(handleAlert(),"Failed! please enter strong password");
	}
	 
	public static void main(String[] args) {
		Assignment1 login = new Assignment1();
		login.loginProcess();
	}
}
