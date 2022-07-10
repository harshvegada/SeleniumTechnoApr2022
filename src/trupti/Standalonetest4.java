package trupti;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Standalonetest4 {
	@Test
	void paybleAmountIsNonZero() {
			System.out.println("STEP-Launch a browser");
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
			System.out.println("STEP-URL");
			driver.get("https://bhutkartrupti-trials7501.orangehrmlive.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			System.out.println("STEP-Enter User Name");
			driver.findElement(By.id("txtUsername")).sendKeys("Admin");
			
			System.out.println("STEP-Enter Passward");
			driver.findElement(By.id("txtPassword")).sendKeys("DBZ@6kHzb5");
			
			System.out.println("STEP- login button on login page");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			System.out.println("STEP- clicked on My Info button");
			driver.findElement(By.partialLinkText("My Info")).click();
			
			System.out.println("Verify user persional info display");
			WebElement persionalInformationElement=driver.findElement(By.xpath("//div[@id='personal_details_tab']//input[@id='firstName']")); 
			Assert.assertTrue(persionalInformationElement.isDisplayed());
			
			System.out.println("STEP-Clicked on salary");
			driver.findElement(By.linkText("Salary")).click();
			
			WebElement ctcElement=driver.findElement(By.xpath("//div[@class='col-9 summary-cards-container']/div[1]/div[2][contains(text(),'$')]"));
			String ctcAmount=ctcElement.getText();
			System.out.println(ctcAmount);
			ctcAmount=ctcAmount.replace("$", "").replace(",", "");
			String ctc=ctcAmount.substring(0, ctcAmount.indexOf("."));
			System.out.println("ctc="+ctc);
			int ctcAmountinInteger=Integer.parseInt(ctc);
			System.out.println("VERIFY-CTC amount non-zero");
			Assert.assertTrue(ctcAmountinInteger>0);
			driver.close();
			
	}
}
