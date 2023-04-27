package Pr1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx2
{
	@DataProvider(name="create")
	public Object[][]dataset()
	{
	    return new Object[][]

	   {
		{"standard_user","secret_sauce"},
		{"locked_out_user","secret_sauce"},
		{"problem_user","secret_sauce"},
		{"performance_glitch_user","secret_sauce"}
		
	   };
	}
	@Test(dataProvider="create")
	public void LoginWithDiffCred(String username,String password)
	{
	  ChromeDriver driver=new ChromeDriver();
	   driver.get("https://www.saucedemo.com/");
	            
	           driver.findElement(By.id("user-name")).sendKeys(username);
	           driver.findElement(By.id("password")).sendKeys(password);
	           driver.findElement(By.id("login-button")).click();
	           driver.quit();
	           

	}
	}

