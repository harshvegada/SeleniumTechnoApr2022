package alka;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import alka.PredefinedActions;
import alka.DashboardPage;
import alka.LoginPage;

public class DashboardTest {
	DashboardPage dashboardpage=new DashboardPage();
	//Login functionality testcase_1
	@BeforeClass
	public void setUp()
	{
		final String username="Admin";
		final String password="iJe60@vBNJ";
		LoginPage loginpage=new LoginPage();
		loginpage.Login(username, password);
		System.out.println("VERIFY: user landed to dashboard page ");
		Assert.assertTrue(loginpage.getCurrentUrl().endsWith("dashboard"));
		
	}
	
	@Test
	public void testcase_2()
	{
		
		System.out.println("Verify Top bar Title");
		boolean isEmpManagementDisplayed=dashboardpage.isTopBarTitleDisplayed();
		Assert.assertTrue(isEmpManagementDisplayed);
		System.out.println("Count Total Widgets Displayed on Dashboard");
		int actualWidget=dashboardpage.getTotalWidgets();
		int expectedWidgets=9;
		System.out.println("Verify Total Widgets");
		Assert.assertEquals(actualWidget,expectedWidgets);
		List<String> actualWidgetHeaderText=dashboardpage.getWidgetHeaderText();
		System.out.println(actualWidgetHeaderText);
		List<String> expectedWidgetHeaderText=new ArrayList<>();
		expectedWidgetHeaderText.add("Quick Access");
		expectedWidgetHeaderText.add("Buzz Latest Posts");
		expectedWidgetHeaderText.add("My Actions");
		expectedWidgetHeaderText.add("Headcount by Location");
		expectedWidgetHeaderText.add("Employees on Leave Today");
		expectedWidgetHeaderText.add("Time At Work");
		expectedWidgetHeaderText.add("Latest Documents");
		expectedWidgetHeaderText.add("Latest News");
		expectedWidgetHeaderText.add("COVID-19 Report");
		Assert.assertEquals(actualWidgetHeaderText, expectedWidgetHeaderText);
		Assert.assertTrue(actualWidgetHeaderText.equals(expectedWidgetHeaderText));
	}
	
	@Test
	public void testcase_3()
	{
		
		boolean userProfileElement=	dashboardpage.isProfileElementDisplayed();	
		Assert.assertTrue(userProfileElement);
		System.out.println("VERIFY:User profile Display on UI");
		dashboardpage.clickOnUserSetting();
		List<String>  lstActuallist=dashboardpage.getUserSubMenu();
		Assert.assertEquals(lstActuallist.size(), 2);
		System.out.println("VERIFY:Total 2 Elements is displayed");
		List<String> lstExpectedlist=new ArrayList<String>();
		lstExpectedlist.add("Change Password");
		lstExpectedlist.add("About");
		Assert.assertEquals(lstActuallist, lstExpectedlist);
		System.out.println("VERIFY:Actual list and Expected List are Matching");
		System.out.println("STEP: Clicked on about button");
		dashboardpage.clickOnAboutSubmenu();
		System.out.println("VERIFY:Employees are non Zero");
		int empCount=dashboardpage.getEmplyoeeCount();
		Assert.assertTrue(empCount>0,"Employee Count is non zero");
		Map<String,String> mapOfAboutText=dashboardpage.getAboutText();
		Set<String> actualCompanyInfo=mapOfAboutText.keySet();
		Set<String> expectedCompanyInfo=new HashSet<String>();
		expectedCompanyInfo.add("Company Name");
		expectedCompanyInfo.add("Version");
		expectedCompanyInfo.add("Employees");
		expectedCompanyInfo.add("Users");
		expectedCompanyInfo.add("Renewal on");
		Assert.assertTrue(actualCompanyInfo.equals(expectedCompanyInfo));
		System.out.println("VERIFY:Company Info Getting Display");
		System.out.println("STEP: Clicked on OK button");
		dashboardpage.clickOnOKButton();
	}
	@Test
	public void testcase_4()
	{  
		System.out.println("Click on Employee Management Tab");
		dashboardpage.payableAmtNonZero();
	}
	@Test
	public void testcase_5()
	{
		System.out.println("Click on HR Administration Tab");
		dashboardpage.verifyRecordsInTable();
	}
	@Test
	public void testcase_6()
	{
		System.out.println("Click on More Tab");
		dashboardpage.verifyRandomSelectionOfSkill();	
	}
	@Test
	public void testcase_7()
	{
		
		System.out.println("Click on HR Adminstration Tab");
		dashboardpage.verifyCompanyNameReflection();	
	}
	
}
