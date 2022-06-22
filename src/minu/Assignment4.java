/*Program - 1. Print whole table using 2 for loop
Program - 2. Print specific row : username - mkanani
Program - 3. Print last rows from 1st table 
Program - 4. return firstname of all employess from table1
Program - 5. return username as key and firstname as value from table1
Program - 6. Unique surname from table1. [LinkedHashSet]

Program - 7. find duplicate employee id if any. [HashSet, add return type] 12:25
Program - 8. find duplicate employee id if any. [Map<String, Integer>, key -> value >1]  12:27

Program - 9. Return map of Dept and employee count
Program - 10. Return map of manager id and number of employees reporting to that manager. 
 */

package minu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	private WebDriver driver;

	private void browserSetUp() {
		System.out.println("STEP-Launch Chrome brower");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		System.out.println("STEP-Load URL");
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();

		System.out.println("PREREQUISITE-Navigate to Demo Tables tab");
		driver.findElement(By.linkText("Demo Tables")).click();
	}

	void printWholeTable() {
		System.out.println("Find total number of row in the table ");
		int size = driver.findElements(By.xpath("//table[@class = 'table table-striped']/tbody/tr")).size();

		System.out.println("Step-Print whole table");
		for (int index = 1; index <= size; index++) {
			for (int innerIndex = 1; innerIndex <= 5; innerIndex++) {
				String data = driver.findElement(By.xpath(
						"//table[@class = 'table table-striped']/tbody/tr[" + index + "]/td[" + innerIndex + "]"))
						.getText();
				System.out.print(data + " ");
			}
			System.out.println();
		}
	}

	void printSpecificRow() {
		System.out.println("Find total number of row in table1");
		int size = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();

		System.out.println("STEP-Print specific row : username - mkanani");
		for (int index = 1; index <= size; index++) {
			String userName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			if (userName.equals("mkanani")) {
				String row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]")).getText();
				System.out.println(row);
			}
		}
	}

	void printLastRow() {
		System.out.println("Find total number of row in table1");
		int size = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();

		System.out.println("STEP-Print last rows from 1st table ");
		String lastRow = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + size + "]")).getText();
		System.out.println(lastRow);
	}

	List<String> getFirstName() {

		List<String> listOfEmployeeFirstName = new ArrayList<String>();

		int size = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();

		System.out.println("Step-return firstname of all employess from table1");
		for (int index = 1; index <= size; index++) {
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			listOfEmployeeFirstName.add(firstName);
		}
		return listOfEmployeeFirstName;
	}

	Map<String, String> getEmployeeData() {
		Map<String, String> listOfEmployee = new LinkedHashMap<String, String>();
		int size = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();

		System.out.println("Step-return username as key and firstname as value from table1");
		for (int index = 1; index <= size; index++) {
			String userName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			listOfEmployee.put(userName, firstName);
		}

		return listOfEmployee;
	}

	Set<String> getSurName() {
		Set<String> setOfSurName = new LinkedHashSet<String>();
		int size = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();

		System.out.println("Step-Unique surname from table1.");
		for (int index = 1; index <= size; index++) {
			String lastName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[3]"))
					.getText();
			setOfSurName.add(lastName);
		}
		return setOfSurName;
	}

	void getDuplicateEmployeeID() {
		Set<String> duplicateEmployeeId = new HashSet<String>();

		int size = driver.findElements(By.xpath("//table[@class = 'table table-striped']/tbody/tr")).size();

		System.out.println("Step-find duplicate employee id if any");
		for (int index = 1; index <= size; index++) {
			String empId = driver
					.findElement(By.xpath("//table[@class = 'table table-striped']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			boolean isUniqueId = duplicateEmployeeId.add(empId);
			if (!isUniqueId)
				System.out.println(empId);
		}
	}

	void getDuplicateEmployeeIDUsingMap() {
		Map<String, Integer> duplicateEmployeeId = new LinkedHashMap<String, Integer>();

		int size = driver.findElements(By.xpath("//table[@class = 'table table-striped']/tbody/tr")).size();

		System.out.println("Step-find duplicate employee id if any Using Map");
		for (int index = 1; index <= size; index++) {
			String empId = driver
					.findElement(By.xpath("//table[@class = 'table table-striped']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			if (duplicateEmployeeId.containsKey(empId))
				duplicateEmployeeId.put(empId, duplicateEmployeeId.get(empId) + 1);
			else
				duplicateEmployeeId.put(empId, 1);
		}
		System.out.println(duplicateEmployeeId);
		System.out.println("Duplicate Employee ID:");

		Iterator<String> itr = duplicateEmployeeId.keySet().iterator();

		while (itr.hasNext()) {
			String id = itr.next();
			if (duplicateEmployeeId.get(id) > 1)
				System.out.println(id);
		}
	}

	Map<String, Integer> getEmpDeptFromTable() {
		Map<String, Integer> listOfEmpDept = new LinkedHashMap<String, Integer>();

		int size = driver.findElements(By.xpath("//table[@class = 'table table-striped']/tbody/tr")).size();

		System.out.println("Step-Return map of Dept and employee count");
		for (int index = 1; index <= size; index++) {
			String deptId = driver
					.findElement(By.xpath("//table[@class = 'table table-striped']/tbody/tr[" + index + "]/td[5]"))
					.getText();
			if (listOfEmpDept.containsKey(deptId))
				listOfEmpDept.put(deptId, listOfEmpDept.get(deptId) + 1);
			else
				listOfEmpDept.put(deptId, 1);
		}
		return listOfEmpDept;
	}

	Map<String, Integer> getManagerIdFromTable() {
		Map<String, Integer> listOfManagerId = new LinkedHashMap<String, Integer>();

		int size = driver.findElements(By.xpath("//table[@class = 'table table-striped']/tbody/tr")).size();

		System.out.println("Step-Return map of manager id and number of employees reporting to that manager");
		for (int index = 1; index <= size; index++) {
			String managerId = driver
					.findElement(By.xpath("//table[@class = 'table table-striped']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			if (listOfManagerId.containsKey(managerId))
				listOfManagerId.put(managerId, listOfManagerId.get(managerId) + 1);
			else
				listOfManagerId.put(managerId, 1);
		}
		return listOfManagerId;
	}

	public static void main(String[] args) {
		Assignment4 assignment4 = new Assignment4();
		assignment4.browserSetUp();

		System.out.println("\nTestCase-1 Print whole table using 2 for loop");
		assignment4.printWholeTable();

		System.out.println("\nTestCase-2. Print specific row : username - mkanani");
		assignment4.printSpecificRow();

		System.out.println("\nTestCase-3. Print last rows from 1st table ");
		assignment4.printLastRow();

		System.out.println("\nTestCase-4. return firstname of all employess from table1");
		System.out.println(assignment4.getFirstName());

		System.out.println("\nTestCase-5. return username as key and firstname as value from table1");
		System.out.println(assignment4.getEmployeeData());

		System.out.println("\nTestCase-6. Unique surname from table1.");
		System.out.println(assignment4.getSurName());

		System.out.println("\nTestCase-find duplicate employee id if any.");
		assignment4.getDuplicateEmployeeID();

		System.out.println("\nTestCase-8. find duplicate employee id if any.");
		assignment4.getDuplicateEmployeeIDUsingMap();

		System.out.println("\nTestCase-9. Return map of Dept and employee count");
		System.out.println(assignment4.getEmpDeptFromTable());

		System.out
				.println("\nTestCase-10. Return map of manager id and number of employees reporting to that manager.");
		System.out.println(assignment4.getManagerIdFromTable());
	}
}
