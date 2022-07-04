package minalS;

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

public class Testcase_6 {

	@Test
	void verifyUserSkillDisplay() {
		System.out.println("STEP-Launch a browser");
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		System.out.println("STEP-URL");
		driver.get("https://minals-trials7501.orangehrmlive.com/auth/seamlessLogin");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		System.out.println("Enter User Name");
		WebElement useNameElement = driver.findElement(By.id("txtUsername"));
		useNameElement.sendKeys("Admin");

		System.out.println("Enter Passward");
		WebElement passwardElement = driver.findElement(By.id("txtPassword"));
		passwardElement.sendKeys("7@kOfBn8YV");

		System.out.println("Click on login button");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		System.out.println("STEP-Clicked on more button");
		driver.findElement(By.partialLinkText("More ")).click();
		
		System.out.println("STEP-Mouse over on qualification and select skills option");
		WebElement qualification=driver.findElement(By.xpath("//a[@data-automation-id='more_menu_child_menu_admin_Qualifications']"));
		WebElement skillElement=driver.findElement(By.xpath("//*[text()='Skills']"));
		Actions action=new Actions(driver);
		action.moveToElement(qualification).click(skillElement).build().perform();
		
		System.out.println("STEP-clicked on Add icon");
		driver.findElement(By.xpath("//i[contains(text(),'add')]")).click();
		
		System.out.println("VERIFY  Add skills header displayed");
	 	boolean isAddSkillsdisplay=driver.findElement(By.xpath("//h4[text()='Add Skill']")).isDisplayed();
	 	Assert.assertTrue(isAddSkillsdisplay);
	 	
	 	System.out.println("STEP-Enter name");
	 	driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Automation");
	 	
	 	System.out.println("STEP-Enter discription");
	 	driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys("Java-Selenium");
	 	
	 	System.out.println("STEP-click on save button");
	 	driver.findElement(By.xpath("//a[@class='modal-action waves-effect waves-green btn primary-btn']")).click();
	 	
	 	driver.navigate().refresh();
	 	List<WebElement> skillElementList=driver.findElements(By.xpath("//table[@class='highlight bordered']//tr//td[2]"));
		
	 	List<String> actualListOfElements=new ArrayList<String>();
	 	
	 	for(int index=0;index<skillElementList.size();index++) {
	 		actualListOfElements.add(skillElementList.get(index).getText());
	 	}
	 	Assert.assertTrue(actualListOfElements.contains("Automation"));
	 
	 	driver.close();
	}

	
}
