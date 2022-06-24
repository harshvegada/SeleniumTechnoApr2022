/*Assignment - 3 : 17th Jun'2022 

Step 1 : Go to URL -  https://www.facebook.com/ 
Step 2 : Click on  Create New Account  button
Step 3 : Fill Signup form

Note : Don't click on  Sign up  button.
*/
package arti;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignement3FBSignUp {

private static  WebDriver driver;
	
	static void setup(String url) {
		
		System.out.println("\nSTEP - Launch Chrome Browser");
		System.setProperty("webdriver.chrome.driver", "C:\\Technocredit\\SeleniumTechnoApr2022\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		System.out.println("\nSTEP - Load URL");
		driver.get(url);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); // added implicit wait which comes with driver so no need to add wait for every action
	}
	
	void fbSignUp() {
		
		System.out.println("\nSTEP - Click on the Create New Account button");
		driver.findElement(By.linkText("Create New Account")).click();
		
		System.out.println("\nFill SIGN UP form");
		System.out.println("\nSTEP - Enter First Name ");
		WebElement fName = driver.findElement(By.name("firstname"));
		fName.sendKeys("artishinde");;
		
		System.out.println("\nSTEP - Enter SurName");
		WebElement sName = driver.findElement(By.name("lastname"));
		sName.sendKeys("Shinde");
		
		System.out.println("\nSTEP - Enter Mobile Number OR Email ID");
		WebElement element = driver.findElement(By.name("reg_email__"));
		element.sendKeys("888343627");
		
		System.out.println("\nSTEP - Enter Password");
		WebElement password = driver.findElement(By.name("reg_passwd__"));
		password.sendKeys("arti123");
		
		System.out.println("\nSTEP - Enter Date Of Birth");
		
		System.out.println("\nSelect Date");
		WebElement day = driver.findElement(By.id("day"));
		
		Select selectDay = new Select(day);
		selectDay.selectByValue("18");
		
		System.out.println("\nSelect Month");
		WebElement month = driver.findElement(By.id("month"));
		
		Select selectMonth = new Select(month);
		selectMonth.selectByValue("2");
		
		System.out.println("\nSelect Year");
		WebElement year = driver.findElement(By.id("year"));
		
		Select selectYear = new Select(year);
		selectYear.selectByValue("1991");
		
		System.out.println("\nSTEP - Select gender");
		
		WebElement female = driver.findElement(By.xpath("//input[@value='1']"));
		
		if(!female.isSelected())
			female.click();
		
		System.out.println("RESULT - Test Pass");
		/* This part is for the gender options male and custom
		 * WebElement male = driver.findElement(By.xpath("//input[@value='2']"));
		 * if(!male.isSelected()) male.click();
		 * 
		 * WebElement custom = driver.findElement(By.xpath("//input[@value='-1']"));
		 * 
		 * if(!custom.isSelected()) {
		 * 
		 * custom.click();
		 * 
		 * WebElement pronounDD =
		 * driver.findElement(By.xpath("//select[@name='preferred_pronoun']"));
		 * 
		 * Select pronounSelect = new Select(pronounDD);
		 * 
		 * //List<WebElement> listOfPronouns = pronounSelect.getOptions();
		 * 
		 * pronounSelect.selectByValue("1"); }
		 */
	}
		
	public static void main(String[] args) {
	
		setup("https://www.facebook.com/");
		System.out.println("\n**************************************************************************************");
		System.out.println("\nTest Case - Verify Facebook Sign Up Page");
		new Assignement3FBSignUp().fbSignUp();
		System.out.println("\n**************************************************************************************");
	}	
}
