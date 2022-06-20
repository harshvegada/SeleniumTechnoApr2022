/* Assignment 2 : 14th Jun'2022
Pre-requisite Steps
1)Go to http://automationbykrishna.com/
2)Go to on Basic Elements tab.
Program 1
1)Click on Alert button.
2)Check that alert pop up appears.
3)Check the alert msg "You must be TechnoCredits student!!"
4)Click OK to accept the alert.
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
8) verify alert message*/

package sachinP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2_Alert {

	WebDriver driver;

	void preRequisites(String url) {
		System.out.println("STEP - Launch browser");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP - Get url");
		driver.get(url);
		System.out.println("STEP - Go to Basic Elements tab");
		driver.findElement(By.id("basicelements")).click();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	}

	String acceptAlert() {
		Alert alert = driver.switchTo().alert();
		System.out.println("Get alert text");
		String message = alert.getText();
		System.out.println("Alert - "+message);
		System.out.println("STEP - accept alert");
		alert.accept();
		return message;
	}

	String dismissAlert() {
		Alert alert = driver.switchTo().alert();
		//System.out.println("Get alert text");
		String message = alert.getText();
		System.out.println("Alert - "+message);
		System.out.println("STEP - dismiss alert");
		alert.dismiss();
		return message;
	}

	void verifyAlertMessage(String currentMessage, String expectedMessage) {
		if(currentMessage.equals(expectedMessage))
			System.out.println("Alert verification test pass");
		else
			System.out.println("Alert verification test fail");
	}
	void program1() {
		preRequisites("http://automationbykrishna.com/");
		System.out.println("STEP - Click on Alert button");
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.id("javascriptAlert"));
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		element.click();
		System.out.println("STEP - Check alert message");
		verifyAlertMessage(acceptAlert(),"You must be TechnoCredits student!!");
	}

	void program2() {
		//preRequisites("http://automationbykrishna.com/");
		System.out.println("STEP - Click on Javascript Confirmation button");
		WebElement element = driver.findElement(By.id("javascriptConfirmBox"));
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		element.click();
		System.out.println("STEP - Check alert pop up message");
		verifyAlertMessage(acceptAlert(),"Are you are doing your homework regularly, Press Okay else Cancel!!");
		if(driver.findElement(By.id("pgraphdemo")).getText().equals("You pressed OK!")) {
			System.out.println("Clicked on OK button");
		}else if(driver.findElement(By.id("pgraphdemo")).getText().equals("You pressed Cancel!")) {
			System.out.println("Clicked on Cancel button");
		}
		System.out.println("Test case pass");
	}

	void program3() {
		//preRequisites("http://automationbykrishna.com/");
		System.out.println("STEP - Click on Javascript Confirmation button");
		WebElement element = driver.findElement(By.id("javascriptConfirmBox"));
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		element.click();
		System.out.println("STEP - Check alert pop up message");
		verifyAlertMessage(dismissAlert(),"Are you are doing your homework regularly, Press Okay else Cancel!!");
		if(driver.findElement(By.id("pgraphdemo")).getText().equals("You pressed OK!")) {
			System.out.println("Clicked on OK button");
		}else if(driver.findElement(By.id("pgraphdemo")).getText().equals("You pressed Cancel!")) {
			System.out.println("Clicked on Cancel button");
		}
		System.out.println("Test case pass");
	}

	void program4() {
		//preRequisites("http://automationbykrishna.com/");
		System.out.println("STEP - Enter first name");
		driver.findElement(By.id("UserFirstName")).sendKeys("Sachin");
		System.out.println("STEP - Enter last name");
		driver.findElement(By.id("UserLastName")).sendKeys("Pawar");
		System.out.println("STEP - Enter company name");
		driver.findElement(By.id("UserCompanyName")).sendKeys("TechnoCredit");
		System.out.println("STEP - Click on Submit button");
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();
		verifyAlertMessage(acceptAlert(), "Sachin and Pawar and TechnoCredit");
	}

	void program5() {
		//preRequisites("http://automationbykrishna.com/");
		System.out.println("STEP - Enter email address");
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("sachinpawar80@gmail.com");
		driver.findElement(By.id("pwd")).sendKeys("12345");
		driver.findElement(By.id("submitb2")).click();
		verifyAlertMessage(acceptAlert(), "You successfully clicked on it");
	}

	public static void main(String[] args) {
		Assignment2_Alert assignment2 = new Assignment2_Alert();
		System.out.println("<< Program 1 : Test Alert button >>");
		assignment2.program1();

		System.out.println("\n"+"<< Program 2 : Test Javascript Confirmation button - OK button on alert window >>");
		assignment2.program2();

		System.out.println("\n"+"<< Program 3 : Test Javascript Confirmation button - Cancel button on alert window >>");
		assignment2.program3();

		System.out.println("\n"+"<< Program 4 : Test ALERT DEMO window >>");
		assignment2.program4();

		System.out.println("\n"+"<< Program 5 : Test BASIC FORMS window >>");
		assignment2.program5();
		System.out.println("\n"+"<< Successfully End >>");
	}

}