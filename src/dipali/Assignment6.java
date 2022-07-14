package dipali;

import java.util.HashSet;
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

	public WebDriver driver;

	@BeforeClass
	public void prdefinedActions() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://datatables.net/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Navigate to URL");
	}

	@Test
	void uniqueSetOfOffices() {		
		int pageNumber = driver.findElements(By.xpath("//div[@id='example_paginate']//span/a")).size();		
		Set<String> setOfOffices = new HashSet<String>();		
		for (int pageIndex=0;pageIndex<pageNumber;pageIndex++) {
			List<WebElement> listOfOficces = driver.findElements(By.xpath("//table[@id='example']//tr/td[3]"));
			for(WebElement e : listOfOficces) {
				setOfOffices.add(e.getText());
			}			
			if(pageIndex!=pageNumber)
				driver.findElement(By.xpath("//a[@id='example_next']"));			
		}
		System.out.println("Unique Office Set -> "+setOfOffices);
		System.out.println("VERIFY: Unique set of offices");
	}		
		@AfterClass
		void tearDown(){
			driver.close();		
			System.out.println("Browser closed");
		}			

}

