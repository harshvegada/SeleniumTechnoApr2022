/*Program - 7. find duplicate employee id if any. [HashSet, add return type]*/

package tamanna;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class A4P7 {
	
	WebDriver driver;
	A4P7(){
		driver=Prerequisites.loadURL();
	}
	
	public void performTest() {
		Prerequisites.redirect(driver,  "demotable");
		
		List<WebElement> trElements = driver.findElements(By.xpath("//div[@id='empmanager']//table/tbody/tr"));
		Set<String> setEmpids=new HashSet<String>();
		for (int index = 1; index <= trElements.size(); index++) {
			String empId=driver.findElement(By.xpath("//div[@id='empmanager']//table/tbody/tr[" + index + "]/td[2]")).getText();
			boolean isAdded=setEmpids.add(empId);
			if(!isAdded)
				System.out.println(empId);
		}
	}
	
	public static void main(String[] args) {
		A4P7 a4p7 = new A4P7();
		a4p7.performTest();
	}
}
