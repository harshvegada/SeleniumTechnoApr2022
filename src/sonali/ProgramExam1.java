package sonali;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class ProgramExam1 {
	private WebDriver driver;

	void setup() {
		System.out.println("Navigate to site `http://automationpractice.com/index.php");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	void processdata() {
		System.out.println("Click on `Sign In` button top right corner");
		WebElement signin = driver.findElement(By.xpath("//a[@class=\"login\"]"));
		signin.click();
		System.out.println("Verify whether URL contains `my-account` keyword or not");
		String currentURL = driver.getCurrentUrl();
		if (currentURL.contains("my-account")) {
			System.out.println("URL contain my-account");
		} else {
			System.out.println("URL not contains my-account");
		}
		System.out.println("enter any random email address");
		WebElement email = driver.findElement(By.id("email_create"));
		email.sendKeys("sirussss.gf1@gmail.com");

		System.out.println("Click on `Create an account` button");
		WebElement createaccount = driver.findElement(By.id("SubmitCreate"));
		createaccount.click();
		WebElement radio = driver.findElement(By.xpath("//input[@value=\"2\"]"));
		radio.click();
		WebElement firstname = driver.findElement(By.id("customer_firstname"));
		firstname.sendKeys("Sonali");
		WebElement lastname = driver.findElement(By.id("customer_lastname"));
		lastname.sendKeys("Borase");
		WebElement passwd = driver.findElement(By.id("passwd"));
		passwd.sendKeys("Sonali");
		WebElement dropdownday = driver.findElement(By.id("days"));
		Select dropdown1 = new Select(dropdownday);
		dropdown1.selectByIndex(5);
		WebElement dropdownmonth = driver.findElement(By.id("months"));
		Select dropdown2 = new Select(dropdownmonth);
		dropdown2.selectByIndex(5);
		WebElement dropdownyears = driver.findElement(By.id("years"));
		Select dropdown3 = new Select(dropdownyears);
		dropdown3.selectByIndex(5);
		WebElement checkbox1 = driver.findElement(By.id("uniform-newsletter"));
		checkbox1.click();
		WebElement checkbox2 = driver.findElement(By.id("uniform-optin"));
		checkbox2.click();
		WebElement cname = driver.findElement(By.id("company"));// a[@class="logout"]
		cname.sendKeys("Sonali");
		WebElement address1 = driver.findElement(By.id("address1"));
		address1.sendKeys("Sonali");
		WebElement address2 = driver.findElement(By.id("address2"));
		address2.sendKeys("Sonali");
		WebElement city = driver.findElement(By.id("city"));
		city.sendKeys("Sonali");
		WebElement statedropdown = driver.findElement(By.id("id_state"));
		Select dropdownstate = new Select(statedropdown);
		dropdownstate.selectByIndex(10);
		WebElement zipcode = driver.findElement(By.id("postcode"));
		zipcode.sendKeys("12345");
		WebElement mobileno = driver.findElement(By.id("phone_mobile"));
		mobileno.sendKeys("956234587");
		WebElement submitbutton = driver.findElement(By.id("submitAccount"));
		submitbutton.click();
		String title = driver.getTitle();
		if (title.contains("My account")) {
			System.out.println("Title contain my-account");
		} else {
			System.out.println("Title not contains my-account");
		}

		WebElement signout = driver.findElement(By.xpath("//a[@class=\"account\"]"));
		System.out.println("Signout is displaed" + signout.isDisplayed());
		WebElement signout1 = driver.findElement(By.xpath("//a[@class=\"logout\"]"));
		signout1.click();

		String signouttitle = driver.getTitle();
		if (signouttitle.contains("Login")) {
			System.out.println("Title contain login");
		} else {
			System.out.println("Title not contains login");

		}
		driver.close();
	}

	public static void main(String[] args) {
		ProgramExam1 programexam1 = new ProgramExam1();
		programexam1.setup();
		programexam1.processdata();

	}
}
