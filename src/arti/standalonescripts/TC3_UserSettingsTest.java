package arti.standalonescripts;

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

public class TC3_UserSettingsTest {

protected static WebDriver driver;
	
	public static void setUp(String url) {
		
		System.out.println("STEP -  Launch Browser");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		System.out.println("STEP -  Load Url");
		driver.get(url);
		
		driver.manage().window().maximize();	
	}
	
	public static void setUp() {
		
		setUp("https://artitechno-trials7501.orangehrmlive.com/");
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void login(String username, String password) {
		
		enterUsername(username);
		enterPassword(password);
		clickOnLoginButton();
	}
	
	public void enterUsername(String username) {
		
		getUserNameElement().sendKeys(username);
	}
	
	public void enterPassword(String password) {
		
		getPasswordElement().sendKeys(password);
	}
	
	public void clickOnLoginButton() {
		
		driver.findElement(By.xpath("//div[@class='button-holder']/button")).click();
	}
	
	public WebElement getUserNameElement() {
		
		return driver.findElement(By.xpath("//input[@id='txtUsername']"));
	}
	
	public WebElement getPasswordElement() {
	
		return driver.findElement(By.xpath("//input[@id='txtPassword']"));
	}
	
	public String getUsername() {
		
		return getUserNameElement().getAttribute("value");
	}
	
	public String getPassword() {
		
		return getPasswordElement().getAttribute("value");
	}
	
	@Test
	public void verifyProfileSettings() {
		
		setUp();
		
		login("Admin","6cyNOTm3N@");
		
		System.out.println("VERIFY - User profile is displayed");
		
		WebElement profileImage = driver.findElement(By.xpath("//div[@class='image-container']/img"));
		Assert.assertTrue(profileImage.isDisplayed());
		
		WebElement settingsButtonElement = driver.findElement(By.xpath("//a[@class='password-action profile-context-menu-handler']/i[contains(text(),'ohrm_settings')]"));
		//Assert.assertTrue(settingsButtonElement.isDisplayed());
		
		Actions action = new Actions(driver);
		action.moveToElement(profileImage).click(settingsButtonElement).build().perform();
		
		List<String> expectedSettingButtonMenu = new ArrayList<String>();
		expectedSettingButtonMenu.add("Change Password");
		expectedSettingButtonMenu.add("About");
		
		List <WebElement> settingButtonMenu = driver.findElements(By.xpath("//div[@class='sub-menu-container-php profile-context-menu-handler opened']/div[@class='sub-menu-container']/div[@class='sub-menu-item']/a"));

		System.out.println("VERIFY - Settings button menu has 2 options");
		Assert.assertEquals(settingButtonMenu.size(), 2);
		
		System.out.println("VERIFY -  Settings Menu has 2 options : Change Password and About");
		List<String> actualList =  new ArrayList<String>();
		for(WebElement element : settingButtonMenu) {
			
			actualList.add(element.getText());	
		}
		
		Assert.assertEquals(expectedSettingButtonMenu, actualList);
		
		System.out.println("STEP - Click on the About link/Button");
		driver.findElement(By.xpath("//div[@class='sub-menu-container-php profile-context-menu-handler opened']/div[@class='sub-menu-container']/div[2]/a")).click();
		
		System.out.println("VERIFY -  Employee is more than 0");
		
		System.out.println("STEP - Find out number of Employees");
		
		String employeesWebElement = driver.findElement(By.xpath("//div[@class='col s12']/p[contains(text(),'Employees')]")).getText();
		
		String array[]= employeesWebElement.split(" ");
		
		int employeesCount = Integer.parseInt(array[1]);
		
		Assert.assertTrue(employeesCount>0);
		
		System.out.println(" VERIFY -  the company details fields are getting displayed on information alert (Company Name, Version, Employees, Users & Renewal on)");
		
		List<String> expectedCompanyInfoList = new ArrayList<String>();
		expectedCompanyInfoList.add("Company Name");
		expectedCompanyInfoList.add("Version");
		expectedCompanyInfoList.add("Employees");
		expectedCompanyInfoList.add("Users");
		expectedCompanyInfoList.add("Renewal on");
		
		List<WebElement> companyInfoElements = driver.findElements(By.xpath("//div[@id='companyInfo']/div/div"));
		
		List<String> actualCompanyInfoList = new ArrayList<String>();
		for(WebElement e : companyInfoElements) {
			
			actualCompanyInfoList.add(e.getText().split(":")[0].trim());
		}
		
		Assert.assertEquals(actualCompanyInfoList, expectedCompanyInfoList);
		//System.out.println(actualCompanyInfoList);
		
		System.out.println("STEP - Click on the Ok button");
		driver.findElement(By.xpath("//a[text()='Ok']")).click();
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public static void closeBroswer() {
		driver.close();
	}
	
}
