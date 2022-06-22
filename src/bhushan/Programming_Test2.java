package bhushan;
/*Automate below scenario

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
Exam - 2 : 22nd Jun'2022*/
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Programming_Test2 {
	
	void createRegistration() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("Click on Sign in");
			driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
		System.out.println("Enter Email id");
			driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("bgadakh2032@gmail.com");
		System.out.println("Scroll down");
			JavascriptExecutor js= (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,300)");
		System.out.println("click on submit");
			driver.findElement(By.xpath("//i[@class='icon-user left']")).click();
		System.out.println("Select Gender");
			driver.findElement(By.id("id_gender1")).click();
		System.out.println("Enter Fisrt Name");
			driver.findElement(By.id("customer_firstname")).sendKeys("Bhushan");
		System.out.println("Enter Last Name");
			driver.findElement(By.id("customer_lastname")).sendKeys("gdk");
		System.out.println("Enter Password");
			driver.findElement(By.id("passwd")).sendKeys("Bhushan1234");
		System.out.println("Select Date ");
			Select sel=new Select(driver.findElement(By.xpath("//select[@id='days']")));
			sel.selectByValue("20");
		System.out.println("Select Month ");
			Select sel1=new Select(driver.findElement(By.xpath("//select[@id='months']")));
			sel1.selectByValue("11");
		System.out.println("Select year ");
			Select sel2=new Select(driver.findElement(By.xpath("//select[@id='years']")));
			sel2.selectByValue("2001");
		System.out.println("Enter Address ");
			driver.findElement(By.id("address1")).sendKeys("india india ");
		System.out.println("Enter City ");
			driver.findElement(By.id("city")).sendKeys("nsknsk ");
		System.out.println("Select state ");
			Select selstate=new Select(driver.findElement(By.id("id_state")));
			selstate.selectByValue("15");
		System.out.println("enter Postal Code ");
			driver.findElement(By.id("postcode")).sendKeys("37201");
		System.out.println("select countary ");
			driver.findElement(By.id("id_country")).click();
		System.out.println("enter Mobile No ");
			driver.findElement(By.id("phone_mobile")).sendKeys("9999888877");
		System.out.println("Assign Referance ");
			driver.findElement(By.id("alias")).clear();
			driver.findElement(By.id("alias")).sendKeys("Hihellow");
		System.out.println("Click on Registration Button");
			driver.findElement(By.id("submitAccount")).click();
		System.out.println("Verify the title should contains My Account keyword");
			String name=driver.findElement(By.xpath("//span[@class='navigation_page']")).getText();
			if(name.contains("My account")) {
				System.out.println("Login page verified ok");
			}else
				System.out.println("Login page not verified ok");
		System.out.println("Verify user name");
			String username=driver.findElement(By.xpath("//a[@title='View my customer account']")).getText();
			System.out.println(username);
			if(username.contains("Bhushan") && username.contains("gdk")) {
				System.out.println("user name verified ok");
			}else
				System.out.println(" user name not verified ok");
		System.out.println("Verify Signout button");
			System.out.println(driver.findElement(By.xpath("//a[@class='logout']")).isDisplayed()+"  is displayed");
		System.out.println("Click on Signout Button");
			driver.findElement(By.xpath("//a[@class='logout']")).click();
		System.out.println("Click on Signout successfully");
		System.out.println("Verify you landed on Login screen");
			System.out.println(driver.getTitle());
			String titleofPage=driver.getTitle();
		if(titleofPage.equals("Login - My Store")) {
			System.out.println("Title page verified ok");
		}else {
			System.out.println("Title page not verified ok");
		}
		
			
	}
public static void main(String[] args) {
	Programming_Test2 test2=new Programming_Test2();
	test2.createRegistration();
}
}
