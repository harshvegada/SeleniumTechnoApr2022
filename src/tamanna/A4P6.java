/*Program - 6. Unique surname from table1. [LinkedHashSet]*/

package tamanna;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class A4P6 {
	WebDriver driver;
	
	A4P6(){
		driver=Prerequisites.loadURL();
	}
	
	public Set<String> performTest() {
		Prerequisites.redirect(driver,  "demotable");
		
		List<WebElement> trElements = driver.findElements(By.xpath("//table[@id=\"table1\"]/tbody/tr"));
		Set<String> setSurnames=new LinkedHashSet<String>();
		for (int index = 1; index <= trElements.size(); index++) {
			setSurnames.add(driver.findElement(By.xpath("//table[@id=\"table1\"]/tbody/tr[" + index + "]/td[3]")).getText());
		}
		
		return setSurnames;
	}
	
	public static void main(String[] args) {
		A4P6 a4p6 = new A4P6();
		System.out.println(a4p6.performTest());
	}

}
