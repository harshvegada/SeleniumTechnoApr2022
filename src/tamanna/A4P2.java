/*Program - 2. Print specific row : username - mkanani*/

package tamanna;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class A4P2 {

	WebDriver driver;

	A4P2() {
		driver = Prerequisites.loadURL();
	}

	void performTest() {
		Prerequisites.redirect(driver, "demotable");

		List<WebElement> trElements = driver.findElements(By.xpath("//table[@id=\"table1\"]//tr"));
		for (int index = 1; index <= trElements.size(); index++) {
			String username = driver.findElement(By.xpath("//table[@id=\"table1\"]/tbody/tr[" + index + "]/td[4]")).getText();
			if (username.equals("mkanani")) {
				String value = "";
				for (int innerIndex = 1; innerIndex <= 4; innerIndex++) {
					value += driver.findElement(By.xpath("//table[@id=\"table1\"]/tbody/tr[" + index + "]/td[" + innerIndex + "]")).getText() + " ";
				}
				System.out.println(value);
				break;
			}
		}
	}

	public static void main(String[] args) {
		A4P2 a4p2 = new A4P2();
		a4p2.performTest();
	}
}
