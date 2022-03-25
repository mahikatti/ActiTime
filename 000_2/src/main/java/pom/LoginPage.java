package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy (xpath ="//input[@name='username']")
	private WebElement username ;
	
	@FindBy (xpath ="//input[@name='pwd']")
	private WebElement password ;
	
	@FindBy (xpath ="//input[@name='remember']")
	private WebElement rememberMe ;
	
	@FindBy (xpath ="//a[@id='loginButton']")
	private WebElement loginButton ;
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void sendUserName(String userid) 
	{
		username.sendKeys(userid);
	}
	public void sendPassword(String passwd)
	{
		password.sendKeys(passwd);
	}
	public void clickOnKeepMeLogin()
	{
		if(!(rememberMe.isSelected()))
		{	
			rememberMe.click();
		}
		else
		{
			System.out.println("keep me login checkbox already selected");
		}
	}
	public void clickOnLoginButton()
	{
		loginButton.click();
	}

}
