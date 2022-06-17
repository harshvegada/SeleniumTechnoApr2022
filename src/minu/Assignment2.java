/*Pre-requisite Steps
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
8) verify alert message
 */

package minu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	private WebDriver driver;

	private void browserSetUp(String url) {
		System.out.println("STEP-Launch Chrome brower");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		System.out.println("STEP-Load URL");
		driver.get(url);
		driver.manage().window().maximize();
	}

	void basicElementsHandle() {
		System.out.println("PREREQUISITE- Browser setup");
		browserSetUp("http://automationbykrishna.com");

		System.out.println("PREREQUISITE-Navigate to Basic Elements tab");
		driver.findElement(By.id("basicelements")).click();
	}

	private void verifyAlertMessage(String expectedMessage, String actualMessage) {
		if (actualMessage.equals(expectedMessage)) {
			System.out.println("Test Pass");
		} else
			System.out.println("Test Fail");
	}

	private void verifyAlertButton() {
		System.out.println("STEP-Click on Alert button.");
		WebElement element = driver.findElement(By.id("javascriptAlert"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();

		System.out.println("STEP-Check that alert pop up appears.");
		Alert alert = driver.switchTo().alert();
		System.out.println("Get alert text message");
		String actualMessage = alert.getText();
		String expectedMessage = "You must be TechnoCredits student!!";

		verifyAlertMessage(expectedMessage, actualMessage);

		System.out.println("STEP-Click OK to accept the alert.");
		alert.accept();
	}

	void verifyConfirmationButtonOK() {
		System.out.println("STEP-Click on Javascript Confirmation button.");
		driver.findElement(By.id("javascriptConfirmBox")).click();

		System.out.println("STEP-Check that alert pop up appears.");
		Alert alert = driver.switchTo().alert();
		System.out.println("Get alert text message");
		String actualMessage = alert.getText();
		String expectedMessage = "Are you are doing your homework regularly, Press Okay else Cancel!!";

		System.out.println(
				"STEP-Check the alert msg \"Are you are doing your homework regularly, Press Okay else Cancel!!\"");
		verifyAlertMessage(expectedMessage, actualMessage);

		System.out.println("STEP-Click OK to accept the alert.");
		alert.accept();

		System.out.println("STEP-Check that msg appears \"You pressed OK!\" because OK button is clicked.");
		String confirmationText = driver.findElement(By.id("pgraphdemo")).getText();
		String pageText = "You pressed OK!";
		verifyAlertMessage(pageText, confirmationText);
	}

	void verifyConfirmationButtonCancel() {
		System.out.println("STEP-Click on Javascript Confirmation button.");
		driver.findElement(By.id("javascriptConfirmBox")).click();

		System.out.println("STEP-Check that alert pop up appears.");
		Alert alert = driver.switchTo().alert();
		System.out.println("Get alert text message");
		String actualMessage = alert.getText();
		String expectedMessage = "Are you are doing your homework regularly, Press Okay else Cancel!!";

		System.out.println(
				"STEP-Check the alert msg \"Are you are doing your homework regularly, Press Okay else Cancel!!\"");
		verifyAlertMessage(expectedMessage, actualMessage);

		System.out.println("STEP-Click Cancel to dismiss the alert.");
		alert.dismiss();

		System.out.println("STEP-Check that msg appears \"You pressed Cancel!\" because cancel button is clicked.");
		String confirmationText = driver.findElement(By.id("pgraphdemo")).getText();
		String pageText = "You pressed Cancel!";
		verifyAlertMessage(pageText, confirmationText);
	}

	void verifyJavascriptPromptOK(String name) {
		System.out.println("STEP-Click on Javascript Prompt button.");
		driver.findElement(By.id("javascriptPromp")).click();

		System.out.println("STEP-Check that alert pop up appears.");
		Alert alert = driver.switchTo().alert();
		System.out.println("Enter text message");
		alert.sendKeys(name);
		System.out.println("STEP-Click OK to accept the alert.");
		alert.accept();
		String expectedMessage = "Hello " + name + "! How are you today?";
		String actualMessage = driver.findElement(By.id("pgraphdemo")).getText();

		System.out.println("STEP-Check that msg appears after clicking OK button");
		verifyAlertMessage(expectedMessage, actualMessage);
	}

	void verifyJavascriptPromptCancel(String name) {
		System.out.println("STEP-Click on Javascript Prompt button.");
		driver.findElement(By.id("javascriptPromp")).click();

		System.out.println("STEP-Check that alert pop up appears.");
		Alert alert = driver.switchTo().alert();
		System.out.println("Enter text message");
		alert.sendKeys(name);
		System.out.println("STEP-Click cancel to dismiss the alert.");
		alert.dismiss();
		String expectedMessage = "User cancelled the prompt.";
		String actualMessage = driver.findElement(By.id("pgraphdemo")).getText();

		System.out.println("STEP-Check that msg appears after clicking OK button");
		verifyAlertMessage(expectedMessage, actualMessage);
	}

	void verifyAlertDemoText(String firstName, String lastName, String companyName) {
		System.out.println("STEP-Enter firstName");
		driver.findElement(By.id("UserFirstName")).sendKeys(firstName);

		System.out.println("STEP-Enter lastName");
		driver.findElement(By.id("UserLastName")).sendKeys(lastName);

		System.out.println("STEP-Enter compantyName");
		driver.findElement(By.id("UserCompanyName")).sendKeys(companyName);

		System.out.println("STEP-click on Submit button");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();

		System.out.println("STEP-Handle alert");

		System.out.println("Switch to alert");
		Alert alert = driver.switchTo().alert();
		System.out.println("Get alert text message");
		String actualMessage = alert.getText();
		String expectedMessage = firstName + " and " + lastName + " and " + companyName;

		System.out.println("STEP-verify alert message using firstName, lastName, compantyName");
		verifyAlertMessage(expectedMessage, actualMessage);

		System.out.println("Accept alert");
		alert.accept();
	}

	void verifyBasicFormText(String email, String password) {

		System.out.println("STEP-Enter Email Address");
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(email);

		System.out.println("STEP-Enter password");
		driver.findElement(By.id("pwd")).sendKeys(password);

		System.out.println("STEP-click on Submit button");
		driver.findElement(By.id("submitb2")).click();

		System.out.println("STEP-Handle alert");

		System.out.println("Switch to alert");
		Alert alert = driver.switchTo().alert();
		System.out.println("Get alert text message");
		String actualMessage = alert.getText();
		String expectedMessage = "You successfully clicked on it";

		System.out.println("STEP-verify alert message");
		verifyAlertMessage(expectedMessage, actualMessage);

		System.out.println("Accept alert");
		alert.accept();
	}

	public static void main(String[] args) {
		Assignment2 assignment2 = new Assignment2();
		assignment2.basicElementsHandle();

		System.out.println("\nTestCase-1");
		assignment2.verifyAlertButton();

		System.out.println("\nTestCase-2");
		assignment2.verifyConfirmationButtonOK();

		System.out.println("\nTestCase-3");
		assignment2.verifyConfirmationButtonCancel();

		System.out.println("\nTestCase-4");
		assignment2.verifyJavascriptPromptOK("Minu");

		System.out.println("\nTestCase-5");
		assignment2.verifyJavascriptPromptCancel("Minu");

		System.out.println("\nTestCase-6");
		assignment2.verifyAlertDemoText("Minu", "Kumari", "SQS");

		System.out.println("\nTestCase-7");
		assignment2.verifyBasicFormText("minu@gmail.com", "Test1234");
	}
}
