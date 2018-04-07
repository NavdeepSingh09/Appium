package ThrivePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ThriveFirst {
	WebDriver driver;
	By ClickOnGetStarted= By.id("com.compass_canada.thrive:id/login_getStarted");
public ThriveFirst(WebDriver driver)
{
	this.driver=driver;
}
public void ClickOnStart()
{
	
	driver.findElement(ClickOnGetStarted).click();
	
}
public String AssertGetStarted()
{
	return driver.findElement(ClickOnGetStarted).getText();	

}
public void clickOnThriveGetStarted()
{
	this.AssertGetStarted();
	this.ClickOnStart();
}
}

