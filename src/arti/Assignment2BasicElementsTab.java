package arti;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2BasicElementsTab {

	private WebDriver driver;

	void setUp(String url) {

		System.out.println("STEP - Launch Chrome brower");

		System.setProperty("webdriver.chrome.driver", "C:\\Technocredit\\SeleniumTechnoApr2022\\drivers\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		System.out.println("\nSTEP - Load URL");
		driver.get(url);

		driver.manage().window().maximize();
	}

	void verifyAlertMessage(String actualMsg, String expectedMsg) {

		if (actualMsg.equals(expectedMsg))
			System.out.println("\nRESULT - Test Pass!!");
		else
			System.out.println("\nRESULT - Test Fail");
	}

	void basicElementsTab() {

		System.out.println("\nPREREQUISITE - Browser Setup");

		setUp("http://automationbykrishna.com");

		System.out.println("\nSTEP - Go to Basic Elements tab");

		driver.findElement(By.id("basicelements")).click();
	}

	void handleAlerts() {

		System.out.println("\nSTEP - Click on the Alert button");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement alertElement = driver.findElement(By.id("javascriptAlert"));

		js.executeScript("arguments[0].scrollIntoView();", alertElement);

		alertElement.click();

		System.out.println("\nSTEP - Alert popup appears");

		Alert alert = driver.switchTo().alert();

		String actualMsg = alert.getText();

		String expectedMsg = "You must be TechnoCredits student!!";

		verifyAlertMessage(actualMsg, expectedMsg);

		System.out.println("\nClick on Ok to accept alert");
		alert.accept();
	}

	void handleJavaScriptConfirmationOK() {

		System.out.println("\nSTEP - Click on Javascript Confirmation button");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement element = driver.findElement(By.id("javascriptConfirmBox"));
		js.executeScript("arguments[0].scrollIntoView();", element);

		element.click();

		System.out.println("\nSTEP - JavaScript Confirmation Popup appears");

		Alert alert = driver.switchTo().alert();

		String actualMsg = alert.getText();

		String expectedMsg = "Are you are doing your homework regularly, Press Okay else Cancel!!";

		verifyAlertMessage(actualMsg, expectedMsg);

		alert.accept();

		WebElement paraElement = driver.findElement(By.id("pgraphdemo"));

		String actualMsgOnOK = paraElement.getText();

		String expectedMsgOnOK = "You pressed OK!";

		System.out.println("\nSTEP - Check that msg appears - You pressed OK! because OK button is clicked");

		verifyAlertMessage(actualMsgOnOK, expectedMsgOnOK);
	}

	void handleJavaScriptConfirmationCancel() {

		System.out.println("\nSTEP - Click on Javascript Confirmation button");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement element = driver.findElement(By.id("javascriptConfirmBox"));
		js.executeScript("arguments[0].scrollIntoView();", element);

		element.click();

		System.out.println("\nSTEP - JavaScript Confirmation Popup appears");

		Alert alert = driver.switchTo().alert();

		String actualMsg = alert.getText();

		String expectedMsg = "Are you are doing your homework regularly, Press Okay else Cancel!!";

		System.out.println(
				"\nSTEP - Check the alert msg - Are you are doing your homework regularly, Press Okay else Cancel!!");

		verifyAlertMessage(actualMsg, expectedMsg);

		System.out.println("\nSTEP - Click on the Cancel button to cancel the Alert window");
		alert.dismiss();

		WebElement paraElement = driver.findElement(By.id("pgraphdemo"));

		String actualMsgOnCancel = paraElement.getText();

		String expectedMsgOnCancel = "You pressed Cancel!";

		System.out.println("\nSTEP - Check that msg appears - You pressed Cancel! because Cancel button is clicked");

		verifyAlertMessage(actualMsgOnCancel, expectedMsgOnCancel);
	}

	void verifyBasicElementsAlertDemoForm(String firstName, String lName, String compName) {

		System.out.println("\nSTEP - Enter First Name");
		WebElement userName = driver.findElement(By.id("UserFirstName"));
		userName.clear();
		userName.sendKeys(firstName);

		System.out.println("\nSTEP - Enter Last Name");
		WebElement lastName = driver.findElement(By.id("UserLastName"));
		lastName.clear();
		lastName.sendKeys(lName);

		System.out.println("\nSTEP - Enter Company Name");
		WebElement companyName = driver.findElement(By.id("UserCompanyName"));
		companyName.clear();
		companyName.sendKeys(compName);

		System.out.println("\nSTEP - Click on the Submit button");
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();

		Alert alert = driver.switchTo().alert();

		String actualMsg = alert.getText();

		String expectedMsg = firstName + " and " + lName + " and " + compName;

		verifyAlertMessage(actualMsg, expectedMsg);

		System.out.println("\nSTEP - Click on Ok to accept the Alert");

		alert.accept();
	}

	void verifyAlertMsgForEmailAndPasswordBasicForm(String emailAddress, String pwd) {

		System.out.println("\nSTEP - Enter the Email address");

		WebElement emailID = driver.findElement(By.id("exampleInputEmail1"));
		emailID.clear();
		emailID.sendKeys(emailAddress);

		System.out.println("\nSTEP - Enter the password");
		WebElement password = driver.findElement(By.id("pwd"));
		password.clear();
		password.sendKeys(pwd);

		System.out.println("\nSTEP - Click on the Submit button");
		driver.findElement(By.id("submitb2")).click();

		Alert alert = driver.switchTo().alert();

		String actualMsg = alert.getText();

		String expectedMsg = "You successfully clicked on it";

		verifyAlertMessage(actualMsg, expectedMsg);

		System.out.println("\nSTEP - Click on Ok to accept Alert");
		alert.accept();
	}

	public static void main(String[] args) {

		Assignment2BasicElementsTab a2 = new Assignment2BasicElementsTab();

		a2.basicElementsTab();

		System.out.println("*****************************************************************************************");
		System.out.println("\nTestCase 1 - Verify Alert button");
		a2.handleAlerts();

		System.out.println("\n*****************************************************************************************");
		System.out.println("\nTestCase 2 - Verify JavaScriptConfirmation OK button");
		a2.handleJavaScriptConfirmationOK();

		System.out.println("\n*****************************************************************************************");
		System.out.println("\nTestCase 3 - Verify JavaScriptConfirmation Cancel button");
		a2.handleJavaScriptConfirmationCancel();

		System.out.println("\n*****************************************************************************************");
		System.out.println("\nTestCase 4 - Verify Alert Demo form");
		a2.verifyBasicElementsAlertDemoForm("Arti", "Shinde", "BMC Software");

		System.out.println("\n*****************************************************************************************");
		System.out.println("\nTestCase 5 - Verify Basic Form");
		a2.verifyAlertMsgForEmailAndPasswordBasicForm("artishinde@gmail.com", "test@1234");

		System.out.println("\n*****************************************************************************************");
	}
}
