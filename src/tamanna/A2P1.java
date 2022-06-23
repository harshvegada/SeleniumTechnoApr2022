/* Program 1
1)Click on Alert button.
2)Check that alert pop up appears.
3)Check the alert msg "You must be TechnoCredits student!!"
4)Click OK to accept the alert.*/
package tamanna;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class A2P1 {

	WebDriver driver;

	A2P1() {
		driver = Setup.setUp("http://automationbykrishna.com");
	}

	void handleAlert() {
		System.out.println("STEP 2 - Check that alert pop up appears.");
		Alert alert=null;
		try {
			alert = driver.switchTo().alert();
		} catch (Exception ex) {
			System.out.println("Alert popup not appearing.");
			return;
		}
		
		String actualMessage=alert.getText();
		System.out.println("STEP 3 - Check the alert msg \"You must be TechnoCredits student!!\"");
		if(actualMessage.equals("You must be TechnoCredits student!!")) {
			System.out.println("Alert message verified");
		}else {
			System.out.println("Cant verify alert message");
		}
		
		System.out.println("STEP 4 - Click OK to accept the alert.");
		alert.accept();
	};

	void performTest() {
		Setup.navigate("basicelements", driver);
		
		System.out.println("STEP 1 - Click on alert button.");
		driver.findElement(By.id("javascriptAlert")).click();
		
		handleAlert();
	}

	public static void main(String[] args) {
		A2P1 a2p1 = new A2P1();
		a2p1.performTest();
	}
}
