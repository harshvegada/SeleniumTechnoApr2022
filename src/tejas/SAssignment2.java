/*Assignment 2 : 14th Jun'2022
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

package tejas;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SAssignment2 {

	private static WebDriver driver;

	void preRequisiteSetUp() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("basicelements")).click();
	}

	void hardWait(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String alertHandle() {
		Alert alert = driver.switchTo().alert();
		System.out.println("Get Alert text");
		String alertMessage = alert.getText();
		System.out.println("Accept alert");
		alert.accept();
		System.out.println("Return alert text");
		return alertMessage;
	}

	void alertMsgVerify(String expectedMessage, String actualMessage) {
		if (expectedMessage.equals(actualMessage)) {
			System.out.println("Test Pass, Alert Mesaage: " + actualMessage);
		} else {
			System.out.println("Test Fail, Alert Message: " + actualMessage);
		}
	}

	// Program 1
	void alertbutton() {
		WebElement elementAlertBtn = driver.findElement(By.id("javascriptAlert"));
		JavascriptExecutor jE = (JavascriptExecutor) driver;
		jE.executeScript("arguments[0].scrollIntoView(true)", elementAlertBtn);
		elementAlertBtn.click();
		Alert alert = driver.switchTo().alert();
		String getAlertMsg = alert.getText();
		if (getAlertMsg.equals("You must be TechnoCredits student!!")) {
			System.out.println("Test Pass : " + getAlertMsg);
		} else {
			System.out.println("Test Fail : " + getAlertMsg);
		}
		alert.accept();
	}

	// Program 2
	void javaScriptConfirmationButtonOK() {
		WebElement elementJSConfirm = driver.findElement(By.id("javascriptConfirmBox"));
		JavascriptExecutor jE = (JavascriptExecutor) driver;
		jE.executeScript("arguments[0].scrollIntoView(true)", elementJSConfirm);
		elementJSConfirm.click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		String alertAcceptText = driver.findElement(By.id("pgraphdemo")).getText();
		if (alertAcceptText.equals("You pressed OK!")) {
			System.out.println("Test Pass : " + alertAcceptText);
		} else {
			System.out.println("Test Fail : " + alertAcceptText);
		}
	}

	// Program 3
	void javaScrpitConfrimationButtonCancel() {
		WebElement elementJSConfirm = driver.findElement(By.id("javascriptConfirmBox"));
		JavascriptExecutor jE = (JavascriptExecutor) driver;
		jE.executeScript("arguments[0].scrollIntoView(true)", elementJSConfirm);
		elementJSConfirm.click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.dismiss();
		String alertAcceptText = driver.findElement(By.id("pgraphdemo")).getText();
		if (alertAcceptText.equals("You pressed Cancel!")) {
			System.out.println("Test Pass : " + alertAcceptText);
		} else {
			System.out.println("Test Fail : " + alertAcceptText);
		}
	}

	// Program 4
	void javaScrpitPromptButton(String nameToBe) {
		WebElement elementJSPrompt = driver.findElement(By.id("javascriptPromp"));
		JavascriptExecutor jE = (JavascriptExecutor) driver;
		jE.executeScript("arguments[0].scrollIntoView(true)", elementJSPrompt);
		elementJSPrompt.click();
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert prompt message: [ " + alert.getText() + " ]");
		alert.sendKeys(nameToBe);
		alert.accept();
		String alertAcceptText = driver.findElement(By.id("pgraphdemo")).getText();
		if (alertAcceptText.equals("Hello " + nameToBe + "! How are you today?")) {
			System.out.println("Test Pass : " + alertAcceptText);
		} else {
			System.out.println("Test Fail : " + alertAcceptText);
		}
	}

	// Program 5
	void automateAlertDemo(String firstName, String lastName, String companyName) {
		WebElement elementFirstName = driver.findElement(By.id("UserFirstName"));
		elementFirstName.sendKeys(firstName);
		WebElement elementLastName = driver.findElement(By.id("UserLastName"));
		elementLastName.sendKeys(lastName);
		WebElement elementCompanyName = driver.findElement(By.id("UserCompanyName"));
		elementCompanyName.sendKeys(companyName);
		WebElement alertDemoSubmit = driver.findElement(By.xpath("//*[text()='Submit']"));
		JavascriptExecutor jE = (JavascriptExecutor) driver;
		jE.executeScript("arguments[0].scrollIntoView(true)", alertDemoSubmit);
		alertDemoSubmit.click();
		String message = alertHandle();
		System.out.println(message);
		alertMsgVerify(firstName + " and " + lastName + " and " + companyName, message);
	}

	// Program 6
	void automateBasicForms(String eMail, String password) {
		WebElement elementEMail = driver.findElement(By.id("exampleInputEmail1"));
		elementEMail.sendKeys(eMail);
		WebElement elementPassword = driver.findElement(By.id("pwd"));
		elementPassword.sendKeys(password);
		driver.findElement(By.id("submitb2")).click();
		String message = alertHandle();
		alertMsgVerify("You successfully clicked on it", message);
	}

	public static void main(String[] args) {
		SAssignment2 sassignment2 = new SAssignment2();

		sassignment2.preRequisiteSetUp();
		System.out.println("_________________________");

		// Program 1
		sassignment2.alertbutton();
		System.out.println("_________________________");

		// Program 2
		sassignment2.javaScriptConfirmationButtonOK();
		System.out.println("_________________________");

		// Program 3
		sassignment2.javaScrpitConfrimationButtonCancel();
		System.out.println("_________________________");

		// Program 4
		String nameInPrompt = "Tejas";
		sassignment2.javaScrpitPromptButton(nameInPrompt);
		System.out.println("_________________________");

		// Program 5
		String firstN = "Tejas";
		String lastN = "Gorde";
		String companyN = "Accenture";
		sassignment2.automateAlertDemo(firstN, lastN, companyN);
		System.out.println("_________________________");

		// Program 6
		String mail_ID = "tejasgorde5@gmail.com";
		String passWord = "TG1234";
		sassignment2.automateBasicForms(mail_ID, passWord);

		driver.quit();
	}
}