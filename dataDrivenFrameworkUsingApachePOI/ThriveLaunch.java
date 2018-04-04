package dataDrivenFrameworkUsingApachePOI;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ThriveLaunch {
	@Test
	public void SetCap() throws InterruptedException, Exception
	{
	String userName = "charanjitsingh3";
	String accessKey = "pLFxDQJCvFNijTYVqX2q";
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
   
	caps.setCapability("app", "bs://69cdc2a199429f4638cc27ab611d02653a602f88");
   AndroidDriver <AndroidElement> driver = new AndroidDriver <AndroidElement> (new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);
   driver.findElement(By.id("com.compass_canada.thrive:id/login_getStarted")).click();
   
   File FileLocation= new File("C:\\Users\\cheem\\eclipse-workspace\\Thrive\\InputData.xlsx");
   FileInputStream LoadNewFile= new FileInputStream(FileLocation);
   XSSFWorkbook wb= new XSSFWorkbook(LoadNewFile);
   XSSFSheet ws= wb.getSheetAt(0);
   String FirstN= ws.getRow(0).getCell(0).getStringCellValue();
   System.out.println("First Name="+FirstN);
 //driver.findElement(By.xpath("//android.widget.EditText[@text='First Name']")).sendKeys(FirstN);
   String LastN= ws.getRow(0).getCell(1).getStringCellValue();
   driver.findElement(By.xpath("//android.widget.EditText[@text='Last Name']")).sendKeys(LastN);
   String Email= ws.getRow(0).getCell(2).getStringCellValue();
   driver.findElement(By.xpath("//android.widget.EditText[@text='Email address']")).sendKeys(Email);
   String Pass= ws.getRow(0).getCell(3).getStringCellValue();
   driver.findElement(By.xpath("//android.widget.EditText[@text='Password']")).sendKeys(Pass);
   double PH= ws.getRow(0).getCell(4).getNumericCellValue();
   driver.findElement(By.xpath("//android.widget.EditText[@text='Mobile number']")).sendKeys(String.valueOf(PH));
   driver.findElement(By.xpath("//android.widget.Button[@index='8' and @text='Create your account']")).click();
   wb.close();
 	}
}
