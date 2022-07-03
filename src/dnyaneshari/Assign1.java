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
package dnyaneshari;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assign1 {
	private WebDriver driver;
	void setup(String url) {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
		System.out.println("STEP - Launch Chrome brower");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		System.out.println("STEP - Launch url");
		driver.get(url);
		
	}
	
	void enterCredentials(String username,String password) {
		System.out.println("Enter USername and Password");
		WebElement usernameelement = driver.findElement(By.id("unameSignin"));
		usernameelement.clear();
		usernameelement.sendKeys(username);
		WebElement passwordelement=driver.findElement(By.id("pwdSignin"));
		passwordelement.clear();
		passwordelement.sendKeys(password);
		System.out.println("STEP - Enter password");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
	}
	
	private String handleAlert() {
		Alert alert=driver.switchTo().alert();
		String actualmessage=alert.getText();
		System.out.println(actualmessage);
		alert.accept();
		return actualmessage;
	}
	void verifyAlertMessage(String Expectedmessage,String actualmessage) {
		if(actualmessage.equals(Expectedmessage))
			System.out.println("Success");
		else
			System.out.println("Fail");
	}
     
	 void loginTest() {
		System.out.println("PREREQUISITE - Browser Setup");
		setup("http://automationbykrishna.com");
		
		System.out.println("STEP - click on Registration link");
		driver.findElement(By.id("registration2")).click();
		
		System.out.println("Enter Credentials & click login button");
		enterCredentials("mkanani", "mkanani1234");
		
		System.out.println("VERIFY - Alert message should be Success!");
		verifyAlertMessage("Success!",handleAlert() );
		
        System.out.println("Alert message should be verified for weak password");
		
		System.out.println("STEP - Enter Credentials");
		enterCredentials("mkanani", "123");
		
		System.out.println("VERIFY - Alert message should be Success!");
		verifyAlertMessage("Failed! please enter strong password",handleAlert());
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Assign1 assign1=new Assign1();
		assign1.loginTest();

	}

}
