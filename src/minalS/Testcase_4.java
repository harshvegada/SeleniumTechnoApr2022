package minalS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase_4 {

	@Test
	void verifyPayableAmountIsNonZero() {
		System.out.println("STEP-Launch a browser");
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		System.out.println("STEP-URL");
		driver.get("https://minals-trials7501.orangehrmlive.com/auth/seamlessLogin");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		System.out.println("Enter User Name");
		WebElement useNameElement = driver.findElement(By.id("txtUsername"));
		useNameElement.sendKeys("Admin");

		System.out.println("Enter Passward");
		WebElement passwardElement = driver.findElement(By.id("txtPassword"));
		passwardElement.sendKeys("7@kOfBn8YV");

		System.out.println("Click on login button");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		System.out.println("STEP- Click on My Info");
		driver.findElement(By.partialLinkText("Info")).click();

		WebElement empDetailsElement = driver
				.findElement(By.xpath("//div[@id=\"personal_details_tab\"]//label[contains(text(),\"First Name\")]"));
		Assert.assertTrue(empDetailsElement.isDisplayed());
		System.out.println("VERIFY- user personal info is display");

		driver.findElement(By.linkText("Salary")).click();
		System.out.println("STEP- Clicked on Salary");

		WebElement ctcElement = driver.findElement(
				By.xpath("//div[@class='col-9 summary-cards-container']/div[1]/div[2][contains(text(),'$')]"));
		String ctcSalaryInString = ctcElement.getText();
		ctcSalaryInString = ctcSalaryInString.replace("$", "").replace(",", "");
		ctcSalaryInString = ctcSalaryInString.substring(0, ctcSalaryInString.indexOf("."));
		int ctcAmount = Integer.parseInt(ctcSalaryInString);
		Assert.assertTrue(ctcAmount > 0);
		System.out.println("STEP- checked payable ctc amount is nonzero");

	}
}
