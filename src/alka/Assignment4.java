
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

package alka;

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

public class Assignment4 {
	private WebDriver driver;
	void setProperty(String url)
	{
		System.out.println("Step1-launch browser ");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("Step2-load url");
		driver.get(url);
		driver.manage().window().maximize();
	}
    void printTable()
    {
    	setProperty("http://automationbykrishna.com");
		System.out.println("Step3-Click on Demo Tables");
    	driver.findElement(By.xpath("//a[@id='demotable']")).click();
		int noOfRows = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr")).size();

		int noOfColumns = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr[1]/td")).size();

    	int size= driver.findElements(By.xpath("//div[@id='empmanager']//tbody//tr")).size();
    	String data="";
		System.out.println("Step4-Print Whole Table");
		System.out.println("# "+"            EmployeeID      "+"      Employee Name      "+"    Employee ManagerID   "+"   Employee Dept  ");
		

    	    	for(int index=1;index<=noOfRows;index++)
    	    	{
    	    		for(int innerindex=1;innerindex<=noOfColumns;innerindex++)
        	    	{
    	    			
    	    			 data=driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr["+index+"]/td["+innerindex+"]")).getText();
    	    		
    	    			 System.out.print(data);
    	    			 System.out.print("               ");
    	    			 
        	    	}
        	    	System.out.println();
    	    	}
    	    	System.out.println();
    }
    void printSpecificRow()
    {
    	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    	String data="";
    	data=driver.findElement(By.xpath(" //table[@id='table1']/tbody/tr[1]/td[4]")).getText();
    	System.out.println("Print particular Row");
    	System.out.println("UserName -"+data);
    	System.out.println();
    }
    
    void printLastRowFromFirstTable()
     {
    	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    	String data="";
    	data=driver.findElement(By.xpath(" //table[@id='table1']/tbody/tr[5]")).getText();
    	System.out.println("Print Last Row From Table");
    	System.out.println("LastRow="+data);
    	System.out.println();
    }
    void printFirstNameFromFirstTable()
    {
   	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
   	String data="";
   	int size=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
   	System.out.println(driver.findElement(By.xpath("//table[@id='table1']//thead//th[2]")).getText());
   	for(int index=1;index<=size;index++)
   	{
   		
   		data=driver.findElement(By.xpath("//table[@id='table1']//tr["+index+"]//td[2]")).getText();
   	    System.out.println(data);
    	
   	}
   	System.out.println();
    }
    
    void printUsernameAndFirstName()
    {
    	int size= driver.findElements(By.xpath("//table[@id='table1']//tbody//tr")).size();
    	List<WebElement> elements= driver.findElements(By.xpath("//table[@id='table1']//tbody//tr"));
    	HashMap<String,String> hm=new LinkedHashMap<String,String>();
    	for(int index=1;index<=elements.size();index++)
    	{
    		String key=driver.findElement(By.xpath("//table[@id='table1']//tr["+index+"]//td[4]")).getText();
    		String val= driver.findElement(By.xpath("//table[@id='table1']//tr["+index+"]//td[2]")).getText();
    		if(hm.containsKey(key))
    		{
    			
    			hm.put(key, hm.get(key));
    		}
    		else
    		{
    			hm.put(key, val);
    		}
    	}
    	System.out.println("Print UserName and FirstName");
    	System.out.println(hm);
    	System.out.println();
   }
    //Program - 6. Unique surname from table1. [LinkedHashSet]
   void printUniqueSurname()
   {
	   List<WebElement> elements=driver.findElements(By.xpath("//table[@id='table1']//tbody//tr"));
	   HashSet<String> hs=new LinkedHashSet<String>();	
	   for(int index=1;index<=elements.size();index++)
	   {
		    String objSurname=driver.findElement(By.xpath("//table[@id='table1']//tbody/tr["+index+"]/td[3]")).getText();
		   if(hs.add(objSurname))
		   {
			   hs.add(objSurname);
			   
		   }
	   }
	   System.out.println("Unique SurName");
	   System.out.println(hs);
	   System.out.println();
   }
  // Program - 7. find duplicate employee id if any. [HashSet, add return type]
   void getDuplicateEmplyeeId()
   {   
	    
	   List<WebElement> elements=driver.findElements(By.xpath("//div[@id='empmanager']//tbody//tr"));
	   String[] strArr=new String[elements.size()];
	   int arrIndex=0;
	   int count=0;
	   HashSet<String> objHS=new LinkedHashSet<String>();
	   for(int index=1;index<=elements.size();index++)
	   {
		   String objElement=driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr["+index+"]/td[2]")).getText();
		   if(!objHS.add(objElement))
		   {
			   strArr[arrIndex]=objElement;
			   arrIndex++;
			   count++;
		   }
		  
	   }
	   String[] oparr=Arrays.copyOf(strArr, count);
	   System.out.println("Duplicate Employee Id");
	   System.out.println(Arrays.toString(oparr));
	   System.out.println();
   }
  // Program - 8. find duplicate employee id if any. [Map<String, Integer>, key -> value >1]
   void getDuplicateEmplyeeIdUsingHashMap()
   {
	   List<WebElement> elements=driver.findElements(By.xpath("//div[@id='empmanager']//tbody//tr"));
	   HashMap<String, Integer> hmObj=new LinkedHashMap<String, Integer>();
	   String[] strArr=new String[elements.size()];
	   int arrIndex=0;
	   int count=0;
	   for(int index=1;index<=elements.size();index++)
	   {
		   String objElement=driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr["+index+"]/td[2]")).getText();
		   if(hmObj.containsKey(objElement))
		   {
			   hmObj.put(objElement,hmObj.get(objElement)+1);
		   }
		   else
		   {
			   hmObj.put(objElement, 1);
		   }
	   }
	   Set<String> objKeySet=hmObj.keySet();
	   for(String objS:objKeySet)
	   {
		   int val=hmObj.get(objS);
		   if(val>1)
		   {
			   strArr[arrIndex]=objS;
			   arrIndex++;
			   count++;
		   }
	   }
	   
	   String[] oparr=Arrays.copyOf(strArr, count);
	   System.out.println("Duplicate Employee Id");
	   System.out.println(Arrays.toString(oparr));
	   System.out.println();
   }
  // Program - 9. Return map of Dept and employee count
   HashMap<String, Integer> getMapOfDeptandEmployeeCount()
    {
    	List<WebElement> elements=driver.findElements(By.xpath("//div[@id='empmanager']//tbody//tr"));
    	HashMap<String, Integer> objHM=new LinkedHashMap<String, Integer>();
    	for(int index=1;index<=elements.size();index++)
    	{
    		String objElement=driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr["+index+"]/td[5]")).getText();
    		String objEmpid=driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr["+index+"]/td[2]")).getText();
    		
    		if(objHM.containsKey(objElement))
    		{
    			objHM.put(objElement, objHM.get(objElement)+1);
    		}
    		else
    		{
    			objHM.put(objElement, 1);
    		}
    	}
    	return objHM;
    	
    }
    
    //Program - 10. Return map of manager id and number of employees reporting to that manager.*/
   Map<String, Integer> getMapOfEmployeeMgrID(){

		Map<String, Integer> mapOfManagerid = new HashMap<String, Integer>();

		driver.findElement(By.xpath("//div[@id='empmanager']"));

		int rows = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr")).size();

		for(int index = 1; index <= rows; index++) {

			String empID = driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr["+index+"]/td[4]")).getText();

			Set<String> setOfKeys = mapOfManagerid.keySet();

			if(setOfKeys.contains(empID))
				mapOfManagerid.put(empID, mapOfManagerid.get(empID) + 1);
			else
				mapOfManagerid.put(empID, 1);
		}

		return mapOfManagerid;
	}

	 public static void main(String[] args) {
		 Assignment4 assignment4=new Assignment4();
		 assignment4.printTable();
		 assignment4.printSpecificRow();
		 assignment4.printLastRowFromFirstTable();
		 assignment4.printFirstNameFromFirstTable();
		 assignment4. printUsernameAndFirstName();
		 assignment4.printUniqueSurname();
		 assignment4.getDuplicateEmplyeeId();
		 assignment4. getDuplicateEmplyeeIdUsingHashMap();
		 System.out.println("Map of Department and Employee Count");
		 System.out.println(assignment4. getMapOfDeptandEmployeeCount());
		 System.out.println();
         System.out.println();
		 System.out.println("Map of manager id and number of employees reporting to that manager");
		 System.out.println(assignment4. getMapOfEmployeeMgrID());
	}
}

