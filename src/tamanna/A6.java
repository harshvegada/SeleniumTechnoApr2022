/*Assignment - 6 : 3rd July'2022

1.Navigate to https://datatables.net/
2. get unique set of offices.

Hint : Find total pages, find office as elements, navigate to next page.


DataTables | Table plug-in for jQuery
https://datatables.net

*/

package tamanna;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class A6 {

	WebDriver driver;

	A6() {
		driver = Prerequisites.loadURL("https://datatables.net/");
	}

	@Test
	void test() {
		// 2. get unique set of offices.
		Set<String> setOffices = new HashSet<>();
		List<WebElement> noOfPages = driver
				.findElements(By.xpath("//div[@class='dataTables_paginate paging_simple_numbers']/span/a"));
		int index = 1;

		while (index <= noOfPages.size()) {

			List<WebElement> tdElement = driver.findElements(By.xpath("//table[@id='example']/tbody//tr/td[3]"));
			for (WebElement element : tdElement) {
				setOffices.add(element.getText());
			}

			if (index != noOfPages.size()) {
				WebElement nextBtnElement = driver.findElement(By.xpath("//a[@class='paginate_button next']"));
				nextBtnElement.click();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			}
			index++;
		}
		
		System.out.println(setOffices);
	}
}
