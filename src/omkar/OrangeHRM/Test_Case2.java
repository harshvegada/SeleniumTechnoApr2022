package omkar.OrangeHRM;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test_Case2 extends Test_Case1 {
	
	public int getTotalWidgets(){
		List<WebElement> listOfWidgets= driver.findElements(By.xpath("//div[@class='dashboard-container']//div[@dragula-model='widgets']/div[not(contains(@class,'ng-hide'))]"));
		int count=0;
		for(WebElement e : listOfWidgets) {
			if(!e.getAttribute("class").endsWith("ng-hide"))
				count++;
		}
		return count;
	}
	
	public List<String> getWidgetsHeaderText(){
		List<WebElement> listOfWidgets = driver.findElements(By.xpath("//div[@class='dashboard-container']//div[@dragula-model='widgets']/div[not(contains(@class,'ng-hide'))]//div[@class='widget-header']/span[2]"));
		List<String> listOfWidgetsText = new ArrayList<String>();
		for(WebElement widget : listOfWidgets) {
			listOfWidgetsText.add(widget.getText());
		}
		return listOfWidgetsText;
	}
	
	void TC_2() {
		TC_1();	
		System.out.println("Total Widgets are "+getTotalWidgets());
		System.out.println("Total List of Widgets are "+getWidgetsHeaderText());
	}	
}
