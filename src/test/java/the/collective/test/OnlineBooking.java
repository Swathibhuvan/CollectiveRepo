package the.collective.test;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CollectiveHomePage;
import resources.Base;

public class OnlineBooking extends Base{
		
	public static Logger log =LogManager.getLogger(Base.class.getName());
		// BeforeTest will initialize the browser driver. Browser driver is read from data.properties
		@BeforeTest
		public void initialize() throws IOException
		{
			 driver =initializeDriver();
		}
		
		//Objective of this function is to navigate to select room page for few nights booking
		@Test
		public void stayForFewNights()throws IOException, InterruptedException {
			
			driver.get(prop.getProperty("url"));
			CollectiveHomePage obj=new CollectiveHomePage(driver);
			Thread.sleep(3000);
			//WebDriverWait wait=new WebDriverWait(driver, 50);
			//wait.until(ExpectedConditions.visibilityOf(obj.closeTerms()));
			obj.closeTerms().click();
			obj.bookNow().click();

			
			obj.selectDropdown().click();
			 List<WebElement> allOptions = obj.selectLocationOption();
		        System.out.println(allOptions.size());
		        for(int i = 0; i<=allOptions.size()-1; i++) {
		             
		             
		            if(allOptions.get(i).getText().contains("Paper Factory")) {
		                 
		                allOptions.get(i).click();
		                break;
		                 
		            }
		        }

		        
		        JavascriptExecutor js = (JavascriptExecutor)driver;
		        js.executeScript("window.scrollBy(0,500)");
		        
		        
		        obj.selectRoomButton().click();
			    log.info("Successfully submitted the page");
				 System.out.println("Test completed");
			
		}
		
		//After test will close the browser driver
		
		@AfterTest
		public void teardown()
		{
			
			driver.quit();
			driver=null;
			
		}

}

