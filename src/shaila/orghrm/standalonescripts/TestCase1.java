/*
 * 1. Launch https://<your server name>-trials71.orangehrmlive.com/auth/login
2. Verify Logo displayed on Login Page
3. Verify Login Panel displayed on Login Page
4. User able to enter username as ""your username""
5. User able to enter password as ""your password""
6. User click on Login button on Login Page
7. User should navigate to home page, Verify "Employee Management" header should be visible.

 */
package shaila.orghrm.standalonescripts;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCase1 {

	static WebDriver driver =null;
	void BrowserLaunchSetup(String url)
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	void loginTest() {
		System.out.println("STEP - Enter userName");
		WebElement usernameElement = driver.findElement(By.xpath("//input[@id='txtUsername']"));
		usernameElement.sendKeys("Admin");

		System.out.println("VERIFY - User able to enter username");
		String actualUserName = usernameElement.getAttribute("value");
		Assert.assertEquals(actualUserName, "Admin");

		System.out.println("STEP - Enter password");
		WebElement passwordElement = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		passwordElement.sendKeys("5N@f8UhNPd");

		System.out.println("VERIFY - User able to enter password");
		String actualPassword = passwordElement.getAttribute("value");
		Assert.assertEquals(actualPassword, "5N@f8UhNPd");

		System.out.println("VERIFY - User click on Login button on Login Page");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
	}
	
	
	void isLinkDisplayed()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean isEmployee_Management=driver.findElement(By.xpath("//div[text()='Employee Management']")).isDisplayed();
		Assert.assertTrue(isEmployee_Management);
	}
	
	
	@Test
	void VerifyloginFunctionality() {
		System.out.println("STEP:-- Launch https://<your server name>-trials71.orangehrmlive.com/auth/login");
		BrowserLaunchSetup("https://javaselenium22-trials7501.orangehrmlive.com/auth/seamlessLogin");
		boolean islogoDisplayed=driver.findElement(By.xpath("//img[@src='/webres_628cd494f1b2b1.12910610/themes/default/images/login/logo.png']")).isDisplayed();
		Assert.assertTrue(islogoDisplayed);
		
		System.out.println("VERIFY - Login Panel displayed on Login Page");
		boolean isLoginPanelDisplayed = driver.findElement(By.xpath("//div[@class='login-form shadow']")).isDisplayed();
		Assert.assertTrue(isLoginPanelDisplayed);
		
		System.out.println("Verify Login Functionality");
		loginTest();
		System.out.println("User should navigate to home page, Verify 'Employee Management' header should be visible.");
		isLinkDisplayed();
		driver.close();
		}
}

	
	
	
		
	