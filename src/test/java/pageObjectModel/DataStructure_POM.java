package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class DataStructure_POM {
	public static WebDriver driver =BaseClass.getDriver();
	
	@FindBy (xpath = "//a[@href ='data-structures-introduction']")WebElement getStartedDSintro_link;
	@FindBy (xpath="//a[@href='time-complexity']")WebElement timecomplexity_link;
	@FindBy (xpath="//a[@href='/tryEditor']")WebElement tryEditor_link;
	@FindBy (xpath ="//form/div/div/div/textarea")
	WebElement textEditor; 
	
	@FindBy(xpath ="//button[text()='Run']")
	WebElement runBtn;
	
	
	public DataStructure_POM() {
		PageFactory.initElements(driver, this);
	}
	public void getStarted_DS() {
		getStartedDSintro_link.click();		
	}
	public String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public void clickOnTimeComplexitylink(){
		timecomplexity_link.click();

	}
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public void tryEditorlink() {
		tryEditor_link.click();
	}
	
	
	public void enterCode(String pythonCode) throws InterruptedException {
		textEditor.sendKeys(pythonCode);
	} 
	
	public void clickRunBtn() throws InterruptedException {
		Thread.sleep(1000);
		runBtn.click();
	}

}