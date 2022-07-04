package docker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class UtilityClass {
	 public void login(RemoteWebDriver driver,String username,String password)
	    {
	    	WebElement userName=driver.findElement(By.xpath("//input[@name='username']"));
			WebElement passWord=driver.findElement(By.id("inputPassword"));
			WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
		userName.sendKeys(username);
		passWord.sendKeys(password);
		loginButton.click();
	    }
	 public void logout(RemoteWebDriver driver)
	 {
		 WebElement profile= driver.findElement(By.xpath("//a[@class='admin-dropdown profile']"));  
         profile.click();
          WebElement logoutButton= driver.findElement(By.xpath("//button[@class='action-btn block blue']"));
      	  logoutButton.click();
      	  
	 }
}
