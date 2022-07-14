package Gaurav;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC4 {
	


@Test
void case4() {
		
		System.setProperty("webdriver.driver.chrome", "chromebrowser");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get("https://gauravselenium-trials7501.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		
		WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
		username.sendKeys("Admin");
		
		WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		password.sendKeys("UR1icg5I@L");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		boolean topbar = driver.findElement(By.xpath("//div[text()='Employee Management']")).isDisplayed();
		System.out.println(topbar +" Employee Management topbar is displayed");
		
		driver.findElement(By.xpath("//a[text()='My Info ']")).click();
		
		WebElement personaldetails = driver.findElement(By.xpath("//div[@id='personal_details_tab']//label[text()='First Name']"));
		Assert.assertTrue(personaldetails.isDisplayed());
		System.out.println("Personal Details tab is displayed");
		
		driver.findElement(By.linkText("Salary")).click();
		WebElement ctc = driver.findElement(By.xpath("//div[@class='col-9 summary-cards-container']/div[1]/div[2][contains(text(),'$')]"));
		System.out.println("CTC Amount : " + ctc.getText());
		
		String salary = ctc.getText();
		salary = salary.replace("$", "").replace(",", "");
		salary = salary.substring(0, salary.indexOf("."));
		int ctcsalary = Integer.parseInt(salary);
		Assert.assertTrue(ctcsalary > 0);
		
		
		
}


public static void main(String[] args) {
	
	TC4 tc4 = new TC4();
	tc4.case4();
}
}
