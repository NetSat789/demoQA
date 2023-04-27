package LibraryClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class baseClass
{
		
	public static WebDriver driver;
    
	public void initializeBrowser() throws IOException 
	{
//				System.setProperty("webdriver.chrome.driver",
//				"C:\\jprogram\\eclipse\\demoQa\\BrowserFiles\\chromedriver.exe");
//				// driver=new ChromeDriver();
//				 ChromeOptions options = new ChromeOptions();
//					options.addArguments("--remote-allow-origins=*");
//					driver = new ChromeDriver(options);
		
		driver = new ChromeDriver();
		driver.get("http://qodeonline.com/JK_Tyre/QA/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

}
}
