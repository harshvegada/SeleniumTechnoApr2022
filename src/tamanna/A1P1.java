/* Write a script to automate below test steps :

1) Launch Chrome brower
2) Load http://automationbykrishna.com
3) click on Registration link
4) Enter username
5) Enter password
6) Click on submit button
7) verify alter message based on password length


Login Signup Demo
http://automationbykrishna.com

*/

package tamanna;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A1P1 {

	WebDriver driver;
	
	void setUp(String url) {
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		System.out.println("STEP 1 - Launch Chrome brower");
		driver = new ChromeDriver();
		System.out.println("STEP 2 - Load http://automationbykrishna.com");
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	void setFields(String userName,String password) {
		WebElement userNameElement=driver.findElement(By.id("unameSignin"));
		userNameElement.clear();
		System.out.println("STEP 4 - Enter username");
		userNameElement.sendKeys(userName);
		
		WebElement passwordElement=driver.findElement(By.id("pwdSignin"));
		passwordElement.clear();
		System.out.println("STEP 5 - Enter password");
		passwordElement.sendKeys(password);
		
		System.out.println("STEP 6 - Click on submit button");
		driver.findElement(By.id("btnsubmitdetails")).click();
	}
	
	void closeBrowser() {
		driver.close();
	}
	
	void verifyMessage(String expectedMessage, String actualMessage) {
		if(expectedMessage.equals(actualMessage)) {
			System.out.println("TEST PASS!!");
		}
		else {
			System.out.println("TEST FAILED!!");
		}
	}
	
	String handleAlert() {
		Alert alert=driver.switchTo().alert();
		String actualMessage=alert.getText();
		alert.accept();
		return actualMessage;
	}
	
	void staticWait(int miliSec) {
		try {
			Thread.sleep(miliSec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void testSteps() {
		
		System.out.println("Setup");
		setUp("http://automationbykrishna.com");
		
		System.out.println("STEP 3 - click on Registration link");
		driver.findElement(By.id("registration2")).click();
		staticWait(5000);
		
		setFields("tamanna", "abc123456");
		verifyMessage(handleAlert(), "Success!");
		
		setFields("tamanna", "abc1");
		verifyMessage(handleAlert(), "Success!");
		
		setFields("tamanna", "abc1");
		verifyMessage(handleAlert(), "Failed! please enter strong password");
		
		closeBrowser();
	}
	
	public static void main(String[] args) {
		A1P1 a1P1=new A1P1();
		a1P1.testSteps();
	}
}
