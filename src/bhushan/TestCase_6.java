package bhushan;
/*
 * Verify When user add new skill that should get display in list
 * "1. Launch https://<your server name>-trials71.orangehrmlive.com/auth/login
2. User able to enter username as ""your username""
3. User able to enter password as ""your password""
5. Click on more button  then mouse hover Qualifications tab and click skill
6. User click on Skills tab
7. User click on ""+"" icon on top right corner
8. On popup header should display as ""Add Skill""
9. User Enter Skill as ""Automation Test 1"" or any
10. User Enter any randon text in description
11. User click on ""save"" button
12. Verify that new skill getting display on Skill List"*/

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

public class TestCase_6 {
	@Test
	void VerifynewAddedSkillShouldDisplayInList() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver=new ChromeDriver();
		System.out.println("Step-- Launch Browser  ");
		driver.get("https://bhushangdk-trials7501.orangehrmlive.com/auth/login");
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
		driver.findElement(By.id("txtPassword")).sendKeys("h1J@DXvJ8t");
		String actualPassword=driver.findElement(By.id("txtPassword")).getAttribute("value");
		String expectedPassword="h1J@DXvJ8t";
		Assert.assertEquals(actualPassword, expectedPassword);

		System.out.println("Step-- User click on Login button on Login Page ");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		System.out.println("Step-- Click on more button tab and ");
		driver.findElement(By.xpath("//a[@data-automation-id='more_menu_child_menu_top_more']")).click();
		
		System.out.println("Step-- mouse over on Qulification tab and click on skill");
		Actions actions1=new Actions(driver);
		   WebElement element=driver.findElement(By.xpath("//a[@ng-focus='showSubmenu($index)'and @data-automation-id='more_menu_child_menu_admin_Qualifications']"));
		   actions1.moveToElement(element).build().perform();
		   System.out.println("mouse hovered");
		   driver.findElements(By.xpath("//i[@class='material-icons expand-icon-left']"));
		   Actions actions2=new Actions(driver);
		   actions2.moveToElement(driver.findElement(By.xpath("//a[@ui-sref ='admin.skills' and @data-automation-id='more_menu_child_menu_admin_viewSkills']"))).build().perform();
		   driver.findElement(By.xpath("//a[@ui-sref ='admin.skills' and @data-automation-id='more_menu_child_menu_admin_viewSkills']")).click();
		   
		System.out.println("Step-- User click on + icon on top right corner");
		driver.findElement(By.xpath("//a[@class='btn-floating btn-large waves-effect waves-light']//i[@class='material-icons']")).click();
		
		System.out.println("Step--On popup header should display as Add Skill");
		boolean isAddskillDisplayed=driver.findElement(By.xpath("//div[@class='modal modal-fixed-footer open']")).isDisplayed();
		Assert.assertTrue(isAddskillDisplayed);
		
		System.out.println("Step--User Enter Skill as Automation Test 1 or any");
		driver.findElement(By.id("name")).sendKeys("Automation1");
		driver.findElement(By.id("description")).sendKeys("Java1");
		
		System.out.println("Step--User click on save button");
		driver.findElement(By.xpath("//a[@class='modal-action waves-effect waves-green btn primary-btn']")).click();
		
		System.out.println("Refresh Driver");
		driver.navigate().refresh();
		
		System.out.println("Step--Verify that new skill getting display on Skill List");
			List<WebElement> listofWebElements=driver.findElements(By.xpath("//tbody//tr//td[@ng-if='((obj[list.clickableCondition] && list.clickableCondition)||!list.clickableCondition) && (listField.hideField==true?false:true)']"));
			List<String> listofNames=new ArrayList<String>();
				for(WebElement skillselement:listofWebElements) {
					listofNames.add(skillselement.getText());
				}
		   System.out.println("Verify names added");
		   	String skillNameGiven="Automation1";
		   	String descriptionName="Java1";
			boolean namecontains=listofNames.contains(skillNameGiven);
			boolean desccontains=listofNames.contains(descriptionName);
			Assert.assertTrue(desccontains);
			Assert.assertTrue(namecontains);
			
			
			System.out.println("System end");
			driver.close();
		
	}
}
