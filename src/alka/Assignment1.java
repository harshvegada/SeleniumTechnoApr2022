package alka;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {
	private WebDriver driver;
	 public static void main(String[] args)
	    {  
		 Assignment1 objlb=new Assignment1();
		 objlb.loginTest();
 		}
        private	void setProperty(String url)
		{
        	
        	System.out.println("STEP - Launch Chrome brower");
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			 driver =new ChromeDriver();
			 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			 System.out.println("STEP - Load URL");
			 driver.get(url);
		}
 		private void  enterCredential(String un,String pass)
 		{
 			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
 			System.out.println("STEP - Enter username");
 			WebElement userName=driver.findElement(By.id("unameSignin"));
 	 		userName.clear();
 	 		userName.sendKeys(un);
 	 		System.out.println("STEP - Enter password");
 	 		WebElement passWord=driver.findElement(By.id("pwdSignin"));
 	 		passWord.clear();
 	 		passWord.sendKeys(pass);
 	 		System.out.println("STEP - Click on submit button");
 	 		driver.findElement(By.id("btnsubmitdetails")).click();
 	 
 		}
 		 void loginTest()
 		{   
 			
 			System.out.println("PREREQUISITE - Browser Setup");
 			setProperty("http://automationbykrishna.com");
 			System.out.println("STEP - click on Registration link");
 			driver.findElement(By.id("registration2")).click();
 			System.out.println("Enter Credentials & click login button");
 		    enterCredential("mkanani","mkanani1234");
 		    System.out.println("VERIFY - Alert message should be Success!");
 			verifyHandleAlert(handleAlert(),"Success!");
 			System.out.println("Alert message should be verified for weak password");
 			System.out.println("STEP - Enter Credentials");
 			enterCredential("mkanani", "123");
 			System.out.println("VERIFY - Alert message should be Success!");
 			verifyHandleAlert(handleAlert(),"Failed! please enter strong password");
 			
 		}
 		void verifyHandleAlert(String actualResult,String expectedResult)
 		{
 			if(actualResult.equals(expectedResult))
 			{
 				System.out.println("Test pass");
 			}
 			else
 				System.out.println("Test fail");
 		}
 		String handleAlert()
 		{
 			System.out.println("Switch to alter");
 			Alert alert = driver.switchTo().alert();
 			System.out.println("Get Alert text");
 	 		String actualMsg= alert.getText();
 			alert.accept();
 			return  actualMsg;
 			
 	 	
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

}
