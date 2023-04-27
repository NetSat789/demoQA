package LibraryClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass
{
	public static String GetDT(int rowIndex,int cellIndex) throws EncryptedDocumentException, IOException
	{
	 FileInputStream file=new FileInputStream("C:\\jprogram\\eclipse\\demoQa\\TestData\\9th_July_First_excel1.xlsx");
	 Sheet sh=WorkbookFactory.create(file).getSheet("Sheet7");
	 String excel = sh.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
	 return excel;
	} 
 
	public static void demo_ss(WebDriver driver,int TCID) throws IOException
   {
 	 File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
 	File dest=new File("C:\\jprogram\\eclipse\\demoQa\\Failed_testCase_SS\\TestCaseID"+TCID+".jpg");
 	FileHandler.copy(src, dest);
    }
   
	
}
