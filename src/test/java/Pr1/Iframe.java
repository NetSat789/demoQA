package Pr1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframe
{
public static void main(String[] args) throws InterruptedException 
{
	System.setProperty("webdriver.chrome.driver",
			            "C:\\Users\\mnetke.dev\\Desktop\\Selenium Files\\chromedriver.exe");
	
	WebDriver driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://demoqa.com/frames");   
	
    driver.switchTo().frame("frame1");             //String frame Name

	String chifr = driver.findElement(By.xpath("(//h1[text()='This is a sample page'])[1]")).getText();
	System.out.println(chifr);
	
	driver.switchTo().parentFrame();
    Thread.sleep(3000);
	String chif = driver.findElement(By.xpath("//iframe[@id='frame2']")).getText();
	System.out.println(chif);
	System.out.println("iframe handled successfully");
     driver.quit();
}
}  
//p[text()='Child Iframe']
//iframe[@src='/sampleiframe']