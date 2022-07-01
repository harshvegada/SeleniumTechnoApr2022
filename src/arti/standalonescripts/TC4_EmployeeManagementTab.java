package arti.standalonescripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC4_EmployeeManagementTab {


	WebDriver driver;
	@Test
	public void verifyTC4_EmployeeManagementTab(){
		
		System.out.println("STEP - Launch browser");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		System.out.println("STEP - Load URL");
		driver.get("https://artitechno-trials7501.orangehrmlive.com/");
		
		System.out.println("VERIFY - User is able to enter the username ");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");

		System.out.println("VERIFY - User is able to enter the password ");
		driver.findElement(By.id("txtPassword")).sendKeys("6cyNOTm3N@");
		
		System.out.println("STEP - User click on Login button on Login Page");
		driver.findElement(By.xpath("//div[@class='button-holder']/button")).click();
		
		System.out.println("STEP - User click on Employee Management tab");
		driver.findElement(By.xpath("//a[@class='main-menu-item-1 active']")).click();
		
		System.out.println("STEP - Click On My Info tab");
		driver.findElement(By.xpath("//a[contains(text(),'My Info')]")).click();
		
		System.out.println("VERIFY - user Personal info displayed");
		driver.findElement(By.xpath("//div[@id='personal_details_tab']//label[contains(text(),'First Name')]")).click();
		
		System.out.println("STEP - Click on Salary");
		driver.findElement(By.linkText("Salary")).click();
		
		
		System.out.println("VERIFY - Check the payable (CTC) amount is non-zero");
		WebElement ctcElement = driver.findElement(By.xpath("//div[@class='col-9 summary-cards-container']/div[1]/div[2][contains(text(),'$')]"));
		String ctcAmount = ctcElement.getText();
		ctcAmount = ctcAmount.replace("$", "").replace(",", "");
		ctcAmount = ctcAmount.substring(0, ctcAmount.indexOf('.') );
		int ctc = Integer.parseInt(ctcAmount);
		System.out.println(ctc);
		Assert.assertTrue(ctc>0);
		
		driver.close();
	}
}
