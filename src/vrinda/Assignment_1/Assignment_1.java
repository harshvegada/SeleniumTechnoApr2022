package vrinda.Assignment_1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_1 {
	private WebDriver driver;

	public static void main(String[] args)
	{
		Assignment_1 assignment1 = new Assignment_1();
		assignment1.login();
	}

	void login()
	{
		browserLaunch("http://automationbykrishna.com/");
		driver.findElement(By.id("registration2")).click();
		waitTime(5000);
		enterCredentials("vrinda","vrinda1234");
		clickOnSubmitButton();
		String actual = handleAlert();
		verifyAlertMessage(actual,"Success!");

		enterCredentials("Vrinda","123");
		clickOnSubmitButton();
		String actual1 = handleAlert();
		verifyAlertMessage(actual1,"Failed! please enter strong password");




	}
	private void enterCredentials(String userName, String password)
	{
		enterUserName(userName);
		enterPassword(password);

	}

	void browserLaunch(String url)
	{
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}

	void waitTime(int time)
	{
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void enterUserName(String Name)
	{
		WebElement userName = driver.findElement(By.id("unameSignin"));
		userName.clear();
		userName.sendKeys(Name);
	}

	private void enterPassword(String password)
	{
		WebElement enterPassword = driver.findElement(By.id("pwdSignin"));
		enterPassword.clear();
		enterPassword.sendKeys(password);
	}

	private void clickOnSubmitButton()
	{
		WebElement submitButton = driver.findElement(By.id("btnsubmitdetails"));
		submitButton.click();
	}

	private String handleAlert()
	{
		//Switch to alert tab
		Alert alert = driver.switchTo().alert();
		//get alert text
		String actualMessage = alert.getText();
		System.out.println(actualMessage);
		//to accept alert
		alert.accept();
		return actualMessage;
	}

	void verifyAlertMessage(String actualMessage, String expectedMessage)
	{
		if(actualMessage.equals(expectedMessage))
			System.out.println("Test case passed");
		else
			System.out.println("Test case failed");
	}

}
