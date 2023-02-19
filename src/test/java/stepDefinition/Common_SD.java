package stepDefinition;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectModel.ArrayPage_POM;
import pageObjectModel.HomePage_POM;
import pageObjectModel.Queue_POM;
import pageObjectModel.SignIn_POM;
import utils.LoggerLoad;

public class Common_SD {
	SignIn_POM signin = new SignIn_POM();
	HomePage_POM home =new HomePage_POM();
	ArrayPage_POM array=new ArrayPage_POM();
	Queue_POM qpage=new Queue_POM();
	
	@Given("The user is on Signin page of DS Algo portal")
	public void the_user_is_on_signin_page_of_ds_algo_portal() {
		LoggerLoad.info("User Is on Login Page");
		signin.getLoginurl();
	    
	}

	@When("The user enter valid {string} and {string}")
	public void the_user_enter_valid_and(String username, String password) {
		LoggerLoad.info("User Enters username and password");
		signin.enterUsername(username);
		signin.enterPassword(password);
		
	   
	}

	@When("The user click on login button")
	public void the_user_click_on_login_button() {
		signin.clickLogin();
	   
	}

	@Then("The user redirected to homepage")
	public void the_user_redirected_to_homepage() {
		
		home.homepage();
		LoggerLoad.info("User redirected to HomePage");
	    
	}
	@Given("The user is on Home page after logged in")
	public void the_user_is_on_home_page_after_logged_in() {
		String Title = home.getTitleofPage();
		LoggerLoad.info("Title of current page is " + Title);
	    
	}
	@Then("User redirected to {string} page")
	public void user_redirected_to_page(String string) {
		LoggerLoad.info("The User redirected to " + string + "Page");
		String title = qpage.getPageTitle();
		LoggerLoad.info("Title of the Current Page is " + title);
		assertEquals(title, string);
	}


}
