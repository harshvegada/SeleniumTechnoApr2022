package alka;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
public class TestCase1_TestCase7 {
	WebDriver driver;
	@Test
	public void testcase_1()
	{
		driver=  setUp();
		System.out.println("VERIFY:Logo displayed on LOgin page");
		boolean isLogoDisplayed=isLogoDisplayed();
		Assert.assertTrue(isLogoDisplayed);
		System.out.println("VERIFY:Login panel displayed on Login page");
		boolean isLoginPanelDisplayed=isLoginPanelDisplayed();
		Assert.assertTrue(isLoginPanelDisplayed);
		final String username= "Admin";
		final String password="iJe60@vBNJ";
		System.out.println("STEP- Enter username");
		enterUsername(username);
	  	System.out.println("STEP- Enter password");
		enterPassword(password);
		System.out.println("VERIFY- user able to enter username");
	  	String actualUserName=getUserName();
	  	Assert.assertEquals(actualUserName, username);
	  	System.out.println("VERIFY- user able to enter password");
		String actualPassword=getPassword();
		Assert.assertEquals(actualPassword, password);
		System.out.println("User  Click on Login Button on Login Page");
		clickOnLoginButton();
		System.out.println("VERIFY-url ends with Dashboard");
		Assert.assertTrue(getCurrentUrl().endsWith("dashboard"));
	}
	public  String getCurrentUrl()
	{
		return driver.getCurrentUrl();
	}
	
	@Test
	public void testcase_7()
	{
		
		System.out.println("Click on HR Adminstration Tab");
		verifyCompanyNameReflection();	
	}
	 
   	static public WebDriver setUp(String url )
	{
		System.out.println("Launch Chrome Browser");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		System.out.println("Step-Load URL ");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}
	static public WebDriver setUp()
	{
		return setUp("https://alkaorg-trials7501.orangehrmlive.com/client/#/dashboard");
	}
	public void verifyCompanyNameReflection()
	{
		System.out.println("Click on HR Administration Tab");
	    driver.findElement(By.xpath("//a[@data-automation-id='menu_admin_viewSystemUsers']/span")).click();	
		System.out.println("Click on Organization Tab");
		 driver.findElement(By.xpath("//a[text()='Organization ']")).click();
	    System.out.println("Click on General Information Tab");
		 driver.findElement(By.partialLinkText("General Information")).click();
		System.out.println("Change Organization Name");
		 driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Technocredits");
		 System.out.println("Verify No. of Employees field is disabled ");
	     Assert.assertFalse(driver.findElement(By.xpath("//input[@id='numemp']")).isEnabled()); 	 
	     System.out.println("User Save Information");
	     driver.findElement(By.xpath("//button[text()='Save']")).click();
	     WebElement toastMesageElement=driver.findElement(By.xpath("//div[@class='toast-message']"));
	   	 Assert.assertTrue(toastMesageElement.isDisplayed());
		 System.out.println("Verify:Toast message is displayed");
		 System.out.println("Mouse Hover on User profile and click on Setting Icon");
		 WebElement profileElement=driver.findElement(By.xpath("//div[@class='image-container']"));
		 Actions action=new Actions(driver);
		 action.moveToElement(profileElement).click(driver.findElement(By.xpath("//a[@class='password-action profile-context-menu-handler']/i")));
		 System.out.println("Click on About Section");
		 driver.findElement(By.id("aboutDisplayLink")).click();
		 String companyName= driver.findElement(By.xpath("//div[@id='companyInfo']/div/div[1]/p")).getText();
	     String strCompanyName=companyName.split(":")[1].trim();
	     Assert.assertEquals(strCompanyName,"Technocredits");
	}
	
	
	 public boolean isLogoDisplayed()
	   {
			
		   try
		   {
			   WebElement e=driver.findElement(By.xpath("//div[@class='organization-logo shadow']/img"));
			   return e.isDisplayed();
		   }
		   catch(NoSuchElementException ne)
		   {
			   return false;
		   }
	   }
	   
	   public boolean isLoginPanelDisplayed()
	   {
		   try
		   {
			    return driver.findElement(By.xpath("//div[@class='login-form shadow']")).isDisplayed();
		   }
		   catch(NoSuchElementException ne)
		   {
			   return false;
		   }
	   }

	   public void enterUsername(String username)
		{
			driver.findElement(By.xpath("//input[@id='txtUsername']")).clear();
			driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
		}
		public void enterPassword(String password)
		{
			driver.findElement(By.xpath("//input[@id='txtPassword']")).clear();
			driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
		}
		public String getUserName()
		{
			return driver.findElement(By.xpath("//input[@id='txtUsername']")).getAttribute("value");
		}
		public String getPassword()
		{
			return driver.findElement(By.xpath("//input[@id='txtPassword']")).getAttribute("value");
		}
		public void clickOnLoginButton()
		{
			driver.findElement(By.xpath("//div[@class='button-holder']//button")).click();
			
		}
		
}
