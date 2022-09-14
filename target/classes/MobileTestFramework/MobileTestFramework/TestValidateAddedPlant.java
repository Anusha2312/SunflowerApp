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


public class TestValidateAddedPlant extends BaseClass{
	
	@BeforeTest
	//To stop appium server for successfull execution
	public void killAllNodes() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);	
	}
	
	@Test( enabled=true )
	public void testValidateAddedPlant() throws IOException, InterruptedException {
		
		service = startAppiumServer();
		
		//Fetch the appName from GlobalProperties file
		AndroidDriver<AndroidElement> driver = Capabilities("MobileApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		
		
		HomeScreen hs = new HomeScreen(driver);
		PlantListScreen ps = new PlantListScreen(driver);
		//Read the Plantname from excel
	    XSSFCell plantNameval =  ReadExcel();
		
		
		//Validate the Screen elements
		Assert.assertEquals(true, hs.headerObj.isDisplayed(),"Header object not found");
		Assert.assertEquals(true, hs.myGardenObj.isDisplayed(),"My Garden object not found");
		Assert.assertEquals(true, hs.myPlantlistObj.isDisplayed(),"My PlantList object not found");
		
		WebElement elePlantname = driver.findElement(By.xpath("//android.widget.TextView[@text='"+plantNameval.toString().trim()+"']"));
		
		
		//Click on any Plant object and validate the page related to the selected plant along with Add, Share and Back button is displayed (ex: Apple)
		Assert.assertEquals(true, elePlantname.isDisplayed(),"The plantName text object not found");
		elePlantname.click();
		
		//Validate the Screen elements on the selected plant screen
		Assert.assertEquals(true, ps.btnBackObj.isDisplayed(),"Back button object not found");
		Assert.assertEquals(true, ps.btnShareObj.isDisplayed(),"Share button object not found");
		Assert.assertEquals(true, elePlantname.isDisplayed(),"The PlantName text object not found");
		
		//Scrollup the screen
		scroll(driver, 0.5, 0.8, 0.5, 0.3);
		
	
		
		//Click back button and check My Garden screen is loaded 
		ps.btnBackObj.click();
		Assert.assertEquals(true, elePlantname.isDisplayed(),"The PlantName text object not found");
		
		//Stop Appium Server
		service.stop();
		
	}
}
