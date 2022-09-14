package MobileTestFramework.MobileTestFramework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class TestValidateHomeScreen extends BaseClass{
	
	@BeforeTest
	//To stop appium server for successfull execution
	public void killAllNodes() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);	
	}
	
	@Test( enabled=true )
	public void homeScreenValidation() throws IOException {
		
		service = startAppiumServer();
		
		//Fetch the appName from GlobalProperties file
		AndroidDriver<AndroidElement> driver = Capabilities("MobileApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		
		
		HomeScreen hs = new HomeScreen(driver);
		PlantListScreen ps = new PlantListScreen(driver);
		
		//Read the Plantname from excel
	    XSSFCell plantNameval =  ReadExcel();
		
		//System.out.println(ReadExcel());
		
		Assert.assertEquals(true, hs.headerObj.isDisplayed(),"Header object not found");
		Assert.assertEquals(true, hs.myGardenObj.isDisplayed(),"My Garden object not found");
		Assert.assertEquals(true, hs.myPlantlistObj.isDisplayed(),"My PlantList object not found");
		Assert.assertEquals(true, hs.txtEmptyObj.isDisplayed(),"The cart is empty object not found");
		Assert.assertEquals(true, hs.btnAddPlantObj.isDisplayed(),"AddPlant object not found");
		
		
		//Validate the links are clickable and navigates to the respective page when clicked
		hs.myGardenObj.click();
		Assert.assertEquals(true, hs.txtEmptyObj.isDisplayed(),"The cart is empty object not found");
		
		hs.myPlantlistObj.click();
		WebElement elePlantname = driver.findElement(By.xpath("//android.widget.TextView[@text='"+plantNameval.toString().trim()+"']"));
		
		Assert.assertEquals(true, elePlantname.isDisplayed(),"The PlantName text object not found");
		
		hs.myGardenObj.click();
		Assert.assertEquals(true, hs.txtEmptyObj.isDisplayed(),"The cart is empty object not found");
		
		//Validate that click on Add Plant button navigates to Plant list screen.
		hs.btnAddPlantObj.click();
		Assert.assertEquals(true, ps.filterObj.isDisplayed(),"The Fliter  object not found");
		
		
		//Stop Appium Server
		service.stop();
		
	}
}
