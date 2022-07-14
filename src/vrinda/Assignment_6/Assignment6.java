package vrinda.Assignment_6;

import java.util.LinkedHashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Assignment6 {
	private WebDriver driver;
	 void launchBrowser(String url)
	{
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();	
	}

	 @ Test
	 void getUniqueSetOfOffices() {
	 System.out.println("Step: Launch Chrome brower");
		launchBrowser("https://datatables.net/");

		int pageCount=driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		System.out.println("Step :find total pages");
		System.out.println(pageCount);

		String totalRecordsPpage=driver.findElement(By.xpath("//div[@id='example_info']")).getText().split(" ")[3];
		int recordsprPage=Integer.parseInt(totalRecordsPpage);
		System.out.println("Step :Total no of records pr page");
		System.out.println(totalRecordsPpage);

		Set<String> setOfUniqueOffices=new LinkedHashSet<String>();

		for(int outerIndex=1;outerIndex<pageCount;outerIndex++) {
			for(int innerIndex=1;innerIndex<=recordsprPage;innerIndex++) {
				setOfUniqueOffices.add(driver.findElement(By.xpath("//table[@id='example']//tr["+ innerIndex +"]/td[3]")).getText());
			}
			driver.findElement(By.xpath("//a[@id='example_next']")).click();
		  }
		System.out.println("Step: Uniqe set of offices "+setOfUniqueOffices);
		}
		
		
		
}
