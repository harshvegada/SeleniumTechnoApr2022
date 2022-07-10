package pragati;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_1 {
	private WebDriver driver;

	void setUp(String url) {
		System.out.println("STEP:Launch Browser");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();

	}

	@Test
	public void loginTest() {
		setUp("https://technopragati-trials7501.orangehrmlive.com/auth/seamlessLogin");

		System.out.println("VERIFY - Logo displayed on Login Page");
		boolean isLogoDisplayedFlag = driver.findElement(By.xpath("//div[@class='organization-logo shadow']/img"))
				.isDisplayed();
		Assert.assertTrue(isLogoDisplayedFlag);

		System.out.println("VERIFY - Login Panel displayed on Login Page");
		boolean isLoginFormDisplayed = driver.findElement(By.xpath("//div[@class='login-form shadow']")).isDisplayed();
		Assert.assertTrue(isLoginFormDisplayed);

		System.out.println("STEP - Enter userName");
		WebElement usernameElement = driver.findElement(By.xpath("//input[@id='txtUsername']"));
		usernameElement.sendKeys("Admin");

		System.out.println("VERIFY - User able to enter username");
		String actualUserName = usernameElement.getAttribute("value");
		Assert.assertEquals(actualUserName, "Admin");

		System.out.println("STEP - Enter password");
		WebElement passwordElement = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		passwordElement.sendKeys("oVD1lqX5@Z");

		System.out.println("VERIFY - User able to enter password");
		String actualPassword = passwordElement.getAttribute("value");
		Assert.assertEquals(actualPassword, "oVD1lqX5@Z");

		System.out.println("VERIFY - User click on Login button on Login Page");
		driver.findElement(By.xpath("//button[text()='Login']")).click();

		System.out.println("VERIFY - Employee Management header should be visible.");
		boolean isEmpManagementDisplayed = driver.findElement(By.xpath("//div[text()='Employee Management']"))
				.isDisplayed();
		Assert.assertTrue(isEmpManagementDisplayed);
	}
}