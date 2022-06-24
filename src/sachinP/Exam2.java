package sachinP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Exam2 {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		System.out.println("Navigate to URL");
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		System.out.println("Click on Sign in button");
		driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
		System.out.println("Verify the URL contains myaccount");
		String currentUrl = driver.getCurrentUrl();
		if(currentUrl.contains("my-account"))
			System.out.println("\nResult : Test Pass!!");
		else
			System.out.println("\nResult : Test Fail!!");
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("s012@gmail.com");
		System.out.println("\nClick on Create an account");
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
		System.out.println("\nFill all the details");
		driver.findElement(By.xpath("//div[@id='uniform-id_gender1']")).click();
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("Sachin");
		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("Pawar");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("Spawar@1234");
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Pune Road 411045");
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("37201");
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("7755990137");
		
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("pune");
		System.out.println("Enter State");
		WebElement state = driver.findElement(By.id("id_state"));
		Select stateSelect = new Select(state);
		stateSelect.selectByValue("8");
		System.out.println("Click on Register button");
		driver.findElement(By.id("submitAccount")).click();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		String title = driver.getTitle();
		System.out.println(title);

		if(title.contains("My account")) {

			System.out.println("\nPage contains My Account keyword");
			System.out.println("\nResult - Test Pass");			
			
			WebElement signOut = driver.findElement(By.xpath("//a[@title='Log me out']"));

			if(signOut.isDisplayed()) {
				System.out.println("\nSign out button is displayed");
				System.out.println("\nResult - Test Pass");
			}

			System.out.println("\nSTEP - Click on `Sign out` button");
			signOut.click();

			System.out.println("Test Case - Verify you landed on Login screen(verify page title)");

			String currentTitle = driver.getTitle();

			if(currentTitle.equals("Login - My Store")) {
				System.out.println("\nYou are navigated to Login page");
				System.out.println("\nResult - Test Pass");
			}
		}		
		driver.close();		
	}
}
