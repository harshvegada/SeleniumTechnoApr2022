/*Program - 8. find duplicate employee id if any. [Map<String, Integer>, key -> value >1]*/

package tamanna;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class A4P8 {

	WebDriver driver;

	A4P8() {
		driver = Prerequisites.loadURL();
	}

	public void performTest() {
		Prerequisites.redirect(driver, "demotable");

		List<WebElement> trElements = driver.findElements(By.xpath("//div[@id='empmanager']//table/tbody/tr"));
		Map<String, Integer> mapEmpIds = new LinkedHashMap<String, Integer>();
		for (int index = 1; index <= trElements.size(); index++) {
			String empId = driver.findElement(By.xpath("//div[@id='empmanager']//table/tbody/tr[" + index + "]/td[2]"))
					.getText();
			if (mapEmpIds.containsKey(empId)) {
				mapEmpIds.put(empId, mapEmpIds.get(empId) + 1);
			} else {
				mapEmpIds.put(empId, 1);
			}
		}

		System.out.println(mapEmpIds);
		System.out.println("Duplicate Values");
		Iterator<String> ie = mapEmpIds.keySet().iterator();
		while (ie.hasNext()) {
			String EmpId = ie.next();
			if (mapEmpIds.get(EmpId) > 1)
				System.out.println(EmpId);
		}
	}

	public static void main(String[] args) {
		A4P8 a4p8 = new A4P8();
		a4p8.performTest();
	}
}
