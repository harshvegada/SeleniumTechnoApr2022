package alka;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment3 {
	private WebDriver driver;
	void setProperty(String url)
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
	}
	void fbSignupInfo(String url)
	{

	   setProperty(url);
	   System.out.println("STEP - Click on Create New Account button");
	   driver.findElement(By.linkText("Create New Account")).click();
	   System.out.println("STEP - Enter FirstName");
	   driver.findElement(By.name("firstname")).sendKeys("Alka");
	   System.out.println("STEP - Enter LastName");
	   driver.findElement(By.name("lastname")).sendKeys("Parab");
	   System.out.println("STEP - Enter EmailId");
	   driver.findElement(By.name("reg_email__")).sendKeys("alka1234@gmail.com");
	   System.out.println("STEP - ReEnter EmailId");
	   driver.findElement(By.name("reg_email_confirmation__")).sendKeys("alka1234@gmail.com");
	   System.out.println("STEP - Enter Password");
	   driver.findElement(By.name("reg_passwd__")).sendKeys("alka1234");
	   System.out.println("STEP - Enter Birth-day");
		WebElement birthDay=driver.findElement(By.name("birthday_day"));
		Select s1 = new Select(birthDay);
		s1.selectByValue("12");
		 System.out.println("STEP - Enter Birth-month");
		WebElement birthMonth=driver.findElement(By.name("birthday_month"));
		Select s2 = new Select(birthMonth);
		s2.selectByValue("10");
		 System.out.println("STEP - Enter Birth-year");
		WebElement birthYear=driver.findElement(By.name("birthday_year"));
		Select s3 = new Select(birthYear);
		s3.selectByValue("1986");
		System.out.println("Step -> Selecting Gender");
		WebElement gender =driver.findElement(By.xpath("//label[text()='Female']"));
		gender.click();	
	   
	}
	public static void main(String[] args)
	{
		Assignment3 assignment3 =new  Assignment3();
		assignment3.fbSignupInfo("https://www.facebook.com/");
	}
}
