package sonali;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Assignment6 {
	@Test
	void test7() {
		System.out.println("STEP-Launch a browser");
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		System.out.println("STEP-URL");
		driver.get("https://datatables.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		int totalpages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		Set<String> setOfOffice = new HashSet<String>();
		for (int index = 0; index < totalpages; index++) {
			List<WebElement> listOfOffice = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));
			for (WebElement e : listOfOffice) {
				setOfOffice.add(e.getText());
				
			}
		    driver.findElement(By.xpath("//a[@id='example_next']")).click();
			
		}
		System.out.println(setOfOffice);
		driver.close();
	}
}
