package pragati;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_7 {
	@Test
	public void testCase_7() {
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
		
		driver.findElement(By.xpath("//a[@data-automation-id='menu_admin_Organization']")).click();
		System.out.println("STEP: click on Organization");
		
		driver.findElement(By.xpath("//a[@data-automation-id='menu_admin_viewOrganizationGeneralInformation']")).click();
		System.out.println("STEP: click on general information");
		
		WebElement organizationNameElement = driver.findElement(By.xpath("//input[@id='name']"));
		organizationNameElement.clear();
		System.out.println("STEP: clear text field of organizationName");
		
		organizationNameElement.sendKeys("Technocredits");
		System.out.println("STEP: new text field added to organizationName");
		
		WebElement numOfEmployee = driver.findElement(By.xpath("//input[@id='numemp']"));
		Assert.assertFalse(numOfEmployee.isEnabled());
		System.out.println("VERIFY: Number employee is disabled");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("STEP: click on save button");

		WebElement toastmsgElement = driver.findElement(By.xpath("//div[text()='Successfully Updated']"));
		Assert.assertTrue(toastmsgElement.isDisplayed());
		System.out.println("VERIFY: toast message is displayed");
		
		WebElement profileElement = driver.findElement(By.xpath("//div[@class='image-container']"));
		
		Actions action = new Actions(driver);
		action.moveToElement(profileElement).click(driver.findElement(By.xpath("//a[@class='password-action profile-context-menu-handler']"))).build().perform();
		System.out.println("STEP: mouse hover on user profle and click on setting icon");
		
		driver.findElement(By.xpath("//a[@id='aboutDisplayLink']")).click();
		System.out.println("STEP: click on about button");
		
		String companyName = driver.findElement(By.xpath("//div[@id=\"companyInfo\"]/div/div[1]/p")).getText();
		Assert.assertTrue(companyName.contains("Technocredits"));
		Assert.assertEquals(companyName.split(": ")[1], "Technocredits");
		System.out.println("VERIFY: updated orgnization displayed");

}
}
