package vrinda.StandAloneTC;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Orange_TC5 {
	private WebDriver driver;
	void launchBrowser(String url){
	System.setProperty("webdriver.chrome.driver","resource/chromedriver.exe");
	driver = new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	}

	@Test
	public void HRAdministration() {
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
		
		driver.findElement(By.xpath("//a[@id='menu_item_81']/span")).click();
		System.out.println(" Step : Click on HR Administration Tab");
		
		driver.findElement(By.xpath("//a[contains(text(),'Manage User Roles ')]")).click();
		System.out.println(" Step : Click on user rols Tab");
		
		driver.findElement(By.xpath("//tbody[@ng-if='!listData.staticBody']/tr/td[2]"));
		System.out.println("Step: Wait for table to lod");
		
		int rowCount=driver.findElements(By.xpath("//tbody[@ng-if='!listData.staticBody']/tr")).size();
		System.out.println("Step: getting data from row");
		String pagination=driver.findElement(By.xpath("//li[@class='summary']")).getText();
		System.out.println("Step : getting data from pagination");
		pagination=pagination.split(" ")[4];
		int actualRowCount=Integer.parseInt(pagination);
		Assert.assertEquals(actualRowCount, rowCount);
		System.out.println("Verify row count and pagination matched");
		
		String pageCount=driver.findElement(By.xpath("//input[@value=\"50\"]")).getAttribute("value");
		System.out.println(pageCount);
		int pcount=Integer.parseInt(pageCount);
		Assert.assertEquals(pcount,50);
		System.out.println("verify: 50 records are on page");
}
}
