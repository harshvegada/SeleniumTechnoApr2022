package bhushan;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/*Assignment - 6 : 3rd July'2022

1.Navigate to https://datatables.net/
2. get unique set of offices.

Hint : Find total pages, find office as elements, navigate to next page.*/
public class Assignment6 {
  
 
  public HashSet<String> findUniqueSetofOffice() {
	    System.out.println("Step-- Launch Browser");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://datatables.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Step--Find Total no of Pages");
		List<WebElement> totalpages=driver.findElements(By.xpath("//div[@id='example_paginate']//span/a"));
		
		HashSet<String> listofOffice=new HashSet<String>();
		
		for(int index=1;index<=totalpages.size();index++) {
			int innerindexsize=driver.findElements(By.xpath("//table[@id='example']//tbody/tr/td[3]")).size();
				for(int i=1;i<=innerindexsize;i++) {
					String s=driver.findElement(By.xpath("//table[@id='example']//tbody/tr["+i+"]/td[3]")).getText();
						listofOffice.add(s);			
			}
			  if(driver.findElement(By.xpath("//a[@id='example_next']")).isEnabled()) {
				  driver.findElement(By.xpath("//a[@id='example_next']")).click();
				}
			}
			System.out.println(listofOffice);
			return listofOffice;
	}
  public static void main(String[] args) {
	  Assignment6 ass6=new Assignment6();
	  ass6.findUniqueSetofOffice();
}
	
}
