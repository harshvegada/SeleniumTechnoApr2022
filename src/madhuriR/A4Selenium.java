package madhuriR;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A4Selenium {
	WebDriver setUp() {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		return driver;
	}
	/***********************************Program 1***********************************************/
	void totalElement() {
		WebDriver driver =setUp();
		driver.findElement(By.linkText("Demo Tables")).click();
		int size = driver.findElements(By.xpath("//table[@id=\"table1\"]/tbody/tr")).size();
		for(int index=1;index<=size;index++) {
			for(int innerIndex=1;innerIndex<=4;innerIndex++) {
				String data= driver.findElement(By.xpath("//table[@id=\"table1\"]/tbody/tr["+index+"]/td["+innerIndex+"]")).getText();
				System.out.print(data+ " ");
			}
			System.out.println( );
		}
	}
	/***********************************Program 2***********************************************/
	void printSpecificRow() {
		WebDriver driver =setUp();
		driver.findElement(By.linkText("Demo Tables")).click();
		int size = driver.findElements(By.xpath("//table[@id=\"table1\"]/tbody/tr")).size();
		for(int index=1;index<=size;index++) {
			String userName = driver.findElement(By.xpath("//table[@id=\"table1\"]/tbody/tr["+index+"]/td[4]")).getText();
			if(userName.equals("mkanani")) {
				String fName = driver.findElement(By.xpath("//table[@id=\"table1\"]/tbody/tr["+index+"]/td[2]")).getText();
				String lName = driver.findElement(By.xpath("//table[@id=\"table1\"]/tbody/tr["+index+"]/td[3]")).getText();
				System.out.println(fName+"--"+lName);
			}
		}
	}
	/***********************************Program 3***********************************************/
	void printLastRow() {
		WebDriver driver =setUp();
		driver.findElement(By.linkText("Demo Tables")).click();
		int size = driver.findElements(By.xpath("//table[@id=\"table1\"]/tbody/tr")).size();
		for(int index=size;index>=1;index--) {
			String data = driver.findElement(By.xpath("//table[@id=\"table1\"]/tbody/tr["+index+"]")).getText();
			System.out.println(data);
			break;
		}
	}
	/***********************************Program 4***********************************************/
	List<String> getListOfEmployee(){
		List<String> list = new ArrayList<String>();
		WebDriver driver =setUp();
		driver.findElement(By.linkText("Demo Tables")).click();
		int size = driver.findElements(By.xpath("//table[@id=\"table1\"]/tbody/tr")).size();
		for(int index=1;index<=size;index++) {
			String employeeName = driver.findElement(By.xpath("//table[@id=\"table1\"]/tbody/tr["+index+"]/td[2]")).getText();
			list.add(employeeName);
		}
		return list;
	}
	/***********************************Program 5***********************************************/
	Map<String,String> getUserNameandfirstNameOfEmpployee(){
		Map<String,String> mapOfEmployee = new LinkedHashMap<String,String>();
		WebDriver driver =setUp();
		driver.findElement(By.linkText("Demo Tables")).click();
		int size = driver.findElements(By.xpath("//table[@id=\"table1\"]/tbody/tr")).size();
		for(int index=1;index<=size;index++) {
			String firstName = driver.findElement(By.xpath("//table[@id=\"table1\"]/tbody/tr["+index+"]/td[2]")).getText();
			String userName = driver.findElement(By.xpath("//table[@id=\"table1\"]/tbody/tr["+index+"]/td[4]")).getText();
			mapOfEmployee.put(userName,firstName);
		}
		return mapOfEmployee;
	}
	/***********************************Program 6***********************************************/
	Set<String> getListOfUniqueSurname(){
		Set<String> set = new HashSet<String>();
		WebDriver driver =setUp();
		driver.findElement(By.linkText("Demo Tables")).click();
		int size = driver.findElements(By.xpath("//table[@id=\"table1\"]/tbody/tr")).size();
		for(int index=1;index<=size;index++) {
			String employeeName = driver.findElement(By.xpath("//table[@id=\"table1\"]/tbody/tr["+index+"]/td[3]")).getText();
			set.add(employeeName);
		}
		return set;
	}
	/***********************************Program 7***********************************************/
	Set<Integer> getDulicateEmployee(){
		Set<Integer> set = new HashSet<Integer>();
		WebDriver driver =setUp();
		driver.findElement(By.linkText("Demo Tables")).click();
		int size = driver.findElements(By.xpath("//table[@class=\"table table-striped\"]/tbody/tr")).size();
		for(int index=1;index<=size;index++) {
			String employeeId = driver.findElement(By.xpath("//table[@class=\"table table-striped\"]/tbody/tr["+index+"]/td[2]")).getText();
			int empid = Integer.parseInt(employeeId);
			if(set.add(empid)==true) {
				set.add(empid);
			}else {
				System.out.println(empid+ " is the duplicate entry");
			}
			
		}
		return set;
	}
	/***********************************Program 8***********************************************/
	Map<Integer,Integer> getUniqueEntryUsingMap(){
		Map<Integer,Integer> map = new LinkedHashMap<Integer,Integer>();
		WebDriver driver =setUp();
		driver.findElement(By.linkText("Demo Tables")).click();
		int size = driver.findElements(By.xpath("//table[@class=\"table table-striped\"]/tbody/tr")).size();
		for(int index=1;index<=size;index++){
			String empId = driver.findElement(By.xpath("//table[@class=\"table table-striped\"]/tbody/tr["+index+"]/td[2]")).getText();
			int empid = Integer.parseInt(empId);
			if(map.containsKey(empid)) {
				map.put(empid, map.get(empid)+1);
			}else {
				map.put(empid,1);
			}
			
			}
		Set<Integer> countofempid = map.keySet();
		
		for(Integer num:countofempid) {
			if (map.get(num) > 1) {
				System.out.println("duplicate num using map collection: " + num);
				break;
				
			}	
		}
		return map;
	}
	/***********************************Program 9***********************************************/
	Map<String,Integer> getDeptAndEmployeeCount(){
		Map<String,Integer> countOfEmp = new LinkedHashMap<String,Integer>();
		WebDriver driver =setUp();
		driver.findElement(By.linkText("Demo Tables")).click();
		int size = driver.findElements(By.xpath("//table[@class=\"table table-striped\"]/tbody/tr")).size();
		for(int index=1;index<=size;index++) {
			String dept = driver.findElement(By.xpath("//table[@class=\"table table-striped\"]/tbody/tr["+index+"]/td[5]")).getText();
			if(countOfEmp.containsKey(dept)) {
				countOfEmp.put(dept, countOfEmp.get(dept)+1);
			}else {
				countOfEmp.put(dept, 1);
			}
		}
		return countOfEmp;
	}
	/***********************************Program 10***********************************************/
	Map<Integer,Integer> getManagerIdAndEmployeeCount(){
		Map<Integer,Integer> mangerIdCount = new LinkedHashMap<Integer,Integer>();
		WebDriver driver =setUp();
		driver.findElement(By.linkText("Demo Tables")).click();
		int size = driver.findElements(By.xpath("//table[@class=\"table table-striped\"]/tbody/tr")).size();
		for(int index=1;index<=size;index++) {
			String str =driver.findElement(By.xpath("//table[@class=\"table table-striped\"]/tbody/tr["+index+"]/td[4]")).getText();
			Integer num = Integer.parseInt(str);
			if(mangerIdCount.containsKey(num)) {
				mangerIdCount.put(num, mangerIdCount.get(num)+1);
			}else {
				mangerIdCount.put(num, 1);
			}
		}
		return mangerIdCount;
	}
	public static void main(String[] args) {
		A4Selenium a4 = new A4Selenium();
		System.out.println("*****************Program1********************");
		a4.totalElement();
		System.out.println("*****************Program2********************");
		a4.printSpecificRow();
		System.out.println("*****************Program3********************");
		a4.printLastRow();
		System.out.println("*****************Program4********************");
		System.out.println(a4.getListOfEmployee());
		System.out.println("*****************Program5********************");
		System.out.println(a4.getUserNameandfirstNameOfEmpployee());
		System.out.println("*****************Program6********************");
		System.out.println(a4.getListOfUniqueSurname());
		System.out.println("*****************Program7********************");
		a4.getDulicateEmployee();
		System.out.println("*****************Program8********************");
		a4.getUniqueEntryUsingMap();
		System.out.println("*****************Program9********************");
		System.out.println(a4.getDeptAndEmployeeCount());
		System.out.println("*****************Program10********************");
		System.out.println(a4.getManagerIdAndEmployeeCount());
	}
}
