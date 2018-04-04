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
	String userName = "charanjitsingh3";
	String accessKey = "pLFxDQJCvFNijTYVqX2q";
	
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
	    caps.setCapability("app", "bs://69cdc2a199429f4638cc27ab611d02653a602f88");
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
		String getExcelName= objSecondPage.ExcelFirstName();
		String getLastName= objSecondPage.ExcelLastName();
		objSecondPage.ReggisterToThrive(getExcelName, getLastName, "abc@mailinator.com", "Abcd1234", "1234567");
	}	

}
