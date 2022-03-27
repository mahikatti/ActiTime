package utilis;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	
	public static void getScreenshotOfTest(WebDriver driver, String TestId) throws IOException
	{
		SimpleDateFormat sdf=new SimpleDateFormat("HH-mm-ss");
		SimpleDateFormat sdf2=new SimpleDateFormat("dd-MM-yy");
		Date date= new Date();
		String m=sdf.format(date);
		String k =sdf2.format(date);	
		File source= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("D:\\ScreenShots"+ TestId +" "+ m +" "+ k + ".jpg");
	    FileHandler.copy(source, dest);	
	}
	
	public static String getDataFromExcel( String sheet,int row, int cell) throws EncryptedDocumentException, IOException
	{
		String data ="";
	
			FileInputStream file = new FileInputStream("D:\\Notes\\Book1.xlsx");
			String value3= WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
			System.out.println(value3);
			data=value3;
			
		
		return data;
		
	}
	
	
	
	//@Test
	public static void getDataFromExcel() throws EncryptedDocumentException, IOException {
		System.out.println(Utility.getDataFromExcel("Test", 1, 0));
	}
	
	

}
