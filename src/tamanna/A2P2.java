/*Program 2
1)Click on Javascript Confirmation button.
2)Check that alert pop up appears.
3)Check the alert msg "Are you are doing your homework regularly, Press Okay else Cancel!!"
4)Click OK to accept the alert.
5)Check that msg appears "You pressed OK!" because OK button is clicked.*/

package tamanna;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class A2P2 {

	WebDriver driver;
	
	A2P2(){
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
		
		System.out.println("STEP 3 - Check the alert msg \"Are you are doing your homework regularly, Press Okay else Cancel!!\"");
		if(alert.getText().equals("Are you are doing your homework regularly, Press Okay else Cancel!!")) {
			System.out.println("alert message verified.");
		}else {
			System.out.println("Cant verify step 3 alert message");
			return;
		}
		
		System.out.println("STEP 4 - Click OK to accept the alert.");
		alert.accept();
		
		System.out.println("STEP 5 - Check that msg appears \"You pressed OK!\" because OK button is clicked.");
		String messageText=driver.findElement(By.id("pgraphdemo")).getText();
		if(messageText.equals("You pressed OK!")) {
			System.out.println("Message text verified.");
		}else {
			System.out.println("Cant verify message text.");
		}
	}
	
	void performTest() {
		Setup.navigate("basicelements", driver);
		
		System.out.println("STEP 1 - Click on Javascript Confirmation button.");
		driver.findElement(By.id("javascriptConfirmBox")).click();
		
		handleAlert();
		
		Setup.staticWait(3000);
		Setup.browserClose(driver);
	}
	
	public static void main(String[] args) {
		A2P2 a2p2=new A2P2();
		a2p2.performTest();
	}
	
}
