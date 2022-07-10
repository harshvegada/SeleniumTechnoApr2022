package pragati;

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
	public void testCase_6() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://technopragati-trials7501.orangehrmlive.com/auth/seamlessLogin");
		System.out.println("STEP: navigat to url");
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		System.out.println("STEP: entered user name");

		driver.findElement(By.id("txtPassword")).sendKeys("oVD1lqX5@Z");
		System.out.println("STEP: entered password");

		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		System.out.println("STEP: click on login button");
		
		driver.findElement(By.xpath("//a[contains(text(),'More')]")).click();
		System.out.println("STEP: click on More button");
		
		WebElement qualificationElement = driver.findElement(By.xpath("//a[@data-automation-id='more_menu_child_menu_admin_Qualifications']"));
		Actions action = new  Actions(driver);
		action.moveToElement(qualificationElement).click(driver.findElement(By.xpath("//a[@data-automation-id='more_menu_child_menu_admin_viewSkills']"))).build().perform();
		System.out.println("STEP: mouseHover and click on skill button");

		driver.findElement(By.xpath("//i[text()='add']")).click();
		System.out.println("STEP: click on add icon");
		
		boolean skillFlag = driver.findElement(By.xpath("//h4[text()='Add Skill']")).isDisplayed();
		Assert.assertTrue(skillFlag);
		System.out.println("VERIFY: Add Skill header is displayed");
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Automation");
		System.out.println("STEP: skill name as Automation");
		
		driver.findElement(By.id("description")).sendKeys("Java-Selenium");
		System.out.println("STEP: description added");
		
		driver.findElement(By.xpath("//a[text()='Save']")).click();
		System.out.println("STEP: click on save button");
		
		List<WebElement>listOfSkillList = driver.findElements(By.xpath("//table[@class='highlight bordered']//tr//td[2]//span"));
		
		List<String>actualSkillList= new ArrayList<>();
		for(int index=0; index<listOfSkillList.size();index++) {
			actualSkillList.add(listOfSkillList.get(index).getText());
		}
		System.out.println("STEP:After updating skill list");
		
		driver.navigate().refresh();
		System.out.println("STEP:refresh page");

		List<WebElement>newlistOfSkillList = driver.findElements(By.xpath("//table[@class='highlight bordered']//tr//td[2]//span"));

		List<String>newActualSkillList= new ArrayList<>();
		for(int index=0; index<listOfSkillList.size();index++) {
			newActualSkillList.add(newlistOfSkillList.get(index).getText());
		}
		
		newActualSkillList.contains("Automation");
        Assert.assertTrue(newActualSkillList.contains("Automation"));
        System.out.println("VERIFY: new skill getting display on skill list");
 }
	
}