package omkar;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Assignment3_FacebookSignUp {
	private static WebDriver driver;
	static void urlLoad(String url) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver=new ChromeDriver();
		
		System.out.println("Step -> URL load");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		System.out.println("Step -> Click on Sign UP");
		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
	}
	
	static void signUpPage() {
		System.out.println("Step ->Entering name");
		driver.findElement(By.name("firstname")).sendKeys("Omkar");
		driver.findElement(By.name("lastname")).sendKeys("Raut");
		
		System.out.println("Step-> Entering Mobile number/ Gmail address");
		driver.findElement(By.name("reg_email__")).sendKeys("9096819656");
		
		System.out.println("Step-> Entering Password");
		driver.findElement(By.name("reg_passwd__")).sendKeys("1234567890");
		
		System.out.println("Step-> Selecting Birth date");
		
		WebElement birthDay=driver.findElement(By.name("birthday_day"));
		Select s1 = new Select(birthDay);
		s1.selectByValue("11");
		
		WebElement birthMonth=driver.findElement(By.name("birthday_month"));
		Select s2 = new Select(birthMonth);
		s2.selectByValue("8");
		
		WebElement birthYear=driver.findElement(By.name("birthday_year"));
		Select s3 = new Select(birthYear);
		s3.selectByValue("1990");
		
		
		System.out.println("Step -> Selecting Gender");
		WebElement gender =driver.findElement(By.xpath("//label[text()='Male']"));
		gender.click();		
	}

	public static void main(String[] args) {
		urlLoad("https://www.facebook.com/");
		signUpPage();
	}

}
