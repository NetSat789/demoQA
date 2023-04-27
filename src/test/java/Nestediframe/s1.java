package Nestediframe;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class s1
{
public static void main(String[] args) throws InterruptedException
{
//	https://demoqa.com/nestedframes
//		
//	System.setProperty("webdriver.chrome.driver",
//            "C:\\Users\\mnetke.dev\\Desktop\\Selenium Files\\chromedriver.exe");

WebDriver driver = new ChromeDriver();

driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.get("https://demoqa.com/nestedframes");   

driver.switchTo().parentFrame();      //String frame Name

String chifr = driver.findElement(By.xpath("//iframe[@src='/sampleiframe']")).getText();
System.out.println(chifr);
//iframe[@id='frame1']

System.out.println("iframe handled");
Thread.sleep(3000);
driver.switchTo().frame(0);
driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
System.out.println("2nd iframe handled");

//p[text()='Child Iframe']
}
}
