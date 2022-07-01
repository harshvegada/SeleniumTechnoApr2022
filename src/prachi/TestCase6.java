package prachi;

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

public class TestCase6 {
	
	@Test
	void addNewSkills() {
		System.out.println("STEP - Launch a browser");
		System.setProperty("webdriver.chrome.driver", "D:\\Java Class\\technocredits\\SeleniumTechnoApr2022\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		System.out.println("STEP - Enetr URL");
		driver.get("https://technoprachi-trials7501.orangehrmlive.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		System.out.println("STEP - Enter User Name");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");

		System.out.println("STEP - Enter Passward");
		driver.findElement(By.id("txtPassword")).sendKeys("@7GqSTCt7j");

		System.out.println("STEP- Click on login button on login page");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		System.out.println("STEP - Clicked on more button");
		driver.findElement(By.partialLinkText("More ")).click();

		System.out.println("STEP - Mouse hover on qualification and select skills option");
		WebElement qualification=driver.findElement(By.xpath("//a[@data-automation-id='more_menu_child_menu_admin_Qualifications']"));
		WebElement skillElement=driver.findElement(By.xpath("//*[text()='Skills']"));
		Actions action = new Actions(driver);
		action.moveToElement(qualification).click(skillElement).build().perform();

		System.out.println("STEP - Clicked on Add icon");
		driver.findElement(By.xpath("//i[contains(text(),'add')]")).click();

		System.out.println("VERIFY - Add skills header displayed");
	 	boolean isAddSkillsdisplay=driver.findElement(By.xpath("//h4[text()='Add Skill']")).isDisplayed();
	 	Assert.assertTrue(isAddSkillsdisplay);

	 	System.out.println("STEP - Enter name");
	 	driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Automation");

	 	System.out.println("STEP-Enter discription");
	 	driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys("Java-Selenium");

	 	System.out.println("STEP - Click on save button");
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
