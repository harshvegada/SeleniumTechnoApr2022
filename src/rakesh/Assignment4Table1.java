/* Assignment - 4 : 18th Jun'2022

Program - 1. Print whole table using 2 for loop
Program - 2. Print specific row : username - mkanani
Program - 3. Print last rows from 1st table 
Program - 4. return firstname of all employess from table1
Program - 5. return username as key and firstname as value from table1
Program - 6. Unique surname from table1. [LinkedHashSet]

 */
package rakesh;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Assignment4Table1 {

	WebDriver driver = PreReq.setUp();
	List<WebElement> thList;
	List<WebElement> trList;
	int tr;
	int td;
	
	void goToDemoTables() {
		driver.findElement(By.id("demotable")).click();
	}
	
	void getTable1RowsColumns() {
		thList = driver.findElements(By.xpath("//table[@id='table1']//th"));
		trList = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr"));
		td = thList.size();
		tr = trList.size();
	}
	
	void printTable() {
		for (int index=1; index <= tr; index++) {
			String data = "";
			for (int innerIndex=1; innerIndex<=td; innerIndex++) {
				if (innerIndex==td)
					data += driver.findElement(By.xpath("//table[@id='table1']//tbody//tr[" + index + "]//td[" + innerIndex + "]")).getText();
				else
					data += driver.findElement(By.xpath("//table[@id='table1']//tbody//tr[" + index + "]//td[" + innerIndex + "]")).getText()+"--";
			}
			System.out.println(data);
		}
	}
	
	void findRow(String userName) {
		System.out.println("Row with username - " + userName + ":");
		boolean flag = false;
		for (int index=1; index <= tr; index++) {
			String data = "";		
			String element = driver.findElement(By.xpath("//table[@id='table1']//tbody//tr[" + index + "]//td[4]")).getText();
			if (element.equals(userName)) {
				data = driver.findElement(By.xpath("//table[@id='table1']//tbody//tr[" + index + "]")).getText();
				System.out.println(data);
				flag = true;
				break;
			}	
		}
		if (flag==false)
			System.out.println("No such username found");
	}
	
	void printLastRow() {
		String data = "";		
		data = driver.findElement(By.xpath("//table[@id='table1']//tbody//tr[" + tr + "]")).getText();
		System.out.println(data);
	}
	
	List<String> allFirstNames() {
		List<WebElement> listOfWebEle = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[2]"));
		List<String> listOfFirstNames = new ArrayList<String>();
		for (WebElement webEle : listOfWebEle)
			listOfFirstNames.add(webEle.getText());
		
		return listOfFirstNames;
	}
	
	LinkedHashMap<String, String> mapOfUsernameAndFirstName(){
		LinkedHashMap<String, String> hm = new LinkedHashMap<String, String>();
		String username = "";
		String firstName = "";
		for (int index=1; index <= tr; index++) {
			username =  driver.findElement(By.xpath("//table[@id='table1']//tbody//tr[" + index + "]//td[4]")).getText();
			firstName =  driver.findElement(By.xpath("//table[@id='table1']//tbody//tr[" + index + "]//td[2]")).getText();
			hm.put(username, firstName);
		}
		return hm;
	}
	
	LinkedHashSet<String> uniqueSurnames(){
		LinkedHashSet<String> hs = new LinkedHashSet<String>();
		String lastName = "";
		for (int index=1; index <= tr; index++) {
			lastName =  driver.findElement(By.xpath("//table[@id='table1']//tbody//tr[" + index + "]//td[3]")).getText();;
			hs.add(lastName);
		}
		return hs;
	}
	

	public static void main(String[] args) {
		Assignment4Table1 obj = new Assignment4Table1();
		obj.goToDemoTables();
		obj.getTable1RowsColumns();
		System.out.println("\n======> Selenium Assignment 4 Program 1 <==========");
		System.out.println("======> Print whole table using 2 for loop <==========");
		obj.printTable();
		System.out.println("\n======> Selenium Assignment 4 Program 2 <==========");
		System.out.println("======> Print specific row <==========");
		obj.findRow("mkanani");
		obj.findRow("asharma");
		obj.findRow("invalidUserName");
		System.out.println("\n======> Selenium Assignment 4 Program 3 <==========");
		System.out.println("======> Print last rows from 1st table <==========");
		obj.printLastRow();
		System.out.println("\n======> Selenium Assignment 4 Program 4 <==========");
		System.out.println("======> Return firstname of all employess from table1 <==========");
		System.out.println(obj.allFirstNames());
		System.out.println("\n======> Selenium Assignment 4 Program 5 <==========");
		System.out.println("======> Return username as key and firstname as value from table1 <==========");
		System.out.println(obj.mapOfUsernameAndFirstName());
		System.out.println("\n======> Selenium Assignment 4 Program 6 <==========");
		System.out.println("======> Unique surname from table1. [LinkedHashSet] <==========");
		System.out.println(obj.uniqueSurnames());

	}
}
