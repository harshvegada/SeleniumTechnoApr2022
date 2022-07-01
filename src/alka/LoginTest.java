package alka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import alka.PredefinedActions;
public class LoginTest 
{
	LoginPage loginpage=new LoginPage();
	@Test
	void verifyLogin()
	{
		
		System.out.println("VERIFY:Logo displayed on LOgin page");
		boolean isLogoDisplayed=loginpage.isLogoDisplayed();
		Assert.assertTrue(isLogoDisplayed);
		System.out.println("VERIFY:Login panel displayed on Login page");
		boolean isLoginPanelDisplayed=loginpage.isLoginPanelDisplayed();
		Assert.assertTrue(isLoginPanelDisplayed);
		final String username= "Admin";
		final String password="iJe60@vBNJ";
		System.out.println("STEP- Enter username");
		loginpage.enterUsername(username);
	  	System.out.println("STEP- Enter password");
		loginpage.enterPassword(password);
		System.out.println("VERIFY- user able to enter username");
	  	String actualUserName=loginpage.getUserName();
	  	Assert.assertEquals(actualUserName, username);
	  	System.out.println("VERIFY- user able to enter password");
		String actualPassword=loginpage.getPassword();
		Assert.assertEquals(actualPassword, password);
		System.out.println("User  Click on Login Button on Login Page");
		loginpage.clickOnLoginButton();
		System.out.println("VERIFY-url ends with Dashboard");
		Assert.assertTrue(loginpage.getCurrentUrl().endsWith("dashboard"));
		
	}

}
