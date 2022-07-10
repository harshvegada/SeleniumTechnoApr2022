package omkar;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
	void prerequsiteActions() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://datatables.net");
		driver.manage().window().maximize();
		
	}
	
	@Test
	void uniqueSetOfOffices() {		
		
		int pageSize=driver.findElements(By.xpath("//div[@id='example_paginate']//span/a")).size();
		System.out.println("Page count is "+pageSize);
		
		Set<String> uniqueSetOffice=new LinkedHashSet<String>();
		for(int page=1;page<=pageSize;page++) {
			List<WebElement> listOfUniqueOffice= driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));
			for(WebElement e : listOfUniqueOffice ) {
				uniqueSetOffice.add(e.getText());
			}
			if(page !=pageSize)
				driver.findElement(By.xpath("//a[@class='paginate_button next']")).click();
		}
		System.out.println("Total Unique office count is "+uniqueSetOffice.size());
		System.out.println("Unique office are :- "+uniqueSetOffice);
	}
	
	@AfterClass
	void tearDown() {
		driver.close();
	}
}
