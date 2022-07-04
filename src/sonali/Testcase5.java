package sonali;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase5 {
	@Test
	void test5() {
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
		//WebDriverWait wait =new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='main-menu-item-1'")));
		driver.findElement(By.xpath("//a[@id='menu_item_81']")).click();
		System.out.println("Click on HR admiistrator");
		driver.findElement(By.xpath("//a[contains(text(),'Manage User Roles ')]")).click();
		System.out.println("Click on manger user roles");
		WebDriverWait wait =new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[@class='highlight bordered']/tbody/tr")));
		int rowcount=driver.findElements(By.xpath("//table[@class='highlight bordered']/tbody/tr")).size();
		System.out.println(rowcount);
		System.out.println("STEP-total row and pagination count matched");
		String pagination=driver.findElement(By.xpath("//li[@class='summary']")).getText().split(" ")[4];
		System.out.println("Page"+ pagination);
		int totalRowCount=Integer.parseInt(pagination);
		Assert.assertEquals(rowcount, totalRowCount);
		
		WebElement e =driver.findElement(By.xpath("//input[@value='50']"));
		String value=e.getText();
		System.out.println(value);
	    String count=e.getAttribute("value");
	    int pagepercount=Integer.parseInt(count);
	    Assert.assertEquals(50, pagepercount);
	    System.out.println("ByDefault pagination count match");
}
}
