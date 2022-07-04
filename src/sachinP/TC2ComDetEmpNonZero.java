package sachinP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC2ComDetEmpNonZero {
	
	
	@Test
	public void TC2ComDetEmpNonZero() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://techsachin-trials7501.orangehrmlive.com/securityAuthentication/retryLogin");
		System.out.println("STEP: Navigate to URL");

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		System.out.println("STEP: Entered user name");

		driver.findElement(By.id("txtPassword")).sendKeys("@ugF02HCjL");
		System.out.println("STEP: Entered password");

		driver.findElement(By.xpath("//button[@id='btnLogin']")).click();
		System.out.println("STEP: click on login button");
		
		WebElement profileDisplay= driver.findElement(By.xpath("//div[@class='image-container']/img"));
		Assert.assertTrue(profileDisplay.isDisplayed());
		System.out.println("VERIFY: User profile displayed");
		
		Actions action = new Actions(driver);
		action.moveToElement(profileDisplay).click(driver.findElement(By.xpath("//a[@class='password-action profile-context-menu-handler']/i"))).build().perform();
		
		System.out.println("STEP: Mouse Over on profile");
		
		
		
		
		//driver.close();
		
	}

}
