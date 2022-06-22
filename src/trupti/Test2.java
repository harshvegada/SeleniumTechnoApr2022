package trupti;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test2 {
	static private WebDriver driver;
	static void setUp(String url) {
		System.out.println("STEP -Launch Browser");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("STEP-go to URL");
		driver.get(url);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		System.out.println("STEP-Click on sign in Button top right corner:");
		driver.findElement(By.className("login")).click();
		
		System.out.println("STEP- Verify URl contains My Account keyword or not:");
		boolean isContainMyAccountKeyWord = driver.getCurrentUrl().contains("my-account");
		if (isContainMyAccountKeyWord)
			System.out.println("Test Case Pass");
		else
			System.out.println("Test Case Fail");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;// for scrollDown
		js.executeScript("window.scrollBy(0,250)", "");
		System.out.println("STEP-Enter any random email address");
		driver.findElement(By.id("email_create")).sendKeys("trupti123@gmail.com");

		System.out.println("STEP-Click on create an account button");
		driver.findElement(By.id("SubmitCreate")).click();

		System.out.println("STEP-Click on MRs button");
		driver.findElement(By.id("id_gender2")).click();

		System.out.println("STEP-Enter First Name");
		WebElement userName = driver.findElement(By.id("customer_firstname"));
		userName.sendKeys("Trupti");

		System.out.println("STEP-Enter Last Name");
		WebElement userLastName = driver.findElement(By.id("customer_lastname"));
		userLastName.sendKeys("Hendre");

		System.out.println("STEP-Enter passward");
		driver.findElement(By.id("passwd")).sendKeys("12345");
		
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;// for scrollDown
		js.executeScript("window.scrollBy(0,250)", "");
		System.out.println("STEP-Select Date of Birth");
		WebElement dateElement = driver.findElement(By.id("days"));
		Select select = new Select(dateElement);
		select.selectByValue("14");
		
		System.out.println("STEP-Select Moth Of Birth");
		WebElement monthElement = driver.findElement(By.id("months"));
		Select select1 = new Select(monthElement);
		select1.selectByValue("8");
		
		JavascriptExecutor JavascriptExecutor1 = (JavascriptExecutor) driver;// for scrollDown
		js.executeScript("window.scrollBy(0,250)", "");
		System.out.println("STEP-Select Year Of Bith");
		WebElement yearElement = driver.findElement(By.id("years"));
		Select select2 = new Select(yearElement);
		select2.selectByValue("1990");

		System.out.println("STEP-Enter Company Name");
		driver.findElement(By.id("company")).sendKeys("Globant");

		System.out.println("STEP-Enter Address");
		driver.findElement(By.id("address1")).sendKeys("Globant,Baner");

		System.out.println("STEP-Enter Address line2");
		driver.findElement(By.id("address2")).sendKeys("Globant,Baner,pune");

		System.out.println("STEP-Enter City");
		driver.findElement(By.id("city")).sendKeys("pune");

		System.out.println("STEP-Enter State");
		WebElement stateElement = driver.findElement(By.id("id_state"));
		Select select3 = new Select(stateElement);
		select3.selectByValue("4");
		
		System.out.println("STEP-Enter pin");
		driver.findElement(By.id("postcode")).sendKeys("37201");
		
		System.out.println("STEP-Enter Additional information");
		driver.findElement(By.id("other")).sendKeys("6666666666");
		
		System.out.println("STEP-Home Phone");
		driver.findElement(By.id("phone")).sendKeys("9999999999");
		
		System.out.println("STEP-Mobile Phone");
		driver.findElement(By.id("phone_mobile")).sendKeys("1212121212");
		
		System.out.println("STEP-Assign an address alias for future reference");
		driver.findElement(By.id("alias")).clear();
		driver.findElement(By.id("alias")).sendKeys("Balewadi");
		
		System.out.println("STEP-clik on Register");
		driver.findElement(By.id("submitAccount")).click();
		
		System.out.println("STEp-Get title");
		String title = driver.getTitle();
		String expectedTitle="My account - My Store";
		System.out.println("Title Of Page:- " + title);
		if (title.equals(expectedTitle))
			System.out.println("Test Case Pass");
		else
			System.out.println("Test Case Fail");

		String loginName = driver.findElement(By.className("account")).getText();
		System.out.println("title-"+loginName);
		String expectedName="Trupti Hendre";
		if (loginName.equals(expectedName))
			System.out.println("Test Case Pass");
		else
			System.out.println("Test Case Fail");

		System.out.println("STEP-Find  Sign Out");
		boolean isSignOut = driver.findElement(By.className("logout")).isDisplayed();
		if (isSignOut)
			System.out.println("Test Case Pass");
		else
			System.out.println("Test case Fail");

		System.out.println("STEP-click on Sign Out");
		driver.findElement(By.className("logout")).click();
		
		System.out.println("STEP-Verify Page Title");
		String pageTitle = driver.getTitle();
		System.out.println("Title:-"+pageTitle);
		String expectedTitle1="Login - My Store";
		if (pageTitle.equals(expectedTitle1))
			System.out.println("Test Case Pass");
		else
			System.out.println("Test Case Fail");

		driver.close();

	}

	public static void main(String[] args) {
		setUp("http://automationpractice.com/index.php");
	}
}
