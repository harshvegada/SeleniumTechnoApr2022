/*Assignment - 6 : 3rd July'2022

1.Navigate to https://datatables.net/
2. get unique set of offices.

Hint : Find total pages, find office as elements, navigate to next page.*/

package sanchit;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SA6 {
	
	@Test
	void getUniqueSetOfOffice() {
		System.out.println("-:Launch Chrome Browser:-");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP: Load 'https://datatables.net/'");
		driver.get("https://datatables.net/");
		System.out.println("VERIFY: 'https://datatables.net/' loaded successfully");
		driver.manage().window().maximize();

		System.out.println("STEP: Get unique set of offices");
		int paginationCount = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();

		Set<String> uniqueOfficeSet = new HashSet<String>();
		for (int index = 1; index <= paginationCount; index++) {
			List<WebElement> officesElements = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));

			for (WebElement offices : officesElements) {
				uniqueOfficeSet.add(offices.getText());
			}

			if (index != paginationCount) {
				driver.findElement(By.xpath("//a[@id='example_next']")).click();
			}
		}
		System.out.println("Unique Office Set -> "+uniqueOfficeSet);
		System.out.println("VERIFY: Unique set of offices");
		driver.close();
		System.out.println("-:Current browser instance closed:-");
	}
}
