package sonali;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {
	private WebDriver driver;
	void setup() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	    driver.get("http://automationbykrishna.com");
	    WebElement demotablelink=driver.findElement(By.id("demotable"));
	    demotablelink.click();
	}
	void program1() {
		System.out.println("Print whole table using 2 for loop");
	    int size=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
	
	    for(int index=1;index<=size;index++) {
	    	for(int i=1;i<=4;i++) {
	    		String data=driver.findElement(By.xpath("//table[@id=\"table1\"]/tbody/tr[" + index + "]/td[" + i + "]")).getText();
	    		System.out.print(data + " ");
	    	}
	    	System.out.println();
	    }
	   		
	}
	void program2() {
		System.out.println("Print specific row : username - mkanani");
		int size=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for(int index=1;index<=size;index++) {
	     		String uname=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]")).getText();
	     		if(uname.equals("mkanani")) {
	     			String row=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]")).getText();
	     		System.out.println(row);
	     	}
		}
	}
	void program3() {
		System.out.println("Print last rows from 1st table ");
		int size=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		String lastrow=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + size + "]")).getText();
		System.out.println(lastrow);
	}
	List<String> program4() {
	 List<String> listoffirstname = new ArrayList<String>();
	 int size=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
	 for(int index=1;index<=size;index++) {
  		String firstname=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]")).getText();
  		listoffirstname.add(firstname);
	 }
	 return listoffirstname;
	}
	Map<String,String> program5(){
		Map<String,String> listofemployee =new LinkedHashMap<String,String>();
		int size=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for(int index=1;index<=size;index++) {
			String uname=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]")).getText();
	  		String firstname=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]")).getText();
	  		listofemployee.put(uname, firstname);
		}
		return listofemployee;
	}
	Set<String> program6(){
		Set<String> setofsurname=new HashSet<String>();
		int size=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		 for(int index=1;index<=size;index++) {
	  		String surname=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[3]")).getText();
	  		setofsurname.add(surname);
		 }
		return setofsurname;
	}
	
	
	public static void main(String[] args) {
		Assignment4 assignment4 =new Assignment4();
		assignment4.setup();
		assignment4.program1();
		assignment4.program2();
		assignment4.program3();
		System.out.println("List of first name is "+ assignment4.program4());
		System.out.println("List of Employee is "+ assignment4.program5());
		System.out.println("List of surname" + assignment4.program6());
	}
	
}
