package amar_StandAloneCase;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC6_StandAlone {
	
	final String username = "admin";
	final String password = "C@sRqq3L4U";
	static String skillToBeAdded = "Automation Test 1";
	static String descriptionToBeAdded = "Random Text";

	@Test
	public void tc6() {

		System.out.println("STEP - Launch Chrome brower");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("STEP - Load URL");
		driver.get("https://technoamar-trials7501.orangehrmlive.com/");
		driver.manage().window().maximize();

		System.out.println("STEP - Enter username");
		WebElement usernameElement = driver.findElement(By.xpath("//input[@id='txtUsername']"));
		usernameElement.sendKeys(username);
		String actualUsername = usernameElement.getAttribute("value");
		Assert.assertEquals(actualUsername, username);
		System.out.println("VERIFY - Username Entered");

		System.out.println("STEP - Enter password");
		WebElement passwordElement = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		passwordElement.sendKeys(password);
		String actualPassword = passwordElement.getAttribute("value");
		Assert.assertEquals(actualPassword, password);
		System.out.println("VERIFY - Password Entered");

		System.out.println("STEP - User click on Login button on Login Page");
		driver.findElement(By.xpath("//div[@class='button-holder']/button")).click();
		System.out.println("VERIFY: Clicked on login button");

		System.out.println("STEP: Mouse hover on Qualifications tab");
		driver.findElement(By.xpath("//a[@data-automation-id='more_menu_child_menu_top_more']")).click();
		Actions actions = new Actions(driver);
		actions.moveToElement(
				driver.findElement(By.xpath("//a[@data-automation-id='more_menu_child_menu_admin_Qualifications']")))
				.build().perform();
		System.out.println("VERIFY: Mouse hovered on Qualifications tab");

		System.out.println("STEP: Click on Skills option under Qualifications");
		driver.findElement(By.xpath("//a[@data-automation-id='more_menu_child_menu_admin_viewSkills']")).click();
		System.out.println("VERIFY: Clicked on Skills under Qualifications");

		int getCurrentSkillTableCount = driver
				.findElements(By.xpath("//table[@class='highlight bordered']/tbody[1]/tr")).size();

		Map<String, String> skillTableMap = new HashMap<String, String>();
		for (int index = 1; index <= getCurrentSkillTableCount; index++) {
			String skills = driver
					.findElement(By.xpath("//table[@class='highlight bordered']/tbody[1]/tr[" + index + "]/td[2]"))
					.getText();
			String descriptions = driver
					.findElement(By.xpath("//table[@class='highlight bordered']/tbody[1]/tr[" + index + "]/td[3]"))
					.getText();
			skillTableMap.put(skills, descriptions);
		}
		Set<String> skillSetBeforeNewSkill = skillTableMap.keySet();

		System.out.println("STEP: click on '+' icon on top right corner");
		driver.findElement(By.xpath("//div[@data-tooltip='Add Skill']")).click();
		System.out.println("VERIFY: Clicked on add skill '+' plus icon");

		System.out.println("STEP: Display popup header as 'Add Skill'");
		String newSkillPopupHeader = driver.findElement(By.xpath("//h4[contains(text(),'Add Skill')]")).getText();
		Assert.assertEquals(newSkillPopupHeader, "Add Skill");
		System.out.println("VERIFY: Popup header displayed as 'Add Skill'");

		System.out.println("STEP: Enter Skill as '" + skillToBeAdded + "'");
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(skillToBeAdded);
		String newSkillNameProvided = driver.findElement(By.xpath("//input[@id='name']")).getAttribute("value");
		Assert.assertEquals(skillToBeAdded, newSkillNameProvided);
		System.out.println("VERIFY: New Skill name added as '" + skillToBeAdded + "'");

		System.out.println("STEP: Enter any randon text in description");
		driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys(descriptionToBeAdded);
		String newSkillDescriptionProvided = driver.findElement(By.xpath("//textarea[@id='description']"))
				.getAttribute("value");
		Assert.assertEquals(descriptionToBeAdded, newSkillDescriptionProvided);
		System.out.println("VERIFY: New Skill description added as '" + descriptionToBeAdded + "'");

		System.out.println("STEP: Click on 'Save' button");
		driver.findElement(By.xpath("//a[text()='Save']")).click();
		System.out.println("VERIFY: Clicked on 'Save' button");

		driver.navigate().refresh();
		System.out.println("***Current URL refreshed***");

		System.out.println("STEP: Verify that new skill getting display on Skill List");
		int getCurrentSkillTableCount2 = driver
				.findElements(By.xpath("//table[@class='highlight bordered']/tbody[1]/tr")).size();

		Map<String, String> skillTableMap2 = new HashMap<String, String>();
		for (int index = 1; index <= getCurrentSkillTableCount2; index++) {
			String skills = driver
					.findElement(By.xpath("//table[@class='highlight bordered']/tbody[1]/tr[" + index + "]/td[2]"))
					.getText();
			String descriptions = driver
					.findElement(By.xpath("//table[@class='highlight bordered']/tbody[1]/tr[" + index + "]/td[3]"))
					.getText();
			skillTableMap2.put(skills, descriptions);
		}
		Set<String> skillSetAfterNewSkill = skillTableMap2.keySet();
		skillSetAfterNewSkill.removeAll(skillSetBeforeNewSkill);
		Assert.assertEquals(String.join(" ", skillSetAfterNewSkill), skillToBeAdded);
		System.out.println("VERIFY: Newly added skill displayed on Skill List");

		driver.close();
		System.out.println("-:Current browser instance closed:-");
	}

}
