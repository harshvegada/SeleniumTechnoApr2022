package madhuriR;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase3{

	protected static WebDriver driver;
	public void setUp(String url) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	@BeforeClass
	public void setUp() {
		setUp("https://apr22madhuri-trials7501.orangehrmlive.com/");
	}

	public void login() {
		driver.findElement(By.xpath("//input[@id=\"txtUsername\"]")).sendKeys("Admin");
		
		driver.findElement(By.xpath("//input[@id=\"txtPassword\"]")).sendKeys("cW@OfXD40d");
		
		//System.out.println("Click on login");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
	
	}
		
	@Test
	public void testCase3() {
		System.out.println("login with valid credential");
		login();
		System.out.println("Verify logo is displayed or not");
		WebElement userProfileElement =driver.findElement(By.xpath("//div[@class=\"image-container\"]/img"));
		Assert.assertTrue(userProfileElement.isDisplayed());
		
		System.out.println("click on setting button");
		Actions action = new Actions(driver);
		action.moveToElement(userProfileElement).click(driver.findElement(By.xpath("//a[@class=\"password-action profile-context-menu-handler\"]/i"))).build().perform();
		
		System.out.println("Verify 2 elements ");
		List<WebElement> webelements = driver.findElements(By.xpath("//div[@class=\"sub-menu-container-php profile-context-menu-handler opened\"]//div[@class=\"sub-menu-item\"]"));
		int actualElement = webelements.size();
		Assert.assertEquals(actualElement, 2);
		List<String> expectedList = new ArrayList<>();
		expectedList.add("Change Password");
		expectedList.add("About");
		
		List<String> actualList = new ArrayList<>();
		for(WebElement element:webelements) {
			actualList.add(element.getText().trim());
		}
		System.out.println("Verify actal and expected list are matching");
		Assert.assertEquals(actualList, expectedList);
		System.out.println("click on abort");
		webelements.get(1).click();
		
		System.out.println("verify total employee are non zero");
		String employeeCount = driver.findElement(By.xpath("//div[@class=\"row\"]/div[3]/p")).getText();
		employeeCount = employeeCount.split(" ")[1];
		int empCnt = Integer.parseInt(employeeCount);
		Assert.assertTrue(empCnt>0);
		
		System.out.println("verify empoyee details feilds are getting displayed");
		List<WebElement> listOfElements = driver.findElements(By.xpath("//div[@class=\"row\"]/div/p"));
		List<String> actualWebelemt = new ArrayList<>();
		for(WebElement element:listOfElements) {
			actualWebelemt.add(element.getText().split(":")[0].trim());
		}
		List<String> expectedWebelement = new ArrayList<>();
		expectedWebelement.add("Company Name");
		expectedWebelement.add("Version");
		expectedWebelement.add("Employees");
		expectedWebelement.add("Users");
		expectedWebelement.add("Renewal on");
		Assert.assertEquals(actualWebelemt, expectedWebelement);
		
		System.out.println("click on ok");
		driver.findElement(By.xpath("//a[@id=\"heartbeatSubmitBtn\"]")).click();	
		
	}
	@AfterTest()
	public void closeDriver() {
		driver.close();
	}
	
	
}
