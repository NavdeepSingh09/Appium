package ThrivePages;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AppiumCapSet {
	
	public void setCaps() throws Exception
	{
	    String userName = " ";
	    String accessKey = " ";
	    DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("os", "android");
	    caps.setCapability("os_version", "7.0"); 
	    caps.setCapability("device", "Samsung Galaxy S8");
	    caps.setCapability("realMobile", true);
	    caps.setCapability("browserstack.debug", "true");
	    caps.setCapability("project","Test App");
	    caps.setCapability("build", "Unknown");
	  //caps.setCapability("name", "Login page Android");
	    caps.setCapability("browserstack.video", "true");
	    caps.setCapability("browserstack.timezone", "Toronto");
	   
	    caps.setCapability("app", "Application URL");
	    AndroidDriver<AndroidElement> driver = new AndroidDriver <AndroidElement> (new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);
	    
	}
	
	

}
