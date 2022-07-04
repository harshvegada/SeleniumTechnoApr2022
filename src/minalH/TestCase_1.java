package minalH;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase_1 {

	WebDriver driver;
	public void verifyLoginFunctionality() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP : Launch url");
		driver.get("https://minalhake-trials7501.orangehrmlive.com/auth/login");
		
		System.out.println("STEP : Verify logo displayed on login page");
		if(driver.findElement(By.xpath("//div[@class='organization-logo shadow']")).isDisplayed())
			System.out.println("Test Pass !!");
		else
			System.out.println("Test Fail !!");
		
		System.out.println("\n"+"STEP : Verify login panel displayed on login page");
		if(driver.findElement(By.xpath("//div[@class='login-form shadow']")).isDisplayed())
			System.out.println("Test pass !!");
		else
			System.out.println("Test Fail !!");
		
		System.out.println("\n"+"STEP : Verify user is able to enter username");
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
		System.out.println("\n"+"STEP : Verify user is able to enter password");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("@tqGJP1nQ5");
		System.out.println("Test pass !!");
		
		System.out.println("\n"+"STEP : User click on login button");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		System.out.println("Test pass !!");
		
		System.out.println("\n"+"STEP : Verify Employee Management header should be visible on home page");
		if(driver.findElement(By.xpath("//div[text()='Employee Management']")).isDisplayed())
			System.out.println("Test Pass !!");
		else
			System.out.println("Test Fail !!");
	}
	
	public static void main(String[] args) {
		TestCase_1 login = new TestCase_1();
		login.verifyLoginFunctionality();
	}

}
