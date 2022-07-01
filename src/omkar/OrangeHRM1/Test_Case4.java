package omkar.OrangeHRM1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Test_Case4 extends Test_Case1 {
	void TC_4() {
		TC_1();
		driver.findElement(By.xpath("//a[contains(text(),'My Info ')]")).click();
		WebElement personalDetails=driver.findElement(By.xpath("//h4[text()='Personal Details']"));
		Assert.assertTrue(personalDetails.isDisplayed());	
		
		driver.findElement(By.xpath("//a[contains(text(),'Salary')]")).click();
		String ctcString=driver.findElement(By.xpath("//div[text()='$168,500.00']")).getText();
		String t=ctcString.replace("$","").replace(",","");
		String ctc=t.substring(0, t.indexOf("."));
		int salaryCTC=Integer.parseInt(ctc);
		System.out.println("Step - Salary is "+salaryCTC);
		System.out.println(salaryCTC>0);
	}
}
