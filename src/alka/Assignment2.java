/*Pre-requisite Steps
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


package alka;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {
 private WebDriver driver;
  void setProperty(String url)
 { 
	 System.out.println("STEP - Launch Chrome brower");
	 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	 driver=new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 System.out.println("STEP - Load URL");
	 driver.get(url);
	 driver.manage().window().maximize();
 }
 String handleAlert()
 {
	 Alert alert=driver.switchTo().alert();
	 String msg=alert.getText();
	 alert.accept();
	 return msg;
	 
 }
 void scrollToElementTest(WebElement element)
 {
	 JavascriptExecutor je= (JavascriptExecutor)driver;
	 je.executeScript("arguments[0].scrollIntoView(true)", element);
 }
void exampleAlert()
{
	setProperty("http://automationbykrishna.com");
	System.out.println("STEP - Click on Basic element button");
	driver.findElement(By.id("basicelements")).click();
	WebElement element=  driver.findElement(By.id("javascriptAlert"));
	scrollToElementTest(element);
	System.out.println("STEP - Click on Alert button");
	driver.findElement(By.id("javascriptAlert")).click();
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	String actualMessage= handleAlert();
	verifyMessage(actualMessage,"You must be TechnoCredits student!!");
}
void examplejavascriptConfirm(String expectedOutput)
{     
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	System.out.println("STEP - Click on Alert Confirmation button");
	driver.findElement(By.id("javascriptConfirmBox")).click();
	String msg=driver.switchTo().alert().getText();
	driver.switchTo().alert().accept();
    String actualMessage=driver.findElement(By.id("pgraphdemo")).getText();
	verifyMessage(actualMessage,expectedOutput);
}

void examplejavascriptConfirmForCancel (String expectedOutput)
{    
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.findElement(By.id("javascriptConfirmBox")).click();
	String msg=driver.switchTo().alert().getText();
	driver.switchTo().alert().dismiss();
    String actualMessage=driver.findElement(By.id("pgraphdemo")).getText();
	verifyMessage(actualMessage,expectedOutput);
}


void examplejavascriptPrompt(String name)
{   
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 
	String expectedOutput="";
	System.out.println("STEP - Click on Alert Prompt button");
    driver.findElement(By.id("javascriptPromp")).click();
    Alert alert=   driver.switchTo().alert();
    expectedOutput=	"Hello "+name+"! How are you today?"; 
	alert.sendKeys(name);
	alert.accept();
  	String actualOutput= driver.findElement(By.id("pgraphdemo")).getText();
    verifyMessage(actualOutput, expectedOutput);
}
void examplejavascriptPromptForCancel(String msg)
{    
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	String expectedOutput=msg;
    driver.findElement(By.id("javascriptPromp")).click();
    Alert alert= driver.switchTo().alert();
	alert.dismiss();
  	String actualOutput= driver.findElement(By.id("pgraphdemo")).getText();
    verifyMessage(actualOutput, expectedOutput);
}
 void verifyMessage(String actualmsg,String expectedmsg)
 {
	 if(actualmsg.equals(expectedmsg))
	 {
		 System.out.println("Test pass");
	 }
	 else
		 System.out.println("Test fail");
	 
	 
 }
	void fastWait(int time)
		{
			 	 try 
			 	{   
					Thread.sleep(time);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		}
	void testDemo(String fName ,String lName,String cName)
	{   
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String expectedmsg=fName +" and " + lName+" and " + cName;
		System.out.println("STEP - Enter First name");
		driver.findElement(By.id("UserFirstName")).sendKeys(fName);
		System.out.println("STEP - Enter Last name");
		driver.findElement(By.id("UserLastName")).sendKeys(lName);
		System.out.println("STEP - Enter Company name");
		driver.findElement(By.id("UserCompanyName")).sendKeys(cName);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		String actualResult=handleAlert();
		verifyMessage(actualResult, expectedmsg);
		
	}
	void testBasicForms(String emailId ,String password,String expectedmsg )
	{   
	   
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("STEP - Enter EmailId");
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(emailId);
		System.out.println("STEP - Enter Password");
		driver.findElement(By.id("pwd")).sendKeys(password);
		System.out.println("STEP - Click on Submit button");
		driver.findElement(By.id("submitb2")).click();
		String actualResult=handleAlert();
		verifyMessage(actualResult, expectedmsg);
		
	}
 
 public static void main(String[] args)
 {
	 Assignment2 objassignment2 =new Assignment2();
	 objassignment2.exampleAlert();
	 objassignment2.examplejavascriptConfirm("You pressed OK!"); 
	 objassignment2.examplejavascriptConfirmForCancel("You pressed Cancel!");
	 objassignment2. examplejavascriptPrompt("alka");
	 objassignment2. examplejavascriptPromptForCancel("User cancelled the prompt.");
	 objassignment2.testDemo("alka","parab","exce");
	 objassignment2. testBasicForms("alka@gmail.com","ddsfsf","You successfully clicked on it");
 }
 
}
