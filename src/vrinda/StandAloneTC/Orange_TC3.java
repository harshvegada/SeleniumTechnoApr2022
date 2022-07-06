package vrinda.StandAloneTC;

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

public class Orange_TC3 {
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println(" Step : Enter User Name");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		
		System.out.println(" Step : Enter Password");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("H5@n5njQKR");
		
		System.out.println(" Step : Click on Submit button");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		System.out.println(" Verify: User profile is Display on UI");
		WebElement isUserProfileDisplay = driver.findElement(By.xpath("//div[@class='image-container']/img"));
		Assert.assertTrue(isUserProfileDisplay.isDisplayed());
		
		System.out.println("");
		Actions action=new Actions(driver);
		action.moveToElement(isUserProfileDisplay).click(driver.findElement(By.xpath("//div[@class='image-container']/a/i"))).build().perform();
	
		List<WebElement> listOfWebElment = driver.findElements(
				By.xpath("//div[@class='sub-menu-container-php profile-context-menu-handler opened']//div//a"));
		Assert.assertEquals(listOfWebElment.size(), 2);
		System.out.println("VERIFY: total 2 element is display");

		List<String> expectedList = new ArrayList<>();
		expectedList.add("Change Password");
		expectedList.add("About");

		List<String> actualList = new ArrayList<>();

		for (int i = 0; i < listOfWebElment.size(); i++) {
			actualList.add(listOfWebElment.get(i).getText().trim());
		}

		Assert.assertEquals(expectedList, actualList);
		System.out.println("VERIFY: actual list and expected list are matching");
		
		listOfWebElment.get(1).click();
		System.out.println("STEP: clicked on about button");

		String empCountInString = driver.findElement(By.xpath("//div[@class='col s12'][3]/p")).getText();
		empCountInString = empCountInString.split(" ")[1];
		int empCount = Integer.parseInt(empCountInString);
		Assert.assertTrue(empCount > 0);
		System.out.println("VERIFY: Employeess are non-zero");
		
		
		List<WebElement> companyWebElementInfoList = driver.findElements(By.xpath("//div[@class='col s12']"));
		List<String> actualCompanyInfo = new ArrayList<>();
		List<String> expectedCompanyInfo = new ArrayList<>();
		
		expectedCompanyInfo.add("Company Name");
		expectedCompanyInfo.add("Version");
		expectedCompanyInfo.add("Employees");
		expectedCompanyInfo.add("Users");
		expectedCompanyInfo.add("Renewal on");
		
		for(int i = 0;i<companyWebElementInfoList.size();i++) {
			actualCompanyInfo.add(companyWebElementInfoList.get(i).getText().split(":")[0].trim());
		}
		Assert.assertTrue(expectedCompanyInfo.equals(actualCompanyInfo));
		System.out.println("VERIFY: Company information getting display");
	}
}
