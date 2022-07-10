package omkar.OrangeHRM1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Test_Case6 extends Test_Case1 {
	void TC_6() {
		TC_1();
		WebElement more=driver.findElement(By.xpath("//a[text()='More ']"));
		System.out.println("Step-> click on more");
		more.click();
		
		WebElement qulicafication=driver.findElement(By.xpath("//a[text()=' Qualifications ']"));
		
		Actions mouseAction=new Actions(driver);
		mouseAction.moveToElement(qulicafication).build().perform();
		
		driver.findElement(By.xpath("//a[text()='Skills']")).click();
		driver.findElement(By.xpath("//i[text()='add']")).click();
		
		WebElement addSkill=driver.findElement(By.xpath("//h4[text()='Add Skill']"));
		Assert.assertTrue(addSkill.isDisplayed());
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("TechnoCredits");
		
		driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys("Demo");
		driver.findElement(By.xpath("//a[text()='Save']")).click();
		System.out.println("Step -> Clicked to Save button");
		
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
		
		String skillToBeAdded = "TechnoCredits-1";
		String descriptionToBeAdded = "Demo";
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
