package sachinP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase4 {
	

	@Test
	public void testcase4() {
	System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://techsachin-trials7501.orangehrmlive.com/");
	System.out.println("STEP: Navigate to URL");

	driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	System.out.println("STEP: Entered user name");

	driver.findElement(By.id("txtPassword")).sendKeys("@ugF02HCjL");
	System.out.println("STEP: Entered password");

	driver.findElement(By.xpath("//button[@type='submit']")).click();
	System.out.println("STEP: click on login button");
	
	WebElement userProfileElement = driver.findElement(By.xpath("//div[@class='image-container']/img"));
	Assert.assertTrue(userProfileElement.isDisplayed());
	System.out.println("VERIFY: user profile is display on UI");
	
	driver.findElement(By.partialLinkText("Info")).click();
	System.out.println("STEP : Click on my info tab");
	
	WebElement personalDetailsElement = driver.findElement(By.xpath("//div[@id='personal_details_tab']//input[@id='firstName']"));
	Assert.assertTrue(personalDetailsElement.isDisplayed());         
	System.out.println("VERIFY : person info is displayed");
	
	driver.findElement(By.linkText("Salary")).click();
	System.out.println("STEP : click on salary tab");
	
	
	WebElement ctcElement = driver.findElement(By.xpath("//div[@class='col-9 summary-cards-container']/div[1]/div[2][contains(text(),'$')]"));
	System.out.println("CTC Amt : "+ctcElement.getText());
	String ctcSalaryInString =ctcElement.getText();
	ctcSalaryInString = ctcSalaryInString.replace("$", "").replace(",", "");
	ctcSalaryInString = ctcSalaryInString.substring(0,ctcSalaryInString.indexOf("."));
	int ctcAmt =Integer.parseInt(ctcSalaryInString);
	Assert.assertTrue(ctcAmt > 0);
	}

}
