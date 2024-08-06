package stepdefinitionsTest;

import org.junit.Assert;


import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginPageStepsTest 
{
	private static String Title;
	private LoginPage LoginPage = new LoginPage(DriverFactory.getdriver());
	
	
	@Given("User is on the login Page")
	public void user_is_on_the_login_page() 
	{
		DriverFactory.getdriver().get("https://adactinhotelapp.com/index.php");
		
	}
	@When("User get the title of the Page")
	public void user_get_the_title_of_the_page() {
	   Title = LoginPage.getpagetitle();
	   System.out.println("Title of the opage  is : " + Title);
	}

	@Then("Title of the Page should be {string}")
	public void title_of_the_page_should_be(String expectedTitle) 
	{
		
		 Assert.assertTrue(Title.contains(expectedTitle));
	}
	
	@When("User enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_ad_training102_and_password102(String username, String password) 
	{
	    LoginPage.enterusername(username);
	    LoginPage.enterpassword(password);
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() 
	{
	    LoginPage.clickLogin();
	}

	




}
