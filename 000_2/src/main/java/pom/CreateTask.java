package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateTask {
	
	@FindBy (xpath ="//a[@href='/tasks/otasklist.do']")
	private WebElement clickOnTask ;
	
	@FindBy (xpath ="//div[@id='ext-gen33']")
	private WebElement createTask ;
	
	@FindBy (xpath ="//table[@id='ext-comp-1017']")
	private WebElement selectCostumer ;
	
	@FindBy (xpath ="(//tr[@class='selectProjectRow'])[1]")
	private WebElement selectNewCostumer ;
	
	@FindBy (xpath ="//input[@id='createTasksPopup_newProject']")
	private WebElement newprojectname ;
	
	@FindBy (xpath ="//input[@id='createTasksPopup_newCustomer']")
	private WebElement newcustomername;
	
	@FindBy (xpath ="(//input[@class='inputFieldWithPlaceholder'])[1]")
	private WebElement entertaskname ;
	
	@FindBy (xpath ="(//td[@class='deadlineCell deadlineNotSet'])[1]")
	private WebElement deadline ;
	
	@FindBy (xpath ="(//table[@class='x-date-inner']//td//span)[33]")
	private WebElement dateselect;
	
//	@FindBy (xpath ="(//tr[@class=' x-btn-with-menu'])[4]")
//	private WebElement buttonbillable;
//	
//	@FindBy (xpath ="//li[@id='ext-gen179']")
//	private WebElement billable;
	
	@FindBy (xpath ="(//td[@class='addToTTCell']//input)[1]")
	private WebElement clickoncheckbox;
	
	@FindBy (xpath ="//div[@id='createTasksPopup_commitBtn']")
	private WebElement submitbutton;
	
	@FindBy (xpath ="//td[text()='Indu']")
	private WebElement costumername;
	
	private WebDriver driver;
	private Actions actions;
	private WebDriverWait wait;
	
	public CreateTask(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		actions = new Actions(driver);
		wait=new WebDriverWait(driver, 10);
	}
	
	public void clickOnTask() 
	{
		clickOnTask.click();
	}
	
	public void clickOnCreateTask() 
	{
		createTask.click();
	}
	

	public void selectCostumer() 
	{
		selectCostumer.click();
	}
	
	public void selectNewCostumer() 
	{
		actions.moveToElement(selectNewCostumer).click().build().perform();
	}
	
	public void newCustomerName() 
	{
		newcustomername.sendKeys("Indu");
	}
	
	public void newProjectName() 
	{
		newprojectname.sendKeys("ActiTimeTaskCreation");
	}
	
	public void enterTaskName() 
	{
		entertaskname.sendKeys("Automation Testing");
	}
	
	public void deadLine() 
	{
		deadline.click();
		
	}
	
	public void dateselect() 
	{
		wait.until(ExpectedConditions.visibilityOf(dateselect));
		actions.moveToElement(dateselect).click().build().perform();
		
	}
	
//	public void buttonBillable() 
//	{
//		buttonbillable.click();
//	}
//	
//	public void billable() 
//	{
//		actions.moveToElement(billable).click().build().perform();
//	}
	
	public void clickONCheckbox() 
	{
		clickoncheckbox.click();
	}
	
	public void submitButton() 
	{
		submitbutton.click();
	}
	
	public String costumerName() 
	{
		String name=costumername.getText();
		return name;
		
	}
	
	


}
