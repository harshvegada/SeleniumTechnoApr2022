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

package tamanna.OrangeHRM;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC3 {

	WebDriver driver;

	TC3() {
		driver = PredefinedActions.setUp();
	}

	// 2. User able to enter username as """"your username""""
	@Test
	void S2verifyUserNameEntry() {
		WebElement element = driver.findElement(By.id("txtUsername"));
		element.clear();
		element.sendKeys("Admin");
		Assert.assertEquals(element.getAttribute("value"), "Admin");
	}

	// 3. User able to enter password as """"your password""""
	@Test
	void S3verifyPasswordEntry() {
		WebElement element = driver.findElement(By.id("txtPassword"));
		element.clear();
		element.sendKeys("f0WV3@MqHp");
		Assert.assertEquals(element.getAttribute("value"), "f0WV3@MqHp");
		clickLoginButton();
	}

	// 4. User click on Login button on Login Page
	void clickLoginButton() {
		WebElement element = driver.findElement(By.xpath("//div[@class='button-holder']/button"));
		element.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	// 5. Verify User profile is displayed
	@Test
	void S5verifyUserProfile() {
		WebElement element = driver.findElement(By.xpath("//div[@class='picture']"));
		Assert.assertTrue(element.isDisplayed());
	}

	// 6.  Mouse Hover on Profile and Click on setting icon on profile
	@Test
	void S6clickSettingIcon() {
		WebElement element = driver.findElement(By.xpath("//div[@class='picture']"));
		Assert.assertTrue(element.isDisplayed());
		Actions actProfile=new Actions(driver);
		actProfile.moveToElement(element).perform();
		WebElement elementSettings = driver.findElement(By.xpath("//a[@class='password-action profile-context-menu-handler']"));
		Assert.assertTrue(elementSettings.isDisplayed());
		elementSettings.click();
	}
	
	//7. Verify user menu total 2 options are displayed (About, Change Password) on after click on setting icon.
	@Test
	void S7verifySettingIconElements() {
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='sub-menu-container-php profile-context-menu-handler opened']//a[@class='sub-menu-item-link truncate']"));
		Assert.assertTrue(elements.size()>0);
		List<String> lstElementString= new LinkedList<String>();
		for(WebElement element:elements) {
			lstElementString.add(element.getText().trim());
		}
		Assert.assertEquals(lstElementString, getMenuOptionList());
	}
	
	List<String> getMenuOptionList(){
		List<String> lst=new LinkedList<String>();
		lst.add("Change Password");
		lst.add("About");
		return lst;
	}
	
	//8. Click on About
	@Test
	void S8ClickAbout() {
		WebElement element = driver.findElement(By.xpath("//div[@class='sub-menu-container-php profile-context-menu-handler opened']//div[@class='sub-menu-item'][2]//a[@class='sub-menu-item-link truncate']"));
		Assert.assertTrue(element.isDisplayed());
		element.click();
	}
	
	//9. Verify Employee is more than 0 
	@Test
	void S9VerifyEmployeeCount() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		List<WebElement> elements = driver.findElements(By.xpath("//div[@id='companyInfo']//p"));
		Assert.assertTrue(elements.size()>0);
		String employeeStr=elements.get(3).getText().trim();
		String[] strEmpVals=employeeStr.split(" ");
		int empCount=Integer.parseInt(strEmpVals[1]);
		Assert.assertTrue(empCount>0);
	}
	
	//10. Verify the company details  fields are getting displayed on information alert (Company Name, Version, Employees, Users & Renewal on)
	@Test
	void S91VerifyCompanyDetails() {
		List<WebElement> elements = driver.findElements(By.xpath("//div[@id='companyInfo']//p"));
		Assert.assertTrue(elements.size()>0);
		List<String> lstCmpDetails=new LinkedList<String>();
		for(WebElement element:elements) {
			lstCmpDetails.add(element.getText().trim().split(":")[0]);
		}
		Assert.assertEquals(lstCmpDetails, getCmpDetailsList());
	}
	
	List<String> getCmpDetailsList(){
		List<String> lst=new LinkedList<String>();
		lst.add("Company Name");
		lst.add("Version");
		lst.add("Employees");
		lst.add("Users");
		lst.add("Renewal on");
		return lst;
	}
	
	//11. Click on OK button on popup.
	@Test
	void S92ClickOk() {
		WebElement element = driver.findElement(By.xpath("//a[@id='heartbeatSubmitBtn']"));
		Assert.assertTrue(element.isDisplayed());
		element.click();
	}
}
