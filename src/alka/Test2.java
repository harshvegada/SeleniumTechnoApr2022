/*Automate below scenario
1. Navigate to site `http://automationpractice.com/index.php`
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
Exam - 2 : 22nd Jun'2022 */

package alka;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test2
{
    	private WebDriver driver;
	  private	void setProperty(String url)

			{
	            System.out.println("STEP - Launch Chrome brower");
	        	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				 driver =new ChromeDriver();
				 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				 System.out.println("STEP - Load URL");
				 driver.get(url);
				 driver.manage().window().maximize();
			}
	  void navigateToElement(String elementXpath) {
			driver.findElement(By.xpath(elementXpath)).click();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}

		void createAccount() {
			System.out.println("enter random email address");
			WebElement emailElement=driver.findElement(By.xpath("//input[@id='email_create']"));
			emailElement.clear();
			emailElement.sendKeys("qqzdd312@xyz.com");
			System.out.println("Click on `Create an account` button");
			navigateToElement("//button[@id='SubmitCreate']");
		}

		void fillTextBox(String xpath,String value) {
			WebElement element=driver.findElement(By.xpath(xpath));
			element.clear();
			element.sendKeys(value);

		}

		void SelectDDValue(String xpath,String value) {
			WebElement element=driver.findElement(By.xpath(xpath));
			Select ddSelect=new Select(element);
			ddSelect.selectByValue(value);
		}

		void selectClickElements(String xpath) {
			driver.findElement(By.xpath(xpath)).click();
		}

		void fillForm() {
			selectClickElements("//input[@id='id_gender2']");
			fillTextBox("//input[@name='customer_firstname']", "alka");
			fillTextBox("//input[@name='customer_lastname']", "parab");
			fillTextBox("//input[@name='passwd']", "xyz123");

			SelectDDValue("//select[@id='days']", "20");
			SelectDDValue("//select[@id='years']", "1995");
			SelectDDValue("//select[@id='months']", "5");

			selectClickElements("//input[@id='newsletter']");
			selectClickElements("//input[@id='optin']");

			fillTextBox("//input[@id='firstname']", "alka");
			fillTextBox("//input[@id='lastname']", "parab");
			fillTextBox("//input[@id='company']", "exec");
			fillTextBox("//input[@id='address1']", "xyz, 123 abc");
			fillTextBox("//input[@id='address2']", "xyz, 23 abc");
			fillTextBox("//input[@id='city']", "Mumbai");

			SelectDDValue("//select[@id='id_state']", "33");
			fillTextBox("//input[@id='postcode']", "37201");
			fillTextBox("//textarea[@id='other']", "Test2 Description ");
			fillTextBox("//input[@id='phone']", "444 558 3333");
			fillTextBox("//input[@id='phone_mobile']", "444 333 5556");
			fillTextBox("//input[@id='alias']", "home");
			fillTextBox("//input[@id='postcode']", "23435");

			System.out.println("Click on `Register` button");
			navigateToElement("//button[@id='submitAccount']");
		}

		void verifyUsername() {
			String username=driver.findElement(By.xpath("//a[@class='account']/span")).getText();
			if(username.equals("alka parab")) {
				System.out.println("Username verified.");
			}else {
				System.out.println("Username cant be verified.");
			}
		}

	  void performTest() 
	  {
		    setProperty("http://automationpractice.com/index.php");
			System.out.println("Click on `Sign In` button top right corner");
			navigateToElement("//a[@class=\"login\"]");

			System.out.println("Verify  URL contains `my-account` keyword or not");
			if(driver.getCurrentUrl().contains("my-account")) {
				System.out.println("URL contains my-account word.");
			}else {
				System.out.println("URL does not contain my-account word.");
			}

			createAccount();

			System.out.println("Fill that form with any random details");
			fillForm();

			System.out.println("After Successfully registration  landed on My Account Page (Verify the title should contains My Account keyword)");
			if(driver.getTitle().contains("My account")) {
				System.out.println("My account in title verified.");
			}else {
				System.out.println("My account in title not available.");
			}

			System.out.println("Verify logged in name is combination of firstName and lastName");
			verifyUsername();

			System.out.println("Verify `Sign out` button is getting display");
			WebElement element=driver.findElement(By.xpath("//a[text()='Sign out']"));
			if(element.isDisplayed()) {
				System.out.println("Sign out button is displayed.");
				System.out.println("Click on `Sign out` button");
				element.click();

				System.out.println("Verify you landed on Login screen(verify page title)");
				if(driver.getTitle().contains("Login")) {
					System.out.println("You landed on login screen.");
				}
				else {
					System.out.println("You are not landed on login screen.");
				}
			}else {
				System.out.println("Cant find signout button.");
			}
		}
	  public static void main(String[] args) {
		  Test2 test2=new Test2();
		  test2.performTest();
			
		}
}
