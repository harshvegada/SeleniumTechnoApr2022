package sonali;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase4 {
	@Test
	void test4() {
		System.setProperty("webdriver.chrome.driver", "./Resource/chromedriver.exe");
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
		
		//driver.findElement(By.xpath("//a[@class='main-menu-item-1 active']/span")).click();
		//System.out.println("Click on Employee Management");
		
		driver.findElement(By.xpath("//a[contains(text(),'My Info')]")).click();
		System.out.println("Click on My Info");
		
		WebElement personalDetailInfo =driver.findElement(By.xpath("//div[@id='personal_details_tab']//input[@id='firstName']"));
	    Assert.assertTrue(personalDetailInfo.isDisplayed());
		System.out.println("Personal info Displayed");
		
		driver.findElement(By.xpath("//div[@class='top-level-menu-item-container']//a[contains(text(),'Salary')]")).click();
		System.out.println("Click on Salary");
		
		WebElement ctcsalary= driver.findElement(By.xpath("//div[@class='summary-card-column summary-card-right']"));
		String salary=ctcsalary.getText();
		salary=salary.replace("$", "").replace(",", "");
		salary=salary.substring(0, salary.indexOf("."));
		int stcsalary=Integer.parseInt(salary);
		Assert.assertTrue(stcsalary>0);
		driver.close();
}
