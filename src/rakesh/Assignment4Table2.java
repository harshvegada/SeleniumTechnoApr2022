/* Assignment - 4 : 18th Jun'2022

Program - 7. find duplicate employee id if any. [HashSet, add return type]
Program - 8. find duplicate employee id if any. [Map<String, Integer>, key -> value >1]

Program - 9. Return map of Dept and employee count
Program - 10. Return map of manager id and number of employees reporting to that manager.
 */
package rakesh;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Assignment4Table2 {

	WebDriver driver = PreReq.setUp();
	List<WebElement> thList;
	List<WebElement> trList;
	int tr;
	int td;
	
	void goToDemoTables() {
		driver.findElement(By.id("demotable")).click();
	}
	
	void getTable2RowsColumns() {
		thList = driver.findElements(By.xpath("//table[@class='table table-striped']//th"));
		trList = driver.findElements(By.xpath("//table[@class='table table-striped']//tbody//tr"));
		td = thList.size();
		tr = trList.size();
	}
	
	LinkedHashSet<String> findDuplicateEmpId(){
		LinkedHashSet<String> hs = new LinkedHashSet<String>();
		LinkedHashSet<String> hsOfDuplicateEmpId = new LinkedHashSet<String>();
		String empId = "";
		for (int index=1; index <= tr; index++) {
			empId =  driver.findElement(By.xpath("//table[@class='table table-striped']//tbody//tr[" + index + "]//td[2]")).getText();;
			if (!hs.add(empId))
				hsOfDuplicateEmpId.add(empId);
		}
		return hsOfDuplicateEmpId;
	}
	
	LinkedHashMap<String, Integer> findDuplicateEmpId2(){
		LinkedHashMap<String, Integer> hm = new LinkedHashMap<String, Integer>();
		String empId = "";
		for (int index=1; index <= tr; index++) {
			empId =  driver.findElement(By.xpath("//table[@class='table table-striped']//tbody//tr[" + index + "]//td[2]")).getText();
			if (!hm.containsKey(empId))
				hm.put(empId, 1);
			else
				hm.put(empId, hm.get(empId)+1);
		}
		System.out.println("Duplicate Employees = ");
		for (String key : hm.keySet())
			if (hm.get(key)>1)
				System.out.println(key);
		return hm;
	}	
	
	Map<String, Integer> mapOfDeptAndEmpCount(){
		Map<String, Integer> hm = new LinkedHashMap<String, Integer>();
		String dept = "";
		for (int index=1; index <= tr; index++) {
			dept =  driver.findElement(By.xpath("//table[@class='table table-striped']//tbody//tr[" + index + "]//td[5]")).getText();
			if (!hm.containsKey(dept))
				hm.put(dept, 1);
			else
				hm.put(dept, hm.get(dept)+1);
		}
		return hm;
	}	
	
	Map<String, Integer> mapOfManagerAndEmpCount(){
		Map<String, Integer> hm = new LinkedHashMap<String, Integer>();
		String manager = "";
		for (int index=1; index <= tr; index++) {
			manager =  driver.findElement(By.xpath("//table[@class='table table-striped']//tbody//tr[" + index + "]//td[4]")).getText();
			if (!hm.containsKey(manager))
				hm.put(manager, 1);
			else
				hm.put(manager, hm.get(manager)+1);
		}
		return hm;
	}	
	
	

	public static void main(String[] args) {
		Assignment4Table2 obj = new Assignment4Table2();
		obj.goToDemoTables();
		obj.getTable2RowsColumns();
		System.out.println("\n======> Selenium Assignment 4 Program 7 <==========");
		System.out.println("======> find duplicate employee id if any. [HashSet, add return type] <==========");
		System.out.println(obj.findDuplicateEmpId());
		System.out.println("\n======> Selenium Assignment 4 Program 8 <==========");
		System.out.println("======> find duplicate employee id if any. [Map<String, Integer>, key -> value >1] <==========");
		obj.findDuplicateEmpId2();
		System.out.println("\n======> Selenium Assignment 4 Program 9 <==========");
		System.out.println("======> Return map of Dept and employee count <==========");
		System.out.println(obj.mapOfDeptAndEmpCount());
		System.out.println("\n======> Selenium Assignment 4 Program 10 <==========");
		System.out.println("======> Return map of manager id and number of employees reporting to that manager. <==========");
		System.out.println(obj.mapOfManagerAndEmpCount());
		
	}
}
