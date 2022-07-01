package omkar.OrangeHRM;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Test_Case3 extends Test_Case1 {
	void TC_3() {
		TC_1();
		WebElement userProfile=driver.findElement(By.xpath("//div[@class='image-container']"));
		System.out.println("Is User Profile shown ");
		Assert.assertTrue(userProfile.isDisplayed());		
		
		Actions action = new Actions(driver);
		action.moveToElement(userProfile).click(driver.findElement(By.xpath("//a[@class='password-action profile-context-menu-handler']/i[text()='ohrm_settings']"))).build().perform();
		
		driver.findElement(By.xpath("//a[@id='aboutDisplayLink']")).click();
		
		String empCountInString=driver.findElement(By.xpath("//p[contains(text(),'Employees: 95')]")).getText();
		empCountInString=empCountInString.split(" ")[1];
		
		int empCount=Integer.parseInt(empCountInString);
		System.out.println("Total count of Employee is "+empCount);
		Assert.assertTrue(empCount>0);		
		System.out.println("Verify Emp count is non zero ");
		
		List<WebElement> componyWebInfoList= driver.findElements(By.xpath("//div[@class ='col s12']"));
		List<String> actualComponyInfo= new ArrayList<>();
		
		List<String> expectedComponyInfo= new ArrayList<>();		
		expectedComponyInfo.add("Company Name");
		expectedComponyInfo.add("Version");
		expectedComponyInfo.add("Employees");
		expectedComponyInfo.add("Users");
		expectedComponyInfo.add("Renewal on");
		
		System.out.println("Step - > Expected Compony Info"+expectedComponyInfo);
		for(int i=0;i<componyWebInfoList.size();i++) {
			actualComponyInfo.add(componyWebInfoList.get(i).getText().split(":")[0].trim());
		}
		
		Assert.assertTrue(expectedComponyInfo.equals(actualComponyInfo));
		System.out.println(" Verify : Compony info getting display");
	}
}
