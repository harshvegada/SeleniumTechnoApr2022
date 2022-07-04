/*Program - 10. Return map of manager id and number of employees reporting to that manager.*/

package tamanna;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class A4P10 {

	WebDriver driver;
	A4P10(){
		driver=Prerequisites.loadURL();
	}
	
	public Map<String, Integer> performTest() {
		Prerequisites.redirect(driver, "demotable");

		List<WebElement> trElements = driver.findElements(By.xpath("//div[@id='empmanager']//table/tbody/tr"));
		Map<String, Integer> mapManagerId = new LinkedHashMap<String, Integer>();
		for (int index = 1; index <= trElements.size(); index++) {
			String managerId = driver.findElement(By.xpath("//div[@id='empmanager']//table/tbody/tr[" + index + "]/td[4]"))
					.getText();
			if (mapManagerId.containsKey(managerId)) {
				mapManagerId.put(managerId, mapManagerId.get(managerId) + 1);
			} else {
				mapManagerId.put(managerId, 1);
			}
		}
		
		return mapManagerId;
	}
	
	public static void main(String[] args) {
		A4P10 a4p10 = new A4P10();
		System.out.println(a4p10.performTest());
	}
}
