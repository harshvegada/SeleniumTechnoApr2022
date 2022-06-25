package balkrishna;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

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
		Assignment2 ass2 = new Assignment2();

		ass2.preRequisiteSetUp();
		System.out.println("_________________________");

		ass2.alertbutton();
		System.out.println("_________________________");

		ass2.javaScriptConfirmationButtonOK();
		System.out.println("_________________________");

		ass2.javaScrpitConfrimationButtonCancel();
		System.out.println("_________________________");

		String nameInPrompt = "Balkrishna";
		ass2.javaScrpitPromptButton(nameInPrompt);
		System.out.println("_________________________");

		String firstN = "Balkrishna";
		String lastN = "Aware";
		String companyN = "Technocredites";
		ass2.automateAlertDemo(firstN, lastN, companyN);
		System.out.println("_________________________");

		String mail_ID = "Krishnaaware.com";
		String passWord = "Krishna009";
		ass2.automateBasicForms(mail_ID, passWord);

		driver.quit();
	}
}