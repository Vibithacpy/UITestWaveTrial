package docker;

import java.net.MalformedURLException;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidLogin extends UtilityClass

{
	
    @Test
	public void VerifyValidLogin() throws MalformedURLException {
		FirefoxOptions firefoxoptions = new FirefoxOptions();		
		URL url=new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver=new RemoteWebDriver(url,firefoxoptions);
		driver.get("https://wave-trial.getbynder.com/login/");
		 login(driver,"Vibitha","7K>}N!\\~J)=@]JcP");
         //check for home page
          Assert.assertEquals(driver.getCurrentUrl(), "https://wave-trial.getbynder.com/account/dashboard/");
          //logout  
        logout(driver);
           WebElement logoutMessage=driver.findElement(By.xpath("//p[text()='You have successfully logged out.']"));
        System.out.println("logoutMessage"+logoutMessage.getText());
      	//check for logout message
        Assert.assertEquals(logoutMessage.getText(),"You have successfully logged out.");
          //check for login page
        Assert.assertEquals(driver.getCurrentUrl(), "https://wave-trial.getbynder.com/login/");
        
        
	}
    
    
    
   

}
