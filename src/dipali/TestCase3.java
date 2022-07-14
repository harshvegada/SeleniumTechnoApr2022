package dipali;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

/*"1. Launch https://<your server name>-trials71.orangehrmlive.com/auth/login
2. User able to enter username as ""your username""
3. User able to enter password as ""your password""
4. User click on Login button on Login Page
5. Verify User profile is displayed
6. Mouse Hover on Profile and Click on setting icon on profile
7. Verify user menu total 2 options are displayed (About, Change Password) on after click on setting icon.
8. Click on About
9. Verify Employee is more than 0
10. Verify the company details  fields are getting displayed on information alert (Company Name, Version, Employees, Users & Renewal on)
11. Click on OK button on popup."*/
public class TestCase3 {
	@Test
	void VerifyCompanyDetailsandEmployyesarenonzero() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver=new ChromeDriver();
		System.out.println("Step-- Launch Browser  ");
		driver.get("https://technodipali-trials7501.orangehrmlive.com/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		System.out.println("Step-- Verify Logo displayed on Login Page ");
		boolean isLogoDisplayed=driver.findElement(By.xpath("//div[@class='organization-logo shadow']")).isDisplayed();
		Assert.assertEquals(isLogoDisplayed, true);

		System.out.println("Step-- Verify Login Panel displayed on Login Page ");
		boolean isLoginPanelDisplayed=driver.findElement(By.xpath("//div[@class='login-form shadow']")).isDisplayed();
		Assert.assertEquals(isLoginPanelDisplayed, true);

		System.out.println("Step-- User able to enter username as your username ");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		String actualUserName=driver.findElement(By.id("txtUsername")).getAttribute("value");
		String expectedUsername="Admin";
		Assert.assertEquals(actualUserName, expectedUsername);

		System.out.println("Step-- User able to enter username as your password ");
		driver.findElement(By.id("txtPassword")).sendKeys("2Nm5@ZZhCv");
		String actualPassword=driver.findElement(By.id("txtPassword")).getAttribute("value");
		String expectedPassword="2Nm5@ZZhCv";
		Assert.assertEquals(actualPassword, expectedPassword);

		System.out.println("Step-- User click on Login button on Login Page ");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		System.out.println("Step-- Verify User profile is displayed ");
		boolean isProfileDisplayed=driver.findElement(By.xpath("//div[@class='image-container']")).isDisplayed();
		Assert.assertTrue(isProfileDisplayed);

		System.out.println("Step--  Mouse Hover on Profile and Click on setting icon on profile ");
		WebElement element=driver.findElement(By.xpath("//div[@class='image-container']"));
		Actions actions=new Actions(driver);
		actions.moveToElement(element).build().perform();
		driver.findElement(By.xpath("//a[@class='password-action profile-context-menu-handler']/i[@class='material-icons']")).click();

		System.out.println("Step--  Verify user menu total 2 options are displayed (About, Change Password) on after click on setting icon. ");
		List<WebElement> actList=	driver.findElements(By.xpath("//div[@class='sub-menu-container-php profile-context-menu-handler opened']//a[@class='sub-menu-item-link truncate']"));
	    List<String> actualList=new ArrayList<>();
	    	for(WebElement elements:actList) {
	    	actualList.add(elements.getText());	
	    	}
	    List<String> expectedList=new ArrayList<String>();
			expectedList.add("Change Password");
			expectedList.add("About");
		Assert.assertEquals(expectedList, actualList);

		System.out.println("Step--  Click on About");
		driver.findElement(By.id("aboutDisplayLink")).click();

		System.out.println("Step--  Verify Employee is more than 0");
		String input=driver.findElement(By.xpath("//div[@class='col s12'][3]")).getText();
		boolean isCountGretorthanZero=false;
		String[] arr=input.split(" ");
		int count=Integer.parseInt(arr[1]);
			if(count>0) {
				isCountGretorthanZero= true;
			}else
				isCountGretorthanZero= false;
		Assert.assertTrue(isCountGretorthanZero);

		System.out.println("Step--  Verify the company details  fields are getting displayed on information alert");
		int forloopendCount=driver.findElements(By.xpath("//div[@class='col s12']")).size();
		List<String> actLists=new ArrayList<String>();
			for(int index=1;index<=forloopendCount;index++) {
				String inputis=driver.findElement(By.xpath("//div[@class='col s12']["+index+"]")).getText();
				String []arr2=inputis.split(":");
				String firstWord=arr2[0];
				actLists.add(firstWord);
			}
		List<String> expectednameList=new ArrayList<String>();
			expectednameList.add("Company Name");
			expectednameList.add("Version");
			expectednameList.add("Employees");
			expectednameList.add("Users");
			expectednameList.add("Renewal on");
		Assert.assertEquals(actLists, expectednameList);

		System.out.println("Step--  Click on OK button on popup");
		driver.findElement(By.id("heartbeatSubmitBtn")).click();

		System.out.println("Driver Close");
		driver.close();

     }
}