package arti.standalonescripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC7_UpdateOrganizationName {
	
	private WebDriver driver;
	
	@Test
	public void verifyUpdateOrganizationName() {
		
		System.out.println("STEP - Launch browser");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		System.out.println("STEP - Load URL");
		driver.get("https://artitechno-trials7501.orangehrmlive.com/");
		
		System.out.println("VERIFY - User is able to enter the username ");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");

		System.out.println("VERIFY - User is able to enter the password ");
		driver.findElement(By.id("txtPassword")).sendKeys("6cyNOTm3N@");
		
		System.out.println("STEP - User click on Login button on Login Page");
		driver.findElement(By.xpath("//div[@class='button-holder']/button")).click();
		
		System.out.println("STEP -  Click on the HR Administration");
		driver.findElement(By.xpath("//li[@id='left_menu_item_1']//a[1]//span[contains(text(),'HR Administration')]")).click();

		System.out.println("STEP - Click on Organization tab");
		driver.findElement(By.xpath("//a[contains(text(),'Organization ')]")).click();
		
		System.out.println("STEP - User click on General Information tab");
		WebElement generalInfoElement = driver.findElement(By.xpath("//a[contains(text(),'General Information')]"));
		
		Actions action = new Actions(driver);
		action.moveToElement(generalInfoElement).click().build().perform();
		
		System.out.println("STEP - User change Organization Name to Anything");
		WebElement organizationNameElement = driver.findElement(By.xpath("//div[@class='input-field col s12 m12 l4']//input[@id='name']"));
		organizationNameElement.clear();
		organizationNameElement.sendKeys("TechnoCredits");
		
		System.out.println("STEP - Verify Number of Employees field is disabled");
		WebElement NumberOfEmployees = driver.findElement(By.xpath("//div[@class='input-field col s12 m12 l4']//input[@id='numemp']"));
		Assert.assertFalse(NumberOfEmployees.isEnabled()); 
		
		System.out.println("STEP - User save the information");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		WebElement toastMessageElement = driver.findElement(By.xpath("//div[text()='Successfully Updated']"));
		Assert.assertTrue(toastMessageElement.isDisplayed());
		
		System.out.println("STEP - User mouse hover on user profile and click on Settin icon");
		WebElement userProfileElement = driver.findElement(By.xpath("//div[@class='image-container']/img"));
		
		action.moveToElement(userProfileElement).click(driver.findElement(By.xpath("//i[contains(text(),'ohrm_settings')]"))).build().perform();
		
		System.out.println("STEP - Click on About");
		driver.findElement(By.id("aboutDisplayLink")).click();
		
		System.out.println("STEP - Verify that updated Organization name display");
		String companyName = driver.findElement(By.xpath("//div[@class='row']/div[1]/p")).getText();
		companyName = companyName.split(": ")[1];
		Assert.assertEquals(companyName, "TechnoCredits");
		
	}
}
