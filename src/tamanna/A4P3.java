/*Program - 3. Print last rows from 1st table */

package tamanna;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class A4P3 {
	WebDriver driver;
	A4P3(){
		driver=Prerequisites.loadURL();
	}
	
	public void performTest() {
		Prerequisites.redirect(driver,  "demotable");
		
		List<WebElement> trElements = driver.findElements(By.xpath("//table[@id=\"table1\"]/tbody/tr"));
		String value = "";
		for (int innerIndex = 1; innerIndex <= 4; innerIndex++) {
			value += driver.findElement(By.xpath("//table[@id=\"table1\"]/tbody/tr[" + trElements.size() + "]/td[" + innerIndex + "]")).getText() + " ";
		}
		System.out.println(value);
	}
	
	public static void main(String[] args) {
		A4P3 a4p3 = new A4P3();
		a4p3.performTest();
	}

}
