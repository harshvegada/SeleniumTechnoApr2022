package sameer;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2
{
	private WebDriver driver;
	public static void main(String[] args)
	{
		Assignment2 assignment2 = new Assignment2();
		System.out.println("Launch Browser");
		assignment2.launchBrowser("http://automationbykrishna.com/");
		System.out.println("Click on Basic Element");
		assignment2.clickOnBasicElement();
		
		
		System.out.println("*******************Test Case 1****************");
		assignment2.program1();
		
		System.out.println("*******************Test Case 2****************");
		assignment2.program2();
		
		System.out.println("*******************Test Case 3****************");
		assignment2.program3(); 
		
		System.out.println("*******************Test Case 4****************");
		assignment2.program4("Sameer","Desai","TechnoCredits");
		
		System.out.println("*******************Test Case 5****************");
		assignment2.program5("samdesai123@gmail.com","Techno@123");
		

	}
	
	void launchBrowser(String url)
	{
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	private void clickOnBasicElement()
	{
		driver.findElement(By.id("basicelements")).click();
	}
	
	void wait(int time)
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void program1()
	{
		wait(5000);
		System.out.println("Click on Alert ");
		driver.findElement(By.id("javascriptAlert")).click();
		String actualMsg = acceptAlert();
		System.out.println(actualMsg);
		handleAlertMessage(actualMsg, "You must be TechnoCredits student!!");
	}
	
	private void program2()
	{
		System.out.println("Click on Javascript Confirmation");
		driver.findElement(By.id("javascriptConfirmBox")).click();
		acceptJavaScriptAlert();
		String actual = driver.findElement(By.id("pgraphdemo")).getText();
		System.out.println(actual);
		handleJavaScriptAlertMessage(actual,"You pressed OK!");
		
	}
	
	private void program3()
	{
		System.out.println("Click on Javascript Confirmation");
		driver.findElement(By.id("javascriptConfirmBox")).click();
		dismissJavaScriptAlert();
		String actual = driver.findElement(By.id("pgraphdemo")).getText();
		System.out.println(actual);
		handleJavaScriptAlertMessage(actual,"You pressed Cancel!");
		driver.close();
		
	}
	
	private void program4(String fName, String lName, String cName)
	{
		System.out.println("Launch Browser");
		launchBrowser("http://automationbykrishna.com/");
		System.out.println("Click on basic element");
		clickOnBasicElement();
		wait(5000);
		System.out.println("First name entered");
		enterUserName(fName);
		System.out.println("Last name entered");
		enterLastName(lName);
		System.out.println("Company name entered");
		enterCompanyName(cName);
		System.out.println("Click on Submit button");
		driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();
		String actual = acceptAlertDemo();
		System.out.println(actual);
		String expected = fName+" and "+lName+" and "+cName;
		handleAlertDemoAlertMessage(actual, expected);	
		driver.close();
	}
	
	
	
	private void program5(String emailId, String passwordText)
	{
		System.out.println("Launch Browser");
		launchBrowser("http://automationbykrishna.com/");
		System.out.println("Click on basic element");
		clickOnBasicElement();
		wait(5000);
		
		WebElement email = driver.findElement(By.id("exampleInputEmail1"));
		email.click();
		email.sendKeys(emailId);
		System.out.println("Email address entered");
		
		WebElement password = driver.findElement(By.id("pwd"));
		password.click();
		password.sendKeys(passwordText);
		System.out.println("Password entered");
		
		System.out.println("Click on Submit button");
		driver.findElement(By.id("submitb2")).click();
		String expected = "You successfully clicked on it";
		String actual = acceptAlertBasicForm();
		System.out.println(actual);
		handleAlertBasicFormAlertMessage(actual, expected);	
		driver.close();
	}
	
	private void enterUserName(String username)
	{
		WebElement uname = driver.findElement(By.xpath("//input[@id='UserFirstName']"));
		uname.click();
		uname.sendKeys(username);
	}
	
	private void enterLastName(String lastName)
	{
		WebElement lName = driver.findElement(By.xpath("//input[@id='UserLastName']"));
		lName.click();
		lName.sendKeys(lastName);
	}
	
	private void enterCompanyName(String companyName)
	{
		WebElement cName = driver.findElement(By.xpath("//input[@id='UserCompanyName']"));
		cName.click();
		cName.sendKeys(companyName);
	}
	
	private String acceptAlert()
	{
		Alert alert = driver.switchTo().alert();
		String actualMessage = alert.getText();
		alert.accept();
		return actualMessage;
	}
	
	private void handleAlertMessage(String actual, String expected)
	{
		if(actual.equals(expected))
			System.out.println("Test  Case Passed !");
		else
			System.out.println("Test Case failed !");	
	}
	
	private void acceptJavaScriptAlert()
	{
		Alert alert = driver.switchTo().alert();
		//tring actualMessage = alert.getText();
		alert.accept();	
	}
	
	private void dismissJavaScriptAlert()
	{
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		
	}
	
	private void handleJavaScriptAlertMessage(String actual, String expected)
	{
		if(actual.equals(expected))
			System.out.println("Test Case Passed !");
		else
			System.out.println("Test Case Failed !");
	}
	
	private String  acceptAlertDemo()
	{
		Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();
		alert.accept();
		return alertMessage;
	}
	
	private void handleAlertDemoAlertMessage(String actual, String expected)
	{
		if(actual.equals(expected))
			System.out.println("Test Case Pass!");
		else
			System.out.println("Test Case4 faile!");
		
	}
	
	private String acceptAlertBasicForm()
	{
		Alert alert = driver.switchTo().alert();
		String actual = alert.getText();
		alert.accept();
		return actual;
	}
	
	private void handleAlertBasicFormAlertMessage(String actual, String expected)
	{
		if(actual.equals(expected))
			System.out.println("Test Case pass!");
		else
			System.out.println("Test Case failed!");
	}

}
