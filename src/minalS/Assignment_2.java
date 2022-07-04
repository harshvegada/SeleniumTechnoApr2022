package minalS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Assignment_2 {
	private WebDriver driver;

	void launchBrowser(String url) {
		System.out.println("STEP - Launch Chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("STEP - Load URL");
		driver.get(url);
		driver.manage().window().maximize();
		
		System.out.println("STEP- Click on Basic Element");
		driver.findElement(By.id("basicelements")).click();
	}

	/*
	 * ///Program 1 --> 1)Click on Alert button. 2)Check that alert pop up appears.
	 * 3)Check the alert msg "You must be TechnoCredits student!!" 4)Click OK to
	 * accept the alert.
	 */

	void checkAlert() {
		

		System.out.println("STEP- Click on Alert");
		driver.findElement(By.id("javascriptAlert")).click();

		System.out.println("Switch to alert");
		Alert alert = driver.switchTo().alert();
		System.out.println("Get Alert text");
		String actualMessage = alert.getText();
		if (actualMessage.equals("You must be TechnoCredits student!!")) {
			System.out.println("Test pass");
		} else {
			System.out.println("Test fail");
		}
		System.out.println("Accept alert");
		alert.accept();
	}

	/*
	 * Program 2 1)Click on Javascript Confirmation button. 2)Check that alert pop
	 * up appears. 3)Check the alert msg
	 * "Are you are doing your homework regularly, Press Okay else Cancel!!" 4)Click
	 * OK to accept the alert. 5)Check that msg appears "You pressed OK!" because OK
	 * button is clicked.
	 */

	void checkConfirmationButtonAccept() {
		System.out.println("STEP- Click on Javascript confirmation button");
		driver.findElement(By.id("javascriptConfirmBox")).click();
		System.out.println("Switch to alert");
		Alert alert = driver.switchTo().alert();
		System.out.println("Get Alert text");
		String actualMessage = alert.getText();
		if (actualMessage.equals("Are you are doing your homework regularly, Press Okay else Cancel!!")) {
			System.out.println("Test pass");
		} else {
			System.out.println("Test fail");
		}
		System.out.println("Accept alert");
		alert.accept();
		System.out.println("STEP- Check msg appears \"You pressed OK \"");
		WebElement paragraphText = driver.findElement(By.id("pgraphdemo"));
		String textMessage = paragraphText.getText();
		if (textMessage.equals("You pressed OK")) {
			System.out.println("Test pass");
		} else {
			System.out.println("Test fail");
		}

	}

	/*
	 * Program 3 1)Again Click on Javascript Confirmation button. 3)Check the alert
	 * msg "Are you are doing your homework regularly, Press Okay else Cancel!!"
	 * 4)Click Cancel to dismiss the alert. 5)Check that msg appears
	 * "You pressed Cancel!" because cancel button is clicked.
	 */

	void checkConfirmationDismiss() {
		System.out.println("STEP- Click on Javascript confirmation button");
		driver.findElement(By.id("javascriptConfirmBox")).click();
		System.out.println("Switch to alert");
		Alert alert = driver.switchTo().alert();

		System.out.println("Dismiss alert");
		alert.dismiss();
		System.out.println("STEP- Check msg appears \"You pressed Cancel! \"");
		WebElement paragraphText = driver.findElement(By.id("pgraphdemo"));
		String textMessage = paragraphText.getText();
		if (textMessage.equals("You pressed Cancel!")) {
			System.out.println("Test pass");
		} else {
			System.out.println("Test fail");
		}
	}

	/*
	 * Program 4 Write a script to automate below test steps :
	 * 
	 * 1) Launch Chrome brower 2) Load http://automationbykrishna.com 3) click on
	 * Basic Element link 4) Enter firstName 5) Enter lastName 6) Enter compantyName
	 * 7) click on Submit button 8) Handle alert 9) verify alert message using
	 * firstName, lastName, compantyName
	 */
	void checkAlertDemo(String firstName, String lastName, String companyName) {
		//launchBrowser("http://automationbykrishna.com");
		//driver.findElement(By.id("basicelements")).click();
		System.out.println("STEP - Enter username");
		WebElement usernameElement = driver.findElement(By.id("UserFirstName"));
		usernameElement.sendKeys(firstName);

		System.out.println("STEP - Enter last name");
		WebElement lastnameElement = driver.findElement(By.id("UserLastName"));
		lastnameElement.sendKeys(lastName);

		System.out.println("STEP - Enter company name");
		WebElement companynameElement = driver.findElement(By.id("UserCompanyName"));
		companynameElement.sendKeys(companyName);
		System.out.println("STEP - Click on submit button");
		driver.findElement(By.xpath("//*[text()='Submit']")).click();///// *[text()='Submit']

		Alert alert = driver.switchTo().alert();
		System.out.println("Get Alert text");
		String actualMessage = alert.getText();
		if (actualMessage.equals("Minal" + " name " + " Shende" + " and" + " Globant ")) {
			System.out.println("Test pass");
		} else {
			System.out.println("Test fail");
		}

		System.out.println("Accept alert");
		alert.accept();
	}

	/*
	 * Program 5 Write a script to automate below test steps :
	 * 
	 * 1) Launch Chrome brower 2) Load http://automationbykrishna.com 3) click on
	 * Basic Element link 4) enter Email Address 5) Enter password 6) Click on
	 * submit button 7) Handle alert 8) verify alert message
	 */
	void checkBasicForm(String emailId, String password) {
		//launchBrowser("http://automationbykrishna.com");
		driver.findElement(By.id("basicelements")).click();

		System.out.println("STEP - Enter Email Address");
		WebElement userEmailElement = driver.findElement(By.id("exampleInputEmail1"));
		userEmailElement.sendKeys(emailId);

		System.out.println("STEP - Enter password");
		WebElement userpasswordElement = driver.findElement(By.id("pwd"));
		userpasswordElement.sendKeys(password);

		System.out.println("STEP - Click on submit button");
		driver.findElement(By.id("submitb2")).click();

		Alert alert = driver.switchTo().alert();
		System.out.println("Get Alert text");
		String actualMessage = alert.getText();
		if (actualMessage.equals("You successfully clicked on it")) {
			System.out.println("Test pass");
		} else {
			System.out.println("Test fail");
		}

		System.out.println("Accept alert");
		alert.accept();
	}

	public static void main(String[] args) {
		Assignment_2 assignment2 = new Assignment_2();
		assignment2.launchBrowser("http://automationbykrishna.com");
		System.out.println("=======================Program1=========================");
		assignment2.checkAlert();
		System.out.println("=======================Program2=========================");
		assignment2.checkConfirmationButtonAccept();
		System.out.println("=======================Program3=========================");
		assignment2.checkConfirmationDismiss();
		System.out.println("=======================Program4=========================");
		assignment2.checkAlertDemo("Minal", "Shende", "Globant");
		System.out.println("=======================Program5=========================");
		assignment2.checkBasicForm("minalShende@gmail.com", "bfsdthf56@56");

	}
}
