/*Login Testcase: 
 
"1. Launch https://<your server name>-trials71.orangehrmlive.com/auth/login
2. Verify Logo displayed on Login Page
3. Verify Login Panel displayed on Login Page
4. User able to enter username as ""your username""
5. User able to enter password as ""your password""
6. User click on Login button on Login Page
7. User should navigate to home page, Verify "Employee Management" header should be visible.
*/

package arti.standalonescripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC1_LoginTest {

	private WebDriver driver;
	
	public void loginTest() {
	
		System.out.println("STEP - Launch browser");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
		System.out.println("STEP - Load URL");
		driver.get("https://artitechno-trials7501.orangehrmlive.com/");

	
		System.out.println("VERIFY - Logo is displayed on the Login Page");
		boolean isLogoDisplayed = driver.findElement(By.xpath("//div[@class='organization-logo shadow']/img")).isDisplayed();;
		if(isLogoDisplayed)
			System.out.println("Logo is displayed on the Login Page");
		
		System.out.println("VERIFY - Login Panel displayed on Login Page");
		boolean isLoginFormDisplayFlag = driver.findElement(By.xpath("//div[@class='login-form shadow']")).isDisplayed();;
		if(isLoginFormDisplayFlag)
			System.out.println("Login form is displayed");
		
		final String username = "Admin";
		final String password = "6cyNOTm3N@";
		
		System.out.println("STEP - Enter username");
		WebElement usernameElement = driver.findElement(By.xpath("//input[@id='txtUsername']"));
		usernameElement.sendKeys(username);
		
		System.out.println("VERIFY - User able to enter username");
		String actualUsername = driver.findElement(By.xpath("//input[@id='txtUsername']")).getAttribute("value");
		if(actualUsername.equals(username))
			System.err.println("User is able to enter the username");
		
		System.out.println("STEP - Enter password");
		WebElement passwordElement = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		passwordElement.sendKeys(password);
		
		System.out.println("VERIFY - User able to enter username");
		String actualPassword = driver.findElement(By.xpath("//input[@id='txtPassword']")).getAttribute("value");
		if(actualPassword.equals(password))
			System.out.println("User is able to enter the password");
		
		System.out.println("STEP - User click on Login button on Login Page");
		driver.findElement(By.xpath("//div[@class='button-holder']/button")).click();
		
		System.out.println("VERIFY - URL endswith dashboard");
		if(driver.getCurrentUrl().endsWith("dashboard"))
			System.out.println("User is on the dashboard page");

		boolean EmpManagementHeaderFlag = driver.findElement(By.xpath("//li[@class='page-title tooltipped title1']//div[text()='Employee Management']")).isDisplayed();
		if(EmpManagementHeaderFlag)
			System.out.println("Employee Management header is displayed");
	
	}
}
