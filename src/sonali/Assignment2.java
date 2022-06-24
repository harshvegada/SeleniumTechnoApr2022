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
package sonali;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {
	
	private WebDriver driver;
	void setup() throws InterruptedException {
		System.out.println("/*Pre-requisite Steps");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement basicelement = driver.findElement(By.id("basicelements"));
		
		basicelement.click();
	}

	void program1() {
		System.out.println("Program1");
		WebElement alertelement = driver.findElement(By.id("javascriptAlert"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", alertelement);
		alertelement.click();
		Alert alert = driver.switchTo().alert();
		String expectedtext = "You must be TechnoCredits student!!";
		String alerttext = alert.getText();
		if (expectedtext.equals(alerttext)) {
			System.out.println("Text is same");
		} else {
			System.out.println("Text is different");
		}
		System.out.println("The alert message is " + alerttext);
		alert.accept();

	}
	void program2() {
		System.out.println("Program2");
		WebElement alertelement =driver.findElement(By.id("javascriptConfirmBox"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", alertelement);
		alertelement.click();
		Alert alert=driver.switchTo().alert();
		String expectedtext="Are you are doing your homework regularly, Press Okay else Cancel!!";
		String alerttext=alert.getText();
		if (expectedtext.equals(alerttext)) {
			System.out.println("Text is same");
		}
		else {
			System.out.println("Text is different");
		}
		System.out.println("The alert message is "+ alerttext);
		alert.accept();
		String expectedtext1="You pressed OK!";
		WebElement text=driver.findElement(By.id("pgraphdemo"));
		String actualtext= text.getText();
		if (expectedtext1.equals(actualtext)) {
			System.out.println("Text is same");
		}
		else {
			System.out.println("Text is different");
		}
	}
   void program3() {
	   System.out.println("Program3");
	   String ExpectedString;
	   WebElement username=driver.findElement(By.id("UserFirstName"));
		username.sendKeys("Sonali");
		WebElement lastname=driver.findElement(By.id("UserLastName"));
		lastname.sendKeys("Mahale");
		WebElement cname=driver.findElement(By.id("UserCompanyName"));
		cname.sendKeys("Cybage");
		WebElement submit=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		submit.click();
	    Alert alert =driver.switchTo().alert();
	    
	   String ActualText=alert.getText();
	   ExpectedString= "Sonali and Mahale and Cybage";
	   System.out.println(ExpectedString);
	   if(ActualText.equals(ExpectedString)) {
		   System.out.println("String are equals");
	   }
	   else {
		   System.out.println("String not equals");
	   }
	   alert.accept();
   }
   void program4() {
	   System.out.println("Program4");
	   WebElement email=driver.findElement(By.id("exampleInputEmail1"));
		email.sendKeys("sonaliborase23@gmail.com");
		WebElement pass =driver.findElement(By.id("pwd"));
		pass.sendKeys("Ojaswi");
		WebElement submit =driver.findElement(By.id("submitb2"));
		submit.click();
		Alert alert =driver.switchTo().alert();
	    String Actualtxt=alert.getText();
	    String Expectedtxt="You successfully clicked on it";
	    if(Actualtxt.equals(Expectedtxt))
	    	System.out.println("passed");
		alert.accept();
		driver.close();
   }
	public static void main(String[] args) throws InterruptedException {
		Assignment2 assignment2 = new Assignment2();
		assignment2.setup();
		assignment2.program1();
		assignment2.program2();
		assignment2.program3();
		assignment2.program4();
	}

}
