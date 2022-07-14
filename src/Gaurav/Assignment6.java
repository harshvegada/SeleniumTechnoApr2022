package Gaurav;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Assignment6 {
	
	@Test
	void uniqueOffices() {
			
			System.setProperty("webdriver.driver.chrome", "chromebrowser");
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			driver.get("https://datatables.net/");
			driver.manage().window().maximize();
			
			int totalpages = driver.findElements(By.xpath("//div[@id='example_paginate']//span/a")).size();
			Set<String> setofoffices = new HashSet<String>();
			
			for(int index=1;index<=totalpages;index++) {
				List<WebElement> listofoffices = driver.findElements(By.xpath("//table[@id='example']/tbody//tr//td[3]"));
				
				for(WebElement e : listofoffices) {
					setofoffices.add(e.getText());
					
				}
				
				if(index != totalpages)
					
					driver.findElement(By.xpath("//a[@id='example_next']")).click();
				
			}
			System.out.println(setofoffices);
			
	}

}
