package MobileTestFramework.MobileTestFramework;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PlantListScreen {
	
	
	
	public PlantListScreen(AppiumDriver driver)
	{
		//Initialize the pageobjects and AppiumFieldDecorator will allow the objects to be used on any OS
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='Filter by grow zone']")
	public WebElement filterObj;
	
	@AndroidFindBy(xpath="//android.widget.Button[@content-desc='Share']")
	public WebElement btnShareObj;
	
	@AndroidFindBy(xpath="//android.widget.Button[@content-desc='Add plant']")
	public WebElement btnAddPlantObj;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc='Navigate up']")
	public WebElement btnBackObj;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc='Picture of plan']")
	public WebElement txtPlantAddedObj;
	
	
	
	
}
