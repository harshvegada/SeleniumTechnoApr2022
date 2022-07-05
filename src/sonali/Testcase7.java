package sonali;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase7 {
	@Test
	void test7() {
		System.out.println("STEP-Launch a browser");
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		System.out.println("STEP-URL");
		driver.get("https://ojaswi-trials7501.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		System.out.println("Enter User Name");
		WebElement useNameElement = driver.findElement(By.id("txtUsername"));
		useNameElement.sendKeys("Admin");

		System.out.println("Enter Passward");
		WebElement passwardElement = driver.findElement(By.id("txtPassword"));
		passwardElement.sendKeys("7@kOfBn8YV");

		System.out.println("Click on login button");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		System.out.println("STEP- clicked on HR Adminstration");
		driver.findElement(By.xpath("//li[@id='left_menu_item_1']")).click();

		driver.findElement(By.xpath("//table[@class='highlight bordered']/tbody/tr[3]"));

		System.out.println("STEP- clicked on Organazation");
		driver.findElement(By.partialLinkText("Organization ")).click();

		System.out.println("STEP- clicked on General Information");
		driver.findElement(By.xpath("//a[@ui-sref='admin.organization_general_information']")).click();
		WebElement organizationElement = driver.findElement(By.xpath("//input[@id='name']"));
		organizationElement.clear();
		organizationElement.sendKeys("Anything");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		WebElement isdisableEmployeeFields = driver.findElement(By.xpath("//input[@id='numemp']"));
		Assert.assertFalse(isdisableEmployeeFields.isEnabled());
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		System.out.println("STEP-Tost Massage is displayed");
		WebElement massege = driver.findElement(By.xpath("//div[text()='Successfully Updated']"));
		Assert.assertTrue(massege.isDisplayed());

		WebElement profileLogoElement = driver.findElement(By.xpath("//div[@class='image-container']"));
		System.out.println("Verify setting option on profile pictur and click on setting icon");
		Actions action = new Actions(driver);
		WebElement settingElement = driver
				.findElement(By.xpath("//a[@class='password-action profile-context-menu-handler']"));
		action.moveToElement(profileLogoElement).click(settingElement).build().perform();

		List<WebElement> listOfWebElements = driver.findElements(By.xpath(
				"//div[@class='sub-menu-container-php profile-context-menu-handler opened']//div[@class='sub-menu-item']"));
		List<String> actualNameList = new ArrayList<String>();

		for (int index = 0; index < listOfWebElements.size(); index++) {
			Assert.assertTrue(listOfWebElements.get(index).isDisplayed());
			actualNameList.add(listOfWebElements.get(index).getText().trim());
		}
		System.out.println("STEP- clicked on About button");
		listOfWebElements.get(1).click();

		String name1 = driver.findElement(By.xpath("//div[@id='companyInfo']/div[@class='row']/div[1]")).getText();
		Assert.assertTrue(name1.contains("Abc"));
        driver.close();
	}
}
