package omkar;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {
	private WebDriver driver;
	
	void launchBrowser(String url) {
		System.out.println("Step -> launch browser");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver=new ChromeDriver();
		
		System.out.println("Step -> load URL");
		driver.get(url);
		driver.manage().window().maximize();
		
		driver.findElement(By.id("basicelements")).click();
		
	}
	
	void fastWait(int time) {
		try {
			Thread.sleep(time);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private String alertMessage() {
		Alert alert=driver.switchTo().alert();
		fastWait(2000);
		String actualMessage=alert.getText();
		fastWait(2000);
		alert.accept();
		return actualMessage;
	} 
	
	void verifyAlertMessage(String actualMessage , String expectedMessage) {
		if(actualMessage.equals(expectedMessage)) 
			System.out.println("Test pass");
		else
			System.out.println("Test failed");
	}
	
	void alert(String expectedMessage) {
		//String expectedMessage="You must be TechnoCredits student!!";
		
		fastWait(2000);	
		System.out.println("Step scroll down");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");		
		driver.findElement(By.id("javascriptAlert")).click();		
		//driver.switchTo().alert();
		fastWait(2000);
		verifyAlertMessage(alertMessage(),expectedMessage);
		
	}
	void javaScriptConfirmation() {
		
		System.out.println("Step -> Click on Javascript Confirmation button.");
		String expectedMessage1="You pressed Cancel!";
		fastWait(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		fastWait(2000);
		
	    driver.findElement(By.id("javascriptConfirmBox")).click();
	    System.out.println("Step -> Check that alert pop up appears.");
	    fastWait(2000);
	    
	    Alert alert=driver.switchTo().alert();
	    alert.dismiss();
	    fastWait(2000);
	    
	    System.out.println("Check the alert msg \"Are you are doing your homework regularly, Press Okay else Cancel!!\"");
	    System.out.println("Check that msg appears \"You pressed Cancel!\" because cancel button is clicked.");
	    String actualMessage1=driver.findElement(By.id("pgraphdemo")).getText();	 
	    
	    verifyAlertMessage(actualMessage1,expectedMessage1);
	    fastWait(2000);
	    
	    System.out.println("Step -> Again Click on Javascript Confirmation button.");
	    driver.findElement(By.id("javascriptConfirmBox")).click();
	    fastWait(2000);
	    System.out.println("Step -> Check that alert pop up appears.");
	    
	    Alert alert1=driver.switchTo().alert();
	    fastWait(2000);
	    System.out.println("Step clicked OK");
	    alert1.accept();
	    fastWait(2000);
	    
	    String expectedMessage2="You pressed OK!";
	    
	    String actualMessage2=driver.findElement(By.id("pgraphdemo")).getText();
	    fastWait(2000);
	    
	    verifyAlertMessage(actualMessage2,expectedMessage2);
	}	
	
	void genralInfo(String firstName, String lastName , String componyName) {
		
		System.out.println("Step -> Enter firstName");
		WebElement firstwb=driver.findElement(By.id("UserFirstName"));
		firstwb.sendKeys(firstName);
		fastWait(2000);
		
		System.out.println("Step -> Enter lastName");
		WebElement lastwb=driver.findElement(By.id("UserLastName"));
		lastwb.sendKeys(lastName);
		fastWait(2000);
		
		System.out.println("Step -> Enter compantyName");
		WebElement componywb=driver.findElement(By.id("UserCompanyName"));
		componywb.sendKeys(componyName);
		fastWait(2000);
		
		System.out.println("Step -> click on Submit button");
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();
		
		System.out.println("Step -> verify alert message using firstName, lastName, compantyName");
		fastWait(2000);
	    String expectedMessage= firstName+"and"+lastName+"and"+componyName;
		verifyAlertMessage(alertMessage(),expectedMessage);
		
	}
	
	void basicForm() {
		WebElement emailwb=driver.findElement(By.id("exampleInputEmail1"));
		
		System.out.println("Step -> enter Email Address");
		emailwb.sendKeys("rautom11@gmail.com");
		fastWait(2000);
		
		WebElement passwb=driver.findElement(By.id("pwd"));
		System.out.println("Step ->Enter password");
		passwb.sendKeys("raut@1234");
		fastWait(2000);
		
		System.out.println("Step -> Click on submit button");
		driver.findElement(By.id("submitb2")).click();
		
		
		String expectedMessage="You successfully clicked on it";
		System.out.println("step -> verify alert message");
		verifyAlertMessage(alertMessage(),expectedMessage);
	}
	
	public static void main(String[] args) {
		Assignment2 a2=new Assignment2();
		a2.launchBrowser("http://automationbykrishna.com/");
		System.out.println("*****************Program 1******************************");
		a2.alert("You must be TechnoCredits student!!");
		System.out.println("*****************Program 2 and 3************************");
		a2.javaScriptConfirmation();
		System.out.println("******************Program 4 ****************************");
		a2.genralInfo("Omkar","Raut","Hexaware");
		System.out.println("***************Program 5********************************");
		a2.basicForm();

	}

}
