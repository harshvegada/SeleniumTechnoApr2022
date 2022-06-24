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
package arti;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4WebTables {

static WebDriver driver;
	
	static void setup(String url) {
		
		System.out.println("STEP - Launch Browser");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Technocredit\\SeleniumTechnoApr2022\\drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		System.out.println("STEP - Load URL");
		driver.get(url);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		System.out.println("STEP -  Click on the Demo Tables tab");
		
		driver.findElement(By.linkText("Demo Tables")).click();
	}
	
	void printEmployeeManagerTable() {
		
		System.out.println("Find out no. of rows");
		int noOfRows = driver.findElements(By.xpath("//table[@class='table table-striped']//tbody/tr")).size();
		
		System.out.println("Find out no. of columns");
		int noOfColumns = driver.findElements(By.xpath("//table[@class='table table-striped']//tbody/tr[1]/td")).size();
		
		System.out.println(noOfRows+":"+noOfColumns);
		
		System.out.println("-----------------------------------------------------------------------------------------------------------------------");
		System.out.println("# "+"            EmployeeID      "+"      Employee Name      "+"    Employee ManagerID   "+"   Employee Dept  ");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------");
		
		for(int index = 1; index <= noOfRows; index++) {
		
			for(int innerIndex = 1; innerIndex <= noOfColumns; innerIndex++) {
			
				System.out.print(driver.findElement(By.xpath("//table[@class='table table-striped']//tbody/tr["+index+"]/td["+innerIndex+"]")).getText());
				System.out.print("               ");
			}
			System.out.println();
		}
		System.out.println("--------------------------------------------------------------------------------------------------------------");
	}
	
	void printSpecificRowOfEmpBasicInfoTable(String username) {
		
		driver.findElements(By.xpath("//table[@id='table1']"));

		int rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		
		System.out.print("\nEntire row of table where username = "+username+" is --> \n");
		
		for(int index = 1; index <= rows; index++) {

			String userName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[4]")).getText();
		
			if(userName.equals(username))
				System.out.print(userName);
		}
	}
	void printLastRowOfEmpBasicInfoTable(){
		
		driver.findElements(By.xpath("//table[@id='table1']"));
		
		int rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		
		System.out.println("\nLast row of Employee basic table is -->\n\n"+driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rows+"]")).getText());
	}
	
	void printFirstNameEmpBasicInfoTable() {
		
		driver.findElements(By.xpath("//table[@id='table1']"));
		
		int rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		
		System.out.println("\nFirst name of all employees from Employee basic table -->");
		
		for(int index = 1; index <= rows; index++) {
			
			String data = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]")).getText();
			
			System.out.println(data);
		}
	}
	
	Map<String, String>getLinkedHashMapEmpBasicInfoTable(){
		
		Map<String, String> mapOfUsers = new LinkedHashMap<String, String>();
		
		driver.findElements(By.xpath("//table[@id='table1']"));
		
		int rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		
		for(int index = 1; index <= rows; index++) {
			
			String userName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[4]")).getText();
			
			String firstName =  driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]")).getText();
			
			mapOfUsers.put(userName, firstName);
		}
		
		System.out.println("Map of username as key and first name as value from Employee basic table :-->\n\n"+mapOfUsers);
		
		return mapOfUsers;
	}
	
	Set<String> getSetOfUniqueSurnamesEmpBasicInfoTable(){
		
		Set<String> setOfSurnames = new LinkedHashSet<String>();
		
		driver.findElements(By.xpath("//table[@id='table1']"));
		
		int rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		
		for(int index = 1; index <= rows; index++) {
			
			String surname = driver.findElement(By.xpath("//table[@id='table1']/tbody//tr["+index+"]/td[3]")).getText();

			setOfSurnames.add(surname);
		}
		
		System.out.println("Set of unique surnames from Employee basic table -->\n\n"+setOfSurnames);
		
		return setOfSurnames;
	}
	
	Set<Integer> getSetOfDuplicateEmpIDEmpBasicInfoTable(){
		
		Set<Integer> setOfEmpID =  new LinkedHashSet<Integer>();
		
		Set<Integer> setOfDupEmpID =  new LinkedHashSet<Integer>();
		
		driver.findElements(By.xpath("//table[@class='table table-striped']"));

		int rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		
		for(int index = 1; index <= rows; index++) {
			
			Integer empID = Integer.parseInt(driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[2]")).getText());
			
			if(!setOfEmpID.add(empID))
				setOfDupEmpID.add(empID);
		}
		
		System.out.println("Duplicate EmpID from  the Employee Manager table -->\n\n"+setOfDupEmpID);
		
		return setOfDupEmpID;
	}
	
	Map<String, Integer> getSetOfDuplicateEmpIDUsingMapEmpBasicInfoTable(){
		
		System.out.println("\nMap of Duplicate EmpId is --> \n");
		
		Map<String, Integer> mapOfEmpID = new HashMap<String, Integer>();
		
		Map<String, Integer> mapOfDupEmpID = new HashMap<String, Integer>();
 		
		driver.findElement(By.xpath("//table[@class='table table-striped']"));
		
		int rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		
		Set<String> setOfKeys = mapOfEmpID.keySet();
		
		for(int index = 1; index <= rows; index++) {
			
			String empID = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[2]")).getText();
			
			setOfKeys = mapOfEmpID.keySet();
			
			if(setOfKeys.contains(empID)) 
				mapOfEmpID.put(empID, mapOfEmpID.get(empID) + 1);
			
			else
				mapOfEmpID.put(empID, 1);
		}
		
		Iterator<String> itr = setOfKeys.iterator();
		
		while(itr.hasNext()) {
			
			String id = itr.next();
			
			int count = mapOfEmpID.get(id);
			
			if(count > 1)
				mapOfDupEmpID.put(id, mapOfEmpID.get(id));
		}
		
		System.out.println(mapOfDupEmpID);
		
		return mapOfDupEmpID;
	}
	
	Map<String, Integer> getMapOfEmpDeptFromEmpBasicInfoTable(){
		
		Map<String, Integer> mapOfDept = new HashMap<String, Integer>();
		
		Set<String> setOfKeys = new HashSet<String>();
		
		driver.findElement(By.xpath("//table[@class='table table-striped']"));
		
		int rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		
		for(int index = 1; index <= rows; index++) {
			
			String deptName = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[5]")).getText();
			
			setOfKeys = mapOfDept.keySet();
			
			if(setOfKeys.contains(deptName))
				mapOfDept.put(deptName, mapOfDept.get(deptName) + 1);
			else
				mapOfDept.put(deptName, 1);
		}
		
		System.out.println(mapOfDept);
		
		return mapOfDept;
	}
	
	Map<String, Integer>getMapOfEmployeeMgrID(){
		
		Map<String, Integer> mapOfManagerID = new HashMap<String, Integer>();
		
		driver.findElement(By.xpath("//table[@class='table table-striped']"));
		
		int rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		
		for(int index = 1; index <= rows; index++) {
			
			String empID = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[4]")).getText();
			
			Set<String> setOfKeys = mapOfManagerID.keySet();
			
			if(setOfKeys.contains(empID))
				mapOfManagerID.put(empID, mapOfManagerID.get(empID) + 1);
			else
				mapOfManagerID.put(empID, 1);
		}
		
		System.out.println(mapOfManagerID);
		
		return mapOfManagerID;
	}
	
	public static void main(String[] args) {
		
		Assignment4WebTables a4 = new Assignment4WebTables();
		
		setup("http://automationbykrishna.com");
		
		System.out.println("\nTest Case 1 : Verify printing the whole Employee Manager Table");
		a4.printEmployeeManagerTable();
		System.out.println("\n*********************************************************************************************");

		System.out.println("\nTest Case 2 : Verify printing whole row where username = mkanani ");
		a4.printSpecificRowOfEmpBasicInfoTable("mkanani");
		System.out.println("\n*********************************************************************************************");

		System.out.println("\nTest Case 3 : Verify printing last row ");
		a4.printLastRowOfEmpBasicInfoTable();
		System.out.println("\n*********************************************************************************************");

		System.out.println("\nTest Case 4 : Verify printing first name of all users\n ");
		a4.printFirstNameEmpBasicInfoTable();
		System.out.println("\n*********************************************************************************************");

		System.out.println("\nTest Case 5 : Verify returning username as key and firstname as value from table1\n ");
		a4.getLinkedHashMapEmpBasicInfoTable();
		System.out.println("\n*********************************************************************************************");

		System.out.println("\nTest Case 6 : Unique surname from table1. [LinkedHashSet]\n ");
		a4.getSetOfUniqueSurnamesEmpBasicInfoTable();
		System.out.println("\n*********************************************************************************************");

		System.out.println("\nTest Case 7 : find duplicate employee id if any. [HashSet, add return type]\n ");
		a4.getSetOfDuplicateEmpIDEmpBasicInfoTable();
		System.out.println("\n*********************************************************************************************");
		 
		System.out.println("\nTest Case 8 : find duplicate employee id if any. [Map<String, Integer>, key -> value >1] ");
		a4.getSetOfDuplicateEmpIDUsingMapEmpBasicInfoTable();
		System.out.println("\n*********************************************************************************************");

		System.out.println("\nTest Case 9 :  Return map of Dept and employee count\n ");
		a4.getMapOfEmpDeptFromEmpBasicInfoTable();
		System.out.println("\n*********************************************************************************************");

		System.out.println("\nTest Case 10 :  Return map of manager id and number of employees reporting to that manager\n ");
		a4.getMapOfEmployeeMgrID();
		System.out.println("\n*********************************************************************************************");
	}	
}
