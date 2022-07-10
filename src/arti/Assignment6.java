/*Assignment - 6 : 3rd July'2022

1.Navigate to https://datatables.net/
2. get unique set of offices.

Hint : Find total pages, find office as elements, navigate to next page.*/

package arti;

import java.util.HashSet;
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
	public void setUp() {
		
		System.out.println("STEP - Launch Browser");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		System.out.println("STEP - Load Url");
		driver.get("https://datatables.net/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void getUniqueCities() {
		
		Set<String> setOfCities = new HashSet<String>();
		
		System.out.println("STEP - Find number of pages");
		
		int numberOfPages = driver.findElements(By.xpath("//div[@id='example_paginate']//span/a")).size();
		
		System.out.println("STEP - Find number of Rows");
		
		for(int pageIndex = 1; pageIndex <= numberOfPages; pageIndex++) {
			
			int numberRowsOnPage = driver.findElements(By.xpath("//table[@id='example']//tbody/tr")).size();
			
			for(int index = 1; index <= numberRowsOnPage; index++) {
			
				String cityName = driver.findElement(By.xpath("//table[@id='example']//tbody/tr["+index+"]/td[3]")).getText();
				setOfCities.add(cityName);
			}
			
			// find out next button By id
			WebElement nextButton = driver.findElement(By.id("example_next"));
			
			//navigate to next page using next button click
			if(nextButton.isEnabled())
				nextButton.click();
		}
		System.out.println("Set of cities -->"+setOfCities);
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
}

