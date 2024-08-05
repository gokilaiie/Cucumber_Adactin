package appHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class MyHooks 
{
	private DriverFactory driverfactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	@Before(order = 0)
	private void getproperty()
	{
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		
		
	}
	@Before(order=1)
	public void launchbrowser()
	{
		String browserNm = prop.getProperty("browser");
		System.out.println(browserNm);		
		driverfactory = new DriverFactory();
		driver = driverfactory.init_driver(browserNm);
	}
	@After(order=0)
	public void quitbrowser()
	{
		driver.quit();
	}
	@After(order=1)
	public void teardown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			String ScreenshotNm = scenario.getName().replaceAll(" ", "_");
			byte[] sourcepath =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath, "image/png", ScreenshotNm);
					
		}
		
	}
}
