package ashish;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment6_SeleniumTable {

	private static WebDriver driver;

	public static WebDriver browserSetUp(String url) {
		System.out.println("PREREQUISITE - Launch Chrome brower");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("STEP - Launch URL");
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}

	@BeforeClass
	public void setUp() {
		driver = browserSetUp("https://datatables.net/");
	}

	@Test
	public void getUniqueSetOfOffices() {
		System.out.println("STEP - Get total number of pages");
		int countOfTotalPages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		System.out.println("STEP - Get total number of records displayed per page");
		int countOfperPageRecords = Integer
				.parseInt(driver.findElement(By.xpath("//div[@id='example_info']")).getText().split(" ")[3]);
		Set<String> setOfUniqueOffices = new LinkedHashSet<String>();
		for (int index = 1; index < countOfTotalPages; index++) {
			for (int innerIndex = 1; innerIndex <= countOfperPageRecords; innerIndex++) {
				setOfUniqueOffices.add(
						driver.findElement(By.xpath("//table[@id='example']//tr[" + innerIndex + "]/td[3]")).getText());
			}
			driver.findElement(By.xpath("//a[@id='example_next']")).click();
		}
		System.out.println("Unique set of offices: " + setOfUniqueOffices);
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
