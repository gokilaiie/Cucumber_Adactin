package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory 
{
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
	
	public WebDriver init_driver(String browser)
	{
		if(browser.equals("chrome"))
		{
			System.out.println("browser value is: " + browser);

			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\gokil\\Documents\\lib\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			tldriver.set(new ChromeDriver());
		}
		else
		{
			System.out.println("Enter correct browser : " + browser);
		}
		getdriver().manage().deleteAllCookies();
		getdriver().manage().window().maximize();
		return getdriver();
		
	}
	
	public static synchronized WebDriver getdriver()
	{
		return tldriver.get();
	}
}
