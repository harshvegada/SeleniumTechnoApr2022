package omkar;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {
	private  WebDriver  driver;
		
	void setMethod(String url) {
		System.out.println("Step-> Browser launched ");
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		driver=new ChromeDriver();
		
		System.out.println("Step-> Load URL");
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	void clickOnRegistration(String username,String password) {
		System.out.println("click on Registration link");
		WebElement wb= driver.findElement(By.id("registration2"));
		wb.click();	
		fastWait(2000);
		
		System.out.println("Enter username");
		WebElement usernamewb=driver.findElement(By.id("unameSignin"));
		fastWait(2000);
		usernamewb.sendKeys(username);
		fastWait(2000);
		
		System.out.println("Enter password");
		WebElement passwordwb=driver.findElement(By.id("pwdSignin"));
		fastWait(2000);
		passwordwb.sendKeys(password);
		fastWait(2000);
		
		System.out.println("Click on submit button");
		WebElement submit=driver.findElement(By.id("btnsubmitdetails"));
		fastWait(2000);
		submit.click();
	}
	
	private String alertMessage() {
		System.out.println("Switch to alert message");
		Alert alert=driver.switchTo().alert();
		fastWait(2000);
		String actualMessage=alert.getText();
		fastWait(2000);
		alert.accept();
		return actualMessage;
	}
	void fastWait(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void verifyAlertMessage(String actualMessage, String expectedMessage) {
		if(actualMessage.equals(expectedMessage))
			System.out.println("Test pass");
		else
			System.out.println("Test failed");
	}
	
	void loginTest() {
		setMethod("http://automationbykrishna.com/");
		fastWait(3000);
		clickOnRegistration("oraut","oraut@123");
				
		verifyAlertMessage(alertMessage(),"Success!");
		
		System.out.println("Negative scenario - > weak password");
		fastWait(2000);
		clickOnRegistration("praut","p123");
		
		verifyAlertMessage(alertMessage(),"Failed, kindly enter strong password");
		
		//driver.close();
	}
	
	public static void main(String[] args) {
		Assignment1 assignment1=new Assignment1();
		assignment1.loginTest();
	}
}

