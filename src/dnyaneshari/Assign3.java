/*Assignment - 3 : 17th Jun'2022

Step 1 : Go to URL - https://www.facebook.com/
Step 2 : Click on Create New Account button
Step 3 : Fill Signup form

Note : Don't click on Sign up button.*/
package dnyaneshari;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assign3 {
	private WebDriver driver;

	void launchBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
		System.out.println("Step-Launch Browser");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.xpath("//*[text()='Create New Account']")).click();
	}

	void newCreateAccount(String firstname, String lastName, String emailMobile, String password) {

		System.out.println("Step-Enter Fname,Lname,Email/MobileNumber,Password");
		WebElement fname = driver.findElement(By.name("firstname"));
		fname.clear();
		fname.sendKeys(firstname);

		WebElement lname = driver.findElement(By.name("lastname"));
		lname.clear();
		lname.sendKeys(lastName);

		WebElement emailorMobile = driver.findElement(By.name("reg_email__"));
		emailorMobile.clear();
		emailorMobile.sendKeys(emailMobile);

		WebElement pwd = driver.findElement(By.id("password_step_input"));
		pwd.clear();
		pwd.sendKeys(password);
	}
	
	void enterDateOfBirth(String dob,int dom,String doy) {
		System.out.println("Enter Date Of birth");
		WebElement day = driver.findElement(By.name("birthday_day"));
		Select date = new Select(day);
		date.selectByValue(dob);
		WebElement months = driver.findElement(By.name("birthday_month"));
		Select month = new Select(months);
		month.selectByIndex(dom);
		WebElement years = driver.findElement(By.name("birthday_year"));
		Select year = new Select(years);
		year.selectByValue(doy);
		driver.findElement(By.xpath("//input[@value='1']")).click();

		// driver.findElement(By.name("websubmit")).click();
	}
	
	void fillaccountDetail() {
		launchBrowser("https://www.facebook.com/");
		newCreateAccount("Dnyan", "Panchal", "7845128745", "Dpanch123");
		enterDateOfBirth("30",4,"1995");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Assign3 assign3 = new Assign3();
		assign3.fillaccountDetail();

	}

}
