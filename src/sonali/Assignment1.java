package sonali;


	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class Assignment1 {
		void setup() throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://automationbykrishna.com");
			WebElement registerElement = driver.findElement(By.id("registration2"));
			registerElement.click();
			Thread.sleep(3000);
			WebElement user = driver.findElement(By.id("unameSignin"));
			user.sendKeys("Maulik");
			WebElement pass = driver.findElement(By.id("pwdSignin"));
			pass.sendKeys("Mkanani");
			WebElement submitElement = driver.findElement(By.id("btnsubmitdetails"));
			submitElement.click();
			//driver.switchTo().alert();
			Alert alert =driver.switchTo().alert();
			alert.accept();
			Thread.sleep(3000);
			driver.close();
		}

		public static void main(String[] args) throws InterruptedException {
			Assignment1 assignment = new Assignment1();
			assignment.setup();
		}

}
