package dipali;
/*"1. Launch https://<your server name>-trials71.orangehrmlive.com/auth/login
2. User able to enter username as ""your username""
3. User able to enter password as ""your password""
4. User click on login button
5. User click on Employee Management tab
6. Click on My Info tab
7. Verify user Personal info displayed
8. Click on ""Salary""
9. Check the payable (CTC) amount is non-zero"*/

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase4 {
	@Test	
	void VerifyPayableAmountIsNonZero() {
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

		System.out.println("Step--click on Employee Management tab");
		driver.findElement(By.xpath("//a[@data-automation-id='menu_pim_viewEmployeeList' and @class='main-menu-item-1 active' ]")).click();

		System.out.println("Step--Click on My Info tab");
		driver.findElement(By.xpath("//div[@unique-name='uniqueName']//a[@data-automation-id='menu_pim_viewMyDetails']")).click();

		System.out.println("Step--Verify user Personal info displayed");
		boolean isPersonalInforDisplayed=driver.findElement(By.id("firstName")).isDisplayed();
		Assert.assertTrue(isPersonalInforDisplayed);

		System.out.println("Step--Click on Salary");
		driver.findElement(By.xpath("//div[@unique-name='uniqueName']//a[@data-automation-id='menu_employee_profile_Salary']")).click();

		System.out.println("Step--Check the payable (CTC) amount is non-zero");
		String s=driver.findElement(By.xpath("//div[contains(text(),\"$\") and @class='summary-card-column summary-card-right' and @ng-bind='vm.getFormattedSalaryValue(vm.calculatedSalaryValues.summary.costToCompany)' ]")).getText();
		 String value=s.replace("$","").replace(",", "");
		 String fvalue=value.substring(0, value.indexOf('.'));
		 int ctcValue=Integer.parseInt(fvalue);
		 	boolean isCTCNonZero=false;
		 		if(ctcValue>0) {
		 			isCTCNonZero= true;
		 		}else
		 			isCTCNonZero= false;
		   Assert.assertTrue(isCTCNonZero);

		   System.out.println("System end");
		   driver.close();


	}


}