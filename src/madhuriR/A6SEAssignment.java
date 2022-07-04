package madhuriR;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*Assignment - 6 : 3rd July'2022

1.Navigate to https://datatables.net/
2. get unique set of offices.

Hint : Find total pages, find office as elements, navigate to next page.*/
public class A6SEAssignment {
	WebDriver driver;
	@BeforeTest
	void setUp() {
		System.out.println("lounch browser activity");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://datatables.net/");
	
		driver.manage().window().maximize();
	}
	@Test
	void getUniqueOffices() {
		int totalPages = driver.findElements(By.xpath("//div[@id='example_paginate']//span/a")).size();
		Set<String> listOfCompanies = new  HashSet<String>();
		for(int index=1;index<=totalPages;index++) {
			List<WebElement> listOfOffices =driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));
			for(WebElement element:listOfOffices) {
				listOfCompanies.add(element.getText());
			}
			if(index!=totalPages) {
				driver.findElement(By.xpath("//a[@id='example_next']")).click();
			}
		}
		System.out.println(listOfCompanies);
		//return listOfCompanies;
	}
	@AfterTest
	void closeBrowser() {
		System.out.println("browser clean up activity");
		driver.close();
	}
}
