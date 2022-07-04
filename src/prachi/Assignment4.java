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
Program - 10. Return map of manager id and number of employees reporting to that manager*/


package prachi;

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

public class Assignment4 {
	
		static private WebDriver driver;

		static void setUp(String url) {
			System.out.println("STEP -Launch Browser");
			System.setProperty("webdriver.chrome.driver", "D:\\Java Class\\technocredits\\SeleniumTechnoApr2022\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();

			System.out.println("STEP-go to URL");
			driver.get(url);

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

			System.out.println("STEP -  Click on the Demo Tables tab");
			driver.findElement(By.xpath("//a[@id='demotable']")).click();

		}

//Program 1
		
		void printEmployeeManagerTable() {
			System.out.println("\nTable1:");
			int numberOfRows = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr")).size();
			int numberOfColumns = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr[1]/td")).size();
			for (int index = 1; index <= numberOfRows; index++) {
				for (int innerIndex = 1; innerIndex <= numberOfColumns; innerIndex++) {
					System.out.print(driver
							.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[" + index + "]/td[" + innerIndex + "]"))
							.getText());
					System.out.print(" ");
				}
				System.out.println();
			}
		}

// Program 2 
		
		void specificRowOfTable(String username) {
			System.out.println("\nPrint specific row : username - mkanani");
			int rows = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr")).size();
			for (int index = 1; index <= rows; index++) {
				String userName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]"))
						.getText();
				if (userName.equals(username))
					System.out.println(driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[1]")).getText());
			}
		}

// Program 3 
		
		void lastRowOfTable() {
			System.out.println("\nlast rows from 1st table:");
			int rows = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr")).size();
			System.out.println(driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[" + rows + "]")).getText());
		}

// Program 4
		
		List<String> firstNameOfTable() {
			int rows = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr")).size();
			List<String> nameOfEmployee = new ArrayList<String>();
			for (int index = 1; index <= rows; index++) {
				String empName = driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[" + index + "]/td[2]"))
						.getText();
				nameOfEmployee.add(empName);
			}
			return nameOfEmployee;
		}

//Program 5
		
		HashMap<String, String> mapOfEmpName() {
			System.out.println("\nusername as key and firstname as value from table1:");
			int rows = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr")).size();
			HashMap<String, String> name = new LinkedHashMap<String, String>();
			for (int index = 1; index <= rows; index++) {
				String firstName = driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[" + index + "]/td[2]"))
						.getText();
				String userName = driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[" + index + "]/td[4]"))
						.getText();
				name.put(userName, firstName);
			}
			return name;
		}

// program 6
		
		void uniqueSurnameFromTable() {
			System.out.println("\nUnique surname from table1:");
			int rows = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr")).size();
			LinkedHashSet<String> empSurname = new LinkedHashSet<String>();
			for (int index = 1; index <= rows; index++) {
				String suerName = driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[" + index + "]/td[3]"))
						.getText();
				empSurname.add(suerName);
			}
			System.out.println(empSurname);
		}

//Program 7
		
		void findDublicateEmployeeidFromTable() {
			HashSet<String> emplyoeeId = new LinkedHashSet<String>();
			int rows = driver.findElements(By.xpath("//*[@class='table table-striped']/tbody/tr")).size();
			String empId = "";
			boolean isDublicate = true;
			for (int index = 1; index <= rows; index++) {
				empId = driver.findElement(By.xpath("//*[@class='table table-striped']/tbody/tr[" + index + "]/td[2]"))
						.getText();
				isDublicate = emplyoeeId.add(empId);
				if (!isDublicate) {
					System.out.println("Dublicate Employee Id: " + empId);
				}
			}
		}

//Program - 8
		
		void dublicateEmployeeId() {
			HashMap<String, Integer> empId = new HashMap<String, Integer>();
			int rows = driver.findElements(By.xpath("//*[@class='table table-striped']/tbody/tr")).size();
			for (int index = 1; index <= rows; index++) {
				String employeeId = driver
						.findElement(By.xpath("//*[@class='table table-striped']/tbody/tr[" + index + "]/td[2]")).getText();

				if (empId.containsKey(employeeId)) {
					empId.put(employeeId, empId.get(employeeId) + 1);
				} else
					empId.put(employeeId, 1);
			}
			Set<String> empid = empId.keySet();
			for (String id : empid) {
				if (empId.get(id) > 1) {
					System.out.println("Dublicate Employee Id: " + id);
				}
			}
		}

// Program - 9
		
		HashMap<String, Integer> mapOfDeptAndEmployeeCount() {
			System.out.println("\nMap of Employee Department and Employee Count:");
			HashMap<String, Integer> departmentId = new HashMap<String, Integer>();
			int rows = driver.findElements(By.xpath("//*[@class='table table-striped']/tbody/tr")).size();
			for (int index = 1; index <= rows; index++) {
				String depId = driver
						.findElement(By.xpath("//*[@class='table table-striped']/tbody/tr[" + index + "]/td[5]")).getText();
				if (departmentId.containsKey(depId)) {
					departmentId.put(depId, departmentId.get(depId) + 1);
				} else
					departmentId.put(depId, 1);
			}
			return departmentId;
		}

//Program - 10
		
		Map<String, Integer> getMapOfDeptAndEmployeeCount() {
			System.out.println("\nMap of manager id and number of employees reporting to that manager:");
			Map<String, Integer> mapOfManagerID = new HashMap<String, Integer>();
			int rows = driver.findElements(By.xpath("//*[@class='table table-striped']/tbody/tr")).size();
			for (int index = 1; index <= rows; index++) {
				String empId = driver
						.findElement(By.xpath("//*[@class='table table-striped']/tbody/tr[" + index + "]/td[4]")).getText();
				Set<String> setOfKeys = mapOfManagerID.keySet();
				if (setOfKeys.contains(empId)) {
					mapOfManagerID.put(empId, mapOfManagerID.get(empId) + 1);
				} else {
					mapOfManagerID.put(empId, 1);
				}
			}

			return mapOfManagerID;
		}

		public static void main(String[] args) {
			Assignment4 assignment4 = new Assignment4();
			setUp("http://automationbykrishna.com");
			System.out.println("Test Case 1 : Verify printing the whole Employee Manager Table");

			assignment4.printEmployeeManagerTable();
			System.out.println();

			System.out.println("Test Case 2 : Verify printing whole row where username = mkanani");
			assignment4.specificRowOfTable("mkanani");
			System.out.println();

			System.out.println("Test Case 3 : Verify printing last row");
			assignment4.lastRowOfTable();
			System.out.println();

			System.out.println("Test Case 4 : Verify printing first name of all users");
			List<String> name = assignment4.firstNameOfTable();
			System.out.println("First name of all employee in table: ");
			for (String empName : name) {
				System.out.println(empName);
			}
			System.out.println();

			System.out.println("Test Case 5 : Verify returning username as key and firstname as value from table1");
			HashMap<String, String> nameOfemp = assignment4.mapOfEmpName();
			System.out.println(nameOfemp);
			System.out.println();

			System.out.println("Test Case 6 : Unique surname from table1. [LinkedHashSet]");
			assignment4.uniqueSurnameFromTable();
			System.out.println();

			System.out.println("Test Case 7 : find duplicate employee id if any. [HashSet, add return type]");
			assignment4.findDublicateEmployeeidFromTable();
			System.out.println();

			System.out.println("Test Case 8 : find duplicate employee id if any. [Map<String, Integer>, key -> value >1] ");
			assignment4.dublicateEmployeeId();
			System.out.println();

			System.out.println("Test Case 9 :  Return map of Dept and employee count");
			HashMap<String, Integer> hm1 = assignment4.mapOfDeptAndEmployeeCount();
			System.out.println(hm1);
			System.out.println();

			System.out.println("Test Case 10 :  Return map of manager id and number of employees reporting to that manager");
			Map<String, Integer> mapOfManagerID = assignment4.getMapOfDeptAndEmployeeCount();
			System.out.println(mapOfManagerID);
		}
}


