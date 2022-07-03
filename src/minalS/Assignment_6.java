package minalS;
/*Assignment - 6 : 3rd July'2022

1.Navigate to https://datatables.net/
2. get unique set of offices.

Hint : Find total pages, find office as elements, navigate to next page.



DataTables | Table plug-in for jQuery
https://datatables.net
*/

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment_6 {
	
	private WebDriver driver;
	@BeforeClass
	void setUp() {
		System.out.println("STEP-Launch a browser");
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		System.out.println("STEP-URL");
		driver.get("https://datatables.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	}

	@Test
	void getUniqueSetOfOffice(){
		System.out.println("STEP- Find total pages");
		int totalPages=driver.findElements(By.xpath("//div[@id='example_paginate']//span//a")).size();
		System.out.println("Total pages - "+totalPages);
		
		System.out.println("STEP - get unique set of offices");
		Set<String> uniqueSetOfOffices=new LinkedHashSet<String>();
		for(int page=1;page<=totalPages;page++) {
			List<WebElement> listOfUniqueOffices=driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));
			for(WebElement e:listOfUniqueOffices) {
				uniqueSetOfOffices.add(e.getText());
			}
			if(page !=totalPages) {
				driver.findElement(By.id("example_next")).click();
			}
		}
		System.out.println("Unique set of offices : "+uniqueSetOfOffices);
	}

	void tearDown() {
		driver.close();
	}
	
}
