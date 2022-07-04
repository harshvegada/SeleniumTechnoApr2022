/*Assignment - 6 : 3rd July'2022

1.Navigate to https://datatables.net/
2. get unique set of offices.

Hint : Find total pages, find office as elements, navigate to next page.
*/
package pragati;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Assignment_6 {
	@Test
	public void uniqueSetOfOffices() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://datatables.net/");
		System.out.println("STEP: navigat to url");

		System.out.println("STEP: Get total pages ");
		int pageCount = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();

		System.out.println("VERIFY: Unique set of offices");
		Set<String> uniqueOfficeSet = new HashSet<String>();
		for (int index = 1; index <= pageCount; index++) {
			List<WebElement> listOfOffice = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));
			for (WebElement offices : listOfOffice) {
				uniqueOfficeSet.add(offices.getText());
			}
			if (index != pageCount) {
				driver.findElement(By.xpath("//a[@class='paginate_button next']")).click();
			}

		}
		System.out.println("Unique Office Set -> " + uniqueOfficeSet);

		System.out.println("STEP:Current browser instance closed:-");
		driver.close();
	}
}