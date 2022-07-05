package deepshikha;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Assignment4 {

	private WebDriver driver;
	
	void launchBrowser() {
		System.out.println("STEP - Launch Chrome browser");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("STEP - Load URL");
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//a[@id='demotable']")).click();
	}

	// Program - 1. Print whole table using 2 for loop
	void printWholeTable() {
		System.out.println("Test case 1:- Print whole table ");
		WebElement e = driver.findElement(By.xpath("//*[@class='table']/thead"));
		String str = e.getText();
		System.out.println(str);

		int numberOfRows = driver.findElements(By.xpath("//*[@id=\"table1\"]/tbody/tr")).size();
		int numberOfColumns = driver.findElements(By.xpath("//*[@id=\"table1\"]/tbody/tr[1]/td")).size();

		for (int i = 1; i <= numberOfRows; i++) {
			for (int j = 1; j <= numberOfColumns; j++) {

				WebElement e2 = driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[" + i + "]/td[" + j + "]"));
				String str2 = e2.getText();
				System.out.print(str2 + " ");

			}
			System.out.println("");
		}

	}

	//// Program - 2. Print specific row : username - mkanani

	void printSpecificRow(String name) {
		System.out.println("Test case 2:- print specific row  with user name - mkanani  ");
		int numberOfRows = driver.findElements(By.xpath("//*[@id=\"table1\"]/tbody/tr")).size();
		// int noOfColumns =
		// driver.findElements(By.xpath("//*[@id=\"table1\"]/tbody/tr[1]/td")).size();

		for (int i = 1; i <= numberOfRows; i++) {
			WebElement element1 = driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[" + i + "]"));
			String userName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[4]")).getText();

			if (userName.equals(name)) {

				String str2 = element1.getText();
				System.out.println(str2);
			}

		}

	}

	//// Program - 3. Print last rows from 1st table

	void lastRowFromFirstTable() {
		System.out.println("Test case 3:- print last row from first table  ");
		int numberOfRows = driver.findElements(By.xpath("//*[@id=\"table1\"]/tbody/tr")).size();
		WebElement element1 = driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[" + numberOfRows + "]"));
		String str2 = element1.getText();
		System.out.println(str2);
	}

	// Program - 4. return firstname of all employess from table1

	List<String> printFirstName() {
		System.out.println("Test case 4:- first name of all employes  ");
		List<String> l = new ArrayList<String>();
		int numberOfRows = driver.findElements(By.xpath("//*[@id=\"table1\"]/tbody/tr")).size();

		for (int i = 1; i <= numberOfRows; i++) {
			WebElement e5 = driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[" + i + "]/td[2]"));
			String str5 = e5.getText();
			l.add(str5);

		}
		return l;

	}

	// Program - 5. return username as key and firstname as value from table1

	HashMap<String, String> returnUserNameAsKeyAndFirstNameAsValue() {
		System.out.println("Test case 5:-  username as key and firstname as value ");
		HashMap<String, String> hm = new LinkedHashMap<String, String>();
		int numberOfRows = driver.findElements(By.xpath("//*[@id=\"table1\"]/tbody/tr")).size();
		for (int i = 1; i <= numberOfRows; i++) {
			WebElement e5 = driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[" + i + "]/td[2]"));
			String str5 = e5.getText();
			WebElement e6 = driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[" + i + "]/td[4]"));
			String str6 = e6.getText();
			hm.put(str5, str6);
		}
		return hm;
	}

	// Program - 6. Unique surname from table1. [LinkedHashSet]

	void printUniqueSurname() {
		System.out.println("Test case 6:- unique surname  ");
		HashSet<String> hs = new LinkedHashSet<String>();
		int numberOfRows = driver.findElements(By.xpath("//*[@id=\"table1\"]/tbody/tr")).size();
		for (int i = 1; i <= numberOfRows; i++) {
			WebElement e5 = driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[" + i + "]/td[3]"));
			String str5 = e5.getText();
			hs.add(str5);
		}
		System.out.println(hs);
	}

	/// Program - 7. find duplicate employee id if any. [HashSet, add return type]

	void findDuplicateID() {
		System.out.println("Test case 7:- Duplicate Employee ID  ");
		HashSet<String> hs = new HashSet<>();
		int numberOfRows = driver.findElements(By.xpath("//*[@class='table table-striped']/tbody/tr")).size();
		for (int i = 1; i < numberOfRows; i++) {
			WebElement e5 = driver.findElement(By.xpath("//*[@class='table table-striped']/tbody/tr[" + i + "]/td[2]"));
			String str5 = e5.getText();
			boolean flag2 = hs.add(str5);
			if (!flag2) {
				System.out.println(str5);
			}
		}
	}
	// Program - 8. find duplicate employee id if any. [Map<String, Integer>, key ->
	// value >1]

	void findDuplicateEmpId() {
		System.out.println("Test case 8:- Duplicate Employee ID  [key -> value >1]");
		Map<String, Integer> hm = new HashMap<String, Integer>();
		Map<String, Integer> duplicateID = new HashMap<String, Integer>();
		int numberOfRows = driver.findElements(By.xpath("//*[@class='table table-striped']/tbody/tr")).size();
		for (int i = 1; i <= numberOfRows; i++) {
			WebElement e5 = driver.findElement(By.xpath("//*[@class='table table-striped']/tbody/tr[" + i + "]/td[2]"));
			String str5 = e5.getText();
			if (hm.containsKey(str5)) {
				hm.put(str5, hm.get(str5) + 1);
			} else {
				hm.put(str5, 1);
			}
		}
		Set<String> keys = hm.keySet();
		for (String key : keys) {
			if (hm.get(key) > 1) {
				duplicateID.put(key, hm.get(key));
				// System.out.println(key);
			}
		}
		System.out.println(duplicateID);
	}

	// Program - 9. Return map of Dept and employee count
	Map<String, Integer> getDeptAndEmpCount() {
		System.out.println("Test case 9:- Map of Dept and employee count ");
		Map<String, Integer> hm = new HashMap<String, Integer>();
		int numberOfRows = driver.findElements(By.xpath("//*[@class='table table-striped']/tbody/tr")).size();
		for (int i = 1; i <= numberOfRows; i++) {
			WebElement e5 = driver.findElement(By.xpath("//*[@class='table table-striped']/tbody/tr[" + i + "]/td[5]"));
			String str5 = e5.getText();
			if (hm.containsKey(str5)) {
				hm.put(str5, hm.get(str5) + 1);
			} else {
				hm.put(str5, 1);
			}
		}
		return hm;
	}

	// Program - 10. Return map of manager id and number of employees reporting to
	// that manager.
	void printManagerIdAndReportingEmpNo() {
		System.out.println("Test case 10:- Map of manager id and number of employees reporting to that manager. ");
		Map<String, Integer> hm = new HashMap<String, Integer>();
		int numberOfRows = driver.findElements(By.xpath("//*[@class='table table-striped']/tbody/tr")).size();
		for (int i = 1; i <= numberOfRows; i++) {
			WebElement e5 = driver.findElement(By.xpath("//*[@class='table table-striped']/tbody/tr[" + i + "]/td[4]"));
			String str5 = e5.getText();

			Set<String> setOfKeys = hm.keySet();

			if (setOfKeys.contains(str5)) {
				hm.put(str5, hm.get(str5) + 1);
			} else {
				hm.put(str5, 1);
			}

		}
		System.out.println(hm);
	}

	public static void main(String[] args) {
		Assignment4 assignment4 = new Assignment4();
		assignment4.launchBrowser();
		assignment4.printWholeTable();
		System.out.println("=======================================================================");
		
		assignment4.printSpecificRow("mkanani");
		System.out.println("=======================================================================");
		
		assignment4.lastRowFromFirstTable();
		System.out.println("=======================================================================");
		
		List<String> le = assignment4.printFirstName();
		System.out.println(le);
		System.out.println("=======================================================================");
		
		HashMap<String, String> hm = assignment4.returnUserNameAsKeyAndFirstNameAsValue();
		System.out.println(hm);
		System.out.println("=======================================================================");
		
		assignment4.printUniqueSurname();
		System.out.println("=======================================================================");
		
		assignment4.findDuplicateID();
		System.out.println("=======================================================================");
		
		assignment4.findDuplicateEmpId();
		System.out.println("=======================================================================");
		
		Map<String, Integer> ans = assignment4.getDeptAndEmpCount();
		System.out.println(ans);
		System.out.println("=======================================================================");
		
		assignment4.printManagerIdAndReportingEmpNo();
	}
}
