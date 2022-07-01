package pragati;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_4 {
	@Test
	public void testCase_4() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://technopragati-trials7501.orangehrmlive.com/auth/seamlessLogin");
		System.out.println("STEP: navigat to url");
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		System.out.println("STEP: entered user name");

		driver.findElement(By.id("txtPassword")).sendKeys("oVD1lqX5@Z");
		System.out.println("STEP: entered password");

		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		System.out.println("STEP: click on login button");
		
		System.out.println("STEP: click on My Info tab");
		driver.findElement(By.xpath("//a[contains(text(),'My Info')]")).click();
		
		System.out.println("VERIFY: user personal Info is displayed");
		WebElement personalDetailsElement = driver.findElement(By.xpath("//div[@id=\"personal_details_tab\"]//input[@id='firstName']"));
		Assert.assertTrue(personalDetailsElement.isDisplayed());
		
		System.out.println("STEP: click on Salary tab");
		driver.findElement(By.linkText("Salary")).click();
		
		System.out.println("VERIFY: payable CTC is non-zero");
		WebElement ctcElement = driver.findElement(By.xpath("//div[@class=\"col-9 summary-cards-container\"]/div[1]/div[2][contains(text(),'$')]"));
        System.out.println("CTCamt: " +ctcElement.getText());
        String ctcSalary = ctcElement.getText();
        ctcSalary = ctcSalary.replace("$", "").replace(",", "");
        ctcSalary=ctcSalary.substring(0, ctcSalary.indexOf("."));
		int ctcAmt= Integer.parseInt(ctcSalary);
		Assert.assertTrue(ctcAmt>0);
	}
}
