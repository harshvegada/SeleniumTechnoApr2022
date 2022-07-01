package ashish.standalonescripts;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase6 {
	
	private static WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = PredefinedActions.browserSetUp();
		System.out.println("STEP - Enter userName");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("admin");

		System.out.println("STEP - Enter password");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("h@s4WMi1LR");

		System.out.println("VERIFY - User click on Login button on Login Page");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
	}
	
	@Test
	public void verifySkillTest() {
		
		driver.findElement(By.xpath("//a[@data-automation-id='more_menu_child_menu_top_more'][contains(text(),'More')]")).click();
		System.out.println("STEP -  Clicked on More tab");
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@data-automation-id='more_menu_child_menu_admin_Qualifications'][contains(text(),'Qualifications')]"))).click(driver.findElement(By.xpath("//a[@data-automation-id='more_menu_child_menu_admin_viewSkills'][contains(text(),'Skills')]")))
		.build().perform();
		System.out.println("VERIFY - clicked on Skills tab");
		
		driver.findElement(By.xpath("//div[@id='skillDiv']//div/a/i")).click();
		System.out.println("VERIFY - clicked on + icon on top right corner");
		
		boolean isAddSkillsHeaderDisplayed = driver.findElement(By.xpath("//div[@id='modal1']/h4[contains(text(),'Add Skill')]")).isDisplayed();
		Assert.assertTrue(isAddSkillsHeaderDisplayed);
		System.out.println("VERIFY - verified, On popup header display as Add Skill");
		
		String skillToAdd = "Automation-2", skillDescriptionToAdd = "Java-4";
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(skillToAdd);
		System.out.println("STEP - Entered Skill as Automation-1 or any");
		driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys(skillDescriptionToAdd);
		System.out.println("STEP - Entered any randon text in description");
		
		driver.findElement(By.xpath("//a[@close-modal-on-click='skillsModalForm']")).click();
		System.out.println("VERIFY - Clicked on save button");
		
		driver.navigate().refresh();
		List<WebElement> skillElements= driver.findElements(By.xpath("//table[@class='highlight bordered']//tr/td[2]"));
		List<String> skillTextList = new ArrayList<>();
		for(WebElement ele :  skillElements) {
			skillTextList.add(ele.getText());
		}
		Assert.assertTrue(skillTextList.contains(skillToAdd));
		System.out.println("VERIFY - Verifyied, new skill getting display on Skill List");
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
