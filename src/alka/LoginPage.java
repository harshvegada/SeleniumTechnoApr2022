package alka;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import alka.PredefinedActions;

public class LoginPage extends PredefinedActions
{
	
   public boolean isLogoDisplayed()
   {
		
	  driver=  PredefinedActions.setUp();
	   try
	   {
		   WebElement e=LoginPage.driver.findElement(By.xpath("//div[@class='organization-logo shadow']/img"));
		   return e.isDisplayed();
	   }
	   catch(NoSuchElementException ne)
	   {
		   return false;
	   }
   }
   
   public boolean isLoginPanelDisplayed()
   {
	   try
	   {
		    return driver.findElement(By.xpath("//div[@class='login-form shadow']")).isDisplayed();
	   }
	   catch(NoSuchElementException ne)
	   {
		   return false;
	   }
   }
	public void Login(String username,String password)
	{
		driver=  PredefinedActions.setUp();
		enterUsername(username);
		enterPassword(password);
		clickOnLoginButton();
	}
	public void enterUsername(String username)
	{
		driver.findElement(By.xpath("//input[@id='txtUsername']")).clear();
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
	}
	public void enterPassword(String password)
	{
		driver.findElement(By.xpath("//input[@id='txtPassword']")).clear();
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
	}
	public String getUserName()
	{
		return driver.findElement(By.xpath("//input[@id='txtUsername']")).getAttribute("value");
	}
	public String getPassword()
	{
		return driver.findElement(By.xpath("//input[@id='txtPassword']")).getAttribute("value");
	}
	public void clickOnLoginButton()
	{
		driver.findElement(By.xpath("//div[@class='button-holder']//button")).click();
		
	}
	
	
}
