package docker;

import java.io.File;
import java.io.IOException;

import java.net.URL;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class InvalidLogin extends UtilityClass{
	
	
	@Test
	public void VerifyInvalidValidLogin() throws IOException, InterruptedException {
		
		
		
		ChromeOptions chromeoptions = new ChromeOptions();
		
		URL url=new URL("http://localhost:4444/wd/hub");
		
		RemoteWebDriver driver=new RemoteWebDriver(url,chromeoptions);
		
		driver.get("https://wave-trial.getbynder.com/login/");
		

		File f1 = new File("");
		String FilePath = f1.getAbsolutePath().concat("\\src\\test\\resources\\TestData.xlsx");
		
		
        XSSFWorkbook wb = new XSSFWorkbook(FilePath);
        XSSFSheet s1 = wb.getSheetAt(0);
        int totalNoOfRows  = s1.getLastRowNum();

        XSSFCell username,password;
        for(int i = 2; i <=totalNoOfRows ; i++) 
        {
            	username= s1.getRow(i).getCell(0);
            	password = s1.getRow(i).getCell(1);
			
		  login(driver,username.toString(),password.toString());
          System.out.println(username.toString());
          System.out.println(password.toString());
          System.out.println(driver.getCurrentUrl());
          if(driver.getCurrentUrl().equals("https://wave-trial.getbynder.com/verify/"))
          {
        	  Assert.assertTrue(false,"Webpage to enter captcha is displayed");
        	  
        	  driver.get("https://wave-trial.getbynder.com/login/");
        	  System.out.println("Inside captcha");
          }
          
          else
          {
          //check for error message   
        	
         WebElement validationMessage_invalidLogin=driver.findElement
        		 (By.xpath( "//h1[text()='You have entered an incorrect username or password.']"));
        	
        	 
         Assert.assertEquals
          (validationMessage_invalidLogin.getText(),"You have entered an incorrect username or password.");
        	
        	
        	
        	
        	
        	
          }
          
        }   
       
        //User trying to login with blank username and password
        login(driver,"","");
        WebElement validationMessage_invalidLogin=driver.findElement
       		 (By.xpath( "//h1[text()='You have entered an incorrect username or password.']"));
       	
       	 
        Assert.assertEquals
         (validationMessage_invalidLogin.getText(),"You have entered an incorrect username or password.");
       	
        
	}
    
	
}
