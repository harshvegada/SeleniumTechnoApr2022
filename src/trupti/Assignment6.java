package trupti;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Assignment6 {
	static WebDriver driver;

	@Test
	void setUp() {
		System.out.println("STEP-Launch Browser");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("STEP-Load URL");
		driver.get("https://datatables.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Set<String> uniqueSetOfOffice = getUniqueSetOfOffice();
		System.out.println("Unique set of offices:" + uniqueSetOfOffice);
		driver.close();
	}

	Set<String> getUniqueSetOfOffice() {
		System.out.println("STEP-Get total number of pages");
		int totalNumberOfPages = driver.findElements(By.xpath("//div[@id='example_paginate']//span//a")).size();
		System.out.println("Total number of pages: " + totalNumberOfPages);

		System.out.println("STEP-Get unique set of office");
		Set<String> uniqueOfficeList = new LinkedHashSet<String>();
		for (int pages = 1; pages <= totalNumberOfPages; pages++) {
			List<WebElement> officeElementList = driver
					.findElements(By.xpath("//table[@id='example']//tbody/tr/td[3]"));
			for (WebElement officeElement : officeElementList) {
				uniqueOfficeList.add(officeElement.getText());
			}
			if (pages != totalNumberOfPages)
				driver.findElement(By.xpath("//a[@id='example_next']")).click();
		}
		return uniqueOfficeList;
	}
}
