package prachi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase5 {
	
	@Test
	void valueDisplayInTable() {
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
		
		System.out.println("STEP - Clicked on HR Adminstration");
		driver.findElement(By.xpath("\r\n"+ "//li[@id='left_menu_item_1']")).click();

		System.out.println("STEP- clicked on Manage User Roles");
		driver.findElement(By.partialLinkText("Manage User Roles")).click();

		System.out.println("STEP - Wait for table load");
		driver.findElement(By.xpath("//table[@class='highlight bordered']/tbody"));

		System.out.println("STEP - Getting data from pagination");
		int rowCount=driver.findElements(By.xpath("//table[@class='highlight bordered']/tbody/tr")).size();;

		System.out.println("STEP - Total row and pagination count matched");
		String pagination=driver.findElement(By.xpath("//li[@class='summary']")).getText().split(" ")[4];
		int totalRowCount=Integer.parseInt(pagination);
		Assert.assertEquals(rowCount, totalRowCount);

		WebElement perPageCountElement=driver.findElement(By.xpath("//input[@value='50']"));
		System.out.println("Page Count- "+perPageCountElement.getText());

		System.out.println("VERIFY - Default pagination is 50");
		System.out.println("Attribute value: "+perPageCountElement.getAttribute("value"));
		String countString=perPageCountElement.getAttribute("value");
		int count=Integer.parseInt(countString);
		Assert.assertEquals(count,50);
	}

}
