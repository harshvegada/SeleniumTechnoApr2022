package vrinda.StandAloneTC;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Orange_TC4 {
	private WebDriver driver;
	void launchBrowser(String url){
	System.setProperty("webdriver.chrome.driver","resource/chromedriver.exe");
	driver = new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	}

	@Test
	public void userProfile() {
		System.out.println(" Step : \"1. Launch https://<your server name>-trials71.orangehrmlive.com/auth/login");
		launchBrowser("https://vrinda-trials7501.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		System.out.println(" Step : Enter User Name");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		
		System.out.println(" Step : Enter Password");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("H5@n5njQKR");
		
		System.out.println(" Step : Click on Submit button");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		System.out.println(" Verify: User profile is Display on UI");
		WebElement isUserProfileDisplay = driver.findElement(By.xpath("//div[@class='image-container']/img"));
		Assert.assertTrue(isUserProfileDisplay.isDisplayed());
		
		System.out.println(" Step: User click on 'My Info'");
		driver.findElement(By.xpath("//a[contains(text(),'My Info ')]")).click();
		
		System.out.println(" Verify: User personal info display");
		WebElement isUserPersonaldetail =driver.findElement(By.xpath("//a[@class='top-level-menu-item active']"));
		Assert.assertTrue(isUserPersonaldetail.isDisplayed());
		
		driver.findElement(By.linkText("Salary")).click();
		System.out.println(" Step: click on Salary tab");
		
		WebElement ctcElement=driver.findElement(By.xpath("//div[@class='col-9 summary-cards-container']/div[1]/div[2][contains(text(),'$')]"));
		System.out.println("ctc = "+ctcElement.getText());
		String ctcValue=ctcElement.getText();
		ctcValue=ctcValue.replace("$","").replace(",", "");
		ctcValue=ctcValue.substring(0, ctcValue.indexOf("."));
		int ctcAmount=Integer.parseInt(ctcValue);
		Assert.assertTrue(ctcAmount>0);
		System.out.println(" Verify: CTC ic non zero");
	}
}
