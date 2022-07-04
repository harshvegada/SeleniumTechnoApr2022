package madhuriR;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase6{
	protected static WebDriver driver;
	public void setUp(String url) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	@BeforeClass
	public void setUp() {
		setUp("https://apr22madhuri-trials7501.orangehrmlive.com/");
	}
	public void login() {
		driver.findElement(By.xpath("//input[@id=\"txtUsername\"]")).sendKeys("Admin");
		
		driver.findElement(By.xpath("//input[@id=\"txtPassword\"]")).sendKeys("cW@OfXD40d");
		
		//System.out.println("Click on login");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
	
	}
	@Test
	public void testCase6() {
		System.out.println("Login with Valid Credential");
		login();
		System.out.println("click on more option");
		driver.findElement(By.xpath("//a[contains(text(),\"More \")]")).click();
		
		System.out.println("click on qualification and add skills");
		WebElement qualificationElement = driver.findElement(By.xpath("//a[@data-automation-id=\"more_menu_child_menu_admin_Qualifications\"]"));
		
		Actions action = new Actions(driver);
		action.moveToElement(qualificationElement).click(driver.findElement(By.xpath("//a[@data-automation-id=\"more_menu_child_menu_admin_viewSkills\"]"))).build().perform();
		System.out.println("click on add skill button");
		driver.findElement(By.xpath("//a[@class=\"btn-floating btn-large waves-effect waves-light\"]/i")).click();
		
		System.out.println("verify add skill is diapled or not");
		boolean isAddSkill = driver.findElement(By.xpath("//div[@class=\"modal modal-fixed-footer open\"]//h4[contains(text(),\"Add Skill\")]")).isDisplayed();
		Assert.assertTrue(isAddSkill);
		
		System.out.println("Add skills named as Automation");
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Automation");
		
		System.out.println("Add discription as Techno credits");
		driver.findElement(By.id("description")).sendKeys("TechnoCredits");
		
		driver.findElement(By.xpath("//a[@class=\"modal-action waves-effect waves-green btn primary-btn\"]")).click();
		
		List<WebElement> skillElement = driver.findElements(By.xpath("//table[@class='highlight bordered']//tbody//td[2]//span"));
		List<String> skillList = new ArrayList<>();
		for(WebElement element:skillElement) {
			skillList.add(element.getText().trim());
		}
		
		System.out.println("After click add skills");
		driver.navigate().refresh();
		System.out.println("Refresh the page");
		List<WebElement> latestSkillElement = driver.findElements(By.xpath("//table[@class='highlight bordered']//tbody//td[2]//span"));
		List<String> latestSkillList = new ArrayList<>();
		for(WebElement element:latestSkillElement) {
			latestSkillList.add(element.getText().trim());
		}
		
		System.out.println("verify latest element is added or not");
		Assert.assertTrue(latestSkillList.contains("Automation"));
		
	}
	@AfterTest()
	public void closeDriver() {
		driver.close();
	}

}
