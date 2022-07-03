/*Assignment - 6 : 3rd July'2022

1.Navigate to https://datatables.net/
2. get unique set of offices.

Hint : Find total pages, find office as elements, navigate to next page.*/
package alka;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Assignment6 {
	
	private WebDriver driver; 
	
	@BeforeClass
	public void setUp() {

		System.out.println("STEP - Launch Browser");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("STEP - Load Url");
		driver.get("https://datatables.net/");
		driver.manage().window().maximize();
	}

	@Test
	void getUniqueSetOfOffices()
	{
		int numberOfPages = driver.findElements(By.xpath("//div[@id='example_paginate']//span/a")).size();
 		Set<String>  hs=new HashSet<String>();
 		
        for(int index=1;index<=numberOfPages;index++)
        {
		List<WebElement> lstOffice=driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));
		
		for(int i=0;i<lstOffice.size();i++)
		{
		hs.add(lstOffice.get(i).getText());
		}
		if(driver.findElement(By.xpath("//a[@id='example_next']")).isEnabled())
		{
			driver.findElement(By.xpath("//a[@id='example_next']")).click();
		}
        }
		System.out.println(hs);
	}
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
