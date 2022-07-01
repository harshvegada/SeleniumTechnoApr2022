package sanchit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC7_StandAlone {
	
	final String username = "admin";
	final String password = "Vc0@vIHqZ3";
	String newOrganizationName = "ASD2";
	// Actual Organization Name- OrangeHRM (Pvt) Ltd(Parallel Demo)

	@Test
	public void tc7() {

		System.out.println("STEP - Launch Chrome brower");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("STEP - Load URL");
		driver.get("https://technosanchit-trials7501.orangehrmlive.com/");
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
		System.out.println("VERIFY: Clicked on login button");

		System.out.println("STEP: Click on HR Administration tab");
		driver.findElement(By.xpath("//a[@class=' main-menu-item-1']//span[text()='HR Administration']")).click();
		System.out.println("VERIFY: HR Administration page displayed");

		System.out.println("STEP: Click on Organization menu tab");
		driver.findElement(By.partialLinkText("Organization")).click();
		System.out.println("VERIFY: Organization menu tab expands");

		System.out.println("STEP: Click on General Information option");
		driver.findElement(By.partialLinkText("General Information")).click();
		System.out.println("VERIFY: Genaral Information section displayed");

		System.out.println("STEP: Change Organization Name");
		WebElement orgNameElement = driver.findElement(By.xpath("//input[@id='name']"));
		orgNameElement.clear();
		orgNameElement.sendKeys(newOrganizationName);

		String currentOrgName = orgNameElement.getAttribute("value");
		Assert.assertTrue(currentOrgName.equals(newOrganizationName));
		System.out.println("VERIFY: Organization Name changed as '" + newOrganizationName + "'");

		System.out.println("STEP: Verify 'Number of Employees' field is disabled");
		boolean isNumOfEmpFieldEnabled = driver.findElement(By.xpath("//input[@id='numemp']")).isEnabled();
		Assert.assertFalse(isNumOfEmpFieldEnabled);
		System.out.println("VERIFY: Field 'Number of Employees' is disabled");

		System.out.println("STEP: Save the information");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		System.out.println("VERIFY: Updated information saved");

		System.out.println("STEP: Mouse hover on user profile and click on Setting icon");
		WebElement userProfileElement = driver.findElement(By.xpath("//div[@class='image-container']/img"));
		WebElement userProfileSettingsElement = driver
				.findElement(By.xpath("//a[@class='password-action profile-context-menu-handler']/i"));
		Actions actions = new Actions(driver);
		actions.moveToElement(userProfileElement).click(userProfileSettingsElement).build().perform();
		System.out.println("VERIFY: Mouse hovered on user profile and clicked on setting icon");

		System.out.println("STEP: Click on about section");
		driver.findElement(By.xpath("//a[@id='aboutDisplayLink']")).click();
		System.out.println("VERIFY: User about popup displayed");

		System.out.println("STEP: Verify that updated Organization name displayed as '" + newOrganizationName + "'");
		String updatedOrgName = driver.findElement(By.xpath("//div[@id='companyInfo']/div/div[1]/p")).getText()
				.split(":")[1].trim();
		Assert.assertEquals(updatedOrgName, newOrganizationName);
		System.out.println("VERIFY: Updated Organization name is '" + newOrganizationName + "'");

		driver.close();
		System.out.println("-:Current browser instance closed:-");
	}
}
