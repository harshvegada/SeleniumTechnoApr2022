/*"1. Launch https://<your server name>-trials71.orangehrmlive.com/auth/login
2. Verify Logo displayed on Login Page
3. Verify Login Panel displayed on Login Page
4. User able to enter username as ""your username""
5. User able to enter password as ""your password""
6. User click on Login button on Login Page
7. Verify ""user_roles"" should contains in URL
8. Verify total 9 widget's are disply on Dashboard page
9. Verify ""Quick Access"", ""Buzz Latest Posts"", ""My Actions"", ""Headcount by Location"", ""Employees on Leave Today"", ""Time At Work"", ""Latest Documents"", ""Latest News"" and  ""COVID-19 Report"" is displayed on Dashboard Page
"*/

package tamanna.OrangeHRM;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC2 {

	WebDriver driver;
	TC2(){
		driver=PredefinedActions.setUp();
	}
	
	// 2. Verify Logo displayed on Login Page
		@Test
		void S1verifyLogo() {
			WebElement element = driver.findElement(By.xpath("//div[@class='organization-logo shadow']"));
			Assert.assertTrue(element.isDisplayed());
		}

		// 3. Verify Login Panel displayed on Login Page
		@Test
		void S2verifyLogInPanel() {
			WebElement element = driver.findElement(By.xpath("//div[@class='login-form shadow']"));
			Assert.assertTrue(element.isDisplayed());
		}

		// 4. User able to enter username as """"your username""""
		@Test
		void S3verifyUserNameEntry() {
			WebElement element = driver.findElement(By.id("txtUsername"));
			element.clear();
			element.sendKeys("Admin");
			Assert.assertEquals(element.getAttribute("value"), "Admin");
		}

		// 5. User able to enter password as """"your password""""
		@Test
		void S4verifyPasswordEntry() {
			WebElement element = driver.findElement(By.id("txtPassword"));
			element.clear();
			element.sendKeys("f0WV3@MqHp");
			Assert.assertEquals(element.getAttribute("value"), "f0WV3@MqHp");
			clickLoginButton();
		}

		// 6. User click on Login button on Login Page
		void clickLoginButton() {
			WebElement element = driver.findElement(By.xpath("//div[@class='button-holder']/button"));
			element.click();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		
		//7. Verify ""user_roles"" should contains in URL
		@Test
		void S7verifyURL() {
			String url=driver.getCurrentUrl();
			Assert.assertTrue(url.contains("user_roles"));
		}
		
		//8. Verify total 9 widget's are disply on Dashboard page
		@Test
		void S8verifyNoOfWidgets() {
			List<WebElement> listOfWidgets=driver.findElements(By.xpath("//div[@id='widget.id'][not(contains(@class,'ng-hide'))]"));
			Assert.assertEquals(listOfWidgets.size(), 9);
		}
		
		//9. Verify ""Quick Access"", ""Buzz Latest Posts"", ""My Actions"", ""Headcount by Location"", ""Employees on Leave Today"", ""Time At Work"", ""Latest Documents"", ""Latest News"" and  ""COVID-19 Report"" is displayed on Dashboard Page
		@Test
		void S9verifyWidgetHeadings() {
			List<WebElement> listOfWidgets=driver.findElements(By.xpath("//div[@id='widget.id'][not(contains(@class,'ng-hide'))]//div[@class='widget-header']//span[2]"));
			List<String> lstWidgetHeaders=new LinkedList<String>();
			for(WebElement element: listOfWidgets) {
				lstWidgetHeaders.add(element.getText());
			}
			Assert.assertEquals(lstWidgetHeaders, getListOfWidgetHeaders());
		}
		
		List<String> getListOfWidgetHeaders(){
			List<String> lst=new LinkedList<String>();
			lst.add("Quick Access");
			lst.add("Buzz Latest Posts");
			lst.add("My Actions");
			lst.add("Headcount by Location");
			lst.add("Employees on Leave Today");
			lst.add("Time At Work");
			lst.add("Latest Documents");
			lst.add("Latest News");
			lst.add("COVID-19 Report");
			
			return lst;
		}
}
