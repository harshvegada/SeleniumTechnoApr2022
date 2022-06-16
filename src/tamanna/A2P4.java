/*Program 4
Write a script to automate below test steps :

1) Launch Chrome brower
2) Load http://automationbykrishna.com
3) click on Basic Element link
4) Enter firstName
5) Enter lastName
6) Enter compantyName
7) click on Submit button
8) Handle alert
9) verify alert message using firstName, lastName, compantyName*/

package tamanna;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class A2P4 {
	
	WebDriver driver;
	String fName,lName,cName;
	
	A2P4(){
		System.out.println("STEP 1 - Launch Chrome brower");
		System.out.println("STEP 2 - Load http://automationbykrishna.com");
		driver=Setup.setUp("http://automationbykrishna.com");
	}
	
	void handleFields() {
		System.out.println("STEP 4 - Enter firstName");
		WebElement firstNameelement=driver.findElement(By.name("ufname"));
		firstNameelement.clear();
		firstNameelement.sendKeys(fName);
		
		System.out.println("STEP 5 - Enter lastName");
		WebElement lastNameElement=driver.findElement(By.name("ulname"));
		lastNameElement.clear();
		lastNameElement.sendKeys(lName);
		
		System.out.println("STEP 6 - Enter compantyName");
		WebElement cNameElement=driver.findElement(By.name("cmpname"));
		cNameElement.clear();
		cNameElement.sendKeys(cName);
		
	}
	
	void handleAlert() {
		System.out.println("STEP 8 - Handle alert.");
		Alert alert= null;
		try {
			alert=driver.switchTo().alert();
		}catch(Exception ex){
			System.out.println("Cant verify popup appearance.");
			return;
		}
		
		if(alert.getText().equals(fName+" and "+lName+" and "+cName)) {
			System.out.println("alert message verified. Test pass.");
		}else {
			System.out.println("Cant verify alert message. Test fail.");
			return;
		}
		
		alert.accept();
	}
	
	void performTest() {
		System.out.println("STEP 3 - click on Basic Element link");
		Setup.navigate("basicelements", driver);
		
		fName="tamanna";
		lName="shah";
		cName="erin";
		handleFields();
		
		System.out.println("STEP 7 - click on Submit button");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		handleAlert();
		
		Setup.staticWait(3000);
		Setup.browserClose(driver);
	}
	
	public static void main(String[] args) {
		A2P4 a2p4=new A2P4();
		a2p4.performTest();
	}
}
