/*Assignment - 6 : 3rd July'2022

1.Navigate to https://datatables.net/
2. get unique set of offices.

Hint : Find total pages, find office as elements, navigate to next page.


DataTables | Table plug-in for jQuery
https://datatables.net
*/
package minalH;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6 {
	
	WebDriver driver;
	void setup() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://datatables.net/");
	}
	
	Set<String> getUniqueOffices(){
		setup();
		int totalPages = driver.findElements(By.xpath("//div[@id='example_paginate']//span//a")).size();
		Set<String> setOfOffices = new HashSet<String>();
		for(int index = 1; index <= totalPages; index++) {
			List<WebElement> listOfOffices = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));
			for(WebElement e : listOfOffices) {
				setOfOffices.add(e.getText());
			}
			if(index != totalPages) {
				driver.findElement(By.xpath("//a[@id='example_next']")).click();
			}
		}
		return setOfOffices;
	}
	
	public static void main(String[] args) { 
		Assignment6 assignment6 = new Assignment6();
		Set<String> setOfOffices = assignment6.getUniqueOffices();
		System.out.println(setOfOffices);
	}
}
