package sonali;

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

public class Testcase6 {
	@Test
	void test6() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://ojaswi-trials7501.orangehrmlive.com/");
		System.out.println("STEP: navigat to url");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		System.out.println("STEP: entered user name");
		driver.findElement(By.id("txtPassword")).sendKeys("@7VoLAPs6i");
		System.out.println("STEP: entered password");

		driver.findElement(By.xpath("//div[@class='button-holder']/button")).click();
		System.out.println("STEP: click on login button");
		driver.findElement(By.partialLinkText("More ")).click();
		WebElement qaulification=driver.findElement(By.xpath("//a[@data-automation-id='more_menu_child_menu_admin_Qualifications']"));
		WebElement skills=driver.findElement(By.xpath("//a[@data-automation-id='more_menu_child_menu_admin_viewSkills']"));
		Actions action=new Actions(driver);
	    action.moveToElement(qaulification).click(skills).build().perform();
		driver.findElement(By.xpath("//div[@class='fixed-action-btn floating-add-btn tooltipped']//i[@class='material-icons']")).click();
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Sonali1234");
		driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys("Automation Enginer");
		driver.findElement(By.xpath("//a[@class='modal-action waves-effect waves-green btn primary-btn']")).click();
		driver.navigate().refresh();
		List<WebElement> actualList=driver.findElements(By.xpath("//table[@class='highlight bordered']//tr//td[2]"));
		ArrayList<String> expectedList=new ArrayList<String>();
		for(int index=0;index<actualList.size();index++) {
			expectedList.add(actualList.get(index).getText());
			
		}
		Assert.assertTrue(expectedList.contains("Sonali1234"));
		driver.close();
		
		
		
		
		
}
}
