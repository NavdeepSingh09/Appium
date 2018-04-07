package ThrivePages;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ThriveSecond {
		WebDriver driver;
		By FirstN=By.xpath("//android.widget.EditText[@text='First Name']");
		By LastN= By.xpath("//android.widget.EditText[@text='Last Name']");
		By Email= By.xpath("//android.widget.EditText[@text='Email address']");
		By Pass= By.xpath("//android.widget.EditText[@text='Password']");
		By MobNo= By.xpath("//android.widget.EditText[@text='Mobile number']");
		By ClickCreate= By.xpath("//android.widget.Button[@index='8' and @text='Create your account']");
		By AlertCheck1=By.xpath("//android.widget.TextView[@text='Mandatory Field']");
		By AlertCheck2=By.xpath("//android.widget.TextView[@text='Mandatory field']");
		By AssertWelCome=By.xpath("//android.widget.TextView[@resource-id='com.compass_canada.thrive:id/toolbar_title']");
		By CloseButton=By.xpath("//android.widget.ImageView[contains(@resource-id,'toolbar_back_button')]");
		By TitleCheck=By.xpath("//android.widget.TextView[@text='Please enter your profile info:']");
		By TitleCheck1=By.xpath("//android.widget.TextView[@text='(all text fields are mandatory)']");
		By SubscribeText=By.xpath("//android.widget.TextView[@index='1' and @text='Subscribe to promotions']");
		By CheckBox=By.className("android.widget.CheckBox");
		By AlreadyAccountSignIn= By.xpath("//android.widget.Button[@index='9']");
		By AlertCheckEmailError=By.xpath("//android.widget.TextView[@text='Incorrect email format']");
		By AlertCheckPass=By.xpath("//android.widget.TextView[@text='Minimum 8 characters, 1 capital letter and 1 number']");
		By AlertCheckPhone=By.xpath("//android.widget.TextView[@text='10 digit phone number required']");
		File filename= new File("Excel file path.xlsx");
public String ExcelFirstName() throws Exception
{
	//Load the file
	FileInputStream LoadFile= new FileInputStream(filename);
	// Load workbook
	XSSFWorkbook wb=new XSSFWorkbook(LoadFile);
	// Load sheet- Here we are loading first sheet only
	XSSFSheet sh1= wb.getSheetAt(0);//Use wb.getSheetAt(1) for second sheet
	String FirstName= sh1.getRow(0).getCell(0).getStringCellValue();
	wb.close();
	return FirstName;
	
}
public String ExcelLastName() throws Exception
{
	FileInputStream LoadFile= new FileInputStream(filename);
	XSSFWorkbook wb=new XSSFWorkbook(LoadFile);
	XSSFSheet sh1= wb.getSheetAt(0);
	String LastName= sh1.getRow(0).getCell(1).getStringCellValue();
	wb.close();
	return LastName;
	
}

		
		public ThriveSecond(WebDriver driver)
		{
			this.driver=driver;
		}
		public void setFirstName(String FName)
		{
			driver.findElement(FirstN).sendKeys(FName);
		}
		public void setLastName(String LName)
		{
			driver.findElement(LastN).sendKeys(LName);
		}
		public void setEmailAddress(String EMail)
		{
			driver.findElement(Email).sendKeys(EMail);
		}
		public void setPass(String PassWord)
		{
			driver.findElement(Pass).sendKeys(PassWord);
		}
		public void setMobileNo(String PH )
		{
			driver.findElement(MobNo).sendKeys(PH);
		}
		public void ClickOnCreate()
		{
			driver.findElement(ClickCreate).click();
		}
		public String FirstNameAlert() {
			List<WebElement> AlertMadField= driver.findElements(AlertCheck1);
			return AlertMadField.get(0).getText();
		}
		public String LastNameAlert() {
			List<WebElement> AlertMadField= driver.findElements(AlertCheck1);
			return AlertMadField.get(1).getText();
		}
		public String EmailAlert()
		{
			List<WebElement> AlertMadField= driver.findElements(AlertCheck2);
			return AlertMadField.get(0).getText();
		}
		public String PasswordAlert()
		{
			List<WebElement> AlertMadField= driver.findElements(AlertCheck2);
			return AlertMadField.get(1).getText();
		}
		public String PhAlert()
		{
			List<WebElement> AlertMadField= driver.findElements(AlertCheck2);
			return AlertMadField.get(2).getText();
		}
		public String AssertWelcomeThrive() 
		{
			return driver.findElement(AssertWelCome).getText();
		}
		public boolean AssertClose()
		{
			return driver.findElement(CloseButton).isDisplayed();
		}
		public String TitleCheck()
		{
			return driver.findElement(TitleCheck).getText();
		}
		public String TitleCheck1()
		{
			return driver.findElement(TitleCheck1).getText();
		}
		public String SubscribeTextCheck()
		{
			return driver.findElement(SubscribeText).getText();
		}
		public boolean CheckBoxDisplay()
		{
			return driver.findElement(CheckBox).isDisplayed();
		}
		public String AlreadySignInText()
		{
			return driver.findElement(AlreadyAccountSignIn).getText();
		}
		public String AlertCheckEmail()
		{
			return driver.findElement(AlertCheckEmailError).getText();
		}
		public String AlertCheckPassword()
		{
			return driver.findElement(AlertCheckPass).getText();
		}
		public String AlertCheckPhone()
		{
			return driver.findElement(AlertCheckPhone).getText();
		}
		public void ReggisterToThrive(String FName,String LName,String EMail,String PassWord, String PH) throws Exception
		{
			
			this.setFirstName(FName);
			this.setLastName(LName);
			this.setEmailAddress(EMail);
			this.setPass(PassWord);
			this.setMobileNo(PH);
		}
		
}

