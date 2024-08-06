package stepdefinitionsTest;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.SearchHotelPage;

public class SearchHotelSteps 
{
	
	private LoginPage LoginPage= new LoginPage(DriverFactory.getdriver());
	private SearchHotelPage searchHotelPage;
	private static String Title;
	
	@Given("User is already logged into the application")
	public void User_is_already_logged_into_the_application(DataTable CredTable) 
	{
		List<Map<String,String>> CredList = CredTable.asMaps();
		
		String UserNm = CredList.get(0).get("username");
		String Passwrd = CredList.get(0).get("password");
		
		System.out.println("Logs in using  : " + UserNm  + Passwrd);
		
		DriverFactory.getdriver().get("https://adactinhotelapp.com/index.php");
		
		searchHotelPage = LoginPage.doLogin(UserNm, Passwrd);
	    
	}
	
	@Given("user is on the Search Hotel Page")
	public void user_is_on_the_search_hotel_page() 
	{
		Title= searchHotelPage.Gettitle();
		System.out.println("Page Title is : " + Title);
	}

	@When("User get the title of the Search Hotel Page")
	public void user_get_the_title_of_the_Search_Hotel_page() 
	{
		Title= searchHotelPage.Gettitle();
		System.out.println("Page Title is : " + Title);
	   
	}

	@When("User enters Search Information {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_enters_search_information_and(String Loc, String Htl, String Rm_Typ, String NoonRs, String ChkInDt, String ChkOutDt, String ADPR, String CHPR)
	{
		searchHotelPage.EnterDetails(Loc, Htl, Rm_Typ, NoonRs, ChkInDt, ChkOutDt, CHPR, ADPR);
	}

	@When("User clicks on Search button")
	public void user_clicks_on_search_button() 
	{
		searchHotelPage.ClickSearchBtn();
	    
	}

	@Then("User is on the Select Hotel Page")
	public void user_is_on_the_select_hotel_page() 
	{
	    
	}


}
