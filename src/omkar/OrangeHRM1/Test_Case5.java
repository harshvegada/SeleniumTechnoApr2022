package omkar.OrangeHRM1;

import org.openqa.selenium.By;
import org.testng.Assert;

public class Test_Case5 extends Test_Case1{
	void TC_5() {
		TC_1();
		driver.findElement(By.xpath("//a[@class=' main-menu-item-1']//span[text()='HR Administration']")).click();
		driver.findElement(By.xpath("//a[text()='Manage User Roles ']")).click();
		
		driver.findElement(By.xpath("//table[@class='highlight bordered']/tbody"));		
				
		int rowCount=driver.findElements(By.xpath("//table[@class='highlight bordered']/tbody/tr")).size();
		
		String pagination= driver.findElement(By.xpath("//li[@class='summary']")).getText().split(" ")[4];
		int totalRowCount= Integer.parseInt(pagination);		
		Assert.assertEquals(rowCount, totalRowCount);
		System.out.println("Veify :- total row and pagination count matched");		
	}
}
