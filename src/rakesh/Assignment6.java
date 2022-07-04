/* Assignment - 6 : 3rd July'2022

1.Navigate to https://datatables.net/
2. get unique set of offices.

Hint : Find total pages, find office as elements, navigate to next page.
 */
package rakesh;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Assignment6 {
	
	@Test
	public void dataTables() {
		WebDriver driver = PreReq.setUp("https://datatables.net/");
		int pages = driver.findElements(By.xpath("//a[@class='paginate_button ']")).size();
		Set<String> getOfficeNames = new HashSet<>();
		for (int index = 1; index<=pages ; index++) {
			List<WebElement> ls = new ArrayList<>();
			ls = driver.findElements(By.xpath("//table[@id='example']//tbody//td[3]"));
			for (WebElement e : ls) {
				getOfficeNames.add(e.getText());
			}
			driver.findElement(By.id("example_next")).click();
		}	
		System.out.println("Unique offices are = ");
		System.out.println(getOfficeNames);
	}
}
