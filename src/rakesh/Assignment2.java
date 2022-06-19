/* Assignment 2 : 14th Jun'2022

Pre-requisite Steps
1)Go to http://automationbykrishna.com/
2)Go to on Basic Elements tab.

Program 1
1)Click on Alert button.
2)Check that alert pop up appears.
3)Check the alert msg "You must be TechnoCredits student!!"
4)Click OK to accept the alert.
*/

/*
Program 2
1)Click on Javascript Confirmation button.
2)Check that alert pop up appears.
3)Check the alert msg "Are you are doing your homework regularly, Press Okay else Cancel!!"
4)Click OK to accept the alert.
5)Check that msg appears "You pressed OK!" because OK button is clicked.

Program 3
1)Again Click on Javascript Confirmation button.
3)Check the alert msg "Are you are doing your homework regularly, Press Okay else Cancel!!"
4)Click Cancel to dismiss the alert.
5)Check that msg appears "You pressed Cancel!" because cancel button is clicked.

Program 4
Write a script to automate below test steps :

1) Launch Chrome brower
2) Load http://automationbykrishna.com
3) click on Basic Element link
4) Enter firstName
5) Enter lastName
6) Enter compantyName
7) click on Submit button
8) Handle alert
9) verify alert message using firstName, lastName, compantyName

Program 5
Write a script to automate below test steps :

1) Launch Chrome brower
2) Load http://automationbykrishna.com
3) click on Basic Element link
4) enter Email Address
5) Enter password
6) Click on submit button
7) Handle alert
8) verify alert message
 */
package rakesh;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Assignment2 {

	WebDriver driver = PreReq.setUp();
	
	void alert() {
		driver.findElement(By.id("javascriptAlert")).click();
		Alert alert = driver.switchTo().alert();
		if (alert.getText().equals("You must be TechnoCredits student!!"))
			System.out.println("STEP PASSED - Alert msg found OK.");
		else
			System.out.println("STEP FAILED - Alert msg not matching.");			
		alert.accept();
	}
	
	void basicElements() {
		driver.findElement(By.id("basicelements")).click();
	}
	
	void javaScriptConfirmationbutton(String input) {
		driver.findElement(By.id("javascriptConfirmBox")).click();
		Alert alert = driver.switchTo().alert();
		
		if (alert.getText().equals("Are you are doing your homework regularly, Press Okay else Cancel!!"))
			System.out.println("JavaScript Confirmation msg found OK. ");
		else
			System.out.println("STEP FAILED - msg not matching.");
		
		if (input.equals("Ok")) {
			alert.accept();
			System.out.println("Clicked OK to accept the alert.");
			if (driver.findElement(By.id("pgraphdemo")).getText().equals("You pressed OK!"))
				System.out.println("STEP PASSED - msg appears \"You pressed OK!\" because OK button is clicked.");
			else
				System.out.println("STEP FAILED - msg not matching.");
		}
		else if (input.equals("Cancel")) {
			 alert.dismiss();
			 System.out.println("Clicked Cancel to dismiss the alert.");
			 if (driver.findElement(By.id("pgraphdemo")).getText().equals("You pressed Cancel!"))
					System.out.println("STEP PASSED - msg appears \"You pressed Cancel!\" because cancel button is clicked.");
				else
					System.out.println("STEP FAILED - msg not matching.");
		}
	}
	
	void enterDetails(String fName, String lName, String cName) {
		driver.findElement(By.name("ufname")).sendKeys(fName);
		driver.findElement(By.name("ulname")).sendKeys(lName);
		driver.findElement(By.name("cmpname")).sendKeys(cName);
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();
		Alert alert = driver.switchTo().alert();
		if (alert.getText().equals(fName + " and " + lName + " and " + cName ))
			System.out.println("STEP PASSED - verify alert message using firstName, lastName, compantyName ");
		else
			System.out.println("STEP FAILED - msg not matching.");
		
		alert.accept();
	}
	
	void enterBasicForm(String email, String password) {
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();
		Alert alert = driver.switchTo().alert();
		if (alert.getText().equals("You successfully clicked on it"))
			System.out.println("STEP PASSED - verified the alert message");
		else
			System.out.println("STEP FAILED - msg not matching.");
		
		alert.accept();
	}

	
	public static void main(String[] args) {
		Assignment2 obj = new Assignment2();
		System.out.println("\n======> Selenium Assignment 2 Program 1 <==========");
		obj.basicElements();
		obj.alert();
		System.out.println("\n======> Selenium Assignment 2 Program 2 <==========");
		obj.javaScriptConfirmationbutton("Ok");
		System.out.println("\n======> Selenium Assignment 2 Program 3 <==========");
		obj.javaScriptConfirmationbutton("Cancel");
		System.out.println("\n======> Selenium Assignment 2 Program 4 <==========");
		obj.enterDetails("Rakesh", "Borse", "Dassault Systems");
		System.out.println("\n======> Selenium Assignment 2 Program 5 <==========");
		obj.enterBasicForm("rhborse@gmail.com", "123456789");
	}

}
