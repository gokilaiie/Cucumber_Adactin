package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchHotelPage
{
	private WebDriver driver;
	
	//By Locators
	private By Location = By.id("location");
	private By Hotels = By.id("hotels");
	private By Room_Type = By.id("room_type");
	private By No_Of_Rooms = By.id("room_nos");
	private By Chk_In_Date = By.id("datepick_in");
	private By Chk_out_Date = By.id("datepick_out");
	private By Adult_PR = By.id("adult_room");
	private By Child_PR = By.id("child_room");
	private By Searchbtn = By.id("Submit");
	
	//Constructor
	public SearchHotelPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//Actions
	public String Gettitle()
	{
		return driver.getTitle();
	}
	
	public void EnterDetails(String Locatn, String Hotls, String rm_typ, String NoofRooms,String ChkInDt, String ChkOutDt, String AdultPR,String ChildPR)
	{
		driver.findElement(Location).sendKeys(Locatn);
		driver.findElement(Hotels).sendKeys(Hotls);
		driver.findElement(Room_Type).sendKeys(rm_typ);
		driver.findElement(No_Of_Rooms).sendKeys(NoofRooms);
		driver.findElement(Chk_In_Date).sendKeys(ChkInDt);
		driver.findElement(Chk_out_Date).sendKeys(ChkOutDt);
		driver.findElement(Adult_PR).sendKeys(AdultPR);
		driver.findElement(Child_PR).sendKeys(ChildPR);
		
	}
	
	public void ClickSearchBtn()
	{
		driver.findElement(Searchbtn).click();
	}
}
