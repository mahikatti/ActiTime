package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {
	
	@FindBy (xpath ="//a[@class='content tt_selected selected']")
	private WebElement timetrack ;
	
	@FindBy (xpath ="//div[text()='Tasks']")
	private WebElement task ;
	
	@FindBy (xpath ="//a[@class='content reports']")
	private WebElement reports ;
	
	@FindBy (xpath ="//a[@class='content users']")
	private WebElement user ;
	
	@FindBy (xpath ="//a[@class='content calendar']")
	private WebElement workSchedule ;
	
	@FindBy (xpath ="//a[@id='logoutLink']")
	private WebElement logout ;
	
	private WebDriver driver;
	
	public HeaderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	public void openTimeTrack() 
	{
		timetrack.click();
	}
	
	public void openTask() 
	{
		task.click();
	}
	
	public void openReports() 
	{
		reports.click();
	}
	
	public void openUser() 
	{
		user.click();
	}
	
	public void openWorkSchedule() 
	{
		workSchedule.click();
	}
	
	public void clickOnLogout() 
	{
		logout.click();
	}

}
