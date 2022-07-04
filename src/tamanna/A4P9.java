/*Program - 9. Return map of Dept and employee count*/

package tamanna;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class A4P9 {
	
	WebDriver driver;
	A4P9(){
		driver=Prerequisites.loadURL();
	}
	
	public Map<String, Integer> performTest() {
		Prerequisites.redirect(driver, "demotable");

		List<WebElement> trElements = driver.findElements(By.xpath("//div[@id='empmanager']//table/tbody/tr"));
		Map<String, Integer> mapDept = new LinkedHashMap<String, Integer>();
		for (int index = 1; index <= trElements.size(); index++) {
			String dept = driver.findElement(By.xpath("//div[@id='empmanager']//table/tbody/tr[" + index + "]/td[5]"))
					.getText();
			if (mapDept.containsKey(dept)) {
				mapDept.put(dept, mapDept.get(dept) + 1);
			} else {
				mapDept.put(dept, 1);
			}
		}
		
		return mapDept;
	}
	
	public static void main(String[] args) {
		A4P9 a4p9 = new A4P9();
		System.out.println(a4p9.performTest());
	}
}
