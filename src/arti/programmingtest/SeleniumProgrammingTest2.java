/*maulik, 07:36
Automate below scenario

1. Navigate to site ``
2. Click on `Sign In` button top right corner
3. Verify whether URL contains `my-account` keyword or not
4. enter any random email address
5. Click on `Create an account` button
6. Fill that form with any random details
	a. use pin number as `37201`
7. Click on `Register` button
8. After Successfully registration you landed on My Account Page (Verify the title should contains My Account keyword)
9. Verify logged in name is combination of firstName and lastName
10. Verify `Sign out` button is getting display
11. Click on `Sign out` button
12. Verify you landed on Login screen(verify page title)
Exam - 2 : 22nd Jun'2022
*/
package arti.programmingtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumProgrammingTest2 {

	private WebDriver driver;
	
	void setup(String url){
		
		System.out.println("\nLauch Browser");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Technocredit\\SeleniumTechnoApr2022\\drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		System.out.println("\nLoad URL");
		driver.get(url);
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
	}
	
	void verifyUrlForKeyword() {
		
		System.out.println("\nSTEP - Click on `Sign In` button top right corner");
		
		driver.findElement(By.linkText("Sign in")).click();
		
		System.out.println("\nSTEP : Get current URL");
		
		String currentUrl = driver.getCurrentUrl();
		if(currentUrl.contains("my-account"))
			System.out.println("\nResult : Test Pass!!");
		else
			System.out.println("\nResult : Test Fail!!");
		
		verifyCreateAnAccount();
	}
	
	void verifyCreateAnAccount() {
		
		System.out.println("\n***************************************************************************************\n");
		System.out.println("\nTest Case - Verify entering valid mail ID and clicking on Create An account button");
		
		System.out.println("\nSTEP - Enter valid Email id");
		
		WebElement emailCreate = driver.findElement(By.id("email_create"));
		emailCreate.clear();
		emailCreate.sendKeys("artishinde8@gmail.com");
		
		System.out.println("\nSTEP - Click on the Create an account button");
		driver.findElement(By.id("SubmitCreate")).click();
		
		System.out.println("\nResult - Test Pass");
		
		fillForm("Arti","Shinde");
	}
	
	void fillForm(String firstName, String lastName) {
		
		System.out.println("\n***************************************************************************************\n");
		System.out.println("\nTest Case - Verify filling up the form and clicking on Register button");
		
		System.out.println("\nSTEP - Select gender as Mrs.");
		
		WebElement gender = driver.findElement(By.xpath("//div[@id='uniform-id_gender2']"));
		if(!gender.isSelected())
			gender.click();
		
		System.out.println("\nSTEP -  Enter First Name");
		WebElement fName = driver.findElement(By.xpath("//input[@id='customer_firstname']"));
		fName.clear();
		fName.sendKeys(firstName);
		
		System.out.println("\nSTEP -  Enter Last Name");
		WebElement lName = driver.findElement(By.xpath("//input[@id='customer_lastname']"));
		lName.clear();
		lName.sendKeys(lastName);
		
		System.out.println("\nSTEP -  Enter password");
		WebElement pwd = driver.findElement(By.xpath("//input[@id='passwd']"));
		pwd.clear();
		pwd.sendKeys("12345678");
		
		System.out.println("\nSTEP -  Enter Date Of Birth");
		
		System.out.println("\nSelect day");
		WebElement day = driver.findElement(By.id("days"));
		Select daySelect = new Select(day);
		daySelect.selectByIndex(12);
		
		System.out.println("Select month");
		WebElement month = driver.findElement(By.id("months"));
		Select monthSelect = new Select(month);
		monthSelect.selectByValue("8");
		
		System.out.println("Select year");
		WebElement year = driver.findElement(By.id("years"));
		Select yearSelect = new Select(year);
		yearSelect.selectByValue("1995");
		
		System.out.println("\nSTEP -  Enter Company Name");
		WebElement company = driver.findElement(By.id("company"));
		company.clear();
		company.sendKeys("BMC Software");
		
		System.out.println("\nSTEP -  Enter Address");
		WebElement adress1 = driver.findElement(By.id("address1"));
		adress1.clear();
		adress1.sendKeys("A203, Armada Society ");
		WebElement adress2 = driver.findElement(By.id("address2"));
		adress2.clear();
		adress2.sendKeys("Datta Mandir Road Wakad");
		
		System.out.println("\nSTEP -  Enter City Name");
		WebElement city = driver.findElement(By.id("city"));
		city.clear();
		city.sendKeys("Pune");
		
		System.out.println("\nSelect State");
		WebElement state = driver.findElement(By.id("id_state"));
		Select stateSelect = new Select(state);
		stateSelect.selectByValue("8");
		
		System.out.println("\nSTEP -  Enter PostalCode");
		WebElement postcode = driver.findElement(By.id("postcode"));
		postcode.clear();
		postcode.sendKeys("37201");
		
		System.out.println("\nSTEP -  Enter Additional information");
		WebElement addInfo = driver.findElement(By.id("other"));
		addInfo.clear();
		addInfo.sendKeys(" No Additional Information");
		
		System.out.println("\nSTEP -  Enter home phone");
		WebElement phone = driver.findElement(By.id("phone"));
		phone.clear();
		phone.sendKeys("23233405045");
		
		System.out.println("\nSTEP -  Enter mobile phone");
		WebElement mphone = driver.findElement(By.id("phone_mobile"));
		mphone.clear();
		mphone.sendKeys("65897847857");
		
		System.out.println("\nSTEP - Click on the Register button");
		driver.findElement(By.id("submitAccount")).click();
		System.out.println("\nResult - Test Pass!!");
		
		verifyMyAccountPage(firstName, lastName);
	}
	
	void verifyMyAccountPage(String firstName, String lastName) {
		
		System.out.println("\n***************************************************************************************\n");
		System.out.println("\nTest Case -  Verify the title should contains My Account keyword ");
		
		String title = driver.getTitle();
		System.out.println(title);
		
		if(title.contains("My account")) {
		
			System.out.println("\nPage contains My Account keyword");
			System.out.println("\nResult - Test Pass");
		}
		
		System.out.println("\n***************************************************************************************");
		System.out.println("\nTest Case - Verify logged in name is combination of firstName and lastName");
	
		String expectedloggedInName = firstName+" "+lastName;
		
		String actualName = driver.findElement(By.xpath("//span[text()='Arti Shinde']")).getText();

		if(actualName.equals(expectedloggedInName))
			System.out.println("\nResult - Test Pass");
		
		System.out.println("\n***************************************************************************************\n");
		System.out.println("\nTest Case - Verify Sign out button");
		WebElement signOut = driver.findElement(By.xpath("//a[@title='Log me out']"));
		
		if(signOut.isDisplayed()) {
			
			System.out.println("\nSign out button is displayed");
			System.out.println("\nResult - Test Pass");
		}
		
		System.out.println("\nSTEP - Click on `Sign out` button");
		signOut.click();
		
		System.out.println("\n***************************************************************************************\n");
		System.out.println("\nTest Case - Verify you landed on Login screen(verify page title)");
		
		String currentTitle = driver.getTitle();
		
		if(currentTitle.equals("Login - My Store")) {
			System.out.println("\nYou are navigated to Login page");
			System.out.println("\n Result - Test Pass");
		}
	}
	
	public static void main(String[] args) {
		
		SeleniumProgrammingTest2 test2 = new SeleniumProgrammingTest2();
		
		test2.setup("http://automationpractice.com/index.php");
		
		System.out.println("Test Case - Verify whether URL contains `my-account` keyword or not");
		test2.verifyUrlForKeyword();	
	}
}
