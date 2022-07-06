package Gaurav;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TC3 {
	
void case3() {
		
		System.setProperty("webdriver.driver.chrome", "chromebrowser");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get("https://gauravselenium-trials7501.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		boolean logo = driver.findElement(By.xpath("//div[@class='organization-logo shadow']")).isDisplayed();
		System.out.println(logo + " Logo is displayed");
		
		boolean loginform = driver.findElement(By.xpath("//div[@class='login-form shadow']")).isDisplayed();
		System.out.println(loginform + " Loginform is displayed");
		
		WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
		username.sendKeys("Admin");
		
		WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		password.sendKeys("UR1icg5I@L");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement image = driver.findElement(By.xpath("//div[@class='image-container']/img"));
		boolean img = driver.findElement(By.xpath("//div[@class='image-container']/img")).isDisplayed();
		System.out.println("User Profile image is displayed :" + img);
		
		Actions action = new Actions(driver);
		action.moveToElement(image).build().perform();
		
		driver.findElement(By.xpath("//a[@class='password-action profile-context-menu-handler']/i")).click();
		List<WebElement> listofelement = driver.findElements(By.xpath("//div[@class='sub-menu-container-php profile-context-menu-handler opened']//div//a"));
		List<String> element = new ArrayList<String>();
		for(WebElement e : listofelement) {
			element.add(e.getText().trim());
		
		}
		System.out.println("List of sub menu contains :" +element);
		
		driver.findElement(By.xpath("//div[@class='sub-menu-container-php profile-context-menu-handler opened']//div//a[@id='aboutDisplayLink']")).click();
		List<WebElement> aboutlistelement = driver.findElements(By.xpath("//div[@id='companyInfo']/div/div/p"));
		Map<String,String> abouttext = new LinkedHashMap<String,String>();
		for(WebElement e : aboutlistelement) {
			String text = e.getText();
			String[] arr = text.split(":");
			abouttext.put(arr[0].trim(), arr[1].trim());
			
		}
		System.out.println("About text size is : " +abouttext.size());
		System.out.println("About text values are :" +abouttext);
		
		String text = driver.findElement(By.xpath("//div[@id='companyInfo']/div/div[1]/p")).getText();
		System.out.println("company name is : " + text.split(":")[1].trim());
		
		System.out.println("Version is : " + abouttext.get("Version"));
		
		String empCount = abouttext.get("Employees").split(" ")[0];
		System.out.println("Employee count is : " + Integer.parseInt(empCount));
		
		String remainingCountText= abouttext.get("Employees").split("(")[1];
		System.out.println("Remaining Count is : " + Integer.parseInt(remainingCountText.split(" ")[0]));
		
		String userText = abouttext.get("Users");
		System.out.println("Total user are : " + Integer.parseInt(userText.split(" ")[0]));
		
		driver.findElement(By.xpath("//a[@id='heartbeatSubmitBtn']")).click();
		
		
		}

public static void main(String[] args) {
	
	TC3 tc3 = new TC3();
	tc3.case3();
}

}
