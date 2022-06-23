/*Program 5
Write a script to automate below test steps :

1) Launch Chrome brower
2) Load http://automationbykrishna.com
3) click on Basic Element link
4) enter Email Address
5) Enter password
6) Click on submit button
7) Handle alert
8) verify alert message*/

package tamanna;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class A2P5 {

	WebDriver driver;
	A2P5(){
		System.out.println("STEP 1 - Launch Chrome brower");
		System.out.println("STEP 2 - Load http://automationbykrishna.com");
		driver=Setup.setUp("http://automationbykrishna.com");
	}
	
	void handleFields() {
		System.out.println("STEP 4 - enter Email Address");
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("tamanna@abc.com");
		
		System.out.println("STEP 5 - Enter password");
		driver.findElement(By.id("pwd")).sendKeys("abc123");
		
		System.out.println("STEP 6 - Click on submit button");
		driver.findElement(By.id("submitb2")).click();
	}
	
	void handleAlert() {
		System.out.println("STEP 7 - Handle alert");
		Alert alert=driver.switchTo().alert();
		String alertText=alert.getText();
		alert.accept();
		
		if(alertText.equals("You successfully clicked on it")) {
			System.out.println("Alert message verified. Test pass.");
		}else {
			System.err.println("Alert text cant be verified. Test fail.");
		}
	}
	
	void processSteps() {
	
		System.out.println("STEP 3 - click on Basic Element link");
		driver.findElement(By.id("basicelements")).click();
		Setup.staticWait(5000);
		
		handleFields();
		
		handleAlert();
		
		Setup.browserClose(driver);
	}
	
	public static void main(String[] args) {
		A2P5 a2p5=new A2P5();
		a2p5.processSteps();
	}
}
