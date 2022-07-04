package bhushan;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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
Program - 10. Return map of manager id and number of employees reporting to that manager.*/
public class Assignment4 {
	WebDriver driver;
	WebDriver setupMethod() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.id("demotable")).click();
		return driver;
	}
	//********************************************Program 1 ****************************************************************//
	//Program - 1. Print whole table using 2 for loop
	void printWholeTable() {
		 setupMethod();
		 WebElement tabledata=driver.findElement(By.xpath("//table[@id='table1']//tbody//tr[4]"));
		int num2=driver.findElements(By.xpath("//table[@id='table1']//tbody/tr")).size();
		int innerindexlength=driver.findElements(By.xpath("//table[@id='table1']//tbody/tr[2]//td")).size();
		for(int index=1;index<=num2;index++) {
			for(int innerindex=1;innerindex<=innerindexlength;innerindex++) {
				String input=driver.findElement(By.xpath("//table[@id='table1']//tbody/tr["+index+"]//td["+innerindex+"]")).getText();
				System.out.print(input+"  ");
			}
			System.out.println();
		}
		driver.close();
	}
	
	//********************************************Program 2 ****************************************************************//
	//Program - 2. Print specific row : username - mkanani
	void printSpecificRow() {
		setupMethod();
		int outerforlooplength=driver.findElements(By.xpath("//table[@id='table1']//tr")).size();
		for(int index=1;index<outerforlooplength;index++) {
			String username=driver.findElement(By.xpath("//table[@id='table1']//tr["+index+"]/td[4]")).getText();
			String firstName=driver.findElement(By.xpath("//table[@id='table1']//tr["+index+"]/td[2]")).getText();
			System.out.println(username+" -- "+ firstName);
		}
		driver.close();
	}
	
	//********************************************Program 3 ****************************************************************//
	//Program - 3. Print last rows from 1st table
	
	void printLastRow() {
		setupMethod();
		int length=driver.findElements(By.xpath("//table[@id='table1']//tr")).size();
		String lastName=driver.findElement(By.xpath("//table[@id='table1']//tr["+(length-1)+"]")).getText();
		System.out.println(lastName);
		driver.close();
	}
	
	//********************************************Program 4 ****************************************************************//
	//Program - 4. return firstname of all employess from table1
	
	List<String> returnFisrtName() {
		setupMethod();
		List<String> list=new ArrayList<String>();
		int length=driver.findElements(By.xpath("//table[@id='table1']//tr")).size();
		for(int index=1;index<length;index++) {
			String input=driver.findElement(By.xpath("//table[@id='table1']//tr["+index+"]//td[2]")).getText();
			list.add(input);
		}
		driver.close();
		return list;
	}
	//********************************************Program 5 ****************************************************************//
	//Program - 5. return username as key and firstname as value from table1
	
	Map<String, String> returnUsernamekeyAndFirstnameasValue() {
		setupMethod();
		Map<String, String> listofNames=new LinkedHashMap<String, String>();
		int length=driver.findElements(By.xpath("//table[@id='table1']//tr")).size();
		for(int index=1;index<length;index++) {
			String userName=driver.findElement(By.xpath("//table[@id='table1']//tr["+index+"]//td[4]")).getText();
			String userFisrtName=driver.findElement(By.xpath("//table[@id='table1']//tr["+index+"]//td[2]")).getText();		
			listofNames.put(userName, userFisrtName);
		}
		driver.close();
		return listofNames;
		
		
	}
	
	//********************************************Program 6 ****************************************************************//
	//Program - 6. Unique surname from table1. [LinkedHashSet]
	void printUniqueSurname() {
		setupMethod();
		Set<String> listofsurname=new LinkedHashSet<String>();
		int length=driver.findElements(By.xpath("//table[@id='table1']//tr")).size();
		for(int index=1;index<length;index++) {
			String surname=driver.findElement(By.xpath("//table[@id='table1']//tr["+index+"]//td[3]")).getText();
			listofsurname.add(surname);			
		}
		System.out.println(listofsurname);
		driver.close();
	}
	//********************************************Program 7 ****************************************************************//
	//Program - 7. find duplicate employee id if any. [HashSet, add return type]
	void findDuplicateEmployeeID() {
		setupMethod();
		HashSet<Integer> empIds=new HashSet<Integer>();
		int tablecount=driver.findElements(By.xpath("//table[@class='table table-striped']//tbody//tr")).size();
		for(int index=1;index<tablecount;index++) {
			String Svalue=driver.findElement(By.xpath("//table[@class='table table-striped']//tbody//tr["+index+"]//td[2]")).getText();
			int value=Integer.parseInt(Svalue);
			boolean flag=empIds.add(value);
			if(!flag) {
				System.out.println(value);
			}
		}
		driver.close();		
	}
	//********************************************Program 8 ****************************************************************//
	//Program - 8. find duplicate employee id if any. [Map<String, Integer>, key -> value >1]
	void findDuplicateEmployeeIDUsingMap() {
		setupMethod();
		Map<String, Integer> listofID=new HashMap<String ,Integer>();
		int tablecount=driver.findElements(By.xpath("//table[@class='table table-striped']//tbody//tr")).size();
		
		for(int index=1;index<tablecount;index++) {
			String Svalue=driver.findElement(By.xpath("//table[@class='table table-striped']//tbody//tr["+index+"]//td[2]")).getText();
			if(listofID.containsKey(Svalue)) {
				listofID.put(Svalue,listofID.get(Svalue)+1);
			}else {
				listofID.put(Svalue, 1);
			}		
		}
		
		System.out.println(listofID);
		driver.close();
		int temp=0;
		String value="";
			
		for (String name : listofID.keySet()) {  
			if(listofID.get(name)>temp) {
				temp=listofID.get(name);
				value=name;
			}
		}
		System.out.println(value+"--"+temp);
	}
	//********************************************Program 9 ****************************************************************//
	//Program - 9. Return map of Dept and employee count
	
	Map<String, Integer> ReturnMapOfDeptEmployeeCount() {
		setupMethod();
		Map<String, Integer> listofCount=new HashMap<String, Integer>();
		int tablecount=driver.findElements(By.xpath("//table[@class='table table-striped']//tbody//tr")).size();
		
		for(int index=1;index<=tablecount;index++) {
			String empId=driver.findElement(By.xpath("//table[@class='table table-striped']//tbody//tr["+index+"]//td[2]")).getText();
			String deptName=driver.findElement(By.xpath("//table[@class='table table-striped']//tbody//tr["+index+"]//td[5]")).getText();
			if(listofCount.containsKey(deptName)) {
				listofCount.put(deptName,listofCount.get(deptName)+1);
			}else {
				listofCount.put(deptName, 1);
			}		
		}
		//System.out.println(listofCount);
		driver.close();
		return listofCount;	
	}
	//********************************************Program 10 ****************************************************************//
	//Program - 10. Return map of manager id and number of employees reporting to that manager
	Map<String, Integer> ReturnMapOfManagerIDandNumberOfEmployees() {
		setupMethod();
		
		Map<String, Integer> listofCount=new HashMap<String, Integer>();
		int tablecount=driver.findElements(By.xpath("//table[@class='table table-striped']//tbody//tr")).size();
		
		for(int index=1;index<=tablecount;index++) {
			//String empId=driver.findElement(By.xpath("//table[@class='table table-striped']//tbody//tr["+index+"]//td[2]")).getText();
			String managerID=driver.findElement(By.xpath("//table[@class='table table-striped']//tbody//tr["+index+"]//td[4]")).getText();
			if(listofCount.containsKey(managerID)) {
				listofCount.put(managerID,listofCount.get(managerID)+1);
			}else {
				listofCount.put(managerID, 1);
			}		
		}
		driver.close();
		return listofCount;
	}
	
	
	public static void main(String[] args) {
		Assignment4 ass4=new Assignment4();
		ass4.printWholeTable();
		System.out.println("Program 2 Output");
		ass4.printSpecificRow();
		System.out.println("Program 3 Output");
		ass4.printLastRow();
		System.out.println("Program 4 Output");
		List<String> list=ass4.returnFisrtName();
		System.out.println(list);
		System.out.println("Program 5 Output");
		Map<String, String> mapList=ass4.returnUsernamekeyAndFirstnameasValue();
		System.out.println(mapList);
		System.out.println("Program 6 Output");
		ass4.printUniqueSurname();
		System.out.println("Program 7 Output");
		ass4.findDuplicateEmployeeID();
		System.out.println("Program 8 Output");
		ass4.findDuplicateEmployeeIDUsingMap();
		System.out.println("Program 9 Output");
		Map<String, Integer> deptEmpCount=ass4.ReturnMapOfDeptEmployeeCount();
		System.out.println(deptEmpCount);
		System.out.println("Program 10 Output");
		Map<String, Integer>listofEmpCountunderManager=ass4.ReturnMapOfManagerIDandNumberOfEmployees();
		System.out.println(listofEmpCountunderManager);
	}
}
