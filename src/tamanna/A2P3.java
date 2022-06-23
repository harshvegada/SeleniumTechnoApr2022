/*Program 3
1)Again Click on Javascript Confirmation button.
3)Check the alert msg "Are you are doing your homework regularly, Press Okay else Cancel!!"
4)Click Cancel to dismiss the alert.
5)Check that msg appears "You pressed Cancel!" because cancel button is clicked. */

package tamanna;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class A2P3 {
	WebDriver driver;
	
	A2P3(){
		driver=Setup.setUp("http://automationbykrishna.com");
	}
	
	void handleAlert() {
		System.out.println("STEP 2 - Check that alert pop up appears.");
		Alert alert= null;
		try {
			alert=driver.switchTo().alert();
		}catch(Exception ex){
			System.out.println("Cant verify popup appearance.");
			return;
		}
		
		System.out.println("STEP 3 - Check the alert msg \"Are you are doing your homework regularly, Press Okay else Cancel!!");
		if(alert.getText().equals("Are you are doing your homework regularly, Press Okay else Cancel!!")) {
			System.out.println("alert message verified.");
		}else {
			System.out.println("Cant verify step 3 alert message");
			return;
		}
		
		System.out.println("STEP 4 - Click Cancel to dismiss the alert.");
		alert.dismiss();
		
		System.out.println("STEP 5 - Check that msg appears \"You pressed Cancel!\" because cancel button is clicked.");
		String messageText=driver.findElement(By.id("pgraphdemo")).getText();
		if(messageText.equals("You pressed Cancel!")) {
			System.out.println("Message text verified.");
		}else {
			System.out.println("Cant verify message text.");
		}
	}
	
	void performTest() {
		Setup.navigate("basicelements", driver);
		
		System.out.println("STEP 1 - Again Click on Javascript Confirmation button.");
		driver.findElement(By.id("javascriptConfirmBox")).click();
		
		handleAlert();
		
		Setup.staticWait(3000);
		Setup.browserClose(driver);
	}
	
	public static void main(String[] args) {
		A2P3 a2p3=new A2P3();
		a2p3.performTest();
	}
}
