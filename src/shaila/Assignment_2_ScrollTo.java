/*
 * /*Assignment 2 : 14th Jun'2022

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

 


package shaila;

import java.awt.Desktop.Action;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import net.bytebuddy.asm.Advice.Argument;

public class Assignment_2_ScrollTo {
	
	static WebDriver driver=null;
	void setup(String url) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	void verifyScrollElements() {
		/*
		 * Program 1
		1)Click on Alert button.
		2)Check that alert pop up appears.
		3)Check the alert msg "You must be TechnoCredits student!!"
		4)Click OK to accept the alert.
		 */
		System.out.println("Step :->Launch Browser");
		setup("http://automationbykrishna.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Step:->Click on Basic Elements Link");
		driver.findElement(By.linkText("Basic Elements")).click();
		System.out.println("Step:-Click on Alert button");
		WebElement element= driver.findElement(By.xpath("//button[contains(text(),'Alert')]"));
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",element);
		element.click();
		String expectedMessage ="You must be TechnoCredits student!!";
		String actualMessage=handleAlertOK();
		System.out.println("Actual Alert Meesage:"+actualMessage);
		testResult(expectedMessage, actualMessage);
	}
	
	String handleAlertOK() {
		Alert alert =driver.switchTo().alert();
		String actualMessage =alert.getText();
		alert.accept();
		return actualMessage;
	}
	
	String handleAlertCancel() {
		Alert alert =driver.switchTo().alert();
		String actualMessage =alert.getText();
		alert.dismiss();
		return actualMessage;
	}
	
	void testResult(String expected ,String Actual) {
		if(Actual.equals(expected)) 
			System.out.println("TEST PASS");
		else
			System.out.println("TEST FAIL");
	}
	
	
	
	void javascriptConfirmation() {
		System.out.println("Step:-Click on javascriptConfirmation button");
		WebElement javascriptConfirmation =driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']"));
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].ScrollViewInto",javascriptConfirmation);
		javascriptConfirmation.click();
		String expectedMessage ="Are you are doing your homework regularly, Press Okay else Cancel!!";
		String actualMessage=handleAlertOK();
		System.out.println("Expected Alert Message"+expectedMessage);
		System.out.println("Actual Alert Meesage:"+actualMessage);
		testResult(expectedMessage, actualMessage);

		System.out.println("Verify Case2 : msg appears \"You pressed OK!\"");
		actualMessage = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		expectedMessage ="You pressed OK!";
		testResult(expectedMessage,actualMessage);
	
		System.out.println("Verify Case3 : msg appears \"You pressed Cancel!\"");
		javascriptConfirmation.click();
		handleAlertCancel();
		expectedMessage ="You pressed Cancel!";
		actualMessage = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		testResult(expectedMessage, actualMessage);
		
		
	}
	/*
	 * Program 4
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

}*/
	
/*	Program 5
	Write a script to automate below test steps :

	1) Launch Chrome brower
	2) Load http://automationbykrishna.com
	3) click on Basic Element link
	4) enter Email Address
	5) Enter password
	6) Click on submit button
	7) Handle alert
	8) verify alert message*/

void program5() {
	System.out.println("enter Email Address");
	driver.findElement(By.name("emailId")).sendKeys("shailabhoyate@gmail.com");
	System.out.println("Enter password");
	driver.findElement(By.id("pwd")).sendKeys("1234");
	System.out.println(" Click on submit button");
	driver.findElement(By.id("submitb2")).click();
	System.out.println("Handle alert");
	String actualMessage=handleAlertOK();
	System.out.println("verify alert message test Pass");
	testResult("You successfully clicked on it", actualMessage);
}

	
	void program4() {
		System.out.println("STEP - Enter first name");
		driver.findElement(By.id("UserFirstName")).sendKeys("Shaila");
		System.out.println("STEP - Enter Last name");
		driver.findElement(By.id("UserLastName")).sendKeys("More");
		System.out.println("STEP - Enter Company name");
		driver.findElement(By.id("UserCompanyName")).sendKeys("Magic");
		System.out.println("STEP - Click on Submit button");
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();
		System.out.println("Get Alert");
		String actualMessagae =handleAlertOK();
		System.out.println("Alert Message"+actualMessagae);
		System.out.println("Alert verification testcase pass");
		testResult("Shaila and More and Magic", actualMessagae);
	}		
	public static void main(String[] args) {
		System.out.println("===========Program1===================");
		Assignment_2_ScrollTo assignment_2_ScrollTo =new Assignment_2_ScrollTo();
		assignment_2_ScrollTo.verifyScrollElements();
		System.out.println("===========Program2===================");
		assignment_2_ScrollTo.javascriptConfirmation();
		
		System.out.println("========Program4================");
		assignment_2_ScrollTo.program4();
		
		System.out.println("========Program5================");
		assignment_2_ScrollTo.program5();
				 
		
		driver.close();
	}
}
