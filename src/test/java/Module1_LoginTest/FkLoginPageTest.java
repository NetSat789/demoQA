package Module1_LoginTest;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import LibraryClass.UtilityClass;
import LibraryClass.baseClass;
import Module1_Login.FkLoginPage;
public class FkLoginPageTest extends baseClass 
{
	FkLoginPage login;
	  int TCID;
	
 @BeforeClass
	public void openBrowser() throws  IOException, InterruptedException
	{
		initializeBrowser();
		login= new FkLoginPage(driver);
		login.checkLinks();
	    login.EnterUserName(UtilityClass.GetDT(0, 0));
		login.EnterPassword(UtilityClass.GetDT(0, 1));
        login.RememberMe();
       System.out.println("selected");
		 login.Submit();
	}
	@Test
	public void IsLogoDisplay()
	{
		TCID=500;
		login.MainLogo();
	}
	
	@Test
	public void IsBackImageDisplay()
	{
		TCID=501;
		login.BackImage();
	}
	
	@AfterMethod
	public void logout(ITestResult s1) throws Exception
	{
		if(s1.getStatus()==ITestResult.FAILURE);
		{
			UtilityClass.demo_ss(driver, TCID);
		}
		
	}
	@AfterClass
    public void CloseBrowser() throws InterruptedException
    {
	   Thread.sleep(5000);
	   driver.quit();
     }

   }