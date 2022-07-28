/*Assignment - 3 : 17th Jun'2022 

Step 1 : Go to URL -  https://www.facebook.com/ 
Step 2 : Click on  Create New Account  button
Step 3 : Fill Signup form

Note : Don't click on  Sign up  button.
*/

package prachi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment3 {
	
	private static WebDriver driver;
	
	static void setUp(String url) {
		
		System.out.println("STEP - Lauch Chrome Browser");
		System.setProperty("webdriver.chrome.driver", "D:\\Java Class\\technocredits\\SeleniumTechnoApr2022\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		System.out.println("STEP - Load Url");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	void FaceBookSignUp() {
		
		System.out.println("STEP- Click on Create New Account Button");
		driver.findElement(By.linkText("Create New Account")).click();
		
		System.out.println("Fill SIGN UP form");
		System.out.println("STEP - Enter First Name");
		WebElement fName = driver.findElement(By.name("firstname"));
		fName.sendKeys("Prachi");
		
		System.out.println("STEP - Enter Last Name");
		WebElement lName = driver.findElement(By.name("lastname"));
		lName.sendKeys("Jain");
		
		System.out.println("STEP - Enter Mobile Number Or Mail ID");
		WebElement element = driver.findElement(By.name("reg_email__"));
		element.sendKeys("7066377723");
		
		System.out.println("STEP - Enter Password");
		WebElement password = driver.findElement(By.name("reg_passwd__"));
		password.sendKeys("0987654321");
		
		System.out.println("STEP - Enter Date Of Birth");
		
		System.out.println("Select Date");
		WebElement day = driver.findElement(By.id("day"));
		
		Select selectDay = new Select(day);
		selectDay.selectByValue("22");
		
		System.out.println("Select Month");
		WebElement month = driver.findElement(By.id("month"));
		
		Select selectMonth = new Select(month);
		selectMonth.selectByValue("6");
		
		System.out.println("Select year");
		WebElement year = driver.findElement(By.id("year"));
		
		Select selectyear = new Select(year);
		selectyear.selectByValue("1985");
		
		System.out.println("STEP- Select Gender");
		
		WebElement female = driver.findElement(By.xpath("//input[@value='1']"));
		
		if(!female.isSelected())
			female.click();
		
		System.out.println("RESULT - Test Pass");
	}	
		public static void main(String[] args) {
			
			setUp("https://www.facebook.com/");
			System.out.println();
			System.out.println("\nTest Case - Verify Facebook Sign Up Page");
			new Assignment3().FaceBookSignUp();
			System.out.println();
	}

}
