package MobileTestFramework.MobileTestFramework;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeScreen {
	

	public HomeScreen(AppiumDriver driver)
	{
		//Initialize the pageobjects and AppiumFieldDecorator will allow the objects to be used on any OS
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Sunflower']")
	public WebElement headerObj;
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='MY GARDEN']")
	public WebElement myGardenObj;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='PLANT LIST']")
	public WebElement myPlantlistObj;
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Your garden is empty']")
	public WebElement txtEmptyObj;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='ADD PLANT']")
	public WebElement btnAddPlantObj;
	
	
	
}
