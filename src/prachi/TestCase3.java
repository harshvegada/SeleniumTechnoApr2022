package prachi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase3 {
	
	@Test
	void verifyCompanyDetails(){
		System.out.println("STEP - Launch a browser");
		System.setProperty("webdriver.chrome.driver","D:\\Java Class\\technocredits\\SeleniumTechnoApr2022\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		System.out.println("STEP - Enter URL");
		driver.get("https://technoprachi-trials7501.orangehrmlive.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		System.out.println("STEP - Enter User Name");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");

		System.out.println("STEP - Enter Passward");
		driver.findElement(By.id("txtPassword")).sendKeys("@7GqSTCt7j");

		System.out.println("STEP - Click on login button on login page");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		System.out.println("VERIFY - User profile is displayed");


		WebElement userProfileDisplay=driver.findElement(By.xpath("//div[@class='image-container']"));
		Assert.assertTrue(userProfileDisplay.isDisplayed());

		System.out.println("VERIFY - Setting option on profile pictur and click on setting icon");
		Actions action=new Actions(driver);
		WebElement settingElement=driver.findElement(By.xpath("//a[@class='password-action profile-context-menu-handler']"));
		action.moveToElement(userProfileDisplay).click(settingElement).build().perform();

		System.out.println("VERIFY -  User menu have total 2 options displayed");
		List<WebElement> listOfWebElements= driver.findElements(By.xpath("//div[@class='sub-menu-container-php profile-context-menu-handler opened']//div[@class='sub-menu-item']"));
		Assert.assertEquals(listOfWebElements.size(), 2);

		System.out.println("VERIFY - Actual list and expected list are matching");
		List<String> expectedNameList = new ArrayList<String>();
		expectedNameList.add("Change Password");
		expectedNameList.add("About");

		List<String> actualNameList=new ArrayList<String>();

		for(int index=0;index<listOfWebElements.size();index++) {
			Assert.assertTrue(listOfWebElements.get(index).isDisplayed());
			actualNameList.add(listOfWebElements.get(index).getText().trim());
		}
		Assert.assertEquals(expectedNameList, actualNameList);

		System.out.println("STEP - Clicked on About button");
		listOfWebElements.get(1).click();


		System.out.println("VERIFY - Employees are non-zero");
		String empCountInString=driver.findElement(By.xpath("//div[@id='companyInfo']//div[@class='row']//div[3]")).getText();
		empCountInString=empCountInString.split(" ")[1];
		int empCount=Integer.parseInt(empCountInString);
		Assert.assertTrue(empCount>0);

		System.out.println("Verify company information getting display");
		List<String> expectedCompanyInfoList=new ArrayList<String>();
		expectedCompanyInfoList.add("Company Name");
		expectedCompanyInfoList.add("Version");
		expectedCompanyInfoList.add("Employees");
		expectedCompanyInfoList.add("Users");
		expectedCompanyInfoList.add("Renewal on");

		List<WebElement> listOfWebElementCompanyInfo=driver.findElements(By.xpath("//div[@class='col s12']"));
		List<String> actualListOfCompanyInfo=new ArrayList<String>();
		for(int index=0;index<listOfWebElementCompanyInfo.size();index++) {
			actualListOfCompanyInfo.add(listOfWebElementCompanyInfo.get(index).getText().split(":")[0].trim());
		}
		Assert.assertEquals(expectedCompanyInfoList, actualListOfCompanyInfo);

		System.out.println("STEP-clicked on OK button");
		driver.findElement(By.xpath("//div[@class='modal-footer']/a[@id='heartbeatSubmitBtn']")).click();
		driver.close();
		}
}


