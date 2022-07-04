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

package prachi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Assignment2 {
	void alert(WebDriver driver, String expectedMassage) {
		Alert alert = driver.switchTo().alert();
		String cueerntMassage = alert.getText();
		alert.accept();
		if (expectedMassage.equals(cueerntMassage))
			System.out.println("Test pass");
		else
			System.out.println("Test fail");
	}
	
//Program 1
	
	void alertButton(WebDriver driver) {
		driver.findElement(By.id("basicelements")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		JavascriptExecutor js = (JavascriptExecutor) driver;// for scrollDown
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.id("javascriptAlert")).click();
		String expectedMassage = "You must be TechnoCredits student!!";
		alert(driver, expectedMassage);
		
}
	
//Program 2
	
	void javascriptConfirmationOkbutton(WebDriver driver) {
		driver.findElement(By.id("basicelements")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");

		driver.findElement(By.id("javascriptConfirmBox")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,250)", "");

		WebElement element = driver.findElement(By.id("pgraphdemo"));
		String expectedMassage = "You pressed OK!";
		String actualMassage = element.getText();
		if (expectedMassage.equals(actualMassage))
			System.out.println("Test pass");
		else
			System.out.println("Test fail");
	}
	
//Program 3
	
	void javascriptConfirmationCancelbutton(WebDriver driver) {
		driver.findElement(By.id("basicelements")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");

		driver.findElement(By.id("javascriptConfirmBox")).click();
		Alert alert = driver.switchTo().alert();
		alert.dismiss();

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,250)", "");
		
		WebElement element = driver.findElement(By.id("pgraphdemo"));
		String expectedMassage = "You pressed Cancel!";
		String actualMassage = element.getText();
		if (expectedMassage.equals(actualMassage))
			System.out.println("Test pass");
		else
			System.out.println("Test fail");
	}
	
//Program 4
	
	void alertDemo() {
		System.out.println("Lounch a browser");
		System.setProperty("webdriver.chrome.driver", "D:\\Java Class\\technocredits\\SeleniumTechnoApr2022\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.id("basicelements")).click();

		WebElement userName = driver.findElement(By.id("UserFirstName"));
		userName.sendKeys("Prachi");

		WebElement lastName = driver.findElement(By.id("UserLastName"));
		lastName.sendKeys("Jain");

		WebElement companyName = driver.findElement(By.id("UserCompanyName"));
		companyName.sendKeys("TCS");

		driver.findElement(By.xpath("//*[text()='Submit']")).click();
		Alert alert = driver.switchTo().alert();
		String expectedMassage = "Prachi and Jain and TCS";
		String actualMassage = alert.getText();

		if (expectedMassage.equals(actualMassage))
			System.out.println("Test pass");
		else
			System.out.println("Test fail");
		
}
	
//Program 5
	
	void formBasic() {
		System.out.println("Lounch a browser");
		System.setProperty("webdriver.chrome.driver", "D:\\Java Class\\technocredits\\SeleniumTechnoApr2022\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.id("basicelements")).click();

		WebElement emailElement = driver.findElement(By.id("exampleInputEmail1"));
		emailElement.sendKeys("jain.prachi226@gmail.com");

		WebElement passwordElement = driver.findElement(By.id("pwd"));
		passwordElement.sendKeys("09876543");

		driver.findElement(By.id("submitb2")).click();

		Alert alert = driver.switchTo().alert();
		String expectedMassage = "You successfully clicked on it";
		String actualMassage = alert.getText();
		if (expectedMassage.equals(actualMassage))
			System.out.println("Test pass");
		else
			System.out.println("Test fail");

		alert.accept();
		
		}

	public static void main(String[] args)  {
		Assignment2 assignment2 = new Assignment2();
		System.out.println("Lounch a browser");
		System.setProperty("webdriver.chrome.driver", "D:\\Java Class\\technocredits\\SeleniumTechnoApr2022\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		assignment2.alertButton(driver);
		assignment2.javascriptConfirmationOkbutton(driver);
		assignment2.javascriptConfirmationCancelbutton(driver);
		assignment2.alertDemo();
		assignment2.formBasic();
	}
}
