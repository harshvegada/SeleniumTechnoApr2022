package amar_StandAloneCase;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC4_StandAlone {
	
	final String username = "admin";
	final String password = "C@sRqq3L4U";

	@Test
	public void tc4() {

		System.out.println("STEP - Launch Chrome brower");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("STEP - Load URL");
		driver.get("https://technoamar-trials7501.orangehrmlive.com/");
		driver.manage().window().maximize();

		System.out.println("STEP - Enter username");
		WebElement usernameElement = driver.findElement(By.xpath("//input[@id='txtUsername']"));
		usernameElement.sendKeys(username);
		String actualUsername = usernameElement.getAttribute("value");
		Assert.assertEquals(actualUsername, username);
		System.out.println("VERIFY - Username Entered");

		System.out.println("STEP - Enter password");
		WebElement passwordElement = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		passwordElement.sendKeys(password);
		String actualPassword = passwordElement.getAttribute("value");
		Assert.assertEquals(actualPassword, password);
		System.out.println("VERIFY - Password Entered");

		System.out.println("STEP - User click on Login button on Login Page");
		driver.findElement(By.xpath("//div[@class='button-holder']/button")).click();

		System.out.println("STEP: Click on Employee Management tab");
		driver.findElement(By.xpath("//a[@id='menu_item_37'][1]/span[text()='Employee Management']")).click();

		System.out.println("STEP: Click on My Info tab");
		driver.findElement(By.xpath("//a[contains(text(),'My Info')]")).click();

		System.out.println("STEP: Verify user Personal info displayed");
		boolean isFirstNameDisplayed = driver.findElement(By.xpath("//input[@id='firstName']")).isDisplayed();
		Assert.assertTrue(isFirstNameDisplayed);

		System.out.println("STEP: Click on Salary");
		driver.findElement(By.partialLinkText("Salary")).click();

		System.out.println("STEP: Check the payable (CTC) amount is non-zero");
		int ctc = Integer.parseInt(
				driver.findElement(By.xpath("//div[@class='summary-card col-6'][1]/div[contains(text(),'$')]"))
						.getText().replace("$", "").replace(",", "").replace(".", ":").split(":")[0]);
		Assert.assertTrue(ctc > 0);

		driver.close();
		System.out.println("-:Current browser instance closed:-");
	}

}
