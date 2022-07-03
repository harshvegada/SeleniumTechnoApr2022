/*Assignment4
 * Program - 1. Print whole table using 2 for loop
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

package amar;

import java.util.Arrays;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	WebDriver driver;

	void setup() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com");
		driver.findElement(By.linkText("Demo Tables")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	void printTableData() {
		setup();
		int rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		int columns = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td")).size();

		for(int index = 1; index <= rows; index++) {
			for(int innerIndex = 1; innerIndex<= columns; innerIndex++) {
				String data = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td["+innerIndex+"]")).getText();
				if(innerIndex == columns)
					System.out.print(data);
				else
					System.out.print(data+" --");
			}
			System.out.println();
		}
		driver.close();
	}

	void printSpecificRow() {
		setup();
		int rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		int columns = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td")).size();

		for(int index = 1; index <= rows; index++) {
			String userName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[4]")).getText();
			if(userName.equals("mkanani")) {
				for(int innerIndex = 1; innerIndex<= columns; innerIndex++) {
					String data = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td["+innerIndex+"]")).getText();
					System.out.print(data + " ");
				}
			}
		}
		driver.close();
	}

	void printLastRow() {
		setup();
		int rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		int columns = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td")).size();
		for(int index = 1; index <= columns; index++) {
			String data = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rows+"]/td["+index+"]")).getText();
			if(index == columns)
				System.out.print(data);
			else
				System.out.print(data +"--");
		}
		driver.close();
	}

	void printFirstName() {
		setup();
		int rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		int columns = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td")).size();
		for(int index = 1; index <= rows; index++) {
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]")).getText();
			System.out.println(firstName);
		}
		driver.close();
	}

	Map<String, String> getEmployeeData(){
		setup();
		Map<String, String> mapOfUserNameFirstName = new LinkedHashMap<String, String>();
		int rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for(int index = 1; index <= rows; index++) {
			String userName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[4]")).getText();
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]")).getText();
			mapOfUserNameFirstName.put(userName, firstName);
		}
		driver.close();
		return mapOfUserNameFirstName;
	}

	void uniqueSurname() {
		setup();
		LinkedHashSet<String> setOfSurnames = new LinkedHashSet<String>();
		int rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for(int index = 1; index <= rows; index++) {
			String surName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[3]")).getText();
			setOfSurnames.add(surName);
		}
		driver.close();
		System.out.println(setOfSurnames);
	}

	void duplicateEmpId() {
		setup();
		Set<String> setOfempIds = new HashSet<String>();
		int size = driver.findElements(By.xpath("//div[@id='empmanager']//table/tbody/tr")).size();
		for(int index = 1; index <= size; index++) {
			String empId = driver.findElement(By.xpath("//div[@id='empmanager']//table/tbody/tr["+index+"]/td[2]")).getText();
			boolean flag = setOfempIds.add(empId);
			if(flag == false) {
				System.out.println(empId);
			}
		}
		driver.close();
	}

	void duplicateEmpIdUsingMap() {
		setup();
		Map<String, Integer> mapOfEmpId = new LinkedHashMap<String, Integer>();
		int size = driver.findElements(By.xpath("//div[@id='empmanager']//table/tbody/tr")).size();
		for(int index = 1; index <= size; index++) {
			int count =1;
			String empId = driver.findElement(By.xpath("//div[@id='empmanager']//table/tbody/tr["+index+"]/td[2]")).getText();
			if(mapOfEmpId.containsKey(empId)) {
				mapOfEmpId.put(empId, count+1);
			}else {
				mapOfEmpId.put(empId,1);
			}
		}

		Iterator<String> it = mapOfEmpId.keySet().iterator();
		while(it.hasNext()) {
			String duplicateId = it.next();
			if(mapOfEmpId.get(duplicateId)>1) {
				System.out.println(duplicateId);
			}	
		}
		driver.close();
	}

	void mapOfEmployeeDepartment() {
		setup();
		Map<String, Integer> mapOfDept = new LinkedHashMap<String, Integer>();
		int size = driver.findElements(By.xpath("//div[@id='empmanager']//table/tbody/tr")).size();
		for(int index = 1; index <= size; index++) {
			int count = 1;
			String dept = driver.findElement(By.xpath("//div[@id='empmanager']//table/tbody/tr["+index+"]/td[5]")).getText();
			if(mapOfDept.containsKey(dept)) {
				mapOfDept.put(dept,count+1);
			}else {
				mapOfDept.put(dept,1);
			}
		}
		System.out.println(mapOfDept);
		driver.close();
	}

	void mapOfManagerIdEmployee() {
		setup();
		Map<String, Integer> mapOfManagerId = new LinkedHashMap<String, Integer>();
		int size = driver.findElements(By.xpath("//div[@id='empmanager']//table/tbody/tr")).size();
		for(int index = 1; index <= size; index++) {
			int count = 1;
			String managerId = driver.findElement(By.xpath("//div[@id='empmanager']//table/tbody/tr["+index+"]/td[4]")).getText();
			if(mapOfManagerId.containsKey(managerId)) {
				mapOfManagerId.put(managerId,mapOfManagerId.get(managerId)+1);
			}else {
				mapOfManagerId.put(managerId,1);
			}
		}
		System.out.println(mapOfManagerId);
		driver.close();
	}

	public static void main(String[] args) {

		Assignment4 assignment4 = new Assignment4();
		System.out.println("<< Program 1 : Print whole table data using 2 for loops >>");
		assignment4.printTableData();
		System.out.println("\n"+"<< Program 2 : Print specific row with username mkanani >>");
		assignment4.printSpecificRow();
		System.out.println("\n"+"<< Program 3 : Print last row from first table >>");
		assignment4.printLastRow();
		System.out.println("\n"+"<< Program 4 : Return firstname of all employess from table1 >>");
		assignment4.printFirstName();
		System.out.println("\n"+"<< Program 5 : Return username as key and firstname as value from table1 >>");
		Map<String,String> mapOfUserNameFirstName = assignment4.getEmployeeData();
		System.out.println(Arrays.asList(mapOfUserNameFirstName));
		System.out.println("\n"+"<< Program 6 : Unique surname from table1 >>");
		assignment4.uniqueSurname();
		System.out.println("\n"+"<< Program 7 : find duplicate employee id if any using hashset >>");
		assignment4.duplicateEmpId();
		System.out.println("\n"+"<< Program 8 : find duplicate employee id if any using map >>");
		assignment4.duplicateEmpIdUsingMap();
		System.out.println("\n"+"<< Program 9 : Return map of Dept and employee count >>");
		assignment4.mapOfEmployeeDepartment();
		System.out.println("\n"+"<< Program 10 : Return map of manager id and number of employees reporting to that manager >>");
		assignment4.mapOfManagerIdEmployee();
	}

}
