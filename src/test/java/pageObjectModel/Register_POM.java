package pageObjectModel;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BaseClass;
import utils.ConfigReader;
import utils.LoggerLoad;
//import utils.Utility;

public class Register_POM {
	
	
	public static WebDriver driver = BaseClass.getDriver();
	//ConfigReader cr = new ConfigReader();
	String RegisterURL = ConfigReader.registerPageURL();
	//Utility ul = new Utility();
	
	@FindBy (name="username" ) WebElement username;
	@FindBy (name="password1" ) WebElement pass;
	@FindBy (name="password2" ) WebElement confirmpass;
	@FindBy (xpath="//div[@class='alert alert-primary']" ) WebElement errorMsg;
	@FindBy (xpath="//input[@value='Register']" ) WebElement register;
	
	public Register_POM() {
		PageFactory.initElements(driver, this);
	}
	
	public void OpenRegisterPage() {
			LoggerLoad.info("User is on Register Page");
			driver.get(RegisterURL);
			
	}
	public void setUserName(String userName) {
		
			LoggerLoad.info("Enter User Name");
			username.click();
			username.clear();
			username.sendKeys(userName);
		}
	public void setPassword(String Pass) {
		
		LoggerLoad.info("Enter password");
		pass.click();
		pass.clear();
		pass.sendKeys(Pass);
		
	}
	public void setConfirmPass(String confirmPass) {
		
		LoggerLoad.info("Enter confirm password");
		confirmpass.click();
		confirmpass.clear();
		confirmpass.sendKeys(confirmPass);
	}
	public String verifyErrorMsg() {
		LoggerLoad.info("verify the error message");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String mes1=errorMsg.getText();
		LoggerLoad.warn(mes1);
		return mes1;
	}
	public void ClickRegister() {
		LoggerLoad.info("Click Register Button");
		register.click();
	}
	public String verifyUserWarnMsg() {
		LoggerLoad.info("verify the warn message");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String wmes=username.getAttribute("validationMessage");
		LoggerLoad.warn(wmes);
		return wmes;
	}
	public String verifyPassWarnMsg() {
		LoggerLoad.info("verify the warn message");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String wmes1=pass.getAttribute("validationMessage");
		LoggerLoad.warn(wmes1);
		return wmes1;
	}
	public String verifyConPassWarnMsg() {
		LoggerLoad.info("verify the warn message");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String wmes2=confirmpass.getAttribute("validationMessage");
		LoggerLoad.warn(wmes2);
		return wmes2;
	}

	
	}