package madhuriR;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestCase7{
	protected static WebDriver driver;
	public void setUp(String url) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	@BeforeClass
	public void setUp() {
		setUp("https://apr22madhuri-trials7501.orangehrmlive.com/");
	}
	public void login() {
		driver.findElement(By.xpath("//input[@id=\"txtUsername\"]")).sendKeys("Admin");
		
		driver.findElement(By.xpath("//input[@id=\"txtPassword\"]")).sendKeys("cW@OfXD40d");
		
		//System.out.println("Click on login");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
	
	}
	@Test
	public void testCase7() {
		System.out.println("Login with valid credential");
		login();
		System.out.println("Click on HR Administration");
		driver.findElement(By.xpath("//li[@id='left_menu_item_1']")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Organization ')]")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),' General Information ')]")).click();
		System.out.println("Edit oranization name");
		WebElement orgNameElement = driver.findElement(By.xpath("//input[@id='name']"));
		orgNameElement.clear();
		orgNameElement.sendKeys("Technocredits");
		
		System.out.println("Check number field is disable or not");
		WebElement numberOfEmpelement = driver.findElement(By.xpath("//input[@id='numemp']"));
		boolean isDisable = numberOfEmpelement.isEnabled();
		Assert.assertFalse(isDisable);
		
		System.out.println("click on save button and check tost message is displayed or not");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		boolean tostMesaageDisplayed = driver.findElement(By.xpath("//div[@class='toast-message']")).isDisplayed();
		Assert.assertTrue(tostMesaageDisplayed);
		
		System.out.println("Mouse moveHover on user profile and click on setting button");
		WebElement userProfileElement = driver.findElement(By.xpath("//div[@class='image-container']"));
		Actions acts = new Actions(driver);
		acts.moveToElement(userProfileElement).build().perform();
		driver.findElement(By.xpath("//a[@class='password-action profile-context-menu-handler']")).click();
		
		System.out.println("click on about");
		driver.findElement(By.xpath("//a[@id='aboutDisplayLink']")).click();
		
		System.out.println("verify company name is same or not");
		String comapnyName = driver.findElement(By.xpath("//div[@class='row']/div[1]/p")).getText();
		String cmpName = comapnyName.split(": ")[1];
		Assert.assertEquals(cmpName,"Technocredits");
	}
	@AfterTest()
	public void closeDriver() {
		driver.close();
	}

}
