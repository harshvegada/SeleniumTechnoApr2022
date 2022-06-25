package bhushan;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_SE_2 {

	void waitTime(int val) {
		try {
			Thread.sleep(val);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//****************************Program 1*********************************************************//
//	Program 1
//	1)Click on Alert button.
//	2)Check that alert pop up appears.
//	3)Check the alert msg "You must be TechnoCredits student!!"
//	4)Click OK to accept the alert.	
	
	void validateAlertButtunfunctionality() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.id("basicelements")).click();
		waitTime(3000);
		System.out.println("Scroll Down");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,750)", "");
		System.out.println("Click on Alert");
		driver.findElement(By.id("javascriptAlert")).click();
		waitTime(3000);
		Alert alert = driver.switchTo().alert();
		String actualMsg = alert.getText();
		alert.accept();
		System.out.println("Verifying Alert Message");
		String expectedMsg ="You must be TechnoCredits student!!";
		if(actualMsg.equals(expectedMsg)) {
			System.out.println("TestCase Pass");
		}else {
			System.out.println("TestCase Fail");
		}
	}
	
	//****************************Program 2*********************************************************//
//	Program 2
//	1)Click on Javascript Confirmation button.
//	2)Check that alert pop up appears.
//	3)Check the alert msg "Are you are doing your homework regularly, Press Okay else Cancel!!"
//	4)Click OK to accept the alert.
//	5)Check that msg appears "You pressed OK!" because OK button is clicked.
	
	void validateJavaScriptButtonFunctionalitywithok() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		System.out.println("Click on Basic Elements");
		driver.findElement(By.id("basicelements")).click();
		waitTime(3000);
		System.out.println("Scroll down");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,750)", "");
		waitTime(2000);
		System.out.println("Click on JavaScript confirmation Button");
		driver.findElement(By.id("javascriptConfirmBox")).click();
		System.out.println("Switch alert to Message");
		Alert alert=driver.switchTo().alert();
		System.out.println("click on Ok");
		alert.accept();
		WebElement element=driver.findElement(By.id("pgraphdemo"));
		String opMessage=element.getText();
		String expectedMessage="You pressed OK!";
		System.out.println();
		if(expectedMessage.equals(opMessage)) {
			System.out.println("Test Pass");
			
		}else {
			System.out.println("Test Fail");
		}
		
	}
	//****************************Program 3*********************************************************//
//	Program 3
//	1)Again Click on Javascript Confirmation button.
//	3)Check the alert msg "Are you are doing your homework regularly, Press Okay else Cancel!!"
//	4)Click Cancel to dismiss the alert.
//	5)Check that msg appears "You pressed Cancel!" because cancel button is clicked.

	void validateJavaScriptButtonFunctionalitywithcancel() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		System.out.println("Click on Basic Elements");
		driver.findElement(By.id("basicelements")).click();
		waitTime(3000);
		System.out.println("Scroll down");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,750)", "");
		waitTime(2000);
		System.out.println("Click on JavaScript confirmation Button");
		driver.findElement(By.id("javascriptConfirmBox")).click();
		System.out.println("Switch alert to Message");
		Alert alert=driver.switchTo().alert();
		System.out.println("click on Ok");
		alert.dismiss();
		WebElement element=driver.findElement(By.id("pgraphdemo"));
		String opMessage=element.getText();
		String expectedMessage="You pressed Cancel!";
		System.out.println();
		if(expectedMessage.equals(opMessage)) {
			System.out.println("Test Pass");
			
		}else {
			System.out.println("Test Fail");
		}
		
	}
	
	//****************************Program 4*********************************************************//
//	1) Launch Chrome brower
//	2) Load http://automationbykrishna.com
//	3) click on Basic Element link
//	4) Enter firstName
//	5) Enter lastName
//	6) Enter compantyName
//	7) click on Submit button
//	8) Handle alert
//	9) verify alert message using firstName, lastName, compantyName
	void validateFistNameLastNameAndCompanyName(String fisrtName,String lastName,String compName) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		System.out.println("Click on Basic Elements");
		driver.findElement(By.id("basicelements")).click();
		waitTime(3000);
		System.out.println("Enter first Name");
		driver.findElement(By.id("UserFirstName")).sendKeys(fisrtName);
		waitTime(2000);
		System.out.println("Enter Last Name");
		driver.findElement(By.id("UserLastName")).sendKeys(lastName);
		System.out.println("Enter Company Name");
		waitTime(2000);
		driver.findElement(By.id("UserCompanyName")).sendKeys(compName);
		System.out.println("click on submit");
		waitTime(3000);
		System.out.println("click on submit using xpath");
		driver.findElement(By.xpath("(//button[text() ='Submit'])[1]")).click();
		System.out.println("capture Alert message");
		Alert alert =driver.switchTo().alert();
		String capMsg=alert.getText();
		alert.accept();
		String expectedMsg=(fisrtName+" and "+lastName+" and "+compName);
		if(capMsg.equals(expectedMsg))
			System.out.println("Test Pass");
		else
			System.out.println("Test fail");
		
		
	}
	
	//****************************Program 5*********************************************************//
//	Write a script to automate below test steps :
//
//		1) Launch Chrome brower
//		2) Load http://automationbykrishna.com
//		3) click on Basic Element link
//		4) enter Email Address
//		5) Enter password
//		6) Click on submit button
//		7) Handle alert
//		8) verify alert message
		
	void vaildateBasicformsEmailfunctionality() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		System.out.println("click on Basic element button");
		driver.findElement(By.id("basicelements")).click();
		waitTime(3000);
		System.out.println("enteemailid");
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("bg@gmail.com");
		System.out.println("enter Pwd");
		driver.findElement(By.id("pwd")).sendKeys("123123");
		System.out.println("click on submit");
		waitTime(2000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,550)", "");
		driver.findElement(By.id("submitb2")).click();
		waitTime(2000);
		System.out.println("switch to alert msg");
		Alert alert =driver.switchTo().alert();
		String capMsg=alert.getText();
		alert.accept();
		String expectedMsg="You successfully clicked on it";
		System.out.println("compare msg");
		if(capMsg.equals(expectedMsg))
			System.out.println("Test pass");
		else
			System.out.println("Test fail");
		
	}
	
	
	
	public static void main(String[] args) {
		Assignment_SE_2 ass2=new Assignment_SE_2();
		ass2.validateAlertButtunfunctionality();
		System.out.println("Program 2");
		ass2.validateJavaScriptButtonFunctionalitywithok();
		System.out.println("Program 3");
		ass2.validateJavaScriptButtonFunctionalitywithcancel();
		System.out.println("Program 4");
		ass2.validateFistNameLastNameAndCompanyName("Bhushan", "Gadakh", "Vist");
		System.out.println("Program 5");
		ass2.vaildateBasicformsEmailfunctionality();
	}
	
}
