package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	private WebDriver driver;
	
	//By Locators
	private By username = By.id("username");
	private By password = By.id("password");
	private By LoginBtn = By.id("login");
	private By FrgtPwd = By.linkText("Forgot Password?");
	
	//Constructors
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;		
	}

	//Actions
	public String getpagetitle()
	{
		return driver.getTitle();
	}
	
	public void enterusername(String usernm)
	{
		driver.findElement(username).sendKeys(usernm);
	}
	
	public void enterpassword(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		driver.findElement(LoginBtn).click();
	}
	 public boolean FrgtrPwddisplayed()
	 {
		 return driver.findElement(FrgtPwd).isDisplayed();
	 }
}
