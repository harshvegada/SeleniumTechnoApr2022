package Gaurav;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TC1 {

		
		void case1() {
				
				System.setProperty("webdriver.driver.chrome", "chromebrowser");
				WebDriver driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
				driver.get("https://gauravselenium-trials7501.orangehrmlive.com/");
				driver.manage().window().maximize();
				
				boolean logo = driver.findElement(By.xpath("//div[@class='organization-logo shadow']")).isDisplayed();
				System.out.println(logo + " Logo is displayed");
				
				boolean loginform = driver.findElement(By.xpath("//div[@class='login-form shadow']")).isDisplayed();
				System.out.println(loginform + " Loginform is displayed");
				
				WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
				username.sendKeys("Admin");
				
				WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
				password.sendKeys("UR1icg5I@L");
				
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				boolean topbar = driver.findElement(By.xpath("//div[text()='Employee Management']")).isDisplayed();
				System.out.println(topbar +" Employee Management topbar is displayed");
		}

		public static void main(String[] args) {
			
			TC1 tc1 = new TC1();
			tc1.case1();
		}
		

}
