package omkarExam;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Exam2 {
	
	private WebDriver driver;
	
	void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver=new ChromeDriver();
		
		System.out.println("Step- Launched the URL");
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("Step - clicked on login");
		driver.findElement(By.xpath("//a[@class='login']")).click();		
		verifyUrl();
	}
	
	void verifyUrl() {
		System.out.println("\nSTEP : Get current URL");

		String currentUrl = driver.getCurrentUrl();
		if(currentUrl.contains("my-account"))
			System.out.println("\nResult : Test Pass!!");
		else
			System.out.println("\nResult : Test Fail!!");
		
	}
	
	void formFillup() {
		
		String name= "Omkar";
		String lastName="Raut";
		System.out.println("Step- entering the email ID ");
		WebElement email=driver.findElement(By.xpath("//input[@name='email_create']"));
		email.sendKeys("rautom0@gmail.com");
		System.out.println("Step - Click on Submit");
		driver.findElement(By.xpath("//button[@name='SubmitCreate']")).click();
		System.out.println("Step - select gender");
		driver.findElement(By.xpath("//input[@id='id_gender1']")).click();	
		
		System.out.println("Step -first name");		
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys(name);		
		
		System.out.println("Step - last name");
		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys(lastName);
		
		System.out.println("Step -password");
		driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys("12345679");
						
		System.out.println("Step -Birth Date");
		Select se=new Select(driver.findElement(By.xpath("//select[@id='days']")));
		se.selectByValue("11");
		
		Select sem=new Select(driver.findElement(By.xpath("//select[@id='months']")));
		sem.selectByValue("8");
		
		Select sey=new Select(driver.findElement(By.xpath("//select[@id='years']")));
		sey.selectByValue("1990");
		
		driver.findElement(By.xpath("//label[@for='optin']")).click();
		
		System.out.println("Step -compony name");
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Hexaware");
		
		System.out.println("Step -address");
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("Pune");
		
		System.out.println("Step -city ");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Pune");
		
		System.out.println("Step -state");
		Select state=new Select(driver.findElement(By.xpath("//select[@name='id_state']")));
		state.selectByValue("30");
		
		System.out.println("Step -postal code");
		driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys("98765");
		
		System.out.println("Step -Mobile Number");
		driver.findElement(By.xpath("//input[@name='phone_mobile']")).sendKeys("0987765432");
		
		System.out.println("Step -address");
		driver.findElement(By.xpath("//input[@value='My address']")).sendKeys("pune");
		
		System.out.println("Step -click on register");
		driver.findElement(By.xpath("//span[text()='Register']")).click();
		
		verifyUrl();
		
		WebElement nameLastName= driver.findElement(By.xpath("//a[@class='account']"));
		String fullName=nameLastName.getText();
		if(fullName.equals(name+" "+lastName)) {
			System.out.println("Both names are same"+fullName);
		}else
			System.out.println("Both names are not same");
		verifyUrl();
	}
	
	@Test
	void verifyDisplay() {
		launchBrowser();
		formFillup();
		WebElement logout=driver.findElement(By.xpath("//a[@class='logout']"));
		System.out.println(logout.isDisplayed());
		logout.click();
		
		String currentUrl = driver.getCurrentUrl();
		if(currentUrl.contains("index.php"))
			System.out.println("\nResult : Test Pass!!");
		else
			System.out.println("\nResult : Test Fail!!");		
	}	
}
