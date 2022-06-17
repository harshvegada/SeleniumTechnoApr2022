/*Assignment-1 : 12th Jun'2022 
Write a script to automate below test steps :
1) Launch Chrome brower
2) Load http://automationbykrishna.com
3) click on Registration link
4) Enter username
5) Enter password
6) Click on submit button
7) verify alter message based on password length
*/

package sachinP;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {
	private WebDriver driver;
	
	void fastWait(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void enterCreditials(String username, String password) {
		System.out.println("STEP - Enter username");
		WebElement usernameElement = driver.findElement(By.id("unameSignin"));
		usernameElement.clear();
		usernameElement.sendKeys(username);
		
		System.out.println("STEP - Enter password");
		WebElement passwordElement = driver.findElement(By.id("pwdSignin"));
		passwordElement.clear();
		passwordElement.sendKeys("mkanani1234");
		
		System.out.println("STEP - Click on submit button");
		driver.findElement(By.id("btnsubmitdetails")).click();
	}
	
	private String handleAlert() {
		System.out.println("Switch to alter");
		Alert alert = driver.switchTo().alert();
		System.out.println("Get Alert text");
		String actualMessage = alert.getText();
		System.out.println("Accept alert");
		alert.accept();
		return actualMessage;
	}
	
	void verifyAlertMessage(String actualMessage, String expectedMessage) {
		if(actualMessage.equals(expectedMessage))
			System.out.println("Test pass");
		else
			System.out.println("Test fail");
	}
	
	void setUp(String url) {
		System.out.println("STEP - Launch Chrome brower");
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();
		
		System.out.println("STEP - Load URL");
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	void loginTest() {
		System.out.println("PREREQUISITE - Browser Setup");
		setUp("http://automationbykrishna.com");
		
		System.out.println("STEP - click on Registration link");
		driver.findElement(By.id("registration2")).click();
		
		fastWait(3000);
		
		System.out.println("Enter Credentials & click login button");
		enterCreditials("mkanani", "mkanani1234");
		
		System.out.println("VERIFY - Alert message should be Success!");
		verifyAlertMessage(handleAlert(), "Success!");
		
		System.out.println("Alert message should be verified for weak password");
		
		System.out.println("STEP - Enter Credentials");
		enterCreditials("mkanani", "123");
		
		System.out.println("VERIFY - Alert message should be Success!");
		verifyAlertMessage(handleAlert(), "Failed! please enter strong password");
	}
	
	
	public static void main(String[] args) {
		Assignment1 ass1= new Assignment1();
		ass1.loginTest();
	}
}
