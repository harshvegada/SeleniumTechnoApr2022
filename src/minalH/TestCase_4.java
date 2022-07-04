package minalH;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class TestCase_4 {

	WebDriver driver;
	
	@Test
	public void verifyPayableAmount() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP : Launch url");
		driver.get("https://minalhake-trials7501.orangehrmlive.com/auth/login");
		System.out.println("STEP : Enter username");
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
		System.out.println("STEP : Enter Password");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("@tqGJP1nQ5");
		System.out.println("STEP : Click on login button");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		System.out.println("STEP : Click on My Info tab");
		//driver.findElement(By.xpath("//div[@class='top-level-menu-item-container']/a[@href='#/pim/my_info']")).click();
		//driver.findElement(By.partialLinkText("Info")).click();
		driver.findElement(By.xpath("//a[contains(text(),'My Info')]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement personalInfo = driver.findElement(By.xpath("//div[@id='personal_details_tab']//input[@id='firstName']"));
		Assert.assertTrue(personalInfo.isDisplayed());
		
		System.out.println("STEP : Click on Salary");
		driver.findElement(By.xpath("//a[contains(text(),'Salary')]")).click();
		
		String salary = driver.findElement(By.xpath("//div[@class='col-9 summary-cards-container']/div[1]/div[2][contains(text(),'$')]")).getText();
		System.out.println(salary);
		salary = salary.replace("$", "").replace(",", "");
		int ctc = Integer.parseInt(salary.substring(0,salary.indexOf(".")));
		Assert.assertTrue(ctc>0);	
	}
}
