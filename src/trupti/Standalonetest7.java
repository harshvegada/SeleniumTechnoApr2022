package trupti;

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

public class Standalonetest7 {
	@Test
	void updateCompanyName() {
		System.out.println("STEP-Launch a browser");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("STEP-load URL");
		driver.get("https://bhutkartrupti-trials7501.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		System.out.println("STEP-Enter User Name");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		System.out.println("STEP-Enter Passward");
		driver.findElement(By.id("txtPassword")).sendKeys("DBZ@6kHzb5");
		
		System.out.println("STEP- Clicked on login button ");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		System.out.println("STEP- Clicked on HR Adminstration");
		driver.findElement(By.xpath("\r\n"
				+ "//li[@id='left_menu_item_1']")).click();
		
		//driver.findElement(By.xpath("//table[@class='highlight bordered']/tbody/tr[3]"));//for wait till loading 
		
		System.out.println("STEP- Clicked on Organazation");
		driver.findElement(By.partialLinkText("Organization ")).click();
		
		System.out.println("STEP- clicked on General Information");
		driver.findElement(By.xpath("//a[@ui-sref='admin.organization_general_information']")).click();
		WebElement organizationElement=driver.findElement(By.xpath("//input[@id='name']"));
		organizationElement.clear();
		organizationElement.sendKeys("Abc");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		WebElement isdisableEmployeeFields=driver.findElement(By.xpath("//input[@id='numemp']"));
	
		Assert.assertFalse(isdisableEmployeeFields.isEnabled());
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		System.out.println("STEP-Tost Massege is displayed");
		WebElement massege=driver.findElement(By.xpath("//div[text()='Successfully Updated']"));
		Assert.assertTrue(massege.isDisplayed());
		
		WebElement profileLogoElement = driver.findElement(By.xpath("//div[@class='image-container']"));
		System.out.println("Verify setting option on profile pictur and click on setting icon");
		Actions action=new Actions(driver);
		WebElement settingElement=driver.findElement(By.xpath("//a[@class='password-action profile-context-menu-handler']"));
		action.moveToElement(profileLogoElement).click(settingElement).build().perform();
		
		List<WebElement> listOfWebElements= driver.findElements(By.xpath("//div[@class='sub-menu-container-php profile-context-menu-handler opened']//div[@class='sub-menu-item']"));
		List<String> actualNameList=new ArrayList<String>();
		
		for(int index=0;index<listOfWebElements.size();index++) {
			Assert.assertTrue(listOfWebElements.get(index).isDisplayed());
			actualNameList.add(listOfWebElements.get(index).getText().trim());
		}
		System.out.println("STEP- clicked on About button");
		listOfWebElements.get(1).click();
		
		System.out.println("VERIFY-Update Name");
		String companyName=  driver.findElement(By.xpath("//div[@id='companyInfo']/div[@class='row']/div[1]")).getText();
		Assert.assertTrue(companyName.contains("Abc"));
		
	}
}
