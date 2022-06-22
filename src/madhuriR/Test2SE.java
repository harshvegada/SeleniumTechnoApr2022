package madhuriR;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test2SE {
	
	void m1() {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Step1:Nevigate to http://automationpractice.com/index.php ");
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		System.out.println("Step2:click on sing in button");
		WebElement element=driver.findElement(By.xpath("//div[@class=\"header_user_info\"]/a"));		
		element.click();
		String url=driver.getCurrentUrl();
			if(url.contains("my-account")) {
				System.out.println("Step3:Verify url contains My account");
				JavascriptExecutor je = (JavascriptExecutor)driver;
				je.executeScript("window.scrollTo(0,350)");
				System.out.println("Step4:Enter Random EmailId");
				driver.findElement(By.xpath("(//input[@class=\"is_required validate account_input form-control\"])[1]")).sendKeys("seema@gmail.com");
				System.out.println("Step5:click on create account button");
				driver.findElement(By.name("SubmitCreate")).click();
				
				System.out.println("Step6:Filling Personal form with random details");
				driver.findElement(By.xpath("//input[@id=\"id_gender2\"]")).click();
				driver.findElement(By.xpath("//input[@id=\"customer_firstname\"]")).sendKeys("Seema");
				driver.findElement(By.xpath("//input[@id=\"customer_lastname\"]")).sendKeys("Rajole");
				driver.findElement(By.xpath("//input[@id=\"passwd\"]")).sendKeys("rajole@1234");
				WebElement ele = driver.findElement(By.id("days"));
				Select s1 = new Select(ele);
				s1.selectByValue("17");
				
				WebElement ele1 = driver.findElement(By.id("months"));
				Select s2 = new Select(ele1);
				s2.selectByIndex(11);
				
				WebElement ele2 = driver.findElement(By.id("years"));
				Select s3 = new Select(ele2);
				s3.selectByValue("1995");
				
				driver.findElement(By.xpath("//input[@id=\"newsletter\"]")).click();
				driver.findElement(By.xpath("//input[@id=\"optin\"]")).click();
				
				driver.findElement(By.id("company")).sendKeys("Globant");
				driver.findElement(By.id("address1")).sendKeys("At post eklahare");
				driver.findElement(By.id("address2")).sendKeys("Near Primary school");
				driver.findElement(By.id("city")).sendKeys("Nashik");
				WebElement stateelement = driver.findElement(By.id("id_state"));
				Select oselect = new Select(stateelement);
				oselect.selectByVisibleText("Maine");
				
				driver.findElement(By.id("postcode")).sendKeys("37201");
				WebElement countryElement = driver.findElement(By.id("id_country"));
				Select select = new Select(countryElement);
				select.selectByValue("21");
				driver.findElement(By.id("phone_mobile")).sendKeys("8329616915");
				driver.findElement(By.id("alias")).sendKeys("Eklahare");
				System.out.println("Step7:click on Registration button");
				driver.findElement(By.xpath("//button[@id=\"submitAccount\"]")).click();
				
				System.out.println("Step8:Verify Page Title");
				String expectedTitle="My account";
				String title = driver.getTitle();
				if(expectedTitle.equals(title)) {
					System.out.println("Test case pass title is same");
				}
				System.out.println("Step9:Verify firstname and lastname is same or not");
				String currentName=driver.findElement(By.xpath("(//div[@class=\"header_user_info\"]/a)[1]")).getText();
				String ExpectedName="Seema Rajole";
				if(ExpectedName.equals(currentName)) {
					System.out.println("Test case pass name is same");
				}
				System.out.println("Step10:Verify sing out is displayed or not");
				if(driver.findElement(By.xpath("(//div[@class=\"header_user_info\"]/a)[2]")).isDisplayed()) {
					System.out.println("Step11:Click on sing out button");
					driver.findElement(By.xpath("(//div[@class=\"header_user_info\"]/a)[2]")).click();
				}
				System.out.println("Step12:Verify landed on login screen or not");
				String mainPageTitle= driver.getTitle();
				String firstTitle="Login - My Store";
				if(firstTitle.equals(mainPageTitle)) {
					System.out.println("Test case pass now on first page");
				}	
		}
	}public static void main(String[] args) {
		Test2SE t1 = new Test2SE();
		t1.m1();
	}
}
