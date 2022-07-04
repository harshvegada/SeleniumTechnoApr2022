/*Program - 5. return username as key and firstname as value from table1*/

package tamanna;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class A4P5 {

	WebDriver driver;
	A4P5(){
		driver=Prerequisites.loadURL();
	}
	
	public Map<String,String> performTest() {
		Prerequisites.redirect(driver,  "demotable");
		
		List<WebElement> trElements = driver.findElements(By.xpath("//table[@id=\"table1\"]/tbody/tr"));
		Map<String,String> mapNames=new LinkedHashMap<String,String>();
		for (int index = 1; index <= trElements.size(); index++) {
			mapNames.put(driver.findElement(By.xpath("//table[@id=\"table1\"]/tbody/tr[" + index + "]/td[4]")).getText(), driver.findElement(By.xpath("//table[@id=\"table1\"]/tbody/tr[" + index + "]/td[2]")).getText());
		}
		
		return mapNames;
	}
	
	
	public static void main(String[] args) {
		A4P5 a4p5 = new A4P5();
		System.out.println(a4p5.performTest());
	}
}
