/*Assignment - 4 : 18th Jun'2022
http://automationbykrishna.com/
Program - 1. Print whole table using 2 for loop
Program - 2. Print specific row : username - mkanani
Program - 3. Print last rows from 1st table 
Program - 4. return firstname of all employess from table1
Program - 5. return username as key and firstname as value from table1
Program - 6. Unique surname from table1. [LinkedHashSet]
Program - 7. find duplicate employee id if any. [HashSet, add return type]
Program - 8. find duplicate employee id if any. [Map<String, Integer>, key -> value >1]
Program - 9. Return map of Dept and employee count
Program - 10. Return map of manager id and number of employees reporting to that manager.*/
package dipali;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	private static WebDriver driver;
	private int tableEBISize;
	private int tableEMSize;

	void loadUrlLaunchDemoTable() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Demo Tables")).click();
		tableEBISize = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		tableEMSize = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
	}

	// Program - 1. Print whole table using 2 for loop
	void printEmpBasicTable() {
		for (int index = 1; index <= tableEBISize; index++) {
			for (int innerIndex = 1; innerIndex <= 4; innerIndex++) {
				String rowDatas = driver
						.findElement(
								By.xpath("//table[@id='table1']/tbody[1]/tr[" + index + "]/td[" + innerIndex + "]"))
						.getText();
				if (innerIndex >= 1 && innerIndex < 4) {
					System.out.print(rowDatas + " - ");
				} else {
					System.out.print(rowDatas);
				}
			}
			System.out.println();
		}
	}

	// Program - 2. Print specific row : username - mkanani
	void printSpecificRow(String userName) {
		for (int index = 1; index <= tableEBISize; index++) {
			if (driver.findElement(By.xpath("//table[@id='table1']/tbody[1]/tr[" + index + "]/td[4]")).getText()
					.equals(userName)) {
				System.out.println(
						driver.findElement(By.xpath("//table[@id='table1']/tbody[1]/tr[" + index + "]")).getText());
			}
		}
	}

	// Program - 3. Print last rows from 1st table
	void printfirstTableLastRow() {
		System.out.println(
				driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + tableEBISize + "]")).getText());
	}

	// Program - 4. return firstname of all employess from table1
	List<String> firstNameTable1() {
		List<String> listOfFirstName = new LinkedList<String>();
		for (int index = 1; index <= tableEBISize; index++) {
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			listOfFirstName.add(firstName);
		}
		return listOfFirstName;
	}

	// Program - 5. return username as key and firstname as value from table1
	Map<String, String> UNandFNfromtable1() {
		Map<String, String> UNFNMapTable1 = new LinkedHashMap<String, String>();
		for (int index = 1; index <= tableEBISize; index++) {
			String userName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			UNFNMapTable1.put(userName, firstName);
		}
		return UNFNMapTable1;
	}

	// Program - 6. Unique surname from table1. [LinkedHashSet]
	Set<String> uniqueSurNameTable1() {
		Set<String> uniqueSNSet = new LinkedHashSet<String>();
		for (int index = 1; index <= tableEBISize; index++) {
			String surName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[3]"))
					.getText();
			uniqueSNSet.add(surName);
		}
		return uniqueSNSet;
	}

	// Program - 7. find duplicate employee id if any. [HashSet, add return type]
	Set<String> duplicateEmpId() {
		Set<String> setIncludesDuplicateIDs = new HashSet<String>();
		Set<String> setIncludesUniqueIDs = new HashSet<String>();
		for (int index = 1; index <= tableEMSize; index++) {
			String empId = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			if (!setIncludesUniqueIDs.add(empId)) {
				setIncludesDuplicateIDs.add(empId);
			}
		}
		return setIncludesDuplicateIDs;
	}

	// Program - 8. find duplicate employee id if any. [Map<String, Integer>, key
	// ->value >1]
	void duplicateEmpIDEmpName() {
		Map<String, Integer> mapEmp = new HashMap<String, Integer>();
		for (int index = 1; index <= tableEMSize; index++) {
			String empId = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			if (mapEmp.containsKey(empId)) {
				mapEmp.put(empId, mapEmp.get(empId) + 1);
			} else {
				mapEmp.put(empId, 1);
			}
		}

		Iterator<String> keyItr = mapEmp.keySet().iterator();
		while (keyItr.hasNext()) {
			String empID = keyItr.next();
			int nameCount = mapEmp.get(empID);
			if (nameCount > 1) {
				System.out.println(empID);
			}
		}
	}

	// Program - 9. Return map of Dept and employee count
	Map<String, Integer> deptAndTheirEmpCount() {
		Map<String, Integer> deptEmpCount = new HashMap<String, Integer>();
		for (int index = 1; index <= tableEMSize; index++) {
			String deptName = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]"))
					.getText();
			if (deptEmpCount.containsKey(deptName)) {
				deptEmpCount.put(deptName, deptEmpCount.get(deptName) + 1);
			} else {
				deptEmpCount.put(deptName, 1);
			}
		}
		return deptEmpCount;
	}

	// Program - 10. Return map of manager id and number of employees reporting to
	// that manager.
	Map<String, Integer> managerAndTheirEmpCount() {
		Map<String, Integer> managerEmpCount = new HashMap<String, Integer>();
		for (int index = 1; index <= tableEMSize; index++) {
			String managerId = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			if (managerEmpCount.containsKey(managerId)) {
				managerEmpCount.put(managerId, managerEmpCount.get(managerId) + 1);
			} else {
				managerEmpCount.put(managerId, 1);
			}
		}
		return managerEmpCount;
	}

	public static void main(String[] args) {
		Assignment4 assign4 = new Assignment4();
		assign4.loadUrlLaunchDemoTable();

		// Program 1
		System.out.println("Table:- Employee Basic Information (Using 2 for loops)");
		assign4.printEmpBasicTable();
		System.out.println("*************************");

		// Program 2
		String uName = "mkanani";
		System.out.println("Complete row having username " + uName);
		assign4.printSpecificRow(uName);
		System.out.println("*************************");

		// Program 3
		System.out.println("Last row of the first table(Employee Basic Information)");
		assign4.printfirstTableLastRow();
		System.out.println("**************************");

		// Program 4
		System.out.println("First name of all employee from table- Employee Basic Information");
		System.out.println(assign4.firstNameTable1());
		System.out.println("**************************");

		// Program 5
		System.out.println("Pair of username and firstname from table- Employee Basic Information");
		System.out.println(assign4.UNandFNfromtable1());
		System.out.println("**************************");

		// Program 6
		System.out.println("Unique surname from table- Employee Basic Information");
		System.out.println(assign4.uniqueSurNameTable1());
		System.out.println("***************************");

		// Program 7
		System.out.println("Duplicate Employee Id from table- Employee Manager (Using HashSet)");
		System.out.println(assign4.duplicateEmpId());
		System.out.println("***************************");

		// Program 8
		System.out.println("Duplicate Employee Id from table- Employee Manager (Using Map)");
		assign4.duplicateEmpIDEmpName();
		System.out.println("***************************");

		// Program 9
		System.out.println("Mapping of employee department and their employee count from table- Employee Manager");
		System.out.println(assign4.deptAndTheirEmpCount());
		System.out.println("***************************");

		// Program 10
		System.out.println("Mapping of employee managerId and their employee count from table- Employee Manager");
		System.out.println(assign4.managerAndTheirEmpCount());
		System.out.println("***************************");

		driver.quit();
	}
}