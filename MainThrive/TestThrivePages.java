package MainThrive;

import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ThrivePages.ThriveFirst;
import ThrivePages.ThriveSecond;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class TestThrivePages {
	WebDriver driver;
	ThriveFirst objFirstPage;
	ThriveSecond objSecondPage;
	String userName = " ";//Your UserName of BrowserStack
	String accessKey = " ";//Your access Key of BrowserStack
	
@BeforeSuite
	public void setupMyAppium() throws Exception
	{
	    DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("os", "android");
	    caps.setCapability("os_version", "7.0"); 
	    caps.setCapability("device", "Samsung Galaxy S8");
	    caps.setCapability("realMobile", true);
	    caps.setCapability("browserstack.debug", "true");
	    caps.setCapability("project","Test App");
	    caps.setCapability("build", "Unknown");
            caps.setCapability("name", "Thrive Get Started");
	    caps.setCapability("browserstack.video", "true");
	    caps.setCapability("browserstack.timezone", "Toronto");
	    caps.setCapability("app", "Your Application URL");
	    driver = new AndroidDriver <AndroidElement> (new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);		
	}
	
@AfterSuite
	public void quit()
	{
		driver.quit();
		
	}
	
@Test(priority=0)
	public void Click_on_Get_Started()
	{
		objFirstPage=new ThriveFirst(driver);
		objFirstPage.ClickOnStart();
	}
@Test(priority=1)
	public void Fill_Get_Started_Form() throws Exception
	{
		objSecondPage= new ThriveSecond(driver);
		String getExcelName= objSecondPage.ExcelFirstName();//Get First Name from Excel File
		String getLastName= objSecondPage.ExcelLastName();// Get Last Name from Excel File
		objSecondPage.ReggisterToThrive(getExcelName, getLastName, "abc@mailinator.com", "Abcd1234", "1234567");
	}	

}
