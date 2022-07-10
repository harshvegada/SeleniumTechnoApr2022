package pragati;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_5 {
	@Test
	public void testCase_5() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://technopragati-trials7501.orangehrmlive.com/auth/seamlessLogin");
		System.out.println("STEP: navigat to url");

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		System.out.println("STEP: entered user name");

		driver.findElement(By.id("txtPassword")).sendKeys("oVD1lqX5@Z");
		System.out.println("STEP: entered password");

		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		System.out.println("STEP: click on login button");

		driver.findElement(By.xpath("//a[@id=\"menu_item_81\"][1]")).click();
		System.out.println("STEP: click on HR adminstraion tab");

		driver.findElement(By.xpath("//a[@ui-sref=\"admin.user_roles\"]")).click();
		System.out.println("STEP: click on Manager User Role");

		driver.findElement(By.xpath("//table[@class=\"highlight bordered\"]/tbody"));
		System.out.println("STEP: wait for table to load");

		int rowCount = driver.findElements(By.xpath("//table[@class=\"highlight bordered\"]/tbody/tr")).size();
		System.out.println("STEP: getting total row count");

		String pagination = driver.findElement(By.xpath("//li[@class='summary']")).getText().split(" ")[4];
		System.out.println("STEP: getting data from pagination");

		int totalCount = Integer.parseInt(pagination);
		Assert.assertEquals(rowCount, totalCount);
		System.out.println("VERIFY:total record and showing count of record");
		
		WebElement perPageCount = driver.findElement(By.xpath("//input[@value='50']"));
		System.out.println("perpage count Element: "+perPageCount.getText());
		System.out.println("Attribute value: "+perPageCount.getAttribute("value"));
		
		int attributeValue = Integer.parseInt(perPageCount.getAttribute("value"));
		Assert.assertEquals(attributeValue, 50);
		System.out.println("VERIFY: defualt pagination is 50");
		
	}
}
