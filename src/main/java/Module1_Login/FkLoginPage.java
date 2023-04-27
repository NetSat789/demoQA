package Module1_Login;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LibraryClass.baseClass;

public class FkLoginPage extends baseClass 
{
	 @FindBy(xpath="//input[@id='User_Name']") private WebElement username;
     @FindBy(xpath="//input[@id='id_password']") private WebElement PSW;
     @FindBy(xpath="//input[@checked='checked']") private WebElement RemMe;
     @FindBy(xpath="//input[@value='Login']")private WebElement lgn;//input[@type='submit']
     @FindBy(xpath="//img[@src='/JK_Tyre/QA/Images/OneSetuNew.png']") private WebElement logo;
     @FindBy(xpath="//img[@src='/JK_Tyre/QA/Images/Login_Background.png']") private WebElement BackImg;
     @FindBy(xpath="(//a[@href='mailto:swsupport.ahd@qodenext.com'])[1]") private WebElement ForPas;

     
     
     public FkLoginPage(WebDriver driver)
     {
    	 PageFactory.initElements(driver, this);
     }

     public void EnterUserName(String UN)
     {
    	 username.sendKeys(UN);
     }
     public void EnterPassword(String PW) 
     {
    	 PSW.sendKeys(PW);
     }
     public boolean RememberMe()
     {
    	return RemMe.isSelected();
     }
    
     public  boolean MainLogo()
     {
    	 return logo.isDisplayed();
     }
     public  boolean BackImage()
     {
    	 return BackImg.isDisplayed();
     }
     
       
     public void Submit() 
     {
            lgn.submit();
     }
   
     public void checkLinks() 
     {
    	    List<WebElement> links = driver.findElements(By.tagName("a"));
    	    //links.addAll(driver.findElements(By.tagName("img")));
    	  System.out.println(links.size());
    	   
    	  for (WebElement link : links) 
    	  {
    	        String url = link.getAttribute("href");
    	        try
    	        {
    	            Thread.sleep(1000);
    	            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
    	            connection.connect();
    	            
    	            int responseCode = connection.getResponseCode();
    	           
    	            if (responseCode != 200)
    	            {
    	                System.out.println("Broken Link: " + url + " (" + responseCode + ")");
    	            }
    	        }
    	        
    	        catch (Exception e) 
    	        {
    	            System.out.println("Error checking Link: " + url);
    	            e.printStackTrace();
    	        }
    	    }
    	}
     }
       
