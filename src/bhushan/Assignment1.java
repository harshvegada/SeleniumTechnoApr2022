package bhushan;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*/*Assignment-1 : 12th Jun'2022 

Write a script to automate below test steps :

1) Launch Chrome brower
2) Load http://automationbykrishna.com
3) click on Registration link
4) Enter username
5) Enter password
6) Click on submit button
7) verify alter message based on password length
 */

public class Assignment1 {
	
	//WebDriver driver=new ChromeDriver();
	
	void validateUserIdAndPwd(String userID,String Pwd) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.id("registration2")).click();
		waitTime(3500);
		driver.findElement(By.id("unameSignin")).sendKeys(userID);
		waitTime(3000);
		driver.findElement(By.id("pwdSignin")).sendKeys(Pwd);
		waitTime(3000);
		driver.findElement(By.id("btnsubmitdetails")).click();
		waitTime(3000);
		Alert alert=driver.switchTo().alert();
		String alertMsg=alert.getText();
		alert.accept();
		waitTime(3000);
		if(alertMsg.equals("Success!"))
			System.out.println("Test Pass for user name > "+ userID);
		else
			System.out.println("Test Failed for user name > "+ userID);
		
		driver.quit();
		
	}
	
	static void waitTime(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		
	
	
	public static void main(String[] args) {
		Assignment1 ass1=new Assignment1();
		ass1.validateUserIdAndPwd("Bhushan","123412345");
		waitTime(5000);
		ass1.validateUserIdAndPwd("admin","admin");
	}

}
