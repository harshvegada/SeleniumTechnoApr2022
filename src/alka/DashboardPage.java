package alka;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import alka.PredefinedActions;
public class DashboardPage extends PredefinedActions
{
	public boolean isTopBarTitleDisplayed()
	{
		return driver.findElement(By.xpath("//div[text()='Employee Management']")).isDisplayed();
	}
	public int getTotalWidgets()
	{
		List<WebElement> listofWidgets=driver.findElements(By.xpath("//div[@class='dashboard-container']//div[@dragula-model='widgets']/div[not(contains(@class,'ng-hide'))]"));
		return listofWidgets.size();
		
	}
	public List<String> getWidgetHeaderText()
	{
		List<WebElement> listofWidgets=driver.findElements(By.xpath("//div[@class='dashboard-container']//div[@dragula-model='widgets']/div[not(contains(@class,'ng-hide'))]//div[@class='widget-header']/span[2]"));
	    List<String> listOfWidgetsText=new ArrayList<String>();
	     for(WebElement ele:listofWidgets)
	     {
	    	 listOfWidgetsText.add(ele.getText());
	     }
	     return listOfWidgetsText;
	}
	public boolean isProfileElementDisplayed()
	{
	   return driver.findElement(By.xpath("//div[@class='image-container']/img")).isDisplayed();
    }
	public void clickOnUserSetting()
	{
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@class='image-container']/img"))).click(driver.findElement(By.xpath("//a[@class='password-action profile-context-menu-handler']"))).build().perform();
	}
	public List<String> getUserSubMenu()
	{
		List<WebElement> listOfSubMenuElement =driver.findElements(By.xpath("//div[@class='sub-menu-container-php profile-context-menu-handler opened']/div[@class='sub-menu-container']/div"));
		List<String> lstActuallist=new ArrayList<String>();
		for(int index=0;index<listOfSubMenuElement.size();index++)
		{
			lstActuallist.add(listOfSubMenuElement.get(index).getText().trim());
		}
		return lstActuallist;
	}
	
	public void clickOnOKButton()
	{
		System.out.println("Click on OK Button");
	    driver.findElement(By.xpath("//a[@id='heartbeatSubmitBtn'] ")).click();
	
	}
	 
	public void clickOnAboutSubmenu()
	{
		System.out.println("Click on About button");
		driver.findElement(By.xpath("//a[@id='aboutDisplayLink']")).click();
		
	}
	public int getEmplyoeeCount()
	{
		String empCountInString=driver.findElement(By.xpath("//div[@class='col s12'][3]/p")).getText().trim();
		int empCount= Integer.parseInt(empCountInString.split(" ")[1]);
		return empCount;
	}
	public Map<String, String> getAboutText()
	{
		List<WebElement>  listOfAboutText= driver.findElements(By.xpath("//div[@id='companyInfo'] /div/div/p"));
		Map<String,String> aboutTextMap=new LinkedHashMap<String,String>();
		for(WebElement e:listOfAboutText)
		{
			String text=e.getText();
			String[] arr=text.split(":");
			aboutTextMap.put(arr[0].trim(), arr[1].trim());
		}
		return aboutTextMap;
	}
	public void verifyRecordsInTable()
	{
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='menu_item_81']/span")).click();
		System.out.println("Click on Manage User Roles Tab");
		driver.findElement(By.xpath("//div[@id='top_level_menu_item_menu_item_82']/a[contains(text(),'Manage User Roles ')]")).click();
		List<WebElement> lstElements=driver.findElements(By.xpath("//table[@class='highlight bordered']/tbody/tr"));
		System.out.println("VERIFY:Value display in Table According to Pagination");
		String pagination=driver.findElement(By.xpath("//li[@class='summary']")).getText();
		int expectedSize= Integer.parseInt(pagination.split(" ")[4]);
        Assert.assertEquals(lstElements.size(),expectedSize);
	    int expectedTableRecords=50;
	    WebElement actualTableRecord=driver.findElement(By.xpath("//input[@value='50']"));
	    int actualTableRecordValue=Integer.parseInt(actualTableRecord.getAttribute("value"));
	    Assert.assertEquals(actualTableRecordValue,expectedTableRecords);
	}
	public void payableAmtNonZero()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='menu_item_37']/span")).click();
		System.out.println("Click on My Info Tab");
		driver.findElement(By.partialLinkText("Info")).click();
		System.out.println("Verify Personal Details is Displayed");
		boolean isPersonalInfoDisplayed=driver.findElement(By.xpath("//div[@id='personal_details_tab']//input[@id='firstName']")).isDisplayed();
		Assert.assertTrue(isPersonalInfoDisplayed);
		driver.findElement(By.linkText("Salary")).click();
		System.out.println("Clicked on Salary Tab");
		 String strAmount= driver.findElement(By.xpath("//div[@class='col-9 summary-cards-container']/div[1]/div[2][contains(text(),'$')]")).getText();
		 String t= strAmount.replace("$", "").replace(",", "");
		 String tm=t.substring(0, t.indexOf("."));
		 int ctcAmount=Integer.parseInt(tm);
		 Assert.assertTrue(ctcAmount>0);
	}
	
	public void verifyRandomSelectionOfSkill()
	{  
		System.out.println("Click on Emplyee Management");
		driver.findElement(By.xpath("//a[@id='menu_item_37']/span")).click();
        System.out.println("Click on More Tab");
		driver.findElement(By.xpath("//a[contains(text(),'More ')]")).click();
		Actions  action=new Actions(driver);
		WebElement qualificationElement=driver.findElement(By.xpath("//a[@data-automation-id='more_menu_child_menu_admin_Qualifications']"));
		action.moveToElement(qualificationElement).click(driver.findElement(By.xpath("//*[text()='Skills']"))).build().perform();
		System.out.println("Mouse-hover and click on skills button ");
		driver.findElement(By.xpath("//i[text()='add']")).click();
		System.out.println("Click on Add Button");
		boolean isAddSkillDisplayed=driver.findElement(By.xpath("//h4[text()='Add Skill']")).isDisplayed();
		Assert.assertTrue(isAddSkillDisplayed);
		System.out.println("Verify Add Skill Header Displayed");
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Automation Test 1");
		System.out.println("Enter Skill");
		driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys("java selenium");
		System.out.println("Enter Skill Description");
		driver.findElement(By.xpath("//a[text()='Save']")).click();
		System.out.println("Click on Save Button");
		 List<WebElement> actualElements=driver.findElements(By.xpath("//table[@class='highlight bordered']//tbody/tr//td[2]//span"));
		 List<String> actualSkillSet=new ArrayList<>();
		 for(int index=0;index<actualElements.size();index++)
		 {
			 actualSkillSet.add(actualElements.get(index).getText().trim());
		 }
		System.out.println("After refreshing page");
		driver.navigate().refresh();
		List<WebElement> latestElements=driver.findElements(By.xpath("//table[@class='highlight bordered']//tbody/tr//td[2]//span"));
		List<String> latestactualElements=new ArrayList<>();
		for(int index1=0;index1<latestElements.size();index1++)
		{
			latestactualElements.add(latestElements.get(index1).getText());
		}
		Assert.assertTrue(latestactualElements.contains("Automation Test 1"));
	}
	public void verifyCompanyNameReflection()
	{
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("Click on HR Administration Tab");
	    driver.findElement(By.xpath("//a[@data-automation-id='menu_admin_viewSystemUsers']/span")).click();	
		System.out.println("Click on Organization Tab");
		 driver.findElement(By.xpath("//a[text()='Organization ']")).click();
	    System.out.println("Click on General Information Tab");
		 driver.findElement(By.partialLinkText("General Information")).click();
		System.out.println("Change Organization Name");
		 driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Technocredits");
		 System.out.println("Verify No. of Employees field is disabled ");
	     Assert.assertFalse(driver.findElement(By.xpath("//input[@id='numemp']")).isEnabled()); 	 
	     System.out.println("User Save Information");
	     driver.findElement(By.xpath("//button[text()='Save']")).click();
	     WebElement toastMesageElement=driver.findElement(By.xpath("//div[@class='toast-message']"));
	     driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	     Assert.assertTrue(toastMesageElement.isDisplayed());
		 System.out.println("Verify:Toast message is displayed");
		 System.out.println("Mouse Hover on User profile and click on Setting Icon");
		 WebElement profileElement=driver.findElement(By.xpath("//div[@class='image-container']"));
		 Actions action=new Actions(driver);
		 action.moveToElement(profileElement).click(driver.findElement(By.xpath("//a[@class='password-action profile-context-menu-handler']/i")));
		 System.out.println("Click on About Section");
		 driver.findElement(By.id("aboutDisplayLink")).click();
		 String companyName= driver.findElement(By.xpath("//div[@id='companyInfo']/div/div[1]/p")).getText();
	     String strCompanyName=companyName.split(":")[1].trim();
	     Assert.assertEquals(strCompanyName,"Technocredits");
	}
	
}
