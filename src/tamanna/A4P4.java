/*Program - 4. return firstname of all employess from table1*/

package tamanna;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class A4P4 {

	WebDriver driver;
	A4P4(){
		driver=Prerequisites.loadURL();
	}
	
	public List<String> performTest() {
		Prerequisites.redirect(driver,  "demotable");
		
		List<WebElement> trElements = driver.findElements(By.xpath("//table[@id=\"table1\"]/tbody/tr"));
		List<String> lstFirstNames=new LinkedList<String>();
		for (int index = 1; index <= trElements.size(); index++) {
			lstFirstNames.add(driver.findElement(By.xpath("//table[@id=\"table1\"]/tbody/tr[" + index + "]/td[2]")).getText());
		}
		
		return lstFirstNames;
	}
	
	public static void main(String[] args) {
		A4P4 a4p4 = new A4P4();
		System.out.println(a4p4.performTest());
	}
}
