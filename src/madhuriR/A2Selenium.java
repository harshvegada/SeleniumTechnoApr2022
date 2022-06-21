package madhuriR;
/*Assignment 2 : 14th Jun'2022

Pre-requisite Steps
1)Go to http://automationbykrishna.com/
2)Go to on Basic Elements tab.

Program 1
1)Click on Alert button.
2)Check that alert pop up appears.
3)Check the alert msg "You must be TechnoCredits student!!"
4)Click OK to accept the alert.

Program 2
1)Click on Javascript Confirmation button.
2)Check that alert pop up appears.
3)Check the alert msg "Are you are doing your homework regularly, Press Okay else Cancel!!"
4)Click OK to accept the alert.
5)Check that msg appears "You pressed OK!" because OK button is clicked.

Program 3
1)Again Click on Javascript Confirmation button.
3)Check the alert msg "Are you are doing your homework regularly, Press Okay else Cancel!!"
4)Click Cancel to dismiss the alert.
5)Check that msg appears "You pressed Cancel!" because cancel button is clicked.

Program 4
Write a script to automate below test steps :

1) Launch Chrome brower
2) Load http://automationbykrishna.com
3) click on Basic Element link
4) Enter firstName
5) Enter lastName
6) Enter compantyName
7) click on Submit button
8) Handle alert
9) verify alert message using firstName, lastName, compantyName

Program 5
Write a script to automate below test steps :

1) Launch Chrome brower
2) Load http://automationbykrishna.com
3) click on Basic Element link
4) enter Email Address
5) Enter password
6) Click on submit button
7) Handle alert
8) verify alert message*/
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A2Selenium {
	
	WebDriver driver;
	/**************************************Program 1********************************************/
	void setUp(String url) {
		System.out.println("Lounch a browser");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver =new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	void waitTime(int val) {
		try {
			Thread.sleep(val);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	void verifyAlertFumctionality(){
		
			setUp("http://automationbykrishna.com");
			driver.findElement(By.id("basicelements")).click();
			waitTime(15000);
			JavascriptExecutor je = (JavascriptExecutor)driver;
			je.executeScript("window.scrollTo(0,350)");
			System.out.println("Click on Alert");
			driver.findElement(By.id("javascriptAlert")).click();
			waitTime(15000);
			String actual = handleAlert();
			System.out.println("Verifying Alert Message");
			String expectedMsg ="You must be TechnoCredits student!!";
			verifyMsg(actual, expectedMsg);
		
	}
	/**************************************Program 2********************************************/
	void verifyJavaScriptConfermationforAccept() {
		setUp("http://automationbykrishna.com");
		driver.findElement(By.id("basicelements")).click();
		waitTime(15000);
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("window.scrollTo(0,350)");
		System.out.println("Click on javascript Alert");
		driver.findElement(By.id("javascriptConfirmBox")).click();
		waitTime(15000);
		
		driver.switchTo().alert().accept();
		String actaul = driver.findElement(By.id("pgraphdemo")).getText();
		
		System.out.println("Verifying Javacript confermation alert Message");
		String expectedMsg ="You pressed OK!";
		verifyMsg(actaul, expectedMsg);
	}
	/**************************************Program 3********************************************/
	void verifyJavaScriptConfermationforDismiss() {
		waitTime(15000);
		
		driver.findElement(By.id("javascriptConfirmBox")).click();
		waitTime(15000);
		driver.switchTo().alert().dismiss();
		String actaul = driver.findElement(By.id("pgraphdemo")).getText();
		
		System.out.println("Verifying Javacript confermation alert Message");
		String expectedMsg ="You pressed Cancel!";
		verifyMsg(actaul, expectedMsg);
	}

	/**************************************Program 4********************************************/
	void alertDemoForm(String fName,String lName,String companyName) {
		setUp("http://automationbykrishna.com");
		waitTime(10000);
		driver.findElement(By.id("basicelements")).click();
		waitTime(15000);
		WebElement userElement = driver.findElement(By.id("UserFirstName"));
		userElement.clear();
		userElement.sendKeys(fName);
		
		WebElement  lastElement = driver.findElement(By.id("UserLastName"));
		lastElement.clear();
		lastElement.sendKeys(lName);
		
		WebElement  companyElement = driver.findElement(By.id("UserCompanyName"));
		companyElement.clear();
		companyElement.sendKeys(companyName);
		
		driver.findElement(By.xpath("(//button[@class=\"btn btn-primary\"])[1]")).click();
		Alert alert = driver.switchTo().alert();
		String actualMessage = alert.getText();
		alert.accept();
		String expectedString = fName+" and "+ lName+" and "+ companyName;
		verifyMsg(actualMessage, expectedString);
	}
	/**************************************Program 5********************************************/
	void basicForm(String emailId,String password) {
		setUp("http://automationbykrishna.com");
		waitTime(10000);
		driver.findElement(By.id("basicelements")).click();
		waitTime(15000);
		WebElement emailIdElement = driver.findElement(By.id("exampleInputEmail1"));
		emailIdElement.clear();
		emailIdElement.sendKeys(emailId);
		
		WebElement  passwordElement = driver.findElement(By.id("pwd"));
		passwordElement.clear();
		passwordElement.sendKeys(password);
		
		driver.findElement(By.id("submitb2")).click();
		Alert alert = driver.switchTo().alert();
		waitTime(5000);
		String actualMessage = alert.getText();
		alert.accept();
		String expectedString = "You successfully clicked on it";
		verifyMsg(actualMessage, expectedString);
	}
	
	public static void main(String[] args) {
		A2Selenium ass2=new A2Selenium();
			ass2.verifyAlertFumctionality();
			ass2.verifyJavaScriptConfermationforAccept();
			ass2.waitTime(15000);
			ass2.verifyJavaScriptConfermationforDismiss();
			ass2.alertDemoForm("maulik", "kanani", "Globant");
			ass2.basicForm("rajolemadhuri@gmail.com", "madhu123456");
	}
	

}
