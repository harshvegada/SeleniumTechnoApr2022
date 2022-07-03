package minu;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment6 {

	private static WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.out.println("STEP - Launch Chrome brower");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("STEP - Navigate to https://datatables.net/");
		driver.get("https://datatables.net/");
		driver.manage().window().maximize();
	}

	@Test
	public void getUniqueOffice() {

		System.out.println("STEP - Get total number of pages");
		int totalPages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		Set<String> setOfOffices = new LinkedHashSet<String>();

		System.out.println("STEP - find total offices");
		for (int index = 1; index <= totalPages; index++) {
			List<WebElement> listOfOffices = driver.findElements(By.xpath("//table[@id='example']//tbody/tr/td[3]"));

			for (WebElement office : listOfOffices) {
				setOfOffices.add(office.getText());
			}

			// find out next button
			WebElement nextButton = driver.findElement(By.id("example_next"));

			// STEP - Navigate to next page;
			if (nextButton.isEnabled())
				nextButton.click();
		}

		System.out.println("Unique set of offices: " + setOfOffices);
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
