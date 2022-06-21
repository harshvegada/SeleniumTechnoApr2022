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
package pragati;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {
	private WebDriver driver;

	void setup(String url) {
		System.out.println("step1:-launch browser");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		System.out.println("Step2:-click on Demo Table");
		driver.findElement(By.linkText("Demo Tables")).click();

	}

	void printTable() {
		System.out.println("Step:findout num of rows");
		int numOfRows = driver.findElements(By.xpath("//table[@class=\"table\"]//tbody/tr")).size();
		System.out.println("Step:findout num of columns");
		int numOfColumns = driver.findElements(By.xpath("//table[@class=\"table\"]//tbody/tr[1]/td")).size();
		System.out.println(numOfRows + ":" + numOfColumns);

		System.out.println("------------------------------------------------------------------------------");
		System.out.println("# " + "            First Name      " + "      Last Name      " + "   Username  ");
		System.out.println("------------------------------------------------------------------------------");
		for (int index = 1; index <= numOfRows; index++) {
			for (int innerIndex = 1; innerIndex <= 4; innerIndex++) {
				if (innerIndex == 4)
					System.out.print(driver
							.findElement(By.xpath("//table[@id='table1']//tr[" + index + "]/td[" + innerIndex + "]"))
							.getText());
				else
					System.out.print(driver
							.findElement(By.xpath("//table[@id='table1']//tr[" + index + "]/td[" + innerIndex + "]"))
							.getText() + " -- ");
			}
			System.out.println("");
		}
	}

	void printSecificRow(String username) {
		driver.findElements(By.xpath("//table[@id='table1']"));
		int rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		System.out.print("\nEntire row of table where username = " + username + " is --> \n");
		for (int index = 1; index <= rows; index++) {
			String userName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			if (userName.equals(username))
				System.out.print(userName);
		}
	}

	void printLastRow() {
		driver.findElements(By.xpath("//table[@id='table1']"));
		int rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		System.out.println("\nLast row of Employee basic table is -->\n\n"
				+ driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rows + "]")).getText());
	}

	void printFirstNameEmpBasicInfoTable() {
		driver.findElements(By.xpath("//table[@id='table1']"));
		int rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		System.out.println("\nFirst name of all employees from Employee basic table -->");
		for (int index = 1; index <= rows; index++) {
			String data = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]")).getText();
			System.out.println(data);
		}
	}

	Map<String, String> getUsernameAndFirstName() {
		Map<String, String> userInfo = new LinkedHashMap<String, String>();
		driver.findElements(By.xpath("//table[@id='table1']"));

		int rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for (int index = 1; index <= rows; index++) {
			String userName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			userInfo.put(userName, firstName);
		}

		System.out.println(
				"Map of username as key and first name as value from Employee basic table :-->\n\n" + userInfo);

		return userInfo;
	}

	Set<String> getUniqueSurname() {
		Set<String> uniqueSurname = new LinkedHashSet<String>();
		driver.findElements(By.xpath("//table[@id='table1']"));
		int rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for (int index = 1; index <= rows; index++) {
			String surname = driver.findElement(By.xpath("//table[@id='table1']/tbody//tr[" + index + "]/td[3]"))
					.getText();
			uniqueSurname.add(surname);
		}

		System.out.println("Set of unique surnames from Employee basic table -->\n\n" + uniqueSurname);
		return uniqueSurname;
	}

	Set<Integer> getDuplicateEmpID() {
		Set<Integer> duplicateID = new LinkedHashSet<Integer>();
		driver.findElements(By.xpath("//table[@class='table table-striped']"));
		int rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for (int index = 1; index <= rows; index++) {

			Integer empID = Integer.parseInt(
					driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[2]"))
							.getText());

			if (!duplicateID.add(empID))
				duplicateID.add(empID);
		}

		System.out.println("Duplicate EmpID from  the Employee Manager table -->\n\n" + duplicateID);
		return duplicateID;
	}

	Map<String, Integer> getMapOfEmpDept() {
		Map<String, Integer> mapOfDept = new HashMap<String, Integer>();
		Set<String> setOfKeys = new HashSet<String>();
		driver.findElement(By.xpath("//table[@class='table table-striped']"));
		int rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for (int index = 1; index <= rows; index++) {
			String deptName = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]"))
					.getText();
			setOfKeys = mapOfDept.keySet();
			if (setOfKeys.contains(deptName))
				mapOfDept.put(deptName, mapOfDept.get(deptName) + 1);
			else
				mapOfDept.put(deptName, 1);
		}
		System.out.println(mapOfDept);
		return mapOfDept;
	}

	Map<String, Integer> getMapOfEmployeeMgrID() {
		Map<String, Integer> mapOfManagerID = new HashMap<String, Integer>();
		driver.findElement(By.xpath("//table[@class='table table-striped']"));
		int rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for (int index = 1; index <= rows; index++) {
			String empID = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			Set<String> setOfKeys = mapOfManagerID.keySet();
			if (setOfKeys.contains(empID))
				mapOfManagerID.put(empID, mapOfManagerID.get(empID) + 1);
			else
				mapOfManagerID.put(empID, 1);
		}
		System.out.println(mapOfManagerID);
		return mapOfManagerID;
	}

	public static void main(String[] args) {
		Assignment4 assignment4 = new Assignment4();
		assignment4.setup("http://automationbykrishna.com");
		System.out.println("=================================");
		assignment4.printTable();
		System.out.println("=================================");
		assignment4.printSecificRow("mkanani");
		System.out.println("=================================");
		assignment4.printLastRow();
		System.out.println("=================================");
		assignment4.printFirstNameEmpBasicInfoTable();
		System.out.println("=================================");
		assignment4.getUsernameAndFirstName();
		System.out.println("=================================");
		assignment4.getUniqueSurname();
		System.out.println("=================================");
		assignment4.getDuplicateEmpID();
		System.out.println("=================================");
		assignment4.getMapOfEmpDept();
		System.out.println("=================================");
		assignment4.getMapOfEmployeeMgrID();
		System.out.println("=================================");

	}

}
