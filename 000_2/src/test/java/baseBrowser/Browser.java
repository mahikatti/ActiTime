package baseBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	
	public static WebDriver launchChromeBrowser() {
		
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		return driver;
	}
	
public static WebDriver launchFirefoxBrowser() {
		
	System.setProperty("webdriver.gecko.driver","D:\\geckodriver.exe");
	WebDriver driver= new FirefoxDriver();
		return driver;
	}

}
