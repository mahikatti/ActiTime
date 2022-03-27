package testPack;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.internal.Systematiser;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import baseBrowser.Browser;
import pom.CreateTask;
import pom.HeaderPage;
import pom.LoginPage;
import utilis.Utility;

public class VerifyUserCreated extends Browser{
		
		private WebDriver driver;
		private LoginPage loginPage;
		private CreateTask createTask;
		private HeaderPage headerPage;
		private SoftAssert soft;
		String TestId;
		public static ITestResult result; 
		static ExtentTest test;
		static ExtentHtmlReporter reporter;
		@BeforeTest 
		@Parameters("browser")
		public void launchBrowser(String browserName) {
			reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
			ExtentReports extend = new ExtentReports();
			extend.attachReporter(reporter);
			System.out.println("launchbrowser");
			
			if(browserName.equals("chrome"))
			{
				driver=launchChromeBrowser();
			}
			if(browserName.equals("firefox"))
			{
				driver=launchFirefoxBrowser();
		    }
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		@BeforeClass
		public void createObjectOfPOM()
		{
			loginPage=new LoginPage(driver);
			headerPage=new HeaderPage(driver);
			createTask = new CreateTask(driver);
		}
		
		@BeforeMethod
		public void logInToApplication() throws EncryptedDocumentException, IOException {
			System.out.println("logInToApplication");
			driver.get("http://localhost/login.do");
			
			String userid=Utility.getDataFromExcel("Test", 1, 0);
			System.out.println(userid);
			
			String password=Utility.getDataFromExcel("Test", 1, 1);
			System.out.println(password);
			
			loginPage.sendUserName(userid);
			loginPage.sendPassword(password);
			loginPage.clickOnKeepMeLogin();
			loginPage.clickOnLoginButton();
			headerPage=new HeaderPage(driver);
			headerPage.openTask();
			
		}
		
		@Test
		public void custemerName() {
			headerPage.openTask();
			createTask = new CreateTask(driver);
			soft = new SoftAssert();
			String custName = createTask.costumerName();
			soft.assertEquals(custName, "Indu");
			soft.assertAll();
			Assert.assertEquals(custName,"Indu");
		}
		@AfterMethod
		public void takeScreenshotForFailedTest(ITestResult result) throws IOException {
			if(ITestResult.FAILURE == result.getStatus())
				{
				Utility.getScreenshotOfTest(driver, TestId);
				}
			System.out.println("logout");
			headerPage.clickOnLogout();
		}
		
		@AfterClass
		public void clearObjOFPom() {
			System.out.println("clearObjOFPom");
			loginPage = null;
			headerPage = null;
			createTask =null;
		}
		

		@AfterTest
		public void closeBrowser() {
			System.out.println("closeBrowser");
			driver.quit();
			driver= null;
			System.gc();
		}

	}


