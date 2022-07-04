/*
 * /*Assignment-1 : 12th Jun'2022 

Write a script to automate below test steps :

1) Launch Chrome brower
2) Load http://automationbykrishna.com
3) click on Registration link
4) Enter username
5) Enter password
6) Click on submit button
7) verify alter message based on password length*/
 

package shaila;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.ActionMapUIResource;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_1 {
	public static WebDriver driver=null;
	
	void setup(String url) {
		System.out.println("Step - Launch Chrome brower");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Step - get/load url");
		driver.get(url);
		driver.manage().window().maximize();
	}

	String handleAlertMessage() {
		Alert alert =driver.switchTo().alert();
		String actualMessage =alert.getText();
		alert.accept();
		return actualMessage;
	}
	
	void enterCreadiantial(String user, String pass) {
		System.out.println("Implicit wait for Webelements to load");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		System.out.println("Step -click on Registration link");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		
		System.out.println("Step -Enter UserName");
		WebElement username= driver.findElement(By.id("unameSignin"));
		username.clear();
		username.sendKeys(user);
		System.out.println("Step -Enter Password");
		WebElement password = driver.findElement(By.xpath("//input[@id='pwdSignin']"));
		password.clear();
		password.sendKeys(pass);
	
		System.out.println("Step -Click on Submit button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
	}
	
	void testResult(String expectedMessage,String actualMessage) {

		if (expectedMessage.equals(actualMessage))
			System.out.println("Pass");
		else
			System.out.println("Fail");
	}
	
	
	void registrationAndLogin() {
		setup("http://automationbykrishna.com/");
	
		System.out.println("TEST Case:--> 1");
		enterCreadiantial("mkanani","123457781");
		String expectedMessage="Success!";
		testResult(expectedMessage, handleAlertMessage());
		
		System.out.println("TEST Case:--> 2 :Weak Password");
		expectedMessage="Failed! please enter strong password";
		enterCreadiantial("mkanani","1234");
		testResult(expectedMessage, handleAlertMessage());
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		Assignment_1 assignment_1 =new Assignment_1();
		assignment_1.registrationAndLogin();
		driver.close();
	}
	
	}
