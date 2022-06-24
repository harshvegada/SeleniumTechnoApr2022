/*Assignment - 4 : 18th Jun'2022

Program - 1. Print whole table using 2 for loop
Program - 2. Print specific row : username - mkanani
Program - 3. Print last rows from 1st table 
Program - 4. return firstname of all employess from table1
Program - 5. return username as key and firstname as value from table1
Program - 6. Unique surname from table1. [LinkedHashSet]

Program - 7. find duplicate employee id if any. [HashSet, add return type]
Program - 8. find duplicate employee id if any. [Map<String, Integer>, key -> value >1]

Program - 9. Return map of Dept and employee count
Program - 10. Return map of manager id and number of employees reporting to that manager.
*/
package ashish;

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
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4_TableAndCollections {

	WebDriver driver;
	String url = "http://automationbykrishna.com/#";

	void setUp(String url) {
		System.out.println("STEP - Launch Chrome brower");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		System.out.println("STEP - Load URL");
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
	}

	void printWholeTableUsingTwoForLoop() {
		setUp(url);
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr")).size();
		System.out.println("Whole table content using 2 for loop : ");
		for (int index = 1; index <= rowCount; index++) {
			for (int innerIndex = 1; innerIndex <= 4; innerIndex++) {
				if (innerIndex == 4)
					System.out.print(driver.findElement(By.xpath("//table[@id='table1']//tr[" + index + "]/td[" + innerIndex + "]")).getText());
				else
					System.out.print(driver.findElement(By.xpath("//table[@id='table1']//tr[" + index + "]/td[" + innerIndex + "]")).getText() + " -- ");
			}
			System.out.println("");
		}
		driver.close();
	}

	void printSpecificRow(String username) {
		setUp(url);
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr")).size();
		System.out.println("Row content for username : " + username + " - ");
		for (int index = 1; index <= rowCount; index++) {
			for (int innerIndex = 1; innerIndex <= 4; innerIndex++) {
				if (driver.findElement(By.xpath("//table[@id='table1']/tbody//tr[" + index + "]/td[" + innerIndex + "]")).getText().equals(username)) {
					System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody//tr[" + index + "]")).getText());
				}
			}
		}
		driver.close();
	}

	void printLastRowFromFirstTable() {
		setUp(url);
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr")).size();
		System.out.println("Last Row contents From First Table are: \n" + driver.findElement(By.xpath("//table[@id='table1']/tbody//tr[" + rowCount + "]")).getText());
		driver.close();
	}

	List<String> returnFirstNameOfAllEmployeeFromTable() {
		setUp(url);
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr")).size();
		List<String> firstNameList = new ArrayList<String>();
		for (int index = 1; index <= rowCount; index++) {
			firstNameList.add(driver.findElement(By.xpath("//table[@id='table1']/tbody//tr[" + index + "]/td[2]")).getText());
		}
		driver.close();
		return firstNameList;
	}

	Map<String, String> returnUsernameAsKeyAndFirstnameAsValueFromTable1() {
		setUp(url);
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr")).size();
		Map<String, String> userNameFirstNameMap = new LinkedHashMap<String, String>();
		for (int index = 1; index <= rowCount; index++) {
			String nameKey = driver.findElement(By.xpath("//table[@id='table1']/tbody//tr[" + index + "]/td[2]")).getText();
			String usernameValue = driver.findElement(By.xpath("//table[@id='table1']/tbody//tr[" + index + "]/td[4]")).getText();
			userNameFirstNameMap.put(nameKey, usernameValue);
		}
		driver.close();
		return userNameFirstNameMap;
	}

	Set<String> getUniqueLastnameFromTable1() {
		setUp(url);
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr")).size();
		Set<String> uniqueLastnameSet = new LinkedHashSet<String>();
		for (int index = 1; index <= rowCount; index++) {
			String lastname = driver.findElement(By.xpath("//table[@id='table1']/tbody//tr[" + index + "]/td[3]")).getText();
			uniqueLastnameSet.add(lastname);
		}
		driver.close();
		return uniqueLastnameSet;
	}

	void findDuplicateEmployeeIdUsingSet() {
		setUp(url);
		int rowCount = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr")).size();
		Set<String> empIdSet = new HashSet<String>();
		for (int index = 1; index < rowCount; index++) {
			String empId = driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr[" + index + "]/td[2]")).getText();
			if (!empIdSet.add(empId)) {
				System.out.println("Duplicate employee id - " + empId);
			}
		}
		driver.close();
	}

	void findDuplicateEmployeeIdUsingMap() {
		setUp(url);
		int rowCount = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr")).size();
		Map<String, Integer> empIdMap = new HashMap<String, Integer>();
		for (int index = 1; index <= rowCount; index++) {
			String empId = driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr[" + index + "]/td[2]")).getText();
			if (empIdMap.containsKey(empId)) {
				empIdMap.put(empId, empIdMap.get(empId) + 1);
			} else {
				empIdMap.put(empId, 1);
			}
		}
		System.out.println(empIdMap);
		for (String empid : empIdMap.keySet()) {
			if (empIdMap.get(empid) > 1) {
				System.out.println("Duplicate employee id is - " + empid);
			}
		}
		driver.close();
	}

	Map<String, Integer> returnMapOfDeptAndEmployeeCount() {
		setUp(url);
		int rowCount = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr")).size();
		Map<String, Integer> deptMap = new LinkedHashMap<String, Integer>();
		for (int index = 1; index <= rowCount; index++) {
			String dept = driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr[" + index + "]/td[5]")).getText();
			if (deptMap.containsKey(dept)) {
				deptMap.put(dept, deptMap.get(dept) + 1);
			} else {
				deptMap.put(dept, 1);
			}
		}
		/*System.out.println(deptMap);
		int maxCount = 0;
		String maxDeptName = "";
		for (String deptName : deptMap.keySet()) {
			if (deptMap.get(deptName) > maxCount) {
				maxCount = deptMap.get(deptName);
				maxDeptName = deptName;
			}
		}*/
		driver.close();
		return deptMap;
	}

	Map<String, Integer> returnMapOfManagerIdAndEmployeeCount() {
		setUp(url);
		int rowCount = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr")).size();
		Map<String, Integer> managerMap = new LinkedHashMap<String, Integer>();
		for (int index = 1; index <= rowCount; index++) {
			String manager = driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr[" + index + "]/td[4]")).getText();
			if (managerMap.containsKey(manager)) {
				managerMap.put(manager, managerMap.get(manager) + 1);
			} else {
				managerMap.put(manager, 1);
			}
		}
		driver.close();
		return managerMap;
	}

	public static void main(String[] args) {
		String username = "mkanani";
		Assignment4_TableAndCollections assignment4_TableAndCollections = new Assignment4_TableAndCollections();
		assignment4_TableAndCollections.printWholeTableUsingTwoForLoop();
		assignment4_TableAndCollections.printSpecificRow(username);
		assignment4_TableAndCollections.printLastRowFromFirstTable();
		List<String> allEmployeeNameList = assignment4_TableAndCollections.returnFirstNameOfAllEmployeeFromTable();
		System.out.println("Firstname of all employess from table1 are : \n" + allEmployeeNameList);
		Map<String, String> userNameFirstNameMap = assignment4_TableAndCollections.returnUsernameAsKeyAndFirstnameAsValueFromTable1();
		System.out.println("Username as key and firstname as value from table1 are: \n"+ userNameFirstNameMap);
		Set<String> uniqueLastNameSet= assignment4_TableAndCollections.getUniqueLastnameFromTable1();
		System.out.println("Unique surname from table1 is: \n"+ uniqueLastNameSet);
		assignment4_TableAndCollections.findDuplicateEmployeeIdUsingSet();
		Map<String, Integer> deptAndEmployeeCountMap= assignment4_TableAndCollections.returnMapOfDeptAndEmployeeCount();
		System.out.println("Map of Dept and employee count: \n" + deptAndEmployeeCountMap);
		Map<String, Integer> managerAndEmployeeCountMap= assignment4_TableAndCollections.returnMapOfManagerIdAndEmployeeCount();
		System.out.println("Map of manager id and number of employees reporting to that manager: \n" +managerAndEmployeeCountMap);
	}
}