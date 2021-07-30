package the.collective.test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CollectiveHomePage;
import resources.Base;

public class Newsletter extends Base {
	public static Logger log =LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		 driver =initializeDriver();
	}
	
	@Test
	public void validateNavigationBar() throws IOException, InterruptedException
	{
		
		driver.get(prop.getProperty("url"));
		CollectiveHomePage obj2=new CollectiveHomePage(driver);
		
		//WebDriverWait wait=new WebDriverWait(driver, 40);
		//wait.until(ExpectedConditions.visibilityOf(obj2.closeTerms()));
		Thread.sleep(3000);
		obj2.closeTerms().click();
		
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,5000)");
        
        obj2.getEmailForNewletter().sendKeys("test@gmail.com");
        obj2.submitForNewletter().click();
        
        Assert.assertEquals(obj2.getNewsletterAck().getText(), "thank you for signing up.");
        
	    log.info("Newsletter subscribed successfully");
		 System.out.println("Test completed");
	
		
		}
	
	
	//After test will close the browser driver
	@AfterTest
	public void teardown()
	{
		
		driver.close();
		driver=null;
		
	}
	
}
