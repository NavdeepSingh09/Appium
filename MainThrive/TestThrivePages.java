package MainThrive;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
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
	String AppURL= "Application URL";
	
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
	    caps.setCapability("app", AppURL);
	    driver = new AndroidDriver <AndroidElement> (new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);		
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
		Assert.assertEquals(objFirstPage.AssertGetStarted(), "Get started");
		objFirstPage.ClickOnStart();
	}
@Test(priority=1)
	public void Fill_Get_Started_Form() throws Exception
	{
		objSecondPage= new ThriveSecond(driver);
		objSecondPage.AssertClose();
		Assert.assertEquals(objSecondPage.AssertClose(), true);
		objSecondPage.AssertWelcomeThrive();
		Assert.assertEquals(objSecondPage.AssertWelcomeThrive(), "Welcome to Thrive!");
		objSecondPage.TitleCheck();
		Assert.assertEquals(objSecondPage.TitleCheck(), "Please enter your profile info:");
		objSecondPage.TitleCheck1();
		Assert.assertEquals(objSecondPage.TitleCheck1(), "(all text fields are mandatory)");
		objSecondPage.SubscribeTextCheck();
		Assert.assertEquals(objSecondPage.SubscribeTextCheck(), "Subscribe to promotions");
		objSecondPage.CheckBoxDisplay();
		Assert.assertEquals(objSecondPage.CheckBoxDisplay(), true);
		objSecondPage.AlreadySignInText();
		Assert.assertEquals(objSecondPage.AlreadySignInText(), "Already have an account? Sign in");
		objSecondPage.ClickOnCreate();
		objSecondPage.FirstNameAlert();
		Assert.assertEquals(objSecondPage.FirstNameAlert(), "Mandatory Field");
		objSecondPage.LastNameAlert();
		Assert.assertEquals(objSecondPage.LastNameAlert(), "Mandatory Field");
		objSecondPage.EmailAlert();
		Assert.assertEquals(objSecondPage.EmailAlert(), "Mandatory field");
		objSecondPage.PasswordAlert();
		Assert.assertEquals(objSecondPage.PasswordAlert(), "Mandatory field");
		objSecondPage.PhAlert();
		Assert.assertEquals(objSecondPage.PhAlert(), "Mandatory field");		
		String getExcelName= objSecondPage.ExcelFirstName();//Get First Name from Excel File
		String getLastName= objSecondPage.ExcelLastName();// Get Last Name from Excel File
		objSecondPage.ReggisterToThrive(getExcelName, getLastName, "abc@mailinator", "Abcd1", "1234567");
		objSecondPage.ClickOnCreate();
		objSecondPage.AlertCheckEmail();
		Assert.assertEquals(objSecondPage.AlertCheckEmail(), "Incorrect email format");
		objSecondPage.AlertCheckPassword();
		Assert.assertEquals(objSecondPage.AlertCheckPassword(), "Minimum 8 characters, 1 capital letter and 1 number");
		objSecondPage.AlertCheckPhone();
		Assert.assertEquals(objSecondPage.AlertCheckPhone(), "10 digit phone number required");
	}	

}
