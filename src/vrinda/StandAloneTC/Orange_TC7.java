package vrinda.StandAloneTC;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Orange_TC7 {
	private WebDriver driver;
	void launchBrowser(String url){
	System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
	driver = new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	}

	@Test
	public void HRAdministration() {
		System.out.println(" Step : \"1. Launch https://<your server name>-trials71.orangehrmlive.com/auth/login");
		launchBrowser("https://vrinda-trials7501.orangehrmlive.com/");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		System.out.println(" Step : Enter User Name");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		
		System.out.println(" Step : Enter Password");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("H5@n5njQKR");
		
		System.out.println(" Step : Click on Submit button");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		System.out.println(" Verify: User profile is Display on UI");
		WebElement isUserProfileDisplay = driver.findElement(By.xpath("//div[@class='image-container']/img"));
		Assert.assertTrue(isUserProfileDisplay.isDisplayed());
		
		driver.findElement(By.xpath("//li[@id='left_menu_item_1']")).click();
		System.out.println("Step: Click on HR Administration");
		
		driver.findElement(By.xpath("//a[text()='Organization ']")).click();
		System.out.println("Step: Click On Orgnization tab");
		
		driver.findElement(By.xpath("//a[@data-automation-id='menu_admin_viewOrganizationGeneralInformation']")).click();
		System.out.println("Step: Click on  General Information ");
		
		WebElement orgnizationNameElement=driver.findElement(By.xpath("//input[@id='name']"));
		orgnizationNameElement.clear();
		System.out.println("Step: clear the text field");
		orgnizationNameElement.sendKeys("Java-Selenium");
		System.out.println("Step: new orgnization is updated");
		
		WebElement numberOfEmployeeElement=driver.findElement(By.xpath("//input[@id='numemp']"));
		Assert.assertFalse(numberOfEmployeeElement.isEnabled());
		System.out.println("Verify: numbers of employee field is disable");
		
		driver.findElement(By.xpath("//button[@class=' btn waves-effect waves-green ']")).click();
		System.out.println("Step: Click on Save button");
		
		WebElement successfullUpdatedElement=driver.findElement(By.xpath("//div[text()='Successfully Updated']"));
		Assert.assertTrue(successfullUpdatedElement.isDisplayed());
		System.out.println("Verify: Data successfull updated");
	
		WebElement usserProfileElement=driver.findElement(By.xpath("//div[@class='image-container']/img"));
		Actions actions=new Actions(driver);
		actions.moveToElement(usserProfileElement).click(driver.findElement(By.xpath("//a[@class='password-action profile-context-menu-handler']/i"))).build().perform();
		System.out.println("Step: move hover 0n profile and click on setting icon");
		
		driver.findElement(By.id("aboutDisplayLink")).click();
		System.out.println("Step: click on About tab");
		
		String companyName=driver.findElement(By.xpath("//div[@id='companyInfo']/div/div[1]/p")).getText();
		Assert.assertTrue(companyName.contains("Java-Selenium"));
		Assert.assertEquals(companyName.split(": ")[1],"Java-Selenium");
		System.out.println("Verify:Updated Orgnization name should display"); 
	}
}
