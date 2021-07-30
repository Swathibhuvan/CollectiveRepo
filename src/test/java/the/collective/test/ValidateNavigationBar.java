package the.collective.test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CollectiveHomePage;
import resources.Base;

public class ValidateNavigationBar extends Base{
	
	 public static Logger log =LogManager.getLogger(Base.class.getName());
@BeforeTest

public void initialize() throws IOException
{
	
	 driver =initializeDriver();
	
}
	
	@Test
	
	public void validateNavigationBar() throws IOException
	{
		driver.get(prop.getProperty("url"));
		CollectiveHomePage obj1=new CollectiveHomePage(driver);
	
		//check whether the navigation bar is displayed
	    Assert.assertTrue(obj1.getNavigationBar().isDisplayed());
	    log.info("Navigation Bar is displayed");
		 System.out.println("Test completed");
	
		
		}
	
	@AfterTest
	public void teardown()
	{
		
		driver.close();
		driver=null;
		
	}

	
}
