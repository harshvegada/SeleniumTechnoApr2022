/*Assignment - 4 : 18th Jun'2022

Program - 1. Print whole table using 2 for loop*/

package tamanna;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class A4P1 {

	WebDriver driver;
	A4P1(){
		driver=Prerequisites.loadURL();
	}
	
	void performTest() {
		Prerequisites.redirect(driver, "demotable");
		
		List<WebElement> trElements=driver.findElements(By.xpath("//table[@id=\"table1\"]//tr"));
		for(int index=1;index<=trElements.size();index++) {
			String value="";
			for(int innerIndex=1;innerIndex<=4;innerIndex++) {
				value+=driver.findElement(By.xpath("//table[@id=\"table1\"]/tbody/tr["+ index +"]/td["+ innerIndex+"]")).getText()+" ";
			}
			System.out.println(value);
		}
	}
	
	public static void main(String[] args) {
		A4P1 a4p1=new A4P1();
		a4p1.performTest();
	}
}
