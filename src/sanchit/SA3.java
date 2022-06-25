/*Assignment - 3 : 17th Jun'2022

Step 1 : Go to URL - https://www.facebook.com/
Step 2 : Click on Create New Account button
Step 3 : Fill Signup form

Note : Don't click on Sign up button.*/

package sanchit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SA3 {

	private static WebDriver driver;

	void launchChromeBrowserLoadFacebookUrl() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	}

	void fillCreateNewAccountForm(String firstName, String lastName, String emailOrPhNum, String password,
			String daySelect, String monthSelect, String yearSelect, String gender) {
		System.out.println("Create New Account: : starts:-");
		driver.findElement(By.linkText("Create New Account")).click();
		WebElement elementFirstName = driver.findElement(By.name("firstname"));
		elementFirstName.sendKeys(firstName);
		System.out.println("First Name: " + firstName);
		WebElement elementLastName = driver.findElement(By.name("lastname"));
		elementLastName.sendKeys(lastName);
		System.out.println("Last Name: " + lastName);
		WebElement elementEmailOrPhoneNum = driver.findElement(By.name("reg_email__"));
		elementEmailOrPhoneNum.sendKeys(emailOrPhNum);
		System.out.println("eMail/Phone Number: " + emailOrPhNum);
		WebElement elementPassword = driver.findElement(By.id("password_step_input"));
		elementPassword.sendKeys(password);
		System.out.println("Password: " + password);
		Select dayDropDown = new Select(driver.findElement(By.id("day")));
		dayDropDown.selectByValue(daySelect);
		System.out.println("Day of birth: " + daySelect);
		Select monthDropDown = new Select(driver.findElement(By.id("month")));
		monthDropDown.selectByValue(monthSelect);
		System.out.println("Month of birth: " + monthSelect);
		Select yearDropDown = new Select(driver.findElement(By.id("year")));
		yearDropDown.selectByValue("1993");
		System.out.println("Year of birth: " + yearSelect);

		if (gender.equals("Female")) {
			driver.findElement(By.xpath("//input[@value='1']")).click();
			System.out.println("Gender: " + gender);
		} else if (gender.equals("Male")) {
			driver.findElement(By.xpath("//input[@value='2']")).click();
			System.out.println("Gender: " + gender);
		} else if (gender.equals("Custom")) {
			WebElement preferredPronoun = driver.findElement(By.xpath("//input[@value='-1']"));
			JavascriptExecutor jE = (JavascriptExecutor) driver;
			jE.executeScript("arguments[0].scrollIntoView(true)", preferredPronoun);
			preferredPronoun.click();
			System.out.println("Gender: " + gender);
			Select proNounDroDown = new Select(driver.findElement(By.name("preferred_pronoun")));
			proNounDroDown.selectByValue("6");
			driver.findElement(By.name("custom_gender")).sendKeys("Others");
			System.out.println("Custom Gender: Others");
		}
	}

	public static void main(String[] args) {
		SA3 sa3 = new SA3();
		sa3.launchChromeBrowserLoadFacebookUrl();
		
		String firstN = "Asdfg";
		String lastN = "Zxc";
		String emailOrPhoneNum = "9876987698";
		String password = "1q2w3e4r";
		String dayDOB = "5";
		String monthDOB = "5";
		String yearDOB = "1950";
		String gender = "Custom";
		sa3.fillCreateNewAccountForm(firstN, lastN, emailOrPhoneNum, password, dayDOB, monthDOB, yearDOB, gender);
		
		driver.quit();
	}
}
