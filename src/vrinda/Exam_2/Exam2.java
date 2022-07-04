/*
 * Exam - 2 : 22nd Jun'2022
Automate below scenario

1. Navigate to site `http://automationpractice.com/index.php`
2. Click on `Sign In` button top right corner
3. Verify whether URL contains `my-account` keyword or not
4. enter any random email address
5. Click on `Create an account` button
6. Fill that form with any random details
	a. use pin number as `37201`
7. Click on `Register` button
8. After Successfully registration you landed on My Account Page (Verify the title should contains My Account keyword)
9. Verify logged in name is combination of firstName and lastName
10. Verify `Sign out` button is getting display
11. Click on `Sign out` button
12. Verify you landed on Login screen(verify page title)
 */

package vrinda.Exam_2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import vrinda.Assignment_1.Assignment_1;

public class Exam2 {
	private WebDriver driver;
	void launchBrowser(String url)
	{
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public static void main(String[] args)
	{
		Exam2 exam = new Exam2();
		exam.FillingForm();
	}
	
	void FillingForm() {
		System.out.println("Step 1: Navigate to site");
		launchBrowser("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		System.out.println("Step 2: Click on `Sign In` button");
		driver.findElement(By.xpath("//a[@class='login']")).click();
		
		System.out.println("Step 3:Verify whether URL contains `my-account` keyword or not");
		 boolean isContainKeyWord=driver.getCurrentUrl().contains("my-account");
		 if(isContainKeyWord)
			 System.out.println("URL contains `my-account` keyword");
		 else
			 System.out.println("URL not contains `my-account` keyword");
		 JavascriptExecutor js=(JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,250)", "");
		 
		 System.out.println("Step 4. enter any random email address");
		 driver.findElement(By.id("email_create")).sendKeys("sheelaprakashjoshi@gmail.com");
		 
		 System.out.println("Step 5. Click on `Create an account` button");
		 driver.findElement(By.id("SubmitCreate")).click();
		 
		System.out.println("Step 6. Fill that form with any random details\r\n"
				+ "	a. use pin number as `37201`");
		
		System.out.println("Step 6.1 Click on one radioButton");
		driver.findElement(By.id("id_gender2")).click();
		
		System.out.println("Step 6.2 Enter First Name");
		 WebElement firstName=driver.findElement(By.id("customer_firstname"));
		 firstName.sendKeys("Vrinda");
		 
		 System.out.println("Step 6.3 Enter last Name");
		 WebElement lastName=driver.findElement(By.id("customer_lastname"));
		 lastName.sendKeys("DeviDasi");
		 
		 System.out.println("Step 6.4 Enter password Name");
		 WebElement password=driver.findElement(By.id("passwd"));
		 password.sendKeys("vrindadevidasi");
		 
		 JavascriptExecutor je=(JavascriptExecutor) driver;
		 je.executeScript("window.scrollBy(0,250)", "");
		 
		 System.out.println("Step 6.5 Enter the Date off Birth");
		 System.out.println("Step 6.5.1 Select day");
		 WebElement dayElement=driver.findElement(By.id("days"));
		 Select select1=new Select(dayElement);
		 select1.selectByValue("10");
		 System.out.println("Step 6.5.2 Select month");
		 WebElement monthElement=driver.findElement(By.id("months"));
		 Select select2=new Select(monthElement);
		 select2.selectByValue("5");
		 System.out.println("Step 6.5.3 Select year");
		 WebElement yearElement=driver.findElement(By.id("years"));
		 Select select3=new Select(yearElement);
		 select3.selectByValue("2011");
		 
		 JavascriptExecutor jc=(JavascriptExecutor) driver;
		 jc.executeScript("window.scrollBy(0,250)", "");
		 
		 System.out.println("Step 6.6 Enter the company name");
		 driver.findElement(By.id("company")).sendKeys("TechnoCreadit");
		 
		 System.out.println("Step 6.7 Enter the Address");
		 driver.findElement(By.id("address1")).sendKeys("Barsana");
		 
		 System.out.println("Step 6.8 Enter the address line 2");
		 driver.findElement(By.id("address2")).sendKeys("Manpur,GauShala");
		 
		 System.out.println("Step 6.9 Enter the City");
		 driver.findElement(By.id("city")).sendKeys("Mathura");
		 
		 System.out.println("Step 6.10 Select the City");
		 WebElement state=driver.findElement(By.id("id_state"));
			Select select4=new Select(state);
			select4.selectByValue("29");
			
			System.out.println("Step 6.11 Enter the City");
			 driver.findElement(By.id("postcode")).sendKeys("37201");
			
			 System.out.println("Step 6.12 Select the Country");
			 WebElement country=driver.findElement(By.id("id_state"));
				Select select5=new Select(country);
				select5.selectByValue("21");
			
				System.out.println("Step 6.13 Enter Additional Information");
				 driver.findElement(By.id("other")).sendKeys("Very good attitude");
				 
				 System.out.println("Step 6.14 Enter Phone number");
				 driver.findElement(By.id("phone")).sendKeys("1874365679");
				 
				 System.out.println("Step 6.15 Enter mobile number");
				 driver.findElement(By.id("phone_mobile")).sendKeys("9738752838");
				 
				 System.out.println("Step 6.15 Enter Address for future refrence");
				 driver.findElement(By.id("alias")).sendKeys("Vrindavan");
				 
				 System.out.println("Step 7. Click on `Register` button");
				 driver.findElement(By.id("submitAccount")).click();
				 
				 System.out.println("Step 8: Verify the title should contains My Account keyword");
				 
				 String title=driver.getTitle();
				 String expectedtitle="My Account";
				 System.out.println("the title of page is "+title);
				 if(title.equals(expectedtitle))
					 System.out.println("Title contains My Account keyword");
				 else
					 System.out.println("Title not contains My Account keyword");
				 
				 System.out.println("Step 9. Verify logged in name is combination of firstName and lastName");
					String loginName = driver.findElement(By.className("account")).getText();
					System.out.println("title-"+loginName);
					String expectedName="Vrinda DeviDasi";
					if (loginName.equals(expectedName))
						System.out.println("Test Case Pass");
					else
						System.out.println("Test Case Fail");
					
					String name="Vrinda";
					String lastname="Devidasi";
					WebElement nameLastName= driver.findElement(By.xpath("//a[@class='account']"));
					String fullName=nameLastName.getText();
					if(fullName.equals(name+" "+lastName)) {
						System.out.println("Both names are same"+fullName);
					}else
						System.out.println("Both names are not same");
					
					WebElement logout=driver.findElement(By.xpath("//a[@class='logout']"));
					System.out.println(logout.isDisplayed());
					logout.click();

					String currentUrl = driver.getCurrentUrl();
					if(currentUrl.contains("index.php"))
						System.out.println("\nResult : Test Pass!!");
					else
						System.out.println("\nResult : Test Fail!!");	
					
					driver.close();

}
}
