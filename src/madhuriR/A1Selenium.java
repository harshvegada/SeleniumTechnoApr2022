package madhuriR;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A1Selenium {
	private WebDriver driver;
	void setUP(String url) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	void fastWait(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void enterDetails(String userName,String password) {
		WebElement userElement = driver.findElement(By.id("unameSignin"));
		userElement.clear();
		userElement.sendKeys(userName);
		
		WebElement passElement = driver.findElement(By.id("pwdSignin"));
		passElement.clear();
		passElement.sendKeys(password);

		driver.findElement(By.id("btnsubmitdetails")).click();
		
	}
	String handleAlert() {
		Alert alert = driver.switchTo().alert();
		String actualMsg= alert.getText();
		alert.accept();
		return actualMsg;
	}
	 void verifyMsg(String actualMsg,String expectedMsg) {
		 if(expectedMsg.equals(actualMsg)) {
				System.out.println("TestPAss");
			}else {
				System.out.println("TestFail");
			}
	 }
	
	void login() {
		System.out.println("For Strong password");
		setUP("http://automationbykrishna.com");
		driver.findElement(By.id("registration2")).click();
		fastWait(3000);
		
		enterDetails("mkanani", "maulik1234");
		String actualMessage = handleAlert();
		verifyMsg(actualMessage, "Success!");
	
		System.out.println("For weak password");
		enterDetails("maulik", "123");
		actualMessage = handleAlert();
		verifyMsg(actualMessage, "Failed! please enter strong password");
		
		driver.close();
		
	}
	public static void main(String[] args) {
		A1Selenium a1Selenium = new A1Selenium();
		a1Selenium.login();
	}
}
