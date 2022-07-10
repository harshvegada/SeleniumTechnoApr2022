package arti.standalonescripts;

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

public class TC6_QualificationsTab {

WebDriver driver;
	
	@Test
	public void verifyHRAdministrationTab() {
		
	
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
		
		System.out.println("STEP -  Click on More tab");
		driver.findElement(By.xpath("//a[contains(text(),'More')]")).click();
		
		/*
		 * System.out.println("STEP - Click on Qualifications"); WebElement
		 * qualificationElement = driver.findElement(By.xpath(
		 * "//a[@data-automation-id='menu_admin_Qualifications']"));
		 * qualificationElement.click();
		 * 
		 * System.out.println("STEP - Click on Skills");
		 * driver.findElement(By.xpath("//a[text()='Skills']")).click();
		 */

		System.out.println("STEP - Mouse Hover to Qualifications");
		WebElement qualificationElement = driver.findElement(By.xpath("//a[@data-automation-id=\"more_menu_child_menu_admin_Qualifications\"]")); //
		//qualificationElement.click();

		Actions action = new Actions(driver);

		System.out.println("STEP - Click on the Skills button");
		action.moveToElement(qualificationElement).click(driver.findElement(By.xpath("//a[text()='Skills']"))).build().perform();
		
		System.out.println("STEP - User click on + icon on top right corner");
		driver.findElement(By.xpath("//i[text()='add']")).click();
		
		System.out.println("VERIFY - On popup header should display as Add Skill");
		String headerText = driver.findElement(By.xpath("//div[@id='modal1']/h4")).getText();
		Assert.assertEquals(headerText,"Add Skill");
		
		System.out.println("Size before adding new skill");
		int size = driver.findElements(By.xpath("//table[@class='highlight bordered']/tbody/tr")).size();
		
		System.out.println("STEP - User Enter Skill as Automation Test 1 or any");
		WebElement skillElement = driver.findElement(By.xpath("//input[@id='name']"));
		skillElement.sendKeys("Automation Test");
		
		System.out.println("STEP - User Enter any randon text in description");
		WebElement descriptionElement = driver.findElement(By.xpath("//textarea[@id='description']"));
		descriptionElement.sendKeys("New Skill Added");
	
		System.out.println("STEP - User click on save button");
		driver.findElement(By.xpath("//a[@form-name='skillsModalForm']")).click();
		driver.navigate().refresh();
		
		System.out.println("VERIFY - new skill getting display on Skill List");
		
		int latestSize = driver.findElements(By.xpath("//table[@class='highlight bordered']/tbody/tr")).size();
		Assert.assertTrue(latestSize>size);
				
		List<WebElement> newList = driver.findElements(By.xpath("//table[@class='highlight bordered']/tbody/tr"));
		List<String> newListSkills = new ArrayList<String>();
		
		for(WebElement e: newList) {
			
			newListSkills.add(e.getText());
		}
		
		if(newListSkills.contains("Automation Test"))
			System.out.println("New Skill is successfully added");
		
	}
	
}
