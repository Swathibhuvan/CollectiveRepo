package stepDefinations;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.CollectiveHomePage;
import resources.Base;

public class StepDefination extends Base {


	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		 driver =initializeDriver();
	}

	@Given("^Navigate to \"https://staging.thecollective.com/\" Site$")
	public void Enter_URL() {
		driver.get(prop.getProperty("url"));
	}

	@Given("^Enter Email id in Newsletter section")
	public void enter_Email_Id() throws Throwable,InterruptedException{
		
		Thread.sleep(2000);
		CollectiveHomePage obj3=new CollectiveHomePage(driver);
		obj3.closeTerms().click();
		
		
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,8500)");
        
        obj3.getEmailForNewletter().sendKeys("test@gmail.com");
        Thread.sleep(1000);
	}

	

	@When("^Click on submit button$")
	public void click_On_Submit() throws Throwable {
		CollectiveHomePage obj3=new CollectiveHomePage(driver);
		  obj3.submitForNewletter().click();

	}
	 
	@Then("^Verify that \"Thank you for signing up.\" displayed$")
	    public void verify_Ack() {
		CollectiveHomePage obj3=new CollectiveHomePage(driver);
		 Assert.assertEquals(obj3.getNewsletterAck().getText(), "thank you for signing up.");
	        
	    }
	 @And("^close browsers$")
	    public void close_browsers() throws Throwable {
	        driver.quit();
	    }
	

}
