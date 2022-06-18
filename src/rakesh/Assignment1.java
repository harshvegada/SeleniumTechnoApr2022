/* Assignment-1 : 12th Jun'2022 

Write a script to automate below test steps :

1) Launch Chrome browser
2) Load http://automationbykrishna.com
3) click on Registration link
4) Enter username
5) Enter password
6) Click on submit button
7) verify alert message based on password length
 */
package rakesh;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Assignment1 {

	WebDriver driver = PreReq.setUp();
	
	void enterUserNamePassword(String uName, String pWord) {
		WebElement userName = driver.findElement(By.id("unameSignin"));
		userName.clear();
		userName.sendKeys(uName);
		WebElement password = driver.findElement(By.id("pwdSignin"));
		password.clear();
		password.sendKeys(pWord);
		driver.findElement(By.id("btnsubmitdetails")).click();
	}
	void registration () {
		driver.findElement(By.id("registration2")).click();
		System.out.println("Click on Registration link");
		System.out.println("Passowrd less than 9 char");
		enterUserNamePassword("Rakesh","123");		
		checkFailedAlert();
		System.out.println("Passowrd greater than 8 char");
		enterUserNamePassword("Rakesh","123456789");		
		checkPassedAlert();	
	}
	
	void checkFailedAlert() {
		Alert alert = driver.switchTo().alert();
		if (alert.getText().equals("Failed! please enter strong password"))
				System.out.println("STEP PASSED - verify alert message based on password length");
		else
			System.out.println("STEP 1 FAILED");
		alert.accept();
	}
	
	void checkPassedAlert() {
		Alert alert = driver.switchTo().alert();
		if (alert.getText().equals("Success!"))
				System.out.println("STEP PASSED - verify alert message based on password length");
		else
			System.out.println("STEP 2 FAILED");
		alert.accept();
	}
	
	public static void main(String[] args) {
		Assignment1 obj = new Assignment1();
		System.out.println("======> Selenium Assignment 1 <==========");
		obj.registration();

	}

}
