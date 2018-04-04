package ThrivePages;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ThriveSecond {
		WebDriver driver;
		By FirstN=By.xpath("//android.widget.EditText[@text='First Name']");
		By LastN= By.xpath("//android.widget.EditText[@text='Last Name']");
		By Email= By.xpath("//android.widget.EditText[@text='Email address']");
		By Pass= By.xpath("//android.widget.EditText[@text='Password']");
		By MobNo= By.xpath("//android.widget.EditText[@text='Mobile number']");
		By ClickCreate= By.xpath("//android.widget.Button[@index='8' and @text='Create your account']");
		File filename= new File("Excel File Path in your computer.xlsx");

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
		public void ReggisterToThrive(String FName,String LName,String EMail,String PassWord, String PH) throws Exception
		{
			
			
			this.setFirstName(FName);
			this.setLastName(LName);
			this.setEmailAddress(EMail);
			this.setPass(PassWord);
			this.setMobileNo(PH);
			this.ClickOnCreate();
		}
		
}

