package pragati;

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

public class TestCase_3 {
	@Test
	public void testCase_3() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://technopragati-trials7501.orangehrmlive.com/auth/seamlessLogin");
		System.out.println("STEP: navigat to url");
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		System.out.println("STEP: entered user name");

		driver.findElement(By.id("txtPassword")).sendKeys("oVD1lqX5@Z");
		System.out.println("STEP: entered password");

		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		System.out.println("STEP: click on login button");

		WebElement userProfileElement = driver.findElement(By.xpath("//div[@class='image-container']/img"));
		Assert.assertTrue(userProfileElement.isDisplayed());
		System.out.println("VERIFY: user profile is display on UI");

		Actions action = new Actions(driver);
		action.moveToElement(userProfileElement)
				.click(driver.findElement(By.xpath("//a[@class='password-action profile-context-menu-handler']/i")))
				.build().perform();
		
		System.out.println("VERIFY: total 2 element is display");
        List<WebElement>listOfWebElement= driver.findElements(By.xpath("//div[@class='sub-menu-container-php profile-context-menu-handler opened']//div//a"));
		Assert.assertEquals(listOfWebElement.size(), 2);
		
		System.out.println("VERIFY: actual list and expected list are matching");
        List<String>expectedList = new ArrayList<>();
		expectedList.add("Change Password");
		expectedList.add("About");
		List<String> actualList = new ArrayList<>();

		for (int index = 0; index < listOfWebElement.size(); index++) {
			actualList.add(listOfWebElement.get(index).getText().trim());
		}

		Assert.assertEquals(expectedList, actualList);
		
		System.out.println("STEP: clicked on about button");
		listOfWebElement.get(1).click();
		
		System.out.println("VERIFY: Employeess are non-zero");
		String empCountInString = driver.findElement(By.xpath("//div[@class='col s12'][3]/p")).getText();
		empCountInString = empCountInString.split(" ")[1];
		int empCount = Integer.parseInt(empCountInString);
		Assert.assertTrue(empCount > 0);

		System.out.println("VERIFY: Company information getting display");
		List<WebElement>companylistOfInfo = driver.findElements(By.xpath("//div[@class='col s12']")); 
		List<String> actualCompanyInfo = new ArrayList<>();
		List<String> expectedCompanyInfo = new ArrayList<>();
		
		expectedCompanyInfo.add("Company Name");
		expectedCompanyInfo.add("Version");
		expectedCompanyInfo.add("Employees");
		expectedCompanyInfo.add("Users");
		expectedCompanyInfo.add("Renewal on");
		
		for(int index = 0;index<companylistOfInfo.size();index++) {
			actualCompanyInfo.add(companylistOfInfo.get(index).getText().split(":")[0].trim());
		}
		Assert.assertTrue(expectedCompanyInfo.equals(actualCompanyInfo));
		
		System.out.println("STEP: Click on OK button");
		driver.findElement(By.xpath("//a[@id=\"heartbeatSubmitBtn\"]")).click();

	}

}
